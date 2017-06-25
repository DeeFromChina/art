package com.golead.art.wx.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an object that contains data related to the wx_menu_button table.
 */
@Entity  
@Table(name="wx_menu_button")  
public class WxMenuButton implements Serializable {
    private static final long serialVersionUID = 1L;

   // primary key  
   @Id  
   @GeneratedValue(strategy=GenerationType.AUTO)  
   @Column(name = "id", nullable = false)
   private java.lang.Integer id;   // 主键

   // properties


   @Column(name = "wx_name")
   private java.lang.String wxName;   // 菜单标题，不超过16个字节，子菜单不超过60个字节

   @Column(name = "wx_key")
   private java.lang.String wxKey;   // 菜单KEY值，用于消息接口推送，不超过128字节

   @Column(name = "wx_type")
   private java.lang.String wxType;   // 菜单的响应动作类型

   @Column(name = "enable")
   private java.lang.String enable;   // 是否启用 0否 1是

   @Column(name = "is_sub_button")
   private java.lang.String isSubButton;   // 是否为子菜单 0否 1是

   @Column(name = "wx_url")
   private java.lang.String wxUrl;   // 网页链接，用户点击菜单可打开链接，不超过1024字节

   @Column(name = "order_no")
   private java.lang.Integer orderNo;   // 顺序号

   @Column(name = "wx_media_id")
   private java.lang.String wxMediaId;   // 调用新增永久素材接口返回的合法media_id

   @Column(name = "parent_id")
   private java.lang.Integer parentId;   // 父菜单主键

   // Constructors
   public WxMenuButton() {
   }

   /**
    * The unique identifier of this class.
    * Return the value associated with the column: id
    * 主键
    */
   public java.lang.Integer getId() { 
      return this.id; 
   }
   /**
    * The unique identifier of this class.
    * Set the value related to the column: id
    * @param id is the 'id' value
    */
   public void setId(java.lang.Integer id) { 
      this.id = id; 
   }

   /**
    * Return the value associated with the column: wx_name
    * Description:菜单标题，不超过16个字节，子菜单不超过60个字节
    */
   public java.lang.String getWxName() { 
      return this.wxName; 
   }
   /**
    * Set the value related to the column: wx_name
    * @param wxName is the 'wx_name' value
    */
   public void setWxName(java.lang.String wxName) { 
      this.wxName = wxName; 
   }

   /**
    * Return the value associated with the column: wx_key
    * Description:菜单KEY值，用于消息接口推送，不超过128字节
    */
   public java.lang.String getWxKey() { 
      return this.wxKey; 
   }
   /**
    * Set the value related to the column: wx_key
    * @param wxKey is the 'wx_key' value
    */
   public void setWxKey(java.lang.String wxKey) { 
      this.wxKey = wxKey; 
   }

   /**
    * Return the value associated with the column: wx_type
    * Description:菜单的响应动作类型
    */
   public java.lang.String getWxType() { 
      return this.wxType; 
   }
   /**
    * Set the value related to the column: wx_type
    * @param wxType is the 'wx_type' value
    */
   public void setWxType(java.lang.String wxType) { 
      this.wxType = wxType; 
   }

   /**
    * Return the value associated with the column: enable
    * Description:是否启用 0否 1是
    */
   public java.lang.String getEnable() { 
      return this.enable; 
   }
   /**
    * Set the value related to the column: enable
    * @param enable is the 'enable' value
    */
   public void setEnable(java.lang.String enable) { 
      this.enable = enable; 
   }

   /**
    * Return the value associated with the column: is_sub_button
    * Description:是否为子菜单 0否 1是
    */
   public java.lang.String getIsSubButton() { 
      return this.isSubButton; 
   }
   /**
    * Set the value related to the column: is_sub_button
    * @param isSubButton is the 'is_sub_button' value
    */
   public void setIsSubButton(java.lang.String isSubButton) { 
      this.isSubButton = isSubButton; 
   }

   /**
    * Return the value associated with the column: wx_url
    * Description:网页链接，用户点击菜单可打开链接，不超过1024字节
    */
   public java.lang.String getWxUrl() { 
      return this.wxUrl; 
   }
   /**
    * Set the value related to the column: wx_url
    * @param wxUrl is the 'wx_url' value
    */
   public void setWxUrl(java.lang.String wxUrl) { 
      this.wxUrl = wxUrl; 
   }

