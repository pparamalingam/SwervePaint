package tools;

import java.awt.Color;
import java.awt.geom.*;

@SuppressWarnings("unused")
public abstract class Shape {
	private LocationVector _pointStart = new LocationVector();
	private LocationVector _pointEnd = new LocationVector();
	private Color _color;
	private int _weight;
	private int _style;
	
	//getters
	public abstract LocationVector getPointStart();
	public abstract LocationVector getPointEnd();
	public abstract Color getColor();
	public abstract int getWeight();
	public abstract int getStyle();
	
	//setters
	public abstract void setPointStart(LocationVector x);
	public abstract void setPointEnd(LocationVector x);
	public abstract void setColor(Color x);
	public abstract void setWeight(int x);
	public abstract void setStyle(int x);
	
	public abstract boolean resize(LocationVector start, LocationVector end);
}
