package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_dept table.
 */
@Entity  
@Table(name="sys_dept")  
public class SysDept implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "LEADER_USER_ID")
   private java.lang.Integer leaderUserId;   //  

   @Column(name = "DEPT_STATUS")
   private java.lang.String deptStatus;   //  

   @Column(name = "TREE_LEVEL")
   private java.lang.Integer treeLevel;   //  


   @Column(name = "ORDER_NO")
   private java.lang.Integer orderNo;   //  

   @Column(name = "TREE_CODE")
   private java.lang.String treeCode;   //  

   @Column(name = "DEPT_CODE")
   private java.lang.String deptCode;   //  

   @Column(name = "REMARK")
   private java.lang.String remark;   //  

   @Column(name = "DEPT_ABBR")
   private java.lang.String deptAbbr;   //  

   @Column(name = "DEPT_NAME")
   private java.lang.String deptName;   //  

   @Column(name = "UP_DEPT_ID")
   private java.lang.String upDeptId;   //  

   @Column(name = "ORG_ID")
   private java.lang.Integer orgId;   //  

   // Constructors
   public SysDept() {
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
    * Return the value associated with the column: LEADER_USER_ID
    * Description: 
    */
   public java.lang.Integer getLeaderUserId() { 
      return this.leaderUserId; 
   }
   /**
    * Set the value related to the column: LEADER_USER_ID
    * @param leaderUserId is the 'LEADER_USER_ID' value
    */
   public void setLeaderUserId(java.lang.Integer leaderUserId) { 
      this.leaderUserId = leaderUserId; 
   }

   /**
    * Return the value associated with the column: DEPT_STATUS
    * Description: 
    */
   public java.lang.String getDeptStatus() { 
      return this.deptStatus; 
   }
   /**
    * Set the value related to the column: DEPT_STATUS
    * @param deptStatus is the 'DEPT_STATUS' value
    */
   public void setDeptStatus(java.lang.String deptStatus) { 
      this.deptStatus = deptStatus; 
   }

   /**
    * Return the value associated with the column: TREE_LEVEL
    * Description: 
    */
   public java.lang.Integer getTreeLevel() { 
      return this.treeLevel; 
   }
   /**
    * Set the value related to the column: TREE_LEVEL
    * @param treeLevel is the 'TREE_LEVEL' value
    */
   public void setTreeLevel(java.lang.Integer treeLevel) { 
      this.treeLevel = treeLevel; 
   }

   /**
    * Return the value associated with the column: ORDER_NO
    * Description: 
    */
   public java.lang.Integer getOrderNo() { 
      return this.orderNo; 
   }
   /**
    * Set the value related to the column: ORDER_NO
    * @param orderNo is the 'ORDER_NO' value
    */
   public void setOrderNo(java.lang.Integer orderNo) { 
      this.orderNo = orderNo; 
   }

   /**
    * Return the value associated with the column: TREE_CODE
    * Description: 
    */
   public java.lang.String getTreeCode() { 
      return this.treeCode; 
   }
   /**
    * Set the value related to the column: TREE_CODE
    * @param treeCode is the 'TREE_CODE' value
    */
   public void setTreeCode(java.lang.String treeCode) { 
      this.treeCode = treeCode; 
   }

   /**
    * Return the value associated with the column: DEPT_CODE
    * Description: 
    */
   public java.lang.String getDeptCode() { 
      return this.deptCode; 
   }
   /**
    * Set the value related to the column: DEPT_CODE
    * @param deptCode is the 'DEPT_CODE' value
    */
   public void setDeptCode(java.lang.String deptCode) { 
      this.deptCode = deptCode; 
   }

   /**
    * Return the value associated with the column: REMARK
    * Description: 
    */
   public java.lang.String getRemark() { 
      return this.remark; 
   }
   /**
    * Set the value related to the column: REMARK
    * @param remark is the 'REMARK' value
    */
   public void setRemark(java.lang.String remark) { 
      this.remark = remark; 
   }

   /**
    * Return the value associated with the column: DEPT_ABBR
    * Description: 
    */
   public java.lang.String getDeptAbbr() { 
      return this.deptAbbr; 
   }
   /**
    * Set the value related to the column: DEPT_ABBR
    * @param deptAbbr is the 'DEPT_ABBR' value
    */
   public void setDeptAbbr(java.lang.String deptAbbr) { 
      this.deptAbbr = deptAbbr; 
   }

   /**
    * Return the value associated with the column: DEPT_NAME
    * Description: 
    */
   public java.lang.String getDeptName() { 
      return this.deptName; 
   }
   /**
    * Set the value related to the column: DEPT_NAME
    * @param deptName is the 'DEPT_NAME' value
    */
   public void setDeptName(java.lang.String deptName) { 
      this.deptName = deptName; 
   }

   /**
    * Return the value associated with the column: UP_DEPT_ID
    * Description: 
    */
   public java.lang.String getUpDeptId() { 
      return this.upDeptId; 
   }
   /**
    * Set the value related to the column: UP_DEPT_ID
    * @param upDeptId is the 'UP_DEPT_ID' value
    */
   public void setUpDeptId(java.lang.String upDeptId) { 
      this.upDeptId = upDeptId; 
   }

   /**
    * Return the value associated with the column: ORG_ID
    * Description: 
    */
   public java.lang.Integer getOrgId() { 
      return this.orgId; 
   }
   /**
    * Set the value related to the column: ORG_ID
    * @param orgId is the 'ORG_ID' value
    */
   public void setOrgId(java.lang.Integer orgId) { 
      this.orgId = orgId; 
   }


   public static String REF_CLASS = "SysDept";
   public static String PROP_LEADER_USER_ID = "leaderUserId";
   public static String PROP_DEPT_STATUS = "deptStatus";
   public static String PROP_TREE_LEVEL = "treeLevel";
   public static String PROP_ID = "id";
   public static String PROP_ORDER_NO = "orderNo";
   public static String PROP_TREE_CODE = "treeCode";
   public static String PROP_DEPT_CODE = "deptCode";
   public static String PROP_REMARK = "remark";
   public static String PROP_DEPT_ABBR = "deptAbbr";
   public static String PROP_DEPT_NAME = "deptName";
   public static String PROP_UP_DEPT_ID = "upDeptId";
   public static String PROP_ORG_ID = "orgId";

   public static String REF_TABLE = "sys_dept";
   public static String COL_LEADER_USER_ID = "LEADER_USER_ID";
   public static String COL_DEPT_STATUS = "DEPT_STATUS";
   public static String COL_TREE_LEVEL = "TREE_LEVEL";
   public static String COL_ID = "ID";
   public static String COL_ORDER_NO = "ORDER_NO";
   public static String COL_TREE_CODE = "TREE_CODE";
   public static String COL_DEPT_CODE = "DEPT_CODE";
   public static String COL_REMARK = "REMARK";
   public static String COL_DEPT_ABBR = "DEPT_ABBR";
   public static String COL_DEPT_NAME = "DEPT_NAME";
   public static String COL_UP_DEPT_ID = "UP_DEPT_ID";
   public static String COL_ORG_ID = "ORG_ID";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysDept)) return false;
      else {
         com.golead.common.model.SysDept o = (com.golead.common.model.SysDept) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysDept:");
		buffer.append(" id:").append(id);
		buffer.append(" leaderUserId:").append(dealNull(leaderUserId));
		buffer.append(" deptStatus:").append(dealNull(deptStatus));
		buffer.append(" treeLevel:").append(dealNull(treeLevel));
		buffer.append(" orderNo:").append(dealNull(orderNo));
		buffer.append(" treeCode:").append(dealNull(treeCode));
		buffer.append(" deptCode:").append(dealNull(deptCode));
		buffer.append(" remark:").append(dealNull(remark));
		buffer.append(" deptAbbr:").append(dealNull(deptAbbr));
		buffer.append(" deptName:").append(dealNull(deptName));
		buffer.append(" upDeptId:").append(dealNull(upDeptId));
		buffer.append(" orgId:").append(dealNull(orgId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"leaderUserId\":\"").append(dealNull(leaderUserId)).append("\"");
		buffer.append(",\"deptStatus\":\"").append(dealNull(deptStatus)).append("\"");
		buffer.append(",\"treeLevel\":\"").append(dealNull(treeLevel)).append("\"");
		buffer.append(",\"orderNo\":\"").append(dealNull(orderNo)).append("\"");
		buffer.append(",\"treeCode\":\"").append(dealNull(treeCode)).append("\"");
		buffer.append(",\"deptCode\":\"").append(dealNull(deptCode)).append("\"");
		buffer.append(",\"remark\":\"").append(dealNull(remark)).append("\"");
		buffer.append(",\"deptAbbr\":\"").append(dealNull(deptAbbr)).append("\"");
		buffer.append(",\"deptName\":\"").append(dealNull(deptName)).append("\"");
		buffer.append(",\"upDeptId\":\"").append(dealNull(upDeptId)).append("\"");
		buffer.append(",\"orgId\":\"").append(dealNull(orgId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
