package tools;

public class LocationVector {
	private int _x;
	private int _y;
	
	public void refractor(int maxsize){
		if (_x < 0){
			_x = 0;
		}

		else if (_x > maxsize){
			_x = maxsize;
		}
		if (_y > maxsize){
			_y = maxsize;
		}
		else if (_y < 0){
			_y = 0;
		}
	}
	
	public String toString(){
		return "(" + _x + ", " + _y + ")";
	}
	
	public LocationVector(int x, int y){
		_x = x;
		_y = y;
	}
	
	public int get_x() {
		return _x;
	}
	public void set_x(int _x) {
		this._x = _x;
	}
	public int get_y() {
		return _y;
	}
	public void set_y(int _y) {
		this._y = _y;
	}
	
	
}
