package com.gdf.tender.submission.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.gdf.fpp.market.model.FPPMarket;
import com.gdf.fpp.market.service.FPPMarketLocalServiceUtil;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;
import com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalServiceUtil;
import com.gdf.tender.submission.bean.FPPMarketDetailsModel;
import com.gdf.tender.submission.bean.ScheduleDetailsModel;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MailUtil {
	private static Log _log = LogFactoryUtil.getLog(MailUtil.class);

	public static void sendMail(String toemail, String fromemail, String ccemail, String subject, String body)
			throws javax.mail.internet.ParseException {

		InternetAddress[] cc_email = null;
		InternetAddress[] to_email = null;
		InternetAddress email_from_id = new InternetAddress(fromemail);

		try {
			to_email = InternetAddress.parse(toemail);
			cc_email = InternetAddress.parse(ccemail);
		} catch (AddressException e1) {
			_log.info("exception in email address " + e1.getMessage());

		}
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(to_email);
			mailMessage.setFrom(email_from_id);
			mailMessage.setCC(cc_email);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception ex) {
			_log.error("exception in sending email for " + toemail + ex.getMessage());

		}

		_log.info("Mail has trigerred successfully for  " + toemail);

	}

	public static void sendMailWithAttachments(String toemail, String fromemail, String ccemail, String subject,
			String body, File techBidsfile, String techBidsattchment, File countryRegFile, String countryRegattachment)
			throws javax.mail.internet.ParseException {

		InternetAddress[] cc_email = null;
		InternetAddress[] to_email = null;
		InternetAddress email_from_id = new InternetAddress(fromemail);

		try {
			to_email = InternetAddress.parse(toemail);
			cc_email = InternetAddress.parse(ccemail);
		} catch (AddressException e1) {
			_log.info("exception in email address " + e1.getMessage());

		}
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(to_email);
			mailMessage.setFrom(email_from_id);
			mailMessage.setCC(cc_email);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);

			// adds attachments
			/*
			 * String[] xlfiles = attachments.split(";"); if (xlfiles != null &&
			 * xlfiles.length > 0) {
			 * _log.info("xlfiles 1111::"+xlfiles[0]+"file2222:::"+xlfiles[1]); for (String
			 * filePath : xlfiles) { String techBidsFile = xlfiles[0]; String countryRegFile
			 * = xlfiles[1]; mailMessage.addFileAttachment(file, techBidsFile);
			 * mailMessage.addFileAttachment(file, countryRegFile); } }
			 */

			mailMessage.addFileAttachment(techBidsfile, techBidsattchment);
			mailMessage.addFileAttachment(countryRegFile, countryRegattachment);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception ex) {
			_log.error("exception in sending email for " + toemail + ex.getMessage());

		}

		_log.info("Mail has trigerred successfully for  " + toemail);

	}

