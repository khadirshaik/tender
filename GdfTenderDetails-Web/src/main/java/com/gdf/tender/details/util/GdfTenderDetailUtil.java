package com.gdf.tender.details.util;

import static com.gdf.tender.details.constants.GdfTenderConstants.GDF_ROLE;
import static com.gdf.tender.details.constants.GdfTenderConstants.GSO_ROLE;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil;
import com.gdf.tender.details.bean.ScheduleDetailsModel;
import com.gdf.tender.details.bean.TenderItemDetailsModel;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

public class GdfTenderDetailUtil {

	private static Log _log = LogFactoryUtil.getLog(GdfTenderDetailUtil.class);

	public static Set<ScheduleDetailsModel> prepareScheduleDetails(
			List<GDFTenderScheduleItem> gdfTenderScheduleItemList) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setScheduleName(si.getScheduleName());
			scheduleDetailsModel.setPatientTarget(si.getPatientTarget());

			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setTenderItemDetailsModelList(
					getTenderItemsByScheduleNumber(gdfTenderScheduleItemList, sd.getScheduleNumber()));
		});

		return scheduleDetailsList;

	}

	public static List<TenderItemDetailsModel> getTenderItemsByScheduleNumber(
			List<GDFTenderScheduleItem> gdfScheduleItemList, long scheduleNumber) {
		List<TenderItemDetailsModel> tenderItemList = new ArrayList<>();

		List<GDFTenderScheduleItem> gdfItemsList = gdfScheduleItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfItemsList.forEach(ti -> {
			TenderItemDetailsModel tenderItem = new TenderItemDetailsModel();
			tenderItem.setTenderItemNumber(ti.getTenderItemNumber());
			tenderItem.setGdfGenericCode(ti.getGdfGenericCode());
			tenderItem.setGeneralDescription(ti.getGeneralDescription());
			tenderItem.setPrimaryPackaging(ti.getPrimaryPackaging());
			tenderItem.setSecondaryPackaging(ti.getSecondaryPackaging());
			tenderItem.setTenderItemRefId(ti.getTenderItemRefID());

			tenderItemList.add(tenderItem);

		});

		_log.info("::::tenderItemList in getTenderItemsByScheduleNumber method:::::" + tenderItemList);
		return tenderItemList;
	}
	
	public static List<TenderItemDetailsModel> getCompleteJsonScheduleItems(List<ScheduleDetailsModel> scheduleDetailsList) {
		List<TenderItemDetailsModel> tenderItemsList = new ArrayList<>();
		
		scheduleDetailsList.forEach(sl -> {
			
			tenderItemsList.addAll(sl.getTenderItemDetailsModelList());
		});
		
		
		return tenderItemsList;
	}

	public static List<ScheduleDetailsModel> readScheduleDetailsFromJsonString(String jsonString) {

		List<ScheduleDetailsModel> scheduleDetailsList = new ArrayList<>();

		JSONArray schedularJobJsonArray = null;
		try {
			schedularJobJsonArray = JSONFactoryUtil.createJSONArray(jsonString);
		} catch (JSONException e) {
			_log.error("Not able to create JSONObject for otherInfo, Error: " + e.getMessage());
			return scheduleDetailsList;
		}

		if (schedularJobJsonArray == null)
			return scheduleDetailsList;

		Iterator<?> iterator = schedularJobJsonArray.iterator();
		while (iterator.hasNext()) {

			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();
			List<TenderItemDetailsModel> tenderItemList = new ArrayList<>();

			JSONObject jsonObj = (JSONObject) iterator.next();
			long scheduleNumber = jsonObj.getLong("schduleNumber");
			String scheduleName = jsonObj.getString("scheduleName");
			String patientTarget = jsonObj.getString("patientTarget");
			_log.info("::::schduleNumber:::" + jsonObj.getString("schduleNumber"));
			scheduleDetailsModel.setScheduleNumber(scheduleNumber);
			scheduleDetailsModel.setScheduleName(scheduleName);
			scheduleDetailsModel.setPatientTarget(patientTarget);

			JSONArray tenderItemsJsonArray = jsonObj.getJSONArray("tenderItems");

			Iterator<?> itemsIterator = tenderItemsJsonArray.iterator();
			while (itemsIterator.hasNext()) {
				TenderItemDetailsModel tenderItemDetailsModel = new TenderItemDetailsModel();

				JSONObject itemJsonObj = (JSONObject) itemsIterator.next();
				long jsonTenderRefId = itemJsonObj.getLong("tenderItemRefId", 0L);

				tenderItemDetailsModel.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));
				tenderItemDetailsModel.setGdfGenericCode(itemJsonObj.getString("gdfGenericCode"));
				tenderItemDetailsModel.setGeneralDescription(itemJsonObj.getString("generalDescripton"));
				tenderItemDetailsModel.setPrimaryPackaging(itemJsonObj.getString("primaryPackaging"));
				tenderItemDetailsModel.setSecondaryPackaging(itemJsonObj.getString("secondaryPackaging"));
				tenderItemDetailsModel.setTenderItemRefId(jsonTenderRefId);

				tenderItemList.add(tenderItemDetailsModel);
			}
			scheduleDetailsModel.setTenderItemDetailsModelList(tenderItemList);
			scheduleDetailsList.add(scheduleDetailsModel);
		}

		return scheduleDetailsList;
	}

	public static void updateTenderItem(TenderItemDetailsModel tenderItemModel, long scheduleNumber,
			String scheduleName, String patientTarget, User user) throws PortalException {

		long refId = tenderItemModel.getTenderItemRefId();

		_log.info("::::::In updateTenderItem method scheduleNumber::::::" + scheduleNumber + ", " + scheduleName+ ":::userId::"+user.getUserId());
		_log.info("::::tenderItemModel:::" + tenderItemModel.toString());
		
		GDFTenderScheduleItem updatedGdfTenderScheduleItem = GDFTenderScheduleItemLocalServiceUtil
				.getGDFTenderScheduleItem(refId);

		updatedGdfTenderScheduleItem.setGdfGenericCode(tenderItemModel.getGdfGenericCode());
		updatedGdfTenderScheduleItem.setTenderItemNumber(tenderItemModel.getTenderItemNumber());
		updatedGdfTenderScheduleItem.setGeneralDescription(tenderItemModel.getGeneralDescription());
		updatedGdfTenderScheduleItem.setPrimaryPackaging(tenderItemModel.getPrimaryPackaging());
		updatedGdfTenderScheduleItem.setSecondaryPackaging(tenderItemModel.getSecondaryPackaging());

		updatedGdfTenderScheduleItem.setScheduleNumber(scheduleNumber);
		updatedGdfTenderScheduleItem.setScheduleName(scheduleName);
		updatedGdfTenderScheduleItem.setPatientTarget(patientTarget);
		updatedGdfTenderScheduleItem.setUserId(user.getUserId());
		updatedGdfTenderScheduleItem.setUserName(user.getScreenName());

		GDFTenderScheduleItemLocalServiceUtil.updateGDFTenderScheduleItem(updatedGdfTenderScheduleItem);

	}

	public static void addTenderSchedule(TenderItemDetailsModel tenderItemModel, long scheduleNumber,
			String scheduleName, String patientTarget, String tenderReferenceNumber, User user) throws PortalException {

		_log.info("::::::In addTenderSchedule method scheduleNumber::::::" + scheduleNumber + ", " + scheduleName + ", "
				+ tenderReferenceNumber+":::userId:::"+user.getUserId());

		GDFTenderScheduleItem gdfTenderScheduleItem = GDFTenderScheduleItemLocalServiceUtil
				.createGDFTenderScheduleItem(CounterLocalServiceUtil.increment());

		gdfTenderScheduleItem.setGdfGenericCode(tenderItemModel.getGdfGenericCode());
		gdfTenderScheduleItem.setTenderItemNumber(tenderItemModel.getTenderItemNumber());
		gdfTenderScheduleItem.setGeneralDescription(tenderItemModel.getGeneralDescription());
		gdfTenderScheduleItem.setPrimaryPackaging(tenderItemModel.getPrimaryPackaging());
		gdfTenderScheduleItem.setSecondaryPackaging(tenderItemModel.getSecondaryPackaging());

		gdfTenderScheduleItem.setScheduleNumber(scheduleNumber);
		gdfTenderScheduleItem.setScheduleName(scheduleName);
		gdfTenderScheduleItem.setPatientTarget(patientTarget);
		gdfTenderScheduleItem.setTenderReferenceNumber(tenderReferenceNumber);
		gdfTenderScheduleItem.setUserId(user.getUserId());
		gdfTenderScheduleItem.setUserName(user.getScreenName());
		
		_log.info(":::::gdfTenderScheduleItem added::::::");

		GDFTenderScheduleItemLocalServiceUtil.addGDFTenderScheduleItem(gdfTenderScheduleItem);
	}

	public static boolean isDBTenderItemNotPresentinJsonSchedulesList(List<TenderItemDetailsModel> tenderItems,
			long dbTenderRefId) {

		TenderItemDetailsModel tenderItemDetails = tenderItems.stream()
				.filter(ti -> Objects.equals(ti.getTenderItemRefId(), dbTenderRefId)).findAny().orElse(null);
		
		return tenderItemDetails == null;

	}
	
