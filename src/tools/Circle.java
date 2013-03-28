package tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Circle extends Shape {
	
	private BufferedImage i;

	public Circle(LocationVector _tempFirstCoord,
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
	     Ellipse2D.Float sign1 = new Ellipse2D.Float(0, 0, this.getWidth(), this.getHeight()); 
	     
	     if (_style == 0){	//dashed
	    	 float f1[] = {12.0f};
	    	 g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 12.0f, f1, 0.0f));
	     }
	     
	     g2.draw(sign1); 
    }


}
