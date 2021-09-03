/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gdf.tender.submission.portlet;

import static com.gdf.tender.submission.constants.GdfTenderSubmissionConstants.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalServiceUtil;
import com.gdf.tender.submission.constants.GdfTenderSubmissionWebPortletKeys;
import com.gdf.tender.submission.util.MailUtil;
import com.gdf.tender.submission.util.Utility;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + GdfTenderSubmissionWebPortletKeys.GDFTENDERSUBMISSIONWEB,
		"mvc.command.name=actionTenderSubmissionDetails_Info" }, service = MVCActionCommand.class)
public class GdfTendeSubmissionActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(GdfTendeSubmissionActionCommand.class);
	Configuration config = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String cmdName = ParamUtil.getString(actionRequest, "cmd");
		_log.info("##cmdName mvc action class : " + cmdName);
		try {
			if (Objects.equals(cmdName, ACTION_SUBMIT_TENDER_DETAILS)) {
				submitTenderBids(actionRequest, actionResponse);
				SessionMessages.add(actionRequest, "Tender submission details updated successfully");

			} else if (Objects.equals(cmdName, ACTION_EDIT_TENDER_DETAILS)) {

				editTender(actionRequest, actionResponse);
				SessionMessages.add(actionRequest, "Tender details edit mode");
			}

		} catch (Exception e) {
			_log.error("Exception rendering in Jsp page", e);
		}

	}

	public void submitTenderBids(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL().concat(themeDisplay.getPathFriendlyURLPublic().concat(themeDisplay.getScopeGroup().getFriendlyURL()));
		
		_log.info("GDF tender submission details submit action method portalURL:::"+portalURL);
		String tendRefNo = ParamUtil.getString(actionRequest, "tenderRefNumber");
		try {
			

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

			String supplierName = ParamUtil.getString(actionRequest, "nameOfSupplier");
			String nameOfAuthRepr = ParamUtil.getString(actionRequest, "authRepresenName");
			String supplierTitle = ParamUtil.getString(actionRequest, "supplierTitle");
			String emailAddress = ParamUtil.getString(actionRequest, "emailAddr");
			String telephoneNo = ParamUtil.getString(actionRequest, "telephone");

			_log.info(":::submitTenderSubmissionDetails tendRefNo:::" + tendRefNo + ":::supplierName::::" + supplierName
					+ ":::nameOfAuthRepr:::" + nameOfAuthRepr + ":::supplierTitle:::" + supplierTitle
					+ ":::emailAddress:::" + emailAddress + ":::telephoneNo:::" + telephoneNo);

			GDFTenderSubmissionDetails gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
					.getGDFTenderSubDetailsByTenderRefNumberAndUserId(tendRefNo, themeDisplay.getUserId());

			gdfTenderSubDetails.setSupplierName(supplierName);
			gdfTenderSubDetails.setNameOfAuthRepr(nameOfAuthRepr);
			gdfTenderSubDetails.setSupplierTitle(supplierTitle);
			gdfTenderSubDetails.setSupplierEmailAddress(emailAddress);
			gdfTenderSubDetails.setSupplierTelephoneNumber(telephoneNo);
			gdfTenderSubDetails.setSupplierId(themeDisplay.getUserId());
			gdfTenderSubDetails.setUserName(themeDisplay.getUser().getScreenName());
			gdfTenderSubDetails.setSubmittedDate(new Date());
			gdfTenderSubDetails.setModifiedDate(gdfTenderSubDetails.getModifiedDate());
			gdfTenderSubDetails.setTenderSubmissionStatus(SUBMITTED);

			GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(gdfTenderSubDetails);

			try {

				String path = httpReq.getSession().getServletContext().getRealPath("/");

				_log.info("gdfTenderRefNo:::" + tendRefNo);
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

				String fileTechBidsName = supplierName + tendRefNo + "Technical Bids" + ".xlsx";
				String fileCountryName = supplierName + tendRefNo + "Country product registration" + ".xlsx";

				File techBidsFile = new File(filePath + File.separator + fileTechBidsName);
				File countryRegFile = new File(filePath + File.separator + fileCountryName);

				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				// send mail notification to Supplier with attachments
				/*String emailBodySupplier = getTECh_BIDS_SUPPLIER_TEMPLATE(
						Utility.firstCharacterInUpperCase(user.getScreenName()), "GDFTENDER-" + tendRefNo,
						Utility.firstCharacterInUpperCase(user.getScreenName()), gdfTenderSubDetails, fileTechBidsName,
						fileCountryName);
				sendEmailNotificationToSupplier(user.getEmailAddress(),
						Utility.firstCharacterInUpperCase(user.getScreenName()) + " Your tender submission:" + tendRefNo
											+ " – Technical Bids",
								emailBodySupplier, themeDisplay, techBidsFile, fileTechBidsName, countryRegFile, fileCountryName);

				// send mail notification to IDA
				String emailBodyIDA = getTECh_BIDS_IDA_TEMPLATE("Procurement Agent", "GDFTENDER-" + tendRefNo,
						Utility.firstCharacterInUpperCase(user.getScreenName()), gdfTenderSubDetails);
				sendEmailNotificationWithAttachmentsToIDA(config.get("IDA_MAIL"),
						Utility.firstCharacterInUpperCase(user.getScreenName()) + tendRefNo + " – Technical Bids",
						emailBodyIDA, themeDisplay, techBidsFile, fileTechBidsName, countryRegFile, fileCountryName,
						supplierName, tendRefNo, user.getUserId());
				
				// send mail notification to GDF
				String emailBodyGdf = getTECh_BIDS_IDA_TEMPLATE("GDF", tendRefNo,
						Utility.firstCharacterInUpperCase(user.getScreenName()), gdfTenderSubDetails);
				sendEmailNotificationWithAttachmentsToGDF(getGDFEmailList(),
						Utility.firstCharacterInUpperCase(user.getScreenName()) + tendRefNo + " – Technical Bids",
						emailBodyGdf, themeDisplay, techBidsFile, fileTechBidsName, countryRegFile, fileCountryName,
						supplierName, tendRefNo, user.getUserId());*/

			} catch (Exception e) {
				_log.error("Error in sending the email for tender reference number::" + tendRefNo);
			}

		
		
			
			actionResponse.sendRedirect(portalURL +"/tendersubmission/success?tenderReferenceNumber=" + tendRefNo);

		} catch (Exception e) {
			_log.error(
					"Error while updating tender submission details for tendRefNo or sending in email:: " + tendRefNo);
			actionResponse.sendRedirect(portalURL +"/tendersubmission/error");
		}
	}

	public void editTender(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		String tenderReferenceNumber = ParamUtil.getString(actionRequest, "tenderReferenceNumber");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL().concat(themeDisplay.getPathFriendlyURLPublic().concat(themeDisplay.getScopeGroup().getFriendlyURL()));
		_log.info(":::portalURL:::"+portalURL);
		try {
			User currentUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			List<Role> roles = currentUser.getRoles();
			for (Role role : roles) {
				_log.info("User Role::::" + role.getName());

				actionResponse.sendRedirect(portalURL + "/tendersubmission/edit?tenderReferenceNumber=" + tenderReferenceNumber);

			}

		} catch (PortalException e) {
			_log.error("Error while in edit tender submission details for tendRefNo:: " + tenderReferenceNumber);
		}
	}

	/**
	 * @param emailList
	 * @param subject
	 * @param emailBody
	 * @throws ParseException
	 */
	private void sendEmailNotificationToSupplier(String emailList, String subject, String emailBody,
			ThemeDisplay themeDisplay, File techBidsfile, String techBidsattchment, File countryRegFile,
			String countryRegattachment) throws ParseException {
		try {
			// String toAddress = emailList.stream().collect(Collectors.joining(","));
			String toAddress = emailList;
			// _log.info("emailList:" + toAddress);
			String fromAddress = "kskhadir7@gmail.com";
			// String fromAddress="cdp-portal@stoptb.org";
			String ccAddress = "";
			String contentDetails = "";
			String title = "";
			String salutation = "";
			String buttonContent = ""; // Have comment out the from Email template
			String portalUrl = themeDisplay.getCDNBaseURL();
			String body = MailUtil.mailtemplatewithoutTable(title, salutation, emailBody, contentDetails, buttonContent,
					portalUrl);

			MailUtil.sendMailWithAttachments(toAddress, fromAddress, ccAddress, subject, body, techBidsfile,
					techBidsattchment, countryRegFile, countryRegattachment);
		} catch (Exception e) {
			_log.error("Error in sending the mail for tender submission::" + subject);
		}
	}

	/**
	 * @param emailList
	 * @param subject
	 * @param emailBody
	 * @throws ParseException
	 */
	private void sendEmailNotificationWithAttachmentsToGDF(List<String> emailList, String subject, String emailBody,
			ThemeDisplay themeDisplay, File techBidsfile, String techBidsattchment, File countryRegFile,
			String countryRegattachment,String supplierName, String gdfTenderRefNo, long supplierId) throws ParseException {
		try {
			String toAddress = emailList.stream().collect(Collectors.joining(","));
			// String toAddress =emailList;
			// _log.info("emailList:" + toAddress);
			String fromAddress = "kskhadir7@gmail.com";
			// String fromAddress="cdp-portal@stoptb.org";
			String ccAddress = "";
			String contentDetails = "";
			String title = "";
			String salutation = "";
			String buttonContent = ""; // Have comment out the from Email template
			String portalUrl = themeDisplay.getCDNBaseURL();
			String body = MailUtil.mailtemplatewithScheduleWithTable(title, salutation, emailBody, contentDetails, buttonContent,
					portalUrl, supplierName, gdfTenderRefNo, supplierId);

			MailUtil.sendMailWithAttachments(toAddress, fromAddress, ccAddress, subject, body, techBidsfile,
					techBidsattchment, countryRegFile, countryRegattachment);
		} catch (Exception e) {
			_log.error("Error in sending the mail for tender submission::" + subject);
		}
	}

	/**
	 * @param emailList
	 * @param subject
	 * @param emailBody
	 * @throws ParseException
	 */
	private void sendEmailNotificationWithAttachmentsToIDA(String emailList, String subject, String emailBody,
			ThemeDisplay themeDisplay, File techBidsfile, String techBidsattchment, File countryRegFile,
			String countryRegattachment,String supplierName, String gdfTenderRefNo, long supplierId) throws ParseException {
		try {
			//String toAddress = emailList.stream().collect(Collectors.joining(","));
			 String toAddress =emailList;
			// _log.info("emailList:" + toAddress);
			String fromAddress = "kskhadir7@gmail.com";
			// String fromAddress="cdp-portal@stoptb.org";
			String ccAddress = "";
			String contentDetails = "";
			String title = "";
			String salutation = "";
			String buttonContent = ""; // Have comment out the from Email template
			String portalUrl = themeDisplay.getCDNBaseURL();
			String body = MailUtil.mailtemplatewithScheduleWithTable(title, salutation, emailBody, contentDetails, buttonContent,
					portalUrl, supplierName, gdfTenderRefNo, supplierId);

			MailUtil.sendMailWithAttachments(toAddress, fromAddress, ccAddress, subject, body, techBidsfile,
					techBidsattchment, countryRegFile, countryRegattachment);
		} catch (Exception e) {
			_log.error("Error in sending the mail for tender submission::" + subject);
		}
	}
	
	/**
	 * @param userName
	 * @param linkUrl
	 * @param model
	 * @return
	 */
	private String getTECh_BIDS_IDA_TEMPLATE(String userName, String subDetails, String supplieName,
			GDFTenderSubmissionDetails tenderSubDetails) {
		return "<p>Dear " + userName + "</p>\r\n" + " <p>" + supplieName
				+ " has successfully submitted its Technical Bids for the GDF tender with reference number "
				+ tenderSubDetails.getTenderReferenceNumber();

	}

	/**
	 * @param userName
	 * @param linkUrl
	 * @param model
	 * @return
	 */
	private String getTECh_BIDS_SUPPLIER_TEMPLATE(String userName, String subDetails, String supplieName,
			GDFTenderSubmissionDetails tenderSubDetails, String fileTechBidsName, String fileCountryName) {
		return "<p>Dear " + userName + "</p>\r\n" + " <p>" + supplieName
				+ " has successfully submitted its Technical Bids for the GDF tender with reference number "
				+ tenderSubDetails.getTenderReferenceNumber() + " for the following products:" + ".</p>"
				+ " <p>Please find in the attachment the Technical Bids for the products offered by " + supplieName
				+ " Excel files: " + fileTechBidsName + "  " + fileCountryName;

	}

	/**
	 * @param userName
	 * @param linkUrl
	 * @param model
	 * @return
	 */
	private String getTECh_BIDS_GDF_TEMPLATE(String userName, String subDetails, String supplieName,
			GDFTenderSubmissionDetails tenderSubDetails, String fileTechBidsName, String fileCountryName) {
		return "<p>Dear " + userName + "</p>\r\n" + " <p>" + supplieName
				+ " has successfully submitted its Technical Bids for the GDF tender with reference number "
				+ tenderSubDetails.getTenderReferenceNumber() + " for the following products:" + ".</p>"
				+ " <p>Please find in the attachment the Technical Bids for the products offered by " + supplieName
				+ " Excel files: " +fileTechBidsName + "  " + fileCountryName;

	}
	

