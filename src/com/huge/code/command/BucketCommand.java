package com.huge.code.command;

import com.huge.code.canvas.base.Command;
import com.huge.code.common.Chars;
import com.huge.code.strategy.Point;

/**
 * @author Felipe
 * @version 1.0
 * this class is an implementation of a basic Bucket Fill command
 * */
public class BucketCommand extends Command {
	
	private Point point;
	
	public BucketCommand( Point point ){
		super.setCommand( Chars.B.asChar() );
		this.point = point;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public String toString(){
		return "B "+point.getX() + " " + point.getY() + " " + point.getC();
	}

}
