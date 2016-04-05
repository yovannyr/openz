//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.businessUtility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class WindowTabsData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTabsData.class);
  private String InitRecordNumber="0";
  public String adTabId;
  public String tablevel;
  public String name;
  public String tabname;
  public String seqno;
  public String istranslationtab;
  public String isinfotab;
  public String isbreadcrumb;
  public String tabnameid;
  public String isactive;
  public String id;
  public String action;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("tablevel"))
      return tablevel;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("istranslationtab"))
      return istranslationtab;
    else if (fieldName.equalsIgnoreCase("isinfotab"))
      return isinfotab;
    else if (fieldName.equalsIgnoreCase("isbreadcrumb"))
      return isbreadcrumb;
    else if (fieldName.equalsIgnoreCase("tabnameid"))
      return tabnameid;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static WindowTabsData[] select(ConnectionProvider connectionProvider, String adLanguage, String adWindowId)    throws ServletException {
    return select(connectionProvider, adLanguage, adWindowId, 0, 0);
  }

  public static WindowTabsData[] select(ConnectionProvider connectionProvider, String adLanguage, String adWindowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select t.AD_Tab_ID, t.TabLevel, t.Name, coalesce(ti.name,coalesce(t_trl.name, t.name)) as tabname, t.seqno, " +
      "        t.IsTranslationTab, t.isInfoTab, 'N' AS isBreadCrumb, ('tabname' || t.ad_tab_id) AS tabNameId," +
      "        t.isActive, '' AS ID, '' AS Action" +
      "        from ad_tab t left join ad_tab_trl t_trl on t.ad_tab_id = t_trl.ad_tab_id" +
      "                              and t_trl.ad_language = ?" +
      "                      left join ad_tab_trl_instance ti   on t.ad_tab_id = ti.ad_tab_id" +
      "                              and ti.ad_language = ?" +
      "        where t.ad_window_id = ?" +
      "        order by t.seqno, t.tablevel";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectWindowTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectWindowTabsData.name = UtilSql.getValue(result, "name");
        objectWindowTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectWindowTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectWindowTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectWindowTabsData.isbreadcrumb = UtilSql.getValue(result, "isbreadcrumb");
        objectWindowTabsData.tabnameid = UtilSql.getValue(result, "tabnameid");
        objectWindowTabsData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTabsData.id = UtilSql.getValue(result, "id");
        objectWindowTabsData.action = UtilSql.getValue(result, "action");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static WindowTabsData[] selectManual(ConnectionProvider connectionProvider, String adTabId, String adLanguage, String adMenuId)    throws ServletException {
    return selectManual(connectionProvider, adTabId, adLanguage, adMenuId, 0, 0);
  }

  public static WindowTabsData[] selectManual(ConnectionProvider connectionProvider, String adTabId, String adLanguage, String adMenuId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ? AS AD_Tab_ID, '0' AS TabLevel, m.Name, coalesce(ti.name,coalesce(m_trl.name, m.name)) as tabname, '10' AS seqno, " +
      "        '' AS IsTranslationTab, '' AS isInfoTab, 'N' AS isBreadCrumb" +
      "        from ad_menu m left join ad_menu_trl m_trl on m.ad_menu_id = m_trl.ad_menu_id" +
      "                              and m_trl.ad_language = ?" +
      "                       left join ad_menu_trl_instance ti on m.ad_menu_id = ti.ad_menu_id" +
      "                              and m_trl.ad_language = ?" +
      "        where m.isactive = 'Y'" +
      "        and m.ad_menu_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectWindowTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectWindowTabsData.name = UtilSql.getValue(result, "name");
        objectWindowTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectWindowTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectWindowTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectWindowTabsData.isbreadcrumb = UtilSql.getValue(result, "isbreadcrumb");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static WindowTabsData[] selectManualwithoutMenu(ConnectionProvider connectionProvider, String adTabId, String adLanguage)    throws ServletException {
    return selectManualwithoutMenu(connectionProvider, adTabId, adLanguage, 0, 0);
  }

  public static WindowTabsData[] selectManualwithoutMenu(ConnectionProvider connectionProvider, String adTabId, String adLanguage, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ? AS AD_Tab_ID, '0' AS TabLevel, f.Name, coalesce(ftrl.name, f.name) as tabname, '10' AS seqno, " +
      "        '' AS IsTranslationTab, '' AS isInfoTab, 'N' AS isBreadCrumb" +
      "        from ad_form f left join ad_form_trl ftrl on f.ad_form_id = ftrl.ad_form_id" +
      "                              and ftrl.ad_language = ?" +
      "        where f.isactive = 'Y'" +
      "        and f.ad_form_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectWindowTabsData.tablevel = UtilSql.getValue(result, "tablevel");
        objectWindowTabsData.name = UtilSql.getValue(result, "name");
        objectWindowTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectWindowTabsData.seqno = UtilSql.getValue(result, "seqno");
        objectWindowTabsData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectWindowTabsData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectWindowTabsData.isbreadcrumb = UtilSql.getValue(result, "isbreadcrumb");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static String selectMenu(ConnectionProvider connectionProvider, String adLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select AD_Parent_Menu_Element(m.AD_Menu_ID, m.AD_Client_ID, ?) AS NAME" +
      "        from ad_menu m " +
      "        where m.ad_window_id = ?" +
      "        and m.isactive = 'Y'" +
      "        and m.action = 'W'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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

  public static String selectMenuManual(ConnectionProvider connectionProvider, String adLanguage, String adMenuId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select AD_Parent_Menu_Element(m.AD_Menu_ID, m.AD_Client_ID, ?) AS NAME" +
      "        from ad_menu m " +
      "        where m.ad_menu_id = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);

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

  public static WindowTabsData[] selectMenuInfo(ConnectionProvider connectionProvider, String adLanguage, String action, String adTabId)    throws ServletException {
    return selectMenuInfo(connectionProvider, adLanguage, action, adTabId, 0, 0);
  }

  public static WindowTabsData[] selectMenuInfo(ConnectionProvider connectionProvider, String adLanguage, String action, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m.AD_Menu_ID AS ID, coalesce(ti.name,coalesce(mt.name, m.name)) as name " +
      "        from AD_Menu m left join ad_menu_trl mt on m.ad_menu_id = mt.ad_menu_id " +
      "                                                  and mt.ad_language = ?" +
      "                       left join ad_menu_trl_instance ti on m.ad_menu_id = ti.ad_menu_id " +
      "                                                  and ti.ad_language = ?" +
      "        where (CASE m.action WHEN 'R' THEN 'P' " +
      "                                  ELSE m.action END) = (CASE ? WHEN 'R' THEN 'P' ELSE ? END) " +
      "        and (m.ad_window_ID = ? " +
      "        or m.ad_process_ID = ? " +
      "        or m.ad_form_ID = ? " +
      "        or m.ad_task_ID = ? " +
      "        or m.ad_workflow_ID = ? " +
      "        )";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.id = UtilSql.getValue(result, "id");
        objectWindowTabsData.name = UtilSql.getValue(result, "name");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static WindowTabsData[] selectJavaInfo(ConnectionProvider connectionProvider, String className)    throws ServletException {
    return selectJavaInfo(connectionProvider, className, 0, 0);
  }

  public static WindowTabsData[] selectJavaInfo(ConnectionProvider connectionProvider, String className, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select (CASE mo.Action WHEN 'F' THEN mo.AD_WorkFlow_ID " +
      "                   WHEN 'X' THEN mo.AD_Form_ID" +
      "                   WHEN 'P' THEN mo.AD_Process_ID" +
      "                   WHEN 'R' THEN mo.AD_Process_ID" +
      "                   WHEN 'C' THEN mo.AD_CallOut_ID" +
      "                   WHEN 'T' THEN mo.AD_Task_ID" +
      "                   WHEN 'S' THEN mo.AD_Reference_ID" +
      "                   ELSE mo.AD_Tab_ID END) AS AD_Tab_ID, " +
      "        mom.MAPPINGNAME AS TabName, mo.action" +
      "        from ad_model_object mo, ad_model_object_mapping mom" +
      "        where mo.ad_model_object_id = mom.ad_model_object_id" +
      "        and mo.isActive = 'Y'" +
      "        and mom.isActive = 'Y' " +
      "        and mom.isDefault = 'Y'" +
      "        and UPPER(mo.CLASSNAME) = UPPER(?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, className);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectWindowTabsData.tabname = UtilSql.getValue(result, "tabname");
        objectWindowTabsData.action = UtilSql.getValue(result, "action");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static WindowTabsData[] selectProcessInfo(ConnectionProvider connectionProvider, String processId)    throws ServletException {
    return selectProcessInfo(connectionProvider, processId, 0, 0);
  }

  public static WindowTabsData[] selectProcessInfo(ConnectionProvider connectionProvider, String processId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_process_id as ad_tab_id, 'P' as action" +
      "          from ad_process" +
      "          where ad_process_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

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
        WindowTabsData objectWindowTabsData = new WindowTabsData();
        objectWindowTabsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectWindowTabsData.action = UtilSql.getValue(result, "action");
        objectWindowTabsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTabsData);
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
    WindowTabsData objectWindowTabsData[] = new WindowTabsData[vector.size()];
    vector.copyInto(objectWindowTabsData);
    return(objectWindowTabsData);
  }

  public static String selectWindowInfo(ConnectionProvider connectionProvider, String adLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select coalesce(ti.name,coalesce(mt.name, m.name)) as name " +
      "        from ad_menu m left join ad_menu_trl mt on m.ad_menu_id = mt.ad_menu_id " +
      "                                                and mt.ad_language = ?" +
      "                       left join ad_menu_trl_instance ti on m.ad_menu_id = ti.ad_menu_id " +
      "                                                and ti.ad_language = ?" +
      "        where m.ad_window_id = ? " +
      "        and m.action = 'W' ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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

  public static String isModuleActive(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m.isactive " +
      "        from ad_module m, ad_tab t" +
      "        where t.ad_module_id=m.ad_module_id" +
      "        and t.ad_tab_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isactive");
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

  public static String isRoleActive(ConnectionProvider connectionProvider, String adRoleId, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select isactive from ad_role_tabaccess where ad_role_id = ? and ad_tab_id = ?" +
      "        union " +
      "        select 'Y' as isactive from dual" +
      "        order by isactive  limit 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isactive");
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

  public static String isInstanceActive(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select isactive from ad_tab_instance where ad_tab_id = ?" +
      "        union " +
      "        select 'Y' as isactive from dual" +
      "        order by isactive  limit 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isactive");
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
