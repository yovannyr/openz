//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PriceList;

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
class PriceListVersionData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceListVersionData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String name;
  public String description;
  public String validfrom;
  public String isactive;
  public String mPricelistVersionId;
  public String mDiscountschemaId;
  public String mPricelistVersionBaseId;
  public String proccreate;
  public String mPricelistVersionGenerate;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("m_discountschema_id") || fieldName.equals("mDiscountschemaId"))
      return mDiscountschemaId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_base_id") || fieldName.equals("mPricelistVersionBaseId"))
      return mPricelistVersionBaseId;
    else if (fieldName.equalsIgnoreCase("proccreate"))
      return proccreate;
    else if (fieldName.equalsIgnoreCase("m_pricelist_version_generate") || fieldName.equals("mPricelistVersionGenerate"))
      return mPricelistVersionGenerate;
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
  public static PriceListVersionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mPricelistId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mPricelistId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PriceListVersionData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mPricelistId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_PriceList_Version.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_PriceList_Version.CreatedBy) as CreatedByR, " +
      "        to_char(M_PriceList_Version.Updated, ?) as updated, " +
      "        to_char(M_PriceList_Version.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_PriceList_Version.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_PriceList_Version.UpdatedBy) as UpdatedByR," +
      "        M_PriceList_Version.AD_Client_ID, " +
      "(CASE WHEN M_PriceList_Version.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_PriceList_Version.AD_Org_ID, " +
      "(CASE WHEN M_PriceList_Version.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_PriceList_Version.M_PriceList_ID, " +
      "(CASE WHEN M_PriceList_Version.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "M_PriceList_Version.Name, " +
      "M_PriceList_Version.Description, " +
      "M_PriceList_Version.ValidFrom, " +
      "COALESCE(M_PriceList_Version.IsActive, 'N') AS IsActive, " +
      "M_PriceList_Version.M_PriceList_Version_ID, " +
      "M_PriceList_Version.M_DiscountSchema_ID, " +
      "M_PriceList_Version.M_Pricelist_Version_Base_ID, " +
      "M_PriceList_Version.ProcCreate, " +
      "M_PriceList_Version.M_Pricelist_Version_Generate, " +
      "        ? AS LANGUAGE " +
      "        FROM M_PriceList_Version left join (select AD_Client_ID, Name from AD_Client) table1 on (M_PriceList_Version.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_PriceList_Version.AD_Org_ID = table2.AD_Org_ID) left join (select M_PriceList_ID, Name from M_PriceList) table3 on (M_PriceList_Version.M_PriceList_ID = table3.M_PriceList_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mPricelistId==null || mPricelistId.equals(""))?"":"  AND M_PriceList_Version.M_PriceList_ID = ?  ");
    strSql = strSql + 
      "        AND M_PriceList_Version.M_PriceList_Version_ID = ? " +
      "        AND M_PriceList_Version.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_PriceList_Version.AD_Org_ID IN (";
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
      if (mPricelistId != null && !(mPricelistId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
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
        PriceListVersionData objectPriceListVersionData = new PriceListVersionData();
        objectPriceListVersionData.created = UtilSql.getValue(result, "created");
        objectPriceListVersionData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPriceListVersionData.updated = UtilSql.getValue(result, "updated");
        objectPriceListVersionData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPriceListVersionData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPriceListVersionData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPriceListVersionData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPriceListVersionData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPriceListVersionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPriceListVersionData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPriceListVersionData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPriceListVersionData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectPriceListVersionData.name = UtilSql.getValue(result, "name");
        objectPriceListVersionData.description = UtilSql.getValue(result, "description");
        objectPriceListVersionData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectPriceListVersionData.isactive = UtilSql.getValue(result, "isactive");
        objectPriceListVersionData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionData.mDiscountschemaId = UtilSql.getValue(result, "m_discountschema_id");
        objectPriceListVersionData.mPricelistVersionBaseId = UtilSql.getValue(result, "m_pricelist_version_base_id");
        objectPriceListVersionData.proccreate = UtilSql.getValue(result, "proccreate");
        objectPriceListVersionData.mPricelistVersionGenerate = UtilSql.getValue(result, "m_pricelist_version_generate");
        objectPriceListVersionData.language = UtilSql.getValue(result, "language");
        objectPriceListVersionData.adUserClient = "";
        objectPriceListVersionData.adOrgClient = "";
        objectPriceListVersionData.createdby = "";
        objectPriceListVersionData.trBgcolor = "";
        objectPriceListVersionData.totalCount = "";
        objectPriceListVersionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionData);
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
    PriceListVersionData objectPriceListVersionData[] = new PriceListVersionData[vector.size()];
    vector.copyInto(objectPriceListVersionData);
    return(objectPriceListVersionData);
  }

