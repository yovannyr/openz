/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2001-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.businessUtility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.FileUtility;
import org.openbravo.xmlEngine.XmlDocument;

public class TabAttachments extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {

    final VariablesSecureApp vars = new VariablesSecureApp(request);
    OBError myMessage = null;

    if (vars.getCommand().startsWith("SAVE_NEW")) {
      final String strTab = vars.getStringParameter("inpTabId");
      vars.setSessionValue("TabAttachments.tabId", strTab);
      final String strWindow = vars.getStringParameter("inpwindowId");
      vars.setSessionValue("TabAttachments.windowId", strWindow);
      final String key = vars.getStringParameter("inpKey");
      vars.setSessionValue("TabAttachments.key", key);
      final String strText = vars.getStringParameter("inptext");
      final String strDataType = vars.getStringParameter("inpadDatatypeId");
      final TabAttachmentsData[] data = TabAttachmentsData.selectTabInfo(this, strTab);
      String tableId = "";
      if (data == null || data.length == 0)
        throw new ServletException("Tab not found: " + strTab);
      else
        tableId = data[0].adTableId;

      final String strFileReference = SequenceIdData.getUUID();
      final OBError oberrInsert = insert(vars, strFileReference, tableId, key, strDataType, strText);
      if (!oberrInsert.getType().equals("Success")) {
        vars.setMessage("TabAttachments", oberrInsert);
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=DEFAULT");
      } else {
        if (vars.commandIn("SAVE_NEW_RELATION")) {
          response.sendRedirect(strDireccion + request.getServletPath()
              + "?Command=DEFAULT&inpcFileId=" + strFileReference);
        } else if (vars.commandIn("SAVE_NEW_EDIT")) {
          response.sendRedirect(strDireccion + request.getServletPath()
              + "?Command=EDIT&inpcFileId=" + strFileReference);
        } else if (vars.commandIn("SAVE_NEW_NEW")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        }
      }
    } else if (vars.getCommand().startsWith("SAVE_EDIT")) {
      final String strTab = vars.getStringParameter("inpTabId");
      vars.setSessionValue("TabAttachments.tabId", strTab);
      final String strWindow = vars.getStringParameter("inpwindowId");
      vars.setSessionValue("TabAttachments.windowId", strWindow);
      final String key = vars.getStringParameter("inpKey");
      vars.setSessionValue("TabAttachments.key", key);
      String strFileReference = vars.getStringParameter("inpcFileId");
      final String strDataType = vars.getStringParameter("inpadDatatypeId");
      final String strText = vars.getStringParameter("inptext");
      if (TabAttachmentsData.update(this, vars.getUser(), strDataType, strText, strFileReference) == 0) {
        myMessage = new OBError();
        myMessage.setType("Success");
        myMessage.setTitle("");
        myMessage.setMessage(Utility.messageBD(this, "Error", vars.getLanguage()));
        vars.setMessage("TabAttachments", myMessage);
        // vars.setSessionValue("TabAttachments.message",
        // Utility.messageBD(this, "Error", vars.getLanguage()));
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT&inpcFileId="
            + strFileReference);
      } else {
        if (vars.commandIn("SAVE_EDIT_RELATION")) {
          response.sendRedirect(strDireccion + request.getServletPath()
              + "?Command=DEFAULT&inpcFileId=" + strFileReference);
        } else if (vars.commandIn("SAVE_EDIT_EDIT")) {
          response.sendRedirect(strDireccion + request.getServletPath()
              + "?Command=EDIT&inpcFileId=" + strFileReference);
        } else if (vars.commandIn("SAVE_EDIT_NEW")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW&inpKey="
              + key);
        } else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          final TabAttachmentsData[] data = TabAttachmentsData.selectTabInfo(this, strTab);
          String tableId = "";
          if (data == null || data.length == 0)
            throw new ServletException("Tab not found: " + strTab);
          else {
            tableId = data[0].adTableId;
            if (data[0].isreadonly.equals("Y"))
              throw new ServletException("This tab is read only");
          }
          final String strNewFile = TabAttachmentsData.selectNext(this, Utility.getContext(this,
              vars, "#User_Client", strWindow), Utility.getContext(this, vars,
              "#AccessibleOrgTree", strWindow), strFileReference, tableId, key);
          if (!strNewFile.equals(""))
            strFileReference = strNewFile;
          response.sendRedirect(strDireccion + request.getServletPath()
              + "?Command=EDIT&inpcFileId=" + strFileReference);
        }
      }
    } else if (vars.commandIn("DEL")) {
      final String strTab = vars.getStringParameter("inpTabId");
      vars.setSessionValue("TabAttachments.tabId", strTab);
      final String strWindow = vars.getStringParameter("inpwindowId");
      vars.setSessionValue("TabAttachments.windowId", strWindow);
      final String key = vars.getStringParameter("inpKey");
      vars.setSessionValue("TabAttachments.key", key);
      final String strFileReference = vars.getStringParameter("inpcFileId");
      final OBError oberrDelete = delete(vars, strFileReference);
      if (!oberrDelete.getType().equals("Success")) {
        vars.setMessage("TabAttachments", oberrDelete);
        // vars.setSessionValue("TabAttachments.message",
        // Utility.messageBD(this, "Error", vars.getLanguage()));
        // response.sendRedirect(strDireccion + request.getServletPath()
        // + "?Command=EDIT&inpcFileId=" + strFileReference);
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=DEFAULT");
      } else
        response.sendRedirect(strDireccion + request.getServletPath());
    } else if (vars.commandIn("DISPLAY_DATA")) {
      final String strFileReference = vars.getStringParameter("inpcFileId");
      printPageFile(response, vars, strFileReference);
    } else if (vars.commandIn("DEFAULT")) {
      vars.getGlobalVariable("inpTabId", "TabAttachments.tabId");
      vars.getGlobalVariable("inpwindowId", "TabAttachments.windowId");
      vars.getGlobalVariable("inpKey", "TabAttachments.key");
      vars.getGlobalVariable("inpEditable", "TabAttachments.editable","Y");
      printPageFS(response, vars);
    } else if (vars.commandIn("FRAME1", "RELATION")) {
      final String strTab = vars.getGlobalVariable("inpTabId", "TabAttachments.tabId");
      final String strWindow = vars.getGlobalVariable("inpwindowId", "TabAttachments.windowId");
      final String key = vars.getGlobalVariable("inpKey", "TabAttachments.key");
      final boolean editable = vars.getGlobalVariable("inpEditable", "TabAttachments.editable","Y")
          .equals("Y");
      printPage(response, vars, strTab, strWindow, key, editable);
    } else if (vars.commandIn("FRAME2")) {
      whitePage(response);
    } else if (vars.commandIn("EDIT")) {
      final String strTab = vars.getGlobalVariable("inpTabId", "TabAttachments.tabId");
      final String strWindow = vars.getGlobalVariable("inpwindowId", "TabAttachments.windowId");
      final String key = vars.getGlobalVariable("inpKey", "TabAttachments.key");
      final String strFileReference = vars.getRequiredStringParameter("inpcFileId");
      printPageEdit(response, vars, strTab, strWindow, key, strFileReference);
    } else if (vars.commandIn("NEW")) {
      final String strTab = vars.getGlobalVariable("inpTabId", "TabAttachments.tabId");
      final String strWindow = vars.getGlobalVariable("inpwindowId", "TabAttachments.windowId");
      final String key = vars.getRequestGlobalVariable("inpKey", "TabAttachments.key");
      printPageEdit(response, vars, strTab, strWindow, key, "");
    } else if (vars.commandIn("DISPLAY_DATA")) {
      final String strFileReference = vars.getRequiredStringParameter("inpcFileId");
      printPageFile(response, vars, strFileReference);
    } else if (vars.commandIn("CHECK")) {
      final String tabId = vars.getStringParameter("inpTabId");
      final String inpKey = vars.getStringParameter("inpKey");
      printPageCheck(response, vars, tabId, inpKey);
    } else
      pageError(response);
  }

  private OBError insert(VariablesSecureApp vars, String strFileReference, String tableId,
      String key, String strDataType, String strText) throws IOException, ServletException {

    OBError myMessage = null;
    myMessage = new OBError();
    myMessage.setTitle("");

    if (log4j.isDebugEnabled())
      log4j.debug("Deleting records");
    Connection conn = null;
    try {
      conn = this.getTransactionConnection();
      final String inpName = "inpname";
      String strName = "";
      final FileItem file = vars.getMultiFile(inpName);
      if (file == null)
        throw new ServletException("Empty file");
      strName = file.getName();

      int i = strName.lastIndexOf("\\");
      if (i != -1) {
        strName = strName.substring(i + 1);

      } else if ((i = strName.lastIndexOf("/")) != -1) {
        strName = strName.substring(i + 1);
      }
      TabAttachmentsData.insert(conn, this, strFileReference, vars.getClient(), vars.getOrg(), vars
          .getUser(), tableId, key, strDataType, strText, strName);
      try {
        final File uploadedDir = new File(globalParameters.strFTPDirectory + "/" + tableId + "-"
            + key);
        if (!uploadedDir.exists())
          uploadedDir.mkdirs();
        final File uploadedFile = new File(uploadedDir, strName);
        if (uploadedFile.exists())
          throw new ServletException("File " + uploadedFile.getName() + " already exists. Choose a different name.");
        file.write(uploadedFile);

      } catch (final Exception ex) {
        throw new ServletException(ex);
      }
      releaseCommitConnection(conn);
    } catch (final Exception e) {
      try {
        releaseRollbackConnection(conn);
      } catch (final Exception ignored) {
      }
      e.printStackTrace();
      log4j.error("Rollback in transaction");
      myMessage.setType("Error");
      myMessage.setMessage(Utility.messageBD(this, e.getMessage(), vars.getLanguage()));
      return myMessage;
      // return "ProcessRunError";
    }
    myMessage.setType("Success");
    myMessage.setMessage(Utility.messageBD(this, "Success", vars.getLanguage()));
    return myMessage;
    // return "";
  }

  private OBError delete(VariablesSecureApp vars, String strFileReference) throws IOException,
      ServletException {
    OBError myMessage = null;
    myMessage = new OBError();
    myMessage.setTitle("");

    if (log4j.isDebugEnabled())
      log4j.debug("Deleting records");
    Connection conn = null;
    try {
      conn = this.getTransactionConnection();
      final TabAttachmentsData[] data = TabAttachmentsData.selectReference(this, strFileReference);
      TabAttachmentsData.delete(conn, this, strFileReference);
      try {
        FileUtility f = new FileUtility();

        final File file = new File(globalParameters.strFTPDirectory + "/" + data[0].adTableId + "-"
            + data[0].adRecordId, data[0].name);
        if (file.exists())
          f = new FileUtility(globalParameters.strFTPDirectory + "/" + data[0].adTableId + "-"
              + data[0].adRecordId, data[0].name, false);
        else
          f = new FileUtility(globalParameters.strFTPDirectory, strFileReference, false);
        if (f.exists()) {
          if (!f.deleteFile()) {
            myMessage.setType("Error");
            myMessage.setMessage(Utility.messageBD(this, "ProcessRunError", vars.getLanguage()));
            return myMessage;
          }
        }
      } catch (final Exception ex) {
        throw new ServletException(ex);
      }
      releaseCommitConnection(conn);
    } catch (final Exception e) {
      try {
        releaseRollbackConnection(conn);
      } catch (final Exception ignored) {
      }
      e.printStackTrace();
      log4j.error("Rollback in transaction");
      myMessage.setType("Error");
      myMessage.setMessage(Utility.messageBD(this, e.getMessage(), vars.getLanguage()));
      return myMessage;
      // return "ProcessRunError";
    }
    myMessage.setType("Success");
    myMessage.setMessage(Utility.messageBD(this, "Success", vars.getLanguage()));
    return myMessage;
    // return "";
  }

  private void printPageFS(HttpServletResponse response, VariablesSecureApp vars)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: Attachments relations frame set");
    final XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/businessUtility/TabAttachments_FS").createXmlDocument();

    response.setContentType("text/html; charset=UTF-8");
    final PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strTab,
      String strWindow, String key, boolean editable) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: Frame 1 of the attachments relations");
    final String[] discard = { "noData", "" };
    if (!editable)
      discard[1] = "editable";
    final TabAttachmentsData[] data = TabAttachmentsData.selectTabInfo(this, strTab);
    String tableId = "";
    if (data == null || data.length == 0)
      throw new ServletException("Tab not found: " + strTab);
    else {
      tableId = data[0].adTableId;
      if (data[0].isreadonly.equals("Y"))
        discard[0] = new String("selReadOnly");
    }

    final TabAttachmentsData[] files = TabAttachmentsData.select(this, Utility.getContext(this,
        vars, "#User_Client", strWindow), Utility.getContext(this, vars, "#AccessibleOrgTree",
        strWindow), tableId, key);

    if ((files == null) || (files.length == 0))
      discard[0] = "widthData";
    final XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/businessUtility/TabAttachments_F1", discard).createXmlDocument();

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    xmlDocument.setParameter("tab", strTab);
    xmlDocument.setParameter("window", strWindow);
    xmlDocument.setParameter("key", key);
    xmlDocument.setParameter("recordIdentifier", TabAttachmentsData.selectRecordIdentifier(this,
        key, vars.getLanguage(), strTab));

    {
      final OBError myMessage = vars.getMessage("TabAttachments");
      vars.removeMessage("TabAttachments");
      if (myMessage != null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }

    xmlDocument.setData("structure1", files);

    response.setContentType("text/html; charset=UTF-8");
    final PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, VariablesSecureApp vars, String strTab,
      String strWindow, String key, String strFileReference) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: Frame 1 of the attachments edition");
    final String[] discard = { "editDiscard" };
    final TabAttachmentsData[] data = TabAttachmentsData.selectTabInfo(this, strTab);
    if (data == null || data.length == 0)
      throw new ServletException("Tab not found: " + strTab);
    else {
      if (data[0].isreadonly.equals("Y"))
        throw new ServletException("This tab is read only");
    }
    if (strFileReference.equals(""))
      discard[0] = new String("newDiscard");
    final XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/businessUtility/TabAttachments_Edition", discard)
        .createXmlDocument();

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    xmlDocument.setParameter("tab", strTab);
    xmlDocument.setParameter("window", strWindow);
    xmlDocument.setParameter("key", key);
    xmlDocument.setParameter("save", (strFileReference.equals("") ? "NEW" : "EDIT"));
    xmlDocument.setParameter("recordIdentifier", TabAttachmentsData.selectRecordIdentifier(this,
        key, vars.getLanguage(), strTab));

    {
      final OBError myMessage = vars.getMessage("TabAttachments");
      vars.removeMessage("TabAttachments");
      if (myMessage != null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }

    /*
     * String message = vars.getSessionValue("TabAttachments.message"); if (!message.equals(""))
     * message = "alert('" + message + "');"; xmlDocument.setParameter("body", message);
     */

    final TabAttachmentsData[] files = TabAttachmentsData.selectEdit(this, strFileReference);
    // FIXME: If we do not use this code, it should be removed
    /*
     * String viewButtons = "yes"; if (strFileReference.equals("")||files==null||files.length==0)
     * viewButtons="none";
     * 
     * xmlDocument.setParameter("butEdit", viewButtons); xmlDocument.setParameter("butDownload",
     * viewButtons); xmlDocument.setParameter("butDel", viewButtons);
     */

    xmlDocument.setData("structure1", (strFileReference.equals("") ? TabAttachmentsData.set()
        : files));
    xmlDocument.setData("reportAD_Datatype_ID_D", "liststructure", DataTypeComboData.select(this,
        Utility.getContext(this, vars, "#User_Client", "TabAttachments"), Utility.getContext(this,
            vars, "#AccessibleOrgTree", "TabAttachments")));

    response.setContentType("text/html; charset=UTF-8");
    final PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageFile(HttpServletResponse response, VariablesSecureApp vars,
      String strFileReference) throws IOException, ServletException {
    final TabAttachmentsData[] data = TabAttachmentsData.selectEdit(this, strFileReference);
    if (data == null || data.length == 0)
      throw new ServletException("Missing file");
    FileUtility f = new FileUtility();
    final File file = new File(globalParameters.strFTPDirectory + "/" + data[0].adTableId + "-"
        + data[0].adRecordId, data[0].name);
    if (file.exists())
      f = new FileUtility(globalParameters.strFTPDirectory + "/" + data[0].adTableId + "-"
          + data[0].adRecordId, data[0].name, false, true);
    else
      f = new FileUtility(globalParameters.strFTPDirectory, strFileReference, false, true);
    if (data[0].datatypeContent.equals(""))
      response.setContentType("application/txt");
    else
      response.setContentType(data[0].datatypeContent);
    response.setHeader("Content-Disposition", "attachment; filename=\""
        + data[0].name.replace("\"", "\\\"") + "\"");

    f.dumpFile(response.getOutputStream());
    response.getOutputStream().flush();
    response.getOutputStream().close();
  }

  private void printPageCheck(HttpServletResponse response, VariablesSecureApp vars, String strTab,
      String recordId) throws IOException, ServletException {
    response.setContentType("text/plain; charset=UTF-8");
    final PrintWriter out = response.getWriter();
    out.print(Utility.hasTabAttachments(this, vars, strTab, recordId));
    out.close();
  }

  @Override
  public String getServletInfo() {
    return "Servlet that presents the attachments";
  } // end of getServletInfo() method
}
