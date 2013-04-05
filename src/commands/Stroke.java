package commands;

import tools.Shape;

public class Stroke implements Command {

	Shape _s;
	int _oldStyle;
	int _newStyle;
	
	public Stroke(Shape s, Boolean solid){
		_s = s;
		if (solid){
			_newStyle = 1;	//solid
		}
		else {
			_newStyle = 0;	//dashed
		}
		_oldStyle = s.getStyle();
	}
	
	@Override
	public void execute() {
		_s.setStyle(_newStyle);
	}

	@Override
	public void unexecute() {
		_s.setStyle(_oldStyle);
	}

}
