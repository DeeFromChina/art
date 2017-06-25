package com.golead.art.auction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the art_auction_houses table.
 */
@Entity  
@Table(name="art_auction_houses")  
public class ArtAuctionHouses implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   //  

   // properties


   @Column(name = "nationality")
   private java.lang.String nationality;   // 国家

   @Column(name = "website")
   private java.lang.String website;   // 网址

   @Column(name = "remark")
   private java.lang.String remark;   // 说明

   @Column(name = "auction_house")
   private java.lang.String auctionHouse;   // 拍卖行

   @Column(name = "addr")
   private java.lang.String addr;   // 地址

   // Constructors
   public ArtAuctionHouses() {
   }

   public java.lang.Integer getId() { 
      return this.id; 
   }

   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }


   public java.lang.String getNationality() { 
      return this.nationality; 
   }
   public void setNationality(java.lang.String nationality) { 
      this.nationality = nationality; 
   }


   public java.lang.String getWebsite() { 
      return this.website; 
   }
   public void setWebsite(java.lang.String website) { 
      this.website = website; 
   }


   public java.lang.String getRemark() { 
      return this.remark; 
   }
   public void setRemark(java.lang.String remark) { 
      this.remark = remark; 
   }


   public java.lang.String getAuctionHouse() { 
      return this.auctionHouse; 
   }
   public void setAuctionHouse(java.lang.String auctionHouse) { 
      this.auctionHouse = auctionHouse; 
   }


   public java.lang.String getAddr() { 
      return this.addr; 
   }
   public void setAddr(java.lang.String addr) { 
      this.addr = addr; 
   }


   public static String REF_CLASS = "ArtAuctionHouses";
   public static String PROP_ID = "id";
   public static String PROP_NATIONALITY = "nationality";
   public static String PROP_WEBSITE = "website";
   public static String PROP_REMARK = "remark";
   public static String PROP_AUCTION_HOUSE = "auctionHouse";
   public static String PROP_ADDR = "addr";

   public static String REF_TABLE = "art_auction_houses";
   public static String COL_ID = "id";
   public static String COL_NATIONALITY = "nationality";
   public static String COL_WEBSITE = "website";
   public static String COL_REMARK = "remark";
   public static String COL_AUCTION_HOUSE = "auction_house";
   public static String COL_ADDR = "addr";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.auction.model.ArtAuctionHouses)) return false;
      else {
         com.golead.art.auction.model.ArtAuctionHouses o = (com.golead.art.auction.model.ArtAuctionHouses) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ArtAuctionHouses:");
		buffer.append(" id:").append(id);
		buffer.append(" nationality:").append(dealNull(nationality));
		buffer.append(" website:").append(dealNull(website));
		buffer.append(" remark:").append(dealNull(remark));
		buffer.append(" auctionHouse:").append(dealNull(auctionHouse));
		buffer.append(" addr:").append(dealNull(addr));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"nationality\":\"").append(dealNull(nationality)).append("\"");
		buffer.append(",\"website\":\"").append(dealNull(website)).append("\"");
		buffer.append(",\"remark\":\"").append(dealNull(remark)).append("\"");
		buffer.append(",\"auctionHouse\":\"").append(dealNull(auctionHouse)).append("\"");
		buffer.append(",\"addr\":\"").append(dealNull(addr)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
