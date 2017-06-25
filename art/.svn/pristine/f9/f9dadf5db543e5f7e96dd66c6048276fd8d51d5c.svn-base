package com.golead.art.app.artistFollow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_follow table.
 */
@Entity  
@Table(name="art_artist_follow")  
public class ArtArtistFollow implements Serializable {
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

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   // Constructors
   public ArtArtistFollow() {
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


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public static String REF_CLASS = "ArtArtistFollow";
   public static String PROP_ID = "id";
   public static String PROP_FOLLOW_TIME = "followTime";
   public static String PROP_APP_USER_ID = "appUserId";
   public static String PROP_ARTIST_ID = "artistId";

   public static String REF_TABLE = "art_artist_follow";
   public static String COL_ID = "id";
   public static String COL_FOLLOW_TIME = "follow_time";
   public static String COL_APP_USER_ID = "app_user_id";
   public static String COL_ARTIST_ID = "artist_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.artistFollow.model.ArtArtistFollow)) return false;
      else {
         com.golead.art.app.artistFollow.model.ArtArtistFollow o = (com.golead.art.app.artistFollow.model.ArtArtistFollow) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistFollow:");
		buffer.append(" id:").append(id);
		buffer.append(" followTime:").append(dealNull(followTime));
		buffer.append(" appUserId:").append(dealNull(appUserId));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"followTime\":\"").append(dealNull(followTime)).append("\"");
		buffer.append(",\"appUserId\":\"").append(dealNull(appUserId)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
