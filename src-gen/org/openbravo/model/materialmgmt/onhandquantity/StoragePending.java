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
package org.openbravo.model.materialmgmt.onhandquantity;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity MaterialMgmtStoragePending (stored in table M_Storage_Pending).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class StoragePending extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Storage_Pending";
    public static final String ENTITY_NAME = "MaterialMgmtStoragePending";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_QTYRESERVED = "qtyReserved";
    public static final String PROPERTY_QTYORDERRESERVED = "qtyOrderReserved";
    public static final String PROPERTY_QTYORDERED = "qtyOrdered";
    public static final String PROPERTY_QTYORDERORDERED = "qtyOrderOrdered";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";

    public StoragePending() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributeSetInstance(
        AttributeSetInstance attributeSetInstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributeSetInstance);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public BigDecimal getQtyReserved() {
        return (BigDecimal) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyReserved(BigDecimal qtyReserved) {
        set(PROPERTY_QTYRESERVED, qtyReserved);
    }

    public BigDecimal getQtyOrderReserved() {
        return (BigDecimal) get(PROPERTY_QTYORDERRESERVED);
    }

    public void setQtyOrderReserved(BigDecimal qtyOrderReserved) {
        set(PROPERTY_QTYORDERRESERVED, qtyOrderReserved);
    }

    public BigDecimal getQtyOrdered() {
        return (BigDecimal) get(PROPERTY_QTYORDERED);
    }

    public void setQtyOrdered(BigDecimal qtyOrdered) {
        set(PROPERTY_QTYORDERED, qtyOrdered);
    }

    public BigDecimal getQtyOrderOrdered() {
        return (BigDecimal) get(PROPERTY_QTYORDERORDERED);
    }

    public void setQtyOrderOrdered(BigDecimal qtyOrderOrdered) {
        set(PROPERTY_QTYORDERORDERED, qtyOrderOrdered);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }
}
