//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DefaultOptionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(DefaultOptionsData.class);
  private String InitRecordNumber="0";
  public String defaultAdClientId;
  public String defaultAdOrgId;
  public String defaultAdLanguage;
  public String defaultAdRoleId;
  public String defaultMWarehouseId;
  public String isrtl;
  public String adLanguage;
  public String line;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("default_ad_client_id") || fieldName.equals("defaultAdClientId"))
      return defaultAdClientId;
    else if (fieldName.equalsIgnoreCase("default_ad_org_id") || fieldName.equals("defaultAdOrgId"))
      return defaultAdOrgId;
    else if (fieldName.equalsIgnoreCase("default_ad_language") || fieldName.equals("defaultAdLanguage"))
      return defaultAdLanguage;
    else if (fieldName.equalsIgnoreCase("default_ad_role_id") || fieldName.equals("defaultAdRoleId"))
      return defaultAdRoleId;
    else if (fieldName.equalsIgnoreCase("default_m_warehouse_id") || fieldName.equals("defaultMWarehouseId"))
      return defaultMWarehouseId;
    else if (fieldName.equalsIgnoreCase("isrtl"))
      return isrtl;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DefaultOptionsData[] getDefaultOptions(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    return getDefaultOptions(connectionProvider, aduserid, 0, 0);
  }

  public static DefaultOptionsData[] getDefaultOptions(ConnectionProvider connectionProvider, String aduserid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_CLIENT_ID," +
      "               users.DEFAULT_AD_ORG_ID," +
      "               users.DEFAULT_AD_LANGUAGE," +
      "               users.DEFAULT_AD_ROLE_ID," +
      "               users.DEFAULT_M_WAREHOUSE_ID," +
      "               '' AS ISRTL," +
      "               '' AS AD_LANGUAGE," +
      "               '' AS LINE" +
      "          FROM AD_USER users" +
      "              INNER JOIN AD_CLIENT client ON users.DEFAULT_AD_CLIENT_ID = client.AD_CLIENT_ID" +
      "              INNER JOIN AD_ORG org ON users.DEFAULT_AD_ORG_ID = org.AD_ORG_ID" +
      "              INNER JOIN AD_LANGUAGE lang ON users.DEFAULT_AD_LANGUAGE = lang.AD_LANGUAGE" +
      "              INNER JOIN M_WAREHOUSE warehouse ON users.DEFAULT_M_WAREHOUSE_ID = warehouse.M_WAREHOUSE_ID" +
      "              INNER JOIN AD_ROLE role ON users.DEFAULT_AD_ROLE_ID = role.AD_ROLE_ID" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND (NOT users.DEFAULT_AD_ORG_ID IS NULL" +
      "                AND org.ISACTIVE = 'Y')" +
      "           AND (NOT users.DEFAULT_AD_LANGUAGE IS NULL" +
      "                AND lang.ISACTIVE = 'Y')" +
      "           AND (NOT users.DEFAULT_AD_ROLE_ID IS NULL" +
      "                AND role.ISACTIVE = 'Y')" +
      "           AND (NOT users.DEFAULT_M_WAREHOUSE_ID IS NULL" +
      "                AND warehouse.ISACTIVE = 'Y')";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

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
        DefaultOptionsData objectDefaultOptionsData = new DefaultOptionsData();
        objectDefaultOptionsData.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectDefaultOptionsData.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectDefaultOptionsData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectDefaultOptionsData.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectDefaultOptionsData.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectDefaultOptionsData.isrtl = UtilSql.getValue(result, "isrtl");
        objectDefaultOptionsData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectDefaultOptionsData.line = UtilSql.getValue(result, "line");
        objectDefaultOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultOptionsData);
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
    DefaultOptionsData objectDefaultOptionsData[] = new DefaultOptionsData[vector.size()];
    vector.copyInto(objectDefaultOptionsData);
    return(objectDefaultOptionsData);
  }

  public static String defaultRole(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_ROLE_ID" +
      "          FROM AD_USER users" +
      "            INNER JOIN AD_ROLE role ON users.DEFAULT_AD_ROLE_ID = role.AD_ROLE_ID" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_AD_ROLE_ID IS NULL" +
      "           AND role.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_role_id");
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

  public static String getDefaultSystemRole(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_ROLE_ID, 1 as line" +
      "          FROM AD_USER users," +
      "               AD_ROLE role  " +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_AD_ROLE_ID IS NULL" +
      "           AND role.ISACTIVE = 'Y'" +
      "           AND users.DEFAULT_AD_ROLE_ID = role.AD_ROLE_ID" +
      "           AND role.USERLEVEL = 'S'" +
      "         UNION" +
      "        SELECT TO_CHAR(MIN(userRoles.AD_ROLE_ID)) AS DEFAULT_AD_ROLE_ID, 2 as line" +
      "          FROM AD_USER_ROLES userRoles" +
      "            INNER JOIN AD_ROLE role" +
      "              ON userRoles.AD_ROLE_ID = role.AD_ROLE_ID" +
      "         WHERE userRoles.AD_USER_ID = ?" +
      "           AND role.ISACTIVE = 'Y'" +
      "           AND role.USERLEVEL = 'S'" +
      "         ORDER BY 2";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_role_id");
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

  public static String defaultClient(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_CLIENT_ID" +
      "          FROM AD_USER users" +
      "            INNER JOIN AD_CLIENT client ON users.DEFAULT_AD_CLIENT_ID = client.AD_CLIENT_ID" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_AD_CLIENT_ID IS NULL" +
      "           AND client.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_client_id");
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

  public static String defaultOrg(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_ORG_ID" +
      "          FROM AD_USER users" +
      "            INNER JOIN AD_ORG org ON users.DEFAULT_AD_ORG_ID = org.AD_ORG_ID" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_AD_ORG_ID IS NULL" +
      "           AND org.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_org_id");
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

  public static String defaultWarehouse(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_M_WAREHOUSE_ID" +
      "          FROM AD_USER users" +
      "            INNER JOIN M_WAREHOUSE warehouse ON users.DEFAULT_M_WAREHOUSE_ID = warehouse.M_WAREHOUSE_ID" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_M_WAREHOUSE_ID IS NULL" +
      "           AND warehouse.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_m_warehouse_id");
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

  public static DefaultOptionsData[] defaultLanguage(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    return defaultLanguage(connectionProvider, aduserid, 0, 0);
  }

  public static DefaultOptionsData[] defaultLanguage(ConnectionProvider connectionProvider, String aduserid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT users.DEFAULT_AD_LANGUAGE, lang.ISRTL AS ISRTL" +
      "          FROM AD_USER users" +
      "            INNER JOIN AD_LANGUAGE lang ON users.DEFAULT_AD_LANGUAGE = lang.AD_LANGUAGE" +
      "         WHERE users.AD_USER_ID = ?" +
      "           AND NOT users.DEFAULT_AD_LANGUAGE IS NULL" +
      "           AND lang.ISACTIVE = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

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
        DefaultOptionsData objectDefaultOptionsData = new DefaultOptionsData();
        objectDefaultOptionsData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectDefaultOptionsData.isrtl = UtilSql.getValue(result, "isrtl");
        objectDefaultOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultOptionsData);
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
    DefaultOptionsData objectDefaultOptionsData[] = new DefaultOptionsData[vector.size()];
    vector.copyInto(objectDefaultOptionsData);
    return(objectDefaultOptionsData);
  }

  public static String getDefaultRole(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(MIN(userRoles.AD_ROLE_ID)) AS DEFAULT_AD_ROLE_ID" +
      "          FROM AD_USER_ROLES userRoles" +
      "            INNER JOIN AD_ROLE role" +
      "              ON userRoles.AD_ROLE_ID = role.AD_ROLE_ID" +
      "         WHERE userRoles.AD_USER_ID = ?" +
      "           AND role.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_role_id");
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

  public static String getDefaultClient(ConnectionProvider connectionProvider, String adroleid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CLIENTLIST AS DEFAULT_AD_CLIENT_ID" +
      "          FROM AD_ROLE role" +
      "            INNER JOIN AD_CLIENT client" +
      "              ON role.AD_CLIENT_ID = client.AD_CLIENT_ID" +
      "         WHERE AD_ROLE_ID = ?" +
      "          AND client.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adroleid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_ad_client_id");
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

  public static String getDefaultWarehouse(ConnectionProvider connectionProvider, String adclientid, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(MIN(M_WAREHOUSE_ID)) AS DEFAULT_M_WAREHOUSE_ID" +
      "          FROM M_WAREHOUSE" +
      "         WHERE AD_CLIENT_ID = ?" +
      "          AND ISACTIVE = 'Y'" +
      "          AND AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adclientid);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "default_m_warehouse_id");
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

  public static String getDefaultOrg(ConnectionProvider connectionProvider, String adroleid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(MAX(roleOrg.AD_ORG_ID)) AS AD_ORG_ID" +
      "        FROM AD_ROLE_ORGACCESS roleOrg " +
      "          INNER JOIN AD_ORG org" +
      "            ON roleOrg.AD_ORG_ID = org.AD_ORG_ID" +
      "        WHERE roleOrg.AD_ROLE_ID = ?" +
      "           AND roleOrg.ISACTIVE = 'Y'" +
      "           AND org.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adroleid);

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

  public static DefaultOptionsData[] getDefaultLanguage(ConnectionProvider connectionProvider)    throws ServletException {
    return getDefaultLanguage(connectionProvider, 0, 0);
  }

  public static DefaultOptionsData[] getDefaultLanguage(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT lang.AD_LANGUAGE AS AD_LANGUAGE, lang.ISRTL AS ISRTL" +
      "          FROM AD_LANGUAGE lang, AD_MODULE mod" +
      "         WHERE lang.ISACTIVE = 'Y'" +
      "           AND lang.AD_LANGUAGE = mod.AD_LANGUAGE" +
      "           AND mod.AD_MODULE_ID = '0'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        DefaultOptionsData objectDefaultOptionsData = new DefaultOptionsData();
        objectDefaultOptionsData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectDefaultOptionsData.isrtl = UtilSql.getValue(result, "isrtl");
        objectDefaultOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultOptionsData);
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
    DefaultOptionsData objectDefaultOptionsData[] = new DefaultOptionsData[vector.size()];
    vector.copyInto(objectDefaultOptionsData);
    return(objectDefaultOptionsData);
  }

  public static DefaultOptionsData[] getFirstElementsOptions(ConnectionProvider connectionProvider, String aduserid)    throws ServletException {
    return getFirstElementsOptions(connectionProvider, aduserid, 0, 0);
  }

  public static DefaultOptionsData[] getFirstElementsOptions(ConnectionProvider connectionProvider, String aduserid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ro.ad_role_id AS DEFAULT_AD_ROLE_ID, " +
      "          ro.ad_org_id AS DEFAULT_AD_ORG_ID, " +
      "          ro.ad_client_id AS DEFAULT_AD_CLIENT_ID, " +
      "        (SELECT MAX(w.m_warehouse_id) " +
      "          FROM m_warehouse w, ad_role_orgaccess roa WHERE w.isActive='Y' " +
      "          AND roa.ad_role_id = ro.ad_role_id " +
      "          AND roa.isActive = 'Y'" +
      "          AND w.ad_org_id=roa.ad_org_id " +
      "          AND w.ad_client_id = ro.ad_client_id)" +
      "          AS DEFAULT_M_WAREHOUSE_ID, " +
      "        (SELECT MIN(ad_language) FROM ad_language WHERE isbaselanguage='Y' AND isactive='Y') AS DEFAULT_AD_LANGUAGE " +
      "        FROM ad_role_orgaccess ro" +
      "        WHERE ro.ad_role_id = (SELECT MAX(ad_role_id) FROM ad_user_roles WHERE ad_user_id = ? AND isActive = 'Y')" +
      "        AND ro.isactive = 'Y'" +
      "        ORDER BY ro.ad_org_id, ro.ad_client_id";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aduserid);

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
        DefaultOptionsData objectDefaultOptionsData = new DefaultOptionsData();
        objectDefaultOptionsData.defaultAdRoleId = UtilSql.getValue(result, "default_ad_role_id");
        objectDefaultOptionsData.defaultAdOrgId = UtilSql.getValue(result, "default_ad_org_id");
        objectDefaultOptionsData.defaultAdClientId = UtilSql.getValue(result, "default_ad_client_id");
        objectDefaultOptionsData.defaultMWarehouseId = UtilSql.getValue(result, "default_m_warehouse_id");
        objectDefaultOptionsData.defaultAdLanguage = UtilSql.getValue(result, "default_ad_language");
        objectDefaultOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDefaultOptionsData);
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
    DefaultOptionsData objectDefaultOptionsData[] = new DefaultOptionsData[vector.size()];
    vector.copyInto(objectDefaultOptionsData);
    return(objectDefaultOptionsData);
  }
}
