package com.gdf.tender.submission.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;

import com.gdf.fpp.market.model.FPPMarket;
import com.gdf.fpp.market.service.FPPMarketLocalServiceUtil;
import com.gdf.fpp.reg.model.FPPRegistration;
import com.gdf.fpp.reg.service.FPPRegistrationLocalServiceUtil;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;
import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalServiceUtil;
import com.gdf.tender.submission.bean.FPPMarketDetailsModel;
import com.gdf.tender.submission.bean.FPPRegDetailsModel;
import com.gdf.tender.submission.bean.ScheduleDetailsModel;
import com.gdf.tender.submission.bean.TenderItemDetailsModel;
import com.gdf.tender.submission.constants.GdfTenderSubmissionConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public class GdfTenderSubmissionDetailUtil {

	private static Log _log = LogFactoryUtil.getLog(GdfTenderSubmissionDetailUtil.class);

	public static Set<ScheduleDetailsModel> prepareScheduleDetails(
			List<GDFTenderScheduleItem> gdfTenderScheduleItemList) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setScheduleName(si.getScheduleName());
			scheduleDetailsModel.setPatientTarget(si.getPatientTarget());
			scheduleDetailsModel.setUserId(si.getUserId());

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
			tenderItem.setTenderReferenceNumber(ti.getTenderReferenceNumber());
			tenderItem.setTenderItemRefId(ti.getTenderItemRefID());
			tenderItemList.add(tenderItem);

		});

		_log.info("::::tenderItemList in getTenderItemsByScheduleNumber method:::::" + tenderItemList);
		return tenderItemList;
	}

	public static Set<ScheduleDetailsModel> prepareFPPMartDetails(
			List<GDFTenderScheduleItem> gdfTenderScheduleItemList, long userId) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppMartModelList(getTendersByFPPMartGenCode(gdfTenderScheduleItemList, sd.getScheduleNumber(), userId));
		});

		return scheduleDetailsList;

	}

	public static List<FPPMarketDetailsModel> getTendersByFPPMartGenCode(
			List<GDFTenderScheduleItem> gdfScheduleItemList, long scheduleNumber, long userId) {
		List<FPPMarketDetailsModel> fppMarGenCodeList = new ArrayList<>();

		List<GDFTenderScheduleItem> gdfItemsList = gdfScheduleItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfItemsList.forEach(ti -> {

			List<FPPMarket> fppMarketList = FPPMarketLocalServiceUtil.findByFPPMarketBySIdAndGDFCode(userId,
					ti.getGdfGenericCode());
			// _log.info("::::in fppMarketList size() method:::::" + fppMarketList.size());
			for (FPPMarket fppMarketModel : fppMarketList) {
				if (Objects.equals(ti.getGdfGenericCode(), fppMarketModel.getGdfGenericCode()) && Objects.equals(userId, fppMarketModel.getSupplierId())) {

					try {
						FPPMarket fppMarketCompleteList = FPPMarketLocalServiceUtil
								.getFPPMarket(fppMarketModel.getFppMarketID());
						_log.info(":::::fppMarketList::size::" + fppMarketList.size());
						FPPMarketDetailsModel fppMartGenCodeDetails = new FPPMarketDetailsModel();

						fppMartGenCodeDetails.setTenderReferenceNumber(ti.getTenderReferenceNumber());
						fppMartGenCodeDetails.setTenderItemRefId(ti.getTenderItemRefID());
						fppMartGenCodeDetails.setTenderItemNumber(ti.getTenderItemNumber());
						fppMartGenCodeDetails.setDosageForm(fppMarketCompleteList.getDosageForm());
						fppMartGenCodeDetails
								.setNoOfPrimaryPackaging(String.valueOf(fppMarketCompleteList.getPrimPackageUnits()));
						fppMartGenCodeDetails
								.setNoOfSecondaryPackaging(String.valueOf(fppMarketCompleteList.getSecPackageUnits()));
						fppMartGenCodeDetails.setFppMartStatus(fppMarketCompleteList.getFppMarketStatus());
						fppMartGenCodeDetails.setGdfGenericCode(fppMarketCompleteList.getGdfGenericCode());
						fppMartGenCodeDetails.setFppMarketId(fppMarketModel.getFppMarketID());

						fppMarGenCodeList.add(fppMartGenCodeDetails);

					} catch (PortalException e) {
						e.printStackTrace();
					}

				}

			}

		});

		_log.info("::::fppMarGenCodeList size in  method:::::" + fppMarGenCodeList.size());
		return fppMarGenCodeList;
	}

	public static Set<ScheduleDetailsModel> prepareEditFPPMartDetails(
			List<GDFTenderScheduleItem> gdfTenderScheduleItemList, long userId) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppMartModelList(getTendersByEditFPPMartGenCode(gdfTenderScheduleItemList, sd.getScheduleNumber(),userId));
		});

		return scheduleDetailsList;

	}

	public static List<FPPMarketDetailsModel> getTendersByEditFPPMartGenCode(
			List<GDFTenderScheduleItem> gdfScheduleItemList, long scheduleNumber, long userId) {
		List<FPPMarketDetailsModel> fppMarGenCodeList = new ArrayList<>();

		List<GDFTenderScheduleItem> gdfItemsList = gdfScheduleItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfItemsList.forEach(ti -> {

			List<FPPMarket> fppMarketList = FPPMarketLocalServiceUtil.findByFPPMarketBySIdAndGDFCode(userId,
					ti.getGdfGenericCode());
			_log.info("::::in fppMarketList edit size() method:::::" + fppMarketList.size()+":::userId::"+userId);
			for (FPPMarket fppMarketModel : fppMarketList) {
				if (Objects.equals(ti.getGdfGenericCode(), fppMarketModel.getGdfGenericCode()) && Objects.equals(userId, fppMarketModel.getSupplierId())) {
					_log.info(":::fppMarketModel.getSupplierId():::"+fppMarketModel.getSupplierId());
					try {
						FPPMarket fppMarketCompleteList = FPPMarketLocalServiceUtil
								.getFPPMarket(fppMarketModel.getFppMarketID());

						List<GDFTenderSubFPPMatDetails> gdfFppMatDetails = GDFTenderSubFPPMatDetailsLocalServiceUtil
								.getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(fppMarketModel.getFppMarketID(), userId,
										ti.getGdfGenericCode(), scheduleNumber, ti.getTenderReferenceNumber());
						_log.info("::::in gdfFppMatDetails edit in if condition size() method:::::" + gdfFppMatDetails.size());
						if (gdfFppMatDetails == null || gdfFppMatDetails.isEmpty()) {

							FPPMarketDetailsModel fppMartGenCodeDetails = new FPPMarketDetailsModel();
							
							fppMartGenCodeDetails.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppMartGenCodeDetails.setTenderItemRefId(ti.getTenderItemRefID());
							fppMartGenCodeDetails.setTenderItemNumber(ti.getTenderItemNumber());
							fppMartGenCodeDetails.setDosageForm(fppMarketCompleteList.getDosageForm());
							fppMartGenCodeDetails.setNoOfPrimaryPackaging(
									String.valueOf(fppMarketCompleteList.getPrimPackageUnits()));
							fppMartGenCodeDetails.setNoOfSecondaryPackaging(
									String.valueOf(fppMarketCompleteList.getSecPackageUnits()));
							fppMartGenCodeDetails.setFppMartStatus(fppMarketCompleteList.getFppMarketStatus());
							fppMartGenCodeDetails.setGdfGenericCode(fppMarketCompleteList.getGdfGenericCode());
							fppMartGenCodeDetails.setFppMarketId(fppMarketModel.getFppMarketID());

							fppMarGenCodeList.add(fppMartGenCodeDetails);

						} else {

							gdfFppMatDetails.forEach(gmd -> {

								_log.info(":::::gdfFppMatDetails::edit in if else condition size::" + gdfFppMatDetails + ", "
										+ gdfFppMatDetails.size());
								FPPMarketDetailsModel fppMartGenCodeDetails = new FPPMarketDetailsModel();

								fppMartGenCodeDetails.setTenderReferenceNumber(ti.getTenderReferenceNumber());
								fppMartGenCodeDetails.setTenderItemRefId(ti.getTenderItemRefID());
								fppMartGenCodeDetails.setTenderItemNumber(ti.getTenderItemNumber());
								fppMartGenCodeDetails.setDosageForm(fppMarketCompleteList.getDosageForm());
								fppMartGenCodeDetails.setNoOfPrimaryPackaging(
										String.valueOf(fppMarketCompleteList.getPrimPackageUnits()));
								fppMartGenCodeDetails.setNoOfSecondaryPackaging(
										String.valueOf(fppMarketCompleteList.getSecPackageUnits()));
								fppMartGenCodeDetails.setFppMartStatus(fppMarketCompleteList.getFppMarketStatus());
								fppMartGenCodeDetails.setGdfGenericCode(fppMarketCompleteList.getGdfGenericCode());
								fppMartGenCodeDetails.setFppMarketId(fppMarketModel.getFppMarketID());
								fppMartGenCodeDetails.setFppSelTenderSub(gmd.getFppSelectedStatus());
								fppMartGenCodeDetails.setTenderFPPMatRefNumber(gmd.getTenderItemMatRefID());

								
								fppMarGenCodeList.add(fppMartGenCodeDetails);
							});
						}
					} catch (PortalException e) {
						e.printStackTrace();
					}

				}

			}

		});

		// _log.info("::::fppMarGenCodeList in getTendersByFPPMartGenCode method:::::" +
		// fppMarGenCodeList);
		_log.info("::::fppMarGenCodeList edit size in  method:::::" + fppMarGenCodeList.size());
		return fppMarGenCodeList;
	}

	public static Set<ScheduleDetailsModel> preparePrdSelectedDetails(
			List<GDFTenderSubFPPMatDetails> gdfTenderSubSchedItemList, long userId, String tenderRefNumber) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderSubSchedItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppMartModelList(getPrdSelectedByScheduleNumber(gdfTenderSubSchedItemList, sd.getScheduleNumber(), userId, tenderRefNumber));
		});

		return scheduleDetailsList;

	}

	public static List<FPPMarketDetailsModel> getPrdSelectedByScheduleNumber(
			List<GDFTenderSubFPPMatDetails> gdfScheduleSubItemList, long scheduleNumber, long userId, String tenderRefNumber) {
		List<FPPMarketDetailsModel> fppMartList = new ArrayList<>();

		List<GDFTenderSubFPPMatDetails> gdfMatItemsList = gdfScheduleSubItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfMatItemsList.forEach(fm -> {

			if (Objects.equals(fm.getFppSelectedStatus(), true) && (Objects.equals(userId, fm.getUserId())) && Objects.equals(fm.getTenderReferenceNumber(), tenderRefNumber)) {
				List<FPPMarket> fppMarketList = FPPMarketLocalServiceUtil.findByFPPMarketByMarketId(fm.getFppMarketID());
				_log.info("::::in fppMarketList edit size() method:::::" + fppMarketList.size()+":::userId::"+userId);
				for (FPPMarket fppMarketModel : fppMarketList) {
				FPPMarketDetailsModel fppMatDetails = new FPPMarketDetailsModel();
				fppMatDetails.setTenderReferenceNumber(fm.getTenderReferenceNumber());
				fppMatDetails.setTenderItemNumber(fm.getTenderItemRefID());
				fppMatDetails.setGdfGenericCode(fm.getGdfGenericCode());
				fppMatDetails.setTenderFPPMatRefNumber(fm.getTenderItemMatRefID());
				fppMatDetails.setDosageForm(fppMarketModel.getDosageForm());
				fppMatDetails.setNoOfPrimaryPackaging(String.valueOf(fppMarketModel.getPrimPackageUnits()));
				fppMatDetails.setNoOfSecondaryPackaging(String.valueOf(fppMarketModel.getSecPackageUnits()));
				fppMatDetails.setFppMartStatus(fppMarketModel.getFppMarketStatus());
				fppMatDetails.setFppSelTenderSub(fm.getFppSelectedStatus());
				fppMatDetails.setFppMarketId(fm.getFppMarketID());
				fppMartList.add(fppMatDetails);
			}

			}
		});

		_log.info("::::fppMartList in getPrdSelectedByScheduleNumber method:::::" + fppMartList);
		return fppMartList;
	}

	public static Set<ScheduleDetailsModel> prepareExcelFPPRegDetails(
			List<GDFTenderSubFPPRegDetails> gdfTenderSubSchedItemList, long userId) {
		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderSubSchedItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppRegDetailsModelList(
					getPrepareExcelFPPRegDetails(gdfTenderSubSchedItemList, sd.getScheduleNumber(), userId));
		});

		return scheduleDetailsList;

	}

	public static List<FPPRegDetailsModel> getPrepareExcelFPPRegDetails(
			List<GDFTenderSubFPPRegDetails> gdfScheduleSubItemList, long scheduleNumber, long userId) {
		List<FPPRegDetailsModel> fppRegList = new ArrayList<>();

		List<GDFTenderSubFPPRegDetails> gdfRegItemsList = gdfScheduleSubItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfRegItemsList.forEach(fm -> {

			if (Objects.equals(fm.getFppRegAccepted(), true) && (Objects.equals(userId, fm.getUserId()))) {
				FPPRegDetailsModel fppRegDetails = new FPPRegDetailsModel();
				fppRegDetails.setTenderReferenceNumber(fm.getTenderReferenceNumber());
				fppRegDetails.setGdfGenericCode(fm.getGdfGenericCode());
				fppRegDetails.setFppRegId(String.valueOf(fm.getFppRegistrationId()));
				fppRegDetails.setListOfCountries(fm.getListOfRegCountries());
				fppRegDetails.setFppRegStatus(fm.getFppRegApprStatus());
				fppRegDetails.setGdfTenderItemMatRefID(String.valueOf(fm.getTenderItemMatRefID()));
				fppRegDetails.setFppRegAcceptedStatus(fm.getFppRegAccepted());
				fppRegDetails.setTenderItemNumber(fm.getTenderItemRefID());
				fppRegList.add(fppRegDetails);
			}

		});

		_log.info("::::fppRegList in getPrdSelectedByScheduleNumber method:::::" + fppRegList);
		return fppRegList;
	}

	public static Set<ScheduleDetailsModel> prepareProdRegDetails(
			List<GDFTenderSubFPPMatDetails> gdfTenderScheduleItemList, long userId) {

		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppRegDetailsModelList(getTenderByFppRegGenCode(gdfTenderScheduleItemList, sd.getScheduleNumber(), userId));
		});

		return scheduleDetailsList;

	}

	public static List<FPPRegDetailsModel> getTenderByFppRegGenCode(List<GDFTenderSubFPPMatDetails> gdfScheduleItemList,
			long scheduleNumber, long userId) {

		List<FPPRegDetailsModel> fppRegDetailsModelList = new ArrayList<>();
		Map<String, FPPRegDetailsModel> fppRegDetailsMap = new HashMap<>();

		List<GDFTenderSubFPPMatDetails> gdfItemsList = gdfScheduleItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfItemsList.forEach(ti -> {

			/*List<FPPRegistration> fppRegList = FPPRegistrationLocalServiceUtil
					.findByFPPRegBySIdAndGDFCode(userId, ti.getGdfGenericCode());*/
			List<FPPRegistration> fppRegList = FPPRegistrationLocalServiceUtil
					.findByFPPRegistrationByMarketId(ti.getFppMarketID());
			_log.info("::::fppRegList in countries list size:::::"+ userId + ", "
					+ ti.getFppMarketID());

			fppRegList.forEach(fr -> {

					String keyGenCodeStatus = fr.getGdfGenericCode().concat(fr.getFppRegStatus());
					FPPRegDetailsModel fppRegDetailsModel = fppRegDetailsMap.get(keyGenCodeStatus);
					if (Objects.equals(ti.getFppSelectedStatus(), true) && Objects.equals(userId, fr.getSupplierId())) {
						if (fppRegDetailsModel == null) {

							Set<String> countryNames = new HashSet<>();
							countryNames.add(fr.getRegCountry());

							fppRegDetailsModel = new FPPRegDetailsModel();
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry()));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setCountryNames(countryNames);
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							fppRegDetailsModel.setGdfTenderItemMatRefID(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry()));
						
							fppRegDetailsMap.put(keyGenCodeStatus, fppRegDetailsModel);

						} else {
							Set<String> countryNames = fppRegDetailsModel.getCountryNames();
							countryNames.add(fr.getRegCountry());
							String fppMatRefId = fppRegDetailsModel.getGdfTenderItemMatRefID();
							String fppRegId = fppRegDetailsModel.getFppRegId();
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(fppRegId.concat(",").concat(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setGdfTenderItemMatRefID(fppMatRefId.concat(",").concat(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							
						}
					}

			
			});

		});

		fppRegDetailsMap.forEach((k, v) -> {
			fppRegDetailsModelList.add(v);
		});
		_log.info("::::fppRegDetailsModelList in getTenderByFppRegGenCode method:::::" + fppRegDetailsModelList);
		return fppRegDetailsModelList;
	}

	
	public static Set<ScheduleDetailsModel> prepareEditProdRegDetails(
			List<GDFTenderSubFPPMatDetails> gdfTenderScheduleItemList, long userId) {

		Set<ScheduleDetailsModel> scheduleDetailsList = new LinkedHashSet<>();

		gdfTenderScheduleItemList.forEach(si -> {
			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();

			scheduleDetailsModel.setScheduleNumber(si.getScheduleNumber());
			scheduleDetailsModel.setUserId(si.getUserId());
			scheduleDetailsModel.setUserName(si.getUserName());
			scheduleDetailsList.add(scheduleDetailsModel);
		});

		_log.info(":::::scheduleDetailsList in set method:::::" + scheduleDetailsList);

		scheduleDetailsList.forEach(sd -> {
			sd.setFppRegDetailsModelList(getTenderByEditFppRegGenCode(gdfTenderScheduleItemList, sd.getScheduleNumber(), userId));
		});

		return scheduleDetailsList;

	}

	public static List<FPPRegDetailsModel> getTenderByEditFppRegGenCode(List<GDFTenderSubFPPMatDetails> gdfScheduleItemList,
			long scheduleNumber, long userId) {

		List<FPPRegDetailsModel> fppRegDetailsModelList = new ArrayList<>();
		Map<String, FPPRegDetailsModel> fppRegDetailsMap = new HashMap<>();

		List<GDFTenderSubFPPMatDetails> gdfItemsList = gdfScheduleItemList.stream()
				.filter(si -> Objects.equals(si.getScheduleNumber(), scheduleNumber)).collect(Collectors.toList());

		gdfItemsList.forEach(ti -> {

			/*List<FPPRegistration> fppRegList = FPPRegistrationLocalServiceUtil
					.findByFPPRegBySIdAndGDFCode(userId, ti.getGdfGenericCode());*/
			List<FPPRegistration> fppRegList = FPPRegistrationLocalServiceUtil
					.findByFPPRegistrationByMarketId(ti.getFppMarketID());
			_log.info("::::fppRegList in countries list size:::::" + ti.getUserId() + ", "
					+ ti.getFppMarketID() );

			fppRegList.forEach(fr -> {

				
				List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegList = GDFTenderSubFPPRegDetailsLocalServiceUtil
						.getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(scheduleNumber, userId,
								ti.getTenderReferenceNumber(), ti.getGdfGenericCode(), fr.getFppRegistrationId());
				
				if(gdfTenderSubFPPRegList == null || gdfTenderSubFPPRegList.isEmpty()) {
					
					String keyGenCodeStatus = fr.getGdfGenericCode().concat(fr.getFppRegStatus());
					FPPRegDetailsModel fppRegDetailsModel = fppRegDetailsMap.get(keyGenCodeStatus);
					if (Objects.equals(ti.getFppSelectedStatus(), true) && Objects.equals(userId, fr.getSupplierId())) {
						if (fppRegDetailsModel == null) {

							Set<String> countryNames = new HashSet<>();
							countryNames.add(fr.getRegCountry());

							fppRegDetailsModel = new FPPRegDetailsModel();
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry()));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setCountryNames(countryNames);
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							fppRegDetailsModel.setGdfTenderItemMatRefID(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry()));
							fppRegDetailsModel.setTenderItemNumber(ti.getTenderItemRefID());
						
							fppRegDetailsMap.put(keyGenCodeStatus, fppRegDetailsModel);

						} else {
							Set<String> countryNames = fppRegDetailsModel.getCountryNames();
							countryNames.add(fr.getRegCountry());
							String fppMatRefId = fppRegDetailsModel.getGdfTenderItemMatRefID();
							String fppRegId = fppRegDetailsModel.getFppRegId();
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(fppRegId.concat(",").concat(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setGdfTenderItemMatRefID(fppMatRefId.concat(",").concat(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							fppRegDetailsModel.setTenderItemNumber(ti.getTenderItemRefID());
							
						}
					}
					
				}else {
					
				gdfTenderSubFPPRegList.forEach(gsf -> {

					String keyGenCodeStatus = fr.getGdfGenericCode().concat(fr.getFppRegStatus());
					FPPRegDetailsModel fppRegDetailsModel = fppRegDetailsMap.get(keyGenCodeStatus);
					if (Objects.equals(ti.getFppSelectedStatus(), true) && Objects.equals(userId, fr.getSupplierId())) {
						if (fppRegDetailsModel == null) {

							Set<String> countryNames = new HashSet<>();
							countryNames.add(fr.getRegCountry());

							fppRegDetailsModel = new FPPRegDetailsModel();
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry()));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setCountryNames(countryNames);
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							fppRegDetailsModel.setGdfTenderItemMatRefID(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry()));
							fppRegDetailsModel.setFppRegAcceptedStatus(gsf.getFppRegAccepted());
							fppRegDetailsModel.setTenderFPPRegRefNumber(String.valueOf(gsf.getTenderRegRefID()));
							fppRegDetailsModel.setTenderItemNumber(ti.getTenderItemRefID());
							fppRegDetailsMap.put(keyGenCodeStatus, fppRegDetailsModel);

						} else {
							Set<String> countryNames = fppRegDetailsModel.getCountryNames();
							countryNames.add(fr.getRegCountry());
							String fppMatRefId = fppRegDetailsModel.getGdfTenderItemMatRefID();
							String fppRegId = fppRegDetailsModel.getFppRegId();
							String fppTenderRegRefId = String.valueOf(fppRegDetailsModel.getTenderFPPRegRefNumber());
							fppRegDetailsModel.setTenderReferenceNumber(ti.getTenderReferenceNumber());
							fppRegDetailsModel.setFppRegId(fppRegId.concat(",").concat(
									String.valueOf(fr.getFppRegistrationId()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setGdfGenericCode(fr.getGdfGenericCode());
							fppRegDetailsModel.setListOfCountries(String.join(", ", countryNames));
							fppRegDetailsModel.setNoOfCountries(countryNames.size());
							fppRegDetailsModel.setGdfTenderItemMatRefID(fppMatRefId.concat(",").concat(
									String.valueOf(ti.getTenderItemMatRefID()).concat(":").concat(fr.getRegCountry())));
							fppRegDetailsModel.setFppRegStatus(fr.getFppRegStatus());
							fppRegDetailsModel.setFppRegAcceptedStatus(gsf.getFppRegAccepted());
							fppRegDetailsModel.setTenderFPPRegRefNumber(
									fppTenderRegRefId.concat(",").concat(String.valueOf(gsf.getTenderRegRefID())));
							fppRegDetailsModel.setTenderItemNumber(ti.getTenderItemRefID());
						}
					}

				});
				
				}
			});

		});

		fppRegDetailsMap.forEach((k, v) -> {
			fppRegDetailsModelList.add(v);
		});
		_log.info("::::fppRegDetailsModelList in getTenderByFppRegGenCode method:::::" + fppRegDetailsModelList);
		return fppRegDetailsModelList;
	}
	
	public static List<TenderItemDetailsModel> getCompleteJsonScheduleItems(
			List<ScheduleDetailsModel> scheduleDetailsList) {
		List<TenderItemDetailsModel> tenderItemsList = new ArrayList<>();

		scheduleDetailsList.forEach(sl -> {

			tenderItemsList.addAll(sl.getTenderItemDetailsModelList());
		});

		return tenderItemsList;
	}

	public static List<ScheduleDetailsModel> readScheduleDetailsFromJsonString(JSONArray selGdfTenderArr) {

		List<ScheduleDetailsModel> scheduleDetailsList = new ArrayList<>();

		Iterator<?> iterator = selGdfTenderArr.iterator();
		while (iterator.hasNext()) {

			JSONObject jsonObj = (JSONObject) iterator.next();

			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();
			List<TenderItemDetailsModel> tenderItemList = new ArrayList<>();

			long scheduleNumber = jsonObj.getLong("schduleNumber");
			String scheduleName = jsonObj.getString("scheduleName");
			String patientTarget = jsonObj.getString("patientTarget");

			scheduleDetailsModel.setScheduleNumber(scheduleNumber);
			scheduleDetailsModel.setScheduleName(scheduleName);
			scheduleDetailsModel.setPatientTarget(patientTarget);

			JSONArray tenderItemsJsonArray = jsonObj.getJSONArray("tenderItems");

			Iterator<?> itemsIterator = tenderItemsJsonArray.iterator();
			while (itemsIterator.hasNext()) {
				TenderItemDetailsModel tenderItemDetailsModel = new TenderItemDetailsModel();

				JSONObject itemJsonObj = (JSONObject) itemsIterator.next();
				// long jsonTenderRefId = itemJsonObj.getLong("tenderItemRefId", 0L);

				tenderItemDetailsModel.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));
				tenderItemDetailsModel.setGdfGenericCode(itemJsonObj.getString("gdfGenericCode"));
				tenderItemDetailsModel.setTenderItemRefId(itemJsonObj.getLong("tenderItemRefId"));

				tenderItemList.add(tenderItemDetailsModel);
			}
			scheduleDetailsModel.setTenderItemDetailsModelList(tenderItemList);
			scheduleDetailsList.add(scheduleDetailsModel);
		}
		_log.info("In Ajax scheduleDetailsList:::::" + scheduleDetailsList);
		return scheduleDetailsList;
	}

	public static List<ScheduleDetailsModel> readPrdSelFromJsonString(JSONArray selPrdSelArr) {

		List<ScheduleDetailsModel> scheduleDetailsList = new ArrayList<>();

		Iterator<?> iterator = selPrdSelArr.iterator();
		while (iterator.hasNext()) {

			JSONObject jsonObj = (JSONObject) iterator.next();
			long scheduleNumber = jsonObj.getLong("schduleNumber");
			JSONArray tenderItemsJsonArray = jsonObj.getJSONArray("tenderItems");

			Iterator<?> itemsIterator = tenderItemsJsonArray.iterator();
			while (itemsIterator.hasNext()) {
				List<FPPMarketDetailsModel> fppGenCodeList = new ArrayList<>();
				ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();
				scheduleDetailsModel.setScheduleNumber(scheduleNumber);
				FPPMarketDetailsModel fppMarketDetailsModel = new FPPMarketDetailsModel();

				JSONObject itemJsonObj = (JSONObject) itemsIterator.next();

				fppMarketDetailsModel.setTenderReferenceNumber(itemJsonObj.getString("tenderReferenceNumber"));
				fppMarketDetailsModel.setGdfGenericCode(itemJsonObj.getString("gdfGenericCode"));
				fppMarketDetailsModel.setDosageForm(itemJsonObj.getString("dosageForm"));
				fppMarketDetailsModel.setNoOfPrimaryPackaging(itemJsonObj.getString("noOfUnitsForPrimPack"));
				fppMarketDetailsModel.setNoOfSecondaryPackaging(itemJsonObj.getString("noOfUnitsForSecPack"));
				fppMarketDetailsModel.setFppMartStatus(itemJsonObj.getString("fppMarStauts"));
				fppMarketDetailsModel.setFppMarketId(itemJsonObj.getLong("fppMarketId"));
				fppMarketDetailsModel.setFppSelTenderSub(itemJsonObj.getBoolean("fppSelTenderSub"));
				fppMarketDetailsModel.setTenderFPPMatRefNumber(itemJsonObj.getLong("tenderFPPMatRefNumber"));
				fppMarketDetailsModel.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));

				fppGenCodeList.add(fppMarketDetailsModel);

				scheduleDetailsModel.setFppMartModelList(fppGenCodeList);
				scheduleDetailsList.add(scheduleDetailsModel);
			}

		}
		_log.info("In Ajax scheduleDetailsList size:::::" + scheduleDetailsList.size());
		return scheduleDetailsList;
	}

	public static List<ScheduleDetailsModel> readPrdRegisteredFromJsonString(JSONArray selectedPrdRegArr) {

		List<ScheduleDetailsModel> scheduleDetailsList = new ArrayList<>();

		Iterator<?> iterator = selectedPrdRegArr.iterator();
		while (iterator.hasNext()) {

			JSONObject jsonObj = (JSONObject) iterator.next();
			long scheduleNumber = jsonObj.getLong("schduleNumber");
			JSONArray tenderItemsJsonArray = jsonObj.getJSONArray("tenderItems");

			Iterator<?> itemsIterator = tenderItemsJsonArray.iterator();
			while (itemsIterator.hasNext()) {

				JSONObject itemJsonObj = (JSONObject) itemsIterator.next();

				// HashMap<String,String> marketRefIDCountryMap=new HashMap<String,String>();
				String[] gdfTenderItemMatRefArr = itemJsonObj.getString("gdfTenderItemMatRefID").split(",");
				String[] fppRegArr = itemJsonObj.getString("fppRegId").split(",");
				for (String MatRefId : gdfTenderItemMatRefArr) {
					String country[] = MatRefId.split(":");
					_log.info("country" + Arrays.toString(country).substring(0));
					String countryMart = country[country.length - 1];
					String gdfMartRefId = country[0];
					for (String fppRegCountryId : fppRegArr) {
						String fppRegCountry[] = fppRegCountryId.split(":");
						String fppCountry = fppRegCountry[fppRegCountry.length - 1];
						String fppRegRefId = fppRegCountry[0];
						if (Objects.equals(countryMart, fppCountry)) {
							List<FPPRegDetailsModel> fppGenCodeList = new ArrayList<>();
							ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();
							scheduleDetailsModel.setScheduleNumber(scheduleNumber);
							FPPRegDetailsModel fppRegDetailsModel = new FPPRegDetailsModel();

							fppRegDetailsModel.setTenderReferenceNumber(itemJsonObj.getString("tenderReferenceNumber"));
							fppRegDetailsModel.setGdfGenericCode(itemJsonObj.getString("gdfGenericCode"));
							fppRegDetailsModel.setListOfCountries(fppCountry);
							fppRegDetailsModel.setGdfTenderItemMatRefID(gdfMartRefId);
							fppRegDetailsModel.setFppRegStatus(itemJsonObj.getString("fppRegStatus"));

							fppRegDetailsModel.setFppRegId(fppRegRefId);
							fppRegDetailsModel.setFppRegAcceptedStatus(itemJsonObj.getBoolean("fppRegAcceptedStatus"));
							fppRegDetailsModel.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));

							fppGenCodeList.add(fppRegDetailsModel);

							scheduleDetailsModel.setFppRegDetailsModelList(fppGenCodeList);
							scheduleDetailsList.add(scheduleDetailsModel);

							// marketRefIDCountryMap.put(country[0],country[country.length-1]);
							// _log.info("marketRefIDCountryMap"+marketRefIDCountryMap);
						}
					}

				}

			}
		}
		_log.info("In Ajax readPrdRegisteredFromJsonString size:::::" + scheduleDetailsList + ", size::::"
				+ scheduleDetailsList.size());
		return scheduleDetailsList;
	}

	public static void addFPPMartDetails(FPPMarketDetailsModel fppMartModel, ThemeDisplay themeDisplay,
			long scheduleNumber, String tenderReferenceNumber) throws PortalException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = GDFTenderSubFPPMatDetailsLocalServiceUtil
				.createGDFTenderSubFPPMatDetails(CounterLocalServiceUtil.increment());

		_log.info(":::::in addFPPMartDetails::::");
		gdfTenderSubFPPMatDetails.setTenderReferenceNumber(tenderReferenceNumber);
		gdfTenderSubFPPMatDetails.setScheduleNumber(scheduleNumber);
		gdfTenderSubFPPMatDetails.setGdfGenericCode(fppMartModel.getGdfGenericCode());
		gdfTenderSubFPPMatDetails.setDosageForm(fppMartModel.getDosageForm());
		gdfTenderSubFPPMatDetails.setNoPrimPackageUnits(Long.parseLong(fppMartModel.getNoOfPrimaryPackaging()));
		gdfTenderSubFPPMatDetails.setNoSecPackageUnits(Long.parseLong(fppMartModel.getNoOfSecondaryPackaging()));
		gdfTenderSubFPPMatDetails.setFppMarketID(fppMartModel.getFppMarketId());
		gdfTenderSubFPPMatDetails.setGdfFppMartApprStatus(fppMartModel.getFppMartStatus());
		gdfTenderSubFPPMatDetails.setFppSelectedStatus(fppMartModel.isFppSelTenderSub());
		gdfTenderSubFPPMatDetails.setUserId(themeDisplay.getUserId());
		gdfTenderSubFPPMatDetails.setUserName(themeDisplay.getUser().getScreenName());
		//gdfTenderSubFPPMatDetails.setCreateDate(gdfTenderSubFPPMatDetails.getCreateDate());
		//gdfTenderSubFPPMatDetails.setModifiedDate(new Date());
		gdfTenderSubFPPMatDetails.setTenderItemRefID(fppMartModel.getTenderItemNumber());
		GDFTenderSubFPPMatDetailsLocalServiceUtil.addGDFTenderSubFPPMatDetails(gdfTenderSubFPPMatDetails);

	}

	public static GDFTenderSubFPPMatDetails isFppMartDetExists(
			List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatUpdatedDetList, FPPMarketDetailsModel fg,
			long scheduleNumber, ThemeDisplay themeDisplay) {

		return gdfTenderSubFPPMatUpdatedDetList.stream()
				.filter(ufm -> ((Objects.equals(ufm.getFppMarketID(), fg.getFppMarketId()))
						&& (Objects.equals(fg.getTenderReferenceNumber(), ufm.getTenderReferenceNumber()))
						&& (Objects.equals(scheduleNumber, ufm.getScheduleNumber()))
						&& (Objects.equals(fg.getGdfGenericCode(), ufm.getGdfGenericCode()))
						&& (Objects.equals(themeDisplay.getUserId(), ufm.getUserId()))))
				.findAny().orElse(null);

	}

	public static void addFPPRegDetails(FPPRegDetailsModel fppRegModel, ThemeDisplay themeDisplay, long scheduleNumber,
			String tenderReferenceNumber) throws PortalException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = GDFTenderSubFPPRegDetailsLocalServiceUtil
				.createGDFTenderSubFPPRegDetails(CounterLocalServiceUtil.increment());

		_log.info(":::::in addFPPRegDetails getListOfCountries::::" + fppRegModel.getListOfCountries());
		gdfTenderSubFPPRegDetails.setTenderReferenceNumber(tenderReferenceNumber);
		gdfTenderSubFPPRegDetails.setScheduleNumber(scheduleNumber);
		gdfTenderSubFPPRegDetails.setGdfGenericCode(fppRegModel.getGdfGenericCode());
		gdfTenderSubFPPRegDetails.setListOfRegCountries(fppRegModel.getListOfCountries());
		gdfTenderSubFPPRegDetails.setFppRegistrationId(Long.parseLong(fppRegModel.getFppRegId()));
		gdfTenderSubFPPRegDetails.setFppRegApprStatus(fppRegModel.getFppRegStatus());
		gdfTenderSubFPPRegDetails.setFppRegAccepted(fppRegModel.isFppRegAcceptedStatus());
		gdfTenderSubFPPRegDetails.setTenderItemMatRefID(Long.parseLong(fppRegModel.getGdfTenderItemMatRefID()));
		gdfTenderSubFPPRegDetails.setUserId(themeDisplay.getUserId());
		gdfTenderSubFPPRegDetails.setUserName(themeDisplay.getUser().getScreenName());
		gdfTenderSubFPPRegDetails.setTenderItemRefID(fppRegModel.getTenderItemNumber());
		//gdfTenderSubFPPRegDetails.setModifiedDate(new Date());

		gdfTenderSubFPPRegDetails.setTenderItemMatRefID(Long.parseLong(fppRegModel.getGdfTenderItemMatRefID()));
		GDFTenderSubFPPRegDetailsLocalServiceUtil.addGDFTenderSubFPPRegDetails(gdfTenderSubFPPRegDetails);

	}

	public static GDFTenderSubFPPRegDetails isFppRegCountryListExists(
			List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegUpdatedDetList, FPPRegDetailsModel fg,
			long scheduleNumber, ThemeDisplay themeDisplay) {

		return gdfTenderSubFPPRegUpdatedDetList.stream()
				.filter(ufm -> ((Objects.equals(ufm.getFppRegistrationId(), Long.parseLong(fg.getFppRegId())))
						&& (Objects.equals(fg.getTenderReferenceNumber(), ufm.getTenderReferenceNumber()))
						&& (Objects.equals(scheduleNumber, ufm.getScheduleNumber()))
						&& (Objects.equals(fg.getGdfGenericCode(), ufm.getGdfGenericCode()))
						&& (Objects.equals(themeDisplay.getUserId(), ufm.getUserId()))))
				.findAny().orElse(null);

	}

	public static void addGdfSubmittionDetails(String tenderReferenceNumber, ThemeDisplay themeDisplay) {
		_log.info("::::tenderReferenceNumber in addGdfSubmittionDetails:::::" + tenderReferenceNumber);

		GDFTenderSubmissionDetails gdfTenderSubDetails = GDFTenderSubmissionDetailsLocalServiceUtil
				.createGDFTenderSubmissionDetails(CounterLocalServiceUtil.increment());

		gdfTenderSubDetails.setTenderReferenceNumber(tenderReferenceNumber);

		gdfTenderSubDetails.setSupplierId(themeDisplay.getUserId());
		gdfTenderSubDetails.setUserName(themeDisplay.getUser().getScreenName());

		//gdfTenderSubDetails.setCreateDate(gdfTenderSubDetails.getCreateDate());
		//gdfTenderSubDetails.setModifiedDate(gdfTenderSubDetails.getModifiedDate());
		gdfTenderSubDetails.setTenderSubmissionStatus(GdfTenderSubmissionConstants.DRAFT);

		GDFTenderSubmissionDetailsLocalServiceUtil.addGDFTenderSubmissionDetails(gdfTenderSubDetails);

	}

	public static GDFTenderSubmissionDetails istenderRefNumberExists(
			List<GDFTenderSubmissionDetails> gdfTenderSubmissionDetails, String tenderReferenceNumber,
			ThemeDisplay themeDisplay) {
		_log.info("::::tenderReferenceNumber istenderRefNumberExists:::::" + tenderReferenceNumber);
		return gdfTenderSubmissionDetails.stream()
				.filter(gts -> ((Objects.equals(tenderReferenceNumber, gts.getTenderReferenceNumber()))
						&& (Objects.equals(themeDisplay.getUserId(), gts.getSupplierId()))))
				.findAny().orElse(null);

	}

	/*
	 * public static void updateFPPMartDetails(FPPMarketDetailsModel fppMartModel,
	 * ThemeDisplay themeDisplay, long scheduleNumber, String tenderReferenceNumber,
	 * long tenderFPPMatRefNumber) throws PortalException {
	 * 
	 * GDFTenderSubFPPMatDetails gdfTenderSubFPPMatUpdatedDetList =
	 * GDFTenderSubFPPMatDetailsLocalServiceUtil
	 * .getGDFTenderSubFPPMatDetails(tenderFPPMatRefNumber);
	 * 
	 * _log.info(":::::in UpdateFPPMartDetails::::");
	 * gdfTenderSubFPPMatUpdatedDetList.setTenderReferenceNumber(
	 * tenderReferenceNumber);
	 * gdfTenderSubFPPMatUpdatedDetList.setScheduleNumber(scheduleNumber);
	 * gdfTenderSubFPPMatUpdatedDetList.setGdfGenericCode(fppMartModel.
	 * getGdfGenericCode());
	 * gdfTenderSubFPPMatUpdatedDetList.setDosageForm(fppMartModel.getDosageForm());
	 * gdfTenderSubFPPMatUpdatedDetList
	 * .setNoPrimPackageUnits(Long.parseLong(fppMartModel.getNoOfPrimaryPackaging())
	 * ); gdfTenderSubFPPMatUpdatedDetList
	 * .setNoSecPackageUnits(Long.parseLong(fppMartModel.getNoOfSecondaryPackaging()
	 * ));
	 * gdfTenderSubFPPMatUpdatedDetList.setFppMarketID(fppMartModel.getFppMarketId()
	 * ); gdfTenderSubFPPMatUpdatedDetList.setGdfFppMartApprStatus(fppMartModel.
	 * getFppMartStatus());
	 * gdfTenderSubFPPMatUpdatedDetList.setFppSelectedSatus(fppMartModel.
	 * isFppSelTenderSub());
	 * gdfTenderSubFPPMatUpdatedDetList.setUserId(themeDisplay.getUserId());
	 * gdfTenderSubFPPMatUpdatedDetList.setUserName(themeDisplay.getUser().
	 * getScreenName()); gdfTenderSubFPPMatUpdatedDetList.setCreateDate(
	 * gdfTenderSubFPPMatUpdatedDetList.getCreateDate());
	 * gdfTenderSubFPPMatUpdatedDetList.setModifiedDate(
	 * gdfTenderSubFPPMatUpdatedDetList.getModifiedDate());
	 * 
	 * GDFTenderSubFPPMatDetailsLocalServiceUtil.updateGDFTenderSubFPPMatDetails(
	 * gdfTenderSubFPPMatUpdatedDetList);
	 * 
	 * }
	 */

	public static List<ScheduleDetailsModel> readAlreadySelectedPrdsFromJsonString(JSONArray selPrdSelArr) {

		List<ScheduleDetailsModel> scheduleDetailsList = new ArrayList<>();

		Iterator<?> iterator = selPrdSelArr.iterator();
		while (iterator.hasNext()) {

			JSONObject jsonObj = (JSONObject) iterator.next();

			ScheduleDetailsModel scheduleDetailsModel = new ScheduleDetailsModel();
			List<FPPMarketDetailsModel> fppMartList = new ArrayList<>();

			long scheduleNumber = jsonObj.getLong("schduleNumber");

			scheduleDetailsModel.setScheduleNumber(scheduleNumber);

			JSONArray tenderItemsJsonArray = jsonObj.getJSONArray("tenderItems");

			Iterator<?> itemsIterator = tenderItemsJsonArray.iterator();
			while (itemsIterator.hasNext()) {
				FPPMarketDetailsModel fppMartSelectedDet = new FPPMarketDetailsModel();

				JSONObject itemJsonObj = (JSONObject) itemsIterator.next();
				// fppMartSelectedDet.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));
				fppMartSelectedDet.setGdfGenericCode(itemJsonObj.getString("gdfGenericCode"));
				fppMartSelectedDet.setDosageForm(itemJsonObj.getString("dosageForm"));
				fppMartSelectedDet.setNoOfPrimaryPackaging(itemJsonObj.getString("noOfUnitsForPrimPack"));
				fppMartSelectedDet.setNoOfSecondaryPackaging(itemJsonObj.getString("noOfUnitsForSecPack"));
				fppMartSelectedDet.setFppMartStatus(itemJsonObj.getString("fppMarStauts"));
				fppMartSelectedDet.setTenderFPPMatRefNumber(itemJsonObj.getLong("tenderFPPMatRefNumber"));
				fppMartSelectedDet.setTenderItemNumber(itemJsonObj.getLong("tenderItemNumber"));
				fppMartList.add(fppMartSelectedDet);

			}
			scheduleDetailsModel.setFppMartModelList(fppMartList);
			scheduleDetailsList.add(scheduleDetailsModel);
		}
		_log.info("In Ajax scheduleDetailsList:::::" + scheduleDetailsList);
		return scheduleDetailsList;
	}

	public static void updateFPPMartDetails(FPPMarketDetailsModel fppMartModel, long scheduleNumber,
			long tenderFPPMatRefNumber) throws PortalException {

		// long fppMartRefId = fppMartModel.getTenderFPPMatRefNumber();

		_log.info("::::::In updateTenderItem method scheduleNumber::::::" + scheduleNumber + ", "
				+ tenderFPPMatRefNumber);
		_log.info("::::fppMartModel:::" + fppMartModel.toString());

		GDFTenderSubFPPMatDetails updatedGdfFppMartDet = GDFTenderSubFPPMatDetailsLocalServiceUtil
				.getGDFTenderSubFPPMatDetails(tenderFPPMatRefNumber);

		updatedGdfFppMartDet.setScheduleNumber(scheduleNumber);

		updatedGdfFppMartDet.setTenderItemMatRefID(tenderFPPMatRefNumber);
		// updatedGdfFppMartDet.setTenderItemMatRefID(fppMartModel.getTenderFPPMatRefNumber());
		updatedGdfFppMartDet.setGdfGenericCode(fppMartModel.getGdfGenericCode());
		updatedGdfFppMartDet.setDosageForm(fppMartModel.getDosageForm());
		updatedGdfFppMartDet.setNoPrimPackageUnits(Long.parseLong(fppMartModel.getNoOfPrimaryPackaging()));
		updatedGdfFppMartDet.setNoSecPackageUnits(Long.parseLong(fppMartModel.getNoOfSecondaryPackaging()));
		updatedGdfFppMartDet.setGdfFppMartApprStatus(fppMartModel.getFppMartStatus());
		updatedGdfFppMartDet.setTenderItemRefID(fppMartModel.getTenderItemNumber());

		GDFTenderSubFPPMatDetailsLocalServiceUtil.updateGDFTenderSubFPPMatDetails(updatedGdfFppMartDet);

	}

	/*
	 * public static void updateTenderSubSelectedItems(String tenderRefNumber)
	 * throws PortalException { _log.info("::::In update Method:::::" +
	 * tenderRefNumber);
	 * 
	 * GDFTenderSubmissionDetails gdfTenderUpdatedSubDetails =
	 * GDFTenderSubmissionDetailsLocalServiceUtil
	 * .getGDFTenderSubDetailsByTenderRefNumber(tenderRefNumber); if
	 * (Objects.equals(gdfTenderUpdatedSubDetails.getTenderReferenceNumber(),
	 * tenderRefNumber)) {
	 * gdfTenderUpdatedSubDetails.setTenderReferenceNumber(tenderRefNumber);
	 * 
	 * gdfTenderUpdatedSubDetails.setTenderStatus(gdfTenderDetails.getTenderStatus()
	 * );
	 * gdfTenderUpdatedSubDetails.setTenderTitle(tenderDetJson.get("title").toString
	 * ());
	 * gdfTenderUpdatedSubDetails.setMethod(tenderDetJson.get("method").toString());
	 * gdfTenderUpdatedSubDetails.setProductCategory(tenderDetJson.get(
	 * "productCategoryVal").toString());
	 * gdfTenderUpdatedSubDetails.setUserId(themeDisplay.getUserId());
	 * gdfTenderUpdatedSubDetails.setUserName(themeDisplay.getUser().getScreenName()
	 * ); gdfTenderUpdatedSubDetails .setPublicationDate(new
	 * Date(tenderDetJson.get("publicationDate").toString()));
	 * gdfTenderUpdatedSubDetails .setDeadlineForTechBidsSub(new
	 * Date(tenderDetJson.get("deadlineForTechBidsSub").toString()));
	 * 
	 * gdfTenderUpdatedSubDetails.setModifiedDate(gdfTenderUpdatedSubDetails.
	 * getModifiedDate()); gdfTenderUpdatedSubDetails.setTenderSubmissionStatus(
	 * GdfTenderSubmissionConstants.DRAFT);
	 * 
	 * GDFTenderSubmissionDetailsLocalServiceUtil.updateGDFTenderSubmissionDetails(
	 * gdfTenderUpdatedSubDetails); } }
	 * 
	 * 
	 * public static void addTenderSchedule(TenderItemDetailsModel tenderItemModel,
	 * long scheduleNumber, String scheduleName, String patientTarget, String
	 * tenderReferenceNumber) throws PortalException {
	 * 
	 * _log.info("::::::In addTenderSchedule method scheduleNumber::::::" +
	 * scheduleNumber + ", " + scheduleName + ", " + tenderReferenceNumber);
	 * 
	 * GDFTenderScheduleItem gdfTenderScheduleItem =
	 * GDFTenderScheduleItemLocalServiceUtil
	 * .createGDFTenderScheduleItem(CounterLocalServiceUtil.increment());
	 * 
	 * gdfTenderScheduleItem.setGdfGenericCode(tenderItemModel.getGdfGenericCode());
	 * gdfTenderScheduleItem.setTenderItemNumber(tenderItemModel.getTenderItemNumber
	 * ()); gdfTenderScheduleItem.setGeneralDescription(tenderItemModel.
	 * getGeneralDescription());
	 * gdfTenderScheduleItem.setPrimaryPackaging(tenderItemModel.getPrimaryPackaging
	 * ()); gdfTenderScheduleItem.setSecondaryPackaging(tenderItemModel.
	 * getSecondaryPackaging());
	 * 
	 * gdfTenderScheduleItem.setScheduleNumber(scheduleNumber);
	 * gdfTenderScheduleItem.setScheduleName(scheduleName);
	 * gdfTenderScheduleItem.setPatientTarget(patientTarget);
	 * gdfTenderScheduleItem.setTenderReferenceNumber(tenderReferenceNumber);
	 * 
	 * _log.info(":::::gdfTenderScheduleItem added::::::");
	 * 
	 * GDFTenderScheduleItemLocalServiceUtil.addGDFTenderScheduleItem(
	 * gdfTenderScheduleItem); }
	 */

	public static boolean isDBTenderItemNotPresentinJsonSchedulesList(List<TenderItemDetailsModel> tenderItems,
			long dbTenderRefId) {

		TenderItemDetailsModel tenderItemDetails = tenderItems.stream()
				.filter(ti -> Objects.equals(ti.getTenderItemRefId(), dbTenderRefId)).findAny().orElse(null);

		return tenderItemDetails == null;

	}

	// Method to view all uploaded file url
	public static void fileUploadUrl(GDFTenderSubmissionDetails gdfTenderSubmissionDetails,
			RenderRequest renderRequest) {

		HashMap<String, String> regCertificateFileName = new HashMap<String, String>();

		String[] urlArr = gdfTenderSubmissionDetails.getCopyOfRegCert().split(",");
		for (String url : urlArr) {
			String name[] = url.split("/");
			if (!url.isEmpty())
				regCertificateFileName.put(url.toString(), name[name.length - 1]);
		}
		renderRequest.setAttribute("regCertificateFileName", regCertificateFileName);

	}

}
