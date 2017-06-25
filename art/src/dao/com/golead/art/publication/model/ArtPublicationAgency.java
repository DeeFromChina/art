package com.golead.art.publication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_publication_agency table.
 */
@Entity  
@Table(name="art_publication_agency")  
public class ArtPublicationAgency implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "publication_id")
   private java.lang.Integer publicationId;   // 出版物id

   @Column(name = "agency_id")
   private java.lang.Integer agencyId;   // 机构id


   // Constructors
   public ArtPublicationAgency() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getPublicationId() { 
      return this.publicationId; 
   }
   public void setPublicationId(java.lang.Integer publicationId) { 
      this.publicationId = publicationId; 
   }


   public java.lang.Integer getAgencyId() { 
      return this.agencyId; 
   }
   public void setAgencyId(java.lang.Integer agencyId) { 
      this.agencyId = agencyId; 
   }


   public static String REF_CLASS = "ArtPublicationAgency";
   public static String PROP_PUBLICATION_ID = "publicationId";
   public static String PROP_AGENCY_ID = "agencyId";
   public static String PROP_ID = "id";

   public static String REF_TABLE = "art_publication_agency";
   public static String COL_PUBLICATION_ID = "publication_id";
   public static String COL_AGENCY_ID = "agency_id";
   public static String COL_ID = "id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.publication.model.ArtPublicationAgency)) return false;
      else {
         com.golead.art.publication.model.ArtPublicationAgency o = (com.golead.art.publication.model.ArtPublicationAgency) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtPublicationAgency:");
		buffer.append(" id:").append(id);
		buffer.append(" publicationId:").append(dealNull(publicationId));
		buffer.append(" agencyId:").append(dealNull(agencyId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"publicationId\":\"").append(dealNull(publicationId)).append("\"");
		buffer.append(",\"agencyId\":\"").append(dealNull(agencyId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
