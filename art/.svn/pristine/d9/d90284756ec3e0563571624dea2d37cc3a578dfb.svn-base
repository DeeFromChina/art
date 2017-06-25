package com.golead.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.golead.common.dao.SysCodeDao;
import com.golead.common.dao.SysCodesetDao;
import com.golead.common.dao.SysResourceDao;
import com.golead.common.model.SysCode;
import com.golead.common.model.SysCodeset;
import com.golead.common.model.SysResource;
import com.golead.core.common.Code;
import com.golead.core.exception.ServiceException;
import com.golead.core.web.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

   private Map<String, List<Code>> codes;

   private Map<String, String>     sysReources;

   @Resource
   private SysCodeDao              sysCodeDao;

   @Resource
   private SysCodesetDao           SysCodesetDao;

   @Resource
   private SysResourceDao          sysResourceDao;

   private List<SysResource>       sysResourceList;

   public SysCodeDao getSysCodeDao() {
      return sysCodeDao;
   }

   public void setSysCodeDao(SysCodeDao sysCodeDao) {
      this.sysCodeDao = sysCodeDao;
   }

   public SysCodesetDao getSysCodesetDao() {
      return SysCodesetDao;
   }

   public void setSysCodesetDao(SysCodesetDao SysCodesetDao) {
      this.SysCodesetDao = SysCodesetDao;
   }

   @Override
   public Map<String, List<Code>> loadCodes() throws ServiceException {
      if (codes == null) {
         codes = new HashMap<String, List<Code>>();
         Iterator<SysCodeset> it = SysCodesetDao.findAll().iterator();
         try {
            Iterator<SysCode> itc = sysCodeDao.findAll(SysCode.PROP_ITEM_VALUE, true).iterator();
            while (itc.hasNext()) {
               SysCode sysCode = itc.next();
               if (sysCode.getCsId() == null) continue;
               String csid = sysCode.getCsId().toString();
               List<Code> ls = codes.get(csid);
               if (ls == null) {
                  ls = new ArrayList<Code>();
                  ls.add(new Code("", ""));
                  codes.put(csid, ls);
               }
               ls.add(new Code(sysCode.getItemName(), sysCode.getItemValue(), sysCode.getParentItemId(), sysCode.getParentValue()));
            }
            while (it.hasNext()) {
               SysCodeset set = it.next();
               List<Code> list = codes.get(set.getId().toString());
               if (list != null) {
                  codes.remove(set.getId().toString());
                  codes.put(set.getEnName(), list);
               }
            }
         } catch (Exception e) {
            throw new ServiceException(e);
         }
      }
      return codes;
   }

   @Override
   public void remove(String codeSetName) {
      if (codes != null) codes.remove(codeSetName);
   }

   @Override
   public List<Code> load(String codeSetName) {
      if (codes == null) loadCodes();
      List<Code> list = codes.get(codeSetName);

      if (list == null) {
         list = new ArrayList<Code>();
         list.add(new Code("", ""));
         List<SysCodeset> scs = SysCodesetDao.findByField(SysCodeset.PROP_EN_NAME, codeSetName);
         if (scs == null || scs.size() == 0) {
            codes.put(codeSetName, list);
            return list;
         }
         else {
            int scId = scs.get(0).getId();
            List<SysCode> ls = sysCodeDao.findByField(SysCode.PROP_CS_ID, scId, SysCode.PROP_ITEM_VALUE, true);
            if (ls != null) {
               for (SysCode sc : ls) {
                  list.add(new Code(sc.getItemName(), sc.getItemValue(), sc.getParentItemId(), sc.getParentValue()));
               }
            }
            codes.put(codeSetName, list);
         }
      }
      return list;
   }

   public SysResourceDao getSysResourceDao() {
      return sysResourceDao;
   }

   public void setSysResourceDao(SysResourceDao sysResourceDao) {
      this.sysResourceDao = sysResourceDao;
   }

   private void findReources() {
      sysResourceList = sysResourceDao.findAll();
      if (sysReources == null) sysReources = new HashMap<String, String>();
      for (SysResource sr : sysResourceList) {
         if (sr.getActionUrl() != null && sr.getActionUrl().trim().length() > 0) {
            sysReources.put(sr.getResCode().trim(), sr.getActionUrl().trim());
         }
      }
   }

   @Override
   public String findResourceCode(String url) {
      if (sysReources == null) findReources();
      String res = "";

      Iterator<String> it = sysReources.keySet().iterator();
      while (it.hasNext()) {
         String key = it.next();
         if (sysReources.get(key).equalsIgnoreCase(url.trim())) {
            res = key;
            break;
         }
      }
      return res;
   }

   @Override
   public String findResourceCode(String actionClass, String methord) {
      if (sysReources == null) findReources();
      String res = "";

      for (int i = 0; i < sysResourceList.size(); i++) {
         SysResource sysResource = sysResourceList.get(i);
         if (sysResource.getResName().equals(actionClass) && sysResource.getResType().equals(methord)) {
            res = sysResource.getResCode();
            break;
         }
      }
      return res;
   }

}
