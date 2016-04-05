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

class SEInOutDocTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(SEInOutDocTypeData.class);
  private String InitRecordNumber="0";
  public String isdocnocontrolled;
  public String currentnext;
  public String docbasetype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("isdocnocontrolled"))
      return isdocnocontrolled;
    else if (fieldName.equalsIgnoreCase("currentnext"))
      return currentnext;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SEInOutDocTypeData[] select(ConnectionProvider connectionProvider, String cDocTypeId)    throws ServletException {
    return select(connectionProvider, cDocTypeId, 0, 0);
  }

  public static SEInOutDocTypeData[] select(ConnectionProvider connectionProvider, String cDocTypeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT d.IsDocNoControlled," +
      "        s.CurrentNext, d.DocBaseType" +
      "        FROM C_DocType d left join AD_Sequence s on d.DocNoSequence_ID=s.AD_Sequence_ID" +
      "        WHERE C_DocType_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeId);

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
        SEInOutDocTypeData objectSEInOutDocTypeData = new SEInOutDocTypeData();
        objectSEInOutDocTypeData.isdocnocontrolled = UtilSql.getValue(result, "isdocnocontrolled");
        objectSEInOutDocTypeData.currentnext = UtilSql.getValue(result, "currentnext");
        objectSEInOutDocTypeData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectSEInOutDocTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSEInOutDocTypeData);
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
    SEInOutDocTypeData objectSEInOutDocTypeData[] = new SEInOutDocTypeData[vector.size()];
    vector.copyInto(objectSEInOutDocTypeData);
    return(objectSEInOutDocTypeData);
  }

  public static String selectDoctypetargetinvoice(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DOCTYPETARGET_ID" +
      "        FROM C_INVOICE" +
      "        WHERE C_INVOICE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctypetarget_id");
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

  public static String selectActualinvoicedocumentno(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DOCUMENTNO" +
      "        FROM C_INVOICE" +
      "        WHERE C_INVOICE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "documentno");
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
