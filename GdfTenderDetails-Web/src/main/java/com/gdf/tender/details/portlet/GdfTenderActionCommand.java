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
package com.gdf.tender.details.portlet;

import static com.gdf.tender.details.constants.GdfTenderConstants.ACTION_CREATE_TENDER_DETAILS;
import static com.gdf.tender.details.constants.GdfTenderConstants.ACTION_UPDATE_TENDER_DETAILS;
import static com.gdf.tender.details.constants.GdfTenderConstants.SUCCESS;
import static com.gdf.tender.details.constants.GdfTenderConstants.UPDATESUCCESS;
import static com.gdf.tender.details.constants.GdfTenderConstants.VIEW_CREATE_TENDER_PAGE;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.gdf.common.model.Product;
import com.gdf.common.service.ProductLocalServiceUtil;
import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil;
import com.gdf.tender.details.bean.ScheduleDetailsModel;
import com.gdf.tender.details.bean.TenderItemDetailsModel;
import com.gdf.tender.details.constants.GdfTenderDetailsWebPortletKeys;
import com.gdf.tender.details.util.GdfTenderDetailUtil;
import com.gdf.tender.model.ProductCategories;
import com.gdf.tender.model.TenderSchedules;
import com.gdf.tender.service.ProductCategoriesLocalServiceUtil;
import com.gdf.tender.service.TenderSchedulesLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + GdfTenderDetailsWebPortletKeys.GDFTENDERDETAILSWEB,
		"mvc.command.name=actionTenderDetails_Info" }, service = MVCActionCommand.class)
