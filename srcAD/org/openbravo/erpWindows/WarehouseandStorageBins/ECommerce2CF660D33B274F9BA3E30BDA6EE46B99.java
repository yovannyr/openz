
package org.openbravo.erpWindows.WarehouseandStorageBins;





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

public class ECommerce2CF660D33B274F9BA3E30BDA6EE46B99 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.class);
  
  private static final String windowId = "139";
  private static final String tabId = "2CF660D33B274F9BA3E30BDA6EE46B99";
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
        String strzseWarehouseShopId = request.getParameter("inpzseWarehouseShopId");
         String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzseWarehouseShopId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Warehouse_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Warehouse_ID);
          
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
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID", "");

      String strZSE_Warehouse_Shop_ID = vars.getGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID", "");
            if (strPM_Warehouse_ID.equals("")) {
        strPM_Warehouse_ID = getParentID(vars, strZSE_Warehouse_Shop_ID);
        if (strPM_Warehouse_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Warehouse_ID");
        vars.setSessionValue(windowId + "|M_Warehouse_ID", strPM_Warehouse_ID);

        refreshParentSession(vars, strPM_Warehouse_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZSE_Warehouse_Shop_ID.equals("")) strZSE_Warehouse_Shop_ID = firstElement(vars, tableSQL);
          if (strZSE_Warehouse_Shop_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Warehouse_ID, strZSE_Warehouse_Shop_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZSE_Warehouse_Shop_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZSE_Warehouse_Shop_ID.equals("")) strZSE_Warehouse_Shop_ID = vars.getRequiredGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID");
      else vars.setSessionValue(windowId + "|ZSE_Warehouse_Shop_ID", strZSE_Warehouse_Shop_ID);
      
      
      String strPM_Warehouse_ID = getParentID(vars, strZSE_Warehouse_Shop_ID);
      
      vars.setSessionValue(windowId + "|M_Warehouse_ID", strPM_Warehouse_ID);
      vars.setSessionValue("177|Warehouse.view", "EDIT");

      refreshParentSession(vars, strPM_Warehouse_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "EDIT");

        printPageEdit(response, request, vars, false, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Warehouse_ID, strZSE_Warehouse_Shop_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|ZSE_Warehouse_Shop_ID");
      refreshParentSession(vars, strPM_Warehouse_ID);


      String strView = vars.getSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view");
      String strZSE_Warehouse_Shop_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZSE_Warehouse_Shop_ID = firstElement(vars, tableSQL);
          if (strZSE_Warehouse_Shop_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZSE_Warehouse_Shop_ID.equals("")) strZSE_Warehouse_Shop_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Warehouse_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamZSE_Shop_ID", tabId + "|paramZSE_Shop_ID");
vars.getRequestGlobalVariable("inpParamM_Warehouse_ID", tabId + "|paramM_Warehouse_ID");

            String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      
      vars.removeSessionValue(windowId + "|ZSE_Warehouse_Shop_ID");
      String strZSE_Warehouse_Shop_ID="";

      String strView = vars.getSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZSE_Warehouse_Shop_ID = firstElement(vars, tableSQL);
        if (strZSE_Warehouse_Shop_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Warehouse_ID, strZSE_Warehouse_Shop_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      

      String strZSE_Warehouse_Shop_ID = vars.getGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID", "");
      vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Warehouse_ID, strZSE_Warehouse_Shop_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");


      printPageEdit(response, request, vars, true, "", strPM_Warehouse_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZSE_Warehouse_Shop_ID = vars.getGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID", "");
      vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      String strZSE_Warehouse_Shop_ID = vars.getRequiredStringParameter("inpzseWarehouseShopId");
      
      String strNext = nextElement(vars, strZSE_Warehouse_Shop_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Warehouse_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      String strZSE_Warehouse_Shop_ID = vars.getRequiredStringParameter("inpzseWarehouseShopId");
      
      String strPrevious = previousElement(vars, strZSE_Warehouse_Shop_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Warehouse_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|ZSE_Warehouse_Shop_ID");
      vars.setSessionValue(windowId + "|M_Warehouse_ID", strPM_Warehouse_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|ZSE_Warehouse_Shop_ID");
      vars.setSessionValue(windowId + "|M_Warehouse_ID", strPM_Warehouse_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Warehouse_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Warehouse_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Warehouse_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Warehouse_ID);      
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
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");
      String strZSE_Warehouse_Shop_ID = vars.getRequiredGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Warehouse_ID);      
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
          String strNext = nextElement(vars, strZSE_Warehouse_Shop_ID, tableSQL);
          vars.setSessionValue(windowId + "|ZSE_Warehouse_Shop_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      String strZSE_Warehouse_Shop_ID = vars.getRequiredInStringParameter("inpzseWarehouseShopId");
      String message = deleteRelation(vars, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zseWarehouseShopId");
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPM_Warehouse_ID = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");

      String strZSE_Warehouse_Shop_ID = vars.getRequiredStringParameter("inpzseWarehouseShopId");
      //ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data data = getEditVariables(vars, strPM_Warehouse_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.delete(this, strZSE_Warehouse_Shop_ID, strPM_Warehouse_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zseWarehouseShopId");
        vars.setSessionValue(tabId + "|ECommerce2CF660D33B274F9BA3E30BDA6EE46B99.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strZSE_Warehouse_Shop_ID, String strPM_Warehouse_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZSE_Warehouse_Shop_ID.startsWith("(")) strZSE_Warehouse_Shop_ID = strZSE_Warehouse_Shop_ID.substring(1, strZSE_Warehouse_Shop_ID.length()-1);
      if (!strZSE_Warehouse_Shop_ID.equals("")) {
        strZSE_Warehouse_Shop_ID = Replace.replace(strZSE_Warehouse_Shop_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZSE_Warehouse_Shop_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.deleteTransactional(conn, this, strKey, strPM_Warehouse_ID)==0) {
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
  private ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Warehouse_ID) throws IOException,ServletException {
    ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data data = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data();
    ServletException ex = null;
    try {
    data.zseWarehouseShopId = vars.getRequestGlobalVariable("inpzseWarehouseShopId", windowId + "|ZSE_Warehouse_Shop_ID");     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.zseShopId = vars.getStringParameter("inpzseShopId");     data.zseShopIdr = vars.getStringParameter("inpzseShopId_R");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mWarehouseId = vars.getGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");


    
    

    
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

   private ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] getRelationData(ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zseWarehouseShopId = FormatUtilities.truncate(data[i].zseWarehouseShopId, 32);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zseShopId = FormatUtilities.truncate(data[i].zseShopId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Warehouse_ID) throws IOException,ServletException {
      WarehouseData[] data = WarehouseData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Warehouse_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);
      vars.setSessionValue(windowId + "|M_Warehouse_ID", strPM_Warehouse_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZSE_Warehouse_Shop_ID) throws ServletException {
    String strPM_Warehouse_ID = ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectParentID(this, strZSE_Warehouse_Shop_ID);
    if (strPM_Warehouse_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZSE_Warehouse_Shop_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Warehouse_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|ZSE_Warehouse_Shop_ID", data[0].getField("zseWarehouseShopId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Warehouse_ID) throws IOException,ServletException {
      ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] data = ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Warehouse_ID, vars.getStringParameter("inpzseWarehouseShopId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Warehouse_ID, String strZSE_Warehouse_Shop_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamZSE_Shop_ID = vars.getSessionValue(tabId + "|paramZSE_Shop_ID");
String strParamM_Warehouse_ID = vars.getSessionValue(tabId + "|paramM_Warehouse_ID");

    if (vars.getSessionValue(windowId +  "|M_Warehouse_ID").isEmpty()) vars.setSessionValue(windowId + "|M_Warehouse_ID", vars.getStringParameter("inpmWarehouseId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamZSE_Shop_ID.equals("") && strParamM_Warehouse_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZSE_Warehouse_Shop_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZSE_Warehouse_Shop_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/WarehouseandStorageBins/ECommerce2CF660D33B274F9BA3E30BDA6EE46B99_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ECommerce2CF660D33B274F9BA3E30BDA6EE46B99", false, "document.frmMain.inpzseWarehouseShopId", "grid", "..", "".equals("Y"), "WarehouseandStorageBins", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPM_Warehouse_ID);

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
    xmlDocument.setParameter("KeyName", "zseWarehouseShopId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ECommerce2CF660D33B274F9BA3E30BDA6EE46B99_Relation.html", "WarehouseandStorageBins", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ECommerce2CF660D33B274F9BA3E30BDA6EE46B99_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectParent(this, strPM_Warehouse_ID));
    else xmlDocument.setParameter("parent", ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectParentTrl(this, strPM_Warehouse_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZSE_Warehouse_Shop_ID, String strPM_Warehouse_ID, TableSQLData tableSQL)
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
    ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamZSE_Shop_ID = vars.getSessionValue(tabId + "|paramZSE_Shop_ID");
String strParamM_Warehouse_ID = vars.getSessionValue(tabId + "|paramM_Warehouse_ID");

    boolean hasSearchCondition=false;
    if (!(strParamZSE_Shop_ID.equals("") && strParamM_Warehouse_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Warehouse_ID, strZSE_Warehouse_Shop_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZSE_Warehouse_Shop_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zseWarehouseShopId") == null || dataField.getField("zseWarehouseShopId").equals("")) {
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
        refreshSessionNew(vars, strPM_Warehouse_ID);
        data = ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.set(strPM_Warehouse_ID, Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField), ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectDefE975E8CAD9E244F695BF4C40CB69B1A7_0(this, Utility.getDefault(this, vars, "Createdby", "", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField), "Y", Utility.getDefault(this, vars, "ZSE_Shop_ID", "", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField), ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.selectDef76C6967D3E534B7598466B5804A7A2C5_1(this, Utility.getDefault(this, vars, "Updatedby", "", "139", "2CF660D33B274F9BA3E30BDA6EE46B99", "", dataField)), "");
        
      }
    } else {
      data = new ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=WarehouseData.selectOrg(this, strPM_Warehouse_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ECommerce2CF660D33B274F9BA3E30BDA6EE46B99", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzseWarehouseShopId", "", "..", "".equals("Y"), "WarehouseandStorageBins", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZSE_Warehouse_Shop_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Warehouse_ID) throws IOException, ServletException {
    ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data data = null;
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
            data = getEditVariables(con, vars, strPM_Warehouse_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zseWarehouseShopId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ECommerce2CF660D33B274F9BA3E30BDA6EE46B99Data.getCurrentDBTimestamp(this, data.zseWarehouseShopId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zseWarehouseShopId, vars, this);
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
                    data.zseWarehouseShopId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|ZSE_Warehouse_Shop_ID", data.zseWarehouseShopId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ECommerce2CF660D33B274F9BA3E30BDA6EE46B99. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
