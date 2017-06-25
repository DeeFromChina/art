package com.golead.art.app.commentary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_commentary table.
 */
@Entity  
@Table(name="art_commentary")  
public class ArtCommentary implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties


   @Column(name = "content")
   private java.lang.String content;   // 内容

   @Column(name = "app_user_id")
   private java.lang.Integer appUserId;   // app用户id

   @Column(name = "commentary_time")
   private java.util.Date commentaryTime;   // 评论时间

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "create_time")
   private java.util.Date createTime;   // 创建时间

   @Column(name = "user_id")
   private java.lang.Integer userId;   // 审批人id

   @Column(name = "comment_type")
   private java.lang.String commentType;   // 类型：0:留言 1:意见反馈

   @Column(name = "give_num")
   private java.lang.Integer giveNum;   // 评论点赞数

   @Column(name = "commentary_status")
   private java.lang.String commentaryStatus;   // 评论状态（0待审批，1通过，2不通过）

   // Constructors
   public ArtCommentary() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getContent() { 
      return this.content; 
   }
   public void setContent(java.lang.String content) { 
      this.content = content; 
   }


   public java.lang.Integer getAppUserId() { 
      return this.appUserId; 
   }
   public void setAppUserId(java.lang.Integer appUserId) { 
      this.appUserId = appUserId; 
   }


   public java.util.Date getCommentaryTime() { 
      return this.commentaryTime; 
   }
   public void setCommentaryTime(java.util.Date commentaryTime) { 
      this.commentaryTime = commentaryTime; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.util.Date getCreateTime() { 
      return this.createTime; 
   }
   public void setCreateTime(java.util.Date createTime) { 
      this.createTime = createTime; 
   }


   public java.lang.Integer getUserId() { 
      return this.userId; 
   }
   public void setUserId(java.lang.Integer userId) { 
      this.userId = userId; 
   }


   public java.lang.String getCommentType() { 
      return this.commentType; 
   }
   public void setCommentType(java.lang.String commentType) { 
      this.commentType = commentType; 
   }


   public java.lang.Integer getGiveNum() { 
      return this.giveNum; 
   }
   public void setGiveNum(java.lang.Integer giveNum) { 
      this.giveNum = giveNum; 
   }


   public java.lang.String getCommentaryStatus() { 
      return this.commentaryStatus; 
   }
   public void setCommentaryStatus(java.lang.String commentaryStatus) { 
      this.commentaryStatus = commentaryStatus; 
   }


   public static String REF_CLASS = "ArtCommentary";
   public static String PROP_ID = "id";
   public static String PROP_CONTENT = "content";
   public static String PROP_APP_USER_ID = "appUserId";
   public static String PROP_COMMENTARY_TIME = "commentaryTime";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_CREATE_TIME = "createTime";
   public static String PROP_USER_ID = "userId";
   public static String PROP_COMMENT_TYPE = "commentType";
   public static String PROP_GIVE_NUM = "giveNum";
   public static String PROP_COMMENTARY_STATUS = "commentaryStatus";

   public static String REF_TABLE = "art_commentary";
   public static String COL_ID = "id";
   public static String COL_CONTENT = "content";
   public static String COL_APP_USER_ID = "app_user_id";
   public static String COL_COMMENTARY_TIME = "commentary_time";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_CREATE_TIME = "create_time";
   public static String COL_USER_ID = "user_id";
   public static String COL_COMMENT_TYPE = "comment_type";
   public static String COL_GIVE_NUM = "give_num";
   public static String COL_COMMENTARY_STATUS = "commentary_status";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.app.commentary.model.ArtCommentary)) return false;
      else {
         com.golead.art.app.commentary.model.ArtCommentary o = (com.golead.art.app.commentary.model.ArtCommentary) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtCommentary:");
		buffer.append(" id:").append(id);
		buffer.append(" content:").append(dealNull(content));
		buffer.append(" appUserId:").append(dealNull(appUserId));
		buffer.append(" commentaryTime:").append(dealNull(commentaryTime));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" createTime:").append(dealNull(createTime));
		buffer.append(" userId:").append(dealNull(userId));
		buffer.append(" commentType:").append(dealNull(commentType));
		buffer.append(" giveNum:").append(dealNull(giveNum));
		buffer.append(" commentaryStatus:").append(dealNull(commentaryStatus));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"content\":\"").append(dealNull(content)).append("\"");
		buffer.append(",\"appUserId\":\"").append(dealNull(appUserId)).append("\"");
		buffer.append(",\"commentaryTime\":\"").append(dealNull(commentaryTime)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"createTime\":\"").append(dealNull(createTime)).append("\"");
		buffer.append(",\"userId\":\"").append(dealNull(userId)).append("\"");
		buffer.append(",\"commentType\":\"").append(dealNull(commentType)).append("\"");
		buffer.append(",\"giveNum\":\"").append(dealNull(giveNum)).append("\"");
		buffer.append(",\"commentaryStatus\":\"").append(dealNull(commentaryStatus)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
