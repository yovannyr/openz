//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String documentId;
  public String docstatus;
  public String doctypetargetid;
  public String ourreference;
  public String cusreference;
  public String bpartnerId;
  public String bpartnerLanguage;
  public String uniqueTimestamp;
  public String bpartnerName;
  public String orga;
  public String docname;
  public String issalesordertransaction;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("document_id") || fieldName.equals("documentId"))
      return documentId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("doctypetargetid"))
      return doctypetargetid;
    else if (fieldName.equalsIgnoreCase("ourreference"))
      return ourreference;
    else if (fieldName.equalsIgnoreCase("cusreference"))
      return cusreference;
    else if (fieldName.equalsIgnoreCase("bpartner_id") || fieldName.equals("bpartnerId"))
      return bpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartner_language") || fieldName.equals("bpartnerLanguage"))
      return bpartnerLanguage;
    else if (fieldName.equalsIgnoreCase("unique_timestamp") || fieldName.equals("uniqueTimestamp"))
      return uniqueTimestamp;
    else if (fieldName.equalsIgnoreCase("bpartner_name") || fieldName.equals("bpartnerName"))
      return bpartnerName;
    else if (fieldName.equalsIgnoreCase("orga"))
      return orga;
    else if (fieldName.equalsIgnoreCase("docname"))
      return docname;
    else if (fieldName.equalsIgnoreCase("issalesordertransaction"))
      return issalesordertransaction;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportData[] dummy(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return dummy(connectionProvider, cOrderId, 0, 0);
  }

  public static ReportData[] dummy(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				'' as ad_Org_Id," +
      "				'' as document_id," +
      "				'' as docstatus," +
      "				'' as docTypeTargetId," +
      "				'' as ourreference," +
      "				'' as cusreference," +
      "				'' as bpartner_id," +
      "				'' as bpartner_language," +
      "				'' as unique_timestamp," +
      "				'' as bpartner_name," +
      "				'' as orga," +
      "				'' as docname," +
      "				'' as isSalesOrderTransaction" +
      "			from" +
      "				c_order" +
      "			where" +
      "				1=1";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  			 and c_order.c_order_id in  		" + cOrderId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (cOrderId != null && !(cOrderId.equals(""))) {
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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.uniqueTimestamp = UtilSql.getValue(result, "unique_timestamp");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.orga = UtilSql.getValue(result, "orga");
        objectReportData.docname = UtilSql.getValue(result, "docname");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getOrderInfo(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return getOrderInfo(connectionProvider, cOrderId, 0, 0);
  }

  public static ReportData[] getOrderInfo(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				c_order.ad_org_id," +
      "				c_order.c_order_id as document_id," +
      "				c_order.docstatus," +
      "				c_order.c_doctypetarget_id as docTypeTargetId," +
      "				c_order.documentno as ourreference," +
      "				c_order.poreference as cusreference," +
      "				c_order.c_bpartner_id as bpartner_id," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS') as unique_timestamp," +
      "                c_bpartner.name as bpartner_name," +
      "                zssi_juwiorgshortcut(c_order.ad_org_id) as orga," +
      "                zssi_docshortcut(c_order.c_doctypetarget_id) as docname" +
      "			from" +
      "				c_order left join c_doctype on c_order.c_doctypetarget_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on c_order.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "			where" +
      "				c_order.c_order_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.uniqueTimestamp = UtilSql.getValue(result, "unique_timestamp");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.orga = UtilSql.getValue(result, "orga");
        objectReportData.docname = UtilSql.getValue(result, "docname");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getInvoiceInfo(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return getInvoiceInfo(connectionProvider, cInvoiceId, 0, 0);
  }

  public static ReportData[] getInvoiceInfo(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				c_invoice.ad_org_id," +
      "				c_invoice.c_invoice_id as document_id," +
      "				c_invoice.docstatus," +
      "				c_invoice.c_doctypetarget_id as docTypeTargetId," +
      "				c_invoice.documentno as ourreference," +
      "				c_invoice.poreference as cusreference," +
      "				c_invoice.c_bpartner_id as bpartner_id," +
      "				c_invoice.issotrx as isSalesOrderTransaction," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS') as unique_timestamp," +
      "                c_bpartner.name as bpartner_name," +
      "                zssi_juwiorgshortcut(c_invoice.ad_org_id) as orga," +
      "                zssi_docshortcut(c_invoice.c_doctypetarget_id) as docname" +
      "			from" +
      "				c_invoice left join c_doctype on c_invoice.c_doctypetarget_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on c_invoice.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "			where" +
      "				c_invoice.c_invoice_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.issalesordertransaction = UtilSql.getValue(result, "issalesordertransaction");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.uniqueTimestamp = UtilSql.getValue(result, "unique_timestamp");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.orga = UtilSql.getValue(result, "orga");
        objectReportData.docname = UtilSql.getValue(result, "docname");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getShipmentInfo(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    return getShipmentInfo(connectionProvider, mInoutId, 0, 0);
  }

  public static ReportData[] getShipmentInfo(ConnectionProvider connectionProvider, String mInoutId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "				m_inout.ad_org_id," +
      "				m_inout.m_inout_id as document_id," +
      "				m_inout.docstatus," +
      "				m_inout.c_doctype_id as docTypeTargetId," +
      "				m_inout.documentno as ourreference," +
      "				m_inout.poreference as cusreference," +
      "				m_inout.c_bpartner_id as bpartner_id," +
      "				c_bpartner.ad_language as bpartner_language," +
      "				to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS') as unique_timestamp," +
      "                c_bpartner.name as bpartner_name," +
      "                zssi_juwiorgshortcut(m_inout.ad_org_id) as orga," +
      "                zssi_docshortcut(m_inout.c_doctype_id) as docname" +
      "			from" +
      "				m_inout left join c_doctype on m_inout.c_doctype_id = c_doctype.c_doctype_id" +
      "				left join c_bpartner on m_inout.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "			where" +
      "				m_inout.m_inout_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.uniqueTimestamp = UtilSql.getValue(result, "unique_timestamp");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.orga = UtilSql.getValue(result, "orga");
        objectReportData.docname = UtilSql.getValue(result, "docname");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static ReportData[] getDefaultDocInfo(ConnectionProvider connectionProvider, String functionname, String tablename, String id)    throws ServletException {
    return getDefaultDocInfo(connectionProvider, functionname, tablename, id, 0, 0);
  }

  public static ReportData[] getDefaultDocInfo(ConnectionProvider connectionProvider, String functionname, String tablename, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id," +
      "                   bpartner_language,unique_timestamp,bpartner_name,orga,docname" +
      "            FROM ";
    strSql = strSql + ((functionname==null || functionname.equals(""))?"":functionname);
    strSql = strSql + 
      "(?,?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (functionname != null && !(functionname.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        ReportData objectReportData = new ReportData();
        objectReportData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportData.documentId = UtilSql.getValue(result, "document_id");
        objectReportData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportData.doctypetargetid = UtilSql.getValue(result, "doctypetargetid");
        objectReportData.ourreference = UtilSql.getValue(result, "ourreference");
        objectReportData.cusreference = UtilSql.getValue(result, "cusreference");
        objectReportData.bpartnerId = UtilSql.getValue(result, "bpartner_id");
        objectReportData.bpartnerLanguage = UtilSql.getValue(result, "bpartner_language");
        objectReportData.uniqueTimestamp = UtilSql.getValue(result, "unique_timestamp");
        objectReportData.bpartnerName = UtilSql.getValue(result, "bpartner_name");
        objectReportData.orga = UtilSql.getValue(result, "orga");
        objectReportData.docname = UtilSql.getValue(result, "docname");
        objectReportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportData);
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
    ReportData objectReportData[] = new ReportData[vector.size()];
    vector.copyInto(objectReportData);
    return(objectReportData);
  }

  public static String getBpartnerLanguage(ConnectionProvider connectionProvider, String bpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ad_language from c_bpartner where c_bpartner_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_language");
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
