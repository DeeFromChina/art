package com.golead.art.literature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_literature_other table.
 */
@Entity  
@Table(name="art_literature_other")  
public class ArtLiteratureOther implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // id

   // properties

   @Column(name = "relevant_pages")
   private java.lang.String relevantPages;   //  

   @Column(name = "attachment")
   private java.lang.String attachment;   //  

   @Column(name = "publication_period")
   private java.lang.String publicationPeriod;   //  

   @Column(name = "auther")
   private java.lang.String auther;   //  

   @Column(name = "pub_name")
   private java.lang.String pubName;   //  


   @Column(name = "attachment_source")
   private java.lang.String attachmentSource;   //  

   @Column(name = "literature_title")
   private java.lang.String literatureTitle;   //  

   @Column(name = "press")
   private java.lang.String press;   //  

   @Column(name = "artist_id")
   private java.lang.Integer artistId;   //  

   @Column(name = "currer_time")
   private java.lang.String currerTime;   //  

   // Constructors
   public ArtLiteratureOther() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getRelevantPages() { 
      return this.relevantPages; 
   }
   public void setRelevantPages(java.lang.String relevantPages) { 
      this.relevantPages = relevantPages; 
   }


   public java.lang.String getAttachment() { 
      return this.attachment; 
   }
   public void setAttachment(java.lang.String attachment) { 
      this.attachment = attachment; 
   }


   public java.lang.String getPublicationPeriod() { 
      return this.publicationPeriod; 
   }
   public void setPublicationPeriod(java.lang.String publicationPeriod) { 
      this.publicationPeriod = publicationPeriod; 
   }


   public java.lang.String getAuther() { 
      return this.auther; 
   }
   public void setAuther(java.lang.String auther) { 
      this.auther = auther; 
   }


   public java.lang.String getPubName() { 
      return this.pubName; 
   }
   public void setPubName(java.lang.String pubName) { 
      this.pubName = pubName; 
   }


   public java.lang.String getAttachmentSource() { 
      return this.attachmentSource; 
   }
   public void setAttachmentSource(java.lang.String attachmentSource) { 
      this.attachmentSource = attachmentSource; 
   }


   public java.lang.String getLiteratureTitle() { 
      return this.literatureTitle; 
   }
   public void setLiteratureTitle(java.lang.String literatureTitle) { 
      this.literatureTitle = literatureTitle; 
   }


   public java.lang.String getPress() { 
      return this.press; 
   }
   public void setPress(java.lang.String press) { 
      this.press = press; 
   }


   public java.lang.Integer getArtistId() { 
      return this.artistId; 
   }
   public void setArtistId(java.lang.Integer artistId) { 
      this.artistId = artistId; 
   }


   public java.lang.String getCurrerTime() { 
      return this.currerTime; 
   }
   public void setCurrerTime(java.lang.String currerTime) { 
      this.currerTime = currerTime; 
   }


   public static String REF_CLASS = "ArtLiteratureOther";
   public static String PROP_RELEVANT_PAGES = "relevantPages";
   public static String PROP_ATTACHMENT = "attachment";
   public static String PROP_PUBLICATION_PERIOD = "publicationPeriod";
   public static String PROP_AUTHER = "auther";
   public static String PROP_PUB_NAME = "pubName";
   public static String PROP_ID = "id";
   public static String PROP_ATTACHMENT_SOURCE = "attachmentSource";
   public static String PROP_LITERATURE_TITLE = "literatureTitle";
   public static String PROP_PRESS = "press";
   public static String PROP_ARTIST_ID = "artistId";
   public static String PROP_CURRER_TIME = "currerTime";

   public static String REF_TABLE = "art_literature_other";
   public static String COL_RELEVANT_PAGES = "relevant_pages";
   public static String COL_ATTACHMENT = "attachment";
   public static String COL_PUBLICATION_PERIOD = "publication_period";
   public static String COL_AUTHER = "auther";
   public static String COL_PUB_NAME = "pub_name";
   public static String COL_ID = "id";
   public static String COL_ATTACHMENT_SOURCE = "attachment_source";
   public static String COL_LITERATURE_TITLE = "literature_title";
   public static String COL_PRESS = "press";
   public static String COL_ARTIST_ID = "artist_id";
   public static String COL_CURRER_TIME = "currer_time";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.literature.model.ArtLiteratureOther)) return false;
      else {
         com.golead.art.literature.model.ArtLiteratureOther o = (com.golead.art.literature.model.ArtLiteratureOther) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtLiteratureOther:");
		buffer.append(" id:").append(id);
		buffer.append(" relevantPages:").append(dealNull(relevantPages));
		buffer.append(" attachment:").append(dealNull(attachment));
		buffer.append(" publicationPeriod:").append(dealNull(publicationPeriod));
		buffer.append(" auther:").append(dealNull(auther));
		buffer.append(" pubName:").append(dealNull(pubName));
		buffer.append(" attachmentSource:").append(dealNull(attachmentSource));
		buffer.append(" literatureTitle:").append(dealNull(literatureTitle));
		buffer.append(" press:").append(dealNull(press));
		buffer.append(" artistId:").append(dealNull(artistId));
		buffer.append(" currerTime:").append(dealNull(currerTime));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"relevantPages\":\"").append(dealNull(relevantPages)).append("\"");
		buffer.append(",\"attachment\":\"").append(dealNull(attachment)).append("\"");
		buffer.append(",\"publicationPeriod\":\"").append(dealNull(publicationPeriod)).append("\"");
		buffer.append(",\"auther\":\"").append(dealNull(auther)).append("\"");
		buffer.append(",\"pubName\":\"").append(dealNull(pubName)).append("\"");
		buffer.append(",\"attachmentSource\":\"").append(dealNull(attachmentSource)).append("\"");
		buffer.append(",\"literatureTitle\":\"").append(dealNull(literatureTitle)).append("\"");
		buffer.append(",\"press\":\"").append(dealNull(press)).append("\"");
		buffer.append(",\"artistId\":\"").append(dealNull(artistId)).append("\"");
		buffer.append(",\"currerTime\":\"").append(dealNull(currerTime)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
