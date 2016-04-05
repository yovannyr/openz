//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.ecommerce.WebshopCategories;

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
class ProductsC3F81961A2454E19B8342FEDA5A1ECDAData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductsC3F81961A2454E19B8342FEDA5A1ECDAData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zseProductShopId;
  public String zseProductShopIdr;
  public String zseWebshopcategoryId;
  public String zseWebshopcategoryIdr;
  public String externalid;
  public String adOrgId;
  public String adClientId;
  public String isactive;
  public String zseWebshopcategoryProductId;
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
    else if (fieldName.equalsIgnoreCase("zse_product_shop_id") || fieldName.equals("zseProductShopId"))
      return zseProductShopId;
    else if (fieldName.equalsIgnoreCase("zse_product_shop_idr") || fieldName.equals("zseProductShopIdr"))
      return zseProductShopIdr;
    else if (fieldName.equalsIgnoreCase("zse_webshopcategory_id") || fieldName.equals("zseWebshopcategoryId"))
      return zseWebshopcategoryId;
    else if (fieldName.equalsIgnoreCase("zse_webshopcategory_idr") || fieldName.equals("zseWebshopcategoryIdr"))
      return zseWebshopcategoryIdr;
    else if (fieldName.equalsIgnoreCase("externalid"))
      return externalid;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zse_webshopcategory_product_id") || fieldName.equals("zseWebshopcategoryProductId"))
      return zseWebshopcategoryProductId;
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
  public static ProductsC3F81961A2454E19B8342FEDA5A1ECDAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zseWebshopcategoryId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zseWebshopcategoryId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductsC3F81961A2454E19B8342FEDA5A1ECDAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zseWebshopcategoryId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zse_webshopcategory_product.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_webshopcategory_product.CreatedBy) as CreatedByR, " +
      "        to_char(zse_webshopcategory_product.Updated, ?) as updated, " +
      "        to_char(zse_webshopcategory_product.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zse_webshopcategory_product.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zse_webshopcategory_product.UpdatedBy) as UpdatedByR," +
      "        zse_webshopcategory_product.ZSE_Product_Shop_ID, " +
      "(CASE WHEN zse_webshopcategory_product.ZSE_Product_Shop_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS ZSE_Product_Shop_IDR, " +
      "zse_webshopcategory_product.ZSE_Webshopcategory_ID, " +
      "(CASE WHEN zse_webshopcategory_product.ZSE_Webshopcategory_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Title IS NULL THEN TO_CHAR(table4.Title) ELSE TO_CHAR(tableTRL5.Title) END)), ''))),'') ) END) AS ZSE_Webshopcategory_IDR, " +
      "zse_webshopcategory_product.Externalid, " +
      "zse_webshopcategory_product.AD_Org_ID, " +
      "zse_webshopcategory_product.AD_Client_ID, " +
      "COALESCE(zse_webshopcategory_product.Isactive, 'N') AS Isactive, " +
      "zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zse_webshopcategory_product left join (select ZSE_Product_Shop_ID, ZSE_Shop_ID, M_Product_ID from ZSE_Product_Shop) table1 on (zse_webshopcategory_product.ZSE_Product_Shop_ID = table1.ZSE_Product_Shop_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table2 on (table1.ZSE_Shop_ID = table2.ZSE_Shop_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select ZSE_Webshopcategory_ID, ZSE_Shop_ID, Title from ZSE_Webshopcategory) table4 on (zse_webshopcategory_product.ZSE_Webshopcategory_ID = table4.ZSE_Webshopcategory_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table5 on (table4.ZSE_Shop_ID = table5.ZSE_Shop_ID) left join (select ZSE_Webshopcategory_ID,AD_Language, Title from zse_webshopcategory_TRL) tableTRL5 on (table4.ZSE_Webshopcategory_ID = tableTRL5.ZSE_Webshopcategory_ID and tableTRL5.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zseWebshopcategoryId==null || zseWebshopcategoryId.equals(""))?"":"  AND zse_webshopcategory_product.ZSE_Webshopcategory_ID = ?  ");
    strSql = strSql + 
      "        AND zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? " +
      "        AND zse_webshopcategory_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zse_webshopcategory_product.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (zseWebshopcategoryId != null && !(zseWebshopcategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);
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
        ProductsC3F81961A2454E19B8342FEDA5A1ECDAData objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData = new ProductsC3F81961A2454E19B8342FEDA5A1ECDAData();
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.created = UtilSql.getValue(result, "created");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.updated = UtilSql.getValue(result, "updated");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.zseProductShopId = UtilSql.getValue(result, "zse_product_shop_id");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.zseProductShopIdr = UtilSql.getValue(result, "zse_product_shop_idr");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.zseWebshopcategoryId = UtilSql.getValue(result, "zse_webshopcategory_id");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.zseWebshopcategoryIdr = UtilSql.getValue(result, "zse_webshopcategory_idr");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.externalid = UtilSql.getValue(result, "externalid");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.isactive = UtilSql.getValue(result, "isactive");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.zseWebshopcategoryProductId = UtilSql.getValue(result, "zse_webshopcategory_product_id");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.language = UtilSql.getValue(result, "language");
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.adUserClient = "";
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.adOrgClient = "";
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.createdby = "";
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.trBgcolor = "";
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.totalCount = "";
        objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData);
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
    ProductsC3F81961A2454E19B8342FEDA5A1ECDAData objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[] = new ProductsC3F81961A2454E19B8342FEDA5A1ECDAData[vector.size()];
    vector.copyInto(objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData);
    return(objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData);
  }

