package tools;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	
	public Triangle(LocationVector _tempFirstCoord,
			LocationVector _tempSecondCoord, Color theColor, int theWeight,
			int theStyle) {
		_pointStart = _tempFirstCoord;
		_pointEnd = _tempSecondCoord;
		_color = theColor;
		_weight = theWeight;
		_style = theStyle;
	}
	
	@Override
	public LocationVector getPointStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationVector getPointEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPointStart(LocationVector x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPointEnd(LocationVector x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWeight(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStyle(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean resize(LocationVector start, LocationVector end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

		
}
