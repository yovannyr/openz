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
package org.openbravo.model.sales;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity SalesCommission (stored in table C_Commission).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Commission extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Commission";
    public static final String ENTITY_NAME = "SalesCommission";
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
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_FREQUENCYTYPE = "frequencyType";
    public static final String PROPERTY_DOCBASISTYPE = "docBasisType";
    public static final String PROPERTY_LISTDETAILS = "listDetails";
    public static final String PROPERTY_DATELASTRUN = "dateLastRun";
    public static final String PROPERTY_CREATEFROM = "createFrom";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SHAREOFTURNOVERPERCENT =
        "shareofturnoverpercent";
    public static final String PROPERTY_SHAREOFTURNOVERPARTNER =
        "shareofturnoverpartner";
    public static final String PROPERTY_SALESCOMMISSIONLINELIST =
        "salesCommissionLineList";

    public Commission() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_FREQUENCYTYPE, "M");
        setDefaultValue(PROPERTY_DOCBASISTYPE, "I");
        setDefaultValue(PROPERTY_LISTDETAILS, false);
        setDefaultValue(PROPERTY_CREATEFROM, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_SALESCOMMISSIONLINELIST,
            new ArrayList<Object>());
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

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getFrequencyType() {
        return (String) get(PROPERTY_FREQUENCYTYPE);
    }

    public void setFrequencyType(String frequencyType) {
        set(PROPERTY_FREQUENCYTYPE, frequencyType);
    }

    public String getDocBasisType() {
        return (String) get(PROPERTY_DOCBASISTYPE);
    }

    public void setDocBasisType(String docBasisType) {
        set(PROPERTY_DOCBASISTYPE, docBasisType);
    }

    public Boolean isListDetails() {
        return (Boolean) get(PROPERTY_LISTDETAILS);
    }

    public void setListDetails(Boolean listDetails) {
        set(PROPERTY_LISTDETAILS, listDetails);
    }

    public Date getDateLastRun() {
        return (Date) get(PROPERTY_DATELASTRUN);
    }

    public void setDateLastRun(Date dateLastRun) {
        set(PROPERTY_DATELASTRUN, dateLastRun);
    }

    public Boolean isCreateFrom() {
        return (Boolean) get(PROPERTY_CREATEFROM);
    }

    public void setCreateFrom(Boolean createFrom) {
        set(PROPERTY_CREATEFROM, createFrom);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getShareofturnoverpercent() {
        return (BigDecimal) get(PROPERTY_SHAREOFTURNOVERPERCENT);
    }

    public void setShareofturnoverpercent(BigDecimal shareofturnoverpercent) {
        set(PROPERTY_SHAREOFTURNOVERPERCENT, shareofturnoverpercent);
    }

    public BusinessPartner getShareofturnoverpartner() {
        return (BusinessPartner) get(PROPERTY_SHAREOFTURNOVERPARTNER);
    }

    public void setShareofturnoverpartner(
        BusinessPartner shareofturnoverpartner) {
        set(PROPERTY_SHAREOFTURNOVERPARTNER, shareofturnoverpartner);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionLine> getSalesCommissionLineList() {
        return (List<CommissionLine>) get(PROPERTY_SALESCOMMISSIONLINELIST);
    }

    public void setSalesCommissionLineList(
        List<CommissionLine> salesCommissionLineList) {
        set(PROPERTY_SALESCOMMISSIONLINELIST, salesCommissionLineList);
    }
}