public class GdfTenderActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(GdfTenderActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {


		String cmdName = ParamUtil.getString(actionRequest, "cmd");
		_log.info("##cmdName mvc action class : " + cmdName);
		try {
			if (Objects.equals(cmdName, ACTION_CREATE_TENDER_DETAILS)) {
				createTender(actionRequest, actionResponse);
				SessionMessages.add(actionRequest, "Tender details added successfully");

			} else if (Objects.equals(cmdName, ACTION_UPDATE_TENDER_DETAILS)) {

				updateTenderDetails(actionRequest, actionResponse);
				SessionMessages.add(actionRequest, "Tender details updated successfully");
			}
		} catch (Exception e) {
			_log.error("Exception rendering in Jsp page", e);
		}

	}

	public void createTender(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		_log.info("GDF tender details create method");

		ThemeDisplay themedisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		User user = (User)actionRequest.getAttribute(WebKeys.USER);
		
		String publicationTimeDate = ParamUtil.getString(actionRequest, "publicationDate");
		String deadLineTimeDate = ParamUtil.getString(actionRequest, "deadlineForTechBidsSub");
		SimpleDateFormat formattedNewDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//formattedNewDate.setTimeZone(TimeZone.getTimeZone("CET"));
		//String newTimeDate;
		Date publicationDate = null;
		Date deadlineForTechBidsSub = null;
		try {
			publicationDate = formattedNewDate.parse(publicationTimeDate.replace("T"," "));
			deadlineForTechBidsSub = formattedNewDate.parse(deadLineTimeDate.replace("T"," "));
            // newTimeDate= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date1);
            _log.info(":::publicationDate:::"+publicationDate+"::deadlineForTechBidsSub:::"+deadlineForTechBidsSub);
        }catch (Exception e){
            e.printStackTrace();
        }
		

		//SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Long tenderRefID = ParamUtil.getLong(actionRequest, "tenderRefID");
		_log.info("============tenderRefID in add method===========" + tenderRefID);
		String tenderReferenceNumber = ParamUtil.getString(actionRequest, "tenderReferenceNumber");
		String productCategory = ParamUtil.getString(actionRequest, "productCategory");
		_log.info(":::::productCategory in Action ::::::" + productCategory);
		String title = ParamUtil.getString(actionRequest, "title");
		String method = ParamUtil.getString(actionRequest, "method");
		String tenderStatus = ParamUtil.getString(actionRequest, "tenderStatus");
		//Date publicationDate = ParamUtil.getDate(actionRequest, "publicationDate", formattedDate);
		//Date publicationDate = pubTimeDate;
		//Date deadlineForTechBidsSub = ParamUtil.getDate(actionRequest, "deadlineForTechBidsSub", formattedDate);
		//Date deadlineForTechBidsSub = deadTechTimeDate;
		_log.info(":::::deadlineForTechBidsSub in Action ::::::" + deadlineForTechBidsSub);
		String tenderScheduleJson = ParamUtil.getString(actionRequest, "tenderScheduleJsonString");
		_log.info(":::::tenderScheduleJson::::::" + tenderScheduleJson);

		List<ScheduleDetailsModel> schedularJsonList = GdfTenderDetailUtil
				.readScheduleDetailsFromJsonString(tenderScheduleJson);
		_log.info(":::::schedularJsonList::::::" + schedularJsonList);
		
		GDFTenderDetails gdfTenderDetails;

		try {
			gdfTenderDetails = GDFTenderDetailsLocalServiceUtil
					.getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);

			
				_log.info("duplicate value for tender Reference Number");

				
				
				actionResponse.setRenderParameter("mvcPath", VIEW_CREATE_TENDER_PAGE);
				actionRequest.setAttribute("tenderReferenceNumber", tenderReferenceNumber);
				actionRequest.setAttribute("productCategory", productCategory);
				actionRequest.setAttribute("title", title);
				actionRequest.setAttribute("tenderStatus", tenderStatus);
				actionRequest.setAttribute("publicationDate", publicationDate);
				actionRequest.setAttribute("deadlineForTechBidsSub", deadlineForTechBidsSub);
				actionRequest.setAttribute("method", method);
				List<ProductCategories> prdCategoryList = ProductCategoriesLocalServiceUtil
						.getProductCategorieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				actionRequest.setAttribute("prdCategoryList", prdCategoryList);
				
				List<Product> productGenricList = ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				actionRequest.setAttribute("productGenricList", productGenricList);

				List<TenderSchedules> tenderschedList = TenderSchedulesLocalServiceUtil.getTenderScheduleses(QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

				actionRequest.setAttribute("tenderschedList", tenderschedList);
				actionRequest.setAttribute("schedularJsonList", schedularJsonList);
				
				actionRequest.setAttribute("error", true);
				
			/*	SessionErrors.add(actionRequest, "duplicate-entry");
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);*/
				return;
				
		} catch (NoSuchGDFTenderDetailsException e) {
			
			_log.info(e.getMessage());

			try {
				gdfTenderDetails = GDFTenderDetailsLocalServiceUtil
						.createGDFTenderDetails(CounterLocalServiceUtil.increment());

				gdfTenderDetails.setTenderRefID(tenderRefID);
				gdfTenderDetails.setTenderReferenceNumber(tenderReferenceNumber);
				gdfTenderDetails.setTenderStatus(tenderStatus);
				gdfTenderDetails.setTitle(title);
				gdfTenderDetails.setMethod(method);
				gdfTenderDetails.setProductCategory(productCategory);
				gdfTenderDetails.setUserId(user.getUserId());
				gdfTenderDetails.setUserName(user.getScreenName());
				gdfTenderDetails.setPublicationDate(publicationDate);
				gdfTenderDetails.setDeadlineForTechBidsSub(deadlineForTechBidsSub);
				//gdfTenderDetails.setCreateDate(gdfTenderDetails.getCreateDate());
				//gdfTenderDetails.setModifiedDate(gdfTenderDetails.getModifiedDate());

				GDFTenderDetailsLocalServiceUtil.addGDFTenderDetails(gdfTenderDetails);
			} catch (Exception ex) {
				_log.info("error in adding gdf tender details" + ex.getMessage());

			}

			actionRequest.setAttribute("successMessage", "Tender details has been successfully added");
			_log.info("tender details successfuly created " + "by" + themedisplay.getUser().getScreenName());

		}

		

		for (ScheduleDetailsModel scheduleDetailsModel : schedularJsonList) {

			List<TenderItemDetailsModel> tenderItemList = scheduleDetailsModel.getTenderItemDetailsModelList();
			_log.info(":::::tenderItemList::::::" + tenderItemList);

			for (TenderItemDetailsModel tenderItemDetailsList : tenderItemList) {
				GDFTenderScheduleItem gdfTenderScheduleItem = GDFTenderScheduleItemLocalServiceUtil
						.createGDFTenderScheduleItem(CounterLocalServiceUtil.increment());

				gdfTenderScheduleItem.setGdfGenericCode(tenderItemDetailsList.getGdfGenericCode());
				gdfTenderScheduleItem.setTenderItemNumber(tenderItemDetailsList.getTenderItemNumber());
				gdfTenderScheduleItem.setGeneralDescription(tenderItemDetailsList.getGeneralDescription());
				gdfTenderScheduleItem.setPrimaryPackaging(tenderItemDetailsList.getPrimaryPackaging());
				gdfTenderScheduleItem.setSecondaryPackaging(tenderItemDetailsList.getSecondaryPackaging());

				gdfTenderScheduleItem.setScheduleNumber(scheduleDetailsModel.getScheduleNumber());
				gdfTenderScheduleItem.setScheduleName(scheduleDetailsModel.getScheduleName());
				gdfTenderScheduleItem.setPatientTarget(scheduleDetailsModel.getPatientTarget());
				gdfTenderScheduleItem.setTenderReferenceNumber(tenderReferenceNumber);
				gdfTenderScheduleItem.setUserId(user.getUserId());
				gdfTenderScheduleItem.setUserName(user.getScreenName());
				
				GDFTenderScheduleItemLocalServiceUtil.addGDFTenderScheduleItem(gdfTenderScheduleItem);
			}
		}

		SessionMessages.add(actionRequest, "success");
		actionRequest.setAttribute("successMsg", "GDF Tender details has been successfully added");
		actionResponse.setRenderParameter("mvcPath", SUCCESS);
		actionResponse.setRenderParameter("tenderRefNumber", tenderReferenceNumber);
		_log.info("GDF tender details added successfully!!!");

	}

	public void updateTenderDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		_log.info("==================In Update Method===============");

		//SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		
		User user = (User)actionRequest.getAttribute(WebKeys.USER);
		
		String publicationTimeDate = ParamUtil.getString(actionRequest, "publicationDate");
		String deadLineTimeDate = ParamUtil.getString(actionRequest, "deadlineForTechBidsSub");
		SimpleDateFormat formattedNewDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//formattedNewDate.setTimeZone(TimeZone.getTimeZone("CET"));
		//String newTimeDate;
		Date publicationDate = null;
		Date deadlineForTechBidsSub = null;
		try {
			publicationDate = formattedNewDate.parse(publicationTimeDate.replace("T"," "));
			deadlineForTechBidsSub = formattedNewDate.parse(deadLineTimeDate.replace("T"," "));;
            // newTimeDate= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date1);
            _log.info(":::publicationDate in update method:::"+publicationDate+"::deadlineForTechBidsSub in update method:::"+deadlineForTechBidsSub);
        }catch (Exception e){
            e.printStackTrace();
        }

		long tenderItemRefIdFromJson = ParamUtil.getLong(actionRequest, "tenderItemRefId", GetterUtil.DEFAULT_LONG);
		_log.info("============tenderItemRefIdFromJson===========" + tenderItemRefIdFromJson);
		String tenderReferenceNumber = ParamUtil.getString(actionRequest, "tenderReferenceNumber");
		_log.info("============tenderReferenceNumber in update ===========" + tenderReferenceNumber+":::userId:::"+user.getUserId());
		String productCategory = ParamUtil.getString(actionRequest, "productCategory", GetterUtil.DEFAULT_STRING);
		String title = ParamUtil.getString(actionRequest, "title", GetterUtil.DEFAULT_STRING);
		String method = ParamUtil.getString(actionRequest, "method", GetterUtil.DEFAULT_STRING);
		String tenderStatus = ParamUtil.getString(actionRequest, "tenderStatus", GetterUtil.DEFAULT_STRING);
		//Date publicationDate = ParamUtil.getDate(actionRequest, "publicationDate", formattedDate);
		//Date deadlineForTechBidsSub = ParamUtil.getDate(actionRequest, "deadlineForTechBidsSub", formattedDate);

		String updatedTenderScheduleJson = ParamUtil.getString(actionRequest, "tenderScheduleJsonString");
		_log.info(":::::updatedTenderScheduleJson::::::" + updatedTenderScheduleJson);

		GDFTenderDetails gdfTenderDetails = null;
		try {

			gdfTenderDetails = GDFTenderDetailsLocalServiceUtil
					.getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);
		} catch (Exception e) {
			_log.error(e.getCause(), e);
		}

		if (Validator.isNotNull(gdfTenderDetails)) {
			gdfTenderDetails.setTenderReferenceNumber(tenderReferenceNumber);
			gdfTenderDetails.setProductCategory(productCategory);
			gdfTenderDetails.setTitle(title);
			gdfTenderDetails.setMethod(method);
			gdfTenderDetails.setTenderStatus(tenderStatus);
			gdfTenderDetails.setPublicationDate(publicationDate);
			gdfTenderDetails.setDeadlineForTechBidsSub(deadlineForTechBidsSub);
			gdfTenderDetails.setProductCategory(productCategory);
			gdfTenderDetails.setUserId(user.getUserId());
			gdfTenderDetails.setUserName(user.getScreenName());
			
			GDFTenderDetailsLocalServiceUtil.updateGDFTenderDetails(gdfTenderDetails);

			List<GDFTenderScheduleItem> gdfTenderScheduleItemList = GDFTenderScheduleItemLocalServiceUtil
					.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);

			Set<ScheduleDetailsModel> dbScheduleList = GdfTenderDetailUtil
					.prepareScheduleDetails(gdfTenderScheduleItemList);
			_log.info(":::::dbScheduleList in  update::::::" + dbScheduleList);

			List<ScheduleDetailsModel> jsonScheduleList = GdfTenderDetailUtil
					.readScheduleDetailsFromJsonString(updatedTenderScheduleJson);
			_log.info(":::::schedularJsonList  in  update::::::" + jsonScheduleList);

			List<TenderItemDetailsModel> completeJsonTenderItemsList = GdfTenderDetailUtil
					.getCompleteJsonScheduleItems(jsonScheduleList);

			// Adding the new schedule and updating the existing records
			jsonScheduleList.forEach(js -> {
				List<TenderItemDetailsModel> tenderItems = js.getTenderItemDetailsModelList();
				tenderItems = (tenderItems == null || tenderItems.isEmpty()) ? Collections.emptyList() : tenderItems;

				tenderItems.forEach(ti -> {
					long refId = ti.getTenderItemRefId();
					_log.info("--------Adding || Updating --- ti refId -------" + refId);

					if (refId == 0) {
						_log.info("--------Adding tender Items-------");
						try {
							GdfTenderDetailUtil.addTenderSchedule(ti, js.getScheduleNumber(), js.getScheduleName(),
									js.getPatientTarget(), tenderReferenceNumber, user);
						} catch (PortalException e) {
							_log.error(":::Unable to add tender Item:::" + js.getScheduleNumber(), e);
							SessionErrors.add(actionRequest, "Unable to add tender Item");
							return;
						}

					} else {
						_log.info("--------Updating tender Items-------");
						try {
							GdfTenderDetailUtil.updateTenderItem(ti, js.getScheduleNumber(), js.getScheduleName(),
									js.getPatientTarget(), user);
						} catch (PortalException e) {
							_log.error(":::Unable to update tender Item:::" + js.getScheduleNumber(), e);
							SessionErrors.add(actionRequest, "Unable to update tender Item");
							//actionRequest.setAttribute("updateError", true);
							return;
						}
					}

				});

			});

			// Deleting the schedules and tenderItems
			gdfTenderScheduleItemList.forEach(dbs -> {
				long dbRefId = dbs.getTenderItemRefID();
				_log.info(":::::dbRefId::::" + dbRefId);

				if (GdfTenderDetailUtil.isDBTenderItemNotPresentinJsonSchedulesList(completeJsonTenderItemsList,
						dbRefId)) {

					try {
						_log.info("::::DELETING dbRefId:::" + dbRefId);
						GDFTenderScheduleItemLocalServiceUtil.deleteGDFTenderScheduleItem(dbRefId);
					} catch (PortalException e) {
						_log.error(":::Unable to delete tender Item:::", e);
					}
				}

			});
			actionResponse.setRenderParameter("mvcPath", UPDATESUCCESS);
			actionResponse.setRenderParameter("tenderRefNumber", tenderReferenceNumber);
		}
		
		
	}

}