package com.huge.code.common;

import com.huge.code.canvas.BasicCanvas;

/**
 * @author Felipe
 * @version 1.0
 * Utility class as helper of other classes
 * */
public class PaintUtils {
	
	/**
	 * @param canvas canvas
	 * @return String final canvas to be saved into the output file
	 * */
	public static String drawCanvas(BasicCanvas canvas){
		String output = "";
		dashes(output, canvas);
		
		for( int i = 0; i<canvas.getCommand().getHeight() ; i++ ){
			output += "\n";
			output += Chars.PIPE.asChar();
			for( int j = 0; j<canvas.getCommand().getWidth() ; j++ ){
				output+= canvas.getArea()[i][j];
			}
			output += Chars.PIPE.asChar();
		}
		output += "\n";
		dashes(output, canvas);
		output += "\n";
		return output;
	}
	
	private static String dashes(String output, BasicCanvas canvas){
		for( int i = 0; i<=canvas.getCommand().getWidth()+1 ; i++ ){
			output += Chars.DASH.asChar();
		}
		return output;
	}
	
	public static void imprimir( BasicCanvas canvas ){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(canvas.getArea()[i][j]);
			}
			System.out.println();
		}
	}
	
	public static char[][] areaFill(int w, int h, char c){
		char output [][] = new char [h][w];
		for( int i = 0 ; i<h ; i++ ){
			for( int j = 0; j<w ; j++ ){
				output[i][j] = c;
			}
		}
		return output;
	}
	
	public static void imprimir( char[][] array ){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

}
