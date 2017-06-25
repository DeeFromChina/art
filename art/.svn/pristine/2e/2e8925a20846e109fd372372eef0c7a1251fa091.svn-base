package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_agency table.
 */
@Entity  
@Table(name="art_works_agency")  
public class ArtWorksAgency implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties


   @Column(name = "agency_id")
   private java.lang.Integer agencyId;   // 机构id

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "collect_desc")
   private java.lang.String collectDesc;   // 描述

   @Column(name = "collect_time")
   private java.lang.String collectTime;   // 时间

   // Constructors
   public ArtWorksAgency() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getAgencyId() { 
      return this.agencyId; 
   }
   public void setAgencyId(java.lang.Integer agencyId) { 
      this.agencyId = agencyId; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.String getCollectDesc() { 
      return this.collectDesc; 
   }
   public void setCollectDesc(java.lang.String collectDesc) { 
      this.collectDesc = collectDesc; 
   }


   public java.lang.String getCollectTime() { 
      return this.collectTime; 
   }
   public void setCollectTime(java.lang.String collectTime) { 
      this.collectTime = collectTime; 
   }


   public static String REF_CLASS = "ArtWorksAgency";
   public static String PROP_ID = "id";
   public static String PROP_AGENCY_ID = "agencyId";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_COLLECT_DESC = "collectDesc";
   public static String PROP_COLLECT_TIME = "collectTime";

   public static String REF_TABLE = "art_works_agency";
   public static String COL_ID = "id";
   public static String COL_AGENCY_ID = "agency_id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_COLLECT_DESC = "collect_desc";
   public static String COL_COLLECT_TIME = "collect_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksAgency)) return false;
      else {
         com.golead.art.works.model.ArtWorksAgency o = (com.golead.art.works.model.ArtWorksAgency) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksAgency:");
		buffer.append(" id:").append(id);
		buffer.append(" agencyId:").append(dealNull(agencyId));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" collectDesc:").append(dealNull(collectDesc));
		buffer.append(" collectTime:").append(dealNull(collectTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"agencyId\":\"").append(dealNull(agencyId)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"collectDesc\":\"").append(dealNull(collectDesc)).append("\"");
		buffer.append(",\"collectTime\":\"").append(dealNull(collectTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
