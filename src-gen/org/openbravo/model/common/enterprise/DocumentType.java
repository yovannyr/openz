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
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.financialmgmt.gl.GLCategory;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity DocumentType (stored in table C_DocType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DocumentType extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_DocType";
    public static final String ENTITY_NAME = "DocumentType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTNAME = "printName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCBASETYPE = "docBaseType";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_DOCSUBTYPESO = "docSubTypeSO";
    public static final String PROPERTY_DOCTYPESHIPMENT = "docTypeShipment";
    public static final String PROPERTY_DOCTYPEINVOICE = "docTypeInvoice";
    public static final String PROPERTY_ISDOCNOCONTROLLED = "isDocNoControlled";
    public static final String PROPERTY_DOCNOSEQUENCE = "docNoSequence";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_DOCUMENTNOTE = "documentNote";
    public static final String PROPERTY_ISDEFAULT = "isDefault";
    public static final String PROPERTY_DOCUMENTCOPIES = "documentCopies";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_ORGFILTERED = "orgfiltered";
    public static final String PROPERTY_DOCTYPEREVERSED = "doctypeReversed";
    public static final String PROPERTY_DOCUMENTTEMPLATELIST =
        "documentTemplateList";
    public static final String PROPERTY_DOCUMENTTYPETRLLIST =
        "documentTypeTrlList";

    public DocumentType() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSOTRX, false);
        setDefaultValue(PROPERTY_ISDOCNOCONTROLLED, true);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_DOCUMENTCOPIES, (long) 1);
        setDefaultValue(PROPERTY_ORGFILTERED, false);
        setDefaultValue(PROPERTY_DOCUMENTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPETRLLIST, new ArrayList<Object>());
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

    public String getPrintName() {
        return (String) get(PROPERTY_PRINTNAME);
    }

    public void setPrintName(String printName) {
        set(PROPERTY_PRINTNAME, printName);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocBaseType() {
        return (String) get(PROPERTY_DOCBASETYPE);
    }

    public void setDocBaseType(String docBaseType) {
        set(PROPERTY_DOCBASETYPE, docBaseType);
    }

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public String getDocSubTypeSO() {
        return (String) get(PROPERTY_DOCSUBTYPESO);
    }

    public void setDocSubTypeSO(String docSubTypeSO) {
        set(PROPERTY_DOCSUBTYPESO, docSubTypeSO);
    }

    public DocumentType getDocTypeShipment() {
        return (DocumentType) get(PROPERTY_DOCTYPESHIPMENT);
    }

    public void setDocTypeShipment(DocumentType docTypeShipment) {
        set(PROPERTY_DOCTYPESHIPMENT, docTypeShipment);
    }

    public DocumentType getDocTypeInvoice() {
        return (DocumentType) get(PROPERTY_DOCTYPEINVOICE);
    }

    public void setDocTypeInvoice(DocumentType docTypeInvoice) {
        set(PROPERTY_DOCTYPEINVOICE, docTypeInvoice);
    }

    public Boolean isDocNoControlled() {
        return (Boolean) get(PROPERTY_ISDOCNOCONTROLLED);
    }

    public void setDocNoControlled(Boolean isDocNoControlled) {
        set(PROPERTY_ISDOCNOCONTROLLED, isDocNoControlled);
    }

    public Sequence getDocNoSequence() {
        return (Sequence) get(PROPERTY_DOCNOSEQUENCE);
    }

    public void setDocNoSequence(Sequence docNoSequence) {
        set(PROPERTY_DOCNOSEQUENCE, docNoSequence);
    }

    public GLCategory getCategory() {
        return (GLCategory) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GLCategory category) {
        set(PROPERTY_CATEGORY, category);
    }

    public String getDocumentNote() {
        return (String) get(PROPERTY_DOCUMENTNOTE);
    }

    public void setDocumentNote(String documentNote) {
        set(PROPERTY_DOCUMENTNOTE, documentNote);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isDefault) {
        set(PROPERTY_ISDEFAULT, isDefault);
    }

    public Long getDocumentCopies() {
        return (Long) get(PROPERTY_DOCUMENTCOPIES);
    }

    public void setDocumentCopies(Long documentCopies) {
        set(PROPERTY_DOCUMENTCOPIES, documentCopies);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Boolean isOrgfiltered() {
        return (Boolean) get(PROPERTY_ORGFILTERED);
    }

    public void setOrgfiltered(Boolean orgfiltered) {
        set(PROPERTY_ORGFILTERED, orgfiltered);
    }

    public DocumentType getDoctypeReversed() {
        return (DocumentType) get(PROPERTY_DOCTYPEREVERSED);
    }

    public void setDoctypeReversed(DocumentType doctypeReversed) {
        set(PROPERTY_DOCTYPEREVERSED, doctypeReversed);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTemplate> getDocumentTemplateList() {
        return (List<DocumentTemplate>) get(PROPERTY_DOCUMENTTEMPLATELIST);
    }

    public void setDocumentTemplateList(
        List<DocumentTemplate> documentTemplateList) {
        set(PROPERTY_DOCUMENTTEMPLATELIST, documentTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTypeTrl> getDocumentTypeTrlList() {
        return (List<DocumentTypeTrl>) get(PROPERTY_DOCUMENTTYPETRLLIST);
    }

    public void setDocumentTypeTrlList(
        List<DocumentTypeTrl> documentTypeTrlList) {
        set(PROPERTY_DOCUMENTTYPETRLLIST, documentTypeTrlList);
    }
}
