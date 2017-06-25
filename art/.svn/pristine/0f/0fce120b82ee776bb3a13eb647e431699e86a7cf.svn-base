package com.golead.common.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class PrintPoint {

   private int     x;//x轴(行)

   private int     y;//y轴(列)

   private Object  pointValue; //数据

   private boolean isDynamic;   //单元格的值是否为动态变化

   private String  dynamicField; //动态值的字段名称 

   private int     cellType; //单元格的数据类型
   
   private int	   copyCellX = -1;
   
   private int	   copyCellY = -1;

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public Object getPointValue() {
      return pointValue;
   }

   public void setPointValue(Object pointValue) {
      this.pointValue = pointValue;
   }

   public boolean isDynamic() {
      return isDynamic;
   }

   public void setDynamic(boolean isDynamic) {
      this.isDynamic = isDynamic;
   }

   public String getDynamicField() {
      return dynamicField;
   }

   public void setDynamicField(String dynamicField) {
      this.dynamicField = dynamicField;
   }

   public int getCellType() {
      return cellType;
   }

   public void setCellType(int cellType) {
      this.cellType = cellType;
   }

	public int getCopyCellX() {
		return copyCellX;
	}

	public void setCopyCellX(int copyCellX) {
		this.copyCellX = copyCellX;
	}

	public int getCopyCellY() {
		return copyCellY;
	}

	public void setCopyCellY(int copyCellY) {
		this.copyCellY = copyCellY;
	}

	/**
    * Excel单元格数据对象
    * 
    * @param x 横坐标
    * @param y 纵坐标
    * @param pointValue 单元格的默认值
    * @param cellType 单元格数据类型
    */
   public PrintPoint(int x, int y, Object pointValue, int cellType) {
      this.x = x;
      this.y = y;
      this.pointValue = pointValue;
      this.isDynamic = false;
      this.cellType = cellType;

   }
   
   public PrintPoint(int x, int y, Object pointValue) {
	   this(x, y, pointValue, PrintExcel.STRING);
   }
   
   public PrintPoint(int x, int y, Object pointValue, int copyCellX, int copyCellY) {
	   this(x, y, pointValue, PrintExcel.STRING);
	   this.copyCellX = copyCellX;
	   this.copyCellY = copyCellY;
   }

}
