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

class UpdateMaintenanceScheduledData implements FieldProvider {
static Logger log4j = Logger.getLogger(UpdateMaintenanceScheduledData.class);
  private String InitRecordNumber="0";
  public String maMaintScheduledId;
  public String maintscheduled;
  public String scheduleddate;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ma_maint_scheduled_id") || fieldName.equals("maMaintScheduledId"))
      return maMaintScheduledId;
    else if (fieldName.equalsIgnoreCase("maintscheduled"))
      return maintscheduled;
    else if (fieldName.equalsIgnoreCase("scheduleddate"))
      return scheduleddate;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UpdateMaintenanceScheduledData[] select(ConnectionProvider connectionProvider, String language, String scheduleddateFrom, String scheduleddateTo, String maintenancetype)    throws ServletException {
    return select(connectionProvider, language, scheduleddateFrom, scheduleddateTo, maintenancetype, 0, 0);
  }

  public static UpdateMaintenanceScheduledData[] select(ConnectionProvider connectionProvider, String language, String scheduleddateFrom, String scheduleddateTo, String maintenancetype, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MA_Maint_Scheduled_ID, AD_COLUMN_IDENTIFIER(TO_CHAR('MA_Maint_Scheduled'), TO_CHAR(MA_Maint_Scheduled_ID), TO_CHAR(?)) AS maintscheduled, scheduledDate" +
      "        FROM MA_Maint_Scheduled " +
      "        WHERE scheduleddate >= TO_DATE(?)" +
      "          AND confirmed = 'Y'" +
      "          AND MA_Maint_Part_ID IS NULL" +
      "          AND 1=1";
    strSql = strSql + ((scheduleddateTo==null || scheduleddateTo.equals(""))?"":"  AND scheduleddate < TO_DATE(?) + 1  ");
    strSql = strSql + ((maintenancetype==null || maintenancetype.equals(""))?"":"  AND maintenance_type = ? ");

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddateFrom);
      if (scheduleddateTo != null && !(scheduleddateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduleddateTo);
      }
      if (maintenancetype != null && !(maintenancetype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintenancetype);
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
        UpdateMaintenanceScheduledData objectUpdateMaintenanceScheduledData = new UpdateMaintenanceScheduledData();
        objectUpdateMaintenanceScheduledData.maMaintScheduledId = UtilSql.getValue(result, "ma_maint_scheduled_id");
        objectUpdateMaintenanceScheduledData.maintscheduled = UtilSql.getValue(result, "maintscheduled");
        objectUpdateMaintenanceScheduledData.scheduleddate = UtilSql.getDateValue(result, "scheduleddate", "dd-MM-yyyy");
        objectUpdateMaintenanceScheduledData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdateMaintenanceScheduledData);
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
    UpdateMaintenanceScheduledData objectUpdateMaintenanceScheduledData[] = new UpdateMaintenanceScheduledData[vector.size()];
    vector.copyInto(objectUpdateMaintenanceScheduledData);
    return(objectUpdateMaintenanceScheduledData);
  }

  public static int update(Connection conn, ConnectionProvider connectionProvider, String result, String usedtime, String observation, String aduser, String maintpart, String maMaintScheduledId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MA_MAINT_SCHEDULED" +
      "        SET RESULT = ?," +
      "            USEDTIME = TO_NUMBER(?)," +
      "            OBSERVATION = ?," +
      "            UPDATED = now()," +
      "            UPDATEDBY = ?," +
      "            MA_MAINT_PART_ID = ?" +
      "        WHERE MA_MAINT_SCHEDULED_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, observation);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maintpart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMaintScheduledId);

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
}
