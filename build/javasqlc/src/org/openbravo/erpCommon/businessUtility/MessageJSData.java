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

class MessageJSData implements FieldProvider {
static Logger log4j = Logger.getLogger(MessageJSData.class);
  private String InitRecordNumber="0";
  public String msgtype;
  public String msgtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("msgtype"))
      return msgtype;
    else if (fieldName.equalsIgnoreCase("msgtext"))
      return msgtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MessageJSData[] getMessage(ConnectionProvider connectionProvider, String adLanguage, String value)    throws ServletException {
    return getMessage(connectionProvider, adLanguage, value, 0, 0);
  }

  public static MessageJSData[] getMessage(ConnectionProvider connectionProvider, String adLanguage, String value, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select m.msgtype, COALESCE(mt.msgtext, m.msgtext) AS msgtext " +
      "        from ad_message m left join ad_message_trl mt on m.ad_message_id = mt.ad_message_id " +
      "                                                    and mt.ad_language = ? " +
      "        where upper(m.value) = upper(?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
        MessageJSData objectMessageJSData = new MessageJSData();
        objectMessageJSData.msgtype = UtilSql.getValue(result, "msgtype");
        objectMessageJSData.msgtext = UtilSql.getValue(result, "msgtext");
        objectMessageJSData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMessageJSData);
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
    MessageJSData objectMessageJSData[] = new MessageJSData[vector.size()];
    vector.copyInto(objectMessageJSData);
    return(objectMessageJSData);
  }
}
