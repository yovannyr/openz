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
Report for asset depreciation schedule
 */
class ReportAssetDepreciationScheduleData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportAssetDepreciationScheduleData.class);
  private String InitRecordNumber="0";
  public String assetname;
  public String assetdescription;
  public String fieldfiscalyear;
  public String startdate;
  public String enddate;
  public String amount;
  public String currency;
  public String initamt;
  public String currentamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("assetname"))
      return assetname;
    else if (fieldName.equalsIgnoreCase("assetdescription"))
      return assetdescription;
    else if (fieldName.equalsIgnoreCase("fieldfiscalyear"))
      return fieldfiscalyear;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("initamt"))
      return initamt;
    else if (fieldName.equalsIgnoreCase("currentamt"))
      return currentamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Method used for search(HTML) and PDF 
 */
  public static ReportAssetDepreciationScheduleData[] select(ConnectionProvider connectionProvider, String client, String DateFrom, String DateTo, String assetSeaKey, String assetDescription, String cAssetCategoryId, String cAcctSchemaId, String Org)    throws ServletException {
    return select(connectionProvider, client, DateFrom, DateTo, assetSeaKey, assetDescription, cAssetCategoryId, cAcctSchemaId, Org, 0, 0);
  }

/**
Method used for search(HTML) and PDF 
 */
  public static ReportAssetDepreciationScheduleData[] select(ConnectionProvider connectionProvider, String client, String DateFrom, String DateTo, String assetSeaKey, String assetDescription, String cAssetCategoryId, String cAcctSchemaId, String Org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT A.NAME AS ASSETNAME,A.DESCRIPTION AS ASSETDESCRIPTION,to_char(am.dateacct,'YYYY') AS FIELDFISCALYEAR,AM.STARTDATE AS STARTDATE," +
      "    AM.ENDDATE AS ENDDATE,AML.Amortizationamt AS AMOUNT,C.ISO_CODE AS CURRENCY, coalesce(a.assetvalueamt,0) AS initAmt,coalesce(a.assetvalueamt,0)-coalesce(a.depreciatedvalue,0) as currentamt" +
      "    FROM A_ASSET_GROUP AG, A_ASSET A, A_AMORTIZATION AM, A_AMORTIZATIONLINE AML, C_CURRENCY C" +
      "    WHERE AG.A_ASSET_GROUP_ID = A.A_ASSET_GROUP_ID AND A.A_ASSET_ID=AML.A_ASSET_ID AND AM.A_AMORTIZATION_ID=AML.A_AMORTIZATION_ID" +
      "    AND C.C_CURRENCY_ID= AML.C_CURRENCY_ID" +
      "    AND AM.POSTED='Y'" +
      "    AND A.AD_CLIENT_ID = ?" +
      "    AND 1=1";
    strSql = strSql + ((DateFrom==null || DateFrom.equals(""))?"":"  AND AM.STARTDATE >= TO_DATE(?) ");
    strSql = strSql + ((DateTo==null || DateTo.equals(""))?"":"  AND AM.ENDDATE <= TO_DATE(?) ");
    strSql = strSql + ((assetSeaKey==null || assetSeaKey.equals("") || assetSeaKey.equals("%") )?"":"  AND UPPER(A.VALUE) LIKE UPPER(?) ");
    strSql = strSql + ((assetDescription==null || assetDescription.equals("") || assetDescription.equals("%") )?"":"  AND UPPER(A.DESCRIPTION) LIKE UPPER(?) ");
    strSql = strSql + ((cAssetCategoryId==null || cAssetCategoryId.equals(""))?"":"   AND AG.A_ASSET_GROUP_ID = ? ");
    strSql = strSql + ((cAcctSchemaId==null || cAcctSchemaId.equals(""))?"":"  AND AG.A_ASSET_GROUP_ID = ? ");
    strSql = strSql + 
      "    AND A.AD_ORG_ID IN (";
    strSql = strSql + ((Org==null || Org.equals(""))?"":Org);
    strSql = strSql + 
      ")" +
      "    ORDER BY A.NAME, AM.STARTDATE, AM.ENDDATE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      if (DateFrom != null && !(DateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateFrom);
      }
      if (DateTo != null && !(DateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo);
      }
      if (assetSeaKey != null && !(assetSeaKey.equals("")) && !(assetSeaKey.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetSeaKey);
      }
      if (assetDescription != null && !(assetDescription.equals("")) && !(assetDescription.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetDescription);
      }
      if (cAssetCategoryId != null && !(cAssetCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAssetCategoryId);
      }
      if (cAcctSchemaId != null && !(cAcctSchemaId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctSchemaId);
      }
      if (Org != null && !(Org.equals(""))) {
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
        ReportAssetDepreciationScheduleData objectReportAssetDepreciationScheduleData = new ReportAssetDepreciationScheduleData();
        objectReportAssetDepreciationScheduleData.assetname = UtilSql.getValue(result, "assetname");
        objectReportAssetDepreciationScheduleData.assetdescription = UtilSql.getValue(result, "assetdescription");
        objectReportAssetDepreciationScheduleData.fieldfiscalyear = UtilSql.getValue(result, "fieldfiscalyear");
        objectReportAssetDepreciationScheduleData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectReportAssetDepreciationScheduleData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectReportAssetDepreciationScheduleData.amount = UtilSql.getValue(result, "amount");
        objectReportAssetDepreciationScheduleData.currency = UtilSql.getValue(result, "currency");
        objectReportAssetDepreciationScheduleData.initamt = UtilSql.getValue(result, "initamt");
        objectReportAssetDepreciationScheduleData.currentamt = UtilSql.getValue(result, "currentamt");
        objectReportAssetDepreciationScheduleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAssetDepreciationScheduleData);
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
    ReportAssetDepreciationScheduleData objectReportAssetDepreciationScheduleData[] = new ReportAssetDepreciationScheduleData[vector.size()];
    vector.copyInto(objectReportAssetDepreciationScheduleData);
    return(objectReportAssetDepreciationScheduleData);
  }

  public static ReportAssetDepreciationScheduleData[] set()    throws ServletException {
    ReportAssetDepreciationScheduleData objectReportAssetDepreciationScheduleData[] = new ReportAssetDepreciationScheduleData[1];
    objectReportAssetDepreciationScheduleData[0] = new ReportAssetDepreciationScheduleData();
    objectReportAssetDepreciationScheduleData[0].assetname = "";
    objectReportAssetDepreciationScheduleData[0].assetdescription = "";
    objectReportAssetDepreciationScheduleData[0].fieldfiscalyear = "";
    objectReportAssetDepreciationScheduleData[0].startdate = "";
    objectReportAssetDepreciationScheduleData[0].enddate = "";
    objectReportAssetDepreciationScheduleData[0].amount = "";
    objectReportAssetDepreciationScheduleData[0].currency = "";
    objectReportAssetDepreciationScheduleData[0].initamt = "";
    objectReportAssetDepreciationScheduleData[0].currentamt = "";
    return objectReportAssetDepreciationScheduleData;
  }
}
