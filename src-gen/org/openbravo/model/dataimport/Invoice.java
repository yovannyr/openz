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
package org.openbravo.model.dataimport;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity DataImportInvoice (stored in table I_Invoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Invoice extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "I_Invoice";
    public static final String ENTITY_NAME = "DataImportInvoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ORGTRX = "orgTrx";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISIMPORTED = "isImported";
    public static final String PROPERTY_ERRORMSG = "errorMsg";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_SALESREP = "salesRep";
    public static final String PROPERTY_ISSOTRX = "isSOTrx";
    public static final String PROPERTY_BPARTNER = "bPartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bPartnerLocation";
    public static final String PROPERTY_BPARTNERVALUE = "bPartnerValue";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_POSTAL = "postal";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_REGIONNAME = "regionName";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_CONTACTNAME = "contactName";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_COUNTRYCODE = "countryCode";
    public static final String PROPERTY_DOCTYPE = "docType";
    public static final String PROPERTY_DOCTYPENAME = "docTypeName";
    public static final String PROPERTY_PAYMENTTERM = "paymentTerm";
    public static final String PROPERTY_PAYMENTTERMVALUE = "paymentTermValue";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTVALUE = "productValue";
    public static final String PROPERTY_UPC = "uPC";
    public static final String PROPERTY_SKU = "sKU";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_TAXINDICATOR = "taxIndicator";
    public static final String PROPERTY_TAXAMT = "taxAmt";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_LINEDESCRIPTION = "lineDescription";
    public static final String PROPERTY_QTYORDERED = "qtyOrdered";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";

    public Invoice() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_ISSOTRX, false);
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

    public Organization getOrgTrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgTrx(Organization orgTrx) {
        set(PROPERTY_ORGTRX, orgTrx);
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

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isImported) {
        set(PROPERTY_ISIMPORTED, isImported);
    }

    public String getErrorMsg() {
        return (String) get(PROPERTY_ERRORMSG);
    }

    public void setErrorMsg(String errorMsg) {
        set(PROPERTY_ERRORMSG, errorMsg);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public User getSalesRep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesRep(User salesRep) {
        set(PROPERTY_SALESREP, salesRep);
    }

    public Boolean isSOTrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSOTrx(Boolean isSOTrx) {
        set(PROPERTY_ISSOTRX, isSOTrx);
    }

    public BusinessPartner getBPartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBPartner(BusinessPartner bPartner) {
        set(PROPERTY_BPARTNER, bPartner);
    }

    public Location getBPartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBPartnerLocation(Location bPartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bPartnerLocation);
    }

    public String getBPartnerValue() {
        return (String) get(PROPERTY_BPARTNERVALUE);
    }

    public void setBPartnerValue(String bPartnerValue) {
        set(PROPERTY_BPARTNERVALUE, bPartnerValue);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public org.openbravo.model.common.geography.Location getLocation() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(
        org.openbravo.model.common.geography.Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public String getAddress1() {
        return (String) get(PROPERTY_ADDRESS1);
    }

    public void setAddress1(String address1) {
        set(PROPERTY_ADDRESS1, address1);
    }

    public String getAddress2() {
        return (String) get(PROPERTY_ADDRESS2);
    }

    public void setAddress2(String address2) {
        set(PROPERTY_ADDRESS2, address2);
    }

    public String getPostal() {
        return (String) get(PROPERTY_POSTAL);
    }

    public void setPostal(String postal) {
        set(PROPERTY_POSTAL, postal);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public String getRegionName() {
        return (String) get(PROPERTY_REGIONNAME);
    }

    public void setRegionName(String regionName) {
        set(PROPERTY_REGIONNAME, regionName);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public String getContactName() {
        return (String) get(PROPERTY_CONTACTNAME);
    }

    public void setContactName(String contactName) {
        set(PROPERTY_CONTACTNAME, contactName);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public String getCountryCode() {
        return (String) get(PROPERTY_COUNTRYCODE);
    }

    public void setCountryCode(String countryCode) {
        set(PROPERTY_COUNTRYCODE, countryCode);
    }

    public DocumentType getDocType() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDocType(DocumentType docType) {
        set(PROPERTY_DOCTYPE, docType);
    }

    public String getDocTypeName() {
        return (String) get(PROPERTY_DOCTYPENAME);
    }

    public void setDocTypeName(String docTypeName) {
        set(PROPERTY_DOCTYPENAME, docTypeName);
    }

    public PaymentTerm getPaymentTerm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        set(PROPERTY_PAYMENTTERM, paymentTerm);
    }

    public String getPaymentTermValue() {
        return (String) get(PROPERTY_PAYMENTTERMVALUE);
    }

    public void setPaymentTermValue(String paymentTermValue) {
        set(PROPERTY_PAYMENTTERMVALUE, paymentTermValue);
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

    public org.openbravo.model.common.invoice.Invoice getInvoice() {
        return (org.openbravo.model.common.invoice.Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(org.openbravo.model.common.invoice.Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProductValue() {
        return (String) get(PROPERTY_PRODUCTVALUE);
    }

    public void setProductValue(String productValue) {
        set(PROPERTY_PRODUCTVALUE, productValue);
    }

    public String getUPC() {
        return (String) get(PROPERTY_UPC);
    }

    public void setUPC(String uPC) {
        set(PROPERTY_UPC, uPC);
    }

    public String getSKU() {
        return (String) get(PROPERTY_SKU);
    }

    public void setSKU(String sKU) {
        set(PROPERTY_SKU, sKU);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getTaxIndicator() {
        return (String) get(PROPERTY_TAXINDICATOR);
    }

    public void setTaxIndicator(String taxIndicator) {
        set(PROPERTY_TAXINDICATOR, taxIndicator);
    }

    public BigDecimal getTaxAmt() {
        return (BigDecimal) get(PROPERTY_TAXAMT);
    }

    public void setTaxAmt(BigDecimal taxAmt) {
        set(PROPERTY_TAXAMT, taxAmt);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public String getLineDescription() {
        return (String) get(PROPERTY_LINEDESCRIPTION);
    }

    public void setLineDescription(String lineDescription) {
        set(PROPERTY_LINEDESCRIPTION, lineDescription);
    }

    public BigDecimal getQtyOrdered() {
        return (BigDecimal) get(PROPERTY_QTYORDERED);
    }

    public void setQtyOrdered(BigDecimal qtyOrdered) {
        set(PROPERTY_QTYORDERED, qtyOrdered);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }
}
