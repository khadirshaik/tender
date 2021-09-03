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

import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;

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
 * The persistence utility for the gdf tender sub fpp reg details service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderSubFPPRegDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetailsPersistence
 * @generated
 */
public class GDFTenderSubFPPRegDetailsUtil {

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
	public static void clearCache(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		getPersistence().clearCache(gdfTenderSubFPPRegDetails);
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
	public static Map<Serializable, GDFTenderSubFPPRegDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderSubFPPRegDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderSubFPPRegDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderSubFPPRegDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderSubFPPRegDetails update(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		return getPersistence().update(gdfTenderSubFPPRegDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderSubFPPRegDetails update(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			gdfTenderSubFPPRegDetails, serviceContext);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId) {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end) {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTendRefSubFPPRegByUserId_First(
				String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTendRefSubFPPRegByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendRefSubFPPRegByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTendRefSubFPPRegByUserId_Last(
				String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTendRefSubFPPRegByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendRefSubFPPRegByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByGDFTendRefSubFPPRegByUserId_PrevAndNext(
				long tenderRegRefID, String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTendRefSubFPPRegByUserId_PrevAndNext(
			tenderRegRefID, tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public static void removeByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId) {

		getPersistence().removeByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().countByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(long scheduleNumber) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDF_Tender_Schedule_Number_First(
				long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDF_Tender_Schedule_Number_Last(
				long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_PrevAndNext(
			tenderRegRefID, scheduleNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public static void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		getPersistence().removeByGDF_Tender_Schedule_Number(scheduleNumber);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		return getPersistence().countByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId) {

		return getPersistence().findByFPP_Registration_ID(fppRegistrationId);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end) {

		return getPersistence().findByFPP_Registration_ID(
			fppRegistrationId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByFPP_Registration_ID(
			fppRegistrationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFPP_Registration_ID(
			fppRegistrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByFPP_Registration_ID_First(
			long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByFPP_Registration_ID_First(
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_First(
		long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByFPP_Registration_ID_First(
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByFPP_Registration_ID_Last(
			long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByFPP_Registration_ID_Last(
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_Last(
		long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByFPP_Registration_ID_Last(
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByFPP_Registration_ID_PrevAndNext(
				long tenderRegRefID, long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByFPP_Registration_ID_PrevAndNext(
			tenderRegRefID, fppRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63; from the database.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 */
	public static void removeByFPP_Registration_ID(long fppRegistrationId) {
		getPersistence().removeByFPP_Registration_ID(fppRegistrationId);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByFPP_Registration_ID(long fppRegistrationId) {
		return getPersistence().countByFPP_Registration_ID(fppRegistrationId);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID) {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id(tenderRegRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end) {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_First(
			long tenderRegRefID,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id_First(
			tenderRegRefID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_First(
		long tenderRegRefID,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reg_Ref_Id_First(
			tenderRegRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_Last(
			long tenderRegRefID,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Tender_Reg_Ref_Id_Last(
			tenderRegRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_Last(
		long tenderRegRefID,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reg_Ref_Id_Last(
			tenderRegRefID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 */
	public static void removeByGDF_Tender_Reg_Ref_Id(long tenderRegRefID) {
		getPersistence().removeByGDF_Tender_Reg_Ref_Id(tenderRegRefID);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDF_Tender_Reg_Ref_Id(long tenderRegRefID) {
		return getPersistence().countByGDF_Tender_Reg_Ref_Id(tenderRegRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return getPersistence().findByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByGDF_Generic_Code_PrevAndNext(
				long tenderRegRefID, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDF_Generic_Code_PrevAndNext(
			tenderRegRefID, gdfGenericCode, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByGDF_Generic_Code(String gdfGenericCode) {
		getPersistence().removeByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDF_Generic_Code(String gdfGenericCode) {
		return getPersistence().countByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		return getPersistence().findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end) {

		return getPersistence().findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_First(
			long tenderRegRefID, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderByTRIDAndFRID_First(
			tenderRegRefID, fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_First(
		long tenderRegRefID, long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByTRIDAndFRID_First(
			tenderRegRefID, fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_Last(
			long tenderRegRefID, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderByTRIDAndFRID_Last(
			tenderRegRefID, fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_Last(
		long tenderRegRefID, long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByTRIDAndFRID_Last(
			tenderRegRefID, fppRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 */
	public static void removeByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		getPersistence().removeByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		return getPersistence().countByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode) {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end) {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUTRNUAndGenCode_First(
				long scheduleNumber, String tenderReferenceNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode_First(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode,
			orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUTRNUAndGenCode_First(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUTRNUAndGenCode_First(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUTRNUAndGenCode_Last(
				long scheduleNumber, String tenderReferenceNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode_Last(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUTRNUAndGenCode_Last(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUTRNUAndGenCode_Last(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode,
			orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				String tenderReferenceNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
			tenderRegRefID, scheduleNumber, tenderReferenceNumber,
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode) {

		getPersistence().removeByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode) {

		return getPersistence().countByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId) {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end) {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUAndTRNUGenCodeFID_First(
				long scheduleNumber, long userId, String tenderReferenceNumber,
				String gdfGenericCode, long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID_First(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_First(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUAndTRNUGenCodeFID_First(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUAndTRNUGenCodeFID_Last(
				long scheduleNumber, long userId, String tenderReferenceNumber,
				String gdfGenericCode, long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public static GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				long tenderRegRefID, long scheduleNumber, long userId,
				String tenderReferenceNumber, String gdfGenericCode,
				long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().
			findByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				tenderRegRefID, scheduleNumber, userId, tenderReferenceNumber,
				gdfGenericCode, fppRegistrationId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 */
	public static void removeByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId) {

		getPersistence().removeByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public static int countByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId) {

		return getPersistence().countByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId);
	}

	/**
	 * Caches the gdf tender sub fpp reg details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 */
	public static void cacheResult(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		getPersistence().cacheResult(gdfTenderSubFPPRegDetails);
	}

	/**
	 * Caches the gdf tender sub fpp reg detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetailses the gdf tender sub fpp reg detailses
	 */
	public static void cacheResult(
		List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegDetailses) {

		getPersistence().cacheResult(gdfTenderSubFPPRegDetailses);
	}

	/**
	 * Creates a new gdf tender sub fpp reg details with the primary key. Does not add the gdf tender sub fpp reg details to the database.
	 *
	 * @param tenderRegRefID the primary key for the new gdf tender sub fpp reg details
	 * @return the new gdf tender sub fpp reg details
	 */
	public static GDFTenderSubFPPRegDetails create(long tenderRegRefID) {
		return getPersistence().create(tenderRegRefID);
	}

	/**
	 * Removes the gdf tender sub fpp reg details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails remove(long tenderRegRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().remove(tenderRegRefID);
	}

	public static GDFTenderSubFPPRegDetails updateImpl(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		return getPersistence().updateImpl(gdfTenderSubFPPRegDetails);
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or throws a <code>NoSuchGDFTenderSubFPPRegDetailsException</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails findByPrimaryKey(
			long tenderRegRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPRegDetailsException {

		return getPersistence().findByPrimaryKey(tenderRegRefID);
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details, or <code>null</code> if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static GDFTenderSubFPPRegDetails fetchByPrimaryKey(
		long tenderRegRefID) {

		return getPersistence().fetchByPrimaryKey(tenderRegRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses.
	 *
	 * @return the gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp reg detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender sub fpp reg detailses
	 */
	public static List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses.
	 *
	 * @return the number of gdf tender sub fpp reg detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderSubFPPRegDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubFPPRegDetailsPersistence,
		 GDFTenderSubFPPRegDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubFPPRegDetailsPersistence.class);

		ServiceTracker
			<GDFTenderSubFPPRegDetailsPersistence,
			 GDFTenderSubFPPRegDetailsPersistence> serviceTracker =
				new ServiceTracker
					<GDFTenderSubFPPRegDetailsPersistence,
					 GDFTenderSubFPPRegDetailsPersistence>(
						 bundle.getBundleContext(),
						 GDFTenderSubFPPRegDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}