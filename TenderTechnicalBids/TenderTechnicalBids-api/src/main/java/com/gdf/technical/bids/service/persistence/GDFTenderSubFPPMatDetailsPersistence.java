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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubFPPMatDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender sub fpp mat details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPMatDetailsUtil
 * @generated
 */
@ProviderType
public interface GDFTenderSubFPPMatDetailsPersistence
	extends BasePersistence<GDFTenderSubFPPMatDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderSubFPPMatDetailsUtil} to access the gdf tender sub fpp mat details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTendRefSubFPPMatByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTendRefSubFPPMatByUserId_First(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTendRefSubFPPMatByUserId_First(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTendRefSubFPPMatByUserId_Last(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTendRefSubFPPMatByUserId_Last(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails[]
			findByGDFTendRefSubFPPMatByUserId_PrevAndNext(
				long tenderItemMatRefID, String tenderReferenceNumber,
				long userId,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public void removeByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_Item_Mat_Ref_Id(
			long tenderItemMatRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Tender_Item_Mat_Ref_Id_First(
			long tenderItemMatRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_Item_Mat_Ref_Id_First(
		long tenderItemMatRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Tender_Item_Mat_Ref_Id_Last(
			long tenderItemMatRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_Item_Mat_Ref_Id_Last(
		long tenderItemMatRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 */
	public void removeByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_fppMarketID(long fppMarketID);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_fppMarketID(long fppMarketID, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_fppMarketID(
			long fppMarketID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDF_Tender_fppMarketID(
			long fppMarketID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_First(
			long fppMarketID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_First(
		long fppMarketID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_Last(
			long fppMarketID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_Last(
		long fppMarketID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails[] findByGDF_Tender_fppMarketID_PrevAndNext(
			long tenderItemMatRefID, long fppMarketID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 */
	public void removeByGDF_Tender_fppMarketID(long fppMarketID);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDF_Tender_fppMarketID(long fppMarketID);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByTIMRIDAndFMID(
			long tenderItemMatRefID, long fppMarketID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTenderByTIMRIDAndFMID_First(
			long tenderItemMatRefID, long fppMarketID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByTIMRIDAndFMID_First(
		long tenderItemMatRefID, long fppMarketID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTenderByTIMRIDAndFMID_Last(
			long tenderItemMatRefID, long fppMarketID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByTIMRIDAndFMID_Last(
		long tenderItemMatRefID, long fppMarketID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 */
	public void removeByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderMatUserGenCodeSNU(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

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
	public GDFTenderSubFPPMatDetails findByGDFTenderMatUserGenCodeSNU_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

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
	public GDFTenderSubFPPMatDetails fetchByGDFTenderMatUserGenCodeSNU_First(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails findByGDFTenderMatUserGenCodeSNU_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

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
	public GDFTenderSubFPPMatDetails fetchByGDFTenderMatUserGenCodeSNU_Last(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderMatUserGenCodeSNU_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 */
	public void removeByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderBySNUAndAndGenCode(
			long scheduleNumber, String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTenderBySNUAndAndGenCode_First(
			long scheduleNumber, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTenderBySNUAndAndGenCode_First(
		long scheduleNumber, String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDFTenderBySNUAndAndGenCode_Last(
			long scheduleNumber, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDFTenderBySNUAndAndGenCode_Last(
		long scheduleNumber, String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderBySNUAndAndGenCode_PrevAndNext(
				long tenderItemMatRefID, long scheduleNumber,
				String gdfGenericCode,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderItemMatRefID, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByFPP_Selected_Status_First(
			boolean fppSelectedStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_First(
		boolean fppSelectedStatus,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails findByFPP_Selected_Status_Last(
			boolean fppSelectedStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_Last(
		boolean fppSelectedStatus,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp mat detailses before and after the current gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param tenderItemMatRefID the primary key of the current gdf tender sub fpp mat details
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails[] findByFPP_Selected_Status_PrevAndNext(
			long tenderItemMatRefID, boolean fppSelectedStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63; from the database.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 */
	public void removeByFPP_Selected_Status(boolean fppSelectedStatus);

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	public int countByFPP_Selected_Status(boolean fppSelectedStatus);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails>
		findByGDFTenderByFIDUIDGenCodeSNUTRN(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator,
			boolean useFinderCache);

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
	public GDFTenderSubFPPMatDetails findByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

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
	public GDFTenderSubFPPMatDetails
		fetchByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails findByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

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
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				String tenderReferenceNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; and tenderReferenceNumber = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 */
	public void removeByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber);

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
	public int countByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber);

	/**
	 * Caches the gdf tender sub fpp mat details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 */
	public void cacheResult(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails);

	/**
	 * Caches the gdf tender sub fpp mat detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetailses the gdf tender sub fpp mat detailses
	 */
	public void cacheResult(
		java.util.List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatDetailses);

	/**
	 * Creates a new gdf tender sub fpp mat details with the primary key. Does not add the gdf tender sub fpp mat details to the database.
	 *
	 * @param tenderItemMatRefID the primary key for the new gdf tender sub fpp mat details
	 * @return the new gdf tender sub fpp mat details
	 */
	public GDFTenderSubFPPMatDetails create(long tenderItemMatRefID);

	/**
	 * Removes the gdf tender sub fpp mat details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails remove(long tenderItemMatRefID)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	public GDFTenderSubFPPMatDetails updateImpl(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails);

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or throws a <code>NoSuchGDFTenderSubFPPMatDetailsException</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails findByPrimaryKey(long tenderItemMatRefID)
		throws NoSuchGDFTenderSubFPPMatDetailsException;

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details, or <code>null</code> if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	public GDFTenderSubFPPMatDetails fetchByPrimaryKey(long tenderItemMatRefID);

	/**
	 * Returns all the gdf tender sub fpp mat detailses.
	 *
	 * @return the gdf tender sub fpp mat detailses
	 */
	public java.util.List<GDFTenderSubFPPMatDetails> findAll();

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
	public java.util.List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender sub fpp mat detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender sub fpp mat detailses.
	 *
	 * @return the number of gdf tender sub fpp mat detailses
	 */
	public int countAll();

}