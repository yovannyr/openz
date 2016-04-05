//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_combos;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class OrganizationComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrganizationComboData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String name;
  public String id;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrganizationComboData[] select(ConnectionProvider connectionProvider, String rol)    throws ServletException {
    return select(connectionProvider, rol, 0, 0);
  }

  public static OrganizationComboData[] select(ConnectionProvider connectionProvider, String rol, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_O.AD_ORG_ID, A_O.NAME, '' AS ID " +
      "        FROM AD_ORG A_O, AD_ROLE_ORGACCESS A_R_O, AD_ROLE R " +
      "        WHERE A_R_O.AD_ORG_ID = A_O.AD_ORG_ID " +
      "        AND A_R_O.ISACTIVE = 'Y' " +
      "        AND A_R_O.AD_ROLE_ID = R.AD_ROLE_ID " +
      "        AND R.ISACTIVE = 'Y' " +
      "        AND (LPAD(TO_CHAR(R.USERLEVEL), 1, '1')='S' OR A_O.AD_ORG_ID <> '0') " +
      "        AND A_R_O.AD_ROLE_ID = ? " +
      "        ORDER BY A_O.NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);

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
        OrganizationComboData objectOrganizationComboData = new OrganizationComboData();
        objectOrganizationComboData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrganizationComboData.name = UtilSql.getValue(result, "name");
        objectOrganizationComboData.id = UtilSql.getValue(result, "id");
        objectOrganizationComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrganizationComboData);
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
    OrganizationComboData objectOrganizationComboData[] = new OrganizationComboData[vector.size()];
    vector.copyInto(objectOrganizationComboData);
    return(objectOrganizationComboData);
  }

  public static OrganizationComboData[] selectCombo(ConnectionProvider connectionProvider, String rol)    throws ServletException {
    return selectCombo(connectionProvider, rol, 0, 0);
  }

  public static OrganizationComboData[] selectCombo(ConnectionProvider connectionProvider, String rol, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_O.AD_ORG_ID AS ID, A_O.NAME " +
      "        FROM AD_ORG A_O, AD_ROLE_ORGACCESS A_R_O, AD_ROLE R " +
      "        WHERE A_R_O.AD_ORG_ID = A_O.AD_ORG_ID " +
      "        AND A_R_O.ISACTIVE = 'Y' " +
      "        AND A_R_O.AD_ROLE_ID = R.AD_ROLE_ID " +
      "        AND R.ISACTIVE = 'Y' " +
      "        AND (LPAD(TO_CHAR(R.USERLEVEL), 1, '1')='S' OR A_O.AD_ORG_ID <> '0') " +
      "        AND A_R_O.AD_ROLE_ID = ? " +
      "        ORDER BY A_O.NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);

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
        OrganizationComboData objectOrganizationComboData = new OrganizationComboData();
        objectOrganizationComboData.id = UtilSql.getValue(result, "id");
        objectOrganizationComboData.name = UtilSql.getValue(result, "name");
        objectOrganizationComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrganizationComboData);
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
    OrganizationComboData objectOrganizationComboData[] = new OrganizationComboData[vector.size()];
    vector.copyInto(objectOrganizationComboData);
    return(objectOrganizationComboData);
  }

  public static boolean isRoleOrg(ConnectionProvider connectionProvider, String rol, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_ROLE_ORGACCESS A_R_O, AD_ROLE R " +
      "        WHERE A_R_O.ISACTIVE = 'Y' " +
      "        AND A_R_O.AD_ROLE_ID = R.AD_ROLE_ID " +
      "        AND R.ISACTIVE = 'Y' " +
      "        AND (LPAD(TO_CHAR(R.USERLEVEL), 1, '1')='S' OR A_R_O.AD_ORG_ID <> '0') " +
      "        AND A_R_O.AD_ROLE_ID = ? " +
      "        AND A_R_O.AD_ORG_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "total").equals("0");
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
    return(boolReturn);
  }
}
