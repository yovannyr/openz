/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.common.currency;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity CurrencyConversionRate (stored in table C_Conversion_Rate).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ConversionRate extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Conversion_Rate";
    public static final String ENTITY_NAME = "CurrencyConversionRate";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CURRENCYIDTO = "currencyIDTo";
    public static final String PROPERTY_VALIDFROM = "validFrom";
    public static final String PROPERTY_VALIDTO = "validTo";
    public static final String PROPERTY_CONVERSIONRATETYPE =
        "conversionRateType";
    public static final String PROPERTY_MULTIPLYRATE = "multiplyRate";
    public static final String PROPERTY_DIVIDERATE = "divideRate";

    public ConversionRate() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CONVERSIONRATETYPE, "S");
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Currency getCurrencyIDTo() {
        return (Currency) get(PROPERTY_CURRENCYIDTO);
    }

    public void setCurrencyIDTo(Currency currencyIDTo) {
        set(PROPERTY_CURRENCYIDTO, currencyIDTo);
    }

    public Date getValidFrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidFrom(Date validFrom) {
        set(PROPERTY_VALIDFROM, validFrom);
    }

    public Date getValidTo() {
        return (Date) get(PROPERTY_VALIDTO);
    }

    public void setValidTo(Date validTo) {
        set(PROPERTY_VALIDTO, validTo);
    }

    public String getConversionRateType() {
        return (String) get(PROPERTY_CONVERSIONRATETYPE);
    }

    public void setConversionRateType(String conversionRateType) {
        set(PROPERTY_CONVERSIONRATETYPE, conversionRateType);
    }

    public BigDecimal getMultiplyRate() {
        return (BigDecimal) get(PROPERTY_MULTIPLYRATE);
    }

    public void setMultiplyRate(BigDecimal multiplyRate) {
        set(PROPERTY_MULTIPLYRATE, multiplyRate);
    }

    public BigDecimal getDivideRate() {
        return (BigDecimal) get(PROPERTY_DIVIDERATE);
    }

    public void setDivideRate(BigDecimal divideRate) {
        set(PROPERTY_DIVIDERATE, divideRate);
    }
}
