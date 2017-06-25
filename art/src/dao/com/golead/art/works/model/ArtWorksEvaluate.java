package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_evaluate table.
 */
@Entity  
@Table(name="art_works_evaluate")  
public class ArtWorksEvaluate implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "evaluate")
   private java.lang.String evaluate;   // 评价

   @Column(name = "evaluate_type")
   private java.lang.String evaluateType;   // 评价类型，代码集：EVAL_TYPE

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   // Constructors
   public ArtWorksEvaluate() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getEvaluate() { 
      return this.evaluate; 
   }
   public void setEvaluate(java.lang.String evaluate) { 
      this.evaluate = evaluate; 
   }


   public java.lang.String getEvaluateType() { 
      return this.evaluateType; 
   }
   public void setEvaluateType(java.lang.String evaluateType) { 
      this.evaluateType = evaluateType; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public static String REF_CLASS = "ArtWorksEvaluate";
   public static String PROP_ID = "id";
   public static String PROP_EVALUATE = "evaluate";
   public static String PROP_EVALUATE_TYPE = "evaluateType";
   public static String PROP_WORKS_ID = "worksId";

   public static String REF_TABLE = "art_works_evaluate";
   public static String COL_ID = "id";
   public static String COL_EVALUATE = "evaluate";
   public static String COL_EVALUATE_TYPE = "evaluate_type";
   public static String COL_WORKS_ID = "works_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksEvaluate)) return false;
      else {
         com.golead.art.works.model.ArtWorksEvaluate o = (com.golead.art.works.model.ArtWorksEvaluate) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksEvaluate:");
		buffer.append(" id:").append(id);
		buffer.append(" evaluate:").append(dealNull(evaluate));
		buffer.append(" evaluateType:").append(dealNull(evaluateType));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"evaluate\":\"").append(dealNull(evaluate)).append("\"");
		buffer.append(",\"evaluateType\":\"").append(dealNull(evaluateType)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
