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
package org.openbravo.model.financialmgmt.cashmgmt;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity FinancialMgmtCashJournal (stored in table C_Cash).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CashJournal extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Cash";
    public static final String ENTITY_NAME = "FinancialMgmtCashJournal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CASHBOOK = "cashBook";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STATEMENTDATE = "statementDate";
    public static final String PROPERTY_DATEACCT = "dateAcct";
    public static final String PROPERTY_BEGINNINGBALANCE = "beginningBalance";
    public static final String PROPERTY_ENDINGBALANCE = "endingBalance";
    public static final String PROPERTY_STATEMENTDIFFERENCE =
        "statementDifference";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_FINANCIALMGMTJOURNALLINELIST =
        "financialMgmtJournalLineList";

    public CashJournal() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_DOCSTATUS, "CO");
        setDefaultValue(PROPERTY_FINANCIALMGMTJOURNALLINELIST,
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

    public CashBook getCashBook() {
        return (CashBook) get(PROPERTY_CASHBOOK);
    }

    public void setCashBook(CashBook cashBook) {
        set(PROPERTY_CASHBOOK, cashBook);
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

    public Date getStatementDate() {
        return (Date) get(PROPERTY_STATEMENTDATE);
    }

    public void setStatementDate(Date statementDate) {
        set(PROPERTY_STATEMENTDATE, statementDate);
    }

    public Date getDateAcct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateAcct(Date dateAcct) {
        set(PROPERTY_DATEACCT, dateAcct);
    }

    public BigDecimal getBeginningBalance() {
        return (BigDecimal) get(PROPERTY_BEGINNINGBALANCE);
    }

    public void setBeginningBalance(BigDecimal beginningBalance) {
        set(PROPERTY_BEGINNINGBALANCE, beginningBalance);
    }

    public BigDecimal getEndingBalance() {
        return (BigDecimal) get(PROPERTY_ENDINGBALANCE);
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        set(PROPERTY_ENDINGBALANCE, endingBalance);
    }

    public BigDecimal getStatementDifference() {
        return (BigDecimal) get(PROPERTY_STATEMENTDIFFERENCE);
    }

    public void setStatementDifference(BigDecimal statementDifference) {
        set(PROPERTY_STATEMENTDIFFERENCE, statementDifference);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getUser1() {
        return (String) get(PROPERTY_USER1);
    }

    public void setUser1(String user1) {
        set(PROPERTY_USER1, user1);
    }

    public String getUser2() {
        return (String) get(PROPERTY_USER2);
    }

    public void setUser2(String user2) {
        set(PROPERTY_USER2, user2);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    @SuppressWarnings("unchecked")
    public List<CashJournalLine> getFinancialMgmtJournalLineList() {
        return (List<CashJournalLine>) get(PROPERTY_FINANCIALMGMTJOURNALLINELIST);
    }

    public void setFinancialMgmtJournalLineList(
        List<CashJournalLine> financialMgmtJournalLineList) {
        set(PROPERTY_FINANCIALMGMTJOURNALLINELIST, financialMgmtJournalLineList);
    }
}
