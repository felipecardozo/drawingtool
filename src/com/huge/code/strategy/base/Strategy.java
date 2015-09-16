package com.huge.code.strategy.base;

import com.huge.code.canvas.BasicCanvas;

/**
 * @author Felipe
 * @version 1.0
 * Represents the basic strategy
 * */
public interface Strategy {
	
	/**
	 * @param canvas represents the canvas which can be draw for any strategy
	 * draw into the canvas the current strategy
	 * */
	public void drawIn( BasicCanvas canvas );
	
}
