package com.huge.code.common;

/**
 * @author Felipe
 * @version 1.0
 * Represents must of the characters presented accross the project
 * */
public enum Chars {

	X('x'), SPACE(' '), O('o'), C('C'), L('L'), R('R'), B('B'), DASH('-'), PIPE('|');
	
	private char c;
	
	Chars(char c){
		this.c = c;
	}
	
	public static Chars getCharForName(final char c){
        for (Chars type : Chars.values())
            if (type.c == c)
                return type;

        return null;
    }
	
	/**
	 * @return char
	 * returns the char of a current enumeration
	 * */
	public char asChar() {
        return c;
    }
	
	/**
	 * @return String
	 * returns the String of a current enumeration
	 * */
	public String asString(){
		return Character.toString(c) ;
	}
}
