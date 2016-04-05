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

public class RegistrationData implements FieldProvider {
static Logger log4j = Logger.getLogger(RegistrationData.class);
  private String InitRecordNumber="0";
  public String registrationId;
  public String isregistrationactive;
  public String postponeDate;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("registration_id") || fieldName.equals("registrationId"))
      return registrationId;
    else if (fieldName.equalsIgnoreCase("isregistrationactive"))
      return isregistrationactive;
    else if (fieldName.equalsIgnoreCase("postpone_date") || fieldName.equals("postponeDate"))
      return postponeDate;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RegistrationData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static RegistrationData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT Registration_Id, Isregistrationactive, Postpone_Date" +
      "        FROM Ad_Registration_Info";

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
        RegistrationData objectRegistrationData = new RegistrationData();
        objectRegistrationData.registrationId = UtilSql.getValue(result, "registration_id");
        objectRegistrationData.isregistrationactive = UtilSql.getValue(result, "isregistrationactive");
        objectRegistrationData.postponeDate = UtilSql.getDateValue(result, "postpone_date", "dd-MM-yyyy");
        objectRegistrationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRegistrationData);
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
    RegistrationData objectRegistrationData[] = new RegistrationData[vector.size()];
    vector.copyInto(objectRegistrationData);
    return(objectRegistrationData);
  }
}