/**
Create a registry
 */
  public static PriceListVersionData[] set(String mPricelistId, String isactive, String description, String adOrgId, String mPricelistVersionBaseId, String name, String proccreate, String mPricelistVersionGenerate, String createdby, String createdbyr, String validfrom, String mPricelistVersionId, String updatedby, String updatedbyr, String mDiscountschemaId, String adClientId)    throws ServletException {
    PriceListVersionData objectPriceListVersionData[] = new PriceListVersionData[1];
    objectPriceListVersionData[0] = new PriceListVersionData();
    objectPriceListVersionData[0].created = "";
    objectPriceListVersionData[0].createdbyr = createdbyr;
    objectPriceListVersionData[0].updated = "";
    objectPriceListVersionData[0].updatedTimeStamp = "";
    objectPriceListVersionData[0].updatedby = updatedby;
    objectPriceListVersionData[0].updatedbyr = updatedbyr;
    objectPriceListVersionData[0].adClientId = adClientId;
    objectPriceListVersionData[0].adClientIdr = "";
    objectPriceListVersionData[0].adOrgId = adOrgId;
    objectPriceListVersionData[0].adOrgIdr = "";
    objectPriceListVersionData[0].mPricelistId = mPricelistId;
    objectPriceListVersionData[0].mPricelistIdr = "";
    objectPriceListVersionData[0].name = name;
    objectPriceListVersionData[0].description = description;
    objectPriceListVersionData[0].validfrom = validfrom;
    objectPriceListVersionData[0].isactive = isactive;
    objectPriceListVersionData[0].mPricelistVersionId = mPricelistVersionId;
    objectPriceListVersionData[0].mDiscountschemaId = mDiscountschemaId;
    objectPriceListVersionData[0].mPricelistVersionBaseId = mPricelistVersionBaseId;
    objectPriceListVersionData[0].proccreate = proccreate;
    objectPriceListVersionData[0].mPricelistVersionGenerate = mPricelistVersionGenerate;
    objectPriceListVersionData[0].language = "";
    return objectPriceListVersionData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2995(ConnectionProvider connectionProvider, String m_pricelist_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select substr(name||'-'||to_char(now(),'YYYY-MM-DD'),1,60) as defaultvalue from m_pricelist where m_pricelist_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_pricelist_id);

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
  public static String selectDef2992_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2994_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SELECT M_PriceList_Version.M_PriceList_ID AS NAME" +
      "        FROM M_PriceList_Version" +
      "        WHERE M_PriceList_Version.M_PriceList_Version_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_PriceList left join (select M_PriceList_ID, Name from M_PriceList) table1 on (M_PriceList.M_PriceList_ID = table1.M_PriceList_ID) WHERE M_PriceList.M_PriceList_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_PriceList left join (select M_PriceList_ID, Name from M_PriceList) table1 on (M_PriceList.M_PriceList_ID = table1.M_PriceList_ID) WHERE M_PriceList.M_PriceList_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
      "        UPDATE M_PriceList_Version" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , M_PriceList_ID = (?) , Name = (?) , Description = (?) , ValidFrom = TO_DATE(?) , IsActive = (?) , M_PriceList_Version_ID = (?) , M_DiscountSchema_ID = (?) , M_Pricelist_Version_Base_ID = (?) , ProcCreate = (?) , M_Pricelist_Version_Generate = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_PriceList_Version.M_PriceList_Version_ID = ? " +
      "                 AND M_PriceList_Version.M_PriceList_ID = ? " +
      "        AND M_PriceList_Version.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_PriceList_Version.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mDiscountschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionBaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proccreate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionGenerate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
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
      "        INSERT INTO M_PriceList_Version " +
      "        (AD_Client_ID, AD_Org_ID, M_PriceList_ID, Name, Description, ValidFrom, IsActive, M_PriceList_Version_ID, M_DiscountSchema_ID, M_Pricelist_Version_Base_ID, ProcCreate, M_Pricelist_Version_Generate, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mDiscountschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionBaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proccreate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionGenerate);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mPricelistId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_PriceList_Version" +
      "        WHERE M_PriceList_Version.M_PriceList_Version_ID = ? " +
      "                 AND M_PriceList_Version.M_PriceList_ID = ? " +
      "        AND M_PriceList_Version.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_PriceList_Version.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_PriceList_Version" +
      "        WHERE M_PriceList_Version.M_PriceList_Version_ID = ? " +
      "                 AND M_PriceList_Version.M_PriceList_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
      "          FROM M_PriceList_Version" +
      "         WHERE M_PriceList_Version.M_PriceList_Version_ID = ? ";

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
      "          FROM M_PriceList_Version" +
      "         WHERE M_PriceList_Version.M_PriceList_Version_ID = ? ";

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
