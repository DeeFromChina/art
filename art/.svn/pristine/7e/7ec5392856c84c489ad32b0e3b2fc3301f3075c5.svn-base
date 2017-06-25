package com.golead.common.web;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.golead.core.exception.ServiceException;
import com.golead.core.exception.WebException;
import com.golead.core.web.action.BaseAction;

public class BlankAction extends BaseAction  {
   private final Log log = LogFactory.getLog(BlankAction.class);

   
   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();
      if(action==null){
    	  action="LIST";
      }
      if (log.isDebugEnabled()) log.debug("action:" + action);
      try {
         if ("LIST".equalsIgnoreCase(action)){
        	 forward = Initlist();
        } 
         
         else {
            request.put("err", new WebException("找不到该action方法：" + action));
            forward = "ERROR";// 找不到合适的action
         }

      } catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
   
   public String Initlist() throws Exception {
      if (log.isDebugEnabled()) log.debug("Entering 'Initlist' method");
      try {
    		  return LIST;
      } catch (ServiceException e) {
         request.put("errMsg", e.getMessage());
         return ERROR;
      } catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

}
