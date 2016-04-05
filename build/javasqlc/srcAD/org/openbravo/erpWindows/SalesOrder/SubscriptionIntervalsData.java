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
class SubscriptionIntervalsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SubscriptionIntervalsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cSubscriptionintervalViewId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String poreference;
  public String isactive;
  public String dateordered;
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String aAssetId;
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
  public String generatetemplate;
  public String copyfrom;
  public String copyfrompo;
  public String docaction;
  public String docactionBtn;
  public String cOrderId;
  public String issotrx;
  public String processed;
  public String isdelivered;
  public String isinvoiced;
  public String isprinted;
  public String isselected;
  public String dateprinted;
  public String dateacct;
  public String cChargeId;
  public String chargeamt;
  public String istaxincluded;
  public String cCampaignId;
  public String cActivityId;
  public String posted;
  public String dropshipBpartnerId;
  public String dropshipLocationId;
  public String dropshipUserId;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String incotermsdescription;
  public String cBidprojectId;
  public String cProjectphaseId;
  public String generateproject;
  public String closeproject;
  public String ispaid;
  public String isrecharge;
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
    else if (fieldName.equalsIgnoreCase("c_subscriptioninterval_view_id") || fieldName.equals("cSubscriptionintervalViewId"))
      return cSubscriptionintervalViewId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
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
    else if (fieldName.equalsIgnoreCase("generatetemplate"))
      return generatetemplate;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("copyfrompo"))
      return copyfrompo;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("dropship_user_id") || fieldName.equals("dropshipUserId"))
      return dropshipUserId;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("c_bidproject_id") || fieldName.equals("cBidprojectId"))
      return cBidprojectId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("generateproject"))
      return generateproject;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("isrecharge"))
      return isrecharge;
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
  public static SubscriptionIntervalsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SubscriptionIntervalsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_subscriptioninterval_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptioninterval_view.CreatedBy) as CreatedByR, " +
      "        to_char(c_subscriptioninterval_view.Updated, ?) as updated, " +
      "        to_char(c_subscriptioninterval_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_subscriptioninterval_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_subscriptioninterval_view.UpdatedBy) as UpdatedByR," +
      "        c_subscriptioninterval_view.C_Subscriptioninterval_View_ID, " +
      "c_subscriptioninterval_view.AD_Client_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "c_subscriptioninterval_view.AD_Org_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_subscriptioninterval_view.Documentno, " +
      "c_subscriptioninterval_view.Poreference, " +
      "COALESCE(c_subscriptioninterval_view.Isactive, 'N') AS Isactive, " +
      "c_subscriptioninterval_view.Dateordered, " +
      "c_subscriptioninterval_view.C_Doctypetarget_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Doctypetarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Doctypetarget_IDR, " +
      "c_subscriptioninterval_view.A_Asset_ID, " +
      "c_subscriptioninterval_view.Name, " +
      "c_subscriptioninterval_view.C_Doctype_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "c_subscriptioninterval_view.Docstatus, " +
      "(CASE WHEN c_subscriptioninterval_view.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "c_subscriptioninterval_view.Description, " +
      "c_subscriptioninterval_view.Deliverynotes, " +
      "c_subscriptioninterval_view.Internalnote, " +
      "c_subscriptioninterval_view.C_Bpartner_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_subscriptioninterval_view.bpzipcode, " +
      "c_subscriptioninterval_view.Billto_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Billto_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS Billto_IDR, " +
      "c_subscriptioninterval_view.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_subscriptioninterval_view.AD_User_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "c_subscriptioninterval_view.Salesrep_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "c_subscriptioninterval_view.M_Pricelist_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "COALESCE(c_subscriptioninterval_view.Isdiscountprinted, 'N') AS Isdiscountprinted, " +
      "c_subscriptioninterval_view.Invoicerule, " +
      "(CASE WHEN c_subscriptioninterval_view.Invoicerule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS InvoiceruleR, " +
      "c_subscriptioninterval_view.Estpropability, " +
      "(CASE WHEN c_subscriptioninterval_view.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS EstpropabilityR, " +
      "c_subscriptioninterval_view.M_Warehouse_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "c_subscriptioninterval_view.C_Currency_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "c_subscriptioninterval_view.Deliveryrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Deliveryrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS DeliveryruleR, " +
      "c_subscriptioninterval_view.Priorityrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Priorityrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS PriorityruleR, " +
      "c_subscriptioninterval_view.Paymentrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Paymentrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS PaymentruleR, " +
      "c_subscriptioninterval_view.C_Paymentterm_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Paymentterm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS C_Paymentterm_IDR, " +
      "c_subscriptioninterval_view.C_Incoterms_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "c_subscriptioninterval_view.Delivery_Location_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "c_subscriptioninterval_view.Deliveryviarule, " +
      "(CASE WHEN c_subscriptioninterval_view.Deliveryviarule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS DeliveryviaruleR, " +
      "c_subscriptioninterval_view.M_Shipper_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "c_subscriptioninterval_view.Weight, " +
      "c_subscriptioninterval_view.Weight_Uom, " +
      "(CASE WHEN c_subscriptioninterval_view.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL17.Name IS NULL THEN TO_CHAR(table17.Name) ELSE TO_CHAR(tableTRL17.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "c_subscriptioninterval_view.Freightcostrule, " +
      "(CASE WHEN c_subscriptioninterval_view.Freightcostrule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS FreightcostruleR, " +
      "c_subscriptioninterval_view.M_Product_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_subscriptioninterval_view.Qty, " +
      "c_subscriptioninterval_view.Freightamt, " +
      "c_subscriptioninterval_view.C_Project_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_subscriptioninterval_view.C_Projecttask_ID, " +
      "(CASE WHEN c_subscriptioninterval_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_subscriptioninterval_view.Orderselfjoin, " +
      "(CASE WHEN c_subscriptioninterval_view.Orderselfjoin IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.DocumentNo), ''))),'') ) END) AS OrderselfjoinR, " +
      "c_subscriptioninterval_view.Firstschedinvoicedate, " +
      "c_subscriptioninterval_view.Datepromised, " +
      "c_subscriptioninterval_view.Scheddeliverydate, " +
      "c_subscriptioninterval_view.Schedtransactiondate, " +
      "c_subscriptioninterval_view.Transactiondate, " +
      "c_subscriptioninterval_view.Contractdate, " +
      "c_subscriptioninterval_view.Enddate, " +
      "c_subscriptioninterval_view.Invoicefrequence, " +
      "(CASE WHEN c_subscriptioninterval_view.Invoicefrequence IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS InvoicefrequenceR, " +
      "COALESCE(c_subscriptioninterval_view.Isinvoiceafterfirstcycle, 'N') AS Isinvoiceafterfirstcycle, " +
      "c_subscriptioninterval_view.Quarterly_Month, " +
      "(CASE WHEN c_subscriptioninterval_view.Quarterly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list10.name),'') ) END) AS Quarterly_MonthR, " +
      "c_subscriptioninterval_view.Yearly_Month, " +
      "(CASE WHEN c_subscriptioninterval_view.Yearly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list11.name),'') ) END) AS Yearly_MonthR, " +
      "c_subscriptioninterval_view.Weekly_Day, " +
      "(CASE WHEN c_subscriptioninterval_view.Weekly_Day IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list12.name),'') ) END) AS Weekly_DayR, " +
      "c_subscriptioninterval_view.Monthly_Day, " +
      "c_subscriptioninterval_view.Proposalstatus, " +
      "(CASE WHEN c_subscriptioninterval_view.Proposalstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list13.name),'') ) END) AS ProposalstatusR, " +
      "c_subscriptioninterval_view.Lostproposalfixedreason, " +
      "(CASE WHEN c_subscriptioninterval_view.Lostproposalfixedreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list14.name),'') ) END) AS LostproposalfixedreasonR, " +
      "c_subscriptioninterval_view.Lostproposalreason, " +
      "c_subscriptioninterval_view.Totallinesonetime, " +
      "c_subscriptioninterval_view.Grandtotalonetime, " +
      "c_subscriptioninterval_view.Totallines, " +
      "c_subscriptioninterval_view.Grandtotal, " +
      "c_subscriptioninterval_view.Invoicedamt, " +
      "c_subscriptioninterval_view.Totalpaid, " +
      "c_subscriptioninterval_view.Completeordervalue, " +
      "COALESCE(c_subscriptioninterval_view.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "c_subscriptioninterval_view.Generatetemplate, " +
      "c_subscriptioninterval_view.Copyfrom, " +
      "c_subscriptioninterval_view.Copyfrompo, " +
      "c_subscriptioninterval_view.DocAction, " +
      "list15.name as DocAction_BTN, " +
      "c_subscriptioninterval_view.C_Order_ID, " +
      "COALESCE(c_subscriptioninterval_view.Issotrx, 'N') AS Issotrx, " +
      "COALESCE(c_subscriptioninterval_view.Processed, 'N') AS Processed, " +
      "COALESCE(c_subscriptioninterval_view.Isdelivered, 'N') AS Isdelivered, " +
      "COALESCE(c_subscriptioninterval_view.Isinvoiced, 'N') AS Isinvoiced, " +
      "COALESCE(c_subscriptioninterval_view.Isprinted, 'N') AS Isprinted, " +
      "COALESCE(c_subscriptioninterval_view.Isselected, 'N') AS Isselected, " +
      "c_subscriptioninterval_view.Dateprinted, " +
      "c_subscriptioninterval_view.Dateacct, " +
      "c_subscriptioninterval_view.C_Charge_ID, " +
      "c_subscriptioninterval_view.Chargeamt, " +
      "COALESCE(c_subscriptioninterval_view.Istaxincluded, 'N') AS Istaxincluded, " +
      "c_subscriptioninterval_view.C_Campaign_ID, " +
      "c_subscriptioninterval_view.C_Activity_ID, " +
      "c_subscriptioninterval_view.Posted, " +
      "c_subscriptioninterval_view.Dropship_Bpartner_ID, " +
      "c_subscriptioninterval_view.Dropship_Location_ID, " +
      "c_subscriptioninterval_view.Dropship_User_ID, " +
      "COALESCE(c_subscriptioninterval_view.Isselfservice, 'N') AS Isselfservice, " +
      "c_subscriptioninterval_view.AD_Orgtrx_ID, " +
      "c_subscriptioninterval_view.User1_ID, " +
      "c_subscriptioninterval_view.User2_ID, " +
      "c_subscriptioninterval_view.Incotermsdescription, " +
      "c_subscriptioninterval_view.C_Bidproject_ID, " +
      "c_subscriptioninterval_view.C_Projectphase_ID, " +
      "c_subscriptioninterval_view.Generateproject, " +
      "c_subscriptioninterval_view.Closeproject, " +
      "COALESCE(c_subscriptioninterval_view.Ispaid, 'N') AS Ispaid, " +
      "COALESCE(c_subscriptioninterval_view.Isrecharge, 'N') AS Isrecharge, " +
      "        ? AS LANGUAGE " +
      "        FROM c_subscriptioninterval_view left join (select AD_Client_ID, Name from AD_Client) table1 on (c_subscriptioninterval_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (c_subscriptioninterval_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (c_subscriptioninterval_view.C_Doctypetarget_ID =  table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join (select C_Doctype_ID, Name from C_Doctype) table4 on (c_subscriptioninterval_view.C_Doctype_ID = table4.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (c_subscriptioninterval_view.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (c_subscriptioninterval_view.C_Bpartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (c_subscriptioninterval_view.Billto_ID =  table6.C_BPartner_Location_ID) left join (select C_Bpartner_Location_ID, Name from C_Bpartner_Location) table7 on (c_subscriptioninterval_view.C_Bpartner_Location_ID = table7.C_Bpartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table8 on (c_subscriptioninterval_view.AD_User_ID = table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (c_subscriptioninterval_view.Salesrep_ID =  table9.AD_User_ID) left join (select M_Pricelist_ID, Name from M_Pricelist) table10 on (c_subscriptioninterval_view.M_Pricelist_ID = table10.M_Pricelist_ID) left join ad_ref_list_v list2 on (c_subscriptioninterval_view.Invoicerule = list2.value and list2.ad_reference_id = '150' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (c_subscriptioninterval_view.Estpropability = list3.value and list3.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list3.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table11 on (c_subscriptioninterval_view.M_Warehouse_ID =  table11.M_Warehouse_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table12 on (c_subscriptioninterval_view.C_Currency_ID = table12.C_Currency_ID) left join ad_ref_list_v list4 on (c_subscriptioninterval_view.Deliveryrule = list4.value and list4.ad_reference_id = '151' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (c_subscriptioninterval_view.Priorityrule = list5.value and list5.ad_reference_id = '154' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (c_subscriptioninterval_view.Paymentrule = list6.value and list6.ad_reference_id = '195' and list6.ad_language = ?)  left join (select C_Paymentterm_ID, Name from C_Paymentterm) table13 on (c_subscriptioninterval_view.C_Paymentterm_ID = table13.C_Paymentterm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL13 on (table13.C_PaymentTerm_ID = tableTRL13.C_PaymentTerm_ID and tableTRL13.AD_Language = ?)  left join (select C_Incoterms_ID, Name from C_Incoterms) table14 on (c_subscriptioninterval_view.C_Incoterms_ID = table14.C_Incoterms_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table15 on (c_subscriptioninterval_view.Delivery_Location_ID =  table15.C_BPartner_Location_ID) left join ad_ref_list_v list7 on (c_subscriptioninterval_view.Deliveryviarule = list7.value and list7.ad_reference_id = '152' and list7.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table16 on (c_subscriptioninterval_view.M_Shipper_ID = table16.M_Shipper_ID) left join (select C_UOM_ID, Name from C_UOM) table17 on (c_subscriptioninterval_view.Weight_Uom =  table17.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL17 on (table17.C_UOM_ID = tableTRL17.C_UOM_ID and tableTRL17.AD_Language = ?)  left join ad_ref_list_v list8 on (c_subscriptioninterval_view.Freightcostrule = list8.value and list8.ad_reference_id = '153' and list8.ad_language = ?)  left join (select M_Product_ID, value, Name from M_Product) table18 on (c_subscriptioninterval_view.M_Product_ID =  table18.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL18 on (table18.M_Product_ID = tableTRL18.M_Product_ID and tableTRL18.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table19 on (c_subscriptioninterval_view.C_Project_ID = table19.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table20 on (c_subscriptioninterval_view.C_Projecttask_ID = table20.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table21 on (table20.C_Project_ID = table21.C_Project_ID) left join (select C_Order_ID, DocumentNo from C_Order) table22 on (c_subscriptioninterval_view.Orderselfjoin =  table22.C_Order_ID) left join ad_ref_list_v list9 on (c_subscriptioninterval_view.Invoicefrequence = list9.value and list9.ad_reference_id = 'F17BFE71276743BBB6105EE61D9FD666' and list9.ad_language = ?)  left join ad_ref_list_v list10 on (c_subscriptioninterval_view.Quarterly_Month = list10.value and list10.ad_reference_id = '99780AA6C1644A329162A8AF74602925' and list10.ad_language = ?)  left join ad_ref_list_v list11 on (c_subscriptioninterval_view.Yearly_Month = list11.value and list11.ad_reference_id = 'B849337BE90242BEB0B230808EDC0CEE' and list11.ad_language = ?)  left join ad_ref_list_v list12 on (c_subscriptioninterval_view.Weekly_Day = list12.value and list12.ad_reference_id = '167' and list12.ad_language = ?)  left join ad_ref_list_v list13 on (c_subscriptioninterval_view.Proposalstatus = list13.value and list13.ad_reference_id = 'B00D78B6B154404A831F25F11ABD867E' and list13.ad_language = ?)  left join ad_ref_list_v list14 on (c_subscriptioninterval_view.Lostproposalfixedreason = list14.value and list14.ad_reference_id = 'B51F770E9FA84F5B8FC0FFD7B3848317' and list14.ad_language = ?)  left join ad_ref_list_v list15 on (list15.ad_reference_id = '135' and list15.ad_language = ?  AND (CASE c_subscriptioninterval_view.DocAction WHEN '--' THEN 'CL' ELSE TO_CHAR(c_subscriptioninterval_view.DocAction) END) = list15.value)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND c_subscriptioninterval_view.C_Order_ID = ?  ");
    strSql = strSql + 
      "        AND c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_subscriptioninterval_view.AD_Org_ID IN (";
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
      if (cOrderId != null && !(cOrderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      }
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
        SubscriptionIntervalsData objectSubscriptionIntervalsData = new SubscriptionIntervalsData();
        objectSubscriptionIntervalsData.created = UtilSql.getValue(result, "created");
        objectSubscriptionIntervalsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSubscriptionIntervalsData.updated = UtilSql.getValue(result, "updated");
        objectSubscriptionIntervalsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSubscriptionIntervalsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSubscriptionIntervalsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSubscriptionIntervalsData.cSubscriptionintervalViewId = UtilSql.getValue(result, "c_subscriptioninterval_view_id");
        objectSubscriptionIntervalsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSubscriptionIntervalsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSubscriptionIntervalsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSubscriptionIntervalsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSubscriptionIntervalsData.documentno = UtilSql.getValue(result, "documentno");
        objectSubscriptionIntervalsData.poreference = UtilSql.getValue(result, "poreference");
        objectSubscriptionIntervalsData.isactive = UtilSql.getValue(result, "isactive");
        objectSubscriptionIntervalsData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectSubscriptionIntervalsData.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectSubscriptionIntervalsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectSubscriptionIntervalsData.name = UtilSql.getValue(result, "name");
        objectSubscriptionIntervalsData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectSubscriptionIntervalsData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectSubscriptionIntervalsData.docstatus = UtilSql.getValue(result, "docstatus");
        objectSubscriptionIntervalsData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectSubscriptionIntervalsData.description = UtilSql.getValue(result, "description");
        objectSubscriptionIntervalsData.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectSubscriptionIntervalsData.internalnote = UtilSql.getValue(result, "internalnote");
        objectSubscriptionIntervalsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSubscriptionIntervalsData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSubscriptionIntervalsData.bpzipcode = UtilSql.getValue(result, "bpzipcode");
        objectSubscriptionIntervalsData.billtoId = UtilSql.getValue(result, "billto_id");
        objectSubscriptionIntervalsData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectSubscriptionIntervalsData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectSubscriptionIntervalsData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectSubscriptionIntervalsData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectSubscriptionIntervalsData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectSubscriptionIntervalsData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectSubscriptionIntervalsData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectSubscriptionIntervalsData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSubscriptionIntervalsData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectSubscriptionIntervalsData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectSubscriptionIntervalsData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectSubscriptionIntervalsData.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectSubscriptionIntervalsData.estpropability = UtilSql.getValue(result, "estpropability");
        objectSubscriptionIntervalsData.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectSubscriptionIntervalsData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectSubscriptionIntervalsData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectSubscriptionIntervalsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSubscriptionIntervalsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectSubscriptionIntervalsData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectSubscriptionIntervalsData.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectSubscriptionIntervalsData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectSubscriptionIntervalsData.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectSubscriptionIntervalsData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectSubscriptionIntervalsData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectSubscriptionIntervalsData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSubscriptionIntervalsData.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectSubscriptionIntervalsData.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectSubscriptionIntervalsData.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectSubscriptionIntervalsData.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectSubscriptionIntervalsData.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectSubscriptionIntervalsData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectSubscriptionIntervalsData.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectSubscriptionIntervalsData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectSubscriptionIntervalsData.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectSubscriptionIntervalsData.weight = UtilSql.getValue(result, "weight");
        objectSubscriptionIntervalsData.weightUom = UtilSql.getValue(result, "weight_uom");
        objectSubscriptionIntervalsData.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectSubscriptionIntervalsData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectSubscriptionIntervalsData.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectSubscriptionIntervalsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSubscriptionIntervalsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectSubscriptionIntervalsData.qty = UtilSql.getValue(result, "qty");
        objectSubscriptionIntervalsData.freightamt = UtilSql.getValue(result, "freightamt");
        objectSubscriptionIntervalsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSubscriptionIntervalsData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectSubscriptionIntervalsData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectSubscriptionIntervalsData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectSubscriptionIntervalsData.orderselfjoin = UtilSql.getValue(result, "orderselfjoin");
        objectSubscriptionIntervalsData.orderselfjoinr = UtilSql.getValue(result, "orderselfjoinr");
        objectSubscriptionIntervalsData.firstschedinvoicedate = UtilSql.getDateValue(result, "firstschedinvoicedate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.invoicefrequence = UtilSql.getValue(result, "invoicefrequence");
        objectSubscriptionIntervalsData.invoicefrequencer = UtilSql.getValue(result, "invoicefrequencer");
        objectSubscriptionIntervalsData.isinvoiceafterfirstcycle = UtilSql.getValue(result, "isinvoiceafterfirstcycle");
        objectSubscriptionIntervalsData.quarterlyMonth = UtilSql.getValue(result, "quarterly_month");
        objectSubscriptionIntervalsData.quarterlyMonthr = UtilSql.getValue(result, "quarterly_monthr");
        objectSubscriptionIntervalsData.yearlyMonth = UtilSql.getValue(result, "yearly_month");
        objectSubscriptionIntervalsData.yearlyMonthr = UtilSql.getValue(result, "yearly_monthr");
        objectSubscriptionIntervalsData.weeklyDay = UtilSql.getValue(result, "weekly_day");
        objectSubscriptionIntervalsData.weeklyDayr = UtilSql.getValue(result, "weekly_dayr");
        objectSubscriptionIntervalsData.monthlyDay = UtilSql.getValue(result, "monthly_day");
        objectSubscriptionIntervalsData.proposalstatus = UtilSql.getValue(result, "proposalstatus");
        objectSubscriptionIntervalsData.proposalstatusr = UtilSql.getValue(result, "proposalstatusr");
        objectSubscriptionIntervalsData.lostproposalfixedreason = UtilSql.getValue(result, "lostproposalfixedreason");
        objectSubscriptionIntervalsData.lostproposalfixedreasonr = UtilSql.getValue(result, "lostproposalfixedreasonr");
        objectSubscriptionIntervalsData.lostproposalreason = UtilSql.getValue(result, "lostproposalreason");
        objectSubscriptionIntervalsData.totallinesonetime = UtilSql.getValue(result, "totallinesonetime");
        objectSubscriptionIntervalsData.grandtotalonetime = UtilSql.getValue(result, "grandtotalonetime");
        objectSubscriptionIntervalsData.totallines = UtilSql.getValue(result, "totallines");
        objectSubscriptionIntervalsData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectSubscriptionIntervalsData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectSubscriptionIntervalsData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectSubscriptionIntervalsData.completeordervalue = UtilSql.getValue(result, "completeordervalue");
        objectSubscriptionIntervalsData.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectSubscriptionIntervalsData.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectSubscriptionIntervalsData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectSubscriptionIntervalsData.copyfrompo = UtilSql.getValue(result, "copyfrompo");
        objectSubscriptionIntervalsData.docaction = UtilSql.getValue(result, "docaction");
        objectSubscriptionIntervalsData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectSubscriptionIntervalsData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSubscriptionIntervalsData.issotrx = UtilSql.getValue(result, "issotrx");
        objectSubscriptionIntervalsData.processed = UtilSql.getValue(result, "processed");
        objectSubscriptionIntervalsData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectSubscriptionIntervalsData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectSubscriptionIntervalsData.isprinted = UtilSql.getValue(result, "isprinted");
        objectSubscriptionIntervalsData.isselected = UtilSql.getValue(result, "isselected");
        objectSubscriptionIntervalsData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectSubscriptionIntervalsData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectSubscriptionIntervalsData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectSubscriptionIntervalsData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectSubscriptionIntervalsData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectSubscriptionIntervalsData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectSubscriptionIntervalsData.posted = UtilSql.getValue(result, "posted");
        objectSubscriptionIntervalsData.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectSubscriptionIntervalsData.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectSubscriptionIntervalsData.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectSubscriptionIntervalsData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectSubscriptionIntervalsData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectSubscriptionIntervalsData.user1Id = UtilSql.getValue(result, "user1_id");
        objectSubscriptionIntervalsData.user2Id = UtilSql.getValue(result, "user2_id");
        objectSubscriptionIntervalsData.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectSubscriptionIntervalsData.cBidprojectId = UtilSql.getValue(result, "c_bidproject_id");
        objectSubscriptionIntervalsData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectSubscriptionIntervalsData.generateproject = UtilSql.getValue(result, "generateproject");
        objectSubscriptionIntervalsData.closeproject = UtilSql.getValue(result, "closeproject");
        objectSubscriptionIntervalsData.ispaid = UtilSql.getValue(result, "ispaid");
        objectSubscriptionIntervalsData.isrecharge = UtilSql.getValue(result, "isrecharge");
        objectSubscriptionIntervalsData.language = UtilSql.getValue(result, "language");
        objectSubscriptionIntervalsData.adUserClient = "";
        objectSubscriptionIntervalsData.adOrgClient = "";
        objectSubscriptionIntervalsData.createdby = "";
        objectSubscriptionIntervalsData.trBgcolor = "";
        objectSubscriptionIntervalsData.totalCount = "";
        objectSubscriptionIntervalsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSubscriptionIntervalsData);
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
    SubscriptionIntervalsData objectSubscriptionIntervalsData[] = new SubscriptionIntervalsData[vector.size()];
    vector.copyInto(objectSubscriptionIntervalsData);
    return(objectSubscriptionIntervalsData);
  }

