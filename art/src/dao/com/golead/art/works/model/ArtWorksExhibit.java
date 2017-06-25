package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_exhibit table.
 */
@Entity  
@Table(name="art_works_exhibit")  
public class ArtWorksExhibit implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "exhibit_id")
   private java.lang.Integer exhibitId;   // 展览id

   // Constructors
   public ArtWorksExhibit() {
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


   public java.lang.Integer getExhibitId() { 
      return this.exhibitId; 
   }
   public void setExhibitId(java.lang.Integer exhibitId) { 
      this.exhibitId = exhibitId; 
   }


   public static String REF_CLASS = "ArtWorksExhibit";
   public static String PROP_ID = "id";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_EXHIBIT_ID = "exhibitId";

   public static String REF_TABLE = "art_works_exhibit";
   public static String COL_ID = "id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_EXHIBIT_ID = "exhibit_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksExhibit)) return false;
      else {
         com.golead.art.works.model.ArtWorksExhibit o = (com.golead.art.works.model.ArtWorksExhibit) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksExhibit:");
		buffer.append(" id:").append(id);
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" exhibitId:").append(dealNull(exhibitId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"exhibitId\":\"").append(dealNull(exhibitId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
