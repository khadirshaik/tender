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

import com.gdf.technical.bids.service.base.GDFTenderDetailsLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;
import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.model.GDFTenderDetails;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the gdf tender details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gdf.technical.bids.service.GDFTenderDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gdf.technical.bids.model.GDFTenderDetails",
	service = AopService.class
)
public class GDFTenderDetailsLocalServiceImpl
	extends GDFTenderDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gdf.technical.bids.service.GDFTenderDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.gdf.technical.bids.service.GDFTenderDetailsLocalServiceUtil</code>.
	 */
	public GDFTenderDetails getGDFTenderDetailsByTenderRefNumber(String tenderReferenceNumber) throws NoSuchGDFTenderDetailsException {
		
		return gdfTenderDetailsPersistence.findByGDF_Tender_Reference_Number(tenderReferenceNumber);
		
		
	}
	
public GDFTenderDetails getGDFTenderDetailsByTenderRefNumberAndUserId(String tenderReferenceNumber, long userId) throws NoSuchGDFTenderDetailsException {
		
		return gdfTenderDetailsPersistence.findByGDFTenderRefeNoByUserId(tenderReferenceNumber, userId);
		
		
	}

public List<GDFTenderDetails> getGDFTenderDetailsByUserId(long userId) throws NoSuchGDFTenderDetailsException {
	
	return gdfTenderDetailsPersistence.findByGDFTendersByUserId(userId);
	
	
}
	
}