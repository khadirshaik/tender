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
public class GDFTenderScheduleItemSoap implements Serializable {

	public static GDFTenderScheduleItemSoap toSoapModel(
		GDFTenderScheduleItem model) {

		GDFTenderScheduleItemSoap soapModel = new GDFTenderScheduleItemSoap();

		soapModel.setTenderItemRefID(model.getTenderItemRefID());
		soapModel.setTenderItemNumber(model.getTenderItemNumber());
		soapModel.setScheduleNumber(model.getScheduleNumber());
		soapModel.setGeneralDescription(model.getGeneralDescription());
		soapModel.setPrimaryPackaging(model.getPrimaryPackaging());
		soapModel.setSecondaryPackaging(model.getSecondaryPackaging());
		soapModel.setGdfGenericCode(model.getGdfGenericCode());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setScheduleName(model.getScheduleName());
		soapModel.setPatientTarget(model.getPatientTarget());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GDFTenderScheduleItemSoap[] toSoapModels(
		GDFTenderScheduleItem[] models) {

		GDFTenderScheduleItemSoap[] soapModels =
			new GDFTenderScheduleItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderScheduleItemSoap[][] toSoapModels(
		GDFTenderScheduleItem[][] models) {

		GDFTenderScheduleItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderScheduleItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderScheduleItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderScheduleItemSoap[] toSoapModels(
		List<GDFTenderScheduleItem> models) {

		List<GDFTenderScheduleItemSoap> soapModels =
			new ArrayList<GDFTenderScheduleItemSoap>(models.size());

		for (GDFTenderScheduleItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GDFTenderScheduleItemSoap[soapModels.size()]);
	}

	public GDFTenderScheduleItemSoap() {
	}

	public long getPrimaryKey() {
		return _tenderItemRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderItemRefID(pk);
	}

	public long getTenderItemRefID() {
		return _tenderItemRefID;
	}

	public void setTenderItemRefID(long tenderItemRefID) {
		_tenderItemRefID = tenderItemRefID;
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

	public String getGeneralDescription() {
		return _generalDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		_generalDescription = generalDescription;
	}

	public String getPrimaryPackaging() {
		return _primaryPackaging;
	}

	public void setPrimaryPackaging(String primaryPackaging) {
		_primaryPackaging = primaryPackaging;
	}

	public String getSecondaryPackaging() {
		return _secondaryPackaging;
	}

	public void setSecondaryPackaging(String secondaryPackaging) {
		_secondaryPackaging = secondaryPackaging;
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

	private long _tenderItemRefID;
	private long _tenderItemNumber;
	private long _scheduleNumber;
	private String _generalDescription;
	private String _primaryPackaging;
	private String _secondaryPackaging;
	private String _gdfGenericCode;
	private String _tenderReferenceNumber;
	private String _scheduleName;
	private String _patientTarget;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}