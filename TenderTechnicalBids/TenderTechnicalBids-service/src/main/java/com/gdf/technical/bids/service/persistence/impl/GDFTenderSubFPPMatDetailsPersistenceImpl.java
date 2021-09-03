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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubFPPMatDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;
import com.gdf.technical.bids.model.impl.GDFTenderSubFPPMatDetailsImpl;
import com.gdf.technical.bids.model.impl.GDFTenderSubFPPMatDetailsModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderSubFPPMatDetailsPersistence;
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
 * The persistence implementation for the gdf tender sub fpp mat details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderSubFPPMatDetailsPersistence.class)
public class GDFTenderSubFPPMatDetailsPersistenceImpl
	extends BasePersistenceImpl<GDFTenderSubFPPMatDetails>
	implements GDFTenderSubFPPMatDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderSubFPPMatDetailsUtil</code> to access the gdf tender sub fpp mat details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderSubFPPMatDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindByGDFTendRefSubFPPMatByUserId;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId;
	private FinderPath _finderPathCountByGDFTendRefSubFPPMatByUserId;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId) {

		return findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId, int start, int end) {

		return findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId;
				finderArgs = new Object[] {tenderReferenceNumber, userId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTendRefSubFPPMatByUserId;
			finderArgs = new Object[] {
				tenderReferenceNumber, userId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if (!tenderReferenceNumber.equals(
							gdfTenderSubFPPMatDetails.
								getTenderReferenceNumber()) ||
						(userId != gdfTenderSubFPPMatDetails.getUserId())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTendRefSubFPPMatByUserId_First(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTendRefSubFPPMatByUserId_First(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTendRefSubFPPMatByUserId_First(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTendRefSubFPPMatByUserId(
				tenderReferenceNumber, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTendRefSubFPPMatByUserId_Last(
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTendRefSubFPPMatByUserId_Last(
				tenderReferenceNumber, userId, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTendRefSubFPPMatByUserId_Last(
		String tenderReferenceNumber, long userId,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDFTendRefSubFPPMatByUserId(
			tenderReferenceNumber, userId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTendRefSubFPPMatByUserId(
				tenderReferenceNumber, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[]
			findByGDFTendRefSubFPPMatByUserId_PrevAndNext(
				long tenderItemMatRefID, String tenderReferenceNumber,
				long userId,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDFTendRefSubFPPMatByUserId_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, tenderReferenceNumber,
				userId, orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDFTendRefSubFPPMatByUserId_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, tenderReferenceNumber,
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

	protected GDFTenderSubFPPMatDetails
		getByGDFTendRefSubFPPMatByUserId_PrevAndNext(
			Session session,
			GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
			String tenderReferenceNumber, long userId,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_2);
		}

		sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_USERID_2);

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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 */
	@Override
	public void removeByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDFTendRefSubFPPMatByUserId(
					tenderReferenceNumber, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDFTendRefSubFPPMatByUserId(
		String tenderReferenceNumber, long userId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDFTendRefSubFPPMatByUserId;

		Object[] finderArgs = new Object[] {tenderReferenceNumber, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_USERID_2);

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
		_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubFPPMatDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubFPPMatDetails.tenderReferenceNumber IS NULL OR gdfTenderSubFPPMatDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDREFSUBFPPMATBYUSERID_USERID_2 =
			"gdfTenderSubFPPMatDetails.userId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Item_Mat_Ref_Id;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id;
	private FinderPath _finderPathCountByGDF_Tender_Item_Mat_Ref_Id;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID) {

		return findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID, int start, int end) {

		return findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_Item_Mat_Ref_Id(
		long tenderItemMatRefID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id;
				finderArgs = new Object[] {tenderItemMatRefID};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDF_Tender_Item_Mat_Ref_Id;
			finderArgs = new Object[] {
				tenderItemMatRefID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if (tenderItemMatRefID !=
							gdfTenderSubFPPMatDetails.getTenderItemMatRefID()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_ITEM_MAT_REF_ID_TENDERITEMMATREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemMatRefID);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Tender_Item_Mat_Ref_Id_First(
			long tenderItemMatRefID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Tender_Item_Mat_Ref_Id_First(
				tenderItemMatRefID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_Item_Mat_Ref_Id_First(
		long tenderItemMatRefID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Tender_Item_Mat_Ref_Id_Last(
			long tenderItemMatRefID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Tender_Item_Mat_Ref_Id_Last(
				tenderItemMatRefID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_Item_Mat_Ref_Id_Last(
		long tenderItemMatRefID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDF_Tender_Item_Mat_Ref_Id(tenderItemMatRefID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Tender_Item_Mat_Ref_Id(
			tenderItemMatRefID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 */
	@Override
	public void removeByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID) {
		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDF_Tender_Item_Mat_Ref_Id(
					tenderItemMatRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDF_Tender_Item_Mat_Ref_Id(long tenderItemMatRefID) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Item_Mat_Ref_Id;

		Object[] finderArgs = new Object[] {tenderItemMatRefID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_ITEM_MAT_REF_ID_TENDERITEMMATREFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemMatRefID);

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
		_FINDER_COLUMN_GDF_TENDER_ITEM_MAT_REF_ID_TENDERITEMMATREFID_2 =
			"gdfTenderSubFPPMatDetails.tenderItemMatRefID = ?";

	private FinderPath _finderPathWithPaginationFindByGDF_Tender_fppMarketID;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Tender_fppMarketID;
	private FinderPath _finderPathCountByGDF_Tender_fppMarketID;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID) {

		return findByGDF_Tender_fppMarketID(
			fppMarketID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end) {

		return findByGDF_Tender_fppMarketID(fppMarketID, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDF_Tender_fppMarketID(
			fppMarketID, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Tender_fppMarketID(
		long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_fppMarketID;
				finderArgs = new Object[] {fppMarketID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDF_Tender_fppMarketID;
			finderArgs = new Object[] {
				fppMarketID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if (fppMarketID !=
							gdfTenderSubFPPMatDetails.getFppMarketID()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_FPPMARKETID_FPPMARKETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_First(
			long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Tender_fppMarketID_First(fppMarketID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_First(
		long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Tender_fppMarketID(
			fppMarketID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Tender_fppMarketID_Last(
			long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Tender_fppMarketID_Last(fppMarketID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Tender_fppMarketID_Last(
		long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDF_Tender_fppMarketID(fppMarketID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Tender_fppMarketID(
			fppMarketID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[] findByGDF_Tender_fppMarketID_PrevAndNext(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDF_Tender_fppMarketID_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDF_Tender_fppMarketID_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID,
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

	protected GDFTenderSubFPPMatDetails getByGDF_Tender_fppMarketID_PrevAndNext(
		Session session, GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
		long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDF_TENDER_FPPMARKETID_FPPMARKETID_2);

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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fppMarketID);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 */
	@Override
	public void removeByGDF_Tender_fppMarketID(long fppMarketID) {
		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDF_Tender_fppMarketID(
					fppMarketID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppMarketID = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDF_Tender_fppMarketID(long fppMarketID) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_fppMarketID;

		Object[] finderArgs = new Object[] {fppMarketID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_FPPMARKETID_FPPMARKETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

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
		_FINDER_COLUMN_GDF_TENDER_FPPMARKETID_FPPMARKETID_2 =
			"gdfTenderSubFPPMatDetails.fppMarketID = ?";

	private FinderPath _finderPathWithPaginationFindByGDFTenderByTIMRIDAndFMID;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID;
	private FinderPath _finderPathCountByGDFTenderByTIMRIDAndFMID;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID) {

		return findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID, int start, int end) {

		return findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, start, end, orderByComparator,
			true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID;
				finderArgs = new Object[] {tenderItemMatRefID, fppMarketID};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderByTIMRIDAndFMID;
			finderArgs = new Object[] {
				tenderItemMatRefID, fppMarketID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if ((tenderItemMatRefID !=
							gdfTenderSubFPPMatDetails.
								getTenderItemMatRefID()) ||
						(fppMarketID !=
							gdfTenderSubFPPMatDetails.getFppMarketID())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_TENDERITEMMATREFID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_FPPMARKETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemMatRefID);

				queryPos.add(fppMarketID);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderByTIMRIDAndFMID_First(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderByTIMRIDAndFMID_First(
				tenderItemMatRefID, fppMarketID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);

		sb.append(", fppMarketID=");
		sb.append(fppMarketID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByTIMRIDAndFMID_First(
		long tenderItemMatRefID, long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderByTIMRIDAndFMID_Last(
			long tenderItemMatRefID, long fppMarketID,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderByTIMRIDAndFMID_Last(
				tenderItemMatRefID, fppMarketID, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);

		sb.append(", fppMarketID=");
		sb.append(fppMarketID);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByTIMRIDAndFMID_Last(
		long tenderItemMatRefID, long fppMarketID,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByGDFTenderByTIMRIDAndFMID(
			tenderItemMatRefID, fppMarketID, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63; from the database.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 */
	@Override
	public void removeByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDFTenderByTIMRIDAndFMID(
					tenderItemMatRefID, fppMarketID, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where tenderItemMatRefID = &#63; and fppMarketID = &#63;.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID
	 * @param fppMarketID the fpp market ID
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDFTenderByTIMRIDAndFMID(
		long tenderItemMatRefID, long fppMarketID) {

		FinderPath finderPath = _finderPathCountByGDFTenderByTIMRIDAndFMID;

		Object[] finderArgs = new Object[] {tenderItemMatRefID, fppMarketID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_TENDERITEMMATREFID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_FPPMARKETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemMatRefID);

				queryPos.add(fppMarketID);

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
		_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_TENDERITEMMATREFID_2 =
			"gdfTenderSubFPPMatDetails.tenderItemMatRefID = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYTIMRIDANDFMID_FPPMARKETID_2 =
			"gdfTenderSubFPPMatDetails.fppMarketID = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderMatUserGenCodeSNU;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU;
	private FinderPath _finderPathCountByGDFTenderMatUserGenCodeSNU;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63;.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber) {

		return findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, int start, int end) {

		return findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end,
			null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end,
			orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU;
				finderArgs = new Object[] {
					fppMarketID, userId, gdfGenericCode, scheduleNumber
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderMatUserGenCodeSNU;
			finderArgs = new Object[] {
				fppMarketID, userId, gdfGenericCode, scheduleNumber, start, end,
				orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if ((fppMarketID !=
							gdfTenderSubFPPMatDetails.getFppMarketID()) ||
						(userId != gdfTenderSubFPPMatDetails.getUserId()) ||
						!gdfGenericCode.equals(
							gdfTenderSubFPPMatDetails.getGdfGenericCode()) ||
						(scheduleNumber !=
							gdfTenderSubFPPMatDetails.getScheduleNumber())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_FPPMARKETID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_USERID_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_SCHEDULENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

				queryPos.add(userId);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				queryPos.add(scheduleNumber);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderMatUserGenCodeSNU_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderMatUserGenCodeSNU_First(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
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
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderMatUserGenCodeSNU_First(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderMatUserGenCodeSNU_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderMatUserGenCodeSNU_Last(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
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
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderMatUserGenCodeSNU_Last(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByGDFTenderMatUserGenCodeSNU(
			fppMarketID, userId, gdfGenericCode, scheduleNumber, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderMatUserGenCodeSNU_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDFTenderMatUserGenCodeSNU_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID, userId,
				gdfGenericCode, scheduleNumber, orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDFTenderMatUserGenCodeSNU_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID, userId,
				gdfGenericCode, scheduleNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderSubFPPMatDetails
		getByGDFTenderMatUserGenCodeSNU_PrevAndNext(
			Session session,
			GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_FPPMARKETID_2);

		sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_USERID_2);

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_2);
		}

		sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_SCHEDULENUMBER_2);

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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fppMarketID);

		queryPos.add(userId);

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		queryPos.add(scheduleNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppMarketID = &#63; and userId = &#63; and gdfGenericCode = &#63; and scheduleNumber = &#63; from the database.
	 *
	 * @param fppMarketID the fpp market ID
	 * @param userId the user ID
	 * @param gdfGenericCode the gdf generic code
	 * @param scheduleNumber the schedule number
	 */
	@Override
	public void removeByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDFTenderMatUserGenCodeSNU(
					fppMarketID, userId, gdfGenericCode, scheduleNumber,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
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
	@Override
	public int countByGDFTenderMatUserGenCodeSNU(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDFTenderMatUserGenCodeSNU;

		Object[] finderArgs = new Object[] {
			fppMarketID, userId, gdfGenericCode, scheduleNumber
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_FPPMARKETID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_USERID_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_SCHEDULENUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

				queryPos.add(userId);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

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
		_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_FPPMARKETID_2 =
			"gdfTenderSubFPPMatDetails.fppMarketID = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_USERID_2 =
			"gdfTenderSubFPPMatDetails.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_2 =
			"gdfTenderSubFPPMatDetails.gdfGenericCode = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPMatDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPMatDetails.gdfGenericCode = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERMATUSERGENCODESNU_SCHEDULENUMBER_2 =
			"gdfTenderSubFPPMatDetails.scheduleNumber = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderBySNUAndAndGenCode;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode;
	private FinderPath _finderPathCountByGDFTenderBySNUAndAndGenCode;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode) {

		return findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode, int start, int end) {

		return findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode, start, end, orderByComparator,
			true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode;
				finderArgs = new Object[] {scheduleNumber, gdfGenericCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderBySNUAndAndGenCode;
			finderArgs = new Object[] {
				scheduleNumber, gdfGenericCode, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if ((scheduleNumber !=
							gdfTenderSubFPPMatDetails.getScheduleNumber()) ||
						!gdfGenericCode.equals(
							gdfTenderSubFPPMatDetails.getGdfGenericCode())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderBySNUAndAndGenCode_First(
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderBySNUAndAndGenCode_First(
				scheduleNumber, gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderBySNUAndAndGenCode_First(
		long scheduleNumber, String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTenderBySNUAndAndGenCode(
				scheduleNumber, gdfGenericCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderBySNUAndAndGenCode_Last(
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderBySNUAndAndGenCode_Last(
				scheduleNumber, gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderBySNUAndAndGenCode_Last(
		long scheduleNumber, String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDFTenderBySNUAndAndGenCode(
			scheduleNumber, gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTenderBySNUAndAndGenCode(
				scheduleNumber, gdfGenericCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderBySNUAndAndGenCode_PrevAndNext(
				long tenderItemMatRefID, long scheduleNumber,
				String gdfGenericCode,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDFTenderBySNUAndAndGenCode_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, scheduleNumber,
				gdfGenericCode, orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDFTenderBySNUAndAndGenCode_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, scheduleNumber,
				gdfGenericCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderSubFPPMatDetails
		getByGDFTenderBySNUAndAndGenCode_PrevAndNext(
			Session session,
			GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
			long scheduleNumber, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_SCHEDULENUMBER_2);

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_2);
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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(scheduleNumber);

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDFTenderBySNUAndAndGenCode(
					scheduleNumber, gdfGenericCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where scheduleNumber = &#63; and gdfGenericCode = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDFTenderBySNUAndAndGenCode(
		long scheduleNumber, String gdfGenericCode) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDFTenderBySNUAndAndGenCode;

		Object[] finderArgs = new Object[] {scheduleNumber, gdfGenericCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_SCHEDULENUMBER_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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
		_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_SCHEDULENUMBER_2 =
			"gdfTenderSubFPPMatDetails.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_2 =
			"gdfTenderSubFPPMatDetails.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYSNUANDANDGENCODE_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPMatDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPMatDetails.gdfGenericCode = '')";

	private FinderPath _finderPathWithPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathCountByGDF_Generic_Code;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return findByGDF_Generic_Code(
			gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return findByGDF_Generic_Code(gdfGenericCode, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if (!gdfGenericCode.equals(
							gdfTenderSubFPPMatDetails.getGdfGenericCode())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

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
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Generic_Code_First(gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDF_Generic_Code_Last(gdfGenericCode, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDF_Generic_Code(gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderItemMatRefID, String gdfGenericCode,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, gdfGenericCode,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, gdfGenericCode,
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

	protected GDFTenderSubFPPMatDetails getByGDF_Generic_Code_PrevAndNext(
		Session session, GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByGDF_Generic_Code(String gdfGenericCode) {
		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDF_Generic_Code(
					gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByGDF_Generic_Code(String gdfGenericCode) {
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDF_Generic_Code;

		Object[] finderArgs = new Object[] {gdfGenericCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

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
			"gdfTenderSubFPPMatDetails.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPMatDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPMatDetails.gdfGenericCode = '')";

	private FinderPath _finderPathWithPaginationFindByFPP_Selected_Status;
	private FinderPath _finderPathWithoutPaginationFindByFPP_Selected_Status;
	private FinderPath _finderPathCountByFPP_Selected_Status;

	/**
	 * Returns all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the matching gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus) {

		return findByFPP_Selected_Status(
			fppSelectedStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end) {

		return findByFPP_Selected_Status(fppSelectedStatus, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByFPP_Selected_Status(
			fppSelectedStatus, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByFPP_Selected_Status(
		boolean fppSelectedStatus, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFPP_Selected_Status;
				finderArgs = new Object[] {fppSelectedStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFPP_Selected_Status;
			finderArgs = new Object[] {
				fppSelectedStatus, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if (fppSelectedStatus !=
							gdfTenderSubFPPMatDetails.isFppSelectedStatus()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FPP_SELECTED_STATUS_FPPSELECTEDSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppSelectedStatus);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByFPP_Selected_Status_First(
			boolean fppSelectedStatus,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByFPP_Selected_Status_First(
				fppSelectedStatus, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppSelectedStatus=");
		sb.append(fppSelectedStatus);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_First(
		boolean fppSelectedStatus,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list = findByFPP_Selected_Status(
			fppSelectedStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByFPP_Selected_Status_Last(
			boolean fppSelectedStatus,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByFPP_Selected_Status_Last(
				fppSelectedStatus, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppSelectedStatus=");
		sb.append(fppSelectedStatus);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub fpp mat details in the ordered set where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub fpp mat details, or <code>null</code> if a matching gdf tender sub fpp mat details could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByFPP_Selected_Status_Last(
		boolean fppSelectedStatus,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByFPP_Selected_Status(fppSelectedStatus);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list = findByFPP_Selected_Status(
			fppSelectedStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[] findByFPP_Selected_Status_PrevAndNext(
			long tenderItemMatRefID, boolean fppSelectedStatus,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByFPP_Selected_Status_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppSelectedStatus,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByFPP_Selected_Status_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppSelectedStatus,
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

	protected GDFTenderSubFPPMatDetails getByFPP_Selected_Status_PrevAndNext(
		Session session, GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
		boolean fppSelectedStatus,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_FPP_SELECTED_STATUS_FPPSELECTEDSTATUS_2);

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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fppSelectedStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub fpp mat detailses where fppSelectedStatus = &#63; from the database.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 */
	@Override
	public void removeByFPP_Selected_Status(boolean fppSelectedStatus) {
		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByFPP_Selected_Status(
					fppSelectedStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses where fppSelectedStatus = &#63;.
	 *
	 * @param fppSelectedStatus the fpp selected status
	 * @return the number of matching gdf tender sub fpp mat detailses
	 */
	@Override
	public int countByFPP_Selected_Status(boolean fppSelectedStatus) {
		FinderPath finderPath = _finderPathCountByFPP_Selected_Status;

		Object[] finderArgs = new Object[] {fppSelectedStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_FPP_SELECTED_STATUS_FPPSELECTEDSTATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppSelectedStatus);

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
		_FINDER_COLUMN_FPP_SELECTED_STATUS_FPPSELECTEDSTATUS_2 =
			"gdfTenderSubFPPMatDetails.fppSelectedStatus = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN;
	private FinderPath _finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN;

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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber) {

		return findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber, int start, int end) {

		return findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber, start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
		boolean useFinderCache) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");
		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN;
				finderArgs = new Object[] {
					fppMarketID, userId, gdfGenericCode, scheduleNumber,
					tenderReferenceNumber
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN;
			finderArgs = new Object[] {
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber, start, end, orderByComparator
			};
		}

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
						list) {

					if ((fppMarketID !=
							gdfTenderSubFPPMatDetails.getFppMarketID()) ||
						(userId != gdfTenderSubFPPMatDetails.getUserId()) ||
						!gdfGenericCode.equals(
							gdfTenderSubFPPMatDetails.getGdfGenericCode()) ||
						(scheduleNumber !=
							gdfTenderSubFPPMatDetails.getScheduleNumber()) ||
						!tenderReferenceNumber.equals(
							gdfTenderSubFPPMatDetails.
								getTenderReferenceNumber())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_FPPMARKETID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_USERID_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

				queryPos.add(userId);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				queryPos.add(scheduleNumber);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderByFIDUIDGenCodeSNUTRN_First(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
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
	@Override
	public GDFTenderSubFPPMatDetails
		fetchByGDFTenderByFIDUIDGenCodeSNUTRN_First(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTenderByFIDUIDGenCodeSNUTRN(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails findByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			fetchByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderSubFPPMatDetails != null) {
			return gdfTenderSubFPPMatDetails;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fppMarketID=");
		sb.append(fppMarketID);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubFPPMatDetailsException(sb.toString());
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
	@Override
	public GDFTenderSubFPPMatDetails fetchByGDFTenderByFIDUIDGenCodeSNUTRN_Last(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		int count = countByGDFTenderByFIDUIDGenCodeSNUTRN(
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubFPPMatDetails> list =
			findByGDFTenderByFIDUIDGenCodeSNUTRN(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public GDFTenderSubFPPMatDetails[]
			findByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				long tenderItemMatRefID, long fppMarketID, long userId,
				String gdfGenericCode, long scheduleNumber,
				String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");
		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = findByPrimaryKey(
			tenderItemMatRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails[] array =
				new GDFTenderSubFPPMatDetailsImpl[3];

			array[0] = getByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID, userId,
				gdfGenericCode, scheduleNumber, tenderReferenceNumber,
				orderByComparator, true);

			array[1] = gdfTenderSubFPPMatDetails;

			array[2] = getByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
				session, gdfTenderSubFPPMatDetails, fppMarketID, userId,
				gdfGenericCode, scheduleNumber, tenderReferenceNumber,
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

	protected GDFTenderSubFPPMatDetails
		getByGDFTenderByFIDUIDGenCodeSNUTRN_PrevAndNext(
			Session session,
			GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails,
			long fppMarketID, long userId, String gdfGenericCode,
			long scheduleNumber, String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_FPPMARKETID_2);

		sb.append(_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_USERID_2);

		boolean bindGdfGenericCode = false;

		if (gdfGenericCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_3);
		}
		else {
			bindGdfGenericCode = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_2);
		}

		sb.append(
			_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_SCHEDULENUMBER_2);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_2);
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
			sb.append(GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fppMarketID);

		queryPos.add(userId);

		if (bindGdfGenericCode) {
			queryPos.add(gdfGenericCode);
		}

		queryPos.add(scheduleNumber);

		if (bindTenderReferenceNumber) {
			queryPos.add(tenderReferenceNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubFPPMatDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubFPPMatDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				findByGDFTenderByFIDUIDGenCodeSNUTRN(
					fppMarketID, userId, gdfGenericCode, scheduleNumber,
					tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubFPPMatDetails);
		}
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
	@Override
	public int countByGDFTenderByFIDUIDGenCodeSNUTRN(
		long fppMarketID, long userId, String gdfGenericCode,
		long scheduleNumber, String tenderReferenceNumber) {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");
		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath =
			_finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN;

		Object[] finderArgs = new Object[] {
			fppMarketID, userId, gdfGenericCode, scheduleNumber,
			tenderReferenceNumber
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_FPPMARKETID_2);

			sb.append(_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_USERID_2);

			boolean bindGdfGenericCode = false;

			if (gdfGenericCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_3);
			}
			else {
				bindGdfGenericCode = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fppMarketID);

				queryPos.add(userId);

				if (bindGdfGenericCode) {
					queryPos.add(gdfGenericCode);
				}

				queryPos.add(scheduleNumber);

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
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_FPPMARKETID_2 =
			"gdfTenderSubFPPMatDetails.fppMarketID = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_USERID_2 =
			"gdfTenderSubFPPMatDetails.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_2 =
			"gdfTenderSubFPPMatDetails.gdfGenericCode = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_GDFGENERICCODE_3 =
			"(gdfTenderSubFPPMatDetails.gdfGenericCode IS NULL OR gdfTenderSubFPPMatDetails.gdfGenericCode = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_SCHEDULENUMBER_2 =
			"gdfTenderSubFPPMatDetails.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubFPPMatDetails.tenderReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_GDFTENDERBYFIDUIDGENCODESNUTRN_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubFPPMatDetails.tenderReferenceNumber IS NULL OR gdfTenderSubFPPMatDetails.tenderReferenceNumber = '')";

	public GDFTenderSubFPPMatDetailsPersistenceImpl() {
		setModelClass(GDFTenderSubFPPMatDetails.class);

		setModelImplClass(GDFTenderSubFPPMatDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderItemMatRefID", "GDF_Tender_Item_Mat_Ref_Id");
		dbColumnNames.put("scheduleNumber", "GDF_Tender_Schedule_Number");
		dbColumnNames.put("gdfGenericCode", "GDF_Generic_Code");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put("dosageForm", "Dosage_Form");
		dbColumnNames.put("noPrimPackageUnits", "No_Prim_Package_Units");
		dbColumnNames.put("noSecPackageUnits", "No_Sec_Package_Units");
		dbColumnNames.put("gdfFppMartApprStatus", "Gdf_Fpp_Mart_Appr_Status");
		dbColumnNames.put("fppSelectedStatus", "FPP_Selected_Status");
		dbColumnNames.put("fppMarketID", "FPP_Market_Id");
		dbColumnNames.put("tenderItemRefID", "GDF_Tender_Item_Ref_Id");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender sub fpp mat details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 */
	@Override
	public void cacheResult(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
			gdfTenderSubFPPMatDetails.getPrimaryKey(),
			gdfTenderSubFPPMatDetails);

		gdfTenderSubFPPMatDetails.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender sub fpp mat detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubFPPMatDetailses the gdf tender sub fpp mat detailses
	 */
	@Override
	public void cacheResult(
		List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatDetailses) {

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				gdfTenderSubFPPMatDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
					gdfTenderSubFPPMatDetails.getPrimaryKey()) == null) {

				cacheResult(gdfTenderSubFPPMatDetails);
			}
			else {
				gdfTenderSubFPPMatDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender sub fpp mat detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderSubFPPMatDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender sub fpp mat details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		entityCache.removeResult(
			entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
			gdfTenderSubFPPMatDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<GDFTenderSubFPPMatDetails> gdfTenderSubFPPMatDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails :
				gdfTenderSubFPPMatDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
				gdfTenderSubFPPMatDetails.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new gdf tender sub fpp mat details with the primary key. Does not add the gdf tender sub fpp mat details to the database.
	 *
	 * @param tenderItemMatRefID the primary key for the new gdf tender sub fpp mat details
	 * @return the new gdf tender sub fpp mat details
	 */
	@Override
	public GDFTenderSubFPPMatDetails create(long tenderItemMatRefID) {
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
			new GDFTenderSubFPPMatDetailsImpl();

		gdfTenderSubFPPMatDetails.setNew(true);
		gdfTenderSubFPPMatDetails.setPrimaryKey(tenderItemMatRefID);

		return gdfTenderSubFPPMatDetails;
	}

	/**
	 * Removes the gdf tender sub fpp mat details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails remove(long tenderItemMatRefID)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		return remove((Serializable)tenderItemMatRefID);
	}

	/**
	 * Removes the gdf tender sub fpp mat details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails remove(Serializable primaryKey)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails =
				(GDFTenderSubFPPMatDetails)session.get(
					GDFTenderSubFPPMatDetailsImpl.class, primaryKey);

			if (gdfTenderSubFPPMatDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderSubFPPMatDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderSubFPPMatDetails);
		}
		catch (NoSuchGDFTenderSubFPPMatDetailsException noSuchEntityException) {
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
	protected GDFTenderSubFPPMatDetails removeImpl(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderSubFPPMatDetails)) {
				gdfTenderSubFPPMatDetails =
					(GDFTenderSubFPPMatDetails)session.get(
						GDFTenderSubFPPMatDetailsImpl.class,
						gdfTenderSubFPPMatDetails.getPrimaryKeyObj());
			}

			if (gdfTenderSubFPPMatDetails != null) {
				session.delete(gdfTenderSubFPPMatDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderSubFPPMatDetails != null) {
			clearCache(gdfTenderSubFPPMatDetails);
		}

		return gdfTenderSubFPPMatDetails;
	}

	@Override
	public GDFTenderSubFPPMatDetails updateImpl(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		boolean isNew = gdfTenderSubFPPMatDetails.isNew();

		if (!(gdfTenderSubFPPMatDetails instanceof
				GDFTenderSubFPPMatDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderSubFPPMatDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderSubFPPMatDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderSubFPPMatDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderSubFPPMatDetails implementation " +
					gdfTenderSubFPPMatDetails.getClass());
		}

		GDFTenderSubFPPMatDetailsModelImpl gdfTenderSubFPPMatDetailsModelImpl =
			(GDFTenderSubFPPMatDetailsModelImpl)gdfTenderSubFPPMatDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderSubFPPMatDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderSubFPPMatDetails.setCreateDate(now);
			}
			else {
				gdfTenderSubFPPMatDetails.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderSubFPPMatDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderSubFPPMatDetails.setModifiedDate(now);
			}
			else {
				gdfTenderSubFPPMatDetails.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderSubFPPMatDetails.isNew()) {
				session.save(gdfTenderSubFPPMatDetails);

				gdfTenderSubFPPMatDetails.setNew(false);
			}
			else {
				gdfTenderSubFPPMatDetails =
					(GDFTenderSubFPPMatDetails)session.merge(
						gdfTenderSubFPPMatDetails);
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
				gdfTenderSubFPPMatDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubFPPMatDetailsModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTendRefSubFPPMatByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId,
				args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getTenderItemMatRefID()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Item_Mat_Ref_Id, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id,
				args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_fppMarketID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_fppMarketID, args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getTenderItemMatRefID(),
				gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderByTIMRIDAndFMID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID,
				args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID(),
				gdfTenderSubFPPMatDetailsModelImpl.getUserId(),
				gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode(),
				gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderMatUserGenCodeSNU, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU,
				args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber(),
				gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderBySNUAndAndGenCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode,
				args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(_finderPathCountByGDF_Generic_Code, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.isFppSelectedStatus()
			};

			finderCache.removeResult(
				_finderPathCountByFPP_Selected_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFPP_Selected_Status, args);

			args = new Object[] {
				gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID(),
				gdfTenderSubFPPMatDetailsModelImpl.getUserId(),
				gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode(),
				gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber(),
				gdfTenderSubFPPMatDetailsModelImpl.getTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendRefSubFPPMatByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getTenderReferenceNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendRefSubFPPMatByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalTenderItemMatRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Item_Mat_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getTenderItemMatRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Item_Mat_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_fppMarketID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalFppMarketID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_fppMarketID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_fppMarketID,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_fppMarketID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_fppMarketID,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalTenderItemMatRefID(),
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalFppMarketID()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByTIMRIDAndFMID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getTenderItemMatRefID(),
					gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByTIMRIDAndFMID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalFppMarketID(),
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalUserId(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalGdfGenericCode(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderMatUserGenCodeSNU, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID(),
					gdfTenderSubFPPMatDetailsModelImpl.getUserId(),
					gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode(),
					gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderMatUserGenCodeSNU, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalScheduleNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUAndAndGenCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderBySNUAndAndGenCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Generic_Code.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFPP_Selected_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalFppSelectedStatus()
				};

				finderCache.removeResult(
					_finderPathCountByFPP_Selected_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFPP_Selected_Status,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.isFppSelectedStatus()
				};

				finderCache.removeResult(
					_finderPathCountByFPP_Selected_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFPP_Selected_Status,
					args);
			}

			if ((gdfTenderSubFPPMatDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalFppMarketID(),
					gdfTenderSubFPPMatDetailsModelImpl.getOriginalUserId(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalGdfGenericCode(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalScheduleNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getOriginalTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN,
					args);

				args = new Object[] {
					gdfTenderSubFPPMatDetailsModelImpl.getFppMarketID(),
					gdfTenderSubFPPMatDetailsModelImpl.getUserId(),
					gdfTenderSubFPPMatDetailsModelImpl.getGdfGenericCode(),
					gdfTenderSubFPPMatDetailsModelImpl.getScheduleNumber(),
					gdfTenderSubFPPMatDetailsModelImpl.
						getTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubFPPMatDetailsImpl.class,
			gdfTenderSubFPPMatDetails.getPrimaryKey(),
			gdfTenderSubFPPMatDetails, false);

		gdfTenderSubFPPMatDetails.resetOriginalValues();

		return gdfTenderSubFPPMatDetails;
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails = fetchByPrimaryKey(
			primaryKey);

		if (gdfTenderSubFPPMatDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderSubFPPMatDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderSubFPPMatDetails;
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or throws a <code>NoSuchGDFTenderSubFPPMatDetailsException</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details
	 * @throws NoSuchGDFTenderSubFPPMatDetailsException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails findByPrimaryKey(long tenderItemMatRefID)
		throws NoSuchGDFTenderSubFPPMatDetailsException {

		return findByPrimaryKey((Serializable)tenderItemMatRefID);
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details, or <code>null</code> if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubFPPMatDetails fetchByPrimaryKey(
		long tenderItemMatRefID) {

		return fetchByPrimaryKey((Serializable)tenderItemMatRefID);
	}

	/**
	 * Returns all the gdf tender sub fpp mat detailses.
	 *
	 * @return the gdf tender sub fpp mat detailses
	 */
	@Override
	public List<GDFTenderSubFPPMatDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<GDFTenderSubFPPMatDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubFPPMatDetails> orderByComparator,
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

		List<GDFTenderSubFPPMatDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubFPPMatDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERSUBFPPMATDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERSUBFPPMATDETAILS;

				sql = sql.concat(
					GDFTenderSubFPPMatDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderSubFPPMatDetails>)QueryUtil.list(
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
	 * Removes all the gdf tender sub fpp mat detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails : findAll()) {
			remove(gdfTenderSubFPPMatDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses.
	 *
	 * @return the number of gdf tender sub fpp mat detailses
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
					_SQL_COUNT_GDFTENDERSUBFPPMATDETAILS);

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
		return "GDF_Tender_Item_Mat_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERSUBFPPMATDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderSubFPPMatDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender sub fpp mat details persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderSubFPPMatDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		GDFTenderSubFPPMatDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGDFTendRefSubFPPMatByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTendRefSubFPPMatByUserId",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTendRefSubFPPMatByUserId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTendRefSubFPPMatByUserId",
				new String[] {String.class.getName(), Long.class.getName()},
				GDFTenderSubFPPMatDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGDFTendRefSubFPPMatByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTendRefSubFPPMatByUserId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Item_Mat_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Item_Mat_Ref_Id",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Item_Mat_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Item_Mat_Ref_Id",
				new String[] {Long.class.getName()},
				GDFTenderSubFPPMatDetailsModelImpl.
					TENDERITEMMATREFID_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Item_Mat_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Item_Mat_Ref_Id",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_fppMarketID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGDF_Tender_fppMarketID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Tender_fppMarketID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_fppMarketID",
				new String[] {Long.class.getName()},
				GDFTenderSubFPPMatDetailsModelImpl.FPPMARKETID_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_fppMarketID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_fppMarketID",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderByTIMRIDAndFMID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderByTIMRIDAndFMID",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderByTIMRIDAndFMID =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderByTIMRIDAndFMID",
				new String[] {Long.class.getName(), Long.class.getName()},
				GDFTenderSubFPPMatDetailsModelImpl.
					TENDERITEMMATREFID_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.FPPMARKETID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderByTIMRIDAndFMID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderByTIMRIDAndFMID",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderMatUserGenCodeSNU =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderMatUserGenCodeSNU",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderMatUserGenCodeSNU =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderMatUserGenCodeSNU",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				GDFTenderSubFPPMatDetailsModelImpl.FPPMARKETID_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.USERID_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					GDFGENERICCODE_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDFTenderMatUserGenCodeSNU = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderMatUserGenCodeSNU",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByGDFTenderBySNUAndAndGenCode =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderBySNUAndAndGenCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderBySNUAndAndGenCode =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderBySNUAndAndGenCode",
				new String[] {Long.class.getName(), String.class.getName()},
				GDFTenderSubFPPMatDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByGDFTenderBySNUAndAndGenCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderBySNUAndAndGenCode",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGDF_Generic_Code",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGDF_Generic_Code",
			new String[] {String.class.getName()},
			GDFTenderSubFPPMatDetailsModelImpl.GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Generic_Code", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByFPP_Selected_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFPP_Selected_Status",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFPP_Selected_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubFPPMatDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFPP_Selected_Status", new String[] {Boolean.class.getName()},
			GDFTenderSubFPPMatDetailsModelImpl.
				FPPSELECTEDSTATUS_COLUMN_BITMASK);

		_finderPathCountByFPP_Selected_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFPP_Selected_Status",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderByFIDUIDGenCodeSNUTRN",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderByFIDUIDGenCodeSNUTRN =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubFPPMatDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderByFIDUIDGenCodeSNUTRN",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				GDFTenderSubFPPMatDetailsModelImpl.FPPMARKETID_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.USERID_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					GDFGENERICCODE_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderSubFPPMatDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDFTenderByFIDUIDGenCodeSNUTRN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderByFIDUIDGenCodeSNUTRN",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderSubFPPMatDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails"),
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

	private static final String _SQL_SELECT_GDFTENDERSUBFPPMATDETAILS =
		"SELECT gdfTenderSubFPPMatDetails FROM GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails";

	private static final String _SQL_SELECT_GDFTENDERSUBFPPMATDETAILS_WHERE =
		"SELECT gdfTenderSubFPPMatDetails FROM GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails WHERE ";

	private static final String _SQL_COUNT_GDFTENDERSUBFPPMATDETAILS =
		"SELECT COUNT(gdfTenderSubFPPMatDetails) FROM GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails";

	private static final String _SQL_COUNT_GDFTENDERSUBFPPMATDETAILS_WHERE =
		"SELECT COUNT(gdfTenderSubFPPMatDetails) FROM GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"gdfTenderSubFPPMatDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderSubFPPMatDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderSubFPPMatDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderSubFPPMatDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderItemMatRefID", "scheduleNumber", "gdfGenericCode",
			"tenderReferenceNumber", "dosageForm", "noPrimPackageUnits",
			"noSecPackageUnits", "gdfFppMartApprStatus", "fppSelectedStatus",
			"fppMarketID", "tenderItemRefID"
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