package commands;

import java.util.ArrayList;
import java.util.List;

import tools.Shape;

public class ShapesReciever {
	private static volatile ShapesReciever instance = new ShapesReciever();
	List<Shape> _copyBuffer = new ArrayList<Shape>();
	
    public ShapesReciever() { }

    public static ShapesReciever getInstance(){
    	return instance;
    }
	
    public void copy(List<Shape> s){
    	_copyBuffer.clear();
    	for (int i = 0; i < s.size(); i++){
    		_copyBuffer.add(s.get(i).getACopy());
    	}    	
    }
    
    public List<Shape> paste(){
    	System.out.println(_copyBuffer.size() + " IS THE SIZE");
    	return _copyBuffer;
    }
}
