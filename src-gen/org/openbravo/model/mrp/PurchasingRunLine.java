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
package org.openbravo.model.mrp;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity MRPPurchasingRunLine (stored in table MRP_Run_PurchaseLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PurchasingRunLine extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MRP_Run_PurchaseLine";
    public static final String ENTITY_NAME = "MRPPurchasingRunLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MRPRUNPURCHASE = "mRPRunPurchase";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_NEEDEDQTY = "neededqty";
    public static final String PROPERTY_PLANNEDDATE = "planneddate";
    public static final String PROPERTY_INOUTTRXTYPE = "inouttrxtype";
    public static final String PROPERTY_ISFIXED = "isfixed";
    public static final String PROPERTY_ORDERLINE = "orderLine";
    public static final String PROPERTY_MRPSALESFORECASTLINE =
        "mRPSalesforecastline";
    public static final String PROPERTY_REQUISITIONLINE = "requisitionline";
    public static final String PROPERTY_ISCOMPLETED = "iscompleted";
    public static final String PROPERTY_PLANNEDORDERDATE = "plannedorderdate";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_CUMQTY = "cumqty";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_FRAMECONTRACTLINE = "framecontractline";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_TOTALDEMAND = "totaldemand";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_MANUFACTURER = "manufacturer";
    public static final String PROPERTY_QUANTITYORDER = "quantityorder";

    public PurchasingRunLine() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_NEEDEDQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISFIXED, false);
        setDefaultValue(PROPERTY_ISCOMPLETED, false);
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

    public PurchasingRun getMRPRunPurchase() {
        return (PurchasingRun) get(PROPERTY_MRPRUNPURCHASE);
    }

    public void setMRPRunPurchase(PurchasingRun mRPRunPurchase) {
        set(PROPERTY_MRPRUNPURCHASE, mRPRunPurchase);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getNeededqty() {
        return (BigDecimal) get(PROPERTY_NEEDEDQTY);
    }

    public void setNeededqty(BigDecimal neededqty) {
        set(PROPERTY_NEEDEDQTY, neededqty);
    }

    public Date getPlanneddate() {
        return (Date) get(PROPERTY_PLANNEDDATE);
    }

    public void setPlanneddate(Date planneddate) {
        set(PROPERTY_PLANNEDDATE, planneddate);
    }

    public String getInouttrxtype() {
        return (String) get(PROPERTY_INOUTTRXTYPE);
    }

    public void setInouttrxtype(String inouttrxtype) {
        set(PROPERTY_INOUTTRXTYPE, inouttrxtype);
    }

    public Boolean isFixed() {
        return (Boolean) get(PROPERTY_ISFIXED);
    }

    public void setFixed(Boolean isfixed) {
        set(PROPERTY_ISFIXED, isfixed);
    }

    public OrderLine getOrderLine() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderLine(OrderLine orderLine) {
        set(PROPERTY_ORDERLINE, orderLine);
    }

    public SalesForecastLine getMRPSalesforecastline() {
        return (SalesForecastLine) get(PROPERTY_MRPSALESFORECASTLINE);
    }

    public void setMRPSalesforecastline(SalesForecastLine mRPSalesforecastline) {
        set(PROPERTY_MRPSALESFORECASTLINE, mRPSalesforecastline);
    }

    public RequisitionLine getRequisitionline() {
        return (RequisitionLine) get(PROPERTY_REQUISITIONLINE);
    }

    public void setRequisitionline(RequisitionLine requisitionline) {
        set(PROPERTY_REQUISITIONLINE, requisitionline);
    }

    public Boolean isCompleted() {
        return (Boolean) get(PROPERTY_ISCOMPLETED);
    }

    public void setCompleted(Boolean iscompleted) {
        set(PROPERTY_ISCOMPLETED, iscompleted);
    }

    public Date getPlannedorderdate() {
        return (Date) get(PROPERTY_PLANNEDORDERDATE);
    }

    public void setPlannedorderdate(Date plannedorderdate) {
        set(PROPERTY_PLANNEDORDERDATE, plannedorderdate);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public BigDecimal getCumqty() {
        return (BigDecimal) get(PROPERTY_CUMQTY);
    }

    public void setCumqty(BigDecimal cumqty) {
        set(PROPERTY_CUMQTY, cumqty);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public BigDecimal getPricelist() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(BigDecimal pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public OrderLine getFramecontractline() {
        return (OrderLine) get(PROPERTY_FRAMECONTRACTLINE);
    }

    public void setFramecontractline(OrderLine framecontractline) {
        set(PROPERTY_FRAMECONTRACTLINE, framecontractline);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public BigDecimal getTotaldemand() {
        return (BigDecimal) get(PROPERTY_TOTALDEMAND);
    }

    public void setTotaldemand(BigDecimal totaldemand) {
        set(PROPERTY_TOTALDEMAND, totaldemand);
    }

    public org.openbravo.model.common.uom.UOM getUom() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUom(org.openbravo.model.common.uom.UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public org.openbravo.model.common.utility.m_manufacturer getManufacturer() {
        return (org.openbravo.model.common.utility.m_manufacturer) get(PROPERTY_MANUFACTURER);
    }

    public void setManufacturer(
        org.openbravo.model.common.utility.m_manufacturer manufacturer) {
        set(PROPERTY_MANUFACTURER, manufacturer);
    }

    public BigDecimal getQuantityorder() {
        return (BigDecimal) get(PROPERTY_QUANTITYORDER);
    }

    public void setQuantityorder(BigDecimal quantityorder) {
        set(PROPERTY_QUANTITYORDER, quantityorder);
    }
}
