package com.golead.art.app.artistPage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_page_research table.
 */
@Entity  
@Table(name="art_artist_page_research")  
public class ArtArtistPageResearch implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "artist_id")
   private java.lang.Integer artistId;   //  

   @Column(name = "temp_id")
   private java.lang.Integer tempId;   //  

   // Constructors
   public ArtArtistPageResearch() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.Integer getTempId() { 
      return this.tempId; 
   }
   public void setTempId(java.lang.Integer tempId) { 
      this.tempId = tempId; 
   }


   public static String REF_CLASS = "ArtArtistPageResearch";
   public static String PROP_ID = "id";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_TEMP_ID = "tempId";

   public static String REF_TABLE = "art_artist_page_research";
   public static String COL_ID = "id";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_TEMP_ID = "temp_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.artistPage.model.ArtArtistPageResearch)) return false;
      else {
         com.golead.art.app.artistPage.model.ArtArtistPageResearch o = (com.golead.art.app.artistPage.model.ArtArtistPageResearch) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistPageResearch:");
		buffer.append(" id:").append(id);
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" tempId:").append(dealNull(tempId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"tempId\":\"").append(dealNull(tempId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
