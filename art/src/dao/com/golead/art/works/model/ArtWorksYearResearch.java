package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_year_research table.
 */
@Entity  
@Table(name="art_works_year_research")  
public class ArtWorksYearResearch implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "seq_no")
   private java.lang.Integer seqNo;   // 序列号

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "year_id")
   private java.lang.Integer yearId;   // 年代id


   // Constructors
   public ArtWorksYearResearch() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getSeqNo() { 
      return this.seqNo; 
   }
   public void setSeqNo(java.lang.Integer seqNo) { 
      this.seqNo = seqNo; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.Integer getYearId() { 
      return this.yearId; 
   }
   public void setYearId(java.lang.Integer yearId) { 
      this.yearId = yearId; 
   }


   public static String REF_CLASS = "ArtWorksYearResearch";
   public static String PROP_SEQ_NO = "seqNo";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_YEAR_ID = "yearId";
   public static String PROP_ID = "id";

   public static String REF_TABLE = "art_works_year_research";
   public static String COL_SEQ_NO = "seq_no";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_YEAR_ID = "year_id";
   public static String COL_ID = "id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksYearResearch)) return false;
      else {
         com.golead.art.works.model.ArtWorksYearResearch o = (com.golead.art.works.model.ArtWorksYearResearch) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksYearResearch:");
		buffer.append(" id:").append(id);
		buffer.append(" seqNo:").append(dealNull(seqNo));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" yearId:").append(dealNull(yearId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"seqNo\":\"").append(dealNull(seqNo)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"yearId\":\"").append(dealNull(yearId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
