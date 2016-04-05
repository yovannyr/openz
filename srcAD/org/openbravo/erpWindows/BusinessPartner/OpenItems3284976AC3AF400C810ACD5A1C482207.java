
package org.openbravo.erpWindows.BusinessPartner;





import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import org.apache.log4j.Logger;
import org.apache.commons.fileupload.FileItem;
import org.openz.view.*;
import org.openz.model.*;
import org.openz.controller.callouts.CalloutStructure;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.view.templates.ConfigureSelectBox;
import org.openz.view.templates.ConfigureFrameWindow;
import org.openz.util.LocalizationUtils;
import org.openz.util.UtilsData;
import org.openz.controller.businessprocess.DocActionWorkflowOptions;
import org.openbravo.data.Sqlc;

public class OpenItems3284976AC3AF400C810ACD5A1C482207 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(OpenItems3284976AC3AF400C810ACD5A1C482207.class);
  
  private static final String windowId = "123";
  private static final String tabId = "3284976AC3AF400C810ACD5A1C482207";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
  private static final double SUBTABS_COL_SIZE = 15;

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    this.setWindowId(windowId);
    this.setTabId(tabId);
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strcInvoiceId = request.getParameter("inpcInvoiceId");
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcInvoiceId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");

      String strC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strC_Invoice_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Invoice_ID.equals("")) strC_Invoice_ID = firstElement(vars, tableSQL);
          if (strC_Invoice_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Invoice_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Invoice_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Invoice_ID.equals("")) strC_Invoice_ID = vars.getRequiredGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      else vars.setSessionValue(windowId + "|C_Invoice_ID", strC_Invoice_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strC_Invoice_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("220|Business Partner.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Invoice_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Invoice_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Invoice_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view");
      String strC_Invoice_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Invoice_ID = firstElement(vars, tableSQL);
          if (strC_Invoice_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Invoice_ID.equals("")) strC_Invoice_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Invoice_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamPOReference", tabId + "|paramPOReference");
vars.getRequestGlobalVariable("inpParamDateInvoiced", tabId + "|paramDateInvoiced");
vars.getRequestGlobalVariable("inpParamC_DocTypeTarget_ID", tabId + "|paramC_DocTypeTarget_ID");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamSalesRep_ID", tabId + "|paramSalesRep_ID");
vars.getRequestGlobalVariable("inpParamIsPaid", tabId + "|paramIsPaid");
vars.getRequestGlobalVariable("inpParamOutstandingAmt", tabId + "|paramOutstandingAmt");
vars.getRequestGlobalVariable("inpParamDueAmt", tabId + "|paramDueAmt");
vars.getRequestGlobalVariable("inpParamGrandTotal", tabId + "|paramGrandTotal");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamDateInvoiced_f", tabId + "|paramDateInvoiced_f");
vars.getRequestGlobalVariable("inpParamOutstandingAmt_f", tabId + "|paramOutstandingAmt_f");
vars.getRequestGlobalVariable("inpParamDueAmt_f", tabId + "|paramDueAmt_f");
vars.getRequestGlobalVariable("inpParamGrandTotal_f", tabId + "|paramGrandTotal_f");

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|C_Invoice_ID");
      String strC_Invoice_ID="";

      String strView = vars.getSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Invoice_ID = firstElement(vars, tableSQL);
        if (strC_Invoice_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Invoice_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID", "");
      vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Invoice_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Invoice_ID = vars.getGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID", "");
      vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Invoice_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Invoice_ID = vars.getRequiredStringParameter("inpcInvoiceId");
      
      String strNext = nextElement(vars, strC_Invoice_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Invoice_ID = vars.getRequiredStringParameter("inpcInvoiceId");
      
      String strPrevious = previousElement(vars, strC_Invoice_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Invoice_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Invoice_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_BPartner_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Invoice_ID = vars.getRequiredGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strC_Invoice_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Invoice_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_Invoice_ID = vars.getRequiredInStringParameter("inpcInvoiceId");
      String message = deleteRelation(vars, strC_Invoice_ID, strPC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cInvoiceId");
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_Invoice_ID = vars.getRequiredStringParameter("inpcInvoiceId");
      //OpenItems3284976AC3AF400C810ACD5A1C482207Data data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = OpenItems3284976AC3AF400C810ACD5A1C482207Data.delete(this, strC_Invoice_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|cInvoiceId");
        vars.setSessionValue(tabId + "|OpenItems3284976AC3AF400C810ACD5A1C482207.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());








    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strC_Invoice_ID, String strPC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Invoice_ID.startsWith("(")) strC_Invoice_ID = strC_Invoice_ID.substring(1, strC_Invoice_ID.length()-1);
      if (!strC_Invoice_ID.equals("")) {
        strC_Invoice_ID = Replace.replace(strC_Invoice_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Invoice_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (OpenItems3284976AC3AF400C810ACD5A1C482207Data.deleteTransactional(conn, this, strKey, strPC_BPartner_ID)==0) {
            releaseRollbackConnection(conn);
            log4j.warn("deleteRelation - key :" + strKey + " - 0 records deleted");
          }
        }
      }
      releaseCommitConnection(conn);
    } catch (ServletException e) {
      releaseRollbackConnection(conn);
      e.printStackTrace();
      log4j.error("Rollback in transaction");
      return "ProcessRunError";
    }
    return "";
  }
*/
  private OpenItems3284976AC3AF400C810ACD5A1C482207Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    OpenItems3284976AC3AF400C810ACD5A1C482207Data data = new OpenItems3284976AC3AF400C810ACD5A1C482207Data();
    ServletException ex = null;
    try {
    data.cInvoiceId = vars.getRequestGlobalVariable("inpcInvoiceId", windowId + "|C_Invoice_ID");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.dateinvoiced = vars.getRequestGlobalVariable("inpdateinvoiced", windowId + "|DateInvoiced");     data.dateordered = vars.getStringParameter("inpdateordered");     data.dateacct = vars.getStringParameter("inpdateacct");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.description = vars.getStringParameter("inpdescription");    try {   data.dueamt = vars.getNumericParameter("inpdueamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.daystilldue = vars.getNumericParameter("inpdaystilldue");  } catch (ServletException paramEx) { ex = paramEx; }     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.ispaid = vars.getRequiredInputGlobalVariable("inpispaid", windowId + "|IsPaid", "N");     data.isgrossinvoice = vars.getStringParameter("inpisgrossinvoice", "N");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");     data.generateto = vars.getStringParameter("inpgenerateto");     data.user1Id = vars.getStringParameter("inpuser1Id");     data.cWithholdingId = vars.getStringParameter("inpcWithholdingId");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.createfrom = vars.getStringParameter("inpcreatefrom");     data.user2Id = vars.getStringParameter("inpuser2Id");     data.processing = vars.getStringParameter("inpprocessing");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.posted = vars.getStringParameter("inpposted");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adUserId = vars.getStringParameter("inpadUserId");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.taxdate = vars.getStringParameter("inptaxdate");     data.updatepaymentmonitor = vars.getStringParameter("inpupdatepaymentmonitor");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.docaction = vars.getStringParameter("inpdocaction");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.lastcalculatedondate = vars.getStringParameter("inplastcalculatedondate");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");    try {   data.outstandingamt = vars.getNumericParameter("inpoutstandingamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");    try {   data.withholdingamount = vars.getNumericParameter("inpwithholdingamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.poreference = vars.getStringParameter("inpporeference");     data.cChargeId = vars.getStringParameter("inpcChargeId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "C_Invoice", data.cDoctypetargetId, data.cDoctypeId, false, true);

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }

   private OpenItems3284976AC3AF400C810ACD5A1C482207Data[] getRelationData(OpenItems3284976AC3AF400C810ACD5A1C482207Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 32);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 50);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 30);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 22);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 22);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 50);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 22);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 22);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 50);        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 22);        data[i].cWithholdingId = FormatUtilities.truncate(data[i].cWithholdingId, 12);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 22);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 22);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 22);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 22);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 22);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 22);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 22);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 22);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 22);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      BusinessPartnerData[] data = BusinessPartnerData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Value", data[0].value);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Invoice_ID) throws ServletException {
    String strPC_BPartner_ID = OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectParentID(this, strC_Invoice_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Invoice_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Invoice_ID", data[0].getField("cInvoiceId"));    vars.setSessionValue(windowId + "|DateInvoiced", data[0].getField("dateinvoiced"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|IsPaid", data[0].getField("ispaid"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      OpenItems3284976AC3AF400C810ACD5A1C482207Data[] data = OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, vars.getStringParameter("inpcInvoiceId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strC_Invoice_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateInvoiced = vars.getSessionValue(tabId + "|paramDateInvoiced");
String strParamC_DocTypeTarget_ID = vars.getSessionValue(tabId + "|paramC_DocTypeTarget_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamIsPaid = vars.getSessionValue(tabId + "|paramIsPaid");
String strParamOutstandingAmt = vars.getSessionValue(tabId + "|paramOutstandingAmt");
String strParamDueAmt = vars.getSessionValue(tabId + "|paramDueAmt");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateInvoiced_f = vars.getSessionValue(tabId + "|paramDateInvoiced_f");
String strParamOutstandingAmt_f = vars.getSessionValue(tabId + "|paramOutstandingAmt_f");
String strParamDueAmt_f = vars.getSessionValue(tabId + "|paramDueAmt_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");

    if (vars.getSessionValue(windowId +  "|C_BPartner_ID").isEmpty()) vars.setSessionValue(windowId + "|C_BPartner_ID", vars.getStringParameter("inpcBpartnerId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateInvoiced.equals("") && strParamC_DocTypeTarget_ID.equals("") && strParamC_BPartner_ID.equals("") && strParamSalesRep_ID.equals("") && strParamIsPaid.equals("") && strParamOutstandingAmt.equals("") && strParamDueAmt.equals("") && strParamGrandTotal.equals("") && strParamDocStatus.equals("") && strParamC_Project_ID.equals("") && strParamDateInvoiced_f.equals("") && strParamOutstandingAmt_f.equals("") && strParamDueAmt_f.equals("") && strParamGrandTotal_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Invoice_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Invoice_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/BusinessPartner/OpenItems3284976AC3AF400C810ACD5A1C482207_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "OpenItems3284976AC3AF400C810ACD5A1C482207", false, "document.frmMain.inpcInvoiceId", "grid", "..", "".equals("Y"), "BusinessPartner", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_BPartner_ID);

    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "cInvoiceId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "OpenItems3284976AC3AF400C810ACD5A1C482207_Relation.html", "BusinessPartner", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "OpenItems3284976AC3AF400C810ACD5A1C482207_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectParentTrl(this, strPC_BPartner_ID));

    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Invoice_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " dateinvoiced";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    OpenItems3284976AC3AF400C810ACD5A1C482207Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateInvoiced = vars.getSessionValue(tabId + "|paramDateInvoiced");
String strParamC_DocTypeTarget_ID = vars.getSessionValue(tabId + "|paramC_DocTypeTarget_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamIsPaid = vars.getSessionValue(tabId + "|paramIsPaid");
String strParamOutstandingAmt = vars.getSessionValue(tabId + "|paramOutstandingAmt");
String strParamDueAmt = vars.getSessionValue(tabId + "|paramDueAmt");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateInvoiced_f = vars.getSessionValue(tabId + "|paramDateInvoiced_f");
String strParamOutstandingAmt_f = vars.getSessionValue(tabId + "|paramOutstandingAmt_f");
String strParamDueAmt_f = vars.getSessionValue(tabId + "|paramDueAmt_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateInvoiced.equals("") && strParamC_DocTypeTarget_ID.equals("") && strParamC_BPartner_ID.equals("") && strParamSalesRep_ID.equals("") && strParamIsPaid.equals("") && strParamOutstandingAmt.equals("") && strParamDueAmt.equals("") && strParamGrandTotal.equals("") && strParamDocStatus.equals("") && strParamC_Project_ID.equals("") && strParamDateInvoiced_f.equals("") && strParamOutstandingAmt_f.equals("") && strParamDueAmt_f.equals("") && strParamGrandTotal_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, strC_Invoice_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Invoice_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Invoice_ID = firstElement(vars, tableSQL);
        if (strC_Invoice_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, strC_Invoice_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new OpenItems3284976AC3AF400C810ACD5A1C482207Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cInvoiceId") == null || dataField.getField("cInvoiceId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPC_BPartner_ID);
        data = OpenItems3284976AC3AF400C810ACD5A1C482207Data.set(strPC_BPartner_ID, "Y", Utility.getDefault(this, vars, "IsGrossInvoice", "N", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "User1_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "CreateFrom", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "TotalLines", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectDef3489_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField)), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "DateInvoiced", "@#Date@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectDef3499_1(this, strPC_BPartner_ID), Utility.getDefault(this, vars, "Taxdate", "@#Date@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "Processing", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "OutstandingAmt", "0", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "LastCalculatedOnDate", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "Description", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "POReference", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectDef3510_2(this, Utility.getDefault(this, vars, "C_Project_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField)), Utility.getDefault(this, vars, "DocAction", "CO", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsPrinted", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "DateOrdered", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "DateAcct", "@#Date@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "DocStatus", "DR", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsPaid", "N", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "Posted", "N", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "C_Withholding_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "User2_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "TotalPaid", "0", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "UpdatePaymentMonitor", "N", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "PaymentRule", "P", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "GenerateTo", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), OpenItems3284976AC3AF400C810ACD5A1C482207Data.selectDef3491_3(this, Utility.getDefault(this, vars, "UpdatedBy", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField)), Utility.getDefault(this, vars, "Withholdingamount", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_DocType_ID", "0", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "Processed", "", "123", "3284976AC3AF400C810ACD5A1C482207", "N", dataField), Utility.getDefault(this, vars, "DaysTillDue", "0", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "DueAmt", "0", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), Utility.getDefault(this, vars, "C_Order_ID", "", "123", "3284976AC3AF400C810ACD5A1C482207", "", dataField), "");
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "C_Invoice", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new OpenItems3284976AC3AF400C810ACD5A1C482207Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(OpenItems3284976AC3AF400C810ACD5A1C482207Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=BusinessPartnerData.selectOrg(this, strPC_BPartner_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "OpenItems3284976AC3AF400C810ACD5A1C482207", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcInvoiceId", "", "..", "".equals("Y"), "BusinessPartner", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Invoice_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "RO", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
  // set updated timestamp to manage locking mechanism
    String updatedTimestamp="";
    if (!boolNew) {
      updatedTimestamp=(dataField != null ? dataField.getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp"));
    }
    this.setUpdatedtimestamp(updatedTimestamp);
   // this.setOrgparent(currentPOrg);
    this.setCommandtype(strCommand);
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter output = response.getWriter();
      
      Connection conn = null;
      Scripthelper script = new Scripthelper();
      if (boolNew) 
        script.addHiddenfieldWithID("newdatasetindicator", "NEW");
      else
        script.addHiddenfieldWithID("newdatasetindicator", "");
      script.addHiddenfieldWithID("enabledautosave", "Y");
      script.addMessage(this, vars, vars.getMessage(tabId));
      Formhelper fh=new Formhelper();
      String strLeftabsmode="EDIT";
      String focus=fh.TabGetFirstFocusField(this,tabId);
      String strSkeleton = ConfigureFrameWindow.doConfigureWindowMode(this,vars,Sqlc.TransformaNombreColumna(focus),tabs.breadcrumb(), "Form Window",null,strLeftabsmode,tabs,"_Relation",toolbar.toString());
      String strTableStructure="";
      if (editableTab||tabId.equalsIgnoreCase("800026"))
        strTableStructure=fh.prepareTabFields(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      else
        strTableStructure=fh.prepareTabFieldsRO(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      strSkeleton=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure );  
      script.addOnload("setProcessingMode('window', false);");
      strSkeleton = script.doScript(strSkeleton, "",this,vars);
      output.println(strSkeleton);
      vars.removeMessage(tabId);
      output.close();
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }
  






    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strDOCNOREADONLY=\"" + Utility.getContext(this, vars, "DOCNOREADONLY", windowId) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_BPartner_ID) throws IOException, ServletException {
    OpenItems3284976AC3AF400C810ACD5A1C482207Data data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars, strPC_BPartner_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cInvoiceId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (OpenItems3284976AC3AF400C810ACD5A1C482207Data.getCurrentDBTimestamp(this, data.cInvoiceId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
          CrudOperations.UpdateCustomFields(tabId, data.cInvoiceId, vars, this);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.cInvoiceId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Invoice_ID", data.cInvoiceId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet OpenItems3284976AC3AF400C810ACD5A1C482207. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
