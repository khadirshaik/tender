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

package com.gdf.technical.bids.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GDFTenderScheduleItem. This utility wraps
 * <code>com.gdf.technical.bids.service.impl.GDFTenderScheduleItemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author KS61374
 * @see GDFTenderScheduleItemLocalService
 * @generated
 */
public class GDFTenderScheduleItemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.gdf.technical.bids.service.impl.GDFTenderScheduleItemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the gdf tender schedule item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 * @return the gdf tender schedule item that was added
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
		addGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return getService().addGDFTenderScheduleItem(gdfTenderScheduleItem);
	}

	/**
	 * Creates a new gdf tender schedule item with the primary key. Does not add the gdf tender schedule item to the database.
	 *
	 * @param tenderItemRefID the primary key for the new gdf tender schedule item
	 * @return the new gdf tender schedule item
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
		createGDFTenderScheduleItem(long tenderItemRefID) {

		return getService().createGDFTenderScheduleItem(tenderItemRefID);
	}

	/**
	 * Deletes the gdf tender schedule item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
		deleteGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return getService().deleteGDFTenderScheduleItem(gdfTenderScheduleItem);
	}

	/**
	 * Deletes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws PortalException if a gdf tender schedule item with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
			deleteGDFTenderScheduleItem(long tenderItemRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGDFTenderScheduleItem(tenderItemRefID);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
		fetchGDFTenderScheduleItem(long tenderItemRefID) {

		return getService().fetchGDFTenderScheduleItem(tenderItemRefID);
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderScheduleItem>
				findByTenderItemByGenCodeAndSchedNo(
					String tenderReferenceNumber, long tenderItemNumber,
					long scheduleNumber, String gdfGenericCode)
			throws com.gdf.technical.bids.exception.
				NoSuchGDFTenderScheduleItemException {

		return getService().findByTenderItemByGenCodeAndSchedNo(
			tenderReferenceNumber, tenderItemNumber, scheduleNumber,
			gdfGenericCode);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the gdf tender schedule item with the primary key.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws PortalException if a gdf tender schedule item with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
			getGDFTenderScheduleItem(long tenderItemRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGDFTenderScheduleItem(tenderItemRefID);
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderScheduleItem>
				getGDFTenderScheduleItemByItemNumberAndUserId(
					long tenderItemNumber, long userId)
			throws com.gdf.technical.bids.exception.
				NoSuchGDFTenderDetailsException {

		return getService().getGDFTenderScheduleItemByItemNumberAndUserId(
			tenderItemNumber, userId);
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderScheduleItem>
				getGDFTenderScheduleItemByTenderRefNumber(
					String tenderReferenceNumber)
			throws com.gdf.technical.bids.exception.
				NoSuchGDFTenderDetailsException {

		return getService().getGDFTenderScheduleItemByTenderRefNumber(
			tenderReferenceNumber);
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderScheduleItem>
				getGDFTenderScheduleItemByTenderRefNumberAndUserId(
					String tenderReferenceNumber, long userId)
			throws com.gdf.technical.bids.exception.
				NoSuchGDFTenderDetailsException {

		return getService().getGDFTenderScheduleItemByTenderRefNumberAndUserId(
			tenderReferenceNumber, userId);
	}

	/**
	 * Returns a range of all the gdf tender schedule items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderScheduleItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender schedule items
	 * @param end the upper bound of the range of gdf tender schedule items (not inclusive)
	 * @return the range of gdf tender schedule items
	 */
	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderScheduleItem>
			getGDFTenderScheduleItems(int start, int end) {

		return getService().getGDFTenderScheduleItems(start, end);
	}

	/**
	 * Returns the number of gdf tender schedule items.
	 *
	 * @return the number of gdf tender schedule items
	 */
	public static int getGDFTenderScheduleItemsCount() {
		return getService().getGDFTenderScheduleItemsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
			getTenderItemByTenderRefNoAndScheduleNoAndGenricCode(
				String tenderReferenceNumber, long tenderItemNumber,
				long scheduleNumber, String gdfGenericCode)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return getService().
			getTenderItemByTenderRefNoAndScheduleNoAndGenricCode(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode);
	}

	/**
	 * Updates the gdf tender schedule item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 * @return the gdf tender schedule item that was updated
	 */
	public static com.gdf.technical.bids.model.GDFTenderScheduleItem
		updateGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return getService().updateGDFTenderScheduleItem(gdfTenderScheduleItem);
	}

	public static GDFTenderScheduleItemLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderScheduleItemLocalService, GDFTenderScheduleItemLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderScheduleItemLocalService.class);

		ServiceTracker
			<GDFTenderScheduleItemLocalService,
			 GDFTenderScheduleItemLocalService> serviceTracker =
				new ServiceTracker
					<GDFTenderScheduleItemLocalService,
					 GDFTenderScheduleItemLocalService>(
						 bundle.getBundleContext(),
						 GDFTenderScheduleItemLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}