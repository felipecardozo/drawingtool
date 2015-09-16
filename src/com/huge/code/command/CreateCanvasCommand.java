package com.huge.code.command;

import com.huge.code.canvas.base.Command;
import com.huge.code.common.Chars;

/**
 * @author Felipe
 * @version 1.0
 * this class is an implementation of a basic canvas command
 * */
public class CreateCanvasCommand extends Command {

	private int width;
	private int height;
	
	/**
	 * @param width represents the width of the canvas
	 * @param height represents the height of the canvas
	 * Constructs the canvas with the width and height
	 * sets by default an identifier C
	 * */
	public CreateCanvasCommand(int width, int height) {
		super.setCommand(Chars.C.asChar());
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString(){
		return "C " + width + " " + height;
	}

}
