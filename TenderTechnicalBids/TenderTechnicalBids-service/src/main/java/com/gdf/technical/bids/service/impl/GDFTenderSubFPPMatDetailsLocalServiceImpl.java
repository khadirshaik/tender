/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gdf.technical.bids.service.impl;

import com.gdf.technical.bids.service.base.GDFTenderSubFPPMatDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;

/**
 * The implementation of the gdf tender sub fpp mat details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPMatDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails",
	service = AopService.class
)
public class GDFTenderSubFPPMatDetailsLocalServiceImpl
	extends GDFTenderSubFPPMatDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.gdf.technical.bids.service.GDFTenderSubFPPMatDetailsLocalServiceUtil</code>.
	 */
	
	public List<GDFTenderSubFPPMatDetails> getGDFTendRefDetailsSubFPPMatByUserId(String tenderReferenceNumber, long userId){

		return gdfTenderSubFPPMatDetailsPersistence.findByGDFTendRefSubFPPMatByUserId(tenderReferenceNumber, userId);

	}
	
	

	public List<GDFTenderSubFPPMatDetails> getGDFTenderFPPMartDetailsByFppMartId(long fppMarketId){

		return gdfTenderSubFPPMatDetailsPersistence.findByGDF_Tender_fppMarketID(fppMarketId);

	}
	
	public List<GDFTenderSubFPPMatDetails> getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(long fppMarketID, long userId, String gdfGenericCode, long scheduleNumber, String tenderReferenceNumber){

		return gdfTenderSubFPPMatDetailsPersistence.findByGDFTenderByFIDUIDGenCodeSNUTRN(fppMarketID, userId, gdfGenericCode, scheduleNumber, tenderReferenceNumber);

	}
	
	public List<GDFTenderSubFPPMatDetails> getGDFTenderFPPMartDetailsBySelectedStatus(boolean fppSelectedStatus){

		return gdfTenderSubFPPMatDetailsPersistence.findByFPP_Selected_Status(fppSelectedStatus);

	}
}