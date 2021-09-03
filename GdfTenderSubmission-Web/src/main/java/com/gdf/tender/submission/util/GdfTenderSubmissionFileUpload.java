package com.gdf.tender.submission.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;

public class GdfTenderSubmissionFileUpload {
	private static Log _log = LogFactoryUtil.getLog(GdfTenderSubmissionFileUpload.class);
	Folder folder;

	public GDFTenderSubmissionDetails fileUpload(String regCerti, ResourceRequest actionRequest, ResourceResponse actionResponse, ThemeDisplay themeDisplay) throws PortalException {

		GDFTenderSubmissionDetails gdfTenderSubDetails=null;
		try {
			
		String childFolder="";
		String attrName="";
		
		//Uploading file on upload button respectively
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);


		if(regCerti!=null){			
			childFolder="Gdf Tender Submission";
			attrName=regCerti;
			gdfTenderSubDetails= upload(uploadPortletRequest,serviceContext,themeDisplay,actionRequest,childFolder,attrName,actionResponse);
		//	actionResponse.sendRedirect("/web/guest/fppregistration/edit?fppRegId="+regId);	

		}
		
		}catch (Exception e) {
			 
			_log.error("Error while uploading file to EDM");
			
			e.printStackTrace();
		}
		return gdfTenderSubDetails;
		
		
	}

	public 	GDFTenderSubmissionDetails upload(UploadPortletRequest uploadPortletRequest, ServiceContext serviceContext, ThemeDisplay themeDisplay, ResourceRequest actionRequest, String childFolder, String attrName, ResourceResponse actionResponse) throws PortalException{

		String fileUrl="";		
		File fileArr[]=null;
		String fileNameArr[]=null;
		GDFTenderSubmissionDetails gdfTenderSubDetails=null;

		fileArr=uploadPortletRequest.getFiles("regCerti");
		fileNameArr=uploadPortletRequest.getFileNames("regCerti");
		String tenderReferenceNumber =  uploadPortletRequest.getParameter("tenderReferenceNumber");
		
		if(fileNameArr.length!=0){
			//Creating folder and uploading file and fecting it's url
			List<String> fileUrlList=createFolder(themeDisplay,actionRequest,childFolder,fileNameArr,fileArr,serviceContext,uploadPortletRequest,tenderReferenceNumber);

	//		_log.info("fileUrlList::"+fileUrlList);

			//converting list of url into a single string and setting it into DB
			for(int i=0;i<fileUrlList.size();i++){			
				fileUrl=fileUrl+fileUrlList.get(i);				
				if(i<fileUrlList.size()-1)
				{
					fileUrl=fileUrl+","	;
				}
			}

		//	_log.info("fileUrl::"+fileUrl);	
			
			//set url in DB			
		
				
				gdfTenderSubDetails =GDFTenderSubmissionDetailsLocalServiceUtil.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tenderReferenceNumber, themeDisplay.getUserId());								
				gdfTenderSubDetails.setCopyOfRegCert(fileUrl);			
				gdfTenderSubDetails.setSupplierId(themeDisplay.getUser().getUserId());			
				GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);
		//	jsonArray.put(regModel);
					
		}
		return gdfTenderSubDetails;
	}

	public List<String> createFolder(ThemeDisplay themeDisplay, ResourceRequest actionRequest, String childFolder, String[] fileNameArr, File[] fileArr, ServiceContext serviceContext1, UploadPortletRequest uploadPortletRequest,String tenderReferenceNumber) throws PortalException{

		_log.info("createFolder folder for user "+themeDisplay.getUser().getUserId());

		List<String> fileUrlList=new ArrayList<String>();

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(themeDisplay.getLayout().getGroupId());

		long repositoryId = themeDisplay.getScopeGroupId();
		String description = "This file is added via programatically "+themeDisplay.getUser().getUserId();
		
		//String gdfGenericCode =  uploadPortletRequest.getParameter("gdfGenericCode");
		
		long folderId;
		
		GDFTenderSubmissionDetails	gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tenderReferenceNumber, themeDisplay.getUserId());
			
		//creating folder named Technical Bids Submission
				Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
				String folderName = "Technical Bids Submission";
				creatingFolder(themeDisplay, serviceContext, folderName, description, parentFolderId,repositoryId);

				//creating folder named by user name
				parentFolderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();
				folderName=themeDisplay.getUser().getFullName();   //supplier name
				creatingFolder(themeDisplay,serviceContext,folderName,description,parentFolderId,repositoryId);

				//creating folder by Tender Reference Number
				parentFolderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();
				folderName = String.valueOf(gdfTenderSubDetails.getTenderSubRefID());   // Tender Reference Number
				_log.info("tenderRefFolder"+folderName);
				creatingFolder(themeDisplay,serviceContext,folderName,description,parentFolderId,repositoryId);

				//creating folder named as product ID
				parentFolderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();

		//creating folder by supplier Id  
				int year = Calendar.getInstance().get(Calendar.YEAR);
				
		folderName= String.valueOf(year);
		_log.info("year::::"+year+", folderName"+folderName);
		creatingFolder(themeDisplay,serviceContext,folderName,description,parentFolderId,repositoryId);

		folderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();

		//uploading file in particular folder			
		fileUpload(themeDisplay, actionRequest,parentFolderId,folderName,folderId,"regCerti",repositoryId,fileNameArr,fileArr,serviceContext);// for submit

		//getting file URL
		fileUrlList=fileEntryUrl(themeDisplay,folderName,repositoryId,folderId,parentFolderId);
		return fileUrlList;
	}

	private void creatingFolder(ThemeDisplay themeDisplay, ServiceContext serviceContext,
			String folderName, String description, Long parentFolderId, long repositoryId) {

		boolean folderStatus=false;  //true:Exist

		try {
			List<Folder> folderList = DLAppServiceUtil.getFolders(repositoryId,parentFolderId);
			for (Folder folder : folderList) {
				if(folder.getName().equals(folderName)){
					folderStatus=true;
					_log.info(folderName +" is already created");
				}
			}

			if(!folderStatus){
				folder=DLAppServiceUtil.addFolder(repositoryId,parentFolderId, folderName,description, serviceContext);
				_log.info(folderName +" created successfully by user "+themeDisplay.getUser().getUserId());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fileUpload(ThemeDisplay themeDisplay, ResourceRequest actionRequest, Long parentFolderId, String folderName, long folderId,String paramName,long repositoryId, String[] fileNameArr, File[] fileArr, ServiceContext serviceContext) throws PortalException {

		File file = null;
		String fileName = null;
		
		for(int i=0;i<fileArr.length;i++){
			if( fileArr[i]!=null){
			file = fileArr[i];
			fileName=fileNameArr[i];	
			uploading(themeDisplay,actionRequest,file,fileName,parentFolderId,folderName,folderId,serviceContext,repositoryId);
			}
		}

	}

	public static void uploading(ThemeDisplay themeDisplay,ResourceRequest actionRequest, File file, String fileName,
			Long parentFolderId, String folderName, long folderId, ServiceContext serviceContext,long repositoryId) {

		try{
			if (!file.exists()) {
				_log.info("Empty File");
			}

			if ((file != null) && file.exists())
			{

				//uploading file in liferay document and media
				String mimeType = MimeTypesUtil.getContentType(file);
				String title =fileName;
				String description = "This file is added via programatically by user :" +themeDisplay.getUser().getUserId();
				String changeLog = "";
				FileEntry fileUploaded = null;
				InputStream is = null;
				try {
					is = new FileInputStream( file );
				} catch (FileNotFoundException e1) {
					 
					e1.printStackTrace();
				}

				try
				{ 
					List<FileEntry> fileEntries = null;	
					fileEntries = DLAppServiceUtil.getFileEntries(repositoryId,folderId);	
					boolean fileExist=false;
					for (FileEntry fileEntry : fileEntries){
						if(fileEntry.getFileName().equalsIgnoreCase(fileName))
						{
							_log.info("updating file "+fileName +" by user "+themeDisplay.getUser().getUserId());
							fileExist=true;
							long fileEntryId=fileEntry.getFileEntryId();
							fileUploaded=DLAppServiceUtil.updateFileEntry(fileEntryId, fileName, mimeType, title, description, changeLog, true, is, file.length(), serviceContext);
						}
					}
					if(!fileExist){
						_log.info("adding new file "+fileName +" by user "+themeDisplay.getUser().getUserId());
						fileUploaded=DLAppServiceUtil.addFileEntry(repositoryId,folderId,title, mimeType, 
								title, description, changeLog, is, file.length(), serviceContext);
					}

					_log.info("File entry id:::"+ fileUploaded.getFileEntryId()); 

				} catch (Exception e)
				{
					_log.info("Exception");
					e.printStackTrace();
				}

			}
		} catch (Exception e)
		{
			_log.info("Exception");
			e.printStackTrace();
		}
		_log.info("End of file upload method");

	}

	public List<String> fileEntryUrl(ThemeDisplay themeDisplay, String folderName, long repositoryId, long folderId, long parentFolderId) {
		_log.info("inside fileEntryUrl for folderName::"+folderName);
		List<String> fileUrlList=new ArrayList<String>();
		try {
			folder =DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
						file.getFolderId() +  "/" +file.getTitle() ;
				_log.info("Link for file entry file=>"+url);
				fileUrlList.add(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrlList;
	}



}

