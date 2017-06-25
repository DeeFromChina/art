package com.golead.art.artist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_country table.
 */
@Entity  
@Table(name="art_country")  
public class ArtCountry implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "country_desc")
   private java.lang.String countryDesc;   // 描述

   @Column(name = "country_name")
   private java.lang.String countryName;   // 国家名称

   // Constructors
   public ArtCountry() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getCountryDesc() { 
      return this.countryDesc; 
   }
   public void setCountryDesc(java.lang.String countryDesc) { 
      this.countryDesc = countryDesc; 
   }


   public java.lang.String getCountryName() { 
      return this.countryName; 
   }
   public void setCountryName(java.lang.String countryName) { 
      this.countryName = countryName; 
   }


   public static String REF_CLASS = "ArtCountry";
   public static String PROP_ID = "id";
   public static String PROP_COUNTRY_DESC = "countryDesc";
   public static String PROP_COUNTRY_NAME = "countryName";

   public static String REF_TABLE = "art_country";
   public static String COL_ID = "id";
   public static String COL_COUNTRY_DESC = "country_desc";
   public static String COL_COUNTRY_NAME = "country_name";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.artist.model.ArtCountry)) return false;
      else {
         com.golead.art.artist.model.ArtCountry o = (com.golead.art.artist.model.ArtCountry) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtCountry:");
		buffer.append(" id:").append(id);
		buffer.append(" countryDesc:").append(dealNull(countryDesc));
		buffer.append(" countryName:").append(dealNull(countryName));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"countryDesc\":\"").append(dealNull(countryDesc)).append("\"");
		buffer.append(",\"countryName\":\"").append(dealNull(countryName)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
