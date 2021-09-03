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

import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;

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
 * The persistence utility for the gdf tender submission details service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderSubmissionDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubmissionDetailsPersistence
 * @generated
 */
public class GDFTenderSubmissionDetailsUtil {

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
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		getPersistence().clearCache(gdfTenderSubmissionDetails);
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
	public static Map<Serializable, GDFTenderSubmissionDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderSubmissionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderSubmissionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderSubmissionDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderSubmissionDetails update(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		return getPersistence().update(gdfTenderSubmissionDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderSubmissionDetails update(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			gdfTenderSubmissionDetails, serviceContext);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().fetchByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, boolean useFinderCache) {

		return getPersistence().fetchByGDF_Tender_Reference_Number(
			tenderReferenceNumber, useFinderCache);
	}

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender submission details that was removed
	 */
	public static GDFTenderSubmissionDetails
			removeByGDF_Tender_Reference_Number(String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().removeByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender submission detailses
	 */
	public static int countByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().countByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId) {

		return getPersistence().fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId, boolean useFinderCache) {

		return getPersistence().fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId, useFinderCache);
	}

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the gdf tender submission details that was removed
	 */
	public static GDFTenderSubmissionDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().removeByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId);
	}

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63; and supplierId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	public static int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId) {

		return getPersistence().countByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId);
	}

	/**
	 * Returns all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId) {

		return getPersistence().findByGDFTendersByUserId(supplierId);
	}

	/**
	 * Returns a range of all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param supplierId the supplier ID
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @return the range of matching gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end) {

		return getPersistence().findByGDFTendersByUserId(
			supplierId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param supplierId the supplier ID
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return getPersistence().findByGDFTendersByUserId(
			supplierId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param supplierId the supplier ID
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDFTendersByUserId(
			supplierId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails findByGDFTendersByUserId_First(
			long supplierId,
			OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByGDFTendersByUserId_First(
			supplierId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDFTendersByUserId_First(
		long supplierId,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendersByUserId_First(
			supplierId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails findByGDFTendersByUserId_Last(
			long supplierId,
			OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByGDFTendersByUserId_Last(
			supplierId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByGDFTendersByUserId_Last(
		long supplierId,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendersByUserId_Last(
			supplierId, orderByComparator);
	}

	/**
	 * Returns the gdf tender submission detailses before and after the current gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param tenderSubRefID the primary key of the current gdf tender submission details
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public static GDFTenderSubmissionDetails[]
			findByGDFTendersByUserId_PrevAndNext(
				long tenderSubRefID, long supplierId,
				OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByGDFTendersByUserId_PrevAndNext(
			tenderSubRefID, supplierId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender submission detailses where supplierId = &#63; from the database.
	 *
	 * @param supplierId the supplier ID
	 */
	public static void removeByGDFTendersByUserId(long supplierId) {
		getPersistence().removeByGDFTendersByUserId(supplierId);
	}

	/**
	 * Returns the number of gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	public static int countByGDFTendersByUserId(long supplierId) {
		return getPersistence().countByGDFTendersByUserId(supplierId);
	}

	/**
	 * Caches the gdf tender submission details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 */
	public static void cacheResult(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		getPersistence().cacheResult(gdfTenderSubmissionDetails);
	}

	/**
	 * Caches the gdf tender submission detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetailses the gdf tender submission detailses
	 */
	public static void cacheResult(
		List<GDFTenderSubmissionDetails> gdfTenderSubmissionDetailses) {

		getPersistence().cacheResult(gdfTenderSubmissionDetailses);
	}

	/**
	 * Creates a new gdf tender submission details with the primary key. Does not add the gdf tender submission details to the database.
	 *
	 * @param tenderSubRefID the primary key for the new gdf tender submission details
	 * @return the new gdf tender submission details
	 */
	public static GDFTenderSubmissionDetails create(long tenderSubRefID) {
		return getPersistence().create(tenderSubRefID);
	}

	/**
	 * Removes the gdf tender submission details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public static GDFTenderSubmissionDetails remove(long tenderSubRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().remove(tenderSubRefID);
	}

	public static GDFTenderSubmissionDetails updateImpl(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		return getPersistence().updateImpl(gdfTenderSubmissionDetails);
	}

	/**
	 * Returns the gdf tender submission details with the primary key or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public static GDFTenderSubmissionDetails findByPrimaryKey(
			long tenderSubRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return getPersistence().findByPrimaryKey(tenderSubRefID);
	}

	/**
	 * Returns the gdf tender submission details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details, or <code>null</code> if a gdf tender submission details with the primary key could not be found
	 */
	public static GDFTenderSubmissionDetails fetchByPrimaryKey(
		long tenderSubRefID) {

		return getPersistence().fetchByPrimaryKey(tenderSubRefID);
	}

	/**
	 * Returns all the gdf tender submission detailses.
	 *
	 * @return the gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender submission detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @return the range of gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender submission detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender submission detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender submission detailses
	 */
	public static List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender submission detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender submission detailses.
	 *
	 * @return the number of gdf tender submission detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderSubmissionDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubmissionDetailsPersistence,
		 GDFTenderSubmissionDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubmissionDetailsPersistence.class);

		ServiceTracker
			<GDFTenderSubmissionDetailsPersistence,
			 GDFTenderSubmissionDetailsPersistence> serviceTracker =
				new ServiceTracker
					<GDFTenderSubmissionDetailsPersistence,
					 GDFTenderSubmissionDetailsPersistence>(
						 bundle.getBundleContext(),
						 GDFTenderSubmissionDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}