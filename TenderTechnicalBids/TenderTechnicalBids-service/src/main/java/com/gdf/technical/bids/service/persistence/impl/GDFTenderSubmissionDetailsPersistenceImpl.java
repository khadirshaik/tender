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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubmissionDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;
import com.gdf.technical.bids.model.impl.GDFTenderSubmissionDetailsImpl;
import com.gdf.technical.bids.model.impl.GDFTenderSubmissionDetailsModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderSubmissionDetailsPersistence;
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
 * The persistence implementation for the gdf tender submission details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderSubmissionDetailsPersistence.class)
public class GDFTenderSubmissionDetailsPersistenceImpl
	extends BasePersistenceImpl<GDFTenderSubmissionDetails>
	implements GDFTenderSubmissionDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderSubmissionDetailsUtil</code> to access the gdf tender submission details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderSubmissionDetailsImpl.class.getName();

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
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			fetchByGDF_Tender_Reference_Number(tenderReferenceNumber);

		if (gdfTenderSubmissionDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tenderReferenceNumber=");
			sb.append(tenderReferenceNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGDFTenderSubmissionDetailsException(sb.toString());
		}

		return gdfTenderSubmissionDetails;
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return fetchByGDF_Tender_Reference_Number(tenderReferenceNumber, true);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDF_Tender_Reference_Number(
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

		if (result instanceof GDFTenderSubmissionDetails) {
			GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
				(GDFTenderSubmissionDetails)result;

			if (!Objects.equals(
					tenderReferenceNumber,
					gdfTenderSubmissionDetails.getTenderReferenceNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_GDFTENDERSUBMISSIONDETAILS_WHERE);

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

				List<GDFTenderSubmissionDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGDF_Tender_Reference_Number,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									tenderReferenceNumber
								};
							}

							_log.warn(
								"GDFTenderSubmissionDetailsPersistenceImpl.fetchByGDF_Tender_Reference_Number(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
						list.get(0);

					result = gdfTenderSubmissionDetails;

					cacheResult(gdfTenderSubmissionDetails);
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
			return (GDFTenderSubmissionDetails)result;
		}
	}

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the gdf tender submission details that was removed
	 */
	@Override
	public GDFTenderSubmissionDetails removeByGDF_Tender_Reference_Number(
			String tenderReferenceNumber)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			findByGDF_Tender_Reference_Number(tenderReferenceNumber);

		return remove(gdfTenderSubmissionDetails);
	}

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender submission detailses
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

			sb.append(_SQL_COUNT_GDFTENDERSUBMISSIONDETAILS_WHERE);

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
			"gdfTenderSubmissionDetails.tenderReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubmissionDetails.tenderReferenceNumber IS NULL OR gdfTenderSubmissionDetails.tenderReferenceNumber = '')";

	private FinderPath _finderPathFetchByGDFTenderRefeNoByUserId;
	private FinderPath _finderPathCountByGDFTenderRefeNoByUserId;

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			fetchByGDFTenderRefeNoByUserId(tenderReferenceNumber, supplierId);

		if (gdfTenderSubmissionDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("tenderReferenceNumber=");
			sb.append(tenderReferenceNumber);

			sb.append(", supplierId=");
			sb.append(supplierId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGDFTenderSubmissionDetailsException(sb.toString());
		}

		return gdfTenderSubmissionDetails;
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId) {

		return fetchByGDFTenderRefeNoByUserId(
			tenderReferenceNumber, supplierId, true);
	}

	/**
	 * Returns the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId, boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {tenderReferenceNumber, supplierId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, finderArgs, this);
		}

		if (result instanceof GDFTenderSubmissionDetails) {
			GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
				(GDFTenderSubmissionDetails)result;

			if (!Objects.equals(
					tenderReferenceNumber,
					gdfTenderSubmissionDetails.getTenderReferenceNumber()) ||
				(supplierId != gdfTenderSubmissionDetails.getSupplierId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_GDFTENDERSUBMISSIONDETAILS_WHERE);

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

			sb.append(_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_SUPPLIERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(supplierId);

				List<GDFTenderSubmissionDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGDFTenderRefeNoByUserId,
							finderArgs, list);
					}
				}
				else {
					GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
						list.get(0);

					result = gdfTenderSubmissionDetails;

					cacheResult(gdfTenderSubmissionDetails);
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
			return (GDFTenderSubmissionDetails)result;
		}
	}

	/**
	 * Removes the gdf tender submission details where tenderReferenceNumber = &#63; and supplierId = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the gdf tender submission details that was removed
	 */
	@Override
	public GDFTenderSubmissionDetails removeByGDFTenderRefeNoByUserId(
			String tenderReferenceNumber, long supplierId)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			findByGDFTenderRefeNoByUserId(tenderReferenceNumber, supplierId);

		return remove(gdfTenderSubmissionDetails);
	}

	/**
	 * Returns the number of gdf tender submission detailses where tenderReferenceNumber = &#63; and supplierId = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	@Override
	public int countByGDFTenderRefeNoByUserId(
		String tenderReferenceNumber, long supplierId) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByGDFTenderRefeNoByUserId;

		Object[] finderArgs = new Object[] {tenderReferenceNumber, supplierId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GDFTENDERSUBMISSIONDETAILS_WHERE);

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

			sb.append(_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_SUPPLIERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTenderReferenceNumber) {
					queryPos.add(tenderReferenceNumber);
				}

				queryPos.add(supplierId);

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
			"gdfTenderSubmissionDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubmissionDetails.tenderReferenceNumber IS NULL OR gdfTenderSubmissionDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERREFENOBYUSERID_SUPPLIERID_2 =
			"gdfTenderSubmissionDetails.supplierId = ?";

	private FinderPath _finderPathWithPaginationFindByGDFTendersByUserId;
	private FinderPath _finderPathWithoutPaginationFindByGDFTendersByUserId;
	private FinderPath _finderPathCountByGDFTendersByUserId;

	/**
	 * Returns all the gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the matching gdf tender submission detailses
	 */
	@Override
	public List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId) {

		return findByGDFTendersByUserId(
			supplierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end) {

		return findByGDFTendersByUserId(supplierId, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return findByGDFTendersByUserId(
			supplierId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findByGDFTendersByUserId(
		long supplierId, int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTendersByUserId;
				finderArgs = new Object[] {supplierId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDFTendersByUserId;
			finderArgs = new Object[] {
				supplierId, start, end, orderByComparator
			};
		}

		List<GDFTenderSubmissionDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubmissionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubmissionDetails gdfTenderSubmissionDetails :
						list) {

					if (supplierId !=
							gdfTenderSubmissionDetails.getSupplierId()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBMISSIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_SUPPLIERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubmissionDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(supplierId);

				list = (List<GDFTenderSubmissionDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByGDFTendersByUserId_First(
			long supplierId,
			OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			fetchByGDFTendersByUserId_First(supplierId, orderByComparator);

		if (gdfTenderSubmissionDetails != null) {
			return gdfTenderSubmissionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("supplierId=");
		sb.append(supplierId);

		sb.append("}");

		throw new NoSuchGDFTenderSubmissionDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDFTendersByUserId_First(
		long supplierId,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		List<GDFTenderSubmissionDetails> list = findByGDFTendersByUserId(
			supplierId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByGDFTendersByUserId_Last(
			long supplierId,
			OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			fetchByGDFTendersByUserId_Last(supplierId, orderByComparator);

		if (gdfTenderSubmissionDetails != null) {
			return gdfTenderSubmissionDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("supplierId=");
		sb.append(supplierId);

		sb.append("}");

		throw new NoSuchGDFTenderSubmissionDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender submission details, or <code>null</code> if a matching gdf tender submission details could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByGDFTendersByUserId_Last(
		long supplierId,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		int count = countByGDFTendersByUserId(supplierId);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubmissionDetails> list = findByGDFTendersByUserId(
			supplierId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender submission detailses before and after the current gdf tender submission details in the ordered set where supplierId = &#63;.
	 *
	 * @param tenderSubRefID the primary key of the current gdf tender submission details
	 * @param supplierId the supplier ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails[] findByGDFTendersByUserId_PrevAndNext(
			long tenderSubRefID, long supplierId,
			OrderByComparator<GDFTenderSubmissionDetails> orderByComparator)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			findByPrimaryKey(tenderSubRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubmissionDetails[] array =
				new GDFTenderSubmissionDetailsImpl[3];

			array[0] = getByGDFTendersByUserId_PrevAndNext(
				session, gdfTenderSubmissionDetails, supplierId,
				orderByComparator, true);

			array[1] = gdfTenderSubmissionDetails;

			array[2] = getByGDFTendersByUserId_PrevAndNext(
				session, gdfTenderSubmissionDetails, supplierId,
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

	protected GDFTenderSubmissionDetails getByGDFTendersByUserId_PrevAndNext(
		Session session, GDFTenderSubmissionDetails gdfTenderSubmissionDetails,
		long supplierId,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBMISSIONDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_SUPPLIERID_2);

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
			sb.append(GDFTenderSubmissionDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(supplierId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubmissionDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubmissionDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender submission detailses where supplierId = &#63; from the database.
	 *
	 * @param supplierId the supplier ID
	 */
	@Override
	public void removeByGDFTendersByUserId(long supplierId) {
		for (GDFTenderSubmissionDetails gdfTenderSubmissionDetails :
				findByGDFTendersByUserId(
					supplierId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubmissionDetails);
		}
	}

	/**
	 * Returns the number of gdf tender submission detailses where supplierId = &#63;.
	 *
	 * @param supplierId the supplier ID
	 * @return the number of matching gdf tender submission detailses
	 */
	@Override
	public int countByGDFTendersByUserId(long supplierId) {
		FinderPath finderPath = _finderPathCountByGDFTendersByUserId;

		Object[] finderArgs = new Object[] {supplierId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBMISSIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDFTENDERSBYUSERID_SUPPLIERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(supplierId);

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

	private static final String _FINDER_COLUMN_GDFTENDERSBYUSERID_SUPPLIERID_2 =
		"gdfTenderSubmissionDetails.supplierId = ?";

	public GDFTenderSubmissionDetailsPersistenceImpl() {
		setModelClass(GDFTenderSubmissionDetails.class);

		setModelImplClass(GDFTenderSubmissionDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderSubRefID", "GDF_Tender_Sub_Ref_Id");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put("copyOfRegCert", "Copy_Of_Reg_Cert");
		dbColumnNames.put("supplierName", "Supplier_Name");
		dbColumnNames.put("nameOfAuthRepr", "Name_Of_Auth_Repr");
		dbColumnNames.put("supplierTitle", "Supplier_Title");
		dbColumnNames.put("supplierEmailAddress", "Supplier_Email_Address");
		dbColumnNames.put(
			"supplierTelephoneNumber", "Supplier_Telephone_Number");
		dbColumnNames.put("tenderSubmissionStatus", "Submission_Status");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender submission details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 */
	@Override
	public void cacheResult(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
			gdfTenderSubmissionDetails.getPrimaryKey(),
			gdfTenderSubmissionDetails);

		finderCache.putResult(
			_finderPathFetchByGDF_Tender_Reference_Number,
			new Object[] {
				gdfTenderSubmissionDetails.getTenderReferenceNumber()
			},
			gdfTenderSubmissionDetails);

		finderCache.putResult(
			_finderPathFetchByGDFTenderRefeNoByUserId,
			new Object[] {
				gdfTenderSubmissionDetails.getTenderReferenceNumber(),
				gdfTenderSubmissionDetails.getSupplierId()
			},
			gdfTenderSubmissionDetails);

		gdfTenderSubmissionDetails.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender submission detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubmissionDetailses the gdf tender submission detailses
	 */
	@Override
	public void cacheResult(
		List<GDFTenderSubmissionDetails> gdfTenderSubmissionDetailses) {

		for (GDFTenderSubmissionDetails gdfTenderSubmissionDetails :
				gdfTenderSubmissionDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
					gdfTenderSubmissionDetails.getPrimaryKey()) == null) {

				cacheResult(gdfTenderSubmissionDetails);
			}
			else {
				gdfTenderSubmissionDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender submission detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderSubmissionDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender submission details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		entityCache.removeResult(
			entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
			gdfTenderSubmissionDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(GDFTenderSubmissionDetailsModelImpl)gdfTenderSubmissionDetails,
			true);
	}

	@Override
	public void clearCache(
		List<GDFTenderSubmissionDetails> gdfTenderSubmissionDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderSubmissionDetails gdfTenderSubmissionDetails :
				gdfTenderSubmissionDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
				gdfTenderSubmissionDetails.getPrimaryKey());

			clearUniqueFindersCache(
				(GDFTenderSubmissionDetailsModelImpl)gdfTenderSubmissionDetails,
				true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		GDFTenderSubmissionDetailsModelImpl
			gdfTenderSubmissionDetailsModelImpl) {

		Object[] args = new Object[] {
			gdfTenderSubmissionDetailsModelImpl.getTenderReferenceNumber()
		};

		finderCache.putResult(
			_finderPathCountByGDF_Tender_Reference_Number, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByGDF_Tender_Reference_Number, args,
			gdfTenderSubmissionDetailsModelImpl, false);

		args = new Object[] {
			gdfTenderSubmissionDetailsModelImpl.getTenderReferenceNumber(),
			gdfTenderSubmissionDetailsModelImpl.getSupplierId()
		};

		finderCache.putResult(
			_finderPathCountByGDFTenderRefeNoByUserId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByGDFTenderRefeNoByUserId, args,
			gdfTenderSubmissionDetailsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		GDFTenderSubmissionDetailsModelImpl gdfTenderSubmissionDetailsModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				gdfTenderSubmissionDetailsModelImpl.getTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathFetchByGDF_Tender_Reference_Number, args);
		}

		if ((gdfTenderSubmissionDetailsModelImpl.getColumnBitmask() &
			 _finderPathFetchByGDF_Tender_Reference_Number.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				gdfTenderSubmissionDetailsModelImpl.
					getOriginalTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathFetchByGDF_Tender_Reference_Number, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				gdfTenderSubmissionDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubmissionDetailsModelImpl.getSupplierId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderRefeNoByUserId, args);
			finderCache.removeResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, args);
		}

		if ((gdfTenderSubmissionDetailsModelImpl.getColumnBitmask() &
			 _finderPathFetchByGDFTenderRefeNoByUserId.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				gdfTenderSubmissionDetailsModelImpl.
					getOriginalTenderReferenceNumber(),
				gdfTenderSubmissionDetailsModelImpl.getOriginalSupplierId()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderRefeNoByUserId, args);
			finderCache.removeResult(
				_finderPathFetchByGDFTenderRefeNoByUserId, args);
		}
	}

	/**
	 * Creates a new gdf tender submission details with the primary key. Does not add the gdf tender submission details to the database.
	 *
	 * @param tenderSubRefID the primary key for the new gdf tender submission details
	 * @return the new gdf tender submission details
	 */
	@Override
	public GDFTenderSubmissionDetails create(long tenderSubRefID) {
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			new GDFTenderSubmissionDetailsImpl();

		gdfTenderSubmissionDetails.setNew(true);
		gdfTenderSubmissionDetails.setPrimaryKey(tenderSubRefID);

		return gdfTenderSubmissionDetails;
	}

	/**
	 * Removes the gdf tender submission details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails remove(long tenderSubRefID)
		throws NoSuchGDFTenderSubmissionDetailsException {

		return remove((Serializable)tenderSubRefID);
	}

	/**
	 * Removes the gdf tender submission details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails remove(Serializable primaryKey)
		throws NoSuchGDFTenderSubmissionDetailsException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
				(GDFTenderSubmissionDetails)session.get(
					GDFTenderSubmissionDetailsImpl.class, primaryKey);

			if (gdfTenderSubmissionDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderSubmissionDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderSubmissionDetails);
		}
		catch (NoSuchGDFTenderSubmissionDetailsException
					noSuchEntityException) {

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
	protected GDFTenderSubmissionDetails removeImpl(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderSubmissionDetails)) {
				gdfTenderSubmissionDetails =
					(GDFTenderSubmissionDetails)session.get(
						GDFTenderSubmissionDetailsImpl.class,
						gdfTenderSubmissionDetails.getPrimaryKeyObj());
			}

			if (gdfTenderSubmissionDetails != null) {
				session.delete(gdfTenderSubmissionDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderSubmissionDetails != null) {
			clearCache(gdfTenderSubmissionDetails);
		}

		return gdfTenderSubmissionDetails;
	}

	@Override
	public GDFTenderSubmissionDetails updateImpl(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		boolean isNew = gdfTenderSubmissionDetails.isNew();

		if (!(gdfTenderSubmissionDetails instanceof
				GDFTenderSubmissionDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderSubmissionDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderSubmissionDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderSubmissionDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderSubmissionDetails implementation " +
					gdfTenderSubmissionDetails.getClass());
		}

		GDFTenderSubmissionDetailsModelImpl
			gdfTenderSubmissionDetailsModelImpl =
				(GDFTenderSubmissionDetailsModelImpl)gdfTenderSubmissionDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderSubmissionDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderSubmissionDetails.setCreateDate(now);
			}
			else {
				gdfTenderSubmissionDetails.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderSubmissionDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderSubmissionDetails.setModifiedDate(now);
			}
			else {
				gdfTenderSubmissionDetails.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderSubmissionDetails.isNew()) {
				session.save(gdfTenderSubmissionDetails);

				gdfTenderSubmissionDetails.setNew(false);
			}
			else {
				gdfTenderSubmissionDetails =
					(GDFTenderSubmissionDetails)session.merge(
						gdfTenderSubmissionDetails);
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
				gdfTenderSubmissionDetailsModelImpl.getSupplierId()
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
			if ((gdfTenderSubmissionDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTendersByUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubmissionDetailsModelImpl.getOriginalSupplierId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendersByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendersByUserId, args);

				args = new Object[] {
					gdfTenderSubmissionDetailsModelImpl.getSupplierId()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTendersByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTendersByUserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubmissionDetailsImpl.class,
			gdfTenderSubmissionDetails.getPrimaryKey(),
			gdfTenderSubmissionDetails, false);

		clearUniqueFindersCache(gdfTenderSubmissionDetailsModelImpl, false);
		cacheUniqueFindersCache(gdfTenderSubmissionDetailsModelImpl);

		gdfTenderSubmissionDetails.resetOriginalValues();

		return gdfTenderSubmissionDetails;
	}

	/**
	 * Returns the gdf tender submission details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender submission details
	 * @return the gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderSubmissionDetailsException {

		GDFTenderSubmissionDetails gdfTenderSubmissionDetails =
			fetchByPrimaryKey(primaryKey);

		if (gdfTenderSubmissionDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderSubmissionDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderSubmissionDetails;
	}

	/**
	 * Returns the gdf tender submission details with the primary key or throws a <code>NoSuchGDFTenderSubmissionDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details
	 * @throws NoSuchGDFTenderSubmissionDetailsException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails findByPrimaryKey(long tenderSubRefID)
		throws NoSuchGDFTenderSubmissionDetailsException {

		return findByPrimaryKey((Serializable)tenderSubRefID);
	}

	/**
	 * Returns the gdf tender submission details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details, or <code>null</code> if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubmissionDetails fetchByPrimaryKey(long tenderSubRefID) {
		return fetchByPrimaryKey((Serializable)tenderSubRefID);
	}

	/**
	 * Returns all the gdf tender submission detailses.
	 *
	 * @return the gdf tender submission detailses
	 */
	@Override
	public List<GDFTenderSubmissionDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubmissionDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubmissionDetails> orderByComparator,
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

		List<GDFTenderSubmissionDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubmissionDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERSUBMISSIONDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERSUBMISSIONDETAILS;

				sql = sql.concat(
					GDFTenderSubmissionDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderSubmissionDetails>)QueryUtil.list(
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
	 * Removes all the gdf tender submission detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderSubmissionDetails gdfTenderSubmissionDetails :
				findAll()) {

			remove(gdfTenderSubmissionDetails);
		}
	}

	/**
	 * Returns the number of gdf tender submission detailses.
	 *
	 * @return the number of gdf tender submission detailses
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
					_SQL_COUNT_GDFTENDERSUBMISSIONDETAILS);

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
		return "GDF_Tender_Sub_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERSUBMISSIONDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderSubmissionDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender submission details persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderSubmissionDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		GDFTenderSubmissionDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()},
			GDFTenderSubmissionDetailsModelImpl.
				TENDERREFERENCENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()});

		_finderPathFetchByGDFTenderRefeNoByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGDFTenderRefeNoByUserId",
			new String[] {String.class.getName(), Long.class.getName()},
			GDFTenderSubmissionDetailsModelImpl.
				TENDERREFERENCENUMBER_COLUMN_BITMASK |
			GDFTenderSubmissionDetailsModelImpl.SUPPLIERID_COLUMN_BITMASK);

		_finderPathCountByGDFTenderRefeNoByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderRefeNoByUserId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGDFTendersByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubmissionDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGDFTendersByUserId", new String[] {Long.class.getName()},
			GDFTenderSubmissionDetailsModelImpl.SUPPLIERID_COLUMN_BITMASK |
			GDFTenderSubmissionDetailsModelImpl.MODIFIEDDATE_COLUMN_BITMASK |
			GDFTenderSubmissionDetailsModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGDFTendersByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTendersByUserId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderSubmissionDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderSubmissionDetails"),
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

	private static final String _SQL_SELECT_GDFTENDERSUBMISSIONDETAILS =
		"SELECT gdfTenderSubmissionDetails FROM GDFTenderSubmissionDetails gdfTenderSubmissionDetails";

	private static final String _SQL_SELECT_GDFTENDERSUBMISSIONDETAILS_WHERE =
		"SELECT gdfTenderSubmissionDetails FROM GDFTenderSubmissionDetails gdfTenderSubmissionDetails WHERE ";

	private static final String _SQL_COUNT_GDFTENDERSUBMISSIONDETAILS =
		"SELECT COUNT(gdfTenderSubmissionDetails) FROM GDFTenderSubmissionDetails gdfTenderSubmissionDetails";

	private static final String _SQL_COUNT_GDFTENDERSUBMISSIONDETAILS_WHERE =
		"SELECT COUNT(gdfTenderSubmissionDetails) FROM GDFTenderSubmissionDetails gdfTenderSubmissionDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"gdfTenderSubmissionDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderSubmissionDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderSubmissionDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderSubmissionDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderSubRefID", "tenderReferenceNumber", "copyOfRegCert",
			"supplierName", "nameOfAuthRepr", "supplierTitle",
			"supplierEmailAddress", "supplierTelephoneNumber",
			"tenderSubmissionStatus"
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