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
package org.openbravo.model.common.plm;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity PerpetualInv (stored in table M_PerpetualInv).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PerpetualInv extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_PerpetualInv";
    public static final String ENTITY_NAME = "PerpetualInv";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOINVENTORYCOUNT = "noInventoryCount";
    public static final String PROPERTY_NOPRODUCTCOUNT = "noProductCount";
    public static final String PROPERTY_COUNTHIGHMOVEMENT = "countHighMovement";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_DATELASTRUN = "dateLastRun";
    public static final String PROPERTY_DATENEXTRUN = "dateNextRun";
    public static final String PROPERTY_NUMBEROFRUNS = "numberOfRuns";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_WAREHOUSE = "warehouse";

    public PerpetualInv() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_NOINVENTORYCOUNT, (long) 1);
        setDefaultValue(PROPERTY_NOPRODUCTCOUNT, (long) 1);
        setDefaultValue(PROPERTY_COUNTHIGHMOVEMENT, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_NUMBEROFRUNS, (long) 1);
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

    public Long getNoInventoryCount() {
        return (Long) get(PROPERTY_NOINVENTORYCOUNT);
    }

    public void setNoInventoryCount(Long noInventoryCount) {
        set(PROPERTY_NOINVENTORYCOUNT, noInventoryCount);
    }

    public Long getNoProductCount() {
        return (Long) get(PROPERTY_NOPRODUCTCOUNT);
    }

    public void setNoProductCount(Long noProductCount) {
        set(PROPERTY_NOPRODUCTCOUNT, noProductCount);
    }

    public Boolean isCountHighMovement() {
        return (Boolean) get(PROPERTY_COUNTHIGHMOVEMENT);
    }

    public void setCountHighMovement(Boolean countHighMovement) {
        set(PROPERTY_COUNTHIGHMOVEMENT, countHighMovement);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Date getDateLastRun() {
        return (Date) get(PROPERTY_DATELASTRUN);
    }

    public void setDateLastRun(Date dateLastRun) {
        set(PROPERTY_DATELASTRUN, dateLastRun);
    }

    public Date getDateNextRun() {
        return (Date) get(PROPERTY_DATENEXTRUN);
    }

    public void setDateNextRun(Date dateNextRun) {
        set(PROPERTY_DATENEXTRUN, dateNextRun);
    }

    public Long getNumberOfRuns() {
        return (Long) get(PROPERTY_NUMBEROFRUNS);
    }

    public void setNumberOfRuns(Long numberOfRuns) {
        set(PROPERTY_NUMBEROFRUNS, numberOfRuns);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }
}
