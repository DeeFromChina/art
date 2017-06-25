package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_property table.
 */
@Entity  
@Table(name="sys_property")  
public class SysProperty implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "PROPERTY_VALUE")
   private java.lang.String propertyValue;   //  

   @Column(name = "USER_ID")
   private java.lang.Integer userId;   //  


   @Column(name = "PROPERTY_KEY")
   private java.lang.String propertyKey;   //  

   // Constructors
   public SysProperty() {
   }

   /**
    * The unique identifier of this class.
    * Return the value associated with the column: ID
    *  
    */
   public java.lang.Integer getId() { 
      return this.id; 
   }
   /**
    * The unique identifier of this class.
    * Set the value related to the column: ID
    * @param id is the 'ID' value
    */
   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }

   /**
    * Return the value associated with the column: PROPERTY_VALUE
    * Description: 
    */
   public java.lang.String getPropertyValue() { 
      return this.propertyValue; 
   }
   /**
    * Set the value related to the column: PROPERTY_VALUE
    * @param propertyValue is the 'PROPERTY_VALUE' value
    */
   public void setPropertyValue(java.lang.String propertyValue) { 
      this.propertyValue = propertyValue; 
   }

   /**
    * Return the value associated with the column: USER_ID
    * Description: 
    */
   public java.lang.Integer getUserId() { 
      return this.userId; 
   }
   /**
    * Set the value related to the column: USER_ID
    * @param userId is the 'USER_ID' value
    */
   public void setUserId(java.lang.Integer userId) { 
      this.userId = userId; 
   }

   /**
    * Return the value associated with the column: PROPERTY_KEY
    * Description: 
    */
   public java.lang.String getPropertyKey() { 
      return this.propertyKey; 
   }
   /**
    * Set the value related to the column: PROPERTY_KEY
    * @param propertyKey is the 'PROPERTY_KEY' value
    */
   public void setPropertyKey(java.lang.String propertyKey) { 
      this.propertyKey = propertyKey; 
   }


   public static String REF_CLASS = "SysProperty";
   public static String PROP_PROPERTY_VALUE = "propertyValue";
   public static String PROP_USER_ID = "userId";
   public static String PROP_ID = "id";
   public static String PROP_PROPERTY_KEY = "propertyKey";

   public static String REF_TABLE = "sys_property";
   public static String COL_PROPERTY_VALUE = "PROPERTY_VALUE";
   public static String COL_USER_ID = "USER_ID";
   public static String COL_ID = "ID";
   public static String COL_PROPERTY_KEY = "PROPERTY_KEY";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysProperty)) return false;
      else {
         com.golead.common.model.SysProperty o = (com.golead.common.model.SysProperty) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysProperty:");
		buffer.append(" id:").append(id);
		buffer.append(" propertyValue:").append(dealNull(propertyValue));
		buffer.append(" userId:").append(dealNull(userId));
		buffer.append(" propertyKey:").append(dealNull(propertyKey));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"propertyValue\":\"").append(dealNull(propertyValue)).append("\"");
		buffer.append(",\"userId\":\"").append(dealNull(userId)).append("\"");
		buffer.append(",\"propertyKey\":\"").append(dealNull(propertyKey)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
