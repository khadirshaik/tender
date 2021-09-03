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

package com.gdf.technical.bids.service.persistence;

import com.gdf.technical.bids.model.GDFTenderScheduleItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the gdf tender schedule item service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderScheduleItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderScheduleItemPersistence
 * @generated
 */
public class GDFTenderScheduleItemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GDFTenderScheduleItem gdfTenderScheduleItem) {
		getPersistence().clearCache(gdfTenderScheduleItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, GDFTenderScheduleItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderScheduleItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderScheduleItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderScheduleItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderScheduleItem update(
		GDFTenderScheduleItem gdfTenderScheduleItem) {

		return getPersistence().update(gdfTenderScheduleItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderScheduleItem update(
		GDFTenderScheduleItem gdfTenderScheduleItem,
		ServiceContext serviceContext) {

		return getPersistence().update(gdfTenderScheduleItem, serviceContext);
	}

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Reference_Number_First(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
		fetchByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reference_Number_First(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Reference_Number_Last(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByGDF_Tender_Reference_Number_Last(
		String tenderReferenceNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reference_Number_Last(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Reference_Number_PrevAndNext(
			tenderItemRefID, tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	public static void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		getPersistence().removeByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().countByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns a range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderItemRefID, long scheduleNumber,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDF_Tender_Schedule_Number_PrevAndNext(
			tenderItemRefID, scheduleNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender schedule items where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public static void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		getPersistence().removeByGDF_Tender_Schedule_Number(scheduleNumber);
	}

	/**
	 * Returns the number of gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		return getPersistence().countByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId) {

		return getPersistence().findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId);
	}

	/**
	 * Returns a range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end) {

		return getPersistence().findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
			findByGDFTenderScheduleItemByUserId_First(
				long tenderItemNumber, long userId,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderScheduleItemByUserId_First(
			tenderItemNumber, userId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
		fetchByGDFTenderScheduleItemByUserId_First(
			long tenderItemNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDFTenderScheduleItemByUserId_First(
			tenderItemNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
			findByGDFTenderScheduleItemByUserId_Last(
				long tenderItemNumber, long userId,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderScheduleItemByUserId_Last(
			tenderItemNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
		fetchByGDFTenderScheduleItemByUserId_Last(
			long tenderItemNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDFTenderScheduleItemByUserId_Last(
			tenderItemNumber, userId, orderByComparator);
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem[]
			findByGDFTenderScheduleItemByUserId_PrevAndNext(
				long tenderItemRefID, long tenderItemNumber, long userId,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderScheduleItemByUserId_PrevAndNext(
			tenderItemRefID, tenderItemNumber, userId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 */
	public static void removeByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId) {

		getPersistence().removeByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId) {

		return getPersistence().countByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId);
	}

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end) {

		return getPersistence().findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderTendRefNoByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_First(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDFTenderTendRefNoByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderTendRefNoByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_Last(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByGDFTenderTendRefNoByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem[]
			findByGDFTenderTendRefNoByUserId_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByGDFTenderTendRefNoByUserId_PrevAndNext(
			tenderItemRefID, tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public static void removeByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		getPersistence().removeByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().countByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or throws a <code>NoSuchGDFTenderScheduleItemException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem findByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		return getPersistence().fetchByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, boolean useFinderCache) {

		return getPersistence().fetchByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, useFinderCache);
	}

	/**
	 * Removes the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the gdf tender schedule item that was removed
	 */
	public static GDFTenderScheduleItem removeByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().removeByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		return getPersistence().countByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode) {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end) {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
			findByTenderItemByGenCodeAndSchedNo_First(
				String tenderReferenceNumber, long tenderItemNumber,
				long scheduleNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo_First(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
		fetchByTenderItemByGenCodeAndSchedNo_First(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByTenderItemByGenCodeAndSchedNo_First(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
			findByTenderItemByGenCodeAndSchedNo_Last(
				String tenderReferenceNumber, long tenderItemNumber,
				long scheduleNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo_Last(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public static GDFTenderScheduleItem
		fetchByTenderItemByGenCodeAndSchedNo_Last(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().fetchByTenderItemByGenCodeAndSchedNo_Last(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem[]
			findByTenderItemByGenCodeAndSchedNo_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				long tenderItemNumber, long scheduleNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByTenderItemByGenCodeAndSchedNo_PrevAndNext(
			tenderItemRefID, tenderReferenceNumber, tenderItemNumber,
			scheduleNumber, gdfGenericCode, orderByComparator);
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		getPersistence().removeByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	public static int countByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		return getPersistence().countByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	/**
	 * Caches the gdf tender schedule item in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 */
	public static void cacheResult(
		GDFTenderScheduleItem gdfTenderScheduleItem) {

		getPersistence().cacheResult(gdfTenderScheduleItem);
	}

	/**
	 * Caches the gdf tender schedule items in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItems the gdf tender schedule items
	 */
	public static void cacheResult(
		List<GDFTenderScheduleItem> gdfTenderScheduleItems) {

		getPersistence().cacheResult(gdfTenderScheduleItems);
	}

	/**
	 * Creates a new gdf tender schedule item with the primary key. Does not add the gdf tender schedule item to the database.
	 *
	 * @param tenderItemRefID the primary key for the new gdf tender schedule item
	 * @return the new gdf tender schedule item
	 */
	public static GDFTenderScheduleItem create(long tenderItemRefID) {
		return getPersistence().create(tenderItemRefID);
	}

	/**
	 * Removes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem remove(long tenderItemRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().remove(tenderItemRefID);
	}

	public static GDFTenderScheduleItem updateImpl(
		GDFTenderScheduleItem gdfTenderScheduleItem) {

		return getPersistence().updateImpl(gdfTenderScheduleItem);
	}

	/**
	 * Returns the gdf tender schedule item with the primary key or throws a <code>NoSuchGDFTenderScheduleItemException</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem findByPrimaryKey(long tenderItemRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getPersistence().findByPrimaryKey(tenderItemRefID);
	}

	/**
	 * Returns the gdf tender schedule item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item, or <code>null</code> if a gdf tender schedule item with the primary key could not be found
	 */
	public static GDFTenderScheduleItem fetchByPrimaryKey(
		long tenderItemRefID) {

		return getPersistence().fetchByPrimaryKey(tenderItemRefID);
	}

	/**
	 * Returns all the gdf tender schedule items.
	 *
	 * @return the gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findAll(
		int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender schedule items
	 */
	public static List<GDFTenderScheduleItem> findAll(
		int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender schedule items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender schedule items.
	 *
	 * @return the number of gdf tender schedule items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderScheduleItemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderScheduleItemPersistence, GDFTenderScheduleItemPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderScheduleItemPersistence.class);

		ServiceTracker
			<GDFTenderScheduleItemPersistence, GDFTenderScheduleItemPersistence>
				serviceTracker =
					new ServiceTracker
						<GDFTenderScheduleItemPersistence,
						 GDFTenderScheduleItemPersistence>(
							 bundle.getBundleContext(),
							 GDFTenderScheduleItemPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}