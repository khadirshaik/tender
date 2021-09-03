package com.gdf.tender.details.routes;

import org.osgi.service.component.annotations.Component;

import com.gdf.tender.details.constants.GdfTenderDetailsWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		"javax.portlet.name=" + GdfTenderDetailsWebPortletKeys.GDFTENDERDETAILSWEB }, service = FriendlyURLMapper.class)
public class GdfTenderRoutesMapper extends DefaultFriendlyURLMapper {
	private static Log _log = LogFactoryUtil.getLog(GdfTenderRoutesMapper.class);

	@Override
	public String getMapping() {

		//_log.info(":::::In routes mapper friendly URL class");
		return "gdfTender";
	}

	/*@Override
	public boolean isCheckMappingWithPrefix() {
		return false;
	}
*/
}
