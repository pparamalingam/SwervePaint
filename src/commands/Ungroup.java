package commands;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;

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
	//_c = _oldC; 
	_c.groupThemShapes();
 }

}
