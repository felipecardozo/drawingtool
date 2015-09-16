package com.huge.code.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.CreateCanvasCommand;

public class PointTest {

	@Test
	public void basicTestPoint() {
		Point point = new Point(10, 3, 'o');
		assertArrayEquals( new int[]{ 9, 2 } ,  new int[]{ point.getX(), point.getY() } );
	}
	
	@Test
	public void basiCoordinatesCanvasTest(){
		CreateCanvasCommand commandCreateCanvas = new CreateCanvasCommand(20, 4);
		BasicCanvas canvas = new BasicCanvas(commandCreateCanvas);
		canvas.setChar(2, 9, 'o');
		assertArrayEquals( new char[]{ 'o' } , new char[]{ canvas.getArea()[2][9] } );
	}

}
