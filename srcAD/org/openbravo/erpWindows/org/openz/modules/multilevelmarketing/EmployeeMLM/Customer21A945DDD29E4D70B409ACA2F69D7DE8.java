
package org.openbravo.erpWindows.org.openz.modules.multilevelmarketing.EmployeeMLM;





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

public class Customer21A945DDD29E4D70B409ACA2F69D7DE8 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Customer21A945DDD29E4D70B409ACA2F69D7DE8.class);
  
  private static final String windowId = "3B800C41F0DC4618B81E4295E9E2B232";
  private static final String tabId = "21A945DDD29E4D70B409ACA2F69D7DE8";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 3;
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
        String strcBpartnerId = request.getParameter("inpcBpartnerId");
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcBpartnerId.equals(""))
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

      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strC_BPartner_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_BPartner_ID.equals("")) strC_BPartner_ID = firstElement(vars, tableSQL);
          if (strC_BPartner_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BPartner_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_BPartner_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_BPartner_ID.equals("")) strC_BPartner_ID = vars.getRequiredGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      else vars.setSessionValue(windowId + "|C_BPartner_ID", strC_BPartner_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strC_BPartner_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("null|null.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_BPartner_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BPartner_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view");
      String strC_BPartner_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_BPartner_ID = firstElement(vars, tableSQL);
          if (strC_BPartner_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_BPartner_ID.equals("")) strC_BPartner_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_BPartner_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamValue", tabId + "|paramValue");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamIsCustomer", tabId + "|paramIsCustomer");
