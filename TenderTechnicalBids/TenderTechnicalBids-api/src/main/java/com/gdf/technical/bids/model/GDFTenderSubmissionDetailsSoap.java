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
public class GDFTenderSubmissionDetailsSoap implements Serializable {

	public static GDFTenderSubmissionDetailsSoap toSoapModel(
		GDFTenderSubmissionDetails model) {

		GDFTenderSubmissionDetailsSoap soapModel =
			new GDFTenderSubmissionDetailsSoap();

		soapModel.setTenderSubRefID(model.getTenderSubRefID());
		soapModel.setTenderReferenceNumber(model.getTenderReferenceNumber());
		soapModel.setCopyOfRegCert(model.getCopyOfRegCert());
		soapModel.setSupplierName(model.getSupplierName());
		soapModel.setNameOfAuthRepr(model.getNameOfAuthRepr());
		soapModel.setSupplierTitle(model.getSupplierTitle());
		soapModel.setSupplierEmailAddress(model.getSupplierEmailAddress());
		soapModel.setSupplierTelephoneNumber(
			model.getSupplierTelephoneNumber());
		soapModel.setTenderSubmissionStatus(model.getTenderSubmissionStatus());
		soapModel.setSupplierId(model.getSupplierId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSubmittedDate(model.getSubmittedDate());

		return soapModel;
	}

	public static GDFTenderSubmissionDetailsSoap[] toSoapModels(
		GDFTenderSubmissionDetails[] models) {

		GDFTenderSubmissionDetailsSoap[] soapModels =
			new GDFTenderSubmissionDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubmissionDetailsSoap[][] toSoapModels(
		GDFTenderSubmissionDetails[][] models) {

		GDFTenderSubmissionDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GDFTenderSubmissionDetailsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new GDFTenderSubmissionDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GDFTenderSubmissionDetailsSoap[] toSoapModels(
		List<GDFTenderSubmissionDetails> models) {

		List<GDFTenderSubmissionDetailsSoap> soapModels =
			new ArrayList<GDFTenderSubmissionDetailsSoap>(models.size());

		for (GDFTenderSubmissionDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GDFTenderSubmissionDetailsSoap[soapModels.size()]);
	}

	public GDFTenderSubmissionDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _tenderSubRefID;
	}

	public void setPrimaryKey(long pk) {
		setTenderSubRefID(pk);
	}

	public long getTenderSubRefID() {
		return _tenderSubRefID;
	}

	public void setTenderSubRefID(long tenderSubRefID) {
		_tenderSubRefID = tenderSubRefID;
	}

	public String getTenderReferenceNumber() {
		return _tenderReferenceNumber;
	}

	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		_tenderReferenceNumber = tenderReferenceNumber;
	}

	public String getCopyOfRegCert() {
		return _copyOfRegCert;
	}

	public void setCopyOfRegCert(String copyOfRegCert) {
		_copyOfRegCert = copyOfRegCert;
	}

	public String getSupplierName() {
		return _supplierName;
	}

	public void setSupplierName(String supplierName) {
		_supplierName = supplierName;
	}

	public String getNameOfAuthRepr() {
		return _nameOfAuthRepr;
	}

	public void setNameOfAuthRepr(String nameOfAuthRepr) {
		_nameOfAuthRepr = nameOfAuthRepr;
	}

	public String getSupplierTitle() {
		return _supplierTitle;
	}

	public void setSupplierTitle(String supplierTitle) {
		_supplierTitle = supplierTitle;
	}

	public String getSupplierEmailAddress() {
		return _supplierEmailAddress;
	}

	public void setSupplierEmailAddress(String supplierEmailAddress) {
		_supplierEmailAddress = supplierEmailAddress;
	}

	public String getSupplierTelephoneNumber() {
		return _supplierTelephoneNumber;
	}

	public void setSupplierTelephoneNumber(String supplierTelephoneNumber) {
		_supplierTelephoneNumber = supplierTelephoneNumber;
	}

	public String getTenderSubmissionStatus() {
		return _tenderSubmissionStatus;
	}

	public void setTenderSubmissionStatus(String tenderSubmissionStatus) {
		_tenderSubmissionStatus = tenderSubmissionStatus;
	}

	public long getSupplierId() {
		return _supplierId;
	}

	public void setSupplierId(long supplierId) {
		_supplierId = supplierId;
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

	public Date getSubmittedDate() {
		return _submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		_submittedDate = submittedDate;
	}

	private long _tenderSubRefID;
	private String _tenderReferenceNumber;
	private String _copyOfRegCert;
	private String _supplierName;
	private String _nameOfAuthRepr;
	private String _supplierTitle;
	private String _supplierEmailAddress;
	private String _supplierTelephoneNumber;
	private String _tenderSubmissionStatus;
	private long _supplierId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _submittedDate;

}