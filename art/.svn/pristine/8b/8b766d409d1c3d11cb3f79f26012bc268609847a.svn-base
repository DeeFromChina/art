package com.golead.art.literature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_literature_network_research table.
 */
@Entity  
@Table(name="art_literature_network_research")  
public class ArtLiteratureNetworkResearch implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "subjective_eval")
   private java.lang.String subjectiveEval;   //  

   @Column(name = "network_id")
   private java.lang.Integer networkId;   // 网媒id

   @Column(name = "objective_eval")
   private java.lang.String objectiveEval;   //  

   @Column(name = "core_thesis")
   private java.lang.String coreThesis;   // 核心论断

   // Constructors
   public ArtLiteratureNetworkResearch() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getSubjectiveEval() { 
      return this.subjectiveEval; 
   }
   public void setSubjectiveEval(java.lang.String subjectiveEval) { 
      this.subjectiveEval = subjectiveEval; 
   }


   public java.lang.Integer getNetworkId() { 
      return this.networkId; 
   }
   public void setNetworkId(java.lang.Integer networkId) { 
      this.networkId = networkId; 
   }


   public java.lang.String getObjectiveEval() { 
      return this.objectiveEval; 
   }
   public void setObjectiveEval(java.lang.String objectiveEval) { 
      this.objectiveEval = objectiveEval; 
   }


   public java.lang.String getCoreThesis() { 
      return this.coreThesis; 
   }
   public void setCoreThesis(java.lang.String coreThesis) { 
      this.coreThesis = coreThesis; 
   }


   public static String REF_CLASS = "ArtLiteratureNetworkResearch";
   public static String PROP_ID = "id";
   public static String PROP_SUBJECTIVE_EVAL = "subjectiveEval";
   public static String PROP_NETWORK_ID = "networkId";
   public static String PROP_OBJECTIVE_EVAL = "objectiveEval";
   public static String PROP_CORE_THESIS = "coreThesis";

   public static String REF_TABLE = "art_literature_network_research";
   public static String COL_ID = "id";
   public static String COL_SUBJECTIVE_EVAL = "subjective_eval";
   public static String COL_NETWORK_ID = "network_id";
   public static String COL_OBJECTIVE_EVAL = "objective_eval";
   public static String COL_CORE_THESIS = "core_thesis";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.literature.model.ArtLiteratureNetworkResearch)) return false;
      else {
         com.golead.art.literature.model.ArtLiteratureNetworkResearch o = (com.golead.art.literature.model.ArtLiteratureNetworkResearch) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtLiteratureNetworkResearch:");
		buffer.append(" id:").append(id);
		buffer.append(" subjectiveEval:").append(dealNull(subjectiveEval));
		buffer.append(" networkId:").append(dealNull(networkId));
		buffer.append(" objectiveEval:").append(dealNull(objectiveEval));
		buffer.append(" coreThesis:").append(dealNull(coreThesis));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"subjectiveEval\":\"").append(dealNull(subjectiveEval)).append("\"");
		buffer.append(",\"networkId\":\"").append(dealNull(networkId)).append("\"");
		buffer.append(",\"objectiveEval\":\"").append(dealNull(objectiveEval)).append("\"");
		buffer.append(",\"coreThesis\":\"").append(dealNull(coreThesis)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
