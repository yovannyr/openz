//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountTree;

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
  public String cElementvalueTrlId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cElementvalueId;
  public String cElementvalueIdr;
  public String adLanguage;
  public String adLanguager;
  public String isactive;
  public String name;
  public String description;
  public String istranslated;
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
    else if (fieldName.equalsIgnoreCase("c_elementvalue_trl_id") || fieldName.equals("cElementvalueTrlId"))
      return cElementvalueTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_idr") || fieldName.equals("cElementvalueIdr"))
      return cElementvalueIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
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
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementvalueId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cElementvalueId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementvalueId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ElementValue_Trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ElementValue_Trl.CreatedBy) as CreatedByR, " +
      "        to_char(C_ElementValue_Trl.Updated, ?) as updated, " +
      "        to_char(C_ElementValue_Trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ElementValue_Trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ElementValue_Trl.UpdatedBy) as UpdatedByR," +
      "        C_ElementValue_Trl.C_ElementValue_Trl_ID, " +
      "C_ElementValue_Trl.AD_Client_ID, " +
      "(CASE WHEN C_ElementValue_Trl.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_ElementValue_Trl.AD_Org_ID, " +
      "(CASE WHEN C_ElementValue_Trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_ElementValue_Trl.C_ElementValue_ID, " +
      "(CASE WHEN C_ElementValue_Trl.C_ElementValue_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_ElementValue_IDR, " +
      "C_ElementValue_Trl.AD_Language, " +
      "(CASE WHEN C_ElementValue_Trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "COALESCE(C_ElementValue_Trl.IsActive, 'N') AS IsActive, " +
      "C_ElementValue_Trl.Name, " +
      "C_ElementValue_Trl.Description, " +
      "COALESCE(C_ElementValue_Trl.IsTranslated, 'N') AS IsTranslated, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ElementValue_Trl left join (select AD_Client_ID, Name from AD_Client) table1 on (C_ElementValue_Trl.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_ElementValue_Trl.AD_Org_ID = table2.AD_Org_ID) left join (select C_ElementValue_ID, Value, Name from C_ElementValue) table3 on (C_ElementValue_Trl.C_ElementValue_ID = table3.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL3 on (table3.C_ElementValue_ID = tableTRL3.C_ElementValue_ID and tableTRL3.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table4 on (C_ElementValue_Trl.AD_Language =  table4.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cElementvalueId==null || cElementvalueId.equals(""))?"":"  AND C_ElementValue_Trl.C_ElementValue_ID = ?  ");
    strSql = strSql + 
      "        AND C_ElementValue_Trl.C_ElementValue_Trl_ID = ? " +
      "        AND C_ElementValue_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ElementValue_Trl.AD_Org_ID IN (";
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
      if (cElementvalueId != null && !(cElementvalueId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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
        objectTranslationData.cElementvalueTrlId = UtilSql.getValue(result, "c_elementvalue_trl_id");
        objectTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTranslationData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectTranslationData.cElementvalueIdr = UtilSql.getValue(result, "c_elementvalue_idr");
        objectTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationData.name = UtilSql.getValue(result, "name");
        objectTranslationData.description = UtilSql.getValue(result, "description");
        objectTranslationData.istranslated = UtilSql.getValue(result, "istranslated");
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
  public static TranslationData[] set(String cElementvalueId, String createdby, String createdbyr, String updatedby, String updatedbyr, String cElementvalueTrlId, String isactive, String istranslated, String adLanguage, String adClientId, String name, String description, String adOrgId)    throws ServletException {
    TranslationData objectTranslationData[] = new TranslationData[1];
    objectTranslationData[0] = new TranslationData();
    objectTranslationData[0].created = "";
    objectTranslationData[0].createdbyr = createdbyr;
    objectTranslationData[0].updated = "";
    objectTranslationData[0].updatedTimeStamp = "";
    objectTranslationData[0].updatedby = updatedby;
    objectTranslationData[0].updatedbyr = updatedbyr;
    objectTranslationData[0].cElementvalueTrlId = cElementvalueTrlId;
    objectTranslationData[0].adClientId = adClientId;
    objectTranslationData[0].adClientIdr = "";
    objectTranslationData[0].adOrgId = adOrgId;
    objectTranslationData[0].adOrgIdr = "";
    objectTranslationData[0].cElementvalueId = cElementvalueId;
    objectTranslationData[0].cElementvalueIdr = "";
    objectTranslationData[0].adLanguage = adLanguage;
    objectTranslationData[0].adLanguager = "";
    objectTranslationData[0].isactive = isactive;
    objectTranslationData[0].name = name;
    objectTranslationData[0].description = description;
    objectTranslationData[0].istranslated = istranslated;
    objectTranslationData[0].language = "";
    return objectTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3160_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDef3162_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
      "        SELECT C_ElementValue_Trl.C_ElementValue_ID AS NAME" +
      "        FROM C_ElementValue_Trl" +
      "        WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_ElementValue left join (select C_ElementValue_ID, Value, Name from C_ElementValue) table1 on (C_ElementValue.C_ElementValue_ID = table1.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL1 on (table1.C_ElementValue_ID = tableTRL1.C_ElementValue_ID and tableTRL1.AD_Language = ?)  WHERE C_ElementValue.C_ElementValue_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_ElementValue left join (select C_ElementValue_ID, Value, Name from C_ElementValue) table1 on (C_ElementValue.C_ElementValue_ID = table1.C_ElementValue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL1 on (table1.C_ElementValue_ID = tableTRL1.C_ElementValue_ID and tableTRL1.AD_Language = ?)  WHERE C_ElementValue.C_ElementValue_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
      "        UPDATE C_ElementValue_Trl" +
      "        SET C_ElementValue_Trl_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_ElementValue_ID = (?) , AD_Language = (?) , IsActive = (?) , Name = (?) , Description = (?) , IsTranslated = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ? " +
      "                 AND C_ElementValue_Trl.C_ElementValue_ID = ? " +
      "        AND C_ElementValue_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue_Trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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
      "        INSERT INTO C_ElementValue_Trl " +
      "        (C_ElementValue_Trl_ID, AD_Client_ID, AD_Org_ID, C_ElementValue_ID, AD_Language, IsActive, Name, Description, IsTranslated, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cElementvalueId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ElementValue_Trl" +
      "        WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ? " +
      "                 AND C_ElementValue_Trl.C_ElementValue_ID = ? " +
      "        AND C_ElementValue_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue_Trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ElementValue_Trl" +
      "        WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ? " +
      "                 AND C_ElementValue_Trl.C_ElementValue_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
      "          FROM C_ElementValue_Trl" +
      "         WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ? ";

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
      "          FROM C_ElementValue_Trl" +
      "         WHERE C_ElementValue_Trl.C_ElementValue_Trl_ID = ? ";

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
