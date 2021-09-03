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

import com.gdf.technical.bids.exception.NoSuchGDFTenderSubSchedDetailsException;
import com.gdf.technical.bids.model.GDFTenderSubSchedDetails;
import com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsImpl;
import com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsModelImpl;
import com.gdf.technical.bids.service.persistence.GDFTenderSubSchedDetailsPersistence;
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
 * The persistence implementation for the gdf tender sub sched details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author KS61374
 * @generated
 */
@Component(service = GDFTenderSubSchedDetailsPersistence.class)
public class GDFTenderSubSchedDetailsPersistenceImpl
	extends BasePersistenceImpl<GDFTenderSubSchedDetails>
	implements GDFTenderSubSchedDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GDFTenderSubSchedDetailsUtil</code> to access the gdf tender sub sched details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GDFTenderSubSchedDetailsImpl.class.getName();

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
	 * Returns all the gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Reference_Number(
		String tenderReferenceNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if (!tenderReferenceNumber.equals(
							gdfTenderSubSchedDetails.
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
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Reference_Number_First(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Reference_Number_First(
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Reference_Number_First(
		String tenderReferenceNumber,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Reference_Number_Last(
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Reference_Number_Last(
				tenderReferenceNumber, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Reference_Number_Last(
		String tenderReferenceNumber,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDF_Tender_Reference_Number(tenderReferenceNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Reference_Number(
			tenderReferenceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderReferenceNumber the tender reference number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails[]
			findByGDF_Tender_Reference_Number_PrevAndNext(
				long tenderSubSchedRefID, String tenderReferenceNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = findByPrimaryKey(
			tenderSubSchedRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails[] array =
				new GDFTenderSubSchedDetailsImpl[3];

			array[0] = getByGDF_Tender_Reference_Number_PrevAndNext(
				session, gdfTenderSubSchedDetails, tenderReferenceNumber,
				orderByComparator, true);

			array[1] = gdfTenderSubSchedDetails;

			array[2] = getByGDF_Tender_Reference_Number_PrevAndNext(
				session, gdfTenderSubSchedDetails, tenderReferenceNumber,
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

	protected GDFTenderSubSchedDetails
		getByGDF_Tender_Reference_Number_PrevAndNext(
			Session session, GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
			String tenderReferenceNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubSchedDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubSchedDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderReferenceNumber = &#63; from the database.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 */
	@Override
	public void removeByGDF_Tender_Reference_Number(
		String tenderReferenceNumber) {

		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDF_Tender_Reference_Number(
					tenderReferenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderReferenceNumber = &#63;.
	 *
	 * @param tenderReferenceNumber the tender reference number
	 * @return the number of matching gdf tender sub sched detailses
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

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			"gdfTenderSubSchedDetails.tenderReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_GDF_TENDER_REFERENCE_NUMBER_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubSchedDetails.tenderReferenceNumber IS NULL OR gdfTenderSubSchedDetails.tenderReferenceNumber = '')";

	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Sub_Sched_Ref_Id;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id;
	private FinderPath _finderPathCountByGDF_Tender_Sub_Sched_Ref_Id;

	/**
	 * Returns all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID) {

		return findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID, int start, int end) {

		return findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Sub_Sched_Ref_Id(
		long tenderSubSchedRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id;
				finderArgs = new Object[] {tenderSubSchedRefID};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDF_Tender_Sub_Sched_Ref_Id;
			finderArgs = new Object[] {
				tenderSubSchedRefID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if (tenderSubSchedRefID !=
							gdfTenderSubSchedDetails.getTenderSubSchedRefID()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SUB_SCHED_REF_ID_TENDERSUBSCHEDREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderSubSchedRefID);

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Sub_Sched_Ref_Id_First(
			long tenderSubSchedRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Sub_Sched_Ref_Id_First(
				tenderSubSchedRefID, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderSubSchedRefID=");
		sb.append(tenderSubSchedRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Sub_Sched_Ref_Id_First(
		long tenderSubSchedRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Sub_Sched_Ref_Id_Last(
			long tenderSubSchedRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Sub_Sched_Ref_Id_Last(
				tenderSubSchedRefID, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderSubSchedRefID=");
		sb.append(tenderSubSchedRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Sub_Sched_Ref_Id_Last(
		long tenderSubSchedRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDF_Tender_Sub_Sched_Ref_Id(tenderSubSchedRefID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Sub_Sched_Ref_Id(
			tenderSubSchedRefID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderSubSchedRefID = &#63; from the database.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 */
	@Override
	public void removeByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID) {
		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDF_Tender_Sub_Sched_Ref_Id(
					tenderSubSchedRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderSubSchedRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	@Override
	public int countByGDF_Tender_Sub_Sched_Ref_Id(long tenderSubSchedRefID) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Sub_Sched_Ref_Id;

		Object[] finderArgs = new Object[] {tenderSubSchedRefID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SUB_SCHED_REF_ID_TENDERSUBSCHEDREFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderSubSchedRefID);

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
		_FINDER_COLUMN_GDF_TENDER_SUB_SCHED_REF_ID_TENDERSUBSCHEDREFID_2 =
			"gdfTenderSubSchedDetails.tenderSubSchedRefID = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath
		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number;
	private FinderPath _finderPathCountByGDF_Tender_Schedule_Number;

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDF_Tender_Schedule_Number(
			scheduleNumber, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Schedule_Number(
		long scheduleNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if (scheduleNumber !=
							gdfTenderSubSchedDetails.getScheduleNumber()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDF_TENDER_SCHEDULE_NUMBER_SCHEDULENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(scheduleNumber);

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Schedule_Number_First(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Schedule_Number_First(
				scheduleNumber, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Schedule_Number_First(
		long scheduleNumber,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Schedule_Number_Last(
			long scheduleNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Schedule_Number_Last(
				scheduleNumber, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Schedule_Number_Last(
		long scheduleNumber,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDF_Tender_Schedule_Number(scheduleNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Schedule_Number(
			scheduleNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where scheduleNumber = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param scheduleNumber the schedule number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails[]
			findByGDF_Tender_Schedule_Number_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = findByPrimaryKey(
			tenderSubSchedRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails[] array =
				new GDFTenderSubSchedDetailsImpl[3];

			array[0] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderSubSchedDetails, scheduleNumber,
				orderByComparator, true);

			array[1] = gdfTenderSubSchedDetails;

			array[2] = getByGDF_Tender_Schedule_Number_PrevAndNext(
				session, gdfTenderSubSchedDetails, scheduleNumber,
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

	protected GDFTenderSubSchedDetails
		getByGDF_Tender_Schedule_Number_PrevAndNext(
			Session session, GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
			long scheduleNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubSchedDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubSchedDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 */
	@Override
	public void removeByGDF_Tender_Schedule_Number(long scheduleNumber) {
		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDF_Tender_Schedule_Number(
					scheduleNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	@Override
	public int countByGDF_Tender_Schedule_Number(long scheduleNumber) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Schedule_Number;

		Object[] finderArgs = new Object[] {scheduleNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			"gdfTenderSubSchedDetails.scheduleNumber = ?";

	private FinderPath _finderPathWithPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Generic_Code;
	private FinderPath _finderPathCountByGDF_Generic_Code;

	/**
	 * Returns all the gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode) {

		return findByGDF_Generic_Code(
			gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end) {

		return findByGDF_Generic_Code(gdfGenericCode, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDF_Generic_Code(
			gdfGenericCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Generic_Code(
		String gdfGenericCode, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if (!gdfGenericCode.equals(
							gdfTenderSubSchedDetails.getGdfGenericCode())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Generic_Code_First(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Generic_Code_First(gdfGenericCode, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Generic_Code_First(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Generic_Code_Last(
			String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Generic_Code_Last(gdfGenericCode, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("gdfGenericCode=");
		sb.append(gdfGenericCode);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Generic_Code_Last(
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDF_Generic_Code(gdfGenericCode);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list = findByGDF_Generic_Code(
			gdfGenericCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where gdfGenericCode = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param gdfGenericCode the gdf generic code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails[] findByGDF_Generic_Code_PrevAndNext(
			long tenderSubSchedRefID, String gdfGenericCode,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = findByPrimaryKey(
			tenderSubSchedRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails[] array =
				new GDFTenderSubSchedDetailsImpl[3];

			array[0] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubSchedDetails, gdfGenericCode,
				orderByComparator, true);

			array[1] = gdfTenderSubSchedDetails;

			array[2] = getByGDF_Generic_Code_PrevAndNext(
				session, gdfTenderSubSchedDetails, gdfGenericCode,
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

	protected GDFTenderSubSchedDetails getByGDF_Generic_Code_PrevAndNext(
		Session session, GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
		String gdfGenericCode,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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
						gdfTenderSubSchedDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubSchedDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub sched detailses where gdfGenericCode = &#63; from the database.
	 *
	 * @param gdfGenericCode the gdf generic code
	 */
	@Override
	public void removeByGDF_Generic_Code(String gdfGenericCode) {
		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDF_Generic_Code(
					gdfGenericCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where gdfGenericCode = &#63;.
	 *
	 * @param gdfGenericCode the gdf generic code
	 * @return the number of matching gdf tender sub sched detailses
	 */
	@Override
	public int countByGDF_Generic_Code(String gdfGenericCode) {
		gdfGenericCode = Objects.toString(gdfGenericCode, "");

		FinderPath finderPath = _finderPathCountByGDF_Generic_Code;

		Object[] finderArgs = new Object[] {gdfGenericCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

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
			"gdfTenderSubSchedDetails.gdfGenericCode = ?";

	private static final String
		_FINDER_COLUMN_GDF_GENERIC_CODE_GDFGENERICCODE_3 =
			"(gdfTenderSubSchedDetails.gdfGenericCode IS NULL OR gdfTenderSubSchedDetails.gdfGenericCode = '')";

	private FinderPath _finderPathWithPaginationFindByGDF_Tender_Item_Ref_Id;
	private FinderPath _finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id;
	private FinderPath _finderPathCountByGDF_Tender_Item_Ref_Id;

	/**
	 * Returns all the gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID) {

		return findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end) {

		return findByGDF_Tender_Item_Ref_Id(tenderItemRefID, start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDF_Tender_Item_Ref_Id(
		long tenderItemRefID, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id;
				finderArgs = new Object[] {tenderItemRefID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGDF_Tender_Item_Ref_Id;
			finderArgs = new Object[] {
				tenderItemRefID, start, end, orderByComparator
			};
		}

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if (tenderItemRefID !=
							gdfTenderSubSchedDetails.getTenderItemRefID()) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_ITEM_REF_ID_TENDERITEMREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemRefID);

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_First(
			long tenderItemRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Item_Ref_Id_First(
				tenderItemRefID, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemRefID=");
		sb.append(tenderItemRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_First(
		long tenderItemRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDF_Tender_Item_Ref_Id_Last(
			long tenderItemRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDF_Tender_Item_Ref_Id_Last(
				tenderItemRefID, orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tenderItemRefID=");
		sb.append(tenderItemRefID);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDF_Tender_Item_Ref_Id_Last(
		long tenderItemRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDF_Tender_Item_Ref_Id(tenderItemRefID);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list = findByGDF_Tender_Item_Ref_Id(
			tenderItemRefID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the gdf tender sub sched detailses before and after the current gdf tender sub sched details in the ordered set where tenderItemRefID = &#63;.
	 *
	 * @param tenderSubSchedRefID the primary key of the current gdf tender sub sched details
	 * @param tenderItemRefID the tender item ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails[] findByGDF_Tender_Item_Ref_Id_PrevAndNext(
			long tenderSubSchedRefID, long tenderItemRefID,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = findByPrimaryKey(
			tenderSubSchedRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails[] array =
				new GDFTenderSubSchedDetailsImpl[3];

			array[0] = getByGDF_Tender_Item_Ref_Id_PrevAndNext(
				session, gdfTenderSubSchedDetails, tenderItemRefID,
				orderByComparator, true);

			array[1] = gdfTenderSubSchedDetails;

			array[2] = getByGDF_Tender_Item_Ref_Id_PrevAndNext(
				session, gdfTenderSubSchedDetails, tenderItemRefID,
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

	protected GDFTenderSubSchedDetails getByGDF_Tender_Item_Ref_Id_PrevAndNext(
		Session session, GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
		long tenderItemRefID,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_GDF_TENDER_ITEM_REF_ID_TENDERITEMREFID_2);

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
			sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tenderItemRefID);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubSchedDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubSchedDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub sched detailses where tenderItemRefID = &#63; from the database.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 */
	@Override
	public void removeByGDF_Tender_Item_Ref_Id(long tenderItemRefID) {
		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDF_Tender_Item_Ref_Id(
					tenderItemRefID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where tenderItemRefID = &#63;.
	 *
	 * @param tenderItemRefID the tender item ref ID
	 * @return the number of matching gdf tender sub sched detailses
	 */
	@Override
	public int countByGDF_Tender_Item_Ref_Id(long tenderItemRefID) {
		FinderPath finderPath = _finderPathCountByGDF_Tender_Item_Ref_Id;

		Object[] finderArgs = new Object[] {tenderItemRefID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_GDF_TENDER_ITEM_REF_ID_TENDERITEMREFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tenderItemRefID);

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
		_FINDER_COLUMN_GDF_TENDER_ITEM_REF_ID_TENDERITEMREFID_2 =
			"gdfTenderSubSchedDetails.tenderItemRefID = ?";

	private FinderPath
		_finderPathWithPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU;
	private FinderPath
		_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU;
	private FinderPath _finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU;

	/**
	 * Returns all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the matching gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber) {

		return findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber, int start, int end) {

		return findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber, start, end,
			null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber, int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
		boolean useFinderCache) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU;
				finderArgs = new Object[] {
					scheduleNumber, tenderReferenceNumber, tenderItemNumber
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU;
			finderArgs = new Object[] {
				scheduleNumber, tenderReferenceNumber, tenderItemNumber, start,
				end, orderByComparator
			};
		}

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : list) {
					if ((scheduleNumber !=
							gdfTenderSubSchedDetails.getScheduleNumber()) ||
						!tenderReferenceNumber.equals(
							gdfTenderSubSchedDetails.
								getTenderReferenceNumber()) ||
						(tenderItemNumber !=
							gdfTenderSubSchedDetails.getTenderItemNumber())) {

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

			sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERITEMNUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(tenderItemNumber);

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByGDFTenderSubBySNUAndTRNUAndTINU_First(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDFTenderSubBySNUAndTRNUAndTINU_First(
				scheduleNumber, tenderReferenceNumber, tenderItemNumber,
				orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the first gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails
		fetchByGDFTenderSubBySNUAndTRNUAndTINU_First(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		List<GDFTenderSubSchedDetails> list =
			findByGDFTenderSubBySNUAndTRNUAndTINU(
				scheduleNumber, tenderReferenceNumber, tenderItemNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubSchedDetails findByGDFTenderSubBySNUAndTRNUAndTINU_Last(
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			fetchByGDFTenderSubBySNUAndTRNUAndTINU_Last(
				scheduleNumber, tenderReferenceNumber, tenderItemNumber,
				orderByComparator);

		if (gdfTenderSubSchedDetails != null) {
			return gdfTenderSubSchedDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("scheduleNumber=");
		sb.append(scheduleNumber);

		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);

		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);

		sb.append("}");

		throw new NoSuchGDFTenderSubSchedDetailsException(sb.toString());
	}

	/**
	 * Returns the last gdf tender sub sched details in the ordered set where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gdf tender sub sched details, or <code>null</code> if a matching gdf tender sub sched details could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByGDFTenderSubBySNUAndTRNUAndTINU_Last(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		int count = countByGDFTenderSubBySNUAndTRNUAndTINU(
			scheduleNumber, tenderReferenceNumber, tenderItemNumber);

		if (count == 0) {
			return null;
		}

		List<GDFTenderSubSchedDetails> list =
			findByGDFTenderSubBySNUAndTRNUAndTINU(
				scheduleNumber, tenderReferenceNumber, tenderItemNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public GDFTenderSubSchedDetails[]
			findByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				long tenderSubSchedRefID, long scheduleNumber,
				String tenderReferenceNumber, long tenderItemNumber,
				OrderByComparator<GDFTenderSubSchedDetails> orderByComparator)
		throws NoSuchGDFTenderSubSchedDetailsException {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = findByPrimaryKey(
			tenderSubSchedRefID);

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails[] array =
				new GDFTenderSubSchedDetailsImpl[3];

			array[0] = getByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				session, gdfTenderSubSchedDetails, scheduleNumber,
				tenderReferenceNumber, tenderItemNumber, orderByComparator,
				true);

			array[1] = gdfTenderSubSchedDetails;

			array[2] = getByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
				session, gdfTenderSubSchedDetails, scheduleNumber,
				tenderReferenceNumber, tenderItemNumber, orderByComparator,
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

	protected GDFTenderSubSchedDetails
		getByGDFTenderSubBySNUAndTRNUAndTINU_PrevAndNext(
			Session session, GDFTenderSubSchedDetails gdfTenderSubSchedDetails,
			long scheduleNumber, String tenderReferenceNumber,
			long tenderItemNumber,
			OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE);

		sb.append(
			_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_SCHEDULENUMBER_2);

		boolean bindTenderReferenceNumber = false;

		if (tenderReferenceNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_3);
		}
		else {
			bindTenderReferenceNumber = true;

			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_2);
		}

		sb.append(
			_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERITEMNUMBER_2);

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
			sb.append(GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
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

		queryPos.add(tenderItemNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						gdfTenderSubSchedDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GDFTenderSubSchedDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63; from the database.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 */
	@Override
	public void removeByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber) {

		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				findByGDFTenderSubBySNUAndTRNUAndTINU(
					scheduleNumber, tenderReferenceNumber, tenderItemNumber,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses where scheduleNumber = &#63; and tenderReferenceNumber = &#63; and tenderItemNumber = &#63;.
	 *
	 * @param scheduleNumber the schedule number
	 * @param tenderReferenceNumber the tender reference number
	 * @param tenderItemNumber the tender item number
	 * @return the number of matching gdf tender sub sched detailses
	 */
	@Override
	public int countByGDFTenderSubBySNUAndTRNUAndTINU(
		long scheduleNumber, String tenderReferenceNumber,
		long tenderItemNumber) {

		tenderReferenceNumber = Objects.toString(tenderReferenceNumber, "");

		FinderPath finderPath =
			_finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU;

		Object[] finderArgs = new Object[] {
			scheduleNumber, tenderReferenceNumber, tenderItemNumber
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_SCHEDULENUMBER_2);

			boolean bindTenderReferenceNumber = false;

			if (tenderReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_3);
			}
			else {
				bindTenderReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_2);
			}

			sb.append(
				_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERITEMNUMBER_2);

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

				queryPos.add(tenderItemNumber);

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
		_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_SCHEDULENUMBER_2 =
			"gdfTenderSubSchedDetails.scheduleNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_2 =
			"gdfTenderSubSchedDetails.tenderReferenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERREFERENCENUMBER_3 =
			"(gdfTenderSubSchedDetails.tenderReferenceNumber IS NULL OR gdfTenderSubSchedDetails.tenderReferenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_GDFTENDERSUBBYSNUANDTRNUANDTINU_TENDERITEMNUMBER_2 =
			"gdfTenderSubSchedDetails.tenderItemNumber = ?";

	public GDFTenderSubSchedDetailsPersistenceImpl() {
		setModelClass(GDFTenderSubSchedDetails.class);

		setModelImplClass(GDFTenderSubSchedDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("tenderSubSchedRefID", "GDF_Tender_Sub_Sched_Ref_Id");
		dbColumnNames.put("tenderItemNumber", "GDF_Tender_Item_Num");
		dbColumnNames.put("scheduleNumber", "GDF_Tender_Schedule_Number");
		dbColumnNames.put("gdfGenericCode", "GDF_Generic_Code");
		dbColumnNames.put(
			"tenderReferenceNumber", "GDF_Tender_Reference_Number");
		dbColumnNames.put("scheduleName", "GDF_Tender_Schedule_Name");
		dbColumnNames.put("patientTarget", "GDF_PatientTarget");
		dbColumnNames.put("tenderItemRefID", "GDF_Tender_Item_Ref_Id");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the gdf tender sub sched details in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 */
	@Override
	public void cacheResult(GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {
		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
			gdfTenderSubSchedDetails.getPrimaryKey(), gdfTenderSubSchedDetails);

		gdfTenderSubSchedDetails.resetOriginalValues();
	}

	/**
	 * Caches the gdf tender sub sched detailses in the entity cache if it is enabled.
	 *
	 * @param gdfTenderSubSchedDetailses the gdf tender sub sched detailses
	 */
	@Override
	public void cacheResult(
		List<GDFTenderSubSchedDetails> gdfTenderSubSchedDetailses) {

		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				gdfTenderSubSchedDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
					gdfTenderSubSchedDetails.getPrimaryKey()) == null) {

				cacheResult(gdfTenderSubSchedDetails);
			}
			else {
				gdfTenderSubSchedDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gdf tender sub sched detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GDFTenderSubSchedDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gdf tender sub sched details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {
		entityCache.removeResult(
			entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
			gdfTenderSubSchedDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<GDFTenderSubSchedDetails> gdfTenderSubSchedDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails :
				gdfTenderSubSchedDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
				gdfTenderSubSchedDetails.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new gdf tender sub sched details with the primary key. Does not add the gdf tender sub sched details to the database.
	 *
	 * @param tenderSubSchedRefID the primary key for the new gdf tender sub sched details
	 * @return the new gdf tender sub sched details
	 */
	@Override
	public GDFTenderSubSchedDetails create(long tenderSubSchedRefID) {
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
			new GDFTenderSubSchedDetailsImpl();

		gdfTenderSubSchedDetails.setNew(true);
		gdfTenderSubSchedDetails.setPrimaryKey(tenderSubSchedRefID);

		return gdfTenderSubSchedDetails;
	}

	/**
	 * Removes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails remove(long tenderSubSchedRefID)
		throws NoSuchGDFTenderSubSchedDetailsException {

		return remove((Serializable)tenderSubSchedRefID);
	}

	/**
	 * Removes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails remove(Serializable primaryKey)
		throws NoSuchGDFTenderSubSchedDetailsException {

		Session session = null;

		try {
			session = openSession();

			GDFTenderSubSchedDetails gdfTenderSubSchedDetails =
				(GDFTenderSubSchedDetails)session.get(
					GDFTenderSubSchedDetailsImpl.class, primaryKey);

			if (gdfTenderSubSchedDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGDFTenderSubSchedDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gdfTenderSubSchedDetails);
		}
		catch (NoSuchGDFTenderSubSchedDetailsException noSuchEntityException) {
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
	protected GDFTenderSubSchedDetails removeImpl(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gdfTenderSubSchedDetails)) {
				gdfTenderSubSchedDetails =
					(GDFTenderSubSchedDetails)session.get(
						GDFTenderSubSchedDetailsImpl.class,
						gdfTenderSubSchedDetails.getPrimaryKeyObj());
			}

			if (gdfTenderSubSchedDetails != null) {
				session.delete(gdfTenderSubSchedDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gdfTenderSubSchedDetails != null) {
			clearCache(gdfTenderSubSchedDetails);
		}

		return gdfTenderSubSchedDetails;
	}

	@Override
	public GDFTenderSubSchedDetails updateImpl(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		boolean isNew = gdfTenderSubSchedDetails.isNew();

		if (!(gdfTenderSubSchedDetails instanceof
				GDFTenderSubSchedDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(gdfTenderSubSchedDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					gdfTenderSubSchedDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in gdfTenderSubSchedDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GDFTenderSubSchedDetails implementation " +
					gdfTenderSubSchedDetails.getClass());
		}

		GDFTenderSubSchedDetailsModelImpl gdfTenderSubSchedDetailsModelImpl =
			(GDFTenderSubSchedDetailsModelImpl)gdfTenderSubSchedDetails;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (gdfTenderSubSchedDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				gdfTenderSubSchedDetails.setCreateDate(now);
			}
			else {
				gdfTenderSubSchedDetails.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!gdfTenderSubSchedDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				gdfTenderSubSchedDetails.setModifiedDate(now);
			}
			else {
				gdfTenderSubSchedDetails.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (gdfTenderSubSchedDetails.isNew()) {
				session.save(gdfTenderSubSchedDetails);

				gdfTenderSubSchedDetails.setNew(false);
			}
			else {
				gdfTenderSubSchedDetails =
					(GDFTenderSubSchedDetails)session.merge(
						gdfTenderSubSchedDetails);
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
				gdfTenderSubSchedDetailsModelImpl.getTenderReferenceNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Reference_Number, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
				args);

			args = new Object[] {
				gdfTenderSubSchedDetailsModelImpl.getTenderSubSchedRefID()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Sub_Sched_Ref_Id, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id,
				args);

			args = new Object[] {
				gdfTenderSubSchedDetailsModelImpl.getScheduleNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Schedule_Number, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
				args);

			args = new Object[] {
				gdfTenderSubSchedDetailsModelImpl.getGdfGenericCode()
			};

			finderCache.removeResult(_finderPathCountByGDF_Generic_Code, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

			args = new Object[] {
				gdfTenderSubSchedDetailsModelImpl.getTenderItemRefID()
			};

			finderCache.removeResult(
				_finderPathCountByGDF_Tender_Item_Ref_Id, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id, args);

			args = new Object[] {
				gdfTenderSubSchedDetailsModelImpl.getScheduleNumber(),
				gdfTenderSubSchedDetailsModelImpl.getTenderReferenceNumber(),
				gdfTenderSubSchedDetailsModelImpl.getTenderItemNumber()
			};

			finderCache.removeResult(
				_finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Reference_Number.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reference_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
					args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getTenderReferenceNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Reference_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number,
					args);
			}

			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalTenderSubSchedRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Sub_Sched_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id,
					args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getTenderSubSchedRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Sub_Sched_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id,
					args);
			}

			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getScheduleNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Schedule_Number, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number,
					args);
			}

			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Generic_Code.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getGdfGenericCode()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Generic_Code, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Generic_Code, args);
			}

			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalTenderItemRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Item_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id,
					args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getTenderItemRefID()
				};

				finderCache.removeResult(
					_finderPathCountByGDF_Tender_Item_Ref_Id, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id,
					args);
			}

			if ((gdfTenderSubSchedDetailsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalScheduleNumber(),
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalTenderReferenceNumber(),
					gdfTenderSubSchedDetailsModelImpl.
						getOriginalTenderItemNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU,
					args);

				args = new Object[] {
					gdfTenderSubSchedDetailsModelImpl.getScheduleNumber(),
					gdfTenderSubSchedDetailsModelImpl.
						getTenderReferenceNumber(),
					gdfTenderSubSchedDetailsModelImpl.getTenderItemNumber()
				};

				finderCache.removeResult(
					_finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GDFTenderSubSchedDetailsImpl.class,
			gdfTenderSubSchedDetails.getPrimaryKey(), gdfTenderSubSchedDetails,
			false);

		gdfTenderSubSchedDetails.resetOriginalValues();

		return gdfTenderSubSchedDetails;
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGDFTenderSubSchedDetailsException {

		GDFTenderSubSchedDetails gdfTenderSubSchedDetails = fetchByPrimaryKey(
			primaryKey);

		if (gdfTenderSubSchedDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGDFTenderSubSchedDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gdfTenderSubSchedDetails;
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key or throws a <code>NoSuchGDFTenderSubSchedDetailsException</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws NoSuchGDFTenderSubSchedDetailsException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails findByPrimaryKey(long tenderSubSchedRefID)
		throws NoSuchGDFTenderSubSchedDetailsException {

		return findByPrimaryKey((Serializable)tenderSubSchedRefID);
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details, or <code>null</code> if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public GDFTenderSubSchedDetails fetchByPrimaryKey(
		long tenderSubSchedRefID) {

		return fetchByPrimaryKey((Serializable)tenderSubSchedRefID);
	}

	/**
	 * Returns all the gdf tender sub sched detailses.
	 *
	 * @return the gdf tender sub sched detailses
	 */
	@Override
	public List<GDFTenderSubSchedDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<GDFTenderSubSchedDetails> findAll(
		int start, int end,
		OrderByComparator<GDFTenderSubSchedDetails> orderByComparator,
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

		List<GDFTenderSubSchedDetails> list = null;

		if (useFinderCache) {
			list = (List<GDFTenderSubSchedDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GDFTENDERSUBSCHEDDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GDFTENDERSUBSCHEDDETAILS;

				sql = sql.concat(
					GDFTenderSubSchedDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GDFTenderSubSchedDetails>)QueryUtil.list(
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
	 * Removes all the gdf tender sub sched detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GDFTenderSubSchedDetails gdfTenderSubSchedDetails : findAll()) {
			remove(gdfTenderSubSchedDetails);
		}
	}

	/**
	 * Returns the number of gdf tender sub sched detailses.
	 *
	 * @return the number of gdf tender sub sched detailses
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
					_SQL_COUNT_GDFTENDERSUBSCHEDDETAILS);

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
		return "GDF_Tender_Sub_Sched_Ref_Id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GDFTENDERSUBSCHEDDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GDFTenderSubSchedDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gdf tender sub sched details persistence.
	 */
	@Activate
	public void activate() {
		GDFTenderSubSchedDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		GDFTenderSubSchedDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubSchedDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubSchedDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGDF_Tender_Reference_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Reference_Number",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Reference_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Reference_Number",
				new String[] {String.class.getName()},
				GDFTenderSubSchedDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Reference_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Reference_Number",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Sub_Sched_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Sub_Sched_Ref_Id",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Sub_Sched_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Sub_Sched_Ref_Id",
				new String[] {Long.class.getName()},
				GDFTenderSubSchedDetailsModelImpl.
					TENDERSUBSCHEDREFID_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Sub_Sched_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Sub_Sched_Ref_Id",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDF_Tender_Schedule_Number =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Schedule_Number",
				new String[] {Long.class.getName()},
				GDFTenderSubSchedDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Schedule_Number = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Schedule_Number",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubSchedDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGDF_Generic_Code",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubSchedDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGDF_Generic_Code",
			new String[] {String.class.getName()},
			GDFTenderSubSchedDetailsModelImpl.GDFGENERICCODE_COLUMN_BITMASK);

		_finderPathCountByGDF_Generic_Code = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Generic_Code", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGDF_Tender_Item_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GDFTenderSubSchedDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGDF_Tender_Item_Ref_Id",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGDF_Tender_Item_Ref_Id =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDF_Tender_Item_Ref_Id",
				new String[] {Long.class.getName()},
				GDFTenderSubSchedDetailsModelImpl.
					TENDERITEMREFID_COLUMN_BITMASK);

		_finderPathCountByGDF_Tender_Item_Ref_Id = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDF_Tender_Item_Ref_Id",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGDFTenderSubBySNUAndTRNUAndTINU",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGDFTenderSubBySNUAndTRNUAndTINU =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				GDFTenderSubSchedDetailsImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGDFTenderSubBySNUAndTRNUAndTINU",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				GDFTenderSubSchedDetailsModelImpl.
					SCHEDULENUMBER_COLUMN_BITMASK |
				GDFTenderSubSchedDetailsModelImpl.
					TENDERREFERENCENUMBER_COLUMN_BITMASK |
				GDFTenderSubSchedDetailsModelImpl.
					TENDERITEMNUMBER_COLUMN_BITMASK);

		_finderPathCountByGDFTenderSubBySNUAndTRNUAndTINU = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGDFTenderSubBySNUAndTRNUAndTINU",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GDFTenderSubSchedDetailsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.gdf.technical.bids.model.GDFTenderSubSchedDetails"),
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

	private static final String _SQL_SELECT_GDFTENDERSUBSCHEDDETAILS =
		"SELECT gdfTenderSubSchedDetails FROM GDFTenderSubSchedDetails gdfTenderSubSchedDetails";

	private static final String _SQL_SELECT_GDFTENDERSUBSCHEDDETAILS_WHERE =
		"SELECT gdfTenderSubSchedDetails FROM GDFTenderSubSchedDetails gdfTenderSubSchedDetails WHERE ";

	private static final String _SQL_COUNT_GDFTENDERSUBSCHEDDETAILS =
		"SELECT COUNT(gdfTenderSubSchedDetails) FROM GDFTenderSubSchedDetails gdfTenderSubSchedDetails";

	private static final String _SQL_COUNT_GDFTENDERSUBSCHEDDETAILS_WHERE =
		"SELECT COUNT(gdfTenderSubSchedDetails) FROM GDFTenderSubSchedDetails gdfTenderSubSchedDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"gdfTenderSubSchedDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GDFTenderSubSchedDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GDFTenderSubSchedDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GDFTenderSubSchedDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"tenderSubSchedRefID", "tenderItemNumber", "scheduleNumber",
			"gdfGenericCode", "tenderReferenceNumber", "scheduleName",
			"patientTarget", "tenderItemRefID"
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