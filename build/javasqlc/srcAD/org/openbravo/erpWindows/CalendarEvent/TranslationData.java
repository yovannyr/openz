//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CalendarEvent;

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
class TranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cCalendareventId;
  public String cCalendareventIdr;
  public String adLanguage;
  public String adLanguager;
  public String name;
  public String isactive;
  public String cCalendareventTrlId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_idr") || fieldName.equals("cCalendareventIdr"))
      return cCalendareventIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_trl_id") || fieldName.equals("cCalendareventTrlId"))
      return cCalendareventTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCalendareventId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cCalendareventId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cCalendareventId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_CALENDAREVENT_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CALENDAREVENT_trl.CreatedBy) as CreatedByR, " +
      "        to_char(C_CALENDAREVENT_trl.Updated, ?) as updated, " +
      "        to_char(C_CALENDAREVENT_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_CALENDAREVENT_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CALENDAREVENT_trl.UpdatedBy) as UpdatedByR," +
      "        C_CALENDAREVENT_trl.C_Calendarevent_ID, " +
      "(CASE WHEN C_CALENDAREVENT_trl.C_Calendarevent_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_Calendarevent_IDR, " +
      "C_CALENDAREVENT_trl.AD_Language, " +
      "(CASE WHEN C_CALENDAREVENT_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "C_CALENDAREVENT_trl.Name, " +
      "COALESCE(C_CALENDAREVENT_trl.Isactive, 'N') AS Isactive, " +
      "C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID, " +
      "C_CALENDAREVENT_trl.AD_Client_ID, " +
      "C_CALENDAREVENT_trl.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_CALENDAREVENT_trl left join (select C_Calendarevent_ID, Name from C_Calendarevent) table1 on (C_CALENDAREVENT_trl.C_Calendarevent_ID = table1.C_Calendarevent_ID) left join (select C_Calendarevent_ID,AD_Language, Name from C_CALENDAREVENT_TRL) tableTRL1 on (table1.C_Calendarevent_ID = tableTRL1.C_Calendarevent_ID and tableTRL1.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table2 on (C_CALENDAREVENT_trl.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cCalendareventId==null || cCalendareventId.equals(""))?"":"  AND C_CALENDAREVENT_trl.C_Calendarevent_ID = ?  ");
    strSql = strSql + 
      "        AND C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? " +
      "        AND C_CALENDAREVENT_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_CALENDAREVENT_trl.AD_Org_ID IN (";
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
      if (cCalendareventId != null && !(cCalendareventId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
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
        TranslationData objectTranslationData = new TranslationData();
        objectTranslationData.created = UtilSql.getValue(result, "created");
        objectTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslationData.updated = UtilSql.getValue(result, "updated");
        objectTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslationData.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectTranslationData.cCalendareventIdr = UtilSql.getValue(result, "c_calendarevent_idr");
        objectTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationData.name = UtilSql.getValue(result, "name");
        objectTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationData.cCalendareventTrlId = UtilSql.getValue(result, "c_calendarevent_trl_id");
        objectTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationData.language = UtilSql.getValue(result, "language");
        objectTranslationData.adUserClient = "";
        objectTranslationData.adOrgClient = "";
        objectTranslationData.createdby = "";
        objectTranslationData.trBgcolor = "";
        objectTranslationData.totalCount = "";
        objectTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationData);
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
    TranslationData objectTranslationData[] = new TranslationData[vector.size()];
    vector.copyInto(objectTranslationData);
    return(objectTranslationData);
  }

/**
Create a registry
 */
  public static TranslationData[] set(String cCalendareventId, String updatedby, String updatedbyr, String adOrgId, String adClientId, String cCalendareventTrlId, String adLanguage, String createdby, String createdbyr, String name, String isactive)    throws ServletException {
    TranslationData objectTranslationData[] = new TranslationData[1];
    objectTranslationData[0] = new TranslationData();
    objectTranslationData[0].created = "";
    objectTranslationData[0].createdbyr = createdbyr;
    objectTranslationData[0].updated = "";
    objectTranslationData[0].updatedTimeStamp = "";
    objectTranslationData[0].updatedby = updatedby;
    objectTranslationData[0].updatedbyr = updatedbyr;
    objectTranslationData[0].cCalendareventId = cCalendareventId;
    objectTranslationData[0].cCalendareventIdr = "";
    objectTranslationData[0].adLanguage = adLanguage;
    objectTranslationData[0].adLanguager = "";
    objectTranslationData[0].name = name;
    objectTranslationData[0].isactive = isactive;
    objectTranslationData[0].cCalendareventTrlId = cCalendareventTrlId;
    objectTranslationData[0].adClientId = adClientId;
    objectTranslationData[0].adOrgId = adOrgId;
    objectTranslationData[0].language = "";
    return objectTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA42497DB52D1458984A41A8F6B4B6C96_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefF4A0A99A2A5B400FBE6E77E7989C2ACA_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CALENDAREVENT_trl.C_Calendarevent_ID AS NAME" +
      "        FROM C_CALENDAREVENT_trl" +
      "        WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cCalendareventId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_CALENDAREVENT left join (select C_Calendarevent_ID, Name from C_Calendarevent) table1 on (C_CALENDAREVENT.C_Calendarevent_ID = table1.C_Calendarevent_ID) left join (select C_Calendarevent_ID,AD_Language, Name from C_CALENDAREVENT_TRL) tableTRL1 on (table1.C_Calendarevent_ID = tableTRL1.C_Calendarevent_ID and tableTRL1.AD_Language = ?)  WHERE C_CALENDAREVENT.C_Calendarevent_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cCalendareventId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_CALENDAREVENT left join (select C_Calendarevent_ID, Name from C_Calendarevent) table1 on (C_CALENDAREVENT.C_Calendarevent_ID = table1.C_Calendarevent_ID) left join (select C_Calendarevent_ID,AD_Language, Name from C_CALENDAREVENT_TRL) tableTRL1 on (table1.C_Calendarevent_ID = tableTRL1.C_Calendarevent_ID and tableTRL1.AD_Language = ?)  WHERE C_CALENDAREVENT.C_Calendarevent_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);

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
      "        UPDATE C_CALENDAREVENT_trl" +
      "        SET C_Calendarevent_ID = (?) , AD_Language = (?) , Name = (?) , Isactive = (?) , C_Calendarevent_Trl_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? " +
      "                 AND C_CALENDAREVENT_trl.C_Calendarevent_ID = ? " +
      "        AND C_CALENDAREVENT_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CALENDAREVENT_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
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
      "        INSERT INTO C_CALENDAREVENT_trl " +
      "        (C_Calendarevent_ID, AD_Language, Name, Isactive, C_Calendarevent_Trl_ID, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cCalendareventId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CALENDAREVENT_trl" +
      "        WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? " +
      "                 AND C_CALENDAREVENT_trl.C_Calendarevent_ID = ? " +
      "        AND C_CALENDAREVENT_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CALENDAREVENT_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cCalendareventId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_CALENDAREVENT_trl" +
      "        WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? " +
      "                 AND C_CALENDAREVENT_trl.C_Calendarevent_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);

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
      "          FROM C_CALENDAREVENT_trl" +
      "         WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? ";

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
      "          FROM C_CALENDAREVENT_trl" +
      "         WHERE C_CALENDAREVENT_trl.C_Calendarevent_Trl_ID = ? ";

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
