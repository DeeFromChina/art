package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_artist_works_series table.
 */
@Entity  
@Table(name="art_artist_works_series")  
public class ArtArtistWorksSeries implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "series_theme")
   private java.lang.String seriesTheme;   // 系列题材类型

   @Column(name = "series_important")
   private java.lang.String seriesImportant;   // 系列重要度

   @Column(name = "series_name")
   private java.lang.String seriesName;   // 系列名称

   @Column(name = "series_period")
   private java.lang.String seriesPeriod;   // 系列时期类型


   @Column(name = "descript")
   private java.lang.String descript;   // 系列描述及评价

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "appear_year")
   private java.lang.String appearYear;   // 系列出现年份

   // Constructors
   public ArtArtistWorksSeries() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getSeriesTheme() { 
      return this.seriesTheme; 
   }
   public void setSeriesTheme(java.lang.String seriesTheme) { 
      this.seriesTheme = seriesTheme; 
   }


   public java.lang.String getSeriesImportant() { 
      return this.seriesImportant; 
   }
   public void setSeriesImportant(java.lang.String seriesImportant) { 
      this.seriesImportant = seriesImportant; 
   }


   public java.lang.String getSeriesName() { 
      return this.seriesName; 
   }
   public void setSeriesName(java.lang.String seriesName) { 
      this.seriesName = seriesName; 
   }


   public java.lang.String getSeriesPeriod() { 
      return this.seriesPeriod; 
   }
   public void setSeriesPeriod(java.lang.String seriesPeriod) { 
      this.seriesPeriod = seriesPeriod; 
   }


   public java.lang.String getDescript() { 
      return this.descript; 
   }
   public void setDescript(java.lang.String descript) { 
      this.descript = descript; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getAppearYear() { 
      return this.appearYear; 
   }
   public void setAppearYear(java.lang.String appearYear) { 
      this.appearYear = appearYear; 
   }


   public static String REF_CLASS = "ArtArtistWorksSeries";
   public static String PROP_SERIES_THEME = "seriesTheme";
   public static String PROP_SERIES_IMPORTANT = "seriesImportant";
   public static String PROP_SERIES_NAME = "seriesName";
   public static String PROP_SERIES_PERIOD = "seriesPeriod";
   public static String PROP_ID = "id";
   public static String PROP_DESCRIPT = "descript";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_APPEAR_YEAR = "appearYear";

   public static String REF_TABLE = "art_artist_works_series";
   public static String COL_SERIES_THEME = "series_theme";
   public static String COL_SERIES_IMPORTANT = "series_important";
   public static String COL_SERIES_NAME = "series_name";
   public static String COL_SERIES_PERIOD = "series_period";
   public static String COL_ID = "id";
   public static String COL_DESCRIPT = "descript";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_APPEAR_YEAR = "appear_year";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtArtistWorksSeries)) return false;
      else {
         com.golead.art.artist.model.ArtArtistWorksSeries o = (com.golead.art.artist.model.ArtArtistWorksSeries) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtArtistWorksSeries:");
		buffer.append(" id:").append(id);
		buffer.append(" seriesTheme:").append(dealNull(seriesTheme));
		buffer.append(" seriesImportant:").append(dealNull(seriesImportant));
		buffer.append(" seriesName:").append(dealNull(seriesName));
		buffer.append(" seriesPeriod:").append(dealNull(seriesPeriod));
		buffer.append(" descript:").append(dealNull(descript));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" appearYear:").append(dealNull(appearYear));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"seriesTheme\":\"").append(dealNull(seriesTheme)).append("\"");
		buffer.append(",\"seriesImportant\":\"").append(dealNull(seriesImportant)).append("\"");
		buffer.append(",\"seriesName\":\"").append(dealNull(seriesName)).append("\"");
		buffer.append(",\"seriesPeriod\":\"").append(dealNull(seriesPeriod)).append("\"");
		buffer.append(",\"descript\":\"").append(dealNull(descript)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"appearYear\":\"").append(dealNull(appearYear)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
