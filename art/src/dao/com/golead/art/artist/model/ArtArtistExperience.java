package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_experience table.
 */
@Entity  
@Table(name="art_artist_experience")  
public class ArtArtistExperience implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "art_id")
   private java.lang.Integer artId;   // 艺术家ID

   @Column(name = "life_experience")
   private java.lang.String lifeExperience;   // 人生事件


   @Column(name = "history_experience")
   private java.lang.String historyExperience;   // 历史事件

   @Column(name = "expe_time")
   private java.lang.String expeTime;   // 年份

   // Constructors
   public ArtArtistExperience() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getArtId() { 
      return this.artId; 
   }
   public void setArtId(java.lang.Integer artId) { 
      this.artId = artId; 
   }


   public java.lang.String getLifeExperience() { 
      return this.lifeExperience; 
   }
   public void setLifeExperience(java.lang.String lifeExperience) { 
      this.lifeExperience = lifeExperience; 
   }


   public java.lang.String getHistoryExperience() { 
      return this.historyExperience; 
   }
   public void setHistoryExperience(java.lang.String historyExperience) { 
      this.historyExperience = historyExperience; 
   }


   public java.lang.String getExpeTime() { 
      return this.expeTime; 
   }
   public void setExpeTime(java.lang.String expeTime) { 
      this.expeTime = expeTime; 
   }


   public static String REF_CLASS = "ArtArtistExperience";
   public static String PROP_ART_ID = "artId";
   public static String PROP_LIFE_EXPERIENCE = "lifeExperience";
   public static String PROP_ID = "id";
   public static String PROP_HISTORY_EXPERIENCE = "historyExperience";
   public static String PROP_EXPE_TIME = "expeTime";

   public static String REF_TABLE = "art_artist_experience";
   public static String COL_ART_ID = "art_id";
   public static String COL_LIFE_EXPERIENCE = "life_experience";
   public static String COL_ID = "id";
   public static String COL_HISTORY_EXPERIENCE = "history_experience";
   public static String COL_EXPE_TIME = "expe_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistExperience)) return false;
      else {
         com.golead.art.artist.model.ArtArtistExperience o = (com.golead.art.artist.model.ArtArtistExperience) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistExperience:");
		buffer.append(" id:").append(id);
		buffer.append(" artId:").append(dealNull(artId));
		buffer.append(" lifeExperience:").append(dealNull(lifeExperience));
		buffer.append(" historyExperience:").append(dealNull(historyExperience));
		buffer.append(" expeTime:").append(dealNull(expeTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"artId\":\"").append(dealNull(artId)).append("\"");
		buffer.append(",\"lifeExperience\":\"").append(dealNull(lifeExperience)).append("\"");
		buffer.append(",\"historyExperience\":\"").append(dealNull(historyExperience)).append("\"");
		buffer.append(",\"expeTime\":\"").append(dealNull(expeTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
