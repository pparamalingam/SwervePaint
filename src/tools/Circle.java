package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	/*@Override
	public void draw(Graphics g) {
		((Graphics2D) g).draw(new Ellipse2D.Double(_pointStart.get_x(), _pointStart.get_y(), _pointEnd.get_x()-_pointStart.get_x(), _pointEnd.get_y()-_pointStart.get_y()));
	}*/

	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g); 
	     Graphics2D g2 = (Graphics2D) g; 

	     g2.setColor(this._color);
	     Ellipse2D.Float sign1 = new Ellipse2D.Float(0, 0, this.getWidth(), this.getHeight()); 
	     g2.fill(sign1); 
    }
	
	@Override
	public void draw() {
		/*this.updateUI();
		i = new BufferedImage(_pointEnd.get_x()-_pointStart.get_x(), _pointEnd.get_y()-_pointStart.get_y(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = this.i.createGraphics();
		g.drawLine(0, 0, 100, 100);
		System.out.println("DRAW (via circle)");*/
	}


}
