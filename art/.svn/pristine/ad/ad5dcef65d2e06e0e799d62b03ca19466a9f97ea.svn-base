package com.golead.art.works.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_works_case table.
 */
@Entity  
@Table(name="art_works_case")  
public class ArtWorksCase implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "case_auther")
   private java.lang.String caseAuther;   // 作者

   @Column(name = "works_id")
   private java.lang.Integer worksId;   // 作品id

   @Column(name = "case_name")
   private java.lang.String caseName;   // 个案名称

   @Column(name = "research_topic")
   private java.lang.String researchTopic;   // 研究主题

   @Column(name = "case_time")
   private java.util.Date caseTime;   // 时间

   @Column(name = "attachment")
   private java.lang.String attachment;   // 附件

   @Column(name = "case_content")
   private java.lang.String caseContent;   // 内容

   // Constructors
   public ArtWorksCase() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getCaseAuther() { 
      return this.caseAuther; 
   }
   public void setCaseAuther(java.lang.String caseAuther) { 
      this.caseAuther = caseAuther; 
   }


   public java.lang.Integer getWorksId() { 
      return this.worksId; 
   }
   public void setWorksId(java.lang.Integer worksId) { 
      this.worksId = worksId; 
   }


   public java.lang.String getCaseName() { 
      return this.caseName; 
   }
   public void setCaseName(java.lang.String caseName) { 
      this.caseName = caseName; 
   }


   public java.lang.String getResearchTopic() { 
      return this.researchTopic; 
   }
   public void setResearchTopic(java.lang.String researchTopic) { 
      this.researchTopic = researchTopic; 
   }


   public java.util.Date getCaseTime() { 
      return this.caseTime; 
   }
   public void setCaseTime(java.util.Date caseTime) { 
      this.caseTime = caseTime; 
   }


   public java.lang.String getAttachment() { 
      return this.attachment; 
   }
   public void setAttachment(java.lang.String attachment) { 
      this.attachment = attachment; 
   }


   public java.lang.String getCaseContent() { 
      return this.caseContent; 
   }
   public void setCaseContent(java.lang.String caseContent) { 
      this.caseContent = caseContent; 
   }


   public static String REF_CLASS = "ArtWorksCase";
   public static String PROP_ID = "id";
   public static String PROP_CASE_AUTHER = "caseAuther";
   public static String PROP_WORKS_ID = "worksId";
   public static String PROP_CASE_NAME = "caseName";
   public static String PROP_RESEARCH_TOPIC = "researchTopic";
   public static String PROP_CASE_TIME = "caseTime";
   public static String PROP_ATTACHMENT = "attachment";
   public static String PROP_CASE_CONTENT = "caseContent";

   public static String REF_TABLE = "art_works_case";
   public static String COL_ID = "id";
   public static String COL_CASE_AUTHER = "case_auther";
   public static String COL_WORKS_ID = "works_id";
   public static String COL_CASE_NAME = "case_name";
   public static String COL_RESEARCH_TOPIC = "research_topic";
   public static String COL_CASE_TIME = "case_time";
   public static String COL_ATTACHMENT = "attachment";
   public static String COL_CASE_CONTENT = "case_content";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.works.model.ArtWorksCase)) return false;
      else {
         com.golead.art.works.model.ArtWorksCase o = (com.golead.art.works.model.ArtWorksCase) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtWorksCase:");
		buffer.append(" id:").append(id);
		buffer.append(" caseAuther:").append(dealNull(caseAuther));
		buffer.append(" worksId:").append(dealNull(worksId));
		buffer.append(" caseName:").append(dealNull(caseName));
		buffer.append(" researchTopic:").append(dealNull(researchTopic));
		buffer.append(" caseTime:").append(dealNull(caseTime));
		buffer.append(" attachment:").append(dealNull(attachment));
		buffer.append(" caseContent:").append(dealNull(caseContent));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"caseAuther\":\"").append(dealNull(caseAuther)).append("\"");
		buffer.append(",\"worksId\":\"").append(dealNull(worksId)).append("\"");
		buffer.append(",\"caseName\":\"").append(dealNull(caseName)).append("\"");
		buffer.append(",\"researchTopic\":\"").append(dealNull(researchTopic)).append("\"");
		buffer.append(",\"caseTime\":\"").append(dealNull(caseTime)).append("\"");
		buffer.append(",\"attachment\":\"").append(dealNull(attachment)).append("\"");
		buffer.append(",\"caseContent\":\"").append(dealNull(caseContent)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
