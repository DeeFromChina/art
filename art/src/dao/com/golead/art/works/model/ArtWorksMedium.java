package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_medium table.
 */
@Entity  
@Table(name="art_works_medium")  
public class ArtWorksMedium implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "medium_id")
   private java.lang.Integer mediumId;   // 媒介ID

   @Column(name = "medium_desc")
   private java.lang.String mediumDesc;   // 描述

   // Constructors
   public ArtWorksMedium() {
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


   public java.lang.Integer getMediumId() { 
      return this.mediumId; 
   }
   public void setMediumId(java.lang.Integer mediumId) { 
      this.mediumId = mediumId; 
   }


   public java.lang.String getMediumDesc() { 
      return this.mediumDesc; 
   }
   public void setMediumDesc(java.lang.String mediumDesc) { 
      this.mediumDesc = mediumDesc; 
   }


   public static String REF_CLASS = "ArtWorksMedium";
   public static String PROP_ID = "id";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_MEDIUM_ID = "mediumId";
   public static String PROP_MEDIUM_DESC = "mediumDesc";

   public static String REF_TABLE = "art_works_medium";
   public static String COL_ID = "id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_MEDIUM_ID = "medium_id";
   public static String COL_MEDIUM_DESC = "medium_desc";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksMedium)) return false;
      else {
         com.golead.art.works.model.ArtWorksMedium o = (com.golead.art.works.model.ArtWorksMedium) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksMedium:");
		buffer.append(" id:").append(id);
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" mediumId:").append(dealNull(mediumId));
		buffer.append(" mediumDesc:").append(dealNull(mediumDesc));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"mediumId\":\"").append(dealNull(mediumId)).append("\"");
		buffer.append(",\"mediumDesc\":\"").append(dealNull(mediumDesc)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
