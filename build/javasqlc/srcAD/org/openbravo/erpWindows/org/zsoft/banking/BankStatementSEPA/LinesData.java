//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.banking.BankStatementSEPA;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class LinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(LinesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cBankstatementId;
  public String cBankstatementIdr;
  public String line;
  public String description;
  public String valutadate;
  public String dateacct;
  public String cDebtPaymentId;
  public String cDebtPaymentIdr;
  public String trxamt;
  public String memo;
  public String sepaexportenabled;
  public String foreigncurrency;
  public String cDpManagementId;
  public String isvoided;
  public String cChargeId;
  public String foreigncurrencyrate;
  public String isactive;
  public String cGlitemId;
  public String foreigncurrencyamt;
  public String stmtamt;
  public String discountamt;
  public String cCurrencyId;
  public String referenceno;
  public String voidline;
  public String convertchargeamt;
  public String cBankstatementlineId;
  public String cDebtPaymentCreate;
  public String chargeamt;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_bankstatement_id") || fieldName.equals("cBankstatementId"))
      return cBankstatementId;
    else if (fieldName.equalsIgnoreCase("c_bankstatement_idr") || fieldName.equals("cBankstatementIdr"))
      return cBankstatementIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("valutadate"))
      return valutadate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_idr") || fieldName.equals("cDebtPaymentIdr"))
      return cDebtPaymentIdr;
    else if (fieldName.equalsIgnoreCase("trxamt"))
      return trxamt;
    else if (fieldName.equalsIgnoreCase("memo"))
      return memo;
    else if (fieldName.equalsIgnoreCase("sepaexportenabled"))
      return sepaexportenabled;
    else if (fieldName.equalsIgnoreCase("foreigncurrency"))
      return foreigncurrency;
    else if (fieldName.equalsIgnoreCase("c_dp_management_id") || fieldName.equals("cDpManagementId"))
      return cDpManagementId;
    else if (fieldName.equalsIgnoreCase("isvoided"))
      return isvoided;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("foreigncurrencyrate"))
      return foreigncurrencyrate;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("foreigncurrencyamt"))
      return foreigncurrencyamt;
    else if (fieldName.equalsIgnoreCase("stmtamt"))
      return stmtamt;
    else if (fieldName.equalsIgnoreCase("discountamt"))
      return discountamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("referenceno"))
      return referenceno;
    else if (fieldName.equalsIgnoreCase("voidline"))
      return voidline;
    else if (fieldName.equalsIgnoreCase("convertchargeamt"))
      return convertchargeamt;
    else if (fieldName.equalsIgnoreCase("c_bankstatementline_id") || fieldName.equals("cBankstatementlineId"))
      return cBankstatementlineId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_create") || fieldName.equals("cDebtPaymentCreate"))
      return cDebtPaymentCreate;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankstatementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBankstatementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBankstatementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BankStatementLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankStatementLine.CreatedBy) as CreatedByR, " +
      "        to_char(C_BankStatementLine.Updated, ?) as updated, " +
      "        to_char(C_BankStatementLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BankStatementLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BankStatementLine.UpdatedBy) as UpdatedByR," +
      "        C_BankStatementLine.AD_Client_ID, " +
      "(CASE WHEN C_BankStatementLine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_BankStatementLine.AD_Org_ID, " +
      "(CASE WHEN C_BankStatementLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_BankStatementLine.C_BankStatement_ID, " +
      "(CASE WHEN C_BankStatementLine.C_BankStatement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_BankStatement_IDR, " +
      "C_BankStatementLine.Line, " +
      "C_BankStatementLine.Description, " +
      "C_BankStatementLine.ValutaDate, " +
      "C_BankStatementLine.DateAcct, " +
      "C_BankStatementLine.C_Debt_Payment_ID, " +
      "(CASE WHEN C_BankStatementLine.C_Debt_Payment_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.Dateplanned, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Amount), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.IsReceipt), ''))),'') ) END) AS C_Debt_Payment_IDR, " +
      "C_BankStatementLine.TrxAmt, " +
      "C_BankStatementLine.Memo, " +
      "COALESCE(C_BankStatementLine.Sepaexportenabled, 'N') AS Sepaexportenabled, " +
      "C_BankStatementLine.Foreigncurrency, " +
      "C_BankStatementLine.C_Dp_Management_ID, " +
      "COALESCE(C_BankStatementLine.Isvoided, 'N') AS Isvoided, " +
      "C_BankStatementLine.C_Charge_ID, " +
      "C_BankStatementLine.Foreigncurrencyrate, " +
      "COALESCE(C_BankStatementLine.IsActive, 'N') AS IsActive, " +
      "C_BankStatementLine.C_Glitem_ID, " +
      "C_BankStatementLine.Foreigncurrencyamt, " +
      "C_BankStatementLine.StmtAmt, " +
      "C_BankStatementLine.Discountamt, " +
      "C_BankStatementLine.C_Currency_ID, " +
      "C_BankStatementLine.ReferenceNo, " +
      "C_BankStatementLine.Voidline, " +
      "C_BankStatementLine.ConvertChargeAmt, " +
      "C_BankStatementLine.C_BankStatementLine_ID, " +
      "C_BankStatementLine.C_Debt_Payment_Create, " +
      "C_BankStatementLine.ChargeAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BankStatementLine left join (select AD_Client_ID, Name from AD_Client) table1 on (C_BankStatementLine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_BankStatementLine.AD_Org_ID = table2.AD_Org_ID) left join (select C_BankStatement_ID, Name from C_BankStatement) table3 on (C_BankStatementLine.C_BankStatement_ID = table3.C_BankStatement_ID) left join (select C_Debt_Payment_ID, C_BPartner_ID, PaymentRule, Dateplanned, Amount, IsReceipt from C_Debt_Payment) table4 on (C_BankStatementLine.C_Debt_Payment_ID = table4.C_Debt_Payment_ID) left join (select C_BPartner_ID, Name from C_BPartner) table5 on (table4.C_BPartner_ID = table5.C_BPartner_ID) left join ad_ref_list_v list1 on (table4.PaymentRule = list1.value and list1.ad_reference_id = '195' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBankstatementId==null || cBankstatementId.equals(""))?"":"  AND C_BankStatementLine.C_BankStatement_ID = ?  ");
    strSql = strSql + 
      "        AND C_BankStatementLine.C_BankStatementLine_ID = ? " +
      "        AND C_BankStatementLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BankStatementLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cBankstatementId != null && !(cBankstatementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        LinesData objectLinesData = new LinesData();
        objectLinesData.created = UtilSql.getValue(result, "created");
        objectLinesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLinesData.updated = UtilSql.getValue(result, "updated");
        objectLinesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLinesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLinesData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLinesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectLinesData.cBankstatementId = UtilSql.getValue(result, "c_bankstatement_id");
        objectLinesData.cBankstatementIdr = UtilSql.getValue(result, "c_bankstatement_idr");
        objectLinesData.line = UtilSql.getValue(result, "line");
        objectLinesData.description = UtilSql.getValue(result, "description");
        objectLinesData.valutadate = UtilSql.getDateValue(result, "valutadate", "dd-MM-yyyy");
        objectLinesData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectLinesData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectLinesData.cDebtPaymentIdr = UtilSql.getValue(result, "c_debt_payment_idr");
        objectLinesData.trxamt = UtilSql.getValue(result, "trxamt");
        objectLinesData.memo = UtilSql.getValue(result, "memo");
        objectLinesData.sepaexportenabled = UtilSql.getValue(result, "sepaexportenabled");
        objectLinesData.foreigncurrency = UtilSql.getValue(result, "foreigncurrency");
        objectLinesData.cDpManagementId = UtilSql.getValue(result, "c_dp_management_id");
        objectLinesData.isvoided = UtilSql.getValue(result, "isvoided");
        objectLinesData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectLinesData.foreigncurrencyrate = UtilSql.getValue(result, "foreigncurrencyrate");
        objectLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectLinesData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectLinesData.foreigncurrencyamt = UtilSql.getValue(result, "foreigncurrencyamt");
        objectLinesData.stmtamt = UtilSql.getValue(result, "stmtamt");
        objectLinesData.discountamt = UtilSql.getValue(result, "discountamt");
        objectLinesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectLinesData.referenceno = UtilSql.getValue(result, "referenceno");
        objectLinesData.voidline = UtilSql.getValue(result, "voidline");
        objectLinesData.convertchargeamt = UtilSql.getValue(result, "convertchargeamt");
        objectLinesData.cBankstatementlineId = UtilSql.getValue(result, "c_bankstatementline_id");
        objectLinesData.cDebtPaymentCreate = UtilSql.getValue(result, "c_debt_payment_create");
        objectLinesData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectLinesData.language = UtilSql.getValue(result, "language");
        objectLinesData.adUserClient = "";
        objectLinesData.adOrgClient = "";
        objectLinesData.createdby = "";
        objectLinesData.trBgcolor = "";
        objectLinesData.totalCount = "";
        objectLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLinesData);
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
    LinesData objectLinesData[] = new LinesData[vector.size()];
    vector.copyInto(objectLinesData);
    return(objectLinesData);
  }

