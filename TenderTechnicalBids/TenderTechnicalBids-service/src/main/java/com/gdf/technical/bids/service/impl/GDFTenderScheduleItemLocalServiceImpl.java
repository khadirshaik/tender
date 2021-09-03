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

import java.util.List;
import com.gdf.technical.bids.service.base.GDFTenderScheduleItemLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.exception.NoSuchGDFTenderScheduleItemException;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the gdf tender schedule item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gdf.technical.bids.service.GDFTenderScheduleItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderScheduleItemLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gdf.technical.bids.model.GDFTenderScheduleItem",
	service = AopService.class
)
public class GDFTenderScheduleItemLocalServiceImpl
	extends GDFTenderScheduleItemLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gdf.technical.bids.service.GDFTenderScheduleItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.gdf.technical.bids.service.GDFTenderScheduleItemLocalServiceUtil</code>.
	 */
	
public List<GDFTenderScheduleItem> getGDFTenderScheduleItemByTenderRefNumber(String tenderReferenceNumber) throws NoSuchGDFTenderDetailsException {
		
		return gdfTenderScheduleItemPersistence.findByGDF_Tender_Reference_Number(tenderReferenceNumber);
		
	}

public List<GDFTenderScheduleItem> getGDFTenderScheduleItemByItemNumberAndUserId(long tenderItemNumber, long userId) throws NoSuchGDFTenderDetailsException {
	
	return gdfTenderScheduleItemPersistence.findByGDFTenderScheduleItemByUserId(tenderItemNumber, userId);
	
	
}

public List<GDFTenderScheduleItem> getGDFTenderScheduleItemByTenderRefNumberAndUserId(String tenderReferenceNumber, long userId) throws NoSuchGDFTenderDetailsException {
	
	return gdfTenderScheduleItemPersistence.findByGDFTenderTendRefNoByUserId(tenderReferenceNumber, userId);
	
	
}	

public GDFTenderScheduleItem getTenderItemByTenderRefNoAndScheduleNoAndGenricCode(String tenderReferenceNumber, long tenderItemNumber, long scheduleNumber, String gdfGenericCode) throws NoSuchGDFTenderScheduleItemException{
	
	return gdfTenderScheduleItemPersistence.findByTenderItemByScheduleIdGenCode(tenderReferenceNumber, tenderItemNumber, scheduleNumber, gdfGenericCode);
	
}

public List<GDFTenderScheduleItem> findByTenderItemByGenCodeAndSchedNo(String tenderReferenceNumber, long tenderItemNumber, long scheduleNumber, String gdfGenericCode) throws NoSuchGDFTenderScheduleItemException{
	
	return gdfTenderScheduleItemPersistence.findByTenderItemByGenCodeAndSchedNo(tenderReferenceNumber, tenderItemNumber, scheduleNumber, gdfGenericCode);
	
}




}