package com.huge.code.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.huge.code.canvas.base.Command;
import com.huge.code.command.CommandFactory;
import com.huge.code.common.Chars;

/**
 * @author Felipe
 * @version 1.0
 * Represents the way to read the file
 * */
public class ReadFileTool {
	
	private File input;
	private Scanner sc;
	private CommandFactory commandFactory;
	private List<Command> commandsList ;
	private String commands[];
	
	private final static Logger log = Logger.getLogger( ReadFileTool.class.getName() );
	
	/**
	 * @param File represents the file to read
	 * initializes the list of commands to be executed
	 * */
	public ReadFileTool( File input ){
		this.input = input;
		commandFactory = new CommandFactory();
		commandsList = new ArrayList<>();
		commands = null;
	}
	
	/**
	 * reads the file specified
	 * */
	public void read(){
		try {
			scanFirstLine();
			//the condition is, canvas creation must be first
			if( canCreateOtherCommands() ){
				createCanvas();
				
				//get the next commands L or R or B
				scanForOtherCommands();
			}
			else{
				return;
			}
			
		} catch (FileNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * returns the commands list
	 * */
	public List<Command> getCommandsList() {
		return commandsList;
	}

	public void setCommandsList(List<Command> commandsList) {
		this.commandsList = commandsList;
	}
	
	private void addLine(){
		int x1 = Integer.parseInt(commands[1]);
		int y1 = Integer.parseInt(commands[2]);
		int x2 = Integer.parseInt(commands[3]);
		int y2 = Integer.parseInt(commands[4]);
		commandsList.add(commandFactory.createLine( x1, y1, x2, y2 ));
	}
	
	private void addRectangle(){
		int x1 = Integer.parseInt(commands[1]);
		int y1 = Integer.parseInt(commands[2]);
		int x2 = Integer.parseInt(commands[3]);
		int y2 = Integer.parseInt(commands[4]);
		commandsList.add(commandFactory.createRectangle( x1, y1, x2, y2 ));
	}
	
	private void addBucketFill(){
		int x1 = Integer.parseInt(commands[1]);
		int y1 = Integer.parseInt(commands[2]);
		char color =  commands[3].toCharArray()[0];
		commandsList.add(commandFactory.createBucketFill( x1, y1, color ));
	}
	
	private void createCanvas(){
		int width = Integer.parseInt( commands[1] );
		int height = Integer.parseInt( commands[2] );
		commandsList.add(commandFactory.createCanvas( width, height ));
	}
	
	private boolean canCreateOtherCommands(){
		return (commands != null && commands.length>0 && commands[0].equals( Chars.C.asString() ) && !commands[1].isEmpty() && !commands[2].isEmpty());
	}
	
	private void scanForOtherCommands(){
		while( sc.hasNextLine() ){
			String nextLine = sc.nextLine();
			commands = nextLine.split("\\s+");
			switch (commands[0]) {
				case "L":
					addLine();
					break;
				case "R":
					addRectangle();
					break;
				case "B":
					addBucketFill();
					break;
			}
		}
	}
	
	private void scanFirstLine() throws FileNotFoundException{
		sc = new Scanner(input);
		String line1 = null;
		if( sc.hasNextLine() ){
			line1 = sc.nextLine();
		}
		if( line1 != null && !line1.isEmpty() ){
			commands = line1.split("\\s+");
		}
	}

}
