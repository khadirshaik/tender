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
 * Provides a wrapper for {@link GDFTenderSubmissionDetailsLocalService}.
 *
 * @author KS61374
 * @see GDFTenderSubmissionDetailsLocalService
 * @generated
 */
public class GDFTenderSubmissionDetailsLocalServiceWrapper
	implements GDFTenderSubmissionDetailsLocalService,
			   ServiceWrapper<GDFTenderSubmissionDetailsLocalService> {

	public GDFTenderSubmissionDetailsLocalServiceWrapper(
		GDFTenderSubmissionDetailsLocalService
			gdfTenderSubmissionDetailsLocalService) {

		_gdfTenderSubmissionDetailsLocalService =
			gdfTenderSubmissionDetailsLocalService;
	}

	/**
	 * Adds the gdf tender submission details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 * @return the gdf tender submission details that was added
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
		addGDFTenderSubmissionDetails(
			com.gdf.technical.bids.model.GDFTenderSubmissionDetails
				gdfTenderSubmissionDetails) {

		return _gdfTenderSubmissionDetailsLocalService.
			addGDFTenderSubmissionDetails(gdfTenderSubmissionDetails);
	}

	/**
	 * Creates a new gdf tender submission details with the primary key. Does not add the gdf tender submission details to the database.
	 *
	 * @param tenderSubRefID the primary key for the new gdf tender submission details
	 * @return the new gdf tender submission details
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
		createGDFTenderSubmissionDetails(long tenderSubRefID) {

		return _gdfTenderSubmissionDetailsLocalService.
			createGDFTenderSubmissionDetails(tenderSubRefID);
	}

	/**
	 * Deletes the gdf tender submission details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
		deleteGDFTenderSubmissionDetails(
			com.gdf.technical.bids.model.GDFTenderSubmissionDetails
				gdfTenderSubmissionDetails) {

		return _gdfTenderSubmissionDetailsLocalService.
			deleteGDFTenderSubmissionDetails(gdfTenderSubmissionDetails);
	}

	/**
	 * Deletes the gdf tender submission details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details that was removed
	 * @throws PortalException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
			deleteGDFTenderSubmissionDetails(long tenderSubRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubmissionDetailsLocalService.
			deleteGDFTenderSubmissionDetails(tenderSubRefID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubmissionDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gdfTenderSubmissionDetailsLocalService.dynamicQuery();
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

		return _gdfTenderSubmissionDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubmissionDetailsModelImpl</code>.
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

		return _gdfTenderSubmissionDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubmissionDetailsModelImpl</code>.
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

		return _gdfTenderSubmissionDetailsLocalService.dynamicQuery(
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

		return _gdfTenderSubmissionDetailsLocalService.dynamicQueryCount(
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

		return _gdfTenderSubmissionDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
		fetchGDFTenderSubmissionDetails(long tenderSubRefID) {

		return _gdfTenderSubmissionDetailsLocalService.
			fetchGDFTenderSubmissionDetails(tenderSubRefID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gdfTenderSubmissionDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
			getGDFTenderSubDetailsByTenderRefNumber(
				String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubDetailsByTenderRefNumber(tenderReferenceNumber);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
			getGDFTenderSubDetailsByTenderRefNumberAndUserId(
				String tenderReferenceNumber, long supplierId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderSubmissionDetailsException {

		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubDetailsByTenderRefNumberAndUserId(
				tenderReferenceNumber, supplierId);
	}

	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubmissionDetails>
			getGDFTenderSubDetailsByUserId(long supplierId) {

		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubDetailsByUserId(supplierId);
	}

	/**
	 * Returns the gdf tender submission details with the primary key.
	 *
	 * @param tenderSubRefID the primary key of the gdf tender submission details
	 * @return the gdf tender submission details
	 * @throws PortalException if a gdf tender submission details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
			getGDFTenderSubmissionDetails(long tenderSubRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubmissionDetails(tenderSubRefID);
	}

	/**
	 * Returns a range of all the gdf tender submission detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubmissionDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender submission detailses
	 * @param end the upper bound of the range of gdf tender submission detailses (not inclusive)
	 * @return the range of gdf tender submission detailses
	 */
	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubmissionDetails>
			getGDFTenderSubmissionDetailses(int start, int end) {

		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubmissionDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender submission detailses.
	 *
	 * @return the number of gdf tender submission detailses
	 */
	@Override
	public int getGDFTenderSubmissionDetailsesCount() {
		return _gdfTenderSubmissionDetailsLocalService.
			getGDFTenderSubmissionDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gdfTenderSubmissionDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gdfTenderSubmissionDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubmissionDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the gdf tender submission details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubmissionDetails the gdf tender submission details
	 * @return the gdf tender submission details that was updated
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubmissionDetails
		updateGDFTenderSubmissionDetails(
			com.gdf.technical.bids.model.GDFTenderSubmissionDetails
				gdfTenderSubmissionDetails) {

		return _gdfTenderSubmissionDetailsLocalService.
			updateGDFTenderSubmissionDetails(gdfTenderSubmissionDetails);
	}

	@Override
	public GDFTenderSubmissionDetailsLocalService getWrappedService() {
		return _gdfTenderSubmissionDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		GDFTenderSubmissionDetailsLocalService
			gdfTenderSubmissionDetailsLocalService) {

		_gdfTenderSubmissionDetailsLocalService =
			gdfTenderSubmissionDetailsLocalService;
	}

	private GDFTenderSubmissionDetailsLocalService
		_gdfTenderSubmissionDetailsLocalService;

}