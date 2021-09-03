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
 * Provides a wrapper for {@link GDFTenderDetailsLocalService}.
 *
 * @author KS61374
 * @see GDFTenderDetailsLocalService
 * @generated
 */
public class GDFTenderDetailsLocalServiceWrapper
	implements GDFTenderDetailsLocalService,
			   ServiceWrapper<GDFTenderDetailsLocalService> {

	public GDFTenderDetailsLocalServiceWrapper(
		GDFTenderDetailsLocalService gdfTenderDetailsLocalService) {

		_gdfTenderDetailsLocalService = gdfTenderDetailsLocalService;
	}

	/**
	 * Adds the gdf tender details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 * @return the gdf tender details that was added
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails addGDFTenderDetails(
		com.gdf.technical.bids.model.GDFTenderDetails gdfTenderDetails) {

		return _gdfTenderDetailsLocalService.addGDFTenderDetails(
			gdfTenderDetails);
	}

	/**
	 * Creates a new gdf tender details with the primary key. Does not add the gdf tender details to the database.
	 *
	 * @param tenderRefID the primary key for the new gdf tender details
	 * @return the new gdf tender details
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails createGDFTenderDetails(
		long tenderRefID) {

		return _gdfTenderDetailsLocalService.createGDFTenderDetails(
			tenderRefID);
	}

	/**
	 * Deletes the gdf tender details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 * @return the gdf tender details that was removed
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails deleteGDFTenderDetails(
		com.gdf.technical.bids.model.GDFTenderDetails gdfTenderDetails) {

		return _gdfTenderDetailsLocalService.deleteGDFTenderDetails(
			gdfTenderDetails);
	}

	/**
	 * Deletes the gdf tender details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details that was removed
	 * @throws PortalException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails deleteGDFTenderDetails(
			long tenderRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderDetailsLocalService.deleteGDFTenderDetails(
			tenderRefID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gdfTenderDetailsLocalService.dynamicQuery();
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

		return _gdfTenderDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderDetailsModelImpl</code>.
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

		return _gdfTenderDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderDetailsModelImpl</code>.
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

		return _gdfTenderDetailsLocalService.dynamicQuery(
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

		return _gdfTenderDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _gdfTenderDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails fetchGDFTenderDetails(
		long tenderRefID) {

		return _gdfTenderDetailsLocalService.fetchGDFTenderDetails(tenderRefID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gdfTenderDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the gdf tender details with the primary key.
	 *
	 * @param tenderRefID the primary key of the gdf tender details
	 * @return the gdf tender details
	 * @throws PortalException if a gdf tender details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails getGDFTenderDetails(
			long tenderRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderDetailsLocalService.getGDFTenderDetails(tenderRefID);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails
			getGDFTenderDetailsByTenderRefNumber(String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderDetailsLocalService.
			getGDFTenderDetailsByTenderRefNumber(tenderReferenceNumber);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails
			getGDFTenderDetailsByTenderRefNumberAndUserId(
				String tenderReferenceNumber, long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderDetailsLocalService.
			getGDFTenderDetailsByTenderRefNumberAndUserId(
				tenderReferenceNumber, userId);
	}

	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderDetails>
			getGDFTenderDetailsByUserId(long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderDetailsLocalService.getGDFTenderDetailsByUserId(
			userId);
	}

	/**
	 * Returns a range of all the gdf tender detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender detailses
	 * @param end the upper bound of the range of gdf tender detailses (not inclusive)
	 * @return the range of gdf tender detailses
	 */
	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderDetails>
		getGDFTenderDetailses(int start, int end) {

		return _gdfTenderDetailsLocalService.getGDFTenderDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender detailses.
	 *
	 * @return the number of gdf tender detailses
	 */
	@Override
	public int getGDFTenderDetailsesCount() {
		return _gdfTenderDetailsLocalService.getGDFTenderDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gdfTenderDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gdfTenderDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the gdf tender details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderDetails the gdf tender details
	 * @return the gdf tender details that was updated
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderDetails updateGDFTenderDetails(
		com.gdf.technical.bids.model.GDFTenderDetails gdfTenderDetails) {

		return _gdfTenderDetailsLocalService.updateGDFTenderDetails(
			gdfTenderDetails);
	}

	@Override
	public GDFTenderDetailsLocalService getWrappedService() {
		return _gdfTenderDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		GDFTenderDetailsLocalService gdfTenderDetailsLocalService) {

		_gdfTenderDetailsLocalService = gdfTenderDetailsLocalService;
	}

	private GDFTenderDetailsLocalService _gdfTenderDetailsLocalService;

}