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

import com.gdf.technical.bids.exception.NoSuchGDFTenderDetailsException;
import com.gdf.technical.bids.model.GDFTenderDetails;
import com.gdf.technical.bids.model.impl.GDFTenderDetailsImpl;
import com.gdf.technical.bids.model.impl.GDFTenderDetailsModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderDetailsPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the gdf tender details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderDetailsPersistence.class)
public class GDFTenderDetailsPersistenceImpl
	extends BasePersistenceImpl<GDFTenderDetails>
	implements GDFTenderDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderDetailsUtil</code> to access the gdf tender details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByGDF_Tender_Reference_Number;
	private FinderPath _finderPathCountByGDF_Tender_Reference_Number;

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = fetchByGDF_Tender_Reference_Number(
			tenderReferenceNumber);

		if (gdfTenderDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tenderReferenceNumber=");
			sb.append(tenderReferenceNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGDFTenderDetailsException(sb.toString());
		}

		return gdfTenderDetails;
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return fetchByGDF_Tender_Reference_Number(tenderReferenceNumber, true);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tenderReferenceNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGDF_Tender_Reference_Number, finderArgs,
				this);
		}

		if (result instanceof GDFTenderDetails) {
			GDFTenderDetails gdfTenderDetails = (GDFTenderDetails)result;

			if (!Objects.equals(
					tenderReferenceNumber,
					gdfTenderDetails.getTenderReferenceNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_GDFTENDERDETAILS_WHERE);

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

				List<GDFTenderDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGDF_Tender_Reference_Number,
							finderArgs, list);
					}
				}
				else {
					GDFTenderDetails gdfTenderDetails = list.get(0);

					result = gdfTenderDetails;

					cacheResult(gdfTenderDetails);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByGDF_Tender_Reference_Number,
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
			return (GDFTenderDetails)result;
		}
	}

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender details that was removed
	 */
	@Override
	public GDFTenderDetails removeByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = findByGDF_Tender_Reference_Number(
			tenderReferenceNumber);

		return remove(gdfTenderDetails);
	}

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender detailses
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

			sb.append(_SQL_COUNT_GDFTENDERDETAILS_WHERE);

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
			"gdfTenderDetails.tenderReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3 =
			"(gdfTenderDetails.tenderReferenceNumber IS NULL OR gdfTenderDetails.tenderReferenceNumber = '')";

	private FinderPath _finderPathFetchByGDFTenderRefeNoByUserId;
	private FinderPath _finderPathCountByGDFTenderRefeNoByUserId;

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);

		if (gdfTenderDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tenderReferenceNumber=");
			sb.append(tenderReferenceNumber);

			sb.append(", userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGDFTenderDetailsException(sb.toString());
		}

		return gdfTenderDetails;
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId) {

		return fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId, true);
	}

	/**
	 * Returns the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId, boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tenderReferenceNumber, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, finderArgs, this);
		}

		if (result instanceof GDFTenderDetails) {
			GDFTenderDetails gdfTenderDetails = (GDFTenderDetails)result;

			if (!Objects.equals(
					tenderReferenceNumber,
					gdfTenderDetails.getTenderReferenceNumber()) ||
				(userId != gdfTenderDetails.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_GDFTENDERDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_USERID_2);

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

				List<GDFTenderDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGDFTenderRefeNoByUserId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									tenderReferenceNumber, userId
								};
							}

							_log.warn(
								"GDFTenderDetailsPersistenceImpl.fetchByGDFTenderRefeNoByUserId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					GDFTenderDetails gdfTenderDetails = list.get(0);

					result = gdfTenderDetails;

					cacheResult(gdfTenderDetails);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByGDFTenderRefeNoByUserId, finderArgs);
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
			return (GDFTenderDetails)result;
		}
	}

	/**
	 * Removes the gdf tender details where tenderReferenceNumber = &#63; and userId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the gdf tender details that was removed
	 */
	@Override
	public GDFTenderDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long userId)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = findByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, userId);

		return remove(gdfTenderDetails);
	}

	/**
	 * Returns the number of gdf tender detailses where tenderReferenceNumber = &#63; and userId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	@Override
	public int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long userId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDFTenderRefeNoByUserId;

		Object[] finderArgs = new Object[] {tenderReferenceNumber, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERDETAILS_WHERE);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_2);
			}

			sb.append(_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_USERID_2);

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
		_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_2 =
			"gdfTenderDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderDetails.tenderReferenceNumber IS NULL OR gdfTenderDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_USERID_2 =
			"gdfTenderDetails.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGDFTendersByUserId;
	private FinderPath _finderPathWithoutPaginationFindByGDFTendersByUserId;
	private FinderPath _finderPathCountByGDFTendersByUserId;

	/**
	 * Returns all the gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching gdf tender detailses
	 */
	@Override
	public List<GDFTenderDetails> findByGDFTendersByUserId(long userId) {
		return findByGDFTendersByUserId(
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end) {

		return findByGDFTendersByUserId(userId, start, end, null);
	}

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
	@Override
	public List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator) {

		return findByGDFTendersByUserId(
			userId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderDetails> findByGDFTendersByUserId(
		long userId, int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTendersByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDFTendersByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<GDFTenderDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderDetails gdfTenderDetails : list) {
					if (userId != gdfTenderDetails.getUserId()) {
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

			sb.append(_SQL_SELECT_GDFTENDERDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<GDFTenderDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails findByGDFTendersByUserId_First(
			long userId, OrderByComparator<GDFTenderDetails> orderByComparator)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = fetchByGDFTendersByUserId_First(
			userId, orderByComparator);

		if (gdfTenderDetails != null) {
			return gdfTenderDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDFTendersByUserId_First(
		long userId, OrderByComparator<GDFTenderDetails> orderByComparator) {

		List<GDFTenderDetails> list = findByGDFTendersByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails findByGDFTendersByUserId_Last(
			long userId, OrderByComparator<GDFTenderDetails> orderByComparator)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = fetchByGDFTendersByUserId_Last(
			userId, orderByComparator);

		if (gdfTenderDetails != null) {
			return gdfTenderDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGDFTenderDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender details, or <code>null</code> if a matching gdf tender details could not be found
	 */
	@Override
	public GDFTenderDetails fetchByGDFTendersByUserId_Last(
		long userId, OrderByComparator<GDFTenderDetails> orderByComparator) {

		int count = countByGDFTendersByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderDetails> list = findByGDFTendersByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender detailses before and after the current gdf tender details in the ordered set where userId = &#63;.
	 *
	 * @param tenderRefID the primary key of the current gdf tender details
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails[] findByGDFTendersByUserId_PrevAndNext(
			long tenderRefID, long userId,
			OrderByComparator<GDFTenderDetails> orderByComparator)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = findByPrimaryKey(tenderRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderDetails[] array = new GDFTenderDetailsImpl[3];

			array[0] = getByGDFTendersByUserId_PrevAndNext(
				session, gdfTenderDetails, userId, orderByComparator, true);

			array[1] = gdfTenderDetails;

			array[2] = getByGDFTendersByUserId_PrevAndNext(
				session, gdfTenderDetails, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GDFTenderDetails getByGDFTendersByUserId_PrevAndNext(
		Session session, GDFTenderDetails gdfTenderDetails, long userId,
		OrderByComparator<GDFTenderDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_USERID_2);

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
			sb.append(GDFTenderDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender detailses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByGDFTendersByUserId(long userId) {
		for (GDFTenderDetails gdfTenderDetails :
				findByGDFTendersByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderDetails);
		}
	}

	/**
	 * Returns the number of gdf tender detailses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching gdf tender detailses
	 */
	@Override
	public int countByGDFTendersByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByGDFTendersByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_GDFTENDERSBYUSERID_USERID_2 =
		"gdfTenderDetails.userId = ?";

	public GDFTenderDetailsPersistenceImpl() {
		setModelClass(GDFTenderDetails.class);

		setModelImplClass(GDFTenderDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderRefID", "GDF_Tender_Ref_Id");
		dbColumnNames.put("productCategory", "Product_Category");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put("publicationDate", "Date_Of_Publication");
		dbColumnNames.put(
			"deadlineForTechBidsSub", "Deadline_For_Tech_Bids_Sub");
		dbColumnNames.put("method", "Method");
		dbColumnNames.put("tenderStatus", "Status");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 */
	@Override
	public void cacheResult(GDFTenderDetails gdfTenderDetails) {
		entityCache.putResult(
			entityCacheEnabled, GDFTenderDetailsImpl.class,
			gdfTenderDetails.getPrimaryKey(), gdfTenderDetails);

		finderCache.putResult(
			_finderPathFetchByGDF_Tender_Reference_Number,
			new Object[] {gdfTenderDetails.getTenderReferenceNumber()},
			gdfTenderDetails);

		finderCache.putResult(
			_finderPathFetchByGDFTenderRefeNoByUserId,
			new Object[] {
				gdfTenderDetails.getTenderReferenceNumber(),
				gdfTenderDetails.getUserId()
			},
			gdfTenderDetails);

		gdfTenderDetails.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderDetailses the gdf tender detailses
	 */
	@Override
	public void cacheResult(List<GDFTenderDetails> gdfTenderDetailses) {
		for (GDFTenderDetails gdfTenderDetails : gdfTenderDetailses) {
			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderDetailsImpl.class,
					gdfTenderDetails.getPrimaryKey()) == null) {

				cacheResult(gdfTenderDetails);
			}
			else {
				gdfTenderDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GDFTenderDetails gdfTenderDetails) {
		entityCache.removeResult(
			entityCacheEnabled, GDFTenderDetailsImpl.class,
			gdfTenderDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(GDFTenderDetailsModelImpl)gdfTenderDetails, true);
	}

	@Override
	public void clearCache(List<GDFTenderDetails> gdfTenderDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderDetails gdfTenderDetails : gdfTenderDetailses) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderDetailsImpl.class,
				gdfTenderDetails.getPrimaryKey());

			clearUniqueFindersCache(
				(GDFTenderDetailsModelImpl)gdfTenderDetails, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		GDFTenderDetailsModelImpl gdfTenderDetailsModelImpl) {

		Object[] args = new Object[] {
			gdfTenderDetailsModelImpl.getTenderReferenceNumber()
		};

		finderCache.putResult(
			_finderPathCountByGDF_Tender_Reference_Number, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByGDF_Tender_Reference_Number, args,
			gdfTenderDetailsModelImpl, false);

		args = new Object[] {
			gdfTenderDetailsModelImpl.getTenderReferenceNumber(),
			gdfTenderDetailsModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByGDFTenderRefeNoByUserId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByGDFTenderRefeNoByUserId, args,
			gdfTenderDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		GDFTenderDetailsModelImpl gdfTenderDetailsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				gdfTenderDetailsModelImpl.getTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathFetchByGDF_Tender_Reference_Number, args);
		}

		if ((gdfTenderDetailsModelImpl.getColumnBitmask() &
			 _finderPathFetchByGDF_Tender_Reference_Number.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				gdfTenderDetailsModelImpl.getOriginalTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathFetchByGDF_Tender_Reference_Number, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				gdfTenderDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderDetailsModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderRefeNoByUserId, args);
			finderCache.removeResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, args);
		}

		if ((gdfTenderDetailsModelImpl.getColumnBitmask() &
			 _finderPathFetchByGDFTenderRefeNoByUserId.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				gdfTenderDetailsModelImpl.getOriginalTenderReferenceNumber(),
				gdfTenderDetailsModelImpl.getOriginalUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderRefeNoByUserId, args);
			finderCache.removeResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, args);
		}
	}

	/**
	 * Creates a new gdf tender details with the primary key. Does not add the gdf tender details to the database.
	 *
	 * @param tenderRefID the primary key for the new gdf tender details
	 * @return the new gdf tender details
	 */
	@Override
	public GDFTenderDetails create(long tenderRefID) {
		GDFTenderDetails gdfTenderDetails = new GDFTenderDetailsImpl();

		gdfTenderDetails.setNew(true);
		gdfTenderDetails.setPrimaryKey(tenderRefID);

		return gdfTenderDetails;
	}

	/**
	 * Removes the gdf tender details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details that was removed
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails remove(long tenderRefID)
		throws NoSuchGDFTenderDetailsException {

		return remove((Serializable)tenderRefID);
	}

	/**
	 * Removes the gdf tender details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender details
	 * @return the gdf tender details that was removed
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails remove(Serializable primaryKey)
		throws NoSuchGDFTenderDetailsException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderDetails gdfTenderDetails = (GDFTenderDetails)session.get(
				GDFTenderDetailsImpl.class, primaryKey);

			if (gdfTenderDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderDetails);
		}
		catch (NoSuchGDFTenderDetailsException noSuchEntityException) {
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
	protected GDFTenderDetails removeImpl(GDFTenderDetails gdfTenderDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderDetails)) {
				gdfTenderDetails = (GDFTenderDetails)session.get(
					GDFTenderDetailsImpl.class,
					gdfTenderDetails.getPrimaryKeyObj());
			}

			if (gdfTenderDetails != null) {
				session.delete(gdfTenderDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderDetails != null) {
			clearCache(gdfTenderDetails);
		}

		return gdfTenderDetails;
	}

	@Override
	public GDFTenderDetails updateImpl(GDFTenderDetails gdfTenderDetails) {
		boolean isNew = gdfTenderDetails.isNew();

		if (!(gdfTenderDetails instanceof GDFTenderDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderDetails implementation " +
					gdfTenderDetails.getClass());
		}

		GDFTenderDetailsModelImpl gdfTenderDetailsModelImpl =
			(GDFTenderDetailsModelImpl)gdfTenderDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderDetails.setCreateDate(now);
			}
			else {
				gdfTenderDetails.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderDetails.setModifiedDate(now);
			}
			else {
				gdfTenderDetails.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderDetails.isNew()) {
				session.save(gdfTenderDetails);

				gdfTenderDetails.setNew(false);
			}
			else {
				gdfTenderDetails = (GDFTenderDetails)session.merge(
					gdfTenderDetails);
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
				gdfTenderDetailsModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTendersByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTendersByUserId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((gdfTenderDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTendersByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderDetailsModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendersByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendersByUserId, args);

				args = new Object[] {gdfTenderDetailsModelImpl.getUserId()};

				finderCache.removeResult(
					_finderPathCountByGDFTendersByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendersByUserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderDetailsImpl.class,
			gdfTenderDetails.getPrimaryKey(), gdfTenderDetails, false);

		clearUniqueFindersCache(gdfTenderDetailsModelImpl, false);
		cacheUniqueFindersCache(gdfTenderDetailsModelImpl);

		gdfTenderDetails.resetOriginalValues();

		return gdfTenderDetails;
	}

	/**
	 * Returns the gdf tender details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender details
	 * @return the gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderDetailsException {

		GDFTenderDetails gdfTenderDetails = fetchByPrimaryKey(primaryKey);

		if (gdfTenderDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderDetails;
	}

	/**
	 * Returns the gdf tender details with the primary key or throws a <code>NoSuchGDFTenderDetailsException</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details
	 * @throws NoSuchGDFTenderDetailsException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails findByPrimaryKey(long tenderRefID)
		throws NoSuchGDFTenderDetailsException {

		return findByPrimaryKey((Serializable)tenderRefID);
	}

	/**
	 * Returns the gdf tender details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details, or <code>null</code> if a gdf tender details with the primary key could not be found
	 */
	@Override
	public GDFTenderDetails fetchByPrimaryKey(long tenderRefID) {
		return fetchByPrimaryKey((Serializable)tenderRefID);
	}

	/**
	 * Returns all the gdf tender detailses.
	 *
	 * @return the gdf tender detailses
	 */
	@Override
	public List<GDFTenderDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<GDFTenderDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderDetails> orderByComparator,
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

		List<GDFTenderDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERDETAILS;

				sql = sql.concat(GDFTenderDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderDetails>)QueryUtil.list(
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
	 * Removes all the gdf tender detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderDetails gdfTenderDetails : findAll()) {
			remove(gdfTenderDetails);
		}
	}

	/**
	 * Returns the number of gdf tender detailses.
	 *
	 * @return the number of gdf tender detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GDFTENDERDETAILS);

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
		return "GDF_Tender_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender details persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderDetailsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GDFTenderDetailsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()},
			GDFTenderDetailsModelImpl.TENDERREFERENCENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()});

		_finderPathFetchByGDFTenderRefeNoByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByGDFTenderRefeNoByUserId",
			new String[] {String.class.getName(), Long.class.getName()},
			GDFTenderDetailsModelImpl.TENDERREFERENCENUMBER_COLUMN_BITMASK |
			GDFTenderDetailsModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderRefeNoByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderRefeNoByUserId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGDFTendersByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GDFTenderDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGDFTendersByUserId", new String[] {Long.class.getName()},
			GDFTenderDetailsModelImpl.USERID_COLUMN_BITMASK |
			GDFTenderDetailsModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTendersByUserId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderDetails"),
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

	private static final String _SQL_SELECT_GDFTENDERDETAILS =
		"SELECT gdfTenderDetails FROM GDFTenderDetails gdfTenderDetails";

	private static final String _SQL_SELECT_GDFTENDERDETAILS_WHERE =
		"SELECT gdfTenderDetails FROM GDFTenderDetails gdfTenderDetails WHERE ";

	private static final String _SQL_COUNT_GDFTENDERDETAILS =
		"SELECT COUNT(gdfTenderDetails) FROM GDFTenderDetails gdfTenderDetails";

	private static final String _SQL_COUNT_GDFTENDERDETAILS_WHERE =
		"SELECT COUNT(gdfTenderDetails) FROM GDFTenderDetails gdfTenderDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gdfTenderDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderRefID", "productCategory", "tenderReferenceNumber",
			"publicationDate", "deadlineForTechBidsSub", "method",
			"tenderStatus"
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