//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

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

class CreateFromBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromBankData.class);
  private String InitRecordNumber="0";
  public String dateplanned;
  public String cDebtPaymentId;
  public String description;
  public String cInvoiceId;
  public String cBankaccountId;
  public String adClientId;
  public String adOrgId;
  public String pAmount;
  public String pWoamount;
  public String pDiscountamt;
  public String vwz1;
  public String vwz2;
  public String vwz3;
  public String vwz4;
  public String pCashdiscountamt;
  public String cCurrencyId;
  public String currency;
  public String org;
  public String isreceipt;
  public String isapproved;
  public String vendinvoice;
  public String debtPayment;
  public String invoice;
  public String bank;
  public String amount;
  public String converted;
  public String rw;
  public String statementdate;
  public String cashdiscountamt;
  public String addref;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("p_amount") || fieldName.equals("pAmount"))
      return pAmount;
    else if (fieldName.equalsIgnoreCase("p_woamount") || fieldName.equals("pWoamount"))
      return pWoamount;
    else if (fieldName.equalsIgnoreCase("p_discountamt") || fieldName.equals("pDiscountamt"))
      return pDiscountamt;
    else if (fieldName.equalsIgnoreCase("vwz1"))
      return vwz1;
    else if (fieldName.equalsIgnoreCase("vwz2"))
      return vwz2;
    else if (fieldName.equalsIgnoreCase("vwz3"))
      return vwz3;
    else if (fieldName.equalsIgnoreCase("vwz4"))
      return vwz4;
    else if (fieldName.equalsIgnoreCase("p_cashdiscountamt") || fieldName.equals("pCashdiscountamt"))
      return pCashdiscountamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("isreceipt"))
      return isreceipt;
    else if (fieldName.equalsIgnoreCase("isapproved"))
      return isapproved;
    else if (fieldName.equalsIgnoreCase("vendinvoice"))
      return vendinvoice;
    else if (fieldName.equalsIgnoreCase("debt_payment") || fieldName.equals("debtPayment"))
      return debtPayment;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("bank"))
      return bank;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("converted"))
      return converted;
    else if (fieldName.equalsIgnoreCase("rw"))
      return rw;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("cashdiscountamt"))
      return cashdiscountamt;
    else if (fieldName.equalsIgnoreCase("addref"))
      return addref;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromBankData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBankstatementID, String statementdate, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String amountFrom, String amountTo, String isreceipt, String cBankaccountId, String adOrgId, String ischarge, String isapproved, String invoice, String pgLimit)    throws ServletException {
    return select(connectionProvider, adLanguage, cBankstatementID, statementdate, userClient, userOrg, cBPartnerId, paymentrule, planneddateFrom, planneddateTo, amountFrom, amountTo, isreceipt, cBankaccountId, adOrgId, ischarge, isapproved, invoice, pgLimit, 0, 0);
  }

  public static CreateFromBankData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBankstatementID, String statementdate, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String amountFrom, String amountTo, String isreceipt, String cBankaccountId, String adOrgId, String ischarge, String isapproved, String invoice, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A.*," +
      "          (CASE Ad_Column_Identifier(to_char('C_Debt_Payment'), to_char(C_DEBT_Payment_ID), to_char(?))" +
      "             WHEN '**' THEN to_char(description)" +
      "             ELSE to_char(Ad_Column_Identifier(to_char('C_Debt_Payment'), to_char(C_DEBT_Payment_ID), to_char(?)))" +
      "           END)||(CASE WHEN IsReceipt='Y' then '' WHEN a.isapproved='Y' and IsReceipt='N' THEN '- genehmigt' WHEN a.isapproved='N' and IsReceipt='N' THEN ' - nicht genehmigt' ELSE '' END) AS DEBT_PAYMENT," +
      "          Ad_Column_Identifier(to_char('C_Invoice'), to_char(C_INVOICE_ID), to_char(?)) AS INVOICE," +
      "          Ad_Column_Identifier(to_char('C_BankAccount'), to_char(C_BankAccount_ID), to_char(?)) ||' - '||(SELECT cur.description from c_currency cur, c_bankaccount bank where cur.c_currency_id=bank.c_currency_id and bank.c_bankaccount_id=a.c_bankaccount_id) AS BANK," +
      "          (CASE IsReceipt WHEN 'Y' THEN (p_amount - p_woamount - p_discountamt- p_cashdiscountamt) ELSE (p_amount - p_woamount - p_discountamt - p_cashdiscountamt)*(-1) END) AS AMOUNT," +
      "          C_Currency_Convert((CASE IsReceipt WHEN 'Y' THEN (p_amount) ELSE (p_amount)*(-1) END),a.C_Currency_ID," +
      "          	(select c.c_currency_id from c_bankaccount c,c_bankstatement s  where s.c_bankaccount_id=c.c_bankaccount_id and s.c_bankstatement_id = ?)," +
      "          	to_date(?),to_char(null),AD_Client_ID,AD_Org_ID" +
      "          ) AS CONVERTED," +
      "           (case when (select c.c_currency_id from c_bankaccount c,c_bankstatement s  where s.c_bankaccount_id=c.c_bankaccount_id and s.c_bankstatement_id = ?)=(select c_currency_id from c_invoice where c_invoice_id=a.c_invoice_id) then 'TRUE' else 'FALSE' end) AS rw," +
      "          to_date(?) as statementdate," +
      "          (CASE IsReceipt WHEN 'Y' THEN (p_cashdiscountamt) ELSE (p_cashdiscountamt)*(-1) END) AS cashdiscountamt, " +
      "         (CASE IsReceipt WHEN 'Y' THEN (coalesce('Referenz: '||zssi_getinvoicelinkhesir(a.c_invoice_id), 'Rechnung: '||zssi_getinvoicelinkhesid(a.c_invoice_id))) ELSE (coalesce('Referenz: '||zssi_getinvoicelinkhepir(a.c_invoice_id), 'Rechnung: '||zssi_getinvoicelinkhepid(a.c_invoice_id)))END)as addref" +
      "        FROM ( " +
      "        SELECT p.DatePlanned, p.C_DEBT_Payment_ID," +
      "        p.description, p.c_invoice_id, p.c_bankaccount_id, p.ad_client_id, p.ad_org_id," +
      "        p.Amount as p_amount, p.WriteOffAmt as p_woamount,p.discountamt as p_discountamt," +
      "        zssi_getsepavwz(p.c_invoice_id,'1') as vwz1," +
      "        zssi_getsepavwz(p.c_invoice_id,'2') as vwz2," +
      "        zssi_getsepavwz(p.c_invoice_id,'3') as vwz3," +
      "        zssi_getsepavwz(p.c_invoice_id,'4') as vwz4," +
      "        zsfi_getcashdiscount(p.c_invoice_id,p.Amount-p.WriteOffAmt-p.discountamt,p.C_Currency_ID,?) as p_cashdiscountamt," +
      "        p.C_Currency_ID,c.ISO_Code AS CURRENCY," +
      "        o.Name AS Org," +
      "        p.IsReceipt AS IsReceipt," +
      "        p.isapproved as isapproved," +
      "        c_invoice.poreference as vendinvoice" +
      "        FROM C_DEBT_Payment_v p," +
      "         C_Currency c,  AD_Org o, c_invoice" +
      "        where p.C_Currency_ID=c.C_Currency_ID" +
      "        AND p.IsActive = 'Y'" +
      "        AND p.status != 'RT'" +
      "        AND p.AD_Org_ID = o.AD_Org_ID" +
      "        AND p.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ")" +
      "        AND p.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ")" +
      "        AND CASE" +
      "              WHEN (p.ISVALID = 'N') THEN 'I'" +
      "              WHEN (p.C_CASHLINE_ID IS NOT NULL OR p.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' AND p.ISPAID = 'N') THEN 'W'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' OR(p.C_Settlement_Cancel_ID IS NULL AND p.GENERATE_PROCESSED = 'Y' AND p.ISPAID = 'Y')) THEN 'A'" +
      "              ELSE 'P'" +
      "            END IN ('P', 'A')" +
      "        AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE p.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID)";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND p.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND p.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND p.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND p.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND p.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND p.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND p.ISRECEIPT = ?  ");
    strSql = strSql + ((cBankaccountId==null || cBankaccountId.equals(""))?"":"  AND p.C_BankAccount_ID = ?  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND p.AD_ORG_ID = ?  ");
    strSql = strSql + ((ischarge==null || ischarge.equals(""))?"":"  AND p.ISPAID = ?  ");
    strSql = strSql + ((isapproved==null || isapproved.equals(""))?"":"  AND p.ISAPPROVED = ?  ");
    strSql = strSql + ((invoice==null || invoice.equals(""))?"":"  AND EXISTS (SELECT 1 FROM C_INVOICE WHERE p.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID AND DOCUMENTNO LIKE TO_CHAR(?)) ");
    strSql = strSql + 
      "        AND c_invoice.c_invoice_id=p.c_invoice_id" +
      "        ORDER BY p.DATEPLANNED DESC" +
      "        ) A " +
      "        WHERE 1=1" +
      "        ORDER BY Ad_Column_Identifier(to_char('C_Debt_Payment'), to_char(C_DEBT_Payment_ID), to_char(?)),DatePlanned";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementdate);
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (planneddateFrom != null && !(planneddateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateFrom);
      }
      if (planneddateTo != null && !(planneddateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateTo);
      }
      if (amountFrom != null && !(amountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountFrom);
      }
      if (amountTo != null && !(amountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountTo);
      }
      if (isreceipt != null && !(isreceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      }
      if (cBankaccountId != null && !(cBankaccountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      if (ischarge != null && !(ischarge.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ischarge);
      }
      if (isapproved != null && !(isapproved.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      }
      if (invoice != null && !(invoice.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        CreateFromBankData objectCreateFromBankData = new CreateFromBankData();
        objectCreateFromBankData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectCreateFromBankData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectCreateFromBankData.description = UtilSql.getValue(result, "description");
        objectCreateFromBankData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCreateFromBankData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectCreateFromBankData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCreateFromBankData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCreateFromBankData.pAmount = UtilSql.getValue(result, "p_amount");
        objectCreateFromBankData.pWoamount = UtilSql.getValue(result, "p_woamount");
        objectCreateFromBankData.pDiscountamt = UtilSql.getValue(result, "p_discountamt");
        objectCreateFromBankData.vwz1 = UtilSql.getValue(result, "vwz1");
        objectCreateFromBankData.vwz2 = UtilSql.getValue(result, "vwz2");
        objectCreateFromBankData.vwz3 = UtilSql.getValue(result, "vwz3");
        objectCreateFromBankData.vwz4 = UtilSql.getValue(result, "vwz4");
        objectCreateFromBankData.pCashdiscountamt = UtilSql.getValue(result, "p_cashdiscountamt");
        objectCreateFromBankData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCreateFromBankData.currency = UtilSql.getValue(result, "currency");
        objectCreateFromBankData.org = UtilSql.getValue(result, "org");
        objectCreateFromBankData.isreceipt = UtilSql.getValue(result, "isreceipt");
        objectCreateFromBankData.isapproved = UtilSql.getValue(result, "isapproved");
        objectCreateFromBankData.vendinvoice = UtilSql.getValue(result, "vendinvoice");
        objectCreateFromBankData.debtPayment = UtilSql.getValue(result, "debt_payment");
        objectCreateFromBankData.invoice = UtilSql.getValue(result, "invoice");
        objectCreateFromBankData.bank = UtilSql.getValue(result, "bank");
        objectCreateFromBankData.amount = UtilSql.getValue(result, "amount");
        objectCreateFromBankData.converted = UtilSql.getValue(result, "converted");
        objectCreateFromBankData.rw = UtilSql.getValue(result, "rw");
        objectCreateFromBankData.statementdate = UtilSql.getDateValue(result, "statementdate", "dd-MM-yyyy");
        objectCreateFromBankData.cashdiscountamt = UtilSql.getValue(result, "cashdiscountamt");
        objectCreateFromBankData.addref = UtilSql.getValue(result, "addref");
        objectCreateFromBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromBankData);
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
    CreateFromBankData objectCreateFromBankData[] = new CreateFromBankData[vector.size()];
    vector.copyInto(objectCreateFromBankData);
    return(objectCreateFromBankData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String userClient, String userOrg, String cBPartnerId, String paymentrule, String planneddateFrom, String planneddateTo, String amountFrom, String amountTo, String isreceipt, String cBankaccountId, String adOrgId, String ischarge, String isapproved, String invoice)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS COUNT" +
      "        FROM C_DEBT_Payment_v p" +
      "        where" +
      "            p.IsActive = 'Y'" +
      "        AND p.AD_CLIENT_ID IN (";
    strSql = strSql + ((userClient==null || userClient.equals(""))?"":userClient);
    strSql = strSql + 
      ")" +
      "        AND p.AD_ORG_ID IN (";
    strSql = strSql + ((userOrg==null || userOrg.equals(""))?"":userOrg);
    strSql = strSql + 
      ")" +
      "        AND CASE" +
      "              WHEN (p.ISVALID = 'N') THEN 'I'" +
      "              WHEN (p.C_CASHLINE_ID IS NOT NULL OR p.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' AND p.ISPAID = 'N') THEN 'W'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' OR(p.C_Settlement_Cancel_ID IS NULL AND p.GENERATE_PROCESSED = 'Y' AND p.ISPAID = 'Y')) THEN 'A'" +
      "              ELSE 'P'" +
      "            END in ('P', 'A')" +
      "        AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE p.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID)" +
      "        AND 1=1";
    strSql = strSql + ((cBPartnerId==null || cBPartnerId.equals(""))?"":"  AND p.C_BPARTNER_ID = ?  ");
    strSql = strSql + ((paymentrule==null || paymentrule.equals(""))?"":"  AND p.PAYMENTRULE = ?  ");
    strSql = strSql + ((planneddateFrom==null || planneddateFrom.equals(""))?"":"  AND p.DATEPLANNED >= TO_DATE(?)  ");
    strSql = strSql + ((planneddateTo==null || planneddateTo.equals(""))?"":"  AND p.DATEPLANNED <= TO_DATE(?)  ");
    strSql = strSql + ((amountFrom==null || amountFrom.equals(""))?"":"  AND p.AMOUNT >= TO_NUMBER(?)  ");
    strSql = strSql + ((amountTo==null || amountTo.equals(""))?"":"  AND p.AMOUNT <= TO_NUMBER(?)  ");
    strSql = strSql + ((isreceipt==null || isreceipt.equals(""))?"":"  AND p.ISRECEIPT = ?  ");
    strSql = strSql + ((cBankaccountId==null || cBankaccountId.equals(""))?"":"  AND p.C_BankAccount_ID = ?  ");
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND p.AD_ORG_ID = ?  ");
    strSql = strSql + ((ischarge==null || ischarge.equals(""))?"":"  AND p.ISPAID = ?  ");
    strSql = strSql + ((isapproved==null || isapproved.equals(""))?"":"  AND p.ISAPPROVED = ?  ");
    strSql = strSql + ((invoice==null || invoice.equals(""))?"":"  AND EXISTS (SELECT 1 FROM C_INVOICE WHERE p.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID AND DOCUMENTNO LIKE TO_CHAR(?)) ");

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (userClient != null && !(userClient.equals(""))) {
        }
      if (userOrg != null && !(userOrg.equals(""))) {
        }
      if (cBPartnerId != null && !(cBPartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      }
      if (paymentrule != null && !(paymentrule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      }
      if (planneddateFrom != null && !(planneddateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateFrom);
      }
      if (planneddateTo != null && !(planneddateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddateTo);
      }
      if (amountFrom != null && !(amountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountFrom);
      }
      if (amountTo != null && !(amountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, amountTo);
      }
      if (isreceipt != null && !(isreceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreceipt);
      }
      if (cBankaccountId != null && !(cBankaccountId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      }
      if (ischarge != null && !(ischarge.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ischarge);
      }
      if (isapproved != null && !(isapproved.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      }
      if (invoice != null && !(invoice.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);
      }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static boolean NotIsReconcilied(Connection conn, ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*) AS COUNT" +
      "        FROM C_DEBT_Payment_v p" +
      "        WHERE p.C_Debt_Payment_ID = ?" +
      "        AND CASE" +
      "              WHEN (p.ISVALID = 'N') THEN 'I'" +
      "              WHEN (p.C_CASHLINE_ID IS NOT NULL OR p.C_BANKSTATEMENTLINE_ID IS NOT NULL) THEN 'C'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' AND p.ISPAID = 'N') THEN 'W'" +
      "              WHEN (p.CANCEL_PROCESSED = 'Y' OR(p.C_Settlement_Cancel_ID IS NULL AND p.GENERATE_PROCESSED = 'Y' AND p.ISPAID = 'Y')) THEN 'A'" +
      "              ELSE 'P'" +
      "            END IN ('P', 'A')" +
      "        AND NOT EXISTS (SELECT * FROM C_BankStatementLine l WHERE p.C_DEBT_Payment_ID=l.C_DEBT_PAYMENT_ID)";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(boolReturn);
  }

  public static String bpartner(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME FROM C_BPARTNER WHERE C_BPARTNER_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static String readable(ConnectionProvider connectionProvider, String cBankaccountId, String invoice)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT case when (select c_currency_id from c_bankaccount where c_bankaccount_id=?)=(select c_currency_id from c_invoice where c_invoice.documentno=?) then 'TRUE' else 'FALSE' end";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
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
Charge Amount can only occur in Pyments, not in Receipt
 */
  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cBankstatementlineId, String adClientId, String adUserId, String cBankstatementId, String statementdate, String cChargeAmt, String discountamt, String memo, String foreigncurrencyamt, String cPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_BankStatementLine" +
      "            (C_BankStatementLine_ID, AD_Client_ID,AD_Org_ID," +
      "            IsActive,Created,CreatedBy," +
      "            Updated,UpdatedBy, C_BankStatement_ID," +
      "            DateAcct,ValutaDate, Line," +
      "            C_Debt_Payment_ID, Description," +
      "            TrxAmt," +
      "            ChargeAmt," +
      "            C_Currency_ID," +
      "            discountamt, memo,foreigncurrencyamt)" +
      "        SELECT ?,?,p.AD_ORG_ID," +
      "               'Y', now(), ?," +
      "               now(), ?, ?," +
      "               TO_DATE(?), TO_DATE(?), (SELECT (COALESCE(Max(Line),0))+10 FROM C_BankStatementLine WHERE C_BankStatement_ID = ?)," +
      "               p.C_Debt_Payment_ID, Description," +
      "               p.Amount-coalesce(p.writeoffamt,0)-coalesce(p.discountamt,0)," +
      "               coalesce(case p.isreceipt when 'N' then to_number(?)*-1 else 0 end,0)," +
      "               (SELECT A.C_CURRENCY_ID" +
      "                  FROM C_BANKSTATEMENT S, C_BANKACCOUNT A" +
      "                  WHERE S.C_BANKACCOUNT_ID = A.C_BANKACCOUNT_ID" +
      "                  AND S.C_BankStatement_ID = ?)," +
      "               to_number(?), ?, case p.isreceipt when 'N' then to_number(?)*-1 else to_number(?) end" +
      "        FROM C_Debt_Payment_v p" +
      "        WHERE p.C_Debt_Payment_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, statementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discountamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, memo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, foreigncurrencyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentId);

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

  public static int insertSettlement(Connection conn, ConnectionProvider connectionProvider, String cSettlementId, String adUserId, String documentNo, String date, String cBankstatementlineId, String cPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    INSERT" +
      "    INTO C_SETTLEMENT" +
      "      (" +
      "        C_SETTLEMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "        CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        DOCUMENTNO, DATETRX, DATEACCT, SETTLEMENTTYPE," +
      "        C_DOCTYPE_ID, PROCESSING, PROCESSED, POSTED," +
      "        C_CURRENCY_ID, Description, ISGENERATED,bankstatementline" +
      "      )" +
      "        select ?, C_DEBT_PAYMENT.AD_CLIENT_ID, C_DEBT_PAYMENT.AD_Org_ID, 'Y'," +
      "        now(), ?, now(), ?," +
      "        '*DPS*'||?, TO_DATE(?), TO_DATE(?), 'C'," +
      "        (SELECT MIN(C_DOCTYPE_ID) FROM C_DOCTYPE" +
      "        WHERE DOCBASETYPE = 'STT' AND C_DOCTYPE.AD_CLIENT_ID = C_DEBT_PAYMENT.AD_CLIENT_ID" +
      "        AND AD_ORG_ID = '0'), 'N', 'N', 'N'," +
      "        C_DEBT_PAYMENT.C_CURRENCY_ID, COALESCE(C_DEBT_PAYMENT.DESCRIPTION, '(Splited) Nº ' || C_INVOICE.DOCUMENTNO), 'Y',?" +
      "        FROM C_DEBT_PAYMENT LEFT JOIN C_INVOICE ON C_DEBT_PAYMENT.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentId);

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

  public static int insertPayment(Connection conn, ConnectionProvider connectionProvider, String cDebtPaymentId, String adUserId, String cSettlementId, String amount, String cPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    INSERT" +
      "    INTO C_DEBT_PAYMENT" +
      "      (" +
      "        C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "        CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        ISRECEIPT, C_SETTLEMENT_GENERATE_ID, DESCRIPTION, " +
      "        C_BPARTNER_ID, C_CURRENCY_ID," +
      "        PAYMENTRULE, ISPAID, AMOUNT, WRITEOFFAMT,DISCOUNTAMT, DATEPLANNED," +
      "        ISMANUAL, ISVALID," +
      "        CHANGESETTLEMENTCANCEL, CANCEL_PROCESSED, GENERATE_PROCESSED, STATUS_INITIAL, C_INVOICE_ID" +
      "      )" +
      "      SELECT ?, C_DEBT_PAYMENT.AD_CLIENT_ID, C_DEBT_PAYMENT.AD_ORG_ID, C_DEBT_PAYMENT.ISACTIVE," +
      "        NOW(), ?, NOW(), ?," +
      "        C_DEBT_PAYMENT.ISRECEIPT, ?, COALESCE(C_DEBT_PAYMENT.DESCRIPTION, '(Splited) Nº ' || C_INVOICE.DOCUMENTNO), " +
      "        C_DEBT_PAYMENT.C_BPARTNER_ID, C_DEBT_PAYMENT.C_CURRENCY_ID," +
      "        C_DEBT_PAYMENT.PAYMENTRULE, C_DEBT_PAYMENT.ISPAID, TO_NUMBER(?), C_DEBT_PAYMENT.WRITEOFFAMT, 0,C_DEBT_PAYMENT.DATEPLANNED," +
      "        'N', 'N'," +
      "        'N', 'N', 'N', STATUS, C_DEBT_PAYMENT.C_INVOICE_ID" +
      "        FROM C_DEBT_PAYMENT LEFT JOIN C_INVOICE ON C_DEBT_PAYMENT.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentId);

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

  public static int insertSecondPayment(Connection conn, ConnectionProvider connectionProvider, String adUserId, String cSettlementId, String amount, String discount, String cPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    INSERT" +
      "    INTO C_DEBT_PAYMENT" +
      "      (" +
      "        C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "        CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        ISRECEIPT, C_SETTLEMENT_GENERATE_ID, DESCRIPTION, " +
      "        C_BPARTNER_ID, C_CURRENCY_ID," +
      "        PAYMENTRULE, ISPAID, AMOUNT, WRITEOFFAMT, DATEPLANNED," +
      "        ISMANUAL, ISVALID," +
      "        CHANGESETTLEMENTCANCEL, CANCEL_PROCESSED, GENERATE_PROCESSED, STATUS_INITIAL,C_INVOICE_ID" +
      "      )" +
      "      SELECT get_uuid(), C_DEBT_PAYMENT.AD_CLIENT_ID, C_DEBT_PAYMENT.AD_ORG_ID, C_DEBT_PAYMENT.ISACTIVE," +
      "        NOW(), ?, NOW(), ?," +
      "        C_DEBT_PAYMENT.ISRECEIPT, ?, COALESCE(C_DEBT_PAYMENT.DESCRIPTION, '(Splited) Nº ' || C_INVOICE.DOCUMENTNO), " +
      "        C_DEBT_PAYMENT.C_BPARTNER_ID, C_DEBT_PAYMENT.C_CURRENCY_ID," +
      "        C_DEBT_PAYMENT.PAYMENTRULE, C_DEBT_PAYMENT.ISPAID, C_DEBT_PAYMENT.AMOUNT-COALESCE(TO_NUMBER(?),0)-COALESCE(TO_NUMBER(?),0), C_DEBT_PAYMENT.WRITEOFFAMT, C_DEBT_PAYMENT.DATEPLANNED," +
      "        'N', 'N'," +
      "        'N', 'N', 'N', C_DEBT_PAYMENT.STATUS,C_DEBT_PAYMENT.C_INVOICE_ID" +
      "        FROM C_DEBT_PAYMENT LEFT JOIN C_INVOICE ON C_DEBT_PAYMENT.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentId);

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

  public static int insertDiscountPayment(Connection conn, ConnectionProvider connectionProvider, String adUserId, String cSettlementId, String cNewSettlementId, String discount, String cPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    INSERT" +
      "    INTO C_DEBT_PAYMENT" +
      "      (" +
      "        C_DEBT_PAYMENT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "        CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        ISRECEIPT, C_SETTLEMENT_GENERATE_ID,c_settlement_cancel_id, DESCRIPTION, " +
      "        C_BPARTNER_ID, C_CURRENCY_ID," +
      "        PAYMENTRULE, ISPAID, AMOUNT, DISCOUNTAMT, DATEPLANNED," +
      "        ISMANUAL, ISVALID," +
      "        CHANGESETTLEMENTCANCEL, CANCEL_PROCESSED, GENERATE_PROCESSED, STATUS_INITIAL,c_invoice_id" +
      "      )" +
      "      SELECT get_uuid(), C_DEBT_PAYMENT.AD_CLIENT_ID, C_DEBT_PAYMENT.AD_ORG_ID, C_DEBT_PAYMENT.ISACTIVE," +
      "        NOW(), ?, NOW(), ?," +
      "        C_DEBT_PAYMENT.ISRECEIPT, ?,?, COALESCE(C_DEBT_PAYMENT.DESCRIPTION, '(Splited) Nº ' || C_INVOICE.DOCUMENTNO), " +
      "        C_DEBT_PAYMENT.C_BPARTNER_ID, C_DEBT_PAYMENT.C_CURRENCY_ID," +
      "        C_DEBT_PAYMENT.PAYMENTRULE, C_DEBT_PAYMENT.ISPAID, TO_NUMBER(?),TO_NUMBER(?), C_DEBT_PAYMENT.DATEPLANNED," +
      "        'N', 'Y'," +
      "        'N', 'N', 'Y', C_DEBT_PAYMENT.STATUS,C_DEBT_PAYMENT.c_invoice_id" +
      "        FROM C_DEBT_PAYMENT LEFT JOIN C_INVOICE ON C_DEBT_PAYMENT.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cNewSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymentId);

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

  public static int cancelOriginalPayment(Connection conn, ConnectionProvider connectionProvider, String cSettlementId, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_DEBT_PAYMENT SET C_SETTLEMENT_CANCEL_ID = ?, ISVALID = 'Y'" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

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

  public static String selectPaymentFinalAmount(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AMOUNT-COALESCE(WRITEOFFAMT,0)-COALESCE(DISCOUNTAMT,0) as FINALAMOUNT FROM C_DEBT_PAYMENT" +
      "        WHERE C_DEBT_PAYMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "finalamount");
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

  public static CreateFromBankData processSettlement(Connection conn, ConnectionProvider connectionProvider, String cSettlementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_SETTLEMENT_POST(NULL,?)";

    CreateFromBankData objectCreateFromBankData = new CreateFromBankData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSettlementId);

      st.execute();
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
      parametersData.addElement(cSettlementId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
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
    return(objectCreateFromBankData);
  }
}
