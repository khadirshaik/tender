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
 * Provides a wrapper for {@link GDFTenderSubFPPMatDetailsLocalService}.
 *
 * @author KS61374
 * @see GDFTenderSubFPPMatDetailsLocalService
 * @generated
 */
public class GDFTenderSubFPPMatDetailsLocalServiceWrapper
	implements GDFTenderSubFPPMatDetailsLocalService,
			   ServiceWrapper<GDFTenderSubFPPMatDetailsLocalService> {

	public GDFTenderSubFPPMatDetailsLocalServiceWrapper(
		GDFTenderSubFPPMatDetailsLocalService
			gdfTenderSubFPPMatDetailsLocalService) {

		_gdfTenderSubFPPMatDetailsLocalService =
			gdfTenderSubFPPMatDetailsLocalService;
	}

	/**
	 * Adds the gdf tender sub fpp mat details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was added
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
		addGDFTenderSubFPPMatDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
				gdfTenderSubFPPMatDetails) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			addGDFTenderSubFPPMatDetails(gdfTenderSubFPPMatDetails);
	}

	/**
	 * Creates a new gdf tender sub fpp mat details with the primary key. Does not add the gdf tender sub fpp mat details to the database.
	 *
	 * @param tenderItemMatRefID the primary key for the new gdf tender sub fpp mat details
	 * @return the new gdf tender sub fpp mat details
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
		createGDFTenderSubFPPMatDetails(long tenderItemMatRefID) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			createGDFTenderSubFPPMatDetails(tenderItemMatRefID);
	}

	/**
	 * Deletes the gdf tender sub fpp mat details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
		deleteGDFTenderSubFPPMatDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
				gdfTenderSubFPPMatDetails) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			deleteGDFTenderSubFPPMatDetails(gdfTenderSubFPPMatDetails);
	}

	/**
	 * Deletes the gdf tender sub fpp mat details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was removed
	 * @throws PortalException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
			deleteGDFTenderSubFPPMatDetails(long tenderItemMatRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubFPPMatDetailsLocalService.
			deleteGDFTenderSubFPPMatDetails(tenderItemMatRefID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubFPPMatDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQuery();
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

		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPMatDetailsModelImpl</code>.
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

		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPMatDetailsModelImpl</code>.
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

		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQuery(
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

		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQueryCount(
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

		return _gdfTenderSubFPPMatDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
		fetchGDFTenderSubFPPMatDetails(long tenderItemMatRefID) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			fetchGDFTenderSubFPPMatDetails(tenderItemMatRefID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails>
			getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(
				long fppMarketID, long userId, String gdfGenericCode,
				long scheduleNumber, String tenderReferenceNumber) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFByGDFTenderByFIDUIDGenCodeSNUTRN(
				fppMarketID, userId, gdfGenericCode, scheduleNumber,
				tenderReferenceNumber);
	}

	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails>
			getGDFTenderFPPMartDetailsByFppMartId(long fppMarketId) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTenderFPPMartDetailsByFppMartId(fppMarketId);
	}

	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails>
			getGDFTenderFPPMartDetailsBySelectedStatus(
				boolean fppSelectedStatus) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTenderFPPMartDetailsBySelectedStatus(fppSelectedStatus);
	}

	/**
	 * Returns the gdf tender sub fpp mat details with the primary key.
	 *
	 * @param tenderItemMatRefID the primary key of the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details
	 * @throws PortalException if a gdf tender sub fpp mat details with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
			getGDFTenderSubFPPMatDetails(long tenderItemMatRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTenderSubFPPMatDetails(tenderItemMatRefID);
	}

	/**
	 * Returns a range of all the gdf tender sub fpp mat detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPMatDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gdf tender sub fpp mat detailses
	 * @param end the upper bound of the range of gdf tender sub fpp mat detailses (not inclusive)
	 * @return the range of gdf tender sub fpp mat detailses
	 */
	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails>
			getGDFTenderSubFPPMatDetailses(int start, int end) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTenderSubFPPMatDetailses(start, end);
	}

	/**
	 * Returns the number of gdf tender sub fpp mat detailses.
	 *
	 * @return the number of gdf tender sub fpp mat detailses
	 */
	@Override
	public int getGDFTenderSubFPPMatDetailsesCount() {
		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTenderSubFPPMatDetailsesCount();
	}

	@Override
	public java.util.List
		<com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails>
			getGDFTendRefDetailsSubFPPMatByUserId(
				String tenderReferenceNumber, long userId) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getGDFTendRefDetailsSubFPPMatByUserId(
				tenderReferenceNumber, userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gdfTenderSubFPPMatDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gdfTenderSubFPPMatDetailsLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderSubFPPMatDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the gdf tender sub fpp mat details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderSubFPPMatDetails the gdf tender sub fpp mat details
	 * @return the gdf tender sub fpp mat details that was updated
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
		updateGDFTenderSubFPPMatDetails(
			com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails
				gdfTenderSubFPPMatDetails) {

		return _gdfTenderSubFPPMatDetailsLocalService.
			updateGDFTenderSubFPPMatDetails(gdfTenderSubFPPMatDetails);
	}

	@Override
	public GDFTenderSubFPPMatDetailsLocalService getWrappedService() {
		return _gdfTenderSubFPPMatDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		GDFTenderSubFPPMatDetailsLocalService
			gdfTenderSubFPPMatDetailsLocalService) {

		_gdfTenderSubFPPMatDetailsLocalService =
			gdfTenderSubFPPMatDetailsLocalService;
	}

	private GDFTenderSubFPPMatDetailsLocalService
		_gdfTenderSubFPPMatDetailsLocalService;

}