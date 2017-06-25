package com.golead.art.activity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_agency table.
 */
@Entity  
@Table(name="art_agency")  
public class ArtAgency implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "agency_type")
   private java.lang.String agencyType;   // 机构类型：1:画廊，2：美术馆，9：其他

   @Column(name = "agency_c_name")
   private java.lang.String agencyCName;   // 机构中文名

   @Column(name = "agency_e_name")
   private java.lang.String agencyEName;   // 机构英文名

   @Column(name = "country_id")
   private java.lang.Integer countryId;   // 国家

   @Column(name = "city")
   private java.lang.String city;   // 城市

   // Constructors
   public ArtAgency() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getAgencyType() { 
      return this.agencyType; 
   }
   public void setAgencyType(java.lang.String agencyType) { 
      this.agencyType = agencyType; 
   }


   public java.lang.String getAgencyCName() { 
      return this.agencyCName; 
   }
   public void setAgencyCName(java.lang.String agencyCName) { 
      this.agencyCName = agencyCName; 
   }


   public java.lang.String getAgencyEName() { 
      return this.agencyEName; 
   }
   public void setAgencyEName(java.lang.String agencyEName) { 
      this.agencyEName = agencyEName; 
   }


   public java.lang.Integer getCountryId() { 
      return this.countryId; 
   }
   public void setCountryId(java.lang.Integer countryId) { 
      this.countryId = countryId; 
   }


   public java.lang.String getCity() { 
      return this.city; 
   }
   public void setCity(java.lang.String city) { 
      this.city = city; 
   }


   public static String REF_CLASS = "ArtAgency";
   public static String PROP_ID = "id";
   public static String PROP_AGENCY_TYPE = "agencyType";
   public static String PROP_AGENCY_C_NAME = "agencyCName";
   public static String PROP_AGENCY_E_NAME = "agencyEName";
   public static String PROP_COUNTRY_ID = "countryId";
   public static String PROP_CITY = "city";

   public static String REF_TABLE = "art_agency";
   public static String COL_ID = "id";
   public static String COL_AGENCY_TYPE = "agency_type";
   public static String COL_AGENCY_C_NAME = "agency_c_name";
   public static String COL_AGENCY_E_NAME = "agency_e_name";
   public static String COL_COUNTRY_ID = "country_id";
   public static String COL_CITY = "city";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.activity.model.ArtAgency)) return false;
      else {
         com.golead.art.activity.model.ArtAgency o = (com.golead.art.activity.model.ArtAgency) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtAgency:");
		buffer.append(" id:").append(id);
		buffer.append(" agencyType:").append(dealNull(agencyType));
		buffer.append(" agencyCName:").append(dealNull(agencyCName));
		buffer.append(" agencyEName:").append(dealNull(agencyEName));
		buffer.append(" countryId:").append(dealNull(countryId));
		buffer.append(" city:").append(dealNull(city));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"agencyType\":\"").append(dealNull(agencyType)).append("\"");
		buffer.append(",\"agencyCName\":\"").append(dealNull(agencyCName)).append("\"");
		buffer.append(",\"agencyEName\":\"").append(dealNull(agencyEName)).append("\"");
		buffer.append(",\"countryId\":\"").append(dealNull(countryId)).append("\"");
		buffer.append(",\"city\":\"").append(dealNull(city)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
