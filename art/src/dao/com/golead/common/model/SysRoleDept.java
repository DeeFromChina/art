package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_role_dept table.
 */
@Entity  
@Table(name="sys_role_dept")  
public class SysRoleDept implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "DEPT_ID")
   private java.lang.Integer deptId;   //  


   @Column(name = "ROLE_ID")
   private java.lang.Integer roleId;   //  

   // Constructors
   public SysRoleDept() {
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
    * Return the value associated with the column: DEPT_ID
    * Description: 
    */
   public java.lang.Integer getDeptId() { 
      return this.deptId; 
   }
   /**
    * Set the value related to the column: DEPT_ID
    * @param deptId is the 'DEPT_ID' value
    */
   public void setDeptId(java.lang.Integer deptId) { 
      this.deptId = deptId; 
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


   public static String REF_CLASS = "SysRoleDept";
   public static String PROP_DEPT_ID = "deptId";
   public static String PROP_ID = "id";
   public static String PROP_ROLE_ID = "roleId";

   public static String REF_TABLE = "sys_role_dept";
   public static String COL_DEPT_ID = "DEPT_ID";
   public static String COL_ID = "ID";
   public static String COL_ROLE_ID = "ROLE_ID";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysRoleDept)) return false;
      else {
         com.golead.common.model.SysRoleDept o = (com.golead.common.model.SysRoleDept) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysRoleDept:");
		buffer.append(" id:").append(id);
		buffer.append(" deptId:").append(dealNull(deptId));
		buffer.append(" roleId:").append(dealNull(roleId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"deptId\":\"").append(dealNull(deptId)).append("\"");
		buffer.append(",\"roleId\":\"").append(dealNull(roleId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
