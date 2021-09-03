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

import com.gdf.technical.bids.model.GDFTenderSubSchedDetails;
import com.gdf.technical.bids.service.GDFTenderSubSchedDetailsLocalServiceUtil;

/**
 * The extended model base implementation for the GDFTenderSubSchedDetails service. Represents a row in the &quot;PRT_GDFTender_SubSched_Det&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GDFTenderSubSchedDetailsImpl}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderSubSchedDetailsImpl
 * @see GDFTenderSubSchedDetails
 * @generated
 */
public abstract class GDFTenderSubSchedDetailsBaseImpl
	extends GDFTenderSubSchedDetailsModelImpl
	implements GDFTenderSubSchedDetails {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gdf tender sub sched details model instance should use the <code>GDFTenderSubSchedDetails</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			GDFTenderSubSchedDetailsLocalServiceUtil.
				addGDFTenderSubSchedDetails(this);
		}
		else {
			GDFTenderSubSchedDetailsLocalServiceUtil.
				updateGDFTenderSubSchedDetails(this);
		}
	}

}