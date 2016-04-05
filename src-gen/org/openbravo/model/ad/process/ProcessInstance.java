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
package org.openbravo.model.ad.process;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ADProcessInstance (stored in table AD_PInstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProcessInstance extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_PInstance";
    public static final String ENTITY_NAME = "ADProcessInstance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_RECORD = "record";
    public static final String PROPERTY_ISPROCESSING = "isProcessing";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_ADPARAMETERLIST = "aDParameterList";

    public ProcessInstance() {
        setDefaultValue(PROPERTY_ISPROCESSING, false);
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ADPARAMETERLIST, new ArrayList<Object>());
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

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getRecord() {
        return (String) get(PROPERTY_RECORD);
    }

    public void setRecord(String record) {
        set(PROPERTY_RECORD, record);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_ISPROCESSING);
    }

    public void setProcessing(Boolean isProcessing) {
        set(PROPERTY_ISPROCESSING, isProcessing);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public Long getResult() {
        return (Long) get(PROPERTY_RESULT);
    }

    public void setResult(Long result) {
        set(PROPERTY_RESULT, result);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
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

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    @SuppressWarnings("unchecked")
    public List<Parameter> getADParameterList() {
        return (List<Parameter>) get(PROPERTY_ADPARAMETERLIST);
    }

    public void setADParameterList(List<Parameter> aDParameterList) {
        set(PROPERTY_ADPARAMETERLIST, aDParameterList);
    }
}
