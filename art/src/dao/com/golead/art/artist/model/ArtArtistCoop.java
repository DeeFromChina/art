package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_coop table.
 */
@Entity  
@Table(name="art_artist_coop")  
public class ArtArtistCoop implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "agency_id")
   private java.lang.Integer agencyId;   // 合作机构名

   @Column(name = "coop_desc")
   private java.lang.String coopDesc;   // 描述

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "coop_time")
   private java.lang.String coopTime;   // 时间

   // Constructors
   public ArtArtistCoop() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getAgencyId() { 
      return this.agencyId; 
   }
   public void setAgencyId(java.lang.Integer agencyId) { 
      this.agencyId = agencyId; 
   }


   public java.lang.String getCoopDesc() { 
      return this.coopDesc; 
   }
   public void setCoopDesc(java.lang.String coopDesc) { 
      this.coopDesc = coopDesc; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getCoopTime() { 
      return this.coopTime; 
   }
   public void setCoopTime(java.lang.String coopTime) { 
      this.coopTime = coopTime; 
   }


   public static String REF_CLASS = "ArtArtistCoop";
   public static String PROP_ID = "id";
   public static String PROP_AGENCY_ID = "agencyId";
   public static String PROP_COOP_DESC = "coopDesc";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_COOP_TIME = "coopTime";

   public static String REF_TABLE = "art_artist_coop";
   public static String COL_ID = "id";
   public static String COL_AGENCY_ID = "agency_id";
   public static String COL_COOP_DESC = "coop_desc";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_COOP_TIME = "coop_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistCoop)) return false;
      else {
         com.golead.art.artist.model.ArtArtistCoop o = (com.golead.art.artist.model.ArtArtistCoop) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistCoop:");
		buffer.append(" id:").append(id);
		buffer.append(" agencyId:").append(dealNull(agencyId));
		buffer.append(" coopDesc:").append(dealNull(coopDesc));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" coopTime:").append(dealNull(coopTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"agencyId\":\"").append(dealNull(agencyId)).append("\"");
		buffer.append(",\"coopDesc\":\"").append(dealNull(coopDesc)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"coopTime\":\"").append(dealNull(coopTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
