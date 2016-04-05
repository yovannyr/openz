//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class DocTaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocTaxData.class);
  private String InitRecordNumber="0";
  public String tDueAcct;
  public String tLiabilityAcct;
  public String tCreditAcct;
  public String tReceivablesAcct;
  public String tExpenseAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("t_due_acct") || fieldName.equals("tDueAcct"))
      return tDueAcct;
    else if (fieldName.equalsIgnoreCase("t_liability_acct") || fieldName.equals("tLiabilityAcct"))
      return tLiabilityAcct;
    else if (fieldName.equalsIgnoreCase("t_credit_acct") || fieldName.equals("tCreditAcct"))
      return tCreditAcct;
    else if (fieldName.equalsIgnoreCase("t_receivables_acct") || fieldName.equals("tReceivablesAcct"))
      return tReceivablesAcct;
    else if (fieldName.equalsIgnoreCase("t_expense_acct") || fieldName.equals("tExpenseAcct"))
      return tExpenseAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocTaxData[] select(ConnectionProvider connectionProvider, String C_Tax_ID, String C_AcctSchema_ID)    throws ServletException {
    return select(connectionProvider, C_Tax_ID, C_AcctSchema_ID, 0, 0);
  }

  public static DocTaxData[] select(ConnectionProvider connectionProvider, String C_Tax_ID, String C_AcctSchema_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            	SELECT T_Due_Acct, T_Liability_Acct, T_Credit_Acct, T_Receivables_Acct, T_Expense_Acct " +
      "            	FROM C_Tax_Acct WHERE C_Tax_ID=? " +
      "            	AND C_AcctSchema_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Tax_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_AcctSchema_ID);

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
        DocTaxData objectDocTaxData = new DocTaxData();
        objectDocTaxData.tDueAcct = UtilSql.getValue(result, "t_due_acct");
        objectDocTaxData.tLiabilityAcct = UtilSql.getValue(result, "t_liability_acct");
        objectDocTaxData.tCreditAcct = UtilSql.getValue(result, "t_credit_acct");
        objectDocTaxData.tReceivablesAcct = UtilSql.getValue(result, "t_receivables_acct");
        objectDocTaxData.tExpenseAcct = UtilSql.getValue(result, "t_expense_acct");
        objectDocTaxData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocTaxData);
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
    DocTaxData objectDocTaxData[] = new DocTaxData[vector.size()];
    vector.copyInto(objectDocTaxData);
    return(objectDocTaxData);
  }

  public static String getReversecharge(ConnectionProvider connectionProvider, String C_Tax_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT reversecharge " +
      "                FROM C_Tax WHERE C_Tax_ID=? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Tax_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "reversecharge");
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
