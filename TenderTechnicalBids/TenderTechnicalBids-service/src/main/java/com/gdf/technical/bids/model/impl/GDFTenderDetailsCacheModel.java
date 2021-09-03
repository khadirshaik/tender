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

import com.gdf.technical.bids.model.GDFTenderDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GDFTenderDetails in entity cache.
 *
 * @author KS61374
 * @generated
 */
public class GDFTenderDetailsCacheModel
	implements CacheModel<GDFTenderDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderDetailsCacheModel)) {
			return false;
		}

		GDFTenderDetailsCacheModel gdfTenderDetailsCacheModel =
			(GDFTenderDetailsCacheModel)obj;

		if (tenderRefID == gdfTenderDetailsCacheModel.tenderRefID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderRefID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{tenderRefID=");
		sb.append(tenderRefID);
		sb.append(", productCategory=");
		sb.append(productCategory);
		sb.append(", tenderReferenceNumber=");
		sb.append(tenderReferenceNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", deadlineForTechBidsSub=");
		sb.append(deadlineForTechBidsSub);
		sb.append(", method=");
		sb.append(method);
		sb.append(", tenderStatus=");
		sb.append(tenderStatus);
		sb.append(", deadlineTimeForTechBidsSub=");
		sb.append(deadlineTimeForTechBidsSub);
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
	public GDFTenderDetails toEntityModel() {
		GDFTenderDetailsImpl gdfTenderDetailsImpl = new GDFTenderDetailsImpl();

		gdfTenderDetailsImpl.setTenderRefID(tenderRefID);

		if (productCategory == null) {
			gdfTenderDetailsImpl.setProductCategory("");
		}
		else {
			gdfTenderDetailsImpl.setProductCategory(productCategory);
		}

		if (tenderReferenceNumber == null) {
			gdfTenderDetailsImpl.setTenderReferenceNumber("");
		}
		else {
			gdfTenderDetailsImpl.setTenderReferenceNumber(
				tenderReferenceNumber);
		}

		if (title == null) {
			gdfTenderDetailsImpl.setTitle("");
		}
		else {
			gdfTenderDetailsImpl.setTitle(title);
		}

		if (publicationDate == Long.MIN_VALUE) {
			gdfTenderDetailsImpl.setPublicationDate(null);
		}
		else {
			gdfTenderDetailsImpl.setPublicationDate(new Date(publicationDate));
		}

		if (deadlineForTechBidsSub == Long.MIN_VALUE) {
			gdfTenderDetailsImpl.setDeadlineForTechBidsSub(null);
		}
		else {
			gdfTenderDetailsImpl.setDeadlineForTechBidsSub(
				new Date(deadlineForTechBidsSub));
		}

		if (method == null) {
			gdfTenderDetailsImpl.setMethod("");
		}
		else {
			gdfTenderDetailsImpl.setMethod(method);
		}

		if (tenderStatus == null) {
			gdfTenderDetailsImpl.setTenderStatus("");
		}
		else {
			gdfTenderDetailsImpl.setTenderStatus(tenderStatus);
		}

		if (deadlineTimeForTechBidsSub == Long.MIN_VALUE) {
			gdfTenderDetailsImpl.setDeadlineTimeForTechBidsSub(null);
		}
		else {
			gdfTenderDetailsImpl.setDeadlineTimeForTechBidsSub(
				new Date(deadlineTimeForTechBidsSub));
		}

		gdfTenderDetailsImpl.setUserId(userId);

		if (userName == null) {
			gdfTenderDetailsImpl.setUserName("");
		}
		else {
			gdfTenderDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gdfTenderDetailsImpl.setCreateDate(null);
		}
		else {
			gdfTenderDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gdfTenderDetailsImpl.setModifiedDate(null);
		}
		else {
			gdfTenderDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		gdfTenderDetailsImpl.resetOriginalValues();

		return gdfTenderDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderRefID = objectInput.readLong();
		productCategory = objectInput.readUTF();
		tenderReferenceNumber = objectInput.readUTF();
		title = objectInput.readUTF();
		publicationDate = objectInput.readLong();
		deadlineForTechBidsSub = objectInput.readLong();
		method = objectInput.readUTF();
		tenderStatus = objectInput.readUTF();
		deadlineTimeForTechBidsSub = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderRefID);

		if (productCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCategory);
		}

		if (tenderReferenceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenderReferenceNumber);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(publicationDate);
		objectOutput.writeLong(deadlineForTechBidsSub);

		if (method == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(method);
		}

		if (tenderStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenderStatus);
		}

		objectOutput.writeLong(deadlineTimeForTechBidsSub);

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

	public long tenderRefID;
	public String productCategory;
	public String tenderReferenceNumber;
	public String title;
	public long publicationDate;
	public long deadlineForTechBidsSub;
	public String method;
	public String tenderStatus;
	public long deadlineTimeForTechBidsSub;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}