private List<String> getGDFEmailList() {
	


		// collect email Ids of GDF Role
		Set<String> emailList = new HashSet<String>();
		emailList.add(config.get("GDF_KAS_MAIL"));
		emailList.add(config.get("GDF_Mag_MAIL"));
		emailList.add(config.get("GDF_NIGO_MAIL"));
		
		
		_log.info(":::emailList:::" + emailList);
		List<String> resultList = new ArrayList<String>();
		resultList.addAll(emailList);
		
		
		
		return resultList;
	}

/*	private List<String> getGDFEmailList() {

		// collect email Ids of GDF Role
		long roleId = getRoleIdByName(GDF_ROLE);
		Set<String> emailList = new HashSet<String>();
		List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);

		for (User user : users) {
			emailList.add(user.getEmailAddress());
		}
		_log.info(":::emailList:::" + emailList);
		List<String> resultList = new ArrayList<String>();
		resultList.addAll(emailList);
		
		
		
		return resultList;
	}

private long getRoleIdByName(String roleName) {
		if (roleName != null && !roleName.isEmpty()) {
			for (Role role : RoleLocalServiceUtil.getRoles(0, RoleLocalServiceUtil.getRolesCount())) {
				if (role.getName().equals(roleName)) {
					return role.getRoleId();
				}
			}
		}
		return -1;
}
*/
/*private long getUserIdByName(String userName) {
	if (userName != null && !userName.isEmpty()) {
		for (User user : UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount())) {
			if (user.getScreenName().equals(userName)) {
				return user.getUserId();
			}
		}
	}
	return -1;
}*/

}