   /**
    * Return the value associated with the column: order_no
    * Description:顺序号
    */
   public java.lang.Integer getOrderNo() { 
      return this.orderNo; 
   }
   /**
    * Set the value related to the column: order_no
    * @param orderNo is the 'order_no' value
    */
   public void setOrderNo(java.lang.Integer orderNo) { 
      this.orderNo = orderNo; 
   }

   /**
    * Return the value associated with the column: wx_media_id
    * Description:调用新增永久素材接口返回的合法media_id
    */
   public java.lang.String getWxMediaId() { 
      return this.wxMediaId; 
   }
   /**
    * Set the value related to the column: wx_media_id
    * @param wxMediaId is the 'wx_media_id' value
    */
   public void setWxMediaId(java.lang.String wxMediaId) { 
      this.wxMediaId = wxMediaId; 
   }

   /**
    * Return the value associated with the column: parent_id
    * Description:父菜单主键
    */
   public java.lang.Integer getParentId() { 
      return this.parentId; 
   }
   /**
    * Set the value related to the column: parent_id
    * @param parentId is the 'parent_id' value
    */
   public void setParentId(java.lang.Integer parentId) { 
      this.parentId = parentId; 
   }


   public static String REF_CLASS = "WxMenuButton";
   public static String PROP_ID = "id";
   public static String PROP_WX_NAME = "wxName";
   public static String PROP_WX_KEY = "wxKey";
   public static String PROP_WX_TYPE = "wxType";
   public static String PROP_ENABLE = "enable";
   public static String PROP_IS_SUB_BUTTON = "isSubButton";
   public static String PROP_WX_URL = "wxUrl";
   public static String PROP_ORDER_NO = "orderNo";
   public static String PROP_WX_MEDIA_ID = "wxMediaId";
   public static String PROP_PARENT_ID = "parentId";

   public static String REF_TABLE = "wx_menu_button";
   public static String COL_ID = "id";
   public static String COL_WX_NAME = "wx_name";
   public static String COL_WX_KEY = "wx_key";
   public static String COL_WX_TYPE = "wx_type";
   public static String COL_ENABLE = "enable";
   public static String COL_IS_SUB_BUTTON = "is_sub_button";
   public static String COL_WX_URL = "wx_url";
   public static String COL_ORDER_NO = "order_no";
   public static String COL_WX_MEDIA_ID = "wx_media_id";
   public static String COL_PARENT_ID = "parent_id";
   
   public boolean equals(Object obj) {
      if (null == obj) return false;
      if (!(obj instanceof com.golead.art.wx.model.WxMenuButton)) return false;
      else {
         com.golead.art.wx.model.WxMenuButton o = (com.golead.art.wx.model.WxMenuButton) obj;
         if (null == this.getId() || null == o.getId()) return false;
         else return (this.getId().equals(o.getId()));
      }
   }

   public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[WxMenuButton:");
		buffer.append(" id:").append(id);
		buffer.append(" wxName:").append(dealNull(wxName));
		buffer.append(" wxKey:").append(dealNull(wxKey));
		buffer.append(" wxType:").append(dealNull(wxType));
		buffer.append(" enable:").append(dealNull(enable));
		buffer.append(" isSubButton:").append(dealNull(isSubButton));
		buffer.append(" wxUrl:").append(dealNull(wxUrl));
		buffer.append(" orderNo:").append(dealNull(orderNo));
		buffer.append(" wxMediaId:").append(dealNull(wxMediaId));
		buffer.append(" parentId:").append(dealNull(parentId));
		buffer.append("]");
		return buffer.toString();
   }

   public String toJson() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("\"id\":\"").append(id).append("\"");
		buffer.append(",\"wxName\":\"").append(dealNull(wxName)).append("\"");
		buffer.append(",\"wxKey\":\"").append(dealNull(wxKey)).append("\"");
		buffer.append(",\"wxType\":\"").append(dealNull(wxType)).append("\"");
		buffer.append(",\"enable\":\"").append(dealNull(enable)).append("\"");
		buffer.append(",\"isSubButton\":\"").append(dealNull(isSubButton)).append("\"");
		buffer.append(",\"wxUrl\":\"").append(dealNull(wxUrl)).append("\"");
		buffer.append(",\"orderNo\":\"").append(dealNull(orderNo)).append("\"");
		buffer.append(",\"wxMediaId\":\"").append(dealNull(wxMediaId)).append("\"");
		buffer.append(",\"parentId\":\"").append(dealNull(parentId)).append("\"");
		buffer.append("}");
		return buffer.toString();
   }

	private String dealNull(Object str) {
		if(str==null) return ""; else return str.toString();
	}
}
