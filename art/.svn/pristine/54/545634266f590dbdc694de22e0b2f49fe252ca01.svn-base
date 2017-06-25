package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_edu table.
 */
@Entity  
@Table(name="art_artist_edu")  
public class ArtArtistEdu implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "edu_desc")
   private java.lang.String eduDesc;   // 描述

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "edu_time")
   private java.lang.String eduTime;   // 时间

   // Constructors
   public ArtArtistEdu() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getEduDesc() { 
      return this.eduDesc; 
   }
   public void setEduDesc(java.lang.String eduDesc) { 
      this.eduDesc = eduDesc; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getEduTime() { 
      return this.eduTime; 
   }
   public void setEduTime(java.lang.String eduTime) { 
      this.eduTime = eduTime; 
   }


   public static String REF_CLASS = "ArtArtistEdu";
   public static String PROP_ID = "id";
   public static String PROP_EDU_DESC = "eduDesc";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_EDU_TIME = "eduTime";

   public static String REF_TABLE = "art_artist_edu";
   public static String COL_ID = "id";
   public static String COL_EDU_DESC = "edu_desc";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_EDU_TIME = "edu_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistEdu)) return false;
      else {
         com.golead.art.artist.model.ArtArtistEdu o = (com.golead.art.artist.model.ArtArtistEdu) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistEdu:");
		buffer.append(" id:").append(id);
		buffer.append(" eduDesc:").append(dealNull(eduDesc));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" eduTime:").append(dealNull(eduTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"eduDesc\":\"").append(dealNull(eduDesc)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"eduTime\":\"").append(dealNull(eduTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
