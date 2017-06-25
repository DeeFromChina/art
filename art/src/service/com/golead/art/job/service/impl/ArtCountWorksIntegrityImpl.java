package com.golead.art.job.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import com.golead.art.job.service.CheckArtAuction;
import com.golead.art.works.service.ArtWorksService;
import com.golead.core.service.impl.BaseServiceImpl;

/**
 * 统计作品完整度,作品基本信息占50分，子表数据每条10分
 * 
 * @author 尹湘
 * @version 1.0
 * @since 2016年12月8日 下午5:41:41
 */
public class ArtCountWorksIntegrityImpl extends BaseServiceImpl implements CheckArtAuction {

   @Resource
   private ArtWorksService artWorksService;

   private DecimalFormat   df = new DecimalFormat("0.00");

   @Override
   public void executeCheck() throws Exception {
      List<Map<String, Object>> list = artWorksService.findAllWorks();
      Map<String, Object> numMap = new HashMap<String, Object>();
      List<Map<String, Object>> detailList = detailFromWorks();
      for(Map<String, Object> detailMap : detailList){
         numMap.put(detailMap.get("worksId").toString(), isDouble(detailMap.get("num")));
      }
      List<String> sqllList = new ArrayList<String>();
      for (Map<String, Object> map : list) {
         int count = map.size();
         int i = 0;
         boolean isPass = true;
         for (Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null && entry.getValue().toString().trim().length() > 0) {
               i++;
            }
            if ("integrity".equals(entry.getKey())) {
               if (entry.getValue() != null && entry.getValue().toString().trim().length() > 0) {
                  i = i - 1;
               }
            }
         }
         i = i - 1;
         double sum = (double) i / (double) count * 50;
         if(numMap.get(map.get("id").toString()) != null){
            sum += (isDouble(numMap.get(map.get("id").toString())) * 10);
         }
         if (map.get("integrity") != null && !"".equals(map.get("integrity").toString())) {
            if (Double.valueOf(df.format(sum)) == Double.valueOf(map.get("integrity").toString())) {
               isPass = false;
            }
         }
         if (isPass) {
            String sql = "UPDATE art_works works SET works.integrity = " + df.format(sum) + " WHERE works.id = " + map.get("id");
            sqllList.add(sql);
         }
      }
      if (sqllList.size() > 0) {
         String[] sqls = new String[sqllList.size()];
         int i = 0;
         for (String sql : sqllList) {
            sqls[i] = sql;
            i++;
         }
         artWorksService.batchUpdateWorks(sqls);
      }
   }

   private List<Map<String, Object>> detailFromWorks() {
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT a.worksId,COUNT(a.num) AS num FROM (SELECT period.works_id AS worksId,COUNT(period.works_id) AS num FROM art_works_period period  GROUP BY period.works_id ");
      sql.append("      UNION ALL ");
      sql.append("     SELECT evaluate.works_id AS worksId,COUNT(evaluate.works_id) AS num FROM art_works_evaluate evaluate GROUP BY evaluate.works_id ");
      sql.append("     UNION ALL ");
      sql.append("     SELECT case1.works_id AS worksId,COUNT(case1.works_id) AS num FROM art_works_case case1 GROUP BY case1.works_id ");
      sql.append("     UNION ALL ");
      sql.append("     SELECT some1.works_id AS worksId,COUNT(some1.works_id) AS num FROM art_works_some some1 GROUP BY some1.works_id ");
      sql.append("     UNION ALL ");
      sql.append("      SELECT exhibit.works_id AS worksId,COUNT(exhibit.works_id) AS num FROM art_works_exhibit exhibit GROUP BY exhibit.works_id ");
      sql.append("     UNION ALL ");
      sql.append("      SELECT abmb.works_id AS worksId,COUNT(abmb.works_id) AS num FROM art_works_abmb abmb GROUP BY abmb.works_id ");
      sql.append("      UNION ALL ");
      sql.append("     SELECT words.works_id AS worksId,COUNT(words.works_id) AS num FROM art_works_words words GROUP BY words.works_id ");
      sql.append("      UNION ALL ");
      sql.append("      SELECT network.works_id AS worksId,COUNT(network.works_id) AS num FROM art_works_network network GROUP BY network.works_id ");
      sql.append("     UNION ALL ");
      sql.append("     SELECT medium1.works_id AS worksId,COUNT(medium1.works_id) AS num FROM art_works_medium medium1 GROUP BY medium1.works_id ");
      sql.append("     UNION ALL ");
      sql.append("     SELECT auction.works_id AS worksId,COUNT(auction.works_id) AS num FROM art_auction auction GROUP BY auction.works_id ");
      sql.append("     UNION ALL ");
      sql.append("     SELECT agency.works_id AS worksId,COUNT(agency.works_id) AS num FROM art_works_agency agency GROUP BY agency.works_id) a ");
      sql.append("      GROUP BY a.worksId  ");
      List<Map<String, Object>> list = jdbcDao.queryBySql(sql.toString());
      return list;
   }
   
   private double isDouble(Object obj){
      if(obj == null){
         return 0D;
      }
      return Double.valueOf(obj.toString());
   }
}
