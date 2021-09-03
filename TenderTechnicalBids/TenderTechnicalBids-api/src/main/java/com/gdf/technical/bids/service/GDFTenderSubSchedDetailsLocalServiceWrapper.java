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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GDFTenderSubSchedDetailsLocalService}.
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetailsLocalService
 * @generated
 */
public class GDFTenderSubSchedDetailsLocalServiceWrapper
	implements GDFTenderSubSchedDetailsLocalService,
			   ServiceWrapper<GDFTenderSubSchedDetailsLocalService> {

	public GDFTenderSubSchedDetailsLocalServiceWrapper(
		GDFTenderSubSchedDetailsLocalService
			gdfTenderSubSchedDetailsLocalService) {

		_gdfTenderSubSchedDetailsLocalService =
			gdfTenderSubSchedDetailsLocalService;
	}

	/**
	 * Adds the gdf tender sub sched details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was added
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		addGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return _gdfTenderSubSchedDetailsLocalService.
			addGDFTenderSubSchedDetails(gdfTenderSubSchedDetails);
	}

	/**
	 * Creates a new gdf tender sub sched details with the primary key. Does not add the gdf tender sub sched details to the database.
	 *
	 * @param tenderSubSchedRefID the primary key for the new gdf tender sub sched details
	 * @return the new gdf tender sub sched details
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		createGDFTenderSubSchedDetails(long tenderSubSchedRefID) {

		return _gdfTenderSubSchedDetailsLocalService.
			createGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	/**
	 * Deletes the gdf tender sub sched details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		deleteGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return _gdfTenderSubSchedDetailsLocalService.
			deleteGDFTenderSubSchedDetails(gdfTenderSubSchedDetails);
	}

	/**
	 * Deletes the gdf tender sub sched details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was removed
	 * @throws PortalException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
			deleteGDFTenderSubSchedDetails(long tenderSubSchedRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubSchedDetailsLocalService.
			deleteGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubSchedDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gdfTenderSubSchedDetailsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _gdfTenderSubSchedDetailsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _gdfTenderSubSchedDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _gdfTenderSubSchedDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _gdfTenderSubSchedDetailsLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _gdfTenderSubSchedDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		fetchGDFTenderSubSchedDetails(long tenderSubSchedRefID) {

		return _gdfTenderSubSchedDetailsLocalService.
			fetchGDFTenderSubSchedDetails(tenderSubSchedRefID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gdfTenderSubSchedDetailsLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the gdf tender sub sched details with the primary key.
	 *
	 * @param tenderSubSchedRefID the primary key of the gdf tender sub sched details
	 * @return the gdf tender sub sched details
	 * @throws PortalException if a gdf tender sub sched details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
			getGDFTenderSubSchedDetails(long tenderSubSchedRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubSchedDetailsLocalService.
			getGDFTenderSubSchedDetails(tenderSubSchedRefID);
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
	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderSubSchedDetails>
		getGDFTenderSubSchedDetailses(int start, int end) {

		return _gdfTenderSubSchedDetailsLocalService.
			getGDFTenderSubSchedDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender sub sched detailses.
	 *
	 * @return the number of gdf tender sub sched detailses
	 */
	@Override
	public int getGDFTenderSubSchedDetailsesCount() {
		return _gdfTenderSubSchedDetailsLocalService.
			getGDFTenderSubSchedDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gdfTenderSubSchedDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gdfTenderSubSchedDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubSchedDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the gdf tender sub sched details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubSchedDetails the gdf tender sub sched details
	 * @return the gdf tender sub sched details that was updated
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubSchedDetails
		updateGDFTenderSubSchedDetails(
			com.gdf.technical.bids.model.GDFTenderSubSchedDetails
				gdfTenderSubSchedDetails) {

		return _gdfTenderSubSchedDetailsLocalService.
			updateGDFTenderSubSchedDetails(gdfTenderSubSchedDetails);
	}

	@Override
	public GDFTenderSubSchedDetailsLocalService getWrappedService() {
		return _gdfTenderSubSchedDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		GDFTenderSubSchedDetailsLocalService
			gdfTenderSubSchedDetailsLocalService) {

		_gdfTenderSubSchedDetailsLocalService =
			gdfTenderSubSchedDetailsLocalService;
	}

	private GDFTenderSubSchedDetailsLocalService
		_gdfTenderSubSchedDetailsLocalService;

}