vars.getRequestGlobalVariable("inpParamIsActive", tabId + "|paramIsActive");
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      String strC_BPartner_ID="";

      String strView = vars.getSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_BPartner_ID = firstElement(vars, tableSQL);
        if (strC_BPartner_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_BPartner_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
      vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_BPartner_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      
      String strNext = nextElement(vars, strC_BPartner_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      
      String strPrevious = previousElement(vars, strC_BPartner_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
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
      String strC_BPartner_ID = vars.getRequiredGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
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
          String strNext = nextElement(vars, strC_BPartner_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_BPartner_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_BPartner_ID = vars.getRequiredInStringParameter("inpcBpartnerId");
      String message = deleteRelation(vars, strC_BPartner_ID, strPC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cBpartnerId");
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_BPartner_ID = vars.getRequiredStringParameter("inpcBpartnerId");
      //Customer21A945DDD29E4D70B409ACA2F69D7DE8Data data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.delete(this, strC_BPartner_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cBpartnerId");
        vars.setSessionValue(tabId + "|Customer21A945DDD29E4D70B409ACA2F69D7DE8.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_BPartner_ID, String strPC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_BPartner_ID.startsWith("(")) strC_BPartner_ID = strC_BPartner_ID.substring(1, strC_BPartner_ID.length()-1);
      if (!strC_BPartner_ID.equals("")) {
        strC_BPartner_ID = Replace.replace(strC_BPartner_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_BPartner_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.deleteTransactional(conn, this, strKey, strPC_BPartner_ID)==0) {
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
  private Customer21A945DDD29E4D70B409ACA2F69D7DE8Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    Customer21A945DDD29E4D70B409ACA2F69D7DE8Data data = new Customer21A945DDD29E4D70B409ACA2F69D7DE8Data();
    ServletException ex = null;
    try {
    data.value = vars.getRequestGlobalVariable("inpvalue", windowId + "|Value");     data.name = vars.getStringParameter("inpname");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.iscustomer = vars.getStringParameter("inpiscustomer", "N");    try {   data.documentcopies = vars.getNumericParameter("inpdocumentcopies");  } catch (ServletException paramEx) { ex = paramEx; }     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.invoiceruler = vars.getStringParameter("inpinvoicerule_R");     data.cInvoicescheduleId = vars.getStringParameter("inpcInvoicescheduleId");     data.cInvoicescheduleIdr = vars.getStringParameter("inpcInvoicescheduleId_R");     data.invoicegrouping = vars.getStringParameter("inpinvoicegrouping");     data.invoicegroupingr = vars.getStringParameter("inpinvoicegrouping_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.deliveryviarule = vars.getStringParameter("inpdeliveryviarule");     data.deliveryviaruler = vars.getStringParameter("inpdeliveryviarule_R");     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.soDescription = vars.getStringParameter("inpsoDescription");    try {   data.soCreditlimit = vars.getNumericParameter("inpsoCreditlimit");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.soCreditused = vars.getNumericParameter("inpsoCreditused");  } catch (ServletException paramEx) { ex = paramEx; }     data.isecommerceactive = vars.getStringParameter("inpisecommerceactive", "N");    try {   data.fixmonthday2 = vars.getNumericParameter("inpfixmonthday2");  } catch (ServletException paramEx) { ex = paramEx; }     data.soBankaccountId = vars.getStringParameter("inpsoBankaccountId");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");    try {   data.fixmonthday3 = vars.getNumericParameter("inpfixmonthday3");  } catch (ServletException paramEx) { ex = paramEx; }     data.poreference = vars.getStringParameter("inpporeference");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");    try {   data.fixmonthday = vars.getNumericParameter("inpfixmonthday");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
    

    
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

   private Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[] getRelationData(Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 21);        data[i].cInvoicescheduleId = FormatUtilities.truncate(data[i].cInvoicescheduleId, 44);        data[i].invoicegrouping = FormatUtilities.truncate(data[i].invoicegrouping, 21);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 21);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 21);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 21);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);        data[i].soDescription = FormatUtilities.truncate(data[i].soDescription, 50);        data[i].soBankaccountId = FormatUtilities.truncate(data[i].soBankaccountId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 10);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data[] data = EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Value", data[0].value);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_BPartner_ID) throws ServletException {
    String strPC_BPartner_ID = Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectParentID(this, strC_BPartner_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_BPartner_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Value", data[0].getField("value"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[] data = Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPARTNER_ID", windowId), strPC_BPartner_ID, vars.getStringParameter("inpcBpartnerId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamIsCustomer = vars.getSessionValue(tabId + "|paramIsCustomer");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");

    if (vars.getSessionValue(windowId +  "|C_BPartner_ID").isEmpty()) vars.setSessionValue(windowId + "|C_BPartner_ID", vars.getStringParameter("inpcBpartnerId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamIsCustomer.equals("") && strParamIsActive.equals("") && strParamAD_Org_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_BPartner_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_BPartner_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/modules/multilevelmarketing/EmployeeMLM/Customer21A945DDD29E4D70B409ACA2F69D7DE8_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Customer21A945DDD29E4D70B409ACA2F69D7DE8", false, "document.frmMain.inpcBpartnerId", "grid", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, false);
    toolbar.prepareRelationTemplateNoSearch("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
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
    xmlDocument.setParameter("KeyName", "cBpartnerId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Customer21A945DDD29E4D70B409ACA2F69D7DE8_Relation.html", "EmployeeMLM", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Customer21A945DDD29E4D70B409ACA2F69D7DE8_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectParentTrl(this, strPC_BPartner_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_BPartner_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_BPartner.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamIsCustomer = vars.getSessionValue(tabId + "|paramIsCustomer");
String strParamIsActive = vars.getSessionValue(tabId + "|paramIsActive");
String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");

    boolean hasSearchCondition=false;
    if (!(strParamValue.equals("") && strParamName.equals("") && strParamIsCustomer.equals("") && strParamIsActive.equals("") && strParamAD_Org_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPARTNER_ID", windowId), strPC_BPartner_ID, strC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_BPartner_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cBpartnerId") == null || dataField.getField("cBpartnerId").equals("")) {
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
        data = Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.set(strPC_BPartner_ID, Utility.getDefault(this, vars, "IsCustomer", "N", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "N", dataField), Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectDef2901(this, Utility.getContext(this, vars, "AD_ORG_ID", "3B800C41F0DC4618B81E4295E9E2B232")), Utility.getDefault(this, vars, "DocumentCopies", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "Fixmonthday3", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "Name", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "I", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), "Y", Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectDef2898_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField)), Utility.getDefault(this, vars, "FixMonthDay", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "Isecommerceactive", "Y", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "N", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "N", dataField), Utility.getDefault(this, vars, "SO_CreditLimit", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "R", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.selectDef2900_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField)), Utility.getDefault(this, vars, "SO_Description", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "FixMonthDay2", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "Invoicegrouping", "000000000000000", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "SO_CreditUsed", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "SO_Bankaccount_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "DeliveryRule", "A", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "POReference", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "C_InvoiceSchedule_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField), Utility.getDefault(this, vars, "DeliveryViaRule", "D", "3B800C41F0DC4618B81E4295E9E2B232", "21A945DDD29E4D70B409ACA2F69D7DE8", "", dataField));
        
      }
    } else {
      data = new Customer21A945DDD29E4D70B409ACA2F69D7DE8Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Customer21A945DDD29E4D70B409ACA2F69D7DE8Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data.selectOrg(this, strPC_BPartner_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Customer21A945DDD29E4D70B409ACA2F69D7DE8", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcBpartnerId", "", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_BPartner_ID));
    toolbar.prepareEditionTemplateNoSearch("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
    Customer21A945DDD29E4D70B409ACA2F69D7DE8Data data = null;
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
                data.cBpartnerId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Customer21A945DDD29E4D70B409ACA2F69D7DE8Data.getCurrentDBTimestamp(this, data.cBpartnerId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cBpartnerId, vars, this);
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
                    data.cBpartnerId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_BPartner_ID", data.cBpartnerId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Customer21A945DDD29E4D70B409ACA2F69D7DE8. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
