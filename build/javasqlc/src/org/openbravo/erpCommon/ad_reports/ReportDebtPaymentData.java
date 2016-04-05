//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportDebtPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportDebtPaymentData.class);
  private String InitRecordNumber="0";
  public String bankacc;
  public String accountstr;
  public String cInvoiceId;
  public String cDebtPaymentId;
  public String bpartner;
  public String invoice;
  public String dateplanned;
  public String amount;
  public String writeoffamt;
  public String currency;
  public String updated;
  public String updatedby;
  public String debtcancel;
  public String debtgenerate;
  public String paymentrule;
  public String status;
  public String isapproved;
  public String appby;
  public String approvaldisabled;
  public String description;
  public String ispaid;
  public String invoiceType;
  public String path;
  public String dpstatus;
  public String salesrepname;
  public String project;
  public String org;
  public String idate;
  public String grandtotal;
  public String debtgenerate2;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("bankacc"))
      return bankacc;
    else if (fieldName.equalsIgnoreCase("accountstr"))
      return accountstr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_debt_payment_id") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("bpartner"))
      return bpartner;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("dateplanned"))
      return dateplanned;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("writeoffamt"))
      return writeoffamt;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("debtcancel"))
      return debtcancel;
    else if (fieldName.equalsIgnoreCase("debtgenerate"))
      return debtgenerate;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("isapproved"))
      return isapproved;
    else if (fieldName.equalsIgnoreCase("appby"))
      return appby;
    else if (fieldName.equalsIgnoreCase("approvaldisabled"))
      return approvaldisabled;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("invoice_type") || fieldName.equals("invoiceType"))
      return invoiceType;
    else if (fieldName.equalsIgnoreCase("path"))
      return path;
    else if (fieldName.equalsIgnoreCase("dpstatus"))
      return dpstatus;
    else if (fieldName.equalsIgnoreCase("salesrepname"))
      return salesrepname;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("idate"))
      return idate;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("debtgenerate2"))
      return debtgenerate2;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportDebtPaymentData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String isSettle, String cbankaccount, String salesrepId, String appby, String ord)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, cBpartnerId, dateFrom, dateTo, AmountFrom, AmountTo, paymentRule, isReceipt, status, isSettle, cbankaccount, salesrepId, appby, ord, 0, 0);
  }

  public static ReportDebtPaymentData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String isSettle, String cbankaccount, String salesrepId, String appby, String ord, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (BANK.NAME || '/' || coalesce(BANK.swiftcode,bank.codebank) || coalesce(ba.iban,ba.accountno)) AS BANKACC," +
      "      (CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE " +
      "          CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE " +
      "                  CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END) as ACCOUNTSTR," +
      "      (CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END) AS C_INVOICE_ID, (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END) AS C_DEBT_PAYMENT_ID, B.NAME AS BPARTNER, (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END) AS INVOICE, DP.DATEPLANNED," +
      "DP.AMOUNT, DP.WRITEOFFAMT, C.ISO_CODE AS CURRENCY, DP.Updated, DP.Updatedby," +
      "(CASE WHEN S1.DOCUMENTNO IS NOT NULL THEN S1.DOCUMENTNO||' ('||S1.DATETRX||')' ELSE  case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?)  END END) AS DEBTCANCEL," +
      "(CASE WHEN S2.DOCUMENTNO IS NOT NULL THEN S2.DOCUMENTNO||' ('||S2.DATETRX||')' END) AS DEBTGENERATE, COALESCE(RLT.NAME, RL.NAME) AS PAYMENTRULE," +
      "      (CASE C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID, " +
      "      DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) WHEN 'I' THEN AD_MESSAGE_GET2('DPR_INVALID',?) WHEN 'C' THEN AD_MESSAGE_GET2('DPR_CONCILIATED',?) WHEN 'W' THEN AD_MESSAGE_GET2('DPR_CANCELLED',?) WHEN 'A' THEN AD_MESSAGE_GET2('DPR_SETTLE',?) WHEN " +
      "      'P' THEN case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?) else AD_MESSAGE_GET2('DPR_PENDING',?) END END) AS STATUS, " +
      "      DP.isapproved, (CASE DP.isapproved WHEN 'Y' THEN (TO_CHAR(DP.UPDATED,'DD.MM.YYYY')||' '||(SELECT name from ad_user where ad_user_id=DP.APPROVEDBY)) ELSE (' ') END) AS appby," +
      "      I.issotrx as approvaldisabled," +
      "      DP.DESCRIPTION, AD_MESSAGE_GET2(DP.ISPAID, ?) AS ISPAID, " +
      "      (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END) AS INVOICE_TYPE, " +
      "      (CASE s2.SETTLEMENTTYPE WHEN 'I' THEN '../ManualSettlement/CreatePayment_Relation.html' ELSE '../Settlement/CreatedPayments_Relation.html' END) AS PATH, COALESCE(RLT2.NAME, RL2.NAME) AS DPSTATUS, URS.NAME AS SALESREPNAME," +
      "      zssi_getprojectorcostcentername(i.c_project_id,i.a_asset_id) as PROJECT," +
      "      zssi_getshortorg(I.ad_org_id) as ORG," +
      "      I.Dateinvoiced as IDATE," +
      "      '' as grandtotal," +
      "      '' as debtgenerate2" +
      "      FROM C_DEBT_PAYMENT DP left join C_SETTLEMENT S1 on DP.C_SETTLEMENT_CANCEL_ID = S1.C_SETTLEMENT_ID" +
      "                             left join C_SETTLEMENT S2 on DP.C_SETTLEMENT_GENERATE_ID = S2.C_SETTLEMENT_ID" +
      "                             left join C_BPARTNER B    on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "                             left join C_BANKACCOUNT BA on DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                             left join C_BANK BANK ON BA.C_BANK_ID = BANK.C_BANK_ID" +
      "                             left join C_INVOICE I     on DP.C_INVOICE_ID = I.C_INVOICE_ID left join AD_USER URS on I.SALESREP_ID = URS.AD_USER_ID," +
      "           AD_REF_LIST RL    left join AD_REF_LIST_TRL RLT on RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID" +
      "                                                              AND RLT.AD_LANGUAGE = ?," +
      "           AD_REF_LIST RL2    left join AD_REF_LIST_TRL RLT2 on RL2.AD_REF_LIST_ID = RLT2.AD_REF_LIST_ID" +
      "                                                              AND RLT2.AD_LANGUAGE = ?," +
      "           C_CURRENCY C" +
      "      WHERE DP.C_CURRENCY_ID = C.C_CURRENCY_ID " +
      "      AND DP.PAYMENTRULE = RL.VALUE" +
      "      AND RL.AD_REFERENCE_ID = '195'" +
      "      AND DP.STATUS = RL2.VALUE" +
      "      AND RL2.AD_REFERENCE_ID = '800070'" +
      "      AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND DP.IsActive='Y'" +
      "      AND DP.IsValid='Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND dp.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < to_date(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt=?  ");
    strSql = strSql + ((status==null || status.equals(""))?"":"  AND dp.status=?  ");
    strSql = strSql + ((isSettle==null || isSettle.equals(""))?"":" AND C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID,        DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) IN" + isSettle);
    strSql = strSql + ((cbankaccount==null || cbankaccount.equals(""))?"":"  AND DP.C_BANKACCOUNT_ID = ?  ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":"  AND URS.AD_USER_ID = ?  ");
    strSql = strSql + ((appby==null || appby.equals(""))?"":"  AND DP.APPROVEDBY = ? AND DP.isapproved = 'Y' ");
    strSql = strSql + 
      "      GROUP BY bank.name,bank.swiftcode,bank.codebank,ba.iban,ba.accountno,i.c_project_id,i.a_asset_id,I.ad_org_id,I.Dateinvoiced,DP.UPDATED, DP.UPDATEDBY,DP.APPROVEDBY, (BANK.NAME || '/' || BANK.CODEBRANCH || BANK.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL),(CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END)," +
      "      CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END, (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END), B.NAME, (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END), DP.DATEPLANNED, DP.AMOUNT," +
      "      DP.WRITEOFFAMT, C.ISO_CODE, S1.DOCUMENTNO ,S1.DATETRX, S2.DOCUMENTNO,S2.DATETRX, RLT.NAME, RL.NAME, RLT2.NAME, RL2.NAME, DP.C_Settlement_Cancel_ID," +
      "      DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.isapproved,I.issotrx,i.c_dunning_id,DP.ISPAID, DP.ISVALID, DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID, DP.DESCRIPTION, (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END),s2.SETTLEMENTTYPE, DP.STATUS, URS.NAME" +
      "      ORDER BY ";
    strSql = strSql + ((ord==null || ord.equals(""))?"":ord);
    strSql = strSql + 
      ",STATUS, DP.DATEPLANNED";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (status != null && !(status.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      }
      if (isSettle != null && !(isSettle.equals(""))) {
        }
      if (cbankaccount != null && !(cbankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbankaccount);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (appby != null && !(appby.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, appby);
      }
      if (ord != null && !(ord.equals(""))) {
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
        ReportDebtPaymentData objectReportDebtPaymentData = new ReportDebtPaymentData();
        objectReportDebtPaymentData.bankacc = UtilSql.getValue(result, "bankacc");
        objectReportDebtPaymentData.accountstr = UtilSql.getValue(result, "accountstr");
        objectReportDebtPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportDebtPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportDebtPaymentData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportDebtPaymentData.invoice = UtilSql.getValue(result, "invoice");
        objectReportDebtPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportDebtPaymentData.amount = UtilSql.getValue(result, "amount");
        objectReportDebtPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectReportDebtPaymentData.currency = UtilSql.getValue(result, "currency");
        objectReportDebtPaymentData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectReportDebtPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportDebtPaymentData.debtcancel = UtilSql.getValue(result, "debtcancel");
        objectReportDebtPaymentData.debtgenerate = UtilSql.getValue(result, "debtgenerate");
        objectReportDebtPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportDebtPaymentData.status = UtilSql.getValue(result, "status");
        objectReportDebtPaymentData.isapproved = UtilSql.getValue(result, "isapproved");
        objectReportDebtPaymentData.appby = UtilSql.getValue(result, "appby");
        objectReportDebtPaymentData.approvaldisabled = UtilSql.getValue(result, "approvaldisabled");
        objectReportDebtPaymentData.description = UtilSql.getValue(result, "description");
        objectReportDebtPaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportDebtPaymentData.invoiceType = UtilSql.getValue(result, "invoice_type");
        objectReportDebtPaymentData.path = UtilSql.getValue(result, "path");
        objectReportDebtPaymentData.dpstatus = UtilSql.getValue(result, "dpstatus");
        objectReportDebtPaymentData.salesrepname = UtilSql.getValue(result, "salesrepname");
        objectReportDebtPaymentData.project = UtilSql.getValue(result, "project");
        objectReportDebtPaymentData.org = UtilSql.getValue(result, "org");
        objectReportDebtPaymentData.idate = UtilSql.getDateValue(result, "idate", "dd-MM-yyyy");
        objectReportDebtPaymentData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectReportDebtPaymentData.debtgenerate2 = UtilSql.getValue(result, "debtgenerate2");
        objectReportDebtPaymentData.rownum = Long.toString(countRecord);
        objectReportDebtPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportDebtPaymentData);
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
    ReportDebtPaymentData objectReportDebtPaymentData[] = new ReportDebtPaymentData[vector.size()];
    vector.copyInto(objectReportDebtPaymentData);
    return(objectReportDebtPaymentData);
  }

  public static ReportDebtPaymentData[] selectReport(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String cbankaccount, String salesrepId, String appby, String includepaid, String ord)    throws ServletException {
    return selectReport(connectionProvider, adLanguage, adUserClient, adUserOrg, cBpartnerId, dateFrom, dateTo, AmountFrom, AmountTo, paymentRule, isReceipt, status, cbankaccount, salesrepId, appby, includepaid, ord, 0, 0);
  }

  public static ReportDebtPaymentData[] selectReport(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String cbankaccount, String salesrepId, String appby, String includepaid, String ord, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT (BANK.NAME || '/' || BANK.swiftcode || coalesce(ba.iban,ba.accountno)) AS BANKACC," +
      "      (CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE " +
      "          CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE " +
      "                  CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END) as ACCOUNTSTR," +
      "      (CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END) AS C_INVOICE_ID," +
      "       (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END) AS C_DEBT_PAYMENT_ID," +
      "        B.NAME AS BPARTNER," +
      "         (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO END) AS INVOICE," +
      "          DP.DATEPLANNED," +
      "      i.grandtotal as amount," +
      "       i.WRITEOFFAMT," +
      "        C.ISO_CODE AS CURRENCY," +
      "         DP.Updated, DP.Updatedby," +
      "      (i.totalpaid) AS DEBTCANCEL," +
      "      (case when  i.ispaid='N' then i.grandtotal-i.WRITEOFFAMT-i.totalpaid else 0 end) AS DEBTGENERATE," +
      "       COALESCE(RLT.NAME, RL.NAME) AS PAYMENTRULE," +
      "      (CASE C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, i.ISPAID, DP.ISVALID, " +
      "      DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) WHEN 'I' THEN AD_MESSAGE_GET2('DPR_INVALID',?) WHEN 'C' THEN AD_MESSAGE_GET2('DPR_CONCILIATED',?) WHEN 'W' THEN AD_MESSAGE_GET2('DPR_CANCELLED',?) WHEN 'A' THEN AD_MESSAGE_GET2('DPR_SETTLE',?) WHEN " +
      "      'P' THEN  case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?) else  AD_MESSAGE_GET2('DPR_PENDING',?) END END) AS STATUS, " +
      "      DP.isapproved, (CASE DP.isapproved WHEN 'Y' THEN (TO_CHAR(DP.UPDATED,'DD.MM.YYYY')||' '||(SELECT name from ad_user where ad_user_id=DP.APPROVEDBY)) ELSE (' ') END) AS appby," +
      "      I.issotrx as approvaldisabled," +
      "      DP.DESCRIPTION, AD_MESSAGE_GET2(i.ISPAID, ?) AS ISPAID, " +
      "      (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END) AS INVOICE_TYPE, " +
      "      COALESCE(RLT2.NAME, RL2.NAME) AS DPSTATUS, URS.NAME AS SALESREPNAME," +
      "      zssi_getprojectorcostcentername(i.c_project_id,i.a_asset_id) as PROJECT," +
      "      zssi_getshortorg(I.ad_org_id) as ORG," +
      "      I.Dateinvoiced as IDATE" +
      "      FROM C_DEBT_PAYMENT DP left join C_BPARTNER B    on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "                             left join C_BANKACCOUNT BA on DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                             left join C_BANK BANK ON BA.C_BANK_ID = BANK.C_BANK_ID" +
      "                             left join C_INVOICE I     on DP.C_INVOICE_ID = I.C_INVOICE_ID left join AD_USER URS on I.SALESREP_ID = URS.AD_USER_ID," +
      "           AD_REF_LIST RL    left join AD_REF_LIST_TRL RLT on RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID" +
      "                                                              AND RLT.AD_LANGUAGE = ?," +
      "           AD_REF_LIST RL2    left join AD_REF_LIST_TRL RLT2 on RL2.AD_REF_LIST_ID = RLT2.AD_REF_LIST_ID" +
      "                                                              AND RLT2.AD_LANGUAGE = ?," +
      "           C_CURRENCY C" +
      "      WHERE DP.C_CURRENCY_ID = C.C_CURRENCY_ID " +
      "      AND DP.PAYMENTRULE = RL.VALUE" +
      "      AND RL.AD_REFERENCE_ID = '195'" +
      "      AND DP.STATUS = RL2.VALUE" +
      "      AND RL2.AD_REFERENCE_ID = '800070'" +
      "      AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND DP.IsActive='Y'" +
      "      AND DP.IsValid='Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND dp.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < to_date(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt=?  ");
    strSql = strSql + ((status==null || status.equals(""))?"":"  AND dp.status=?  ");
    strSql = strSql + ((cbankaccount==null || cbankaccount.equals(""))?"":"  AND DP.C_BANKACCOUNT_ID = ?  ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":"  AND URS.AD_USER_ID = ?  ");
    strSql = strSql + ((appby==null || appby.equals(""))?"":"  AND DP.APPROVEDBY = ? AND DP.isapproved = 'Y' ");
    strSql = strSql + 
      "      AND DP.generate_processed='N'" +
      "      AND I.ISPAID IN (";
    strSql = strSql + ((includepaid==null || includepaid.equals(""))?"":includepaid);
    strSql = strSql + 
      ")" +
      "      GROUP BY bank.name,i.ispaid,bank.swiftcode,bank.codebank,ba.iban,ba.accountno,i.grandtotal,i.writeoffamt,i.totalpaid,i.documentno, dp.c_debt_payment_id,i.dateinvoiced,i.ad_org_id,I.C_PROJECT_ID,i.a_asset_id,DP.UPDATED, DP.UPDATEDBY, DP.APPROVEDBY,(BANK.NAME || '/' || BANK.CODEBRANCH || BANK.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL),(CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END)," +
      "      CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END, (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END), B.NAME, (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END), DP.DATEPLANNED, DP.AMOUNT," +
      "      DP.WRITEOFFAMT, C.ISO_CODE, RLT.NAME, RL.NAME, RLT2.NAME, RL2.NAME, DP.C_Settlement_Cancel_ID," +
      "      DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.isapproved,I.issotrx,i.c_dunning_id,DP.ISPAID, DP.ISVALID, DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID, DP.DESCRIPTION, (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END), DP.STATUS, URS.NAME" +
      "      ORDER BY ";
    strSql = strSql + ((ord==null || ord.equals(""))?"":ord);
    strSql = strSql + 
      ",STATUS, DP.DATEPLANNED,i.documentno";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (status != null && !(status.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      }
      if (cbankaccount != null && !(cbankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbankaccount);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (appby != null && !(appby.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, appby);
      }
      if (includepaid != null && !(includepaid.equals(""))) {
        }
      if (ord != null && !(ord.equals(""))) {
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
        ReportDebtPaymentData objectReportDebtPaymentData = new ReportDebtPaymentData();
        objectReportDebtPaymentData.bankacc = UtilSql.getValue(result, "bankacc");
        objectReportDebtPaymentData.accountstr = UtilSql.getValue(result, "accountstr");
        objectReportDebtPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportDebtPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportDebtPaymentData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportDebtPaymentData.invoice = UtilSql.getValue(result, "invoice");
        objectReportDebtPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportDebtPaymentData.amount = UtilSql.getValue(result, "amount");
        objectReportDebtPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectReportDebtPaymentData.currency = UtilSql.getValue(result, "currency");
        objectReportDebtPaymentData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectReportDebtPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportDebtPaymentData.debtcancel = UtilSql.getValue(result, "debtcancel");
        objectReportDebtPaymentData.debtgenerate = UtilSql.getValue(result, "debtgenerate");
        objectReportDebtPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportDebtPaymentData.status = UtilSql.getValue(result, "status");
        objectReportDebtPaymentData.isapproved = UtilSql.getValue(result, "isapproved");
        objectReportDebtPaymentData.appby = UtilSql.getValue(result, "appby");
        objectReportDebtPaymentData.approvaldisabled = UtilSql.getValue(result, "approvaldisabled");
        objectReportDebtPaymentData.description = UtilSql.getValue(result, "description");
        objectReportDebtPaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportDebtPaymentData.invoiceType = UtilSql.getValue(result, "invoice_type");
        objectReportDebtPaymentData.dpstatus = UtilSql.getValue(result, "dpstatus");
        objectReportDebtPaymentData.salesrepname = UtilSql.getValue(result, "salesrepname");
        objectReportDebtPaymentData.project = UtilSql.getValue(result, "project");
        objectReportDebtPaymentData.org = UtilSql.getValue(result, "org");
        objectReportDebtPaymentData.idate = UtilSql.getDateValue(result, "idate", "dd-MM-yyyy");
        objectReportDebtPaymentData.rownum = Long.toString(countRecord);
        objectReportDebtPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportDebtPaymentData);
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
    ReportDebtPaymentData objectReportDebtPaymentData[] = new ReportDebtPaymentData[vector.size()];
    vector.copyInto(objectReportDebtPaymentData);
    return(objectReportDebtPaymentData);
  }

  public static ReportDebtPaymentData[] selectReportNoBPartner(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String cbankaccount, String salesrepId, String appby, String includepaid, String ord)    throws ServletException {
    return selectReportNoBPartner(connectionProvider, adLanguage, adUserClient, adUserOrg, cBpartnerId, dateFrom, dateTo, AmountFrom, AmountTo, paymentRule, isReceipt, status, cbankaccount, salesrepId, appby, includepaid, ord, 0, 0);
  }

  public static ReportDebtPaymentData[] selectReportNoBPartner(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String cbankaccount, String salesrepId, String appby, String includepaid, String ord, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT (BANK.NAME || '/' || BANK.swiftcode || coalesce(ba.iban,ba.accountno)) AS BANKACC," +
      "      (CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE " +
      "          CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE " +
      "                  CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END) as ACCOUNTSTR," +
      "      (CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END) AS C_INVOICE_ID," +
      "       (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END) AS C_DEBT_PAYMENT_ID," +
      "        B.NAME AS BPARTNER," +
      "         (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO END) AS INVOICE," +
      "          DP.DATEPLANNED," +
      "      i.grandtotal as amount," +
      "       i.WRITEOFFAMT," +
      "        C.ISO_CODE AS CURRENCY," +
      "         DP.Updated, DP.Updatedby," +
      "      (i.totalpaid) AS DEBTCANCEL," +
      "      (case when  i.ispaid='N' then i.grandtotal-i.WRITEOFFAMT-i.totalpaid else 0 end) AS DEBTGENERATE," +
      "       COALESCE(RLT.NAME, RL.NAME) AS PAYMENTRULE," +
      "      (CASE C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, i.ISPAID, DP.ISVALID, " +
      "      DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) WHEN 'I' THEN AD_MESSAGE_GET2('DPR_INVALID',?) WHEN 'C' THEN AD_MESSAGE_GET2('DPR_CONCILIATED',?) WHEN 'W' THEN AD_MESSAGE_GET2('DPR_CANCELLED',?) WHEN 'A' THEN AD_MESSAGE_GET2('DPR_SETTLE',?) WHEN " +
      "      'P' THEN  case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?) else AD_MESSAGE_GET2('DPR_PENDING',?) END END) AS STATUS, " +
      "      DP.isapproved, (CASE DP.isapproved WHEN 'Y' THEN (TO_CHAR(DP.UPDATED,'DD.MM.YYYY')||' '||(SELECT name from ad_user where ad_user_id=DP.APPROVEDBY)) ELSE (' ') END) AS appby," +
      "      I.issotrx as approvaldisabled," +
      "      DP.DESCRIPTION, AD_MESSAGE_GET2(i.ISPAID, ?) AS ISPAID, " +
      "      (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END) AS INVOICE_TYPE, " +
      "      COALESCE(RLT2.NAME, RL2.NAME) AS DPSTATUS, URS.NAME AS SALESREPNAME," +
      "      zssi_getprojectorcostcentername(i.c_project_id,i.a_asset_id) as PROJECT," +
      "      zssi_getshortorg(I.ad_org_id) as ORG," +
      "      I.Dateinvoiced as IDATE" +
      "      FROM C_DEBT_PAYMENT DP left join C_BPARTNER B    on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "                             left join C_BANKACCOUNT BA on DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                             left join C_BANK BANK ON BA.C_BANK_ID = BANK.C_BANK_ID" +
      "                             left join C_INVOICE I     on DP.C_INVOICE_ID = I.C_INVOICE_ID left join AD_USER URS on I.SALESREP_ID = URS.AD_USER_ID," +
      "           AD_REF_LIST RL    left join AD_REF_LIST_TRL RLT on RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID" +
      "                                                              AND RLT.AD_LANGUAGE = ?," +
      "           AD_REF_LIST RL2    left join AD_REF_LIST_TRL RLT2 on RL2.AD_REF_LIST_ID = RLT2.AD_REF_LIST_ID" +
      "                                                              AND RLT2.AD_LANGUAGE = ?," +
      "           C_CURRENCY C" +
      "      WHERE DP.C_CURRENCY_ID = C.C_CURRENCY_ID " +
      "      AND DP.PAYMENTRULE = RL.VALUE" +
      "      AND RL.AD_REFERENCE_ID = '195'" +
      "      AND DP.STATUS = RL2.VALUE" +
      "      AND RL2.AD_REFERENCE_ID = '800070'" +
      "      AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND DP.IsActive='Y'" +
      "      AND DP.IsValid='Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND dp.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < to_date(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt=?  ");
    strSql = strSql + ((status==null || status.equals(""))?"":"  AND dp.status=?  ");
    strSql = strSql + ((cbankaccount==null || cbankaccount.equals(""))?"":"  AND DP.C_BANKACCOUNT_ID = ?  ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":"  AND URS.AD_USER_ID = ?  ");
    strSql = strSql + ((appby==null || appby.equals(""))?"":"  AND DP.APPROVEDBY = ? AND DP.isapproved = 'Y' ");
    strSql = strSql + 
      "      AND DP.generate_processed='N'" +
      "      AND I.ISPAID IN (";
    strSql = strSql + ((includepaid==null || includepaid.equals(""))?"":includepaid);
    strSql = strSql + 
      ")" +
      "      GROUP BY bank.name,i.ispaid,bank.swiftcode,bank.codebank,ba.iban,ba.accountno,i.grandtotal,i.writeoffamt,i.totalpaid,i.documentno, dp.c_debt_payment_id,i.dateinvoiced,i.ad_org_id,I.C_PROJECT_ID,i.a_asset_id,DP.UPDATED, DP.UPDATEDBY, DP.APPROVEDBY, (BANK.NAME || '/' || BANK.CODEBRANCH || BANK.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL),(CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END)," +
      "      CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END, (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END), B.NAME, (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END), DP.DATEPLANNED, DP.AMOUNT," +
      "      DP.WRITEOFFAMT, C.ISO_CODE, RLT.NAME, RL.NAME, RLT2.NAME, RL2.NAME, DP.C_Settlement_Cancel_ID," +
      "      DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.isapproved,I.issotrx,i.c_dunning_id,DP.ISPAID, DP.ISVALID, DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID, DP.DESCRIPTION, (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END), DP.STATUS, URS.NAME" +
      "      ORDER BY ";
    strSql = strSql + ((ord==null || ord.equals(""))?"":ord);
    strSql = strSql + 
      ",STATUS, DP.DATEPLANNED,i.documentno";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (status != null && !(status.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      }
      if (cbankaccount != null && !(cbankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbankaccount);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (appby != null && !(appby.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, appby);
      }
      if (includepaid != null && !(includepaid.equals(""))) {
        }
      if (ord != null && !(ord.equals(""))) {
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
        ReportDebtPaymentData objectReportDebtPaymentData = new ReportDebtPaymentData();
        objectReportDebtPaymentData.bankacc = UtilSql.getValue(result, "bankacc");
        objectReportDebtPaymentData.accountstr = UtilSql.getValue(result, "accountstr");
        objectReportDebtPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportDebtPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportDebtPaymentData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportDebtPaymentData.invoice = UtilSql.getValue(result, "invoice");
        objectReportDebtPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportDebtPaymentData.amount = UtilSql.getValue(result, "amount");
        objectReportDebtPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectReportDebtPaymentData.currency = UtilSql.getValue(result, "currency");
        objectReportDebtPaymentData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectReportDebtPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportDebtPaymentData.debtcancel = UtilSql.getValue(result, "debtcancel");
        objectReportDebtPaymentData.debtgenerate = UtilSql.getValue(result, "debtgenerate");
        objectReportDebtPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportDebtPaymentData.status = UtilSql.getValue(result, "status");
        objectReportDebtPaymentData.isapproved = UtilSql.getValue(result, "isapproved");
        objectReportDebtPaymentData.appby = UtilSql.getValue(result, "appby");
        objectReportDebtPaymentData.approvaldisabled = UtilSql.getValue(result, "approvaldisabled");
        objectReportDebtPaymentData.description = UtilSql.getValue(result, "description");
        objectReportDebtPaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportDebtPaymentData.invoiceType = UtilSql.getValue(result, "invoice_type");
        objectReportDebtPaymentData.dpstatus = UtilSql.getValue(result, "dpstatus");
        objectReportDebtPaymentData.salesrepname = UtilSql.getValue(result, "salesrepname");
        objectReportDebtPaymentData.project = UtilSql.getValue(result, "project");
        objectReportDebtPaymentData.org = UtilSql.getValue(result, "org");
        objectReportDebtPaymentData.idate = UtilSql.getDateValue(result, "idate", "dd-MM-yyyy");
        objectReportDebtPaymentData.rownum = Long.toString(countRecord);
        objectReportDebtPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportDebtPaymentData);
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
    ReportDebtPaymentData objectReportDebtPaymentData[] = new ReportDebtPaymentData[vector.size()];
    vector.copyInto(objectReportDebtPaymentData);
    return(objectReportDebtPaymentData);
  }

  public static ReportDebtPaymentData[] selectNoBpartner(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String isSettle, String cbankaccount, String salesrepId, String appby, String ord)    throws ServletException {
    return selectNoBpartner(connectionProvider, adLanguage, adUserClient, adUserOrg, cBpartnerId, dateFrom, dateTo, AmountFrom, AmountTo, paymentRule, isReceipt, status, isSettle, cbankaccount, salesrepId, appby, ord, 0, 0);
  }

  public static ReportDebtPaymentData[] selectNoBpartner(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String cBpartnerId, String dateFrom, String dateTo, String AmountFrom, String AmountTo, String paymentRule, String isReceipt, String status, String isSettle, String cbankaccount, String salesrepId, String appby, String ord, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (BANK.NAME || '/' || BANK.CODEBRANCH || BANK.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL) AS BANKACC," +
      "      (CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE " +
      "          CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE " +
      "                  CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END) AS ACCOUNTSTR," +
      "      (CASE WHEN I.C_INVOICE_ID IS NULL THEN '0' ELSE I.C_INVOICE_ID END) AS C_INVOICE_ID," +
      "      (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END) AS C_DEBT_PAYMENT_ID," +
      "      B.NAME AS BPARTNER," +
      "      (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END) AS INVOICE," +
      "      DP.DATEPLANNED," +
      "      DP.AMOUNT," +
      "      DP.WRITEOFFAMT," +
      "      C.ISO_CODE AS CURRENCY," +
      "      (CASE WHEN S1.DOCUMENTNO IS NOT NULL THEN S1.DOCUMENTNO||' ('||S1.DATETRX||')' ELSE  case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?)  END END)  AS DEBTCANCEL," +
      "      (CASE WHEN S2.DOCUMENTNO IS NOT NULL THEN S2.DOCUMENTNO||' ('||S2.DATETRX||')' END) AS DEBTGENERATE," +
      "      COALESCE(RLT.NAME, RL.NAME) AS PAYMENTRULE," +
      "      (CASE C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID, " +
      "      DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) WHEN 'I' THEN AD_MESSAGE_GET2('DPR_INVALID',?) WHEN 'C' THEN AD_MESSAGE_GET2('DPR_CONCILIATED',?) WHEN 'W' THEN AD_MESSAGE_GET2('DPR_CANCELLED',?) WHEN 'A' THEN AD_MESSAGE_GET2('DPR_SETTLE',?) WHEN " +
      "      'P' THEN case when i.c_dunning_id is not null then C_DUNNING_STATUS(i.c_dunning_id , ?) else AD_MESSAGE_GET2('DPR_PENDING',?) END END) AS STATUS," +
      "      DP.DESCRIPTION, AD_MESSAGE_GET2(DP.ISPAID, ?) AS ISPAID, " +
      "      (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END) AS INVOICE_TYPE, " +
      "      (CASE s2.SETTLEMENTTYPE WHEN 'I' THEN '../ManualSettlement/CreatePayment_Relation.html' ELSE '../Settlement/CreatedPayments_Relation.html' END) AS PATH, COALESCE(RLT2.NAME, RL2.NAME) AS DPSTATUS, URS.NAME AS SALESREPNAME" +
      "      FROM C_DEBT_PAYMENT DP left join C_SETTLEMENT S1 on DP.C_SETTLEMENT_CANCEL_ID = S1.C_SETTLEMENT_ID" +
      "                             left join C_SETTLEMENT S2 on DP.C_SETTLEMENT_GENERATE_ID = S2.C_SETTLEMENT_ID" +
      "                             left join C_BPARTNER B    on DP.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "                             left join C_BANKACCOUNT BA on DP.C_BANKACCOUNT_ID = BA.C_BANKACCOUNT_ID" +
      "                             left join C_BANK BANK ON BA.C_BANK_ID = BANK.C_BANK_ID" +
      "                             left join C_INVOICE I     on DP.C_INVOICE_ID = I.C_INVOICE_ID left join AD_USER URS on I.SALESREP_ID = URS.AD_USER_ID," +
      "           AD_REF_LIST RL    left join AD_REF_LIST_TRL RLT on RL.AD_REF_LIST_ID = RLT.AD_REF_LIST_ID" +
      "                                                              AND RLT.AD_LANGUAGE = ?," +
      "           AD_REF_LIST RL2    left join AD_REF_LIST_TRL RLT2 on RL2.AD_REF_LIST_ID = RLT2.AD_REF_LIST_ID" +
      "                                                              AND RLT2.AD_LANGUAGE = ?," +
      "           C_CURRENCY C " +
      "      WHERE DP.C_CURRENCY_ID = C.C_CURRENCY_ID " +
      "      AND DP.PAYMENTRULE = RL.VALUE" +
      "      AND RL.AD_REFERENCE_ID = '195'" +
      "      AND DP.STATUS = RL2.VALUE" +
      "      AND RL2.AD_REFERENCE_ID = '800070'" +
      "      AND DP.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND DP.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "      AND DP.IsActive='Y'" +
      "      AND DP.IsValid='Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND dp.C_BPARTNER_ID IN " + cBpartnerId);
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND dp.Dateplanned >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND dp.Dateplanned < to_date(?)  ");
    strSql = strSql + ((AmountFrom==null || AmountFrom.equals(""))?"":"  AND dp.amount >= TO_NUMBER(?)  ");
    strSql = strSql + ((AmountTo==null || AmountTo.equals(""))?"":"  AND dp.amount <= TO_NUMBER(?)  ");
    strSql = strSql + ((paymentRule==null || paymentRule.equals(""))?"":"  AND dp.paymentrule = ?  ");
    strSql = strSql + ((isReceipt==null || isReceipt.equals(""))?"":"  AND dp.isreceipt=?  ");
    strSql = strSql + ((status==null || status.equals(""))?"":"  AND dp.status=?  ");
    strSql = strSql + ((isSettle==null || isSettle.equals(""))?"":" AND C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID,        DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) IN" + isSettle);
    strSql = strSql + ((cbankaccount==null || cbankaccount.equals(""))?"":"  AND DP.C_BANKACCOUNT_ID = ?  ");
    strSql = strSql + ((salesrepId==null || salesrepId.equals(""))?"":"  AND URS.AD_USER_ID = ?  ");
    strSql = strSql + ((appby==null || appby.equals(""))?"":"  AND DP.APPROVEDBY = ? AND DP.isapproved = 'Y'  ");
    strSql = strSql + 
      "      GROUP BY (BANK.NAME || '/' || BANK.CODEBRANCH || BANK.DIGITCONTROL || BA.CODEACCOUNT || '.' || BA.DIGITCONTROL), (CASE BA.showspanish WHEN 'Y' then BA.CODEACCOUNT ELSE CASE BA.SHOWGENERIC when 'Y' then GENERICACCOUNT ELSE CASE BA.SHOWIBAN WHEN 'Y' THEN BA.IBAN END END END)," +
      "      I.C_INVOICE_ID,i.c_dunning_id, (CASE WHEN DP.C_DEBT_PAYMENT_ID IS NULL THEN '0' ELSE DP.C_DEBT_PAYMENT_ID END), B.NAME, (CASE WHEN I.DOCUMENTNO IS NOT NULL THEN I.DOCUMENTNO||' ('||I.DATEINVOICED||')' END), DP.DATEPLANNED, DP.AMOUNT," +
      "      DP.WRITEOFFAMT, C.ISO_CODE,S1.DOCUMENTNO ,S1.DATETRX, S2.DOCUMENTNO,S2.DATETRX, RLT.NAME, RL.NAME, RLT2.NAME, RL2.NAME, DP.C_Settlement_Cancel_ID," +
      "      DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID, DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID, DP.DESCRIPTION, (CASE DP.ISRECEIPT WHEN 'Y' THEN 'SalesInvoice' ELSE 'PurchaseInvoice' END),s2.SETTLEMENTTYPE, DP.STATUS, URS.NAME" +
      "      ORDER BY ";
    strSql = strSql + ((ord==null || ord.equals(""))?"":ord);
    strSql = strSql + 
      ",STATUS, DP.DATEPLANNED";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (AmountFrom != null && !(AmountFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountFrom);
      }
      if (AmountTo != null && !(AmountTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, AmountTo);
      }
      if (paymentRule != null && !(paymentRule.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentRule);
      }
      if (isReceipt != null && !(isReceipt.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, isReceipt);
      }
      if (status != null && !(status.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      }
      if (isSettle != null && !(isSettle.equals(""))) {
        }
      if (cbankaccount != null && !(cbankaccount.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cbankaccount);
      }
      if (salesrepId != null && !(salesrepId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      }
      if (appby != null && !(appby.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, appby);
      }
      if (ord != null && !(ord.equals(""))) {
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
        ReportDebtPaymentData objectReportDebtPaymentData = new ReportDebtPaymentData();
        objectReportDebtPaymentData.bankacc = UtilSql.getValue(result, "bankacc");
        objectReportDebtPaymentData.accountstr = UtilSql.getValue(result, "accountstr");
        objectReportDebtPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportDebtPaymentData.cDebtPaymentId = UtilSql.getValue(result, "c_debt_payment_id");
        objectReportDebtPaymentData.bpartner = UtilSql.getValue(result, "bpartner");
        objectReportDebtPaymentData.invoice = UtilSql.getValue(result, "invoice");
        objectReportDebtPaymentData.dateplanned = UtilSql.getDateValue(result, "dateplanned", "dd-MM-yyyy");
        objectReportDebtPaymentData.amount = UtilSql.getValue(result, "amount");
        objectReportDebtPaymentData.writeoffamt = UtilSql.getValue(result, "writeoffamt");
        objectReportDebtPaymentData.currency = UtilSql.getValue(result, "currency");
        objectReportDebtPaymentData.debtcancel = UtilSql.getValue(result, "debtcancel");
        objectReportDebtPaymentData.debtgenerate = UtilSql.getValue(result, "debtgenerate");
        objectReportDebtPaymentData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportDebtPaymentData.status = UtilSql.getValue(result, "status");
        objectReportDebtPaymentData.description = UtilSql.getValue(result, "description");
        objectReportDebtPaymentData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportDebtPaymentData.invoiceType = UtilSql.getValue(result, "invoice_type");
        objectReportDebtPaymentData.path = UtilSql.getValue(result, "path");
        objectReportDebtPaymentData.dpstatus = UtilSql.getValue(result, "dpstatus");
        objectReportDebtPaymentData.salesrepname = UtilSql.getValue(result, "salesrepname");
        objectReportDebtPaymentData.rownum = Long.toString(countRecord);
        objectReportDebtPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportDebtPaymentData);
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
    ReportDebtPaymentData objectReportDebtPaymentData[] = new ReportDebtPaymentData[vector.size()];
    vector.copyInto(objectReportDebtPaymentData);
    return(objectReportDebtPaymentData);
  }

  public static ReportDebtPaymentData[] set()    throws ServletException {
    ReportDebtPaymentData objectReportDebtPaymentData[] = new ReportDebtPaymentData[1];
    objectReportDebtPaymentData[0] = new ReportDebtPaymentData();
    objectReportDebtPaymentData[0].bankacc = "";
    objectReportDebtPaymentData[0].accountstr = "";
    objectReportDebtPaymentData[0].cInvoiceId = "";
    objectReportDebtPaymentData[0].cDebtPaymentId = "";
    objectReportDebtPaymentData[0].bpartner = "";
    objectReportDebtPaymentData[0].invoice = "";
    objectReportDebtPaymentData[0].dateplanned = "";
    objectReportDebtPaymentData[0].amount = "";
    objectReportDebtPaymentData[0].writeoffamt = "";
    objectReportDebtPaymentData[0].currency = "";
    objectReportDebtPaymentData[0].debtcancel = "";
    objectReportDebtPaymentData[0].debtgenerate = "";
    objectReportDebtPaymentData[0].paymentrule = "";
    objectReportDebtPaymentData[0].status = "";
    objectReportDebtPaymentData[0].description = "";
    objectReportDebtPaymentData[0].ispaid = "";
    objectReportDebtPaymentData[0].invoiceType = "";
    objectReportDebtPaymentData[0].path = "";
    objectReportDebtPaymentData[0].dpstatus = "";
    objectReportDebtPaymentData[0].salesrepname = "";
    return objectReportDebtPaymentData;
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

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

  public static int approve(ConnectionProvider connectionProvider, String userId, String paymentids)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_DEBT_PAYMENT" +
      "          SET ISAPPROVED = 'Y'," +
      "              APPROVEDBY = ?," +
      "              UPDATED = now()" +
      "          WHERE C_DEBT_PAYMENT_ID  IN ";
    strSql = strSql + ((paymentids==null || paymentids.equals(""))?"":paymentids);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (paymentids != null && !(paymentids.equals(""))) {
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

  public static int unapprove(ConnectionProvider connectionProvider, String userId, String paymentids)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       UPDATE C_DEBT_PAYMENT" +
      "          SET ISAPPROVED = 'N'," +
      "              APPROVEDBY = ?," +
      "              UPDATED = now()" +
      "          WHERE C_DEBT_PAYMENT_ID  IN ";
    strSql = strSql + ((paymentids==null || paymentids.equals(""))?"":paymentids);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (paymentids != null && !(paymentids.equals(""))) {
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

  public static String isDPapprover(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT case pp when 'Y' then 'APPROVER' else 'NONE' end as ispaymentapprover" +
      "       from" +
      "       (SELECT ispaymentapprover as pp" +
      "           from   c_bpartner,ad_user where ad_user.c_bpartner_id= c_bpartner.c_bpartner_id      " +
      "           and ad_user_id = ? " +
      "        UNION" +
      "           SELECT 'N' as pp from dual" +
      "        ) a order by pp desc LIMIT 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ispaymentapprover");
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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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
