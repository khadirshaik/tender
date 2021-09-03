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
 * The base model interface for the GDFTenderSubSchedDetails service. Represents a row in the &quot;PRT_GDFTender_SubSched_Det&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.gdf.technical.bids.model.impl.GDFTenderSubSchedDetailsImpl</code>.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetails
 * @generated
 */
@ProviderType
public interface GDFTenderSubSchedDetailsModel
	extends BaseModel<GDFTenderSubSchedDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a gdf tender sub sched details model instance should use the {@link GDFTenderSubSchedDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this gdf tender sub sched details.
	 *
	 * @return the primary key of this gdf tender sub sched details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this gdf tender sub sched details.
	 *
	 * @param primaryKey the primary key of this gdf tender sub sched details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tender sub sched ref ID of this gdf tender sub sched details.
	 *
	 * @return the tender sub sched ref ID of this gdf tender sub sched details
	 */
	public long getTenderSubSchedRefID();

	/**
	 * Sets the tender sub sched ref ID of this gdf tender sub sched details.
	 *
	 * @param tenderSubSchedRefID the tender sub sched ref ID of this gdf tender sub sched details
	 */
	public void setTenderSubSchedRefID(long tenderSubSchedRefID);

	/**
	 * Returns the tender item number of this gdf tender sub sched details.
	 *
	 * @return the tender item number of this gdf tender sub sched details
	 */
	public long getTenderItemNumber();

	/**
	 * Sets the tender item number of this gdf tender sub sched details.
	 *
	 * @param tenderItemNumber the tender item number of this gdf tender sub sched details
	 */
	public void setTenderItemNumber(long tenderItemNumber);

	/**
	 * Returns the schedule number of this gdf tender sub sched details.
	 *
	 * @return the schedule number of this gdf tender sub sched details
	 */
	public long getScheduleNumber();

	/**
	 * Sets the schedule number of this gdf tender sub sched details.
	 *
	 * @param scheduleNumber the schedule number of this gdf tender sub sched details
	 */
	public void setScheduleNumber(long scheduleNumber);

	/**
	 * Returns the gdf generic code of this gdf tender sub sched details.
	 *
	 * @return the gdf generic code of this gdf tender sub sched details
	 */
	@AutoEscape
	public String getGdfGenericCode();

	/**
	 * Sets the gdf generic code of this gdf tender sub sched details.
	 *
	 * @param gdfGenericCode the gdf generic code of this gdf tender sub sched details
	 */
	public void setGdfGenericCode(String gdfGenericCode);

	/**
	 * Returns the tender reference number of this gdf tender sub sched details.
	 *
	 * @return the tender reference number of this gdf tender sub sched details
	 */
	@AutoEscape
	public String getTenderReferenceNumber();

	/**
	 * Sets the tender reference number of this gdf tender sub sched details.
	 *
	 * @param tenderReferenceNumber the tender reference number of this gdf tender sub sched details
	 */
	public void setTenderReferenceNumber(String tenderReferenceNumber);

	/**
	 * Returns the schedule name of this gdf tender sub sched details.
	 *
	 * @return the schedule name of this gdf tender sub sched details
	 */
	@AutoEscape
	public String getScheduleName();

	/**
	 * Sets the schedule name of this gdf tender sub sched details.
	 *
	 * @param scheduleName the schedule name of this gdf tender sub sched details
	 */
	public void setScheduleName(String scheduleName);

	/**
	 * Returns the patient target of this gdf tender sub sched details.
	 *
	 * @return the patient target of this gdf tender sub sched details
	 */
	@AutoEscape
	public String getPatientTarget();

	/**
	 * Sets the patient target of this gdf tender sub sched details.
	 *
	 * @param patientTarget the patient target of this gdf tender sub sched details
	 */
	public void setPatientTarget(String patientTarget);

	/**
	 * Returns the tender item ref ID of this gdf tender sub sched details.
	 *
	 * @return the tender item ref ID of this gdf tender sub sched details
	 */
	public long getTenderItemRefID();

	/**
	 * Sets the tender item ref ID of this gdf tender sub sched details.
	 *
	 * @param tenderItemRefID the tender item ref ID of this gdf tender sub sched details
	 */
	public void setTenderItemRefID(long tenderItemRefID);

	/**
	 * Returns the user ID of this gdf tender sub sched details.
	 *
	 * @return the user ID of this gdf tender sub sched details
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this gdf tender sub sched details.
	 *
	 * @param userId the user ID of this gdf tender sub sched details
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this gdf tender sub sched details.
	 *
	 * @return the user uuid of this gdf tender sub sched details
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this gdf tender sub sched details.
	 *
	 * @param userUuid the user uuid of this gdf tender sub sched details
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this gdf tender sub sched details.
	 *
	 * @return the user name of this gdf tender sub sched details
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this gdf tender sub sched details.
	 *
	 * @param userName the user name of this gdf tender sub sched details
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this gdf tender sub sched details.
	 *
	 * @return the create date of this gdf tender sub sched details
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this gdf tender sub sched details.
	 *
	 * @param createDate the create date of this gdf tender sub sched details
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this gdf tender sub sched details.
	 *
	 * @return the modified date of this gdf tender sub sched details
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this gdf tender sub sched details.
	 *
	 * @param modifiedDate the modified date of this gdf tender sub sched details
	 */
	public void setModifiedDate(Date modifiedDate);

}