/**
Create a registry
 */
  public static SubscriptionIntervalsData[] set(String cOrderId, String lostproposalreason, String poreference, String freightamt, String transactiondate, String description, String processed, String cBpartnerLocationId, String isinvoiced, String totallines, String totalpaid, String chargeamt, String completeordervalue, String deliveryLocationId, String dateacct, String generatetemplate, String isselected, String cCampaignId, String weeklyDay, String mPricelistId, String freightcostrule, String adOrgtrxId, String cProjectId, String cProjectIdr, String istaxincluded, String ispaid, String issotrx, String generateproject, String internalnote, String docaction, String docactionBtn, String isinvoiceafterfirstcycle, String grandtotalonetime, String isactive, String dateordered, String name, String mShipperId, String bpzipcode, String invoicefrequence, String cChargeId, String invoicerule, String user1Id, String closeproject, String dropshipBpartnerId, String schedtransactiondate, String weightUom, String cSubscriptionintervalViewId, String mWarehouseId, String quarterlyMonth, String qty, String aAssetId, String isdiscountprinted, String createdby, String createdbyr, String dropshipLocationId, String paymentrule, String cIncotermsId, String user2Id, String enddate, String priorityrule, String salesrepId, String updatedby, String updatedbyr, String firstschedinvoicedate, String cActivityId, String cDoctypeId, String cProjectphaseId, String datepromised, String cDoctypetargetId, String iscompletelyinvoiced, String cProjecttaskId, String lostproposalfixedreason, String cPaymenttermId, String dateprinted, String contractdate, String cCurrencyId, String docstatus, String copyfrompo, String posted, String totallinesonetime, String adClientId, String mProductId, String deliveryrule, String cBpartnerId, String cBpartnerIdr, String monthlyDay, String proposalstatus, String deliveryviarule, String documentno, String isdelivered, String isselfservice, String isrecharge, String billtoId, String cBidprojectId, String yearlyMonth, String deliverynotes, String weight, String scheddeliverydate, String grandtotal, String adUserId, String incotermsdescription, String isprinted, String invoicedamt, String estpropability, String adOrgId, String orderselfjoin, String copyfrom, String dropshipUserId)    throws ServletException {
    SubscriptionIntervalsData objectSubscriptionIntervalsData[] = new SubscriptionIntervalsData[1];
    objectSubscriptionIntervalsData[0] = new SubscriptionIntervalsData();
    objectSubscriptionIntervalsData[0].created = "";
    objectSubscriptionIntervalsData[0].createdbyr = createdbyr;
    objectSubscriptionIntervalsData[0].updated = "";
    objectSubscriptionIntervalsData[0].updatedTimeStamp = "";
    objectSubscriptionIntervalsData[0].updatedby = updatedby;
    objectSubscriptionIntervalsData[0].updatedbyr = updatedbyr;
    objectSubscriptionIntervalsData[0].cSubscriptionintervalViewId = cSubscriptionintervalViewId;
    objectSubscriptionIntervalsData[0].adClientId = adClientId;
    objectSubscriptionIntervalsData[0].adClientIdr = "";
    objectSubscriptionIntervalsData[0].adOrgId = adOrgId;
    objectSubscriptionIntervalsData[0].adOrgIdr = "";
    objectSubscriptionIntervalsData[0].documentno = documentno;
    objectSubscriptionIntervalsData[0].poreference = poreference;
    objectSubscriptionIntervalsData[0].isactive = isactive;
    objectSubscriptionIntervalsData[0].dateordered = dateordered;
    objectSubscriptionIntervalsData[0].cDoctypetargetId = cDoctypetargetId;
    objectSubscriptionIntervalsData[0].cDoctypetargetIdr = "";
    objectSubscriptionIntervalsData[0].aAssetId = aAssetId;
    objectSubscriptionIntervalsData[0].name = name;
    objectSubscriptionIntervalsData[0].cDoctypeId = cDoctypeId;
    objectSubscriptionIntervalsData[0].cDoctypeIdr = "";
    objectSubscriptionIntervalsData[0].docstatus = docstatus;
    objectSubscriptionIntervalsData[0].docstatusr = "";
    objectSubscriptionIntervalsData[0].description = description;
    objectSubscriptionIntervalsData[0].deliverynotes = deliverynotes;
    objectSubscriptionIntervalsData[0].internalnote = internalnote;
    objectSubscriptionIntervalsData[0].cBpartnerId = cBpartnerId;
    objectSubscriptionIntervalsData[0].cBpartnerIdr = cBpartnerIdr;
    objectSubscriptionIntervalsData[0].bpzipcode = bpzipcode;
    objectSubscriptionIntervalsData[0].billtoId = billtoId;
    objectSubscriptionIntervalsData[0].billtoIdr = "";
    objectSubscriptionIntervalsData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectSubscriptionIntervalsData[0].cBpartnerLocationIdr = "";
    objectSubscriptionIntervalsData[0].adUserId = adUserId;
    objectSubscriptionIntervalsData[0].adUserIdr = "";
    objectSubscriptionIntervalsData[0].salesrepId = salesrepId;
    objectSubscriptionIntervalsData[0].salesrepIdr = "";
    objectSubscriptionIntervalsData[0].mPricelistId = mPricelistId;
    objectSubscriptionIntervalsData[0].mPricelistIdr = "";
    objectSubscriptionIntervalsData[0].isdiscountprinted = isdiscountprinted;
    objectSubscriptionIntervalsData[0].invoicerule = invoicerule;
    objectSubscriptionIntervalsData[0].invoiceruler = "";
    objectSubscriptionIntervalsData[0].estpropability = estpropability;
    objectSubscriptionIntervalsData[0].estpropabilityr = "";
    objectSubscriptionIntervalsData[0].mWarehouseId = mWarehouseId;
    objectSubscriptionIntervalsData[0].mWarehouseIdr = "";
    objectSubscriptionIntervalsData[0].cCurrencyId = cCurrencyId;
    objectSubscriptionIntervalsData[0].cCurrencyIdr = "";
    objectSubscriptionIntervalsData[0].deliveryrule = deliveryrule;
    objectSubscriptionIntervalsData[0].deliveryruler = "";
    objectSubscriptionIntervalsData[0].priorityrule = priorityrule;
    objectSubscriptionIntervalsData[0].priorityruler = "";
    objectSubscriptionIntervalsData[0].paymentrule = paymentrule;
    objectSubscriptionIntervalsData[0].paymentruler = "";
    objectSubscriptionIntervalsData[0].cPaymenttermId = cPaymenttermId;
    objectSubscriptionIntervalsData[0].cPaymenttermIdr = "";
    objectSubscriptionIntervalsData[0].cIncotermsId = cIncotermsId;
    objectSubscriptionIntervalsData[0].cIncotermsIdr = "";
    objectSubscriptionIntervalsData[0].deliveryLocationId = deliveryLocationId;
    objectSubscriptionIntervalsData[0].deliveryLocationIdr = "";
    objectSubscriptionIntervalsData[0].deliveryviarule = deliveryviarule;
    objectSubscriptionIntervalsData[0].deliveryviaruler = "";
    objectSubscriptionIntervalsData[0].mShipperId = mShipperId;
    objectSubscriptionIntervalsData[0].mShipperIdr = "";
    objectSubscriptionIntervalsData[0].weight = weight;
    objectSubscriptionIntervalsData[0].weightUom = weightUom;
    objectSubscriptionIntervalsData[0].weightUomr = "";
    objectSubscriptionIntervalsData[0].freightcostrule = freightcostrule;
    objectSubscriptionIntervalsData[0].freightcostruler = "";
    objectSubscriptionIntervalsData[0].mProductId = mProductId;
    objectSubscriptionIntervalsData[0].mProductIdr = "";
    objectSubscriptionIntervalsData[0].qty = qty;
    objectSubscriptionIntervalsData[0].freightamt = freightamt;
    objectSubscriptionIntervalsData[0].cProjectId = cProjectId;
    objectSubscriptionIntervalsData[0].cProjectIdr = cProjectIdr;
    objectSubscriptionIntervalsData[0].cProjecttaskId = cProjecttaskId;
    objectSubscriptionIntervalsData[0].cProjecttaskIdr = "";
    objectSubscriptionIntervalsData[0].orderselfjoin = orderselfjoin;
    objectSubscriptionIntervalsData[0].orderselfjoinr = "";
    objectSubscriptionIntervalsData[0].firstschedinvoicedate = firstschedinvoicedate;
    objectSubscriptionIntervalsData[0].datepromised = datepromised;
    objectSubscriptionIntervalsData[0].scheddeliverydate = scheddeliverydate;
    objectSubscriptionIntervalsData[0].schedtransactiondate = schedtransactiondate;
    objectSubscriptionIntervalsData[0].transactiondate = transactiondate;
    objectSubscriptionIntervalsData[0].contractdate = contractdate;
    objectSubscriptionIntervalsData[0].enddate = enddate;
    objectSubscriptionIntervalsData[0].invoicefrequence = invoicefrequence;
    objectSubscriptionIntervalsData[0].invoicefrequencer = "";
    objectSubscriptionIntervalsData[0].isinvoiceafterfirstcycle = isinvoiceafterfirstcycle;
    objectSubscriptionIntervalsData[0].quarterlyMonth = quarterlyMonth;
    objectSubscriptionIntervalsData[0].quarterlyMonthr = "";
    objectSubscriptionIntervalsData[0].yearlyMonth = yearlyMonth;
    objectSubscriptionIntervalsData[0].yearlyMonthr = "";
    objectSubscriptionIntervalsData[0].weeklyDay = weeklyDay;
    objectSubscriptionIntervalsData[0].weeklyDayr = "";
    objectSubscriptionIntervalsData[0].monthlyDay = monthlyDay;
    objectSubscriptionIntervalsData[0].proposalstatus = proposalstatus;
    objectSubscriptionIntervalsData[0].proposalstatusr = "";
    objectSubscriptionIntervalsData[0].lostproposalfixedreason = lostproposalfixedreason;
    objectSubscriptionIntervalsData[0].lostproposalfixedreasonr = "";
    objectSubscriptionIntervalsData[0].lostproposalreason = lostproposalreason;
    objectSubscriptionIntervalsData[0].totallinesonetime = totallinesonetime;
    objectSubscriptionIntervalsData[0].grandtotalonetime = grandtotalonetime;
    objectSubscriptionIntervalsData[0].totallines = totallines;
    objectSubscriptionIntervalsData[0].grandtotal = grandtotal;
    objectSubscriptionIntervalsData[0].invoicedamt = invoicedamt;
    objectSubscriptionIntervalsData[0].totalpaid = totalpaid;
    objectSubscriptionIntervalsData[0].completeordervalue = completeordervalue;
    objectSubscriptionIntervalsData[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectSubscriptionIntervalsData[0].generatetemplate = generatetemplate;
    objectSubscriptionIntervalsData[0].copyfrom = copyfrom;
    objectSubscriptionIntervalsData[0].copyfrompo = copyfrompo;
    objectSubscriptionIntervalsData[0].docaction = docaction;
    objectSubscriptionIntervalsData[0].docactionBtn = docactionBtn;
    objectSubscriptionIntervalsData[0].cOrderId = cOrderId;
    objectSubscriptionIntervalsData[0].issotrx = issotrx;
    objectSubscriptionIntervalsData[0].processed = processed;
    objectSubscriptionIntervalsData[0].isdelivered = isdelivered;
    objectSubscriptionIntervalsData[0].isinvoiced = isinvoiced;
    objectSubscriptionIntervalsData[0].isprinted = isprinted;
    objectSubscriptionIntervalsData[0].isselected = isselected;
    objectSubscriptionIntervalsData[0].dateprinted = dateprinted;
    objectSubscriptionIntervalsData[0].dateacct = dateacct;
    objectSubscriptionIntervalsData[0].cChargeId = cChargeId;
    objectSubscriptionIntervalsData[0].chargeamt = chargeamt;
    objectSubscriptionIntervalsData[0].istaxincluded = istaxincluded;
    objectSubscriptionIntervalsData[0].cCampaignId = cCampaignId;
    objectSubscriptionIntervalsData[0].cActivityId = cActivityId;
    objectSubscriptionIntervalsData[0].posted = posted;
    objectSubscriptionIntervalsData[0].dropshipBpartnerId = dropshipBpartnerId;
    objectSubscriptionIntervalsData[0].dropshipLocationId = dropshipLocationId;
    objectSubscriptionIntervalsData[0].dropshipUserId = dropshipUserId;
    objectSubscriptionIntervalsData[0].isselfservice = isselfservice;
    objectSubscriptionIntervalsData[0].adOrgtrxId = adOrgtrxId;
    objectSubscriptionIntervalsData[0].user1Id = user1Id;
    objectSubscriptionIntervalsData[0].user2Id = user2Id;
    objectSubscriptionIntervalsData[0].incotermsdescription = incotermsdescription;
    objectSubscriptionIntervalsData[0].cBidprojectId = cBidprojectId;
    objectSubscriptionIntervalsData[0].cProjectphaseId = cProjectphaseId;
    objectSubscriptionIntervalsData[0].generateproject = generateproject;
    objectSubscriptionIntervalsData[0].closeproject = closeproject;
    objectSubscriptionIntervalsData[0].ispaid = ispaid;
    objectSubscriptionIntervalsData[0].isrecharge = isrecharge;
    objectSubscriptionIntervalsData[0].language = "";
    return objectSubscriptionIntervalsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8E484ACDA22C4137912AB7CE03F16DF6_0(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
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
  public static String selectDefDCC3A82F3D444E338D83C930D884FC48_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

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

/**
Select for auxiliar field
 */
  public static String selectDef851ED0863DD048029EBBEBFAFA8F1601_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

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
  public static String selectDef8AFDA0D37D114D80B6F7A77103DA7A72_3(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_subscriptioninterval_view.C_Order_ID AS NAME" +
      "        FROM c_subscriptioninterval_view" +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(C_Order.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(C_Order.Name), '')) || ' - ' || TO_CHAR(C_Order.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(C_Order.GrandTotal), ''))) AS NAME FROM C_Order WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(C_Order.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(C_Order.Name), '')) || ' - ' || TO_CHAR(C_Order.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(C_Order.GrandTotal), ''))) AS NAME FROM C_Order WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static int updateDocAction(ConnectionProvider connectionProvider, String docaction, String cSubscriptionintervalViewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_subscriptioninterval_view" +
      "        SET docaction = ? " +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);

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
      "        UPDATE c_subscriptioninterval_view" +
      "        SET C_Subscriptioninterval_View_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Documentno = (?) , Poreference = (?) , Isactive = (?) , Dateordered = TO_DATE(?) , C_Doctypetarget_ID = (?) , A_Asset_ID = (?) , Name = (?) , C_Doctype_ID = (?) , Docstatus = (?) , Description = (?) , Deliverynotes = (?) , Internalnote = (?) , C_Bpartner_ID = (?) , bpzipcode = (?) , Billto_ID = (?) , C_Bpartner_Location_ID = (?) , AD_User_ID = (?) , Salesrep_ID = (?) , M_Pricelist_ID = (?) , Isdiscountprinted = (?) , Invoicerule = (?) , Estpropability = (?) , M_Warehouse_ID = (?) , C_Currency_ID = (?) , Deliveryrule = (?) , Priorityrule = (?) , Paymentrule = (?) , C_Paymentterm_ID = (?) , C_Incoterms_ID = (?) , Delivery_Location_ID = (?) , Deliveryviarule = (?) , M_Shipper_ID = (?) , Weight = TO_NUMBER(?) , Weight_Uom = (?) , Freightcostrule = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , Freightamt = TO_NUMBER(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Orderselfjoin = (?) , Firstschedinvoicedate = TO_DATE(?) , Datepromised = TO_DATE(?) , Scheddeliverydate = TO_DATE(?) , Schedtransactiondate = TO_DATE(?) , Transactiondate = TO_DATE(?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Invoicefrequence = (?) , Isinvoiceafterfirstcycle = (?) , Quarterly_Month = (?) , Yearly_Month = (?) , Weekly_Day = (?) , Monthly_Day = TO_NUMBER(?) , Proposalstatus = (?) , Lostproposalfixedreason = (?) , Lostproposalreason = (?) , Totallinesonetime = TO_NUMBER(?) , Grandtotalonetime = TO_NUMBER(?) , Totallines = TO_NUMBER(?) , Grandtotal = TO_NUMBER(?) , Invoicedamt = TO_NUMBER(?) , Totalpaid = TO_NUMBER(?) , Completeordervalue = TO_NUMBER(?) , Iscompletelyinvoiced = (?) , Generatetemplate = (?) , Copyfrom = (?) , Copyfrompo = (?) , DocAction = (?) , C_Order_ID = (?) , Issotrx = (?) , Processed = (?) , Isdelivered = (?) , Isinvoiced = (?) , Isprinted = (?) , Isselected = (?) , Dateprinted = TO_DATE(?) , Dateacct = TO_DATE(?) , C_Charge_ID = (?) , Chargeamt = TO_NUMBER(?) , Istaxincluded = (?) , C_Campaign_ID = (?) , C_Activity_ID = (?) , Posted = (?) , Dropship_Bpartner_ID = (?) , Dropship_Location_ID = (?) , Dropship_User_ID = (?) , Isselfservice = (?) , AD_Orgtrx_ID = (?) , User1_ID = (?) , User2_ID = (?) , Incotermsdescription = (?) , C_Bidproject_ID = (?) , C_Projectphase_ID = (?) , Generateproject = (?) , Closeproject = (?) , Ispaid = (?) , Isrecharge = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "                 AND c_subscriptioninterval_view.C_Order_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptioninterval_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
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
      "        INSERT INTO c_subscriptioninterval_view " +
      "        (C_Subscriptioninterval_View_ID, AD_Client_ID, AD_Org_ID, Documentno, Poreference, Isactive, Dateordered, C_Doctypetarget_ID, A_Asset_ID, Name, C_Doctype_ID, Docstatus, Description, Deliverynotes, Internalnote, C_Bpartner_ID, bpzipcode, Billto_ID, C_Bpartner_Location_ID, AD_User_ID, Salesrep_ID, M_Pricelist_ID, Isdiscountprinted, Invoicerule, Estpropability, M_Warehouse_ID, C_Currency_ID, Deliveryrule, Priorityrule, Paymentrule, C_Paymentterm_ID, C_Incoterms_ID, Delivery_Location_ID, Deliveryviarule, M_Shipper_ID, Weight, Weight_Uom, Freightcostrule, M_Product_ID, Qty, Freightamt, C_Project_ID, C_Projecttask_ID, Orderselfjoin, Firstschedinvoicedate, Datepromised, Scheddeliverydate, Schedtransactiondate, Transactiondate, Contractdate, Enddate, Invoicefrequence, Isinvoiceafterfirstcycle, Quarterly_Month, Yearly_Month, Weekly_Day, Monthly_Day, Proposalstatus, Lostproposalfixedreason, Lostproposalreason, Totallinesonetime, Grandtotalonetime, Totallines, Grandtotal, Invoicedamt, Totalpaid, Completeordervalue, Iscompletelyinvoiced, Generatetemplate, Copyfrom, Copyfrompo, DocAction, C_Order_ID, Issotrx, Processed, Isdelivered, Isinvoiced, Isprinted, Isselected, Dateprinted, Dateacct, C_Charge_ID, Chargeamt, Istaxincluded, C_Campaign_ID, C_Activity_ID, Posted, Dropship_Bpartner_ID, Dropship_Location_ID, Dropship_User_ID, Isselfservice, AD_Orgtrx_ID, User1_ID, User2_ID, Incotermsdescription, C_Bidproject_ID, C_Projectphase_ID, Generateproject, Closeproject, Ispaid, Isrecharge, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSubscriptionintervalViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cOrderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_subscriptioninterval_view" +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "                 AND c_subscriptioninterval_view.C_Order_ID = ? " +
      "        AND c_subscriptioninterval_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_subscriptioninterval_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_subscriptioninterval_view" +
      "        WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? " +
      "                 AND c_subscriptioninterval_view.C_Order_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
      "          FROM c_subscriptioninterval_view" +
      "         WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? ";

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
      "          FROM c_subscriptioninterval_view" +
      "         WHERE c_subscriptioninterval_view.C_Subscriptioninterval_View_ID = ? ";

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
