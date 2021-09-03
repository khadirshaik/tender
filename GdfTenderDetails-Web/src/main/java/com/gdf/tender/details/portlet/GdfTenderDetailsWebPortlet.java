package com.gdf.tender.details.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil;
import com.gdf.tender.details.bean.ScheduleDetailsModel;
import com.gdf.tender.details.constants.GdfTenderDetailsWebPortletKeys;
import com.gdf.tender.details.util.GdfTenderDetailUtil;
import com.gdf.tender.exception.NoSuchTenderSchedulesException;
import com.gdf.tender.model.TenderSchedules;
import com.gdf.tender.service.TenderSchedulesLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author KS61374
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=GDF",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GdfTenderDetailsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/listview.jsp",
		"javax.portlet.name=" + GdfTenderDetailsWebPortletKeys.GDFTENDERDETAILSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class GdfTenderDetailsWebPortlet extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(GdfTenderDetailsWebPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		_log.info("GDF tender details render method");
		


		User user = (User) renderRequest.getAttribute(WebKeys.USER);

		boolean hasGSORole = GdfTenderDetailUtil.checkIfUserhasGSORole(user);
		boolean hasGDFRole = GdfTenderDetailUtil.checkIfUserhasGDFRole(user);
		
		_log.info(":::user:::" + user.getFullName() + "::hasGSORole:::" + hasGSORole + "::hasGDFRole:::" + hasGDFRole);

		List<GDFTenderDetails> gdfTenderList = GDFTenderDetailsLocalServiceUtil.getGDFTenderDetailses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		_log.info("============In gdfTenderList details==============");
		renderRequest.setAttribute("gdfTenderList", gdfTenderList);
		
		renderRequest.setAttribute("hasGSORole", hasGSORole);
		renderRequest.setAttribute("hasGDFRole", hasGDFRole);
		
		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		JSONObject tenderRefJson = null;

		if ("proCategroyDropDown".equalsIgnoreCase(resourceRequest.getResourceID())) {
			String productCatVal = httpReq.getParameter("productCatVal");

			_log.info(":::productCatVal:::" + productCatVal);

			List<TenderSchedules> tenderschedList = TenderSchedulesLocalServiceUtil
					.getTenderScheduleses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			List<ScheduleDetailsModel> tenderProdCatList = new ArrayList<>();

			TenderSchedules tenderProdSchedules = null;
			for (TenderSchedules tenderSchedules : tenderschedList) {
				if(Objects.equals(productCatVal, tenderSchedules.getProductCategory())) {
				try {
					ScheduleDetailsModel schduleDetails = new ScheduleDetailsModel();
					 tenderProdSchedules = TenderSchedulesLocalServiceUtil.findByCategory_Sched(
							productCatVal, tenderSchedules.getScheduleNumber());
					 schduleDetails.setScheduleNumber(Long.parseLong(tenderProdSchedules.getScheduleNumber()));
					 schduleDetails.setScheduleName(tenderProdSchedules.getScheduleName());
					 schduleDetails.setPatientTarget(tenderProdSchedules.getPatientTarget());
					tenderProdCatList.add(schduleDetails);
				} catch (NoSuchTenderSchedulesException e) {
					e.printStackTrace();
				}
				}

			}
			_log.info("::::tenderProdCatList:::" + tenderProdCatList);
			
			
			JSONArray scheduleJsonArray = JSONFactoryUtil.createJSONArray(tenderProdCatList);
			tenderRefJson = JSONFactoryUtil.createJSONObject();
			tenderRefJson.put("scheduleJsonArray", scheduleJsonArray);
			
			_log.info("Partial resultJson wrt schedule::" + tenderRefJson.toJSONString());
			resourceResponse.getWriter().write(tenderRefJson.toJSONString());

		}

	}
	


}
