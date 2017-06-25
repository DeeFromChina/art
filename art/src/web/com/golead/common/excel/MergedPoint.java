package com.golead.common.excel;

public class MergedPoint {
	
	private int beginPointX;
	
	private int beginPointY;
	
	private int endPointX;
	
	private int endPointY;

	public int getBeginPointX() {
		return beginPointX;
	}

	public void setBeginPointX(int beginPointX) {
		this.beginPointX = beginPointX;
	}

	public int getBeginPointY() {
		return beginPointY;
	}

	public void setBeginPointY(int beginPointY) {
		this.beginPointY = beginPointY;
	}

	public int getEndPointX() {
		return endPointX;
	}

	public void setEndPointX(int endPointX) {
		this.endPointX = endPointX;
	}

	public int getEndPointY() {
		return endPointY;
	}

	public void setEndPointY(int endPointY) {
		this.endPointY = endPointY;
	}
	
	public MergedPoint() {
		
	}

	public MergedPoint(int beginPointX, int beginPointY, int endPointX, int endPointY) {
		this.beginPointX = beginPointX;
		this.beginPointY = beginPointY;
		this.endPointX = endPointX;
		this.endPointY = endPointY;
	}
 
}
