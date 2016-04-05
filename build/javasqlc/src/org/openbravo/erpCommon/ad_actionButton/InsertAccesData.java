//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class InsertAccesData implements FieldProvider {
static Logger log4j = Logger.getLogger(InsertAccesData.class);
  private String InitRecordNumber="0";
  public String nodeId;
  public String parentId;
  public String issummary;
  public String action;
  public String adwindowid;
  public String adprocessid;
  public String adformid;
  public String adworkflowid;
  public String adtaskid;
  public String printreport;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("node_id") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("adwindowid"))
      return adwindowid;
    else if (fieldName.equalsIgnoreCase("adprocessid"))
      return adprocessid;
    else if (fieldName.equalsIgnoreCase("adformid"))
      return adformid;
    else if (fieldName.equalsIgnoreCase("adworkflowid"))
      return adworkflowid;
    else if (fieldName.equalsIgnoreCase("adtaskid"))
      return adtaskid;
    else if (fieldName.equalsIgnoreCase("printreport"))
      return printreport;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InsertAccesData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static InsertAccesData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT tn.Node_ID,tn.Parent_ID, m.ISSUMMARY, m.action, m.AD_WINDOW_ID as adwindowid," +
      "        m.AD_PROCESS_ID as adprocessid, m.AD_FORM_ID as adformid, m.AD_WORKFLOW_ID as adworkflowid," +
      "        m.AD_TASK_ID as adtaskid, tb.ad_process_id as printreport" +
      "        FROM AD_TREENODE tn, AD_MENU m left join ad_tab tb " +
      "                                       on m.ad_window_id = tb.ad_window_id" +
      "                                          and tb.ad_process_id is not null" +
      "        WHERE tn.NODE_ID = m.AD_MENU_ID " +
      "        AND tn.ad_tree_id = '10' " +
      "        AND tn.IsActive='Y' ";

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
        InsertAccesData objectInsertAccesData = new InsertAccesData();
        objectInsertAccesData.nodeId = UtilSql.getValue(result, "node_id");
        objectInsertAccesData.parentId = UtilSql.getValue(result, "parent_id");
        objectInsertAccesData.issummary = UtilSql.getValue(result, "issummary");
        objectInsertAccesData.action = UtilSql.getValue(result, "action");
        objectInsertAccesData.adwindowid = UtilSql.getValue(result, "adwindowid");
        objectInsertAccesData.adprocessid = UtilSql.getValue(result, "adprocessid");
        objectInsertAccesData.adformid = UtilSql.getValue(result, "adformid");
        objectInsertAccesData.adworkflowid = UtilSql.getValue(result, "adworkflowid");
        objectInsertAccesData.adtaskid = UtilSql.getValue(result, "adtaskid");
        objectInsertAccesData.printreport = UtilSql.getValue(result, "printreport");
        objectInsertAccesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInsertAccesData);
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
    InsertAccesData objectInsertAccesData[] = new InsertAccesData[vector.size()];
    vector.copyInto(objectInsertAccesData);
    return(objectInsertAccesData);
  }

  public static String selectWindow(ConnectionProvider connectionProvider, String roleId, String windowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_window_Access" +
      "        where ad_role_id=?" +
      "        and ad_window_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static InsertAccesData[] selectWindowButtons(ConnectionProvider connectionProvider, String windowId, String roleId)    throws ServletException {
    return selectWindowButtons(connectionProvider, windowId, roleId, 0, 0);
  }

  public static InsertAccesData[] selectWindowButtons(ConnectionProvider connectionProvider, String windowId, String roleId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select distinct ad_column.ad_process_id as adprocessid" +
      "        from ad_tab, ad_field, ad_column" +
      "        where ad_tab.ad_window_id = ?" +
      "          and ad_tab.ad_tab_id = ad_field.ad_tab_id" +
      "          and ad_field.ad_column_id = ad_column.ad_column_id" +
      "          and ad_column.ad_process_id is not null" +
      "          and not exists (select 1 from ad_process_access pa" +
      "                          where pa.ad_process_id = ad_column.ad_process_id" +
      "                            and pa.ad_role_id = ?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);

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
        InsertAccesData objectInsertAccesData = new InsertAccesData();
        objectInsertAccesData.adprocessid = UtilSql.getValue(result, "adprocessid");
        objectInsertAccesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInsertAccesData);
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
    InsertAccesData objectInsertAccesData[] = new InsertAccesData[vector.size()];
    vector.copyInto(objectInsertAccesData);
    return(objectInsertAccesData);
  }

  public static int insertWindow(ConnectionProvider connectionProvider, String windowId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_WINDOW_ACCESS (ad_WINDOW_ACCESS_ID, AD_WINDOW_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static String selectProcess(ConnectionProvider connectionProvider, String roleId, String processId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_process_Access" +
      "        where ad_role_id=?" +
      "        and ad_process_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static int insertProcess(ConnectionProvider connectionProvider, String processId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_process_ACCESS (ad_process_ACCESS_ID, AD_process_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static String selectForm(ConnectionProvider connectionProvider, String roleId, String formId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_form_Access" +
      "        where ad_role_id=?" +
      "        and ad_form_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static int insertForm(ConnectionProvider connectionProvider, String formId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_form_ACCESS (ad_form_ACCESS_ID, AD_form_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static String selectWorkflow(ConnectionProvider connectionProvider, String roleId, String workflowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_workflow_Access" +
      "        where ad_role_id=?" +
      "        and ad_workflow_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workflowId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static int insertWorkflow(ConnectionProvider connectionProvider, String workflowId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ad_workflow_ACCESS (ad_workflow_ACCESS_ID, AD_workflow_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE )" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static String selectTask(ConnectionProvider connectionProvider, String roleId, String taskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select 1 from ad_task_Access" +
      "        where ad_role_id=?" +
      "        and ad_task_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "?column?");
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

  public static int insertTask(ConnectionProvider connectionProvider, String taskId, String roleId, String adClientId, String adOrgId, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_TASK_ACCESS (AD_TASK_ACCESS_ID, AD_TASK_ID, AD_ROLE_ID, AD_CLIENT_ID," +
      "        AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISREADWRITE)" +
      "        VALUES (get_uuid(), ?, ?, ?, ?, 'Y', now(), ?, now(), ?, 'Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, roleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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
}
