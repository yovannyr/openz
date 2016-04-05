//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Product;

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
class PriceAdjustmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceAdjustmentData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String name;
  public String isactive;
  public String directpurchasecalc;
  public String cUomId;
  public String cUomIdr;
  public String datefrom;
  public String dateto;
  public String qtyFrom;
  public String qtyTo;
  public String priority;
  public String discount;
  public String addamt;
  public String fixed;
  public String issalesoffer;
  public String adOrgId;
  public String bpGroupSelection;
  public String productSelection;
  public String description;
  public String mPricelistId;
  public String bpartnerSelection;
  public String mOfferplistVId;
  public String mProductpriceId;
  public String prodCatSelection;
  public String pricelistSelection;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("directpurchasecalc"))
      return directpurchasecalc;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("qty_from") || fieldName.equals("qtyFrom"))
      return qtyFrom;
    else if (fieldName.equalsIgnoreCase("qty_to") || fieldName.equals("qtyTo"))
      return qtyTo;
    else if (fieldName.equalsIgnoreCase("priority"))
      return priority;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("addamt"))
      return addamt;
    else if (fieldName.equalsIgnoreCase("fixed"))
      return fixed;
    else if (fieldName.equalsIgnoreCase("issalesoffer"))
      return issalesoffer;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("bp_group_selection") || fieldName.equals("bpGroupSelection"))
      return bpGroupSelection;
    else if (fieldName.equalsIgnoreCase("product_selection") || fieldName.equals("productSelection"))
      return productSelection;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("bpartner_selection") || fieldName.equals("bpartnerSelection"))
      return bpartnerSelection;
    else if (fieldName.equalsIgnoreCase("m_offerplist_v_id") || fieldName.equals("mOfferplistVId"))
      return mOfferplistVId;
    else if (fieldName.equalsIgnoreCase("m_productprice_id") || fieldName.equals("mProductpriceId"))
      return mProductpriceId;
    else if (fieldName.equalsIgnoreCase("prod_cat_selection") || fieldName.equals("prodCatSelection"))
      return prodCatSelection;
    else if (fieldName.equalsIgnoreCase("pricelist_selection") || fieldName.equals("pricelistSelection"))
      return pricelistSelection;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static PriceAdjustmentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductpriceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mProductpriceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PriceAdjustmentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductpriceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(m_offerplist_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_offerplist_v.CreatedBy) as CreatedByR, " +
      "        to_char(m_offerplist_v.Updated, ?) as updated, " +
      "        to_char(m_offerplist_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        m_offerplist_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_offerplist_v.UpdatedBy) as UpdatedByR," +
      "        m_offerplist_v.M_Product_ID, " +
      "(CASE WHEN m_offerplist_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "m_offerplist_v.Name, " +
      "COALESCE(m_offerplist_v.Isactive, 'N') AS Isactive, " +
      "COALESCE(m_offerplist_v.Directpurchasecalc, 'N') AS Directpurchasecalc, " +
      "m_offerplist_v.C_Uom_ID, " +
      "(CASE WHEN m_offerplist_v.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "m_offerplist_v.Datefrom, " +
      "m_offerplist_v.Dateto, " +
      "m_offerplist_v.QTY_From, " +
      "m_offerplist_v.QTY_To, " +
      "m_offerplist_v.Priority, " +
      "m_offerplist_v.Discount, " +
      "m_offerplist_v.Addamt, " +
      "m_offerplist_v.Fixed, " +
      "COALESCE(m_offerplist_v.Issalesoffer, 'N') AS Issalesoffer, " +
      "m_offerplist_v.AD_Org_ID, " +
      "m_offerplist_v.BP_Group_Selection, " +
      "m_offerplist_v.Product_Selection, " +
      "m_offerplist_v.Description, " +
      "m_offerplist_v.M_Pricelist_ID, " +
      "m_offerplist_v.Bpartner_Selection, " +
      "m_offerplist_v.M_Offerplist_V_ID, " +
      "m_offerplist_v.M_Productprice_ID, " +
      "m_offerplist_v.Prod_Cat_Selection, " +
      "m_offerplist_v.Pricelist_Selection, " +
      "m_offerplist_v.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM m_offerplist_v left join (select M_Product_ID, Value, Name from M_Product) table1 on (m_offerplist_v.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table2 on (m_offerplist_v.C_Uom_ID = table2.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL2 on (table2.C_UOM_ID = tableTRL2.C_UOM_ID and tableTRL2.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mProductpriceId==null || mProductpriceId.equals(""))?"":"  AND m_offerplist_v.M_Productprice_ID = ?  ");
    strSql = strSql + 
      "        AND m_offerplist_v.M_Offerplist_V_ID = ? " +
      "        AND m_offerplist_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND m_offerplist_v.AD_Org_ID IN (";
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
      if (mProductpriceId != null && !(mProductpriceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);
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
        PriceAdjustmentData objectPriceAdjustmentData = new PriceAdjustmentData();
        objectPriceAdjustmentData.created = UtilSql.getValue(result, "created");
        objectPriceAdjustmentData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPriceAdjustmentData.updated = UtilSql.getValue(result, "updated");
        objectPriceAdjustmentData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPriceAdjustmentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPriceAdjustmentData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPriceAdjustmentData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPriceAdjustmentData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPriceAdjustmentData.name = UtilSql.getValue(result, "name");
        objectPriceAdjustmentData.isactive = UtilSql.getValue(result, "isactive");
        objectPriceAdjustmentData.directpurchasecalc = UtilSql.getValue(result, "directpurchasecalc");
        objectPriceAdjustmentData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectPriceAdjustmentData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectPriceAdjustmentData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectPriceAdjustmentData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectPriceAdjustmentData.qtyFrom = UtilSql.getValue(result, "qty_from");
        objectPriceAdjustmentData.qtyTo = UtilSql.getValue(result, "qty_to");
        objectPriceAdjustmentData.priority = UtilSql.getValue(result, "priority");
        objectPriceAdjustmentData.discount = UtilSql.getValue(result, "discount");
        objectPriceAdjustmentData.addamt = UtilSql.getValue(result, "addamt");
        objectPriceAdjustmentData.fixed = UtilSql.getValue(result, "fixed");
        objectPriceAdjustmentData.issalesoffer = UtilSql.getValue(result, "issalesoffer");
        objectPriceAdjustmentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPriceAdjustmentData.bpGroupSelection = UtilSql.getValue(result, "bp_group_selection");
        objectPriceAdjustmentData.productSelection = UtilSql.getValue(result, "product_selection");
        objectPriceAdjustmentData.description = UtilSql.getValue(result, "description");
        objectPriceAdjustmentData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPriceAdjustmentData.bpartnerSelection = UtilSql.getValue(result, "bpartner_selection");
        objectPriceAdjustmentData.mOfferplistVId = UtilSql.getValue(result, "m_offerplist_v_id");
        objectPriceAdjustmentData.mProductpriceId = UtilSql.getValue(result, "m_productprice_id");
        objectPriceAdjustmentData.prodCatSelection = UtilSql.getValue(result, "prod_cat_selection");
        objectPriceAdjustmentData.pricelistSelection = UtilSql.getValue(result, "pricelist_selection");
        objectPriceAdjustmentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPriceAdjustmentData.language = UtilSql.getValue(result, "language");
        objectPriceAdjustmentData.adUserClient = "";
        objectPriceAdjustmentData.adOrgClient = "";
        objectPriceAdjustmentData.createdby = "";
        objectPriceAdjustmentData.trBgcolor = "";
        objectPriceAdjustmentData.totalCount = "";
        objectPriceAdjustmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceAdjustmentData);
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
    PriceAdjustmentData objectPriceAdjustmentData[] = new PriceAdjustmentData[vector.size()];
    vector.copyInto(objectPriceAdjustmentData);
    return(objectPriceAdjustmentData);
  }

