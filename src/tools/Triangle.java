package tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
		return _pointStart;
	}

	@Override
	public LocationVector getPointEnd() {
		// TODO Auto-generated method stub
		return _pointEnd;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return _color;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return _weight;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return _style;
	}

	@Override
	public void setPointStart(LocationVector x) {
		_pointStart = x;		
	}

	@Override
	public void setPointEnd(LocationVector x) {
		_pointEnd = x;
	}

	@Override
	public void setColor(Color x) {
		_color = x;
	}

	@Override
	public void setWeight(int x) {
		_weight = x;
	}

	@Override
	public void setStyle(int x) {
		_style = x;
	}

	@Override
	public boolean resize(LocationVector start, LocationVector end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g); 
	     Graphics2D g2 = (Graphics2D) g; 

	     g2.setColor(this._color);
	     Rectangle2D.Float sign1 = new Rectangle2D.Float(5, 5, _pointEnd.get_x()-_pointStart.get_x(), _pointEnd.get_y()-_pointStart.get_y()); 
	     
	     if (_style == 0){	//dashed
	    	 float f1[] = {12.0f};
	    	 g2.setStroke(new BasicStroke((float)_weight, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 12.0f, f1, 0.0f));
	     }
	     else{
	    	 g2.setStroke(new BasicStroke((float)_weight, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	     }
	     
	     g2.draw(sign1); 
    }


		
}
