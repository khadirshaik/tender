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

import com.gdf.technical.bids.model.GDFTenderSubFPPRegDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderSubFPPRegDetails in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderSubFPPRegDetailsCacheModel
	implements CacheModel<GDFTenderSubFPPRegDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderSubFPPRegDetailsCacheModel)) {
			return false;
		}

		GDFTenderSubFPPRegDetailsCacheModel
			gdfTenderSubFPPRegDetailsCacheModel =
				(GDFTenderSubFPPRegDetailsCacheModel)obj;

		if (tenderRegRefID ==
				gdfTenderSubFPPRegDetailsCacheModel.tenderRegRefID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderRegRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tenderRegRefID=");
		sb.append(tenderRegRefID);
		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);
		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", listOfRegCountries=");
		sb.append(listOfRegCountries);
		sb.append(", fppRegApprStatus=");
		sb.append(fppRegApprStatus);
		sb.append(", fppRegAccepted=");
		sb.append(fppRegAccepted);
		sb.append(", fppRegistrationId=");
		sb.append(fppRegistrationId);
		sb.append(", tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);
		sb.append(", tenderItemRefID=");
		sb.append(tenderItemRefID);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GDFTenderSubFPPRegDetails toEntityModel() {
		GDFTenderSubFPPRegDetailsImpl gdfTenderSubFPPRegDetailsImpl =
			new GDFTenderSubFPPRegDetailsImpl();

		gdfTenderSubFPPRegDetailsImpl.setTenderRegRefID(tenderRegRefID);
		gdfTenderSubFPPRegDetailsImpl.setScheduleNumber(scheduleNumber);

		if (gdfGenericCode == null) {
			gdfTenderSubFPPRegDetailsImpl.setGdfGenericCode("");
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setGdfGenericCode(gdfGenericCode);
		}

		if (tenderReferenceNumber == null) {
			gdfTenderSubFPPRegDetailsImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (listOfRegCountries == null) {
			gdfTenderSubFPPRegDetailsImpl.setListOfRegCountries("");
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setListOfRegCountries(
				listOfRegCountries);
		}

		if (fppRegApprStatus == null) {
			gdfTenderSubFPPRegDetailsImpl.setFppRegApprStatus("");
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setFppRegApprStatus(fppRegApprStatus);
		}

		gdfTenderSubFPPRegDetailsImpl.setFppRegAccepted(fppRegAccepted);
		gdfTenderSubFPPRegDetailsImpl.setFppRegistrationId(fppRegistrationId);
		gdfTenderSubFPPRegDetailsImpl.setTenderItemMatRefID(tenderItemMatRefID);
		gdfTenderSubFPPRegDetailsImpl.setTenderItemRefID(tenderItemRefID);
		gdfTenderSubFPPRegDetailsImpl.setUserId(userId);

		if (userName == null) {
			gdfTenderSubFPPRegDetailsImpl.setUserName("");
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderSubFPPRegDetailsImpl.setCreateDate(null);
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderSubFPPRegDetailsImpl.setModifiedDate(null);
		}
		else {
			gdfTenderSubFPPRegDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		gdfTenderSubFPPRegDetailsImpl.resetOriginalValues();

		return gdfTenderSubFPPRegDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderRegRefID = objectInput.readLong();

		scheduleNumber = objectInput.readLong();
		gdfGenericCode = objectInput.readUTF();
		tenderReferenceNumber = objectInput.readUTF();
		listOfRegCountries = objectInput.readUTF();
		fppRegApprStatus = objectInput.readUTF();

		fppRegAccepted = objectInput.readBoolean();

		fppRegistrationId = objectInput.readLong();

		tenderItemMatRefID = objectInput.readLong();

		tenderItemRefID = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderRegRefID);

		objectOutput.writeLong(scheduleNumber);

		if (gdfGenericCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gdfGenericCode);
		}

		if (tenderReferenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenderReferenceNumber);
		}

		if (listOfRegCountries == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(listOfRegCountries);
		}

		if (fppRegApprStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fppRegApprStatus);
		}

		objectOutput.writeBoolean(fppRegAccepted);

		objectOutput.writeLong(fppRegistrationId);

		objectOutput.writeLong(tenderItemMatRefID);

		objectOutput.writeLong(tenderItemRefID);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long tenderRegRefID;
	public long scheduleNumber;
	public String gdfGenericCode;
	public String tenderReferenceNumber;
	public String listOfRegCountries;
	public String fppRegApprStatus;
	public boolean fppRegAccepted;
	public long fppRegistrationId;
	public long tenderItemMatRefID;
	public long tenderItemRefID;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}