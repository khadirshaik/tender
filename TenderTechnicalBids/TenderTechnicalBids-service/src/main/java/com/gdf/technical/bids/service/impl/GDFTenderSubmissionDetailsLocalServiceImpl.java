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

import com.gdf.technical.bids.service.base.GDFTenderSubmissionDetailsLocalServiceBaseImpl;
import com.gdf.technical.bids.exception.NoSuchGDFTenderSubmissionDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the gdf tender submission details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubmissionDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gdf.technical.bids.model.GDFTenderSubmissionDetails",
	service = AopService.class
)
public class GDFTenderSubmissionDetailsLocalServiceImpl
	extends GDFTenderSubmissionDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.gdf.technical.bids.service.GDFTenderSubmissionDetailsLocalServiceUtil</code>.
	 */
	public GDFTenderSubmissionDetails getGDFTenderSubDetailsByTenderRefNumber(String tenderReferenceNumber)
			throws NoSuchGDFTenderSubmissionDetailsException {

		return gdfTenderSubmissionDetailsPersistence.findByGDF_Tender_Reference_Number(tenderReferenceNumber);

	}

	public GDFTenderSubmissionDetails getGDFTenderSubDetailsByTenderRefNumberAndUserId(String tenderReferenceNumber,
			long supplierId) throws NoSuchGDFTenderSubmissionDetailsException {

		return gdfTenderSubmissionDetailsPersistence.findByGDFTenderRefeNoByUserId(tenderReferenceNumber, supplierId);

	}

	public List<GDFTenderSubmissionDetails> getGDFTenderSubDetailsByUserId(long supplierId) {

		return gdfTenderSubmissionDetailsPersistence.findByGDFTendersByUserId(supplierId);

	}
	
}