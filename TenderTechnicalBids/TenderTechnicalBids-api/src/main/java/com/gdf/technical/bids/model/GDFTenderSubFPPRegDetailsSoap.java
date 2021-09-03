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
public class GDFTenderSubFPPRegDetailsSoap implements Serializable {

	public static GDFTenderSubFPPRegDetailsSoap toSoapModel(
		GDFTenderSubFPPRegDetails model) {

		GDFTenderSubFPPRegDetailsSoap soapModel =
			new GDFTenderSubFPPRegDetailsSoap();

		soapModel.setTenderRegRefID(model.getTenderRegRefID());
		soapModel.setScheduleNumber(model.getScheduleNumber());
		soapModel.setGdfGenericCode(model.getGdfGenericCode());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setListOfRegCountries(model.getListOfRegCountries());
		soapModel.setFppRegApprStatus(model.getFppRegApprStatus());
		soapModel.setFppRegAccepted(model.isFppRegAccepted());
		soapModel.setFppRegistrationId(model.getFppRegistrationId());
		soapModel.setTenderItemMatRefID(model.getTenderItemMatRefID());
		soapModel.setTenderItemRefID(model.getTenderItemRefID());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GDFTenderSubFPPRegDetailsSoap[] toSoapModels(
		GDFTenderSubFPPRegDetails[] models) {

		GDFTenderSubFPPRegDetailsSoap[] soapModels =
			new GDFTenderSubFPPRegDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubFPPRegDetailsSoap[][] toSoapModels(
		GDFTenderSubFPPRegDetails[][] models) {

		GDFTenderSubFPPRegDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderSubFPPRegDetailsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderSubFPPRegDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubFPPRegDetailsSoap[] toSoapModels(
		List<GDFTenderSubFPPRegDetails> models) {

		List<GDFTenderSubFPPRegDetailsSoap> soapModels =
			new ArrayList<GDFTenderSubFPPRegDetailsSoap>(models.size());

		for (GDFTenderSubFPPRegDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GDFTenderSubFPPRegDetailsSoap[soapModels.size()]);
	}

	public GDFTenderSubFPPRegDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _tenderRegRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderRegRefID(pk);
	}

	public long getTenderRegRefID() {
		return _tenderRegRefID;
	}

	public void setTenderRegRefID(long tenderRegRefID) {
		_tenderRegRefID = tenderRegRefID;
	}

	public long getScheduleNumber() {
		return _scheduleNumber;
	}

	public void setScheduleNumber(long scheduleNumber) {
		_scheduleNumber = scheduleNumber;
	}

	public String getGdfGenericCode() {
		return _gdfGenericCode;
	}

	public void setGdfGenericCode(String gdfGenericCode) {
		_gdfGenericCode = gdfGenericCode;
	}

	public String getTenderReferenceNumber() {
		return _tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		_tenderReferenceNumber = tenderReferenceNumber;
	}

	public String getListOfRegCountries() {
		return _listOfRegCountries;
	}

	public void setListOfRegCountries(String listOfRegCountries) {
		_listOfRegCountries = listOfRegCountries;
	}

	public String getFppRegApprStatus() {
		return _fppRegApprStatus;
	}

	public void setFppRegApprStatus(String fppRegApprStatus) {
		_fppRegApprStatus = fppRegApprStatus;
	}

	public boolean getFppRegAccepted() {
		return _fppRegAccepted;
	}

	public boolean isFppRegAccepted() {
		return _fppRegAccepted;
	}

	public void setFppRegAccepted(boolean fppRegAccepted) {
		_fppRegAccepted = fppRegAccepted;
	}

	public long getFppRegistrationId() {
		return _fppRegistrationId;
	}

	public void setFppRegistrationId(long fppRegistrationId) {
		_fppRegistrationId = fppRegistrationId;
	}

	public long getTenderItemMatRefID() {
		return _tenderItemMatRefID;
	}

	public void setTenderItemMatRefID(long tenderItemMatRefID) {
		_tenderItemMatRefID = tenderItemMatRefID;
	}

	public long getTenderItemRefID() {
		return _tenderItemRefID;
	}

	public void setTenderItemRefID(long tenderItemRefID) {
		_tenderItemRefID = tenderItemRefID;
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

	private long _tenderRegRefID;
	private long _scheduleNumber;
	private String _gdfGenericCode;
	private String _tenderReferenceNumber;
	private String _listOfRegCountries;
	private String _fppRegApprStatus;
	private boolean _fppRegAccepted;
	private long _fppRegistrationId;
	private long _tenderItemMatRefID;
	private long _tenderItemRefID;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}