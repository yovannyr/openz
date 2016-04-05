//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalesOrder;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class HeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(HeaderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String poreference;
  public String dateordered;
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String name;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String docstatus;
  public String docstatusr;
  public String description;
  public String deliverynotes;
  public String internalnote;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String bpzipcode;
  public String billtoId;
  public String billtoIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String isdiscountprinted;
  public String invoicerule;
  public String invoiceruler;
  public String estpropability;
  public String estpropabilityr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String priorityrule;
  public String priorityruler;
  public String paymentrule;
  public String paymentruler;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String mShipperId;
  public String mShipperIdr;
  public String weight;
  public String weightUom;
  public String weightUomr;
  public String freightcostrule;
  public String freightcostruler;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String freightamt;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String orderselfjoin;
  public String orderselfjoinr;
  public String firstschedinvoicedate;
  public String datepromised;
  public String scheddeliverydate;
  public String schedtransactiondate;
  public String transactiondate;
  public String contractdate;
  public String enddate;
  public String invoicefrequence;
  public String invoicefrequencer;
  public String isinvoiceafterfirstcycle;
  public String quarterlyMonth;
  public String quarterlyMonthr;
  public String yearlyMonth;
  public String yearlyMonthr;
  public String weeklyDay;
  public String weeklyDayr;
  public String monthlyDay;
  public String proposalstatus;
  public String proposalstatusr;
  public String lostproposalfixedreason;
  public String lostproposalfixedreasonr;
  public String lostproposalreason;
  public String totallinesonetime;
  public String grandtotalonetime;
  public String totallines;
  public String grandtotal;
  public String invoicedamt;
  public String totalpaid;
  public String completeordervalue;
  public String iscompletelyinvoiced;
  public String deliverycomplete;
  public String subscriptionchangedate;
  public String docaction;
  public String docactionBtn;
  public String generatetemplate;
  public String copyfrom;
  public String copyfrompo;
  public String generateproject;
  public String closeproject;
  public String createdropshiporder;
  public String isdelivered;
  public String incotermsdescription;
  public String performanceperiodstart;
  public String performanceperiodend;
  public String ispaid;
  public String transactionreference;
  public String isselected;
  public String isactive;
  public String istaxincluded;
  public String posted;
  public String processing;
  public String issotrx;
  public String cOrderId;
  public String dateprinted;
  public String processed;
  public String chargeamt;
  public String cActivityId;
  public String isselfservice;
  public String cChargeId;
  public String isprinted;
  public String isinvoiced;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("deliverynotes"))
      return deliverynotes;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("bpzipcode"))
      return bpzipcode;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceruler"))
      return invoiceruler;
    else if (fieldName.equalsIgnoreCase("estpropability"))
      return estpropability;
    else if (fieldName.equalsIgnoreCase("estpropabilityr"))
      return estpropabilityr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("weight_uom") || fieldName.equals("weightUom"))
      return weightUom;
    else if (fieldName.equalsIgnoreCase("weight_uomr") || fieldName.equals("weightUomr"))
      return weightUomr;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("orderselfjoin"))
      return orderselfjoin;
    else if (fieldName.equalsIgnoreCase("orderselfjoinr"))
      return orderselfjoinr;
    else if (fieldName.equalsIgnoreCase("firstschedinvoicedate"))
      return firstschedinvoicedate;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("schedtransactiondate"))
      return schedtransactiondate;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("invoicefrequence"))
      return invoicefrequence;
    else if (fieldName.equalsIgnoreCase("invoicefrequencer"))
      return invoicefrequencer;
    else if (fieldName.equalsIgnoreCase("isinvoiceafterfirstcycle"))
      return isinvoiceafterfirstcycle;
    else if (fieldName.equalsIgnoreCase("quarterly_month") || fieldName.equals("quarterlyMonth"))
      return quarterlyMonth;
    else if (fieldName.equalsIgnoreCase("quarterly_monthr") || fieldName.equals("quarterlyMonthr"))
      return quarterlyMonthr;
    else if (fieldName.equalsIgnoreCase("yearly_month") || fieldName.equals("yearlyMonth"))
      return yearlyMonth;
    else if (fieldName.equalsIgnoreCase("yearly_monthr") || fieldName.equals("yearlyMonthr"))
      return yearlyMonthr;
    else if (fieldName.equalsIgnoreCase("weekly_day") || fieldName.equals("weeklyDay"))
      return weeklyDay;
    else if (fieldName.equalsIgnoreCase("weekly_dayr") || fieldName.equals("weeklyDayr"))
      return weeklyDayr;
    else if (fieldName.equalsIgnoreCase("monthly_day") || fieldName.equals("monthlyDay"))
      return monthlyDay;
    else if (fieldName.equalsIgnoreCase("proposalstatus"))
      return proposalstatus;
    else if (fieldName.equalsIgnoreCase("proposalstatusr"))
      return proposalstatusr;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreason"))
      return lostproposalfixedreason;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreasonr"))
      return lostproposalfixedreasonr;
    else if (fieldName.equalsIgnoreCase("lostproposalreason"))
      return lostproposalreason;
    else if (fieldName.equalsIgnoreCase("totallinesonetime"))
      return totallinesonetime;
    else if (fieldName.equalsIgnoreCase("grandtotalonetime"))
      return grandtotalonetime;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("completeordervalue"))
      return completeordervalue;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
    else if (fieldName.equalsIgnoreCase("deliverycomplete"))
      return deliverycomplete;
    else if (fieldName.equalsIgnoreCase("subscriptionchangedate"))
      return subscriptionchangedate;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("generatetemplate"))
      return generatetemplate;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("copyfrompo"))
      return copyfrompo;
    else if (fieldName.equalsIgnoreCase("generateproject"))
      return generateproject;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("createdropshiporder"))
      return createdropshiporder;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("performanceperiodstart"))
      return performanceperiodstart;
    else if (fieldName.equalsIgnoreCase("performanceperiodend"))
      return performanceperiodend;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("transactionreference"))
      return transactionreference;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Order.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.CreatedBy) as CreatedByR, " +
      "        to_char(C_Order.Updated, ?) as updated, " +
      "        to_char(C_Order.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Order.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Order.UpdatedBy) as UpdatedByR," +
      "        C_Order.AD_Client_ID, " +
      "(CASE WHEN C_Order.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Order.AD_Org_ID, " +
      "(CASE WHEN C_Order.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Order.DocumentNo, " +
      "C_Order.POReference, " +
      "C_Order.DateOrdered, " +
      "C_Order.C_DocTypeTarget_ID, " +
      "(CASE WHEN C_Order.C_DocTypeTarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_DocTypeTarget_IDR, " +
      "C_Order.Name, " +
      "C_Order.C_DocType_ID, " +
      "(CASE WHEN C_Order.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "C_Order.DocStatus, " +
      "(CASE WHEN C_Order.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "C_Order.Description, " +
      "C_Order.Deliverynotes, " +
      "C_Order.Internalnote, " +
      "C_Order.C_BPartner_ID, " +
      "(CASE WHEN C_Order.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_Order.bpzipcode, " +
      "C_Order.BillTo_ID, " +
      "(CASE WHEN C_Order.BillTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS BillTo_IDR, " +
      "C_Order.C_BPartner_Location_ID, " +
      "(CASE WHEN C_Order.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "C_Order.AD_User_ID, " +
      "(CASE WHEN C_Order.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "C_Order.SalesRep_ID, " +
      "(CASE WHEN C_Order.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Order.M_PriceList_ID, " +
      "(CASE WHEN C_Order.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "COALESCE(C_Order.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "C_Order.InvoiceRule, " +
      "(CASE WHEN C_Order.InvoiceRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS InvoiceRuleR, " +
      "C_Order.Estpropability, " +
      "(CASE WHEN C_Order.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS EstpropabilityR, " +
      "C_Order.M_Warehouse_ID, " +
      "(CASE WHEN C_Order.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "C_Order.C_Currency_ID, " +
      "(CASE WHEN C_Order.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Order.DeliveryRule, " +
      "(CASE WHEN C_Order.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS DeliveryRuleR, " +
      "C_Order.PriorityRule, " +
      "(CASE WHEN C_Order.PriorityRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS PriorityRuleR, " +
      "C_Order.PaymentRule, " +
      "(CASE WHEN C_Order.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS PaymentRuleR, " +
      "C_Order.C_PaymentTerm_ID, " +
      "(CASE WHEN C_Order.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "C_Order.C_Incoterms_ID, " +
      "(CASE WHEN C_Order.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "C_Order.Delivery_Location_ID, " +
      "(CASE WHEN C_Order.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "C_Order.DeliveryViaRule, " +
      "(CASE WHEN C_Order.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS DeliveryViaRuleR, " +
      "C_Order.M_Shipper_ID, " +
      "(CASE WHEN C_Order.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "C_Order.Weight, " +
      "C_Order.Weight_Uom, " +
      "(CASE WHEN C_Order.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL17.Name IS NULL THEN TO_CHAR(table17.Name) ELSE TO_CHAR(tableTRL17.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "C_Order.FreightCostRule, " +
      "(CASE WHEN C_Order.FreightCostRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS FreightCostRuleR, " +
      "C_Order.M_Product_ID, " +
      "(CASE WHEN C_Order.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_Order.Qty, " +
      "C_Order.FreightAmt, " +
      "C_Order.C_Project_ID, " +
      "(CASE WHEN C_Order.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_Order.C_Projecttask_ID, " +
      "(CASE WHEN C_Order.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "C_Order.Orderselfjoin, " +
      "(CASE WHEN C_Order.Orderselfjoin IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.DocumentNo), ''))),'') ) END) AS OrderselfjoinR, " +
      "C_Order.Firstschedinvoicedate, " +
      "C_Order.DatePromised, " +
      "C_Order.SchedDeliveryDate, " +
      "C_Order.SchedTransactionDate, " +
      "C_Order.TransactionDate, " +
      "C_Order.Contractdate, " +
      "C_Order.Enddate, " +
      "C_Order.Invoicefrequence, " +
      "(CASE WHEN C_Order.Invoicefrequence IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS InvoicefrequenceR, " +
      "COALESCE(C_Order.Isinvoiceafterfirstcycle, 'N') AS Isinvoiceafterfirstcycle, " +
      "C_Order.Quarterly_Month, " +
      "(CASE WHEN C_Order.Quarterly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list10.name),'') ) END) AS Quarterly_MonthR, " +
      "C_Order.Yearly_Month, " +
      "(CASE WHEN C_Order.Yearly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list11.name),'') ) END) AS Yearly_MonthR, " +
      "C_Order.Weekly_Day, " +
      "(CASE WHEN C_Order.Weekly_Day IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list12.name),'') ) END) AS Weekly_DayR, " +
      "C_Order.Monthly_Day, " +
      "C_Order.Proposalstatus, " +
      "(CASE WHEN C_Order.Proposalstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list13.name),'') ) END) AS ProposalstatusR, " +
      "C_Order.Lostproposalfixedreason, " +
      "(CASE WHEN C_Order.Lostproposalfixedreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list14.name),'') ) END) AS LostproposalfixedreasonR, " +
      "C_Order.Lostproposalreason, " +
      "C_Order.Totallinesonetime, " +
      "C_Order.Grandtotalonetime, " +
      "C_Order.TotalLines, " +
      "C_Order.GrandTotal, " +
      "C_Order.InvoicedAmt, " +
      "C_Order.TotalPaid, " +
      "C_Order.CompleteOrderValue, " +
      "COALESCE(C_Order.IsCompletelyInvoiced, 'N') AS IsCompletelyInvoiced, " +
      "COALESCE(C_Order.DeliveryComplete, 'N') AS DeliveryComplete, " +
      "C_Order.Subscriptionchangedate, " +
      "C_Order.DocAction, " +
      "list15.name as DocAction_BTN, " +
      "C_Order.Generatetemplate, " +
      "C_Order.CopyFrom, " +
      "C_Order.CopyFromPO, " +
      "C_Order.Generateproject, " +
      "C_Order.Closeproject, " +
      "C_Order.Createdropshiporder, " +
      "COALESCE(C_Order.IsDelivered, 'N') AS IsDelivered, " +
      "C_Order.Incotermsdescription, " +
      "C_Order.performanceperiodstart, " +
      "C_Order.performanceperiodend, " +
      "COALESCE(C_Order.Ispaid, 'N') AS Ispaid, " +
      "C_Order.Transactionreference, " +
      "COALESCE(C_Order.IsSelected, 'N') AS IsSelected, " +
      "COALESCE(C_Order.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_Order.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "C_Order.Posted, " +
      "C_Order.Processing, " +
      "COALESCE(C_Order.IsSOTrx, 'N') AS IsSOTrx, " +
      "C_Order.C_Order_ID, " +
      "C_Order.DatePrinted, " +
      "COALESCE(C_Order.Processed, 'N') AS Processed, " +
      "C_Order.ChargeAmt, " +
      "C_Order.C_Activity_ID, " +
      "COALESCE(C_Order.IsSelfService, 'N') AS IsSelfService, " +
      "C_Order.C_Charge_ID, " +
      "COALESCE(C_Order.IsPrinted, 'N') AS IsPrinted, " +
      "COALESCE(C_Order.IsInvoiced, 'N') AS IsInvoiced, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Order left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Order.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Order.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (C_Order.C_DocTypeTarget_ID =  table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join (select C_DocType_ID, Name from C_DocType) table4 on (C_Order.C_DocType_ID = table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Order.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (C_Order.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (C_Order.BillTo_ID =  table6.C_BPartner_Location_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table7 on (C_Order.C_BPartner_Location_ID = table7.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table8 on (C_Order.AD_User_ID = table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (C_Order.SalesRep_ID =  table9.AD_User_ID) left join (select M_PriceList_ID, Name from M_PriceList) table10 on (C_Order.M_PriceList_ID = table10.M_PriceList_ID) left join ad_ref_list_v list2 on (C_Order.InvoiceRule = list2.value and list2.ad_reference_id = '150' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (C_Order.Estpropability = list3.value and list3.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list3.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table11 on (C_Order.M_Warehouse_ID =  table11.M_Warehouse_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table12 on (C_Order.C_Currency_ID = table12.C_Currency_ID) left join ad_ref_list_v list4 on (C_Order.DeliveryRule = list4.value and list4.ad_reference_id = '151' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (C_Order.PriorityRule = list5.value and list5.ad_reference_id = '154' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (C_Order.PaymentRule = list6.value and list6.ad_reference_id = '195' and list6.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table13 on (C_Order.C_PaymentTerm_ID = table13.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL13 on (table13.C_PaymentTerm_ID = tableTRL13.C_PaymentTerm_ID and tableTRL13.AD_Language = ?)  left join (select C_Incoterms_ID, Name from C_Incoterms) table14 on (C_Order.C_Incoterms_ID = table14.C_Incoterms_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table15 on (C_Order.Delivery_Location_ID =  table15.C_BPartner_Location_ID) left join ad_ref_list_v list7 on (C_Order.DeliveryViaRule = list7.value and list7.ad_reference_id = '152' and list7.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table16 on (C_Order.M_Shipper_ID = table16.M_Shipper_ID) left join (select C_UOM_ID, Name from C_UOM) table17 on (C_Order.Weight_Uom =  table17.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL17 on (table17.C_UOM_ID = tableTRL17.C_UOM_ID and tableTRL17.AD_Language = ?)  left join ad_ref_list_v list8 on (C_Order.FreightCostRule = list8.value and list8.ad_reference_id = '153' and list8.ad_language = ?)  left join (select M_Product_ID, value, Name from M_Product) table18 on (C_Order.M_Product_ID =  table18.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL18 on (table18.M_Product_ID = tableTRL18.M_Product_ID and tableTRL18.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table19 on (C_Order.C_Project_ID = table19.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table20 on (C_Order.C_Projecttask_ID = table20.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table21 on (table20.C_Project_ID = table21.C_Project_ID) left join (select C_Order_ID, DocumentNo from C_Order) table22 on (C_Order.Orderselfjoin =  table22.C_Order_ID) left join ad_ref_list_v list9 on (C_Order.Invoicefrequence = list9.value and list9.ad_reference_id = 'F17BFE71276743BBB6105EE61D9FD666' and list9.ad_language = ?)  left join ad_ref_list_v list10 on (C_Order.Quarterly_Month = list10.value and list10.ad_reference_id = '99780AA6C1644A329162A8AF74602925' and list10.ad_language = ?)  left join ad_ref_list_v list11 on (C_Order.Yearly_Month = list11.value and list11.ad_reference_id = 'B849337BE90242BEB0B230808EDC0CEE' and list11.ad_language = ?)  left join ad_ref_list_v list12 on (C_Order.Weekly_Day = list12.value and list12.ad_reference_id = '167' and list12.ad_language = ?)  left join ad_ref_list_v list13 on (C_Order.Proposalstatus = list13.value and list13.ad_reference_id = 'B00D78B6B154404A831F25F11ABD867E' and list13.ad_language = ?)  left join ad_ref_list_v list14 on (C_Order.Lostproposalfixedreason = list14.value and list14.ad_reference_id = 'B51F770E9FA84F5B8FC0FFD7B3848317' and list14.ad_language = ?)  left join ad_ref_list_v list15 on (list15.ad_reference_id = '135' and list15.ad_language = ?  AND (CASE C_Order.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(C_Order.DocAction) END) = list15.value)" +
      "        WHERE 2=2 " +
      " AND C_Order.IsSOTrx='Y' AND C_Order.c_doctype_id <> 'C_DOCTYPE_ID_ORDER_TEMPLATE_0001' AND C_Order.c_doctype_id <> '6C8EA6FFBB2B4ACBA0542BA4F833C499'" +
      "        AND 1=1 " +
      "        AND C_Order.C_Order_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        HeaderData objectHeaderData = new HeaderData();
        objectHeaderData.created = UtilSql.getValue(result, "created");
        objectHeaderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeaderData.updated = UtilSql.getValue(result, "updated");
        objectHeaderData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeaderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeaderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeaderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeaderData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeaderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeaderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeaderData.documentno = UtilSql.getValue(result, "documentno");
        objectHeaderData.poreference = UtilSql.getValue(result, "poreference");
        objectHeaderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectHeaderData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectHeaderData.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectHeaderData.name = UtilSql.getValue(result, "name");
        objectHeaderData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectHeaderData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectHeaderData.docstatus = UtilSql.getValue(result, "docstatus");
        objectHeaderData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectHeaderData.description = UtilSql.getValue(result, "description");
        objectHeaderData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectHeaderData.internalnote = UtilSql.getValue(result, "internalnote");
        objectHeaderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeaderData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeaderData.bpzipcode = UtilSql.getValue(result, "bpzipcode");
        objectHeaderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectHeaderData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectHeaderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectHeaderData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectHeaderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectHeaderData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectHeaderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectHeaderData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectHeaderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectHeaderData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectHeaderData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectHeaderData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectHeaderData.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectHeaderData.estpropability = UtilSql.getValue(result, "estpropability");
        objectHeaderData.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectHeaderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectHeaderData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectHeaderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectHeaderData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectHeaderData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectHeaderData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectHeaderData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectHeaderData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectHeaderData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectHeaderData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectHeaderData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectHeaderData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectHeaderData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectHeaderData.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectHeaderData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectHeaderData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectHeaderData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectHeaderData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectHeaderData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectHeaderData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectHeaderData.weight = UtilSql.getValue(result, "weight");
        objectHeaderData.weightUom = UtilSql.getValue(result, "weight_uom");
        objectHeaderData.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectHeaderData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectHeaderData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectHeaderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeaderData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeaderData.qty = UtilSql.getValue(result, "qty");
        objectHeaderData.freightamt = UtilSql.getValue(result, "freightamt");
        objectHeaderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectHeaderData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectHeaderData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectHeaderData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectHeaderData.orderselfjoin = UtilSql.getValue(result, "orderselfjoin");
        objectHeaderData.orderselfjoinr = UtilSql.getValue(result, "orderselfjoinr");
        objectHeaderData.firstschedinvoicedate = UtilSql.getDateValue(result, "firstschedinvoicedate", "dd-MM-yyyy");
        objectHeaderData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectHeaderData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectHeaderData.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectHeaderData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectHeaderData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectHeaderData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectHeaderData.invoicefrequence = UtilSql.getValue(result, "invoicefrequence");
        objectHeaderData.invoicefrequencer = UtilSql.getValue(result, "invoicefrequencer");
        objectHeaderData.isinvoiceafterfirstcycle = UtilSql.getValue(result, "isinvoiceafterfirstcycle");
        objectHeaderData.quarterlyMonth = UtilSql.getValue(result, "quarterly_month");
        objectHeaderData.quarterlyMonthr = UtilSql.getValue(result, "quarterly_monthr");
        objectHeaderData.yearlyMonth = UtilSql.getValue(result, "yearly_month");
        objectHeaderData.yearlyMonthr = UtilSql.getValue(result, "yearly_monthr");
        objectHeaderData.weeklyDay = UtilSql.getValue(result, "weekly_day");
        objectHeaderData.weeklyDayr = UtilSql.getValue(result, "weekly_dayr");
        objectHeaderData.monthlyDay = UtilSql.getValue(result, "monthly_day");
        objectHeaderData.proposalstatus = UtilSql.getValue(result, "proposalstatus");
        objectHeaderData.proposalstatusr = UtilSql.getValue(result, "proposalstatusr");
        objectHeaderData.lostproposalfixedreason = UtilSql.getValue(result, "lostproposalfixedreason");
        objectHeaderData.lostproposalfixedreasonr = UtilSql.getValue(result, "lostproposalfixedreasonr");
        objectHeaderData.lostproposalreason = UtilSql.getValue(result, "lostproposalreason");
        objectHeaderData.totallinesonetime = UtilSql.getValue(result, "totallinesonetime");
        objectHeaderData.grandtotalonetime = UtilSql.getValue(result, "grandtotalonetime");
        objectHeaderData.totallines = UtilSql.getValue(result, "totallines");
        objectHeaderData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectHeaderData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectHeaderData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectHeaderData.completeordervalue = UtilSql.getValue(result, "completeordervalue");
        objectHeaderData.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectHeaderData.deliverycomplete = UtilSql.getValue(result, "deliverycomplete");
        objectHeaderData.subscriptionchangedate = UtilSql.getDateValue(result, "subscriptionchangedate", "dd-MM-yyyy");
        objectHeaderData.docaction = UtilSql.getValue(result, "docaction");
        objectHeaderData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectHeaderData.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectHeaderData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectHeaderData.copyfrompo = UtilSql.getValue(result, "copyfrompo");
        objectHeaderData.generateproject = UtilSql.getValue(result, "generateproject");
        objectHeaderData.closeproject = UtilSql.getValue(result, "closeproject");
        objectHeaderData.createdropshiporder = UtilSql.getValue(result, "createdropshiporder");
        objectHeaderData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectHeaderData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectHeaderData.performanceperiodstart = UtilSql.getDateValue(result, "performanceperiodstart", "dd-MM-yyyy");
        objectHeaderData.performanceperiodend = UtilSql.getDateValue(result, "performanceperiodend", "dd-MM-yyyy");
        objectHeaderData.ispaid = UtilSql.getValue(result, "ispaid");
        objectHeaderData.transactionreference = UtilSql.getValue(result, "transactionreference");
        objectHeaderData.isselected = UtilSql.getValue(result, "isselected");
        objectHeaderData.isactive = UtilSql.getValue(result, "isactive");
        objectHeaderData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectHeaderData.posted = UtilSql.getValue(result, "posted");
        objectHeaderData.processing = UtilSql.getValue(result, "processing");
        objectHeaderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectHeaderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectHeaderData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectHeaderData.processed = UtilSql.getValue(result, "processed");
        objectHeaderData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectHeaderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectHeaderData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectHeaderData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectHeaderData.isprinted = UtilSql.getValue(result, "isprinted");
        objectHeaderData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectHeaderData.language = UtilSql.getValue(result, "language");
        objectHeaderData.adUserClient = "";
        objectHeaderData.adOrgClient = "";
        objectHeaderData.createdby = "";
        objectHeaderData.trBgcolor = "";
        objectHeaderData.totalCount = "";
        objectHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    HeaderData objectHeaderData[] = new HeaderData[vector.size()];
    vector.copyInto(objectHeaderData);
    return(objectHeaderData);
  }

