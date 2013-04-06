package commands;

import java.util.ArrayList;
import java.util.List;

import tools.Shape;

@SuppressWarnings("static-access")
public class Copy implements Command {

	List<Shape> _s = new ArrayList<Shape>();
	ShapesReciever sr = new ShapesReciever();
	
	public Copy(List<Shape> s){
		_s = s;
	}
	
	@Override
	public void execute() {
		sr.getInstance().copy(_s);
	}

	@Override
	public void unexecute() {
		//nothing to undo
	}

}
