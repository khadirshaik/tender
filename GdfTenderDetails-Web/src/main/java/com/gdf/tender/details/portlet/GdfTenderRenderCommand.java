package com.gdf.tender.details.portlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import static com.gdf.tender.details.constants.GdfTenderConstants.*;

import com.gdf.common.model.Product;
import com.gdf.common.service.ProductLocalServiceUtil;
import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil;
import com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil;
import com.gdf.tender.details.constants.GdfTenderDetailsWebPortletKeys;


import com.gdf.tender.details.util.GdfTenderDetailUtil;
import com.gdf.tender.exception.NoSuchTenderSchedulesException;
import com.gdf.tender.model.ProductCategories;
import com.gdf.tender.model.TenderSchedules;
import com.gdf.tender.service.ProductCategoriesLocalServiceUtil;
import com.gdf.tender.service.TenderSchedulesLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(property = { "javax.portlet.name=" + GdfTenderDetailsWebPortletKeys.GDFTENDERDETAILSWEB,
		"mvc.command.name=renderTenderDetails_Info" }, service = MVCRenderCommand.class)
public class GdfTenderRenderCommand implements MVCRenderCommand {
	private static Log _log = LogFactoryUtil.getLog(GdfTenderRenderCommand.class);

	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("In GdfTenderEditDetailsCmd ");

		String jspPath = ParamUtil.getString(renderRequest, "_jspPath");
		
		String cmdName = ParamUtil.getString(renderRequest, "cmd");
		_log.info("#jspPath# cmdName#" + jspPath + " " +cmdName);
		try {
			if (Objects.equals(cmdName, RENDER_CREATE_TENDER_DETAILS)) {
				createTenderPage(renderRequest, renderResponse);

			} else if (Objects.equals(cmdName, RENDER_EDIT_TENDER_DETAILS)) {

				renderEditTenderDetails(renderRequest, renderResponse);

			}
		} catch (Exception e) {
			_log.error("Exception rendering in Jsp page",e);
			return ERROR;
		}
		return jspPath;
	}

	public void renderEditTenderDetails(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		String tenderReferenceNumber = ParamUtil.getString(renderRequest, "tenderReferenceNumber");

		_log.info(":::::tenderReferenceNumber in editMVCCMD class:::" + tenderReferenceNumber);

		List<GDFTenderScheduleItem> gdfTenderScheduleItemList = GDFTenderScheduleItemLocalServiceUtil
				.getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);

		renderRequest.setAttribute("gdfScheduleList",
				GdfTenderDetailUtil.prepareScheduleDetails(gdfTenderScheduleItemList));

		List<ProductCategories> prdCategoryList = ProductCategoriesLocalServiceUtil
				.getProductCategorieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute("prdCategoryList", prdCategoryList);

		GDFTenderDetails gdfTenderList = GDFTenderDetailsLocalServiceUtil
				.getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);

		renderRequest.setAttribute("gdfTenderListEdit", gdfTenderList);

		List<Product> productGenricList = ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute("productGenricList", productGenricList);

		List<TenderSchedules> tenderschedList = TenderSchedulesLocalServiceUtil.getTenderScheduleses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		renderRequest.setAttribute("tenderschedList", tenderschedList);

	}

	public void createTenderPage(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		List<ProductCategories> prdCategoryList = ProductCategoriesLocalServiceUtil
				.getProductCategorieses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute("prdCategoryList", prdCategoryList);

		List<TenderSchedules> tenderschedList = TenderSchedulesLocalServiceUtil.getTenderScheduleses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		/*
		List<TenderSchedules> tenderProdCatList = new ArrayList<>();
		
		
		for (ProductCategories prodCategories : prdCategoryList) {
			for (TenderSchedules tenderSchedules : tenderschedList) {
				if(Objects.equals(prodCategories.getProductCategory(), tenderSchedules.getProductCategory())) {
					try {
						TenderSchedules tenderProdSchedules = TenderSchedulesLocalServiceUtil.findByCategory_Sched(prodCategories.getProductCategory(), tenderSchedules.getScheduleNumber());
						tenderProdCatList.add(tenderProdSchedules);
					} catch (NoSuchTenderSchedulesException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}
		_log.info("::::tenderProdCatList:::"+tenderProdCatList);*/
		renderRequest.setAttribute("tenderschedList", tenderschedList);
		
		List<Product> productGenricList = ProductLocalServiceUtil.getProducts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute("productGenricList", productGenricList);

	}

}
