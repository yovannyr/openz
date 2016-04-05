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
package org.openbravo.model.pricing.pricelist;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity PricingProductPrice (stored in table M_ProductPrice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProductPrice extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_ProductPrice";
    public static final String ENTITY_NAME = "PricingProductPrice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRICELISTVERSION = "priceListVersion";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICESTD = "priceStd";
    public static final String PROPERTY_PRICELIMIT = "priceLimit";
    public static final String PROPERTY_MANUFACTURER = "manufacturer";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_ISSTANDARD = "isstandard";
    public static final String PROPERTY_OFFERPLISTVLIST = "offerplistVList";

    public ProductPrice() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSTANDARD, false);
        setDefaultValue(PROPERTY_OFFERPLISTVLIST, new ArrayList<Object>());
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

    public PriceListVersion getPriceListVersion() {
        return (PriceListVersion) get(PROPERTY_PRICELISTVERSION);
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        set(PROPERTY_PRICELISTVERSION, priceListVersion);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
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

    public BigDecimal getPriceList() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(BigDecimal priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public BigDecimal getPriceStd() {
        return (BigDecimal) get(PROPERTY_PRICESTD);
    }

    public void setPriceStd(BigDecimal priceStd) {
        set(PROPERTY_PRICESTD, priceStd);
    }

    public BigDecimal getPriceLimit() {
        return (BigDecimal) get(PROPERTY_PRICELIMIT);
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        set(PROPERTY_PRICELIMIT, priceLimit);
    }

    public org.openbravo.model.common.utility.m_manufacturer getManufacturer() {
        return (org.openbravo.model.common.utility.m_manufacturer) get(PROPERTY_MANUFACTURER);
    }

    public void setManufacturer(
        org.openbravo.model.common.utility.m_manufacturer manufacturer) {
        set(PROPERTY_MANUFACTURER, manufacturer);
    }

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public Boolean isStandard() {
        return (Boolean) get(PROPERTY_ISSTANDARD);
    }

    public void setStandard(Boolean isstandard) {
        set(PROPERTY_ISSTANDARD, isstandard);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.priceadjustment.m_offerplist_v> getOfferplistVList() {
        return (List<org.openbravo.model.pricing.priceadjustment.m_offerplist_v>) get(PROPERTY_OFFERPLISTVLIST);
    }

    public void setOfferplistVList(
        List<org.openbravo.model.pricing.priceadjustment.m_offerplist_v> offerplistVList) {
        set(PROPERTY_OFFERPLISTVLIST, offerplistVList);
    }
}
