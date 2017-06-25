package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_works_series_case table.
 */
@Entity  
@Table(name="art_artist_works_series_case")  
public class ArtArtistWorksSeriesCase implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "case_content")
   private java.lang.String caseContent;   // 内容

   @Column(name = "author")
   private java.lang.String author;   // 作者

   @Column(name = "case_name")
   private java.lang.String caseName;   // 个案名称


   @Column(name = "case_time")
   private java.util.Date caseTime;   // 时间

   @Column(name = "series_id")
   private java.lang.Integer seriesId;   // 系列id

   // Constructors
   public ArtArtistWorksSeriesCase() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getCaseContent() { 
      return this.caseContent; 
   }
   public void setCaseContent(java.lang.String caseContent) { 
      this.caseContent = caseContent; 
   }


   public java.lang.String getAuthor() { 
      return this.author; 
   }
   public void setAuthor(java.lang.String author) { 
      this.author = author; 
   }


   public java.lang.String getCaseName() { 
      return this.caseName; 
   }
   public void setCaseName(java.lang.String caseName) { 
      this.caseName = caseName; 
   }


   public java.util.Date getCaseTime() { 
      return this.caseTime; 
   }
   public void setCaseTime(java.util.Date caseTime) { 
      this.caseTime = caseTime; 
   }


   public java.lang.Integer getSeriesId() { 
      return this.seriesId; 
   }
   public void setSeriesId(java.lang.Integer seriesId) { 
      this.seriesId = seriesId; 
   }


   public static String REF_CLASS = "ArtArtistWorksSeriesCase";
   public static String PROP_CASE_CONTENT = "caseContent";
   public static String PROP_AUTHOR = "author";
   public static String PROP_CASE_NAME = "caseName";
   public static String PROP_ID = "id";
   public static String PROP_CASE_TIME = "caseTime";
   public static String PROP_SERIES_ID = "seriesId";

   public static String REF_TABLE = "art_artist_works_series_case";
   public static String COL_CASE_CONTENT = "case_content";
   public static String COL_AUTHOR = "author";
   public static String COL_CASE_NAME = "case_name";
   public static String COL_ID = "id";
   public static String COL_CASE_TIME = "case_time";
   public static String COL_SERIES_ID = "series_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtArtistWorksSeriesCase)) return false;
      else {
         com.golead.art.works.model.ArtArtistWorksSeriesCase o = (com.golead.art.works.model.ArtArtistWorksSeriesCase) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistWorksSeriesCase:");
		buffer.append(" id:").append(id);
		buffer.append(" caseContent:").append(dealNull(caseContent));
		buffer.append(" author:").append(dealNull(author));
		buffer.append(" caseName:").append(dealNull(caseName));
		buffer.append(" caseTime:").append(dealNull(caseTime));
		buffer.append(" seriesId:").append(dealNull(seriesId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"caseContent\":\"").append(dealNull(caseContent)).append("\"");
		buffer.append(",\"author\":\"").append(dealNull(author)).append("\"");
		buffer.append(",\"caseName\":\"").append(dealNull(caseName)).append("\"");
		buffer.append(",\"caseTime\":\"").append(dealNull(caseTime)).append("\"");
		buffer.append(",\"seriesId\":\"").append(dealNull(seriesId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
