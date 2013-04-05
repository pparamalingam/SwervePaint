package commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import tools.Shape;

public class Colour implements Command {

	List<Shape> _s = new ArrayList<Shape>();
	List<Color> _oldC = new ArrayList<Color>();
	Color _newColour;
	
	public Colour(List<Shape> s, Color c){
		_s = s;
		_newColour = c;
		for (int i = 0; i < _s.size(); i++){
			_oldC.add(_s.get(i).getColor());
		}
	}
	
	@Override
	public void execute() {
		for (int i = 0; i < _s.size(); i++){
			_s.get(i).setColor(_newColour);
		}
	}

	@Override
	public void unexecute() {
		for (int i = 0; i < _s.size(); i++){
			System.out.println("OLD INT TO GO BACK TO " + _oldC.get(i));
			_s.get(i).setColor(_oldC.get(i));
		}
	}

}
