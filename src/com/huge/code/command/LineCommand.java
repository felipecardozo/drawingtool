package com.huge.code.command;

import com.huge.code.canvas.base.Command;
import com.huge.code.common.Chars;

/**
 * @author Felipe
 * @version 1.0
 * this class is an implementation of a basic line command
 * */
public class LineCommand extends Command {

	private int x1;
	private int y1; 
	private int x2;
	private int y2;
	
	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param x2 axis x
	 * @param y2 axis y
	 * represents the coordinates of a line
	 * */
	public LineCommand(int x1, int y1, int x2, int y2){
		super.setCommand( Chars.L.asChar() );
		this.x1 = y1-1;
		this.y1 = x1-1;
		this.x2 = y2-1;
		if( isHorizontal() ){
			this.y2 = x2;
		} else if( isVertical(y1, y2) ){
			this.y2 = x2-1;
		}
	}
	
	public boolean isHorizontal(){
		return x1 == x2;
	}
	
	public boolean isVertical(int y1, int y2){
		return y1 == y2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public String toString(){
		return "L "+x1 + " " + y1+ " " + x2+ " " + y2;
	}
	
}
