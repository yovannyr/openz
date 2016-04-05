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

class SeguridadData implements FieldProvider {
static Logger log4j = Logger.getLogger(SeguridadData.class);
  private String InitRecordNumber="0";
  public String userlevel;
  public String clientlist;
  public String orglist;
  public String cCurrencyId;
  public String amtapproval;
  public String adClientId;
  public String name;
  public String cBpartnerId;
  public String value;
  public String smtphost;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("userlevel"))
      return userlevel;
    else if (fieldName.equalsIgnoreCase("clientlist"))
      return clientlist;
    else if (fieldName.equalsIgnoreCase("orglist"))
      return orglist;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("amtapproval"))
      return amtapproval;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("smtphost"))
      return smtphost;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SeguridadData[] select(ConnectionProvider connectionProvider, String adRoleId, String adUserId)    throws ServletException {
    return select(connectionProvider, adRoleId, adUserId, 0, 0);
  }

  public static SeguridadData[] select(ConnectionProvider connectionProvider, String adRoleId, String adUserId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT r.UserLevel,''''||replace(replace(r.ClientList,' ',''),',',''',''')||'''' as ClientList,''''||replace(replace(r.OrgList,' ',''),',',''',''')||'''' as OrgList,r.C_Currency_ID,r.AmtApproval, " +
      "        r.AD_Client_ID, c.NAME, u.C_BPARTNER_ID, c.VALUE, c.SMTPHOST " +
      "        FROM AD_ROLE r, AD_CLIENT c, AD_USER u, " +
      "        AD_USER_ROLES ur " +
      "        WHERE r.AD_Role_ID = ? " +
      "        AND ur.AD_USER_ID = ? " +
      "        AND r.AD_CLIENT_ID = c.AD_CLIENT_ID" +
      "        AND r.IsActive='Y' AND c.IsActive='Y' " +
      "        AND r.AD_ROLE_ID = ur.AD_ROLE_ID " +
      "        AND ur.AD_USER_ID = u.AD_USER_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

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
        SeguridadData objectSeguridadData = new SeguridadData();
        objectSeguridadData.userlevel = UtilSql.getValue(result, "userlevel");
        objectSeguridadData.clientlist = UtilSql.getValue(result, "clientlist");
        objectSeguridadData.orglist = UtilSql.getValue(result, "orglist");
        objectSeguridadData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSeguridadData.amtapproval = UtilSql.getValue(result, "amtapproval");
        objectSeguridadData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSeguridadData.name = UtilSql.getValue(result, "name");
        objectSeguridadData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSeguridadData.value = UtilSql.getValue(result, "value");
        objectSeguridadData.smtphost = UtilSql.getValue(result, "smtphost");
        objectSeguridadData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSeguridadData);
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
    SeguridadData objectSeguridadData[] = new SeguridadData[vector.size()];
    vector.copyInto(objectSeguridadData);
    return(objectSeguridadData);
  }

  public static String valido(ConnectionProvider connectionProvider, String user, String passwd)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_USER_ID " +
      "        FROM AD_USER " +
      "        WHERE ISACTIVE = 'Y' " +
      "        AND USERNAME = ? " +
      "        AND PASSWORD = ?";

    ResultSet result;
    String strReturn = "-1";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, passwd);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_user_id");
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

  public static boolean loggedOK(ConnectionProvider connectionProvider, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "          FROM AD_SESSION WHERE AD_SESSION_ID = ? " +
      "            AND ISACTIVE = 'Y' ";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

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

  public static boolean isUserRole(ConnectionProvider connectionProvider, String user, String role)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_USER_ROLES A_U_R " +
      "        WHERE A_U_R.ISACTIVE = 'Y' " +
      "        AND A_U_R.AD_USER_ID = ?" +
      "        AND A_U_R.AD_ROLE_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);

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

  public static boolean isRoleClient(ConnectionProvider connectionProvider, String rol, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL" +
      "        FROM AD_CLIENT A_C" +
      "        WHERE A_C.AD_CLIENT_ID IN (SELECT CLIENTLIST FROM AD_ROLE WHERE AD_ROLE_ID = ?) " +
      "        AND A_C.AD_CLIENT_ID = ?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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

  public static boolean isLoginRoleOrg(ConnectionProvider connectionProvider, String rol, String org)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS TOTAL " +
      "        FROM AD_ROLE_ORGACCESS A_R_O, AD_ROLE R " +
      "        WHERE A_R_O.ISACTIVE = 'Y' " +
      "        AND A_R_O.AD_ROLE_ID = R.AD_ROLE_ID " +
      "        AND R.ISACTIVE = 'Y' " +
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

  public static int saveProcessed(ConnectionProvider connectionProvider, String adUserId, String adSessionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_SESSION SET UPDATED = now(), UPDATEDBY = ?, " +
      "        PROCESSED = 'Y' " +
      "        WHERE AD_SESSION_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adSessionId);

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

  public static String selectAccessLevel(ConnectionProvider connectionProvider, String type, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ACCESSLEVEL" +
      "          FROM AD_FORM" +
      "         WHERE TO_CHAR('X') = ? " +
      "           AND AD_FORM_ID = ?" +
      "         UNION " +
      "         SELECT ACCESSLEVEL" +
      "          FROM AD_PROCESS " +
      "         WHERE (TO_CHAR('P') = ? OR TO_CHAR('R') = ?)" +
      "           AND AD_PROCESS_ID = ?" +
      "         UNION" +
      "         SELECT T.ACCESSLEVEL" +
      "          FROM AD_TABLE T, " +
      "               AD_TAB TB" +
      "         WHERE T.AD_TABLE_ID = TB.AD_TABLE_ID" +
      "           AND TO_CHAR('W') = ?" +
      "           AND TB.AD_TAB_ID = ?" +
      "         UNION" +
      "         SELECT ACCESSLEVEL" +
      "          FROM AD_TASK" +
      "         WHERE TO_CHAR('T') = ? " +
      "           AND AD_TASK_ID = ?" +
      "         UNION" +
      "        SELECT ACCESSLEVEL" +
      "          FROM AD_WORKFLOW" +
      "         WHERE TO_CHAR('F') = ? " +
      "           AND AD_WORKFLOW_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "accesslevel");
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

  public static String selectAccess(ConnectionProvider connectionProvider, String role, String type, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT SUM(TOTAL) AS TOTAL" +
      "         FROM (SELECT COUNT(*) AS TOTAL " +
      "                FROM AD_Process_Access " +
      "               WHERE AD_Role_ID = ? " +
      "                 AND (TO_CHAR('P') = ? OR TO_CHAR('R') = ?)" +
      "                 AND AD_Process_ID = ? " +
      "                 AND IsActive = 'Y'" +
      "               UNION" +
      "              SELECT COUNT(*) AS TOTAL " +
      "                FROM AD_Form_Access " +
      "               WHERE AD_Role_ID = ?" +
      "                 AND TO_CHAR('X') = ? " +
      "                 AND AD_Form_ID = ? " +
      "                 AND IsActive = 'Y'" +
      "               UNION" +
      "               SELECT COUNT(*) AS TOTAL " +
      "                FROM DUAL " +
      "                WHERE (to_char('800017') = ? " +
      "                   OR to_char('800018') = ?) " +
      "                   AND TO_CHAR('TABLE') <> TO_CHAR(?)" +
      "               UNION" +
      "               SELECT COUNT(*) AS TOTAL " +
      "                 FROM AD_Window_Access " +
      "                WHERE AD_Role_ID = ? " +
      "                  AND TO_CHAR('W') = ?" +
      "                  AND AD_Window_ID = (SELECT AD_WINDOW_ID" +
      "                                        FROM AD_TAB" +
      "                                       WHERE AD_TAB_ID = ?) " +
      "                  AND IsActive = 'Y'" +
      "                UNION" +
      "               SELECT COUNT(*) AS TOTAL " +
      "                 FROM AD_Table_Access t, AD_Tab tb" +
      "                WHERE t.AD_Table_ID = tb.AD_Table_ID " +
      "                 AND t.AD_Role_ID = ? " +
      "                 AND TO_CHAR('TABLE') = ? " +
      "                 AND tb.AD_Tab_ID = ? " +
      "                 AND t.IsActive = 'Y' " +
      "                 AND t.IsExclude = 'Y'" +
      "               UNION" +
      "              SELECT COUNT(*) AS TOTAL " +
      "                FROM AD_Task_Access " +
      "               WHERE AD_Role_ID = ? " +
      "                 AND TO_CHAR('T') = ?" +
      "                 AND AD_Task_ID = ? " +
      "                 AND IsActive = 'Y' " +
      "               UNION" +
      "              SELECT COUNT(*) AS TOTAL " +
      "                FROM AD_Workflow_Access " +
      "               WHERE AD_Role_ID = ?" +
      "                 AND TO_CHAR('F') = ? " +
      "                 AND AD_Workflow_ID = ? " +
      "                 AND IsActive = 'Y'" +
      "                 UNION" +
      "               SELECT COUNT(*) AS TOTAL " +
      "                FROM AD_Process_Access A," +
      "                     AD_Process P" +
      "               WHERE AD_Role_ID = ? " +
      "                 AND TO_CHAR('P') = TO_CHAR(?)" +
      "                 AND A.AD_Process_ID = ?" +
      "                 AND P.AD_Process_ID = A.AD_Process_ID" +
      "                 AND A.IsActive = 'Y'" +
      "                 AND P.IsExternalService = 'Y' " +
      "                   UNION" +
      "               SELECT 1 AS TOTAL" +
      "                FROM AD_Process" +
      "                WHERE  TO_CHAR('P') = TO_CHAR(?)" +
      "                AND AD_Process_ID = ? " +
      "                 AND IsActive = 'Y'" +
      "                 AND IsExternalService != 'Y') TOTAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String selectAccessSearch(ConnectionProvider connectionProvider, String role, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          select count(*) AS TOTAL" +
      "            from ad_column c," +
      "                 ad_field f," +
      "                 ad_tab tb," +
      "                 ad_table t," +
      "                 ad_window_access wa," +
      "                 ad_window w," +
      "                 ad_role r" +
      "           where r.ad_role_ID = ?" +
      "             and ad_reference_value_ID = ?" +
      "             and ad_reference_id = '30'" +
      "             and f.ad_column_id = c.ad_column_id" +
      "             and tb.ad_tab_id  = f.ad_tab_id" +
      "             and tb.ad_window_id = wa.ad_window_id" +
      "             and tb.ad_window_id = w.ad_window_id" +
      "             and wa.ad_role_id = r.ad_role_id" +
      "             and wa.isactive = 'Y'" +
      "             and w.isactive='Y'" +
      "             and t.isActive='Y'" +
      "             and tb.isActive='Y'" +
      "             and tb.ad_table_id = t.ad_table_id" +
      "             and ( (TO_NUMBER(t.accessLevel)=4 and instr(r.userLevel,'S')!=0)" +
      "                or (TO_NUMBER(t.accessLevel)=1 and instr(r.userLevel,'O')!=0)" +
      "                or (TO_NUMBER(t.accessLevel)=3 and not (instr(r.userLevel,'C')=0 or instr(r.userLevel,'O')=0))" +
      "                or (TO_NUMBER(t.accessLevel)=6 and not (instr(r.userLevel,'S')=0 or instr(r.userLevel,'C')=0))" +
      "                )" +
      "             and not exists (select 1" +
      "                              from ad_table_access ta" +
      "                             where t.ad_table_id = ta.ad_table_id" +
      "                               and ta.ad_role_id = r.ad_role_id" +
      "                               and ta.isActive='Y'" +
      "                               and ta.isExclude = 'N')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, role);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static boolean hasSystemRole(ConnectionProvider connectionProvider, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          select count(*) AS TOTAL" +
      "           FROM AD_USER U, AD_USER_ROLES UR, AD_ROLE R" +
      "          WHERE U.AD_USER_ID = UR.AD_USER_ID" +
      "            AND UR.AD_ROLE_ID = R.AD_ROLE_ID" +
      "            AND R.USERLEVEL='S'" +
      "            AND U.AD_USER_ID=?";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static String checkBanSecure(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT zsse_checkbansecure(?)" +
      "              FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_checkbansecure");
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

  public static String recordFailedLogin(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT zsse_failedlogin(?)" +
      "              FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsse_failedlogin");
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

  public static String getuserID(ConnectionProvider connectionProvider, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_USER_ID " +
      "        FROM AD_USER " +
      "        WHERE  USERNAME = ? ";

    ResultSet result;
    String strReturn = "-1";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_user_id");
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

  public static boolean hasRoleTabAccessReadonly(ConnectionProvider connectionProvider, String roleId, String tabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          select count(*) AS TOTAL" +
      "           FROM ad_role_tabaccess" +
      "           WHERE ad_role_id= ? and ad_tab_id = ?" +
      "           and (editsetting='READONLY' or visiblesetting = 'HIDDEN')";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabId);

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
