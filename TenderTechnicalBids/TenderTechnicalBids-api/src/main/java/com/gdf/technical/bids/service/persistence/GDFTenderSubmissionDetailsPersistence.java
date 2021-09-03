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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubmissionDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender submission details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubmissionDetailsUtil
 * @generated
 */
@ProviderType
public interface GDFTenderSubmissionDetailsPersistence
	extends BasePersistence<GDFTenderSubmissionDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderSubmissionDetailsUtil} to access the gdf tender submission details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber);

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, boolean useFinderCache);

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender submission details that was removed
	 */
	public GDFTenderSubmissionDetails removeByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender submission detailses
	 */
	public int countByGDF_Tender_Reference_Number(String tenderReferenceNumber);

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId);

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId, boolean useFinderCache);

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the gdf tender submission details that was removed
	 */
	public GDFTenderSubmissionDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63; and supplierId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	public int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId);

	/**
	 * Returns all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission detailses
	 */
	public java.util.List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId);

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
	public java.util.List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end);

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
	public java.util.List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails findByGDFTendersByUserId_First(
			long supplierId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDFTendersByUserId_First(
		long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator);

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails findByGDFTendersByUserId_Last(
			long supplierId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	public GDFTenderSubmissionDetails fetchByGDFTendersByUserId_Last(
		long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator);

	/**
	 * Returns the gdf tender submission detailses before and after the current gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param tenderSubRefID the primary key of the current gdf tender submission details
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public GDFTenderSubmissionDetails[] findByGDFTendersByUserId_PrevAndNext(
			long tenderSubRefID, long supplierId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Removes all the gdf tender submission detailses where supplierId = &#63; from the database.
	 *
	 * @param supplierId the supplier ID
	 */
	public void removeByGDFTendersByUserId(long supplierId);

	/**
	 * Returns the number of gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	public int countByGDFTendersByUserId(long supplierId);

	/**
	 * Caches the gdf tender submission details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 */
	public void cacheResult(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails);

	/**
	 * Caches the gdf tender submission detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetailses the gdf tender submission detailses
	 */
	public void cacheResult(
		java.util.List<GDFTenderSubmissionDetails>
			gdfTenderSubmissionDetailses);

	/**
	 * Creates a new gdf tender submission details with the primary key. Does not add the gdf tender submission details to the database.
	 *
	 * @param tenderSubRefID the primary key for the new gdf tender submission details
	 * @return the new gdf tender submission details
	 */
	public GDFTenderSubmissionDetails create(long tenderSubRefID);

	/**
	 * Removes the gdf tender submission details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public GDFTenderSubmissionDetails remove(long tenderSubRefID)
		throws NoSuchGDFTenderSubmissionDetailsException;

	public GDFTenderSubmissionDetails updateImpl(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails);

	/**
	 * Returns the gdf tender submission details with the primary key or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	public GDFTenderSubmissionDetails findByPrimaryKey(long tenderSubRefID)
		throws NoSuchGDFTenderSubmissionDetailsException;

	/**
	 * Returns the gdf tender submission details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details, or <code>null</code> if a gdf tender submission details with the primary key could not be found
	 */
	public GDFTenderSubmissionDetails fetchByPrimaryKey(long tenderSubRefID);

	/**
	 * Returns all the gdf tender submission detailses.
	 *
	 * @return the gdf tender submission detailses
	 */
	public java.util.List<GDFTenderSubmissionDetails> findAll();

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
	public java.util.List<GDFTenderSubmissionDetails> findAll(
		int start, int end);

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
	public java.util.List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubmissionDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender submission detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender submission detailses.
	 *
	 * @return the number of gdf tender submission detailses
	 */
	public int countAll();

}