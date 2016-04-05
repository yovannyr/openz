
package org.openbravo.erpWindows.SalesOrder;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;



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

public class Header extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Header.class);
  
  private static final String windowId = "143";
  private static final String tabId = "186";
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
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcOrderId.equals(""))
              total = saveRecord(vars, myError, 'U');
          else
              total = saveRecord(vars, myError, 'I');
          
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

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Header.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Order_ID.equals("")) strC_Order_ID = firstElement(vars, tableSQL);
          if (strC_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Order_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Order_ID.equals("")) strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      else vars.setSessionValue(windowId + "|C_Order_ID", strC_Order_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Header.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Header.view", "RELATION");
        printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Header.view");
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
        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Org_ID", tabId + "|paramAD_Org_ID");
vars.getRequestGlobalVariable("inpParamDocumentNo", tabId + "|paramDocumentNo");
vars.getRequestGlobalVariable("inpParamName", tabId + "|paramName");
vars.getRequestGlobalVariable("inpParamPOReference", tabId + "|paramPOReference");
vars.getRequestGlobalVariable("inpParamDateOrdered", tabId + "|paramDateOrdered");
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParambpzipcode", tabId + "|parambpzipcode");
vars.getRequestGlobalVariable("inpParamC_Project_ID", tabId + "|paramC_Project_ID");
vars.getRequestGlobalVariable("inpParamSalesRep_ID", tabId + "|paramSalesRep_ID");
vars.getRequestGlobalVariable("inpParamGrandTotal", tabId + "|paramGrandTotal");
vars.getRequestGlobalVariable("inpParamInvoiceRule", tabId + "|paramInvoiceRule");
vars.getRequestGlobalVariable("inpParamDatePromised", tabId + "|paramDatePromised");
vars.getRequestGlobalVariable("inpParamC_DocType_ID", tabId + "|paramC_DocType_ID");
vars.getRequestGlobalVariable("inpParamDocStatus", tabId + "|paramDocStatus");
vars.getRequestGlobalVariable("inpParamProposalstatus", tabId + "|paramProposalstatus");
vars.getRequestGlobalVariable("inpParamInvoicedAmt", tabId + "|paramInvoicedAmt");
vars.getRequestGlobalVariable("inpParamIsCompletelyInvoiced", tabId + "|paramIsCompletelyInvoiced");
vars.getRequestGlobalVariable("inpParamDeliveryComplete", tabId + "|paramDeliveryComplete");
vars.getRequestGlobalVariable("inpParamIspaid", tabId + "|paramIspaid");
vars.getRequestGlobalVariable("inpParamDateOrdered_f", tabId + "|paramDateOrdered_f");
vars.getRequestGlobalVariable("inpParamGrandTotal_f", tabId + "|paramGrandTotal_f");
vars.getRequestGlobalVariable("inpParamDatePromised_f", tabId + "|paramDatePromised_f");
vars.getRequestGlobalVariable("inpParamInvoicedAmt_f", tabId + "|paramInvoicedAmt_f");

      
      
      vars.removeSessionValue(windowId + "|C_Order_ID");
      String strC_Order_ID="";

      String strView = vars.getSessionValue(tabId + "|Header.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Order_ID = firstElement(vars, tableSQL);
        if (strC_Order_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Header.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|Header.view", "RELATION");
      printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|Header.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strNext = nextElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strPrevious = previousElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Header.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Header.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Header.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Header.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Order_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Header.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Header.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Order_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {

      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {

      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {

      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I');      
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

      String strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U');      
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

      String strC_Order_ID = vars.getRequiredInStringParameter("inpcOrderId");
      String message = deleteRelation(vars, strC_Order_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cOrderId");
        vars.setSessionValue(tabId + "|Header.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      //HeaderData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = HeaderData.delete(this, strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.setSessionValue(tabId + "|Header.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONDocAction104")) {
        vars.setSessionValue("button104.strdocaction", vars.getStringParameter("inpdocaction"));
        vars.setSessionValue("button104.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button104.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button104.strClient", vars.getStringParameter("inpadClientId"));
        vars.setSessionValue("button104.inpdocstatus", vars.getRequiredStringParameter("inpdocstatus"));

        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button104.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "104", request.getServletPath());    
     } else if (vars.commandIn("BUTTON104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strdocaction = vars.getSessionValue("button104.strdocaction");
        String strProcessing = vars.getSessionValue("button104.strProcessing");
        String strOrg = vars.getSessionValue("button104.strOrg");
        String strClient = vars.getSessionValue("button104.strClient");
        
        String strdocstatus = vars.getSessionValue("button104.inpdocstatus");
String stradTableId = "259";

        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDocAction104(response, vars, strC_Order_ID, strdocaction, strProcessing);
        }

     } else if (vars.commandIn("BUTTONGenerateproject453D08EFFA694D2E9232AB89680F74DA")) {
        vars.setSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strgenerateproject", vars.getStringParameter("inpgenerateproject"));
        vars.setSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button453D08EFFA694D2E9232AB89680F74DA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "453D08EFFA694D2E9232AB89680F74DA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON453D08EFFA694D2E9232AB89680F74DA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strgenerateproject = vars.getSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strgenerateproject");
        String strProcessing = vars.getSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strProcessing");
        String strOrg = vars.getSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strOrg");
        String strClient = vars.getSessionValue("button453D08EFFA694D2E9232AB89680F74DA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerateproject453D08EFFA694D2E9232AB89680F74DA(response, vars, strC_Order_ID, strgenerateproject, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCloseproject150F4C763BE94C1F8CD6313DA7FA7631")) {
        vars.setSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strcloseproject", vars.getStringParameter("inpcloseproject"));
        vars.setSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button150F4C763BE94C1F8CD6313DA7FA7631.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "150F4C763BE94C1F8CD6313DA7FA7631", request.getServletPath());    
     } else if (vars.commandIn("BUTTON150F4C763BE94C1F8CD6313DA7FA7631")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strcloseproject = vars.getSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strcloseproject");
        String strProcessing = vars.getSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strProcessing");
        String strOrg = vars.getSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strOrg");
        String strClient = vars.getSessionValue("button150F4C763BE94C1F8CD6313DA7FA7631.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCloseproject150F4C763BE94C1F8CD6313DA7FA7631(response, vars, strC_Order_ID, strcloseproject, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreatedropshiporder94ABF1BD3F964A5E9F5536455E4E2C20")) {
        vars.setSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strcreatedropshiporder", vars.getStringParameter("inpcreatedropshiporder"));
        vars.setSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button94ABF1BD3F964A5E9F5536455E4E2C20.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "94ABF1BD3F964A5E9F5536455E4E2C20", request.getServletPath());    
     } else if (vars.commandIn("BUTTON94ABF1BD3F964A5E9F5536455E4E2C20")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strcreatedropshiporder = vars.getSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strcreatedropshiporder");
        String strProcessing = vars.getSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strProcessing");
        String strOrg = vars.getSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strOrg");
        String strClient = vars.getSessionValue("button94ABF1BD3F964A5E9F5536455E4E2C20.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatedropshiporder94ABF1BD3F964A5E9F5536455E4E2C20(response, vars, strC_Order_ID, strcreatedropshiporder, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONDocAction104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        @SuppressWarnings("unused")
        String strdocaction = vars.getStringParameter("inpdocaction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "104", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          HeaderData.updateDocAction(this, strdocaction, strC_Order_ID);

          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONGenerateproject453D08EFFA694D2E9232AB89680F74DA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        @SuppressWarnings("unused")
        String strgenerateproject = vars.getStringParameter("inpgenerateproject");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "453D08EFFA694D2E9232AB89680F74DA", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strvalue = vars.getStringParameter("inpvalue");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "VALUE", strvalue, vars.getClient(), vars.getOrg(), vars.getUser());
String strname = vars.getStringParameter("inpname");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "NAME", strname, vars.getClient(), vars.getOrg(), vars.getUser());

          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONCloseproject150F4C763BE94C1F8CD6313DA7FA7631")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        @SuppressWarnings("unused")
        String strcloseproject = vars.getStringParameter("inpcloseproject");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "150F4C763BE94C1F8CD6313DA7FA7631", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONCreatedropshiporder94ABF1BD3F964A5E9F5536455E4E2C20")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        @SuppressWarnings("unused")
        String strcreatedropshiporder = vars.getStringParameter("inpcreatedropshiporder");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "94ABF1BD3F964A5E9F5536455E4E2C20", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());

          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);






    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strC_Order_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Order_ID.startsWith("(")) strC_Order_ID = strC_Order_ID.substring(1, strC_Order_ID.length()-1);
      if (!strC_Order_ID.equals("")) {
        strC_Order_ID = Replace.replace(strC_Order_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Order_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (HeaderData.deleteTransactional(conn, this, strKey)==0) {
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
  private HeaderData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    HeaderData data = new HeaderData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.poreference = vars.getStringParameter("inpporeference");     data.dateordered = vars.getRequestGlobalVariable("inpdateordered", windowId + "|DateOrdered");     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.name = vars.getStringParameter("inpname");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.description = vars.getStringParameter("inpdescription");     data.deliverynotes = vars.getStringParameter("inpdeliverynotes");     data.internalnote = vars.getStringParameter("inpinternalnote");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.bpzipcode = vars.getStringParameter("inpbpzipcode");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.invoiceruler = vars.getStringParameter("inpinvoicerule_R");     data.estpropability = vars.getStringParameter("inpestpropability");     data.estpropabilityr = vars.getStringParameter("inpestpropability_R");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.priorityrule = vars.getStringParameter("inppriorityrule");     data.priorityruler = vars.getStringParameter("inppriorityrule_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.cIncotermsId = vars.getStringParameter("inpcIncotermsId");     data.cIncotermsIdr = vars.getStringParameter("inpcIncotermsId_R");     data.deliveryLocationId = vars.getStringParameter("inpdeliveryLocationId");     data.deliveryLocationIdr = vars.getStringParameter("inpdeliveryLocationId_R");     data.deliveryviarule = vars.getRequestGlobalVariable("inpdeliveryviarule", windowId + "|DeliveryViaRule");     data.deliveryviaruler = vars.getStringParameter("inpdeliveryviarule_R");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.weight = vars.getNumericParameter("inpweight");  } catch (ServletException paramEx) { ex = paramEx; }     data.weightUom = vars.getStringParameter("inpweightUom");     data.weightUomr = vars.getStringParameter("inpweightUom_R");     data.freightcostrule = vars.getRequestGlobalVariable("inpfreightcostrule", windowId + "|FreightCostRule");     data.freightcostruler = vars.getStringParameter("inpfreightcostrule_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.orderselfjoin = vars.getStringParameter("inporderselfjoin");     data.orderselfjoinr = vars.getStringParameter("inporderselfjoin_R");     data.firstschedinvoicedate = vars.getStringParameter("inpfirstschedinvoicedate");     data.datepromised = vars.getRequestGlobalVariable("inpdatepromised", windowId + "|DatePromised");     data.scheddeliverydate = vars.getRequestGlobalVariable("inpscheddeliverydate", windowId + "|SchedDeliveryDate");     data.schedtransactiondate = vars.getStringParameter("inpschedtransactiondate");     data.transactiondate = vars.getStringParameter("inptransactiondate");     data.contractdate = vars.getStringParameter("inpcontractdate");     data.enddate = vars.getStringParameter("inpenddate");     data.invoicefrequence = vars.getStringParameter("inpinvoicefrequence");     data.invoicefrequencer = vars.getStringParameter("inpinvoicefrequence_R");     data.isinvoiceafterfirstcycle = vars.getStringParameter("inpisinvoiceafterfirstcycle", "N");     data.quarterlyMonth = vars.getStringParameter("inpquarterlyMonth");     data.quarterlyMonthr = vars.getStringParameter("inpquarterlyMonth_R");     data.yearlyMonth = vars.getStringParameter("inpyearlyMonth");     data.yearlyMonthr = vars.getStringParameter("inpyearlyMonth_R");     data.weeklyDay = vars.getStringParameter("inpweeklyDay");     data.weeklyDayr = vars.getStringParameter("inpweeklyDay_R");    try {   data.monthlyDay = vars.getNumericParameter("inpmonthlyDay");  } catch (ServletException paramEx) { ex = paramEx; }     data.proposalstatus = vars.getStringParameter("inpproposalstatus");     data.proposalstatusr = vars.getStringParameter("inpproposalstatus_R");     data.lostproposalfixedreason = vars.getStringParameter("inplostproposalfixedreason");     data.lostproposalfixedreasonr = vars.getStringParameter("inplostproposalfixedreason_R");     data.lostproposalreason = vars.getStringParameter("inplostproposalreason");    try {   data.totallinesonetime = vars.getNumericParameter("inptotallinesonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotalonetime = vars.getNumericParameter("inpgrandtotalonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.completeordervalue = vars.getNumericParameter("inpcompleteordervalue");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N");     data.deliverycomplete = vars.getStringParameter("inpdeliverycomplete", "N");     data.subscriptionchangedate = vars.getStringParameter("inpsubscriptionchangedate");     data.docaction = vars.getStringParameter("inpdocaction");     data.generatetemplate = vars.getStringParameter("inpgeneratetemplate");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.copyfrompo = vars.getStringParameter("inpcopyfrompo");     data.generateproject = vars.getStringParameter("inpgenerateproject");     data.closeproject = vars.getStringParameter("inpcloseproject");     data.createdropshiporder = vars.getStringParameter("inpcreatedropshiporder");     data.isdelivered = vars.getStringParameter("inpisdelivered", "N");     data.incotermsdescription = vars.getStringParameter("inpincotermsdescription");     data.performanceperiodstart = vars.getStringParameter("inpperformanceperiodstart");     data.performanceperiodend = vars.getStringParameter("inpperformanceperiodend");     data.ispaid = vars.getStringParameter("inpispaid", "N");     data.transactionreference = vars.getStringParameter("inptransactionreference");     data.isselected = vars.getStringParameter("inpisselected", "N");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.posted = vars.getStringParameter("inpposted");     data.processing = vars.getStringParameter("inpprocessing");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.dateprinted = vars.getStringParameter("inpdateprinted");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



          vars.getGlobalVariable("inpordertype", windowId + "|ORDERTYPE", "");
    
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

   private HeaderData[] getRelationData(HeaderData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 8);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 11);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 12);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 16);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].deliverynotes = FormatUtilities.truncate(data[i].deliverynotes, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 34);        data[i].bpzipcode = FormatUtilities.truncate(data[i].bpzipcode, 10);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 40);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 48);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 20);        data[i].estpropability = FormatUtilities.truncate(data[i].estpropability, 10);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 20);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 21);        data[i].priorityrule = FormatUtilities.truncate(data[i].priorityrule, 21);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 20);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 48);        data[i].cIncotermsId = FormatUtilities.truncate(data[i].cIncotermsId, 44);        data[i].deliveryLocationId = FormatUtilities.truncate(data[i].deliveryLocationId, 44);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 21);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].weightUom = FormatUtilities.truncate(data[i].weightUom, 32);        data[i].freightcostrule = FormatUtilities.truncate(data[i].freightcostrule, 21);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].orderselfjoin = FormatUtilities.truncate(data[i].orderselfjoin, 32);        data[i].invoicefrequence = FormatUtilities.truncate(data[i].invoicefrequence, 20);        data[i].quarterlyMonth = FormatUtilities.truncate(data[i].quarterlyMonth, 50);        data[i].yearlyMonth = FormatUtilities.truncate(data[i].yearlyMonth, 50);        data[i].weeklyDay = FormatUtilities.truncate(data[i].weeklyDay, 50);        data[i].proposalstatus = FormatUtilities.truncate(data[i].proposalstatus, 30);        data[i].lostproposalfixedreason = FormatUtilities.truncate(data[i].lostproposalfixedreason, 30);        data[i].lostproposalreason = FormatUtilities.truncate(data[i].lostproposalreason, 50);        data[i].incotermsdescription = FormatUtilities.truncate(data[i].incotermsdescription, 50);        data[i].transactionreference = FormatUtilities.truncate(data[i].transactionreference, 32);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 10);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].getField("deliveryviarule"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|FreightCostRule", data[0].getField("freightcostrule"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|SchedDeliveryDate", data[0].getField("scheddeliverydate"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcOrderId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamDeliveryComplete = vars.getSessionValue(tabId + "|paramDeliveryComplete");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamProposalstatus.equals("") && strParamInvoicedAmt.equals("") && strParamIsCompletelyInvoiced.equals("") && strParamDeliveryComplete.equals("") && strParamIspaid.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamInvoicedAmt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Order_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Order_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/SalesOrder/Header_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Header", false, "document.frmMain.inpcOrderId", "grid", "../orders/print.html", "N".equals("Y"), "SalesOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());



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
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Header_Relation.html", "SalesOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Header_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_order.documentno desc";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    HeaderData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamDeliveryComplete = vars.getSessionValue(tabId + "|paramDeliveryComplete");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Org_ID.equals("") && strParamDocumentNo.equals("") && strParamName.equals("") && strParamPOReference.equals("") && strParamDateOrdered.equals("") && strParamC_BPartner_ID.equals("") && strParambpzipcode.equals("") && strParamC_Project_ID.equals("") && strParamSalesRep_ID.equals("") && strParamGrandTotal.equals("") && strParamInvoiceRule.equals("") && strParamDatePromised.equals("") && strParamC_DocType_ID.equals("") && strParamDocStatus.equals("") && strParamProposalstatus.equals("") && strParamInvoicedAmt.equals("") && strParamIsCompletelyInvoiced.equals("") && strParamDeliveryComplete.equals("") && strParamIspaid.equals("") && strParamDateOrdered_f.equals("") && strParamGrandTotal_f.equals("") && strParamDatePromised_f.equals("") && strParamInvoicedAmt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Order_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new HeaderData[0];
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
    
        String strORDERTYPE = HeaderData.selectAux6(this, ((dataField!=null)?dataField.getField("cDoctypetargetId"):((data==null || data.length==0)?"":data[0].cDoctypetargetId)));
    vars.setSessionValue(windowId + "|ORDERTYPE", strORDERTYPE);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars);
        data = HeaderData.set(Utility.getDefault(this, vars, "C_BPartner_ID", "", "143", "186", "", dataField), HeaderData.selectDef2762_0(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "143", "186", "", dataField)), Utility.getDefault(this, vars, "PriorityRule", "5", "143", "186", "", dataField), Utility.getDefault(this, vars, "Generateproject", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "143", "186", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Incoterms_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsSelected", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "FreightAmt", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "performanceperiodstart", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Qty", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "performanceperiodend", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "TotalLines", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Ispaid", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Enddate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Weight_Uom", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Proposalstatus", "OP", "143", "186", "", dataField), Utility.getDefault(this, vars, "Posted", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Weight", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Name", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "Invoicefrequence", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "SchedDeliveryDate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Internalnote", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Totallinesonetime", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "FreightCostRule", "I", "143", "186", "", dataField), Utility.getDefault(this, vars, "DatePromised", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Contractdate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "DocStatus", "DR", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "143", "186", "", dataField), HeaderData.selectDef3402_1(this, Utility.getDefault(this, vars, "C_Project_ID", "", "143", "186", "", dataField)), Utility.getDefault(this, vars, "PaymentRule", "B", "143", "186", "", dataField), Utility.getDefault(this, vars, "Generatetemplate", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "TransactionDate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Lostproposalfixedreason", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "143", "186", "", dataField), HeaderData.selectDef2168_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "143", "186", "", dataField)), Utility.getDefault(this, vars, "Delivery_Location_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "POReference", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "SchedTransactionDate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Createdropshiporder", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "DeliveryComplete", "N", "143", "186", "N", dataField), "", Utility.getDefault(this, vars, "CopyFrom", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "IsDelivered", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "DeliveryRule", "A", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "143", "186", "N", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "143", "186", "", dataField), HeaderData.selectDef2166_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "143", "186", "", dataField)), Utility.getDefault(this, vars, "DateOrdered", "@#Date@", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Monthly_Day", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "CompleteOrderValue", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "CopyFromPO", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Subscriptionchangedate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "143", "186", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "143", "186", "", dataField), Utility.getDefault(this, vars, "TotalPaid", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "bpzipcode", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Grandtotalonetime", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "D", "143", "186", "", dataField), Utility.getDefault(this, vars, "Closeproject", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Transactionreference", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Isinvoiceafterfirstcycle", "Y", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Deliverynotes", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Incotermsdescription", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "InvoicedAmt", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "Processed", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "DeliveryViaRule", "P", "143", "186", "", dataField), Utility.getDefault(this, vars, "Weekly_Day", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Estpropability", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Description", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "143", "186", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "135", Utility.getDefault(this, vars, "DocAction", "CO", "143", "186", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "135", Utility.getDefault(this, vars, "DocAction", "CO", "143", "186", "N", dataField))), Utility.getDefault(this, vars, "IsPrinted", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsInvoiced", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Orderselfjoin", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "IsCompletelyInvoiced", "N", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Lostproposalreason", "", "143", "186", "", dataField), "Y", Utility.getDefault(this, vars, "C_DocType_ID", "0", "143", "186", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Quarterly_Month", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Firstschedinvoicedate", "", "143", "186", "", dataField), Utility.getDefault(this, vars, "Processing", "", "143", "186", "N", dataField), Utility.getDefault(this, vars, "Yearly_Month", "", "143", "186", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "C_Order", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new HeaderData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(HeaderData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Header", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcOrderId", "", "../orders/print.html", "N".equals("Y"), "SalesOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Order_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
  
    void printPageButtonDocAction104(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strdocaction, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "104",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "104" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"104" );
        String isDocAction=UtilsData.isProcessDocAction(this, "104");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "259",strC_Order_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "259", strC_Order_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strdocaction, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "104");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONDocAction" + "104" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Header_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "104");
        script.addHiddenfield("inpKey",strC_Order_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("104");
        vars.removeMessage("104");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButtonGenerateproject453D08EFFA694D2E9232AB89680F74DA(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strgenerateproject, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "453D08EFFA694D2E9232AB89680F74DA",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "453D08EFFA694D2E9232AB89680F74DA" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"453D08EFFA694D2E9232AB89680F74DA" );
        String isDocAction=UtilsData.isProcessDocAction(this, "453D08EFFA694D2E9232AB89680F74DA");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "259",strC_Order_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "259", strC_Order_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strgenerateproject, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "453D08EFFA694D2E9232AB89680F74DA");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONGenerateproject" + "453D08EFFA694D2E9232AB89680F74DA" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Header_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "453D08EFFA694D2E9232AB89680F74DA");
        script.addHiddenfield("inpKey",strC_Order_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("453D08EFFA694D2E9232AB89680F74DA");
        vars.removeMessage("453D08EFFA694D2E9232AB89680F74DA");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButtonCloseproject150F4C763BE94C1F8CD6313DA7FA7631(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strcloseproject, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "150F4C763BE94C1F8CD6313DA7FA7631",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "150F4C763BE94C1F8CD6313DA7FA7631" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"150F4C763BE94C1F8CD6313DA7FA7631" );
        String isDocAction=UtilsData.isProcessDocAction(this, "150F4C763BE94C1F8CD6313DA7FA7631");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "259",strC_Order_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "259", strC_Order_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcloseproject, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "150F4C763BE94C1F8CD6313DA7FA7631");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCloseproject" + "150F4C763BE94C1F8CD6313DA7FA7631" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Header_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "150F4C763BE94C1F8CD6313DA7FA7631");
        script.addHiddenfield("inpKey",strC_Order_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("150F4C763BE94C1F8CD6313DA7FA7631");
        vars.removeMessage("150F4C763BE94C1F8CD6313DA7FA7631");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButtonCreatedropshiporder94ABF1BD3F964A5E9F5536455E4E2C20(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strcreatedropshiporder, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "94ABF1BD3F964A5E9F5536455E4E2C20",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "94ABF1BD3F964A5E9F5536455E4E2C20" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"94ABF1BD3F964A5E9F5536455E4E2C20" );
        String isDocAction=UtilsData.isProcessDocAction(this, "94ABF1BD3F964A5E9F5536455E4E2C20");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "259",strC_Order_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "259", strC_Order_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcreatedropshiporder, dataDocAction, "ID","",true,"");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "94ABF1BD3F964A5E9F5536455E4E2C20");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCreatedropshiporder" + "94ABF1BD3F964A5E9F5536455E4E2C20" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Header_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "94ABF1BD3F964A5E9F5536455E4E2C20");
        script.addHiddenfield("inpKey",strC_Order_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("94ABF1BD3F964A5E9F5536455E4E2C20");
        vars.removeMessage("94ABF1BD3F964A5E9F5536455E4E2C20");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }






    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strCREATEPROJECTFROMSO=\"" +Utility.getContext(this, vars, "CREATEPROJECTFROMSO", windowId) + "\";\nvar strCLOSEPROJECTFROMSO=\"" +Utility.getContext(this, vars, "CLOSEPROJECTFROMSO", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strDOCNOREADONLY=\"" + Utility.getContext(this, vars, "DOCNOREADONLY", windowId) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    HeaderData data = null;
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
            data = getEditVariables(con, vars);
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
		       if (HeaderData.getCurrentDBTimestamp(this, data.cOrderId).equals(
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
                    
                        //BUTTON TEXT FILLING
                    data.docactionBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "135", data.getField("DocAction"));
                    
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
    return "Servlet Header. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
