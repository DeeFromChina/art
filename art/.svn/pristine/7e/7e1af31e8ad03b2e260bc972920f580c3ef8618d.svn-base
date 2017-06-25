package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_exhibit table.
 */
@Entity  
@Table(name="art_artist_exhibit")  
public class ArtArtistExhibit implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "exhibit_id")
   private java.lang.Integer exhibitId;   // 展览id

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   // Constructors
   public ArtArtistExhibit() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getExhibitId() { 
      return this.exhibitId; 
   }
   public void setExhibitId(java.lang.Integer exhibitId) { 
      this.exhibitId = exhibitId; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public static String REF_CLASS = "ArtArtistExhibit";
   public static String PROP_ID = "id";
   public static String PROP_EXHIBIT_ID = "exhibitId";
   public static String PROP_ARTIST_ID = "artistId";

   public static String REF_TABLE = "art_artist_exhibit";
   public static String COL_ID = "id";
   public static String COL_EXHIBIT_ID = "exhibit_id";
   public static String COL_ARTIST_ID = "artist_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistExhibit)) return false;
      else {
         com.golead.art.artist.model.ArtArtistExhibit o = (com.golead.art.artist.model.ArtArtistExhibit) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistExhibit:");
		buffer.append(" id:").append(id);
		buffer.append(" exhibitId:").append(dealNull(exhibitId));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"exhibitId\":\"").append(dealNull(exhibitId)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
