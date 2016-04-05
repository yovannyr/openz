
package org.openbravo.erpWindows.PhysicalInventory;





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

public class Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.class);
  
  private static final String windowId = "168";
  private static final String tabId = "26BC2E065AFE41F9A7D99AB3FC8FC985";
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
        String strsnrInventorylineId = request.getParameter("inpsnrInventorylineId");
         String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strsnrInventorylineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Inventoryline_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Inventoryline_ID);
          
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
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID", "");

      String strSNR_Inventoryline_ID = vars.getGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID", "");
            if (strPM_Inventoryline_ID.equals("")) {
        strPM_Inventoryline_ID = getParentID(vars, strSNR_Inventoryline_ID);
        if (strPM_Inventoryline_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Inventoryline_ID");
        vars.setSessionValue(windowId + "|M_Inventoryline_ID", strPM_Inventoryline_ID);
      vars.removeSessionValue(windowId + "|M_Inventory_ID");
        refreshParentSession(vars, strPM_Inventoryline_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strSNR_Inventoryline_ID.equals("")) strSNR_Inventoryline_ID = firstElement(vars, tableSQL);
          if (strSNR_Inventoryline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Inventoryline_ID, strSNR_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strSNR_Inventoryline_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strSNR_Inventoryline_ID.equals("")) strSNR_Inventoryline_ID = vars.getRequiredGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID");
      else vars.setSessionValue(windowId + "|SNR_Inventoryline_ID", strSNR_Inventoryline_ID);
      
      
      String strPM_Inventoryline_ID = getParentID(vars, strSNR_Inventoryline_ID);
      
      vars.setSessionValue(windowId + "|M_Inventoryline_ID", strPM_Inventoryline_ID);
      vars.setSessionValue("256|Lines.view", "EDIT");
      vars.removeSessionValue(windowId + "|M_Inventory_ID");
      refreshParentSession(vars, strPM_Inventoryline_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "EDIT");

        printPageEdit(response, request, vars, false, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Inventoryline_ID, strSNR_Inventoryline_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|SNR_Inventoryline_ID");
      refreshParentSession(vars, strPM_Inventoryline_ID);


      String strView = vars.getSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view");
      String strSNR_Inventoryline_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strSNR_Inventoryline_ID = firstElement(vars, tableSQL);
          if (strSNR_Inventoryline_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strSNR_Inventoryline_ID.equals("")) strSNR_Inventoryline_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Inventoryline_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamSerialnumber", tabId + "|paramSerialnumber");

            String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      
      vars.removeSessionValue(windowId + "|SNR_Inventoryline_ID");
      String strSNR_Inventoryline_ID="";

      String strView = vars.getSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strSNR_Inventoryline_ID = firstElement(vars, tableSQL);
        if (strSNR_Inventoryline_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Inventoryline_ID, strSNR_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      

      String strSNR_Inventoryline_ID = vars.getGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID", "");
      vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Inventoryline_ID, strSNR_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");


      printPageEdit(response, request, vars, true, "", strPM_Inventoryline_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strSNR_Inventoryline_ID = vars.getGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID", "");
      vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      String strSNR_Inventoryline_ID = vars.getRequiredStringParameter("inpsnrInventorylineId");
      
      String strNext = nextElement(vars, strSNR_Inventoryline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      String strSNR_Inventoryline_ID = vars.getRequiredStringParameter("inpsnrInventorylineId");
      
      String strPrevious = previousElement(vars, strSNR_Inventoryline_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|SNR_Inventoryline_ID");
      vars.setSessionValue(windowId + "|M_Inventoryline_ID", strPM_Inventoryline_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|SNR_Inventoryline_ID");
      vars.setSessionValue(windowId + "|M_Inventoryline_ID", strPM_Inventoryline_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Inventoryline_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Inventoryline_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Inventoryline_ID);      
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
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");
      String strSNR_Inventoryline_ID = vars.getRequiredGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Inventoryline_ID);      
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
          String strNext = nextElement(vars, strSNR_Inventoryline_ID, tableSQL);
          vars.setSessionValue(windowId + "|SNR_Inventoryline_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      String strSNR_Inventoryline_ID = vars.getRequiredInStringParameter("inpsnrInventorylineId");
      String message = deleteRelation(vars, strSNR_Inventoryline_ID, strPM_Inventoryline_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|snrInventorylineId");
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPM_Inventoryline_ID = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");

      String strSNR_Inventoryline_ID = vars.getRequiredStringParameter("inpsnrInventorylineId");
      //Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data data = getEditVariables(vars, strPM_Inventoryline_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.delete(this, strSNR_Inventoryline_ID, strPM_Inventoryline_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|snrInventorylineId");
        vars.setSessionValue(tabId + "|Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strSNR_Inventoryline_ID, String strPM_Inventoryline_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strSNR_Inventoryline_ID.startsWith("(")) strSNR_Inventoryline_ID = strSNR_Inventoryline_ID.substring(1, strSNR_Inventoryline_ID.length()-1);
      if (!strSNR_Inventoryline_ID.equals("")) {
        strSNR_Inventoryline_ID = Replace.replace(strSNR_Inventoryline_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strSNR_Inventoryline_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.deleteTransactional(conn, this, strKey, strPM_Inventoryline_ID)==0) {
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
  private Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Inventoryline_ID) throws IOException,ServletException {
    Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data data = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data();
    ServletException ex = null;
    try {
    data.snrInventorylineId = vars.getRequestGlobalVariable("inpsnrInventorylineId", windowId + "|SNR_Inventoryline_ID");     data.mInventorylineId = vars.getStringParameter("inpmInventorylineId");     data.mInventorylineIdr = vars.getStringParameter("inpmInventorylineId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.serialnumber = vars.getStringParameter("inpserialnumber");     data.isunavailable = vars.getStringParameter("inpisunavailable", "N");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.lotnumber = vars.getStringParameter("inplotnumber");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.quantity = vars.getNumericParameter("inpquantity");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.guaranteedays = vars.getNumericParameter("inpguaranteedays");  } catch (ServletException paramEx) { ex = paramEx; }     data.guaranteedate = vars.getStringParameter("inpguaranteedate");     data.rfidnumber = vars.getStringParameter("inprfidnumber");     data.description = vars.getStringParameter("inpdescription"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mInventorylineId = vars.getGlobalVariable("inpmInventorylineId", windowId + "|M_Inventoryline_ID");


    
    

    
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

   private Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] getRelationData(Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].snrInventorylineId = FormatUtilities.truncate(data[i].snrInventorylineId, 32);        data[i].mInventorylineId = FormatUtilities.truncate(data[i].mInventorylineId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].serialnumber = FormatUtilities.truncate(data[i].serialnumber, 40);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].lotnumber = FormatUtilities.truncate(data[i].lotnumber, 40);        data[i].rfidnumber = FormatUtilities.truncate(data[i].rfidnumber, 40);        data[i].description = FormatUtilities.truncate(data[i].description, 50);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Inventoryline_ID) throws IOException,ServletException {
      LinesData[] data = LinesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|M_Inventory_ID"), strPM_Inventoryline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|M_Inventory_ID", data[0].mInventoryId);    vars.setSessionValue(windowId + "|M_Locator_ID", data[0].mLocatorId);    vars.setSessionValue(windowId + "|C_UOM_ID", data[0].cUomId);    vars.setSessionValue(windowId + "|M_InventoryLine_ID", data[0].mInventorylineId);
      vars.setSessionValue(windowId + "|M_Inventoryline_ID", strPM_Inventoryline_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|HASSECONDUOM", LinesData.selectAux800007(this, Utility.getContext(this, vars, "M_Product_ID", "168")));
      
      vars.setSessionValue(windowId + "|Processed", LinesData.selectAuxA0BD1D62278F4068AEA07E1CBF0D840E(this, Utility.getContext(this, vars, "M_INVENTORY_ID", "168")));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strSNR_Inventoryline_ID) throws ServletException {
    String strPM_Inventoryline_ID = Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectParentID(this, strSNR_Inventoryline_ID);
    if (strPM_Inventoryline_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strSNR_Inventoryline_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Inventoryline_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|SNR_Inventoryline_ID", data[0].getField("snrInventorylineId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Inventoryline_ID) throws IOException,ServletException {
      Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] data = Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Inventoryline_ID, vars.getStringParameter("inpsnrInventorylineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Inventoryline_ID, String strSNR_Inventoryline_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");

    if (vars.getSessionValue(windowId +  "|M_InventoryLine_ID").isEmpty()) vars.setSessionValue(windowId + "|M_InventoryLine_ID", vars.getStringParameter("inpmInventorylineId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamSerialnumber.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strSNR_Inventoryline_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strSNR_Inventoryline_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PhysicalInventory/Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985", false, "document.frmMain.inpsnrInventorylineId", "grid", "..", "".equals("Y"), "PhysicalInventory", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPM_Inventoryline_ID);

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
    xmlDocument.setParameter("KeyName", "snrInventorylineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985_Relation.html", "PhysicalInventory", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectParent(this, strPM_Inventoryline_ID));
    else xmlDocument.setParameter("parent", Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectParentTrl(this, strPM_Inventoryline_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strSNR_Inventoryline_ID, String strPM_Inventoryline_ID, TableSQLData tableSQL)
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
    Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamSerialnumber = vars.getSessionValue(tabId + "|paramSerialnumber");

    boolean hasSearchCondition=false;
    if (!(strParamSerialnumber.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Inventoryline_ID, strSNR_Inventoryline_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strSNR_Inventoryline_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("snrInventorylineId") == null || dataField.getField("snrInventorylineId").equals("")) {
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
        refreshSessionNew(vars, strPM_Inventoryline_ID);
        data = Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.set(strPM_Inventoryline_ID, Utility.getDefault(this, vars, "Serialnumber", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "Guaranteedate", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectDefCDAFF29584E24F46A900AD54035F227B_0(this, Utility.getDefault(this, vars, "Updatedby", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField)), "Y", Utility.getDefault(this, vars, "Rfidnumber", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "Isunavailable", "N", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "N", dataField), Utility.getDefault(this, vars, "Guaranteedays", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.selectDefDF80E990D232466DA7688A90F297EFB5_1(this, Utility.getDefault(this, vars, "Createdby", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField)), Utility.getDefault(this, vars, "Lotnumber", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), "", Utility.getDefault(this, vars, "Quantity", "1", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "Description", "", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "168", "26BC2E065AFE41F9A7D99AB3FC8FC985", "", dataField));
        
      }
    } else {
      data = new Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=LinesData.selectOrg(this, strPM_Inventoryline_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpsnrInventorylineId", "", "..", "".equals("Y"), "PhysicalInventory", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strSNR_Inventoryline_ID));
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Inventoryline_ID) throws IOException, ServletException {
    Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data data = null;
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
            data = getEditVariables(con, vars, strPM_Inventoryline_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.snrInventorylineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985Data.getCurrentDBTimestamp(this, data.snrInventorylineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.snrInventorylineId, vars, this);
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
                    data.snrInventorylineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|SNR_Inventoryline_ID", data.snrInventorylineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Serialnumbers26BC2E065AFE41F9A7D99AB3FC8FC985. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}