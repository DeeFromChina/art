package com.golead.art.literature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_literature_medium table.
 */
@Entity  
@Table(name="art_literature_medium")  
public class ArtLiteratureMedium implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties

   @Column(name = "shot_time")
   private java.lang.String shotTime;   // 拍摄时间

   @Column(name = "person_involved")
   private java.lang.String personInvolved;   // 参与人物，多个以;分开

   @Column(name = "attachment")
   private java.lang.String attachment;   // 附件，多个用;隔开

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   // 艺术家


   @Column(name = "site_link")
   private java.lang.String siteLink;   // 原址链接

   @Column(name = "content_desc")
   private java.lang.String contentDesc;   // 内容描述

   @Column(name = "literature_works")
   private java.lang.String literatureWorks;   // 文献提及作品，多个以;分开

   @Column(name = "related_exhib")
   private java.lang.String relatedExhib;   // 相关展览，多个以;分开

   @Column(name = "related_event")
   private java.lang.String relatedEvent;   // 相关事件，多个以;分开

   @Column(name = "literature_title")
   private java.lang.String literatureTitle;   // 标题

   @Column(name = "when_long")
   private java.lang.String whenLong;   // 时长

   @Column(name = "shot_people")
   private java.lang.String shotPeople;   // 制作方
   
   @Column(name = "attachment_source")
   private java.lang.String attachmentSource;   // 附件来源

   // Constructors
   public ArtLiteratureMedium() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getShotTime() { 
      return this.shotTime; 
   }
   public void setShotTime(java.lang.String shotTime) { 
      this.shotTime = shotTime; 
   }


   public java.lang.String getPersonInvolved() { 
      return this.personInvolved; 
   }
   public void setPersonInvolved(java.lang.String personInvolved) { 
      this.personInvolved = personInvolved; 
   }


   public java.lang.String getAttachment() { 
      return this.attachment; 
   }
   public void setAttachment(java.lang.String attachment) { 
      this.attachment = attachment; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getSiteLink() { 
      return this.siteLink; 
   }
   public void setSiteLink(java.lang.String siteLink) { 
      this.siteLink = siteLink; 
   }


   public java.lang.String getContentDesc() { 
      return this.contentDesc; 
   }
   public void setContentDesc(java.lang.String contentDesc) { 
      this.contentDesc = contentDesc; 
   }


   public java.lang.String getLiteratureWorks() { 
      return this.literatureWorks; 
   }
   public void setLiteratureWorks(java.lang.String literatureWorks) { 
      this.literatureWorks = literatureWorks; 
   }


   public java.lang.String getRelatedExhib() { 
      return this.relatedExhib; 
   }
   public void setRelatedExhib(java.lang.String relatedExhib) { 
      this.relatedExhib = relatedExhib; 
   }


   public java.lang.String getRelatedEvent() { 
      return this.relatedEvent; 
   }
   public void setRelatedEvent(java.lang.String relatedEvent) { 
      this.relatedEvent = relatedEvent; 
   }


   public java.lang.String getLiteratureTitle() { 
      return this.literatureTitle; 
   }
   public void setLiteratureTitle(java.lang.String literatureTitle) { 
      this.literatureTitle = literatureTitle; 
   }


   public java.lang.String getWhenLong() { 
      return this.whenLong; 
   }
   public void setWhenLong(java.lang.String whenLong) { 
      this.whenLong = whenLong; 
   }


   public java.lang.String getShotPeople() { 
      return this.shotPeople; 
   }
   public void setShotPeople(java.lang.String shotPeople) { 
      this.shotPeople = shotPeople; 
   }


   public java.lang.String getAttachmentSource() {
      return attachmentSource;
   }

   public void setAttachmentSource(java.lang.String attachmentSource) {
      this.attachmentSource = attachmentSource;
   }


   public static String REF_CLASS = "ArtLiteratureMedium";
   public static String PROP_SHOT_TIME = "shotTime";
   public static String PROP_PERSON_INVOLVED = "personInvolved";
   public static String PROP_ATTACHMENT = "attachment";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_ID = "id";
   public static String PROP_SITE_LINK = "siteLink";
   public static String PROP_CONTENT_DESC = "contentDesc";
   public static String PROP_LITERATURE_WORKS = "literatureWorks";
   public static String PROP_RELATED_EXHIB = "relatedExhib";
   public static String PROP_RELATED_EVENT = "relatedEvent";
   public static String PROP_LITERATURE_TITLE = "literatureTitle";
   public static String PROP_WHEN_LONG = "whenLong";
   public static String PROP_SHOT_PEOPLE = "shotPeople";
   public static String PROP_ATTACHMENT_SOURCE = "attachmentSource";

   public static String REF_TABLE = "art_literature_medium";
   public static String COL_SHOT_TIME = "shot_time";
   public static String COL_PERSON_INVOLVED = "person_involved";
   public static String COL_ATTACHMENT = "attachment";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_ID = "id";
   public static String COL_SITE_LINK = "site_link";
   public static String COL_CONTENT_DESC = "content_desc";
   public static String COL_LITERATURE_WORKS = "literature_works";
   public static String COL_RELATED_EXHIB = "related_exhib";
   public static String COL_RELATED_EVENT = "related_event";
   public static String COL_LITERATURE_TITLE = "literature_title";
   public static String COL_WHEN_LONG = "when_long";
   public static String COL_SHOT_PEOPLE = "shot_people";
   public static String COL_ATTACHMENT_SOURCE = "attachment_source";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.literature.model.ArtLiteratureMedium)) return false;
      else {
         com.golead.art.literature.model.ArtLiteratureMedium o = (com.golead.art.literature.model.ArtLiteratureMedium) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtLiteratureMedium:");
		buffer.append(" id:").append(id);
		buffer.append(" shotTime:").append(dealNull(shotTime));
		buffer.append(" personInvolved:").append(dealNull(personInvolved));
		buffer.append(" attachment:").append(dealNull(attachment));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" siteLink:").append(dealNull(siteLink));
		buffer.append(" contentDesc:").append(dealNull(contentDesc));
		buffer.append(" literatureWorks:").append(dealNull(literatureWorks));
		buffer.append(" relatedExhib:").append(dealNull(relatedExhib));
		buffer.append(" relatedEvent:").append(dealNull(relatedEvent));
		buffer.append(" literatureTitle:").append(dealNull(literatureTitle));
		buffer.append(" whenLong:").append(dealNull(whenLong));
		buffer.append(" shotPeople:").append(dealNull(shotPeople));
		buffer.append(" attachmentSource:").append(dealNull(attachmentSource));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"shotTime\":\"").append(dealNull(shotTime)).append("\"");
		buffer.append(",\"personInvolved\":\"").append(dealNull(personInvolved)).append("\"");
		buffer.append(",\"attachment\":\"").append(dealNull(attachment)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"siteLink\":\"").append(dealNull(siteLink)).append("\"");
		buffer.append(",\"contentDesc\":\"").append(dealNull(contentDesc)).append("\"");
		buffer.append(",\"literatureWorks\":\"").append(dealNull(literatureWorks)).append("\"");
		buffer.append(",\"relatedExhib\":\"").append(dealNull(relatedExhib)).append("\"");
		buffer.append(",\"relatedEvent\":\"").append(dealNull(relatedEvent)).append("\"");
		buffer.append(",\"literatureTitle\":\"").append(dealNull(literatureTitle)).append("\"");
		buffer.append(",\"whenLong\":\"").append(dealNull(whenLong)).append("\"");
		buffer.append(",\"shotPeople\":\"").append(dealNull(shotPeople)).append("\"");
		buffer.append(",\"attachmentSource\":\"").append(dealNull(attachmentSource)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
