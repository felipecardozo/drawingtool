package com.huge.code.command;

import com.huge.code.canvas.base.Command;
import com.huge.code.common.Chars;

/**
 * @author Felipe
 * @version 1.0
 * this class is an implementation of a basic rectangle command
 * */
public class RectangleCommand extends Command {
	
	private LineCommand line1;
	private LineCommand line2;
	private LineCommand line3;
	private LineCommand line4;
	
	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param x2 axis x
	 * @param y2 axis y
	 * represents the coordinates of the rectangle
	 * which build 4 lines and compose a rectangle
	 * */
	public RectangleCommand( int x1, int y1, int x2, int y2 ){
		super.setCommand( Chars.R.asChar() );
		line1 = new LineCommand(x1, y1, x2, y1);
		line2 = new LineCommand(x1, y1, x1, y2);
		line3 = new LineCommand(x1, y2, x2, y2);
		line4 = new LineCommand(x2, y1, x2, y2);
	}
	
	public LineCommand getLine1() {
		return line1;
	}

	public void setLine1(LineCommand line1) {
		this.line1 = line1;
	}

	public LineCommand getLine2() {
		return line2;
	}

	public void setLine2(LineCommand line2) {
		this.line2 = line2;
	}

	public LineCommand getLine3() {
		return line3;
	}

	public void setLine3(LineCommand line3) {
		this.line3 = line3;
	}

	public LineCommand getLine4() {
		return line4;
	}

	public void setLine4(LineCommand line4) {
		this.line4 = line4;
	}

	public String toString(){
		return "\nR "+line1 +"\t"+ line2 +"\t"+ line3 +"\t"+ line4+ "\n";
	}
	
}
