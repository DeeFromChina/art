package com.golead.art.literature.analyzer;

import java.util.List;
import java.util.Map;

public class FullIndexPagination {

   private List<Map<String, Object>> searchlist;

   private int                       pageNo;

   private int                       pageSize;

   private int                       totalNum;

   public List<Map<String, Object>> getSearchlist() {
      return searchlist;
   }

   public void setSearchlist(List<Map<String, Object>> searchlist) {
      this.searchlist = searchlist;
   }

   public int getPageNo() {
      return pageNo;
   }

   public void setPageNo(int pageNo) {
      this.pageNo = pageNo;
   }

   public int getPageSize() {
      return pageSize;
   }

   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }

   public int getTotalNum() {
      return totalNum;
   }

   public void setTotalNum(int totalNum) {
      this.totalNum = totalNum;
   }

   public int getTotalPage() {
      if (totalNum % pageSize == 0) {
         return totalNum / pageSize;
      }
      else {
         return totalNum / pageSize + 1;
      }
   }

}
