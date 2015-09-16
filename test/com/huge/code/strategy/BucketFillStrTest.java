package com.huge.code.strategy;

import org.junit.Test;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.BucketCommand;
import com.huge.code.command.CreateCanvasCommand;
import com.huge.code.command.LineCommand;
import com.huge.code.command.RectangleCommand;
import com.huge.code.common.Chars;
import com.huge.code.common.PaintUtils;

import static org.junit.Assert.*;

import org.junit.Before;

public class BucketFillStrTest {
	
	private BucketFillStr bucketFill;
	private BucketCommand command;
	private Point point;
	private BasicCanvas canvas;
	private CreateCanvasCommand createCanvasCommand;
	
	@Before
	public void setUp(){
		createCanvasCommand = new CreateCanvasCommand(20, 4);
		canvas = new BasicCanvas(createCanvasCommand);
	}
	
	@Test
	public void basicBucketFillTest(){
		point = new Point(10, 3, Chars.O.asChar());
		command =  new BucketCommand(point); 
		bucketFill = new BucketFillStr(command);
		bucketFill.drawIn(canvas);
		PaintUtils.imprimir(canvas);
		assertArrayEquals(new char[]{ Chars.O.asChar() }, new char[]{ canvas.getArea()[1][9] });
	}
	
	@Test
	public void basicCanvasTest(){
		point = new Point(10, 3, Chars.O.asChar());
		command =  new BucketCommand(point); 
		bucketFill = new BucketFillStr(command);
		bucketFill.drawIn(canvas);
		
		char expected [][] = PaintUtils.areaFill(20, 4, Chars.O.asChar());
		assertArrayEquals(expected, canvas.getArea());
	}
	
	@Test
	public void canvasWith1LineTest(){
		point = new Point(10, 3, Chars.O.asChar());
		LineCommand lineCommand = new LineCommand(1, 2, 6, 2);
		LineStr lineStr = new LineStr(lineCommand);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		
		lineStr.drawIn(canvas);
		bucketStr.drawIn(canvas);
		
		char expected [][] = PaintUtils.areaFill(20, 4, Chars.O.asChar());
		expected[1][0] = Chars.X.asChar();
		expected[1][1] = Chars.X.asChar();
		expected[1][2] = Chars.X.asChar();
		expected[1][3] = Chars.X.asChar();
		expected[1][4] = Chars.X.asChar();
		expected[1][5] = Chars.X.asChar();
		
		assertArrayEquals(expected, canvas.getArea() );
	}
	
	@Test
	public void canvasWith2LineTest(){
		point = new Point(10, 3, Chars.O.asChar());
		
		LineCommand lineCommand1 = new LineCommand(1, 2, 6, 2);
		LineCommand lineCommand2 = new LineCommand(6, 3, 6, 4);
		LineStr lineStr = new LineStr(lineCommand1);
		lineStr.addCommand(lineCommand2);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		
		lineStr.drawIn(canvas);
		bucketStr.drawIn(canvas);
		
		PaintUtils.imprimir(canvas);
	}
	
	@Test
	public void canvasWithRectangleTest(){
		point = new Point(10, 3, Chars.O.asChar());
		
		RectangleCommand command = new RectangleCommand(16, 1, 20, 3);
		RectangleStr rectangleStr = new RectangleStr(command);
		rectangleStr.drawIn(canvas);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		bucketStr.drawIn(canvas);
		
		PaintUtils.imprimir(canvas);
	}
	
	@Test
	public void canvasWithRectangleAnd2LinesTest(){
		point = new Point(10, 3, Chars.O.asChar());
		
		LineCommand lineCommand1 = new LineCommand(1, 2, 6, 2);
		LineCommand lineCommand2 = new LineCommand(6, 3, 6, 4);
		LineStr lineStr = new LineStr(lineCommand1);
		lineStr.addCommand(lineCommand2);
		
		RectangleCommand command = new RectangleCommand(16, 1, 20, 3);
		RectangleStr rectangleStr = new RectangleStr(command);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		
		lineStr.drawIn(canvas);
		rectangleStr.drawIn(canvas);
		bucketStr.drawIn(canvas);
		
		PaintUtils.imprimir(canvas);
	}
	
	@Test
	public void canvasWith1LineAndBucketOverX(){
		point = new Point(1, 2, Chars.O.asChar());
		
		LineCommand lineCommand1 = new LineCommand(1, 2, 6, 2);
		LineStr lineStr = new LineStr(lineCommand1);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		
		lineStr.drawIn(canvas);
		bucketStr.drawIn(canvas);
		
		char expected [][] = PaintUtils.areaFill(20, 4, Chars.SPACE.asChar());
		expected[1][0] = Chars.X.asChar();
		expected[1][1] = Chars.X.asChar();
		expected[1][2] = Chars.X.asChar();
		expected[1][3] = Chars.X.asChar();
		expected[1][4] = Chars.X.asChar();
		expected[1][5] = Chars.X.asChar();
		
		assertArrayEquals(expected, canvas.getArea());
	}
	
	@Test
	public void buckeFillInsideRectangleTest(){
		point = new Point(18, 2, Chars.O.asChar());
		
		RectangleCommand command = new RectangleCommand(16, 1, 20, 3);
		RectangleStr rectangleStr = new RectangleStr(command);
		rectangleStr.drawIn(canvas);
		
		PaintUtils.imprimir(canvas);
		
		BucketCommand bucketCommand =  new BucketCommand(point); 
		BucketFillStr bucketStr = new BucketFillStr(bucketCommand);
		bucketStr.drawIn(canvas);
		
		PaintUtils.imprimir(canvas);
	}
	
	@Test
	public void basicCanvasNegativePointTest(){
		point = new Point(-10, -3, Chars.O.asChar());
		command =  new BucketCommand(point); 
		bucketFill = new BucketFillStr(command);
		bucketFill.drawIn(canvas);
		
		char expected [][] = PaintUtils.areaFill(20, 4, Chars.O.asChar());
		assertNotEquals(expected, canvas.getArea());
	}
	
}
