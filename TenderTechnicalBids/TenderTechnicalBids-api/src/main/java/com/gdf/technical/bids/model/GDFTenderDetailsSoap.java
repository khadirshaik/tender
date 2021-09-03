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

package com.gdf.technical.bids.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderDetailsSoap implements Serializable {

	public static GDFTenderDetailsSoap toSoapModel(GDFTenderDetails model) {
		GDFTenderDetailsSoap soapModel = new GDFTenderDetailsSoap();

		soapModel.setTenderRefID(model.getTenderRefID());
		soapModel.setProductCategory(model.getProductCategory());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setPublicationDate(model.getPublicationDate());
		soapModel.setDeadlineForTechBidsSub(model.getDeadlineForTechBidsSub());
		soapModel.setMethod(model.getMethod());
		soapModel.setTenderStatus(model.getTenderStatus());
		soapModel.setDeadlineTimeForTechBidsSub(
			model.getDeadlineTimeForTechBidsSub());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GDFTenderDetailsSoap[] toSoapModels(
		GDFTenderDetails[] models) {

		GDFTenderDetailsSoap[] soapModels =
			new GDFTenderDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderDetailsSoap[][] toSoapModels(
		GDFTenderDetails[][] models) {

		GDFTenderDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderDetailsSoap[] toSoapModels(
		List<GDFTenderDetails> models) {

		List<GDFTenderDetailsSoap> soapModels =
			new ArrayList<GDFTenderDetailsSoap>(models.size());

		for (GDFTenderDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GDFTenderDetailsSoap[soapModels.size()]);
	}

	public GDFTenderDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _tenderRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderRefID(pk);
	}

	public long getTenderRefID() {
		return _tenderRefID;
	}

	public void setTenderRefID(long tenderRefID) {
		_tenderRefID = tenderRefID;
	}

	public String getProductCategory() {
		return _productCategory;
	}

	public void setProductCategory(String productCategory) {
		_productCategory = productCategory;
	}

	public String getTenderReferenceNumber() {
		return _tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		_tenderReferenceNumber = tenderReferenceNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getPublicationDate() {
		return _publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	public Date getDeadlineForTechBidsSub() {
		return _deadlineForTechBidsSub;
	}

	public void setDeadlineForTechBidsSub(Date deadlineForTechBidsSub) {
		_deadlineForTechBidsSub = deadlineForTechBidsSub;
	}

	public String getMethod() {
		return _method;
	}

	public void setMethod(String method) {
		_method = method;
	}

	public String getTenderStatus() {
		return _tenderStatus;
	}

	public void setTenderStatus(String tenderStatus) {
		_tenderStatus = tenderStatus;
	}

	public Date getDeadlineTimeForTechBidsSub() {
		return _deadlineTimeForTechBidsSub;
	}

	public void setDeadlineTimeForTechBidsSub(Date deadlineTimeForTechBidsSub) {
		_deadlineTimeForTechBidsSub = deadlineTimeForTechBidsSub;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _tenderRefID;
	private String _productCategory;
	private String _tenderReferenceNumber;
	private String _title;
	private Date _publicationDate;
	private Date _deadlineForTechBidsSub;
	private String _method;
	private String _tenderStatus;
	private Date _deadlineTimeForTechBidsSub;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}