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

public class TemplateData implements FieldProvider {
static Logger log4j = Logger.getLogger(TemplateData.class);
  private String InitRecordNumber="0";
  public String position;
  public String adOrgId;
  public String cPocDoctypeTemplateId;
  public String templateLocation;
  public String templateFilename;
  public String reportFilename;
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("position"))
      return position;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_id") || fieldName.equals("cPocDoctypeTemplateId"))
      return cPocDoctypeTemplateId;
    else if (fieldName.equalsIgnoreCase("template_location") || fieldName.equals("templateLocation"))
      return templateLocation;
    else if (fieldName.equalsIgnoreCase("template_filename") || fieldName.equals("templateFilename"))
      return templateFilename;
    else if (fieldName.equalsIgnoreCase("report_filename") || fieldName.equals("reportFilename"))
      return reportFilename;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TemplateData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static TemplateData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "		    '' as position," +
      "			'' as ad_org_id," +
      "			'' as c_poc_doctype_template_id,			" +
      "			'' as template_location," +
      "			'' as template_filename," +
      "			'' as report_filename," +
      "			'' as id," +
      "			'' as name" +
      "		from" +
      "			dual";

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
        TemplateData objectTemplateData = new TemplateData();
        objectTemplateData.position = UtilSql.getValue(result, "position");
        objectTemplateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTemplateData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectTemplateData.templateLocation = UtilSql.getValue(result, "template_location");
        objectTemplateData.templateFilename = UtilSql.getValue(result, "template_filename");
        objectTemplateData.reportFilename = UtilSql.getValue(result, "report_filename");
        objectTemplateData.id = UtilSql.getValue(result, "id");
        objectTemplateData.name = UtilSql.getValue(result, "name");
        objectTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTemplateData);
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
    TemplateData objectTemplateData[] = new TemplateData[vector.size()];
    vector.copyInto(objectTemplateData);
    return(objectTemplateData);
  }

  public static TemplateData[] getDocumentTemplates(ConnectionProvider connectionProvider, String docTypeId, String adOrgId)    throws ServletException {
    return getDocumentTemplates(connectionProvider, docTypeId, adOrgId, 0, 0);
  }

  public static TemplateData[] getDocumentTemplates(ConnectionProvider connectionProvider, String docTypeId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "		    '1' as position,		" +
      "			documenttemplate.ad_org_id as ad_org_id," +
      "			documenttemplate.c_poc_doctype_template_id as c_poc_doctype_template_id," +
      "			documenttemplate.c_poc_doctype_template_id as id,			" +
      "			documenttemplate.templatelocation as template_location," +
      "			documenttemplate.templatefilename as template_filename," +
      "			documenttemplate.name as name," +
      "			documenttemplate.reportfilename as report_filename" +
      "		from" +
      "			C_poc_doctype_template documenttemplate" +
      "		where" +
      "			documenttemplate.c_doctype_id = ? and" +
      "			documenttemplate.ad_org_id = ? and" +
      "			documenttemplate.isactive='Y'" +
      "	    union " +
      "		select" +
      "		    '2' as position," +
      "			documenttemplate.ad_org_id as ad_org_id," +
      "			documenttemplate.c_poc_doctype_template_id as c_poc_doctype_template_id,		" +
      "			documenttemplate.c_poc_doctype_template_id as id,			" +
      "			documenttemplate.templatelocation as template_location," +
      "			documenttemplate.templatefilename as template_filename," +
      "			documenttemplate.name as name," +
      "			documenttemplate.reportfilename as report_filename" +
      "		from" +
      "			C_poc_doctype_template documenttemplate" +
      "		where" +
      "			documenttemplate.c_doctype_id = ? and" +
      "			documenttemplate.ad_org_id = '0' and" +
      "            documenttemplate.isactive='Y'		    " +
      "		order by position asc, ad_org_id desc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docTypeId);

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
        TemplateData objectTemplateData = new TemplateData();
        objectTemplateData.position = UtilSql.getValue(result, "position");
        objectTemplateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTemplateData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectTemplateData.id = UtilSql.getValue(result, "id");
        objectTemplateData.templateLocation = UtilSql.getValue(result, "template_location");
        objectTemplateData.templateFilename = UtilSql.getValue(result, "template_filename");
        objectTemplateData.name = UtilSql.getValue(result, "name");
        objectTemplateData.reportFilename = UtilSql.getValue(result, "report_filename");
        objectTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTemplateData);
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
    TemplateData objectTemplateData[] = new TemplateData[vector.size()];
    vector.copyInto(objectTemplateData);
    return(objectTemplateData);
  }
}
