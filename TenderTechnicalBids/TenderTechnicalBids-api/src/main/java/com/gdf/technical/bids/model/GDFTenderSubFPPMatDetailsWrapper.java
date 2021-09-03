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
 * This class is a wrapper for {@link GDFTenderSubFPPMatDetails}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPMatDetails
 * @generated
 */
public class GDFTenderSubFPPMatDetailsWrapper
	extends BaseModelWrapper<GDFTenderSubFPPMatDetails>
	implements GDFTenderSubFPPMatDetails,
			   ModelWrapper<GDFTenderSubFPPMatDetails> {

	public GDFTenderSubFPPMatDetailsWrapper(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		super(gdfTenderSubFPPMatDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderItemMatRefID", getTenderItemMatRefID());
		attributes.put("scheduleNumber", getScheduleNumber());
		attributes.put("gdfGenericCode", getGdfGenericCode());
		attributes.put("tenderReferenceNumber", getTenderReferenceNumber());
		attributes.put("dosageForm", getDosageForm());
		attributes.put("noPrimPackageUnits", getNoPrimPackageUnits());
		attributes.put("noSecPackageUnits", getNoSecPackageUnits());
		attributes.put("gdfFppMartApprStatus", getGdfFppMartApprStatus());
		attributes.put("fppSelectedStatus", isFppSelectedStatus());
		attributes.put("fppMarketID", getFppMarketID());
		attributes.put("tenderItemRefID", getTenderItemRefID());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderItemMatRefID = (Long)attributes.get("tenderItemMatRefID");

		if (tenderItemMatRefID != null) {
			setTenderItemMatRefID(tenderItemMatRefID);
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

		String dosageForm = (String)attributes.get("dosageForm");

		if (dosageForm != null) {
			setDosageForm(dosageForm);
		}

		Long noPrimPackageUnits = (Long)attributes.get("noPrimPackageUnits");

		if (noPrimPackageUnits != null) {
			setNoPrimPackageUnits(noPrimPackageUnits);
		}

		Long noSecPackageUnits = (Long)attributes.get("noSecPackageUnits");

		if (noSecPackageUnits != null) {
			setNoSecPackageUnits(noSecPackageUnits);
		}

		String gdfFppMartApprStatus = (String)attributes.get(
			"gdfFppMartApprStatus");

		if (gdfFppMartApprStatus != null) {
			setGdfFppMartApprStatus(gdfFppMartApprStatus);
		}

		Boolean fppSelectedStatus = (Boolean)attributes.get(
			"fppSelectedStatus");

		if (fppSelectedStatus != null) {
			setFppSelectedStatus(fppSelectedStatus);
		}

		Long fppMarketID = (Long)attributes.get("fppMarketID");

		if (fppMarketID != null) {
			setFppMarketID(fppMarketID);
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
	 * Returns the create date of this gdf tender sub fpp mat details.
	 *
	 * @return the create date of this gdf tender sub fpp mat details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dosage form of this gdf tender sub fpp mat details.
	 *
	 * @return the dosage form of this gdf tender sub fpp mat details
	 */
	@Override
	public String getDosageForm() {
		return model.getDosageForm();
	}

	/**
	 * Returns the fpp market ID of this gdf tender sub fpp mat details.
	 *
	 * @return the fpp market ID of this gdf tender sub fpp mat details
	 */
	@Override
	public long getFppMarketID() {
		return model.getFppMarketID();
	}

	/**
	 * Returns the fpp selected status of this gdf tender sub fpp mat details.
	 *
	 * @return the fpp selected status of this gdf tender sub fpp mat details
	 */
	@Override
	public boolean getFppSelectedStatus() {
		return model.getFppSelectedStatus();
	}

	/**
	 * Returns the gdf fpp mart appr status of this gdf tender sub fpp mat details.
	 *
	 * @return the gdf fpp mart appr status of this gdf tender sub fpp mat details
	 */
	@Override
	public String getGdfFppMartApprStatus() {
		return model.getGdfFppMartApprStatus();
	}

	/**
	 * Returns the gdf generic code of this gdf tender sub fpp mat details.
	 *
	 * @return the gdf generic code of this gdf tender sub fpp mat details
	 */
	@Override
	public String getGdfGenericCode() {
		return model.getGdfGenericCode();
	}

	/**
	 * Returns the modified date of this gdf tender sub fpp mat details.
	 *
	 * @return the modified date of this gdf tender sub fpp mat details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the no prim package units of this gdf tender sub fpp mat details.
	 *
	 * @return the no prim package units of this gdf tender sub fpp mat details
	 */
	@Override
	public long getNoPrimPackageUnits() {
		return model.getNoPrimPackageUnits();
	}

	/**
	 * Returns the no sec package units of this gdf tender sub fpp mat details.
	 *
	 * @return the no sec package units of this gdf tender sub fpp mat details
	 */
	@Override
	public long getNoSecPackageUnits() {
		return model.getNoSecPackageUnits();
	}

	/**
	 * Returns the primary key of this gdf tender sub fpp mat details.
	 *
	 * @return the primary key of this gdf tender sub fpp mat details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule number of this gdf tender sub fpp mat details.
	 *
	 * @return the schedule number of this gdf tender sub fpp mat details
	 */
	@Override
	public long getScheduleNumber() {
		return model.getScheduleNumber();
	}

	/**
	 * Returns the tender item mat ref ID of this gdf tender sub fpp mat details.
	 *
	 * @return the tender item mat ref ID of this gdf tender sub fpp mat details
	 */
	@Override
	public long getTenderItemMatRefID() {
		return model.getTenderItemMatRefID();
	}

	/**
	 * Returns the tender item ref ID of this gdf tender sub fpp mat details.
	 *
	 * @return the tender item ref ID of this gdf tender sub fpp mat details
	 */
	@Override
	public long getTenderItemRefID() {
		return model.getTenderItemRefID();
	}

	/**
	 * Returns the tender reference number of this gdf tender sub fpp mat details.
	 *
	 * @return the tender reference number of this gdf tender sub fpp mat details
	 */
	@Override
	public String getTenderReferenceNumber() {
		return model.getTenderReferenceNumber();
	}

	/**
	 * Returns the user ID of this gdf tender sub fpp mat details.
	 *
	 * @return the user ID of this gdf tender sub fpp mat details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this gdf tender sub fpp mat details.
	 *
	 * @return the user name of this gdf tender sub fpp mat details
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this gdf tender sub fpp mat details.
	 *
	 * @return the user uuid of this gdf tender sub fpp mat details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this gdf tender sub fpp mat details is fpp selected status.
	 *
	 * @return <code>true</code> if this gdf tender sub fpp mat details is fpp selected status; <code>false</code> otherwise
	 */
	@Override
	public boolean isFppSelectedStatus() {
		return model.isFppSelectedStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this gdf tender sub fpp mat details.
	 *
	 * @param createDate the create date of this gdf tender sub fpp mat details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dosage form of this gdf tender sub fpp mat details.
	 *
	 * @param dosageForm the dosage form of this gdf tender sub fpp mat details
	 */
	@Override
	public void setDosageForm(String dosageForm) {
		model.setDosageForm(dosageForm);
	}

	/**
	 * Sets the fpp market ID of this gdf tender sub fpp mat details.
	 *
	 * @param fppMarketID the fpp market ID of this gdf tender sub fpp mat details
	 */
	@Override
	public void setFppMarketID(long fppMarketID) {
		model.setFppMarketID(fppMarketID);
	}

	/**
	 * Sets whether this gdf tender sub fpp mat details is fpp selected status.
	 *
	 * @param fppSelectedStatus the fpp selected status of this gdf tender sub fpp mat details
	 */
	@Override
	public void setFppSelectedStatus(boolean fppSelectedStatus) {
		model.setFppSelectedStatus(fppSelectedStatus);
	}

	/**
	 * Sets the gdf fpp mart appr status of this gdf tender sub fpp mat details.
	 *
	 * @param gdfFppMartApprStatus the gdf fpp mart appr status of this gdf tender sub fpp mat details
	 */
	@Override
	public void setGdfFppMartApprStatus(String gdfFppMartApprStatus) {
		model.setGdfFppMartApprStatus(gdfFppMartApprStatus);
	}

	/**
	 * Sets the gdf generic code of this gdf tender sub fpp mat details.
	 *
	 * @param gdfGenericCode the gdf generic code of this gdf tender sub fpp mat details
	 */
	@Override
	public void setGdfGenericCode(String gdfGenericCode) {
		model.setGdfGenericCode(gdfGenericCode);
	}

	/**
	 * Sets the modified date of this gdf tender sub fpp mat details.
	 *
	 * @param modifiedDate the modified date of this gdf tender sub fpp mat details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the no prim package units of this gdf tender sub fpp mat details.
	 *
	 * @param noPrimPackageUnits the no prim package units of this gdf tender sub fpp mat details
	 */
	@Override
	public void setNoPrimPackageUnits(long noPrimPackageUnits) {
		model.setNoPrimPackageUnits(noPrimPackageUnits);
	}

	/**
	 * Sets the no sec package units of this gdf tender sub fpp mat details.
	 *
	 * @param noSecPackageUnits the no sec package units of this gdf tender sub fpp mat details
	 */
	@Override
	public void setNoSecPackageUnits(long noSecPackageUnits) {
		model.setNoSecPackageUnits(noSecPackageUnits);
	}

	/**
	 * Sets the primary key of this gdf tender sub fpp mat details.
	 *
	 * @param primaryKey the primary key of this gdf tender sub fpp mat details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule number of this gdf tender sub fpp mat details.
	 *
	 * @param scheduleNumber the schedule number of this gdf tender sub fpp mat details
	 */
	@Override
	public void setScheduleNumber(long scheduleNumber) {
		model.setScheduleNumber(scheduleNumber);
	}

	/**
	 * Sets the tender item mat ref ID of this gdf tender sub fpp mat details.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID of this gdf tender sub fpp mat details
	 */
	@Override
	public void setTenderItemMatRefID(long tenderItemMatRefID) {
		model.setTenderItemMatRefID(tenderItemMatRefID);
	}

	/**
	 * Sets the tender item ref ID of this gdf tender sub fpp mat details.
	 *
	 * @param tenderItemRefID the tender item ref ID of this gdf tender sub fpp mat details
	 */
	@Override
	public void setTenderItemRefID(long tenderItemRefID) {
		model.setTenderItemRefID(tenderItemRefID);
	}

	/**
	 * Sets the tender reference number of this gdf tender sub fpp mat details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender sub fpp mat details
	 */
	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		model.setTenderReferenceNumber(tenderReferenceNumber);
	}

	/**
	 * Sets the user ID of this gdf tender sub fpp mat details.
	 *
	 * @param userId the user ID of this gdf tender sub fpp mat details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this gdf tender sub fpp mat details.
	 *
	 * @param userName the user name of this gdf tender sub fpp mat details
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this gdf tender sub fpp mat details.
	 *
	 * @param userUuid the user uuid of this gdf tender sub fpp mat details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GDFTenderSubFPPMatDetailsWrapper wrap(
		GDFTenderSubFPPMatDetails gdfTenderSubFPPMatDetails) {

		return new GDFTenderSubFPPMatDetailsWrapper(gdfTenderSubFPPMatDetails);
	}

}