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

package com.gdf.technical.bids.model.impl;

import com.gdf.technical.bids.model.GDFTenderSubmissionDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderSubmissionDetails in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderSubmissionDetailsCacheModel
	implements CacheModel<GDFTenderSubmissionDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderSubmissionDetailsCacheModel)) {
			return false;
		}

		GDFTenderSubmissionDetailsCacheModel
			gdfTenderSubmissionDetailsCacheModel =
				(GDFTenderSubmissionDetailsCacheModel)obj;

		if (tenderSubRefID ==
				gdfTenderSubmissionDetailsCacheModel.tenderSubRefID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderSubRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tenderSubRefID=");
		sb.append(tenderSubRefID);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", copyOfRegCert=");
		sb.append(copyOfRegCert);
		sb.append(", supplierName=");
		sb.append(supplierName);
		sb.append(", nameOfAuthRepr=");
		sb.append(nameOfAuthRepr);
		sb.append(", supplierTitle=");
		sb.append(supplierTitle);
		sb.append(", supplierEmailAddress=");
		sb.append(supplierEmailAddress);
		sb.append(", supplierTelephoneNumber=");
		sb.append(supplierTelephoneNumber);
		sb.append(", tenderSubmissionStatus=");
		sb.append(tenderSubmissionStatus);
		sb.append(", supplierId=");
		sb.append(supplierId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GDFTenderSubmissionDetails toEntityModel() {
		GDFTenderSubmissionDetailsImpl gdfTenderSubmissionDetailsImpl =
			new GDFTenderSubmissionDetailsImpl();

		gdfTenderSubmissionDetailsImpl.setTenderSubRefID(tenderSubRefID);

		if (tenderReferenceNumber == null) {
			gdfTenderSubmissionDetailsImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (copyOfRegCert == null) {
			gdfTenderSubmissionDetailsImpl.setCopyOfRegCert("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setCopyOfRegCert(copyOfRegCert);
		}

		if (supplierName == null) {
			gdfTenderSubmissionDetailsImpl.setSupplierName("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setSupplierName(supplierName);
		}

		if (nameOfAuthRepr == null) {
			gdfTenderSubmissionDetailsImpl.setNameOfAuthRepr("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setNameOfAuthRepr(nameOfAuthRepr);
		}

		if (supplierTitle == null) {
			gdfTenderSubmissionDetailsImpl.setSupplierTitle("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setSupplierTitle(supplierTitle);
		}

		if (supplierEmailAddress == null) {
			gdfTenderSubmissionDetailsImpl.setSupplierEmailAddress("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setSupplierEmailAddress(
				supplierEmailAddress);
		}

		if (supplierTelephoneNumber == null) {
			gdfTenderSubmissionDetailsImpl.setSupplierTelephoneNumber("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setSupplierTelephoneNumber(
				supplierTelephoneNumber);
		}

		if (tenderSubmissionStatus == null) {
			gdfTenderSubmissionDetailsImpl.setTenderSubmissionStatus("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setTenderSubmissionStatus(
				tenderSubmissionStatus);
		}

		gdfTenderSubmissionDetailsImpl.setSupplierId(supplierId);

		if (userName == null) {
			gdfTenderSubmissionDetailsImpl.setUserName("");
		}
		else {
			gdfTenderSubmissionDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderSubmissionDetailsImpl.setCreateDate(null);
		}
		else {
			gdfTenderSubmissionDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderSubmissionDetailsImpl.setModifiedDate(null);
		}
		else {
			gdfTenderSubmissionDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (submittedDate == Long.MIN_VALUE) {
			gdfTenderSubmissionDetailsImpl.setSubmittedDate(null);
		}
		else {
			gdfTenderSubmissionDetailsImpl.setSubmittedDate(
				new Date(submittedDate));
		}

		gdfTenderSubmissionDetailsImpl.resetOriginalValues();

		return gdfTenderSubmissionDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderSubRefID = objectInput.readLong();
		tenderReferenceNumber = objectInput.readUTF();
		copyOfRegCert = objectInput.readUTF();
		supplierName = objectInput.readUTF();
		nameOfAuthRepr = objectInput.readUTF();
		supplierTitle = objectInput.readUTF();
		supplierEmailAddress = objectInput.readUTF();
		supplierTelephoneNumber = objectInput.readUTF();
		tenderSubmissionStatus = objectInput.readUTF();

		supplierId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		submittedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderSubRefID);

		if (tenderReferenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenderReferenceNumber);
		}

		if (copyOfRegCert == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(copyOfRegCert);
		}

		if (supplierName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supplierName);
		}

		if (nameOfAuthRepr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameOfAuthRepr);
		}

		if (supplierTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supplierTitle);
		}

		if (supplierEmailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supplierEmailAddress);
		}

		if (supplierTelephoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supplierTelephoneNumber);
		}

		if (tenderSubmissionStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenderSubmissionStatus);
		}

		objectOutput.writeLong(supplierId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(submittedDate);
	}

	public long tenderSubRefID;
	public String tenderReferenceNumber;
	public String copyOfRegCert;
	public String supplierName;
	public String nameOfAuthRepr;
	public String supplierTitle;
	public String supplierEmailAddress;
	public String supplierTelephoneNumber;
	public String tenderSubmissionStatus;
	public long supplierId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long submittedDate;

}