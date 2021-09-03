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

package com.gdf.technical.bids.service.persistence.impl;

import com.gdf.technical.bids.exception.NoSuchGDFTenderScheduleItemException;
import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.model.impl.GDFTenderScheduleItemImpl;
import com.gdf.technical.bids.model.impl.GDFTenderScheduleItemModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderScheduleItemPersistence;
import com.gdf.technical.bids.service.persistence.impl.constants.PRTPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the gdf tender schedule item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderScheduleItemPersistence.class)
public class GDFTenderScheduleItemPersistenceImpl
	extends BasePersistenceImpl<GDFTenderScheduleItem>
	implements GDFTenderScheduleItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderScheduleItemUtil</code> to access the gdf tender schedule item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderScheduleItemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Reference_Number;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number;
	private FinderPath _finderPathCountByGDF_Tender_Reference_Number;

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number;
				finderArgs = new Object[] {tenderReferenceNumber};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDF_Tender_Reference_Number;
			finderArgs = new Object[] {
				tenderReferenceNumber, start, end, orderByComparator
			};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderScheduleItem gdfTenderScheduleItem : list) {
					if (!tenderReferenceNumber.equals(
							gdfTenderScheduleItem.getTenderReferenceNumber())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDF_Tender_Reference_Number_First(
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDF_Tender_Reference_Number_First(
		String tenderReferenceNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		List<GDFTenderScheduleItem> list = findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDF_Tender_Reference_Number_Last(
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDF_Tender_Reference_Number_Last(
		String tenderReferenceNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		int count = countByGDF_Tender_Reference_Number(tenderReferenceNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderScheduleItem> list = findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderScheduleItem gdfTenderScheduleItem = findByPrimaryKey(
			tenderItemRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem[] array = new GDFTenderScheduleItemImpl[3];

			array[0] = getByGDF_Tender_Reference_Number_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber,
				orderByComparator, true);

			array[1] = gdfTenderScheduleItem;

			array[2] = getByGDF_Tender_Reference_Number_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderScheduleItem
		getByGDF_Tender_Reference_Number_PrevAndNext(
			Session session, GDFTenderScheduleItem gdfTenderScheduleItem,
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderScheduleItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderScheduleItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	@Override
	public void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				findByGDF_Tender_Reference_Number(
					tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDF_Tender_Reference_Number;

		Object[] finderArgs = new Object[] {tenderReferenceNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_2 =
			"gdfTenderScheduleItem.tenderReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3 =
			"(gdfTenderScheduleItem.tenderReferenceNumber IS NULL OR gdfTenderScheduleItem.tenderReferenceNumber = '')";

	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath _finderPathCountByGDF_Tender_Schedule_Number;

	/**
	 * Returns all the gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number;
				finderArgs = new Object[] {scheduleNumber};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDF_Tender_Schedule_Number;
			finderArgs = new Object[] {
				scheduleNumber, start, end, orderByComparator
			};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderScheduleItem gdfTenderScheduleItem : list) {
					if (scheduleNumber !=
							gdfTenderScheduleItem.getScheduleNumber()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDF_Tender_Schedule_Number_First(
				scheduleNumber, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		List<GDFTenderScheduleItem> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDF_Tender_Schedule_Number_Last(
				scheduleNumber, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		int count = countByGDF_Tender_Schedule_Number(scheduleNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderScheduleItem> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender schedule items before and after the current gdf tender schedule item in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderItemRefID the primary key of the current gdf tender schedule item
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem[] findByGDF_Tender_Schedule_Number_PrevAndNext(
			long tenderItemRefID, long scheduleNumber,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem = findByPrimaryKey(
			tenderItemRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem[] array = new GDFTenderScheduleItemImpl[3];

			array[0] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderScheduleItem, scheduleNumber,
				orderByComparator, true);

			array[1] = gdfTenderScheduleItem;

			array[2] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderScheduleItem, scheduleNumber,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderScheduleItem getByGDF_Tender_Schedule_Number_PrevAndNext(
		Session session, GDFTenderScheduleItem gdfTenderScheduleItem,
		long scheduleNumber,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

		sb.append(_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderScheduleItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderScheduleItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender schedule items where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	@Override
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				findByGDF_Tender_Schedule_Number(
					scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Schedule_Number;

		Object[] finderArgs = new Object[] {scheduleNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2 =
			"gdfTenderScheduleItem.scheduleNumber = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderScheduleItemByUserId;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId;
	private FinderPath _finderPathCountByGDFTenderScheduleItemByUserId;

	/**
	 * Returns all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId) {

		return findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId, int start, int end) {

		return findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId;
				finderArgs = new Object[] {tenderItemNumber, userId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderScheduleItemByUserId;
			finderArgs = new Object[] {
				tenderItemNumber, userId, start, end, orderByComparator
			};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderScheduleItem gdfTenderScheduleItem : list) {
					if ((tenderItemNumber !=
							gdfTenderScheduleItem.getTenderItemNumber()) ||
						(userId != gdfTenderScheduleItem.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_TENDERITEMNUMBER_2);

			sb.append(_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemNumber);

				queryPos.add(userId);

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDFTenderScheduleItemByUserId_First(
			long tenderItemNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDFTenderScheduleItemByUserId_First(
				tenderItemNumber, userId, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDFTenderScheduleItemByUserId_First(
		long tenderItemNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		List<GDFTenderScheduleItem> list = findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDFTenderScheduleItemByUserId_Last(
			long tenderItemNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDFTenderScheduleItemByUserId_Last(
				tenderItemNumber, userId, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDFTenderScheduleItemByUserId_Last(
		long tenderItemNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		int count = countByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderScheduleItem> list = findByGDFTenderScheduleItemByUserId(
			tenderItemNumber, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderScheduleItem[]
			findByGDFTenderScheduleItemByUserId_PrevAndNext(
				long tenderItemRefID, long tenderItemNumber, long userId,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem = findByPrimaryKey(
			tenderItemRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem[] array = new GDFTenderScheduleItemImpl[3];

			array[0] = getByGDFTenderScheduleItemByUserId_PrevAndNext(
				session, gdfTenderScheduleItem, tenderItemNumber, userId,
				orderByComparator, true);

			array[1] = gdfTenderScheduleItem;

			array[2] = getByGDFTenderScheduleItemByUserId_PrevAndNext(
				session, gdfTenderScheduleItem, tenderItemNumber, userId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderScheduleItem
		getByGDFTenderScheduleItemByUserId_PrevAndNext(
			Session session, GDFTenderScheduleItem gdfTenderScheduleItem,
			long tenderItemNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

		sb.append(
			_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_TENDERITEMNUMBER_2);

		sb.append(_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tenderItemNumber);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderScheduleItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderScheduleItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 */
	@Override
	public void removeByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId) {

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				findByGDFTenderScheduleItemByUserId(
					tenderItemNumber, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderItemNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderItemNumber the tender item number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByGDFTenderScheduleItemByUserId(
		long tenderItemNumber, long userId) {

		FinderPath finderPath = _finderPathCountByGDFTenderScheduleItemByUserId;

		Object[] finderArgs = new Object[] {tenderItemNumber, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_TENDERITEMNUMBER_2);

			sb.append(_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemNumber);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_TENDERITEMNUMBER_2 =
			"gdfTenderScheduleItem.tenderItemNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERSCHEDULEITEMBYUSERID_USERID_2 =
			"gdfTenderScheduleItem.userId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderTendRefNoByUserId;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId;
	private FinderPath _finderPathCountByGDFTenderTendRefNoByUserId;

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		return findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end) {

		return findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId;
				finderArgs = new Object[] {tenderReferenceNumber, userId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderTendRefNoByUserId;
			finderArgs = new Object[] {
				tenderReferenceNumber, userId, start, end, orderByComparator
			};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderScheduleItem gdfTenderScheduleItem : list) {
					if (!tenderReferenceNumber.equals(
							gdfTenderScheduleItem.getTenderReferenceNumber()) ||
						(userId != gdfTenderScheduleItem.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(userId);

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDFTenderTendRefNoByUserId_First(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the first gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_First(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		List<GDFTenderScheduleItem> list = findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByGDFTenderTendRefNoByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByGDFTenderTendRefNoByUserId_Last(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

	/**
	 * Returns the last gdf tender schedule item in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByGDFTenderTendRefNoByUserId_Last(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		int count = countByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderScheduleItem> list = findByGDFTenderTendRefNoByUserId(
			tenderReferenceNumber, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderScheduleItem[] findByGDFTenderTendRefNoByUserId_PrevAndNext(
			long tenderItemRefID, String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderScheduleItem gdfTenderScheduleItem = findByPrimaryKey(
			tenderItemRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem[] array = new GDFTenderScheduleItemImpl[3];

			array[0] = getByGDFTenderTendRefNoByUserId_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber, userId,
				orderByComparator, true);

			array[1] = gdfTenderScheduleItem;

			array[2] = getByGDFTenderTendRefNoByUserId_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber, userId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderScheduleItem getByGDFTenderTendRefNoByUserId_PrevAndNext(
		Session session, GDFTenderScheduleItem gdfTenderScheduleItem,
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_2);
		}

		sb.append(_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderScheduleItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderScheduleItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	@Override
	public void removeByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				findByGDFTenderTendRefNoByUserId(
					tenderReferenceNumber, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByGDFTenderTendRefNoByUserId(
		String tenderReferenceNumber, long userId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDFTenderTendRefNoByUserId;

		Object[] finderArgs = new Object[] {tenderReferenceNumber, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_2 =
			"gdfTenderScheduleItem.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderScheduleItem.tenderReferenceNumber IS NULL OR gdfTenderScheduleItem.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERTENDREFNOBYUSERID_USERID_2 =
			"gdfTenderScheduleItem.userId = ?";

	private FinderPath _finderPathFetchByTenderItemByScheduleIdGenCode;
	private FinderPath _finderPathCountByTenderItemByScheduleIdGenCode;

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
	@Override
	public GDFTenderScheduleItem findByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByTenderItemByScheduleIdGenCode(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode);

		if (gdfTenderScheduleItem == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tenderReferenceNumber=");
			sb.append(tenderReferenceNumber);

			sb.append(", tenderItemNumber=");
			sb.append(tenderItemNumber);

			sb.append(", scheduleNumber=");
			sb.append(scheduleNumber);

			sb.append(", gdfGenericCode=");
			sb.append(gdfGenericCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGDFTenderScheduleItemException(sb.toString());
		}

		return gdfTenderScheduleItem;
	}

	/**
	 * Returns the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule item, or <code>null</code> if a matching gdf tender schedule item could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		return fetchByTenderItemByScheduleIdGenCode(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, true);
	}

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
	@Override
	public GDFTenderScheduleItem fetchByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTenderItemByScheduleIdGenCode, finderArgs,
				this);
		}

		if (result instanceof GDFTenderScheduleItem) {
			GDFTenderScheduleItem gdfTenderScheduleItem =
				(GDFTenderScheduleItem)result;

			if (!Objects.equals(
					tenderReferenceNumber,
					gdfTenderScheduleItem.getTenderReferenceNumber()) ||
				(tenderItemNumber !=
					gdfTenderScheduleItem.getTenderItemNumber()) ||
				(scheduleNumber != gdfTenderScheduleItem.getScheduleNumber()) ||
				!Objects.equals(
					gdfGenericCode,
					gdfTenderScheduleItem.getGdfGenericCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERITEMNUMBER_2);

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(tenderItemNumber);

				queryPos.add(scheduleNumber);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				List<GDFTenderScheduleItem> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTenderItemByScheduleIdGenCode,
							finderArgs, list);
					}
				}
				else {
					GDFTenderScheduleItem gdfTenderScheduleItem = list.get(0);

					result = gdfTenderScheduleItem;

					cacheResult(gdfTenderScheduleItem);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByTenderItemByScheduleIdGenCode,
						finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GDFTenderScheduleItem)result;
		}
	}

	/**
	 * Removes the gdf tender schedule item where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the gdf tender schedule item that was removed
	 */
	@Override
	public GDFTenderScheduleItem removeByTenderItemByScheduleIdGenCode(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			findByTenderItemByScheduleIdGenCode(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode);

		return remove(gdfTenderScheduleItem);
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByTenderItemByScheduleIdGenCode(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByTenderItemByScheduleIdGenCode;

		Object[] finderArgs = new Object[] {
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERITEMNUMBER_2);

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(tenderItemNumber);

				queryPos.add(scheduleNumber);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_2 =
			"gdfTenderScheduleItem.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERREFERENCENUMBER_3 =
			"(gdfTenderScheduleItem.tenderReferenceNumber IS NULL OR gdfTenderScheduleItem.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_TENDERITEMNUMBER_2 =
			"gdfTenderScheduleItem.tenderItemNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_SCHEDULENUMBER_2 =
			"gdfTenderScheduleItem.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_2 =
			"gdfTenderScheduleItem.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYSCHEDULEIDGENCODE_GDFGENERICCODE_3 =
			"(gdfTenderScheduleItem.gdfGenericCode IS NULL OR gdfTenderScheduleItem.gdfGenericCode = '')";

	private FinderPath
		_finderPathWithPaginationFindByTenderItemByGenCodeAndSchedNo;
	private FinderPath
		_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo;
	private FinderPath _finderPathCountByTenderItemByGenCodeAndSchedNo;

	/**
	 * Returns all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		return findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, int start, int end) {

		return findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo;
				finderArgs = new Object[] {
					tenderReferenceNumber, tenderItemNumber, scheduleNumber,
					gdfGenericCode
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTenderItemByGenCodeAndSchedNo;
			finderArgs = new Object[] {
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode, start, end, orderByComparator
			};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderScheduleItem gdfTenderScheduleItem : list) {
					if (!tenderReferenceNumber.equals(
							gdfTenderScheduleItem.getTenderReferenceNumber()) ||
						(tenderItemNumber !=
							gdfTenderScheduleItem.getTenderItemNumber()) ||
						(scheduleNumber !=
							gdfTenderScheduleItem.getScheduleNumber()) ||
						!gdfGenericCode.equals(
							gdfTenderScheduleItem.getGdfGenericCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERITEMNUMBER_2);

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(tenderItemNumber);

				queryPos.add(scheduleNumber);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public GDFTenderScheduleItem findByTenderItemByGenCodeAndSchedNo_First(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByTenderItemByGenCodeAndSchedNo_First(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

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
	@Override
	public GDFTenderScheduleItem fetchByTenderItemByGenCodeAndSchedNo_First(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		List<GDFTenderScheduleItem> list = findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderScheduleItem findByTenderItemByGenCodeAndSchedNo_Last(
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem =
			fetchByTenderItemByGenCodeAndSchedNo_Last(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode, orderByComparator);

		if (gdfTenderScheduleItem != null) {
			return gdfTenderScheduleItem;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderScheduleItemException(sb.toString());
	}

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
	@Override
	public GDFTenderScheduleItem fetchByTenderItemByGenCodeAndSchedNo_Last(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		int count = countByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderScheduleItem> list = findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderScheduleItem[]
			findByTenderItemByGenCodeAndSchedNo_PrevAndNext(
				long tenderItemRefID, String tenderReferenceNumber,
				long tenderItemNumber, long scheduleNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderScheduleItem> orderByComparator)
		throws NoSuchGDFTenderScheduleItemException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderScheduleItem gdfTenderScheduleItem = findByPrimaryKey(
			tenderItemRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem[] array = new GDFTenderScheduleItemImpl[3];

			array[0] = getByTenderItemByGenCodeAndSchedNo_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber,
				tenderItemNumber, scheduleNumber, gdfGenericCode,
				orderByComparator, true);

			array[1] = gdfTenderScheduleItem;

			array[2] = getByTenderItemByGenCodeAndSchedNo_PrevAndNext(
				session, gdfTenderScheduleItem, tenderReferenceNumber,
				tenderItemNumber, scheduleNumber, gdfGenericCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderScheduleItem
		getByTenderItemByGenCodeAndSchedNo_PrevAndNext(
			Session session, GDFTenderScheduleItem gdfTenderScheduleItem,
			String tenderReferenceNumber, long tenderItemNumber,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderScheduleItem> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_2);
		}

		sb.append(
			_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERITEMNUMBER_2);

		sb.append(
			_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_SCHEDULENUMBER_2);

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		queryPos.add(tenderItemNumber);

		queryPos.add(scheduleNumber);

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderScheduleItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderScheduleItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				findByTenderItemByGenCodeAndSchedNo(
					tenderReferenceNumber, tenderItemNumber, scheduleNumber,
					gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items where tenderReferenceNumber = &#63; and tenderItemNumber = &#63; and scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender schedule items
	 */
	@Override
	public int countByTenderItemByGenCodeAndSchedNo(
		String tenderReferenceNumber, long tenderItemNumber,
		long scheduleNumber, String gdfGenericCode) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByTenderItemByGenCodeAndSchedNo;

		Object[] finderArgs = new Object[] {
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERITEMNUMBER_2);

			sb.append(
				_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(tenderItemNumber);

				queryPos.add(scheduleNumber);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_2 =
			"gdfTenderScheduleItem.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERREFERENCENUMBER_3 =
			"(gdfTenderScheduleItem.tenderReferenceNumber IS NULL OR gdfTenderScheduleItem.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_TENDERITEMNUMBER_2 =
			"gdfTenderScheduleItem.tenderItemNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_SCHEDULENUMBER_2 =
			"gdfTenderScheduleItem.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_2 =
			"gdfTenderScheduleItem.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_TENDERITEMBYGENCODEANDSCHEDNO_GDFGENERICCODE_3 =
			"(gdfTenderScheduleItem.gdfGenericCode IS NULL OR gdfTenderScheduleItem.gdfGenericCode = '')";

	public GDFTenderScheduleItemPersistenceImpl() {
		setModelClass(GDFTenderScheduleItem.class);

		setModelImplClass(GDFTenderScheduleItemImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderItemRefID", "GDF_Tender_Item_Ref_Id");
		dbColumnNames.put("tenderItemNumber", "GDF_Tender_Item_Num");
		dbColumnNames.put("scheduleNumber", "GDF_Tender_Schedule_Number");
		dbColumnNames.put("generalDescription", "GDF_Generic_Desc");
		dbColumnNames.put("primaryPackaging", "Prim_Packaging");
		dbColumnNames.put("secondaryPackaging", "Sec_Packaging");
		dbColumnNames.put("gdfGenericCode", "GDF_Generic_Code");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put("scheduleName", "GDF_Tender_Schedule_Name");
		dbColumnNames.put("patientTarget", "GDF_PatientTarget");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender schedule item in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 */
	@Override
	public void cacheResult(GDFTenderScheduleItem gdfTenderScheduleItem) {
		entityCache.putResult(
			entityCacheEnabled, GDFTenderScheduleItemImpl.class,
			gdfTenderScheduleItem.getPrimaryKey(), gdfTenderScheduleItem);

		finderCache.putResult(
			_finderPathFetchByTenderItemByScheduleIdGenCode,
			new Object[] {
				gdfTenderScheduleItem.getTenderReferenceNumber(),
				gdfTenderScheduleItem.getTenderItemNumber(),
				gdfTenderScheduleItem.getScheduleNumber(),
				gdfTenderScheduleItem.getGdfGenericCode()
			},
			gdfTenderScheduleItem);

		gdfTenderScheduleItem.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender schedule items in the entity cache if it is enabled.
	 *
	 * @param gdfTenderScheduleItems the gdf tender schedule items
	 */
	@Override
	public void cacheResult(
		List<GDFTenderScheduleItem> gdfTenderScheduleItems) {

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				gdfTenderScheduleItems) {

			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderScheduleItemImpl.class,
					gdfTenderScheduleItem.getPrimaryKey()) == null) {

				cacheResult(gdfTenderScheduleItem);
			}
			else {
				gdfTenderScheduleItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender schedule items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderScheduleItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender schedule item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GDFTenderScheduleItem gdfTenderScheduleItem) {
		entityCache.removeResult(
			entityCacheEnabled, GDFTenderScheduleItemImpl.class,
			gdfTenderScheduleItem.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(GDFTenderScheduleItemModelImpl)gdfTenderScheduleItem, true);
	}

	@Override
	public void clearCache(List<GDFTenderScheduleItem> gdfTenderScheduleItems) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderScheduleItem gdfTenderScheduleItem :
				gdfTenderScheduleItems) {

			entityCache.removeResult(
				entityCacheEnabled, GDFTenderScheduleItemImpl.class,
				gdfTenderScheduleItem.getPrimaryKey());

			clearUniqueFindersCache(
				(GDFTenderScheduleItemModelImpl)gdfTenderScheduleItem, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderScheduleItemImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		GDFTenderScheduleItemModelImpl gdfTenderScheduleItemModelImpl) {

		Object[] args = new Object[] {
			gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
			gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
			gdfTenderScheduleItemModelImpl.getScheduleNumber(),
			gdfTenderScheduleItemModelImpl.getGdfGenericCode()
		};

		finderCache.putResult(
			_finderPathCountByTenderItemByScheduleIdGenCode, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTenderItemByScheduleIdGenCode, args,
			gdfTenderScheduleItemModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		GDFTenderScheduleItemModelImpl gdfTenderScheduleItemModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
				gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
				gdfTenderScheduleItemModelImpl.getScheduleNumber(),
				gdfTenderScheduleItemModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(
				_finderPathCountByTenderItemByScheduleIdGenCode, args);
			finderCache.removeResult(
				_finderPathFetchByTenderItemByScheduleIdGenCode, args);
		}

		if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
			 _finderPathFetchByTenderItemByScheduleIdGenCode.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				gdfTenderScheduleItemModelImpl.
					getOriginalTenderReferenceNumber(),
				gdfTenderScheduleItemModelImpl.getOriginalTenderItemNumber(),
				gdfTenderScheduleItemModelImpl.getOriginalScheduleNumber(),
				gdfTenderScheduleItemModelImpl.getOriginalGdfGenericCode()
			};

			finderCache.removeResult(
				_finderPathCountByTenderItemByScheduleIdGenCode, args);
			finderCache.removeResult(
				_finderPathFetchByTenderItemByScheduleIdGenCode, args);
		}
	}

	/**
	 * Creates a new gdf tender schedule item with the primary key. Does not add the gdf tender schedule item to the database.
	 *
	 * @param tenderItemRefID the primary key for the new gdf tender schedule item
	 * @return the new gdf tender schedule item
	 */
	@Override
	public GDFTenderScheduleItem create(long tenderItemRefID) {
		GDFTenderScheduleItem gdfTenderScheduleItem =
			new GDFTenderScheduleItemImpl();

		gdfTenderScheduleItem.setNew(true);
		gdfTenderScheduleItem.setPrimaryKey(tenderItemRefID);

		return gdfTenderScheduleItem;
	}

	/**
	 * Removes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem remove(long tenderItemRefID)
		throws NoSuchGDFTenderScheduleItemException {

		return remove((Serializable)tenderItemRefID);
	}

	/**
	 * Removes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem remove(Serializable primaryKey)
		throws NoSuchGDFTenderScheduleItemException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderScheduleItem gdfTenderScheduleItem =
				(GDFTenderScheduleItem)session.get(
					GDFTenderScheduleItemImpl.class, primaryKey);

			if (gdfTenderScheduleItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderScheduleItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderScheduleItem);
		}
		catch (NoSuchGDFTenderScheduleItemException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GDFTenderScheduleItem removeImpl(
		GDFTenderScheduleItem gdfTenderScheduleItem) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderScheduleItem)) {
				gdfTenderScheduleItem = (GDFTenderScheduleItem)session.get(
					GDFTenderScheduleItemImpl.class,
					gdfTenderScheduleItem.getPrimaryKeyObj());
			}

			if (gdfTenderScheduleItem != null) {
				session.delete(gdfTenderScheduleItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderScheduleItem != null) {
			clearCache(gdfTenderScheduleItem);
		}

		return gdfTenderScheduleItem;
	}

	@Override
	public GDFTenderScheduleItem updateImpl(
		GDFTenderScheduleItem gdfTenderScheduleItem) {

		boolean isNew = gdfTenderScheduleItem.isNew();

		if (!(gdfTenderScheduleItem instanceof
				GDFTenderScheduleItemModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderScheduleItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderScheduleItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderScheduleItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderScheduleItem implementation " +
					gdfTenderScheduleItem.getClass());
		}

		GDFTenderScheduleItemModelImpl gdfTenderScheduleItemModelImpl =
			(GDFTenderScheduleItemModelImpl)gdfTenderScheduleItem;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderScheduleItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderScheduleItem.setCreateDate(now);
			}
			else {
				gdfTenderScheduleItem.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderScheduleItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderScheduleItem.setModifiedDate(now);
			}
			else {
				gdfTenderScheduleItem.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderScheduleItem.isNew()) {
				session.save(gdfTenderScheduleItem);

				gdfTenderScheduleItem.setNew(false);
			}
			else {
				gdfTenderScheduleItem = (GDFTenderScheduleItem)session.merge(
					gdfTenderScheduleItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				gdfTenderScheduleItemModelImpl.getTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
				args);

			args = new Object[] {
				gdfTenderScheduleItemModelImpl.getScheduleNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Schedule_Number, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
				args);

			args = new Object[] {
				gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
				gdfTenderScheduleItemModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderScheduleItemByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId,
				args);

			args = new Object[] {
				gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
				gdfTenderScheduleItemModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderTendRefNoByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId,
				args);

			args = new Object[] {
				gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
				gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
				gdfTenderScheduleItemModelImpl.getScheduleNumber(),
				gdfTenderScheduleItemModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(
				_finderPathCountByTenderItemByGenCodeAndSchedNo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Reference_Number.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderScheduleItemModelImpl.
						getOriginalTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reference_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
					args);

				args = new Object[] {
					gdfTenderScheduleItemModelImpl.getTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reference_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
					args);
			}

			if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderScheduleItemModelImpl.getOriginalScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);

				args = new Object[] {
					gdfTenderScheduleItemModelImpl.getScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);
			}

			if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderScheduleItemModelImpl.
						getOriginalTenderItemNumber(),
					gdfTenderScheduleItemModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderScheduleItemByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId,
					args);

				args = new Object[] {
					gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
					gdfTenderScheduleItemModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderScheduleItemByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId,
					args);
			}

			if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderScheduleItemModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderScheduleItemModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderTendRefNoByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId,
					args);

				args = new Object[] {
					gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
					gdfTenderScheduleItemModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderTendRefNoByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId,
					args);
			}

			if ((gdfTenderScheduleItemModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderScheduleItemModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderScheduleItemModelImpl.
						getOriginalTenderItemNumber(),
					gdfTenderScheduleItemModelImpl.getOriginalScheduleNumber(),
					gdfTenderScheduleItemModelImpl.getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByTenderItemByGenCodeAndSchedNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo,
					args);

				args = new Object[] {
					gdfTenderScheduleItemModelImpl.getTenderReferenceNumber(),
					gdfTenderScheduleItemModelImpl.getTenderItemNumber(),
					gdfTenderScheduleItemModelImpl.getScheduleNumber(),
					gdfTenderScheduleItemModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByTenderItemByGenCodeAndSchedNo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderScheduleItemImpl.class,
			gdfTenderScheduleItem.getPrimaryKey(), gdfTenderScheduleItem,
			false);

		clearUniqueFindersCache(gdfTenderScheduleItemModelImpl, false);
		cacheUniqueFindersCache(gdfTenderScheduleItemModelImpl);

		gdfTenderScheduleItem.resetOriginalValues();

		return gdfTenderScheduleItem;
	}

	/**
	 * Returns the gdf tender schedule item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderScheduleItemException {

		GDFTenderScheduleItem gdfTenderScheduleItem = fetchByPrimaryKey(
			primaryKey);

		if (gdfTenderScheduleItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderScheduleItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderScheduleItem;
	}

	/**
	 * Returns the gdf tender schedule item with the primary key or throws a <code>NoSuchGDFTenderScheduleItemException</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws NoSuchGDFTenderScheduleItemException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem findByPrimaryKey(long tenderItemRefID)
		throws NoSuchGDFTenderScheduleItemException {

		return findByPrimaryKey((Serializable)tenderItemRefID);
	}

	/**
	 * Returns the gdf tender schedule item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item, or <code>null</code> if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public GDFTenderScheduleItem fetchByPrimaryKey(long tenderItemRefID) {
		return fetchByPrimaryKey((Serializable)tenderItemRefID);
	}

	/**
	 * Returns all the gdf tender schedule items.
	 *
	 * @return the gdf tender schedule items
	 */
	@Override
	public List<GDFTenderScheduleItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findAll(
		int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderScheduleItem> findAll(
		int start, int end,
		OrderByComparator<GDFTenderScheduleItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<GDFTenderScheduleItem> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderScheduleItem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERSCHEDULEITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERSCHEDULEITEM;

				sql = sql.concat(GDFTenderScheduleItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderScheduleItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the gdf tender schedule items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderScheduleItem gdfTenderScheduleItem : findAll()) {
			remove(gdfTenderScheduleItem);
		}
	}

	/**
	 * Returns the number of gdf tender schedule items.
	 *
	 * @return the number of gdf tender schedule items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_GDFTENDERSCHEDULEITEM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "GDF_Tender_Item_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERSCHEDULEITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderScheduleItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender schedule item persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderScheduleItemModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		GDFTenderScheduleItemModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderScheduleItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderScheduleItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGDF_Tender_Reference_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Reference_Number",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Reference_Number",
				new String[] {String.class.getName()},
				GDFTenderScheduleItemModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {Long.class.getName()},
				GDFTenderScheduleItemModelImpl.SCHEDULENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Schedule_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Schedule_Number",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderScheduleItemByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderScheduleItemByUserId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderScheduleItemByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderScheduleItemByUserId",
				new String[] {Long.class.getName(), Long.class.getName()},
				GDFTenderScheduleItemModelImpl.TENDERITEMNUMBER_COLUMN_BITMASK |
				GDFTenderScheduleItemModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderScheduleItemByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderScheduleItemByUserId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderTendRefNoByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderTendRefNoByUserId",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderTendRefNoByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderTendRefNoByUserId",
				new String[] {String.class.getName(), Long.class.getName()},
				GDFTenderScheduleItemModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderScheduleItemModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderTendRefNoByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderTendRefNoByUserId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByTenderItemByScheduleIdGenCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderScheduleItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTenderItemByScheduleIdGenCode",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			GDFTenderScheduleItemModelImpl.
				TENDERREFERENCENUMBER_COLUMN_BITMASK |
			GDFTenderScheduleItemModelImpl.TENDERITEMNUMBER_COLUMN_BITMASK |
			GDFTenderScheduleItemModelImpl.SCHEDULENUMBER_COLUMN_BITMASK |
			GDFTenderScheduleItemModelImpl.GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByTenderItemByScheduleIdGenCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTenderItemByScheduleIdGenCode",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			});

		_finderPathWithPaginationFindByTenderItemByGenCodeAndSchedNo =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTenderItemByGenCodeAndSchedNo",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTenderItemByGenCodeAndSchedNo =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderScheduleItemImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTenderItemByGenCodeAndSchedNo",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Long.class.getName(), String.class.getName()
				},
				GDFTenderScheduleItemModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderScheduleItemModelImpl.TENDERITEMNUMBER_COLUMN_BITMASK |
				GDFTenderScheduleItemModelImpl.SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderScheduleItemModelImpl.GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByTenderItemByGenCodeAndSchedNo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTenderItemByGenCodeAndSchedNo",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderScheduleItemImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = PRTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderScheduleItem"),
			true);
	}

	@Override
	@Reference(
		target = PRTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PRTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GDFTENDERSCHEDULEITEM =
		"SELECT gdfTenderScheduleItem FROM GDFTenderScheduleItem gdfTenderScheduleItem";

	private static final String _SQL_SELECT_GDFTENDERSCHEDULEITEM_WHERE =
		"SELECT gdfTenderScheduleItem FROM GDFTenderScheduleItem gdfTenderScheduleItem WHERE ";

	private static final String _SQL_COUNT_GDFTENDERSCHEDULEITEM =
		"SELECT COUNT(gdfTenderScheduleItem) FROM GDFTenderScheduleItem gdfTenderScheduleItem";

	private static final String _SQL_COUNT_GDFTENDERSCHEDULEITEM_WHERE =
		"SELECT COUNT(gdfTenderScheduleItem) FROM GDFTenderScheduleItem gdfTenderScheduleItem WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"gdfTenderScheduleItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderScheduleItem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderScheduleItem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderScheduleItemPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderItemRefID", "tenderItemNumber", "scheduleNumber",
			"generalDescription", "primaryPackaging", "secondaryPackaging",
			"gdfGenericCode", "tenderReferenceNumber", "scheduleName",
			"patientTarget"
		});

	static {
		try {
			Class.forName(PRTPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}