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
package org.zsoft.serial;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity snr_movementline (stored in table snr_movementline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Snr_movementline extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "snr_movementline";
    public static final String ENTITY_NAME = "snr_movementline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MOVEMENTLINE = "movementline";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_ISUNAVAILABLE = "isunavailable";
    public static final String PROPERTY_GUARANTEEDAYS = "guaranteedays";
    public static final String PROPERTY_GUARANTEEDATE = "guaranteedate";
    public static final String PROPERTY_LOTNUMBER = "lotnumber";
    public static final String PROPERTY_SERIALNUMBER = "serialnumber";
    public static final String PROPERTY_RFIDNUMBER = "rfidnumber";
    public static final String PROPERTY_DESCRIPTION = "description";

    public Snr_movementline() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_ISUNAVAILABLE, false);
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public InternalMovementLine getMovementline() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementline(InternalMovementLine movementline) {
        set(PROPERTY_MOVEMENTLINE, movementline);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Boolean isUnavailable() {
        return (Boolean) get(PROPERTY_ISUNAVAILABLE);
    }

    public void setUnavailable(Boolean isunavailable) {
        set(PROPERTY_ISUNAVAILABLE, isunavailable);
    }

    public Long getGuaranteedays() {
        return (Long) get(PROPERTY_GUARANTEEDAYS);
    }

    public void setGuaranteedays(Long guaranteedays) {
        set(PROPERTY_GUARANTEEDAYS, guaranteedays);
    }

    public Date getGuaranteedate() {
        return (Date) get(PROPERTY_GUARANTEEDATE);
    }

    public void setGuaranteedate(Date guaranteedate) {
        set(PROPERTY_GUARANTEEDATE, guaranteedate);
    }

    public String getLotnumber() {
        return (String) get(PROPERTY_LOTNUMBER);
    }

    public void setLotnumber(String lotnumber) {
        set(PROPERTY_LOTNUMBER, lotnumber);
    }

    public String getSerialnumber() {
        return (String) get(PROPERTY_SERIALNUMBER);
    }

    public void setSerialnumber(String serialnumber) {
        set(PROPERTY_SERIALNUMBER, serialnumber);
    }

    public String getRfidnumber() {
        return (String) get(PROPERTY_RFIDNUMBER);
    }

    public void setRfidnumber(String rfidnumber) {
        set(PROPERTY_RFIDNUMBER, rfidnumber);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }
}
