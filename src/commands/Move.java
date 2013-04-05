package commands; 

import application.MyWindow;
import tools.LocationVector;
import tools.Shape;

public class Move implements Command {

	Shape _s;
	LocationVector _oldStart;
	LocationVector _oldEnd;
	LocationVector _newStart;
	LocationVector _newEnd;
	
	public Move(Shape s, LocationVector newS, LocationVector newE){
		_s = s;
		_oldStart = s.getPointStart();
		_oldEnd = s.getPointEnd();
		_newStart = newS;
		_newEnd = newE; 
	}
	
	@Override
	public void execute() {
		_s.moveThatShape(_newStart, _newEnd);
	}

	@SuppressWarnings("static-access")
	@Override
	public void unexecute() {
		_s.setPointStart(_oldStart);
		_s.setPointEnd(_oldEnd);
		MyWindow x = new MyWindow();
		x.getInstance().updateUI();
	}

}
