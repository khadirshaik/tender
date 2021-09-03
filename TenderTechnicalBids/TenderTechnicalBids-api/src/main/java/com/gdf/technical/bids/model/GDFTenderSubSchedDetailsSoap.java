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
public class GDFTenderSubSchedDetailsSoap implements Serializable {

	public static GDFTenderSubSchedDetailsSoap toSoapModel(
		GDFTenderSubSchedDetails model) {

		GDFTenderSubSchedDetailsSoap soapModel =
			new GDFTenderSubSchedDetailsSoap();

		soapModel.setTenderSubSchedRefID(model.getTenderSubSchedRefID());
		soapModel.setTenderItemNumber(model.getTenderItemNumber());
		soapModel.setScheduleNumber(model.getScheduleNumber());
		soapModel.setGdfGenericCode(model.getGdfGenericCode());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setScheduleName(model.getScheduleName());
		soapModel.setPatientTarget(model.getPatientTarget());
		soapModel.setTenderItemRefID(model.getTenderItemRefID());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GDFTenderSubSchedDetailsSoap[] toSoapModels(
		GDFTenderSubSchedDetails[] models) {

		GDFTenderSubSchedDetailsSoap[] soapModels =
			new GDFTenderSubSchedDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubSchedDetailsSoap[][] toSoapModels(
		GDFTenderSubSchedDetails[][] models) {

		GDFTenderSubSchedDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderSubSchedDetailsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderSubSchedDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubSchedDetailsSoap[] toSoapModels(
		List<GDFTenderSubSchedDetails> models) {

		List<GDFTenderSubSchedDetailsSoap> soapModels =
			new ArrayList<GDFTenderSubSchedDetailsSoap>(models.size());

		for (GDFTenderSubSchedDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GDFTenderSubSchedDetailsSoap[soapModels.size()]);
	}

	public GDFTenderSubSchedDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _tenderSubSchedRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderSubSchedRefID(pk);
	}

	public long getTenderSubSchedRefID() {
		return _tenderSubSchedRefID;
	}

	public void setTenderSubSchedRefID(long tenderSubSchedRefID) {
		_tenderSubSchedRefID = tenderSubSchedRefID;
	}

	public long getTenderItemNumber() {
		return _tenderItemNumber;
	}

	public void setTenderItemNumber(long tenderItemNumber) {
		_tenderItemNumber = tenderItemNumber;
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

	public String getScheduleName() {
		return _scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		_scheduleName = scheduleName;
	}

	public String getPatientTarget() {
		return _patientTarget;
	}

	public void setPatientTarget(String patientTarget) {
		_patientTarget = patientTarget;
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

	private long _tenderSubSchedRefID;
	private long _tenderItemNumber;
	private long _scheduleNumber;
	private String _gdfGenericCode;
	private String _tenderReferenceNumber;
	private String _scheduleName;
	private String _patientTarget;
	private long _tenderItemRefID;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}