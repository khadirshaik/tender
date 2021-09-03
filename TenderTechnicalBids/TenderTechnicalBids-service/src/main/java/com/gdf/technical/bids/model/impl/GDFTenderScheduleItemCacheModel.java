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

import com.gdf.technical.bids.model.GDFTenderScheduleItem;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderScheduleItem in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderScheduleItemCacheModel
	implements CacheModel<GDFTenderScheduleItem>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderScheduleItemCacheModel)) {
			return false;
		}

		GDFTenderScheduleItemCacheModel gdfTenderScheduleItemCacheModel =
			(GDFTenderScheduleItemCacheModel)obj;

		if (tenderItemRefID ==
				gdfTenderScheduleItemCacheModel.tenderItemRefID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderItemRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{tenderItemRefID=");
		sb.append(tenderItemRefID);
		sb.append(", tenderItemNumber=");
		sb.append(tenderItemNumber);
		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);
		sb.append(", generalDescription=");
		sb.append(generalDescription);
		sb.append(", primaryPackaging=");
		sb.append(primaryPackaging);
		sb.append(", secondaryPackaging=");
		sb.append(secondaryPackaging);
		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", scheduleName=");
		sb.append(scheduleName);
		sb.append(", patientTarget=");
		sb.append(patientTarget);
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
	public GDFTenderScheduleItem toEntityModel() {
		GDFTenderScheduleItemImpl gdfTenderScheduleItemImpl =
			new GDFTenderScheduleItemImpl();

		gdfTenderScheduleItemImpl.setTenderItemRefID(tenderItemRefID);
		gdfTenderScheduleItemImpl.setTenderItemNumber(tenderItemNumber);
		gdfTenderScheduleItemImpl.setScheduleNumber(scheduleNumber);

		if (generalDescription == null) {
			gdfTenderScheduleItemImpl.setGeneralDescription("");
		}
		else {
			gdfTenderScheduleItemImpl.setGeneralDescription(generalDescription);
		}

		if (primaryPackaging == null) {
			gdfTenderScheduleItemImpl.setPrimaryPackaging("");
		}
		else {
			gdfTenderScheduleItemImpl.setPrimaryPackaging(primaryPackaging);
		}

		if (secondaryPackaging == null) {
			gdfTenderScheduleItemImpl.setSecondaryPackaging("");
		}
		else {
			gdfTenderScheduleItemImpl.setSecondaryPackaging(secondaryPackaging);
		}

		if (gdfGenericCode == null) {
			gdfTenderScheduleItemImpl.setGdfGenericCode("");
		}
		else {
			gdfTenderScheduleItemImpl.setGdfGenericCode(gdfGenericCode);
		}

		if (tenderReferenceNumber == null) {
			gdfTenderScheduleItemImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderScheduleItemImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (scheduleName == null) {
			gdfTenderScheduleItemImpl.setScheduleName("");
		}
		else {
			gdfTenderScheduleItemImpl.setScheduleName(scheduleName);
		}

		if (patientTarget == null) {
			gdfTenderScheduleItemImpl.setPatientTarget("");
		}
		else {
			gdfTenderScheduleItemImpl.setPatientTarget(patientTarget);
		}

		gdfTenderScheduleItemImpl.setUserId(userId);

		if (userName == null) {
			gdfTenderScheduleItemImpl.setUserName("");
		}
		else {
			gdfTenderScheduleItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderScheduleItemImpl.setCreateDate(null);
		}
		else {
			gdfTenderScheduleItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderScheduleItemImpl.setModifiedDate(null);
		}
		else {
			gdfTenderScheduleItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		gdfTenderScheduleItemImpl.resetOriginalValues();

		return gdfTenderScheduleItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderItemRefID = objectInput.readLong();

		tenderItemNumber = objectInput.readLong();

		scheduleNumber = objectInput.readLong();
		generalDescription = objectInput.readUTF();
		primaryPackaging = objectInput.readUTF();
		secondaryPackaging = objectInput.readUTF();
		gdfGenericCode = objectInput.readUTF();
		tenderReferenceNumber = objectInput.readUTF();
		scheduleName = objectInput.readUTF();
		patientTarget = objectInput.readUTF();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderItemRefID);

		objectOutput.writeLong(tenderItemNumber);

		objectOutput.writeLong(scheduleNumber);

		if (generalDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(generalDescription);
		}

		if (primaryPackaging == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryPackaging);
		}

		if (secondaryPackaging == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondaryPackaging);
		}

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

	public long tenderItemRefID;
	public long tenderItemNumber;
	public long scheduleNumber;
	public String generalDescription;
	public String primaryPackaging;
	public String secondaryPackaging;
	public String gdfGenericCode;
	public String tenderReferenceNumber;
	public String scheduleName;
	public String patientTarget;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}