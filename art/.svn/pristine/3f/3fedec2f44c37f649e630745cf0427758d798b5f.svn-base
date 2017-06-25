package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_period table.
 */
@Entity  
@Table(name="art_works_period")  
public class ArtWorksPeriod implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "period_type")
   private java.lang.String periodType;   // 时期类型，代码集：PERIOD_TYPE

   @Column(name = "period_name")
   private java.lang.String periodName;   // 时期名称

   // Constructors
   public ArtWorksPeriod() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.String getPeriodType() { 
      return this.periodType; 
   }
   public void setPeriodType(java.lang.String periodType) { 
      this.periodType = periodType; 
   }


   public java.lang.String getPeriodName() { 
      return this.periodName; 
   }
   public void setPeriodName(java.lang.String periodName) { 
      this.periodName = periodName; 
   }


   public static String REF_CLASS = "ArtWorksPeriod";
   public static String PROP_ID = "id";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_PERIOD_TYPE = "periodType";
   public static String PROP_PERIOD_NAME = "periodName";

   public static String REF_TABLE = "art_works_period";
   public static String COL_ID = "id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_PERIOD_TYPE = "period_type";
   public static String COL_PERIOD_NAME = "period_name";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksPeriod)) return false;
      else {
         com.golead.art.works.model.ArtWorksPeriod o = (com.golead.art.works.model.ArtWorksPeriod) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksPeriod:");
		buffer.append(" id:").append(id);
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" periodType:").append(dealNull(periodType));
		buffer.append(" periodName:").append(dealNull(periodName));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"periodType\":\"").append(dealNull(periodType)).append("\"");
		buffer.append(",\"periodName\":\"").append(dealNull(periodName)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
