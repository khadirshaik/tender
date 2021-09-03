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

import com.gdf.technical.bids.model.GDFTenderDetails;

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
 * The persistence utility for the gdf tender details service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderDetailsPersistence
 * @generated
 */
public class GDFTenderDetailsUtil {

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
	public static void clearCache(GDFTenderDetails gdfTenderDetails) {
		getPersistence().clearCache(gdfTenderDetails);
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
	public static Map<Serializable, GDFTenderDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderDetails update(GDFTenderDetails gdfTenderDetails) {
		return getPersistence().update(gdfTenderDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderDetails update(
		GDFTenderDetails gdfTenderDetails, ServiceContext serviceContext) {

		return getPersistence().update(gdfTenderDetails, serviceContext);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().fetchByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, boolean useFinderCache) {

		return getPersistence().fetchByGDF_Tender_Reference_Number(
			tenderReferenceNumber, useFinderCache);
	}

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender details that was removed
	 */
	public static GDFTenderDetails removeByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().removeByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender detailses
	 */
	public static int countByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return getPersistence().countByGDF_Tender_Reference_Number(
			tenderReferenceNumber);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId, boolean useFinderCache) {

		return getPersistence().fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId, useFinderCache);
	}

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the gdf tender details that was removed
	 */
	public static GDFTenderDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().removeByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	public static int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().countByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns all the gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching gdf tender detailses
	 */
	public static List<GDFTenderDetails> findByGDFTendersByUserId(long userId) {
		return getPersistence().findByGDFTendersByUserId(userId);
	}

	/**
	 * Returns a range of all the gdf tender detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @return the range of matching gdf tender detailses
	 */
	public static List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end) {

		return getPersistence().findByGDFTendersByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender detailses
	 */
	public static List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator) {

		return getPersistence().findByGDFTendersByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender detailses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender detailses
	 */
	public static List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDFTendersByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails findByGDFTendersByUserId_First(
			long userId, OrderByComparator<GDFTenderDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByGDFTendersByUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDFTendersByUserId_First(
		long userId, OrderByComparator<GDFTenderDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendersByUserId_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails findByGDFTendersByUserId_Last(
			long userId, OrderByComparator<GDFTenderDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByGDFTendersByUserId_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public static GDFTenderDetails fetchByGDFTendersByUserId_Last(
		long userId, OrderByComparator<GDFTenderDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendersByUserId_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the gdf tender detailses before and after the current gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param tenderRefID the primary key of the current gdf tender details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public static GDFTenderDetails[] findByGDFTendersByUserId_PrevAndNext(
			long tenderRefID, long userId,
			OrderByComparator<GDFTenderDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByGDFTendersByUserId_PrevAndNext(
			tenderRefID, userId, orderByComparator);
	}

	/**
	 * Removes all the gdf tender detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByGDFTendersByUserId(long userId) {
		getPersistence().removeByGDFTendersByUserId(userId);
	}

	/**
	 * Returns the number of gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	public static int countByGDFTendersByUserId(long userId) {
		return getPersistence().countByGDFTendersByUserId(userId);
	}

	/**
	 * Caches the gdf tender details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 */
	public static void cacheResult(GDFTenderDetails gdfTenderDetails) {
		getPersistence().cacheResult(gdfTenderDetails);
	}

	/**
	 * Caches the gdf tender detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetailses the gdf tender detailses
	 */
	public static void cacheResult(List<GDFTenderDetails> gdfTenderDetailses) {
		getPersistence().cacheResult(gdfTenderDetailses);
	}

	/**
	 * Creates a new gdf tender details with the primary key. Does not add the gdf tender details to the database.
	 *
	 * @param tenderRefID the primary key for the new gdf tender details
	 * @return the new gdf tender details
	 */
	public static GDFTenderDetails create(long tenderRefID) {
		return getPersistence().create(tenderRefID);
	}

	/**
	 * Removes the gdf tender details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details that was removed
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public static GDFTenderDetails remove(long tenderRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().remove(tenderRefID);
	}

	public static GDFTenderDetails updateImpl(
		GDFTenderDetails gdfTenderDetails) {

		return getPersistence().updateImpl(gdfTenderDetails);
	}

	/**
	 * Returns the gdf tender details with the primary key or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public static GDFTenderDetails findByPrimaryKey(long tenderRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return getPersistence().findByPrimaryKey(tenderRefID);
	}

	/**
	 * Returns the gdf tender details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details, or <code>null</code> if a gdf tender details with the primary key could not be found
	 */
	public static GDFTenderDetails fetchByPrimaryKey(long tenderRefID) {
		return getPersistence().fetchByPrimaryKey(tenderRefID);
	}

	/**
	 * Returns all the gdf tender detailses.
	 *
	 * @return the gdf tender detailses
	 */
	public static List<GDFTenderDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @return the range of gdf tender detailses
	 */
	public static List<GDFTenderDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender detailses
	 */
	public static List<GDFTenderDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender detailses
	 */
	public static List<GDFTenderDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender detailses.
	 *
	 * @return the number of gdf tender detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderDetailsPersistence, GDFTenderDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderDetailsPersistence.class);

		ServiceTracker<GDFTenderDetailsPersistence, GDFTenderDetailsPersistence>
			serviceTracker =
				new ServiceTracker
					<GDFTenderDetailsPersistence, GDFTenderDetailsPersistence>(
						bundle.getBundleContext(),
						GDFTenderDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}