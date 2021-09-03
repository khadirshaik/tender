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

import com.gdf.technical.bids.model.GDFTenderScheduleItem;
import com.gdf.technical.bids.model.GDFTenderScheduleItemModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the GDFTenderScheduleItem service. Represents a row in the &quot;PRT_GDF_Tender_Item_Details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GDFTenderScheduleItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GDFTenderScheduleItemImpl}.
 * </p>
 *
 * @author KS61374
 * @see GDFTenderScheduleItemImpl
 * @generated
 */
public class GDFTenderScheduleItemModelImpl
	extends BaseModelImpl<GDFTenderScheduleItem>
	implements GDFTenderScheduleItemModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gdf tender schedule item model instance should use the <code>GDFTenderScheduleItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "PRT_GDF_Tender_Item_Details";

	public static final Object[][] TABLE_COLUMNS = {
		{"GDF_Tender_Item_Ref_Id", Types.BIGINT},
		{"GDF_Tender_Item_Num", Types.BIGINT},
		{"GDF_Tender_Schedule_Number", Types.BIGINT},
		{"GDF_Generic_Desc", Types.VARCHAR}, {"Prim_Packaging", Types.VARCHAR},
		{"Sec_Packaging", Types.VARCHAR}, {"GDF_Generic_Code", Types.VARCHAR},
		{"GDF_Tender_Reference_Number", Types.VARCHAR},
		{"GDF_Tender_Schedule_Name", Types.VARCHAR},
		{"GDF_PatientTarget", Types.VARCHAR}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("GDF_Tender_Item_Ref_Id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("GDF_Tender_Item_Num", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("GDF_Tender_Schedule_Number", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("GDF_Generic_Desc", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Prim_Packaging", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Sec_Packaging", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GDF_Generic_Code", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GDF_Tender_Reference_Number", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GDF_Tender_Schedule_Name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GDF_PatientTarget", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PRT_GDF_Tender_Item_Details (GDF_Tender_Item_Ref_Id LONG not null primary key IDENTITY,GDF_Tender_Item_Num LONG,GDF_Tender_Schedule_Number LONG,GDF_Generic_Desc VARCHAR(500) null,Prim_Packaging VARCHAR(500) null,Sec_Packaging VARCHAR(500) null,GDF_Generic_Code VARCHAR(100) null,GDF_Tender_Reference_Number VARCHAR(100) null,GDF_Tender_Schedule_Name VARCHAR(100) null,GDF_PatientTarget VARCHAR(100) null,userId LONG,userName VARCHAR(100) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table PRT_GDF_Tender_Item_Details";

	public static final String ORDER_BY_JPQL =
		" ORDER BY gdfTenderScheduleItem.tenderItemRefID ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PRT_GDF_Tender_Item_Details.GDF_Tender_Item_Ref_Id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long GDFGENERICCODE_COLUMN_BITMASK = 1L;

	public static final long SCHEDULENUMBER_COLUMN_BITMASK = 2L;

	public static final long TENDERITEMNUMBER_COLUMN_BITMASK = 4L;

	public static final long TENDERREFERENCENUMBER_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long TENDERITEMREFID_COLUMN_BITMASK = 32L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public GDFTenderScheduleItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tenderItemRefID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTenderItemRefID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tenderItemRefID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GDFTenderScheduleItem.class;
	}

	@Override
	public String getModelClassName() {
		return GDFTenderScheduleItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<GDFTenderScheduleItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<GDFTenderScheduleItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GDFTenderScheduleItem, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((GDFTenderScheduleItem)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<GDFTenderScheduleItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<GDFTenderScheduleItem, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(GDFTenderScheduleItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<GDFTenderScheduleItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<GDFTenderScheduleItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, GDFTenderScheduleItem>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			GDFTenderScheduleItem.class.getClassLoader(),
			GDFTenderScheduleItem.class, ModelWrapper.class);

		try {
			Constructor<GDFTenderScheduleItem> constructor =
				(Constructor<GDFTenderScheduleItem>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<GDFTenderScheduleItem, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<GDFTenderScheduleItem, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<GDFTenderScheduleItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<GDFTenderScheduleItem, Object>>();
		Map<String, BiConsumer<GDFTenderScheduleItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<GDFTenderScheduleItem, ?>>();

		attributeGetterFunctions.put(
			"tenderItemRefID", GDFTenderScheduleItem::getTenderItemRefID);
		attributeSetterBiConsumers.put(
			"tenderItemRefID",
			(BiConsumer<GDFTenderScheduleItem, Long>)
				GDFTenderScheduleItem::setTenderItemRefID);
		attributeGetterFunctions.put(
			"tenderItemNumber", GDFTenderScheduleItem::getTenderItemNumber);
		attributeSetterBiConsumers.put(
			"tenderItemNumber",
			(BiConsumer<GDFTenderScheduleItem, Long>)
				GDFTenderScheduleItem::setTenderItemNumber);
		attributeGetterFunctions.put(
			"scheduleNumber", GDFTenderScheduleItem::getScheduleNumber);
		attributeSetterBiConsumers.put(
			"scheduleNumber",
			(BiConsumer<GDFTenderScheduleItem, Long>)
				GDFTenderScheduleItem::setScheduleNumber);
		attributeGetterFunctions.put(
			"generalDescription", GDFTenderScheduleItem::getGeneralDescription);
		attributeSetterBiConsumers.put(
			"generalDescription",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setGeneralDescription);
		attributeGetterFunctions.put(
			"primaryPackaging", GDFTenderScheduleItem::getPrimaryPackaging);
		attributeSetterBiConsumers.put(
			"primaryPackaging",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setPrimaryPackaging);
		attributeGetterFunctions.put(
			"secondaryPackaging", GDFTenderScheduleItem::getSecondaryPackaging);
		attributeSetterBiConsumers.put(
			"secondaryPackaging",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setSecondaryPackaging);
		attributeGetterFunctions.put(
			"gdfGenericCode", GDFTenderScheduleItem::getGdfGenericCode);
		attributeSetterBiConsumers.put(
			"gdfGenericCode",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setGdfGenericCode);
		attributeGetterFunctions.put(
			"tenderReferenceNumber",
			GDFTenderScheduleItem::getTenderReferenceNumber);
		attributeSetterBiConsumers.put(
			"tenderReferenceNumber",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setTenderReferenceNumber);
		attributeGetterFunctions.put(
			"scheduleName", GDFTenderScheduleItem::getScheduleName);
		attributeSetterBiConsumers.put(
			"scheduleName",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setScheduleName);
		attributeGetterFunctions.put(
			"patientTarget", GDFTenderScheduleItem::getPatientTarget);
		attributeSetterBiConsumers.put(
			"patientTarget",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setPatientTarget);
		attributeGetterFunctions.put(
			"userId", GDFTenderScheduleItem::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<GDFTenderScheduleItem, Long>)
				GDFTenderScheduleItem::setUserId);
		attributeGetterFunctions.put(
			"userName", GDFTenderScheduleItem::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<GDFTenderScheduleItem, String>)
				GDFTenderScheduleItem::setUserName);
		attributeGetterFunctions.put(
			"createDate", GDFTenderScheduleItem::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<GDFTenderScheduleItem, Date>)
				GDFTenderScheduleItem::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", GDFTenderScheduleItem::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<GDFTenderScheduleItem, Date>)
				GDFTenderScheduleItem::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getTenderItemRefID() {
		return _tenderItemRefID;
	}

	@Override
	public void setTenderItemRefID(long tenderItemRefID) {
		_tenderItemRefID = tenderItemRefID;
	}

	@Override
	public long getTenderItemNumber() {
		return _tenderItemNumber;
	}

	@Override
	public void setTenderItemNumber(long tenderItemNumber) {
		_columnBitmask |= TENDERITEMNUMBER_COLUMN_BITMASK;

		if (!_setOriginalTenderItemNumber) {
			_setOriginalTenderItemNumber = true;

			_originalTenderItemNumber = _tenderItemNumber;
		}

		_tenderItemNumber = tenderItemNumber;
	}

	public long getOriginalTenderItemNumber() {
		return _originalTenderItemNumber;
	}

	@Override
	public long getScheduleNumber() {
		return _scheduleNumber;
	}

	@Override
	public void setScheduleNumber(long scheduleNumber) {
		_columnBitmask |= SCHEDULENUMBER_COLUMN_BITMASK;

		if (!_setOriginalScheduleNumber) {
			_setOriginalScheduleNumber = true;

			_originalScheduleNumber = _scheduleNumber;
		}

		_scheduleNumber = scheduleNumber;
	}

	public long getOriginalScheduleNumber() {
		return _originalScheduleNumber;
	}

	@Override
	public String getGeneralDescription() {
		if (_generalDescription == null) {
			return "";
		}
		else {
			return _generalDescription;
		}
	}

	@Override
	public void setGeneralDescription(String generalDescription) {
		_generalDescription = generalDescription;
	}

	@Override
	public String getPrimaryPackaging() {
		if (_primaryPackaging == null) {
			return "";
		}
		else {
			return _primaryPackaging;
		}
	}

	@Override
	public void setPrimaryPackaging(String primaryPackaging) {
		_primaryPackaging = primaryPackaging;
	}

	@Override
	public String getSecondaryPackaging() {
		if (_secondaryPackaging == null) {
			return "";
		}
		else {
			return _secondaryPackaging;
		}
	}

	@Override
	public void setSecondaryPackaging(String secondaryPackaging) {
		_secondaryPackaging = secondaryPackaging;
	}

	@Override
	public String getGdfGenericCode() {
		if (_gdfGenericCode == null) {
			return "";
		}
		else {
			return _gdfGenericCode;
		}
	}

	@Override
	public void setGdfGenericCode(String gdfGenericCode) {
		_columnBitmask |= GDFGENERICCODE_COLUMN_BITMASK;

		if (_originalGdfGenericCode == null) {
			_originalGdfGenericCode = _gdfGenericCode;
		}

		_gdfGenericCode = gdfGenericCode;
	}

	public String getOriginalGdfGenericCode() {
		return GetterUtil.getString(_originalGdfGenericCode);
	}

	@Override
	public String getTenderReferenceNumber() {
		if (_tenderReferenceNumber == null) {
			return "";
		}
		else {
			return _tenderReferenceNumber;
		}
	}

	@Override
	public void setTenderReferenceNumber(String tenderReferenceNumber) {
		_columnBitmask |= TENDERREFERENCENUMBER_COLUMN_BITMASK;

		if (_originalTenderReferenceNumber == null) {
			_originalTenderReferenceNumber = _tenderReferenceNumber;
		}

		_tenderReferenceNumber = tenderReferenceNumber;
	}

	public String getOriginalTenderReferenceNumber() {
		return GetterUtil.getString(_originalTenderReferenceNumber);
	}

	@Override
	public String getScheduleName() {
		if (_scheduleName == null) {
			return "";
		}
		else {
			return _scheduleName;
		}
	}

	@Override
	public void setScheduleName(String scheduleName) {
		_scheduleName = scheduleName;
	}

	@Override
	public String getPatientTarget() {
		if (_patientTarget == null) {
			return "";
		}
		else {
			return _patientTarget;
		}
	}

	@Override
	public void setPatientTarget(String patientTarget) {
		_patientTarget = patientTarget;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, GDFTenderScheduleItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GDFTenderScheduleItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, GDFTenderScheduleItem>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GDFTenderScheduleItemImpl gdfTenderScheduleItemImpl =
			new GDFTenderScheduleItemImpl();

		gdfTenderScheduleItemImpl.setTenderItemRefID(getTenderItemRefID());
		gdfTenderScheduleItemImpl.setTenderItemNumber(getTenderItemNumber());
		gdfTenderScheduleItemImpl.setScheduleNumber(getScheduleNumber());
		gdfTenderScheduleItemImpl.setGeneralDescription(
			getGeneralDescription());
		gdfTenderScheduleItemImpl.setPrimaryPackaging(getPrimaryPackaging());
		gdfTenderScheduleItemImpl.setSecondaryPackaging(
			getSecondaryPackaging());
		gdfTenderScheduleItemImpl.setGdfGenericCode(getGdfGenericCode());
		gdfTenderScheduleItemImpl.setTenderReferenceNumber(
			getTenderReferenceNumber());
		gdfTenderScheduleItemImpl.setScheduleName(getScheduleName());
		gdfTenderScheduleItemImpl.setPatientTarget(getPatientTarget());
		gdfTenderScheduleItemImpl.setUserId(getUserId());
		gdfTenderScheduleItemImpl.setUserName(getUserName());
		gdfTenderScheduleItemImpl.setCreateDate(getCreateDate());
		gdfTenderScheduleItemImpl.setModifiedDate(getModifiedDate());

		gdfTenderScheduleItemImpl.resetOriginalValues();

		return gdfTenderScheduleItemImpl;
	}

	@Override
	public int compareTo(GDFTenderScheduleItem gdfTenderScheduleItem) {
		long primaryKey = gdfTenderScheduleItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GDFTenderScheduleItem)) {
			return false;
		}

		GDFTenderScheduleItem gdfTenderScheduleItem =
			(GDFTenderScheduleItem)obj;

		long primaryKey = gdfTenderScheduleItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		GDFTenderScheduleItemModelImpl gdfTenderScheduleItemModelImpl = this;

		gdfTenderScheduleItemModelImpl._originalTenderItemNumber =
			gdfTenderScheduleItemModelImpl._tenderItemNumber;

		gdfTenderScheduleItemModelImpl._setOriginalTenderItemNumber = false;

		gdfTenderScheduleItemModelImpl._originalScheduleNumber =
			gdfTenderScheduleItemModelImpl._scheduleNumber;

		gdfTenderScheduleItemModelImpl._setOriginalScheduleNumber = false;

		gdfTenderScheduleItemModelImpl._originalGdfGenericCode =
			gdfTenderScheduleItemModelImpl._gdfGenericCode;

		gdfTenderScheduleItemModelImpl._originalTenderReferenceNumber =
			gdfTenderScheduleItemModelImpl._tenderReferenceNumber;

		gdfTenderScheduleItemModelImpl._originalUserId =
			gdfTenderScheduleItemModelImpl._userId;

		gdfTenderScheduleItemModelImpl._setOriginalUserId = false;

		gdfTenderScheduleItemModelImpl._setModifiedDate = false;

		gdfTenderScheduleItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GDFTenderScheduleItem> toCacheModel() {
		GDFTenderScheduleItemCacheModel gdfTenderScheduleItemCacheModel =
			new GDFTenderScheduleItemCacheModel();

		gdfTenderScheduleItemCacheModel.tenderItemRefID = getTenderItemRefID();

		gdfTenderScheduleItemCacheModel.tenderItemNumber =
			getTenderItemNumber();

		gdfTenderScheduleItemCacheModel.scheduleNumber = getScheduleNumber();

		gdfTenderScheduleItemCacheModel.generalDescription =
			getGeneralDescription();

		String generalDescription =
			gdfTenderScheduleItemCacheModel.generalDescription;

		if ((generalDescription != null) &&
			(generalDescription.length() == 0)) {

			gdfTenderScheduleItemCacheModel.generalDescription = null;
		}

		gdfTenderScheduleItemCacheModel.primaryPackaging =
			getPrimaryPackaging();

		String primaryPackaging =
			gdfTenderScheduleItemCacheModel.primaryPackaging;

		if ((primaryPackaging != null) && (primaryPackaging.length() == 0)) {
			gdfTenderScheduleItemCacheModel.primaryPackaging = null;
		}

		gdfTenderScheduleItemCacheModel.secondaryPackaging =
			getSecondaryPackaging();

		String secondaryPackaging =
			gdfTenderScheduleItemCacheModel.secondaryPackaging;

		if ((secondaryPackaging != null) &&
			(secondaryPackaging.length() == 0)) {

			gdfTenderScheduleItemCacheModel.secondaryPackaging = null;
		}

		gdfTenderScheduleItemCacheModel.gdfGenericCode = getGdfGenericCode();

		String gdfGenericCode = gdfTenderScheduleItemCacheModel.gdfGenericCode;

		if ((gdfGenericCode != null) && (gdfGenericCode.length() == 0)) {
			gdfTenderScheduleItemCacheModel.gdfGenericCode = null;
		}

		gdfTenderScheduleItemCacheModel.tenderReferenceNumber =
			getTenderReferenceNumber();

		String tenderReferenceNumber =
			gdfTenderScheduleItemCacheModel.tenderReferenceNumber;

		if ((tenderReferenceNumber != null) &&
			(tenderReferenceNumber.length() == 0)) {

			gdfTenderScheduleItemCacheModel.tenderReferenceNumber = null;
		}

		gdfTenderScheduleItemCacheModel.scheduleName = getScheduleName();

		String scheduleName = gdfTenderScheduleItemCacheModel.scheduleName;

		if ((scheduleName != null) && (scheduleName.length() == 0)) {
			gdfTenderScheduleItemCacheModel.scheduleName = null;
		}

		gdfTenderScheduleItemCacheModel.patientTarget = getPatientTarget();

		String patientTarget = gdfTenderScheduleItemCacheModel.patientTarget;

		if ((patientTarget != null) && (patientTarget.length() == 0)) {
			gdfTenderScheduleItemCacheModel.patientTarget = null;
		}

		gdfTenderScheduleItemCacheModel.userId = getUserId();

		gdfTenderScheduleItemCacheModel.userName = getUserName();

		String userName = gdfTenderScheduleItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			gdfTenderScheduleItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			gdfTenderScheduleItemCacheModel.createDate = createDate.getTime();
		}
		else {
			gdfTenderScheduleItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			gdfTenderScheduleItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			gdfTenderScheduleItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return gdfTenderScheduleItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<GDFTenderScheduleItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<GDFTenderScheduleItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GDFTenderScheduleItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((GDFTenderScheduleItem)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<GDFTenderScheduleItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<GDFTenderScheduleItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GDFTenderScheduleItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((GDFTenderScheduleItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, GDFTenderScheduleItem>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _tenderItemRefID;
	private long _tenderItemNumber;
	private long _originalTenderItemNumber;
	private boolean _setOriginalTenderItemNumber;
	private long _scheduleNumber;
	private long _originalScheduleNumber;
	private boolean _setOriginalScheduleNumber;
	private String _generalDescription;
	private String _primaryPackaging;
	private String _secondaryPackaging;
	private String _gdfGenericCode;
	private String _originalGdfGenericCode;
	private String _tenderReferenceNumber;
	private String _originalTenderReferenceNumber;
	private String _scheduleName;
	private String _patientTarget;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private GDFTenderScheduleItem _escapedModel;

}