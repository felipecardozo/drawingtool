package com.huge.code.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.common.Chars;
import com.huge.code.common.PaintUtils;
import com.huge.code.strategy.RectangleStr;

public class RectangleCommandTest {

	
	private RectangleCommand command;
	private BasicCanvas canvas ;
	private RectangleStr rectangle;
	private CreateCanvasCommand commandCreateCanvas;
	
	@Before
	public void setUp(){
		commandCreateCanvas = new CreateCanvasCommand(20, 4);
		canvas = new BasicCanvas(commandCreateCanvas);
	}
	
	@Test
	public void rectangleTest() {
		command = new RectangleCommand(16, 1, 20, 3);
		rectangle = new RectangleStr(command);
		rectangle.drawIn(canvas);
		
		//expected values
		BasicCanvas expected = new BasicCanvas(commandCreateCanvas);
		//setChar method puts originally the character into coordinates (no transforms)
		expected.setChar(0, 15, Chars.X.asChar());
		expected.setChar(0, 16, Chars.X.asChar());
		expected.setChar(0, 17, Chars.X.asChar());
		expected.setChar(0, 18, Chars.X.asChar());
		expected.setChar(0, 19, Chars.X.asChar());
		expected.setChar(1, 15, Chars.X.asChar());
		expected.setChar(2, 15, Chars.X.asChar());
		expected.setChar(2, 16, Chars.X.asChar());
		expected.setChar(2, 17, Chars.X.asChar());
		expected.setChar(2, 18, Chars.X.asChar());
		expected.setChar(2, 19, Chars.X.asChar());
		expected.setChar(1, 19, Chars.X.asChar());
		
		assertArrayEquals( expected.getArea()[0] , canvas.getArea()[0] );
		assertArrayEquals( expected.getArea()[1] , canvas.getArea()[1] );
		assertArrayEquals( expected.getArea()[2] , canvas.getArea()[2] );
		assertArrayEquals( expected.getArea()[3] , canvas.getArea()[3] );
		
	}
	
	@Test
	public void rectangleNegativeTest() {
		command = new RectangleCommand(-16, -1, -20, -3);
		rectangle = new RectangleStr(command);
		rectangle.drawIn(canvas);
		
		//expected values
		BasicCanvas expected = new BasicCanvas(commandCreateCanvas);
		//setChar method puts originally the character into coordinates (no transforms)
		expected.setChar(0, 15, Chars.X.asChar());
		expected.setChar(0, 16, Chars.X.asChar());
		expected.setChar(0, 17, Chars.X.asChar());
		expected.setChar(0, 18, Chars.X.asChar());
		expected.setChar(0, 19, Chars.X.asChar());
		expected.setChar(1, 15, Chars.X.asChar());
		expected.setChar(2, 15, Chars.X.asChar());
		expected.setChar(2, 16, Chars.X.asChar());
		expected.setChar(2, 17, Chars.X.asChar());
		expected.setChar(2, 18, Chars.X.asChar());
		expected.setChar(2, 19, Chars.X.asChar());
		expected.setChar(1, 19, Chars.X.asChar());
		
		PaintUtils.imprimir(expected);
		PaintUtils.imprimir(canvas);
		
		assertNotEquals( expected.getArea()[0] , canvas.getArea()[0] );
		assertNotEquals( expected.getArea()[1] , canvas.getArea()[1] );
		assertNotEquals( expected.getArea()[2] , canvas.getArea()[2] );
		assertNotEquals( expected.getArea()[3] , canvas.getArea()[3] );
		
	}

}
