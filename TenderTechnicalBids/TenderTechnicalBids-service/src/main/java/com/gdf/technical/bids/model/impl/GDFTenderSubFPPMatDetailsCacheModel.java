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

import com.gdf.technical.bids.model.GDFTenderSubFPPMatDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderSubFPPMatDetails in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderSubFPPMatDetailsCacheModel
	implements CacheModel<GDFTenderSubFPPMatDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderSubFPPMatDetailsCacheModel)) {
			return false;
		}

		GDFTenderSubFPPMatDetailsCacheModel
			gdfTenderSubFPPMatDetailsCacheModel =
				(GDFTenderSubFPPMatDetailsCacheModel)obj;

		if (tenderItemMatRefID ==
				gdfTenderSubFPPMatDetailsCacheModel.tenderItemMatRefID) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderItemMatRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{tenderItemMatRefID=");
		sb.append(tenderItemMatRefID);
		sb.append(", scheduleNumber=");
		sb.append(scheduleNumber);
		sb.append(", gdfGenericCode=");
		sb.append(gdfGenericCode);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", dosageForm=");
		sb.append(dosageForm);
		sb.append(", noPrimPackageUnits=");
		sb.append(noPrimPackageUnits);
		sb.append(", noSecPackageUnits=");
		sb.append(noSecPackageUnits);
		sb.append(", gdfFppMartApprStatus=");
		sb.append(gdfFppMartApprStatus);
		sb.append(", fppSelectedStatus=");
		sb.append(fppSelectedStatus);
		sb.append(", fppMarketID=");
		sb.append(fppMarketID);
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
	public GDFTenderSubFPPMatDetails toEntityModel() {
		GDFTenderSubFPPMatDetailsImpl gdfTenderSubFPPMatDetailsImpl =
			new GDFTenderSubFPPMatDetailsImpl();

		gdfTenderSubFPPMatDetailsImpl.setTenderItemMatRefID(tenderItemMatRefID);
		gdfTenderSubFPPMatDetailsImpl.setScheduleNumber(scheduleNumber);

		if (gdfGenericCode == null) {
			gdfTenderSubFPPMatDetailsImpl.setGdfGenericCode("");
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setGdfGenericCode(gdfGenericCode);
		}

		if (tenderReferenceNumber == null) {
			gdfTenderSubFPPMatDetailsImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (dosageForm == null) {
			gdfTenderSubFPPMatDetailsImpl.setDosageForm("");
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setDosageForm(dosageForm);
		}

		gdfTenderSubFPPMatDetailsImpl.setNoPrimPackageUnits(noPrimPackageUnits);
		gdfTenderSubFPPMatDetailsImpl.setNoSecPackageUnits(noSecPackageUnits);

		if (gdfFppMartApprStatus == null) {
			gdfTenderSubFPPMatDetailsImpl.setGdfFppMartApprStatus("");
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setGdfFppMartApprStatus(
				gdfFppMartApprStatus);
		}

		gdfTenderSubFPPMatDetailsImpl.setFppSelectedStatus(fppSelectedStatus);
		gdfTenderSubFPPMatDetailsImpl.setFppMarketID(fppMarketID);
		gdfTenderSubFPPMatDetailsImpl.setTenderItemRefID(tenderItemRefID);
		gdfTenderSubFPPMatDetailsImpl.setUserId(userId);

		if (userName == null) {
			gdfTenderSubFPPMatDetailsImpl.setUserName("");
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderSubFPPMatDetailsImpl.setCreateDate(null);
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderSubFPPMatDetailsImpl.setModifiedDate(null);
		}
		else {
			gdfTenderSubFPPMatDetailsImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		gdfTenderSubFPPMatDetailsImpl.resetOriginalValues();

		return gdfTenderSubFPPMatDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderItemMatRefID = objectInput.readLong();

		scheduleNumber = objectInput.readLong();
		gdfGenericCode = objectInput.readUTF();
		tenderReferenceNumber = objectInput.readUTF();
		dosageForm = objectInput.readUTF();

		noPrimPackageUnits = objectInput.readLong();

		noSecPackageUnits = objectInput.readLong();
		gdfFppMartApprStatus = objectInput.readUTF();

		fppSelectedStatus = objectInput.readBoolean();

		fppMarketID = objectInput.readLong();

		tenderItemRefID = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderItemMatRefID);

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

		if (dosageForm == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dosageForm);
		}

		objectOutput.writeLong(noPrimPackageUnits);

		objectOutput.writeLong(noSecPackageUnits);

		if (gdfFppMartApprStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gdfFppMartApprStatus);
		}

		objectOutput.writeBoolean(fppSelectedStatus);

		objectOutput.writeLong(fppMarketID);

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

	public long tenderItemMatRefID;
	public long scheduleNumber;
	public String gdfGenericCode;
	public String tenderReferenceNumber;
	public String dosageForm;
	public long noPrimPackageUnits;
	public long noSecPackageUnits;
	public String gdfFppMartApprStatus;
	public boolean fppSelectedStatus;
	public long fppMarketID;
	public long tenderItemRefID;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}