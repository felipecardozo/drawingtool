package com.huge.code.command;

import com.huge.code.strategy.Point;

/**
 * @author Felipe
 * @version 1.0
 * this class is an implementation of a basic Factory of commands
 * */
public class CommandFactory {
	
	private LineCommand lineCommand;
	
	private RectangleCommand rectangleCommand;
	
	private BucketCommand bucketCommand;
	
	private CreateCanvasCommand createCanvasCommand;
	
	/**
	 * @param width
	 * @param heigth
	 * @return return a CreateCanvasCommand
	 * Constructs a command to create a Canvas
	 * */
	public CreateCanvasCommand createCanvas( int width, int heigth ){
		createCanvasCommand = new CreateCanvasCommand(width, heigth);
		return createCanvasCommand;
	}

	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param x2 axis x
	 * @param y2 axis y
	 * @return return a LineCommand
	 * Constructs a command to create a Line
	 * */
	public LineCommand createLine(int x1, int y1, int x2, int y2) {
		lineCommand = new LineCommand(x1, y1, x2, y2);
		return lineCommand;
	}

	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param x2 axis x
	 * @param y2 axis y
	 * @return return a RectangleCommand
	 * Constructs a command to create a Rectangle
	 * */
	public RectangleCommand createRectangle(int x1, int y1, int x2, int y2) {
		rectangleCommand = new RectangleCommand(x1, y1, x2, y2);
		return rectangleCommand;
	}

	/**
	 * @param x1 axis x
	 * @param y1 axis y
	 * @param color represents a color
	 * @return return a BucketCommand
	 * Constructs a command to create a Bucket to Fill the Canvas
	 * */
	public BucketCommand createBucketFill(int x1, int y1, char color) {
		bucketCommand = new BucketCommand( new Point(x1, y1, color) );
		return bucketCommand;
	}

}
