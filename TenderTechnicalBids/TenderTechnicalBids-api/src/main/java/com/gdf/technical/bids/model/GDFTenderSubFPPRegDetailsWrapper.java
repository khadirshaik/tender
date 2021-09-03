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
 * This class is a wrapper for {@link GDFTenderSubFPPRegDetails}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetails
 * @generated
 */
public class GDFTenderSubFPPRegDetailsWrapper
	extends BaseModelWrapper<GDFTenderSubFPPRegDetails>
	implements GDFTenderSubFPPRegDetails,
			   ModelWrapper<GDFTenderSubFPPRegDetails> {

	public GDFTenderSubFPPRegDetailsWrapper(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		super(gdfTenderSubFPPRegDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderRegRefID", getTenderRegRefID());
		attributes.put("scheduleNumber", getScheduleNumber());
		attributes.put("gdfGenericCode", getGdfGenericCode());
		attributes.put("tenderReferenceNumber", getTenderReferenceNumber());
		attributes.put("listOfRegCountries", getListOfRegCountries());
		attributes.put("fppRegApprStatus", getFppRegApprStatus());
		attributes.put("fppRegAccepted", isFppRegAccepted());
		attributes.put("fppRegistrationId", getFppRegistrationId());
		attributes.put("tenderItemMatRefID", getTenderItemMatRefID());
		attributes.put("tenderItemRefID", getTenderItemRefID());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderRegRefID = (Long)attributes.get("tenderRegRefID");

		if (tenderRegRefID != null) {
			setTenderRegRefID(tenderRegRefID);
		}

		Long scheduleNumber = (Long)attributes.get("scheduleNumber");

		if (scheduleNumber != null) {
			setScheduleNumber(scheduleNumber);
		}

		String gdfGenericCode = (String)attributes.get("gdfGenericCode");

		if (gdfGenericCode != null) {
			setGdfGenericCode(gdfGenericCode);
		}

		String tenderReferenceNumber = (String)attributes.get(
			"tenderReferenceNumber");

		if (tenderReferenceNumber != null) {
			setTenderReferenceNumber(tenderReferenceNumber);
		}

		String listOfRegCountries = (String)attributes.get(
			"listOfRegCountries");

		if (listOfRegCountries != null) {
			setListOfRegCountries(listOfRegCountries);
		}

		String fppRegApprStatus = (String)attributes.get("fppRegApprStatus");

		if (fppRegApprStatus != null) {
			setFppRegApprStatus(fppRegApprStatus);
		}

		Boolean fppRegAccepted = (Boolean)attributes.get("fppRegAccepted");

		if (fppRegAccepted != null) {
			setFppRegAccepted(fppRegAccepted);
		}

		Long fppRegistrationId = (Long)attributes.get("fppRegistrationId");

		if (fppRegistrationId != null) {
			setFppRegistrationId(fppRegistrationId);
		}

		Long tenderItemMatRefID = (Long)attributes.get("tenderItemMatRefID");

		if (tenderItemMatRefID != null) {
			setTenderItemMatRefID(tenderItemMatRefID);
		}

		Long tenderItemRefID = (Long)attributes.get("tenderItemRefID");

		if (tenderItemRefID != null) {
			setTenderItemRefID(tenderItemRefID);
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
	 * Returns the create date of this gdf tender sub fpp reg details.
	 *
	 * @return the create date of this gdf tender sub fpp reg details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the fpp reg accepted of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp reg accepted of this gdf tender sub fpp reg details
	 */
	@Override
	public boolean getFppRegAccepted() {
		return model.getFppRegAccepted();
	}

	/**
	 * Returns the fpp reg appr status of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp reg appr status of this gdf tender sub fpp reg details
	 */
	@Override
	public String getFppRegApprStatus() {
		return model.getFppRegApprStatus();
	}

	/**
	 * Returns the fpp registration ID of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp registration ID of this gdf tender sub fpp reg details
	 */
	@Override
	public long getFppRegistrationId() {
		return model.getFppRegistrationId();
	}

	/**
	 * Returns the gdf generic code of this gdf tender sub fpp reg details.
	 *
	 * @return the gdf generic code of this gdf tender sub fpp reg details
	 */
	@Override
	public String getGdfGenericCode() {
		return model.getGdfGenericCode();
	}

	/**
	 * Returns the list of reg countries of this gdf tender sub fpp reg details.
	 *
	 * @return the list of reg countries of this gdf tender sub fpp reg details
	 */
	@Override
	public String getListOfRegCountries() {
		return model.getListOfRegCountries();
	}

	/**
	 * Returns the modified date of this gdf tender sub fpp reg details.
	 *
	 * @return the modified date of this gdf tender sub fpp reg details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this gdf tender sub fpp reg details.
	 *
	 * @return the primary key of this gdf tender sub fpp reg details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule number of this gdf tender sub fpp reg details.
	 *
	 * @return the schedule number of this gdf tender sub fpp reg details
	 */
	@Override
	public long getScheduleNumber() {
		return model.getScheduleNumber();
	}

	/**
	 * Returns the tender item mat ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender item mat ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public long getTenderItemMatRefID() {
		return model.getTenderItemMatRefID();
	}

	/**
	 * Returns the tender item ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender item ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public long getTenderItemRefID() {
		return model.getTenderItemRefID();
	}

	/**
	 * Returns the tender reference number of this gdf tender sub fpp reg details.
	 *
	 * @return the tender reference number of this gdf tender sub fpp reg details
	 */
	@Override
	public String getTenderReferenceNumber() {
		return model.getTenderReferenceNumber();
	}

	/**
	 * Returns the tender reg ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender reg ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public long getTenderRegRefID() {
		return model.getTenderRegRefID();
	}

	/**
	 * Returns the user ID of this gdf tender sub fpp reg details.
	 *
	 * @return the user ID of this gdf tender sub fpp reg details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this gdf tender sub fpp reg details.
	 *
	 * @return the user name of this gdf tender sub fpp reg details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this gdf tender sub fpp reg details.
	 *
	 * @return the user uuid of this gdf tender sub fpp reg details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this gdf tender sub fpp reg details is fpp reg accepted.
	 *
	 * @return <code>true</code> if this gdf tender sub fpp reg details is fpp reg accepted; <code>false</code> otherwise
	 */
	@Override
	public boolean isFppRegAccepted() {
		return model.isFppRegAccepted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this gdf tender sub fpp reg details.
	 *
	 * @param createDate the create date of this gdf tender sub fpp reg details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this gdf tender sub fpp reg details is fpp reg accepted.
	 *
	 * @param fppRegAccepted the fpp reg accepted of this gdf tender sub fpp reg details
	 */
	@Override
	public void setFppRegAccepted(boolean fppRegAccepted) {
		model.setFppRegAccepted(fppRegAccepted);
	}

	/**
	 * Sets the fpp reg appr status of this gdf tender sub fpp reg details.
	 *
	 * @param fppRegApprStatus the fpp reg appr status of this gdf tender sub fpp reg details
	 */
	@Override
	public void setFppRegApprStatus(String fppRegApprStatus) {
		model.setFppRegApprStatus(fppRegApprStatus);
	}

	/**
	 * Sets the fpp registration ID of this gdf tender sub fpp reg details.
	 *
	 * @param fppRegistrationId the fpp registration ID of this gdf tender sub fpp reg details
	 */
	@Override
	public void setFppRegistrationId(long fppRegistrationId) {
		model.setFppRegistrationId(fppRegistrationId);
	}

	/**
	 * Sets the gdf generic code of this gdf tender sub fpp reg details.
	 *
	 * @param gdfGenericCode the gdf generic code of this gdf tender sub fpp reg details
	 */
	@Override
	public void setGdfGenericCode(String gdfGenericCode) {
		model.setGdfGenericCode(gdfGenericCode);
	}

	/**
	 * Sets the list of reg countries of this gdf tender sub fpp reg details.
	 *
	 * @param listOfRegCountries the list of reg countries of this gdf tender sub fpp reg details
	 */
	@Override
	public void setListOfRegCountries(String listOfRegCountries) {
		model.setListOfRegCountries(listOfRegCountries);
	}

	/**
	 * Sets the modified date of this gdf tender sub fpp reg details.
	 *
	 * @param modifiedDate the modified date of this gdf tender sub fpp reg details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this gdf tender sub fpp reg details.
	 *
	 * @param primaryKey the primary key of this gdf tender sub fpp reg details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule number of this gdf tender sub fpp reg details.
	 *
	 * @param scheduleNumber the schedule number of this gdf tender sub fpp reg details
	 */
	@Override
	public void setScheduleNumber(long scheduleNumber) {
		model.setScheduleNumber(scheduleNumber);
	}

	/**
	 * Sets the tender item mat ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public void setTenderItemMatRefID(long tenderItemMatRefID) {
		model.setTenderItemMatRefID(tenderItemMatRefID);
	}

	/**
	 * Sets the tender item ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderItemRefID the tender item ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public void setTenderItemRefID(long tenderItemRefID) {
		model.setTenderItemRefID(tenderItemRefID);
	}

	/**
	 * Sets the tender reference number of this gdf tender sub fpp reg details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender sub fpp reg details
	 */
	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		model.setTenderReferenceNumber(tenderReferenceNumber);
	}

	/**
	 * Sets the tender reg ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderRegRefID the tender reg ref ID of this gdf tender sub fpp reg details
	 */
	@Override
	public void setTenderRegRefID(long tenderRegRefID) {
		model.setTenderRegRefID(tenderRegRefID);
	}

	/**
	 * Sets the user ID of this gdf tender sub fpp reg details.
	 *
	 * @param userId the user ID of this gdf tender sub fpp reg details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this gdf tender sub fpp reg details.
	 *
	 * @param userName the user name of this gdf tender sub fpp reg details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this gdf tender sub fpp reg details.
	 *
	 * @param userUuid the user uuid of this gdf tender sub fpp reg details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GDFTenderSubFPPRegDetailsWrapper wrap(
		GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

		return new GDFTenderSubFPPRegDetailsWrapper(gdfTenderSubFPPRegDetails);
	}

}