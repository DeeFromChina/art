package com.golead.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the sys_user table.
 */
@Entity  
@Table(name="sys_user")  
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "ID", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "DEPT_ID")
   private java.lang.Integer deptId;   //  

   @Column(name = "UPDATEDATE")
   private java.util.Date updatedate;   //  

   @Column(name = "ORDER_NO")
   private java.lang.Integer orderNo;   //  

   @Column(name = "REMARK")
   private java.lang.String remark;   //  

   @Column(name = "CHINESE_ACCOUNT")
   private java.lang.String chineseAccount;   //  

   @Column(name = "ACCOUNT_TYPE")
   private java.lang.String accountType;   //  

   @Column(name = "USER_PASSWORD")
   private java.lang.String userPassword;   //  

   @Column(name = "USER_ACCOUNT")
   private java.lang.String userAccount;   //  

   @Column(name = "CA_ACCOUNT")
   private java.lang.String caAccount;   //  

   @Column(name = "ORG_ID")
   private java.lang.Integer orgId;   //  

   @Column(name = "ALP_SEARCH")
   private java.lang.String alpSearch;   //  

   @Column(name = "TEL")
   private java.lang.String tel;   //  

   @Column(name = "USER_NAME")
   private java.lang.String userName;   //  

   @Column(name = "ADMIN_LEVEL")
   private java.lang.String adminLevel;   //  


   @Column(name = "EMAIL")
   private java.lang.String email;   //  

   @Column(name = "USER_STATUS")
   private java.lang.String userStatus;   //  

   // Constructors
   public SysUser() {
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
    * Return the value associated with the column: UPDATEDATE
    * Description: 
    */
   public java.util.Date getUpdatedate() { 
      return this.updatedate; 
   }
   /**
    * Set the value related to the column: UPDATEDATE
    * @param updatedate is the 'UPDATEDATE' value
    */
   public void setUpdatedate(java.util.Date updatedate) { 
      this.updatedate = updatedate; 
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
    * Return the value associated with the column: CHINESE_ACCOUNT
    * Description: 
    */
   public java.lang.String getChineseAccount() { 
      return this.chineseAccount; 
   }
   /**
    * Set the value related to the column: CHINESE_ACCOUNT
    * @param chineseAccount is the 'CHINESE_ACCOUNT' value
    */
   public void setChineseAccount(java.lang.String chineseAccount) { 
      this.chineseAccount = chineseAccount; 
   }

   /**
    * Return the value associated with the column: ACCOUNT_TYPE
    * Description: 
    */
   public java.lang.String getAccountType() { 
      return this.accountType; 
   }
   /**
    * Set the value related to the column: ACCOUNT_TYPE
    * @param accountType is the 'ACCOUNT_TYPE' value
    */
   public void setAccountType(java.lang.String accountType) { 
      this.accountType = accountType; 
   }

   /**
    * Return the value associated with the column: USER_PASSWORD
    * Description: 
    */
   public java.lang.String getUserPassword() { 
      return this.userPassword; 
   }
   /**
    * Set the value related to the column: USER_PASSWORD
    * @param userPassword is the 'USER_PASSWORD' value
    */
   public void setUserPassword(java.lang.String userPassword) { 
      this.userPassword = userPassword; 
   }

   /**
    * Return the value associated with the column: USER_ACCOUNT
    * Description: 
    */
   public java.lang.String getUserAccount() { 
      return this.userAccount; 
   }
   /**
    * Set the value related to the column: USER_ACCOUNT
    * @param userAccount is the 'USER_ACCOUNT' value
    */
   public void setUserAccount(java.lang.String userAccount) { 
      this.userAccount = userAccount; 
   }

   /**
    * Return the value associated with the column: CA_ACCOUNT
    * Description: 
    */
   public java.lang.String getCaAccount() { 
      return this.caAccount; 
   }
   /**
    * Set the value related to the column: CA_ACCOUNT
    * @param caAccount is the 'CA_ACCOUNT' value
    */
   public void setCaAccount(java.lang.String caAccount) { 
      this.caAccount = caAccount; 
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

   /**
    * Return the value associated with the column: ALP_SEARCH
    * Description: 
    */
   public java.lang.String getAlpSearch() { 
      return this.alpSearch; 
   }
   /**
    * Set the value related to the column: ALP_SEARCH
    * @param alpSearch is the 'ALP_SEARCH' value
    */
   public void setAlpSearch(java.lang.String alpSearch) { 
      this.alpSearch = alpSearch; 
   }

   /**
    * Return the value associated with the column: TEL
    * Description: 
    */
   public java.lang.String getTel() { 
      return this.tel; 
   }
   /**
    * Set the value related to the column: TEL
    * @param tel is the 'TEL' value
    */
   public void setTel(java.lang.String tel) { 
      this.tel = tel; 
   }

   /**
    * Return the value associated with the column: USER_NAME
    * Description: 
    */
   public java.lang.String getUserName() { 
      return this.userName; 
   }
   /**
    * Set the value related to the column: USER_NAME
    * @param userName is the 'USER_NAME' value
    */
   public void setUserName(java.lang.String userName) { 
      this.userName = userName; 
   }

   /**
    * Return the value associated with the column: ADMIN_LEVEL
    * Description: 
    */
   public java.lang.String getAdminLevel() { 
      return this.adminLevel; 
   }
   /**
    * Set the value related to the column: ADMIN_LEVEL
    * @param adminLevel is the 'ADMIN_LEVEL' value
    */
   public void setAdminLevel(java.lang.String adminLevel) { 
      this.adminLevel = adminLevel; 
   }

   /**
    * Return the value associated with the column: EMAIL
    * Description: 
    */
   public java.lang.String getEmail() { 
      return this.email; 
   }
   /**
    * Set the value related to the column: EMAIL
    * @param email is the 'EMAIL' value
    */
   public void setEmail(java.lang.String email) { 
      this.email = email; 
   }

   /**
    * Return the value associated with the column: USER_STATUS
    * Description: 
    */
   public java.lang.String getUserStatus() { 
      return this.userStatus; 
   }
   /**
    * Set the value related to the column: USER_STATUS
    * @param userStatus is the 'USER_STATUS' value
    */
   public void setUserStatus(java.lang.String userStatus) { 
      this.userStatus = userStatus; 
   }


   public static String REF_CLASS = "SysUser";
   public static String PROP_DEPT_ID = "deptId";
   public static String PROP_UPDATEDATE = "updatedate";
   public static String PROP_ORDER_NO = "orderNo";
   public static String PROP_REMARK = "remark";
   public static String PROP_CHINESE_ACCOUNT = "chineseAccount";
   public static String PROP_ACCOUNT_TYPE = "accountType";
   public static String PROP_USER_PASSWORD = "userPassword";
   public static String PROP_USER_ACCOUNT = "userAccount";
   public static String PROP_CA_ACCOUNT = "caAccount";
   public static String PROP_ORG_ID = "orgId";
   public static String PROP_ALP_SEARCH = "alpSearch";
   public static String PROP_TEL = "tel";
   public static String PROP_USER_NAME = "userName";
   public static String PROP_ADMIN_LEVEL = "adminLevel";
   public static String PROP_ID = "id";
   public static String PROP_EMAIL = "email";
   public static String PROP_USER_STATUS = "userStatus";

   public static String REF_TABLE = "sys_user";
   public static String COL_DEPT_ID = "DEPT_ID";
   public static String COL_UPDATEDATE = "UPDATEDATE";
   public static String COL_ORDER_NO = "ORDER_NO";
   public static String COL_REMARK = "REMARK";
   public static String COL_CHINESE_ACCOUNT = "CHINESE_ACCOUNT";
   public static String COL_ACCOUNT_TYPE = "ACCOUNT_TYPE";
   public static String COL_USER_PASSWORD = "USER_PASSWORD";
   public static String COL_USER_ACCOUNT = "USER_ACCOUNT";
   public static String COL_CA_ACCOUNT = "CA_ACCOUNT";
   public static String COL_ORG_ID = "ORG_ID";
   public static String COL_ALP_SEARCH = "ALP_SEARCH";
   public static String COL_TEL = "TEL";
   public static String COL_USER_NAME = "USER_NAME";
   public static String COL_ADMIN_LEVEL = "ADMIN_LEVEL";
   public static String COL_ID = "ID";
   public static String COL_EMAIL = "EMAIL";
   public static String COL_USER_STATUS = "USER_STATUS";
   
   @Override
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.common.model.SysUser)) return false;
      else {
         com.golead.common.model.SysUser o = (com.golead.common.model.SysUser) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   @Override
   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SysUser:");
		buffer.append(" id:").append(id);
		buffer.append(" deptId:").append(dealNull(deptId));
		buffer.append(" updatedate:").append(dealNull(updatedate));
		buffer.append(" orderNo:").append(dealNull(orderNo));
		buffer.append(" remark:").append(dealNull(remark));
		buffer.append(" chineseAccount:").append(dealNull(chineseAccount));
		buffer.append(" accountType:").append(dealNull(accountType));
		buffer.append(" userPassword:").append(dealNull(userPassword));
		buffer.append(" userAccount:").append(dealNull(userAccount));
		buffer.append(" caAccount:").append(dealNull(caAccount));
		buffer.append(" orgId:").append(dealNull(orgId));
		buffer.append(" alpSearch:").append(dealNull(alpSearch));
		buffer.append(" tel:").append(dealNull(tel));
		buffer.append(" userName:").append(dealNull(userName));
		buffer.append(" adminLevel:").append(dealNull(adminLevel));
		buffer.append(" email:").append(dealNull(email));
		buffer.append(" userStatus:").append(dealNull(userStatus));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"deptId\":\"").append(dealNull(deptId)).append("\"");
		buffer.append(",\"updatedate\":\"").append(dealNull(updatedate)).append("\"");
		buffer.append(",\"orderNo\":\"").append(dealNull(orderNo)).append("\"");
		buffer.append(",\"remark\":\"").append(dealNull(remark)).append("\"");
		buffer.append(",\"chineseAccount\":\"").append(dealNull(chineseAccount)).append("\"");
		buffer.append(",\"accountType\":\"").append(dealNull(accountType)).append("\"");
		buffer.append(",\"userPassword\":\"").append(dealNull(userPassword)).append("\"");
		buffer.append(",\"userAccount\":\"").append(dealNull(userAccount)).append("\"");
		buffer.append(",\"caAccount\":\"").append(dealNull(caAccount)).append("\"");
		buffer.append(",\"orgId\":\"").append(dealNull(orgId)).append("\"");
		buffer.append(",\"alpSearch\":\"").append(dealNull(alpSearch)).append("\"");
		buffer.append(",\"tel\":\"").append(dealNull(tel)).append("\"");
		buffer.append(",\"userName\":\"").append(dealNull(userName)).append("\"");
		buffer.append(",\"adminLevel\":\"").append(dealNull(adminLevel)).append("\"");
		buffer.append(",\"email\":\"").append(dealNull(email)).append("\"");
		buffer.append(",\"userStatus\":\"").append(dealNull(userStatus)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
