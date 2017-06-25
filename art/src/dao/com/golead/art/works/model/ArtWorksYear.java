package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_year table.
 */
@Entity  
@Table(name="art_works_year")  
public class ArtWorksYear implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "year_important")
   private java.lang.String yearImportant;   // 重要度

   @Column(name = "start_year")
   private java.lang.String startYear;   // 开始年份


   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家id

   @Column(name = "end_year")
   private java.lang.String endYear;   // 结束年份

   // Constructors
   public ArtWorksYear() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getYearImportant() { 
      return this.yearImportant; 
   }
   public void setYearImportant(java.lang.String yearImportant) { 
      this.yearImportant = yearImportant; 
   }


   public java.lang.String getStartYear() { 
      return this.startYear; 
   }
   public void setStartYear(java.lang.String startYear) { 
      this.startYear = startYear; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getEndYear() { 
      return this.endYear; 
   }
   public void setEndYear(java.lang.String endYear) { 
      this.endYear = endYear; 
   }


   public static String REF_CLASS = "ArtWorksYear";
   public static String PROP_YEAR_IMPORTANT = "yearImportant";
   public static String PROP_START_YEAR = "startYear";
   public static String PROP_ID = "id";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_END_YEAR = "endYear";

   public static String REF_TABLE = "art_works_year";
   public static String COL_YEAR_IMPORTANT = "year_important";
   public static String COL_START_YEAR = "start_year";
   public static String COL_ID = "id";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_END_YEAR = "end_year";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksYear)) return false;
      else {
         com.golead.art.works.model.ArtWorksYear o = (com.golead.art.works.model.ArtWorksYear) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksYear:");
		buffer.append(" id:").append(id);
		buffer.append(" yearImportant:").append(dealNull(yearImportant));
		buffer.append(" startYear:").append(dealNull(startYear));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" endYear:").append(dealNull(endYear));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"yearImportant\":\"").append(dealNull(yearImportant)).append("\"");
		buffer.append(",\"startYear\":\"").append(dealNull(startYear)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"endYear\":\"").append(dealNull(endYear)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
