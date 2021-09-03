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
package com.gdf.technical.bids.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author KS61374
 */
public class NoSuchGDFTenderSubFPPRegDetailsException extends NoSuchModelException {

	public NoSuchGDFTenderSubFPPRegDetailsException() {
	}

	public NoSuchGDFTenderSubFPPRegDetailsException(String msg) {
		super(msg);
	}

	public NoSuchGDFTenderSubFPPRegDetailsException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchGDFTenderSubFPPRegDetailsException(Throwable cause) {
		super(cause);
	}

}