package commands;

import java.util.ArrayList;
import java.util.List;

import tools.Shape;

public class Stroke implements Command {

	List<Shape> _s = new ArrayList<Shape>();
	List<Integer> _oldS = new ArrayList<Integer>();
	int _solid;
	
	public Stroke(List<Shape> s, int solid){
		_s = s;
		_solid = solid;
		for (int i = 0; i < _s.size(); i++){
			_oldS.add(_s.get(i).getStyle());
		}
	}
	
	@Override
	public void execute() {
		for (int i = 0; i < _s.size(); i++){
			_s.get(i).setStyle(_solid);
		}
	}

	@Override
	public void unexecute() {
		for (int i = 0; i < _s.size(); i++){
			System.out.println("OLD INT TO GO BACK TO " + _oldS.get(i));
			_s.get(i).setStyle(_oldS.get(i));
		}
	}

}
