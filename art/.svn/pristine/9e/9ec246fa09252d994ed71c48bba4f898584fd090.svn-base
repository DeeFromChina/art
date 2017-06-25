package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_user_role table.
 */
@Entity  
@Table(name="sys_user_role")  
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "OPER")
   private java.lang.String oper;   //  

   @Column(name = "USER_ID")
   private java.lang.Integer userId;   //  

   @Column(name = "APP_TIME")
   private java.util.Date appTime;   //  

   @Column(name = "APP_NOTE")
   private java.lang.String appNote;   //  


   @Column(name = "STATUS")
   private java.lang.String status;   //  

   @Column(name = "ROLE_ID")
   private java.lang.Integer roleId;   //  

   // Constructors
   public SysUserRole() {
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
    * Return the value associated with the column: OPER
    * Description: 
    */
   public java.lang.String getOper() { 
      return this.oper; 
   }
   /**
    * Set the value related to the column: OPER
    * @param oper is the 'OPER' value
    */
   public void setOper(java.lang.String oper) { 
      this.oper = oper; 
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
    * Return the value associated with the column: APP_TIME
    * Description: 
    */
   public java.util.Date getAppTime() { 
      return this.appTime; 
   }
   /**
    * Set the value related to the column: APP_TIME
    * @param appTime is the 'APP_TIME' value
    */
   public void setAppTime(java.util.Date appTime) { 
      this.appTime = appTime; 
   }

   /**
    * Return the value associated with the column: APP_NOTE
    * Description: 
    */
   public java.lang.String getAppNote() { 
      return this.appNote; 
   }
   /**
    * Set the value related to the column: APP_NOTE
    * @param appNote is the 'APP_NOTE' value
    */
   public void setAppNote(java.lang.String appNote) { 
      this.appNote = appNote; 
   }

   /**
    * Return the value associated with the column: STATUS
    * Description: 
    */
   public java.lang.String getStatus() { 
      return this.status; 
   }
   /**
    * Set the value related to the column: STATUS
    * @param status is the 'STATUS' value
    */
   public void setStatus(java.lang.String status) { 
      this.status = status; 
   }

   /**
    * Return the value associated with the column: ROLE_ID
    * Description: 
    */
   public java.lang.Integer getRoleId() { 
      return this.roleId; 
   }
   /**
    * Set the value related to the column: ROLE_ID
    * @param roleId is the 'ROLE_ID' value
    */
   public void setRoleId(java.lang.Integer roleId) { 
      this.roleId = roleId; 
   }


   public static String REF_CLASS = "SysUserRole";
   public static String PROP_OPER = "oper";
   public static String PROP_USER_ID = "userId";
   public static String PROP_APP_TIME = "appTime";
   public static String PROP_APP_NOTE = "appNote";
   public static String PROP_ID = "id";
   public static String PROP_STATUS = "status";
   public static String PROP_ROLE_ID = "roleId";

   public static String REF_TABLE = "sys_user_role";
   public static String COL_OPER = "OPER";
   public static String COL_USER_ID = "USER_ID";
   public static String COL_APP_TIME = "APP_TIME";
   public static String COL_APP_NOTE = "APP_NOTE";
   public static String COL_ID = "ID";
   public static String COL_STATUS = "STATUS";
   public static String COL_ROLE_ID = "ROLE_ID";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysUserRole)) return false;
      else {
         com.golead.common.model.SysUserRole o = (com.golead.common.model.SysUserRole) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysUserRole:");
		buffer.append(" id:").append(id);
		buffer.append(" oper:").append(dealNull(oper));
		buffer.append(" userId:").append(dealNull(userId));
		buffer.append(" appTime:").append(dealNull(appTime));
		buffer.append(" appNote:").append(dealNull(appNote));
		buffer.append(" status:").append(dealNull(status));
		buffer.append(" roleId:").append(dealNull(roleId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"oper\":\"").append(dealNull(oper)).append("\"");
		buffer.append(",\"userId\":\"").append(dealNull(userId)).append("\"");
		buffer.append(",\"appTime\":\"").append(dealNull(appTime)).append("\"");
		buffer.append(",\"appNote\":\"").append(dealNull(appNote)).append("\"");
		buffer.append(",\"status\":\"").append(dealNull(status)).append("\"");
		buffer.append(",\"roleId\":\"").append(dealNull(roleId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
