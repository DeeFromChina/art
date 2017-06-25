package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_heat_day table.
 */
@Entity  
@Table(name="art_artist_heat_day")  
public class ArtArtistHeatDay implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties


   @Column(name = "day")
   private java.lang.Integer day;   // 天数

   // Constructors
   public ArtArtistHeatDay() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getDay() { 
      return this.day; 
   }
   public void setDay(java.lang.Integer day) { 
      this.day = day; 
   }


   public static String REF_CLASS = "ArtArtistHeatDay";
   public static String PROP_ID = "id";
   public static String PROP_DAY = "day";

   public static String REF_TABLE = "art_artist_heat_day";
   public static String COL_ID = "id";
   public static String COL_DAY = "day";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtArtistHeatDay)) return false;
      else {
         com.golead.art.works.model.ArtArtistHeatDay o = (com.golead.art.works.model.ArtArtistHeatDay) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistHeatDay:");
		buffer.append(" id:").append(id);
		buffer.append(" day:").append(dealNull(day));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"day\":\"").append(dealNull(day)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
