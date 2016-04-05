package org.zsoft.ecommerce;

import org.openbravo.database.ConnectionProvider;
import org.openbravo.scheduling.Process;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.quartz.JobExecutionException;
import org.zsoft.ecommerce.order.client.OrderClientAPIRequest;
import org.zsoft.ecommerce.order.client.OrderData;
import org.zsoft.ecommerce.order.client.sangro.response.PollingSangro;

public class FilePollingService implements Process {

  private static int counter = 0;

  private ConnectionProvider connection;
  private ProcessLogger logger;
  
  
  
  public void execute(ProcessBundle bundle) throws Exception {
    logger = bundle.getLogger();
    connection = bundle.getConnection();

    logger.log("Starting File Polling Backgrouond Process. \n");
    try {
      FilePollingServiceData[] shopdata=FilePollingServiceData.select(connection);
      for (int i = 0; i < shopdata.length; i++) {
        String apikey=shopdata[i].apikey;
        String secret=shopdata[i].secret;
        String  shop=shopdata[i].zseShopId;
        // Polling Sangro API 
        if (shopdata[i].api.equals("SANGRO")) {
          Object obj=Class.forName("org.zsoft.ecommerce.order.client.sangro.response.PollingSangro").newInstance();
          FilePollingAPI req=(FilePollingAPI) obj;
          req.fetchAndProcess(connection,apikey, secret, shop);
        }
        // Pushing  Sangro API  
        if (shopdata[i].api.equals("SANGRO") && shopdata[i].isoderactive.equals("Y") && shopdata[i].cBpartnerId != null) {
          OrderStatusData[] data= OrderStatusData.select(connection, shopdata[i].cBpartnerId);
          Object obj=Class.forName("org.zsoft.ecommerce.order.client.sangro.request.OrderSangro").newInstance();
          OrderClientAPIRequest order =  (OrderClientAPIRequest) obj;
          for (int ii=0;ii<data.length;ii++){
            try {
              order.processOrder(data[ii].cOrderId, connection);
            } catch (Exception e) {
              OrderStatusData.insertOrderStatusNew(connection, shopdata[i].adOrgId, shop,"n/a", null, data[ii].cOrderId, "ERROR SENDING ORDER FILE",e.getMessage(), "N");
              OrderData.InsertPoReference(connection, null, data[ii].cOrderId);
            }
          }
        }
        // Polling Attends API 
        if (shopdata[i].api.equals("ATTENDS")) {
          Object obj=Class.forName("org.zsoft.ecommerce.order.client.attends.response.PollingAttends").newInstance();
          FilePollingAPI req=(FilePollingAPI) obj;
          req.fetchAndProcess(connection,apikey, secret, shop);
        }
        // Pushing Attends API 
        if (shopdata[i].api.equals("ATTENDS") && shopdata[i].isoderactive.equals("Y") && shopdata[i].cBpartnerId != null) {
          OrderStatusData[] data= OrderStatusData.select(connection, shopdata[i].cBpartnerId);
          Object obj=Class.forName("org.zsoft.ecommerce.order.client.attends.request.OrderAttends").newInstance();
          OrderClientAPIRequest order =  (OrderClientAPIRequest) obj;
          for (int ii=0;ii<data.length;ii++){
            try {
              order.processOrder(data[ii].cOrderId, connection);
            } catch (Exception e) {
              OrderStatusData.insertOrderStatusNew(connection, shopdata[i].adOrgId, shop,"n/a", null, data[ii].cOrderId, "ERROR SENDING ORDER FILE",e.getMessage(), "N");
              OrderData.InsertPoReference(connection, null, data[ii].cOrderId);
            }
          }
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      logger.log("File Polling Backgrouond Process reported an error.");
      logger.log(e.getMessage());
      throw new JobExecutionException(e.getMessage(), e);
    
    }
  }


}
