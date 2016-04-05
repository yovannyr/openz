//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class AttributeSetInstanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(AttributeSetInstanceData.class);
  private String InitRecordNumber="0";
  public String mAttributesetId;
  public String name;
  public String description;
  public String guaranteedays;
  public String isguaranteedate;
  public String islot;
  public String isserno;
  public String mLotctlId;
  public String mSernoctlId;
  public String islist;
  public String elementname;
  public String mAttributeId;
  public String islockable;
  public String isinstanceattribute;
  public String mAttributesetinstanceId;
  public String guaranteedate;
  public String lot;
  public String serno;
  public String mAttributevalueId;
  public String value;
  public String ismandatory;
  public String islocked;
  public String lockDescription;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("isguaranteedate"))
      return isguaranteedate;
    else if (fieldName.equalsIgnoreCase("islot"))
      return islot;
    else if (fieldName.equalsIgnoreCase("isserno"))
      return isserno;
    else if (fieldName.equalsIgnoreCase("m_lotctl_id") || fieldName.equals("mLotctlId"))
      return mLotctlId;
    else if (fieldName.equalsIgnoreCase("m_sernoctl_id") || fieldName.equals("mSernoctlId"))
      return mSernoctlId;
    else if (fieldName.equalsIgnoreCase("islist"))
      return islist;
    else if (fieldName.equalsIgnoreCase("elementname"))
      return elementname;
    else if (fieldName.equalsIgnoreCase("m_attribute_id") || fieldName.equals("mAttributeId"))
      return mAttributeId;
    else if (fieldName.equalsIgnoreCase("islockable"))
      return islockable;
    else if (fieldName.equalsIgnoreCase("isinstanceattribute"))
      return isinstanceattribute;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
    else if (fieldName.equalsIgnoreCase("serno"))
      return serno;
    else if (fieldName.equalsIgnoreCase("m_attributevalue_id") || fieldName.equals("mAttributevalueId"))
      return mAttributevalueId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("ismandatory"))
      return ismandatory;
    else if (fieldName.equalsIgnoreCase("islocked"))
      return islocked;
    else if (fieldName.equalsIgnoreCase("lock_description") || fieldName.equals("lockDescription"))
      return lockDescription;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AttributeSetInstanceData[] select(ConnectionProvider connectionProvider, String mAttributesetId)    throws ServletException {
    return select(connectionProvider, mAttributesetId, 0, 0);
  }

  public static AttributeSetInstanceData[] select(ConnectionProvider connectionProvider, String mAttributesetId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_S.M_ATTRIBUTESET_ID, A_S.NAME, A_S.DESCRIPTION, A_S.GUARANTEEDAYS, A_S.ISGUARANTEEDATE, A_S.ISLOT, A_S.ISSERNO, " +
      "        A_S.M_LOTCTL_ID, A_S.M_SERNOCTL_ID, A.ISLIST, A.NAME AS ELEMENTNAME, A.M_ATTRIBUTE_ID, " +
      "        A_S.ISLOCKABLE, A.ISINSTANCEATTRIBUTE, '' AS M_ATTRIBUTESETINSTANCE_ID, '' as GUARANTEEDATE, '' as LOT, '' as SERNO, " +
      "        '' as M_ATTRIBUTEVALUE_ID, '' as VALUE, A.ISMANDATORY, '' AS ISLOCKED, '' AS LOCK_DESCRIPTION " +
      "        FROM M_ATTRIBUTESET A_S left join (M_ATTRIBUTEUSE A_U " +
      "                                           join M_ATTRIBUTE A on A_U.M_ATTRIBUTE_ID = A.M_ATTRIBUTE_ID" +
      "                                                                 and A_U.ISACTIVE= 'Y'" +
      "                                                                 and A.ISACTIVE= 'Y')" +
      "                                on a_s.M_ATTRIBUTESET_ID = a_u.M_ATTRIBUTESET_ID" +
      "        WHERE A_S.ISACTIVE = 'Y'" +
      "        AND A_S.M_ATTRIBUTESET_ID = ? " +
      "        ORDER BY A_U.SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        AttributeSetInstanceData objectAttributeSetInstanceData = new AttributeSetInstanceData();
        objectAttributeSetInstanceData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAttributeSetInstanceData.name = UtilSql.getValue(result, "name");
        objectAttributeSetInstanceData.description = UtilSql.getValue(result, "description");
        objectAttributeSetInstanceData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectAttributeSetInstanceData.isguaranteedate = UtilSql.getValue(result, "isguaranteedate");
        objectAttributeSetInstanceData.islot = UtilSql.getValue(result, "islot");
        objectAttributeSetInstanceData.isserno = UtilSql.getValue(result, "isserno");
        objectAttributeSetInstanceData.mLotctlId = UtilSql.getValue(result, "m_lotctl_id");
        objectAttributeSetInstanceData.mSernoctlId = UtilSql.getValue(result, "m_sernoctl_id");
        objectAttributeSetInstanceData.islist = UtilSql.getValue(result, "islist");
        objectAttributeSetInstanceData.elementname = UtilSql.getValue(result, "elementname");
        objectAttributeSetInstanceData.mAttributeId = UtilSql.getValue(result, "m_attribute_id");
        objectAttributeSetInstanceData.islockable = UtilSql.getValue(result, "islockable");
        objectAttributeSetInstanceData.isinstanceattribute = UtilSql.getValue(result, "isinstanceattribute");
        objectAttributeSetInstanceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectAttributeSetInstanceData.guaranteedate = UtilSql.getValue(result, "guaranteedate");
        objectAttributeSetInstanceData.lot = UtilSql.getValue(result, "lot");
        objectAttributeSetInstanceData.serno = UtilSql.getValue(result, "serno");
        objectAttributeSetInstanceData.mAttributevalueId = UtilSql.getValue(result, "m_attributevalue_id");
        objectAttributeSetInstanceData.value = UtilSql.getValue(result, "value");
        objectAttributeSetInstanceData.ismandatory = UtilSql.getValue(result, "ismandatory");
        objectAttributeSetInstanceData.islocked = UtilSql.getValue(result, "islocked");
        objectAttributeSetInstanceData.lockDescription = UtilSql.getValue(result, "lock_description");
        objectAttributeSetInstanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetInstanceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[vector.size()];
    vector.copyInto(objectAttributeSetInstanceData);
    return(objectAttributeSetInstanceData);
  }

  public static AttributeSetInstanceData[] set()    throws ServletException {
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[1];
    objectAttributeSetInstanceData[0] = new AttributeSetInstanceData();
    objectAttributeSetInstanceData[0].mAttributesetId = "";
    objectAttributeSetInstanceData[0].name = "";
    objectAttributeSetInstanceData[0].description = "";
    objectAttributeSetInstanceData[0].guaranteedays = "";
    objectAttributeSetInstanceData[0].isguaranteedate = "";
    objectAttributeSetInstanceData[0].islot = "";
    objectAttributeSetInstanceData[0].isserno = "";
    objectAttributeSetInstanceData[0].mLotctlId = "";
    objectAttributeSetInstanceData[0].mSernoctlId = "";
    objectAttributeSetInstanceData[0].islist = "";
    objectAttributeSetInstanceData[0].elementname = "";
    objectAttributeSetInstanceData[0].mAttributeId = "";
    objectAttributeSetInstanceData[0].islockable = "";
    objectAttributeSetInstanceData[0].isinstanceattribute = "";
    objectAttributeSetInstanceData[0].mAttributesetinstanceId = "";
    objectAttributeSetInstanceData[0].guaranteedate = "";
    objectAttributeSetInstanceData[0].lot = "";
    objectAttributeSetInstanceData[0].serno = "";
    objectAttributeSetInstanceData[0].mAttributevalueId = "";
    objectAttributeSetInstanceData[0].value = "";
    objectAttributeSetInstanceData[0].ismandatory = "";
    objectAttributeSetInstanceData[0].islocked = "";
    objectAttributeSetInstanceData[0].lockDescription = "";
    return objectAttributeSetInstanceData;
  }

  public static AttributeSetInstanceData[] selectInstance(ConnectionProvider connectionProvider, String mAttributesetinstanceId)    throws ServletException {
    return selectInstance(connectionProvider, mAttributesetinstanceId, 0, 0);
  }

  public static AttributeSetInstanceData[] selectInstance(ConnectionProvider connectionProvider, String mAttributesetinstanceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_S.DESCRIPTION, A_S.GUARANTEEDATE, A_S.LOT, A_S.SERNO, A_S.M_ATTRIBUTESET_ID, " +
      "        A.M_ATTRIBUTEVALUE_ID, A.M_ATTRIBUTE_ID, A.VALUE, A_S.ISLOCKED, A_S.LOCK_DESCRIPTION " +
      "        FROM M_ATTRIBUTESETINSTANCE A_S left join M_ATTRIBUTEINSTANCE A on A_S.M_ATTRIBUTESETINSTANCE_ID = A.M_ATTRIBUTESETINSTANCE_ID" +
      "        WHERE A_S.M_ATTRIBUTESETINSTANCE_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        AttributeSetInstanceData objectAttributeSetInstanceData = new AttributeSetInstanceData();
        objectAttributeSetInstanceData.description = UtilSql.getValue(result, "description");
        objectAttributeSetInstanceData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectAttributeSetInstanceData.lot = UtilSql.getValue(result, "lot");
        objectAttributeSetInstanceData.serno = UtilSql.getValue(result, "serno");
        objectAttributeSetInstanceData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAttributeSetInstanceData.mAttributevalueId = UtilSql.getValue(result, "m_attributevalue_id");
        objectAttributeSetInstanceData.mAttributeId = UtilSql.getValue(result, "m_attribute_id");
        objectAttributeSetInstanceData.value = UtilSql.getValue(result, "value");
        objectAttributeSetInstanceData.islocked = UtilSql.getValue(result, "islocked");
        objectAttributeSetInstanceData.lockDescription = UtilSql.getValue(result, "lock_description");
        objectAttributeSetInstanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetInstanceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[vector.size()];
    vector.copyInto(objectAttributeSetInstanceData);
    return(objectAttributeSetInstanceData);
  }

  public static AttributeSetInstanceData[] selectList(ConnectionProvider connectionProvider, String mAttributeId)    throws ServletException {
    return selectList(connectionProvider, mAttributeId, 0, 0);
  }

  public static AttributeSetInstanceData[] selectList(ConnectionProvider connectionProvider, String mAttributeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_ATTRIBUTEVALUE_ID AS VALUE, NAME, DESCRIPTION " +
      "        FROM M_ATTRIBUTEVALUE" +
      "        WHERE M_ATTRIBUTE_ID = ?" +
      "        AND ISACTIVE='Y'" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeId);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        AttributeSetInstanceData objectAttributeSetInstanceData = new AttributeSetInstanceData();
        objectAttributeSetInstanceData.value = UtilSql.getValue(result, "value");
        objectAttributeSetInstanceData.name = UtilSql.getValue(result, "name");
        objectAttributeSetInstanceData.description = UtilSql.getValue(result, "description");
        objectAttributeSetInstanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetInstanceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[vector.size()];
    vector.copyInto(objectAttributeSetInstanceData);
    return(objectAttributeSetInstanceData);
  }

  public static String existingInstance(ConnectionProvider connectionProvider, String mLocatorId, String description)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m.m_attributesetinstance_id " +
      "        FROM m_storage_detail m, M_AttributeSetInstance a " +
      "        WHERE m.M_ATTRIBUTESETINSTANCE_ID = a.M_ATTRIBUTESETINSTANCE_ID " +
      "        and m.M_LOCATOR_ID = ? " +
      "        and upper(description) = upper(?)";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributesetinstance_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String hasIdentical(ConnectionProvider connectionProvider, String description, String mAttributeSet)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_attributesetinstance_id " +
      "        FROM M_AttributeSetInstance " +
      "        WHERE (upper(description) = upper(?) OR ((description IS NULL) AND (? IS NULL)))" +
      "        AND M_AttributeSet_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSet);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributesetinstance_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectDescription(ConnectionProvider connectionProvider, String mAttributesetinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DESCRIPTION FROM M_ATTRIBUTESETINSTANCE WHERE M_ATTRIBUTESETINSTANCE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "description");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectNextLot(ConnectionProvider connectionProvider, String mLotctlId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(TO_CHAR(PREFIX),'') || CURRENTNEXT || COALESCE(TO_CHAR(SUFFIX),'') AS TOTAL" +
      "        FROM M_LOTCTL " +
      "        WHERE M_LOTCTL_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotctlId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectNextSerNo(ConnectionProvider connectionProvider, String mSernoctlId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(TO_CHAR(PREFIX),'') || CURRENTNEXT || COALESCE(TO_CHAR(SUFFIX),'') AS TOTAL" +
      "        FROM M_SERNOCTL " +
      "        WHERE M_SERNOCTL_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mSernoctlId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectNextSerNo(Connection conn, ConnectionProvider connectionProvider, String mSernoctlId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(TO_CHAR(PREFIX),'') || CURRENTNEXT || COALESCE(TO_CHAR(SUFFIX),'') AS TOTAL" +
      "        FROM M_SERNOCTL " +
      "        WHERE M_SERNOCTL_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mSernoctlId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static AttributeSetInstanceData[] selectProductAttr(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return selectProductAttr(connectionProvider, mProductId, 0, 0);
  }

  public static AttributeSetInstanceData[] selectProductAttr(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_attributeset_id, m_attributesetinstance_id FROM M_PRODUCT WHERE m_product_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        AttributeSetInstanceData objectAttributeSetInstanceData = new AttributeSetInstanceData();
        objectAttributeSetInstanceData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAttributeSetInstanceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectAttributeSetInstanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetInstanceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[vector.size()];
    vector.copyInto(objectAttributeSetInstanceData);
    return(objectAttributeSetInstanceData);
  }

  public static String selectAttributeSet(ConnectionProvider connectionProvider, String mAttributesetinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT s.M_ATTRIBUTESET_ID" +
      "        FROM M_ATTRIBUTESETINSTANCE s" +
      "        WHERE s.M_ATTRIBUTESETINSTANCE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributeset_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String isInstanceAttribute(ConnectionProvider connectionProvider, String mAttributesetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE A_S.ISLOCKABLE WHEN 'Y' THEN 1 ELSE (CASE A_S.ISLOT WHEN 'Y' THEN 1 ELSE (CASE A_S.ISSERNO WHEN 'Y' THEN 1 ELSE (CASE A_S.ISGUARANTEEDATE WHEN 'Y' THEN 1 ELSE " +
      "        (CASE (SELECT MAX(ISINSTANCEATTRIBUTE) FROM M_ATTRIBUTE, M_ATTRIBUTEUSE " +
      "                WHERE M_ATTRIBUTE.M_ATTRIBUTE_ID = M_ATTRIBUTEUSE.M_ATTRIBUTE_ID" +
      "                AND M_ATTRIBUTEUSE.M_ATTRIBUTESET_ID = A_S.M_ATTRIBUTESET_ID) WHEN 'Y' THEN 1 ELSE 0 END) END) END) END) END) AS TOTAL " +
      "        FROM M_ATTRIBUTESET A_S" +
      "        WHERE A_S.ISACTIVE = 'Y'" +
      "        AND A_S.M_ATTRIBUTESET_ID = ? ";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static AttributeSetInstanceData[] selectKey(ConnectionProvider connectionProvider, String mAttributesetId)    throws ServletException {
    return selectKey(connectionProvider, mAttributesetId, 0, 0);
  }

  public static AttributeSetInstanceData[] selectKey(ConnectionProvider connectionProvider, String mAttributesetId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_S.M_ATTRIBUTESET_ID, A_S.NAME, A_S.DESCRIPTION, A_S.GUARANTEEDAYS, A_S.ISGUARANTEEDATE, A_S.ISLOT, A_S.ISSERNO, " +
      "        A_S.M_LOTCTL_ID, A_S.M_SERNOCTL_ID, A_S.ISLOCKABLE, A.ISINSTANCEATTRIBUTE, '' AS M_ATTRIBUTESETINSTANCE_ID " +
      "        FROM M_ATTRIBUTESET A_S left join M_ATTRIBUTEUSE A_U on a_s.M_ATTRIBUTESET_ID = a_u.M_ATTRIBUTESET_ID" +
      "                                left join M_ATTRIBUTE A on A_U.M_ATTRIBUTE_ID = A.M_ATTRIBUTE_ID " +
      "                                                        and A_U.ISACTIVE = 'Y'" +
      "        WHERE  A_S.ISACTIVE = 'Y'" +
      "        AND A_S.M_ATTRIBUTESET_ID = ? " +
      "        ORDER BY A_U.SEQNO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        AttributeSetInstanceData objectAttributeSetInstanceData = new AttributeSetInstanceData();
        objectAttributeSetInstanceData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAttributeSetInstanceData.name = UtilSql.getValue(result, "name");
        objectAttributeSetInstanceData.description = UtilSql.getValue(result, "description");
        objectAttributeSetInstanceData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectAttributeSetInstanceData.isguaranteedate = UtilSql.getValue(result, "isguaranteedate");
        objectAttributeSetInstanceData.islot = UtilSql.getValue(result, "islot");
        objectAttributeSetInstanceData.isserno = UtilSql.getValue(result, "isserno");
        objectAttributeSetInstanceData.mLotctlId = UtilSql.getValue(result, "m_lotctl_id");
        objectAttributeSetInstanceData.mSernoctlId = UtilSql.getValue(result, "m_sernoctl_id");
        objectAttributeSetInstanceData.islockable = UtilSql.getValue(result, "islockable");
        objectAttributeSetInstanceData.isinstanceattribute = UtilSql.getValue(result, "isinstanceattribute");
        objectAttributeSetInstanceData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectAttributeSetInstanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAttributeSetInstanceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    AttributeSetInstanceData objectAttributeSetInstanceData[] = new AttributeSetInstanceData[vector.size()];
    vector.copyInto(objectAttributeSetInstanceData);
    return(objectAttributeSetInstanceData);
  }

  public static String selectAttributeValue(ConnectionProvider connectionProvider, String mAttributevalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NAME FROM M_ATTRIBUTEVALUE WHERE M_ATTRIBUTEVALUE_ID=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributevalueId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String mAttributeinstanceId, String mAttributesetinstanceId, String mAttributeId, String adClientId, String adOrgId, String adUserId, String mAttributevalueId, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_ATTRIBUTEINSTANCE (M_ATTRIBUTEINSTANCE_ID, M_ATTRIBUTESETINSTANCE_ID, M_ATTRIBUTE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, " +
      "        CREATEDBY, UPDATED, UPDATEDBY, M_ATTRIBUTEVALUE_ID, VALUE) " +
      "        VALUES ( ?, ?, ?, ?, ?, 'Y', now(), ?, now(), ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributevalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int update(Connection conn, ConnectionProvider connectionProvider, String adUserId, String mAttributevalueId, String value, String mAttributesetinstanceId, String mAttributeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_ATTRIBUTEINSTANCE SET UPDATED=now(), UPDATEDBY = ?, M_ATTRIBUTEVALUE_id = ?, VALUE=? " +
      "        WHERE M_ATTRIBUTESETINSTANCE_ID = ? " +
      "        AND M_ATTRIBUTE_ID = ? " +
      "        AND ISACTIVE = 'Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributevalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int insertHeader(Connection conn, ConnectionProvider connectionProvider, String mAttributesetinstanceId, String adClientId, String adOrgId, String adUserId, String mAttributesetId, String serno, String lot, String guaranteedate, String mLotId, String islocked, String lockDescription)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_ATTRIBUTESETINSTANCE (M_ATTRIBUTESETINSTANCE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, M_ATTRIBUTESET_ID, SERNO, LOT, GUARANTEEDATE, M_LOT_ID, ISLOCKED, LOCK_DESCRIPTION) " +
      "        VALUES ( ?, ?, ?, 'Y', now(), ?, now(), ?, ?, ?, ?, TO_DATE(?), ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockDescription);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateHeader(Connection conn, ConnectionProvider connectionProvider, String adUserId, String mAttributesetId, String serno, String lot, String guaranteedate, String mLotId, String islocked, String lockDescription, String mAttributesetinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_ATTRIBUTESETINSTANCE SET UPDATED=now(), UPDATEDBY = ?, M_ATTRIBUTESET_ID = ?, SERNO=?, LOT=?, GUARANTEEDATE=TO_DATE(?), " +
      "        M_LOT_ID = ?, ISLOCKED = ?, LOCK_DESCRIPTION = ? " +
      "        WHERE M_ATTRIBUTESETINSTANCE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lot);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateHeaderDescription(Connection conn, ConnectionProvider connectionProvider, String adUserId, String description, String mAttributesetinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_ATTRIBUTESETINSTANCE SET UPDATED=now(), UPDATEDBY = ?, DESCRIPTION=? " +
      "        WHERE M_ATTRIBUTESETINSTANCE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateLotSequence(Connection conn, ConnectionProvider connectionProvider, String adUserId, String mLotctlId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_LOTCTL SET UPDATED=now(), UPDATEDBY = ?, CURRENTNEXT=(CURRENTNEXT + INCREMENTNO) " +
      "        WHERE M_LOTCTL_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLotctlId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateSerNoSequence(Connection conn, ConnectionProvider connectionProvider, String adUserId, String mSernoctlId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_SERNOCTL SET UPDATED=now(), UPDATEDBY = ?, CURRENTNEXT=(CURRENTNEXT + INCREMENTNO) " +
      "        WHERE M_SERNOCTL_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mSernoctlId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }
}
