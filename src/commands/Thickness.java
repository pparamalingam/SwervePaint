package commands;
import java.util.ArrayList;
import java.util.List;

import tools.Shape;

public class Thickness implements Command {

	List<Shape> _s = new ArrayList<Shape>();
	List<Integer> _oldThickness = new ArrayList<Integer>();
	int _newThickness;
	
	public Thickness(List<Shape> s, int thickness){
		_s = s;
		_newThickness = thickness;
		for (int i = 0; i < _s.size(); i++){
			_oldThickness.add(_s.get(i).getWeight());
		}
	}
	
	@Override
	public void execute() {
		for (int i = 0; i < _s.size(); i++){
			_s.get(i).setWeight(_newThickness);
		}
	}

	@Override
	public void unexecute() {
		for (int i = 0; i < _s.size(); i++){
			//System.out.println("OLD INT TO GO BACK TO " + _oldC.get(i));
			_s.get(i).setWeight(_oldThickness.get(i));
		}
	}

}
