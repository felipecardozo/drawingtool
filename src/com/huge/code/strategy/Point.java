package com.huge.code.strategy;

/**
 * @author Felipe
 * @version 1.0
 * Represents a point in the canvas
 * */
public class Point {

	private int x;
	private int y;
	private char c;
	
	public Point(){  }

	public Point(int x, int y, char c) {
		super();
		this.x = x-1;
		this.y = y-1;
		this.c = c;
	}

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
	
	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
	public String toString(){
		return "("+this.x + ", "+ this.y +")";
	}

}
