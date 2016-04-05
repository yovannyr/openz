//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;

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
class MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String mProductId;
  public String mProductIdr;
  public String movementqty;
  public String quantity;
  public String movementdate;
  public String description;
  public String mLocatorId;
  public String mLocatorIdr;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
  public String zspmMaterialmovementsViewId;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
    else if (fieldName.equalsIgnoreCase("zspm_materialmovements_view_id") || fieldName.equals("zspmMaterialmovementsViewId"))
      return zspmMaterialmovementsViewId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_materialmovements_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_materialmovements_view.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_materialmovements_view.Updated, ?) as updated, " +
      "        to_char(zspm_materialmovements_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_materialmovements_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_materialmovements_view.UpdatedBy) as UpdatedByR," +
      "        zspm_materialmovements_view.Zssm_Workstep_V_ID, " +
      "(CASE WHEN zspm_materialmovements_view.Zssm_Workstep_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'') ) END) AS Zssm_Workstep_V_IDR, " +
      "zspm_materialmovements_view.M_Product_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zspm_materialmovements_view.Movementqty, " +
      "zspm_materialmovements_view.Quantity, " +
      "zspm_materialmovements_view.Movementdate, " +
      "zspm_materialmovements_view.Description, " +
      "zspm_materialmovements_view.M_Locator_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "zspm_materialmovements_view.M_Internal_Consumption_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "zspm_materialmovements_view.Zspm_Materialmovements_View_ID, " +
      "zspm_materialmovements_view.AD_Client_ID, " +
      "zspm_materialmovements_view.AD_Org_ID, " +
      "COALESCE(zspm_materialmovements_view.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_materialmovements_view left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zspm_materialmovements_view.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (zspm_materialmovements_view.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table3 on (zspm_materialmovements_view.M_Locator_ID = table3.M_Locator_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table4 on (zspm_materialmovements_view.M_Internal_Consumption_ID = table4.M_Internal_Consumption_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepVId==null || zssmWorkstepVId.equals(""))?"":"  AND zspm_materialmovements_view.Zssm_Workstep_V_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_materialmovements_view.AD_Org_ID IN (";
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
      if (zssmWorkstepVId != null && !(zssmWorkstepVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
        MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data();
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.created = UtilSql.getValue(result, "created");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.updated = UtilSql.getValue(result, "updated");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.movementqty = UtilSql.getValue(result, "movementqty");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.quantity = UtilSql.getValue(result, "quantity");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.description = UtilSql.getValue(result, "description");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.zspmMaterialmovementsViewId = UtilSql.getValue(result, "zspm_materialmovements_view_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.language = UtilSql.getValue(result, "language");
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.adUserClient = "";
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.adOrgClient = "";
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.createdby = "";
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.trBgcolor = "";
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.totalCount = "";
        objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data);
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
    MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[vector.size()];
    vector.copyInto(objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data);
    return(objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data);
  }

/**
Create a registry
 */
  public static MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] set(String zssmWorkstepVId, String createdby, String createdbyr, String adClientId, String adOrgId, String mLocatorId, String mLocatorIdr, String movementdate, String mInternalConsumptionId, String mProductId, String mProductIdr, String updatedby, String updatedbyr, String movementqty, String isactive, String description, String quantity, String zspmMaterialmovementsViewId)    throws ServletException {
    MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[1];
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0] = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data();
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].created = "";
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].createdbyr = createdbyr;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].updated = "";
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].updatedTimeStamp = "";
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].updatedby = updatedby;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].updatedbyr = updatedbyr;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].zssmWorkstepVIdr = "";
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mProductId = mProductId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mProductIdr = mProductIdr;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].movementqty = movementqty;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].quantity = quantity;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].movementdate = movementdate;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].description = description;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mLocatorId = mLocatorId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mLocatorIdr = mLocatorIdr;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mInternalConsumptionId = mInternalConsumptionId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].mInternalConsumptionIdr = "";
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].zspmMaterialmovementsViewId = zspmMaterialmovementsViewId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].adClientId = adClientId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].adOrgId = adOrgId;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].isactive = isactive;
    objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0].language = "";
    return objectMaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8B6E18287CAD4A7C99906D40E34EB8FF_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefEC9210DF81754D308A9EC6A5DF6A6FFC_1(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDef48D06B95772A4CF7AE85F32AEED21537_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefD3B1A3C6F2514E9D80B290D4C2E87865_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zspm_materialmovements_view.Zssm_Workstep_V_ID AS NAME" +
      "        FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select Zssm_Workstep_V_ID, Value, Name, Zssm_Prj_Name, SeqNo from Zssm_Workstep_V) table1 on (zssm_workstep_v.Zssm_Workstep_V_ID = table1.Zssm_Workstep_V_ID) WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
      "        UPDATE zspm_materialmovements_view" +
      "        SET Zssm_Workstep_V_ID = (?) , M_Product_ID = (?) , Movementqty = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Movementdate = TO_DATE(?) , Description = (?) , M_Locator_ID = (?) , M_Internal_Consumption_ID = (?) , Zspm_Materialmovements_View_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.Zssm_Workstep_V_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_materialmovements_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
      "        INSERT INTO zspm_materialmovements_view " +
      "        (Zssm_Workstep_V_ID, M_Product_ID, Movementqty, Quantity, Movementdate, Description, M_Locator_ID, M_Internal_Consumption_ID, Zspm_Materialmovements_View_ID, AD_Client_ID, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.Zssm_Workstep_V_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_materialmovements_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.Zssm_Workstep_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
      "          FROM zspm_materialmovements_view" +
      "         WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? ";

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
      "          FROM zspm_materialmovements_view" +
      "         WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? ";

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
