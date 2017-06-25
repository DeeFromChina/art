package com.golead.common.web.system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerBean;

import com.golead.common.model.SysProperty;
import com.golead.common.model.SysResource;
import com.golead.common.service.system.SysPropertyService;
import com.golead.common.service.system.SysResourceService;
import com.golead.common.service.system.SysUserService;
import com.golead.core.exception.ServiceException;
import com.golead.core.exception.WebException;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.action.BaseAction;

public class SysPropertyAction extends BaseAction {
   private final Log log = LogFactory.getLog(SysPropertyAction.class);

   @Override
   public String doExecute() throws Exception {
      String forward = "";
      String action = form.getAction();

      if (action == null) action = LIST;
      if (log.isDebugEnabled()) log.debug("action:" + action);
      try {
         if (LIST.equalsIgnoreCase(action)) forward = listProperty(); // 打开列表页面
         else if ("SAVE".equalsIgnoreCase(action)) // 保存
         forward = saveProperty();
         else {
            request.put("err", new WebException("找不到该action方法：" + action));
            forward = "ERROR";// 找不到合适的action
         }

      }
      catch (Exception e) {// 其他系统出错
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         forward = ERROR;
      }
      return forward;
   }

   private String listProperty() {
      if (log.isDebugEnabled()) log.debug("Entering 'listProperty' method");

      try {
         form.getRecord().putAll(currentUser.getProperties());
         return "LIST";
      }
      catch (Exception e) {
         e.printStackTrace();
         request.put("errMsg", e.getMessage());
         return ERROR;
      }
   }

   private String saveProperty() {
      if (log.isDebugEnabled()) log.debug("Entering 'saveProperty' method");
      try {
         List<SysProperty> cProperties = new ArrayList<SysProperty>();
         String userId = currentUser.getUserId();
         Set<String> set = form.getRecord().keySet();
         Iterator<String> iter = set.iterator();
         while (iter.hasNext()) {
            String cKey = iter.next();
            List<SysProperty> propertys = sysPropertyService.findSysProperty(new Integer(userId), cKey);
            if (propertys.size() == 0) {
               SysProperty pro = new SysProperty();
               pro.setUserId(new Integer(userId));
               pro.setPropertyKey(cKey);
               pro.setPropertyValue(form.getRecord().get(cKey));
               sysPropertyService.createSysProperty(pro);
               cProperties.add(pro);
            }
            else {
               SysProperty pro = propertys.get(0);
               pro.setPropertyKey(cKey);
               pro.setPropertyValue(form.getRecord().get(cKey));
               HashMap<String, String> map = new HashMap<String, String>();
               ConvertUtil.objectToMap(map, pro);
               sysPropertyService.updateSysProperty(map);
               cProperties.add(pro);
            }
         }

         //更新任务时间
         refreshScheduler(cProperties);

         return returnForward(RETURN_NORMAL);
      }
      catch (ServiceException e) {
         addMessage(form, e.getMessage());
         return ADD;
      }
      catch (Exception ex) {
         ex.printStackTrace();
         addMessage(form, "保存操作失败!");
         return ADD;
      }
   }

   private void refreshScheduler(List<SysProperty> propertys) throws SchedulerException, ParseException {

      String[] tNames = scheduler.getTriggerNames(Scheduler.DEFAULT_GROUP);
      for (int n = 0; n < tNames.length; n++) {
         for (int i = 0; i < propertys.size(); i++) {
            SysProperty sysProperty = propertys.get(i);
            if (sysProperty.getPropertyKey().equals(tNames[n])) {
               Trigger triggerObj = scheduler.getTrigger(tNames[n], Scheduler.DEFAULT_GROUP);
               if (triggerObj != null) {
                  CronTriggerBean trigger = (CronTriggerBean) triggerObj;
                  trigger.setCronExpression(sysProperty.getPropertyValue());
                  scheduler.rescheduleJob(tNames[n], Scheduler.DEFAULT_GROUP, trigger);
               }
            }
         }
      }

   }

   @Resource
   private SysResourceService sysResourceService;

   @Resource
   private SysUserService     sysUserService;

   @Resource
   private SysPropertyService sysPropertyService;

   private List<SysResource>  sysReources;

   private String             id;

   private List<SysResource>  rights;

   private String             key;

   private String             value;

   private Scheduler          scheduler;

   public List<SysResource> getSysReources() {
      return sysReources;
   }

   public void setSysReources(List<SysResource> sysReources) {
      this.sysReources = sysReources;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public List<SysResource> getRights() {
      return rights;
   }

   public void setRights(List<SysResource> rights) {
      this.rights = rights;
   }

   public String getKey() {
      return key;
   }

   public void setKey(String key) {
      this.key = key;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public Scheduler getScheduler() {
      return scheduler;
   }

   public void setScheduler(Scheduler scheduler) {
      this.scheduler = scheduler;
   }
}
