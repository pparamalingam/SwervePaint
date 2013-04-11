package commands;

import java.util.ArrayList;

import tools.Canvas;
import tools.Shape;

public class Ungroup implements Command {
 
 Canvas _c;
 ArrayList<Shape> _oldC = new ArrayList<Shape>();;
 
 public Ungroup(Canvas curr, ArrayList<Shape> backup ){
  _c = curr;
  _oldC = backup;
 }
 
 @Override
 public void execute() {
  _c.ungroupThemShapes();
 }

 @Override
 public void unexecute() {
  _c.setBorder(null);
  _c.setShapeList(_oldC);
 }

}
