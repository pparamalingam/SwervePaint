package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends Shape {
		private List<Shape> _shapes = new ArrayList<Shape>();

		public Canvas(LocationVector _tempFirstCoord,
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
		
		public void addToShapeList(Shape x){
			_shapes.add(x);
		}
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			System.out.println("DRAW (via canvas paintcomponent)");
			for (int i = 0; i < _shapes.size(); i++){
				Shape shapeInstance = _shapes.get(i);
				shapeInstance.setOpaque(false);
				shapeInstance.setVisible(true);
				shapeInstance.setSize(100, 100);
				shapeInstance.setLocation(shapeInstance.getPointStart().get_x(), shapeInstance.getPointStart().get_y());
				shapeInstance.setSize(shapeInstance.getPointEnd().get_x()-shapeInstance.getPointStart().get_x(), shapeInstance.getPointEnd().get_y()-shapeInstance.getPointStart().get_y());
				this.add(shapeInstance);
				System.out.println(i);
			}
	    }

}
