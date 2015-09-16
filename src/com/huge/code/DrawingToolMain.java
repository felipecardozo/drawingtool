package com.huge.code;

import java.io.File;
import java.util.List;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.canvas.base.Command;
import com.huge.code.command.BucketCommand;
import com.huge.code.command.CreateCanvasCommand;
import com.huge.code.command.LineCommand;
import com.huge.code.command.RectangleCommand;
import com.huge.code.common.PaintUtils;
import com.huge.code.io.ReadFileTool;
import com.huge.code.io.WriteFileTool;
import com.huge.code.strategy.BucketFillStr;
import com.huge.code.strategy.LineStr;
import com.huge.code.strategy.RectangleStr;

/**
 * @author Felipe
 * @version 1.0
 * This is the Main class, which runs the program
 * */
public class DrawingToolMain {
	
	private ReadFileTool readFileTool;
	private WriteFileTool writeFileTool;
	private BasicCanvas canvas;
	private LineStr lineStr;
	private RectangleStr rectangleStr;
	private BucketFillStr bucketFillStr;
	
	public DrawingToolMain(){
		initObjects();
		initExecution();
		draw();
	}
	
	/**
	 * initializes the objects of the class
	 * */
	public void initObjects(){
		readFileTool = new ReadFileTool( new File("input/input.txt") );
		readFileTool.read();
		lineStr = new LineStr();
		rectangleStr = new RectangleStr();
		bucketFillStr = new BucketFillStr();
	}
	
	/**
	 * initializes the execution of the list of the commands scanned from the input file
	 * */
	public void initExecution(){
		List<Command> listCommands = readFileTool.getCommandsList();
		for( Command c : listCommands ){
			switch ( Character.toString(c.getCommand()) ) {
			case "C":
				canvas = new BasicCanvas( (CreateCanvasCommand) c );
				break;
			case "L":
				lineStr.addCommand( (LineCommand) c );
				break;
			case "R":
				rectangleStr.addCommand( (RectangleCommand) c );
				break;
			case "B":
				bucketFillStr.addCommand( (BucketCommand) c );
				break;
			}
		}
	}
	
	/**
	 * draws in the output file the commands using the strategies
	 * */
	public void draw(){
		writeFileTool = new WriteFileTool( new File("output/output.txt") );
		writeFileTool.writeContent( PaintUtils.drawCanvas(canvas) );
		lineStr.drawIn(canvas);
		writeFileTool.writeContent( PaintUtils.drawCanvas(canvas) );
		rectangleStr.drawIn(canvas);
		writeFileTool.writeContent( PaintUtils.drawCanvas(canvas) );
		bucketFillStr.drawIn(canvas);
		writeFileTool.writeContent( PaintUtils.drawCanvas(canvas) );
		writeFileTool.closeFile();
	}
	
	public static void main(String [] felipe){
		new DrawingToolMain();
	}
	

}
