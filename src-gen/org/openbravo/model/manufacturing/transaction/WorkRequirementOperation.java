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
package org.openbravo.model.manufacturing.transaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.manufacturing.processplan.Operation;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity ManufacturingWorkRequirementOperation (stored in table MA_WRPhase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class WorkRequirementOperation extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_WRPhase";
    public static final String ENTITY_NAME =
        "ManufacturingWorkRequirementOperation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_WORKREQUIREMENT = "workrequirement";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_DONEQUANTITY = "donequantity";
    public static final String PROPERTY_COSTCENTERUSE = "costCenterUse";
    public static final String PROPERTY_PREPTIME = "preptime";
    public static final String PROPERTY_CLOSED = "closed";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_NOQTY = "noqty";
    public static final String PROPERTY_GROUPUSE = "groupuse";
    public static final String PROPERTY_SEQUENCE = "sequence";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_OUTSOURCED = "outsourced";

    public WorkRequirementOperation() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CLOSED, false);
        setDefaultValue(PROPERTY_NOQTY, false);
        setDefaultValue(PROPERTY_GROUPUSE, false);
        setDefaultValue(PROPERTY_OUTSOURCED, false);
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

    public WorkRequirement getWorkrequirement() {
        return (WorkRequirement) get(PROPERTY_WORKREQUIREMENT);
    }

    public void setWorkrequirement(WorkRequirement workrequirement) {
        set(PROPERTY_WORKREQUIREMENT, workrequirement);
    }

    public Activity getProcess() {
        return (Activity) get(PROPERTY_PROCESS);
    }

    public void setProcess(Activity process) {
        set(PROPERTY_PROCESS, process);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public BigDecimal getDonequantity() {
        return (BigDecimal) get(PROPERTY_DONEQUANTITY);
    }

    public void setDonequantity(BigDecimal donequantity) {
        set(PROPERTY_DONEQUANTITY, donequantity);
    }

    public BigDecimal getCostCenterUse() {
        return (BigDecimal) get(PROPERTY_COSTCENTERUSE);
    }

    public void setCostCenterUse(BigDecimal costCenterUse) {
        set(PROPERTY_COSTCENTERUSE, costCenterUse);
    }

    public BigDecimal getPreptime() {
        return (BigDecimal) get(PROPERTY_PREPTIME);
    }

    public void setPreptime(BigDecimal preptime) {
        set(PROPERTY_PREPTIME, preptime);
    }

    public Boolean isClosed() {
        return (Boolean) get(PROPERTY_CLOSED);
    }

    public void setClosed(Boolean closed) {
        set(PROPERTY_CLOSED, closed);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Boolean isNoqty() {
        return (Boolean) get(PROPERTY_NOQTY);
    }

    public void setNoqty(Boolean noqty) {
        set(PROPERTY_NOQTY, noqty);
    }

    public Boolean isGroupuse() {
        return (Boolean) get(PROPERTY_GROUPUSE);
    }

    public void setGroupuse(Boolean groupuse) {
        set(PROPERTY_GROUPUSE, groupuse);
    }

    public Operation getSequence() {
        return (Operation) get(PROPERTY_SEQUENCE);
    }

    public void setSequence(Operation sequence) {
        set(PROPERTY_SEQUENCE, sequence);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isOutsourced() {
        return (Boolean) get(PROPERTY_OUTSOURCED);
    }

    public void setOutsourced(Boolean outsourced) {
        set(PROPERTY_OUTSOURCED, outsourced);
    }
}
