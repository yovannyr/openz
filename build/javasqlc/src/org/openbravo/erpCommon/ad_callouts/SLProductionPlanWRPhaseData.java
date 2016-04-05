//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SLProductionPlanWRPhaseData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLProductionPlanWRPhaseData.class);
  private String InitRecordNumber="0";
  public String neededqty;
  public String secondaryunit;
  public String conversionrate;
  public String maCostcenterVersionId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("neededqty"))
      return neededqty;
    else if (fieldName.equalsIgnoreCase("secondaryunit"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("conversionrate"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_id") || fieldName.equals("maCostcenterVersionId"))
      return maCostcenterVersionId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLProductionPlanWRPhaseData[] select(ConnectionProvider connectionProvider, String mProductionId, String mawrphaseid)    throws ServletException {
    return select(connectionProvider, mProductionId, mawrphaseid, 0, 0);
  }

  public static SLProductionPlanWRPhaseData[] select(ConnectionProvider connectionProvider, String mProductionId, String mawrphaseid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (wrp.QUANTITY - wrp.DONEQUANTITY) AS neededqty, w.secondaryunit, w.conversionrate, ccv.MA_CostCenter_Version_ID" +
      "      FROM MA_WRPhase wrp, MA_WorkRequirement w, MA_Process p" +
      "           LEFT JOIN MA_CostCenter cc ON p.MA_COSTCENTER_ID = cc.MA_CostCenter_Id" +
      "           LEFT JOIN (SELECT MA_COSTCENTER_VERSION_ID,MA_COstcenter_ID " +
      "                      FROM MA_CostCenter_Version maccv2" +
      "                      WHERE validfrom= (SELECT MAX(validfrom) " +
      "                                        FROM MA_COSTCENTER_VERSION maccv3" +
      "                                        WHERE maccv2.Ma_Costcenter_id = maccv3.Ma_Costcenter_id" +
      "                                          AND validfrom < (SELECT pr.Movementdate" +
      "                                                           FROM M_Production pr" +
      "                                                           WHERE pr.M_Production_ID = ?))) ccv ON cc.MA_Costcenter_ID  = ccv.MA_COstCenter_ID" +
      "      WHERE wrp.MA_WRPhase_ID = ?" +
      "      AND wrp.MA_Process_ID = p.MA_Process_ID" +
      "      AND wrp.MA_WorkRequirement_ID = w.MA_WorkRequirement_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mawrphaseid);

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
        SLProductionPlanWRPhaseData objectSLProductionPlanWRPhaseData = new SLProductionPlanWRPhaseData();
        objectSLProductionPlanWRPhaseData.neededqty = UtilSql.getValue(result, "neededqty");
        objectSLProductionPlanWRPhaseData.secondaryunit = UtilSql.getValue(result, "secondaryunit");
        objectSLProductionPlanWRPhaseData.conversionrate = UtilSql.getValue(result, "conversionrate");
        objectSLProductionPlanWRPhaseData.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectSLProductionPlanWRPhaseData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLProductionPlanWRPhaseData);
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
    SLProductionPlanWRPhaseData objectSLProductionPlanWRPhaseData[] = new SLProductionPlanWRPhaseData[vector.size()];
    vector.copyInto(objectSLProductionPlanWRPhaseData);
    return(objectSLProductionPlanWRPhaseData);
  }

  public static SLProductionPlanWRPhaseData[] set()    throws ServletException {
    SLProductionPlanWRPhaseData objectSLProductionPlanWRPhaseData[] = new SLProductionPlanWRPhaseData[1];
    objectSLProductionPlanWRPhaseData[0] = new SLProductionPlanWRPhaseData();
    objectSLProductionPlanWRPhaseData[0].neededqty = "";
    objectSLProductionPlanWRPhaseData[0].secondaryunit = "";
    objectSLProductionPlanWRPhaseData[0].conversionrate = "";
    objectSLProductionPlanWRPhaseData[0].maCostcenterVersionId = "";
    return objectSLProductionPlanWRPhaseData;
  }

  public static String selectOutsourced(ConnectionProvider connectionProvider, String mProductionPlanId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT coalesce(wrp.Outsourced, 'N') as Outsourced" +
      "       FROM MA_WRPhase wrp" +
      "       WHERE wrp.MA_WRPhase_ID = ?";

    ResultSet result;
    String strReturn = "N";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionPlanId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "outsourced");
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
}
