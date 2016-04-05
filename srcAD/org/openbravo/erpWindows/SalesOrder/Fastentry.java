
package org.openbravo.erpWindows.SalesOrder;





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

public class Fastentry extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Fastentry.class);
  
  private static final String windowId = "143";
  private static final String tabId = "DF1661AA54D0440DAB3B727E77A2194D";
  private static final String defaultTabView = "EDIT";
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
        String strcOrderlineId = request.getParameter("inpcOrderlineId");
         String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcOrderlineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Order_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Order_ID);
          
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");

      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
            if (strPC_Order_ID.equals("")) {
        strPC_Order_ID = getParentID(vars, strC_OrderLine_ID);
        if (strPC_Order_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Order_ID");
        vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);

        refreshParentSession(vars, strPC_Order_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Fastentry.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = firstElement(vars, tableSQL);
          if (strC_OrderLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_OrderLine_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = vars.getRequiredGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");
      else vars.setSessionValue(windowId + "|C_OrderLine_ID", strC_OrderLine_ID);
      
      
      String strPC_Order_ID = getParentID(vars, strC_OrderLine_ID);
      
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.setSessionValue("186|Header.view", "EDIT");

      refreshParentSession(vars, strPC_Order_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Fastentry.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Fastentry.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      refreshParentSession(vars, strPC_Order_ID);


      String strView = vars.getSessionValue(tabId + "|Fastentry.view");
      String strC_OrderLine_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_OrderLine_ID = firstElement(vars, tableSQL);
          if (strC_OrderLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Order_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamC_Order_ID", tabId + "|paramC_Order_ID");
vars.getRequestGlobalVariable("inpParamLine", tabId + "|paramLine");
vars.getRequestGlobalVariable("inpParamLineNetAmt", tabId + "|paramLineNetAmt");
vars.getRequestGlobalVariable("inpParamLine_f", tabId + "|paramLine_f");
vars.getRequestGlobalVariable("inpParamLineNetAmt_f", tabId + "|paramLineNetAmt_f");

            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      String strC_OrderLine_ID="";

      String strView = vars.getSessionValue(tabId + "|Fastentry.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_OrderLine_ID = firstElement(vars, tableSQL);
        if (strC_OrderLine_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Fastentry.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      

      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
      vars.setSessionValue(tabId + "|Fastentry.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


      printPageEdit(response, request, vars, true, "", strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
      vars.setSessionValue(tabId + "|Fastentry.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      
      String strNext = nextElement(vars, strC_OrderLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      
      String strPrevious = previousElement(vars, strC_OrderLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      vars.setSessionValue(tabId + "|Fastentry.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Fastentry.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Fastentry.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Fastentry.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Fastentry.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Fastentry.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Order_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Order_ID);      
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Order_ID);      
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
          String strNext = nextElement(vars, strC_OrderLine_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_OrderLine_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strC_OrderLine_ID = vars.getRequiredInStringParameter("inpcOrderlineId");
      String message = deleteRelation(vars, strC_OrderLine_ID, strPC_Order_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|cOrderlineId");
        vars.setSessionValue(tabId + "|Fastentry.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      //FastentryData data = getEditVariables(vars, strPC_Order_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = FastentryData.delete(this, strC_OrderLine_ID, strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cOrderlineId");
        vars.setSessionValue(tabId + "|Fastentry.view", "RELATION");
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
  String deleteRelation(VariablesSecureApp vars, String strC_OrderLine_ID, String strPC_Order_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strC_OrderLine_ID.startsWith("(")) strC_OrderLine_ID = strC_OrderLine_ID.substring(1, strC_OrderLine_ID.length()-1);
      if (!strC_OrderLine_ID.equals("")) {
        strC_OrderLine_ID = Replace.replace(strC_OrderLine_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strC_OrderLine_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (FastentryData.deleteTransactional(conn, this, strKey, strPC_Order_ID)==0) {
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
  private FastentryData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
    FastentryData data = new FastentryData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getStringParameter("inpadOrgId");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.desireddeliverydate = vars.getStringParameter("inpdesireddeliverydate");     data.datepromised = vars.getRequestGlobalVariable("inpdatepromised", windowId + "|DatePromised");     data.scheddeliverydate = vars.getStringParameter("inpscheddeliverydate");     data.directship = vars.getStringParameter("inpdirectship", "N");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.description = vars.getStringParameter("inpdescription");    try {   data.quantityorder = vars.getNumericParameter("inpquantityorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductUomId = vars.getStringParameter("inpmProductUomId");     data.mProductUomIdr = vars.getStringParameter("inpmProductUomId_R");    try {   data.qtyordered = vars.getNumericParameter("inpqtyordered", vars.getSessionValue(windowId + "|QtyOrdered"));  } catch (ServletException paramEx) { ex = paramEx; }     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.qtydelivered = vars.getNumericParameter("inpqtydelivered");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyreserved = vars.getNumericParameter("inpqtyreserved");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ignoreresidue = vars.getStringParameter("inpignoreresidue", "N");     data.deliverycomplete = vars.getStringParameter("inpdeliverycomplete", "N");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricestd = vars.getNumericParameter("inppricestd");  } catch (ServletException paramEx) { ex = paramEx; }     data.cancelpricead = vars.getStringParameter("inpcancelpricead", "N");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discount = vars.getNumericParameter("inpdiscount");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.orderlineselfjoin = vars.getStringParameter("inporderlineselfjoin");     data.orderlineselfjoinr = vars.getStringParameter("inporderlineselfjoin_R");    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ignoreresiduedate = vars.getStringParameter("inpignoreresiduedate");     data.cOrderlineId = vars.getRequestGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cOrderId = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


    
    

    
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

   private FastentryData[] getRelationData(FastentryData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 44);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 14);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mProductUomId = FormatUtilities.truncate(data[i].mProductUomId, 44);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 44);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].orderlineselfjoin = FormatUtilities.truncate(data[i].orderlineselfjoin, 32);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 10);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|DatePromised", data[0].datepromised);    vars.setSessionValue(windowId + "|SchedDeliveryDate", data[0].scheddeliverydate);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|Processed", data[0].processed);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|ORDERTYPE", HeaderData.selectAux6(this, Utility.getContext(this, vars, "C_DOCTYPETARGET_ID", "143")));
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_OrderLine_ID) throws ServletException {
    String strPC_Order_ID = FastentryData.selectParentID(this, strC_OrderLine_ID);
    if (strPC_Order_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_OrderLine_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Order_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));    vars.setSessionValue(windowId + "|QtyOrdered", data[0].getField("qtyordered"));    vars.setSessionValue(windowId + "|C_OrderLine_ID", data[0].getField("cOrderlineId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      FastentryData[] data = FastentryData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, vars.getStringParameter("inpcOrderlineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Order_ID, String strC_OrderLine_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    if (vars.getSessionValue(windowId +  "|C_Order_ID").isEmpty()) vars.setSessionValue(windowId + "|C_Order_ID", vars.getStringParameter("inpcOrderId"));
    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamC_Order_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_OrderLine_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_OrderLine_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/SalesOrder/Fastentry_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Fastentry", false, "document.frmMain.inpcOrderlineId", "grid", "..", "".equals("Y"), "SalesOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPC_Order_ID);

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
    xmlDocument.setParameter("KeyName", "cOrderlineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Fastentry_Relation.html", "SalesOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Fastentry_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", FastentryData.selectParent(this, strPC_Order_ID));
    else xmlDocument.setParameter("parent", FastentryData.selectParentTrl(this, strPC_Order_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_OrderLine_ID, String strPC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_orderline.line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    FastentryData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=false;
    if (!(strParamC_Order_ID.equals("") && strParamLine.equals("") && strParamLineNetAmt.equals("") && strParamLine_f.equals("") && strParamLineNetAmt_f.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = FastentryData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, strC_OrderLine_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_OrderLine_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new FastentryData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cOrderlineId") == null || dataField.getField("cOrderlineId").equals("")) {
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
        refreshSessionNew(vars, strPC_Order_ID);
        data = FastentryData.set(strPC_Order_ID, Utility.getDefault(this, vars, "M_Product_Uom_Id", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "DatePromised", "@DatePromised@", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "QtyInvoiced", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "QtyReserved", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Desireddeliverydate", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "0", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef2210_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField)), Utility.getDefault(this, vars, "QuantityOrder", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Discount", "0", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Linegrossamt", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef2212_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField)), Utility.getDefault(this, vars, "QtyDelivered", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef2213_2(this, strPC_Order_ID), FastentryData.selectDef6F7344EDD9904E5A94A709DE5BFE09D6(this, strPC_Order_ID), Utility.getDefault(this, vars, "QtyOrdered", "1", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDefA48DE71600FC4CC7A352989D54135EDD(this, strPC_Order_ID), FastentryData.selectDefA48DE71600FC4CC7A352989D54135EDD_3(this, FastentryData.selectDefA48DE71600FC4CC7A352989D54135EDD(this, strPC_Order_ID)), Utility.getDefault(this, vars, "Ignoreresiduedate", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef8767_4(this, Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField)), Utility.getDefault(this, vars, "CANCELPRICEAD", "N", "143", "DF1661AA54D0440DAB3B727E77A2194D", "N", dataField), Utility.getDefault(this, vars, "PriceActual", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Deliverycomplete", "N", "143", "DF1661AA54D0440DAB3B727E77A2194D", "N", dataField), "", Utility.getDefault(this, vars, "C_UOM_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Scheddeliverydate", "@Scheddeliverydate@", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "DirectShip", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "N", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef2221_5(this, Utility.getDefault(this, vars, "M_Product_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Orderlineselfjoin", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "PriceStd", "0", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), FastentryData.selectDef2214(this, strPC_Order_ID), Utility.getDefault(this, vars, "PriceList", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Description", "", "143", "DF1661AA54D0440DAB3B727E77A2194D", "", dataField), Utility.getDefault(this, vars, "Ignoreresidue", "N", "143", "DF1661AA54D0440DAB3B727E77A2194D", "N", dataField));
        
      }
    } else {
      data = new FastentryData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(FastentryData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=HeaderData.selectOrg(this, strPC_Order_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Fastentry", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcOrderlineId", "", "..", "".equals("Y"), "SalesOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_OrderLine_ID));
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
        this.setWindowId("143");
       this.setTabId("DF1661AA54D0440DAB3B727E77A2194D");
       this.setUpdatedtimestamp(updatedTimestamp);
       this.setOrgparent(currentPOrg);
       this.setCommandtype(strCommand);
       ManualTabPane tp;
    tp= (ManualTabPane) Class.forName("org.openz.controller.manualTabPane.OrderlineFastEntry").newInstance();
       String result=tp.getFormEdit(this,vars,data[0],tabs,response);
       output.println(result);
       output.close();
       if (1==1)
          return;

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
      String result = "var strC_DocTypeTarget_ID=\"" +Utility.getContext(this, vars, "C_DocTypeTarget_ID", windowId) + "\";\nvar strisonetimeposition=\"" +Utility.getContext(this, vars, "isonetimeposition", windowId) + "\";\nvar strHASSECONDUOM=\"" +Utility.getContext(this, vars, "HASSECONDUOM", windowId) + "\";\nvar strOrderType=\"" +Utility.getContext(this, vars, "OrderType", windowId) + "\";\nvar strProcessed=\"" +Utility.getContext(this, vars, "Processed", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Order_ID) throws IOException, ServletException {
    FastentryData data = null;
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
            data = getEditVariables(con, vars, strPC_Order_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cOrderlineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (FastentryData.getCurrentDBTimestamp(this, data.cOrderlineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cOrderlineId, vars, this);
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
                    data.cOrderlineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_OrderLine_ID", data.cOrderlineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Fastentry. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
