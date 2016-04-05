//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting.printing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class EmailData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailData.class);
  private String InitRecordNumber="0";
  public String cPocEmailId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String emailType;
  public String addressFrom;
  public String addressTo;
  public String addressCc;
  public String addressBcc;
  public String dateofemail;
  public String subject;
  public String body;
  public String cBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_poc_email_id") || fieldName.equals("cPocEmailId"))
      return cPocEmailId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("email_type") || fieldName.equals("emailType"))
      return emailType;
    else if (fieldName.equalsIgnoreCase("address_from") || fieldName.equals("addressFrom"))
      return addressFrom;
    else if (fieldName.equalsIgnoreCase("address_to") || fieldName.equals("addressTo"))
      return addressTo;
    else if (fieldName.equalsIgnoreCase("address_cc") || fieldName.equals("addressCc"))
      return addressCc;
    else if (fieldName.equalsIgnoreCase("address_bcc") || fieldName.equals("addressBcc"))
      return addressBcc;
    else if (fieldName.equalsIgnoreCase("dateofemail"))
      return dateofemail;
    else if (fieldName.equalsIgnoreCase("subject"))
      return subject;
    else if (fieldName.equalsIgnoreCase("body"))
      return body;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmailData[] getEmail(ConnectionProvider connectionProvider, String emailId)    throws ServletException {
    return getEmail(connectionProvider, emailId, 0, 0);
  }

  public static EmailData[] getEmail(ConnectionProvider connectionProvider, String emailId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select			" +
      "			C_POC_EMAIL_ID, " +
      "			AD_CLIENT_ID ," +
      "			AD_ORG_ID ," +
      "			ISACTIVE ," +
      "			CREATED ," +
      "			CREATEDBY, " +
      "			UPDATED ," +
      "			UPDATEDBY, " +
      "			EMAIL_TYPE," +
      "			ADDRESS_FROM ," +
      "			ADDRESS_TO ," +
      "			ADDRESS_CC ," +
      "			ADDRESS_BCC ," +
      "			DATEOFEMAIL, " +
      "			SUBJECT ," +
      "			BODY ," +
      "			C_BPARTNER_ID" +
      "		from" +
      "			C_POC_EMAIL" +
      "		where" +
      "			1=1";
    strSql = strSql + ((emailId==null || emailId.equals(""))?"":"              and C_POC_EMAIL.C_POC_EMAIL_ID in          " + emailId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (emailId != null && !(emailId.equals(""))) {
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
        EmailData objectEmailData = new EmailData();
        objectEmailData.cPocEmailId = UtilSql.getValue(result, "c_poc_email_id");
        objectEmailData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmailData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmailData.isactive = UtilSql.getValue(result, "isactive");
        objectEmailData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectEmailData.createdby = UtilSql.getValue(result, "createdby");
        objectEmailData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectEmailData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmailData.emailType = UtilSql.getValue(result, "email_type");
        objectEmailData.addressFrom = UtilSql.getValue(result, "address_from");
        objectEmailData.addressTo = UtilSql.getValue(result, "address_to");
        objectEmailData.addressCc = UtilSql.getValue(result, "address_cc");
        objectEmailData.addressBcc = UtilSql.getValue(result, "address_bcc");
        objectEmailData.dateofemail = UtilSql.getDateValue(result, "dateofemail", "dd-MM-yyyy");
        objectEmailData.subject = UtilSql.getValue(result, "subject");
        objectEmailData.body = UtilSql.getValue(result, "body");
        objectEmailData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectEmailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailData);
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
    EmailData objectEmailData[] = new EmailData[vector.size()];
    vector.copyInto(objectEmailData);
    return(objectEmailData);
  }

  public static int insertEmail(Connection conn, ConnectionProvider connectionProvider, String bmPocEmailId, String adClientId, String adOrgId, String adUserId, String type, String from, String to, String cc, String bcc, String dateOfEmail, String subject, String body, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO" +
      "        	C_POC_EMAIL" +
      "        	(" +
      "				C_POC_EMAIL_ID, " +
      "				AD_CLIENT_ID ," +
      "				AD_ORG_ID ," +
      "				ISACTIVE ," +
      "				CREATED ," +
      "				CREATEDBY, " +
      "				UPDATED ," +
      "				UPDATEDBY, " +
      "				EMAIL_TYPE," +
      "				ADDRESS_FROM ," +
      "				ADDRESS_TO ," +
      "				ADDRESS_CC ," +
      "				ADDRESS_BCC ," +
      "				DATEOFEMAIL, " +
      "				SUBJECT ," +
      "				BODY ," +
      "				C_BPARTNER_ID" +
      "        	)" +
      "        	VALUES" +
      "        	(" +
      "        		?," +
      "        		?," +
      "        		?, " +
      "        		'Y', " +
      "        		now(), " +
      "        		?," +
      "				now()," +
      "				?," +
      "				?," +
      "				?," +
      "				?," +
      "				?," +
      "				?," +
      "				TO_DATE(?, 'YYYYMMDDHH24MISS')," +
      "				?," +
      "				?," +
      "				?" +
      "			)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bmPocEmailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, from);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, to);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bcc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateOfEmail);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, body);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int insertEmailUser(Connection conn, ConnectionProvider connectionProvider, String bmPocEmailUserId, String adClientId, String adOrgId, String adUserId, String type, String bmPocEmailId, String email_adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO" +
      "        	C_POC_EMAIL_USER" +
      "        	(" +
      "				C_POC_EMAIL_USER_ID, " +
      "				AD_CLIENT_ID ," +
      "				AD_ORG_ID ," +
      "				ISACTIVE ," +
      "				CREATED ," +
      "				CREATEDBY, " +
      "				UPDATED ," +
      "				UPDATEDBY, " +
      "				ADDRESS_TYPE," +
      "				C_POC_EMAIL_ID ," +
      "				AD_USER_ID" +
      "        	)" +
      "        	VALUES" +
      "        	(" +
      "        		TO_NUMBER(?)," +
      "        		TO_NUMBER(?)," +
      "        		TO_NUMBER(?), " +
      "        		'Y', " +
      "        		now(), " +
      "        		TO_NUMBER(?)," +
      "				now()," +
      "				TO_NUMBER(?)," +
      "				TO_NUMBER(?)," +
      "				TO_NUMBER(?)," +
      "				TO_NUMBER(?)" +
      "			)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bmPocEmailUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, type);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bmPocEmailId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email_adUserId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String getSenderAddress(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select" +
      "            C_poc_configuration.smtpServerSenderAddress" +
      "        from" +
      "            C_poc_configuration" +
      "        where" +
      "            C_poc_configuration.ad_client_id = ? AND" +
      "            (C_poc_configuration.ad_org_id = ? OR C_poc_configuration.ad_org_id = '0') AND" +
      "            C_poc_configuration.isActive = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "smtpserversenderaddress");
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
