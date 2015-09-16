package com.huge.code.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Felipe
 * @version 1.0
 * Represents the way to write the file
 * */
public class WriteFileTool {
	
	private BufferedWriter bw;
	
	private final static Logger log = Logger.getLogger( WriteFileTool.class.getName() );
	
	/**
	 * @param File represents the file to be saved
	 * if the file has not created, then the system will create the file
	 * */
	public WriteFileTool(File file){
		existFile(file);
		initObjects(file);
	}
	
	/**
	 * @param content represents the content to be saved into the file
	 * sets the content in the specified file
	 * */
	public void writeContent(String content){
		try {
			bw.write(content);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	/**
	 * closes the file
	 * */
	public void closeFile(){
		try {
			bw.close();
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	private void existFile(File file){
		if( !file.exists() ){
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}
	
	public void initObjects(File file){
		try {
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}

}
