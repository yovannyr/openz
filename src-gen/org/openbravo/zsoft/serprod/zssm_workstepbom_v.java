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
package org.openbravo.zsoft.serprod;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.zsoft.projects.Zspm_projecttaskbom;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity zssm_workstepbom_v (stored in table zssm_workstepbom_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_workstepbom_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_workstepbom_v";
    public static final String ENTITY_NAME = "zssm_workstepbom_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSSMWORKSTEPPRPV = "zssmWorkstepPrpV";
    public static final String PROPERTY_ZSPMPROJECTTASKBOM =
        "zspmProjecttaskbom";
    public static final String PROPERTY_ZSSMWORKSTEPV = "zssmWorkstepV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ACTUALCOSAMOUNT = "actualcosamount";
    public static final String PROPERTY_CONSTUCTIVEMEASURE =
        "constuctivemeasure";
    public static final String PROPERTY_RAWMATERIAL = "rawmaterial";
    public static final String PROPERTY_CUTOFF = "cutoff";
    public static final String PROPERTY_QTYPLAN = "qTYPlan";
    public static final String PROPERTY_QTYRESERVED = "qtyreserved";
    public static final String PROPERTY_QTYINREQUISITION = "qtyinrequisition";
    public static final String PROPERTY_QTYRECEIVED = "qtyreceived";
    public static final String PROPERTY_DATEPLAN = "datePlan";
    public static final String PROPERTY_PLANREQUISITION = "planrequisition";
    public static final String PROPERTY_ISSUINGLOCATOR = "issuingLocator";
    public static final String PROPERTY_RECEIVINGLOCATOR = "receivingLocator";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_QTYAVAILABLE = "qTYAvailable";
    public static final String PROPERTY_QTYINSTOCK = "qTYInstock";
    public static final String PROPERTY_SNRBATCHMASTERDATA =
        "sNRBatchmasterdata";

    public zssm_workstepbom_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_QTYRESERVED, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYINREQUISITION, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYRECEIVED, new BigDecimal(0));
        setDefaultValue(PROPERTY_PLANREQUISITION, false);
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

    public org.openbravo.zsoft.serprod.zssm_workstep_prp_v getZssmWorkstepPrpV() {
        return (org.openbravo.zsoft.serprod.zssm_workstep_prp_v) get(PROPERTY_ZSSMWORKSTEPPRPV);
    }

    public void setZssmWorkstepPrpV(
        org.openbravo.zsoft.serprod.zssm_workstep_prp_v zssmWorkstepPrpV) {
        set(PROPERTY_ZSSMWORKSTEPPRPV, zssmWorkstepPrpV);
    }

    public Zspm_projecttaskbom getZspmProjecttaskbom() {
        return (Zspm_projecttaskbom) get(PROPERTY_ZSPMPROJECTTASKBOM);
    }

    public void setZspmProjecttaskbom(Zspm_projecttaskbom zspmProjecttaskbom) {
        set(PROPERTY_ZSPMPROJECTTASKBOM, zspmProjecttaskbom);
    }

    public org.openbravo.zsoft.serprod.zssm_workstep_v getZssmWorkstepV() {
        return (org.openbravo.zsoft.serprod.zssm_workstep_v) get(PROPERTY_ZSSMWORKSTEPV);
    }

    public void setZssmWorkstepV(
        org.openbravo.zsoft.serprod.zssm_workstep_v zssmWorkstepV) {
        set(PROPERTY_ZSSMWORKSTEPV, zssmWorkstepV);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getActualcosamount() {
        return (BigDecimal) get(PROPERTY_ACTUALCOSAMOUNT);
    }

    public void setActualcosamount(BigDecimal actualcosamount) {
        set(PROPERTY_ACTUALCOSAMOUNT, actualcosamount);
    }

    public String getConstuctivemeasure() {
        return (String) get(PROPERTY_CONSTUCTIVEMEASURE);
    }

    public void setConstuctivemeasure(String constuctivemeasure) {
        set(PROPERTY_CONSTUCTIVEMEASURE, constuctivemeasure);
    }

    public String getRawmaterial() {
        return (String) get(PROPERTY_RAWMATERIAL);
    }

    public void setRawmaterial(String rawmaterial) {
        set(PROPERTY_RAWMATERIAL, rawmaterial);
    }

    public Long getCutoff() {
        return (Long) get(PROPERTY_CUTOFF);
    }

    public void setCutoff(Long cutoff) {
        set(PROPERTY_CUTOFF, cutoff);
    }

    public BigDecimal getQTYPlan() {
        return (BigDecimal) get(PROPERTY_QTYPLAN);
    }

    public void setQTYPlan(BigDecimal qTYPlan) {
        set(PROPERTY_QTYPLAN, qTYPlan);
    }

    public BigDecimal getQtyreserved() {
        return (BigDecimal) get(PROPERTY_QTYRESERVED);
    }

    public void setQtyreserved(BigDecimal qtyreserved) {
        set(PROPERTY_QTYRESERVED, qtyreserved);
    }

    public BigDecimal getQtyinrequisition() {
        return (BigDecimal) get(PROPERTY_QTYINREQUISITION);
    }

    public void setQtyinrequisition(BigDecimal qtyinrequisition) {
        set(PROPERTY_QTYINREQUISITION, qtyinrequisition);
    }

    public BigDecimal getQtyreceived() {
        return (BigDecimal) get(PROPERTY_QTYRECEIVED);
    }

    public void setQtyreceived(BigDecimal qtyreceived) {
        set(PROPERTY_QTYRECEIVED, qtyreceived);
    }

    public Date getDatePlan() {
        return (Date) get(PROPERTY_DATEPLAN);
    }

    public void setDatePlan(Date datePlan) {
        set(PROPERTY_DATEPLAN, datePlan);
    }

    public Boolean isPlanrequisition() {
        return (Boolean) get(PROPERTY_PLANREQUISITION);
    }

    public void setPlanrequisition(Boolean planrequisition) {
        set(PROPERTY_PLANREQUISITION, planrequisition);
    }

    public Locator getIssuingLocator() {
        return (Locator) get(PROPERTY_ISSUINGLOCATOR);
    }

    public void setIssuingLocator(Locator issuingLocator) {
        set(PROPERTY_ISSUINGLOCATOR, issuingLocator);
    }

    public Locator getReceivingLocator() {
        return (Locator) get(PROPERTY_RECEIVINGLOCATOR);
    }

    public void setReceivingLocator(Locator receivingLocator) {
        set(PROPERTY_RECEIVINGLOCATOR, receivingLocator);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getQTYAvailable() {
        return (BigDecimal) get(PROPERTY_QTYAVAILABLE);
    }

    public void setQTYAvailable(BigDecimal qTYAvailable) {
        set(PROPERTY_QTYAVAILABLE, qTYAvailable);
    }

    public BigDecimal getQTYInstock() {
        return (BigDecimal) get(PROPERTY_QTYINSTOCK);
    }

    public void setQTYInstock(BigDecimal qTYInstock) {
        set(PROPERTY_QTYINSTOCK, qTYInstock);
    }

    public org.openbravo.model.materialmgmt.onhandquantity.snr_batchlocator getSNRBatchmasterdata() {
        return (org.openbravo.model.materialmgmt.onhandquantity.snr_batchlocator) get(PROPERTY_SNRBATCHMASTERDATA);
    }

    public void setSNRBatchmasterdata(
        org.openbravo.model.materialmgmt.onhandquantity.snr_batchlocator sNRBatchmasterdata) {
        set(PROPERTY_SNRBATCHMASTERDATA, sNRBatchmasterdata);
    }
}
