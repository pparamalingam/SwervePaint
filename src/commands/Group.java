package commands;

import java.util.ArrayList;

import tools.Canvas;
import tools.Shape;

public class Group implements Command {
	
	Canvas _c;
	ArrayList<Shape> _oldC = new ArrayList<Shape>();;
	
	public Group(Canvas curr, ArrayList<Shape> backup ){
		_c = curr;
		_oldC = backup;
	}
	
	@Override
	public void execute() {
		_c.groupThemShapes();
	}

	@Override
	public void unexecute() {
		_c.setBorder(null);
		_c.setShapeList(_oldC);
	}

}
