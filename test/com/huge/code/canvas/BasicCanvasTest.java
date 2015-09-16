package com.huge.code.canvas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.huge.code.command.CreateCanvasCommand;
import com.huge.code.common.Chars;

public class BasicCanvasTest {

	private BasicCanvas canvas;
	
	@Before
	public void setUp(){
		CreateCanvasCommand command = new CreateCanvasCommand(20, 4);
		canvas = new BasicCanvas(command);
	}
	
	@Test
	public void evaluateArea() {
		assertArrayEquals(new int[] { 20, 4 }, new int[] { canvas.getCommand().getWidth(), canvas.getCommand().getHeight() });
	}
	
	@Test
	public void evaluateSetChar(){
		canvas.setChar(1, 0, Chars.X.asChar());
		assertArrayEquals( new char[]{ Chars.X.asChar() } , new char[]{ canvas.getArea()[1][0]  } );
	}
	
	@Test
	public void evaluateSetCharOutOfBounds(){
		canvas.setChar(100, 0, Chars.X.asChar());
		boolean hasX = false;
		for( int i = 0 ; i < canvas.getCommand().getHeight() ; i++ ){
			for( int j = 0; j<canvas.getCommand().getWidth() ; j++ ){
				hasX = canvas.getArea()[i][j] == Chars.X.asChar();
			}
		}
		assertArrayEquals( new boolean[]{ false } , new boolean[]{ hasX  } );
	}
	
	@Test
	public void widthTest(){
		CreateCanvasCommand command = new CreateCanvasCommand(10, 5);
		BasicCanvas canvas1 = new BasicCanvas(command);
		assertArrayEquals( new int[]{ 10 } , new int[]{ canvas1.getCommand().getWidth()  } );
	}
	
	@Test( expected = NegativeArraySizeException.class )
	public void negativeWidthTest(){
		CreateCanvasCommand command = new CreateCanvasCommand(-10, 5);
		@SuppressWarnings("unused")
		BasicCanvas canvas1 = new BasicCanvas(command);
	}
	
	@Test( expected = NegativeArraySizeException.class )
	public void negativeHeightTest(){
		CreateCanvasCommand command = new CreateCanvasCommand(10, -5);
		@SuppressWarnings("unused")
		BasicCanvas canvas1 = new BasicCanvas(command);
	}
	

}
