package com.huge.code.strategy;

import java.util.ArrayList;
import java.util.List;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.BucketCommand;
import com.huge.code.common.Chars;
import com.huge.code.strategy.base.Strategy;

/**
 * @author Felipe
 * @version 1.0
 * Represents the strategy to fill the draw
 * */
public class BucketFillStr implements Strategy  {
	
	private List<BucketCommand> commands;
	private BasicCanvas canvas;
	
	public BucketFillStr(){
		commands = new ArrayList<>();
	}
	
	public BucketFillStr( BucketCommand bucketFill ) {
		commands = new ArrayList<>();
		addCommand(bucketFill);
	}

	@Override
	public void drawIn(BasicCanvas canvas) {
		this.canvas = canvas;
		if( commands.size() > 0 ){
			for( BucketCommand bucketCommand : commands ){
				Point p = bucketCommand.getPoint();
				if( canDraw( p ) ){
					bucketFillAlg( canvas.getArea(), p.getY(), p.getX(), Chars.SPACE.asChar(), bucketCommand.getPoint().getC() );
				}
			}
		}
	}
	
	public void bucketFillAlg( char area[][], int x, int y, char targetColor, char replacementColor ){
		if( area[x][y] == 'x' || area[x][y] == replacementColor ){
			return;
		}
		if( Character.isSpaceChar(area[x][y]) ){
			area[x][y] = replacementColor;
		}
		if( x-1>=0 ){
			bucketFillAlg( area, x-1, y, Chars.SPACE.asChar(), replacementColor );
		}
		if( x+1 < canvas.getCommand().getHeight() ){
			bucketFillAlg( area, x+1, y, Chars.SPACE.asChar(), replacementColor );
		}
		if( y-1 >= 0 ){
			bucketFillAlg( area, x, y-1, Chars.SPACE.asChar(), replacementColor );
		}
		if( y+1 < canvas.getCommand().getWidth() ){
			bucketFillAlg( area, x, y+1, Chars.SPACE.asChar(), replacementColor );
		}
		return;
	}

	public BasicCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(BasicCanvas canvas) {
		this.canvas = canvas;
	}
	
	public boolean canDraw( Point p ){
		return (p.getX() >=0 && p.getX()<canvas.getCommand().getWidth() && p.getY() >=0 && p.getY()<canvas.getCommand().getHeight());
	}
	
	/**
	 * @param command represent the command of a bucket fill
	 * adds the list of commands to be executed
	 * */
	public void addCommand( BucketCommand command ){
		commands.add(command);
	}
	
	public List<BucketCommand> getCommands( ){
		return commands;
	}

}
