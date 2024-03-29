package com.golead.art.literature.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeFilter;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.golead.art.literature.analyzer.DocAnalyzer;
import com.golead.art.literature.analyzer.FullIndexPagination;
import com.golead.art.literature.analyzer.ParserPdf;
import com.golead.art.literature.service.SearchEngineService;
import com.golead.core.dao.model.PageQuery;
import com.golead.core.exception.ServiceException;

@Service
public class SearchEngineServiceImpl implements SearchEngineService {

   private static final long serialVersionUID = 1L;

   private String            indexFolder      = System.getProperty("artApplication.root") + "fullindex"; ;

   private String            prefixHTML       = "<font class=\"highlight\">";

   private String            suffixHTML       = "</font>";

   private Analyzer          dAnalyzer;

   private final String      DEFAULT_KEYWORD  = "text";

   private final int         fragmenterLength = 200;

   private Query             hightLightQuery;

   public Query getHightLightQuery() {
      return hightLightQuery;
   }

   public void setHightLightQuery(Query hightLightQuery) {
      this.hightLightQuery = hightLightQuery;
   }

   public FullIndexPagination searchTalent(Map<String, String> queryStrs, int pageNo, int pageSize) {
      String str = queryStrs.get("text");
      String startDate = queryStrs.get("startDate");
      String endDate = queryStrs.get("endDate");
      String title = queryStrs.get("title");
      String wordsType = queryStrs.get("wordsType");
      String author = queryStrs.get("author");
      List<Map<String, Object>> searchlist = new ArrayList<Map<String, Object>>();
      FullIndexPagination p = null;
      IndexSearcher searcher = null;
      Directory directory = null;
      try {
         directory = FSDirectory.open(new File(indexFolder));
         searcher = new IndexSearcher(directory);
         Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_31);
         dAnalyzer = new IKAnalyzer();
         QueryParser parser = new QueryParser(Version.LUCENE_31, "content", analyzer);
         Query query = parser.parse(str);
         this.setHightLightQuery(query);

         BooleanQuery booleanQuery = new BooleanQuery();
         if (!str.trim().equals("")) booleanQuery.add(query, BooleanClause.Occur.MUST);
         if (wordsType != null && !"".equals(wordsType)) {
            TermQuery termQuery = new TermQuery(new Term("wordsType", wordsType));
            booleanQuery.add(termQuery, BooleanClause.Occur.MUST);
         }
         if (title != null && !"".equals(title)) {
            TermQuery termQuery = new TermQuery(new Term("title", title));
            booleanQuery.add(termQuery, BooleanClause.Occur.MUST);
         }
         if (author != null && !"".equals(author)) {
            TermQuery termQuery = new TermQuery(new Term("author", author));
            booleanQuery.add(termQuery, BooleanClause.Occur.MUST);
         }

         SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(prefixHTML, suffixHTML);
         Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));
         highlighter.setTextFragmenter(new SimpleFragmenter(fragmenterLength));

         TopDocs results = null;
         if (startDate != null && !startDate.equals("")) {
            TermRangeFilter trf = new TermRangeFilter("time", startDate, endDate, true, true);
            results = searcher.search(booleanQuery, trf, 999999999, new Sort(new SortField("time", SortField.STRING, true)));
         }
         else {
            results = searcher.search(booleanQuery, 999999999, new Sort(new SortField("time", SortField.STRING, true)));
         }
         ScoreDoc[] hits = results.scoreDocs;
         Document doc = null;
         if ((((pageNo - 1) * pageSize) + pageSize) <= hits.length) {
            for (int i = ((pageNo - 1) * pageSize); i < ((pageNo - 1) * pageSize) + pageSize; i++) {
               doc = searcher.doc(hits[i].doc);
               if (null != doc) {
                  Map<String, Object> map = getDocumentMap(doc, str, highlighter);
                  if (map != null) {
                     map.put("docId", hits[i].doc);
                     searchlist.add(map);
                  }
               }
            }
         }
         else {
            for (int i = (pageNo - 1) * pageSize; i < ((pageNo - 1) * pageSize) + (hits.length % pageSize); i++) {
               doc = searcher.doc(hits[i].doc);
               if (null != doc) {
                  Map<String, Object> map = getDocumentMap(doc, str, highlighter);
                  if (map != null) {
                     map.put("docId", hits[i].doc);
                     searchlist.add(map);
                  }
               }
            }
         }

         int totalnum = hits.length;
         p = new FullIndexPagination();
         p.setSearchlist(searchlist);
         p.setPageNo(pageNo);
         p.setPageSize(pageSize);
         p.setTotalNum(totalnum);
      }
      catch (Exception e) {
         e.printStackTrace();
         p = new FullIndexPagination();
         p.setSearchlist(null);
         p.setPageNo(1);
         p.setPageSize(pageSize);
         p.setTotalNum(0);
      }
      finally {
         try {
            if (directory != null) directory.close();
         }
         catch (IOException e) {
            e.printStackTrace();
            p = new FullIndexPagination();
            p.setSearchlist(null);
            p.setPageNo(1);
            p.setPageSize(pageSize);
            p.setTotalNum(0);
         }
      }
      return p;
   }

   public FullIndexPagination searchTalent(PageQuery pq, int pageNo, int pageSize) {
      List<Map<String, Object>> searchlist = new ArrayList<Map<String, Object>>();
      FullIndexPagination p = null;
      try {
         IndexSearcher indexSearcher = new IndexSearcher(FSDirectory.open(new File(indexFolder)));
         Query query = getQueryParser(pq.getParameters());

         int maxHits = indexSearcher.maxDoc();
         int startIndex = (pageNo - 1) * pageSize;
         int step = pageSize;

         ScoreDoc[] hits = null;
         if (query != null && maxHits > 0) {
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(prefixHTML, suffixHTML);
            Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));
            highlighter.setTextFragmenter(new SimpleFragmenter(fragmenterLength));

            TopScoreDocCollector collector = TopScoreDocCollector.create(maxHits, false);
            indexSearcher.search(query, collector);
            hits = collector.topDocs(startIndex, step).scoreDocs;

            Document doc = null;
            for (int i = 0; i < hits.length; i++) {
               doc = indexSearcher.doc(hits[i].doc);
               if (null != doc) {
                  Map<String, Object> map = getDocumentMap(doc, pq.getParameters().get("text"), highlighter);
                  if (map != null) {
                     map.put("docId", hits[i].doc);
                     searchlist.add(map);
                  }
               }
            }
         }

         int totalnum = hits == null ? 0 : hits.length;
         p = new FullIndexPagination();
         p.setSearchlist(searchlist);
         p.setPageNo(pageNo);
         p.setPageSize(pageSize);
         p.setTotalNum(totalnum);
      }
      catch (Exception e) {
         e.printStackTrace();
         p = new FullIndexPagination();
         p.setSearchlist(null);
         p.setPageNo(1);
         p.setPageSize(pageSize);
         p.setTotalNum(0);
      }
      return p;
   }

   private Query getQueryParser(Map<String, String> queryStrs) throws ServiceException {
      try {
         String key = formatKeyWords(queryStrs);
         if (key != null && key.trim().length() > 0) {
            Set<char[]> stopWords = new HashSet<char[]>();
            DocAnalyzer analyzer = new DocAnalyzer(Version.LUCENE_31, stopWords, null);
            dAnalyzer = analyzer;//new EmailAnalyzer(Version.LUCENE_31, new File(stopFilePath));

            QueryParser qp = new QueryParser(Version.LUCENE_31, DEFAULT_KEYWORD, analyzer);
            qp.setDefaultOperator(QueryParser.AND_OPERATOR);
            Query query = qp.parse(key);
            return query;
         }
      }
      catch (org.apache.lucene.queryParser.ParseException e) {
         e.printStackTrace();
         throw new ServiceException("查询条件格式错误");
      }

      return null;
   }

   private String formatKeyWords(Map<String, String> queryStrs) {
      String keyWord = "";

      String filter = DEFAULT_KEYWORD;
      Iterator<String> it = queryStrs.keySet().iterator();
      while (it.hasNext()) {
         String key = it.next();
         String value = queryStrs.get(key);
         if (value != null && value.trim().length() > 0) if (("," + filter + ",").indexOf("," + key + ",") == -1) keyWord += " " + key + ":" + value.trim();
      }

      String defaultKey = queryStrs.get(DEFAULT_KEYWORD);
      if (defaultKey != null && defaultKey.trim().length() > 0) {
         keyWord = "(" + defaultKey.trim() + keyWord + ") OR (content:" + defaultKey.trim() + keyWord + ")";
      }
      return keyWord;
   }

   public Map<String, Object> getDocumentMap(Document doc, String str, Highlighter highlighter) throws IOException, InvalidTokenOffsetsException,
         ParseException {
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("author", doc.get("author"));
      map.put("time", doc.get("time"));
      map.put("publicationName", doc.get("publicationName"));
      map.put("press", doc.get("press"));
      map.put("title", doc.get("title"));
      map.put("fileName", doc.get("fileName"));
      String fileFullName = doc.get("fileFullName");
      String fileNameHighLight = null;
      if (null != fileFullName && !fileFullName.equals("")) {
         try {
            fileNameHighLight = highlighter.getBestFragment(dAnalyzer, "fileFullName", fileFullName);
         }
         catch (Exception e) {
            e.printStackTrace();
         }
      }

      if (fileNameHighLight != null) fileFullName = fileNameHighLight;
      map.put("fileFullName", fileFullName);
      String text = ParserPdf.parserPDF(doc.get("fileFullName")).toString();
      String contentHighLight = null;
      if (null != text && !text.equals("")) {
         contentHighLight = highlighter.getBestFragment(dAnalyzer, "text", text);
         if (contentHighLight != null) text = contentHighLight;
         else {
            int endIndex = Math.min(fragmenterLength, text.length());
            text = text.substring(0, endIndex);
         }
      }
      map.put("text", text);

      return map;
   }
}