/**
Create a registry
 */
  public static HeaderData[] set(String cBpartnerId, String cBpartnerIdr, String priorityrule, String generateproject, String adClientId, String billtoId, String cIncotermsId, String isselected, String freightamt, String mShipperId, String performanceperiodstart, String istaxincluded, String qty, String cProjecttaskId, String performanceperiodend, String cChargeId, String mProductId, String totallines, String ispaid, String enddate, String weightUom, String proposalstatus, String posted, String weight, String name, String chargeamt, String invoicefrequence, String scheddeliverydate, String cBpartnerLocationId, String internalnote, String isdiscountprinted, String totallinesonetime, String freightcostrule, String datepromised, String cPaymenttermId, String contractdate, String docstatus, String cProjectId, String cProjectIdr, String paymentrule, String generatetemplate, String transactiondate, String lostproposalfixedreason, String updatedby, String updatedbyr, String deliveryLocationId, String salesrepId, String poreference, String mWarehouseId, String schedtransactiondate, String createdropshiporder, String deliverycomplete, String cOrderId, String copyfrom, String isdelivered, String deliveryrule, String issotrx, String isselfservice, String createdby, String createdbyr, String dateordered, String cActivityId, String documentno, String monthlyDay, String completeordervalue, String copyfrompo, String subscriptionchangedate, String cCurrencyId, String adOrgId, String totalpaid, String bpzipcode, String grandtotalonetime, String cDoctypetargetId, String invoicerule, String closeproject, String transactionreference, String isinvoiceafterfirstcycle, String deliverynotes, String incotermsdescription, String mPricelistId, String invoicedamt, String processed, String deliveryviarule, String weeklyDay, String estpropability, String description, String docaction, String docactionBtn, String isprinted, String dateprinted, String grandtotal, String isinvoiced, String orderselfjoin, String iscompletelyinvoiced, String lostproposalreason, String isactive, String cDoctypeId, String adUserId, String quarterlyMonth, String firstschedinvoicedate, String processing, String yearlyMonth)    throws ServletException {
    HeaderData objectHeaderData[] = new HeaderData[1];
    objectHeaderData[0] = new HeaderData();
    objectHeaderData[0].created = "";
    objectHeaderData[0].createdbyr = createdbyr;
    objectHeaderData[0].updated = "";
    objectHeaderData[0].updatedTimeStamp = "";
    objectHeaderData[0].updatedby = updatedby;
    objectHeaderData[0].updatedbyr = updatedbyr;
    objectHeaderData[0].adClientId = adClientId;
    objectHeaderData[0].adClientIdr = "";
    objectHeaderData[0].adOrgId = adOrgId;
    objectHeaderData[0].adOrgIdr = "";
    objectHeaderData[0].documentno = documentno;
    objectHeaderData[0].poreference = poreference;
    objectHeaderData[0].dateordered = dateordered;
    objectHeaderData[0].cDoctypetargetId = cDoctypetargetId;
    objectHeaderData[0].cDoctypetargetIdr = "";
    objectHeaderData[0].name = name;
    objectHeaderData[0].cDoctypeId = cDoctypeId;
    objectHeaderData[0].cDoctypeIdr = "";
    objectHeaderData[0].docstatus = docstatus;
    objectHeaderData[0].docstatusr = "";
    objectHeaderData[0].description = description;
    objectHeaderData[0].deliverynotes = deliverynotes;
    objectHeaderData[0].internalnote = internalnote;
    objectHeaderData[0].cBpartnerId = cBpartnerId;
    objectHeaderData[0].cBpartnerIdr = cBpartnerIdr;
    objectHeaderData[0].bpzipcode = bpzipcode;
    objectHeaderData[0].billtoId = billtoId;
    objectHeaderData[0].billtoIdr = "";
    objectHeaderData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectHeaderData[0].cBpartnerLocationIdr = "";
    objectHeaderData[0].adUserId = adUserId;
    objectHeaderData[0].adUserIdr = "";
    objectHeaderData[0].salesrepId = salesrepId;
    objectHeaderData[0].salesrepIdr = "";
    objectHeaderData[0].mPricelistId = mPricelistId;
    objectHeaderData[0].mPricelistIdr = "";
    objectHeaderData[0].isdiscountprinted = isdiscountprinted;
    objectHeaderData[0].invoicerule = invoicerule;
    objectHeaderData[0].invoiceruler = "";
    objectHeaderData[0].estpropability = estpropability;
    objectHeaderData[0].estpropabilityr = "";
    objectHeaderData[0].mWarehouseId = mWarehouseId;
    objectHeaderData[0].mWarehouseIdr = "";
    objectHeaderData[0].cCurrencyId = cCurrencyId;
    objectHeaderData[0].cCurrencyIdr = "";
    objectHeaderData[0].deliveryrule = deliveryrule;
    objectHeaderData[0].deliveryruler = "";
    objectHeaderData[0].priorityrule = priorityrule;
    objectHeaderData[0].priorityruler = "";
    objectHeaderData[0].paymentrule = paymentrule;
    objectHeaderData[0].paymentruler = "";
    objectHeaderData[0].cPaymenttermId = cPaymenttermId;
    objectHeaderData[0].cPaymenttermIdr = "";
    objectHeaderData[0].cIncotermsId = cIncotermsId;
    objectHeaderData[0].cIncotermsIdr = "";
    objectHeaderData[0].deliveryLocationId = deliveryLocationId;
    objectHeaderData[0].deliveryLocationIdr = "";
    objectHeaderData[0].deliveryviarule = deliveryviarule;
    objectHeaderData[0].deliveryviaruler = "";
    objectHeaderData[0].mShipperId = mShipperId;
    objectHeaderData[0].mShipperIdr = "";
    objectHeaderData[0].weight = weight;
    objectHeaderData[0].weightUom = weightUom;
    objectHeaderData[0].weightUomr = "";
    objectHeaderData[0].freightcostrule = freightcostrule;
    objectHeaderData[0].freightcostruler = "";
    objectHeaderData[0].mProductId = mProductId;
    objectHeaderData[0].mProductIdr = "";
    objectHeaderData[0].qty = qty;
    objectHeaderData[0].freightamt = freightamt;
    objectHeaderData[0].cProjectId = cProjectId;
    objectHeaderData[0].cProjectIdr = cProjectIdr;
    objectHeaderData[0].cProjecttaskId = cProjecttaskId;
    objectHeaderData[0].cProjecttaskIdr = "";
    objectHeaderData[0].orderselfjoin = orderselfjoin;
    objectHeaderData[0].orderselfjoinr = "";
    objectHeaderData[0].firstschedinvoicedate = firstschedinvoicedate;
    objectHeaderData[0].datepromised = datepromised;
    objectHeaderData[0].scheddeliverydate = scheddeliverydate;
    objectHeaderData[0].schedtransactiondate = schedtransactiondate;
    objectHeaderData[0].transactiondate = transactiondate;
    objectHeaderData[0].contractdate = contractdate;
    objectHeaderData[0].enddate = enddate;
    objectHeaderData[0].invoicefrequence = invoicefrequence;
    objectHeaderData[0].invoicefrequencer = "";
    objectHeaderData[0].isinvoiceafterfirstcycle = isinvoiceafterfirstcycle;
    objectHeaderData[0].quarterlyMonth = quarterlyMonth;
    objectHeaderData[0].quarterlyMonthr = "";
    objectHeaderData[0].yearlyMonth = yearlyMonth;
    objectHeaderData[0].yearlyMonthr = "";
    objectHeaderData[0].weeklyDay = weeklyDay;
    objectHeaderData[0].weeklyDayr = "";
    objectHeaderData[0].monthlyDay = monthlyDay;
    objectHeaderData[0].proposalstatus = proposalstatus;
    objectHeaderData[0].proposalstatusr = "";
    objectHeaderData[0].lostproposalfixedreason = lostproposalfixedreason;
    objectHeaderData[0].lostproposalfixedreasonr = "";
    objectHeaderData[0].lostproposalreason = lostproposalreason;
    objectHeaderData[0].totallinesonetime = totallinesonetime;
    objectHeaderData[0].grandtotalonetime = grandtotalonetime;
    objectHeaderData[0].totallines = totallines;
    objectHeaderData[0].grandtotal = grandtotal;
    objectHeaderData[0].invoicedamt = invoicedamt;
    objectHeaderData[0].totalpaid = totalpaid;
    objectHeaderData[0].completeordervalue = completeordervalue;
    objectHeaderData[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectHeaderData[0].deliverycomplete = deliverycomplete;
    objectHeaderData[0].subscriptionchangedate = subscriptionchangedate;
    objectHeaderData[0].docaction = docaction;
    objectHeaderData[0].docactionBtn = docactionBtn;
    objectHeaderData[0].generatetemplate = generatetemplate;
    objectHeaderData[0].copyfrom = copyfrom;
    objectHeaderData[0].copyfrompo = copyfrompo;
    objectHeaderData[0].generateproject = generateproject;
    objectHeaderData[0].closeproject = closeproject;
    objectHeaderData[0].createdropshiporder = createdropshiporder;
    objectHeaderData[0].isdelivered = isdelivered;
    objectHeaderData[0].incotermsdescription = incotermsdescription;
    objectHeaderData[0].performanceperiodstart = performanceperiodstart;
    objectHeaderData[0].performanceperiodend = performanceperiodend;
    objectHeaderData[0].ispaid = ispaid;
    objectHeaderData[0].transactionreference = transactionreference;
    objectHeaderData[0].isselected = isselected;
    objectHeaderData[0].isactive = isactive;
    objectHeaderData[0].istaxincluded = istaxincluded;
    objectHeaderData[0].posted = posted;
    objectHeaderData[0].processing = processing;
    objectHeaderData[0].issotrx = issotrx;
    objectHeaderData[0].cOrderId = cOrderId;
    objectHeaderData[0].dateprinted = dateprinted;
    objectHeaderData[0].processed = processed;
    objectHeaderData[0].chargeamt = chargeamt;
    objectHeaderData[0].cActivityId = cActivityId;
    objectHeaderData[0].isselfservice = isselfservice;
    objectHeaderData[0].cChargeId = cChargeId;
    objectHeaderData[0].isprinted = isprinted;
    objectHeaderData[0].isinvoiced = isinvoiced;
    objectHeaderData[0].language = "";
    return objectHeaderData;
  }

/**
Select for auxiliar field
 */
  public static String selectAux6(ConnectionProvider connectionProvider, String C_DOCTYPETARGET_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DOCSUBTYPESO FROM C_DOCTYPE WHERE C_DOCTYPE_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DOCTYPETARGET_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "docsubtypeso");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef2762_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef3402_1(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef2168_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef2166_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Order" +
      "        SET docaction = ? " +
      "        WHERE C_Order.C_Order_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Order" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , POReference = (?) , DateOrdered = TO_DATE(?) , C_DocTypeTarget_ID = (?) , Name = (?) , C_DocType_ID = (?) , DocStatus = (?) , Description = (?) , Deliverynotes = (?) , Internalnote = (?) , C_BPartner_ID = (?) , bpzipcode = (?) , BillTo_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , SalesRep_ID = (?) , M_PriceList_ID = (?) , IsDiscountPrinted = (?) , InvoiceRule = (?) , Estpropability = (?) , M_Warehouse_ID = (?) , C_Currency_ID = (?) , DeliveryRule = (?) , PriorityRule = (?) , PaymentRule = (?) , C_PaymentTerm_ID = (?) , C_Incoterms_ID = (?) , Delivery_Location_ID = (?) , DeliveryViaRule = (?) , M_Shipper_ID = (?) , Weight = TO_NUMBER(?) , Weight_Uom = (?) , FreightCostRule = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , FreightAmt = TO_NUMBER(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Orderselfjoin = (?) , Firstschedinvoicedate = TO_DATE(?) , DatePromised = TO_DATE(?) , SchedDeliveryDate = TO_DATE(?) , SchedTransactionDate = TO_DATE(?) , TransactionDate = TO_DATE(?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Invoicefrequence = (?) , Isinvoiceafterfirstcycle = (?) , Quarterly_Month = (?) , Yearly_Month = (?) , Weekly_Day = (?) , Monthly_Day = TO_NUMBER(?) , Proposalstatus = (?) , Lostproposalfixedreason = (?) , Lostproposalreason = (?) , Totallinesonetime = TO_NUMBER(?) , Grandtotalonetime = TO_NUMBER(?) , TotalLines = TO_NUMBER(?) , GrandTotal = TO_NUMBER(?) , InvoicedAmt = TO_NUMBER(?) , TotalPaid = TO_NUMBER(?) , CompleteOrderValue = TO_NUMBER(?) , IsCompletelyInvoiced = (?) , DeliveryComplete = (?) , Subscriptionchangedate = TO_DATE(?) , DocAction = (?) , Generatetemplate = (?) , CopyFrom = (?) , CopyFromPO = (?) , Generateproject = (?) , Closeproject = (?) , Createdropshiporder = (?) , IsDelivered = (?) , Incotermsdescription = (?) , performanceperiodstart = TO_DATE(?) , performanceperiodend = TO_DATE(?) , Ispaid = (?) , Transactionreference = (?) , IsSelected = (?) , IsActive = (?) , IsTaxIncluded = (?) , Posted = (?) , Processing = (?) , IsSOTrx = (?) , C_Order_ID = (?) , DatePrinted = TO_DATE(?) , Processed = (?) , ChargeAmt = TO_NUMBER(?) , C_Activity_ID = (?) , IsSelfService = (?) , C_Charge_ID = (?) , IsPrinted = (?) , IsInvoiced = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Order.C_Order_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdropshiporder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_Order " +
      "        (AD_Client_ID, AD_Org_ID, DocumentNo, POReference, DateOrdered, C_DocTypeTarget_ID, Name, C_DocType_ID, DocStatus, Description, Deliverynotes, Internalnote, C_BPartner_ID, bpzipcode, BillTo_ID, C_BPartner_Location_ID, AD_User_ID, SalesRep_ID, M_PriceList_ID, IsDiscountPrinted, InvoiceRule, Estpropability, M_Warehouse_ID, C_Currency_ID, DeliveryRule, PriorityRule, PaymentRule, C_PaymentTerm_ID, C_Incoterms_ID, Delivery_Location_ID, DeliveryViaRule, M_Shipper_ID, Weight, Weight_Uom, FreightCostRule, M_Product_ID, Qty, FreightAmt, C_Project_ID, C_Projecttask_ID, Orderselfjoin, Firstschedinvoicedate, DatePromised, SchedDeliveryDate, SchedTransactionDate, TransactionDate, Contractdate, Enddate, Invoicefrequence, Isinvoiceafterfirstcycle, Quarterly_Month, Yearly_Month, Weekly_Day, Monthly_Day, Proposalstatus, Lostproposalfixedreason, Lostproposalreason, Totallinesonetime, Grandtotalonetime, TotalLines, GrandTotal, InvoicedAmt, TotalPaid, CompleteOrderValue, IsCompletelyInvoiced, DeliveryComplete, Subscriptionchangedate, DocAction, Generatetemplate, CopyFrom, CopyFromPO, Generateproject, Closeproject, Createdropshiporder, IsDelivered, Incotermsdescription, performanceperiodstart, performanceperiodend, Ispaid, Transactionreference, IsSelected, IsActive, IsTaxIncluded, Posted, Processing, IsSOTrx, C_Order_ID, DatePrinted, Processed, ChargeAmt, C_Activity_ID, IsSelfService, C_Charge_ID, IsPrinted, IsInvoiced, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdropshiporder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performanceperiodend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? " +
      "        AND C_Order.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Order.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Order" +
      "        WHERE C_Order.C_Order_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM C_Order" +
      "         WHERE C_Order.C_Order_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM C_Order" +
      "         WHERE C_Order.C_Order_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
