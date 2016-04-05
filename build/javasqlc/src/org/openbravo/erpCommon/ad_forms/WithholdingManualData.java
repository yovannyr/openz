//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

/**
WithHolding Manual data 
 */
class WithholdingManualData implements FieldProvider {
static Logger log4j = Logger.getLogger(WithholdingManualData.class);
  private String InitRecordNumber="0";
  public String accountId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select Accounts of Withholding
 */
  public static String select_accounts(ConnectionProvider connectionProvider, String parC_Withholding_ID, String parC_acctschema_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT WithHolding_Acct as account_ID " +
      "	FROM C_WithHolding_Acct " +
      "	WHERE C_WithHolding_ID = ?" +
      "	and C_ACCTSCHEMA_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parC_Withholding_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parC_acctschema_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "account_id");
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
