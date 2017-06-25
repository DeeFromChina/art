package com.golead.art.literature.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import com.golead.art.literature.analyzer.DocAnalyzer;
import com.golead.art.literature.analyzer.ParserPdf;
import com.golead.art.literature.service.FullIndexQueryService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

@Service
public class FullIndexQueryServiceImpl implements FullIndexQueryService {

   private final String     DEFAULT_KEYWORD = "text";

   private SimpleDateFormat sdf             = new SimpleDateFormat("yyyy-MM-dd");

   private String           indexPath       = System.getProperty("artApplication.root") + "fullindex";

   public PageQuery query(PageQuery pq) throws ServiceException {
      try {
         List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
         IndexSearcher indexSearcher = prepareIndexSearcher();
         Query query = getLuceneQuery("QueryParser", pq.getParameters());
         pq.setRecordCount("0");
         pq.setPageCount("1");
         int pgNum = Integer.valueOf(pq.getPageNumber());
         int pgSize = Integer.valueOf(pq.getPageSize());

         int maxHits = indexSearcher.maxDoc();
         int startIndex = (pgNum - 1) * pgSize;
         int step = pgSize;

         if (query != null && maxHits > 0) {
            TopScoreDocCollector collector = TopScoreDocCollector.create(maxHits, false);
            indexSearcher.search(query, collector);
            ScoreDoc[] hits = collector.topDocs(startIndex, step).scoreDocs;

            for (int i = 0; i < hits.length; i++) {
               Document doc = indexSearcher.doc(hits[i].doc);

               Map<String, Object> map = new HashMap<String, Object>();
               map.put("seq", startIndex + i + 1);
               map.put("docId", hits[i].doc);
               for (Fieldable f : doc.getFields()) {
                  String key = f.name();
                  String value = f.stringValue();
                  map.put(key, value);
               }
               result.add(map);
            }

            // 设置最大记录数和最大页数
            pq.setRecordCount(String.valueOf(collector.getTotalHits()));
            if (collector.getTotalHits() % pgSize == 0) pq.setPageCount(String.valueOf(collector.getTotalHits() / pgSize));
            else pq.setPageCount(String.valueOf(collector.getTotalHits() / pgSize + 1));
         }

         pq.setRecordSet(result);
         return pq;

      }
      catch (ServiceException e) {
         e.printStackTrace();
         throw e;

      }
      catch (IOException e) {
         e.printStackTrace();
         throw new ServiceException("索引搜索失败");

      }
   }

   private IndexSearcher prepareIndexSearcher() throws ServiceException {
      try {
         File indxFile = new File(indexPath);
         if (!indxFile.exists()) throw new ServiceException("索引目录不存在");

         Directory dir;
         dir = FSDirectory.open(indxFile);
         return new IndexSearcher(dir, true);

      }
      catch (IOException e) {
         e.printStackTrace();
         throw new ServiceException("索引文件读取失败");
      }
   }

   private Query getLuceneQuery(String type, Map<String, String> queryStrs) throws ServiceException {
      Query query = null;
      if ("QueryParser".equalsIgnoreCase(type)) query = getQueryParser(queryStrs);
      return query;
   }

   private Query getQueryParser(Map<String, String> queryStrs) throws ServiceException {
      try {
         String key = formatKeyWords(queryStrs);
         if (key != null && key.trim().length() > 0) {
            Set<char[]> stopWords = new HashSet<char[]>();
            DocAnalyzer analyzer = new DocAnalyzer(Version.LUCENE_31, stopWords, null);
            QueryParser qp = new QueryParser(Version.LUCENE_31, DEFAULT_KEYWORD, analyzer);
            qp.setDefaultOperator(QueryParser.AND_OPERATOR);
            return qp.parse(key);

         }
         else {
            return null;
         }

      }
      catch (ParseException e) {
         e.printStackTrace();
         throw new ServiceException("查询条件格式错误");
      }
   }

   private String formatKeyWords(Map<String, String> queryStrs) {
      String keyWord = "";

      String filter = DEFAULT_KEYWORD + ",startDate,endDate";
      Iterator<String> it = queryStrs.keySet().iterator();
      while (it.hasNext()) {
         String key = it.next();
         String value = queryStrs.get(key);
         if (value != null && value.trim().length() > 0) if (("," + filter + ",").indexOf("," + key + ",") == -1) keyWord += " " + key + ":" + value.trim();
      }

      String startDate = queryStrs.get("startDate").trim();
      String endDate = queryStrs.get("endDate").trim();
      if (startDate.length() > 0 && endDate.length() > 0) {
         try {
            keyWord += " createDate:" + "[" + transformDate(startDate) + " TO " + transformDate(endDate) + "]";

         }
         catch (java.text.ParseException e) {
            throw new ServiceException("日期格式错误，正确格式为\"2013-01-01\"");
         }
      }

      String defaultKey = queryStrs.get(DEFAULT_KEYWORD);
      if (defaultKey != null && defaultKey.trim().length() > 0) {
         keyWord = "(" + defaultKey.trim() + keyWord + ") OR (fileName:" + defaultKey.trim() + keyWord + ")";
      }

      return keyWord;
   }

   private String transformDate(String dateStr) throws java.text.ParseException {
      SimpleDateFormat inputForm = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat resultForm = new SimpleDateFormat("yyyyMMdd");
      return resultForm.format(inputForm.parse(dateStr));
   }

   public Map<String, String> readDocContent(Integer docId) throws ServiceException {
      Directory dir = null;
      try {
         File indxFile = new File(indexPath);
         Map<String, String> result = new HashMap<String, String>();
         if (indxFile.exists()) {
            dir = FSDirectory.open(indxFile);
            IndexSearcher idSearcher = new IndexSearcher(dir, true);
            Document doc = idSearcher.doc(docId);
            for (Fieldable f : doc.getFields()) {
               result.put(f.name(), f.stringValue());
            }
            String context = ParserPdf.parserPDF(result.get("fileFullName")).toString();
            context = context.replaceAll("\n", "<br/>");
            context = context.replaceAll("\t", "<br/>");
            context = context.replaceAll(" ", "&nbsp;");
            context += "<p align=\"center\">【余下全文请点击“下载”查阅】</p>";
            int len = context.length() > 3000 ? 3000 : context.length();
            result.put("content", context.substring(0, len));
            return result;

         }
         else {
            throw new ServiceException("索引目录不存在");
         }

      }
      catch (IOException e) {
         e.printStackTrace();
         throw new ServiceException("索引文件读取失败");
      }
      finally {
         try {
            if (dir != null) dir.close();
         }
         catch (IOException e) {
            e.printStackTrace();
         }

      }
   }

}
