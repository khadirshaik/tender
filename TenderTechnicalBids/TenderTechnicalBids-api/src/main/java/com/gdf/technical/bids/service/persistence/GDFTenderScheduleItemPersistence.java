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

import com.gdf.technical.bids.exception.NoSuchGDFTenderScheduleItemException;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gdf tender schedule item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @see GDFTenderScheduleItemUtil
 * @generated
 */
@ProviderType
public interface GDFTenderScheduleItemPersistence
	extends BasePersistence<GDFTenderScheduleItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GDFTenderScheduleItemUtil} to access the gdf tender schedule item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Reference_Number(String tenderReferenceNumber);

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDF_Tender_Reference_Number_First(
		String tenderReferenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDF_Tender_Reference_Number_Last(
		String tenderReferenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	public void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber);

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByGDF_Tender_Reference_Number(String tenderReferenceNumber);

	/**
	 * Returns all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns a range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param scheduleNumber the schedule number
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDF_Tender_Schedule_Number(
			long scheduleNumber, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem[] findByGDF_Tender_Schedule_Number_PrevAndNext(
			long tenderItemRefID, long scheduleNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Removes all the gdf tender schedule items where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns the number of gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber);

	/**
	 * Returns all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(long tenderItemNumber, long userId);

	/**
	 * Returns a range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderScheduleItemByUserId(
			long tenderItemNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDFTenderScheduleItemByUserId_First(
			long tenderItemNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDFTenderScheduleItemByUserId_First(
		long tenderItemNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDFTenderScheduleItemByUserId_Last(
			long tenderItemNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDFTenderScheduleItemByUserId_Last(
		long tenderItemNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem[]
			findByGDFTenderScheduleItemByUserId_PrevAndNext(
				long tenderItemRefID, long tenderItemNumber, long userId,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Removes all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 */
	public void removeByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId);

	/**
	 * Returns the number of gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId);

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderTendRefNoByUserId(
			String tenderReferenceNumber, long userId);

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderTendRefNoByUserId(
			String tenderReferenceNumber, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderTendRefNoByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByGDFTenderTendRefNoByUserId(
			String tenderReferenceNumber, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_First(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_First(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_Last(
			String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_Last(
		String tenderReferenceNumber, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem[] findByGDFTenderTendRefNoByUserId_PrevAndNext(
			long tenderItemRefID, String tenderReferenceNumber, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	public void removeByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId);

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or throws a <code>NoSuchGDFTenderScheduleItemException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, boolean useFinderCache);

	/**
	 * Removes the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the gdf tender schedule item that was removed
	 */
	public GDFTenderScheduleItem removeByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns a range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem>
		findByTenderItemByGenCodeAndSchedNo(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByTenderItemByGenCodeAndSchedNo_First(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByTenderItemByGenCodeAndSchedNo_First(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem findByTenderItemByGenCodeAndSchedNo_Last(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	public GDFTenderScheduleItem fetchByTenderItemByGenCodeAndSchedNo_Last(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem[]
			findByTenderItemByGenCodeAndSchedNo_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				long tenderItemNumber, long scheduleNumber,
				String gdfGenericCode,
				com.liferay.portal.kernel.util.OrderByComparator
					<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	public void removeByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	public int countByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode);

	/**
	 * Caches the gdf tender schedule item in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 */
	public void cacheResult(GDFTenderScheduleItem gdfTenderScheduleItem);

	/**
	 * Caches the gdf tender schedule items in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItems the gdf tender schedule items
	 */
	public void cacheResult(
		java.util.List<GDFTenderScheduleItem> gdfTenderScheduleItems);

	/**
	 * Creates a new gdf tender schedule item with the primary key. Does not add the gdf tender schedule item to the database.
	 *
	 * @param tenderItemRefID the primary key for the new gdf tender schedule item
	 * @return the new gdf tender schedule item
	 */
	public GDFTenderScheduleItem create(long tenderItemRefID);

	/**
	 * Removes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem remove(long tenderItemRefID)
		throws NoSuchGDFTenderScheduleItemException;

	public GDFTenderScheduleItem updateImpl(
		GDFTenderScheduleItem gdfTenderScheduleItem);

	/**
	 * Returns the gdf tender schedule item with the primary key or throws a <code>NoSuchGDFTenderScheduleItemException</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem findByPrimaryKey(long tenderItemRefID)
		throws NoSuchGDFTenderScheduleItemException;

	/**
	 * Returns the gdf tender schedule item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item, or <code>null</code> if a gdf tender schedule item with the primary key could not be found
	 */
	public GDFTenderScheduleItem fetchByPrimaryKey(long tenderItemRefID);

	/**
	 * Returns all the gdf tender schedule items.
	 *
	 * @return the gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem> findAll();

	/**
	 * Returns a range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gdf tender schedule items
	 */
	public java.util.List<GDFTenderScheduleItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GDFTenderScheduleItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gdf tender schedule items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gdf tender schedule items.
	 *
	 * @return the number of gdf tender schedule items
	 */
	public int countAll();

}