package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_theme table.
 */
@Entity  
@Table(name="art_works_theme")  
public class ArtWorksTheme implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "update_person")
   private java.lang.String updatePerson;   // 修改人


   @Column(name = "update_time")
   private java.util.Date updateTime;   // 修改时间

   @Column(name = "theme_desc")
   private java.lang.String themeDesc;   // 说明

   @Column(name = "create_person")
   private java.lang.String createPerson;   // 创建人

   @Column(name = "create_time")
   private java.util.Date createTime;   // 创建时间

   @Column(name = "theme_name")
   private java.lang.String themeName;   // 题材

   // Constructors
   public ArtWorksTheme() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getUpdatePerson() { 
      return this.updatePerson; 
   }
   public void setUpdatePerson(java.lang.String updatePerson) { 
      this.updatePerson = updatePerson; 
   }


   public java.util.Date getUpdateTime() { 
      return this.updateTime; 
   }
   public void setUpdateTime(java.util.Date updateTime) { 
      this.updateTime = updateTime; 
   }


   public java.lang.String getThemeDesc() { 
      return this.themeDesc; 
   }
   public void setThemeDesc(java.lang.String themeDesc) { 
      this.themeDesc = themeDesc; 
   }


   public java.lang.String getCreatePerson() { 
      return this.createPerson; 
   }
   public void setCreatePerson(java.lang.String createPerson) { 
      this.createPerson = createPerson; 
   }


   public java.util.Date getCreateTime() { 
      return this.createTime; 
   }
   public void setCreateTime(java.util.Date createTime) { 
      this.createTime = createTime; 
   }


   public java.lang.String getThemeName() { 
      return this.themeName; 
   }
   public void setThemeName(java.lang.String themeName) { 
      this.themeName = themeName; 
   }


   public static String REF_CLASS = "ArtWorksTheme";
   public static String PROP_UPDATE_PERSON = "updatePerson";
   public static String PROP_ID = "id";
   public static String PROP_UPDATE_TIME = "updateTime";
   public static String PROP_THEME_DESC = "themeDesc";
   public static String PROP_CREATE_PERSON = "createPerson";
   public static String PROP_CREATE_TIME = "createTime";
   public static String PROP_THEME_NAME = "themeName";

   public static String REF_TABLE = "art_works_theme";
   public static String COL_UPDATE_PERSON = "update_person";
   public static String COL_ID = "id";
   public static String COL_UPDATE_TIME = "update_time";
   public static String COL_THEME_DESC = "theme_desc";
   public static String COL_CREATE_PERSON = "create_person";
   public static String COL_CREATE_TIME = "create_time";
   public static String COL_THEME_NAME = "theme_name";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksTheme)) return false;
      else {
         com.golead.art.works.model.ArtWorksTheme o = (com.golead.art.works.model.ArtWorksTheme) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksTheme:");
		buffer.append(" id:").append(id);
		buffer.append(" updatePerson:").append(dealNull(updatePerson));
		buffer.append(" updateTime:").append(dealNull(updateTime));
		buffer.append(" themeDesc:").append(dealNull(themeDesc));
		buffer.append(" createPerson:").append(dealNull(createPerson));
		buffer.append(" createTime:").append(dealNull(createTime));
		buffer.append(" themeName:").append(dealNull(themeName));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"updatePerson\":\"").append(dealNull(updatePerson)).append("\"");
		buffer.append(",\"updateTime\":\"").append(dealNull(updateTime)).append("\"");
		buffer.append(",\"themeDesc\":\"").append(dealNull(themeDesc)).append("\"");
		buffer.append(",\"createPerson\":\"").append(dealNull(createPerson)).append("\"");
		buffer.append(",\"createTime\":\"").append(dealNull(createTime)).append("\"");
		buffer.append(",\"themeName\":\"").append(dealNull(themeName)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
