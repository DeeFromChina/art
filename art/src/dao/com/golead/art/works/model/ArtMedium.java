package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_medium table.
 */
@Entity  
@Table(name="art_medium")  
public class ArtMedium implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "medium_side")
   private java.lang.String mediumSide;   // 国内：1，国际：2

   @Column(name = "tree_code")
   private java.lang.String treeCode;   // 编码


   @Column(name = "up_medium_id")
   private java.lang.Integer upMediumId;   // 父id

   @Column(name = "medium_category")
   private java.lang.String mediumCategory;   // 类别，1：材料，2：形式，MEDIUM_CATEGORY

   @Column(name = "medium_name")
   private java.lang.String mediumName;   // 媒介中文名称

   @Column(name = "tree_level")
   private java.lang.Integer treeLevel;   // 层级

   // Constructors
   public ArtMedium() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getMediumSide() { 
      return this.mediumSide; 
   }
   public void setMediumSide(java.lang.String mediumSide) { 
      this.mediumSide = mediumSide; 
   }


   public java.lang.String getTreeCode() { 
      return this.treeCode; 
   }
   public void setTreeCode(java.lang.String treeCode) { 
      this.treeCode = treeCode; 
   }


   public java.lang.Integer getUpMediumId() { 
      return this.upMediumId; 
   }
   public void setUpMediumId(java.lang.Integer upMediumId) { 
      this.upMediumId = upMediumId; 
   }


   public java.lang.String getMediumCategory() { 
      return this.mediumCategory; 
   }
   public void setMediumCategory(java.lang.String mediumCategory) { 
      this.mediumCategory = mediumCategory; 
   }


   public java.lang.String getMediumName() { 
      return this.mediumName; 
   }
   public void setMediumName(java.lang.String mediumName) { 
      this.mediumName = mediumName; 
   }


   public java.lang.Integer getTreeLevel() { 
      return this.treeLevel; 
   }
   public void setTreeLevel(java.lang.Integer treeLevel) { 
      this.treeLevel = treeLevel; 
   }


   public static String REF_CLASS = "ArtMedium";
   public static String PROP_MEDIUM_SIDE = "mediumSide";
   public static String PROP_TREE_CODE = "treeCode";
   public static String PROP_ID = "id";
   public static String PROP_UP_MEDIUM_ID = "upMediumId";
   public static String PROP_MEDIUM_CATEGORY = "mediumCategory";
   public static String PROP_MEDIUM_NAME = "mediumName";
   public static String PROP_TREE_LEVEL = "treeLevel";

   public static String REF_TABLE = "art_medium";
   public static String COL_MEDIUM_SIDE = "medium_side";
   public static String COL_TREE_CODE = "tree_code";
   public static String COL_ID = "id";
   public static String COL_UP_MEDIUM_ID = "up_medium_id";
   public static String COL_MEDIUM_CATEGORY = "medium_category";
   public static String COL_MEDIUM_NAME = "medium_name";
   public static String COL_TREE_LEVEL = "tree_level";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtMedium)) return false;
      else {
         com.golead.art.works.model.ArtMedium o = (com.golead.art.works.model.ArtMedium) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtMedium:");
		buffer.append(" id:").append(id);
		buffer.append(" mediumSide:").append(dealNull(mediumSide));
		buffer.append(" treeCode:").append(dealNull(treeCode));
		buffer.append(" upMediumId:").append(dealNull(upMediumId));
		buffer.append(" mediumCategory:").append(dealNull(mediumCategory));
		buffer.append(" mediumName:").append(dealNull(mediumName));
		buffer.append(" treeLevel:").append(dealNull(treeLevel));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"mediumSide\":\"").append(dealNull(mediumSide)).append("\"");
		buffer.append(",\"treeCode\":\"").append(dealNull(treeCode)).append("\"");
		buffer.append(",\"upMediumId\":\"").append(dealNull(upMediumId)).append("\"");
		buffer.append(",\"mediumCategory\":\"").append(dealNull(mediumCategory)).append("\"");
		buffer.append(",\"mediumName\":\"").append(dealNull(mediumName)).append("\"");
		buffer.append(",\"treeLevel\":\"").append(dealNull(treeLevel)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
