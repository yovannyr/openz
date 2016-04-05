//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Menu;

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
class InstanceSpecificTranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(InstanceSpecificTranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adMenuId;
  public String adMenuIdr;
  public String adMenuTrlInstanceId;
  public String adLanguage;
  public String adLanguager;
  public String name;
  public String adClientId;
  public String isactive;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("ad_menu_id") || fieldName.equals("adMenuId"))
      return adMenuId;
    else if (fieldName.equalsIgnoreCase("ad_menu_idr") || fieldName.equals("adMenuIdr"))
      return adMenuIdr;
    else if (fieldName.equalsIgnoreCase("ad_menu_trl_instance_id") || fieldName.equals("adMenuTrlInstanceId"))
      return adMenuTrlInstanceId;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static InstanceSpecificTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adMenuId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adMenuId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InstanceSpecificTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adMenuId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_menu_trl_instance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_menu_trl_instance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_menu_trl_instance.Updated, ?) as updated, " +
      "        to_char(ad_menu_trl_instance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_menu_trl_instance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_menu_trl_instance.UpdatedBy) as UpdatedByR," +
      "        ad_menu_trl_instance.AD_Menu_id, " +
      "(CASE WHEN ad_menu_trl_instance.AD_Menu_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS AD_Menu_idR, " +
      "ad_menu_trl_instance.AD_Menu_Trl_Instance_ID, " +
      "ad_menu_trl_instance.AD_Language, " +
      "(CASE WHEN ad_menu_trl_instance.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "ad_menu_trl_instance.Name, " +
      "ad_menu_trl_instance.AD_Client_ID, " +
      "COALESCE(ad_menu_trl_instance.Isactive, 'N') AS Isactive, " +
      "ad_menu_trl_instance.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_menu_trl_instance left join (select AD_Menu_id, Name from AD_Menu) table1 on (ad_menu_trl_instance.AD_Menu_id = table1.AD_Menu_id) left join (select AD_Menu_ID,AD_Language, Name from AD_Menu_TRL) tableTRL1 on (table1.AD_Menu_ID = tableTRL1.AD_Menu_ID and tableTRL1.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table2 on (ad_menu_trl_instance.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adMenuId==null || adMenuId.equals(""))?"":"  AND ad_menu_trl_instance.AD_Menu_id = ?  ");
    strSql = strSql + 
      "        AND ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? " +
      "        AND ad_menu_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_menu_trl_instance.AD_Org_ID IN (";
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
      if (adMenuId != null && !(adMenuId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
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
        InstanceSpecificTranslationData objectInstanceSpecificTranslationData = new InstanceSpecificTranslationData();
        objectInstanceSpecificTranslationData.created = UtilSql.getValue(result, "created");
        objectInstanceSpecificTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInstanceSpecificTranslationData.updated = UtilSql.getValue(result, "updated");
        objectInstanceSpecificTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInstanceSpecificTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInstanceSpecificTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInstanceSpecificTranslationData.adMenuId = UtilSql.getValue(result, "ad_menu_id");
        objectInstanceSpecificTranslationData.adMenuIdr = UtilSql.getValue(result, "ad_menu_idr");
        objectInstanceSpecificTranslationData.adMenuTrlInstanceId = UtilSql.getValue(result, "ad_menu_trl_instance_id");
        objectInstanceSpecificTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectInstanceSpecificTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectInstanceSpecificTranslationData.name = UtilSql.getValue(result, "name");
        objectInstanceSpecificTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInstanceSpecificTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectInstanceSpecificTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInstanceSpecificTranslationData.language = UtilSql.getValue(result, "language");
        objectInstanceSpecificTranslationData.adUserClient = "";
        objectInstanceSpecificTranslationData.adOrgClient = "";
        objectInstanceSpecificTranslationData.createdby = "";
        objectInstanceSpecificTranslationData.trBgcolor = "";
        objectInstanceSpecificTranslationData.totalCount = "";
        objectInstanceSpecificTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInstanceSpecificTranslationData);
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
    InstanceSpecificTranslationData objectInstanceSpecificTranslationData[] = new InstanceSpecificTranslationData[vector.size()];
    vector.copyInto(objectInstanceSpecificTranslationData);
    return(objectInstanceSpecificTranslationData);
  }

