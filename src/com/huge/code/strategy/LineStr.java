package com.huge.code.strategy;

import java.util.ArrayList;
import java.util.List;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.LineCommand;
import com.huge.code.common.Chars;
import com.huge.code.strategy.base.Strategy;

/**
 * @author Felipe
 * @version 1.0
 * Represents the strategy to draw a Line
 * */
public class LineStr implements Strategy {

	private List<LineCommand> commands;
	
	public LineStr(){
		commands = new ArrayList<>();
	}

	public LineStr(LineCommand line) {
		commands = new ArrayList<>();
		addCommand( line );
	}

	@Override
	public void drawIn(BasicCanvas canvas) {
		if( commands.size()>0  ){
			for( LineCommand command : commands ){
				if (command.isHorizontal()) {
					for (int i = command.getY1(); i < command.getY2(); i++) {
						canvas.setChar(command.getX1(), i, Chars.X.asChar());
					}
				} else {
					for (int i = command.getX1(); i <= command.getX2(); i++) {
						canvas.setChar(i, command.getY1(), Chars.X.asChar());
					}
				}
			}
		}
	}
	
	/**
	 * @param command represent the command of a line
	 * adds the list of commands to be executed
	 * */
	public void addCommand( LineCommand command ){
		commands.add(command);
	}
	
	public List<LineCommand> getCommands( ){
		return commands;
	}

}
