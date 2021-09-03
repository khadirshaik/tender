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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GDFTenderSubFPPRegDetails service. Represents a row in the &quot;PRT_GDFTender_SubFppReg_Det&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsImpl</code>.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetails
 * @generated
 */
@ProviderType
public interface GDFTenderSubFPPRegDetailsModel
	extends BaseModel<GDFTenderSubFPPRegDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a gdf tender sub fpp reg details model instance should use the {@link GDFTenderSubFPPRegDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this gdf tender sub fpp reg details.
	 *
	 * @return the primary key of this gdf tender sub fpp reg details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this gdf tender sub fpp reg details.
	 *
	 * @param primaryKey the primary key of this gdf tender sub fpp reg details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tender reg ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender reg ref ID of this gdf tender sub fpp reg details
	 */
	public long getTenderRegRefID();

	/**
	 * Sets the tender reg ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderRegRefID the tender reg ref ID of this gdf tender sub fpp reg details
	 */
	public void setTenderRegRefID(long tenderRegRefID);

	/**
	 * Returns the schedule number of this gdf tender sub fpp reg details.
	 *
	 * @return the schedule number of this gdf tender sub fpp reg details
	 */
	public long getScheduleNumber();

	/**
	 * Sets the schedule number of this gdf tender sub fpp reg details.
	 *
	 * @param scheduleNumber the schedule number of this gdf tender sub fpp reg details
	 */
	public void setScheduleNumber(long scheduleNumber);

	/**
	 * Returns the gdf generic code of this gdf tender sub fpp reg details.
	 *
	 * @return the gdf generic code of this gdf tender sub fpp reg details
	 */
	@AutoEscape
	public String getGdfGenericCode();

	/**
	 * Sets the gdf generic code of this gdf tender sub fpp reg details.
	 *
	 * @param gdfGenericCode the gdf generic code of this gdf tender sub fpp reg details
	 */
	public void setGdfGenericCode(String gdfGenericCode);

	/**
	 * Returns the tender reference number of this gdf tender sub fpp reg details.
	 *
	 * @return the tender reference number of this gdf tender sub fpp reg details
	 */
	@AutoEscape
	public String getTenderReferenceNumber();

	/**
	 * Sets the tender reference number of this gdf tender sub fpp reg details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender sub fpp reg details
	 */
	public void setTenderReferenceNumber(String tenderReferenceNumber);

	/**
	 * Returns the list of reg countries of this gdf tender sub fpp reg details.
	 *
	 * @return the list of reg countries of this gdf tender sub fpp reg details
	 */
	@AutoEscape
	public String getListOfRegCountries();

	/**
	 * Sets the list of reg countries of this gdf tender sub fpp reg details.
	 *
	 * @param listOfRegCountries the list of reg countries of this gdf tender sub fpp reg details
	 */
	public void setListOfRegCountries(String listOfRegCountries);

	/**
	 * Returns the fpp reg appr status of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp reg appr status of this gdf tender sub fpp reg details
	 */
	@AutoEscape
	public String getFppRegApprStatus();

	/**
	 * Sets the fpp reg appr status of this gdf tender sub fpp reg details.
	 *
	 * @param fppRegApprStatus the fpp reg appr status of this gdf tender sub fpp reg details
	 */
	public void setFppRegApprStatus(String fppRegApprStatus);

	/**
	 * Returns the fpp reg accepted of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp reg accepted of this gdf tender sub fpp reg details
	 */
	public boolean getFppRegAccepted();

	/**
	 * Returns <code>true</code> if this gdf tender sub fpp reg details is fpp reg accepted.
	 *
	 * @return <code>true</code> if this gdf tender sub fpp reg details is fpp reg accepted; <code>false</code> otherwise
	 */
	public boolean isFppRegAccepted();

	/**
	 * Sets whether this gdf tender sub fpp reg details is fpp reg accepted.
	 *
	 * @param fppRegAccepted the fpp reg accepted of this gdf tender sub fpp reg details
	 */
	public void setFppRegAccepted(boolean fppRegAccepted);

	/**
	 * Returns the fpp registration ID of this gdf tender sub fpp reg details.
	 *
	 * @return the fpp registration ID of this gdf tender sub fpp reg details
	 */
	public long getFppRegistrationId();

	/**
	 * Sets the fpp registration ID of this gdf tender sub fpp reg details.
	 *
	 * @param fppRegistrationId the fpp registration ID of this gdf tender sub fpp reg details
	 */
	public void setFppRegistrationId(long fppRegistrationId);

	/**
	 * Returns the tender item mat ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender item mat ref ID of this gdf tender sub fpp reg details
	 */
	public long getTenderItemMatRefID();

	/**
	 * Sets the tender item mat ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderItemMatRefID the tender item mat ref ID of this gdf tender sub fpp reg details
	 */
	public void setTenderItemMatRefID(long tenderItemMatRefID);

	/**
	 * Returns the tender item ref ID of this gdf tender sub fpp reg details.
	 *
	 * @return the tender item ref ID of this gdf tender sub fpp reg details
	 */
	public long getTenderItemRefID();

	/**
	 * Sets the tender item ref ID of this gdf tender sub fpp reg details.
	 *
	 * @param tenderItemRefID the tender item ref ID of this gdf tender sub fpp reg details
	 */
	public void setTenderItemRefID(long tenderItemRefID);

	/**
	 * Returns the user ID of this gdf tender sub fpp reg details.
	 *
	 * @return the user ID of this gdf tender sub fpp reg details
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this gdf tender sub fpp reg details.
	 *
	 * @param userId the user ID of this gdf tender sub fpp reg details
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this gdf tender sub fpp reg details.
	 *
	 * @return the user uuid of this gdf tender sub fpp reg details
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this gdf tender sub fpp reg details.
	 *
	 * @param userUuid the user uuid of this gdf tender sub fpp reg details
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this gdf tender sub fpp reg details.
	 *
	 * @return the user name of this gdf tender sub fpp reg details
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this gdf tender sub fpp reg details.
	 *
	 * @param userName the user name of this gdf tender sub fpp reg details
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this gdf tender sub fpp reg details.
	 *
	 * @return the create date of this gdf tender sub fpp reg details
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this gdf tender sub fpp reg details.
	 *
	 * @param createDate the create date of this gdf tender sub fpp reg details
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this gdf tender sub fpp reg details.
	 *
	 * @return the modified date of this gdf tender sub fpp reg details
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this gdf tender sub fpp reg details.
	 *
	 * @param modifiedDate the modified date of this gdf tender sub fpp reg details
	 */
	public void setModifiedDate(Date modifiedDate);

}