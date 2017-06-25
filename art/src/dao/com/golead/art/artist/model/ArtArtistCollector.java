package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_collector table.
 */
@Entity  
@Table(name="art_artist_collector")  
public class ArtArtistCollector implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "collector")
   private java.lang.String collector;   // 收藏家

   @Column(name = "collect_desc")
   private java.lang.String collectDesc;   // 描述

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "collect_works")
   private java.lang.String collectWorks;   // 作品，多个以、隔开

   @Column(name = "collect_time")
   private java.lang.String collectTime;   // 时间

   // Constructors
   public ArtArtistCollector() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getCollector() { 
      return this.collector; 
   }
   public void setCollector(java.lang.String collector) { 
      this.collector = collector; 
   }


   public java.lang.String getCollectDesc() { 
      return this.collectDesc; 
   }
   public void setCollectDesc(java.lang.String collectDesc) { 
      this.collectDesc = collectDesc; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getCollectWorks() { 
      return this.collectWorks; 
   }
   public void setCollectWorks(java.lang.String collectWorks) { 
      this.collectWorks = collectWorks; 
   }


   public java.lang.String getCollectTime() { 
      return this.collectTime; 
   }
   public void setCollectTime(java.lang.String collectTime) { 
      this.collectTime = collectTime; 
   }


   public static String REF_CLASS = "ArtArtistCollector";
   public static String PROP_ID = "id";
   public static String PROP_COLLECTOR = "collector";
   public static String PROP_COLLECT_DESC = "collectDesc";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_COLLECT_WORKS = "collectWorks";
   public static String PROP_COLLECT_TIME = "collectTime";

   public static String REF_TABLE = "art_artist_collector";
   public static String COL_ID = "id";
   public static String COL_COLLECTOR = "collector";
   public static String COL_COLLECT_DESC = "collect_desc";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_COLLECT_WORKS = "collect_works";
   public static String COL_COLLECT_TIME = "collect_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistCollector)) return false;
      else {
         com.golead.art.artist.model.ArtArtistCollector o = (com.golead.art.artist.model.ArtArtistCollector) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistCollector:");
		buffer.append(" id:").append(id);
		buffer.append(" collector:").append(dealNull(collector));
		buffer.append(" collectDesc:").append(dealNull(collectDesc));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" collectWorks:").append(dealNull(collectWorks));
		buffer.append(" collectTime:").append(dealNull(collectTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"collector\":\"").append(dealNull(collector)).append("\"");
		buffer.append(",\"collectDesc\":\"").append(dealNull(collectDesc)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"collectWorks\":\"").append(dealNull(collectWorks)).append("\"");
		buffer.append(",\"collectTime\":\"").append(dealNull(collectTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
