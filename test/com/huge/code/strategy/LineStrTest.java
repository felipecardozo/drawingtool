package com.huge.code.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.CreateCanvasCommand;
import com.huge.code.command.LineCommand;
import com.huge.code.common.Chars;
import com.huge.code.common.PaintUtils;
import com.huge.code.strategy.LineStr;

public class LineStrTest {

	private BasicCanvas canvas;
	private LineStr line ;
	private CreateCanvasCommand commandCreateCanvas;
	
	@Before
	public void setUp(){
		commandCreateCanvas = new CreateCanvasCommand(20, 4);
		canvas = new BasicCanvas(commandCreateCanvas);
	}
	
	@Test
	public void testAdd2Commands() {
		LineCommand command1 = new LineCommand(1, 2, 6, 2);
		LineCommand command2 = new LineCommand(6, 3, 6, 4);
		line = new LineStr(command1);
		line.addCommand(command2);
		
		line.drawIn(canvas);
		
		char[][] expected = PaintUtils.areaFill(20, 4, ' ');
		expected[1][0] = Chars.X.asChar();
		expected[1][1] = Chars.X.asChar();
		expected[1][2] = Chars.X.asChar();
		expected[1][3] = Chars.X.asChar();
		expected[1][4] = Chars.X.asChar();
		expected[1][5] = Chars.X.asChar();
		expected[2][5] = Chars.X.asChar();
		expected[3][5] = Chars.X.asChar();
		
		assertArrayEquals(expected,  canvas.getArea() );
		
	}

}
