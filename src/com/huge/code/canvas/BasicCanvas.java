package com.huge.code.canvas;

import com.huge.code.canvas.base.Canvas;
import com.huge.code.command.CreateCanvasCommand;

/**
 * @author Felipe
 * @version 1.0
 * represents a basic canvas
 * */
public class BasicCanvas implements Canvas {

	private char[][] area;
	
	private CreateCanvasCommand command;
	
	/**
	 * @param CreateCanvasCommand Create Canvas Command
	 * constructs a Basic canvas using the command CreateCanvasCommand<br>
	 * initialize the area with space character
	 * */
	public BasicCanvas( CreateCanvasCommand command ){
		this.command = command;
		area = new char[ command.getHeight() ][ command.getWidth() ];
		initArea();
	}
	
	public void initArea(){
		for( int i = 0; i<command.getHeight() ; i++ ){
			for( int j = 0; j<command.getWidth() ; j++ ){
				area[i][j] = ' ';
			}
		}
	}
	
	public char[][] getArea() {
		return area;
	}

	public void setArea(char[][] area) {
		this.area = area;
	}
	
	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param c represents color
	 * sets the character manually into the canvas area<br>
	 * the x and y parameter have not any transformation,<br> 
	 * so those coordinates goes purely to the x and y provided
	 * */
	public void setChar(int x, int y, char c){
		if( x>=0 && x<command.getHeight() && y>=0 && y<command.getWidth() ){
			area[x][y] = c;
		}
	}

	public CreateCanvasCommand getCommand() {
		return command;
	}

	public void setCommand(CreateCanvasCommand command) {
		this.command = command;
	}

}
