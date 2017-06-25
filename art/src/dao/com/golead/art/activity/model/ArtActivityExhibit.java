package com.golead.art.activity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_activity_exhibit table.
 */
@Entity  
@Table(name="art_activity_exhibit")  
public class ArtActivityExhibit implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "curator")
   private java.lang.String curator;   // 策展人

   @Column(name = "exhibit_name")
   private java.lang.String exhibitName;   // 名称

   @Column(name = "exhibitors")
   private java.lang.Integer exhibitors;   // 机构

   @Column(name = "country_id")
   private java.lang.Integer countryId;   // 国家

   @Column(name = "activity_year")
   private java.lang.Integer activityYear;   // 时间年份

   @Column(name = "activity_month")
   private java.lang.Integer activityMonth;   // 月份

   @Column(name = "exhib_type")
   private java.lang.String exhibType;   // 展览类别，1：个展，2：群展，代码集：EXHIB_TYPE

   @Column(name = "city")
   private java.lang.String city;   // 城市

   // Constructors
   public ArtActivityExhibit() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getCurator() { 
      return this.curator; 
   }
   public void setCurator(java.lang.String curator) { 
      this.curator = curator; 
   }


   public java.lang.String getExhibitName() { 
      return this.exhibitName; 
   }
   public void setExhibitName(java.lang.String exhibitName) { 
      this.exhibitName = exhibitName; 
   }


   public java.lang.Integer getExhibitors() { 
      return this.exhibitors; 
   }
   public void setExhibitors(java.lang.Integer exhibitors) { 
      this.exhibitors = exhibitors; 
   }


   public java.lang.Integer getCountryId() { 
      return this.countryId; 
   }
   public void setCountryId(java.lang.Integer countryId) { 
      this.countryId = countryId; 
   }


   public java.lang.Integer getActivityYear() { 
      return this.activityYear; 
   }
   public void setActivityYear(java.lang.Integer activityYear) { 
      this.activityYear = activityYear; 
   }


   public java.lang.Integer getActivityMonth() { 
      return this.activityMonth; 
   }
   public void setActivityMonth(java.lang.Integer activityMonth) { 
      this.activityMonth = activityMonth; 
   }


   public java.lang.String getExhibType() { 
      return this.exhibType; 
   }
   public void setExhibType(java.lang.String exhibType) { 
      this.exhibType = exhibType; 
   }


   public java.lang.String getCity() { 
      return this.city; 
   }
   public void setCity(java.lang.String city) { 
      this.city = city; 
   }


   public static String REF_CLASS = "ArtActivityExhibit";
   public static String PROP_ID = "id";
   public static String PROP_CURATOR = "curator";
   public static String PROP_EXHIBIT_NAME = "exhibitName";
   public static String PROP_EXHIBITORS = "exhibitors";
   public static String PROP_COUNTRY_ID = "countryId";
   public static String PROP_ACTIVITY_YEAR = "activityYear";
   public static String PROP_ACTIVITY_MONTH = "activityMonth";
   public static String PROP_EXHIB_TYPE = "exhibType";
   public static String PROP_CITY = "city";

   public static String REF_TABLE = "art_activity_exhibit";
   public static String COL_ID = "id";
   public static String COL_CURATOR = "curator";
   public static String COL_EXHIBIT_NAME = "exhibit_name";
   public static String COL_EXHIBITORS = "exhibitors";
   public static String COL_COUNTRY_ID = "country_id";
   public static String COL_ACTIVITY_YEAR = "activity_year";
   public static String COL_ACTIVITY_MONTH = "activity_month";
   public static String COL_EXHIB_TYPE = "exhib_type";
   public static String COL_CITY = "city";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.activity.model.ArtActivityExhibit)) return false;
      else {
         com.golead.art.activity.model.ArtActivityExhibit o = (com.golead.art.activity.model.ArtActivityExhibit) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtActivityExhibit:");
		buffer.append(" id:").append(id);
		buffer.append(" curator:").append(dealNull(curator));
		buffer.append(" exhibitName:").append(dealNull(exhibitName));
		buffer.append(" exhibitors:").append(dealNull(exhibitors));
		buffer.append(" countryId:").append(dealNull(countryId));
		buffer.append(" activityYear:").append(dealNull(activityYear));
		buffer.append(" activityMonth:").append(dealNull(activityMonth));
		buffer.append(" exhibType:").append(dealNull(exhibType));
		buffer.append(" city:").append(dealNull(city));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"curator\":\"").append(dealNull(curator)).append("\"");
		buffer.append(",\"exhibitName\":\"").append(dealNull(exhibitName)).append("\"");
		buffer.append(",\"exhibitors\":\"").append(dealNull(exhibitors)).append("\"");
		buffer.append(",\"countryId\":\"").append(dealNull(countryId)).append("\"");
		buffer.append(",\"activityYear\":\"").append(dealNull(activityYear)).append("\"");
		buffer.append(",\"activityMonth\":\"").append(dealNull(activityMonth)).append("\"");
		buffer.append(",\"exhibType\":\"").append(dealNull(exhibType)).append("\"");
		buffer.append(",\"city\":\"").append(dealNull(city)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
