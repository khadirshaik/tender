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
 * Provides the local service utility for GDFTenderSubFPPRegDetails. This utility wraps
 * <code>com.gdf.technical.bids.service.impl.GDFTenderSubFPPRegDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetailsLocalService
 * @generated
 */
public class GDFTenderSubFPPRegDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.gdf.technical.bids.service.impl.GDFTenderSubFPPRegDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the gdf tender sub fpp reg details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was added
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
		addGDFTenderSubFPPRegDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
				gdfTenderSubFPPRegDetails) {

		return getService().addGDFTenderSubFPPRegDetails(
			gdfTenderSubFPPRegDetails);
	}

	/**
	 * Creates a new gdf tender sub fpp reg details with the primary key. Does not add the gdf tender sub fpp reg details to the database.
	 *
	 * @param tenderRegRefID the primary key for the new gdf tender sub fpp reg details
	 * @return the new gdf tender sub fpp reg details
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
		createGDFTenderSubFPPRegDetails(long tenderRegRefID) {

		return getService().createGDFTenderSubFPPRegDetails(tenderRegRefID);
	}

	/**
	 * Deletes the gdf tender sub fpp reg details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
		deleteGDFTenderSubFPPRegDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
				gdfTenderSubFPPRegDetails) {

		return getService().deleteGDFTenderSubFPPRegDetails(
			gdfTenderSubFPPRegDetails);
	}

	/**
	 * Deletes the gdf tender sub fpp reg details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was removed
	 * @throws PortalException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
			deleteGDFTenderSubFPPRegDetails(long tenderRegRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGDFTenderSubFPPRegDetails(tenderRegRefID);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsModelImpl</code>.
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

	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
		fetchGDFTenderSubFPPRegDetails(long tenderRegRefID) {

		return getService().fetchGDFTenderSubFPPRegDetails(tenderRegRefID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails>
			getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(
				long scheduleNumber, long userId, String tenderReferenceNumber,
				String gdfGenericCode, long fppRegistrationId) {

		return getService().getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(
			scheduleNumber, userId, tenderReferenceNumber, gdfGenericCode,
			fppRegistrationId);
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails>
			getGDFTenderFPPRegDetailsByFppMartId(long fppRegistrationId) {

		return getService().getGDFTenderFPPRegDetailsByFppMartId(
			fppRegistrationId);
	}

	/**
	 * Returns the gdf tender sub fpp reg details with the primary key.
	 *
	 * @param tenderRegRefID the primary key of the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details
	 * @throws PortalException if a gdf tender sub fpp reg details with the primary key could not be found
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
			getGDFTenderSubFPPRegDetails(long tenderRegRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGDFTenderSubFPPRegDetails(tenderRegRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp reg detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp reg detailses
	 * @param end the upper bound of the range of gdf tender sub fpp reg detailses (not inclusive)
	 * @return the range of gdf tender sub fpp reg detailses
	 */
	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails>
			getGDFTenderSubFPPRegDetailses(int start, int end) {

		return getService().getGDFTenderSubFPPRegDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender sub fpp reg detailses.
	 *
	 * @return the number of gdf tender sub fpp reg detailses
	 */
	public static int getGDFTenderSubFPPRegDetailsesCount() {
		return getService().getGDFTenderSubFPPRegDetailsesCount();
	}

	public static java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails>
			getGDFTendRefDetailsSubFPPRegByUserId(
				String tenderReferenceNumber, long userId) {

		return getService().getGDFTendRefDetailsSubFPPRegByUserId(
			tenderReferenceNumber, userId);
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
	 * Updates the gdf tender sub fpp reg details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPRegDetails the gdf tender sub fpp reg details
	 * @return the gdf tender sub fpp reg details that was updated
	 */
	public static com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
		updateGDFTenderSubFPPRegDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails
				gdfTenderSubFPPRegDetails) {

		return getService().updateGDFTenderSubFPPRegDetails(
			gdfTenderSubFPPRegDetails);
	}

	public static GDFTenderSubFPPRegDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GDFTenderSubFPPRegDetailsLocalService,
		 GDFTenderSubFPPRegDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GDFTenderSubFPPRegDetailsLocalService.class);

		ServiceTracker
			<GDFTenderSubFPPRegDetailsLocalService,
			 GDFTenderSubFPPRegDetailsLocalService> serviceTracker =
				new ServiceTracker
					<GDFTenderSubFPPRegDetailsLocalService,
					 GDFTenderSubFPPRegDetailsLocalService>(
						 bundle.getBundleContext(),
						 GDFTenderSubFPPRegDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}