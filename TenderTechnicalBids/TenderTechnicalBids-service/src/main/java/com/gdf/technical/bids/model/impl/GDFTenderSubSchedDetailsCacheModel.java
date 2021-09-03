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

import com.gdf.technical.bids.model.GDFTenderSubSchedDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderSubSchedDetails in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderSubSchedDetailsCacheModel
	implements CacheModel<GDFTenderSubSchedDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderSubSchedDetailsCacheModel)) {
			return false;
		}

		GDFTenderSubSchedDetailsCacheModel gdfTenderSubSchedDetailsCacheModel =
			(GDFTenderSubSchedDetailsCacheModel)obj;

		if (tenderSubSchedRefID ==
				gdfTenderSubSchedDetailsCacheModel.tenderSubSchedRefID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderSubSchedRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{tenderSubSchedRefID=");
		sb.append(tenderSubSchedRefID);
		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);
		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);
		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", scheduleName=");
		sb.append(scheduleName);
		sb.append(", patientTarget=");
		sb.append(patientTarget);
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
	public GDFTenderSubSchedDetails toEntityModel() {
		GDFTenderSubSchedDetailsImpl gdfTenderSubSchedDetailsImpl =
			new GDFTenderSubSchedDetailsImpl();

		gdfTenderSubSchedDetailsImpl.setTenderSubSchedRefID(
			tenderSubSchedRefID);
		gdfTenderSubSchedDetailsImpl.setTenderItemNumber(tenderItemNumber);
		gdfTenderSubSchedDetailsImpl.setScheduleNumber(scheduleNumber);

		if (gdfGenericCode == null) {
			gdfTenderSubSchedDetailsImpl.setGdfGenericCode("");
		}
		else {
			gdfTenderSubSchedDetailsImpl.setGdfGenericCode(gdfGenericCode);
		}

		if (tenderReferenceNumber == null) {
			gdfTenderSubSchedDetailsImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderSubSchedDetailsImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (scheduleName == null) {
			gdfTenderSubSchedDetailsImpl.setScheduleName("");
		}
		else {
			gdfTenderSubSchedDetailsImpl.setScheduleName(scheduleName);
		}

		if (patientTarget == null) {
			gdfTenderSubSchedDetailsImpl.setPatientTarget("");
		}
		else {
			gdfTenderSubSchedDetailsImpl.setPatientTarget(patientTarget);
		}

		gdfTenderSubSchedDetailsImpl.setTenderItemRefID(tenderItemRefID);
		gdfTenderSubSchedDetailsImpl.setUserId(userId);

		if (userName == null) {
			gdfTenderSubSchedDetailsImpl.setUserName("");
		}
		else {
			gdfTenderSubSchedDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderSubSchedDetailsImpl.setCreateDate(null);
		}
		else {
			gdfTenderSubSchedDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderSubSchedDetailsImpl.setModifiedDate(null);
		}
		else {
			gdfTenderSubSchedDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		gdfTenderSubSchedDetailsImpl.resetOriginalValues();

		return gdfTenderSubSchedDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderSubSchedRefID = objectInput.readLong();

		tenderItemNumber = objectInput.readLong();

		scheduleNumber = objectInput.readLong();
		gdfGenericCode = objectInput.readUTF();
		tenderReferenceNumber = objectInput.readUTF();
		scheduleName = objectInput.readUTF();
		patientTarget = objectInput.readUTF();

		tenderItemRefID = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderSubSchedRefID);

		objectOutput.writeLong(tenderItemNumber);

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

		if (scheduleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scheduleName);
		}

		if (patientTarget == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patientTarget);
		}

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

	public long tenderSubSchedRefID;
	public long tenderItemNumber;
	public long scheduleNumber;
	public String gdfGenericCode;
	public String tenderReferenceNumber;
	public String scheduleName;
	public String patientTarget;
	public long tenderItemRefID;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}