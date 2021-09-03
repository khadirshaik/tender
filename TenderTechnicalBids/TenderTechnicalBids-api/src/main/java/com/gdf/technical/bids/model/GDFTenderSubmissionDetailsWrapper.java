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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GDFTenderSubmissionDetails}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubmissionDetails
 * @generated
 */
public class GDFTenderSubmissionDetailsWrapper
	extends BaseModelWrapper<GDFTenderSubmissionDetails>
	implements GDFTenderSubmissionDetails,
			   ModelWrapper<GDFTenderSubmissionDetails> {

	public GDFTenderSubmissionDetailsWrapper(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		super(gdfTenderSubmissionDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderSubRefID", getTenderSubRefID());
		attributes.put("tenderReferenceNumber", getTenderReferenceNumber());
		attributes.put("copyOfRegCert", getCopyOfRegCert());
		attributes.put("supplierName", getSupplierName());
		attributes.put("nameOfAuthRepr", getNameOfAuthRepr());
		attributes.put("supplierTitle", getSupplierTitle());
		attributes.put("supplierEmailAddress", getSupplierEmailAddress());
		attributes.put("supplierTelephoneNumber", getSupplierTelephoneNumber());
		attributes.put("tenderSubmissionStatus", getTenderSubmissionStatus());
		attributes.put("supplierId", getSupplierId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("submittedDate", getSubmittedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderSubRefID = (Long)attributes.get("tenderSubRefID");

		if (tenderSubRefID != null) {
			setTenderSubRefID(tenderSubRefID);
		}

		String tenderReferenceNumber = (String)attributes.get(
			"tenderReferenceNumber");

		if (tenderReferenceNumber != null) {
			setTenderReferenceNumber(tenderReferenceNumber);
		}

		String copyOfRegCert = (String)attributes.get("copyOfRegCert");

		if (copyOfRegCert != null) {
			setCopyOfRegCert(copyOfRegCert);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
		}

		String nameOfAuthRepr = (String)attributes.get("nameOfAuthRepr");

		if (nameOfAuthRepr != null) {
			setNameOfAuthRepr(nameOfAuthRepr);
		}

		String supplierTitle = (String)attributes.get("supplierTitle");

		if (supplierTitle != null) {
			setSupplierTitle(supplierTitle);
		}

		String supplierEmailAddress = (String)attributes.get(
			"supplierEmailAddress");

		if (supplierEmailAddress != null) {
			setSupplierEmailAddress(supplierEmailAddress);
		}

		String supplierTelephoneNumber = (String)attributes.get(
			"supplierTelephoneNumber");

		if (supplierTelephoneNumber != null) {
			setSupplierTelephoneNumber(supplierTelephoneNumber);
		}

		String tenderSubmissionStatus = (String)attributes.get(
			"tenderSubmissionStatus");

		if (tenderSubmissionStatus != null) {
			setTenderSubmissionStatus(tenderSubmissionStatus);
		}

		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date submittedDate = (Date)attributes.get("submittedDate");

		if (submittedDate != null) {
			setSubmittedDate(submittedDate);
		}
	}

	/**
	 * Returns the copy of reg cert of this gdf tender submission details.
	 *
	 * @return the copy of reg cert of this gdf tender submission details
	 */
	@Override
	public String getCopyOfRegCert() {
		return model.getCopyOfRegCert();
	}

	/**
	 * Returns the create date of this gdf tender submission details.
	 *
	 * @return the create date of this gdf tender submission details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this gdf tender submission details.
	 *
	 * @return the modified date of this gdf tender submission details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of auth repr of this gdf tender submission details.
	 *
	 * @return the name of auth repr of this gdf tender submission details
	 */
	@Override
	public String getNameOfAuthRepr() {
		return model.getNameOfAuthRepr();
	}

	/**
	 * Returns the primary key of this gdf tender submission details.
	 *
	 * @return the primary key of this gdf tender submission details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the submitted date of this gdf tender submission details.
	 *
	 * @return the submitted date of this gdf tender submission details
	 */
	@Override
	public Date getSubmittedDate() {
		return model.getSubmittedDate();
	}

	/**
	 * Returns the supplier email address of this gdf tender submission details.
	 *
	 * @return the supplier email address of this gdf tender submission details
	 */
	@Override
	public String getSupplierEmailAddress() {
		return model.getSupplierEmailAddress();
	}

	/**
	 * Returns the supplier ID of this gdf tender submission details.
	 *
	 * @return the supplier ID of this gdf tender submission details
	 */
	@Override
	public long getSupplierId() {
		return model.getSupplierId();
	}

	/**
	 * Returns the supplier name of this gdf tender submission details.
	 *
	 * @return the supplier name of this gdf tender submission details
	 */
	@Override
	public String getSupplierName() {
		return model.getSupplierName();
	}

	/**
	 * Returns the supplier telephone number of this gdf tender submission details.
	 *
	 * @return the supplier telephone number of this gdf tender submission details
	 */
	@Override
	public String getSupplierTelephoneNumber() {
		return model.getSupplierTelephoneNumber();
	}

	/**
	 * Returns the supplier title of this gdf tender submission details.
	 *
	 * @return the supplier title of this gdf tender submission details
	 */
	@Override
	public String getSupplierTitle() {
		return model.getSupplierTitle();
	}

	/**
	 * Returns the tender reference number of this gdf tender submission details.
	 *
	 * @return the tender reference number of this gdf tender submission details
	 */
	@Override
	public String getTenderReferenceNumber() {
		return model.getTenderReferenceNumber();
	}

	/**
	 * Returns the tender submission status of this gdf tender submission details.
	 *
	 * @return the tender submission status of this gdf tender submission details
	 */
	@Override
	public String getTenderSubmissionStatus() {
		return model.getTenderSubmissionStatus();
	}

	/**
	 * Returns the tender sub ref ID of this gdf tender submission details.
	 *
	 * @return the tender sub ref ID of this gdf tender submission details
	 */
	@Override
	public long getTenderSubRefID() {
		return model.getTenderSubRefID();
	}

	/**
	 * Returns the user name of this gdf tender submission details.
	 *
	 * @return the user name of this gdf tender submission details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the copy of reg cert of this gdf tender submission details.
	 *
	 * @param copyOfRegCert the copy of reg cert of this gdf tender submission details
	 */
	@Override
	public void setCopyOfRegCert(String copyOfRegCert) {
		model.setCopyOfRegCert(copyOfRegCert);
	}

	/**
	 * Sets the create date of this gdf tender submission details.
	 *
	 * @param createDate the create date of this gdf tender submission details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this gdf tender submission details.
	 *
	 * @param modifiedDate the modified date of this gdf tender submission details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of auth repr of this gdf tender submission details.
	 *
	 * @param nameOfAuthRepr the name of auth repr of this gdf tender submission details
	 */
	@Override
	public void setNameOfAuthRepr(String nameOfAuthRepr) {
		model.setNameOfAuthRepr(nameOfAuthRepr);
	}

	/**
	 * Sets the primary key of this gdf tender submission details.
	 *
	 * @param primaryKey the primary key of this gdf tender submission details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the submitted date of this gdf tender submission details.
	 *
	 * @param submittedDate the submitted date of this gdf tender submission details
	 */
	@Override
	public void setSubmittedDate(Date submittedDate) {
		model.setSubmittedDate(submittedDate);
	}

	/**
	 * Sets the supplier email address of this gdf tender submission details.
	 *
	 * @param supplierEmailAddress the supplier email address of this gdf tender submission details
	 */
	@Override
	public void setSupplierEmailAddress(String supplierEmailAddress) {
		model.setSupplierEmailAddress(supplierEmailAddress);
	}

	/**
	 * Sets the supplier ID of this gdf tender submission details.
	 *
	 * @param supplierId the supplier ID of this gdf tender submission details
	 */
	@Override
	public void setSupplierId(long supplierId) {
		model.setSupplierId(supplierId);
	}

	/**
	 * Sets the supplier name of this gdf tender submission details.
	 *
	 * @param supplierName the supplier name of this gdf tender submission details
	 */
	@Override
	public void setSupplierName(String supplierName) {
		model.setSupplierName(supplierName);
	}

	/**
	 * Sets the supplier telephone number of this gdf tender submission details.
	 *
	 * @param supplierTelephoneNumber the supplier telephone number of this gdf tender submission details
	 */
	@Override
	public void setSupplierTelephoneNumber(String supplierTelephoneNumber) {
		model.setSupplierTelephoneNumber(supplierTelephoneNumber);
	}

	/**
	 * Sets the supplier title of this gdf tender submission details.
	 *
	 * @param supplierTitle the supplier title of this gdf tender submission details
	 */
	@Override
	public void setSupplierTitle(String supplierTitle) {
		model.setSupplierTitle(supplierTitle);
	}

	/**
	 * Sets the tender reference number of this gdf tender submission details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender submission details
	 */
	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		model.setTenderReferenceNumber(tenderReferenceNumber);
	}

	/**
	 * Sets the tender submission status of this gdf tender submission details.
	 *
	 * @param tenderSubmissionStatus the tender submission status of this gdf tender submission details
	 */
	@Override
	public void setTenderSubmissionStatus(String tenderSubmissionStatus) {
		model.setTenderSubmissionStatus(tenderSubmissionStatus);
	}

	/**
	 * Sets the tender sub ref ID of this gdf tender submission details.
	 *
	 * @param tenderSubRefID the tender sub ref ID of this gdf tender submission details
	 */
	@Override
	public void setTenderSubRefID(long tenderSubRefID) {
		model.setTenderSubRefID(tenderSubRefID);
	}

	/**
	 * Sets the user name of this gdf tender submission details.
	 *
	 * @param userName the user name of this gdf tender submission details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected GDFTenderSubmissionDetailsWrapper wrap(
		GDFTenderSubmissionDetails gdfTenderSubmissionDetails) {

		return new GDFTenderSubmissionDetailsWrapper(
			gdfTenderSubmissionDetails);
	}

}