package com.gdf.tender.submission.util;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gdf.APIInformation.model.FppApiMapping;
import com.gdf.APIInformation.service.FppApiMappingLocalServiceUtil;
import com.gdf.APIInformation.service.PRTFPPAPIDetailsLocalServiceUtil;
import com.gdf.common.model.ManufacturingSiteDetail;
import com.gdf.common.model.WarehouseDetail;
import com.gdf.common.service.APIDetailLocalServiceUtil;
import com.gdf.common.service.ManufacturingSiteDetailLocalServiceUtil;
import com.gdf.common.service.WarehouseDetailLocalServiceUtil;
import com.gdf.fpp.market.model.FPPMarket;
import com.gdf.fpp.market.model.FPPMarketAPIMapping;
import com.gdf.fpp.market.model.FPPMarketMSiteMapping;
import com.gdf.fpp.market.model.FPPWarehousMapping;
import com.gdf.fpp.market.service.FPPMarketAPIMappingLocalServiceUtil;
import com.gdf.fpp.market.service.FPPMarketLocalServiceUtil;
import com.gdf.fpp.market.service.FPPMarketMSiteMappingLocalServiceUtil;
import com.gdf.fpp.market.service.FPPWarehousMappingLocalServiceUtil;
import com.gdf.fpp.reg.model.FPPRegistration;
import com.gdf.fpp.reg.service.FPPRegistrationLocalServiceUtil;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;
import com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalServiceUtil;
import com.gdf.tender.submission.bean.FPPMarketDetailsModel;
import com.gdf.tender.submission.bean.FPPRegDetailsModel;
import com.gdf.tender.submission.bean.ScheduleDetailsModel;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class Utility {

	private static Log _log = LogFactoryUtil.getLog(Utility.class);

	public static String getElapsedTime(Date startDate) {

		String elapsedTime = null;
		Date endDateTime = new Date();
		Map<TimeUnit, Long> result = computeDiff(startDate, endDateTime);

		Long days = result.get(TimeUnit.DAYS);
		Long hours = result.get(TimeUnit.HOURS);
		Long minutes = result.get(TimeUnit.MINUTES);
		Long seconds = result.get(TimeUnit.SECONDS);

		if (days != 0) {
			if (days == 1)
				elapsedTime = days + " " + "day" + " " + "ago";
			else
				elapsedTime = days + " " + "days" + " " + "ago";
		} else if (hours != 0) {
			if (hours == 1)
				elapsedTime = hours + " " + "hour" + " " + "ago";
			else
				elapsedTime = hours + " " + "hours" + " " + "ago";
		} else if (minutes != 0) {
			if (minutes == 1)
				elapsedTime = minutes + " " + "minute" + " " + "ago";
			else
				elapsedTime = minutes + " " + "minutes" + " " + "ago";
		} else {
			if (seconds == 1 || seconds == 0)
				elapsedTime = seconds + " " + "second" + " " + "ago";
			if (seconds != 1 || seconds != 0)
				elapsedTime = seconds + " " + "seconds" + " " + "ago";
		}

		return elapsedTime;
	}

	public static Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
		long diffInMilliSeconds = date2.getTime() - date1.getTime();
		List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
		Collections.reverse(units);
		Map<TimeUnit, Long> result = new LinkedHashMap<TimeUnit, Long>();
		long milliSecondsRest = diffInMilliSeconds;
		for (TimeUnit unit : units) {
			long diff = unit.convert(milliSecondsRest, TimeUnit.MILLISECONDS);
			long diffInMilliSecondsForUnit = unit.toMillis(diff);
			milliSecondsRest = milliSecondsRest - diffInMilliSecondsForUnit;
			result.put(unit, diff);
		}
		return result;
	}

	public static void writeFPPMarketSheet(File file, String supplierName, String gdfTenderRefNo, long supplierId) {

		_log.info("inside write file for download");
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			List<GDFTenderSubFPPMatDetails> gdfFppMartDetList = GDFTenderSubFPPMatDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPMatByUserId(gdfTenderRefNo, supplierId);
			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.preparePrdSelectedDetails(gdfFppMartDetList, supplierId, gdfTenderRefNo);
			List<ScheduleDetailsModel> scheduleNameList = new ArrayList<>();
			scheduleNameList.addAll(schedList);
			XSSFWorkbook workbook = new XSSFWorkbook();
			for (ScheduleDetailsModel tenderSubFPPMatDetails : scheduleNameList) {

				// Creating Workbook instances

				XSSFSheet spreadsheet = workbook
						.createSheet("Technical Bids Schedule" + tenderSubFPPMatDetails.getScheduleNumber() + " Info ");

				// Sheet styling

				// Text wrap
				CellStyle cs = workbook.createCellStyle();
				CellStyle header = workbook.createCellStyle();
				cs.setWrapText(true);
				// cs.setAlignment(header.ALIGN_CENTER);
				cs.setAlignment(HorizontalAlignment.CENTER);

				CellStyle forGC = workbook.createCellStyle();
				forGC.setWrapText(true);
				// forGC.setAlignment(header.ALIGN_CENTER);
				forGC.setAlignment(HorizontalAlignment.CENTER);
				forGC.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
				// forGC.setFillPattern(CellStyle.SOLID_FOREGROUND);
				forGC.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				
				CellStyle forBC = workbook.createCellStyle();
				forBC.setWrapText(true);
				// forGC.setAlignment(header.ALIGN_CENTER);
				forBC.setAlignment(HorizontalAlignment.CENTER);
				//forGC.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				// forGC.setFillPattern(CellStyle.SOLID_FOREGROUND);
				forBC.setFillBackgroundColor(IndexedColors.OLIVE_GREEN.getIndex());
				forBC.setFillPattern(FillPatternType.BIG_SPOTS);
				
				// Adding to header
				Font font = workbook.createFont();
				font.setFontHeightInPoints((short) 11);
				font.setFontName(HSSFFont.FONT_ARIAL);
				// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				font.setBold(true);
				header.setFont(font);
				header.setWrapText(true);
				// header.setAlignment(header.ALIGN_CENTER);
				header.setAlignment(HorizontalAlignment.CENTER);

				String[] columnsFppMarket = { "GDF Tender reference Number", "Tender Item Number", "Schedule Number", "FPP GDF generic code",
						"FPP Dosage form", "FPP Product specifications", "FPP Primary packaging type",
						"Comments related to FPP primary packaging type",
						"Number of units per FPP primary packaging type", "FPP Secondary packaging type ",
						"Comments related to FPP secondary packaging type",
						"Number of units per FPP secondary packaging type",
						/* "Supplier_HQ_Name_Add","Supplier_HQ_Country", */"Subcontractor for FPP?",
						"Name of Subcontractor", "Address of Subcontractor", "Country of Subcontractor",
						"Quality status of FPP", "FPP WHO PQP number", "SRA country issuing registration for FPP",
						"SRA registration number for FPP", "ERP validity date", "EMA Approved date for FPP",
						"EMA reference number", "Is the FPP registered in the manufacturing country?",
						"Shelf life (months) of FPP (as accepted/approvedby WHO PQP/ SRA and/or ERP)",
						"Comments related to shelf life of FPP", "Storage conditions of FPP",
						"Comments related to storage conditions of FPP",
						/* "Total_API_Number", */"Point of collection of the FPP",
						"Production capacity of FPP in basic units (tablet, vial) per week",
						"Comments related to production capacity of FPP", "Batch size quantity in basic units for FPP",
						"Comments related to batch size of FPP",
						"GDF ceiling quantity in basic units of FPP for regular quantity",
						"Guaranteed delivery lead time for FPP after purchase order placement (in weeks-Regular Quantity)",
						"Guaranteed delivery lead time for FPP after purchase order placement (in weeks High Quantity)",
						"Minimum Order Quantity in basic units (tablets, vials) for FPP",
						/* "Number_of_Warehouses", */"Additional comments in regard to safety/buffer stock for this FPP",
						/* "Stock_Availability", */"Secondary packaging dimension in cm - LENGHT",
						"Secondary packaging dimension in cm - WIDTH", "Secondary packaging dimension in cm - HEIGHT",
						"Secondary packaging volume in cubic meters", "Secondary packaging WEIGHT in Kg",
						"Number of secondary packing in tertiary packaging (Export shipper box)",
						"Tertiary packaging (Export shipper box) dimension in cm - LENGHT",
						"Tertiary packaging (Export shipper box) dimension in cm - WIDTH",
						"Tertiary packaging (Export shipper box) dimension in cm - HEIGHT",
						"Tertiary packaging (Export shipper box) volume in cubic meter",
						"Tertiary packaging (Export shipper box) \r\n" + "WEIGHT in Kg",
						"Number of tertiary packaging in a pallet", "Select type of pallet for transportation",
						"Warehouse Name", "Warehouse Address", "Warehouse Country",
						"Storage Capacity (# of tertiary packs)", "Manufacturing site of FPP: Name",
						"Manufacturing site of FPP: Address", "Manufacturing site of FPP: Country", "INN",
						"Name of API Manufacturer", "API Manufacturing Site Address", "% split between sites" };
				// String[] columnsWarehouse = {"Warehouse Name", "Warehouse Address",
				// "Warehoust Country"};

				for (int i = 0; i < columnsFppMarket.length; i++) {
					XSSFRow row = spreadsheet.createRow(i);
					spreadsheet.setColumnWidth(i, 8000);

					Cell cell = row.createCell(0);
					cell.setCellStyle(header);
					cell.setCellValue(columnsFppMarket[i]);
					cell.setCellStyle(forGC);
					int cellNo = 1;
					List<FPPMarketDetailsModel> fppMartModelList = tenderSubFPPMatDetails.getFppMartModelList();
					for (FPPMarketDetailsModel scheduleDetailsModel : fppMartModelList) {
						List<FPPMarket> marketList = FPPMarketLocalServiceUtil
								.findByFPPMarketByMarketId(scheduleDetailsModel.getFppMarketId());
						for (FPPMarket market : marketList) {
							cell = row.createCell(cellNo);
							cell.setCellStyle(cs);
							cell.setCellStyle(forBC);
							if (i == 0) {
								cell.setCellValue(scheduleDetailsModel.getTenderReferenceNumber());
							cell.setCellStyle(forBC);
							}
							if (i == 1)
							cell.setCellValue(scheduleDetailsModel.getTenderItemNumber());
							
							if (i == 2)
								cell.setCellValue(tenderSubFPPMatDetails.getScheduleNumber());

							if (i == 3) 
								cell.setCellValue(market.getGdfGenericCode());
								
							if (i == 4)
								cell.setCellValue(market.getDosageForm());
							if (i == 5)
								cell.setCellValue(market.getProdSpec());
							if (i == 6)
								cell.setCellValue(market.getPrimPackageDesc());
							if (i == 7)
								cell.setCellValue(market.getPrimPackageComments());
							if (i == 8)
								cell.setCellValue(market.getPrimPackageUnits());
							if (i == 9)
								cell.setCellValue(market.getSecPackageDesc());
							if (i == 10)
								cell.setCellValue(market.getSecPackageComments());
							if (i == 11)
								cell.setCellValue(market.getSecPackageUnits());
							if (i == 12)
								cell.setCellValue(market.getSubContractorPresent());
							if (i == 13)
								cell.setCellValue(market.getSubContractorName());
							if (i == 14)
								cell.setCellValue(market.getSubcontractorCountry());
							if (i == 15)
								cell.setCellValue(market.getSubcontractorCountry());
							if (i == 16)
								cell.setCellValue(market.getQualityStatus());
							if (i == 17)
								cell.setCellValue(market.getWHO_pqp_Number());
							if (i == 18)
								cell.setCellValue(market.getSraCountry());
							if (i == 19)
								cell.setCellValue(market.getSraRegDetails());

							if (i == 20) {
								Date erpValidityDt = market.getErpValidaityDt();
								if (erpValidityDt != null) {
									cell.setCellValue(simpleDateFormat.format(erpValidityDt));
								} else {
									cell.setCellValue("");
								}
							}
							if (i == 21) {
								Date emaApprovalDt = market.getEmaApprovalDt();
								if (emaApprovalDt != null) {
									cell.setCellValue(simpleDateFormat.format(emaApprovalDt));
								} else {
									cell.setCellValue("");
								}
							}
							if (i == 22)
								cell.setCellValue(market.getEmaRefNumber());

							if (i == 23)
								cell.setCellValue(market.getRegManCou());
							if (i == 24)
								cell.setCellValue(market.getShelfLife());
							if (i == 25)
								cell.setCellValue(market.getShelfLifeComment());

							if (i == 26)
								cell.setCellValue(market.getStorageConditions());
							if (i == 27)
								cell.setCellValue(market.getStorageConditionsComments());
							if (i == 28)
								cell.setCellValue(market.getFppPointCollection());
							if (i == 29)
								cell.setCellValue(market.getTotalCapacityUnits());
							if (i == 30)
								cell.setCellValue(market.getProdCapacityComments());
							if (i == 31)
								cell.setCellValue(market.getBatchSizeQty());
							if (i == 32)
								cell.setCellValue(market.getBatchSizeComments());
							if (i == 33)
								cell.setCellValue(market.getDelLeadTimeStaircaseUnits());
							if (i == 34)
								cell.setCellValue(market.getDelTimePurchaseRegQty());
							if (i == 35)
								cell.setCellValue(market.getDelTimePurchaseHighQty());
							if (i == 36)
								cell.setCellValue(market.getMinOrderQty());
							if (i == 37)
								cell.setCellValue(market.getWarehouseComment());
							if (i == 38)
								cell.setCellValue(market.getSecPackageLengthDim());
							if (i == 39)
								cell.setCellValue(market.getSecPackageWidthDim());
							if (i == 40)
								cell.setCellValue(market.getSecPackageHeightDim());
							if (i == 41)
								cell.setCellValue(market.getSecPackageVol());
							if (i == 42)
								cell.setCellValue(market.getSecPackageWeight());
							if (i == 43)
								cell.setCellValue(market.getNoofSecTerPack());
							if (i == 44)
								cell.setCellValue(market.getTertiaryPackLength());
							if (i == 45)
								cell.setCellValue(market.getTertiaryPackWidth());
							if (i == 46)
								cell.setCellValue(market.getTertiaryPackHeight());
							if (i == 47)
								cell.setCellValue(market.getTertiaryPackVol());
							if (i == 48)
								cell.setCellValue(market.getTertiaryPackWeight());
							if (i == 49)
								cell.setCellValue(market.getNoofTerPackInPallet());
							if (i == 50)
								cell.setCellValue(market.getPalletType());

							// warehouse details
							if (i == 52 || i == 53 || i == 54 || i == 51) {

								List<String> wareHouseNameList = new ArrayList<String>();
								List<String> wareHouseAddressList = new ArrayList<String>();
								List<String> wareHouseCountryList = new ArrayList<String>();
								List<String> wareHouseStorageCapacityList = new ArrayList<String>();

								List<FPPWarehousMapping> whMapping = FPPWarehousMappingLocalServiceUtil
										.findByFPPMarketID(market.getFppMarketID());

								for (FPPWarehousMapping wareModel : whMapping) {
									WarehouseDetail wareHouseDet = WarehouseDetailLocalServiceUtil
											.getWarehouseDetail(wareModel.getWarehouseDetailsId());
									wareHouseNameList.add(wareHouseDet.getWarehouseName());
									wareHouseAddressList.add(wareHouseDet.getWarehouseAddress());
									wareHouseCountryList.add(wareHouseDet.getWarehouseCountry());
									wareHouseStorageCapacityList
											.add(Long.toString(wareHouseDet.getWarehouseStorageCapacity()));
								}
								if (i == 51) {
									cell.setCellValue(getCommaSeparatedString(wareHouseNameList));
								}
								if (i == 52) {
									cell.setCellValue(getCommaSeparatedString(wareHouseAddressList));
								}
								if (i == 53) {
									cell.setCellValue(getCommaSeparatedString(wareHouseCountryList));
								}
								if (i == 54) {
									cell.setCellValue(getCommaSeparatedString(wareHouseStorageCapacityList));
								}

							}

							// manufacture site details
							if (i == 55 || i == 56 || i == 57) {
								List<String> mSiteNameList = new ArrayList<String>();
								List<String> mSiteAddressList = new ArrayList<String>();
								List<String> mSiteCountryList = new ArrayList<String>();

								List<FPPMarketMSiteMapping> mSiteList = FPPMarketMSiteMappingLocalServiceUtil
										.findByFPPMarketID(market.getFppMarketID());

								for (FPPMarketMSiteMapping fppMSite : mSiteList) {
									ManufacturingSiteDetail mSiteDet = ManufacturingSiteDetailLocalServiceUtil
											.getManufacturingSiteDetail(fppMSite.getManufacturingSiteId());
									mSiteNameList.add(mSiteDet.getManufSiteName());
									mSiteAddressList.add(mSiteDet.getManufSiteAdd());
									mSiteCountryList.add(mSiteDet.getManufSiteCountry());
								}

								if (i == 55) {
									cell.setCellValue(getCommaSeparatedString(mSiteNameList));
								}
								if (i == 56) {
									cell.setCellValue(getCommaSeparatedString(mSiteAddressList));
								}
								if (i == 57) {
									cell.setCellValue(getCommaSeparatedString(mSiteCountryList));
								}

							}

							// Api manufacturer details
							if (i == 58 || i == 59 || i == 60 || i == 61) {

								List<String> innList = new ArrayList<String>();
								List<String> apiManufacturerList = new ArrayList<String>();
								List<String> apiManufacturerAddressList = new ArrayList<String>();
								List<String> sitePercentageList = new ArrayList<String>();

								List<FPPMarketAPIMapping> apiList = FPPMarketAPIMappingLocalServiceUtil
										.findByFPPMarketID(market.getFppMarketID());

								for (FPPMarketAPIMapping currentRec : apiList) {

									sitePercentageList.add(String.valueOf(currentRec.getSitepercentage()));

									DynamicQuery queryMapTable = FppApiMappingLocalServiceUtil.dynamicQuery();
									queryMapTable.add(PropertyFactoryUtil.forName("FppApiMappingId")
											.eq(currentRec.getApidetailsId()));
									List<FppApiMapping> mappingList = FppApiMappingLocalServiceUtil
											.dynamicQuery(queryMapTable);

									if (!mappingList.isEmpty()) {

										FppApiMapping fppApiMappingInstance = FppApiMappingLocalServiceUtil
												.getFppApiMapping(currentRec.getApidetailsId());
										innList.add(PRTFPPAPIDetailsLocalServiceUtil
												.getPRTFPPAPIDetails(fppApiMappingInstance.getFppApiId()).getINN());
										apiManufacturerList.add(PRTFPPAPIDetailsLocalServiceUtil
												.getPRTFPPAPIDetails(fppApiMappingInstance.getFppApiId())
												.getManuName());
										apiManufacturerAddressList.add(APIDetailLocalServiceUtil
												.getAPIDetail(fppApiMappingInstance.getApiDetailId())
												.getApiManfAddress());

									}

								}
								if (i == 58) {
									cell.setCellValue(getCommaSeparatedString(innList));
								}
								if (i == 59) {
									cell.setCellValue(getCommaSeparatedString(apiManufacturerList));
								}
								if (i == 60) {
									cell.setCellValue(getCommaSeparatedString(apiManufacturerAddressList));
								}
								if (i == 61) {
									cell.setCellValue(getCommaSeparatedString(sitePercentageList));
								}

							}

							cellNo++;

						}

					}
				}
			}
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);

			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeFPPRegSheet(File file, String supplierName, String gdfTenderRefNo, long supplierId) {

		_log.info("inside write file for download");
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			List<GDFTenderSubFPPRegDetails> gdfFppRegDetList = GDFTenderSubFPPRegDetailsLocalServiceUtil
					.getGDFTendRefDetailsSubFPPRegByUserId(gdfTenderRefNo, supplierId);
			Set<ScheduleDetailsModel> schedList = GdfTenderSubmissionDetailUtil
					.prepareExcelFPPRegDetails(gdfFppRegDetList, supplierId);
			List<ScheduleDetailsModel> scheduleNameList = new ArrayList<>();
			scheduleNameList.addAll(schedList);
			XSSFWorkbook workbook = new XSSFWorkbook();
			for (ScheduleDetailsModel tenderSubFPPRegDetails : scheduleNameList) {

				// Creating Workbook instances

				XSSFSheet spreadsheet = workbook
						.createSheet("Country product registration" + tenderSubFPPRegDetails.getScheduleNumber());

				// Sheet styling

				// Text wrap
				CellStyle cs = workbook.createCellStyle();
				CellStyle header = workbook.createCellStyle();
				cs.setWrapText(true);
				cs.setAlignment(HorizontalAlignment.CENTER);

				CellStyle forGC = workbook.createCellStyle();
				forGC.setWrapText(true);
				forGC.setAlignment(HorizontalAlignment.CENTER);
				forGC.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
				forGC.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				CellStyle forBC = workbook.createCellStyle();
				forBC.setWrapText(true);
				// forGC.setAlignment(header.ALIGN_CENTER);
				forBC.setAlignment(HorizontalAlignment.CENTER);
				//forGC.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				// forGC.setFillPattern(CellStyle.SOLID_FOREGROUND);
				forBC.setFillBackgroundColor(IndexedColors.OLIVE_GREEN.getIndex());
				forBC.setFillPattern(FillPatternType.BIG_SPOTS);
				
				// Adding to header
				Font font = workbook.createFont();
				font.setFontHeightInPoints((short) 11);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setBold(true);
				header.setFont(font);
				header.setWrapText(true);
				header.setAlignment(HorizontalAlignment.CENTER);

				String[] columnsFppMarket = { "GDF Tender reference Number", "Tender Item Number", "Schedule Number", "FPP GDF generic code", "FPP Dosage form",
						"FPP Primary packaging Desription", "FPP Secondary packaging size", "FPP Quality Status",
						"Registration Name", "Supplier Name", "FPP Registration Country Name",
						"Registration Brand Name", "Registration Status", "FPP Registration Number ",
						"Registration From Date", "Registration Expiry Date", "Has Same QA Status?",
						"Is Annual Registration required?", "FPP Shelf Life", "Shelf Life Expiry Date",
						"Storage Conditions", "Is Packaging Design Registration?",
						"Comments Of Packaging Design Registration", "Number of countries of registration" };

				for (int i = 0; i < columnsFppMarket.length; i++) {
					XSSFRow row = spreadsheet.createRow(i);
					spreadsheet.setColumnWidth(i, 8000);

					Cell cell = row.createCell(0);
					cell.setCellStyle(header);
					cell.setCellValue(columnsFppMarket[i]);
					cell.setCellStyle(forGC);
					int cellNo = 1;
					
					List<FPPRegDetailsModel> fppMartModelList = tenderSubFPPRegDetails.getFppRegDetailsModel();
					for (FPPRegDetailsModel scheduleDetailsModel : fppMartModelList) {
						List<FPPRegistration> fppRegList = FPPRegistrationLocalServiceUtil
								.findByFPPRegistrationId(Long.parseLong(scheduleDetailsModel.getFppRegId()));
						for (FPPRegistration registration : fppRegList) {
							cell = row.createCell(cellNo);
							cell.setCellStyle(cs);
							cell.setCellStyle(forBC);
							if (i == 0) {
								cell.setCellValue(scheduleDetailsModel.getTenderReferenceNumber());
							cell.setCellStyle(forBC);
							}
							if (i == 1)
								cell.setCellValue(scheduleDetailsModel.getTenderItemNumber());
							if (i == 2)
								cell.setCellValue(tenderSubFPPRegDetails.getScheduleNumber());
							if (i == 3) 
								cell.setCellValue(registration.getGdfGenericCode());
							if (i == 4)
								cell.setCellValue(registration.getDosageForm());
							if (i == 5)
								cell.setCellValue(registration.getPrimPackageDesc());
							if (i == 6)
								cell.setCellValue(registration.getSecPackagingSize());
							if (i == 7)
								cell.setCellValue(registration.getQualityStatus());
							if (i == 8)
								cell.setCellValue(registration.getRegistrationName());
							if (i == 9)
								cell.setCellValue(registration.getSupplierName());
							if (i == 10)
								cell.setCellValue(registration.getRegCountry());
							if (i == 11)
								cell.setCellValue(registration.getRegBrandName());
							if (i == 12)
								cell.setCellValue(registration.getRegStatus());
							if (i == 13)
								cell.setCellValue(registration.getRegNumber());
							if (i == 14) {

								Date erpValidityDt = registration.getRegFromDate();
								if (erpValidityDt != null) {
									cell.setCellValue(simpleDateFormat.format(erpValidityDt));
								} else {
									cell.setCellValue("");
								}
							}
							if (i == 15) {
								Date emaApprovalDt = registration.getRegExpiryDate();
								if (emaApprovalDt != null) {
									cell.setCellValue(simpleDateFormat.format(emaApprovalDt));
								} else {
									cell.setCellValue("");
								}
							}
							if (i == 16)
								cell.setCellValue(registration.getHasSameQAStatus());
							if (i == 17)
								cell.setCellValue(registration.getIsAnnualRegRequired());
							if (i == 18) {
								cell.setCellValue(registration.getShelfLife());
							}
							if (i == 19) {

								Date erpValidityDt = registration.getShelfLifeExtDate();
								if (erpValidityDt != null) {
									cell.setCellValue(simpleDateFormat.format(erpValidityDt));
								} else {
									cell.setCellValue("");
								}
							}
							if (i == 20) {
								cell.setCellValue(registration.getStorageConditions());
							}
							if (i == 21) {
								cell.setCellValue(registration.getIsPackDesignReg());
							}
							if (i == 22)
								cell.setCellValue(registration.getPackDesignRegComment());
							if (i == 23) {
								String[] regSize = { registration.getRegCountry() };
								_log.info(":::regSize:::"+regSize.length);
								cell.setCellValue(regSize.length);
							}
							cellNo++;

						}

					}
				}
				
			}
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);

			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getCommaSeparatedString(List<String> names) {
		return String.join(",", names);
	}

	/* To return screen name of supplier */
	public static String getScreenNameById(long userId) {
		String screenName = "";
		try {
			screenName = UserLocalServiceUtil.getUser(userId).getScreenName();
		} catch (PortalException e) {
			_log.info("exception in utility to fetch supplier screenname");

		}
		if (screenName == null || screenName.isEmpty()) {
			return screenName;
		}
		return screenName.substring(0, 1).toUpperCase() + screenName.substring(1);
	}

	public static String firstCharacterInUpperCase(String name) {
		if (name.length() > 0) {
			return name.substring(0, 1).toUpperCase() + name.substring(1);
		} else {
			return "";
		}
	}

	public static String formatDate(Date date) throws ParseException {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
		return formattedDate.format(date);
	}

	public static String convertExponentToNumeric(double num) {
		return BigDecimal.valueOf(num).toPlainString();
		// return String.format("%.9f", BigDecimal.valueOf(num).toPlainString())
	}

}
