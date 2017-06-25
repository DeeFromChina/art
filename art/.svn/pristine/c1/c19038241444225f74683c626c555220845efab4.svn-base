package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_some table.
 */
@Entity  
@Table(name="art_works_some")  
public class ArtWorksSome implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "some_works_id")
   private java.lang.Integer someWorksId;   // 相关作品id

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "year")
   private java.lang.String year;   // 年代

   @Column(name = "works_name")
   private java.lang.String worksName;   // 名称

   @Column(name = "medium_material")
   private java.lang.String mediumMaterial;   // 媒介(材料)

   @Column(name = "medium_shape")
   private java.lang.String mediumShape;   // 媒介(形式)

   // Constructors
   public ArtWorksSome() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getSomeWorksId() { 
      return this.someWorksId; 
   }
   public void setSomeWorksId(java.lang.Integer someWorksId) { 
      this.someWorksId = someWorksId; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.String getYear() { 
      return this.year; 
   }
   public void setYear(java.lang.String year) { 
      this.year = year; 
   }


   public java.lang.String getWorksName() { 
      return this.worksName; 
   }
   public void setWorksName(java.lang.String worksName) { 
      this.worksName = worksName; 
   }


   public java.lang.String getMediumMaterial() { 
      return this.mediumMaterial; 
   }
   public void setMediumMaterial(java.lang.String mediumMaterial) { 
      this.mediumMaterial = mediumMaterial; 
   }


   public java.lang.String getMediumShape() { 
      return this.mediumShape; 
   }
   public void setMediumShape(java.lang.String mediumShape) { 
      this.mediumShape = mediumShape; 
   }


   public static String REF_CLASS = "ArtWorksSome";
   public static String PROP_ID = "id";
   public static String PROP_SOME_WORKS_ID = "someWorksId";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_YEAR = "year";
   public static String PROP_WORKS_NAME = "worksName";
   public static String PROP_MEDIUM_MATERIAL = "mediumMaterial";
   public static String PROP_MEDIUM_SHAPE = "mediumShape";

   public static String REF_TABLE = "art_works_some";
   public static String COL_ID = "id";
   public static String COL_SOME_WORKS_ID = "some_works_id";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_YEAR = "year";
   public static String COL_WORKS_NAME = "works_name";
   public static String COL_MEDIUM_MATERIAL = "medium_material";
   public static String COL_MEDIUM_SHAPE = "medium_shape";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksSome)) return false;
      else {
         com.golead.art.works.model.ArtWorksSome o = (com.golead.art.works.model.ArtWorksSome) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksSome:");
		buffer.append(" id:").append(id);
		buffer.append(" someWorksId:").append(dealNull(someWorksId));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" year:").append(dealNull(year));
		buffer.append(" worksName:").append(dealNull(worksName));
		buffer.append(" mediumMaterial:").append(dealNull(mediumMaterial));
		buffer.append(" mediumShape:").append(dealNull(mediumShape));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"someWorksId\":\"").append(dealNull(someWorksId)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"year\":\"").append(dealNull(year)).append("\"");
		buffer.append(",\"worksName\":\"").append(dealNull(worksName)).append("\"");
		buffer.append(",\"mediumMaterial\":\"").append(dealNull(mediumMaterial)).append("\"");
		buffer.append(",\"mediumShape\":\"").append(dealNull(mediumShape)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
