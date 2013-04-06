package commands;

import java.util.List;

import tools.Canvas;
import tools.Shape;

@SuppressWarnings("static-access")
public class Paste implements Command {

	Canvas _c;
	int sizeBeforePasting;
	ShapesReciever sr = new ShapesReciever();
	
	public Paste(Canvas c){
		_c = c;
	}
	
	@Override
	public void execute() {
		sizeBeforePasting = _c.getShapeListSize();
		List<Shape> newElements = sr.getInstance().paste();
		for (int i = 0; i < newElements.size(); i++){
			_c.addToShapeList(newElements.get(i));
		}
	}

	@Override
	public void unexecute() {
		for (int i = _c.getShapeListSize()-1; i > sizeBeforePasting; i--){
			_c.getShapeList().get(i).setVisible(false);
			_c.getShapeList().remove(i);
		}
	}

}
