
package org.openbravo.erpWindows.org.openz.customerassets.CustomerAssetsOverview;





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

public class AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.class);
  
  private static final String windowId = "634348D479144B959CAEEE0DE1171895";
  private static final String tabId = "2DA8999B9C8D4B478399C275EA76BFD5";
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
        String strcaAssetsstockedId = request.getParameter("inpcaAssetsstockedId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcaAssetsstockedId.equals(""))
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

      String strCA_AssetsStocked_ID = vars.getGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strCA_AssetsStocked_ID.equals("")) strCA_AssetsStocked_ID = firstElement(vars, tableSQL);
          if (strCA_AssetsStocked_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strCA_AssetsStocked_ID, tableSQL);

      else printPageDataSheet(response, vars, strCA_AssetsStocked_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strCA_AssetsStocked_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strCA_AssetsStocked_ID.equals("")) strCA_AssetsStocked_ID = vars.getRequiredGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID");
      else vars.setSessionValue(windowId + "|CA_AssetsStocked_ID", strCA_AssetsStocked_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "EDIT");

        printPageEdit(response, request, vars, false, strCA_AssetsStocked_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "RELATION");
        printPageDataSheet(response, vars, strCA_AssetsStocked_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view");
      String strCA_AssetsStocked_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strCA_AssetsStocked_ID = firstElement(vars, tableSQL);
          if (strCA_AssetsStocked_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strCA_AssetsStocked_ID.equals("")) strCA_AssetsStocked_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strCA_AssetsStocked_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_BPartner_ID", tabId + "|paramC_BPartner_ID");
vars.getRequestGlobalVariable("inpParamM_Product_ID", tabId + "|paramM_Product_ID");
vars.getRequestGlobalVariable("inpParamQty", tabId + "|paramQty");
vars.getRequestGlobalVariable("inpParamSNR_Masterdata_id", tabId + "|paramSNR_Masterdata_id");
vars.getRequestGlobalVariable("inpParamQty_f", tabId + "|paramQty_f");

      
      
      vars.removeSessionValue(windowId + "|CA_AssetsStocked_ID");
      String strCA_AssetsStocked_ID="";

      String strView = vars.getSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strCA_AssetsStocked_ID = firstElement(vars, tableSQL);
        if (strCA_AssetsStocked_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strCA_AssetsStocked_ID, tableSQL);

      else printPageDataSheet(response, vars, strCA_AssetsStocked_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strCA_AssetsStocked_ID = vars.getGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID", "");
      vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "RELATION");
      printPageDataSheet(response, vars, strCA_AssetsStocked_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strCA_AssetsStocked_ID = vars.getGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID", "");
      vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strCA_AssetsStocked_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strCA_AssetsStocked_ID = vars.getRequiredStringParameter("inpcaAssetsstockedId");
      
      String strNext = nextElement(vars, strCA_AssetsStocked_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strCA_AssetsStocked_ID = vars.getRequiredStringParameter("inpcaAssetsstockedId");
      
      String strPrevious = previousElement(vars, strCA_AssetsStocked_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|CA_AssetsStocked_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|CA_AssetsStocked_ID");

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

      String strCA_AssetsStocked_ID = vars.getRequiredGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID");
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
          String strNext = nextElement(vars, strCA_AssetsStocked_ID, tableSQL);
          vars.setSessionValue(windowId + "|CA_AssetsStocked_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {

      String strCA_AssetsStocked_ID = vars.getRequiredInStringParameter("inpcaAssetsstockedId");
      String message = deleteRelation(vars, strCA_AssetsStocked_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|caAssetsstockedId");
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {

      String strCA_AssetsStocked_ID = vars.getRequiredStringParameter("inpcaAssetsstockedId");
      //AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.delete(this, strCA_AssetsStocked_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|caAssetsstockedId");
        vars.setSessionValue(tabId + "|AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strCA_AssetsStocked_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strCA_AssetsStocked_ID.startsWith("(")) strCA_AssetsStocked_ID = strCA_AssetsStocked_ID.substring(1, strCA_AssetsStocked_ID.length()-1);
      if (!strCA_AssetsStocked_ID.equals("")) {
        strCA_AssetsStocked_ID = Replace.replace(strCA_AssetsStocked_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strCA_AssetsStocked_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.deleteTransactional(conn, this, strKey)==0) {
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
  private AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data data = new AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data();
    ServletException ex = null;
    try {
    data.caAssetsstockedId = vars.getRequestGlobalVariable("inpcaAssetsstockedId", windowId + "|CA_AssetsStocked_ID");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.snrMasterdataId = vars.getStringParameter("inpsnrMasterdataId");     data.snrMasterdataIdr = vars.getStringParameter("inpsnrMasterdataId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualqty = vars.getNumericParameter("inpactualqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtysold = vars.getNumericParameter("inpqtysold");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.price = vars.getNumericParameter("inpprice");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.amt = vars.getNumericParameter("inpamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.stockcharge = vars.getNumericParameter("inpstockcharge");  } catch (ServletException paramEx) { ex = paramEx; }     data.paymentdate = vars.getStringParameter("inppaymentdate");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.statusref = vars.getStringParameter("inpstatusref");     data.statusrefr = vars.getStringParameter("inpstatusref_R");     data.dateofsale = vars.getStringParameter("inpdateofsale");     data.datedelivered = vars.getStringParameter("inpdatedelivered");     data.dateordered = vars.getStringParameter("inpdateordered");     data.datestockfeeuntil = vars.getStringParameter("inpdatestockfeeuntil");     data.description = vars.getStringParameter("inpdescription");     data.cOrderlineId = vars.getStringParameter("inpcOrderlineId");     data.cOrderlineIdr = vars.getStringParameter("inpcOrderlineId_R");     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.poorderline = vars.getStringParameter("inppoorderline");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
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

   private AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[] getRelationData(AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].caAssetsstockedId = FormatUtilities.truncate(data[i].caAssetsstockedId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].snrMasterdataId = FormatUtilities.truncate(data[i].snrMasterdataId, 32);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 32);        data[i].statusref = FormatUtilities.truncate(data[i].statusref, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 32);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].poorderline = FormatUtilities.truncate(data[i].poorderline, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|CA_Assetsstocked_ID", data[0].getField("caAssetsstockedId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[] data = AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcaAssetsstockedId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strCA_AssetsStocked_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamQty = vars.getSessionValue(tabId + "|paramQty");
String strParamSNR_Masterdata_id = vars.getSessionValue(tabId + "|paramSNR_Masterdata_id");
String strParamQty_f = vars.getSessionValue(tabId + "|paramQty_f");

    
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_BPartner_ID.equals("") && strParamM_Product_ID.equals("") && strParamQty.equals("") && strParamSNR_Masterdata_id.equals("") && strParamQty_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strCA_AssetsStocked_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strCA_AssetsStocked_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/customerassets/CustomerAssetsOverview/AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5", false, "document.frmMain.inpcaAssetsstockedId", "grid", "..", "".equals("Y"), "CustomerAssetsOverview", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "caAssetsstockedId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5_Relation.html", "CustomerAssetsOverview", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strCA_AssetsStocked_ID, TableSQLData tableSQL)
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
    AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamQty = vars.getSessionValue(tabId + "|paramQty");
String strParamSNR_Masterdata_id = vars.getSessionValue(tabId + "|paramSNR_Masterdata_id");
String strParamQty_f = vars.getSessionValue(tabId + "|paramQty_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_BPartner_ID.equals("") && strParamM_Product_ID.equals("") && strParamQty.equals("") && strParamSNR_Masterdata_id.equals("") && strParamQty_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strCA_AssetsStocked_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strCA_AssetsStocked_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strCA_AssetsStocked_ID = firstElement(vars, tableSQL);
        if (strCA_AssetsStocked_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strCA_AssetsStocked_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("caAssetsstockedId") == null || dataField.getField("caAssetsstockedId").equals("")) {
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
        data = AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.set(Utility.getDefault(this, vars, "SNR_Masterdata_id", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), "", Utility.getDefault(this, vars, "Price", "0", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectDef9CFD412BDE444822A111D1D8F1C35ACD_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField)), Utility.getDefault(this, vars, "DateStockFeeUntil", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Actualqty", "0", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "C_OrderLine_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Description", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Amt", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Stockcharge", "0", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "DateDelivered", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectDef50776D81AA0944A69E1B6F951CFF161D_1(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField)), Utility.getDefault(this, vars, "Poorderline", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Statusref", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), "Y", Utility.getDefault(this, vars, "UpdatedBy", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectDefB8FD240B381E480FB8DDC9807008A7E7_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField)), Utility.getDefault(this, vars, "C_Currency_ID", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Paymentdate", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Qtysold", "0", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "Qty", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.selectDef57F4E21F8A55400DA273C41AF26F0AEB_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField)), Utility.getDefault(this, vars, "DateOrdered", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField), Utility.getDefault(this, vars, "DateOfSale", "", "634348D479144B959CAEEE0DE1171895", "2DA8999B9C8D4B478399C275EA76BFD5", "", dataField));
        
      }
    } else {
      data = new AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcaAssetsstockedId", "", "..", "".equals("Y"), "CustomerAssetsOverview", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strCA_AssetsStocked_ID));
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
    AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data data = null;
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
                data.caAssetsstockedId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5Data.getCurrentDBTimestamp(this, data.caAssetsstockedId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.caAssetsstockedId, vars, this);
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
                    data.caAssetsstockedId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|CA_AssetsStocked_ID", data.caAssetsstockedId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet AllCustomerAssets2DA8999B9C8D4B478399C275EA76BFD5. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}