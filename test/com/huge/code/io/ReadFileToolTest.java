package com.huge.code.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ReadFileToolTest {

	@Test
	public void test() {
		File file = new File("input/input.txt");
		ReadFileTool readFileTool = new ReadFileTool(file);
		readFileTool.read();
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String actual = sc.nextLine();
		String expected = "C 20 4";
		assertArrayEquals( new String[]{ expected } , new String[]{ actual } );
	}
	
	@Test
	public void test2(){
		File file = new File("input/input.txt");
		ReadFileTool tool = new ReadFileTool(file);
		tool.read();
		assertArrayEquals( new int[]{ 5 } , new int[]{ tool.getCommandsList().size() } );
		
	}

}
