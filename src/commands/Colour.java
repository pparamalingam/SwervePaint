package commands;

import java.awt.Color;

import tools.Shape;

public class Colour implements Command {

	Shape _s;
	Color _c;
	Color _oldColour;
	
	public Colour(Shape s, Color c){
		_s = s;
		_c = c;
		_oldColour = s.getColor();
	}
	
	@Override
	public void execute() {
		_s.setColor(_c);
	}

	@Override
	public void unexecute() {
		_s.setColor(_oldColour);
	}

}