/**
Create a registry
 */
  public static InstanceSpecificTranslationData[] set(String adMenuId, String adMenuTrlInstanceId, String name, String adOrgId, String isactive, String createdby, String createdbyr, String adClientId, String adLanguage, String updatedby, String updatedbyr)    throws ServletException {
    InstanceSpecificTranslationData objectInstanceSpecificTranslationData[] = new InstanceSpecificTranslationData[1];
    objectInstanceSpecificTranslationData[0] = new InstanceSpecificTranslationData();
    objectInstanceSpecificTranslationData[0].created = "";
    objectInstanceSpecificTranslationData[0].createdbyr = createdbyr;
    objectInstanceSpecificTranslationData[0].updated = "";
    objectInstanceSpecificTranslationData[0].updatedTimeStamp = "";
    objectInstanceSpecificTranslationData[0].updatedby = updatedby;
    objectInstanceSpecificTranslationData[0].updatedbyr = updatedbyr;
    objectInstanceSpecificTranslationData[0].adMenuId = adMenuId;
    objectInstanceSpecificTranslationData[0].adMenuIdr = "";
    objectInstanceSpecificTranslationData[0].adMenuTrlInstanceId = adMenuTrlInstanceId;
    objectInstanceSpecificTranslationData[0].adLanguage = adLanguage;
    objectInstanceSpecificTranslationData[0].adLanguager = "";
    objectInstanceSpecificTranslationData[0].name = name;
    objectInstanceSpecificTranslationData[0].adClientId = adClientId;
    objectInstanceSpecificTranslationData[0].isactive = isactive;
    objectInstanceSpecificTranslationData[0].adOrgId = adOrgId;
    objectInstanceSpecificTranslationData[0].language = "";
    return objectInstanceSpecificTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9BD9613188D94631BF44DAB40E9F0E0D_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef70B7358AE812416C8C8916153B703E29_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ad_menu_trl_instance.AD_Menu_id AS NAME" +
      "        FROM ad_menu_trl_instance" +
      "        WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adMenuId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Menu left join (select AD_Menu_id, Name from AD_Menu) table1 on (AD_Menu.AD_Menu_id = table1.AD_Menu_id) left join (select AD_Menu_ID,AD_Language, Name from AD_Menu_TRL) tableTRL1 on (table1.AD_Menu_ID = tableTRL1.AD_Menu_ID and tableTRL1.AD_Language = ?)  WHERE AD_Menu.AD_Menu_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adMenuId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Menu left join (select AD_Menu_id, Name from AD_Menu) table1 on (AD_Menu.AD_Menu_id = table1.AD_Menu_id) left join (select AD_Menu_ID,AD_Language, Name from AD_Menu_TRL) tableTRL1 on (table1.AD_Menu_ID = tableTRL1.AD_Menu_ID and tableTRL1.AD_Language = ?)  WHERE AD_Menu.AD_Menu_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);

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
      "        UPDATE ad_menu_trl_instance" +
      "        SET AD_Menu_id = (?) , AD_Menu_Trl_Instance_ID = (?) , AD_Language = (?) , Name = (?) , AD_Client_ID = (?) , Isactive = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? " +
      "                 AND ad_menu_trl_instance.AD_Menu_id = ? " +
      "        AND ad_menu_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_menu_trl_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
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
      "        INSERT INTO ad_menu_trl_instance " +
      "        (AD_Menu_id, AD_Menu_Trl_Instance_ID, AD_Language, Name, AD_Client_ID, Isactive, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adMenuId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_menu_trl_instance" +
      "        WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? " +
      "                 AND ad_menu_trl_instance.AD_Menu_id = ? " +
      "        AND ad_menu_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_menu_trl_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adMenuId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_menu_trl_instance" +
      "        WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? " +
      "                 AND ad_menu_trl_instance.AD_Menu_id = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);

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
      "          FROM ad_menu_trl_instance" +
      "         WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? ";

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
      "          FROM ad_menu_trl_instance" +
      "         WHERE ad_menu_trl_instance.AD_Menu_Trl_Instance_ID = ? ";

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
