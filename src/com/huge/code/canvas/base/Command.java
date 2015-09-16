package com.huge.code.canvas.base;

/**
 * @author Felipe
 * @version 1.0
 * represents an interface for all sub commands
 * */
public class Command implements ICommand {

	/**
	 * represents an identifier for the subclasses
	 * */
	private char command;

	public char getCommand() {
		return command;
	}

	public void setCommand(char command) {
		this.command = command;
	}
	
}
