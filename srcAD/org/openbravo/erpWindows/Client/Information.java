
package org.openbravo.erpWindows.Client;





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

public class Information extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Information.class);
  
  private static final String windowId = "109";
  private static final String tabId = "169";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 6;
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
        String stradClientId = request.getParameter("inpadClientId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !stradClientId.equals(""))
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

      String strAD_Client_ID = vars.getGlobalVariable("inpadClientId", windowId + "|AD_Client_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Information.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strAD_Client_ID.equals("")) strAD_Client_ID = firstElement(vars, tableSQL);
          if (strAD_Client_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Client_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_Client_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strAD_Client_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strAD_Client_ID.equals("")) strAD_Client_ID = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");
      else vars.setSessionValue(windowId + "|AD_Client_ID", strAD_Client_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Information.view", "EDIT");

        printPageEdit(response, request, vars, false, strAD_Client_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Information.view", "RELATION");
        printPageDataSheet(response, vars, strAD_Client_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Information.view");
      String strAD_Client_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strAD_Client_ID = firstElement(vars, tableSQL);
          if (strAD_Client_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strAD_Client_ID.equals("")) strAD_Client_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strAD_Client_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamAD_Client_ID", tabId + "|paramAD_Client_ID");

      
      
      vars.removeSessionValue(windowId + "|AD_Client_ID");
      String strAD_Client_ID="";

      String strView = vars.getSessionValue(tabId + "|Information.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strAD_Client_ID = firstElement(vars, tableSQL);
        if (strAD_Client_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Information.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strAD_Client_ID, tableSQL);

      else printPageDataSheet(response, vars, strAD_Client_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strAD_Client_ID = vars.getGlobalVariable("inpadClientId", windowId + "|AD_Client_ID", "");
      vars.setSessionValue(tabId + "|Information.view", "RELATION");
      printPageDataSheet(response, vars, strAD_Client_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strAD_Client_ID = vars.getGlobalVariable("inpadClientId", windowId + "|AD_Client_ID", "");
      vars.setSessionValue(tabId + "|Information.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strAD_Client_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strAD_Client_ID = vars.getRequiredStringParameter("inpadClientId");
      
      String strNext = nextElement(vars, strAD_Client_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strAD_Client_ID = vars.getRequiredStringParameter("inpadClientId");
      
      String strPrevious = previousElement(vars, strAD_Client_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Information.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Information.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Information.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Information.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|AD_Client_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Information.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Information.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|AD_Client_ID");

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

      String strAD_Client_ID = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");
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
          String strNext = nextElement(vars, strAD_Client_ID, tableSQL);
          vars.setSessionValue(windowId + "|AD_Client_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strAD_Client_ID = vars.getRequiredInStringParameter("inpadClientId");
      String message = deleteRelation(vars, strAD_Client_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|adClientId");
        vars.setSessionValue(tabId + "|Information.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strAD_Client_ID = vars.getRequiredStringParameter("inpadClientId");
      //InformationData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = InformationData.delete(this, strAD_Client_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|adClientId");
        vars.setSessionValue(tabId + "|Information.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strAD_Client_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strAD_Client_ID.startsWith("(")) strAD_Client_ID = strAD_Client_ID.substring(1, strAD_Client_ID.length()-1);
      if (!strAD_Client_ID.equals("")) {
        strAD_Client_ID = Replace.replace(strAD_Client_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strAD_Client_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (InformationData.deleteTransactional(conn, this, strKey)==0) {
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
  private InformationData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    InformationData data = new InformationData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adTreeOrgId = vars.getStringParameter("inpadTreeOrgId");     data.adTreeOrgIdr = vars.getStringParameter("inpadTreeOrgId_R");     data.adTreeMenuId = vars.getStringParameter("inpadTreeMenuId");     data.adTreeMenuIdr = vars.getStringParameter("inpadTreeMenuId_R");     data.adTreeBpartnerId = vars.getStringParameter("inpadTreeBpartnerId");     data.adTreeBpartnerIdr = vars.getStringParameter("inpadTreeBpartnerId_R");     data.adTreeProductId = vars.getStringParameter("inpadTreeProductId");     data.adTreeProductIdr = vars.getStringParameter("inpadTreeProductId_R");     data.adTreeProjectId = vars.getStringParameter("inpadTreeProjectId");     data.adTreeProjectIdr = vars.getStringParameter("inpadTreeProjectId_R");     data.adTreeSalesregionId = vars.getStringParameter("inpadTreeSalesregionId");     data.adTreeSalesregionIdr = vars.getStringParameter("inpadTreeSalesregionId_R");     data.allownegativestock = vars.getStringParameter("inpallownegativestock", "N");     data.checkinoutorg = vars.getStringParameter("inpcheckinoutorg", "N");     data.checkorderorg = vars.getStringParameter("inpcheckorderorg", "N");     data.yourCompanyBigImage = vars.getStringParameter("inpyourCompanyBigImage");     data.yourCompanyDocumentImage = vars.getStringParameter("inpyourCompanyDocumentImage");     data.yourCompanyMenuImage = vars.getStringParameter("inpyourCompanyMenuImage");     data.cBpartnercashtrxId = vars.getStringParameter("inpcBpartnercashtrxId");     data.cUomTimeId = vars.getStringParameter("inpcUomTimeId");     data.cUomLengthId = vars.getStringParameter("inpcUomLengthId");     data.cUomWeightId = vars.getStringParameter("inpcUomWeightId");     data.cUomVolumeId = vars.getStringParameter("inpcUomVolumeId");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cAcctschema3Id = vars.getStringParameter("inpcAcctschema3Id");     data.acct3Active = vars.getStringParameter("inpacct3Active", "N");     data.cAcctschema2Id = vars.getStringParameter("inpcAcctschema2Id");     data.acct2Active = vars.getStringParameter("inpacct2Active", "N");     data.cAcctschema1Id = vars.getStringParameter("inpcAcctschema1Id");     data.groupacctinvlines = vars.getStringParameter("inpgroupacctinvlines", "N");     data.mPricelistId = vars.getStringParameter("inpmPricelistId");     data.isdiscountlineamt = vars.getStringParameter("inpisdiscountlineamt", "N");     data.cCalendarId = vars.getStringParameter("inpcCalendarId");     data.mProductfreightId = vars.getStringParameter("inpmProductfreightId"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
    

    
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

   private InformationData[] getRelationData(InformationData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 20);        data[i].adTreeOrgId = FormatUtilities.truncate(data[i].adTreeOrgId, 20);        data[i].adTreeMenuId = FormatUtilities.truncate(data[i].adTreeMenuId, 20);        data[i].adTreeBpartnerId = FormatUtilities.truncate(data[i].adTreeBpartnerId, 20);        data[i].adTreeProductId = FormatUtilities.truncate(data[i].adTreeProductId, 20);        data[i].adTreeProjectId = FormatUtilities.truncate(data[i].adTreeProjectId, 20);        data[i].adTreeSalesregionId = FormatUtilities.truncate(data[i].adTreeSalesregionId, 20);        data[i].yourCompanyBigImage = FormatUtilities.truncate(data[i].yourCompanyBigImage, 10);        data[i].yourCompanyDocumentImage = FormatUtilities.truncate(data[i].yourCompanyDocumentImage, 10);        data[i].yourCompanyMenuImage = FormatUtilities.truncate(data[i].yourCompanyMenuImage, 32);        data[i].cBpartnercashtrxId = FormatUtilities.truncate(data[i].cBpartnercashtrxId, 20);        data[i].cUomTimeId = FormatUtilities.truncate(data[i].cUomTimeId, 10);        data[i].cUomLengthId = FormatUtilities.truncate(data[i].cUomLengthId, 10);        data[i].cUomWeightId = FormatUtilities.truncate(data[i].cUomWeightId, 10);        data[i].cUomVolumeId = FormatUtilities.truncate(data[i].cUomVolumeId, 10);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cAcctschema3Id = FormatUtilities.truncate(data[i].cAcctschema3Id, 44);        data[i].cAcctschema2Id = FormatUtilities.truncate(data[i].cAcctschema2Id, 44);        data[i].cAcctschema1Id = FormatUtilities.truncate(data[i].cAcctschema1Id, 44);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 20);        data[i].cCalendarId = FormatUtilities.truncate(data[i].cCalendarId, 20);        data[i].mProductfreightId = FormatUtilities.truncate(data[i].mProductfreightId, 20);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      InformationData[] data = InformationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpadClientId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strAD_Client_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamAD_Client_ID = vars.getSessionValue(tabId + "|paramAD_Client_ID");

    if (vars.getSessionValue(windowId +  "|AD_Client_ID").isEmpty()) vars.setSessionValue(windowId + "|AD_Client_ID", vars.getStringParameter("inpadClientId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamAD_Client_ID.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strAD_Client_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strAD_Client_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Client/Information_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Information", false, "document.frmMain.inpadClientId", "grid", "..", "".equals("Y"), "Client", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
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
    xmlDocument.setParameter("KeyName", "adClientId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Information_Relation.html", "Client", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Information_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strAD_Client_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " AD_ClientInfo.IsActive";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    InformationData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Client_ID = vars.getSessionValue(tabId + "|paramAD_Client_ID");

    boolean hasSearchCondition=false;
    if (!(strParamAD_Client_ID.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = InformationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strAD_Client_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strAD_Client_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strAD_Client_ID = firstElement(vars, tableSQL);
        if (strAD_Client_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = InformationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strAD_Client_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new InformationData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("adClientId") == null || dataField.getField("adClientId").equals("")) {
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
        refreshSessionNew(vars);
        data = InformationData.set(Utility.getDefault(this, vars, "Your_Company_Document_Image", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "109", "169", "", dataField), Utility.getDefault(this, vars, "Your_Company_Menu_Image", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "M_ProductFreight_ID", "", "109", "169", "", dataField), "Y", Utility.getDefault(this, vars, "AllowNegativeStock", "Y", "109", "169", "N", dataField), Utility.getDefault(this, vars, "C_UOM_Weight_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "109", "169", "", dataField), InformationData.selectDef1989_0(this, Utility.getDefault(this, vars, "UpdatedBy", "", "109", "169", "", dataField)), Utility.getDefault(this, vars, "M_PriceList_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_AcctSchema3_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_Calendar_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "Checkorderorg", "Y", "109", "169", "N", dataField), Utility.getDefault(this, vars, "AD_Tree_Menu_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "IsDiscountLineAmt", "", "109", "169", "N", dataField), Utility.getDefault(this, vars, "AD_Tree_Org_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_AcctSchema2_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "Groupacctinvlines", "N", "109", "169", "N", dataField), Utility.getDefault(this, vars, "Acct2_Active", "", "109", "169", "N", dataField), Utility.getDefault(this, vars, "AD_Tree_SalesRegion_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "Checkinoutorg", "Y", "109", "169", "N", dataField), Utility.getDefault(this, vars, "Acct3_Active", "", "109", "169", "N", dataField), Utility.getDefault(this, vars, "C_AcctSchema1_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_UOM_Time_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "AD_Tree_Product_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "109", "169", "", dataField), InformationData.selectDef1987_1(this, Utility.getDefault(this, vars, "CreatedBy", "", "109", "169", "", dataField)), "0", Utility.getDefault(this, vars, "C_BPartnerCashTrx_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "AD_Tree_BPartner_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_UOM_Length_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "Your_Company_Big_Image", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "AD_Tree_Project_ID", "", "109", "169", "", dataField), Utility.getDefault(this, vars, "C_UOM_Volume_ID", "", "109", "169", "", dataField));
        
      }
    } else {
      data = new InformationData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(InformationData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Information", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpadClientId", "", "..", "".equals("Y"), "Client", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strAD_Client_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "SR", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    InformationData data = null;
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
                data.adClientId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (InformationData.getCurrentDBTimestamp(this, data.adClientId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.adClientId, vars, this);
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
                    data.adClientId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|AD_Client_ID", data.adClientId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Information. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
