package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_style table.
 */
@Entity  
@Table(name="art_works_style")  
public class ArtWorksStyle implements Serializable {
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

   @Column(name = "style_desc")
   private java.lang.String styleDesc;   // 说明

   @Column(name = "create_person")
   private java.lang.String createPerson;   // 创建人

   @Column(name = "create_time")
   private java.util.Date createTime;   // 创建时间

   @Column(name = "style_name")
   private java.lang.String styleName;   // 风格

   // Constructors
   public ArtWorksStyle() {
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


   public java.lang.String getStyleDesc() { 
      return this.styleDesc; 
   }
   public void setStyleDesc(java.lang.String styleDesc) { 
      this.styleDesc = styleDesc; 
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


   public java.lang.String getStyleName() { 
      return this.styleName; 
   }
   public void setStyleName(java.lang.String styleName) { 
      this.styleName = styleName; 
   }


   public static String REF_CLASS = "ArtWorksStyle";
   public static String PROP_UPDATE_PERSON = "updatePerson";
   public static String PROP_ID = "id";
   public static String PROP_UPDATE_TIME = "updateTime";
   public static String PROP_STYLE_DESC = "styleDesc";
   public static String PROP_CREATE_PERSON = "createPerson";
   public static String PROP_CREATE_TIME = "createTime";
   public static String PROP_STYLE_NAME = "styleName";

   public static String REF_TABLE = "art_works_style";
   public static String COL_UPDATE_PERSON = "update_person";
   public static String COL_ID = "id";
   public static String COL_UPDATE_TIME = "update_time";
   public static String COL_STYLE_DESC = "style_desc";
   public static String COL_CREATE_PERSON = "create_person";
   public static String COL_CREATE_TIME = "create_time";
   public static String COL_STYLE_NAME = "style_name";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksStyle)) return false;
      else {
         com.golead.art.works.model.ArtWorksStyle o = (com.golead.art.works.model.ArtWorksStyle) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksStyle:");
		buffer.append(" id:").append(id);
		buffer.append(" updatePerson:").append(dealNull(updatePerson));
		buffer.append(" updateTime:").append(dealNull(updateTime));
		buffer.append(" styleDesc:").append(dealNull(styleDesc));
		buffer.append(" createPerson:").append(dealNull(createPerson));
		buffer.append(" createTime:").append(dealNull(createTime));
		buffer.append(" styleName:").append(dealNull(styleName));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"updatePerson\":\"").append(dealNull(updatePerson)).append("\"");
		buffer.append(",\"updateTime\":\"").append(dealNull(updateTime)).append("\"");
		buffer.append(",\"styleDesc\":\"").append(dealNull(styleDesc)).append("\"");
		buffer.append(",\"createPerson\":\"").append(dealNull(createPerson)).append("\"");
		buffer.append(",\"createTime\":\"").append(dealNull(createTime)).append("\"");
		buffer.append(",\"styleName\":\"").append(dealNull(styleName)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
