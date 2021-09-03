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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubSchedDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubSchedDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender sub sched details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetailsUtil
 * @generated
 */
@ProviderType
public interface GDFTenderSubSchedDetailsPersistence
	extends BasePersistence<GDFTenderSubSchedDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderSubSchedDetailsUtil} to access the gdf tender sub sched details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(String tenderReferenceNumber);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Reference_Number_First(
		String tenderReferenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Reference_Number_Last(
		String tenderReferenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderSubSchedRefID, String tenderReferenceNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Removes all the gdf tender sub sched detailses where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	public void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber);

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDF_Tender_Reference_Number(String tenderReferenceNumber);

	/**
	 * Returns all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Sub_Sched_Ref_Id(
			long tenderSubSchedRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Sub_Sched_Ref_Id_First(
			long tenderSubSchedRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Sub_Sched_Ref_Id_First(
		long tenderSubSchedRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Sub_Sched_Ref_Id_Last(
			long tenderSubSchedRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Sub_Sched_Ref_Id_Last(
		long tenderSubSchedRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Removes all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63; from the database.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 */
	public void removeByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID);

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID);

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(long scheduleNumber);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode);

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
	public java.util.List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderSubSchedRefID, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Removes all the gdf tender sub sched detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns the number of gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDF_Generic_Code(String gdfGenericCode);

	/**
	 * Returns all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Item_Ref_Id(long tenderItemRefID);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Item_Ref_Id(long tenderItemRefID, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Item_Ref_Id(
			long tenderItemRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDF_Tender_Item_Ref_Id(
			long tenderItemRefID, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_First(
			long tenderItemRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_First(
		long tenderItemRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_Last(
			long tenderItemRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_Last(
		long tenderItemRefID,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails[] findByGDF_Tender_Item_Ref_Id_PrevAndNext(
			long tenderSubSchedRefID, long tenderItemRefID,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Removes all the gdf tender sub sched detailses where tenderItemRefID = &#63; from the database.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 */
	public void removeByGDF_Tender_Item_Ref_Id(long tenderItemRefID);

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDF_Tender_Item_Ref_Id(long tenderItemRefID);

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the matching gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails>
		findByGDFTenderSubBySNUAndTRNUAndTINU(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator,
			boolean useFinderCache);

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
	public GDFTenderSubSchedDetails findByGDFTenderSubBySNUAndTRNUAndTINU_First(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails
		fetchByGDFTenderSubBySNUAndTRNUAndTINU_First(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator);

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
	public GDFTenderSubSchedDetails findByGDFTenderSubBySNUAndTRNUAndTINU_Last(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	public GDFTenderSubSchedDetails fetchByGDFTenderSubBySNUAndTRNUAndTINU_Last(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

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
	public GDFTenderSubSchedDetails[]
			findByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				String tenderReferenceNumber, long tenderItemNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 */
	public void removeByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber);

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	public int countByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber);

	/**
	 * Caches the gdf tender sub sched details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 */
	public void cacheResult(GDFTenderSubSchedDetails gdfTenderSubSchedDetails);

	/**
	 * Caches the gdf tender sub sched detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetailses the gdf tender sub sched detailses
	 */
	public void cacheResult(
		java.util.List<GDFTenderSubSchedDetails> gdfTenderSubSchedDetailses);

	/**
	 * Creates a new gdf tender sub sched details with the primary key. Does not add the gdf tender sub sched details to the database.
	 *
	 * @param tenderSubSchedRefID the primary key for the new gdf tender sub sched details
	 * @return the new gdf tender sub sched details
	 */
	public GDFTenderSubSchedDetails create(long tenderSubSchedRefID);

	/**
	 * Removes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails remove(long tenderSubSchedRefID)
		throws NoSuchGDFTenderSubSchedDetailsException;

	public GDFTenderSubSchedDetails updateImpl(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails);

	/**
	 * Returns the gdf tender sub sched details with the primary key or throws a <code>NoSuchGDFTenderSubSchedDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails findByPrimaryKey(long tenderSubSchedRefID)
		throws NoSuchGDFTenderSubSchedDetailsException;

	/**
	 * Returns the gdf tender sub sched details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details, or <code>null</code> if a gdf tender sub sched details with the primary key could not be found
	 */
	public GDFTenderSubSchedDetails fetchByPrimaryKey(long tenderSubSchedRefID);

	/**
	 * Returns all the gdf tender sub sched detailses.
	 *
	 * @return the gdf tender sub sched detailses
	 */
	public java.util.List<GDFTenderSubSchedDetails> findAll();

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
	public java.util.List<GDFTenderSubSchedDetails> findAll(int start, int end);

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
	public java.util.List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator);

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
	public java.util.List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender sub sched detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender sub sched detailses.
	 *
	 * @return the number of gdf tender sub sched detailses
	 */
	public int countAll();

}