package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_other table.
 */
@Entity  
@Table(name="art_works_other")  
public class ArtWorksOther implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id


   @Column(name = "other_id")
   private java.lang.Integer otherId;   // 其他收录id

   // Constructors
   public ArtWorksOther() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.Integer getOtherId() { 
      return this.otherId; 
   }
   public void setOtherId(java.lang.Integer otherId) { 
      this.otherId = otherId; 
   }


   public static String REF_CLASS = "ArtWorksOther";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_ID = "id";
   public static String PROP_OTHER_ID = "otherId";

   public static String REF_TABLE = "art_works_other";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_ID = "id";
   public static String COL_OTHER_ID = "other_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksOther)) return false;
      else {
         com.golead.art.works.model.ArtWorksOther o = (com.golead.art.works.model.ArtWorksOther) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksOther:");
		buffer.append(" id:").append(id);
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" otherId:").append(dealNull(otherId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"otherId\":\"").append(dealNull(otherId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
