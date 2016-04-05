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
class TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData implements FieldProvider {
static Logger log4j = Logger.getLogger(TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cOrderId;
  public String cOrderIdr;
  public String zssiOrderTextmoduleId;
  public String zssiTextmoduleId;
  public String zssiTextmoduleIdr;
  public String line;
  public String adClientId;
  public String islower;
  public String adOrgId;
  public String ismodified;
  public String text;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("zssi_order_textmodule_id") || fieldName.equals("zssiOrderTextmoduleId"))
      return zssiOrderTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_id") || fieldName.equals("zssiTextmoduleId"))
      return zssiTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_idr") || fieldName.equals("zssiTextmoduleIdr"))
      return zssiTextmoduleIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("islower"))
      return islower;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ismodified"))
      return ismodified;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_order_textmodule.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_order_textmodule.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_order_textmodule.Updated, ?) as updated, " +
      "        to_char(zssi_order_textmodule.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_order_textmodule.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_order_textmodule.UpdatedBy) as UpdatedByR," +
      "        zssi_order_textmodule.C_Order_ID, " +
      "(CASE WHEN zssi_order_textmodule.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "zssi_order_textmodule.Zssi_Order_Textmodule_ID, " +
      "zssi_order_textmodule.Zssi_Textmodule_ID, " +
      "(CASE WHEN zssi_order_textmodule.Zssi_Textmodule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Position), ''))),'') ) END) AS Zssi_Textmodule_IDR, " +
      "zssi_order_textmodule.Line, " +
      "zssi_order_textmodule.AD_Client_ID, " +
      "COALESCE(zssi_order_textmodule.Islower, 'N') AS Islower, " +
      "zssi_order_textmodule.AD_Org_ID, " +
      "COALESCE(zssi_order_textmodule.Ismodified, 'N') AS Ismodified, " +
      "zssi_order_textmodule.Text, " +
      "COALESCE(zssi_order_textmodule.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_order_textmodule left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (zssi_order_textmodule.C_Order_ID = table1.C_Order_ID) left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table2 on (zssi_order_textmodule.Zssi_Textmodule_ID = table2.Zssi_Textmodule_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND zssi_order_textmodule.C_Order_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? " +
      "        AND zssi_order_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_order_textmodule.AD_Org_ID IN (";
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
        TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData = new TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData();
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.created = UtilSql.getValue(result, "created");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.updated = UtilSql.getValue(result, "updated");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.zssiOrderTextmoduleId = UtilSql.getValue(result, "zssi_order_textmodule_id");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.zssiTextmoduleId = UtilSql.getValue(result, "zssi_textmodule_id");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.zssiTextmoduleIdr = UtilSql.getValue(result, "zssi_textmodule_idr");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.line = UtilSql.getValue(result, "line");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.islower = UtilSql.getValue(result, "islower");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.ismodified = UtilSql.getValue(result, "ismodified");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.text = UtilSql.getValue(result, "text");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.isactive = UtilSql.getValue(result, "isactive");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.language = UtilSql.getValue(result, "language");
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.adUserClient = "";
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.adOrgClient = "";
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.createdby = "";
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.trBgcolor = "";
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.totalCount = "";
        objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData);
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
    TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[] = new TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[vector.size()];
    vector.copyInto(objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData);
    return(objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData);
  }

/**
Create a registry
 */
  public static TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[] set(String cOrderId, String text, String islower, String ismodified, String adClientId, String adOrgId, String line, String createdby, String createdbyr, String updatedby, String updatedbyr, String zssiTextmoduleId, String zssiOrderTextmoduleId, String isactive)    throws ServletException {
    TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[] = new TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[1];
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0] = new TextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData();
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].created = "";
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].createdbyr = createdbyr;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].updated = "";
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].updatedTimeStamp = "";
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].updatedby = updatedby;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].updatedbyr = updatedbyr;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].cOrderId = cOrderId;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].cOrderIdr = "";
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].zssiOrderTextmoduleId = zssiOrderTextmoduleId;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].zssiTextmoduleId = zssiTextmoduleId;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].zssiTextmoduleIdr = "";
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].line = line;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].adClientId = adClientId;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].islower = islower;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].adOrgId = adOrgId;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].ismodified = ismodified;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].text = text;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].isactive = isactive;
    objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData[0].language = "";
    return objectTextmoduleACEAD94A98BA4B85AD4D69BC24C5A27BData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE9FA66D9C5AE4E499DD4E6FAA9364C0E(ConnectionProvider connectionProvider, String c_order_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM ZSSI_ORDER_TEXTMODULE WHERE c_order_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef68FEA96B6A2943BAA0F20E91C7D0A409_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef4AB8FAAB8CB64DFBA042409E35FF0884_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_order_textmodule.C_Order_ID AS NAME" +
      "        FROM zssi_order_textmodule" +
      "        WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ?";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

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
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_order_textmodule" +
      "        SET C_Order_ID = (?) , Zssi_Order_Textmodule_ID = (?) , Zssi_Textmodule_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , Islower = (?) , AD_Org_ID = (?) , Ismodified = (?) , Text = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? " +
      "                 AND zssi_order_textmodule.C_Order_ID = ? " +
      "        AND zssi_order_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_order_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOrderTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOrderTextmoduleId);
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
      "        INSERT INTO zssi_order_textmodule " +
      "        (C_Order_ID, Zssi_Order_Textmodule_ID, Zssi_Textmodule_ID, Line, AD_Client_ID, Islower, AD_Org_ID, Ismodified, Text, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOrderTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      "        DELETE FROM zssi_order_textmodule" +
      "        WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? " +
      "                 AND zssi_order_textmodule.C_Order_ID = ? " +
      "        AND zssi_order_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_order_textmodule.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_order_textmodule" +
      "        WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? " +
      "                 AND zssi_order_textmodule.C_Order_ID = ? ";

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
      "          FROM zssi_order_textmodule" +
      "         WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? ";

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
      "          FROM zssi_order_textmodule" +
      "         WHERE zssi_order_textmodule.Zssi_Order_Textmodule_ID = ? ";

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
