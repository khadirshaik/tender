package com.gdf.tender.submission.portlet;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.gdf.common.model.Product;
import com.gdf.common.service.ProductLocalServiceUtil;
import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil;
import com.gdf.tender.model.ProductCategories;
import com.gdf.tender.model.TenderSchedules;
import com.gdf.tender.service.ProductCategoriesLocalServiceUtil;
import com.gdf.tender.service.TenderSchedulesLocalServiceUtil;
import com.gdf.tender.submission.constants.GdfTenderSubmissionWebPortletKeys;
import com.gdf.tender.submission.util.GdfTenderSubmissionDetailUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.PortalUtil;


@Component(
		 property = {
		 "javax.portlet.name=" + GdfTenderSubmissionWebPortletKeys.GDFTENDERSUBMISSIONWEB,
		 "mvc.command.name=gdf_tenderRef_dropDown"
		 },
		 service = MVCResourceCommand.class
		 )
public class GdfTenderSubResourceCommand extends BaseMVCResourceCommand{
	private static Log _log = LogFactoryUtil.getLog(GdfTenderSubResourceCommand.class);
	
	 @Override
	 protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	 throws Exception {
	 
	_log.info("In gdfSubmission module Resource cmd ");
	
	 HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(resourceRequest));
	 
	 String tenderReferenceNumber = httpReq.getParameter("tenderReferenceNumber");

		_log.info(":::::tenderReferenceNumber in editMVCCMD class:::" + tenderReferenceNumber);

		List<GDFTenderScheduleItem> gdfTenderScheduleItemList = GDFTenderScheduleItemLocalServiceUtil
				.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);

		resourceRequest.setAttribute("gdfScheduleList",
				GdfTenderSubmissionDetailUtil.prepareScheduleDetails(gdfTenderScheduleItemList));

		List<ProductCategories> prdCategoryList = ProductCategoriesLocalServiceUtil
				.getProductCategorieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		resourceRequest.setAttribute("prdCategoryList", prdCategoryList);

		GDFTenderDetails gdfTenderList = GDFTenderDetailsLocalServiceUtil
				.getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);

		resourceRequest.setAttribute("gdfTenderListEdit", gdfTenderList);

		List<Product> productGenricList = ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		resourceRequest.setAttribute("productGenricList", productGenricList);

		List<TenderSchedules> tenderschedList = TenderSchedulesLocalServiceUtil.getTenderScheduleses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		resourceRequest.setAttribute("tenderschedList", tenderschedList);
	 
	 }

}
