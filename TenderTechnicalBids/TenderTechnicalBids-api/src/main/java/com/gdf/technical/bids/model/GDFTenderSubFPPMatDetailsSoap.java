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
public class GDFTenderSubFPPMatDetailsSoap implements Serializable {

	public static GDFTenderSubFPPMatDetailsSoap toSoapModel(
		GDFTenderSubFPPMatDetails model) {

		GDFTenderSubFPPMatDetailsSoap soapModel =
			new GDFTenderSubFPPMatDetailsSoap();

		soapModel.setTenderItemMatRefID(model.getTenderItemMatRefID());
		soapModel.setScheduleNumber(model.getScheduleNumber());
		soapModel.setGdfGenericCode(model.getGdfGenericCode());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setDosageForm(model.getDosageForm());
		soapModel.setNoPrimPackageUnits(model.getNoPrimPackageUnits());
		soapModel.setNoSecPackageUnits(model.getNoSecPackageUnits());
		soapModel.setGdfFppMartApprStatus(model.getGdfFppMartApprStatus());
		soapModel.setFppSelectedStatus(model.isFppSelectedStatus());
		soapModel.setFppMarketID(model.getFppMarketID());
		soapModel.setTenderItemRefID(model.getTenderItemRefID());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GDFTenderSubFPPMatDetailsSoap[] toSoapModels(
		GDFTenderSubFPPMatDetails[] models) {

		GDFTenderSubFPPMatDetailsSoap[] soapModels =
			new GDFTenderSubFPPMatDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubFPPMatDetailsSoap[][] toSoapModels(
		GDFTenderSubFPPMatDetails[][] models) {

		GDFTenderSubFPPMatDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderSubFPPMatDetailsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderSubFPPMatDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubFPPMatDetailsSoap[] toSoapModels(
		List<GDFTenderSubFPPMatDetails> models) {

		List<GDFTenderSubFPPMatDetailsSoap> soapModels =
			new ArrayList<GDFTenderSubFPPMatDetailsSoap>(models.size());

		for (GDFTenderSubFPPMatDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GDFTenderSubFPPMatDetailsSoap[soapModels.size()]);
	}

	public GDFTenderSubFPPMatDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _tenderItemMatRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderItemMatRefID(pk);
	}

	public long getTenderItemMatRefID() {
		return _tenderItemMatRefID;
	}

	public void setTenderItemMatRefID(long tenderItemMatRefID) {
		_tenderItemMatRefID = tenderItemMatRefID;
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

	public String getDosageForm() {
		return _dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		_dosageForm = dosageForm;
	}

	public long getNoPrimPackageUnits() {
		return _noPrimPackageUnits;
	}

	public void setNoPrimPackageUnits(long noPrimPackageUnits) {
		_noPrimPackageUnits = noPrimPackageUnits;
	}

	public long getNoSecPackageUnits() {
		return _noSecPackageUnits;
	}

	public void setNoSecPackageUnits(long noSecPackageUnits) {
		_noSecPackageUnits = noSecPackageUnits;
	}

	public String getGdfFppMartApprStatus() {
		return _gdfFppMartApprStatus;
	}

	public void setGdfFppMartApprStatus(String gdfFppMartApprStatus) {
		_gdfFppMartApprStatus = gdfFppMartApprStatus;
	}

	public boolean getFppSelectedStatus() {
		return _fppSelectedStatus;
	}

	public boolean isFppSelectedStatus() {
		return _fppSelectedStatus;
	}

	public void setFppSelectedStatus(boolean fppSelectedStatus) {
		_fppSelectedStatus = fppSelectedStatus;
	}

	public long getFppMarketID() {
		return _fppMarketID;
	}

	public void setFppMarketID(long fppMarketID) {
		_fppMarketID = fppMarketID;
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

	private long _tenderItemMatRefID;
	private long _scheduleNumber;
	private String _gdfGenericCode;
	private String _tenderReferenceNumber;
	private String _dosageForm;
	private long _noPrimPackageUnits;
	private long _noSecPackageUnits;
	private String _gdfFppMartApprStatus;
	private boolean _fppSelectedStatus;
	private long _fppMarketID;
	private long _tenderItemRefID;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}