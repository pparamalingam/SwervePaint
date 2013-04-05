package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Canvas extends Shape {
		private List<Shape> _shapes = new ArrayList<Shape>();
		private Boolean _selected = false;

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
		
		public void addToShapeList(Shape x){
			_shapes.add(x);
		}
		
		public void addShapeListeners(int x){
			for (int i = 0; i < _shapes.size(); i++){
				addMoveListener(_shapes.get(i), x);
				System.out.println("swerve1");
			}
		}
		
		public void removeShapeListeners(){
			for (int i = 0; i < _shapes.size(); i++){
				removeMoveListener(_shapes.get(i));
				_shapes.get(i).unselect();
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//System.out.println("DRAW (via canvas paintcomponent)");
			// print in reverse order to give priority to newly created shapes
			for (int i = (_shapes.size() - 1); i >= 0; i--){
				Shape shapeInstance = _shapes.get(i);
				shapeInstance.setOpaque(false);
				shapeInstance.setVisible(true);
				shapeInstance.setLocation(shapeInstance.getPointStart().get_x(), shapeInstance.getPointStart().get_y());
				shapeInstance.setSize(shapeInstance.getPointEnd().get_x()-shapeInstance.getPointStart().get_x()+10, shapeInstance.getPointEnd().get_y()-shapeInstance.getPointStart().get_y()+10);
				this.add(shapeInstance);
			}
	    }

		public void addMoveListener(Shape s, int type) {
			System.out.println("ADD INDIVIDUAL SHAPE LISTENER" + type);
			s.addML(type);
		}

		public void removeMoveListener(Shape s) {
			System.out.println("KILL INDIVIDUAL SHAPE LISTENERS");
			s.removeMouseListener(s.getMl());
		}

		@Override
		public MouseListener getMl() {
			// gtfo
			return null;
		}

		@Override
		public void setMl(MouseListener m) {
			//gtfo
		}

		@Override
		public void moveThatShape(LocationVector s, LocationVector e) {
			// gtfo
			//will be used to move groups
		}

		@Override
		public void addML(int x) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resizeThatShape(LocationVector s, LocationVector e) {
			// gtfo
			// will be used to resize groups
			
		}

		@Override
		public void selectThatShape() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void unselect() {
			_selected = false;
			
		}
}
