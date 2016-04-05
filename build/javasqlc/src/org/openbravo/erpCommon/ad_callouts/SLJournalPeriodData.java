//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SLJournalPeriodData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLJournalPeriodData.class);
  private String InitRecordNumber="0";
  public String periodtype;
  public String startdate;
  public String enddate;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("periodtype"))
      return periodtype;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLJournalPeriodData[] select(ConnectionProvider connectionProvider, String cPeriodId)    throws ServletException {
    return select(connectionProvider, cPeriodId, 0, 0);
  }

  public static SLJournalPeriodData[] select(ConnectionProvider connectionProvider, String cPeriodId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PeriodType, StartDate, EndDate " +
      "      FROM C_Period WHERE C_Period_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);

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
        SLJournalPeriodData objectSLJournalPeriodData = new SLJournalPeriodData();
        objectSLJournalPeriodData.periodtype = UtilSql.getValue(result, "periodtype");
        objectSLJournalPeriodData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectSLJournalPeriodData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectSLJournalPeriodData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLJournalPeriodData);
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
    SLJournalPeriodData objectSLJournalPeriodData[] = new SLJournalPeriodData[vector.size()];
    vector.copyInto(objectSLJournalPeriodData);
    return(objectSLJournalPeriodData);
  }

  public static String period(ConnectionProvider connectionProvider, String adCientId, String adOrgId, String DateAcct)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Period_ID " +
      "      FROM C_Period " +
      "      WHERE C_Year_ID IN " +
      "      (SELECT C_Year_ID FROM C_Year WHERE C_Calendar_ID =" +
      "      (SELECT C_Calendar_ID FROM AD_ORG WHERE AD_Client_ID=? AND AD_ORG_ID=(SELECT AD_ORG_GETCALENDAROWNER(?) from dual)))" +
      "      AND to_date(?) BETWEEN StartDate AND EndDate" +
      "      AND PeriodType='S'" +
      "      AND exists (select 1 from c_periodcontrol where c_periodcontrol.c_period_id = c_period.c_period_id" +
      "      AND periodstatus = 'O')";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateAcct);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_period_id");
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