/**
Create a registry
 */
  public static LinesData[] set(String cBankstatementId, String cBankstatementlineId, String trxamt, String isvoided, String referenceno, String cCurrencyId, String foreigncurrency, String voidline, String foreigncurrencyamt, String isactive, String valutadate, String foreigncurrencyrate, String cGlitemId, String chargeamt, String memo, String cDpManagementId, String createdby, String createdbyr, String stmtamt, String dateacct, String cDebtPaymentId, String cDebtPaymentIdr, String cChargeId, String adClientId, String discountamt, String description, String adOrgId, String sepaexportenabled, String cDebtPaymentCreate, String updatedby, String updatedbyr, String line, String convertchargeamt)    throws ServletException {
    LinesData objectLinesData[] = new LinesData[1];
    objectLinesData[0] = new LinesData();
    objectLinesData[0].created = "";
    objectLinesData[0].createdbyr = createdbyr;
    objectLinesData[0].updated = "";
    objectLinesData[0].updatedTimeStamp = "";
    objectLinesData[0].updatedby = updatedby;
    objectLinesData[0].updatedbyr = updatedbyr;
    objectLinesData[0].adClientId = adClientId;
    objectLinesData[0].adClientIdr = "";
    objectLinesData[0].adOrgId = adOrgId;
    objectLinesData[0].adOrgIdr = "";
    objectLinesData[0].cBankstatementId = cBankstatementId;
    objectLinesData[0].cBankstatementIdr = "";
    objectLinesData[0].line = line;
    objectLinesData[0].description = description;
    objectLinesData[0].valutadate = valutadate;
    objectLinesData[0].dateacct = dateacct;
    objectLinesData[0].cDebtPaymentId = cDebtPaymentId;
    objectLinesData[0].cDebtPaymentIdr = cDebtPaymentIdr;
    objectLinesData[0].trxamt = trxamt;
    objectLinesData[0].memo = memo;
    objectLinesData[0].sepaexportenabled = sepaexportenabled;
    objectLinesData[0].foreigncurrency = foreigncurrency;
    objectLinesData[0].cDpManagementId = cDpManagementId;
    objectLinesData[0].isvoided = isvoided;
    objectLinesData[0].cChargeId = cChargeId;
    objectLinesData[0].foreigncurrencyrate = foreigncurrencyrate;
    objectLinesData[0].isactive = isactive;
    objectLinesData[0].cGlitemId = cGlitemId;
    objectLinesData[0].foreigncurrencyamt = foreigncurrencyamt;
    objectLinesData[0].stmtamt = stmtamt;
    objectLinesData[0].discountamt = discountamt;
    objectLinesData[0].cCurrencyId = cCurrencyId;
    objectLinesData[0].referenceno = referenceno;
    objectLinesData[0].voidline = voidline;
    objectLinesData[0].convertchargeamt = convertchargeamt;
    objectLinesData[0].cBankstatementlineId = cBankstatementlineId;
    objectLinesData[0].cDebtPaymentCreate = cDebtPaymentCreate;
    objectLinesData[0].chargeamt = chargeamt;
    objectLinesData[0].language = "";
    return objectLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5217(ConnectionProvider connectionProvider, String C_BankAccount_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID FROM C_BANKACCOUNT WHERE C_BANKACCOUNT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankAccount_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef4931_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

/**
Select for auxiliar field
 */
  public static String selectDef800404_1(ConnectionProvider connectionProvider, String C_Debt_Payment_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.PaymentRule), '')  || ' - ' || COALESCE(TO_CHAR(table1.Dateplanned), '')  || ' - ' || COALESCE(TO_CHAR(table1.Amount), '')  || ' - ' || COALESCE(TO_CHAR(table1.IsReceipt), '') ) as C_Debt_Payment_ID FROM C_Debt_Payment table1 left join C_BPartner table2 on (table1.C_BPartner_ID = table2.C_BPartner_ID) WHERE table1.isActive='Y' AND table1.C_Debt_Payment_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Debt_Payment_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_debt_payment_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef4933_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
