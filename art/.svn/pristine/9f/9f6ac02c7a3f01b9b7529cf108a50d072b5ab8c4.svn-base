package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_sys_log table.
 */
@Entity  
@Table(name="art_sys_log")  
public class ArtSysLog implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "oper_result")
   private java.lang.String operResult;   // 结果

   @Column(name = "oper_date")
   private java.util.Date operDate;   //  

   @Column(name = "oper_function")
   private java.lang.String operFunction;   // 功能

   @Column(name = "operator")
   private java.lang.String operator;   // 操作人

   @Column(name = "oper_module")
   private java.lang.String operModule;   // 模块

   // Constructors
   public ArtSysLog() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getOperResult() { 
      return this.operResult; 
   }
   public void setOperResult(java.lang.String operResult) { 
      this.operResult = operResult; 
   }


   public java.util.Date getOperDate() { 
      return this.operDate; 
   }
   public void setOperDate(java.util.Date operDate) { 
      this.operDate = operDate; 
   }


   public java.lang.String getOperFunction() { 
      return this.operFunction; 
   }
   public void setOperFunction(java.lang.String operFunction) { 
      this.operFunction = operFunction; 
   }


   public java.lang.String getOperator() { 
      return this.operator; 
   }
   public void setOperator(java.lang.String operator) { 
      this.operator = operator; 
   }


   public java.lang.String getOperModule() { 
      return this.operModule; 
   }
   public void setOperModule(java.lang.String operModule) { 
      this.operModule = operModule; 
   }


   public static String REF_CLASS = "ArtSysLog";
   public static String PROP_ID = "id";
   public static String PROP_OPER_RESULT = "operResult";
   public static String PROP_OPER_DATE = "operDate";
   public static String PROP_OPER_FUNCTION = "operFunction";
   public static String PROP_OPERATOR = "operator";
   public static String PROP_OPER_MODULE = "operModule";

   public static String REF_TABLE = "art_sys_log";
   public static String COL_ID = "id";
   public static String COL_OPER_RESULT = "oper_result";
   public static String COL_OPER_DATE = "oper_date";
   public static String COL_OPER_FUNCTION = "oper_function";
   public static String COL_OPERATOR = "operator";
   public static String COL_OPER_MODULE = "oper_module";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtSysLog)) return false;
      else {
         com.golead.art.works.model.ArtSysLog o = (com.golead.art.works.model.ArtSysLog) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtSysLog:");
		buffer.append(" id:").append(id);
		buffer.append(" operResult:").append(dealNull(operResult));
		buffer.append(" operDate:").append(dealNull(operDate));
		buffer.append(" operFunction:").append(dealNull(operFunction));
		buffer.append(" operator:").append(dealNull(operator));
		buffer.append(" operModule:").append(dealNull(operModule));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"operResult\":\"").append(dealNull(operResult)).append("\"");
		buffer.append(",\"operDate\":\"").append(dealNull(operDate)).append("\"");
		buffer.append(",\"operFunction\":\"").append(dealNull(operFunction)).append("\"");
		buffer.append(",\"operator\":\"").append(dealNull(operator)).append("\"");
		buffer.append(",\"operModule\":\"").append(dealNull(operModule)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
