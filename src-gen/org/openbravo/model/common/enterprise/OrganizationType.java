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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity OrganizationType (stored in table AD_OrgType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OrganizationType extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_OrgType";
    public static final String ENTITY_NAME = "OrganizationType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISLEGALENTITY = "isLegalEntity";
    public static final String PROPERTY_ISBUSINESSUNIT = "isBusinessUnit";
    public static final String PROPERTY_ISTRANSACTIONSALLOWED =
        "isTransactionsAllowed";
    public static final String PROPERTY_ISACCTLEGALENTITY = "isAcctLegalEntity";

    public OrganizationType() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_ISLEGALENTITY, false);
        setDefaultValue(PROPERTY_ISBUSINESSUNIT, false);
        setDefaultValue(PROPERTY_ISTRANSACTIONSALLOWED, false);
        setDefaultValue(PROPERTY_ISACCTLEGALENTITY, false);
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

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
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

    public Boolean isLegalEntity() {
        return (Boolean) get(PROPERTY_ISLEGALENTITY);
    }

    public void setLegalEntity(Boolean isLegalEntity) {
        set(PROPERTY_ISLEGALENTITY, isLegalEntity);
    }

    public Boolean isBusinessUnit() {
        return (Boolean) get(PROPERTY_ISBUSINESSUNIT);
    }

    public void setBusinessUnit(Boolean isBusinessUnit) {
        set(PROPERTY_ISBUSINESSUNIT, isBusinessUnit);
    }

    public Boolean isTransactionsAllowed() {
        return (Boolean) get(PROPERTY_ISTRANSACTIONSALLOWED);
    }

    public void setTransactionsAllowed(Boolean isTransactionsAllowed) {
        set(PROPERTY_ISTRANSACTIONSALLOWED, isTransactionsAllowed);
    }

    public Boolean isAcctLegalEntity() {
        return (Boolean) get(PROPERTY_ISACCTLEGALENTITY);
    }

    public void setAcctLegalEntity(Boolean isAcctLegalEntity) {
        set(PROPERTY_ISACCTLEGALENTITY, isAcctLegalEntity);
    }
}
