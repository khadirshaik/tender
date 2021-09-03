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
 * This class is a wrapper for {@link GDFTenderDetails}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderDetails
 * @generated
 */
public class GDFTenderDetailsWrapper
	extends BaseModelWrapper<GDFTenderDetails>
	implements GDFTenderDetails, ModelWrapper<GDFTenderDetails> {

	public GDFTenderDetailsWrapper(GDFTenderDetails gdfTenderDetails) {
		super(gdfTenderDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderRefID", getTenderRefID());
		attributes.put("productCategory", getProductCategory());
		attributes.put("tenderReferenceNumber", getTenderReferenceNumber());
		attributes.put("title", getTitle());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("deadlineForTechBidsSub", getDeadlineForTechBidsSub());
		attributes.put("method", getMethod());
		attributes.put("tenderStatus", getTenderStatus());
		attributes.put(
			"deadlineTimeForTechBidsSub", getDeadlineTimeForTechBidsSub());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderRefID = (Long)attributes.get("tenderRefID");

		if (tenderRefID != null) {
			setTenderRefID(tenderRefID);
		}

		String productCategory = (String)attributes.get("productCategory");

		if (productCategory != null) {
			setProductCategory(productCategory);
		}

		String tenderReferenceNumber = (String)attributes.get(
			"tenderReferenceNumber");

		if (tenderReferenceNumber != null) {
			setTenderReferenceNumber(tenderReferenceNumber);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date deadlineForTechBidsSub = (Date)attributes.get(
			"deadlineForTechBidsSub");

		if (deadlineForTechBidsSub != null) {
			setDeadlineForTechBidsSub(deadlineForTechBidsSub);
		}

		String method = (String)attributes.get("method");

		if (method != null) {
			setMethod(method);
		}

		String tenderStatus = (String)attributes.get("tenderStatus");

		if (tenderStatus != null) {
			setTenderStatus(tenderStatus);
		}

		Date deadlineTimeForTechBidsSub = (Date)attributes.get(
			"deadlineTimeForTechBidsSub");

		if (deadlineTimeForTechBidsSub != null) {
			setDeadlineTimeForTechBidsSub(deadlineTimeForTechBidsSub);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
	}

	/**
	 * Returns the create date of this gdf tender details.
	 *
	 * @return the create date of this gdf tender details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deadline for tech bids sub of this gdf tender details.
	 *
	 * @return the deadline for tech bids sub of this gdf tender details
	 */
	@Override
	public Date getDeadlineForTechBidsSub() {
		return model.getDeadlineForTechBidsSub();
	}

	/**
	 * Returns the deadline time for tech bids sub of this gdf tender details.
	 *
	 * @return the deadline time for tech bids sub of this gdf tender details
	 */
	@Override
	public Date getDeadlineTimeForTechBidsSub() {
		return model.getDeadlineTimeForTechBidsSub();
	}

	/**
	 * Returns the method of this gdf tender details.
	 *
	 * @return the method of this gdf tender details
	 */
	@Override
	public String getMethod() {
		return model.getMethod();
	}

	/**
	 * Returns the modified date of this gdf tender details.
	 *
	 * @return the modified date of this gdf tender details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this gdf tender details.
	 *
	 * @return the primary key of this gdf tender details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product category of this gdf tender details.
	 *
	 * @return the product category of this gdf tender details
	 */
	@Override
	public String getProductCategory() {
		return model.getProductCategory();
	}

	/**
	 * Returns the publication date of this gdf tender details.
	 *
	 * @return the publication date of this gdf tender details
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Returns the tender reference number of this gdf tender details.
	 *
	 * @return the tender reference number of this gdf tender details
	 */
	@Override
	public String getTenderReferenceNumber() {
		return model.getTenderReferenceNumber();
	}

	/**
	 * Returns the tender ref ID of this gdf tender details.
	 *
	 * @return the tender ref ID of this gdf tender details
	 */
	@Override
	public long getTenderRefID() {
		return model.getTenderRefID();
	}

	/**
	 * Returns the tender status of this gdf tender details.
	 *
	 * @return the tender status of this gdf tender details
	 */
	@Override
	public String getTenderStatus() {
		return model.getTenderStatus();
	}

	/**
	 * Returns the title of this gdf tender details.
	 *
	 * @return the title of this gdf tender details
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this gdf tender details.
	 *
	 * @return the user ID of this gdf tender details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this gdf tender details.
	 *
	 * @return the user name of this gdf tender details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this gdf tender details.
	 *
	 * @return the user uuid of this gdf tender details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this gdf tender details.
	 *
	 * @param createDate the create date of this gdf tender details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deadline for tech bids sub of this gdf tender details.
	 *
	 * @param deadlineForTechBidsSub the deadline for tech bids sub of this gdf tender details
	 */
	@Override
	public void setDeadlineForTechBidsSub(Date deadlineForTechBidsSub) {
		model.setDeadlineForTechBidsSub(deadlineForTechBidsSub);
	}

	/**
	 * Sets the deadline time for tech bids sub of this gdf tender details.
	 *
	 * @param deadlineTimeForTechBidsSub the deadline time for tech bids sub of this gdf tender details
	 */
	@Override
	public void setDeadlineTimeForTechBidsSub(Date deadlineTimeForTechBidsSub) {
		model.setDeadlineTimeForTechBidsSub(deadlineTimeForTechBidsSub);
	}

	/**
	 * Sets the method of this gdf tender details.
	 *
	 * @param method the method of this gdf tender details
	 */
	@Override
	public void setMethod(String method) {
		model.setMethod(method);
	}

	/**
	 * Sets the modified date of this gdf tender details.
	 *
	 * @param modifiedDate the modified date of this gdf tender details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this gdf tender details.
	 *
	 * @param primaryKey the primary key of this gdf tender details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product category of this gdf tender details.
	 *
	 * @param productCategory the product category of this gdf tender details
	 */
	@Override
	public void setProductCategory(String productCategory) {
		model.setProductCategory(productCategory);
	}

	/**
	 * Sets the publication date of this gdf tender details.
	 *
	 * @param publicationDate the publication date of this gdf tender details
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the tender reference number of this gdf tender details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender details
	 */
	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		model.setTenderReferenceNumber(tenderReferenceNumber);
	}

	/**
	 * Sets the tender ref ID of this gdf tender details.
	 *
	 * @param tenderRefID the tender ref ID of this gdf tender details
	 */
	@Override
	public void setTenderRefID(long tenderRefID) {
		model.setTenderRefID(tenderRefID);
	}

	/**
	 * Sets the tender status of this gdf tender details.
	 *
	 * @param tenderStatus the tender status of this gdf tender details
	 */
	@Override
	public void setTenderStatus(String tenderStatus) {
		model.setTenderStatus(tenderStatus);
	}

	/**
	 * Sets the title of this gdf tender details.
	 *
	 * @param title the title of this gdf tender details
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this gdf tender details.
	 *
	 * @param userId the user ID of this gdf tender details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this gdf tender details.
	 *
	 * @param userName the user name of this gdf tender details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this gdf tender details.
	 *
	 * @param userUuid the user uuid of this gdf tender details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GDFTenderDetailsWrapper wrap(GDFTenderDetails gdfTenderDetails) {
		return new GDFTenderDetailsWrapper(gdfTenderDetails);
	}

}