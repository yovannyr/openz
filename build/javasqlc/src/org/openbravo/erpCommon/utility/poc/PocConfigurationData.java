//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.poc;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PocConfigurationData implements FieldProvider {
static Logger log4j = Logger.getLogger(PocConfigurationData.class);
  private String InitRecordNumber="0";
  public String smtpserver;
  public String smtpserveraccount;
  public String smtpserverpassword;
  public String issmtpauthorization;
  public String smtpserversenderaddress;
  public String smtpport;
  public String usetls;
  public String usessl;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("smtpserver"))
      return smtpserver;
    else if (fieldName.equalsIgnoreCase("smtpserveraccount"))
      return smtpserveraccount;
    else if (fieldName.equalsIgnoreCase("smtpserverpassword"))
      return smtpserverpassword;
    else if (fieldName.equalsIgnoreCase("issmtpauthorization"))
      return issmtpauthorization;
    else if (fieldName.equalsIgnoreCase("smtpserversenderaddress"))
      return smtpserversenderaddress;
    else if (fieldName.equalsIgnoreCase("smtpport"))
      return smtpport;
    else if (fieldName.equalsIgnoreCase("usetls"))
      return usetls;
    else if (fieldName.equalsIgnoreCase("usessl"))
      return usessl;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PocConfigurationData[] getSmtpDetails(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    return getSmtpDetails(connectionProvider, adClientId, adOrgId, 0, 0);
  }

  public static PocConfigurationData[] getSmtpDetails(ConnectionProvider connectionProvider, String adClientId, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select" +
      "			C_poc_configuration.smtpServer," +
      "			C_poc_configuration.smtpServerAccount," +
      "			C_poc_configuration.smtpServerPassword," +
      "            C_poc_configuration.isSmtpAuthorization," +
      "            C_poc_configuration.smtpServerSenderAddress," +
      "            C_poc_configuration.smtpport," +
      "            C_poc_configuration.usetls," +
      "            C_poc_configuration.usessl" +
      "		from" +
      "			C_poc_configuration" +
      "		where" +
      "			C_poc_configuration.ad_client_id = ? AND " +
      "			(C_poc_configuration.ad_org_id = ? OR C_poc_configuration.ad_org_id = '0') AND" +
      "			C_poc_configuration.isActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
        PocConfigurationData objectPocConfigurationData = new PocConfigurationData();
        objectPocConfigurationData.smtpserver = UtilSql.getValue(result, "smtpserver");
        objectPocConfigurationData.smtpserveraccount = UtilSql.getValue(result, "smtpserveraccount");
        objectPocConfigurationData.smtpserverpassword = UtilSql.getValue(result, "smtpserverpassword");
        objectPocConfigurationData.issmtpauthorization = UtilSql.getValue(result, "issmtpauthorization");
        objectPocConfigurationData.smtpserversenderaddress = UtilSql.getValue(result, "smtpserversenderaddress");
        objectPocConfigurationData.smtpport = UtilSql.getValue(result, "smtpport");
        objectPocConfigurationData.usetls = UtilSql.getValue(result, "usetls");
        objectPocConfigurationData.usessl = UtilSql.getValue(result, "usessl");
        objectPocConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPocConfigurationData);
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
    PocConfigurationData objectPocConfigurationData[] = new PocConfigurationData[vector.size()];
    vector.copyInto(objectPocConfigurationData);
    return(objectPocConfigurationData);
  }
}
