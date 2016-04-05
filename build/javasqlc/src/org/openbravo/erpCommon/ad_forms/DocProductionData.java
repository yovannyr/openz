//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DocProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocProductionData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String description;
  public String posted;
  public String movementdate;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String acct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("acct"))
      return acct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocProductionData[] select(ConnectionProvider connectionProvider, String mProductionId)    throws ServletException {
    return select(connectionProvider, mProductionId, 0, 0);
  }

  public static DocProductionData[] select(ConnectionProvider connectionProvider, String mProductionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID, AD_ORG_ID, DESCRIPTION, POSTED, MOVEMENTDATE," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID, USER2_ID, '' AS ACCT" +
      "      FROM M_PRODUCTION	  " +
      "      WHERE M_PRODUCTION_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);

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
        DocProductionData objectDocProductionData = new DocProductionData();
        objectDocProductionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocProductionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocProductionData.description = UtilSql.getValue(result, "description");
        objectDocProductionData.posted = UtilSql.getValue(result, "posted");
        objectDocProductionData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectDocProductionData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocProductionData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocProductionData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocProductionData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocProductionData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocProductionData.acct = UtilSql.getValue(result, "acct");
        objectDocProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocProductionData);
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
    DocProductionData objectDocProductionData[] = new DocProductionData[vector.size()];
    vector.copyInto(objectDocProductionData);
    return(objectDocProductionData);
  }

  public static DocProductionData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocProductionData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID, AD_ORG_ID, DESCRIPTION, POSTED, MOVEMENTDATE," +
      "      C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID, USER2_ID" +
      "      FROM M_PRODUCTION	  " +
      "      WHERE AD_Client_ID=? " +
      "      AND M_PRODUCTION_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocProductionData objectDocProductionData = new DocProductionData();
        objectDocProductionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocProductionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocProductionData.description = UtilSql.getValue(result, "description");
        objectDocProductionData.posted = UtilSql.getValue(result, "posted");
        objectDocProductionData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectDocProductionData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocProductionData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocProductionData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocProductionData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocProductionData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocProductionData);
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
    DocProductionData objectDocProductionData[] = new DocProductionData[vector.size()];
    vector.copyInto(objectDocProductionData);
    return(objectDocProductionData);
  }
}
