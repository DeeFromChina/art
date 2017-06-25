package com.golead.art.activity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_activity_abmb table.
 */
@Entity  
@Table(name="art_activity_abmb")  
public class ArtActivityAbmb implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "abmb_year")
   private java.lang.Integer abmbYear;   // 开幕时间年

   @Column(name = "art_director")
   private java.lang.String artDirector;   // 艺术总监

   @Column(name = "abmb_month")
   private java.lang.Integer abmbMonth;   // 开幕时间月

   @Column(name = "abmb_number")
   private java.lang.Integer abmbNumber;   // 届数

   @Column(name = "country_id")
   private java.lang.Integer countryId;   // 国家

   @Column(name = "sponsor")
   private java.lang.String sponsor;   // 主办方

   @Column(name = "city")
   private java.lang.String city;   // 城市

   @Column(name = "abmb_name")
   private java.lang.String abmbName;   // 名称

   // Constructors
   public ArtActivityAbmb() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getAbmbYear() { 
      return this.abmbYear; 
   }
   public void setAbmbYear(java.lang.Integer abmbYear) { 
      this.abmbYear = abmbYear; 
   }


   public java.lang.String getArtDirector() { 
      return this.artDirector; 
   }
   public void setArtDirector(java.lang.String artDirector) { 
      this.artDirector = artDirector; 
   }


   public java.lang.Integer getAbmbMonth() { 
      return this.abmbMonth; 
   }
   public void setAbmbMonth(java.lang.Integer abmbMonth) { 
      this.abmbMonth = abmbMonth; 
   }


   public java.lang.Integer getAbmbNumber() { 
      return this.abmbNumber; 
   }
   public void setAbmbNumber(java.lang.Integer abmbNumber) { 
      this.abmbNumber = abmbNumber; 
   }


   public java.lang.Integer getCountryId() { 
      return this.countryId; 
   }
   public void setCountryId(java.lang.Integer countryId) { 
      this.countryId = countryId; 
   }


   public java.lang.String getSponsor() { 
      return this.sponsor; 
   }
   public void setSponsor(java.lang.String sponsor) { 
      this.sponsor = sponsor; 
   }


   public java.lang.String getCity() { 
      return this.city; 
   }
   public void setCity(java.lang.String city) { 
      this.city = city; 
   }


   public java.lang.String getAbmbName() { 
      return this.abmbName; 
   }
   public void setAbmbName(java.lang.String abmbName) { 
      this.abmbName = abmbName; 
   }


   public static String REF_CLASS = "ArtActivityAbmb";
   public static String PROP_ID = "id";
   public static String PROP_ABMB_YEAR = "abmbYear";
   public static String PROP_ART_DIRECTOR = "artDirector";
   public static String PROP_ABMB_MONTH = "abmbMonth";
   public static String PROP_ABMB_NUMBER = "abmbNumber";
   public static String PROP_COUNTRY_ID = "countryId";
   public static String PROP_SPONSOR = "sponsor";
   public static String PROP_CITY = "city";
   public static String PROP_ABMB_NAME = "abmbName";

   public static String REF_TABLE = "art_activity_abmb";
   public static String COL_ID = "id";
   public static String COL_ABMB_YEAR = "abmb_year";
   public static String COL_ART_DIRECTOR = "art_director";
   public static String COL_ABMB_MONTH = "abmb_month";
   public static String COL_ABMB_NUMBER = "abmb_number";
   public static String COL_COUNTRY_ID = "country_id";
   public static String COL_SPONSOR = "sponsor";
   public static String COL_CITY = "city";
   public static String COL_ABMB_NAME = "abmb_name";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.activity.model.ArtActivityAbmb)) return false;
      else {
         com.golead.art.activity.model.ArtActivityAbmb o = (com.golead.art.activity.model.ArtActivityAbmb) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtActivityAbmb:");
		buffer.append(" id:").append(id);
		buffer.append(" abmbYear:").append(dealNull(abmbYear));
		buffer.append(" artDirector:").append(dealNull(artDirector));
		buffer.append(" abmbMonth:").append(dealNull(abmbMonth));
		buffer.append(" abmbNumber:").append(dealNull(abmbNumber));
		buffer.append(" countryId:").append(dealNull(countryId));
		buffer.append(" sponsor:").append(dealNull(sponsor));
		buffer.append(" city:").append(dealNull(city));
		buffer.append(" abmbName:").append(dealNull(abmbName));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"abmbYear\":\"").append(dealNull(abmbYear)).append("\"");
		buffer.append(",\"artDirector\":\"").append(dealNull(artDirector)).append("\"");
		buffer.append(",\"abmbMonth\":\"").append(dealNull(abmbMonth)).append("\"");
		buffer.append(",\"abmbNumber\":\"").append(dealNull(abmbNumber)).append("\"");
		buffer.append(",\"countryId\":\"").append(dealNull(countryId)).append("\"");
		buffer.append(",\"sponsor\":\"").append(dealNull(sponsor)).append("\"");
		buffer.append(",\"city\":\"").append(dealNull(city)).append("\"");
		buffer.append(",\"abmbName\":\"").append(dealNull(abmbName)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
