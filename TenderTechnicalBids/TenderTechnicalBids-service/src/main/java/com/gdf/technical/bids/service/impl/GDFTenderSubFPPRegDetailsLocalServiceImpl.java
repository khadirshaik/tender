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

import com.gdf.technical.bids.service.base.GDFTenderSubFPPRegDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;

/**
 * The implementation of the gdf tender sub fpp reg details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails",
	service = AopService.class
)
public class GDFTenderSubFPPRegDetailsLocalServiceImpl
	extends GDFTenderSubFPPRegDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.gdf.technical.bids.service.GDFTenderSubFPPRegDetailsLocalServiceUtil</code>.
	 */
	
	public List<GDFTenderSubFPPRegDetails> getGDFTendRefDetailsSubFPPRegByUserId(String tenderReferenceNumber, long userId){

		return gdfTenderSubFPPRegDetailsPersistence.findByGDFTendRefSubFPPRegByUserId(tenderReferenceNumber, userId);

	}
	
	

	public List<GDFTenderSubFPPRegDetails> getGDFTenderFPPRegDetailsByFppMartId(long fppRegistrationId){

		return gdfTenderSubFPPRegDetailsPersistence.findByFPP_Registration_ID(fppRegistrationId);

	}
	
	public List<GDFTenderSubFPPRegDetails> getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(long scheduleNumber, long userId, String tenderReferenceNumber, String gdfGenericCode, long fppRegistrationId){

		return gdfTenderSubFPPRegDetailsPersistence.findByGDFTenderBySNUAndTRNUGenCodeFID(scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode, fppRegistrationId);

	}

	
}