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
 * This class is a wrapper for {@link GDFTenderSubSchedDetails}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetails
 * @generated
 */
public class GDFTenderSubSchedDetailsWrapper
	extends BaseModelWrapper<GDFTenderSubSchedDetails>
	implements GDFTenderSubSchedDetails,
			   ModelWrapper<GDFTenderSubSchedDetails> {

	public GDFTenderSubSchedDetailsWrapper(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		super(gdfTenderSubSchedDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderSubSchedRefID", getTenderSubSchedRefID());
		attributes.put("tenderItemNumber", getTenderItemNumber());
		attributes.put("scheduleNumber", getScheduleNumber());
		attributes.put("gdfGenericCode", getGdfGenericCode());
		attributes.put("tenderReferenceNumber", getTenderReferenceNumber());
		attributes.put("scheduleName", getScheduleName());
		attributes.put("patientTarget", getPatientTarget());
		attributes.put("tenderItemRefID", getTenderItemRefID());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderSubSchedRefID = (Long)attributes.get("tenderSubSchedRefID");

		if (tenderSubSchedRefID != null) {
			setTenderSubSchedRefID(tenderSubSchedRefID);
		}

		Long tenderItemNumber = (Long)attributes.get("tenderItemNumber");

		if (tenderItemNumber != null) {
			setTenderItemNumber(tenderItemNumber);
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

		String scheduleName = (String)attributes.get("scheduleName");

		if (scheduleName != null) {
			setScheduleName(scheduleName);
		}

		String patientTarget = (String)attributes.get("patientTarget");

		if (patientTarget != null) {
			setPatientTarget(patientTarget);
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
	 * Returns the create date of this gdf tender sub sched details.
	 *
	 * @return the create date of this gdf tender sub sched details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the gdf generic code of this gdf tender sub sched details.
	 *
	 * @return the gdf generic code of this gdf tender sub sched details
	 */
	@Override
	public String getGdfGenericCode() {
		return model.getGdfGenericCode();
	}

	/**
	 * Returns the modified date of this gdf tender sub sched details.
	 *
	 * @return the modified date of this gdf tender sub sched details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient target of this gdf tender sub sched details.
	 *
	 * @return the patient target of this gdf tender sub sched details
	 */
	@Override
	public String getPatientTarget() {
		return model.getPatientTarget();
	}

	/**
	 * Returns the primary key of this gdf tender sub sched details.
	 *
	 * @return the primary key of this gdf tender sub sched details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule name of this gdf tender sub sched details.
	 *
	 * @return the schedule name of this gdf tender sub sched details
	 */
	@Override
	public String getScheduleName() {
		return model.getScheduleName();
	}

	/**
	 * Returns the schedule number of this gdf tender sub sched details.
	 *
	 * @return the schedule number of this gdf tender sub sched details
	 */
	@Override
	public long getScheduleNumber() {
		return model.getScheduleNumber();
	}

	/**
	 * Returns the tender item number of this gdf tender sub sched details.
	 *
	 * @return the tender item number of this gdf tender sub sched details
	 */
	@Override
	public long getTenderItemNumber() {
		return model.getTenderItemNumber();
	}

	/**
	 * Returns the tender item ref ID of this gdf tender sub sched details.
	 *
	 * @return the tender item ref ID of this gdf tender sub sched details
	 */
	@Override
	public long getTenderItemRefID() {
		return model.getTenderItemRefID();
	}

	/**
	 * Returns the tender reference number of this gdf tender sub sched details.
	 *
	 * @return the tender reference number of this gdf tender sub sched details
	 */
	@Override
	public String getTenderReferenceNumber() {
		return model.getTenderReferenceNumber();
	}

	/**
	 * Returns the tender sub sched ref ID of this gdf tender sub sched details.
	 *
	 * @return the tender sub sched ref ID of this gdf tender sub sched details
	 */
	@Override
	public long getTenderSubSchedRefID() {
		return model.getTenderSubSchedRefID();
	}

	/**
	 * Returns the user ID of this gdf tender sub sched details.
	 *
	 * @return the user ID of this gdf tender sub sched details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this gdf tender sub sched details.
	 *
	 * @return the user name of this gdf tender sub sched details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this gdf tender sub sched details.
	 *
	 * @return the user uuid of this gdf tender sub sched details
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
	 * Sets the create date of this gdf tender sub sched details.
	 *
	 * @param createDate the create date of this gdf tender sub sched details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the gdf generic code of this gdf tender sub sched details.
	 *
	 * @param gdfGenericCode the gdf generic code of this gdf tender sub sched details
	 */
	@Override
	public void setGdfGenericCode(String gdfGenericCode) {
		model.setGdfGenericCode(gdfGenericCode);
	}

	/**
	 * Sets the modified date of this gdf tender sub sched details.
	 *
	 * @param modifiedDate the modified date of this gdf tender sub sched details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient target of this gdf tender sub sched details.
	 *
	 * @param patientTarget the patient target of this gdf tender sub sched details
	 */
	@Override
	public void setPatientTarget(String patientTarget) {
		model.setPatientTarget(patientTarget);
	}

	/**
	 * Sets the primary key of this gdf tender sub sched details.
	 *
	 * @param primaryKey the primary key of this gdf tender sub sched details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule name of this gdf tender sub sched details.
	 *
	 * @param scheduleName the schedule name of this gdf tender sub sched details
	 */
	@Override
	public void setScheduleName(String scheduleName) {
		model.setScheduleName(scheduleName);
	}

	/**
	 * Sets the schedule number of this gdf tender sub sched details.
	 *
	 * @param scheduleNumber the schedule number of this gdf tender sub sched details
	 */
	@Override
	public void setScheduleNumber(long scheduleNumber) {
		model.setScheduleNumber(scheduleNumber);
	}

	/**
	 * Sets the tender item number of this gdf tender sub sched details.
	 *
	 * @param tenderItemNumber the tender item number of this gdf tender sub sched details
	 */
	@Override
	public void setTenderItemNumber(long tenderItemNumber) {
		model.setTenderItemNumber(tenderItemNumber);
	}

	/**
	 * Sets the tender item ref ID of this gdf tender sub sched details.
	 *
	 * @param tenderItemRefID the tender item ref ID of this gdf tender sub sched details
	 */
	@Override
	public void setTenderItemRefID(long tenderItemRefID) {
		model.setTenderItemRefID(tenderItemRefID);
	}

	/**
	 * Sets the tender reference number of this gdf tender sub sched details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender sub sched details
	 */
	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		model.setTenderReferenceNumber(tenderReferenceNumber);
	}

	/**
	 * Sets the tender sub sched ref ID of this gdf tender sub sched details.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID of this gdf tender sub sched details
	 */
	@Override
	public void setTenderSubSchedRefID(long tenderSubSchedRefID) {
		model.setTenderSubSchedRefID(tenderSubSchedRefID);
	}

	/**
	 * Sets the user ID of this gdf tender sub sched details.
	 *
	 * @param userId the user ID of this gdf tender sub sched details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this gdf tender sub sched details.
	 *
	 * @param userName the user name of this gdf tender sub sched details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this gdf tender sub sched details.
	 *
	 * @param userUuid the user uuid of this gdf tender sub sched details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GDFTenderSubSchedDetailsWrapper wrap(
		GDFTenderSubSchedDetails gdfTenderSubSchedDetails) {

		return new GDFTenderSubSchedDetailsWrapper(gdfTenderSubSchedDetails);
	}

}