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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the GDFTenderSubFPPRegDetails service. Represents a row in the &quot;PRT_GDFTender_SubFppReg_Det&quot; database table, with each column mapped to a property of this class.
 *
 * @author KS61374
 * @see GDFTenderSubFPPRegDetailsModel
 * @generated
 */
@ImplementationClassName(
	"com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsImpl"
)
@ProviderType
public interface GDFTenderSubFPPRegDetails
	extends GDFTenderSubFPPRegDetailsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.gdf.technical.bids.model.impl.GDFTenderSubFPPRegDetailsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GDFTenderSubFPPRegDetails, Long>
		TENDER_REG_REF_ID_ACCESSOR =
			new Accessor<GDFTenderSubFPPRegDetails, Long>() {

				@Override
				public Long get(
					GDFTenderSubFPPRegDetails gdfTenderSubFPPRegDetails) {

					return gdfTenderSubFPPRegDetails.getTenderRegRefID();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<GDFTenderSubFPPRegDetails> getTypeClass() {
					return GDFTenderSubFPPRegDetails.class;
				}

			};

}