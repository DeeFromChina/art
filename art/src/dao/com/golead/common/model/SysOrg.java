package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_org table.
 */
@Entity  
@Table(name="sys_org")  
public class SysOrg implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "UP_ORG_ID")
   private java.lang.Integer upOrgId;   //  

   @Column(name = "ORG_NAME")
   private java.lang.String orgName;   //  

   @Column(name = "ORG_TYPE")
   private java.lang.String orgType;   //  

   @Column(name = "TREE_LEVEL")
   private java.lang.Integer treeLevel;   //  


   @Column(name = "ORG_STATUS")
   private java.lang.String orgStatus;   //  

   @Column(name = "ORDER_NO")
   private java.lang.Integer orderNo;   //  

   @Column(name = "TREE_CODE")
   private java.lang.String treeCode;   //  

   @Column(name = "REMARK")
   private java.lang.String remark;   //  

   @Column(name = "ORG_CODE")
   private java.lang.String orgCode;   //  

   @Column(name = "ORG_ABBR")
   private java.lang.String orgAbbr;   //  

   // Constructors
   public SysOrg() {
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
    * Return the value associated with the column: UP_ORG_ID
    * Description: 
    */
   public java.lang.Integer getUpOrgId() { 
      return this.upOrgId; 
   }
   /**
    * Set the value related to the column: UP_ORG_ID
    * @param upOrgId is the 'UP_ORG_ID' value
    */
   public void setUpOrgId(java.lang.Integer upOrgId) { 
      this.upOrgId = upOrgId; 
   }

   /**
    * Return the value associated with the column: ORG_NAME
    * Description: 
    */
   public java.lang.String getOrgName() { 
      return this.orgName; 
   }
   /**
    * Set the value related to the column: ORG_NAME
    * @param orgName is the 'ORG_NAME' value
    */
   public void setOrgName(java.lang.String orgName) { 
      this.orgName = orgName; 
   }

   /**
    * Return the value associated with the column: ORG_TYPE
    * Description: 
    */
   public java.lang.String getOrgType() { 
      return this.orgType; 
   }
   /**
    * Set the value related to the column: ORG_TYPE
    * @param orgType is the 'ORG_TYPE' value
    */
   public void setOrgType(java.lang.String orgType) { 
      this.orgType = orgType; 
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
    * Return the value associated with the column: ORG_STATUS
    * Description: 
    */
   public java.lang.String getOrgStatus() { 
      return this.orgStatus; 
   }
   /**
    * Set the value related to the column: ORG_STATUS
    * @param orgStatus is the 'ORG_STATUS' value
    */
   public void setOrgStatus(java.lang.String orgStatus) { 
      this.orgStatus = orgStatus; 
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
    * Return the value associated with the column: ORG_CODE
    * Description: 
    */
   public java.lang.String getOrgCode() { 
      return this.orgCode; 
   }
   /**
    * Set the value related to the column: ORG_CODE
    * @param orgCode is the 'ORG_CODE' value
    */
   public void setOrgCode(java.lang.String orgCode) { 
      this.orgCode = orgCode; 
   }

   /**
    * Return the value associated with the column: ORG_ABBR
    * Description: 
    */
   public java.lang.String getOrgAbbr() { 
      return this.orgAbbr; 
   }
   /**
    * Set the value related to the column: ORG_ABBR
    * @param orgAbbr is the 'ORG_ABBR' value
    */
   public void setOrgAbbr(java.lang.String orgAbbr) { 
      this.orgAbbr = orgAbbr; 
   }


   public static String REF_CLASS = "SysOrg";
   public static String PROP_UP_ORG_ID = "upOrgId";
   public static String PROP_ORG_NAME = "orgName";
   public static String PROP_ORG_TYPE = "orgType";
   public static String PROP_TREE_LEVEL = "treeLevel";
   public static String PROP_ID = "id";
   public static String PROP_ORG_STATUS = "orgStatus";
   public static String PROP_ORDER_NO = "orderNo";
   public static String PROP_TREE_CODE = "treeCode";
   public static String PROP_REMARK = "remark";
   public static String PROP_ORG_CODE = "orgCode";
   public static String PROP_ORG_ABBR = "orgAbbr";

   public static String REF_TABLE = "sys_org";
   public static String COL_UP_ORG_ID = "UP_ORG_ID";
   public static String COL_ORG_NAME = "ORG_NAME";
   public static String COL_ORG_TYPE = "ORG_TYPE";
   public static String COL_TREE_LEVEL = "TREE_LEVEL";
   public static String COL_ID = "ID";
   public static String COL_ORG_STATUS = "ORG_STATUS";
   public static String COL_ORDER_NO = "ORDER_NO";
   public static String COL_TREE_CODE = "TREE_CODE";
   public static String COL_REMARK = "REMARK";
   public static String COL_ORG_CODE = "ORG_CODE";
   public static String COL_ORG_ABBR = "ORG_ABBR";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysOrg)) return false;
      else {
         com.golead.common.model.SysOrg o = (com.golead.common.model.SysOrg) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysOrg:");
		buffer.append(" id:").append(id);
		buffer.append(" upOrgId:").append(dealNull(upOrgId));
		buffer.append(" orgName:").append(dealNull(orgName));
		buffer.append(" orgType:").append(dealNull(orgType));
		buffer.append(" treeLevel:").append(dealNull(treeLevel));
		buffer.append(" orgStatus:").append(dealNull(orgStatus));
		buffer.append(" orderNo:").append(dealNull(orderNo));
		buffer.append(" treeCode:").append(dealNull(treeCode));
		buffer.append(" remark:").append(dealNull(remark));
		buffer.append(" orgCode:").append(dealNull(orgCode));
		buffer.append(" orgAbbr:").append(dealNull(orgAbbr));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"upOrgId\":\"").append(dealNull(upOrgId)).append("\"");
		buffer.append(",\"orgName\":\"").append(dealNull(orgName)).append("\"");
		buffer.append(",\"orgType\":\"").append(dealNull(orgType)).append("\"");
		buffer.append(",\"treeLevel\":\"").append(dealNull(treeLevel)).append("\"");
		buffer.append(",\"orgStatus\":\"").append(dealNull(orgStatus)).append("\"");
		buffer.append(",\"orderNo\":\"").append(dealNull(orderNo)).append("\"");
		buffer.append(",\"treeCode\":\"").append(dealNull(treeCode)).append("\"");
		buffer.append(",\"remark\":\"").append(dealNull(remark)).append("\"");
		buffer.append(",\"orgCode\":\"").append(dealNull(orgCode)).append("\"");
		buffer.append(",\"orgAbbr\":\"").append(dealNull(orgAbbr)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
