
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;





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

public class ExpensePlan375773FAA7444EE08B21FB8A3DEDD131 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.class);
  
  private static final String windowId = "130";
  private static final String tabId = "375773FAA7444EE08B21FB8A3DEDD131";
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
        String strcProjecttaskexpenseplanId = request.getParameter("inpcProjecttaskexpenseplanId");
         String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcProjecttaskexpenseplanId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Projecttask_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Projecttask_ID);
          
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
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID", "");

      String strC_Projecttaskexpenseplan_ID = vars.getGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID", "");
            if (strPC_Projecttask_ID.equals("")) {
        strPC_Projecttask_ID = getParentID(vars, strC_Projecttaskexpenseplan_ID);
        if (strPC_Projecttask_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Projecttask_ID");
        vars.setSessionValue(windowId + "|C_Projecttask_ID", strPC_Projecttask_ID);
      vars.removeSessionValue(windowId + "|C_Project_ID");
        refreshParentSession(vars, strPC_Projecttask_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Projecttaskexpenseplan_ID.equals("")) strC_Projecttaskexpenseplan_ID = firstElement(vars, tableSQL);
          if (strC_Projecttaskexpenseplan_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Projecttask_ID, strC_Projecttaskexpenseplan_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Projecttaskexpenseplan_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Projecttaskexpenseplan_ID.equals("")) strC_Projecttaskexpenseplan_ID = vars.getRequiredGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID");
      else vars.setSessionValue(windowId + "|C_Projecttaskexpenseplan_ID", strC_Projecttaskexpenseplan_ID);
      
      
      String strPC_Projecttask_ID = getParentID(vars, strC_Projecttaskexpenseplan_ID);
      
      vars.setSessionValue(windowId + "|C_Projecttask_ID", strPC_Projecttask_ID);
      vars.setSessionValue("490|Project Task.view", "EDIT");
      vars.removeSessionValue(windowId + "|C_Project_ID");
      refreshParentSession(vars, strPC_Projecttask_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Projecttask_ID, strC_Projecttaskexpenseplan_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Projecttaskexpenseplan_ID");
      refreshParentSession(vars, strPC_Projecttask_ID);


      String strView = vars.getSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view");
      String strC_Projecttaskexpenseplan_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Projecttaskexpenseplan_ID = firstElement(vars, tableSQL);
          if (strC_Projecttaskexpenseplan_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Projecttaskexpenseplan_ID.equals("")) strC_Projecttaskexpenseplan_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Projecttask_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");

            String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      
      vars.removeSessionValue(windowId + "|C_Projecttaskexpenseplan_ID");
      String strC_Projecttaskexpenseplan_ID="";

      String strView = vars.getSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Projecttaskexpenseplan_ID = firstElement(vars, tableSQL);
        if (strC_Projecttaskexpenseplan_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Projecttask_ID, strC_Projecttaskexpenseplan_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      

      String strC_Projecttaskexpenseplan_ID = vars.getGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID", "");
      vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Projecttask_ID, strC_Projecttaskexpenseplan_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");


      printPageEdit(response, request, vars, true, "", strPC_Projecttask_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Projecttaskexpenseplan_ID = vars.getGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID", "");
      vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      String strC_Projecttaskexpenseplan_ID = vars.getRequiredStringParameter("inpcProjecttaskexpenseplanId");
      
      String strNext = nextElement(vars, strC_Projecttaskexpenseplan_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Projecttask_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      String strC_Projecttaskexpenseplan_ID = vars.getRequiredStringParameter("inpcProjecttaskexpenseplanId");
      
      String strPrevious = previousElement(vars, strC_Projecttaskexpenseplan_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Projecttask_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Projecttaskexpenseplan_ID");
      vars.setSessionValue(windowId + "|C_Projecttask_ID", strPC_Projecttask_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Projecttaskexpenseplan_ID");
      vars.setSessionValue(windowId + "|C_Projecttask_ID", strPC_Projecttask_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Projecttask_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Projecttask_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Projecttask_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Projecttask_ID);      
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
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");
      String strC_Projecttaskexpenseplan_ID = vars.getRequiredGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Projecttask_ID);      
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
          String strNext = nextElement(vars, strC_Projecttaskexpenseplan_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Projecttaskexpenseplan_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      String strC_Projecttaskexpenseplan_ID = vars.getRequiredInStringParameter("inpcProjecttaskexpenseplanId");
      String message = deleteRelation(vars, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cProjecttaskexpenseplanId");
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Projecttask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");

      String strC_Projecttaskexpenseplan_ID = vars.getRequiredStringParameter("inpcProjecttaskexpenseplanId");
      //ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data data = getEditVariables(vars, strPC_Projecttask_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.delete(this, strC_Projecttaskexpenseplan_ID, strPC_Projecttask_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cProjecttaskexpenseplanId");
        vars.setSessionValue(tabId + "|ExpensePlan375773FAA7444EE08B21FB8A3DEDD131.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_Projecttaskexpenseplan_ID, String strPC_Projecttask_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_Projecttaskexpenseplan_ID.startsWith("(")) strC_Projecttaskexpenseplan_ID = strC_Projecttaskexpenseplan_ID.substring(1, strC_Projecttaskexpenseplan_ID.length()-1);
      if (!strC_Projecttaskexpenseplan_ID.equals("")) {
        strC_Projecttaskexpenseplan_ID = Replace.replace(strC_Projecttaskexpenseplan_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_Projecttaskexpenseplan_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.deleteTransactional(conn, this, strKey, strPC_Projecttask_ID)==0) {
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
  private ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Projecttask_ID) throws IOException,ServletException {
    ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data data = new ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data();
    ServletException ex = null;
    try {
    data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.cProjecttaskexpenseplanId = vars.getRequestGlobalVariable("inpcProjecttaskexpenseplanId", windowId + "|C_Projecttaskexpenseplan_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.plannedamt = vars.getNumericParameter("inpplannedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.description = vars.getStringParameter("inpdescription");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cProjecttaskId = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_Projecttask_ID");


    
    

    
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

   private ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[] getRelationData(ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cProjecttaskexpenseplanId = FormatUtilities.truncate(data[i].cProjecttaskexpenseplanId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Projecttask_ID) throws IOException,ServletException {
      ProjectTask490Data[] data = ProjectTask490Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|C_Project_ID"), strPC_Projecttask_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Outsourcing", data[0].outsourcing);    vars.setSessionValue(windowId + "|Taskbegun", data[0].taskbegun);    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].ismaterialdisposed);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|C_ProjectTask_ID", data[0].cProjecttaskId);
      vars.setSessionValue(windowId + "|C_Projecttask_ID", strPC_Projecttask_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Projecttaskexpenseplan_ID) throws ServletException {
    String strPC_Projecttask_ID = ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectParentID(this, strC_Projecttaskexpenseplan_ID);
    if (strPC_Projecttask_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Projecttaskexpenseplan_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Projecttask_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Projecttaskexpenseplan_ID", data[0].getField("cProjecttaskexpenseplanId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Projecttask_ID) throws IOException,ServletException {
      ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[] data = ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Projecttask_ID, vars.getStringParameter("inpcProjecttaskexpenseplanId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Projecttask_ID, String strC_Projecttaskexpenseplan_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    if (vars.getSessionValue(windowId +  "|C_ProjectTask_ID").isEmpty()) vars.setSessionValue(windowId + "|C_ProjectTask_ID", vars.getStringParameter("inpcProjecttaskId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamM_Product_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Projecttaskexpenseplan_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Projecttaskexpenseplan_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/project/Projects/ExpensePlan375773FAA7444EE08B21FB8A3DEDD131_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ExpensePlan375773FAA7444EE08B21FB8A3DEDD131", false, "document.frmMain.inpcProjecttaskexpenseplanId", "grid", "..", "".equals("Y"), "Projects", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Projecttask_ID);

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
    xmlDocument.setParameter("KeyName", "cProjecttaskexpenseplanId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ExpensePlan375773FAA7444EE08B21FB8A3DEDD131_Relation.html", "Projects", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ExpensePlan375773FAA7444EE08B21FB8A3DEDD131_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectParent(this, strPC_Projecttask_ID));
    else xmlDocument.setParameter("parent", ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectParentTrl(this, strPC_Projecttask_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Projecttaskexpenseplan_ID, String strPC_Projecttask_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");

    boolean hasSearchCondition=false;
    if (!(strParamM_Product_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Projecttask_ID, strC_Projecttaskexpenseplan_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Projecttaskexpenseplan_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cProjecttaskexpenseplanId") == null || dataField.getField("cProjecttaskexpenseplanId").equals("")) {
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
        refreshSessionNew(vars, strPC_Projecttask_ID);
        data = ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.set(strPC_Projecttask_ID, "", Utility.getDefault(this, vars, "Createdby", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectDefA854D70DAFB5475C81FE2CD335528395_0(this, Utility.getDefault(this, vars, "Createdby", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField)), "Y", Utility.getDefault(this, vars, "Description", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectDef966429265B1D4186833AA330ECCCB284_1(this, Utility.getDefault(this, vars, "M_Product_ID", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField), ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectDefF597991F30C3405DAD7D6E6D99FF6150_2(this, Utility.getDefault(this, vars, "Updatedby", "", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField)), ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.selectDef9D6A016EE4AB464B8220040587CDDB44(this, strPC_Projecttask_ID), Utility.getDefault(this, vars, "Plannedamt", "0", "130", "375773FAA7444EE08B21FB8A3DEDD131", "", dataField));
        
      }
    } else {
      data = new ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProjectTask490Data.selectOrg(this, strPC_Projecttask_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ExpensePlan375773FAA7444EE08B21FB8A3DEDD131", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcProjecttaskexpenseplanId", "", "..", "".equals("Y"), "Projects", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Projecttaskexpenseplan_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Projecttask_ID) throws IOException, ServletException {
    ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data data = null;
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
            data = getEditVariables(con, vars, strPC_Projecttask_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cProjecttaskexpenseplanId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ExpensePlan375773FAA7444EE08B21FB8A3DEDD131Data.getCurrentDBTimestamp(this, data.cProjecttaskexpenseplanId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cProjecttaskexpenseplanId, vars, this);
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
                    data.cProjecttaskexpenseplanId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Projecttaskexpenseplan_ID", data.cProjecttaskexpenseplanId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ExpensePlan375773FAA7444EE08B21FB8A3DEDD131. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
