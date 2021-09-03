package com.gdf.tender.submission.portlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.exception.NoSuchGDFTenderSubmissionDetailsException;
import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;
import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalServiceUtil;
import com.gdf.tender.submission.bean.FPPMarketDetailsModel;
import com.gdf.tender.submission.bean.FPPRegDetailsModel;
import com.gdf.tender.submission.bean.ScheduleDetailsModel;
import com.gdf.tender.submission.bean.TenderSubmissionViewDetailsModel;
import com.gdf.tender.submission.constants.GdfTenderSubmissionConstants;
import com.gdf.tender.submission.constants.GdfTenderSubmissionWebPortletKeys;
import com.gdf.tender.submission.util.GdfTenderSubmissionDetailUtil;
import com.gdf.tender.submission.util.GdfTenderSubmissionFileUpload;
import com.gdf.tender.submission.util.Utility;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author KS61374
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=gdf",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GdfTenderSubmissionWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/configure.jsp",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"javax.portlet.name=" + GdfTenderSubmissionWebPortletKeys.GDFTENDERSUBMISSIONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GdfTenderSubmissionWebPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(GdfTenderSubmissionWebPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = (User) renderRequest.getAttribute(WebKeys.USER);
		
		_log.info("GDF tender submission render method");
		List<GDFTenderDetails> activeGdfTenders = new ArrayList<GDFTenderDetails>();
		
		List<GDFTenderDetails> gdfTenderList = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		
		/*List<GDFTenderDetails> gdfTenderList = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		List<GDFTenderSubmissionDetails> gdfTenderSubmissionList = GDFTenderSubmissionDetailsLocalServiceUtil
				.getGDFTenderSubmissionDetailses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);*/
		
		List<GDFTenderSubmissionDetails> gdfTenderSubmissionList = GDFTenderSubmissionDetailsLocalServiceUtil
				.getGDFTenderSubDetailsByUserId(user.getUserId());
		List<TenderSubmissionViewDetailsModel> tenderSubViewList = new ArrayList<>();

		gdfTenderList.forEach(gt -> {
			if (Objects.equals(gt.getTenderStatus(), GdfTenderSubmissionConstants.ACTIVE)) {
				activeGdfTenders.add(gt);
			}

			gdfTenderSubmissionList.forEach(std -> {

				if (Objects.equals(gt.getTenderReferenceNumber(), std.getTenderReferenceNumber())) {
					TenderSubmissionViewDetailsModel tenderSubViewDetails = new TenderSubmissionViewDetailsModel();
					tenderSubViewDetails.setCreatedDate(std.getCreateDate());
					tenderSubViewDetails.setModifiedDate(std.getModifiedDate());
					tenderSubViewDetails.setTenderReferenceNumber(gt.getTenderReferenceNumber());
					tenderSubViewDetails.setTitle(gt.getTitle());
					tenderSubViewDetails.setMethod(gt.getMethod());
					tenderSubViewDetails.setDeadLineSubmissionDate(gt.getDeadlineForTechBidsSub());
					tenderSubViewDetails.setDateOfPublication(gt.getPublicationDate());
					tenderSubViewDetails.setTenderSubmissionStatus(std.getTenderSubmissionStatus());
					tenderSubViewDetails.setSubmissionStatusDate(std.getSubmittedDate());
					tenderSubViewDetails.setTenderStatus(gt.getTenderStatus());
					tenderSubViewList.add(tenderSubViewDetails);
				}
			});

		});

		
		List<String> userRoles = new ArrayList<String>();  
		String roleName = "";
		try {
			
			UserLocalServiceUtil.getUserById(user.getUserId());
			List<Role> roleList= user.getRoles();	
			for(Role role:roleList) {
				userRoles.add(role.getName());
				roleName=String.join(",", userRoles);
			}						
			 
		} catch (PortalException e1) {
			_log.error("Error while fetching user data for GDF Tender Submission Module...");
		}
		
		_log.info("============In gdfTenderList details==============" + activeGdfTenders.size());
		renderRequest.setAttribute("activeGdfTenders", activeGdfTenders);

		renderRequest.setAttribute("tenderSubViewList", tenderSubViewList);
		String currentURL = themeDisplay.getURLCurrent();
		_log.info("currentURL visited page url ::" + currentURL);

		if(userRoles.contains(GdfTenderSubmissionConstants.MEDICINE_SUPPLIER_ROLE)) { 
			_log.info(":::userRoles:::"+userRoles);
		if (currentURL.contains("create")) {
			renderRequest.setAttribute("currentPage", "create");
		} else if (currentURL.contains("edit")) {
			renderRequest.setAttribute("currentPage", "edit");
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String tenderReferenceNumber = httpReq.getParameter("tenderReferenceNumber");
			_log.info(":::::tenderReferenceNumber in render method::::" + tenderReferenceNumber);
			GDFTenderDetails gdfTender = null;

			try {
				gdfTender = GDFTenderDetailsLocalServiceUtil
						.getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);
				renderRequest.setAttribute("gdfTenderEdit", gdfTender);
				_log.info(":::::gdfTender in edit mode:::" + gdfTender);

			} catch (NoSuchGDFTenderDetailsException e) {
				e.printStackTrace();
			}

			List<GDFTenderScheduleItem> gdfTenderScheduleItemList;
			try {
				gdfTenderScheduleItemList = GDFTenderScheduleItemLocalServiceUtil
						.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);
				Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
						.prepareScheduleDetails(gdfTenderScheduleItemList);

				renderRequest.setAttribute("schedList", schedList);

				_log.info(":::::schedList in edit mode:::" + schedList);
			} catch (NoSuchGDFTenderDetailsException e) {
				e.printStackTrace();
			}

			GDFTenderSubmissionDetails gdfSubmittedTenders = null;
			try {
				gdfSubmittedTenders = GDFTenderSubmissionDetailsLocalServiceUtil
						.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tenderReferenceNumber, user.getUserId());
				renderRequest.setAttribute("gdfSubmittedTenders", gdfSubmittedTenders);
				_log.info(":::::gdfSubmittedTenders in edit mode:::" + gdfSubmittedTenders);

				GdfTenderSubmissionDetailUtil.fileUploadUrl(gdfSubmittedTenders, renderRequest);

			} catch (NoSuchGDFTenderSubmissionDetailsException e) {
				e.printStackTrace();
			}

		} else if (currentURL.contains("view")) {
			renderRequest.setAttribute("currentPage", "view");
		} else if (currentURL.contains("success")) {
			renderRequest.setAttribute("currentPage", "success");
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String tenderRefNo = httpReq.getParameter("tenderReferenceNumber");
			
			_log.info(":::::tenderReferenceNumber in success method::::" + tenderRefNo);
			renderRequest.setAttribute("tenderReferenceNumber", tenderRefNo);
		} else {
			renderRequest.setAttribute("currentPage", "error");
		}
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = (User) resourceRequest.getAttribute(WebKeys.USER);
		long userId = themeDisplay.getUserId();
		_log.info("In gdfSubmission module Resource cmd userId:::" + userId);
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject tenderRefJson = null;

		if ("tenderRefDropDown".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");

			_log.info(":::::tenderReferenceNumber in serve resource:::" + tenderRefNo);

			List<GDFTenderScheduleItem> gdfTenderScheduleItemList = null;
			try {

				gdfTenderScheduleItemList = GDFTenderScheduleItemLocalServiceUtil
						.getGDFTenderScheduleItemByTenderRefNumber(tenderRefNo);

				_log.info(":::::gdfTenderScheduleItemList in serve resource:::" + gdfTenderScheduleItemList);
			} catch (NoSuchGDFTenderDetailsException e) {
				_log.error("*****NoSuchGDFTenderDetailsException****", e);
			}

			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareScheduleDetails(gdfTenderScheduleItemList);

			GDFTenderDetails gdfTender = null;
			try {
				gdfTender = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailsByTenderRefNumber(tenderRefNo);
			} catch (NoSuchGDFTenderDetailsException e) {
				_log.error("*****NoSuchGDFTenderDetailsException****", e);
			}

			JSONArray scheduleJsonArray = JSONFactoryUtil.createJSONArray(schedList);

			tenderRefJson = JSONFactoryUtil.createJSONObject();
			tenderRefJson.put("TenderReferenceNumber", gdfTender.getTenderReferenceNumber());
			tenderRefJson.put("ProdCategory", gdfTender.getProductCategory());
			tenderRefJson.put("Title", gdfTender.getTitle());
			tenderRefJson.put("PublicationDate",
					new SimpleDateFormat("dd/MM/yyyy").format(gdfTender.getPublicationDate()));
			tenderRefJson.put("DeadlineForTechBidsSub",
					new SimpleDateFormat("dd/MM/yyyy").format(gdfTender.getDeadlineForTechBidsSub()));
			//tenderRefJson.put("DeadlineForTechBidsTimer", gdfTender.getDeadlineForTechBidsSub());
			tenderRefJson.put("Method", gdfTender.getMethod());
			tenderRefJson.put("scheduleJsonArray", scheduleJsonArray);

			_log.info("Partial resultJson wrt tender::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());

		}
		// for deadline date for cancellation
		if ("fetchDeadLineDateDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");
			_log.info("::::::::tenderRefNo in fetchDeadLineDateDetails:::::" + tenderRefNo+ ":::tenderReferenceNumber::::" +httpReq.getParameter("tenderReferenceNumber"));

			GDFTenderDetails gdfTender = null;
			try {
				gdfTender = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailsByTenderRefNumber(tenderRefNo);
			} catch (NoSuchGDFTenderDetailsException e) {
				_log.error("*****NoSuchGDFTenderDetailsException****", e);
			}
			
			
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("tenderReferenceNumber", gdfTender.getTenderReferenceNumber());
			tenderRefJson.put("deadLineDateForTechBids", new SimpleDateFormat("dd/MM/yyyy").format(gdfTender.getDeadlineForTechBidsSub()));

			_log.info("Partial resultJson wrt fetchDeadLineDateDetails::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}
		
		// for product selection tab
		if ("fetchSelectGdfTenders".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderReferenceNumber = httpReq.getParameter("tenderRefNo");
			_log.info("::::::::tenderRefNo in fetchSelectGdfTenders:::::" + tenderReferenceNumber);

			List<GDFTenderScheduleItem> gdfTenderMatRegList = null;
			try {
				gdfTenderMatRegList = GDFTenderScheduleItemLocalServiceUtil
						.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);
			} catch (NoSuchGDFTenderDetailsException e) {
				e.printStackTrace();
			}
			_log.info("::::::::gdfTenderMatRegList in fetchSelectGdfTenders size:::::" + gdfTenderMatRegList.size());

			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareFPPMartDetails(gdfTenderMatRegList, user.getUserId());
			_log.info("::::::::schedList in fetchSelectGdfTenders:::::" + schedList);

			JSONArray schedFppMartJsonArray = JSONFactoryUtil.createJSONArray(schedList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("schedFppMartJsonArray", schedFppMartJsonArray);

			_log.info("Partial resultJson wrt fetchSelectGdfTenders::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}
		// for prdSelectedNext from FPP in market

		if ("prdSelectedNext".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");

			List<GDFTenderSubFPPMatDetails> gdfTenderMatRegList = GDFTenderSubFPPMatDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPMatByUserId(tenderRefNo, themeDisplay.getUserId());
			_log.info("::::::::gdfTenderMatRegList in prdSelectedNext:::::" + gdfTenderMatRegList);
			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.preparePrdSelectedDetails(gdfTenderMatRegList, user.getUserId(),tenderRefNo);
			_log.info("::::::::schedList in prdSelectedNext:::::" + schedList);

			JSONArray prdSelectedJsonArray = JSONFactoryUtil.createJSONArray(schedList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("prdSelectedJsonArray", prdSelectedJsonArray);

			_log.info("Partial resultJson prdSelectedJsonArray wrt tender submission::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}

		// For Product Registration tab from FPP registration
		if ("fetchPrdRegDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");
			_log.info("::::::::tenderRefNo in fetchPrdRegDetails:::::" + tenderRefNo);

			List<GDFTenderSubFPPMatDetails> gdfTenderFppMatList = GDFTenderSubFPPMatDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPMatByUserId(tenderRefNo, themeDisplay.getUserId());
			_log.info("::::::::gdfTenderMatRegList in fetchPrdRegDetails size:::::" + gdfTenderFppMatList.size());

			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareProdRegDetails(gdfTenderFppMatList, user.getUserId());
			_log.info("::::::::schedList in prdSelectedNext:::::" + schedList);

			JSONArray fppRegJsonArray = JSONFactoryUtil.createJSONArray(schedList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("fppRegJsonArray", fppRegJsonArray);

			_log.info("Partial resultJson wrt fetchPrdRegDetails::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}

		// for product selection tab
		if ("editSelectGdfTenders".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderReferenceNumber = httpReq.getParameter("tenderRefNo");
			_log.info("::::::::tenderRefNo in editSelectGdfTenders:::::" + tenderReferenceNumber);

			List<GDFTenderScheduleItem> gdfTenderMatRegList = null;
			try {
				gdfTenderMatRegList = GDFTenderScheduleItemLocalServiceUtil
						.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);
			} catch (NoSuchGDFTenderDetailsException e) {
				e.printStackTrace();
			}
			_log.info("::::::::gdfTenderMatRegList in editSelectGdfTenders size:::::" + gdfTenderMatRegList.size());

			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareEditFPPMartDetails(gdfTenderMatRegList, user.getUserId());
			_log.info("::::::::schedList in editSelectGdfTenders:::::" + schedList);

			JSONArray schedFppMartJsonArray = JSONFactoryUtil.createJSONArray(schedList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("schedFppMartJsonArray", schedFppMartJsonArray);

			_log.info("Partial resultJson wrt editSelectGdfTenders::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}
		if ("tenderSubNextDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");

			
			GDFTenderSubmissionDetails gdfTenderSubDetails;
			try {
				gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
						.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tenderRefNo, themeDisplay.getUserId());
				tenderRefJson = JSONFactoryUtil.createJSONObject();
				tenderRefJson.put("tenderReferenceNumber", gdfTenderSubDetails.getTenderReferenceNumber());
				tenderRefJson.put("supplierName", user.getScreenName());
				tenderRefJson.put("nameOfAuthRepr", gdfTenderSubDetails.getNameOfAuthRepr());
				tenderRefJson.put("supplierTitle", gdfTenderSubDetails.getSupplierTitle());
				tenderRefJson.put("supplierEmailAddress", gdfTenderSubDetails.getSupplierEmailAddress());
				tenderRefJson.put("supplierTelephoneNumber", gdfTenderSubDetails.getSupplierTelephoneNumber());
				
				

			} catch (NoSuchGDFTenderSubmissionDetailsException e) {
				e.printStackTrace();
			}

			GDFTenderDetails gdfTender = null;
			try {
				gdfTender = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailsByTenderRefNumber(tenderRefNo);
				tenderRefJson.put("deadLineDateForTechBids", new SimpleDateFormat("dd/MM/yyyy").format(gdfTender.getDeadlineForTechBidsSub()));
			} catch (NoSuchGDFTenderDetailsException e) {
				_log.error("*****NoSuchGDFTenderDetailsException****", e);
			}
			
			
			
			_log.info("Partial resultJson tenderSubNextDetails wrt tender submission::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}

		// For edit Product Registration tab from FPP registration details
		if ("editPrdRegDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String tenderRefNo = httpReq.getParameter("tenderRefNo");
			_log.info("::::::::tenderRefNo in editPrdRegDetails:::::" + tenderRefNo);

			List<GDFTenderSubFPPMatDetails> gdfTenderFppMatList = GDFTenderSubFPPMatDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPMatByUserId(tenderRefNo, themeDisplay.getUserId());
			_log.info("::::::::gdfTenderMatRegList in editPrdRegDetails size:::::" + gdfTenderFppMatList.size());

			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareEditProdRegDetails(gdfTenderFppMatList, user.getUserId());
			_log.info("::::::::schedList in editPrdRegDetails:::::" + schedList);

			JSONArray fppRegJsonArray = JSONFactoryUtil.createJSONArray(schedList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();

			tenderRefJson.put("fppRegJsonArray", fppRegJsonArray);

			_log.info("Partial resultJson wrt editPrdRegDetails::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());
		}

		// File upload
		else if ("regCerificate".equalsIgnoreCase(resourceRequest.getResourceID())) {
			_log.info("inside file upload for  technical bids");
			GDFTenderSubmissionDetails model = null;

			try {
				GdfTenderSubmissionFileUpload upload = new GdfTenderSubmissionFileUpload();
				model = upload.fileUpload("regCerti", resourceRequest, resourceResponse, themeDisplay);
			} catch (PortalException e) {

				e.printStackTrace();
			}

			tenderRefJson.put("tenderReferenceNumber", model.getTenderReferenceNumber());
			tenderRefJson.put("fileUrl", model.getCopyOfRegCert());

			resourceResponse.getWriter().write(tenderRefJson.toJSONString());

		}
		// For Download Technical Bids
		else if ("downloadTechBidsFile".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String output = downloadTechBidsFile(resourceRequest, resourceResponse);
			resourceResponse.getWriter().print(output);
		}
		// For Download Country product Registration
		else if ("downloadCountryProdRegFile".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String output = downloadCountryProdRegFile(resourceRequest, resourceResponse);
			resourceResponse.getWriter().print(output);
		}

		// select Tender Info Save Ajax
		else if ("saveSelGdfTender".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for saveSelGdfTender ajax::" + requestData.toString());
			String result = saveSelGdfTenderDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		} // For Product Selection tab Ajax
		else if ("savePrdSelection".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for savePrdSelection ajax::" + requestData.toString());
			String result = savePrdSelectionDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		}
		// For Product Selection tab Ajax

		else if ("alreadySelectedProducts".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for savePrdSelection ajax::" + requestData.toString());
			String result = saveSelectedPrdDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		}

		// For Product Registration tab Ajax

		else if ("saveProductsRegistration".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for saveProductsRegistration ajax::" + requestData.toString());
			String result = saveProductsRegDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		}

		// For tender submission tab save Ajax

		else if ("saveTenderSubDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for saveTenderSubDetails ajax::" + requestData.toString());
			String result = saveTenderSubmissionDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		}

		/*
		 * // For tender submission tab submit Ajax
		 * 
		 * else if
		 * ("submitTenderSubDetails".equalsIgnoreCase(resourceRequest.getResourceID()))
		 * {
		 * 
		 * String requestData = httpReq.getParameter("requestData");
		 * 
		 * _log.info("requestData for submitTenderSubDetails ajax::" +
		 * requestData.toString()); String result =
		 * submitTenderSubmissionDetails(requestData, themeDisplay);
		 * resourceResponse.getWriter().print(result);
		 * 
		 * }
		 */

		// For tender submission tab cancel Ajax

		else if ("cancelTenderSubDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {

			String requestData = httpReq.getParameter("requestData");

			_log.info("requestData for cancelTenderSubDetails ajax::" + requestData.toString());
			String result = cancelTenderSubmissionDetails(requestData, themeDisplay);
			resourceResponse.getWriter().print(result);

		}
	}

	// select Tender Info Save Ajax
	private String saveSelGdfTenderDetails(String requestData, ThemeDisplay themeDisplay) {
		GDFTenderDetails gdfTenderDetails;

		GDFTenderSubmissionDetails gdfTenderSubDetails;
		JSONObject tenderDetJson;
		try {
			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = (String) tenderDetJson.get("tenderRefNo");
			String tenderSubRefId = (String) tenderDetJson.get("tenderSubRefId");
			_log.info("::::tenderSubRefId:::::" + tenderSubRefId);
			gdfTenderDetails = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailsByTenderRefNumber(tendRefNo);
			List<GDFTenderSubmissionDetails> gdfTenderSubDetailsList = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubmissionDetailses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			/*gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());
			List<GDFTenderSubmissionDetails> gdfTenderSubDetailsList = new ArrayList<>();
			gdfTenderSubDetailsList.add(gdfTenderSubDetails);*/
			_log.info(":::::gdfTenderSubDetailsList:: Size::" + gdfTenderSubDetailsList.size());
			if (gdfTenderSubDetailsList == null || gdfTenderSubDetailsList.isEmpty()) {
				_log.info("::::in if condition of adding tender ref number::::");

				GdfTenderSubmissionDetailUtil.addGdfSubmittionDetails(tendRefNo, themeDisplay);
			} else {
				GDFTenderSubmissionDetails gdfTenderUpdatedSubDetails = GdfTenderSubmissionDetailUtil
						.istenderRefNumberExists(gdfTenderSubDetailsList, tendRefNo, themeDisplay);

				if (gdfTenderUpdatedSubDetails != null) {
					_log.info("::::in if condition of Updating tender ref number::::");
					gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
							.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

					gdfTenderSubDetails.setSupplierId(themeDisplay.getUserId());
					gdfTenderSubDetails.setUserName(themeDisplay.getUser().getScreenName());

					//gdfTenderSubDetails.setModifiedDate(new Date());
					gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

					GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);
				} else {
					_log.info("::::in if else condition of adding tender ref number::::");
					GdfTenderSubmissionDetailUtil.addGdfSubmittionDetails(tendRefNo, themeDisplay);
				}
			}

		} catch (Exception e) {
			_log.error(":::Exception while saving the record:::::" + e.getMessage());
		}
		return requestData;
	}

// For select Product selection Save Ajax
	private String savePrdSelectionDetails(String requestData, ThemeDisplay themeDisplay) {

		GDFTenderSubmissionDetails gdfTenderSubDetails;

		JSONObject tenderDetJson;
		try {

			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = (String) tenderDetJson.get("tenderRefNo");

			gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			//gdfTenderSubDetails.setModifiedDate(new Date());
			gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

			JSONArray selPrdSelArr = (JSONArray) tenderDetJson.getJSONArray("selPrdSelArr");

			_log.info("::tendRefNo :::: selPrdSelArr:::" + selPrdSelArr + tendRefNo);

			List<ScheduleDetailsModel> schedularJsonList = GdfTenderSubmissionDetailUtil
					.readPrdSelFromJsonString(selPrdSelArr);

			_log.info(":::::schedularJsonList in ajax::::::" + schedularJsonList.size());

			List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatUpdatedDetList = GDFTenderSubFPPMatDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPMatByUserId(tendRefNo, themeDisplay.getUserId());

			_log.info("::::DB List size:::" + gdfTenderSubFPPMatUpdatedDetList.size());

			schedularJsonList.forEach(sl -> {

				FPPMarketDetailsModel fg = sl.getFppMartModelList().get(0);

				long fppMarketId = fg.getFppMarketId();
				_log.info(":::::fppMarketId in controller::::" + fppMarketId + ", " + fg.getTenderReferenceNumber()
						+ tendRefNo);

				if (gdfTenderSubFPPMatUpdatedDetList == null || gdfTenderSubFPPMatUpdatedDetList.isEmpty()) {

					_log.info(":::::In add fppMatDetails method:::::");

					try {
						GdfTenderSubmissionDetailUtil.addFPPMartDetails(fg, themeDisplay, sl.getScheduleNumber(),
								tendRefNo);
					} catch (PortalException e) {

						e.printStackTrace();
					}

				} else {

					GDFTenderSubFPPMatDetails fppMatDetails = GdfTenderSubmissionDetailUtil.isFppMartDetExists(
							gdfTenderSubFPPMatUpdatedDetList, fg, sl.getScheduleNumber(), themeDisplay);
					if (fppMatDetails != null) {
						_log.info(":::::In update fppMatDetails method:::::"+fg.isFppSelTenderSub());

						fppMatDetails.setFppSelectedStatus(fg.isFppSelTenderSub());
						//fppMatDetails.setModifiedDate(new Date());
						fppMatDetails.setGdfFppMartApprStatus(fg.getFppMartStatus());
						fppMatDetails.setTenderItemRefID(fg.getTenderItemNumber());
						GDFTenderSubFPPMatDetailsLocalServiceUtil.updateGDFTenderSubFPPMatDetails(fppMatDetails);

					} else {

						_log.info(":::::In else add fppMatDetails method:::::");
						try {
							GdfTenderSubmissionDetailUtil.addFPPMartDetails(fg, themeDisplay, sl.getScheduleNumber(),
									tendRefNo);
						} catch (PortalException e) {

							e.printStackTrace();
						}

					}

				}
			});

		} catch (Exception e) {
			_log.error("-------Error in Adding the fpp market gencodes submission ----", e);
		}
		return requestData;

	}

//For already selected Product Save Ajax

	private String saveSelectedPrdDetails(String requestData, ThemeDisplay themeDisplay) {

		GDFTenderSubmissionDetails gdfTenderSubDetails;

		JSONObject tenderDetJson;
		try {

			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = (String) tenderDetJson.get("tenderRefNo");

			gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			//gdfTenderSubDetails.setModifiedDate(new Date());
			gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

			JSONArray selectedPrdArr = (JSONArray) tenderDetJson.getJSONArray("selectedPrdArr");

			_log.info("::tendRefNo :::: selPrdSelArr:::" + selectedPrdArr + tendRefNo);

			List<ScheduleDetailsModel> schedularJsonList = GdfTenderSubmissionDetailUtil
					.readAlreadySelectedPrdsFromJsonString(selectedPrdArr);

			_log.info(":::::schedularJsonList in ajax::::::" + schedularJsonList);

			schedularJsonList.forEach(sl -> {

				List<FPPMarketDetailsModel> fppMartList = sl.getFppMartModelList();
				_log.info(":::::fppMartList in ajax::::::" + fppMartList);

				fppMartList.forEach(fm -> {
					long tenderFPPMatRefNumber = fm.getTenderFPPMatRefNumber();

					try {
						GdfTenderSubmissionDetailUtil.updateFPPMartDetails(fm, sl.getScheduleNumber(),
								tenderFPPMatRefNumber);
					} catch (Exception e) {
						_log.error("------------------Unable to update-------", e);
					}
				});
			});

		} catch (Exception e) {
			_log.error("-------Error in Updating the tender submission Items----", e);
		}
		return requestData;

	}

	// For select Product selection Save Ajax
	private String saveProductsRegDetails(String requestData, ThemeDisplay themeDisplay) {

		GDFTenderSubmissionDetails gdfTenderSubDetails;

		JSONObject tenderDetJson;
		try {

			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = (String) tenderDetJson.get("tenderRefNo");

			gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			//gdfTenderSubDetails.setModifiedDate(new Date());
			gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

			JSONArray selectedPrdRegArr = (JSONArray) tenderDetJson.getJSONArray("selectedPrdRegArr");

			_log.info("::tendRefNo :::: selectedPrdRegArr:::" + selectedPrdRegArr + tendRefNo);

			List<ScheduleDetailsModel> schedularJsonList = GdfTenderSubmissionDetailUtil
					.readPrdRegisteredFromJsonString(selectedPrdRegArr);

			_log.info(":::::schedularJsonList in ajax::::::" + schedularJsonList + ", Size:::: "
					+ schedularJsonList.size());

			List<GDFTenderSubFPPRegDetails> gdfTenderFPPRegUpdatedDetList = GDFTenderSubFPPRegDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPRegByUserId(tendRefNo, themeDisplay.getUserId());

			_log.info("::::DB List size:::" + gdfTenderFPPRegUpdatedDetList.size());

			schedularJsonList.forEach(sl -> {

				FPPRegDetailsModel fg = sl.getFppRegDetailsModel().get(0);

				String fppRegId = fg.getFppRegId();
				_log.info(":::::fppRegId in controller::::" + fppRegId + ", " + fg.getTenderReferenceNumber()
						+ tendRefNo);

				if (gdfTenderFPPRegUpdatedDetList == null || gdfTenderFPPRegUpdatedDetList.isEmpty()) {

					_log.info(":::::In add fppRegDetails method:::::");

					try {
						GdfTenderSubmissionDetailUtil.addFPPRegDetails(fg, themeDisplay, sl.getScheduleNumber(),
								tendRefNo);
					} catch (PortalException e) {

						e.printStackTrace();
					}

				} else {

					GDFTenderSubFPPRegDetails fppRegDetails = GdfTenderSubmissionDetailUtil.isFppRegCountryListExists(
							gdfTenderFPPRegUpdatedDetList, fg, sl.getScheduleNumber(), themeDisplay);
					if (fppRegDetails != null) {
						_log.info(":::::In update fppRegDetails method:::::");

						fppRegDetails.setTenderItemMatRefID(Long.parseLong(fg.getGdfTenderItemMatRefID()));
						fppRegDetails.setListOfRegCountries(fg.getListOfCountries());
						fppRegDetails.setFppRegAccepted(fg.isFppRegAcceptedStatus());
						fppRegDetails.setTenderItemRefID(fg.getTenderItemNumber());
						//fppRegDetails.setModifiedDate(new Date());
						fppRegDetails.setFppRegApprStatus(fg.getFppRegStatus());
						GDFTenderSubFPPRegDetailsLocalServiceUtil.updateGDFTenderSubFPPRegDetails(fppRegDetails);

					} else {

						_log.info(":::::In else add fppRegDetails method:::::");
						try {
							GdfTenderSubmissionDetailUtil.addFPPRegDetails(fg, themeDisplay, sl.getScheduleNumber(),
									tendRefNo);
						} catch (PortalException e) {

							e.printStackTrace();
						}

					}

				}
			});

		} catch (Exception e) {
			_log.error("-------Error in Adding the fpp reg countries submission ----", e);
		}
		return requestData;

	}

/*	private String downloadTechBidsFile(ResourceRequest request, ResourceResponse response) {
//		_log.info("requestData for downloadFile:"+requestData);

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String supplierName = themeDisplay.getUser().getScreenName();
			long supplierId = themeDisplay.getUserId();

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

			String path = httpReq.getSession().getServletContext().getRealPath("/");

			String gdfTenderRefNo = httpReq.getParameter("tenderRefNo");

			_log.info("gdfTenderRefNo:::" + gdfTenderRefNo);
			_log.info("path=" + path);

			int length = path.indexOf("ROOT");

			if (length > 0) {
				_log.info("inside if");
				path = path.substring(0, length - 1);
			} else {
				_log.info("inside else");
				length = path.indexOf("webapps");
				path = path.substring(0, length - 1);
			}

			String filePath = path + File.separator + "filedownload";
			_log.info("filePath=" + filePath);
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				_log.info("create directory");
				fileDir.mkdirs();
			}

			String fileName = supplierName + gdfTenderRefNo + "Technical Bids" + ".xlsx";
			File file = new File(filePath + File.separator + fileName);

			if (!file.exists()) {
				_log.info("create file");
				file.createNewFile();

			}
			_log.info("fileName::" + fileName);

			Utility.writeFPPMarketSheet(file, supplierName, gdfTenderRefNo, supplierId);
			JSONObject result = JSONFactoryUtil.createJSONObject();
			result.put("fileName", "/filedownload/" + fileName);

			_log.info("result ::" + fileName);
			return result.toString();

		} catch (Exception e) {
			_log.error("Error in downloadFile requestData::");
			e.printStackTrace();
		}
		return null;
	}*/

	
	private String downloadTechBidsFile(ResourceRequest request, ResourceResponse response) {
//		_log.info("requestData for downloadFile:"+requestData);

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String supplierName = themeDisplay.getUser().getScreenName();
			long supplierId = themeDisplay.getUserId();

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

			//String path = httpReq.getSession().getServletContext().getRealPath("/");

			String gdfTenderRefNo = httpReq.getParameter("tenderRefNo");
			
			//String tenderSpecialChars = "/,*|<>\\?:";
			
			_log.info("gdfTenderRefNo trim :::" + gdfTenderRefNo.trim()+"gdfTenderRefNo replace :::" + gdfTenderRefNo.replaceAll("/,*|<>\\\\?:", "-"));
			//_log.info("path=" + path);
			
			String folderName = "Technical Bids filedownload";
			long repositoryId = themeDisplay.getScopeGroupId();
			long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			
			
			Folder folder =DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			_log.info("::::folder name:::" + folder);
			
			long folderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();
			_log.info("====folderId===" + folderId);

			String filePath = folder.getName();
			_log.info("filePath=" + filePath);
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				_log.info("create directory");
				fileDir.mkdirs();
			}

			String fileName = supplierName + gdfTenderRefNo.replaceAll("/,*|<>\\\\?:", "-") + "Technical Bids" + ".xlsx";
			File file = new File(filePath + File.separator + fileName);

			if (!file.exists()) {
				_log.info("create file");
				file.createNewFile();

			}
			_log.info("fileName::" + fileName);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			GdfTenderSubmissionFileUpload.uploading(themeDisplay,request,file,fileName,parentFolderId,folderName,folderId,serviceContext,repositoryId);
			
			//List<String> fileUrlList=new ArrayList<String>();
			FileEntry fileEntries = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, file.getName());
			String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
					fileEntries.getFolderId() +  "/" +fileEntries.getTitle() ;
			_log.info("Link for file fpp market entry file url=>"+url);
			
			Utility.writeFPPMarketSheet(file, supplierName, gdfTenderRefNo, supplierId);
			JSONObject result = JSONFactoryUtil.createJSONObject();
			//fileUrlList=fileEntryUrl(themeDisplay,folderName,repositoryId,folderId,parentFolderId);
			result.put("fileName", url);

			
			_log.info("result ::" + fileName);
			return result.toString();

		} catch (Exception e) {
			_log.error("Error in downloadFile requestData::");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static List<String> fileEntryUrl(ThemeDisplay themeDisplay, String folderName, long repositoryId, long folderId, long parentFolderId) {
		_log.info("inside fileEntryUrl for folderName::"+folderName);
		Folder folder;
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

	private String downloadCountryProdRegFile(ResourceRequest request, ResourceResponse response) {
//		_log.info("requestData for downloadFile:"+requestData);

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String supplierName = themeDisplay.getUser().getScreenName();
			long supplierId = themeDisplay.getUserId();

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

			//String path = httpReq.getSession().getServletContext().getRealPath("/");

			String gdfTenderRefNo = httpReq.getParameter("tenderRefNo");

			_log.info("gdfTenderRefNo:::" + gdfTenderRefNo);
			//_log.info("path=" + path);
			
			String folderName = "Technical Bids filedownload";
			long repositoryId = themeDisplay.getScopeGroupId();
			long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			
			
			Folder folder =DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			_log.info("::::folder name:::" + folder);
			
			long folderId=DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName).getFolderId();
			_log.info("====folderId===" + folderId);

			String filePath = folder.getName();
			_log.info("filePath=" + filePath);
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				_log.info("create directory");
				fileDir.mkdirs();
			}

			String fileName = supplierName + gdfTenderRefNo.replaceAll("/,*|<>\\\\?:", "-") + "Country product registration" + ".xlsx";
			File file = new File(filePath + File.separator + fileName);

			if (!file.exists()) {
				_log.info("create file");
				file.createNewFile();

			}
			_log.info("fileName::" + fileName);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			GdfTenderSubmissionFileUpload.uploading(themeDisplay,request,file,fileName,parentFolderId,folderName,folderId,serviceContext,repositoryId);
			
			//List<String> fileUrlList=new ArrayList<String>();
			FileEntry fileEntries = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, file.getName());
			String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
					fileEntries.getFolderId() +  "/" +fileEntries.getTitle() ;
			_log.info("Link for file fpp reg entry file url=>"+url);
			
			
			Utility.writeFPPRegSheet(file, supplierName, gdfTenderRefNo, supplierId);
			JSONObject result = JSONFactoryUtil.createJSONObject();
			//fileUrlList=fileEntryUrl(themeDisplay,folderName,repositoryId,folderId,parentFolderId);
			result.put("fileName", url);

			
			_log.info("result ::" + fileName);
			return result.toString();

		} catch (Exception e) {
			_log.error("Error in downloadFile requestData::");
			e.printStackTrace();
		}
		return null;
		}
	
	
/*	private String downloadCountryProdRegFile(ResourceRequest request, ResourceResponse response) {
//	_log.info("requestData for downloadFile:"+requestData);

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			String supplierName = themeDisplay.getUser().getScreenName();
			long supplierId = themeDisplay.getUserId();

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

			String path = httpReq.getSession().getServletContext().getRealPath("/");

			String gdfTenderRefNo = httpReq.getParameter("tenderRefNo");

			_log.info("gdfTenderRefNo:::" + gdfTenderRefNo);
			_log.info("path=" + path);

			int length = path.indexOf("ROOT");

			if (length > 0) {
				_log.info("inside if");
				path = path.substring(0, length - 1);
			} else {
				_log.info("inside else");
				length = path.indexOf("webapps");
				path = path.substring(0, length - 1);
			}

			String filePath = path + File.separator + "filedownload";
			_log.info("filePath=" + filePath);
			File fileDir = new File(filePath);
			if (!fileDir.exists()) {
				_log.info("create directory");
				fileDir.mkdirs();
			}

			String fileName = supplierName + gdfTenderRefNo + "Country product registration" + ".xlsx";
			File file = new File(filePath + File.separator + fileName);

			if (!file.exists()) {
				_log.info("create file");
				file.createNewFile();

			}
			_log.info("fileName::" + fileName);

			Utility.writeFPPRegSheet(file, supplierName, gdfTenderRefNo, supplierId);
			JSONObject result = JSONFactoryUtil.createJSONObject();
			result.put("fileName", "/filedownload/" + fileName);

			_log.info("result ::" + fileName);
			return result.toString();

		} catch (Exception e) {
			_log.error("Error in downloadFile requestData::");
			e.printStackTrace();
		}
		return null;
	}*/

//select Tender Info Tender SubmissionD Save Ajax
	private String saveTenderSubmissionDetails(String requestData, ThemeDisplay themeDisplay) {

		JSONObject tenderDetJson;
		try {
			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = tenderDetJson.getString("tenderRefNo");

			GDFTenderSubmissionDetails gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			gdfTenderSubDetails.setSupplierName(tenderDetJson.getString("supplierName"));
			gdfTenderSubDetails.setNameOfAuthRepr(tenderDetJson.getString("respresentName"));
			gdfTenderSubDetails.setSupplierTitle(tenderDetJson.getString("supplierTitle"));
			gdfTenderSubDetails.setSupplierEmailAddress(tenderDetJson.getString("emailAddr"));
			gdfTenderSubDetails.setSupplierTelephoneNumber(tenderDetJson.getString("telephone"));
			gdfTenderSubDetails.setSupplierId(themeDisplay.getUserId());
			gdfTenderSubDetails.setUserName(themeDisplay.getUser().getScreenName());

			//gdfTenderSubDetails.setCreateDate(gdfTenderSubDetails.getCreateDate());
			//gdfTenderSubDetails.setModifiedDate(new Date());
			gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

		} catch (Exception e) {
			_log.error(":::Exception while saving the record:::::" + e.getMessage());
		}
		return requestData;
	}

//select Tender Info Tender SubmissionD Save Ajax
	private String cancelTenderSubmissionDetails(String requestData, ThemeDisplay themeDisplay) {

		JSONObject tenderDetJson;
		try {
			tenderDetJson = JSONFactoryUtil.createJSONObject(requestData);
			String tendRefNo = tenderDetJson.getString("tenderRefNo");

			GDFTenderSubmissionDetails gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			gdfTenderSubDetails.setSupplierName(tenderDetJson.getString("supplierName"));
			gdfTenderSubDetails.setNameOfAuthRepr(tenderDetJson.getString("respresentName"));
			gdfTenderSubDetails.setSupplierTitle(tenderDetJson.getString("supplierTitle"));
			gdfTenderSubDetails.setSupplierEmailAddress(tenderDetJson.getString("emailAddr"));
			gdfTenderSubDetails.setSupplierTelephoneNumber(tenderDetJson.getString("telephone"));
			gdfTenderSubDetails.setSupplierId(themeDisplay.getUserId());
			gdfTenderSubDetails.setUserName(themeDisplay.getUser().getScreenName());

			//gdfTenderSubDetails.setCreateDate(gdfTenderSubDetails.getCreateDate());
			//gdfTenderSubDetails.setModifiedDate(new Date());
			gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.CANCEL);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

		} catch (Exception e) {
			_log.error(":::Exception while saving the record:::::" + e.getMessage());
		}
		return requestData;
	}

	/*
	 * // For Edit select Product selection Save Ajax private String
	 * editPrdSelectionDetails(String requestData, ThemeDisplay themeDisplay) {
	 * 
	 * GDFTenderSubmissionDetails gdfTenderSubDetails;
	 * 
	 * JSONObject tenderDetJson; try {
	 * 
	 * tenderDetJson = JSONFactoryUtil.createJSONObject(requestData); String
	 * tendRefNo = (String) tenderDetJson.get("tenderRefNo");
	 * 
	 * gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
	 * .getGDFTenderDetailsByTenderRefNumber(tendRefNo);
	 * 
	 * gdfTenderSubDetails.setModifiedDate(gdfTenderSubDetails.getModifiedDate());
	 * gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.
	 * DRAFT);
	 * 
	 * GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(
	 * gdfTenderSubDetails);
	 * 
	 * JSONArray selPrdSelArr = (JSONArray)
	 * tenderDetJson.getJSONArray("selPrdSelArr");
	 * 
	 * _log.info("::tendRefNo :::: selPrdSelArr:::" + selPrdSelArr + tendRefNo);
	 * 
	 * List<ScheduleDetailsModel> schedularJsonList = GdfTenderSubmissionDetailUtil
	 * .readPrdSelFromJsonString(selPrdSelArr);
	 * 
	 * _log.info(":::::schedularJsonList in ajax::::::" + schedularJsonList);
	 * 
	 * schedularJsonList.forEach(sl -> {
	 * 
	 * List<FPPMarketDetailsModel> fppMartGenCodeList = sl.getFppMartModelList();
	 * fppMartGenCodeList = (fppMartGenCodeList == null ||
	 * fppMartGenCodeList.isEmpty()) ? Collections.emptyList() : fppMartGenCodeList;
	 * _log.info(":::::fppMartGenCodeList in ajax::::::" + fppMartGenCodeList);
	 * 
	 * fppMartGenCodeList.forEach(fg -> { long tenderFPPMatRefNumber =
	 * fg.getTenderFPPMatRefNumber();
	 * _log.info(":::::tenderFPPMatRefNumber in update controller::::" +
	 * tenderFPPMatRefNumber);
	 * 
	 * if (tenderFPPMatRefNumber == 0) {
	 * _log.info("--------Adding fpp market details-------"); try {
	 * GdfTenderSubmissionDetailUtil.addFPPMartDetails(fg, themeDisplay,
	 * sl.getScheduleNumber(), tendRefNo); } catch (PortalException e) {
	 * _log.error(":::Unable to add fpp market details:::" + sl.getScheduleNumber(),
	 * e); } } else { _log.info("--------Updating fpp market details-------"); try {
	 * GdfTenderSubmissionDetailUtil.updateFPPMartDetails(fg, themeDisplay,
	 * sl.getScheduleNumber(), fg.getTenderReferenceNumber(),
	 * tenderFPPMatRefNumber); } catch (PortalException e) {
	 * _log.error(":::Unable to update fpp market details:::" +
	 * sl.getScheduleNumber(), e); } }
	 * 
	 * }); });
	 * 
	 * } catch (Exception e) {
	 * _log.error("-------Error in Adding the fpp market gencodes submission ----",
	 * e); } return requestData;
	 * 
	 * }
	 */

}