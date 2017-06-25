package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_heat table.
 */
@Entity  
@Table(name="art_artist_heat")  
public class ArtArtistHeat implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "heat_num")
   private java.lang.Integer heatNum;   // 热度数量


   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "day_id")
   private java.lang.Integer dayId;   // 天数id

   @Column(name = "heat_time")
   private java.util.Date heatTime;   // 记录时间

   // Constructors
   public ArtArtistHeat() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getHeatNum() { 
      return this.heatNum; 
   }
   public void setHeatNum(java.lang.Integer heatNum) { 
      this.heatNum = heatNum; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.Integer getDayId() { 
      return this.dayId; 
   }
   public void setDayId(java.lang.Integer dayId) { 
      this.dayId = dayId; 
   }


   public java.util.Date getHeatTime() { 
      return this.heatTime; 
   }
   public void setHeatTime(java.util.Date heatTime) { 
      this.heatTime = heatTime; 
   }


   public static String REF_CLASS = "ArtArtistHeat";
   public static String PROP_HEAT_NUM = "heatNum";
   public static String PROP_ID = "id";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_DAY_ID = "dayId";
   public static String PROP_HEAT_TIME = "heatTime";

   public static String REF_TABLE = "art_artist_heat";
   public static String COL_HEAT_NUM = "heat_num";
   public static String COL_ID = "id";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_DAY_ID = "day_id";
   public static String COL_HEAT_TIME = "heat_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtArtistHeat)) return false;
      else {
         com.golead.art.works.model.ArtArtistHeat o = (com.golead.art.works.model.ArtArtistHeat) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistHeat:");
		buffer.append(" id:").append(id);
		buffer.append(" heatNum:").append(dealNull(heatNum));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" dayId:").append(dealNull(dayId));
		buffer.append(" heatTime:").append(dealNull(heatTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"heatNum\":\"").append(dealNull(heatNum)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"dayId\":\"").append(dealNull(dayId)).append("\"");
		buffer.append(",\"heatTime\":\"").append(dealNull(heatTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
