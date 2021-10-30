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

package com.liferay.commerce.demo.product.specification.template.model.impl;

import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMapping;
import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMappingModel;
import com.liferay.commerce.demo.product.specification.template.model.ProductSpecificationMappingSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProductSpecificationMapping service. Represents a row in the &quot;PT_ProductSpecificationMapping&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductSpecificationMappingModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductSpecificationMappingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductSpecificationMappingImpl
 * @generated
 */
@JSON(strict = true)
public class ProductSpecificationMappingModelImpl
	extends BaseModelImpl<ProductSpecificationMapping>
	implements ProductSpecificationMappingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product specification mapping model instance should use the <code>ProductSpecificationMapping</code> interface instead.
	 */
	public static final String TABLE_NAME = "PT_ProductSpecificationMapping";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"productSpecificationMappingId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"productType", Types.VARCHAR},
		{"cpSpecificationOptionId", Types.BIGINT},
		{"cpOptionCategoryId", Types.BIGINT}, {"priority", Types.DOUBLE},
		{"defaultValue", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productSpecificationMappingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("productType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cpSpecificationOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cpOptionCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("defaultValue", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PT_ProductSpecificationMapping (uuid_ VARCHAR(75) null,productSpecificationMappingId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,productType VARCHAR(75) null,cpSpecificationOptionId LONG,cpOptionCategoryId LONG,priority DOUBLE,defaultValue STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table PT_ProductSpecificationMapping";

	public static final String ORDER_BY_JPQL =
		" ORDER BY productSpecificationMapping.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PT_ProductSpecificationMapping.priority ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRODUCTTYPE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRIORITY_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ProductSpecificationMapping toModel(
		ProductSpecificationMappingSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		ProductSpecificationMapping model =
			new ProductSpecificationMappingImpl();

		model.setUuid(soapModel.getUuid());
		model.setProductSpecificationMappingId(
			soapModel.getProductSpecificationMappingId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setProductType(soapModel.getProductType());
		model.setCpSpecificationOptionId(
			soapModel.getCpSpecificationOptionId());
		model.setCpOptionCategoryId(soapModel.getCpOptionCategoryId());
		model.setPriority(soapModel.getPriority());
		model.setDefaultValue(soapModel.getDefaultValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ProductSpecificationMapping> toModels(
		ProductSpecificationMappingSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ProductSpecificationMapping> models =
			new ArrayList<ProductSpecificationMapping>(soapModels.length);

		for (ProductSpecificationMappingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ProductSpecificationMappingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _productSpecificationMappingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProductSpecificationMappingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productSpecificationMappingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProductSpecificationMapping.class;
	}

	@Override
	public String getModelClassName() {
		return ProductSpecificationMapping.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProductSpecificationMapping, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProductSpecificationMapping, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductSpecificationMapping, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(ProductSpecificationMapping)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProductSpecificationMapping, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProductSpecificationMapping, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProductSpecificationMapping)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProductSpecificationMapping, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProductSpecificationMapping, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProductSpecificationMapping>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProductSpecificationMapping.class.getClassLoader(),
			ProductSpecificationMapping.class, ModelWrapper.class);

		try {
			Constructor<ProductSpecificationMapping> constructor =
				(Constructor<ProductSpecificationMapping>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<ProductSpecificationMapping, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProductSpecificationMapping, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProductSpecificationMapping, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProductSpecificationMapping, Object>>();
		Map<String, BiConsumer<ProductSpecificationMapping, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ProductSpecificationMapping, ?>>();

		attributeGetterFunctions.put(
			"uuid", ProductSpecificationMapping::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProductSpecificationMapping, String>)
				ProductSpecificationMapping::setUuid);
		attributeGetterFunctions.put(
			"productSpecificationMappingId",
			ProductSpecificationMapping::getProductSpecificationMappingId);
		attributeSetterBiConsumers.put(
			"productSpecificationMappingId",
			(BiConsumer<ProductSpecificationMapping, Long>)
				ProductSpecificationMapping::setProductSpecificationMappingId);
		attributeGetterFunctions.put(
			"companyId", ProductSpecificationMapping::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProductSpecificationMapping, Long>)
				ProductSpecificationMapping::setCompanyId);
		attributeGetterFunctions.put(
			"userId", ProductSpecificationMapping::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProductSpecificationMapping, Long>)
				ProductSpecificationMapping::setUserId);
		attributeGetterFunctions.put(
			"userName", ProductSpecificationMapping::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProductSpecificationMapping, String>)
				ProductSpecificationMapping::setUserName);
		attributeGetterFunctions.put(
			"createDate", ProductSpecificationMapping::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProductSpecificationMapping, Date>)
				ProductSpecificationMapping::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProductSpecificationMapping::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProductSpecificationMapping, Date>)
				ProductSpecificationMapping::setModifiedDate);
		attributeGetterFunctions.put(
			"productType", ProductSpecificationMapping::getProductType);
		attributeSetterBiConsumers.put(
			"productType",
			(BiConsumer<ProductSpecificationMapping, String>)
				ProductSpecificationMapping::setProductType);
		attributeGetterFunctions.put(
			"cpSpecificationOptionId",
			ProductSpecificationMapping::getCpSpecificationOptionId);
		attributeSetterBiConsumers.put(
			"cpSpecificationOptionId",
			(BiConsumer<ProductSpecificationMapping, Long>)
				ProductSpecificationMapping::setCpSpecificationOptionId);
		attributeGetterFunctions.put(
			"cpOptionCategoryId",
			ProductSpecificationMapping::getCpOptionCategoryId);
		attributeSetterBiConsumers.put(
			"cpOptionCategoryId",
			(BiConsumer<ProductSpecificationMapping, Long>)
				ProductSpecificationMapping::setCpOptionCategoryId);
		attributeGetterFunctions.put(
			"priority", ProductSpecificationMapping::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<ProductSpecificationMapping, Double>)
				ProductSpecificationMapping::setPriority);
		attributeGetterFunctions.put(
			"defaultValue", ProductSpecificationMapping::getDefaultValue);
		attributeSetterBiConsumers.put(
			"defaultValue",
			(BiConsumer<ProductSpecificationMapping, String>)
				ProductSpecificationMapping::setDefaultValue);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getProductSpecificationMappingId() {
		return _productSpecificationMappingId;
	}

	@Override
	public void setProductSpecificationMappingId(
		long productSpecificationMappingId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_productSpecificationMappingId = productSpecificationMappingId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
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

	@JSON
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getProductType() {
		if (_productType == null) {
			return "";
		}
		else {
			return _productType;
		}
	}

	@Override
	public void setProductType(String productType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_productType = productType;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalProductType() {
		return getColumnOriginalValue("productType");
	}

	@JSON
	@Override
	public long getCpSpecificationOptionId() {
		return _cpSpecificationOptionId;
	}

	@Override
	public void setCpSpecificationOptionId(long cpSpecificationOptionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cpSpecificationOptionId = cpSpecificationOptionId;
	}

	@JSON
	@Override
	public long getCpOptionCategoryId() {
		return _cpOptionCategoryId;
	}

	@Override
	public void setCpOptionCategoryId(long cpOptionCategoryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cpOptionCategoryId = cpOptionCategoryId;
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_priority = priority;
	}

	@JSON
	@Override
	public String getDefaultValue() {
		if (_defaultValue == null) {
			return "";
		}
		else {
			return _defaultValue;
		}
	}

	@Override
	public String getDefaultValue(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDefaultValue(languageId);
	}

	@Override
	public String getDefaultValue(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDefaultValue(languageId, useDefault);
	}

	@Override
	public String getDefaultValue(String languageId) {
		return LocalizationUtil.getLocalization(getDefaultValue(), languageId);
	}

	@Override
	public String getDefaultValue(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDefaultValue(), languageId, useDefault);
	}

	@Override
	public String getDefaultValueCurrentLanguageId() {
		return _defaultValueCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDefaultValueCurrentValue() {
		Locale locale = getLocale(_defaultValueCurrentLanguageId);

		return getDefaultValue(locale);
	}

	@Override
	public Map<Locale, String> getDefaultValueMap() {
		return LocalizationUtil.getLocalizationMap(getDefaultValue());
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_defaultValue = defaultValue;
	}

	@Override
	public void setDefaultValue(String defaultValue, Locale locale) {
		setDefaultValue(defaultValue, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDefaultValue(
		String defaultValue, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(defaultValue)) {
			setDefaultValue(
				LocalizationUtil.updateLocalization(
					getDefaultValue(), "DefaultValue", defaultValue, languageId,
					defaultLanguageId));
		}
		else {
			setDefaultValue(
				LocalizationUtil.removeLocalization(
					getDefaultValue(), "DefaultValue", languageId));
		}
	}

	@Override
	public void setDefaultValueCurrentLanguageId(String languageId) {
		_defaultValueCurrentLanguageId = languageId;
	}

	@Override
	public void setDefaultValueMap(Map<Locale, String> defaultValueMap) {
		setDefaultValueMap(defaultValueMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDefaultValueMap(
		Map<Locale, String> defaultValueMap, Locale defaultLocale) {

		if (defaultValueMap == null) {
			return;
		}

		setDefaultValue(
			LocalizationUtil.updateLocalization(
				defaultValueMap, getDefaultValue(), "DefaultValue",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				ProductSpecificationMapping.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProductSpecificationMapping.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> defaultValueMap = getDefaultValueMap();

		for (Map.Entry<Locale, String> entry : defaultValueMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getDefaultValue();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			ProductSpecificationMapping.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String defaultValue = getDefaultValue(defaultLocale);

		if (Validator.isNull(defaultValue)) {
			setDefaultValue(
				getDefaultValue(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDefaultValue(
				getDefaultValue(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public ProductSpecificationMapping toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProductSpecificationMapping>
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
		ProductSpecificationMappingImpl productSpecificationMappingImpl =
			new ProductSpecificationMappingImpl();

		productSpecificationMappingImpl.setUuid(getUuid());
		productSpecificationMappingImpl.setProductSpecificationMappingId(
			getProductSpecificationMappingId());
		productSpecificationMappingImpl.setCompanyId(getCompanyId());
		productSpecificationMappingImpl.setUserId(getUserId());
		productSpecificationMappingImpl.setUserName(getUserName());
		productSpecificationMappingImpl.setCreateDate(getCreateDate());
		productSpecificationMappingImpl.setModifiedDate(getModifiedDate());
		productSpecificationMappingImpl.setProductType(getProductType());
		productSpecificationMappingImpl.setCpSpecificationOptionId(
			getCpSpecificationOptionId());
		productSpecificationMappingImpl.setCpOptionCategoryId(
			getCpOptionCategoryId());
		productSpecificationMappingImpl.setPriority(getPriority());
		productSpecificationMappingImpl.setDefaultValue(getDefaultValue());

		productSpecificationMappingImpl.resetOriginalValues();

		return productSpecificationMappingImpl;
	}

	@Override
	public int compareTo(
		ProductSpecificationMapping productSpecificationMapping) {

		int value = 0;

		if (getPriority() < productSpecificationMapping.getPriority()) {
			value = -1;
		}
		else if (getPriority() > productSpecificationMapping.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductSpecificationMapping)) {
			return false;
		}

		ProductSpecificationMapping productSpecificationMapping =
			(ProductSpecificationMapping)object;

		long primaryKey = productSpecificationMapping.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ProductSpecificationMapping> toCacheModel() {
		ProductSpecificationMappingCacheModel
			productSpecificationMappingCacheModel =
				new ProductSpecificationMappingCacheModel();

		productSpecificationMappingCacheModel.uuid = getUuid();

		String uuid = productSpecificationMappingCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			productSpecificationMappingCacheModel.uuid = null;
		}

		productSpecificationMappingCacheModel.productSpecificationMappingId =
			getProductSpecificationMappingId();

		productSpecificationMappingCacheModel.companyId = getCompanyId();

		productSpecificationMappingCacheModel.userId = getUserId();

		productSpecificationMappingCacheModel.userName = getUserName();

		String userName = productSpecificationMappingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			productSpecificationMappingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			productSpecificationMappingCacheModel.createDate =
				createDate.getTime();
		}
		else {
			productSpecificationMappingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productSpecificationMappingCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			productSpecificationMappingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		productSpecificationMappingCacheModel.productType = getProductType();

		String productType = productSpecificationMappingCacheModel.productType;

		if ((productType != null) && (productType.length() == 0)) {
			productSpecificationMappingCacheModel.productType = null;
		}

		productSpecificationMappingCacheModel.cpSpecificationOptionId =
			getCpSpecificationOptionId();

		productSpecificationMappingCacheModel.cpOptionCategoryId =
			getCpOptionCategoryId();

		productSpecificationMappingCacheModel.priority = getPriority();

		productSpecificationMappingCacheModel.defaultValue = getDefaultValue();

		String defaultValue =
			productSpecificationMappingCacheModel.defaultValue;

		if ((defaultValue != null) && (defaultValue.length() == 0)) {
			productSpecificationMappingCacheModel.defaultValue = null;
		}

		return productSpecificationMappingCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProductSpecificationMapping, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProductSpecificationMapping, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductSpecificationMapping, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(ProductSpecificationMapping)this));
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
		Map<String, Function<ProductSpecificationMapping, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProductSpecificationMapping, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductSpecificationMapping, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(ProductSpecificationMapping)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, ProductSpecificationMapping>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private long _productSpecificationMappingId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _productType;
	private long _cpSpecificationOptionId;
	private long _cpOptionCategoryId;
	private double _priority;
	private String _defaultValue;
	private String _defaultValueCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProductSpecificationMapping, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProductSpecificationMapping)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"productSpecificationMappingId", _productSpecificationMappingId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("productType", _productType);
		_columnOriginalValues.put(
			"cpSpecificationOptionId", _cpSpecificationOptionId);
		_columnOriginalValues.put("cpOptionCategoryId", _cpOptionCategoryId);
		_columnOriginalValues.put("priority", _priority);
		_columnOriginalValues.put("defaultValue", _defaultValue);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("productSpecificationMappingId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("productType", 128L);

		columnBitmasks.put("cpSpecificationOptionId", 256L);

		columnBitmasks.put("cpOptionCategoryId", 512L);

		columnBitmasks.put("priority", 1024L);

		columnBitmasks.put("defaultValue", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProductSpecificationMapping _escapedModel;

}