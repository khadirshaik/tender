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
 * Provides the local service utility for GDFTenderSubSchedDetails. This utility wraps
 * <code>com.gdf.technical.bids.service.impl.GDFTenderSubSchedDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetailsLocalService
 * @generated
 */
public class GDFTenderSubSchedDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.gdf.technical.bids.service.impl.GDFTenderSubSchedDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the gdf tender sub sched details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was added
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		addGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return getService().addGDFTenderSubSchedDetails(
			gdfTenderSubSchedDetails);
	}

	/**
	 * Creates a new gdf tender sub sched details with the primary key. Does not add the gdf tender sub sched details to the database.
	 *
	 * @param tenderSubSchedRefID the primary key for the new gdf tender sub sched details
	 * @return the new gdf tender sub sched details
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		createGDFTenderSubSchedDetails(long tenderSubSchedRefID) {

		return getService().createGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	/**
	 * Deletes the gdf tender sub sched details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		deleteGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return getService().deleteGDFTenderSubSchedDetails(
			gdfTenderSubSchedDetails);
	}

	/**
	 * Deletes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws PortalException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
			deleteGDFTenderSubSchedDetails(long tenderSubSchedRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGDFTenderSubSchedDetails(tenderSubSchedRefID);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsModelImpl</code>.
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

	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		fetchGDFTenderSubSchedDetails(long tenderSubSchedRefID) {

		return getService().fetchGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws PortalException if a gdf tender sub sched details with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
			getGDFTenderSubSchedDetails(long tenderSubSchedRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub sched detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub sched detailses
	 * @param end the upper bound of the range of gdf tender sub sched detailses (not inclusive)
	 * @return the range of gdf tender sub sched detailses
	 */
	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubSchedDetails>
			getGDFTenderSubSchedDetailses(int start, int end) {

		return getService().getGDFTenderSubSchedDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses.
	 *
	 * @return the number of gdf tender sub sched detailses
	 */
	public static int getGDFTenderSubSchedDetailsesCount() {
		return getService().getGDFTenderSubSchedDetailsesCount();
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

	/**
	 * Updates the gdf tender sub sched details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was updated
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		updateGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return getService().updateGDFTenderSubSchedDetails(
			gdfTenderSubSchedDetails);
	}

	public static GDFTenderSubSchedDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubSchedDetailsLocalService,
		 GDFTenderSubSchedDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubSchedDetailsLocalService.class);

		ServiceTracker
			<GDFTenderSubSchedDetailsLocalService,
			 GDFTenderSubSchedDetailsLocalService> serviceTracker =
				new ServiceTracker
					<GDFTenderSubSchedDetailsLocalService,
					 GDFTenderSubSchedDetailsLocalService>(
						 bundle.getBundleContext(),
						 GDFTenderSubSchedDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}