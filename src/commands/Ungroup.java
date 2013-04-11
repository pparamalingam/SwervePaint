package commands;

import java.util.ArrayList;

import tools.Canvas;
import tools.Shape;

public class Ungroup implements Command {
 
 Canvas _c, _oldC;

 
 public Ungroup(Canvas curr, Canvas backup ){
  _c = curr;
  _oldC = backup;
 }
 
 @Override
 public void execute() {
  _c.ungroupThemShapes();
 }

 @Override
 public void unexecute() {
	 for(Shape s : _c.getShapeList()) {
		s.setVisible(false);
	}
	_c.getShapeList().clear(); 
   _c.setShapeList(_oldC.getShapeList());
 }

}