/**
Create a registry
 */
  public static ProductsC3F81961A2454E19B8342FEDA5A1ECDAData[] set(String zseWebshopcategoryId, String adOrgId, String adClientId, String createdby, String createdbyr, String zseProductShopId, String isactive, String updatedby, String updatedbyr, String zseWebshopcategoryProductId, String externalid)    throws ServletException {
    ProductsC3F81961A2454E19B8342FEDA5A1ECDAData objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[] = new ProductsC3F81961A2454E19B8342FEDA5A1ECDAData[1];
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0] = new ProductsC3F81961A2454E19B8342FEDA5A1ECDAData();
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].created = "";
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].createdbyr = createdbyr;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].updated = "";
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].updatedTimeStamp = "";
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].updatedby = updatedby;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].updatedbyr = updatedbyr;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].zseProductShopId = zseProductShopId;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].zseProductShopIdr = "";
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].zseWebshopcategoryId = zseWebshopcategoryId;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].zseWebshopcategoryIdr = "";
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].externalid = externalid;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].adOrgId = adOrgId;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].adClientId = adClientId;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].isactive = isactive;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].zseWebshopcategoryProductId = zseWebshopcategoryProductId;
    objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData[0].language = "";
    return objectProductsC3F81961A2454E19B8342FEDA5A1ECDAData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA78DFB3EF3D14B24A871E2FEFA2C4D56_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefD41058629D084325922E6D35E07F6A70_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zse_webshopcategory_product.ZSE_Webshopcategory_ID AS NAME" +
      "        FROM zse_webshopcategory_product" +
      "        WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zseWebshopcategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Title IS NULL THEN TO_CHAR(table1.Title) ELSE TO_CHAR(tableTRL2.Title) END)), ''))) AS NAME FROM zse_webshopcategory left join (select ZSE_Webshopcategory_ID, ZSE_Shop_ID, Title from ZSE_Webshopcategory) table1 on (zse_webshopcategory.ZSE_Webshopcategory_ID = table1.ZSE_Webshopcategory_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table2 on (table1.ZSE_Shop_ID = table2.ZSE_Shop_ID) left join (select ZSE_Webshopcategory_ID,AD_Language, Title from zse_webshopcategory_TRL) tableTRL2 on (table1.ZSE_Webshopcategory_ID = tableTRL2.ZSE_Webshopcategory_ID and tableTRL2.AD_Language = ?)  WHERE zse_webshopcategory.ZSE_Webshopcategory_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zseWebshopcategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Title IS NULL THEN TO_CHAR(table1.Title) ELSE TO_CHAR(tableTRL2.Title) END)), ''))) AS NAME FROM zse_webshopcategory left join (select ZSE_Webshopcategory_ID, ZSE_Shop_ID, Title from ZSE_Webshopcategory) table1 on (zse_webshopcategory.ZSE_Webshopcategory_ID = table1.ZSE_Webshopcategory_ID) left join (select ZSE_Shop_ID, Value from ZSE_Shop) table2 on (table1.ZSE_Shop_ID = table2.ZSE_Shop_ID) left join (select ZSE_Webshopcategory_ID,AD_Language, Title from zse_webshopcategory_TRL) tableTRL2 on (table1.ZSE_Webshopcategory_ID = tableTRL2.ZSE_Webshopcategory_ID and tableTRL2.AD_Language = ?)  WHERE zse_webshopcategory.ZSE_Webshopcategory_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);

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
      "        UPDATE zse_webshopcategory_product" +
      "        SET ZSE_Product_Shop_ID = (?) , ZSE_Webshopcategory_ID = (?) , Externalid = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Isactive = (?) , ZSE_Webshopcategory_Product_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? " +
      "                 AND zse_webshopcategory_product.ZSE_Webshopcategory_ID = ? " +
      "        AND zse_webshopcategory_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_webshopcategory_product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseProductShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);
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
      "        INSERT INTO zse_webshopcategory_product " +
      "        (ZSE_Product_Shop_ID, ZSE_Webshopcategory_ID, Externalid, AD_Org_ID, AD_Client_ID, Isactive, ZSE_Webshopcategory_Product_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseProductShopId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryProductId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zseWebshopcategoryId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_webshopcategory_product" +
      "        WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? " +
      "                 AND zse_webshopcategory_product.ZSE_Webshopcategory_ID = ? " +
      "        AND zse_webshopcategory_product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zse_webshopcategory_product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zseWebshopcategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zse_webshopcategory_product" +
      "        WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? " +
      "                 AND zse_webshopcategory_product.ZSE_Webshopcategory_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zseWebshopcategoryId);

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
      "          FROM zse_webshopcategory_product" +
      "         WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? ";

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
      "          FROM zse_webshopcategory_product" +
      "         WHERE zse_webshopcategory_product.ZSE_Webshopcategory_Product_ID = ? ";

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
