package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_abmb table.
 */
@Entity  
@Table(name="art_works_abmb")  
public class ArtWorksAbmb implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "abmb_id")
   private java.lang.Integer abmbId;   // 艺博会id

   // Constructors
   public ArtWorksAbmb() {
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


   public java.lang.Integer getAbmbId() { 
      return this.abmbId; 
   }
   public void setAbmbId(java.lang.Integer abmbId) { 
      this.abmbId = abmbId; 
   }


   public static String REF_CLASS = "ArtWorksAbmb";
   public static String PROP_ID = "id";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_ABMB_ID = "abmbId";

   public static String REF_TABLE = "art_works_abmb";
   public static String COL_ID = "id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_ABMB_ID = "abmb_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksAbmb)) return false;
      else {
         com.golead.art.works.model.ArtWorksAbmb o = (com.golead.art.works.model.ArtWorksAbmb) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksAbmb:");
		buffer.append(" id:").append(id);
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" abmbId:").append(dealNull(abmbId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"abmbId\":\"").append(dealNull(abmbId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
