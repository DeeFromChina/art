package com.golead.art.activity.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.golead.art.activity.dao.ArtActivityAbmbDao;
import com.golead.art.activity.model.ArtActivityAbmb;
import com.golead.art.activity.service.ArtActivityAbmbService;
import com.golead.art.works.dao.ArtWorksAbmbDao;
import com.golead.art.works.model.ArtWorksAbmb;
import com.golead.core.common.Code;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.DAOException;
import com.golead.core.exception.ServiceException;
import com.golead.core.service.impl.BaseServiceImpl;
import com.golead.core.util.ConvertUtil;
import com.golead.core.web.form.BaseForm;

@Service
public class ArtActivityAbmbServiceImpl extends BaseServiceImpl implements ArtActivityAbmbService {
   private static final long serialVersionUID = 1L;

   public ArtActivityAbmb getArtActivityAbmb(Serializable id) throws ServiceException {
      try {
         return artActivityAbmbDao.get(id);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void createArtActivityAbmb(ArtActivityAbmb artActivityAbmb) throws ServiceException {
      try {
         artActivityAbmbDao.save(artActivityAbmb);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void updateArtActivityAbmb(Map<String, String> artActivityAbmbMap) throws ServiceException {
      try {
         Integer pkId = new Integer(artActivityAbmbMap.get(ArtActivityAbmb.PROP_ID));
         ArtActivityAbmb tmp = artActivityAbmbDao.get(pkId);
         ConvertUtil.mapToObject(tmp, artActivityAbmbMap, true);
         artActivityAbmbDao.update(tmp);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void deleteArtActivityAbmb(Serializable id) throws ServiceException {
      try {
         artActivityAbmbDao.delete(id);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public void deleteArtActivityAbmbs(Serializable[] ids) throws ServiceException {
      try {
         for (int i = 0; i < ids.length; i++) {
            artWorksAbmbDao.deleteByField(ArtWorksAbmb.PROP_ABMB_ID, ids[i]);
         }
         artActivityAbmbDao.deleteAll(ids);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   public PageQuery queryArtActivityAbmb(PageQuery pageQuery) throws ServiceException {
      try {
         createSqlFilter(pageQuery);
         return jdbcDao.queryBySqlId("artActivityAbmbList", pageQuery);
      }
      catch (DAOException e) {
         e.printStackTrace();
         throw new ServiceException("数据库操作错误。");
      }
      catch (ServiceException se) {
         se.printStackTrace();
         throw se;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private void createSqlFilter(PageQuery page) {
      String tmp = "";
      Map<String, String> map = page.getParameters();
      String str = map.get("abmbName");
      if (str != null && !"".equals(str.trim())) {
         tmp = "a.abmb_name like '%" + str.trim() + "%'";
      }
      str = map.get("sponsor");
      if (str != null && !"".equals(str.trim())) {
         tmp = "a.sponsor like '%" + str.trim() + "%'";
      }
      str = map.get("abmbYear");
      if (str != null && !"".equals(str.trim())) {
         tmp = "a.abmb_year like '%" + str.trim() + "%'";
      }
      str = map.get("artistName");
      if (str != null && !"".equals(str.trim())) {
         tmp = "y.c_name LIKE '%" + str.trim() + "%'";
      }

      if (tmp.length() > 0) map.put("paras", tmp);
   }

   public int findByCountry(String ids) throws ServiceException {
      try {
         String str = "SELECT COUNT(*) FROM art_activity_abmb abmb WHERE abmb.country_id IN (" + ids + ")";
         return jdbcDao.queryIntBySql(str);
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   @SuppressWarnings("deprecation")
   public HSSFWorkbook export(BaseForm form, PageQuery pageQuery) throws ServiceException {
      try {
         HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
         HSSFSheet sheet = hssfWorkbook.createSheet("sheet1");
         HSSFRow row = sheet.createRow((int) 0);

         HSSFCell cell = row.createCell((short) 0);
         cell.setCellValue("名称");
         cell = row.createCell((short) 1);
         cell.setCellValue("届数");
         cell = row.createCell((short) 2);
         cell.setCellValue("主办方");
         cell = row.createCell((short) 3);
         cell.setCellValue("艺术总监");
         cell = row.createCell((short) 4);
         cell.setCellValue("国家");
         cell = row.createCell((short) 5);
         cell.setCellValue("城市");
         cell = row.createCell((short) 6);
         cell.setCellValue("开幕时间");
         pageQuery.setPageSize("-1");
         PageQuery pageQuery2 = queryArtActivityAbmb(pageQuery);
         int i = 0;
         for (Map<String, Object> item : pageQuery2.getRecordSet()) {
            String time = "";
            time = addString(time, returnString(item.get("abmbYear")), "年");
            time = addString(time, returnString(item.get("abmbMonth")), "月");
            row = sheet.createRow(i + 1);
            row.createCell((short) 0).setCellValue(returnString(item.get("abmbName")));
            row.createCell((short) 1).setCellValue(returnString(item.get("abmbNumber")));
            row.createCell((short) 2).setCellValue(returnString(item.get("sponsor")));
            row.createCell((short) 3).setCellValue(returnString(item.get("artDirector")));
            row.createCell((short) 4).setCellValue(returnString(item.get("country")));
            row.createCell((short) 5).setCellValue(returnString(item.get("city")));
            row.createCell((short) 6).setCellValue(time);
            i++;
         }
         return hssfWorkbook;
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new ServiceException("系统错误。");
      }
   }

   private String returnString(Object object) {
      String str = object == null ? "" : object.toString();
      return str;
   }

   private String addString(String str, String equalStr, String addStr) {
      if (!"".equals(equalStr)) {
         if (equalStr.indexOf(addStr) > -1) return str + equalStr;
         else return str + equalStr + addStr;
      }
      return str;
   }

   @Resource
   private ArtActivityAbmbDao artActivityAbmbDao;

   @Resource
   private ArtWorksAbmbDao    artWorksAbmbDao;
}
