//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class LocatorData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocatorData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String mLocatorId;
  public String name;
  public String value;
  public String valueHidden;
  public String priorityno;
  public String isdefault;
  public String aisle;
  public String bin;
  public String nivel;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rn1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("value_hidden") || fieldName.equals("valueHidden"))
      return valueHidden;
    else if (fieldName.equalsIgnoreCase("priorityno"))
      return priorityno;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("aisle"))
      return aisle;
    else if (fieldName.equalsIgnoreCase("bin"))
      return bin;
    else if (fieldName.equalsIgnoreCase("nivel"))
      return nivel;
    else if (fieldName.equalsIgnoreCase("rowkey"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static LocatorData[] select(ConnectionProvider connectionProvider, String rownum, String adLanguage, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adLanguage, adUserClient, adUserOrg, key, warehouse, aisle, bin, level, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static LocatorData[] select(ConnectionProvider connectionProvider, String rownum, String adLanguage, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (      				   " +
      "        SELECT m.M_LOCATOR_ID, mw.NAME, m.VALUE, REPLACE(AD_COLUMN_IDENTIFIER(TO_CHAR('M_LOCATOR'), TO_CHAR(m.M_LOCATOR_ID), TO_CHAR(?)), '''', chr(92)||'''') AS VALUE_HIDDEN, m.PRIORITYNO, " +
      "        m.ISDEFAULT, m.X AS aisle, m.Y AS bin, m.Z AS nivel," +
      "        m.M_LOCATOR_ID || '#' || m.value  AS rowKey" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(m.VALUE) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((aisle==null || aisle.equals("") || aisle.equals("%") )?"":"  AND UPPER(m.X) LIKE UPPER(?)  ");
    strSql = strSql + ((bin==null || bin.equals("") || bin.equals("%") )?"":"  AND UPPER(m.Y) LIKE UPPER(?)  ");
    strSql = strSql + ((level==null || level.equals("") || level.equals("%") )?"":"  AND UPPER(m.Z) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (rownum != null && !(rownum.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (aisle != null && !(aisle.equals("")) && !(aisle.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aisle);
      }
      if (bin != null && !(bin.equals("")) && !(bin.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bin);
      }
      if (level != null && !(level.equals("")) && !(level.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        LocatorData objectLocatorData = new LocatorData();
        objectLocatorData.rn1 = UtilSql.getValue(result, "rn1");
        objectLocatorData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectLocatorData.name = UtilSql.getValue(result, "name");
        objectLocatorData.value = UtilSql.getValue(result, "value");
        objectLocatorData.valueHidden = UtilSql.getValue(result, "value_hidden");
        objectLocatorData.priorityno = UtilSql.getValue(result, "priorityno");
        objectLocatorData.isdefault = UtilSql.getValue(result, "isdefault");
        objectLocatorData.aisle = UtilSql.getValue(result, "aisle");
        objectLocatorData.bin = UtilSql.getValue(result, "bin");
        objectLocatorData.nivel = UtilSql.getValue(result, "nivel");
        objectLocatorData.rowkey = UtilSql.getValue(result, "rowkey");
        objectLocatorData.position = Long.toString(countRecord);
        objectLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorData);
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
    LocatorData objectLocatorData[] = new LocatorData[vector.size()];
    vector.copyInto(objectLocatorData);
    return(objectLocatorData);
  }

  public static LocatorData[] set()    throws ServletException {
    LocatorData objectLocatorData[] = new LocatorData[1];
    objectLocatorData[0] = new LocatorData();
    objectLocatorData[0].rn1 = "";
    objectLocatorData[0].mLocatorId = "";
    objectLocatorData[0].name = "";
    objectLocatorData[0].value = "";
    objectLocatorData[0].valueHidden = "";
    objectLocatorData[0].priorityno = "";
    objectLocatorData[0].isdefault = "";
    objectLocatorData[0].aisle = "";
    objectLocatorData[0].bin = "";
    objectLocatorData[0].nivel = "";
    objectLocatorData[0].rowkey = "";
    return objectLocatorData;
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( SELECT 1" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(m.VALUE) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((aisle==null || aisle.equals("") || aisle.equals("%") )?"":"  AND UPPER(m.X) LIKE UPPER(?)  ");
    strSql = strSql + ((bin==null || bin.equals("") || bin.equals("%") )?"":"  AND UPPER(m.Y) LIKE UPPER(?)  ");
    strSql = strSql + ((level==null || level.equals("") || level.equals("%") )?"":"  AND UPPER(m.Z) LIKE UPPER(?)  ");
    strSql = strSql + 
      "		AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "		) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "		) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (aisle != null && !(aisle.equals("")) && !(aisle.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aisle);
      }
      if (bin != null && !(bin.equals("")) && !(bin.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bin);
      }
      if (level != null && !(level.equals("")) && !(level.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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

  public static LocatorData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String warehouse, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, warehouse, key, 0, 0);
  }

  public static LocatorData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String warehouse, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m.M_LOCATOR_ID, mw.NAME, m.VALUE, m.PRIORITYNO, m.ISDEFAULT, m.X AS aisle, m.Y AS bin, m.Z AS nivel" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        AND UPPER(m.VALUE) LIKE UPPER(?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        LocatorData objectLocatorData = new LocatorData();
        objectLocatorData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectLocatorData.name = UtilSql.getValue(result, "name");
        objectLocatorData.value = UtilSql.getValue(result, "value");
        objectLocatorData.priorityno = UtilSql.getValue(result, "priorityno");
        objectLocatorData.isdefault = UtilSql.getValue(result, "isdefault");
        objectLocatorData.aisle = UtilSql.getValue(result, "aisle");
        objectLocatorData.bin = UtilSql.getValue(result, "bin");
        objectLocatorData.nivel = UtilSql.getValue(result, "nivel");
        objectLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorData);
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
    LocatorData objectLocatorData[] = new LocatorData[vector.size()];
    vector.copyInto(objectLocatorData);
    return(objectLocatorData);
  }

  public static String selectname(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mw.name" +
      "        FROM M_WAREHOUSE mw" +
      "        WHERE mw.M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
}
