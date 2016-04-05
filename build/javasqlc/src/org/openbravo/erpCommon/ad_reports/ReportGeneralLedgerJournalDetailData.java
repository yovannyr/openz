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

class ReportGeneralLedgerJournalDetailData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportGeneralLedgerJournalDetailData.class);
  private String InitRecordNumber="0";
  public String identifier;
  public String dateacct;
  public String dp;
  public String display1;
  public String display2;
  public String value;
  public String name;
  public String amtacctdr;
  public String amtacctcr;
  public String description;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("identifier"))
      return identifier;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("dp"))
      return dp;
    else if (fieldName.equalsIgnoreCase("display1"))
      return display1;
    else if (fieldName.equalsIgnoreCase("display2"))
      return display2;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportGeneralLedgerJournalDetailData[] select(ConnectionProvider connectionProvider, String factAcctGroupId, String dateacct)    throws ServletException {
    return select(connectionProvider, factAcctGroupId, dateacct, 0, 0);
  }

  public static ReportGeneralLedgerJournalDetailData[] select(ConnectionProvider connectionProvider, String factAcctGroupId, String dateacct, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT, F.C_ACCTSCHEMA_ID || '/' ||F.RECORD_ID2 AS DP, (CASE WHEN RECORD_ID2 IS NULL THEN 'none' END) AS DISPLAY1, (CASE WHEN RECORD_ID2 IS NOT NULL THEN 'none' END) AS DISPLAY2, " +
      "        F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME," +
      "        (CASE F.AMTACCTDR WHEN 0 THEN NULL ELSE F.AMTACCTDR END) AS AMTACCTDR, (CASE F.AMTACCTCR WHEN 0 THEN NULL ELSE F.AMTACCTCR END) AS AMTACCTCR, F.DESCRIPTION" +
      "        FROM FACT_ACCT F" +
      "        WHERE FACT_ACCT_GROUP_ID = ?" +
      "        AND (DATEACCT = TO_DATE(?) OR TO_DATE(?) = NULL)" +
      "        ORDER BY F.FACT_ACCT_GROUP_ID, F.SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, factAcctGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);

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
        ReportGeneralLedgerJournalDetailData objectReportGeneralLedgerJournalDetailData = new ReportGeneralLedgerJournalDetailData();
        objectReportGeneralLedgerJournalDetailData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalDetailData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalDetailData.dp = UtilSql.getValue(result, "dp");
        objectReportGeneralLedgerJournalDetailData.display1 = UtilSql.getValue(result, "display1");
        objectReportGeneralLedgerJournalDetailData.display2 = UtilSql.getValue(result, "display2");
        objectReportGeneralLedgerJournalDetailData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalDetailData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalDetailData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalDetailData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalDetailData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerJournalDetailData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerJournalDetailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerJournalDetailData);
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
    ReportGeneralLedgerJournalDetailData objectReportGeneralLedgerJournalDetailData[] = new ReportGeneralLedgerJournalDetailData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerJournalDetailData);
    return(objectReportGeneralLedgerJournalDetailData);
  }

  public static ReportGeneralLedgerJournalDetailData[] selectByDP(ConnectionProvider connectionProvider, String DPid, String acctSchema)    throws ServletException {
    return selectByDP(connectionProvider, DPid, acctSchema, 0, 0);
  }

  public static ReportGeneralLedgerJournalDetailData[] selectByDP(ConnectionProvider connectionProvider, String DPid, String acctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT F.FACT_ACCT_GROUP_ID AS IDENTIFIER, F.DATEACCT, F.C_ACCTSCHEMA_ID || '/' ||F.RECORD_ID2 AS DP, (CASE WHEN RECORD_ID2 IS NULL THEN 'none' END) AS DISPLAY1, (CASE WHEN RECORD_ID2 IS NOT NULL THEN 'none' END) AS DISPLAY2, " +
      "        F.ACCTVALUE AS VALUE, F.ACCTDESCRIPTION AS NAME," +
      "        (CASE F.AMTACCTDR WHEN 0 THEN NULL ELSE F.AMTACCTDR END) AS AMTACCTDR, (CASE F.AMTACCTCR WHEN 0 THEN NULL ELSE F.AMTACCTCR END) AS AMTACCTCR, F.DESCRIPTION" +
      "        FROM FACT_ACCT F" +
      "        WHERE FACT_ACCT_GROUP_ID IN (SELECT DISTINCT FACT_ACCT_GROUP_ID" +
      "                                       FROM FACT_ACCT" +
      "                                      WHERE RECORD_ID2=?" +
      "                                      AND C_ACCTSCHEMA_ID=?)" +
      "        ORDER BY F.DATEACCT, F.FACT_ACCT_GROUP_ID, F.SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DPid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctSchema);

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
        ReportGeneralLedgerJournalDetailData objectReportGeneralLedgerJournalDetailData = new ReportGeneralLedgerJournalDetailData();
        objectReportGeneralLedgerJournalDetailData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalDetailData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportGeneralLedgerJournalDetailData.dp = UtilSql.getValue(result, "dp");
        objectReportGeneralLedgerJournalDetailData.display1 = UtilSql.getValue(result, "display1");
        objectReportGeneralLedgerJournalDetailData.display2 = UtilSql.getValue(result, "display2");
        objectReportGeneralLedgerJournalDetailData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalDetailData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalDetailData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalDetailData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalDetailData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerJournalDetailData.rownum = Long.toString(countRecord);
        objectReportGeneralLedgerJournalDetailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerJournalDetailData);
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
    ReportGeneralLedgerJournalDetailData objectReportGeneralLedgerJournalDetailData[] = new ReportGeneralLedgerJournalDetailData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerJournalDetailData);
    return(objectReportGeneralLedgerJournalDetailData);
  }

  public static ReportGeneralLedgerJournalDetailData[] set()    throws ServletException {
    ReportGeneralLedgerJournalDetailData objectReportGeneralLedgerJournalDetailData[] = new ReportGeneralLedgerJournalDetailData[1];
    objectReportGeneralLedgerJournalDetailData[0] = new ReportGeneralLedgerJournalDetailData();
    objectReportGeneralLedgerJournalDetailData[0].identifier = "";
    objectReportGeneralLedgerJournalDetailData[0].dateacct = "";
    objectReportGeneralLedgerJournalDetailData[0].dp = "";
    objectReportGeneralLedgerJournalDetailData[0].display1 = "";
    objectReportGeneralLedgerJournalDetailData[0].display2 = "";
    objectReportGeneralLedgerJournalDetailData[0].value = "";
    objectReportGeneralLedgerJournalDetailData[0].name = "";
    objectReportGeneralLedgerJournalDetailData[0].amtacctdr = "";
    objectReportGeneralLedgerJournalDetailData[0].amtacctcr = "";
    objectReportGeneralLedgerJournalDetailData[0].description = "";
    return objectReportGeneralLedgerJournalDetailData;
  }
}
