package com.huge.code.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.common.Chars;
import com.huge.code.strategy.LineStr;

public class LineCommandTest {

	private LineCommand commandLine;
	private BasicCanvas canvas ;
	private LineStr line ;
	private CreateCanvasCommand commandCreateCanvas;
	
	@Before
	public void setUp(){
		commandCreateCanvas = new CreateCanvasCommand(20, 4);
		canvas = new BasicCanvas(commandCreateCanvas);
	}
	
	@Test
	public void lineHorizontalTest() {
		commandLine = new LineCommand(1, 2, 6, 2);
		line = new LineStr(commandLine);
		line.drawIn(canvas);
		
		//expected values
		BasicCanvas canvasTest = new BasicCanvas(commandCreateCanvas);
		//setChar method puts originally the character into coordinates (no transforms)
		canvasTest.setChar(1, 0, Chars.X.asChar());
		canvasTest.setChar(1, 1, Chars.X.asChar());
		canvasTest.setChar(1, 2, Chars.X.asChar());
		canvasTest.setChar(1, 3, Chars.X.asChar());
		canvasTest.setChar(1, 4, Chars.X.asChar());
		canvasTest.setChar(1, 5, Chars.X.asChar());
		
		assertArrayEquals( canvasTest.getArea()[1], canvas.getArea()[1] );
	}
	
	@Test
	public void lineVerticalTest(){
		commandLine = new LineCommand(6, 3, 6, 4);
		line = new LineStr(commandLine);
		line.drawIn(canvas);

		//expected values
		BasicCanvas canvasTest = new BasicCanvas(commandCreateCanvas);
		//setChar method puts originally the character into coordinates (no transforms)
		canvasTest.setChar(2, 5, Chars.X.asChar());
		canvasTest.setChar(3, 5, Chars.X.asChar());
		
		assertArrayEquals( new char[]{ canvasTest.getArea()[2][5], canvasTest.getArea()[3][5] } , new char[]{ canvas.getArea()[2][5], canvas.getArea()[2][5] } );
		
	}
	
	@Test
	public void lineHorizontalNegativeCoordsTest() {
		commandLine = new LineCommand(-1, -2, -6, -2);
		line = new LineStr(commandLine);
		line.drawIn(canvas);
		
		//expected values
		BasicCanvas canvasTest = new BasicCanvas(commandCreateCanvas);
		//setChar method puts originally the character into coordinates (no transforms)
		canvasTest.setChar(1, 0, Chars.X.asChar());
		canvasTest.setChar(1, 1, Chars.X.asChar());
		canvasTest.setChar(1, 2, Chars.X.asChar());
		canvasTest.setChar(1, 3, Chars.X.asChar());
		canvasTest.setChar(1, 4, Chars.X.asChar());
		canvasTest.setChar(1, 5, Chars.X.asChar());
		
		assertNotEquals( canvasTest.getArea()[1], canvas.getArea()[1] );
	}

}
