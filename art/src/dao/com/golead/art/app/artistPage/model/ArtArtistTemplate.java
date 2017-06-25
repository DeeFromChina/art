package com.golead.art.app.artistPage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_template table.
 */
@Entity  
@Table(name="art_artist_template")  
public class ArtArtistTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "template_name")
   private java.lang.String templateName;   // 模板名称

   @Column(name = "template_remark")
   private java.lang.String templateRemark;   // 描述

   @Column(name = "create_time")
   private java.util.Date createTime;   //  

   @Column(name = "creater")
   private java.lang.String creater;   //  

   // Constructors
   public ArtArtistTemplate() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getTemplateName() { 
      return this.templateName; 
   }
   public void setTemplateName(java.lang.String templateName) { 
      this.templateName = templateName; 
   }


   public java.lang.String getTemplateRemark() { 
      return this.templateRemark; 
   }
   public void setTemplateRemark(java.lang.String templateRemark) { 
      this.templateRemark = templateRemark; 
   }


   public java.util.Date getCreateTime() { 
      return this.createTime; 
   }
   public void setCreateTime(java.util.Date createTime) { 
      this.createTime = createTime; 
   }


   public java.lang.String getCreater() { 
      return this.creater; 
   }
   public void setCreater(java.lang.String creater) { 
      this.creater = creater; 
   }


   public static String REF_CLASS = "ArtArtistTemplate";
   public static String PROP_ID = "id";
   public static String PROP_TEMPLATE_NAME = "templateName";
   public static String PROP_TEMPLATE_REMARK = "templateRemark";
   public static String PROP_CREATE_TIME = "createTime";
   public static String PROP_CREATER = "creater";

   public static String REF_TABLE = "art_artist_template";
   public static String COL_ID = "id";
   public static String COL_TEMPLATE_NAME = "template_name";
   public static String COL_TEMPLATE_REMARK = "template_remark";
   public static String COL_CREATE_TIME = "create_time";
   public static String COL_CREATER = "creater";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.artistPage.model.ArtArtistTemplate)) return false;
      else {
         com.golead.art.app.artistPage.model.ArtArtistTemplate o = (com.golead.art.app.artistPage.model.ArtArtistTemplate) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistTemplate:");
		buffer.append(" id:").append(id);
		buffer.append(" templateName:").append(dealNull(templateName));
		buffer.append(" templateRemark:").append(dealNull(templateRemark));
		buffer.append(" createTime:").append(dealNull(createTime));
		buffer.append(" creater:").append(dealNull(creater));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"templateName\":\"").append(dealNull(templateName)).append("\"");
		buffer.append(",\"templateRemark\":\"").append(dealNull(templateRemark)).append("\"");
		buffer.append(",\"createTime\":\"").append(dealNull(createTime)).append("\"");
		buffer.append(",\"creater\":\"").append(dealNull(creater)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
