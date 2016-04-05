//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
Clase ReportAgingBalanceData
 */
class ReportAgingBalanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportAgingBalanceData.class);
  private String InitRecordNumber="0";
  public String bpartnerId;
  public String bpartner;
  public String isreceipt;
  public String zero;
  public String one;
  public String two;
  public String three;
  public String four;
  public String five;
  public String total;
  public String adOrgId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bpartner_id") || fieldName.equals("bpartnerId"))
      return bpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("zero"))
      return zero;
    else if (fieldName.equalsIgnoreCase("one"))
      return one;
    else if (fieldName.equalsIgnoreCase("two"))
      return two;
    else if (fieldName.equalsIgnoreCase("three"))
      return three;
    else if (fieldName.equalsIgnoreCase("four"))
      return four;
    else if (fieldName.equalsIgnoreCase("five"))
      return five;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static ReportAgingBalanceData[] select(ConnectionProvider connectionProvider, String adLanguage, String orgTrx, String one, String two, String three, String four, String isreceipt, String cBpartnerId, String orgFamily, String adUserClient, String adUserOrg)    throws ServletException {
    return select(connectionProvider, adLanguage, orgTrx, one, two, three, four, isreceipt, cBpartnerId, orgFamily, adUserClient, adUserOrg, 0, 0);
  }

/**
Select for relation
 */
  public static ReportAgingBalanceData[] select(ConnectionProvider connectionProvider, String adLanguage, String orgTrx, String one, String two, String three, String four, String isreceipt, String cBpartnerId, String orgFamily, String adUserClient, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT BPARTNER AS BPARTNER_ID, AD_COLUMN_IDENTIFIER('C_Bpartner',TO_CHAR(BPARTNER), ?) AS BPARTNER, ISRECEIPT," +
      "        SUM(CASE(SCOPE) WHEN 0 THEN AMOUNT ELSE 0 END) AS ZERO," +
      "        SUM(CASE(SCOPE) WHEN 1 THEN AMOUNT ELSE 0 END) AS ONE," +
      "        SUM(CASE(SCOPE) WHEN 2 THEN AMOUNT ELSE 0 END) AS TWO," +
      "        SUM(CASE(SCOPE) WHEN 3 THEN AMOUNT ELSE 0 END) AS THREE," +
      "        SUM(CASE(SCOPE) WHEN 4 THEN AMOUNT ELSE 0 END) AS FOUR," +
      "        SUM(CASE(SCOPE) WHEN 5 THEN AMOUNT ELSE 0 END) AS FIVE," +
      "        SUM(AMOUNT) AS TOTAL, ? AS AD_ORG_ID" +
      "        FROM(" +
      "          SELECT C_BPARTNER_ID AS BPARTNER, AMOUNT, ISRECEIPT, DATEPLANNED," +
      "          C_AGING_GET_SCOPE(DATEPLANNED, TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?)) AS SCOPE, C_DEBT_PAYMENT_ID" +
      "          FROM  C_DEBT_PAYMENT" +
      "          WHERE C_DEBT_PAYMENT_STATUS(C_SETTLEMENT_CANCEL_ID, CANCEL_PROCESSED, GENERATE_PROCESSED,ISPAID,ISVALID,C_CASHLINE_ID,C_BANKSTATEMENTLINE_ID) = 'P'" +
      "          AND ISRECEIPT = ?" +
      "          AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + 
      "          AND AD_ORG_ID IN(";
    strSql = strSql + ((orgFamily==null || orgFamily.equals(""))?"":orgFamily);
    strSql = strSql + 
      ")" +
      "          AND AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "          ) AAA" +
      "        GROUP BY BPARTNER, ISRECEIPT";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgTrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, one);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, two);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, three);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, four);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (orgFamily != null && !(orgFamily.equals(""))) {
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
        ReportAgingBalanceData objectReportAgingBalanceData = new ReportAgingBalanceData();
        objectReportAgingBalanceData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportAgingBalanceData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportAgingBalanceData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectReportAgingBalanceData.zero = UtilSql.getValue(result, "zero");
        objectReportAgingBalanceData.one = UtilSql.getValue(result, "one");
        objectReportAgingBalanceData.two = UtilSql.getValue(result, "two");
        objectReportAgingBalanceData.three = UtilSql.getValue(result, "three");
        objectReportAgingBalanceData.four = UtilSql.getValue(result, "four");
        objectReportAgingBalanceData.five = UtilSql.getValue(result, "five");
        objectReportAgingBalanceData.total = UtilSql.getValue(result, "total");
        objectReportAgingBalanceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportAgingBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAgingBalanceData);
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
    ReportAgingBalanceData objectReportAgingBalanceData[] = new ReportAgingBalanceData[vector.size()];
    vector.copyInto(objectReportAgingBalanceData);
    return(objectReportAgingBalanceData);
  }

/**
Create a registry
 */
  public static ReportAgingBalanceData[] set()    throws ServletException {
    ReportAgingBalanceData objectReportAgingBalanceData[] = new ReportAgingBalanceData[1];
    objectReportAgingBalanceData[0] = new ReportAgingBalanceData();
    objectReportAgingBalanceData[0].bpartnerId = "";
    objectReportAgingBalanceData[0].bpartner = "";
    objectReportAgingBalanceData[0].isreceipt = "";
    objectReportAgingBalanceData[0].zero = "";
    objectReportAgingBalanceData[0].one = "";
    objectReportAgingBalanceData[0].two = "";
    objectReportAgingBalanceData[0].three = "";
    objectReportAgingBalanceData[0].four = "";
    objectReportAgingBalanceData[0].five = "";
    objectReportAgingBalanceData[0].total = "";
    objectReportAgingBalanceData[0].adOrgId = "";
    return objectReportAgingBalanceData;
  }
}
