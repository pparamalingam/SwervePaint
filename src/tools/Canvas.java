package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends Shape {
		private List<Shape> _shapes = new ArrayList<Shape>();

		public Canvas(int maxsize) {
			_pointStart = new LocationVector(0,0);
			_pointEnd = new LocationVector(maxsize,maxsize);
			_color = Color.WHITE;
			_weight = -1;
			_style = -1;
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
		
		public void addToShapeList(Shape x){
			_shapes.add(x);
		}

		/*@Override
		public void draw(Graphics g) {
			
		}*/

		@Override
		public void draw() {
			for (int i = 0; i < _shapes.size(); i++){
				_shapes.get(i).draw();
				System.out.println("DRAW (via canvas)");
			}
		}

}
