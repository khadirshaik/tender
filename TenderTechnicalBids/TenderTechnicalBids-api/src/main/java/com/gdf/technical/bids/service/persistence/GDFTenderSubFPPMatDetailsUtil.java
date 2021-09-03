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

import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;

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
 * The persistence utility for the gdf tender sub fpp mat details service. This utility wraps <code>com.gdf.technical.bids.service.persistence.impl.GDFTenderSubFPPMatDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPMatDetailsPersistence
 * @generated
 */
public class GDFTenderSubFPPMatDetailsUtil {

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
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		getPersistence().clearCache(gdfTenderSubFPPMatDetails);
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
	public static Map<Serializable, GDFTenderSubFPPMatDetails>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GDFTenderSubFPPMatDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GDFTenderSubFPPMatDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GDFTenderSubFPPMatDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GDFTenderSubFPPMatDetails update(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		return getPersistence().update(gdfTenderSubFPPMatDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GDFTenderSubFPPMatDetails update(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(
			gdfTenderSubFPPMatDetails, serviceContext);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId) {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end) {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTendRefSubFPPMatByUserId_First(
				String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTendRefSubFPPMatByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendRefSubFPPMatByUserId_First(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTendRefSubFPPMatByUserId_Last(
				String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTendRefSubFPPMatByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTendRefSubFPPMatByUserId_Last(
			tenderReferenceNumber, userId, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDFTendRefSubFPPMatByUserId_PrevAndNext(
				long tenderItemMatRefID, String tenderReferenceNumber,
				long userId,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTendRefSubFPPMatByUserId_PrevAndNext(
			tenderItemMatRefID, tenderReferenceNumber, userId,
			orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public static void removeByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId) {

		getPersistence().removeByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId) {

		return getPersistence().countByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID) {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end) {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDF_Tender_Item_Mat_Ref_Id_First(
				long tenderItemMatRefID,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id_First(
			tenderItemMatRefID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDF_Tender_Item_Mat_Ref_Id_First(
			long tenderItemMatRefID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Item_Mat_Ref_Id_First(
			tenderItemMatRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDF_Tender_Item_Mat_Ref_Id_Last(
				long tenderItemMatRefID,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Tender_Item_Mat_Ref_Id_Last(
			tenderItemMatRefID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDF_Tender_Item_Mat_Ref_Id_Last(
			long tenderItemMatRefID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_Item_Mat_Ref_Id_Last(
			tenderItemMatRefID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 */
	public static void removeByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID) {

		getPersistence().removeByGDF_Tender_Item_Mat_Ref_Id(tenderItemMatRefID);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID) {

		return getPersistence().countByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID) {

		return getPersistence().findByGDF_Tender_fppMarketID(fppMarketID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end) {

		return getPersistence().findByGDF_Tender_fppMarketID(
			fppMarketID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDF_Tender_fppMarketID(
			fppMarketID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Tender_fppMarketID(
			fppMarketID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_First(
			long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Tender_fppMarketID_First(
			fppMarketID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_First(
		long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_fppMarketID_First(
			fppMarketID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_Last(
			long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Tender_fppMarketID_Last(
			fppMarketID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_Last(
		long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Tender_fppMarketID_Last(
			fppMarketID, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDF_Tender_fppMarketID_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Tender_fppMarketID_PrevAndNext(
			tenderItemMatRefID, fppMarketID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 */
	public static void removeByGDF_Tender_fppMarketID(long fppMarketID) {
		getPersistence().removeByGDF_Tender_fppMarketID(fppMarketID);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDF_Tender_fppMarketID(long fppMarketID) {
		return getPersistence().countByGDF_Tender_fppMarketID(fppMarketID);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID) {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end) {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderByTIMRIDAndFMID_First(
				long tenderItemMatRefID, long fppMarketID,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID_First(
			tenderItemMatRefID, fppMarketID, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderByTIMRIDAndFMID_First(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByTIMRIDAndFMID_First(
			tenderItemMatRefID, fppMarketID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByGDFTenderByTIMRIDAndFMID_Last(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderByTIMRIDAndFMID_Last(
			tenderItemMatRefID, fppMarketID, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderByTIMRIDAndFMID_Last(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByTIMRIDAndFMID_Last(
			tenderItemMatRefID, fppMarketID, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 */
	public static void removeByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID) {

		getPersistence().removeByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID) {

		return getPersistence().countByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber) {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end) {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderMatUserGenCodeSNU_First(
				long fppMarketID, long userId, String gdfGenericCode,
				long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU_First(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderMatUserGenCodeSNU_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderMatUserGenCodeSNU_First(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderMatUserGenCodeSNU_Last(
				long fppMarketID, long userId, String gdfGenericCode,
				long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU_Last(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderMatUserGenCodeSNU_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderMatUserGenCodeSNU_Last(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDFTenderMatUserGenCodeSNU_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderMatUserGenCodeSNU_PrevAndNext(
			tenderItemMatRefID, fppMarketID, userId, gdfGenericCode,
			scheduleNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 */
	public static void removeByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber) {

		getPersistence().removeByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber) {

		return getPersistence().countByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode) {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end) {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderBySNUAndAndGenCode_First(
				long scheduleNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode_First(
			scheduleNumber, gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderBySNUAndAndGenCode_First(
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUAndAndGenCode_First(
			scheduleNumber, gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderBySNUAndAndGenCode_Last(
				long scheduleNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode_Last(
			scheduleNumber, gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderBySNUAndAndGenCode_Last(
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderBySNUAndAndGenCode_Last(
			scheduleNumber, gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDFTenderBySNUAndAndGenCode_PrevAndNext(
				long tenderItemMatRefID, long scheduleNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderBySNUAndAndGenCode_PrevAndNext(
			tenderItemMatRefID, scheduleNumber, gdfGenericCode,
			orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode) {

		getPersistence().removeByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode) {

		return getPersistence().countByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return getPersistence().findByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_First(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDF_Generic_Code_Last(
			gdfGenericCode, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDF_Generic_Code_PrevAndNext(
				long tenderItemMatRefID, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDF_Generic_Code_PrevAndNext(
			tenderItemMatRefID, gdfGenericCode, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public static void removeByGDF_Generic_Code(String gdfGenericCode) {
		getPersistence().removeByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDF_Generic_Code(String gdfGenericCode) {
		return getPersistence().countByGDF_Generic_Code(gdfGenericCode);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus) {

		return getPersistence().findByFPP_Selected_Status(fppSelectedStatus);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end) {

		return getPersistence().findByFPP_Selected_Status(
			fppSelectedStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByFPP_Selected_Status(
			fppSelectedStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFPP_Selected_Status(
			fppSelectedStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByFPP_Selected_Status_First(
			boolean fppSelectedStatus,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByFPP_Selected_Status_First(
			fppSelectedStatus, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_First(
		boolean fppSelectedStatus,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByFPP_Selected_Status_First(
			fppSelectedStatus, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByFPP_Selected_Status_Last(
			boolean fppSelectedStatus,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByFPP_Selected_Status_Last(
			fppSelectedStatus, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_Last(
		boolean fppSelectedStatus,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByFPP_Selected_Status_Last(
			fppSelectedStatus, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByFPP_Selected_Status_PrevAndNext(
				long tenderItemMatRefID, boolean fppSelectedStatus,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByFPP_Selected_Status_PrevAndNext(
			tenderItemMatRefID, fppSelectedStatus, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63; from the database.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 */
	public static void removeByFPP_Selected_Status(boolean fppSelectedStatus) {
		getPersistence().removeByFPP_Selected_Status(fppSelectedStatus);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByFPP_Selected_Status(boolean fppSelectedStatus) {
		return getPersistence().countByFPP_Selected_Status(fppSelectedStatus);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber) {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end) {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderByFIDUIDGenCodeSNUTRN_First(
				long fppMarketID, long userId, String gdfGenericCode,
				long scheduleNumber, String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
			findByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
				long fppMarketID, long userId, String gdfGenericCode,
				long scheduleNumber, String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public static GDFTenderSubFPPMatDetails
		fetchByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().fetchByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails[]
			findByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().
			findByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				tenderItemMatRefID, fppMarketID, userId, gdfGenericCode,
				scheduleNumber, tenderReferenceNumber, orderByComparator);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 */
	public static void removeByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber) {

		getPersistence().removeByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public static int countByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber) {

		return getPersistence().countByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber);
	}

	/**
	 * Caches the gdf tender sub fpp mat details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 */
	public static void cacheResult(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		getPersistence().cacheResult(gdfTenderSubFPPMatDetails);
	}

	/**
	 * Caches the gdf tender sub fpp mat detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetailses the gdf tender sub fpp mat detailses
	 */
	public static void cacheResult(
		List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatDetailses) {

		getPersistence().cacheResult(gdfTenderSubFPPMatDetailses);
	}

	/**
	 * Creates a new gdf tender sub fpp mat details with the primary key. Does not add the gdf tender sub fpp mat details to the database.
	 *
	 * @param tenderItemMatRefID the primary key for the new gdf tender sub fpp mat details
	 * @return the new gdf tender sub fpp mat details
	 */
	public static GDFTenderSubFPPMatDetails create(long tenderItemMatRefID) {
		return getPersistence().create(tenderItemMatRefID);
	}

	/**
	 * Removes the gdf tender sub fpp mat details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails remove(long tenderItemMatRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().remove(tenderItemMatRefID);
	}

	public static GDFTenderSubFPPMatDetails updateImpl(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		return getPersistence().updateImpl(gdfTenderSubFPPMatDetails);
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or throws a <code>NoSuchGDFTenderSubFPPMatDetailsException</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails findByPrimaryKey(
			long tenderItemMatRefID)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubFPPMatDetailsException {

		return getPersistence().findByPrimaryKey(tenderItemMatRefID);
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details, or <code>null</code> if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public static GDFTenderSubFPPMatDetails fetchByPrimaryKey(
		long tenderItemMatRefID) {

		return getPersistence().fetchByPrimaryKey(tenderItemMatRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses.
	 *
	 * @return the gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gdf tender sub fpp mat detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender sub fpp mat detailses
	 */
	public static List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses.
	 *
	 * @return the number of gdf tender sub fpp mat detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GDFTenderSubFPPMatDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubFPPMatDetailsPersistence,
		 GDFTenderSubFPPMatDetailsPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubFPPMatDetailsPersistence.class);

		ServiceTracker
			<GDFTenderSubFPPMatDetailsPersistence,
			 GDFTenderSubFPPMatDetailsPersistence> serviceTracker =
				new ServiceTracker
					<GDFTenderSubFPPMatDetailsPersistence,
					 GDFTenderSubFPPMatDetailsPersistence>(
						 bundle.getBundleContext(),
						 GDFTenderSubFPPMatDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}