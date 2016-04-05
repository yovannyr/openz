
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;





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

public class FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "06CAAFC989CF468EB695B46D23DBD31E";
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
        String strzssmFeedbackVId = request.getParameter("inpzssmFeedbackVId");
         String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmFeedbackVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZssm_Workstep_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZssm_Workstep_V_ID);
          
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
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");

      String strZssm_Feedback_V_ID = vars.getGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID", "");
            if (strPZssm_Workstep_V_ID.equals("")) {
        strPZssm_Workstep_V_ID = getParentID(vars, strZssm_Feedback_V_ID);
        if (strPZssm_Workstep_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zssm_Workstep_V_ID");
        vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
        refreshParentSession(vars, strPZssm_Workstep_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Feedback_V_ID.equals("")) strZssm_Feedback_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Feedback_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Feedback_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Feedback_V_ID.equals("")) strZssm_Feedback_V_ID = vars.getRequiredGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Feedback_V_ID", strZssm_Feedback_V_ID);
      
      
      String strPZssm_Workstep_V_ID = getParentID(vars, strZssm_Feedback_V_ID);
      
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      vars.setSessionValue("035860BB9D4F4D08878CED2F371D7201|Work Steps.view", "EDIT");
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
      refreshParentSession(vars, strPZssm_Workstep_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "RELATION");
        printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zssm_Feedback_V_ID");
      refreshParentSession(vars, strPZssm_Workstep_V_ID);


      String strView = vars.getSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view");
      String strZssm_Feedback_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Feedback_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Feedback_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Feedback_V_ID.equals("")) strZssm_Feedback_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_User_ID", tabId + "|paramAD_User_ID");

            String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      
      vars.removeSessionValue(windowId + "|Zssm_Feedback_V_ID");
      String strZssm_Feedback_V_ID="";

      String strView = vars.getSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Feedback_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Feedback_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      

      String strZssm_Feedback_V_ID = vars.getGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID", "");
      vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "RELATION");
      printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");


      printPageEdit(response, request, vars, true, "", strPZssm_Workstep_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Feedback_V_ID = vars.getGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID", "");
      vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZssm_Feedback_V_ID = vars.getRequiredStringParameter("inpzssmFeedbackVId");
      
      String strNext = nextElement(vars, strZssm_Feedback_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZssm_Feedback_V_ID = vars.getRequiredStringParameter("inpzssmFeedbackVId");
      
      String strPrevious = previousElement(vars, strZssm_Feedback_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Feedback_V_ID");
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Feedback_V_ID");
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZssm_Workstep_V_ID);      
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
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZssm_Feedback_V_ID = vars.getRequiredGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZssm_Workstep_V_ID);      
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
          String strNext = nextElement(vars, strZssm_Feedback_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Feedback_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strZssm_Feedback_V_ID = vars.getRequiredInStringParameter("inpzssmFeedbackVId");
      String message = deleteRelation(vars, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmFeedbackVId");
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strZssm_Feedback_V_ID = vars.getRequiredStringParameter("inpzssmFeedbackVId");
      //FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData data = getEditVariables(vars, strPZssm_Workstep_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.delete(this, strZssm_Feedback_V_ID, strPZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssmFeedbackVId");
        vars.setSessionValue(tabId + "|FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZssm_Feedback_V_ID, String strPZssm_Workstep_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Feedback_V_ID.startsWith("(")) strZssm_Feedback_V_ID = strZssm_Feedback_V_ID.substring(1, strZssm_Feedback_V_ID.length()-1);
      if (!strZssm_Feedback_V_ID.equals("")) {
        strZssm_Feedback_V_ID = Replace.replace(strZssm_Feedback_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Feedback_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.deleteTransactional(conn, this, strKey, strPZssm_Workstep_V_ID)==0) {
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
  private FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData getEditVariables(Connection con, VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
    FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData data = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData();
    ServletException ex = null;
    try {
    data.zssmWorkstepVId = vars.getStringParameter("inpzssmWorkstepVId");     data.zssmWorkstepVIdr = vars.getStringParameter("inpzssmWorkstepVId_R");     data.zssmFeedbackVId = vars.getRequestGlobalVariable("inpzssmFeedbackVId", windowId + "|Zssm_Feedback_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.workdate = vars.getStringParameter("inpworkdate");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");    try {   data.hours = vars.getNumericParameter("inphours");  } catch (ServletException paramEx) { ex = paramEx; }     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cSalaryCategoryId = vars.getStringParameter("inpcSalaryCategoryId");     data.cSalaryCategoryIdr = vars.getStringParameter("inpcSalaryCategoryId_R");     data.maMachineId = vars.getStringParameter("inpmaMachineId");     data.maMachineIdr = vars.getStringParameter("inpmaMachineId_R");     data.description = vars.getStringParameter("inpdescription");     data.url = vars.getStringParameter("inpurl");     data.zssmProductionorderVId = vars.getStringParameter("inpzssmProductionorderVId");    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.hourFrom = vars.getStringParameter("inphourFrom");     data.hourTo = vars.getStringParameter("inphourTo"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmWorkstepVId = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");


    
    

    
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

   private FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] getRelationData(FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);        data[i].zssmFeedbackVId = FormatUtilities.truncate(data[i].zssmFeedbackVId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].cSalaryCategoryId = FormatUtilities.truncate(data[i].cSalaryCategoryId, 32);        data[i].maMachineId = FormatUtilities.truncate(data[i].maMachineId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].url = FormatUtilities.truncate(data[i].url, 50);        data[i].zssmProductionorderVId = FormatUtilities.truncate(data[i].zssmProductionorderVId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
      WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|zssm_productionorder_v_id"), strPZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Receiving_Locator", data[0].receivingLocator);    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].issuingLocator);    vars.setSessionValue(windowId + "|Taskbegun", data[0].taskbegun);    vars.setSessionValue(windowId + "|IsComplete", data[0].iscomplete);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].zssmWorkstepVId);    vars.setSessionValue(windowId + "|Outsourcing", data[0].outsourcing);    vars.setSessionValue(windowId + "|QtyLeft", data[0].qtyleft);    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].ismaterialdisposed);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZssm_Feedback_V_ID) throws ServletException {
    String strPZssm_Workstep_V_ID = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectParentID(this, strZssm_Feedback_V_ID);
    if (strPZssm_Workstep_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZssm_Feedback_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZssm_Workstep_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zssm_Feedback_V_ID", data[0].getField("zssmFeedbackVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
      FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] data = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, vars.getStringParameter("inpzssmFeedbackVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZssm_Workstep_V_ID, String strZssm_Feedback_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");

    if (vars.getSessionValue(windowId +  "|Zssm_Workstep_V_ID").isEmpty()) vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", vars.getStringParameter("inpzssmWorkstepVId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_User_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Feedback_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Feedback_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E", false, "document.frmMain.inpzssmFeedbackVId", "grid", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPZssm_Workstep_V_ID);

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
    xmlDocument.setParameter("KeyName", "zssmFeedbackVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectParent(this, strPZssm_Workstep_V_ID));
    else xmlDocument.setParameter("parent", FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectParentTrl(this, strPZssm_Workstep_V_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Feedback_V_ID, String strPZssm_Workstep_V_ID, TableSQLData tableSQL)
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
    FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_User_ID = vars.getSessionValue(tabId + "|paramAD_User_ID");

    boolean hasSearchCondition=false;
    if (!(strParamAD_User_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Feedback_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strZssm_Feedback_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Feedback_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, strZssm_Feedback_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmFeedbackVId") == null || dataField.getField("zssmFeedbackVId").equals("")) {
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
        refreshSessionNew(vars, strPZssm_Workstep_V_ID);
        data = FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.set(strPZssm_Workstep_V_ID, "", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Zssm_Productionorder_V_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectDef6DF1DBCDF7414D599E6D831563111F5C_0(this, Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField)), Utility.getDefault(this, vars, "Actualcostamount", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), "Y", Utility.getDefault(this, vars, "Workdate", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Url", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "MA_Machine_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.selectDefF025FC1B7D2E4F18A0332BD422842C69_1(this, Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField)), Utility.getDefault(this, vars, "Hours", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Hour_From", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "C_Salary_Category_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField), Utility.getDefault(this, vars, "Hour_To", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "06CAAFC989CF468EB695B46D23DBD31E", "", dataField));
        
      }
    } else {
      data = new FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectOrg(this, strPZssm_Workstep_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmFeedbackVId", "", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Feedback_V_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZssm_Workstep_V_ID) throws IOException, ServletException {
    FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData data = null;
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
            data = getEditVariables(con, vars, strPZssm_Workstep_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zssmFeedbackVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (FeedbackOverview06CAAFC989CF468EB695B46D23DBD31EData.getCurrentDBTimestamp(this, data.zssmFeedbackVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssmFeedbackVId, vars, this);
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
                    data.zssmFeedbackVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Feedback_V_ID", data.zssmFeedbackVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet FeedbackOverview06CAAFC989CF468EB695B46D23DBD31E. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
