package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_follow table.
 */
@Entity  
@Table(name="art_works_follow")  
public class ArtWorksFollow implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties


   @Column(name = "follow_time")
   private java.util.Date followTime;   // 关注时间

   @Column(name = "app_user_id")
   private java.lang.Integer appUserId;   // app用户id

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 艺术品id

   // Constructors
   public ArtWorksFollow() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.util.Date getFollowTime() { 
      return this.followTime; 
   }
   public void setFollowTime(java.util.Date followTime) { 
      this.followTime = followTime; 
   }


   public java.lang.Integer getAppUserId() { 
      return this.appUserId; 
   }
   public void setAppUserId(java.lang.Integer appUserId) { 
      this.appUserId = appUserId; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public static String REF_CLASS = "ArtWorksFollow";
   public static String PROP_ID = "id";
   public static String PROP_FOLLOW_TIME = "followTime";
   public static String PROP_APP_USER_ID = "appUserId";
   public static String PROP_WORKS_ID = "worksId";

   public static String REF_TABLE = "art_works_follow";
   public static String COL_ID = "id";
   public static String COL_FOLLOW_TIME = "follow_time";
   public static String COL_APP_USER_ID = "app_user_id";
   public static String COL_WORKS_ID = "works_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksFollow)) return false;
      else {
         com.golead.art.works.model.ArtWorksFollow o = (com.golead.art.works.model.ArtWorksFollow) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksFollow:");
		buffer.append(" id:").append(id);
		buffer.append(" followTime:").append(dealNull(followTime));
		buffer.append(" appUserId:").append(dealNull(appUserId));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"followTime\":\"").append(dealNull(followTime)).append("\"");
		buffer.append(",\"appUserId\":\"").append(dealNull(appUserId)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
