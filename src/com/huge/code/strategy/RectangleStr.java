package com.huge.code.strategy;

import java.util.ArrayList;
import java.util.List;

import com.huge.code.canvas.BasicCanvas;
import com.huge.code.command.RectangleCommand;
import com.huge.code.strategy.base.Strategy;

/**
 * @author Felipe
 * @version 1.0
 * Represents the strategy to draw a rectangle
 * */
public class RectangleStr  implements Strategy {
	
	private List<RectangleCommand> commands;

	public RectangleStr(){
		commands = new ArrayList<>();
	}
	
	public RectangleStr(RectangleCommand rectangle) {
		commands = new ArrayList<>();
		addCommand(rectangle);
	}
	
	@Override
	public void drawIn(BasicCanvas canvas) {
		if( commands.size() > 0 ){
			for( RectangleCommand rectangleCommand : commands ){
				LineStr lineStr = new LineStr();
				lineStr.addCommand(rectangleCommand.getLine1());
				lineStr.addCommand(rectangleCommand.getLine2());
				lineStr.addCommand(rectangleCommand.getLine3());
				lineStr.addCommand(rectangleCommand.getLine4());
				lineStr.drawIn(canvas);
			}
		}
		
	}
	
	/**
	 * @param command represent the command of a rectangle
	 * adds the list of commands to be executed
	 * */
	public void addCommand( RectangleCommand command ){
		commands.add(command);
	}
	
	public List<RectangleCommand> getCommands( ){
		return commands;
	}
	
}
