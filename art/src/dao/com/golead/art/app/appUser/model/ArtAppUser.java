package com.golead.art.app.appUser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_app_user table.
 */
@Entity  
@Table(name="art_app_user")  
public class ArtAppUser implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "wetchat")
   private java.lang.String wetchat;   // 微信号

   @Column(name = "sex")
   private java.lang.String sex;   // 性别

   @Column(name = "phone_number")
   private java.lang.Integer phoneNumber;   // 电话号码

   @Column(name = "no_comment")
   private java.lang.String noComment;   // 禁言（0:否

   @Column(name = "reg_time")
   private java.util.Date regTime;   // 注册时间

   @Column(name = "user_status")
   private java.lang.String userStatus;   // 状态(1启用，停用0)

   @Column(name = "photo")
   private java.lang.String photo;   // 用户头像

   @Column(name = "password")
   private java.lang.String password;   // 密码

   @Column(name = "recomment_time")
   private java.util.Date recommentTime;   // 重新发言时间

   @Column(name = "account_name")
   private java.lang.String accountName;   // 用户账号


   @Column(name = "user_name")
   private java.lang.String userName;   // 用户昵称

   @Column(name = "area")
   private java.lang.String area;   // 地区

   @Column(name = "email")
   private java.lang.String email;   // 邮件

   @Column(name = "reopen_time")
   private java.util.Date reopenTime;   // 重新启用时间
   
   @Column(name = "reason")
   private java.lang.String reason;   // 禁言/停用原因

   // Constructors
   public ArtAppUser() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getWetchat() { 
      return this.wetchat; 
   }
   public void setWetchat(java.lang.String wetchat) { 
      this.wetchat = wetchat; 
   }


   public java.lang.String getSex() { 
      return this.sex; 
   }
   public void setSex(java.lang.String sex) { 
      this.sex = sex; 
   }


   public java.lang.Integer getPhoneNumber() { 
      return this.phoneNumber; 
   }
   public void setPhoneNumber(java.lang.Integer phoneNumber) { 
      this.phoneNumber = phoneNumber; 
   }


   public java.lang.String getNoComment() { 
      return this.noComment; 
   }
   public void setNoComment(java.lang.String noComment) { 
      this.noComment = noComment; 
   }


   public java.util.Date getRegTime() { 
      return this.regTime; 
   }
   public void setRegTime(java.util.Date regTime) { 
      this.regTime = regTime; 
   }


   public java.lang.String getUserStatus() { 
      return this.userStatus; 
   }
   public void setUserStatus(java.lang.String userStatus) { 
      this.userStatus = userStatus; 
   }


   public java.lang.String getPhoto() { 
      return this.photo; 
   }
   public void setPhoto(java.lang.String photo) { 
      this.photo = photo; 
   }


   public java.lang.String getPassword() { 
      return this.password; 
   }
   public void setPassword(java.lang.String password) { 
      this.password = password; 
   }


   public java.util.Date getRecommentTime() { 
      return this.recommentTime; 
   }
   public void setRecommentTime(java.util.Date recommentTime) { 
      this.recommentTime = recommentTime; 
   }


   public java.lang.String getAccountName() { 
      return this.accountName; 
   }
   public void setAccountName(java.lang.String accountName) { 
      this.accountName = accountName; 
   }


   public java.lang.String getUserName() { 
      return this.userName; 
   }
   public void setUserName(java.lang.String userName) { 
      this.userName = userName; 
   }


   public java.lang.String getArea() { 
      return this.area; 
   }
   public void setArea(java.lang.String area) { 
      this.area = area; 
   }


   public java.lang.String getEmail() { 
      return this.email; 
   }
   public void setEmail(java.lang.String email) { 
      this.email = email; 
   }


   public java.util.Date getReopenTime() { 
      return this.reopenTime; 
   }
   public void setReopenTime(java.util.Date reopenTime) { 
      this.reopenTime = reopenTime; 
   }


   public java.lang.String getReason() {
      return reason;
   }

   public void setReason(java.lang.String reason) {
      this.reason = reason;
   }


   public static String REF_CLASS = "ArtAppUser";
   public static String PROP_WETCHAT = "wetchat";
   public static String PROP_SEX = "sex";
   public static String PROP_PHONE_NUMBER = "phoneNumber";
   public static String PROP_NO_COMMENT = "noComment";
   public static String PROP_REG_TIME = "regTime";
   public static String PROP_USER_STATUS = "userStatus";
   public static String PROP_PHOTO = "photo";
   public static String PROP_PASSWORD = "password";
   public static String PROP_RECOMMENT_TIME = "recommentTime";
   public static String PROP_ACCOUNT_NAME = "accountName";
   public static String PROP_ID = "id";
   public static String PROP_USER_NAME = "userName";
   public static String PROP_AREA = "area";
   public static String PROP_EMAIL = "email";
   public static String PROP_REOPEN_TIME = "reopenTime";
   public static String PROP_REASON = "reason";

   public static String REF_TABLE = "art_app_user";
   public static String COL_WETCHAT = "wetchat";
   public static String COL_SEX = "sex";
   public static String COL_PHONE_NUMBER = "phone_number";
   public static String COL_NO_COMMENT = "no_comment";
   public static String COL_REG_TIME = "reg_time";
   public static String COL_USER_STATUS = "user_status";
   public static String COL_PHOTO = "photo";
   public static String COL_PASSWORD = "password";
   public static String COL_RECOMMENT_TIME = "recomment_time";
   public static String COL_ACCOUNT_NAME = "account_name";
   public static String COL_ID = "id";
   public static String COL_USER_NAME = "user_name";
   public static String COL_AREA = "area";
   public static String COL_EMAIL = "email";
   public static String COL_REOPEN_TIME = "reopen_time";
   public static String COL_REASON = "reason";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.appUser.model.ArtAppUser)) return false;
      else {
         com.golead.art.app.appUser.model.ArtAppUser o = (com.golead.art.app.appUser.model.ArtAppUser) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtAppUser:");
		buffer.append(" id:").append(id);
		buffer.append(" wetchat:").append(dealNull(wetchat));
		buffer.append(" sex:").append(dealNull(sex));
		buffer.append(" phoneNumber:").append(dealNull(phoneNumber));
		buffer.append(" noComment:").append(dealNull(noComment));
		buffer.append(" regTime:").append(dealNull(regTime));
		buffer.append(" userStatus:").append(dealNull(userStatus));
		buffer.append(" photo:").append(dealNull(photo));
		buffer.append(" password:").append(dealNull(password));
		buffer.append(" recommentTime:").append(dealNull(recommentTime));
		buffer.append(" accountName:").append(dealNull(accountName));
		buffer.append(" userName:").append(dealNull(userName));
		buffer.append(" area:").append(dealNull(area));
		buffer.append(" email:").append(dealNull(email));
		buffer.append(" reopenTime:").append(dealNull(reopenTime));
		buffer.append(" reason:").append(dealNull(reason));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"wetchat\":\"").append(dealNull(wetchat)).append("\"");
		buffer.append(",\"sex\":\"").append(dealNull(sex)).append("\"");
		buffer.append(",\"phoneNumber\":\"").append(dealNull(phoneNumber)).append("\"");
		buffer.append(",\"noComment\":\"").append(dealNull(noComment)).append("\"");
		buffer.append(",\"regTime\":\"").append(dealNull(regTime)).append("\"");
		buffer.append(",\"userStatus\":\"").append(dealNull(userStatus)).append("\"");
		buffer.append(",\"photo\":\"").append(dealNull(photo)).append("\"");
		buffer.append(",\"password\":\"").append(dealNull(password)).append("\"");
		buffer.append(",\"recommentTime\":\"").append(dealNull(recommentTime)).append("\"");
		buffer.append(",\"accountName\":\"").append(dealNull(accountName)).append("\"");
		buffer.append(",\"userName\":\"").append(dealNull(userName)).append("\"");
		buffer.append(",\"area\":\"").append(dealNull(area)).append("\"");
		buffer.append(",\"email\":\"").append(dealNull(email)).append("\"");
		buffer.append(",\"reopenTime\":\"").append(dealNull(reopenTime)).append("\"");
		buffer.append(",\"reason\":\"").append(dealNull(reason)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
