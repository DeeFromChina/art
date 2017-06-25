package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_network table.
 */
@Entity  
@Table(name="art_works_network")  
public class ArtWorksNetwork implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "network_id")
   private java.lang.Integer networkId;   // 网媒ID

   @Column(name = "network_desc")
   private java.lang.String networkDesc;   // 描述

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   // Constructors
   public ArtWorksNetwork() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getNetworkId() { 
      return this.networkId; 
   }
   public void setNetworkId(java.lang.Integer networkId) { 
      this.networkId = networkId; 
   }


   public java.lang.String getNetworkDesc() { 
      return this.networkDesc; 
   }
   public void setNetworkDesc(java.lang.String networkDesc) { 
      this.networkDesc = networkDesc; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public static String REF_CLASS = "ArtWorksNetwork";
   public static String PROP_ID = "id";
   public static String PROP_NETWORK_ID = "networkId";
   public static String PROP_NETWORK_DESC = "networkDesc";
   public static String PROP_WORKS_ID = "worksId";

   public static String REF_TABLE = "art_works_network";
   public static String COL_ID = "id";
   public static String COL_NETWORK_ID = "network_id";
   public static String COL_NETWORK_DESC = "network_desc";
   public static String COL_WORKS_ID = "works_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksNetwork)) return false;
      else {
         com.golead.art.works.model.ArtWorksNetwork o = (com.golead.art.works.model.ArtWorksNetwork) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksNetwork:");
		buffer.append(" id:").append(id);
		buffer.append(" networkId:").append(dealNull(networkId));
		buffer.append(" networkDesc:").append(dealNull(networkDesc));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"networkId\":\"").append(dealNull(networkId)).append("\"");
		buffer.append(",\"networkDesc\":\"").append(dealNull(networkDesc)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
