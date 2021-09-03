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

import com.gdf.technical.bids.model.GDFTenderSubSchedDetails;

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
 * The persistence utility for the gdf tender sub sched details service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderSubSchedDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetailsPersistence
 * @generated
 */
public class GDFTenderSubSchedDetailsUtil {

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
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		getPersistence().clearCache(gdfTenderSubSchedDetails);
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
	public static Map<Serializable, GDFTenderSubSchedDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderSubSchedDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderSubSchedDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderSubSchedDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderSubSchedDetails update(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		return getPersistence().update(gdfTenderSubSchedDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderSubSchedDetails update(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			gdfTenderSubSchedDetails, serviceContext);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(String tenderReferenceNumber) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Reference_Number_First(
				String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Reference_Number_First(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reference_Number_First(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Reference_Number_Last(
				String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Reference_Number_Last(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Reference_Number_Last(
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderSubSchedRefID, String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Reference_Number_PrevAndNext(
			tenderSubSchedRefID, tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	public static void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		getPersistence().removeByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().countByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID) {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end) {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Sub_Sched_Ref_Id_First(
				long tenderSubSchedRefID,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id_First(
			tenderSubSchedRefID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Sub_Sched_Ref_Id_First(
			long tenderSubSchedRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Sub_Sched_Ref_Id_First(
			tenderSubSchedRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Sub_Sched_Ref_Id_Last(
				long tenderSubSchedRefID,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Sub_Sched_Ref_Id_Last(
			tenderSubSchedRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Sub_Sched_Ref_Id_Last(
			long tenderSubSchedRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Sub_Sched_Ref_Id_Last(
			tenderSubSchedRefID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63; from the database.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 */
	public static void removeByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID) {

		getPersistence().removeByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID) {

		return getPersistence().countByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(long scheduleNumber) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Schedule_Number_First(
				long scheduleNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_First(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDF_Tender_Schedule_Number_Last(
				long scheduleNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Schedule_Number_Last(
			scheduleNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Schedule_Number_PrevAndNext(
			tenderSubSchedRefID, scheduleNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public static void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		getPersistence().removeByGDF_Tender_Schedule_Number(scheduleNumber);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		return getPersistence().countByGDF_Tender_Schedule_Number(
			scheduleNumber);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return getPersistence().findByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderSubSchedRefID, String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Generic_Code_PrevAndNext(
			tenderSubSchedRefID, gdfGenericCode, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByGDF_Generic_Code(String gdfGenericCode) {
		getPersistence().removeByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDF_Generic_Code(String gdfGenericCode) {
		return getPersistence().countByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID) {

		return getPersistence().findByGDF_Tender_Item_Ref_Id(tenderItemRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end) {

		return getPersistence().findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_First(
			long tenderItemRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Item_Ref_Id_First(
			tenderItemRefID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_First(
		long tenderItemRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Item_Ref_Id_First(
			tenderItemRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_Last(
			long tenderItemRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Item_Ref_Id_Last(
			tenderItemRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_Last(
		long tenderItemRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Item_Ref_Id_Last(
			tenderItemRefID, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails[]
			findByGDF_Tender_Item_Ref_Id_PrevAndNext(
				long tenderSubSchedRefID, long tenderItemRefID,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDF_Tender_Item_Ref_Id_PrevAndNext(
			tenderSubSchedRefID, tenderItemRefID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderItemRefID = &#63; from the database.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 */
	public static void removeByGDF_Tender_Item_Ref_Id(long tenderItemRefID) {
		getPersistence().removeByGDF_Tender_Item_Ref_Id(tenderItemRefID);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDF_Tender_Item_Ref_Id(long tenderItemRefID) {
		return getPersistence().countByGDF_Tender_Item_Ref_Id(tenderItemRefID);
	}

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber) {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end) {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber, start,
			end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDFTenderSubBySNUAndTRNUAndTINU_First(
				long scheduleNumber, String tenderReferenceNumber,
				long tenderItemNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU_First(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber,
			orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDFTenderSubBySNUAndTRNUAndTINU_First(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderSubBySNUAndTRNUAndTINU_First(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
			findByGDFTenderSubBySNUAndTRNUAndTINU_Last(
				long scheduleNumber, String tenderReferenceNumber,
				long tenderItemNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByGDFTenderSubBySNUAndTRNUAndTINU_Last(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public static GDFTenderSubSchedDetails
		fetchByGDFTenderSubBySNUAndTRNUAndTINU_Last(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderSubBySNUAndTRNUAndTINU_Last(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber,
			orderByComparator);
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails[]
			findByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				String tenderReferenceNumber, long tenderItemNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().
			findByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				tenderSubSchedRefID, scheduleNumber, tenderReferenceNumber,
				tenderItemNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 */
	public static void removeByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber) {

		getPersistence().removeByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public static int countByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber) {

		return getPersistence().countByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber);
	}

	/**
	 * Caches the gdf tender sub sched details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 */
	public static void cacheResult(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		getPersistence().cacheResult(gdfTenderSubSchedDetails);
	}

	/**
	 * Caches the gdf tender sub sched detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetailses the gdf tender sub sched detailses
	 */
	public static void cacheResult(
		List<GDFTenderSubSchedDetails> gdfTenderSubSchedDetailses) {

		getPersistence().cacheResult(gdfTenderSubSchedDetailses);
	}

	/**
	 * Creates a new gdf tender sub sched details with the primary key. Does not add the gdf tender sub sched details to the database.
	 *
	 * @param tenderSubSchedRefID the primary key for the new gdf tender sub sched details
	 * @return the new gdf tender sub sched details
	 */
	public static GDFTenderSubSchedDetails create(long tenderSubSchedRefID) {
		return getPersistence().create(tenderSubSchedRefID);
	}

	/**
	 * Removes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails remove(long tenderSubSchedRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().remove(tenderSubSchedRefID);
	}

	public static GDFTenderSubSchedDetails updateImpl(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		return getPersistence().updateImpl(gdfTenderSubSchedDetails);
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key or throws a <code>NoSuchGDFTenderSubSchedDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails findByPrimaryKey(
			long tenderSubSchedRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubSchedDetailsException {

		return getPersistence().findByPrimaryKey(tenderSubSchedRefID);
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details, or <code>null</code> if a gdf tender sub sched details with the primary key could not be found
	 */
	public static GDFTenderSubSchedDetails fetchByPrimaryKey(
		long tenderSubSchedRefID) {

		return getPersistence().fetchByPrimaryKey(tenderSubSchedRefID);
	}

	/**
	 * Returns all the gdf tender sub sched detailses.
	 *
	 * @return the gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub sched detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender sub sched detailses
	 */
	public static List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender sub sched detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender sub sched detailses.
	 *
	 * @return the number of gdf tender sub sched detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderSubSchedDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubSchedDetailsPersistence,
		 GDFTenderSubSchedDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubSchedDetailsPersistence.class);

		ServiceTracker
			<GDFTenderSubSchedDetailsPersistence,
			 GDFTenderSubSchedDetailsPersistence> serviceTracker =
				new ServiceTracker
					<GDFTenderSubSchedDetailsPersistence,
					 GDFTenderSubSchedDetailsPersistence>(
						 bundle.getBundleContext(),
						 GDFTenderSubSchedDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}