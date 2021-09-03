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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubFPPRegDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;
import com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsImpl;
import com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderSubFPPRegDetailsPersistence;
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
 * The persistence implementation for the gdf tender sub fpp reg details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderSubFPPRegDetailsPersistence.class)
public class GDFTenderSubFPPRegDetailsPersistenceImpl
	extends BasePersistenceImpl<GDFTenderSubFPPRegDetails>
	implements GDFTenderSubFPPRegDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderSubFPPRegDetailsUtil</code> to access the gdf tender sub fpp reg details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderSubFPPRegDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByGDFTendRefSubFPPRegByUserId;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId;
	private FinderPath _finderPathCountByGDFTendRefSubFPPRegByUserId;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId) {

		return findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId, int start, int end) {

		return findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId;
				finderArgs = new Object[] {tenderReferenceNumber, userId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTendRefSubFPPRegByUserId;
			finderArgs = new Object[] {
				tenderReferenceNumber, userId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if (!tenderReferenceNumber.equals(
							gdfTenderSubFPPRegDetails.
								getTenderReferenceNumber()) ||
						(userId != gdfTenderSubFPPRegDetails.getUserId())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTendRefSubFPPRegByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTendRefSubFPPRegByUserId_First(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTendRefSubFPPRegByUserId_First(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTendRefSubFPPRegByUserId(
				tenderReferenceNumber, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTendRefSubFPPRegByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTendRefSubFPPRegByUserId_Last(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTendRefSubFPPRegByUserId_Last(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDFTendRefSubFPPRegByUserId(
			tenderReferenceNumber, userId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTendRefSubFPPRegByUserId(
				tenderReferenceNumber, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubFPPRegDetails[]
			findByGDFTendRefSubFPPRegByUserId_PrevAndNext(
				long tenderRegRefID, String tenderReferenceNumber, long userId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByGDFTendRefSubFPPRegByUserId_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, tenderReferenceNumber,
				userId, orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByGDFTendRefSubFPPRegByUserId_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, tenderReferenceNumber,
				userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderSubFPPRegDetails
		getByGDFTendRefSubFPPRegByUserId_PrevAndNext(
			Session session,
			GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_2);
		}

		sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_USERID_2);

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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	@Override
	public void removeByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId) {

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDFTendRefSubFPPRegByUserId(
					tenderReferenceNumber, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDFTendRefSubFPPRegByUserId(
		String tenderReferenceNumber, long userId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDFTendRefSubFPPRegByUserId;

		Object[] finderArgs = new Object[] {tenderReferenceNumber, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_USERID_2);

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
		_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubFPPRegDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubFPPRegDetails.tenderReferenceNumber IS NULL OR gdfTenderSubFPPRegDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDREFSUBFPPREGBYUSERID_USERID_2 =
			"gdfTenderSubFPPRegDetails.userId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath _finderPathCountByGDF_Tender_Schedule_Number;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if (scheduleNumber !=
							gdfTenderSubFPPRegDetails.getScheduleNumber()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Tender_Schedule_Number_First(
				scheduleNumber, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Tender_Schedule_Number_Last(
				scheduleNumber, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDF_Tender_Schedule_Number(scheduleNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber,
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

	protected GDFTenderSubFPPRegDetails
		getByGDF_Tender_Schedule_Number_PrevAndNext(
			Session session,
			GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	@Override
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDF_Tender_Schedule_Number(
					scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Schedule_Number;

		Object[] finderArgs = new Object[] {scheduleNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

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
			"gdfTenderSubFPPRegDetails.scheduleNumber = ?";

	private FinderPath _finderPathWithPaginationFindByFPP_Registration_ID;
	private FinderPath _finderPathWithoutPaginationFindByFPP_Registration_ID;
	private FinderPath _finderPathCountByFPP_Registration_ID;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId) {

		return findByFPP_Registration_ID(
			fppRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end) {

		return findByFPP_Registration_ID(fppRegistrationId, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByFPP_Registration_ID(
			fppRegistrationId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByFPP_Registration_ID(
		long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFPP_Registration_ID;
				finderArgs = new Object[] {fppRegistrationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFPP_Registration_ID;
			finderArgs = new Object[] {
				fppRegistrationId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if (fppRegistrationId !=
							gdfTenderSubFPPRegDetails.getFppRegistrationId()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FPP_REGISTRATION_ID_FPPREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppRegistrationId);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByFPP_Registration_ID_First(
			long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByFPP_Registration_ID_First(
				fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_First(
		long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list = findByFPP_Registration_ID(
			fppRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByFPP_Registration_ID_Last(
			long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByFPP_Registration_ID_Last(
				fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByFPP_Registration_ID_Last(
		long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByFPP_Registration_ID(fppRegistrationId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list = findByFPP_Registration_ID(
			fppRegistrationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails[] findByFPP_Registration_ID_PrevAndNext(
			long tenderRegRefID, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByFPP_Registration_ID_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, fppRegistrationId,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByFPP_Registration_ID_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, fppRegistrationId,
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

	protected GDFTenderSubFPPRegDetails getByFPP_Registration_ID_PrevAndNext(
		Session session, GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
		long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_FPP_REGISTRATION_ID_FPPREGISTRATIONID_2);

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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fppRegistrationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where fppRegistrationId = &#63; from the database.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 */
	@Override
	public void removeByFPP_Registration_ID(long fppRegistrationId) {
		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByFPP_Registration_ID(
					fppRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where fppRegistrationId = &#63;.
	 *
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByFPP_Registration_ID(long fppRegistrationId) {
		FinderPath finderPath = _finderPathCountByFPP_Registration_ID;

		Object[] finderArgs = new Object[] {fppRegistrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FPP_REGISTRATION_ID_FPPREGISTRATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppRegistrationId);

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
		_FINDER_COLUMN_FPP_REGISTRATION_ID_FPPREGISTRATIONID_2 =
			"gdfTenderSubFPPRegDetails.fppRegistrationId = ?";

	private FinderPath _finderPathWithPaginationFindByGDF_Tender_Reg_Ref_Id;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id;
	private FinderPath _finderPathCountByGDF_Tender_Reg_Ref_Id;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID) {

		return findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end) {

		return findByGDF_Tender_Reg_Ref_Id(tenderRegRefID, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Tender_Reg_Ref_Id(
		long tenderRegRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id;
				finderArgs = new Object[] {tenderRegRefID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDF_Tender_Reg_Ref_Id;
			finderArgs = new Object[] {
				tenderRegRefID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if (tenderRegRefID !=
							gdfTenderSubFPPRegDetails.getTenderRegRefID()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_REG_REF_ID_TENDERREGREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderRegRefID);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_First(
			long tenderRegRefID,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Tender_Reg_Ref_Id_First(
				tenderRegRefID, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderRegRefID=");
		sb.append(tenderRegRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_First(
		long tenderRegRefID,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Tender_Reg_Ref_Id_Last(
			long tenderRegRefID,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Tender_Reg_Ref_Id_Last(
				tenderRegRefID, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderRegRefID=");
		sb.append(tenderRegRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Tender_Reg_Ref_Id_Last(
		long tenderRegRefID,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDF_Tender_Reg_Ref_Id(tenderRegRefID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Tender_Reg_Ref_Id(
			tenderRegRefID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 */
	@Override
	public void removeByGDF_Tender_Reg_Ref_Id(long tenderRegRefID) {
		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDF_Tender_Reg_Ref_Id(
					tenderRegRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDF_Tender_Reg_Ref_Id(long tenderRegRefID) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Reg_Ref_Id;

		Object[] finderArgs = new Object[] {tenderRegRefID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_REG_REF_ID_TENDERREGREFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderRegRefID);

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
		_FINDER_COLUMN_GDF_TENDER_REG_REF_ID_TENDERREGREFID_2 =
			"gdfTenderSubFPPRegDetails.tenderRegRefID = ?";

	private FinderPath _finderPathWithPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathCountByGDF_Generic_Code;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return findByGDF_Generic_Code(
			gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return findByGDF_Generic_Code(gdfGenericCode, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGDF_Generic_Code;
				finderArgs = new Object[] {gdfGenericCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDF_Generic_Code;
			finderArgs = new Object[] {
				gdfGenericCode, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if (!gdfGenericCode.equals(
							gdfTenderSubFPPRegDetails.getGdfGenericCode())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Generic_Code_First(gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDF_Generic_Code_Last(gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDF_Generic_Code(gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub fpp reg detailses before and after the current gdf tender sub fpp reg details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderRegRefID the primary key of the current gdf tender sub fpp reg details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderRegRefID, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, gdfGenericCode,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, gdfGenericCode,
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

	protected GDFTenderSubFPPRegDetails getByGDF_Generic_Code_PrevAndNext(
		Session session, GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_2);
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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByGDF_Generic_Code(String gdfGenericCode) {
		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDF_Generic_Code(
					gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDF_Generic_Code(String gdfGenericCode) {
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDF_Generic_Code;

		Object[] finderArgs = new Object[] {gdfGenericCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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
		_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_2 =
			"gdfTenderSubFPPRegDetails.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPRegDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPRegDetails.gdfGenericCode = '')";

	private FinderPath _finderPathWithPaginationFindByGDFTenderByTRIDAndFRID;
	private FinderPath _finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID;
	private FinderPath _finderPathCountByGDFTenderByTRIDAndFRID;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		return findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end) {

		return findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID;
				finderArgs = new Object[] {tenderRegRefID, fppRegistrationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDFTenderByTRIDAndFRID;
			finderArgs = new Object[] {
				tenderRegRefID, fppRegistrationId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if ((tenderRegRefID !=
							gdfTenderSubFPPRegDetails.getTenderRegRefID()) ||
						(fppRegistrationId !=
							gdfTenderSubFPPRegDetails.getFppRegistrationId())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_TENDERREGREFID_2);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_FPPREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderRegRefID);

				queryPos.add(fppRegistrationId);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_First(
			long tenderRegRefID, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderByTRIDAndFRID_First(
				tenderRegRefID, fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderRegRefID=");
		sb.append(tenderRegRefID);

		sb.append(", fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_First(
		long tenderRegRefID, long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list = findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTenderByTRIDAndFRID_Last(
			long tenderRegRefID, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderByTRIDAndFRID_Last(
				tenderRegRefID, fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderRegRefID=");
		sb.append(tenderRegRefID);

		sb.append(", fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTenderByTRIDAndFRID_Last(
		long tenderRegRefID, long fppRegistrationId,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list = findByGDFTenderByTRIDAndFRID(
			tenderRegRefID, fppRegistrationId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 */
	@Override
	public void removeByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDFTenderByTRIDAndFRID(
					tenderRegRefID, fppRegistrationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where tenderRegRefID = &#63; and fppRegistrationId = &#63;.
	 *
	 * @param tenderRegRefID the tender reg ref ID
	 * @param fppRegistrationId the fpp registration ID
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDFTenderByTRIDAndFRID(
		long tenderRegRefID, long fppRegistrationId) {

		FinderPath finderPath = _finderPathCountByGDFTenderByTRIDAndFRID;

		Object[] finderArgs = new Object[] {tenderRegRefID, fppRegistrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_TENDERREGREFID_2);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_FPPREGISTRATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderRegRefID);

				queryPos.add(fppRegistrationId);

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
		_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_TENDERREGREFID_2 =
			"gdfTenderSubFPPRegDetails.tenderRegRefID = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYTRIDANDFRID_FPPREGISTRATIONID_2 =
			"gdfTenderSubFPPRegDetails.fppRegistrationId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderBySNUTRNUAndGenCode;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode;
	private FinderPath _finderPathCountByGDFTenderBySNUTRNUAndGenCode;

	/**
	 * Returns all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode) {

		return findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode, int start, int end) {

		return findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode, start, end,
			null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode;
				finderArgs = new Object[] {
					scheduleNumber, tenderReferenceNumber, gdfGenericCode
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderBySNUTRNUAndGenCode;
			finderArgs = new Object[] {
				scheduleNumber, tenderReferenceNumber, gdfGenericCode, start,
				end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if ((scheduleNumber !=
							gdfTenderSubFPPRegDetails.getScheduleNumber()) ||
						!tenderReferenceNumber.equals(
							gdfTenderSubFPPRegDetails.
								getTenderReferenceNumber()) ||
						!gdfGenericCode.equals(
							gdfTenderSubFPPRegDetails.getGdfGenericCode())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_2);
			}

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUTRNUAndGenCode_First(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderBySNUTRNUAndGenCode_First(
				scheduleNumber, tenderReferenceNumber, gdfGenericCode,
				orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTenderBySNUTRNUAndGenCode_First(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTenderBySNUTRNUAndGenCode(
				scheduleNumber, tenderReferenceNumber, gdfGenericCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUTRNUAndGenCode_Last(
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderBySNUTRNUAndGenCode_Last(
				scheduleNumber, tenderReferenceNumber, gdfGenericCode,
				orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp reg details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp reg details, or <code>null</code> if a matching gdf tender sub fpp reg details could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByGDFTenderBySNUTRNUAndGenCode_Last(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDFTenderBySNUTRNUAndGenCode(
			scheduleNumber, tenderReferenceNumber, gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTenderBySNUTRNUAndGenCode(
				scheduleNumber, tenderReferenceNumber, gdfGenericCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
				long tenderRegRefID, long scheduleNumber,
				String tenderReferenceNumber, String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber,
				tenderReferenceNumber, gdfGenericCode, orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber,
				tenderReferenceNumber, gdfGenericCode, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderSubFPPRegDetails
		getByGDFTenderBySNUTRNUAndGenCode_PrevAndNext(
			Session session,
			GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
			long scheduleNumber, String tenderReferenceNumber,
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_SCHEDULENUMBER_2);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_2);
		}

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_2);
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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleNumber);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode) {

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDFTenderBySNUTRNUAndGenCode(
					scheduleNumber, tenderReferenceNumber, gdfGenericCode,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp reg detailses
	 */
	@Override
	public int countByGDFTenderBySNUTRNUAndGenCode(
		long scheduleNumber, String tenderReferenceNumber,
		String gdfGenericCode) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDFTenderBySNUTRNUAndGenCode;

		Object[] finderArgs = new Object[] {
			scheduleNumber, tenderReferenceNumber, gdfGenericCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_2);
			}

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

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
		_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_SCHEDULENUMBER_2 =
			"gdfTenderSubFPPRegDetails.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubFPPRegDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubFPPRegDetails.tenderReferenceNumber IS NULL OR gdfTenderSubFPPRegDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_2 =
			"gdfTenderSubFPPRegDetails.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUTRNUANDGENCODE_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPRegDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPRegDetails.gdfGenericCode = '')";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID;
	private FinderPath _finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID;

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
	@Override
	public List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId) {

		return findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end) {

		return findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails>
		findByGDFTenderBySNUAndTRNUGenCodeFID(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId, int start, int end,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID;
				finderArgs = new Object[] {
					scheduleNumber, userId, tenderReferenceNumber,
					gdfGenericCode, fppRegistrationId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID;
			finderArgs = new Object[] {
				scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
				fppRegistrationId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
						list) {

					if ((scheduleNumber !=
							gdfTenderSubFPPRegDetails.getScheduleNumber()) ||
						(userId != gdfTenderSubFPPRegDetails.getUserId()) ||
						!tenderReferenceNumber.equals(
							gdfTenderSubFPPRegDetails.
								getTenderReferenceNumber()) ||
						!gdfGenericCode.equals(
							gdfTenderSubFPPRegDetails.getGdfGenericCode()) ||
						(fppRegistrationId !=
							gdfTenderSubFPPRegDetails.getFppRegistrationId())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_SCHEDULENUMBER_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_USERID_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_2);
			}

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_FPPREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				queryPos.add(userId);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				queryPos.add(fppRegistrationId);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	@Override
	public GDFTenderSubFPPRegDetails
			findByGDFTenderBySNUAndTRNUGenCodeFID_First(
				long scheduleNumber, long userId, String tenderReferenceNumber,
				String gdfGenericCode, long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderBySNUAndTRNUGenCodeFID_First(
				scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
				fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

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
	@Override
	public GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_First(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTenderBySNUAndTRNUGenCodeFID(
				scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
				fppRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubFPPRegDetails findByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			fetchByGDFTenderBySNUAndTRNUGenCodeFID_Last(
				scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
				fppRegistrationId, orderByComparator);

		if (gdfTenderSubFPPRegDetails != null) {
			return gdfTenderSubFPPRegDetails;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", fppRegistrationId=");
		sb.append(fppRegistrationId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPRegDetailsException(sb.toString());
	}

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
	@Override
	public GDFTenderSubFPPRegDetails
		fetchByGDFTenderBySNUAndTRNUGenCodeFID_Last(
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		int count = countByGDFTenderBySNUAndTRNUGenCodeFID(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPRegDetails> list =
			findByGDFTenderBySNUAndTRNUGenCodeFID(
				scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
				fppRegistrationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubFPPRegDetails[]
			findByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				long tenderRegRefID, long scheduleNumber, long userId,
				String tenderReferenceNumber, String gdfGenericCode,
				long fppRegistrationId,
				OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = findByPrimaryKey(
			tenderRegRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails[] array =
				new GDFTenderSubFPPRegDetailsImpl[3];

			array[0] = getByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber, userId,
				tenderReferenceNumber, gdfGenericCode, fppRegistrationId,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPRegDetails;

			array[2] = getByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
				session, gdfTenderSubFPPRegDetails, scheduleNumber, userId,
				tenderReferenceNumber, gdfGenericCode, fppRegistrationId,
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

	protected GDFTenderSubFPPRegDetails
		getByGDFTenderBySNUAndTRNUGenCodeFID_PrevAndNext(
			Session session,
			GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails,
			long scheduleNumber, long userId, String tenderReferenceNumber,
			String gdfGenericCode, long fppRegistrationId,
			OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE);

		sb.append(
			_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_SCHEDULENUMBER_2);

		sb.append(_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_USERID_2);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_2);
		}

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_2);
		}

		sb.append(
			_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_FPPREGISTRATIONID_2);

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
			sb.append(GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleNumber);

		queryPos.add(userId);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		queryPos.add(fppRegistrationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPRegDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPRegDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp reg detailses where scheduleNumber = &#63; and userId = &#63; and tenderReferenceNumber = &#63; and gdfGenericCode = &#63; and fppRegistrationId = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param userId the user ID
	 * @param tenderReferenceNumber the tender reference number
	 * @param gdfGenericCode the gdf generic code
	 * @param fppRegistrationId the fpp registration ID
	 */
	@Override
	public void removeByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId) {

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				findByGDFTenderBySNUAndTRNUGenCodeFID(
					scheduleNumber, userId, tenderReferenceNumber,
					gdfGenericCode, fppRegistrationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPRegDetails);
		}
	}

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
	@Override
	public int countByGDFTenderBySNUAndTRNUGenCodeFID(
		long scheduleNumber, long userId, String tenderReferenceNumber,
		String gdfGenericCode, long fppRegistrationId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath =
			_finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID;

		Object[] finderArgs = new Object[] {
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_SCHEDULENUMBER_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_USERID_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_2);
			}

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_FPPREGISTRATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				queryPos.add(userId);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				queryPos.add(fppRegistrationId);

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
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_SCHEDULENUMBER_2 =
			"gdfTenderSubFPPRegDetails.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_USERID_2 =
			"gdfTenderSubFPPRegDetails.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubFPPRegDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubFPPRegDetails.tenderReferenceNumber IS NULL OR gdfTenderSubFPPRegDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_2 =
			"gdfTenderSubFPPRegDetails.gdfGenericCode = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPRegDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPRegDetails.gdfGenericCode = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDTRNUGENCODEFID_FPPREGISTRATIONID_2 =
			"gdfTenderSubFPPRegDetails.fppRegistrationId = ?";

	public GDFTenderSubFPPRegDetailsPersistenceImpl() {
		setModelClass(GDFTenderSubFPPRegDetails.class);

		setModelImplClass(GDFTenderSubFPPRegDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderRegRefID", "GDF_Tender_Reg_Ref_Id");
		dbColumnNames.put("scheduleNumber", "GDF_Tender_Schedule_Number");
		dbColumnNames.put("gdfGenericCode", "GDF_Generic_Code");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put(
			"listOfRegCountries", "listOf_Registration_Countries");
		dbColumnNames.put("fppRegApprStatus", "FPP_Reg_Appr_Status");
		dbColumnNames.put("fppRegAccepted", "FPP_Reg_Accepted");
		dbColumnNames.put("fppRegistrationId", "FPP_Registration_ID");
		dbColumnNames.put("tenderItemMatRefID", "GDF_Tender_Item_Mat_Ref_Id");
		dbColumnNames.put("tenderItemRefID", "GDF_Tender_Item_Ref_Id");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender sub fpp reg details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 */
	@Override
	public void cacheResult(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
			gdfTenderSubFPPRegDetails.getPrimaryKey(),
			gdfTenderSubFPPRegDetails);

		gdfTenderSubFPPRegDetails.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender sub fpp reg detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPRegDetailses the gdf tender sub fpp reg detailses
	 */
	@Override
	public void cacheResult(
		List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegDetailses) {

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				gdfTenderSubFPPRegDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
					gdfTenderSubFPPRegDetails.getPrimaryKey()) == null) {

				cacheResult(gdfTenderSubFPPRegDetails);
			}
			else {
				gdfTenderSubFPPRegDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender sub fpp reg detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderSubFPPRegDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender sub fpp reg details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		entityCache.removeResult(
			entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
			gdfTenderSubFPPRegDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<GDFTenderSubFPPRegDetails> gdfTenderSubFPPRegDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails :
				gdfTenderSubFPPRegDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
				gdfTenderSubFPPRegDetails.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new gdf tender sub fpp reg details with the primary key. Does not add the gdf tender sub fpp reg details to the database.
	 *
	 * @param tenderRegRefID the primary key for the new gdf tender sub fpp reg details
	 * @return the new gdf tender sub fpp reg details
	 */
	@Override
	public GDFTenderSubFPPRegDetails create(long tenderRegRefID) {
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
			new GDFTenderSubFPPRegDetailsImpl();

		gdfTenderSubFPPRegDetails.setNew(true);
		gdfTenderSubFPPRegDetails.setPrimaryKey(tenderRegRefID);

		return gdfTenderSubFPPRegDetails;
	}

	/**
	 * Removes the gdf tender sub fpp reg details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails remove(long tenderRegRefID)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		return remove((Serializable)tenderRegRefID);
	}

	/**
	 * Removes the gdf tender sub fpp reg details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails remove(Serializable primaryKey)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails =
				(GDFTenderSubFPPRegDetails)session.get(
					GDFTenderSubFPPRegDetailsImpl.class, primaryKey);

			if (gdfTenderSubFPPRegDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderSubFPPRegDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderSubFPPRegDetails);
		}
		catch (NoSuchGDFTenderSubFPPRegDetailsException noSuchEntityException) {
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
	protected GDFTenderSubFPPRegDetails removeImpl(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderSubFPPRegDetails)) {
				gdfTenderSubFPPRegDetails =
					(GDFTenderSubFPPRegDetails)session.get(
						GDFTenderSubFPPRegDetailsImpl.class,
						gdfTenderSubFPPRegDetails.getPrimaryKeyObj());
			}

			if (gdfTenderSubFPPRegDetails != null) {
				session.delete(gdfTenderSubFPPRegDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderSubFPPRegDetails != null) {
			clearCache(gdfTenderSubFPPRegDetails);
		}

		return gdfTenderSubFPPRegDetails;
	}

	@Override
	public GDFTenderSubFPPRegDetails updateImpl(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		boolean isNew = gdfTenderSubFPPRegDetails.isNew();

		if (!(gdfTenderSubFPPRegDetails instanceof
				GDFTenderSubFPPRegDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderSubFPPRegDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderSubFPPRegDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderSubFPPRegDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderSubFPPRegDetails implementation " +
					gdfTenderSubFPPRegDetails.getClass());
		}

		GDFTenderSubFPPRegDetailsModelImpl gdfTenderSubFPPRegDetailsModelImpl =
			(GDFTenderSubFPPRegDetailsModelImpl)gdfTenderSubFPPRegDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderSubFPPRegDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderSubFPPRegDetails.setCreateDate(now);
			}
			else {
				gdfTenderSubFPPRegDetails.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderSubFPPRegDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderSubFPPRegDetails.setModifiedDate(now);
			}
			else {
				gdfTenderSubFPPRegDetails.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderSubFPPRegDetails.isNew()) {
				session.save(gdfTenderSubFPPRegDetails);

				gdfTenderSubFPPRegDetails.setNew(false);
			}
			else {
				gdfTenderSubFPPRegDetails =
					(GDFTenderSubFPPRegDetails)session.merge(
						gdfTenderSubFPPRegDetails);
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
				gdfTenderSubFPPRegDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubFPPRegDetailsModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTendRefSubFPPRegByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId,
				args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Schedule_Number, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
				args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
			};

			finderCache.removeResult(
				_finderPathCountByFPP_Registration_ID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFPP_Registration_ID, args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getTenderRegRefID()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reg_Ref_Id, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id, args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(_finderPathCountByGDF_Generic_Code, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getTenderRegRefID(),
				gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderByTRIDAndFRID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID, args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber(),
				gdfTenderSubFPPRegDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderBySNUTRNUAndGenCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode,
				args);

			args = new Object[] {
				gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber(),
				gdfTenderSubFPPRegDetailsModelImpl.getUserId(),
				gdfTenderSubFPPRegDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode(),
				gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendRefSubFPPRegByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendRefSubFPPRegByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFPP_Registration_ID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByFPP_Registration_ID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFPP_Registration_ID,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByFPP_Registration_ID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFPP_Registration_ID,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalTenderRegRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reg_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getTenderRegRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reg_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Generic_Code.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalTenderRegRefID(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByTRIDAndFRID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getTenderRegRefID(),
					gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByTRIDAndFRID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalScheduleNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUTRNUAndGenCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUTRNUAndGenCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode,
					args);
			}

			if ((gdfTenderSubFPPRegDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalScheduleNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getOriginalUserId(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalGdfGenericCode(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getOriginalFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID,
					args);

				args = new Object[] {
					gdfTenderSubFPPRegDetailsModelImpl.getScheduleNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getUserId(),
					gdfTenderSubFPPRegDetailsModelImpl.
						getTenderReferenceNumber(),
					gdfTenderSubFPPRegDetailsModelImpl.getGdfGenericCode(),
					gdfTenderSubFPPRegDetailsModelImpl.getFppRegistrationId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubFPPRegDetailsImpl.class,
			gdfTenderSubFPPRegDetails.getPrimaryKey(),
			gdfTenderSubFPPRegDetails, false);

		gdfTenderSubFPPRegDetails.resetOriginalValues();

		return gdfTenderSubFPPRegDetails;
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails = fetchByPrimaryKey(
			primaryKey);

		if (gdfTenderSubFPPRegDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderSubFPPRegDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderSubFPPRegDetails;
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or throws a <code>NoSuchGDFTenderSubFPPRegDetailsException</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details
	 * @throws NoSuchGDFTenderSubFPPRegDetailsException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails findByPrimaryKey(long tenderRegRefID)
		throws NoSuchGDFTenderSubFPPRegDetailsException {

		return findByPrimaryKey((Serializable)tenderRegRefID);
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details, or <code>null</code> if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPRegDetails fetchByPrimaryKey(long tenderRegRefID) {
		return fetchByPrimaryKey((Serializable)tenderRegRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp reg detailses.
	 *
	 * @return the gdf tender sub fpp reg detailses
	 */
	@Override
	public List<GDFTenderSubFPPRegDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubFPPRegDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPRegDetails> orderByComparator,
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

		List<GDFTenderSubFPPRegDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPRegDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERSUBFPPREGDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERSUBFPPREGDETAILS;

				sql = sql.concat(
					GDFTenderSubFPPRegDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderSubFPPRegDetails>)QueryUtil.list(
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
	 * Removes all the gdf tender sub fpp reg detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails : findAll()) {
			remove(gdfTenderSubFPPRegDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses.
	 *
	 * @return the number of gdf tender sub fpp reg detailses
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
					_SQL_COUNT_GDFTENDERSUBFPPREGDETAILS);

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
		return "GDF_Tender_Reg_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERSUBFPPREGDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderSubFPPRegDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender sub fpp reg details persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderSubFPPRegDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		GDFTenderSubFPPRegDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGDFTendRefSubFPPRegByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTendRefSubFPPRegByUserId",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTendRefSubFPPRegByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTendRefSubFPPRegByUserId",
				new String[] {String.class.getName(), Long.class.getName()},
				GDFTenderSubFPPRegDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGDFTendRefSubFPPRegByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTendRefSubFPPRegByUserId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {Long.class.getName()},
				GDFTenderSubFPPRegDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Schedule_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Schedule_Number",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFPP_Registration_ID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFPP_Registration_ID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFPP_Registration_ID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFPP_Registration_ID", new String[] {Long.class.getName()},
			GDFTenderSubFPPRegDetailsModelImpl.
				FPPREGISTRATIONID_COLUMN_BITMASK);

		_finderPathCountByFPP_Registration_ID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFPP_Registration_ID", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Reg_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGDF_Tender_Reg_Ref_Id",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Tender_Reg_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Reg_Ref_Id",
				new String[] {Long.class.getName()},
				GDFTenderSubFPPRegDetailsModelImpl.
					TENDERREGREFID_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Reg_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Reg_Ref_Id",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGDF_Generic_Code",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGDF_Generic_Code",
			new String[] {String.class.getName()},
			GDFTenderSubFPPRegDetailsModelImpl.GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Generic_Code", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGDFTenderByTRIDAndFRID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPRegDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGDFTenderByTRIDAndFRID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDFTenderByTRIDAndFRID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderByTRIDAndFRID",
				new String[] {Long.class.getName(), Long.class.getName()},
				GDFTenderSubFPPRegDetailsModelImpl.
					TENDERREGREFID_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					FPPREGISTRATIONID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderByTRIDAndFRID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderByTRIDAndFRID",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderBySNUTRNUAndGenCode =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderBySNUTRNUAndGenCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderBySNUTRNUAndGenCode =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderBySNUTRNUAndGenCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName()
				},
				GDFTenderSubFPPRegDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByGDFTenderBySNUTRNUAndGenCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderBySNUTRNUAndGenCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderBySNUAndTRNUGenCodeFID",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderBySNUAndTRNUGenCodeFID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPRegDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderBySNUAndTRNUGenCodeFID",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				GDFTenderSubFPPRegDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.USERID_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					GDFGENERICCODE_COLUMN_BITMASK |
				GDFTenderSubFPPRegDetailsModelImpl.
					FPPREGISTRATIONID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderBySNUAndTRNUGenCodeFID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderBySNUAndTRNUGenCodeFID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderSubFPPRegDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails"),
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

	private static final String _SQL_SELECT_GDFTENDERSUBFPPREGDETAILS =
		"SELECT gdfTenderSubFPPRegDetails FROM GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails";

	private static final String _SQL_SELECT_GDFTENDERSUBFPPREGDETAILS_WHERE =
		"SELECT gdfTenderSubFPPRegDetails FROM GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails WHERE ";

	private static final String _SQL_COUNT_GDFTENDERSUBFPPREGDETAILS =
		"SELECT COUNT(gdfTenderSubFPPRegDetails) FROM GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails";

	private static final String _SQL_COUNT_GDFTENDERSUBFPPREGDETAILS_WHERE =
		"SELECT COUNT(gdfTenderSubFPPRegDetails) FROM GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"gdfTenderSubFPPRegDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderSubFPPRegDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderSubFPPRegDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderSubFPPRegDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderRegRefID", "scheduleNumber", "gdfGenericCode",
			"tenderReferenceNumber", "listOfRegCountries", "fppRegApprStatus",
			"fppRegAccepted", "fppRegistrationId", "tenderItemMatRefID",
			"tenderItemRefID"
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