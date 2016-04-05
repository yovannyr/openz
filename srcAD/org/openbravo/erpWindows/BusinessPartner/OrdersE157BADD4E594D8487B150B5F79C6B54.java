
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

public class OrdersE157BADD4E594D8487B150B5F79C6B54 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(OrdersE157BADD4E594D8487B150B5F79C6B54.class);
  
  private static final String windowId = "123";
  private static final String tabId = "E157BADD4E594D8487B150B5F79C6B54";
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
        String strcOrderId = request.getParameter("inpcOrderId");
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcOrderId.equals(""))
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

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strC_Order_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Order_ID.equals("")) strC_Order_ID = firstElement(vars, tableSQL);
          if (strC_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Order_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Order_ID.equals("")) strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      else vars.setSessionValue(windowId + "|C_Order_ID", strC_Order_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strC_Order_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("null|null.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Order_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Order_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Order_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view");
      String strC_Order_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Order_ID = firstElement(vars, tableSQL);
          if (strC_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Order_ID.equals("")) strC_Order_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Order_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamPOReference", tabId + "|paramPOReference");
vars.getRequestGlobalVariable("inpParamDateOrdered", tabId + "|paramDateOrdered");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamSalesRep_ID", tabId + "|paramSalesRep_ID");
vars.getRequestGlobalVariable("inpParamGrandTotal", tabId + "|paramGrandTotal");
vars.getRequestGlobalVariable("inpParamInvoiceRule", tabId + "|paramInvoiceRule");
vars.getRequestGlobalVariable("inpParamDatePromised", tabId + "|paramDatePromised");
vars.getRequestGlobalVariable("inpParamC_DocType_ID", tabId + "|paramC_DocType_ID");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamInvoicedAmt", tabId + "|paramInvoicedAmt");
vars.getRequestGlobalVariable("inpParamIsCompletelyInvoiced", tabId + "|paramIsCompletelyInvoiced");
vars.getRequestGlobalVariable("inpParamDeliveryComplete", tabId + "|paramDeliveryComplete");
vars.getRequestGlobalVariable("inpParamDateOrdered_f", tabId + "|paramDateOrdered_f");
vars.getRequestGlobalVariable("inpParamGrandTotal_f", tabId + "|paramGrandTotal_f");
vars.getRequestGlobalVariable("inpParamDatePromised_f", tabId + "|paramDatePromised_f");
vars.getRequestGlobalVariable("inpParamInvoicedAmt_f", tabId + "|paramInvoicedAmt_f");

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|C_Order_ID");
      String strC_Order_ID="";

      String strView = vars.getSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Order_ID = firstElement(vars, tableSQL);
        if (strC_Order_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Order_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strNext = nextElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strPrevious = previousElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Order_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Order_ID");
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
      String strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
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
          String strNext = nextElement(vars, strC_Order_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Order_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_Order_ID = vars.getRequiredInStringParameter("inpcOrderId");
      String message = deleteRelation(vars, strC_Order_ID, strPC_BPartner_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cOrderId");
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      //OrdersE157BADD4E594D8487B150B5F79C6B54Data data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = OrdersE157BADD4E594D8487B150B5F79C6B54Data.delete(this, strC_Order_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cOrderId");
        vars.setSessionValue(tabId + "|OrdersE157BADD4E594D8487B150B5F79C6B54.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Order_ID, String strPC_BPartner_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Order_ID.startsWith("(")) strC_Order_ID = strC_Order_ID.substring(1, strC_Order_ID.length()-1);
      if (!strC_Order_ID.equals("")) {
        strC_Order_ID = Replace.replace(strC_Order_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Order_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (OrdersE157BADD4E594D8487B150B5F79C6B54Data.deleteTransactional(conn, this, strKey, strPC_BPartner_ID)==0) {
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
  private OrdersE157BADD4E594D8487B150B5F79C6B54Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    OrdersE157BADD4E594D8487B150B5F79C6B54Data data = new OrdersE157BADD4E594D8487B150B5F79C6B54Data();
    ServletException ex = null;
    try {
    data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.documentno = vars.getStringParameter("inpdocumentno");     data.dateordered = vars.getRequestGlobalVariable("inpdateordered", windowId + "|DateOrdered");     data.dateacct = vars.getStringParameter("inpdateacct");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.description = vars.getStringParameter("inpdescription");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.deliveryLocationId = vars.getStringParameter("inpdeliveryLocationId");     data.deliveryLocationIdr = vars.getStringParameter("inpdeliveryLocationId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.datepromised = vars.getRequestGlobalVariable("inpdatepromised", windowId + "|DatePromised");     data.scheddeliverydate = vars.getRequestGlobalVariable("inpscheddeliverydate", windowId + "|SchedDeliveryDate");     data.schedtransactiondate = vars.getStringParameter("inpschedtransactiondate");     data.transactiondate = vars.getStringParameter("inptransactiondate");    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N");     data.deliverycomplete = vars.getStringParameter("inpdeliverycomplete", "N");     data.isdelivered = vars.getStringParameter("inpisdelivered", "N");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.isselected = vars.getStringParameter("inpisselected", "N");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.copyfrompo = vars.getStringParameter("inpcopyfrompo");     data.user2Id = vars.getStringParameter("inpuser2Id");     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.generatetemplate = vars.getStringParameter("inpgeneratetemplate");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.docaction = vars.getStringParameter("inpdocaction");     data.dropshipBpartnerId = vars.getStringParameter("inpdropshipBpartnerId");     data.cIncotermsId = vars.getStringParameter("inpcIncotermsId");     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.priorityrule = vars.getStringParameter("inppriorityrule");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N");     data.user1Id = vars.getStringParameter("inpuser1Id");     data.paymentrule = vars.getStringParameter("inppaymentrule");    try {   data.completeordervalue = vars.getNumericParameter("inpcompleteordervalue");  } catch (ServletException paramEx) { ex = paramEx; }     data.adUserId = vars.getStringParameter("inpadUserId");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.incotermsdescription = vars.getStringParameter("inpincotermsdescription");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.dropshipLocationId = vars.getStringParameter("inpdropshipLocationId");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.deliverynotes = vars.getStringParameter("inpdeliverynotes");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.processing = vars.getStringParameter("inpprocessing");     data.freightcostrule = vars.getRequestGlobalVariable("inpfreightcostrule", windowId + "|FreightCostRule");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.posted = vars.getStringParameter("inpposted");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.dropshipUserId = vars.getStringParameter("inpdropshipUserId");     data.deliveryviarule = vars.getRequestGlobalVariable("inpdeliveryviarule", windowId + "|DeliveryViaRule");     data.poreference = vars.getStringParameter("inpporeference"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "C_Order", data.cDoctypetargetId, data.cDoctypeId, false, true);

    
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

   private OrdersE157BADD4E594D8487B150B5F79C6B54Data[] getRelationData(OrdersE157BADD4E594D8487B150B5F79C6B54Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 22);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 22);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 22);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 22);        data[i].deliveryLocationId = FormatUtilities.truncate(data[i].deliveryLocationId, 22);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 50);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 22);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 22);        data[i].dropshipBpartnerId = FormatUtilities.truncate(data[i].dropshipBpartnerId, 22);        data[i].cIncotermsId = FormatUtilities.truncate(data[i].cIncotermsId, 12);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 22);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 22);        data[i].priorityrule = FormatUtilities.truncate(data[i].priorityrule, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 22);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 22);        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 22);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 50);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 22);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 50);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 22);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 22);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 22);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 22);        data[i].incotermsdescription = FormatUtilities.truncate(data[i].incotermsdescription, 50);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 22);        data[i].dropshipLocationId = FormatUtilities.truncate(data[i].dropshipLocationId, 22);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 50);        data[i].deliverynotes = FormatUtilities.truncate(data[i].deliverynotes, 50);        data[i].freightcostrule = FormatUtilities.truncate(data[i].freightcostrule, 50);        data[i].dropshipUserId = FormatUtilities.truncate(data[i].dropshipUserId, 22);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 50);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);}
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
    
  private String getParentID(VariablesSecureApp vars, String strC_Order_ID) throws ServletException {
    String strPC_BPartner_ID = OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectParentID(this, strC_Order_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Order_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|SchedDeliveryDate", data[0].getField("scheddeliverydate"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));    vars.setSessionValue(windowId + "|FreightCostRule", data[0].getField("freightcostrule"));    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].getField("deliveryviarule"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      OrdersE157BADD4E594D8487B150B5F79C6B54Data[] data = OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPartner_ID", windowId), strPC_BPartner_ID, vars.getStringParameter("inpcOrderId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamDeliveryComplete = vars.getSessionValue(tabId + "|paramDeliveryComplete");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    if (vars.getSessionValue(windowId +  "|C_BPartner_ID").isEmpty()) vars.setSessionValue(windowId + "|C_BPartner_ID", vars.getStringParameter("inpcBpartnerId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParamC_Project_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamInvoicedAmt.equals("") && strParamIsCompletelyInvoiced.equals("") && strParamDeliveryComplete.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamInvoicedAmt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Order_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Order_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/BusinessPartner/OrdersE157BADD4E594D8487B150B5F79C6B54_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "OrdersE157BADD4E594D8487B150B5F79C6B54", false, "document.frmMain.inpcOrderId", "grid", "..", "".equals("Y"), "BusinessPartner", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "cOrderId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "OrdersE157BADD4E594D8487B150B5F79C6B54_Relation.html", "BusinessPartner", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "OrdersE157BADD4E594D8487B150B5F79C6B54_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectParentTrl(this, strPC_BPartner_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Order_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_order.dateordered desc";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    OrdersE157BADD4E594D8487B150B5F79C6B54Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamDeliveryComplete = vars.getSessionValue(tabId + "|paramDeliveryComplete");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParamC_Project_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamInvoicedAmt.equals("") && strParamIsCompletelyInvoiced.equals("") && strParamDeliveryComplete.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamInvoicedAmt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPartner_ID", windowId), strPC_BPartner_ID, strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Order_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Order_ID = firstElement(vars, tableSQL);
        if (strC_Order_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPartner_ID", windowId), strPC_BPartner_ID, strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new OrdersE157BADD4E594D8487B150B5F79C6B54Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cOrderId") == null || dataField.getField("cOrderId").equals("")) {
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
        data = OrdersE157BADD4E594D8487B150B5F79C6B54Data.set(strPC_BPartner_ID, Utility.getDefault(this, vars, "AD_User_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectDef2762_0(this, strPC_BPartner_ID), Utility.getDefault(this, vars, "DropShip_Location_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "IsSelected", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "User2_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "TotalLines", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Posted", "N", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), "Y", Utility.getDefault(this, vars, "User1_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Deliverynotes", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "SchedDeliveryDate", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "D", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DropShip_BPartner_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DeliveryViaRule", "P", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DatePromised", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectDef3402_1(this, Utility.getDefault(this, vars, "C_Project_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField)), Utility.getDefault(this, vars, "DocStatus", "DR", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "TransactionDate", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), "", Utility.getDefault(this, vars, "CopyFrom", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectDef2168_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField)), Utility.getDefault(this, vars, "IsDelivered", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "DeliveryRule", "A", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Delivery_Location_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DateAcct", "@#Date@", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "CompleteOrderValue", "0", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "SchedTransactionDate", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "CopyFromPO", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "DeliveryComplete", "N", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), OrdersE157BADD4E594D8487B150B5F79C6B54Data.selectDef2166_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField)), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DateOrdered", "@#Date@", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "B", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Generatetemplate", "N", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "POReference", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DropShip_User_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "TotalPaid", "0", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Incotermsdescription", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "InvoicedAmt", "0", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Processed", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "FreightCostRule", "I", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Description", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "IsPrinted", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "IsInvoiced", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "IsCompletelyInvoiced", "N", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "C_DocType_ID", "0", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "C_Incoterms_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "PriorityRule", "5", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "Processing", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "N", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField), Utility.getDefault(this, vars, "FreightAmt", "", "123", "E157BADD4E594D8487B150B5F79C6B54", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "C_Order", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new OrdersE157BADD4E594D8487B150B5F79C6B54Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(OrdersE157BADD4E594D8487B150B5F79C6B54Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "OrdersE157BADD4E594D8487B150B5F79C6B54", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcOrderId", "", "..", "".equals("Y"), "BusinessPartner", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Order_ID));
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
    OrdersE157BADD4E594D8487B150B5F79C6B54Data data = null;
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
                data.cOrderId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (OrdersE157BADD4E594D8487B150B5F79C6B54Data.getCurrentDBTimestamp(this, data.cOrderId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cOrderId, vars, this);
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
                    data.cOrderId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Order_ID", data.cOrderId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet OrdersE157BADD4E594D8487B150B5F79C6B54. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
