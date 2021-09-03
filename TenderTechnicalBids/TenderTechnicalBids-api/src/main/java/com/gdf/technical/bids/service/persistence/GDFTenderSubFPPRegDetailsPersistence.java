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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubFPPRegDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender sub fpp reg details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetailsUtil
 * @generated
 */
@ProviderType
public interface GDFTenderSubFPPRegDetailsPersistence
	extends BasePersistence<GDFTenderSubFPPRegDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderSubFPPRegDetailsUtil} to access the gdf tender sub fpp reg details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTendRefSubFPPRegByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDFTendRefSubFPPRegByUserId_First(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTendRefSubFPPRegByUserId_First(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDFTendRefSubFPPRegByUserId_Last(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTendRefSubFPPRegByUserId_Last(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public GDFTenderSubFPPRegDetails[]
			findByGDFTendRefSubFPPRegByUserId_PrevAndNext(
				long tenderRegRefID, String tenderReferenceNumber, long userId,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public void removeByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(long scheduleNumber);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByFPP_Registration_ID_First(
			long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_First(
		long fppRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByFPP_Registration_ID_Last(
			long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_Last(
		long fppRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails[] findByFPP_Registration_ID_PrevAndNext(
			long tenderRegRefID, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63; from the database.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 */
	public void removeByFPP_Registration_ID(long fppRegistrationId);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByFPP_Registration_ID(long fppRegistrationId);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Reg_Ref_Id(long tenderRegRefID);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Reg_Ref_Id(long tenderRegRefID, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Reg_Ref_Id(
			long tenderRegRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDF_Tender_Reg_Ref_Id(
			long tenderRegRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_First(
			long tenderRegRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_First(
		long tenderRegRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_Last(
			long tenderRegRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_Last(
		long tenderRegRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 */
	public void removeByGDF_Tender_Reg_Ref_Id(long tenderRegRefID);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDF_Tender_Reg_Ref_Id(long tenderRegRefID);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderRegRefID, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderByTRIDAndFRID(
			long tenderRegRefID, long fppRegistrationId);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderByTRIDAndFRID(
			long tenderRegRefID, long fppRegistrationId, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderByTRIDAndFRID(
			long tenderRegRefID, long fppRegistrationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderByTRIDAndFRID(
			long tenderRegRefID, long fppRegistrationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_First(
			long tenderRegRefID, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_First(
		long tenderRegRefID, long fppRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_Last(
			long tenderRegRefID, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_Last(
		long tenderRegRefID, long fppRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 */
	public void removeByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId);

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUTRNUAndGenCode(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

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
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUTRNUAndGenCode_First(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTenderBySNUTRNUAndGenCode_First(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUTRNUAndGenCode_Last(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByGDFTenderBySNUTRNUAndGenCode_Last(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				String tenderReferenceNumber, String gdfGenericCode,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode);

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	public int countByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache);

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
	public GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUAndTRNUGenCodeFID_First(
				long scheduleNumber, long userId, String tenderReferenceNumber,
				String gdfGenericCode, long fppRegistrationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

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
	public GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_First(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

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
	public GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				long tenderRegRefID, long scheduleNumber, long userId,
				String tenderReferenceNumber, String gdfGenericCode,
				long fppRegistrationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 */
	public void removeByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId);

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
	public int countByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId);

	/**
	 * Caches the gdf tender sub fpp reg details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 */
	public void cacheResult(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails);

	/**
	 * Caches the gdf tender sub fpp reg detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetailses the gdf tender sub fpp reg detailses
	 */
	public void cacheResult(
		java.util.List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegDetailses);

	/**
	 * Creates a new gdf tender sub fpp reg details with the primary key. Does not add the gdf tender sub fpp reg details to the database.
	 *
	 * @param tenderRegRefID the primary key for the new gdf tender sub fpp reg details
	 * @return the new gdf tender sub fpp reg details
	 */
	public GDFTenderSubFPPRegDetails create(long tenderRegRefID);

	/**
	 * Removes the gdf tender sub fpp reg details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails remove(long tenderRegRefID)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	public GDFTenderSubFPPRegDetails updateImpl(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails);

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or throws a <code>NoSuchGDFTenderSubFPPRegDetailsException</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails findByPrimaryKey(long tenderRegRefID)
		throws NoSuchGDFTenderSubFPPRegDetailsException;

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details, or <code>null</code> if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public GDFTenderSubFPPRegDetails fetchByPrimaryKey(long tenderRegRefID);

	/**
	 * Returns all the gdf tender sub fpp reg detailses.
	 *
	 * @return the gdf tender sub fpp reg detailses
	 */
	public java.util.List<GDFTenderSubFPPRegDetails> findAll();

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
	public java.util.List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender sub fpp reg detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender sub fpp reg detailses.
	 *
	 * @return the number of gdf tender sub fpp reg detailses
	 */
	public int countAll();

}