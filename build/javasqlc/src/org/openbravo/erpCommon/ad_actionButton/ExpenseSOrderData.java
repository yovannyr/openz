//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class ExpenseSOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExpenseSOrderData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cBpartnerId;
  public String bpname;
  public String mWarehouseId;
  public String datereport;
  public String dateexpense;
  public String cProjectId;
  public String cActivityId;
  public String cCampaignId;
  public String line;
  public String mProductId;
  public String sResourceassignmentId;
  public String cUomId;
  public String qty;
  public String description;
  public String note;
  public String invoiceprice;
  public String mPricelistId;
  public String documentno;
  public String sTimeexpenselineId;
  public String cCurrencyId;
  public String dateordered;
  public String datepromised;
  public String cBpartnerLocationId;
  public String processing;
  public String stdprecision;
  public String priceprecision;
  public String validfrom;
  public String pricestd;
  public String pricelist;
  public String pricelimit;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("datereport"))
      return datereport;
    else if (fieldName.equalsIgnoreCase("dateexpense"))
      return dateexpense;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("s_resourceassignment_id") || fieldName.equals("sResourceassignmentId"))
      return sResourceassignmentId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("invoiceprice"))
      return invoiceprice;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("s_timeexpenseline_id") || fieldName.equals("sTimeexpenselineId"))
      return sTimeexpenselineId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ExpenseSOrderData[] select(ConnectionProvider connectionProvider, String bpartner, String dateFrom, String dateTo, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, bpartner, dateFrom, dateTo, adUserClient, adUserOrg, 0, 0);
  }

  public static ExpenseSOrderData[] select(ConnectionProvider connectionProvider, String bpartner, String dateFrom, String dateTo, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT E.AD_CLIENT_ID, E.AD_ORG_ID, EL.C_BPARTNER_ID, BP.NAME AS BPNAME, E.M_WAREHOUSE_ID, TO_CHAR(E.DATEREPORT) AS DATEREPORT," +
      "        TO_CHAR(EL.DATEEXPENSE) AS DATEEXPENSE, EL.C_PROJECT_ID, EL.C_ACTIVITY_ID, EL.C_CAMPAIGN_ID, EL.LINE," +
      "        EL.M_PRODUCT_ID, EL.S_RESOURCEASSIGNMENT_ID, EL.C_UOM_ID, EL.QTY, EL.DESCRIPTION, EL.NOTE, EL.INVOICEPRICE," +
      "        COALESCE(BP.M_PRICELIST_ID, E.M_PRICELIST_ID) AS M_PRICELIST_ID, E.DOCUMENTNO, EL.S_TIMEEXPENSELINE_ID, EL.C_CURRENCY_ID," +
      "        '' AS DATEORDERED, '' AS DATEPROMISED, '' AS C_BPARTNER_LOCATION_ID, '' AS PROCESSING," +
      "        '' AS STDPRECISION, '' AS PRICEPRECISION, '' AS VALIDFROM, '' AS PRICESTD, '' AS PRICELIST, '' AS PRICELIMIT " +
      "        FROM S_TIMEEXPENSELINE EL left join  S_RESOURCEASSIGNMENT RA on EL.S_RESOURCEASSIGNMENT_ID=RA.S_RESOURCEASSIGNMENT_ID," +
      "        S_TIMEEXPENSE E,  C_BPARTNER BP" +
      "        WHERE ";
    strSql = strSql + ((bpartner==null || bpartner.equals(""))?"":"  el.C_BPartner_ID=? AND  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  COALESCE(el.DateExpense, e.DateReport) >= TO_DATE(?) AND  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  COALESCE(el.DateExpense, e.DateReport)  < TO_DATE(?) AND  ");
    strSql = strSql + 
      "E.S_TIMEEXPENSE_ID=EL.S_TIMEEXPENSE_ID" +
      "        AND EL.C_BPARTNER_ID=BP.C_BPARTNER_ID" +
      "        AND EL.C_ORDERLINE_ID IS NULL" +
      "        AND EL.ISINVOICED='Y'" +
      "        AND E.PROCESSED='Y'" +
      "        AND E.ISACTIVE='Y'        " +
      "        AND E.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND E.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        ORDER BY E.AD_ORG_ID, el.C_BPartner_ID, el.C_Project_ID, e.S_TimeExpense_ID, el.Line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (bpartner != null && !(bpartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExpenseSOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExpenseSOrderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectExpenseSOrderData.bpname = UtilSql.getValue(result, "bpname");
        objectExpenseSOrderData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectExpenseSOrderData.datereport = UtilSql.getValue(result, "datereport");
        objectExpenseSOrderData.dateexpense = UtilSql.getValue(result, "dateexpense");
        objectExpenseSOrderData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectExpenseSOrderData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectExpenseSOrderData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectExpenseSOrderData.line = UtilSql.getValue(result, "line");
        objectExpenseSOrderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectExpenseSOrderData.sResourceassignmentId = UtilSql.getValue(result, "s_resourceassignment_id");
        objectExpenseSOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExpenseSOrderData.qty = UtilSql.getValue(result, "qty");
        objectExpenseSOrderData.description = UtilSql.getValue(result, "description");
        objectExpenseSOrderData.note = UtilSql.getValue(result, "note");
        objectExpenseSOrderData.invoiceprice = UtilSql.getValue(result, "invoiceprice");
        objectExpenseSOrderData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectExpenseSOrderData.documentno = UtilSql.getValue(result, "documentno");
        objectExpenseSOrderData.sTimeexpenselineId = UtilSql.getValue(result, "s_timeexpenseline_id");
        objectExpenseSOrderData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectExpenseSOrderData.dateordered = UtilSql.getValue(result, "dateordered");
        objectExpenseSOrderData.datepromised = UtilSql.getValue(result, "datepromised");
        objectExpenseSOrderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectExpenseSOrderData.processing = UtilSql.getValue(result, "processing");
        objectExpenseSOrderData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseSOrderData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseSOrderData.validfrom = UtilSql.getValue(result, "validfrom");
        objectExpenseSOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseSOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseSOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static ExpenseSOrderData[] selectPrice(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, String CCurrencyID)    throws ServletException {
    return selectPrice(connectionProvider, MProductID, MPriceListID, CCurrencyID, 0, 0);
  }

  public static ExpenseSOrderData[] selectPrice(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, String CCurrencyID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom " +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_PriceList_Version pv " +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND p.M_Product_ID = ?" +
      "        AND pl.M_PriceList_ID = ?" +
      "        AND pl.C_Currency_ID = ?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CCurrencyID);

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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.pricestd = UtilSql.getValue(result, "pricestd");
        objectExpenseSOrderData.pricelist = UtilSql.getValue(result, "pricelist");
        objectExpenseSOrderData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectExpenseSOrderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectExpenseSOrderData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static int updateTimeExpenseLine(Connection conn, ConnectionProvider connectionProvider, String COrderlineId, String STimeExpenseLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE S_TimeExpenseLine SET C_OrderLine_id = ?" +
      "        WHERE S_TimeExpenseLine_ID= ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, COrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, STimeExpenseLineId);

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

  public static int insertCOrder(Connection conn, ConnectionProvider connectionProvider, String cOrderId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String processing, String cDoctypeId, String cDoctypetargetId, String dateordered, String datepromised, String dateacct, String cBpartnerId, String cBpartnerLocationId, String billtoId, String cCurrencyId, String paymentrule, String cPaymenttermId, String invoicerule, String deliveryrule, String freightcostrule, String deliveryviarule, String mWarehouseId, String mPricelistId, String cProjectId, String cActivityId, String cCampaignId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDER " +
      "          (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY, " +
      "           DOCUMENTNO, DOCSTATUS, DOCACTION, " +
      "           PROCESSING, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "           DATEORDERED, DATEPROMISED, DATEACCT, " +
      "           C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, BILLTO_ID, " +
      "           C_CURRENCY_ID, PAYMENTRULE, C_PAYMENTTERM_ID, " +
      "           INVOICERULE, DELIVERYRULE, FREIGHTCOSTRULE," +
      "           DELIVERYVIARULE, M_WAREHOUSE_ID, M_PRICELIST_ID, " +
      "           C_PROJECT_ID, C_ACTIVITY_ID, C_CAMPAIGN_ID, PRIORITYRULE)" +
      "        VALUES " +
      "          (?,?,?," +
      "           now(),?,now(),?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           TO_DATE(?),TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           ?,?,?," +
      "           ?,?,?,'5')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String line, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String description, String mProductId, String mWarehouseId, String cUomId, String qtyordered, String cCurrencyId, String pricelist, String priceactual, String pricelistId, String pricelimit, String cTaxId, String sResourceassignmentId, String discount)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE " +
      "          (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, " +
      "           CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           C_ORDER_ID, LINE, C_BPARTNER_ID, " +
      "           C_BPARTNER_LOCATION_ID, DATEORDERED, DATEPROMISED, " +
      "           DESCRIPTION, M_PRODUCT_ID, M_WAREHOUSE_ID, " +
      "           C_UOM_ID, QTYORDERED, C_CURRENCY_ID, " +
      "           PRICELIST, PRICEACTUAL, PRICELIMIT, " +
      "           C_TAX_ID, S_RESOURCEASSIGNMENT_ID, DISCOUNT, " +
      "           PRICESTD) " +
      "        VALUES " +
      "          (?,?,?," +
      "           now(),?,now(),?," +
      "           ?,TO_NUMBER(?),?," +
      "           ?,TO_DATE(?),TO_DATE(?)," +
      "           ?,?,?," +
      "           ?,TO_NUMBER(?),?," +
      "           TO_NUMBER(?), M_GET_OFFERS_PRICE(to_date(?),?,?,TO_NUMBER(?),TO_NUMBER(?),?),TO_NUMBER(?), " +
      "           ?, ?,TO_NUMBER(?), " +
      "           TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);

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

  public static String cDoctypeTarget(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT AD_GET_DOCTYPE(?, ?, 'SOO', 'WP') FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y' " +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectBpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT Name" +
      "      FROM C_BPartner " +
      "      WHERE C_BPartner_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static int insertPInstance(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId, String adProcessId, String recordId, String adUserId, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO AD_PINSTANCE " +
      "        (AD_PINSTANCE_ID, AD_PROCESS_ID, RECORD_ID, " +
      "         ISPROCESSING, CREATED, AD_USER_ID, " +
      "         UPDATED, AD_CLIENT_ID, AD_ORG_ID, " +
      "         CREATEDBY, UPDATEDBY)" +
      "      VALUES" +
      "        (?,?,?," +
      "         'N',now(),?," +
      "         now(), ?, ?, " +
      "         ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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

  public static ExpenseSOrderData processOrder(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_Post(?)";

    ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectExpenseSOrderData);
  }

  public static ExpenseSOrderData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    return selectPrecisions(connectionProvider, cCurrencyId, 0, 0);
  }

  public static ExpenseSOrderData[] selectPrecisions(ConnectionProvider connectionProvider, String cCurrencyId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT STDPRECISION, PRICEPRECISION " +
      "          FROM C_CURRENCY " +
      "          WHERE C_CURRENCY_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

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
        ExpenseSOrderData objectExpenseSOrderData = new ExpenseSOrderData();
        objectExpenseSOrderData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectExpenseSOrderData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectExpenseSOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExpenseSOrderData);
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
    ExpenseSOrderData objectExpenseSOrderData[] = new ExpenseSOrderData[vector.size()];
    vector.copyInto(objectExpenseSOrderData);
    return(objectExpenseSOrderData);
  }

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency_ID" +
      "      FROM M_PriceList " +
      "      WHERE M_PriceList_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static String selectConvertedAmt(ConnectionProvider connectionProvider, String expenseAmount, String currencyFrom, String currencyTo, String dateExpense, String client, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_convert(TO_NUMBER(?),?,?,TO_DATE(?),null, ?,?) from dual";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateExpense);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_convert");
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

  public static String selectPaymentTerm(ConnectionProvider connectionProvider, String clientlist)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_paymentterm_id " +
      "        from c_paymentterm " +
      "        where isactive='Y' " +
      "        AND isdefault='Y' " +
      "        AND AD_Client_ID IN (";
    strSql = strSql + ((clientlist==null || clientlist.equals(""))?"":clientlist);
    strSql = strSql + 
      ") ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (clientlist != null && !(clientlist.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_paymentterm_id");
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