/*private static List<String> getGSOUserList() {

		// collect email Ids of GDF Role
		long roleId = getRoleIdByName(GSO_ROLE);
		Set<String> userList = new HashSet<String>();
		List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);

		for (User user : users) {
			userList.add(user.getEmailAddress());
		}
		_log.info(":::userList:::" + userList);
		List<String> resultList = new ArrayList<String>();
		resultList.addAll(userList);
		
		return resultList;
	}*/

private static long getRoleIdByName(String roleName) {
		if (roleName != null && !roleName.isEmpty()) {
			for (Role role : RoleLocalServiceUtil.getRoles(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				if (role.getName().equals(roleName)) {
					return role.getRoleId();
				}
			}
		}
		return -1;
}

public static boolean checkIfUserhasGSORole(User user) {
	
	return RoleLocalServiceUtil.hasUserRole(user.getUserId(), getRoleIdByName(GSO_ROLE));
	
}
public static boolean checkIfUserhasGDFRole(User user) {
	
	return RoleLocalServiceUtil.hasUserRole(user.getUserId(), getRoleIdByName(GDF_ROLE));
	
}
public static LocalDateTime cetToIst(LocalDateTime timeInCet) {
	ZonedDateTime istTimeZoned = ZonedDateTime.of(timeInCet, ZoneId.of("CET"));
	return istTimeZoned.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
}

}
