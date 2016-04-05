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
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.zsoft.serprod;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.project.StandardTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity zssm_workstep_v (stored in table zssm_workstep_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class zssm_workstep_v extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssm_workstep_v";
    public static final String ENTITY_NAME = "zssm_workstep_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_TASK = "task";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ZSSMPRODUCTIONORDERV =
        "zssmProductionorderV";
    public static final String PROPERTY_ZSSMPRJNAME = "zssmPrjName";
    public static final String PROPERTY_ZSSMPRJPROJECTCATEGORY =
        "zssmPrjProjectcategory";
    public static final String PROPERTY_SEQNO = "seqNo";
    public static final String PROPERTY_TASKBEGUN = "taskbegun";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELP = "help";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_ISCOMPLETE = "iscomplete";
    public static final String PROPERTY_PRICEACTUAL = "priceActual";
    public static final String PROPERTY_COMMITTEDAMT = "committedamt";
    public static final String PROPERTY_ISCOMMITCEILING = "iscommitceiling";
    public static final String PROPERTY_DATECONTRACT = "datecontract";
    public static final String PROPERTY_SCHEDULESTATUS = "schedulestatus";
    public static final String PROPERTY_ACTUALCOST = "actualcost";
    public static final String PROPERTY_PLANNEDCOST = "plannedcost";
    public static final String PROPERTY_PERCENTDONE = "percentdone";
    public static final String PROPERTY_OUTSOURCING = "outsourcing";
    public static final String PROPERTY_ISMATERIALDISPOSED =
        "ismaterialdisposed";
    public static final String PROPERTY_ISTASKCANCELLED = "istaskcancelled";
    public static final String PROPERTY_CREATEBOM = "createbom";
    public static final String PROPERTY_PLANMATERIAL = "planmaterial";
    public static final String PROPERTY_UNPLANMATERIAL = "unplanmaterial";
    public static final String PROPERTY_CANCELTASK = "canceltask";
    public static final String PROPERTY_BEGINTASK = "beginTask";
    public static final String PROPERTY_ENDTASK = "endtask";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_INDIRECTCOST = "indirectcost";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_EXPENSES = "expenses";
    public static final String PROPERTY_SERVCOST = "servcost";
    public static final String PROPERTY_MATERIALCOSTPLAN = "materialcostplan";
    public static final String PROPERTY_INDIRECTCOSTPLAN = "indirectcostplan";
    public static final String PROPERTY_MACHINECOSTPLAN = "machinecostplan";
    public static final String PROPERTY_SERVCOSTPLAN = "servcostplan";
    public static final String PROPERTY_GETMATERIALFROMSTOCK =
        "getmaterialfromstock";
    public static final String PROPERTY_GOTOPURCHASING = "gotopurchasing";
    public static final String PROPERTY_RETURNMATERIALTOSTOCK =
        "returnmaterialtostock";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_ASSEMBLY = "assembly";
    public static final String PROPERTY_QTYPRODUCED = "qtyproduced";
    public static final String PROPERTY_QTYLEFT = "qtyleft";
    public static final String PROPERTY_RECEIVINGLOCATOR = "receivingLocator";
    public static final String PROPERTY_ISSUINGLOCATOR = "issuingLocator";
    public static final String PROPERTY_PERCENTREJECTS = "percentrejects";
    public static final String PROPERTY_STARTED = "started";
    public static final String PROPERTY_ENDED = "ended";
    public static final String PROPERTY_STARTONLYWITHCOMPLETEMATERIAL =
        "startonlywithcompletematerial";
    public static final String PROPERTY_FORCEMATERIALSCAN = "forcematerialscan";
    public static final String PROPERTY_ZSSMPRODUCTIONPLANTASK =
        "zssmProductionplanTask";
    public static final String PROPERTY_TIMEPERPIECE = "timeperpiece";
    public static final String PROPERTY_SETUPTIME = "setuptime";
    public static final String PROPERTY_ISAUTOTRIGGERED = "isautotriggered";
    public static final String PROPERTY_TIMEPLANNED = "timeplanned";
    public static final String PROPERTY_WEIGHTPROPORTION = "weightproportion";
    public static final String PROPERTY_TRIGGERREASON = "triggerreason";
    public static final String PROPERTY_ZSSMWORKSTEPDEPENDENCIESVLIST =
        "zssmWorkstepdependenciesVList";
    public static final String PROPERTY_ZSSMWORKSTEPMACHINESVLIST =
        "zssmWorkstepmachinesVList";
    public static final String PROPERTY_ZSSMWORKSTEPBOMVLIST =
        "zssmWorkstepbomVList";
    public static final String PROPERTY_ZSSMWORKSTEPTECHDOCVLIST =
        "zssmWorkstepTechDocVList";
    public static final String PROPERTY_ZSSMWORKSTEPACTIVITIESVLIST =
        "zssmWorkstepactivitiesVList";
    public static final String PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST =
        "zspmMaterialmovementsViewList";
    public static final String PROPERTY_ZSSMFEEDBACKVLIST = "zssmFeedbackVList";

    public zssm_workstep_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_TASKBEGUN, false);
        setDefaultValue(PROPERTY_QTY, new BigDecimal(1));
        setDefaultValue(PROPERTY_ISCOMPLETE, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
        setDefaultValue(PROPERTY_OUTSOURCING, false);
        setDefaultValue(PROPERTY_ISMATERIALDISPOSED, false);
        setDefaultValue(PROPERTY_ISTASKCANCELLED, false);
        setDefaultValue(PROPERTY_CREATEBOM, false);
        setDefaultValue(PROPERTY_PLANMATERIAL, false);
        setDefaultValue(PROPERTY_UNPLANMATERIAL, false);
        setDefaultValue(PROPERTY_CANCELTASK, false);
        setDefaultValue(PROPERTY_BEGINTASK, false);
        setDefaultValue(PROPERTY_ENDTASK, false);
        setDefaultValue(PROPERTY_GETMATERIALFROMSTOCK, false);
        setDefaultValue(PROPERTY_GOTOPURCHASING, false);
        setDefaultValue(PROPERTY_RETURNMATERIALTOSTOCK, false);
        setDefaultValue(PROPERTY_ASSEMBLY, false);
        setDefaultValue(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL, false);
        setDefaultValue(PROPERTY_FORCEMATERIALSCAN, false);
        setDefaultValue(PROPERTY_ISAUTOTRIGGERED, false);
        setDefaultValue(PROPERTY_ZSSMWORKSTEPDEPENDENCIESVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMWORKSTEPMACHINESVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMWORKSTEPBOMVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMWORKSTEPTECHDOCVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMWORKSTEPACTIVITIESVLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_ZSSMFEEDBACKVLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public ProjectTask getProjectTask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjectTask(ProjectTask projectTask) {
        set(PROPERTY_PROJECTTASK, projectTask);
    }

    public StandardTask getTask() {
        return (StandardTask) get(PROPERTY_TASK);
    }

    public void setTask(StandardTask task) {
        set(PROPERTY_TASK, task);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public org.openbravo.zsoft.serprod.zssm_productionorder_v getZssmProductionorderV() {
        return (org.openbravo.zsoft.serprod.zssm_productionorder_v) get(PROPERTY_ZSSMPRODUCTIONORDERV);
    }

    public void setZssmProductionorderV(
        org.openbravo.zsoft.serprod.zssm_productionorder_v zssmProductionorderV) {
        set(PROPERTY_ZSSMPRODUCTIONORDERV, zssmProductionorderV);
    }

    public String getZssmPrjName() {
        return (String) get(PROPERTY_ZSSMPRJNAME);
    }

    public void setZssmPrjName(String zssmPrjName) {
        set(PROPERTY_ZSSMPRJNAME, zssmPrjName);
    }

    public String getZssmPrjProjectcategory() {
        return (String) get(PROPERTY_ZSSMPRJPROJECTCATEGORY);
    }

    public void setZssmPrjProjectcategory(String zssmPrjProjectcategory) {
        set(PROPERTY_ZSSMPRJPROJECTCATEGORY, zssmPrjProjectcategory);
    }

    public Long getSeqNo() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqNo(Long seqNo) {
        set(PROPERTY_SEQNO, seqNo);
    }

    public Boolean isTaskbegun() {
        return (Boolean) get(PROPERTY_TASKBEGUN);
    }

    public void setTaskbegun(Boolean taskbegun) {
        set(PROPERTY_TASKBEGUN, taskbegun);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getHelp() {
        return (String) get(PROPERTY_HELP);
    }

    public void setHelp(String help) {
        set(PROPERTY_HELP, help);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public Boolean isComplete() {
        return (Boolean) get(PROPERTY_ISCOMPLETE);
    }

    public void setComplete(Boolean iscomplete) {
        set(PROPERTY_ISCOMPLETE, iscomplete);
    }

    public BigDecimal getPriceActual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceActual(BigDecimal priceActual) {
        set(PROPERTY_PRICEACTUAL, priceActual);
    }

    public BigDecimal getCommittedamt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedamt(BigDecimal committedamt) {
        set(PROPERTY_COMMITTEDAMT, committedamt);
    }

    public Boolean isCommitceiling() {
        return (Boolean) get(PROPERTY_ISCOMMITCEILING);
    }

    public void setCommitceiling(Boolean iscommitceiling) {
        set(PROPERTY_ISCOMMITCEILING, iscommitceiling);
    }

    public Date getDatecontract() {
        return (Date) get(PROPERTY_DATECONTRACT);
    }

    public void setDatecontract(Date datecontract) {
        set(PROPERTY_DATECONTRACT, datecontract);
    }

    public String getSchedulestatus() {
        return (String) get(PROPERTY_SCHEDULESTATUS);
    }

    public void setSchedulestatus(String schedulestatus) {
        set(PROPERTY_SCHEDULESTATUS, schedulestatus);
    }

    public BigDecimal getActualcost() {
        return (BigDecimal) get(PROPERTY_ACTUALCOST);
    }

    public void setActualcost(BigDecimal actualcost) {
        set(PROPERTY_ACTUALCOST, actualcost);
    }

    public BigDecimal getPlannedcost() {
        return (BigDecimal) get(PROPERTY_PLANNEDCOST);
    }

    public void setPlannedcost(BigDecimal plannedcost) {
        set(PROPERTY_PLANNEDCOST, plannedcost);
    }

    public Long getPercentdone() {
        return (Long) get(PROPERTY_PERCENTDONE);
    }

    public void setPercentdone(Long percentdone) {
        set(PROPERTY_PERCENTDONE, percentdone);
    }

    public Boolean isOutsourcing() {
        return (Boolean) get(PROPERTY_OUTSOURCING);
    }

    public void setOutsourcing(Boolean outsourcing) {
        set(PROPERTY_OUTSOURCING, outsourcing);
    }

    public Boolean isMaterialdisposed() {
        return (Boolean) get(PROPERTY_ISMATERIALDISPOSED);
    }

    public void setMaterialdisposed(Boolean ismaterialdisposed) {
        set(PROPERTY_ISMATERIALDISPOSED, ismaterialdisposed);
    }

    public Boolean isTaskcancelled() {
        return (Boolean) get(PROPERTY_ISTASKCANCELLED);
    }

    public void setTaskcancelled(Boolean istaskcancelled) {
        set(PROPERTY_ISTASKCANCELLED, istaskcancelled);
    }

    public Boolean isCreatebom() {
        return (Boolean) get(PROPERTY_CREATEBOM);
    }

    public void setCreatebom(Boolean createbom) {
        set(PROPERTY_CREATEBOM, createbom);
    }

    public Boolean isPlanmaterial() {
        return (Boolean) get(PROPERTY_PLANMATERIAL);
    }

    public void setPlanmaterial(Boolean planmaterial) {
        set(PROPERTY_PLANMATERIAL, planmaterial);
    }

    public Boolean isUnplanmaterial() {
        return (Boolean) get(PROPERTY_UNPLANMATERIAL);
    }

    public void setUnplanmaterial(Boolean unplanmaterial) {
        set(PROPERTY_UNPLANMATERIAL, unplanmaterial);
    }

    public Boolean isCanceltask() {
        return (Boolean) get(PROPERTY_CANCELTASK);
    }

    public void setCanceltask(Boolean canceltask) {
        set(PROPERTY_CANCELTASK, canceltask);
    }

    public Boolean isBeginTask() {
        return (Boolean) get(PROPERTY_BEGINTASK);
    }

    public void setBeginTask(Boolean beginTask) {
        set(PROPERTY_BEGINTASK, beginTask);
    }

    public Boolean isEndtask() {
        return (Boolean) get(PROPERTY_ENDTASK);
    }

    public void setEndtask(Boolean endtask) {
        set(PROPERTY_ENDTASK, endtask);
    }

    public BigDecimal getMaterialcost() {
        return (BigDecimal) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(BigDecimal materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
    }

    public BigDecimal getIndirectcost() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectcost(BigDecimal indirectcost) {
        set(PROPERTY_INDIRECTCOST, indirectcost);
    }

    public BigDecimal getMachinecost() {
        return (BigDecimal) get(PROPERTY_MACHINECOST);
    }

    public void setMachinecost(BigDecimal machinecost) {
        set(PROPERTY_MACHINECOST, machinecost);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public BigDecimal getExpenses() {
        return (BigDecimal) get(PROPERTY_EXPENSES);
    }

    public void setExpenses(BigDecimal expenses) {
        set(PROPERTY_EXPENSES, expenses);
    }

    public BigDecimal getServcost() {
        return (BigDecimal) get(PROPERTY_SERVCOST);
    }

    public void setServcost(BigDecimal servcost) {
        set(PROPERTY_SERVCOST, servcost);
    }

    public BigDecimal getMaterialcostplan() {
        return (BigDecimal) get(PROPERTY_MATERIALCOSTPLAN);
    }

    public void setMaterialcostplan(BigDecimal materialcostplan) {
        set(PROPERTY_MATERIALCOSTPLAN, materialcostplan);
    }

    public BigDecimal getIndirectcostplan() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOSTPLAN);
    }

    public void setIndirectcostplan(BigDecimal indirectcostplan) {
        set(PROPERTY_INDIRECTCOSTPLAN, indirectcostplan);
    }

    public BigDecimal getMachinecostplan() {
        return (BigDecimal) get(PROPERTY_MACHINECOSTPLAN);
    }

    public void setMachinecostplan(BigDecimal machinecostplan) {
        set(PROPERTY_MACHINECOSTPLAN, machinecostplan);
    }

    public BigDecimal getServcostplan() {
        return (BigDecimal) get(PROPERTY_SERVCOSTPLAN);
    }

    public void setServcostplan(BigDecimal servcostplan) {
        set(PROPERTY_SERVCOSTPLAN, servcostplan);
    }

    public Boolean isGetmaterialfromstock() {
        return (Boolean) get(PROPERTY_GETMATERIALFROMSTOCK);
    }

    public void setGetmaterialfromstock(Boolean getmaterialfromstock) {
        set(PROPERTY_GETMATERIALFROMSTOCK, getmaterialfromstock);
    }

    public Boolean isGotopurchasing() {
        return (Boolean) get(PROPERTY_GOTOPURCHASING);
    }

    public void setGotopurchasing(Boolean gotopurchasing) {
        set(PROPERTY_GOTOPURCHASING, gotopurchasing);
    }

    public Boolean isReturnmaterialtostock() {
        return (Boolean) get(PROPERTY_RETURNMATERIALTOSTOCK);
    }

    public void setReturnmaterialtostock(Boolean returnmaterialtostock) {
        set(PROPERTY_RETURNMATERIALTOSTOCK, returnmaterialtostock);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public Boolean isAssembly() {
        return (Boolean) get(PROPERTY_ASSEMBLY);
    }

    public void setAssembly(Boolean assembly) {
        set(PROPERTY_ASSEMBLY, assembly);
    }

    public BigDecimal getQtyproduced() {
        return (BigDecimal) get(PROPERTY_QTYPRODUCED);
    }

    public void setQtyproduced(BigDecimal qtyproduced) {
        set(PROPERTY_QTYPRODUCED, qtyproduced);
    }

    public BigDecimal getQtyleft() {
        return (BigDecimal) get(PROPERTY_QTYLEFT);
    }

    public void setQtyleft(BigDecimal qtyleft) {
        set(PROPERTY_QTYLEFT, qtyleft);
    }

    public Locator getReceivingLocator() {
        return (Locator) get(PROPERTY_RECEIVINGLOCATOR);
    }

    public void setReceivingLocator(Locator receivingLocator) {
        set(PROPERTY_RECEIVINGLOCATOR, receivingLocator);
    }

    public Locator getIssuingLocator() {
        return (Locator) get(PROPERTY_ISSUINGLOCATOR);
    }

    public void setIssuingLocator(Locator issuingLocator) {
        set(PROPERTY_ISSUINGLOCATOR, issuingLocator);
    }

    public BigDecimal getPercentrejects() {
        return (BigDecimal) get(PROPERTY_PERCENTREJECTS);
    }

    public void setPercentrejects(BigDecimal percentrejects) {
        set(PROPERTY_PERCENTREJECTS, percentrejects);
    }

    public Date getStarted() {
        return (Date) get(PROPERTY_STARTED);
    }

    public void setStarted(Date started) {
        set(PROPERTY_STARTED, started);
    }

    public Date getEnded() {
        return (Date) get(PROPERTY_ENDED);
    }

    public void setEnded(Date ended) {
        set(PROPERTY_ENDED, ended);
    }

    public Boolean isStartonlywithcompletematerial() {
        return (Boolean) get(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL);
    }

    public void setStartonlywithcompletematerial(
        Boolean startonlywithcompletematerial) {
        set(PROPERTY_STARTONLYWITHCOMPLETEMATERIAL,
            startonlywithcompletematerial);
    }

    public Boolean isForcematerialscan() {
        return (Boolean) get(PROPERTY_FORCEMATERIALSCAN);
    }

    public void setForcematerialscan(Boolean forcematerialscan) {
        set(PROPERTY_FORCEMATERIALSCAN, forcematerialscan);
    }

    public org.openbravo.zsoft.serprod.zssm_productionplan_task getZssmProductionplanTask() {
        return (org.openbravo.zsoft.serprod.zssm_productionplan_task) get(PROPERTY_ZSSMPRODUCTIONPLANTASK);
    }

    public void setZssmProductionplanTask(
        org.openbravo.zsoft.serprod.zssm_productionplan_task zssmProductionplanTask) {
        set(PROPERTY_ZSSMPRODUCTIONPLANTASK, zssmProductionplanTask);
    }

    public BigDecimal getTimeperpiece() {
        return (BigDecimal) get(PROPERTY_TIMEPERPIECE);
    }

    public void setTimeperpiece(BigDecimal timeperpiece) {
        set(PROPERTY_TIMEPERPIECE, timeperpiece);
    }

    public BigDecimal getSetuptime() {
        return (BigDecimal) get(PROPERTY_SETUPTIME);
    }

    public void setSetuptime(BigDecimal setuptime) {
        set(PROPERTY_SETUPTIME, setuptime);
    }

    public Boolean isAutotriggered() {
        return (Boolean) get(PROPERTY_ISAUTOTRIGGERED);
    }

    public void setAutotriggered(Boolean isautotriggered) {
        set(PROPERTY_ISAUTOTRIGGERED, isautotriggered);
    }

    public BigDecimal getTimeplanned() {
        return (BigDecimal) get(PROPERTY_TIMEPLANNED);
    }

    public void setTimeplanned(BigDecimal timeplanned) {
        set(PROPERTY_TIMEPLANNED, timeplanned);
    }

    public BigDecimal getWeightproportion() {
        return (BigDecimal) get(PROPERTY_WEIGHTPROPORTION);
    }

    public void setWeightproportion(BigDecimal weightproportion) {
        set(PROPERTY_WEIGHTPROPORTION, weightproportion);
    }

    public String getTriggerreason() {
        return (String) get(PROPERTY_TRIGGERREASON);
    }

    public void setTriggerreason(String triggerreason) {
        set(PROPERTY_TRIGGERREASON, triggerreason);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_workstepdependencies_v> getZssmWorkstepdependenciesVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_workstepdependencies_v>) get(PROPERTY_ZSSMWORKSTEPDEPENDENCIESVLIST);
    }

    public void setZssmWorkstepdependenciesVList(
        List<org.openbravo.zsoft.serprod.zssm_workstepdependencies_v> zssmWorkstepdependenciesVList) {
        set(PROPERTY_ZSSMWORKSTEPDEPENDENCIESVLIST,
            zssmWorkstepdependenciesVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_workstepmachines_v> getZssmWorkstepmachinesVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_workstepmachines_v>) get(PROPERTY_ZSSMWORKSTEPMACHINESVLIST);
    }

    public void setZssmWorkstepmachinesVList(
        List<org.openbravo.zsoft.serprod.zssm_workstepmachines_v> zssmWorkstepmachinesVList) {
        set(PROPERTY_ZSSMWORKSTEPMACHINESVLIST, zssmWorkstepmachinesVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_workstepbom_v> getZssmWorkstepbomVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_workstepbom_v>) get(PROPERTY_ZSSMWORKSTEPBOMVLIST);
    }

    public void setZssmWorkstepbomVList(
        List<org.openbravo.zsoft.serprod.zssm_workstepbom_v> zssmWorkstepbomVList) {
        set(PROPERTY_ZSSMWORKSTEPBOMVLIST, zssmWorkstepbomVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_worksteptechdoc_v> getZssmWorkstepTechDocVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_worksteptechdoc_v>) get(PROPERTY_ZSSMWORKSTEPTECHDOCVLIST);
    }

    public void setZssmWorkstepTechDocVList(
        List<org.openbravo.zsoft.serprod.zssm_worksteptechdoc_v> zssmWorkstepTechDocVList) {
        set(PROPERTY_ZSSMWORKSTEPTECHDOCVLIST, zssmWorkstepTechDocVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_workstepactivities_v> getZssmWorkstepactivitiesVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_workstepactivities_v>) get(PROPERTY_ZSSMWORKSTEPACTIVITIESVLIST);
    }

    public void setZssmWorkstepactivitiesVList(
        List<org.openbravo.zsoft.serprod.zssm_workstepactivities_v> zssmWorkstepactivitiesVList) {
        set(PROPERTY_ZSSMWORKSTEPACTIVITIESVLIST, zssmWorkstepactivitiesVList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.projects.zspm_materialmovements_view> getZspmMaterialmovementsViewList() {
        return (List<org.openbravo.zsoft.projects.zspm_materialmovements_view>) get(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST);
    }

    public void setZspmMaterialmovementsViewList(
        List<org.openbravo.zsoft.projects.zspm_materialmovements_view> zspmMaterialmovementsViewList) {
        set(PROPERTY_ZSPMMATERIALMOVEMENTSVIEWLIST,
            zspmMaterialmovementsViewList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.zsoft.serprod.zssm_feedback_v> getZssmFeedbackVList() {
        return (List<org.openbravo.zsoft.serprod.zssm_feedback_v>) get(PROPERTY_ZSSMFEEDBACKVLIST);
    }

    public void setZssmFeedbackVList(
        List<org.openbravo.zsoft.serprod.zssm_feedback_v> zssmFeedbackVList) {
        set(PROPERTY_ZSSMFEEDBACKVLIST, zssmFeedbackVList);
    }
}
