package tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

import application.MyWindow;

@SuppressWarnings("serial")
public class Circle extends Shape {
	
	private MouseListener _ml;

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
	     Ellipse2D.Float sign1 = new Ellipse2D.Float(5, 5, _pointEnd.get_x()-_pointStart.get_x(), _pointEnd.get_y()-_pointStart.get_y()); 
	     
	     if (_style == 0){	//dashed
	    	 float f1[] = {12.0f};
	    	 g2.setStroke(new BasicStroke((float)_weight, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 12.0f, f1, 0.0f));
	     }
	     else{
	    	 g2.setStroke(new BasicStroke((float)_weight, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	     }
	     
	     g2.draw(sign1); 
    }

	@Override
	public MouseListener getMl() {
		return _ml;
	}

	@Override
	public void setMl(MouseListener m) {
		_ml = m;
	}
	
	@Override
	public void addML(int x) {
		if (x == 1){	// Move
			_ml = new MouseAdapter() {
				private LocationVector nsl;
				private LocationVector nel;
				
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println("Pressed Rectangle: " + e.getX() + ", " + e.getY());
					nsl = new LocationVector(e.getX(), e.getY());
					
				}
				@SuppressWarnings("static-access")
				@Override
				public void mouseReleased(MouseEvent e) {
					System.out.println("Released Rectangle: " + e.getX() + ", " + e.getY());
					nel = new LocationVector(e.getX(), e.getY());
					moveThatShape(nsl, nel);
					MyWindow x = new MyWindow();
					x.getInstance().updateUI();
					//x.getInstance().getWidth();
					System.out.println(x.getInstance().getWidth());
				}
			};
		}
		else if (x == 2){	// Resize
			_ml = new MouseAdapter() {
				private LocationVector nsl;
				private LocationVector nel;
				
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println("Pressed Circle: " + e.getX() + ", " + e.getY());
					nsl = new LocationVector(e.getX(), e.getY());
					
				}
				@SuppressWarnings("static-access")
				@Override
				public void mouseReleased(MouseEvent e) {
					System.out.println("Released Circle: " + e.getX() + ", " + e.getY());
					nel = new LocationVector(e.getX(), e.getY());
					resizeThatShape(nsl, nel);
					MyWindow x = new MyWindow();
					x.getInstance().updateUI();
					//x.getInstance().getWidth();
					System.out.println(x.getInstance().getWidth());
				}
			};
		}
		this.addMouseListener(_ml);
	}
	
	@Override
	public void moveThatShape(LocationVector s, LocationVector e){
		setPointStart(new LocationVector(_pointStart.get_x() +e.get_x(), _pointStart.get_y() + e.get_y()));
		setPointEnd(new LocationVector(_pointEnd.get_x() + e.get_x(), _pointEnd.get_y() + e.get_y()));
	}

	@Override
	public void resizeThatShape(LocationVector s, LocationVector e) {
		setPointEnd(new LocationVector(_pointStart.get_x() +e.get_x(), _pointStart.get_y() + e.get_y()));
	}
}
