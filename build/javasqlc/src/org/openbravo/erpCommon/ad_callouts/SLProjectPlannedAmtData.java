//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SLProjectPlannedAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLProjectPlannedAmtData.class);
  private String InitRecordNumber="0";
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String mPricelistId;
  public String updatedby;
  public String updated;
  public String cProjectlineId;
  public String plannedamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("enforcepricelimit"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("c_projectline_id") || fieldName.equals("cProjectlineId"))
      return cProjectlineId;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLProjectPlannedAmtData[] select(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    return select(connectionProvider, cProjectId, 0, 0);
  }

  public static SLProjectPlannedAmtData[] select(ConnectionProvider connectionProvider, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision, M_PriceList.EnforcePriceLimit, M_PriceList.M_PriceList_ID, C_Projectline.updatedby, C_Projectline.Updated, C_Projectline.C_Projectline_ID, C_Projectline.plannedAmt" +
      "      FROM C_Projectline, C_Project, M_PriceList, C_Currency " +
      "      WHERE C_Projectline.C_Project_ID = C_Project.C_Project_ID" +
      "      AND C_Project.M_PriceList_ID = M_PriceList.M_PriceList_ID" +
      "      AND M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND C_Projectline.C_Projectline_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
        SLProjectPlannedAmtData objectSLProjectPlannedAmtData = new SLProjectPlannedAmtData();
        objectSLProjectPlannedAmtData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectSLProjectPlannedAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLProjectPlannedAmtData.enforcepricelimit = UtilSql.getValue(result, "enforcepricelimit");
        objectSLProjectPlannedAmtData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSLProjectPlannedAmtData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSLProjectPlannedAmtData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectSLProjectPlannedAmtData.cProjectlineId = UtilSql.getValue(result, "c_projectline_id");
        objectSLProjectPlannedAmtData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectSLProjectPlannedAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLProjectPlannedAmtData);
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
    SLProjectPlannedAmtData objectSLProjectPlannedAmtData[] = new SLProjectPlannedAmtData[vector.size()];
    vector.copyInto(objectSLProjectPlannedAmtData);
    return(objectSLProjectPlannedAmtData);
  }

  public static String selectPriceLimit(ConnectionProvider connectionProvider, String mPricelistVersionId, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PRICELIMIT " +
      "      FROM M_PRODUCTPRICE " +
      "      WHERE M_PRICELIST_VERSION_ID = ? " +
      "      AND M_PRODUCT_ID=?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pricelimit");
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

  public static int update(ConnectionProvider connectionProvider, String plannedAmt, String updatedby, String cProjectlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PROJECTLINE SET " +
      "        PLANNEDAMT = TO_NUMBER(?), UPDATED = now(), UPDATEDBY = ?" +
      "        WHERE C_PROJECTLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectlineId);

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

  public static String selectPrecision(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PRICEPRECISION " +
      "        FROM C_CURRENCY C" +
      "        WHERE C.C_CURRENCY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "priceprecision");
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
