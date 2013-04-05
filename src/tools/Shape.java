package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public abstract class Shape extends JPanel{
	protected MouseListener _ml;
	protected LocationVector _pointStart;
	protected LocationVector _pointEnd;
	protected Color _color;
	protected int _weight;	//1-10
	protected int _style;	//1==Solid, 2==Dashed
	protected BufferedImage _bufImage = null;
	
	//getters
	public abstract LocationVector getPointStart();
	public abstract LocationVector getPointEnd();
	public abstract Color getColor();
	public abstract int getWeight();
	public abstract int getStyle();
	public abstract MouseListener getMl();
	
	//setters
	public abstract void setPointStart(LocationVector x);
	public abstract void setPointEnd(LocationVector x);
	public abstract void setColor(Color x);
	public abstract void setWeight(int x);
	public abstract void setStyle(int x);
	public abstract void setMl(MouseListener m);
	
	public abstract boolean resize(LocationVector start, LocationVector end);
	public abstract void addML(int x);
	public abstract void moveThatShape(LocationVector s, LocationVector e);
	public abstract void resizeThatShape(LocationVector s, LocationVector e);
}