public static String mailtemplatewithScheduleWithTable(String title,String salutation,String content,String contentDetails,String buttonContent,String portalUrl,String supplierName, String gdfTenderRefNo, long supplierId) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date caldate = Calendar.getInstance().getTime();
		String date = formatter.format(caldate);  
		int year = Year.now().getValue(); 
		
		List<GDFTenderSubFPPMatDetails> gdfFppMartDetList = GDFTenderSubFPPMatDetailsLocalServiceUtil
				.getGDFTendRefDetailsSubFPPMatByUserId(gdfTenderRefNo, supplierId);
		Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
				.preparePrdSelectedDetails(gdfFppMartDetList, supplierId, gdfTenderRefNo);
		List<ScheduleDetailsModel> scheduleNameList = new ArrayList<>();
		scheduleNameList.addAll(schedList);
		
		String tableBody = new String();
		String imageUrl= portalUrl+"/o/StopTBTheme/images/GDF-logo.png";
		String template="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Email Template</title>\r\n" + 
				"    <style>\r\n" + 
				"        html,\r\n" + 
				"        body,\r\n" + 
				"        table,\r\n" + 
				"        tbody,\r\n" + 
				"        tr,\r\n" + 
				"        td,\r\n" + 
				"        div,\r\n" + 
				"        p,\r\n" + 
				"        ul,\r\n" + 
				"        ol,\r\n" + 
				"        li,\r\n" + 
				"        h1,\r\n" + 
				"        h2,\r\n" + 
				"        h3,\r\n" + 
				"        h4,\r\n" + 
				"        h5,\r\n" + 
				"        h6 {\r\n" + 
				"            margin: 0;\r\n" + 
				"            padding: 0;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        body {\r\n" + 
				"            margin: 0;\r\n" + 
				"            padding: 0;\r\n" + 
				"            font-size: 14px;\r\n" + 
				"            line-height: 0;\r\n" + 
				"            -ms-text-size-adjust: 100%;\r\n" + 
				"            -webkit-text-size-adjust: 100%;\r\n" + 
				"        "
				+ "}\r\n" + 
				"\r\n" + 
				"        table {\r\n" + 
				"            border-spacing: 0;\r\n" + 
				"            mso-table-lspace: 0pt;\r\n" + 
				"            mso-table-rspace: 0pt;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        table td {\r\n" + 
				"            border-collapse: collapse;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .ExternalClass {\r\n" + 
				"            width: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        .ExternalClass,\r\n" + 
				"        .ExternalClass p,\r\n" + 
				"        .ExternalClass span,\r\n" + 
				"        .ExternalClass font,\r\n" + 
				"        .ExternalClass td,\r\n" + 
				"        .ExternalClass div {\r\n" + 
				"            line-height: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        /* Outermost container in Outlook.com */\r\n" + 
				"\r\n" + 
				"        .ReadMsgBody {\r\n" + 
				"            width: 100%;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        img {\r\n" + 
				"            -ms-interpolation-mode: bicubic;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        h1,\r\n" + 
				"        h2,\r\n" + 
				"        h3,\r\n" + 
				"        h4,\r\n" + 
				"        h5,\r\n" + 
				"        h6 {\r\n" + 
				"            font-family: Arial;\r\n" + 
				"            font-weight:normal;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        h1 {\r\n" + 
				"            font-size: 26px;\r\n" + 
				"            line-height: 32px;\r\n" + 
				"            padding-top: 15px;\r\n" + 
				"            padding-bottom: 25px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        h2 {\r\n" + 
				"            font-size: 24px;\r\n" + 
				"            line-height: 28px;\r\n" + 
				"            padding-top: 10px;\r\n" + 
				"            padding-bottom: 20px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        h3 {\r\n" + 
				"            font-size: 20px;\r\n" + 
				"            line-height: 24px;\r\n" + 
				"            padding-top: 10px;\r\n" + 
				"            padding-bottom: 5px;\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"        p {\r\n" + 
				"            font-size: 14px;\r\n" + 
				"            line-height: 20px;\r\n" + 
				"            font-family: Arial, sans-serif;\r\n" + 
				"            margin-bottom:15px;\r\n" + 
				"        }\r\n" + 
				"        .spacer{\r\n" + 
				"            padding: 5px 100px 5px;\r\n" + 
				"        }\r\n" + 
				"        .DateSpacer{\r\n" + 
				"            padding:5px 100px 5px;\r\n" + 
				"        }\r\n" + 
				"        .container600 {\r\n" + 
				"            width: 600px;\r\n" + 
				"            max-width: 100%;\r\n" + 
				"        }\r\n" + 
				"        @media all and (max-width: 599px) {\r\n" + 
				"            .container600 {\r\n" + 
				"                width: 100% !important;\r\n" + 
				"            }\r\n" + 
				"            .spacer{\r\n" + 
				"            padding: 5px 35px 5px;\r\n" + 
				"            }\r\n" + 
				"            .DateSpacer{\r\n" + 
				"            padding:5px 35px 5px;\r\n" + 
				"            }\r\n" + 
				"            table td{\r\n" + 
				"                display:block;\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"       @media only screen and (min-width: 1440px) {\r\n" + 
				"           body {\r\n" + 
                			"                font-size: 16px;\r\n" + 
                			"                -ms-text-size-adjust: 100%;\r\n" + 
                			"                webkit-text-size-adjust: 100%;\r\n" + 
				"            }\r\n" + 
				
				"        }\r\n" +
				"\r\n" + 
				"table.email-table {\r\n" + 
				"      border: none;      \r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    table.email-table th {\r\n" + 
				"      background: #008c9e;\r\n" + 
				"      color: #fff;\r\n" + 
				"      padding: 20px;\r\n" + 
				/*"      border-top: 2px solid #dee2e6;\r\n" + */
				"    }\r\n" + 
				"\r\n" + 
				"    table.email-table td {\r\n" + 
				"      padding: 10px;\r\n" + 
				"      border-top: 1px solid #dee2e6;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    table.email-table td strong {\r\n" + 
				"      display: none;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    table.email-table td.primary-secondary-column {\r\n" + 
				"      width: 200px;\r\n" + 
				"    }\r\n" + 
				"    table.email-table td p {\r\n" + 
				"        margin:0px;\r\n" + 
				"        padding:0px;\r\n" + 
				"    margin-left: 35px;\r\n"+
				"      }\r\n" + 
				"    table.email-table tbody tr:nth-child(odd) {\r\n" + 
				"    background-color: #eee !important;\r\n" + 
				"}\r\n" + 
				"a{\r\n" + 
				"  text-decoration:none;\r\n" + 
				"  color:#0082df;\r\n" + 
				"}\r\n" + 
				"a:hover{\r\n" + 
				"  text-decoration:underline;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"    @media (max-width: 768px) {\r\n" + 
				"\r\n" + 
				"      table.email-table td strong,\r\n" + 
				"      table.email-table td p {\r\n" + 
				"        display: inline-block;\r\n" + 
				"        width: 49%;\r\n" + 
				"        vertical-align: bottom;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      table.email-table td {\r\n" + 
				"        display: block;\r\n" + 
				"      }\r\n" + 
				"      \r\n" + 
				"\r\n" + 
				"      table.email-table th {\r\n" + 
				"        display: none;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      table.email-table td.primary-secondary-column {\r\n" + 
				"        width: auto;\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    @media (max-width: 640px) {\r\n" + 
				"\r\n" + 
				"      table.email-table td strong,\r\n" + 
				"      table.email-table td p {\r\n" + 
				"        display: block;\r\n" + 
				"        width: 100%;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"    }"+
				"\r\n" + 
				"    </style>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!--[if gte mso 9]>\r\n" + 
				"        <style>\r\n" + 
				"            .ol {\r\n" + 
				"              width: 100%;\r\n" + 
				"            }\r\n" + 
				"        </style>\r\n" + 
				"    <![endif]-->\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body style=\"background-color:#F4F4F4;\">\r\n" + 
				"    <center>\r\n" + 
				"\r\n" + 
				"        <!--[if gte mso 9]><table width=\"600\" cellpadding=\"0\" cellspacing=\"0\"><tr><td>\r\n" + 
				"                    <![endif]-->\r\n" + 
				"        <table>\r\n" + 
				"            <tr>\r\n" + 
				"                <td align=\"center\" class=\"spacer\" style=\"background-color:#FFFFFF;color:#000000; padding:20px 0px;\" colspan=\"2\">\r\n" + 
				"                    <img alt=\"\" src="+imageUrl+" width=\"210\"  />\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"                    <td class=\"DateSpacer\" style=\"background-color:#5f366e ;color:#fff;text-align:right; height:35px;\"> \r\n" + 
				"                            <p style=\"padding:5px 0px; margin-bottom:0px;color:#fff;\">Date :"+date+" </p>\r\n" + 
				"                    </td>\r\n" + 
				"             </tr>\r\n" + 
				"            <tr>\r\n" + 
				"                <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n" + 
				"\r\n" + 
				"                    <h1>"+title+"</h1>\r\n" + 
				"                    <p>"+salutation+"</p>\r\n" + 
				"\r\n" + 
				"                    <p>"+content+"</p>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" + 
				"                <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n" + 
				"                    <p>"+contentDetails+"</p>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            <tr>\r\n" 	+
				"            </tr>\r\n ";
		for (ScheduleDetailsModel tenderSubFPPMatDetails : scheduleNameList) {
			_log.info(":::ScheduleNumber Email Content::::"+tenderSubFPPMatDetails.getScheduleNumber());
			StringBuilder midTemp= new StringBuilder();
			List<FPPMarketDetailsModel> fppMartModelList = tenderSubFPPMatDetails.getFppMartModelList();
			for (FPPMarketDetailsModel scheduleDetailsModel : fppMartModelList) {
				List<FPPMarket> marketList = FPPMarketLocalServiceUtil
						.findByFPPMarketByMarketId(scheduleDetailsModel.getFppMarketId());
				for (FPPMarket market : marketList) {
				 midTemp.append(" <tr>\r\n" + 
				"                    <td>\r\n" + 
				"                      <p><a href=\"#\" title=\"\">"+market.getGdfGenericCode()+"</a></p>\r\n" + 
				"                    </td>\r\n" + 
				"                    <td>\r\n" + 
		
				"                      <p>"+market.getDosageForm()+"</p>\r\n" + 
				"                    </td>\r\n" + 
				"                    <td>\r\n" + 
			
				"                      <p>"+market.getPrimPackageUnits()+"</p>\r\n" + 
				"                    </td>\r\n" + 
				"                    <td>\r\n" + 
			
				"                      <p>"+market.getSecPackageUnits()+"</p>\r\n" + 
				"                    </td>\r\n" + 
				"                    <td>\r\n" + 
				
				"                      <p>"+market.getFppMarketStatus()+"</p>\r\n" + 
				"                    </td>\r\n" + 
				"                  </tr>") ;
				
				 
				 /* checking for more items for UI purpose*/
				 
				/* midTemp.append(" <tr>\r\n" + 
							"                    <td>\r\n" + 
							"                      <p><a href=\"#\" title=\"\">GdfGenericCode111</a></p>\r\n" + 
							"                    </td>\r\n" + 
							"                    <td>\r\n" + 
					
							"                      <p>DosageForm111</p>\r\n" + 
							"                    </td>\r\n" + 
							"                    <td>\r\n" + 
						
							"                      <p>PrimPackageUnits111</p>\r\n" + 
							"                    </td>\r\n" + 
							"                    <td>\r\n" + 
						
							"                      <p>SecPackageUnits111</p>\r\n" + 
							"                    </td>\r\n" + 
							"                    <td>\r\n" + 
							
							"                      <p>FppMarketStatus111</p>\r\n" + 
							"                    </td>\r\n" + 
							"                  </tr>") ;
				 */
				 
				 /* end*/
				 
				}
				midTemp.ensureCapacity(50);
				
		}
			
			tableBody = tableBody + "<tr> <td style=\"background: #5e356d; color:#ffffff; padding:20px; text-align:left\">\r\n" + 
					"						Schedule Number : "+tenderSubFPPMatDetails.getScheduleNumber()+"</td>\r\n"
					+"\r\n</tr>"
					+ "\r\n" + "\r\n" + 
					 "\r\n" + "\r\n" + "\r\n" + "\r\n" + 
					 "	 <tr>\r\n" + 
			"            <td vertical-align=\"top\">\r\n" + 
			"              <table class=\"email-table\" cellspacing=\"0\" width=\"100%\" cellpadding=\"0\">\r\n" + 
			"                <thead class=\"thead-dark\">\r\n" + 
			"                  <tr>\r\n" + 
		
			"                    <th>GDF Generic Code</th>\r\n" + 
			"                     <th>Dosage form</th>\r\n" + 
			"                     <th style=\"width: 265px;\">No of units per primary packaging type</th>\r\n" + 
			"                     <th style=\"width: 280px;\">No of units per secondary packaging type</th>\r\n" + 
			"                     <th>GDF Approval status</th>\r\n" + 
			"                  </tr>\r\n" + 
			"                </thead>\r\n" + 
			"                <tbody>\r\n" 
			
			+  midTemp + " </tbody>\r\n" + 
					"              </table>\r\n" + 
					"\r\n" + 
					"            </td>\r\n" + 
					"\r\n" + 
					"          </tr>"+	"<tr> <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#FFFFFF;\">\r\n" + 
							"                   <p></p>\r\n" + 
							"                </td>\r\n" + 
							"            </tr>  \r\n" ;
		}
		String lastTemp = " <tr> <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#FFFFFF;\">\r\n" + 
				"                   <p></p>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>  \r\n" + 
				" <tr> <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n" + 
				"                   <p><strong>Best regards</strong>,<br>GDF/IDA procurement teams</p>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>  \r\n" + 
				"            <tr>\r\n" + 
				"            </tr>  \r\n" + 
				"            <tr>\r\n" + 
				"                    <td style=\"padding:15px 0px; background-color:#fff;\"></td>\r\n" + 
				"             </tr>  \r\n" + 
				"            <tr>\r\n" + 
				"                    <td style=\"background-color:#58585A;color:#fff;padding: 10px;text-align:center\"> \r\n" + 
				"                            <p style=\"margin-bottom:0px; font-size:12px;\">Copyrights @"+year+" UNOPS </p>\r\n" + 
				"                    </td>\r\n" + 
				"             </tr>          \r\n" + 
				"        </table>\r\n" + 
				"\r\n" + 
				"        <!--[if gte mso 9]></td></tr></table>\r\n" + 
				"                    <![endif]-->\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>";
		
		return template.concat(tableBody.toString()).concat(lastTemp);
		}

	public static String mailtemplatewithoutTable(String title, String salutation, String content,
			String contentDetails, String buttonContent, String portalUrl) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date caldate = Calendar.getInstance().getTime();
		String date = formatter.format(caldate);
		int year = Year.now().getValue();

		String imageUrl = portalUrl + "/o/StopTBTheme/images/GDF-logo.png";
		String template = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Email Template</title>\r\n" + "    <style>\r\n" + "        html,\r\n"
				+ "        body,\r\n" + "        table,\r\n" + "        tbody,\r\n" + "        tr,\r\n"
				+ "        td,\r\n" + "        div,\r\n" + "        p,\r\n" + "        ul,\r\n" + "        ol,\r\n"
				+ "        li,\r\n" + "        h1,\r\n" + "        h2,\r\n" + "        h3,\r\n" + "        h4,\r\n"
				+ "        h5,\r\n" + "        h6 {\r\n" + "            margin: 0;\r\n" + "            padding: 0;\r\n"
				+ "        }\r\n" + "\r\n" + "        body {\r\n" + "            margin: 0;\r\n"
				+ "            padding: 0;\r\n" + "            font-size: 14px;\r\n" + "            line-height: 0;\r\n"
				+ "            -ms-text-size-adjust: 100%;\r\n" + "            -webkit-text-size-adjust: 100%;\r\n"
				+ "        }\r\n" + "\r\n" + "        table {\r\n" + "            border-spacing: 0;\r\n"
				+ "            mso-table-lspace: 0pt;\r\n" + "            mso-table-rspace: 0pt;\r\n" + "        }\r\n"
				+ "\r\n" + "        table td {\r\n" + "            border-collapse: collapse;\r\n" + "        }\r\n"
				+ "\r\n" + "        .ExternalClass {\r\n" + "            width: 100%;\r\n" + "        }\r\n" + "\r\n"
				+ "        .ExternalClass,\r\n" + "        .ExternalClass p,\r\n" + "        .ExternalClass span,\r\n"
				+ "        .ExternalClass font,\r\n" + "        .ExternalClass td,\r\n"
				+ "        .ExternalClass div {\r\n" + "            line-height: 100%;\r\n" + "        }\r\n" + "\r\n"
				+ "        /* Outermost container in Outlook.com */\r\n" + "\r\n" + "        .ReadMsgBody {\r\n"
				+ "            width: 100%;\r\n" + "        }\r\n" + "\r\n" + "        img {\r\n"
				+ "            -ms-interpolation-mode: bicubic;\r\n" + "        }\r\n" + "\r\n" + "        h1,\r\n"
				+ "        h2,\r\n" + "        h3,\r\n" + "        h4,\r\n" + "        h5,\r\n" + "        h6 {\r\n"
				+ "            font-family: Arial;\r\n" + "            font-weight:normal;\r\n" + "        }\r\n"
				+ "\r\n" + "        h1 {\r\n" + "            font-size: 26px;\r\n"
				+ "            line-height: 32px;\r\n" + "            padding-top: 15px;\r\n"
				+ "            padding-bottom: 25px;\r\n" + "        }\r\n" + "\r\n" + "        h2 {\r\n"
				+ "            font-size: 24px;\r\n" + "            line-height: 28px;\r\n"
				+ "            padding-top: 10px;\r\n" + "            padding-bottom: 20px;\r\n" + "        }\r\n"
				+ "\r\n" + "        h3 {\r\n" + "            font-size: 20px;\r\n"
				+ "            line-height: 24px;\r\n" + "            padding-top: 10px;\r\n"
				+ "            padding-bottom: 5px;\r\n" + "        }\r\n" + "\r\n" + "        p {\r\n"
				+ "            font-size: 14px;\r\n" + "            line-height: 20px;\r\n"
				+ "            font-family: Arial, sans-serif;\r\n" + "            margin-bottom:15px;\r\n"
				+ "        }\r\n" + "        .spacer{\r\n" + "            padding: 5px 100px 5px;\r\n" + "        }\r\n"
				+ "        .DateSpacer{\r\n" + "            padding:5px 100px 5px;\r\n" + "        }\r\n"
				+ "        .container600 {\r\n" + "            width: 600px;\r\n" + "            max-width: 100%;\r\n"
				+ "        }\r\n" + "        @media all and (max-width: 599px) {\r\n"
				+ "            .container600 {\r\n" + "                width: 100% !important;\r\n"
				+ "            }\r\n" + "            .spacer{\r\n" + "            padding: 5px 35px 5px;\r\n"
				+ "            }\r\n" + "            .DateSpacer{\r\n" + "            padding:5px 35px 5px;\r\n"
				+ "            }\r\n" + "            table td{\r\n" + "                display:block;\r\n"
				+ "            }\r\n" + "        }\r\n" + "       @media only screen and (min-width: 1440px) {\r\n"
				+ "           body {\r\n" + "                font-size: 16px;\r\n"
				+ "                -ms-text-size-adjust: 100%;\r\n"
				+ "                webkit-text-size-adjust: 100%;\r\n" + "            }\r\n" +

				"        }\r\n" + "\r\n" + "\r\n" + "    </style>\r\n" + "\r\n" + "\r\n" + "    <!--[if gte mso 9]>\r\n"
				+ "        <style>\r\n" + "            .ol {\r\n" + "              width: 100%;\r\n"
				+ "            }\r\n" + "        </style>\r\n" + "    <![endif]-->\r\n" + "\r\n" + "</head>\r\n"
				+ "\r\n" + "<body style=\"background-color:#F4F4F4;\">\r\n" + "    <center>\r\n" + "\r\n"
				+ "        <!--[if gte mso 9]><table width=\"600\" cellpadding=\"0\" cellspacing=\"0\"><tr><td>\r\n"
				+ "                    <![endif]-->\r\n" + "        <table>\r\n" + "            <tr>\r\n"
				+ "                <td align=\"center\" class=\"spacer\" style=\"background-color:#FFFFFF;color:#000000; padding:20px 0px;\" colspan=\"2\">\r\n"
				+ "                    <img alt=\"\" src=" + imageUrl + " width=\"210\"  />\r\n"
				+ "                </td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "                    <td class=\"DateSpacer\" style=\"background-color:#5f366e ;color:#fff;text-align:right; height:35px;\"> \r\n"
				+ "                            <p style=\"padding:5px 0px; margin-bottom:0px;color:#fff;\">Date :"
				+ date + " </p>\r\n" + "                    </td>\r\n" + "             </tr>\r\n"
				+ "            <tr>\r\n"
				+ "                <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n" + "\r\n"
				+ "                    <h1>" + title + "</h1>\r\n" + "                    <p>" + salutation + "</p>\r\n"
				+ "\r\n" + "                    <p>" + content + "</p>\r\n" + "                </td>\r\n"
				+ "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n"
				+ "                    <p>" + contentDetails + "</p>\r\n" + "                </td>\r\n"
				+ "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td class=\"spacer\" style=\"background-color:#FFFFFF;color:#58585A;\">\r\n"
				+ "                   <p><strong>Best regards</strong>,<br>GDF/IDA procurement teams</p>\r\n"
				+ "                </td>\r\n" + "            </tr>  \r\n" + "            <tr>\r\n"
				+ "            </tr>  \r\n" + "            <tr>\r\n"
				+ "                    <td style=\"padding:15px 0px; background-color:#fff;\"></td>\r\n"
				+ "             </tr>  \r\n" + "            <tr>\r\n"
				+ "                    <td style=\"background-color:#58585A;color:#fff;padding: 10px;text-align:center\"> \r\n"
				+ "                            <p style=\"margin-bottom:0px; font-size:12px;\">Copyrights @" + year
				+ " UNOPS </p>\r\n" + "                    </td>\r\n" + "             </tr>          \r\n"
				+ "        </table>\r\n" + "\r\n" + "        <!--[if gte mso 9]></td></tr></table>\r\n"
				+ "                    <![endif]-->\r\n" + "\r\n" + "</body>\r\n" + "\r\n" + "</html>";

		return template;
	}

	

}