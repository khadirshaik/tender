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
 * Provides a wrapper for {@link GDFTenderScheduleItemLocalService}.
 *
 * @author KS61374
 * @see GDFTenderScheduleItemLocalService
 * @generated
 */
public class GDFTenderScheduleItemLocalServiceWrapper
	implements GDFTenderScheduleItemLocalService,
			   ServiceWrapper<GDFTenderScheduleItemLocalService> {

	public GDFTenderScheduleItemLocalServiceWrapper(
		GDFTenderScheduleItemLocalService gdfTenderScheduleItemLocalService) {

		_gdfTenderScheduleItemLocalService = gdfTenderScheduleItemLocalService;
	}

	/**
	 * Adds the gdf tender schedule item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 * @return the gdf tender schedule item that was added
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
		addGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return _gdfTenderScheduleItemLocalService.addGDFTenderScheduleItem(
			gdfTenderScheduleItem);
	}

	/**
	 * Creates a new gdf tender schedule item with the primary key. Does not add the gdf tender schedule item to the database.
	 *
	 * @param tenderItemRefID the primary key for the new gdf tender schedule item
	 * @return the new gdf tender schedule item
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
		createGDFTenderScheduleItem(long tenderItemRefID) {

		return _gdfTenderScheduleItemLocalService.createGDFTenderScheduleItem(
			tenderItemRefID);
	}

	/**
	 * Deletes the gdf tender schedule item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gdfTenderScheduleItem the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
		deleteGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return _gdfTenderScheduleItemLocalService.deleteGDFTenderScheduleItem(
			gdfTenderScheduleItem);
	}

	/**
	 * Deletes the gdf tender schedule item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item that was removed
	 * @throws PortalException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
			deleteGDFTenderScheduleItem(long tenderItemRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderScheduleItemLocalService.deleteGDFTenderScheduleItem(
			tenderItemRefID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderScheduleItemLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gdfTenderScheduleItemLocalService.dynamicQuery();
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

		return _gdfTenderScheduleItemLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _gdfTenderScheduleItemLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _gdfTenderScheduleItemLocalService.dynamicQuery(
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

		return _gdfTenderScheduleItemLocalService.dynamicQueryCount(
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

		return _gdfTenderScheduleItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
		fetchGDFTenderScheduleItem(long tenderItemRefID) {

		return _gdfTenderScheduleItemLocalService.fetchGDFTenderScheduleItem(
			tenderItemRefID);
	}

	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderScheduleItem>
			findByTenderItemByGenCodeAndSchedNo(
				String tenderReferenceNumber, long tenderItemNumber,
				long scheduleNumber, String gdfGenericCode)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return _gdfTenderScheduleItemLocalService.
			findByTenderItemByGenCodeAndSchedNo(
				tenderReferenceNumber, tenderItemNumber, scheduleNumber,
				gdfGenericCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gdfTenderScheduleItemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the gdf tender schedule item with the primary key.
	 *
	 * @param tenderItemRefID the primary key of the gdf tender schedule item
	 * @return the gdf tender schedule item
	 * @throws PortalException if a gdf tender schedule item with the primary key could not be found
	 */
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
			getGDFTenderScheduleItem(long tenderItemRefID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderScheduleItemLocalService.getGDFTenderScheduleItem(
			tenderItemRefID);
	}

	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderScheduleItem>
			getGDFTenderScheduleItemByItemNumberAndUserId(
				long tenderItemNumber, long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderScheduleItemLocalService.
			getGDFTenderScheduleItemByItemNumberAndUserId(
				tenderItemNumber, userId);
	}

	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderScheduleItem>
			getGDFTenderScheduleItemByTenderRefNumber(
				String tenderReferenceNumber)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderScheduleItemLocalService.
			getGDFTenderScheduleItemByTenderRefNumber(tenderReferenceNumber);
	}

	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderScheduleItem>
			getGDFTenderScheduleItemByTenderRefNumberAndUserId(
				String tenderReferenceNumber, long userId)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderDetailsException {

		return _gdfTenderScheduleItemLocalService.
			getGDFTenderScheduleItemByTenderRefNumberAndUserId(
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
	@Override
	public java.util.List<com.gdf.technical.bids.model.GDFTenderScheduleItem>
		getGDFTenderScheduleItems(int start, int end) {

		return _gdfTenderScheduleItemLocalService.getGDFTenderScheduleItems(
			start, end);
	}

	/**
	 * Returns the number of gdf tender schedule items.
	 *
	 * @return the number of gdf tender schedule items
	 */
	@Override
	public int getGDFTenderScheduleItemsCount() {
		return _gdfTenderScheduleItemLocalService.
			getGDFTenderScheduleItemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gdfTenderScheduleItemLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gdfTenderScheduleItemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gdfTenderScheduleItemLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
			getTenderItemByTenderRefNoAndScheduleNoAndGenricCode(
				String tenderReferenceNumber, long tenderItemNumber,
				long scheduleNumber, String gdfGenericCode)
		throws com.gdf.technical.bids.exception.
			NoSuchGDFTenderScheduleItemException {

		return _gdfTenderScheduleItemLocalService.
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
	@Override
	public com.gdf.technical.bids.model.GDFTenderScheduleItem
		updateGDFTenderScheduleItem(
			com.gdf.technical.bids.model.GDFTenderScheduleItem
				gdfTenderScheduleItem) {

		return _gdfTenderScheduleItemLocalService.updateGDFTenderScheduleItem(
			gdfTenderScheduleItem);
	}

	@Override
	public GDFTenderScheduleItemLocalService getWrappedService() {
		return _gdfTenderScheduleItemLocalService;
	}

	@Override
	public void setWrappedService(
		GDFTenderScheduleItemLocalService gdfTenderScheduleItemLocalService) {

		_gdfTenderScheduleItemLocalService = gdfTenderScheduleItemLocalService;
	}

	private GDFTenderScheduleItemLocalService
		_gdfTenderScheduleItemLocalService;

}