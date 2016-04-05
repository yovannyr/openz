//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class DocumentNoData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocumentNoData.class);
  private String InitRecordNumber="0";
  public String a;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("a"))
      return a;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocumentNoData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocumentNoData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select 1 as a from dual";

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
        DocumentNoData objectDocumentNoData = new DocumentNoData();
        objectDocumentNoData.a = UtilSql.getValue(result, "a");
        objectDocumentNoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocumentNoData);
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
    DocumentNoData objectDocumentNoData[] = new DocumentNoData[vector.size()];
    vector.copyInto(objectDocumentNoData);
    return(objectDocumentNoData);
  }

  public static CSResponse nextDocType(ConnectionProvider connectionProvider, String cDocTypeId, String adOrgId, String updateNext)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Sequence_DocType(?,?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateNext);
      int iParameterrazon = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      st.execute();
      objectCSResponse.razon= UtilSql.getStringCallableStatement(st, iParameterrazon);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(cDocTypeId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(updateNext);
      parametersTypes.addElement("in");
      parametersData.addElement("razon");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.razon = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectCSResponse);
  }

  public static CSResponse nextDoc(ConnectionProvider connectionProvider, String cDocTypeTableName, String adOrgId, String updateNext)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Sequence_Doc(?,?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeTableName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateNext);
      int iParameterrazon = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      st.execute();
      objectCSResponse.razon= UtilSql.getStringCallableStatement(st, iParameterrazon);
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
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(cDocTypeTableName);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(updateNext);
      parametersTypes.addElement("in");
      parametersData.addElement("razon");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(null, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.razon = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectCSResponse);
  }

  public static CSResponse nextDocConnection(Connection conn, ConnectionProvider connectionProvider, String cDocTypeTableName, String adOrgId, String updateNext)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Sequence_Doc(?,?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeTableName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateNext);
      int iParameterrazon = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      st.execute();
      objectCSResponse.razon= UtilSql.getStringCallableStatement(st, iParameterrazon);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(cDocTypeTableName);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(updateNext);
      parametersTypes.addElement("in");
      parametersData.addElement("razon");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.razon = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectCSResponse);
  }

  public static CSResponse nextDocTypeConnection(Connection conn, ConnectionProvider connectionProvider, String cDocTypeId, String adOrgId, String updateNext)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL AD_Sequence_DocType(?,?,?,?)";

    CSResponse objectCSResponse = new CSResponse();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updateNext);
      int iParameterrazon = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);

      st.execute();
      objectCSResponse.razon= UtilSql.getStringCallableStatement(st, iParameterrazon);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(cDocTypeId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(updateNext);
      parametersTypes.addElement("in");
      parametersData.addElement("razon");
      parametersTypes.addElement("out");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectCSResponse.razon = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectCSResponse);
  }
}
