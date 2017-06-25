package com.golead.art.app.homePage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_app_home_page table.
 */
@Entity  
@Table(name="art_app_home_page")  
public class ArtAppHomePage implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "seq_no")
   private java.lang.String seqNo;   // 序列号


   @Column(name = "homepage_photo")
   private java.lang.String homepagePhoto;   // 图片

   @Column(name = "homepage_status")
   private java.lang.String homepageStatus;   // 状态（0停用、1启用）

   // Constructors
   public ArtAppHomePage() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getSeqNo() { 
      return this.seqNo; 
   }
   public void setSeqNo(java.lang.String seqNo) { 
      this.seqNo = seqNo; 
   }


   public java.lang.String getHomepagePhoto() { 
      return this.homepagePhoto; 
   }
   public void setHomepagePhoto(java.lang.String homepagePhoto) { 
      this.homepagePhoto = homepagePhoto; 
   }


   public java.lang.String getHomepageStatus() { 
      return this.homepageStatus; 
   }
   public void setHomepageStatus(java.lang.String homepageStatus) { 
      this.homepageStatus = homepageStatus; 
   }


   public static String REF_CLASS = "ArtAppHomePage";
   public static String PROP_SEQ_NO = "seqNo";
   public static String PROP_ID = "id";
   public static String PROP_HOMEPAGE_PHOTO = "homepagePhoto";
   public static String PROP_HOMEPAGE_STATUS = "homepageStatus";

   public static String REF_TABLE = "art_app_home_page";
   public static String COL_SEQ_NO = "seq_no";
   public static String COL_ID = "id";
   public static String COL_HOMEPAGE_PHOTO = "homepage_photo";
   public static String COL_HOMEPAGE_STATUS = "homepage_status";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.homePage.model.ArtAppHomePage)) return false;
      else {
         com.golead.art.app.homePage.model.ArtAppHomePage o = (com.golead.art.app.homePage.model.ArtAppHomePage) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtAppHomePage:");
		buffer.append(" id:").append(id);
		buffer.append(" seqNo:").append(dealNull(seqNo));
		buffer.append(" homepagePhoto:").append(dealNull(homepagePhoto));
		buffer.append(" homepageStatus:").append(dealNull(homepageStatus));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"seqNo\":\"").append(dealNull(seqNo)).append("\"");
		buffer.append(",\"homepagePhoto\":\"").append(dealNull(homepagePhoto)).append("\"");
		buffer.append(",\"homepageStatus\":\"").append(dealNull(homepageStatus)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