/**
Create a registry
 */
  public static PriceAdjustmentData[] set(String mProductpriceId, String addamt, String directpurchasecalc, String qtyTo, String mOfferplistVId, String isactive, String priority, String description, String dateto, String qtyFrom, String mPricelistId, String productSelection, String issalesoffer, String prodCatSelection, String pricelistSelection, String name, String mProductId, String mProductIdr, String discount, String bpartnerSelection, String adOrgId, String updatedby, String updatedbyr, String createdby, String createdbyr, String datefrom, String bpGroupSelection, String fixed, String cUomId, String adClientId)    throws ServletException {
    PriceAdjustmentData objectPriceAdjustmentData[] = new PriceAdjustmentData[1];
    objectPriceAdjustmentData[0] = new PriceAdjustmentData();
    objectPriceAdjustmentData[0].created = "";
    objectPriceAdjustmentData[0].createdbyr = createdbyr;
    objectPriceAdjustmentData[0].updated = "";
    objectPriceAdjustmentData[0].updatedTimeStamp = "";
    objectPriceAdjustmentData[0].updatedby = updatedby;
    objectPriceAdjustmentData[0].updatedbyr = updatedbyr;
    objectPriceAdjustmentData[0].mProductId = mProductId;
    objectPriceAdjustmentData[0].mProductIdr = mProductIdr;
    objectPriceAdjustmentData[0].name = name;
    objectPriceAdjustmentData[0].isactive = isactive;
    objectPriceAdjustmentData[0].directpurchasecalc = directpurchasecalc;
    objectPriceAdjustmentData[0].cUomId = cUomId;
    objectPriceAdjustmentData[0].cUomIdr = "";
    objectPriceAdjustmentData[0].datefrom = datefrom;
    objectPriceAdjustmentData[0].dateto = dateto;
    objectPriceAdjustmentData[0].qtyFrom = qtyFrom;
    objectPriceAdjustmentData[0].qtyTo = qtyTo;
    objectPriceAdjustmentData[0].priority = priority;
    objectPriceAdjustmentData[0].discount = discount;
    objectPriceAdjustmentData[0].addamt = addamt;
    objectPriceAdjustmentData[0].fixed = fixed;
    objectPriceAdjustmentData[0].issalesoffer = issalesoffer;
    objectPriceAdjustmentData[0].adOrgId = adOrgId;
    objectPriceAdjustmentData[0].bpGroupSelection = bpGroupSelection;
    objectPriceAdjustmentData[0].productSelection = productSelection;
    objectPriceAdjustmentData[0].description = description;
    objectPriceAdjustmentData[0].mPricelistId = mPricelistId;
    objectPriceAdjustmentData[0].bpartnerSelection = bpartnerSelection;
    objectPriceAdjustmentData[0].mOfferplistVId = mOfferplistVId;
    objectPriceAdjustmentData[0].mProductpriceId = mProductpriceId;
    objectPriceAdjustmentData[0].prodCatSelection = prodCatSelection;
    objectPriceAdjustmentData[0].pricelistSelection = pricelistSelection;
    objectPriceAdjustmentData[0].adClientId = adClientId;
    objectPriceAdjustmentData[0].language = "";
    return objectPriceAdjustmentData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1961B4AE66DB41DC9AB135ADE09B3410_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDefEA017F229520407281E0C871872E2C25_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef37E78F935C094F898DE19D100EA855C7_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT m_offerplist_v.M_Productprice_ID AS NAME" +
      "        FROM m_offerplist_v" +
      "        WHERE m_offerplist_v.M_Offerplist_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mProductpriceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))) AS NAME FROM M_ProductPrice left join (select M_Productprice_ID, M_Product_ID, M_PriceList_Version_ID from M_Productprice) table1 on (M_ProductPrice.M_Productprice_ID = table1.M_Productprice_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_PriceList_Version_ID, Name from M_PriceList_Version) table3 on (table1.M_PriceList_Version_ID = table3.M_PriceList_Version_ID) WHERE M_ProductPrice.M_Productprice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mProductpriceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))) AS NAME FROM M_ProductPrice left join (select M_Productprice_ID, M_Product_ID, M_PriceList_Version_ID from M_Productprice) table1 on (M_ProductPrice.M_Productprice_ID = table1.M_Productprice_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_PriceList_Version_ID, Name from M_PriceList_Version) table3 on (table1.M_PriceList_Version_ID = table3.M_PriceList_Version_ID) WHERE M_ProductPrice.M_Productprice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);

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
      "        UPDATE m_offerplist_v" +
      "        SET M_Product_ID = (?) , Name = (?) , Isactive = (?) , Directpurchasecalc = (?) , C_Uom_ID = (?) , Datefrom = TO_DATE(?) , Dateto = TO_DATE(?) , QTY_From = TO_NUMBER(?) , QTY_To = TO_NUMBER(?) , Priority = TO_NUMBER(?) , Discount = TO_NUMBER(?) , Addamt = TO_NUMBER(?) , Fixed = TO_NUMBER(?) , Issalesoffer = (?) , AD_Org_ID = (?) , BP_Group_Selection = (?) , Product_Selection = (?) , Description = (?) , M_Pricelist_ID = (?) , Bpartner_Selection = (?) , M_Offerplist_V_ID = (?) , M_Productprice_ID = (?) , Prod_Cat_Selection = (?) , Pricelist_Selection = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE m_offerplist_v.M_Offerplist_V_ID = ? " +
      "                 AND m_offerplist_v.M_Productprice_ID = ? " +
      "        AND m_offerplist_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_offerplist_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directpurchasecalc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpGroupSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferplistVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodCatSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferplistVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);
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
      "        INSERT INTO m_offerplist_v " +
      "        (M_Product_ID, Name, Isactive, Directpurchasecalc, C_Uom_ID, Datefrom, Dateto, QTY_From, QTY_To, Priority, Discount, Addamt, Fixed, Issalesoffer, AD_Org_ID, BP_Group_Selection, Product_Selection, Description, M_Pricelist_ID, Bpartner_Selection, M_Offerplist_V_ID, M_Productprice_ID, Prod_Cat_Selection, Pricelist_Selection, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directpurchasecalc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpGroupSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferplistVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodCatSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mProductpriceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_offerplist_v" +
      "        WHERE m_offerplist_v.M_Offerplist_V_ID = ? " +
      "                 AND m_offerplist_v.M_Productprice_ID = ? " +
      "        AND m_offerplist_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_offerplist_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mProductpriceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_offerplist_v" +
      "        WHERE m_offerplist_v.M_Offerplist_V_ID = ? " +
      "                 AND m_offerplist_v.M_Productprice_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductpriceId);

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
      "          FROM m_offerplist_v" +
      "         WHERE m_offerplist_v.M_Offerplist_V_ID = ? ";

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
      "          FROM m_offerplist_v" +
      "         WHERE m_offerplist_v.M_Offerplist_V_ID = ? ";

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
