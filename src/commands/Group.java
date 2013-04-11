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
		for(Shape s : _c.getShapeList()) {
			s.setVisible(false);
		}
		_c.getShapeList().clear();
		_c.setShapeList(_oldC);
	}

}
