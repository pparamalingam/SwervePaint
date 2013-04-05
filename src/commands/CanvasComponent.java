package commands;

import tools.Canvas;
import tools.Shape;

public class CanvasComponent implements Command {
	Canvas _canvas;
	Shape _newShape;
	
	public CanvasComponent(Canvas c, Shape shapeToAdd){
		_canvas = c;
		_newShape = shapeToAdd;
	}
	
	@Override
	public void execute() {
		_canvas.addToShapeList(_newShape);
	}

	@Override
	public void unexecute() {
		_canvas.removeLastFromShapeList();
	}

}