Select for auxiliar field
 */
  public static String selectDef5219(ConnectionProvider connectionProvider, String C_BankStatement_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM C_BankStatementLine WHERE C_BankStatement_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BankStatement_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BankStatementLine.C_BankStatement_ID AS NAME" +
      "        FROM C_BankStatementLine" +
      "        WHERE C_BankStatementLine.C_BankStatementLine_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cBankstatementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BankStatement left join (select C_BankStatement_ID, Name from C_BankStatement) table1 on (C_BankStatement.C_BankStatement_ID = table1.C_BankStatement_ID) WHERE C_BankStatement.C_BankStatement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBankstatementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BankStatement left join (select C_BankStatement_ID, Name from C_BankStatement) table1 on (C_BankStatement.C_BankStatement_ID = table1.C_BankStatement_ID) WHERE C_BankStatement.C_BankStatement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_BankStatementLine" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_BankStatement_ID = (?) , Line = TO_NUMBER(?) , Description = (?) , ValutaDate = TO_DATE(?) , DateAcct = TO_DATE(?) , C_Debt_Payment_ID = (?) , TrxAmt = TO_NUMBER(?) , Memo = (?) , Sepaexportenabled = (?) , Foreigncurrency = (?) , C_Dp_Management_ID = (?) , Isvoided = (?) , C_Charge_ID = (?) , Foreigncurrencyrate = TO_NUMBER(?) , IsActive = (?) , C_Glitem_ID = (?) , Foreigncurrencyamt = TO_NUMBER(?) , StmtAmt = TO_NUMBER(?) , Discountamt = TO_NUMBER(?) , C_Currency_ID = (?) , ReferenceNo = (?) , Voidline = (?) , ConvertChargeAmt = TO_NUMBER(?) , C_BankStatementLine_ID = (?) , C_Debt_Payment_Create = (?) , ChargeAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_BankStatementLine.C_BankStatementLine_ID = ? " +
      "                 AND C_BankStatementLine.C_BankStatement_ID = ? " +
      "        AND C_BankStatementLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankStatementLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valutadate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, memo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sepaexportenabled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDpManagementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvoided);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stmtamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, voidline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertchargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentCreate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_BankStatementLine " +
      "        (AD_Client_ID, AD_Org_ID, C_BankStatement_ID, Line, Description, ValutaDate, DateAcct, C_Debt_Payment_ID, TrxAmt, Memo, Sepaexportenabled, Foreigncurrency, C_Dp_Management_ID, Isvoided, C_Charge_ID, Foreigncurrencyrate, IsActive, C_Glitem_ID, Foreigncurrencyamt, StmtAmt, Discountamt, C_Currency_ID, ReferenceNo, Voidline, ConvertChargeAmt, C_BankStatementLine_ID, C_Debt_Payment_Create, ChargeAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valutadate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, memo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sepaexportenabled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDpManagementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvoided);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stmtamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, voidline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, convertchargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentCreate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBankstatementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankStatementLine" +
      "        WHERE C_BankStatementLine.C_BankStatementLine_ID = ? " +
      "                 AND C_BankStatementLine.C_BankStatement_ID = ? " +
      "        AND C_BankStatementLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BankStatementLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBankstatementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BankStatementLine" +
      "        WHERE C_BankStatementLine.C_BankStatementLine_ID = ? " +
      "                 AND C_BankStatementLine.C_BankStatement_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);

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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM C_BankStatementLine" +
      "         WHERE C_BankStatementLine.C_BankStatementLine_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM C_BankStatementLine" +
      "         WHERE C_BankStatementLine.C_BankStatementLine_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
