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

import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.model.GDFTenderDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderDetailsUtil
 * @generated
 */
@ProviderType
public interface GDFTenderDetailsPersistence
	extends BasePersistence<GDFTenderDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderDetailsUtil} to access the gdf tender details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber);

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, boolean useFinderCache);

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender details that was removed
	 */
	public GDFTenderDetails removeByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender detailses
	 */
	public int countByGDF_Tender_Reference_Number(String tenderReferenceNumber);

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId, boolean useFinderCache);

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the gdf tender details that was removed
	 */
	public GDFTenderDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	public int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns all the gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching gdf tender detailses
	 */
	public java.util.List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId);

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
	public java.util.List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end);

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
	public java.util.List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator);

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
	public java.util.List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails findByGDFTendersByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
				orderByComparator)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDFTendersByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator);

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails findByGDFTendersByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
				orderByComparator)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	public GDFTenderDetails fetchByGDFTendersByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator);

	/**
	 * Returns the gdf tender detailses before and after the current gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param tenderRefID the primary key of the current gdf tender details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public GDFTenderDetails[] findByGDFTendersByUserId_PrevAndNext(
			long tenderRefID, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
				orderByComparator)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Removes all the gdf tender detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByGDFTendersByUserId(long userId);

	/**
	 * Returns the number of gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	public int countByGDFTendersByUserId(long userId);

	/**
	 * Caches the gdf tender details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 */
	public void cacheResult(GDFTenderDetails gdfTenderDetails);

	/**
	 * Caches the gdf tender detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetailses the gdf tender detailses
	 */
	public void cacheResult(
		java.util.List<GDFTenderDetails> gdfTenderDetailses);

	/**
	 * Creates a new gdf tender details with the primary key. Does not add the gdf tender details to the database.
	 *
	 * @param tenderRefID the primary key for the new gdf tender details
	 * @return the new gdf tender details
	 */
	public GDFTenderDetails create(long tenderRefID);

	/**
	 * Removes the gdf tender details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details that was removed
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public GDFTenderDetails remove(long tenderRefID)
		throws NoSuchGDFTenderDetailsException;

	public GDFTenderDetails updateImpl(GDFTenderDetails gdfTenderDetails);

	/**
	 * Returns the gdf tender details with the primary key or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	public GDFTenderDetails findByPrimaryKey(long tenderRefID)
		throws NoSuchGDFTenderDetailsException;

	/**
	 * Returns the gdf tender details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details, or <code>null</code> if a gdf tender details with the primary key could not be found
	 */
	public GDFTenderDetails fetchByPrimaryKey(long tenderRefID);

	/**
	 * Returns all the gdf tender detailses.
	 *
	 * @return the gdf tender detailses
	 */
	public java.util.List<GDFTenderDetails> findAll();

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
	public java.util.List<GDFTenderDetails> findAll(int start, int end);

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
	public java.util.List<GDFTenderDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator);

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
	public java.util.List<GDFTenderDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender detailses.
	 *
	 * @return the number of gdf tender detailses
	 */
	public int countAll();

}