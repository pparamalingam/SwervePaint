package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import application.MyWindow;

import commands.Colour;
import commands.Invoker;
import commands.Stroke;
import commands.Thickness;

@SuppressWarnings({"serial", "static-access"})
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
			return _pointStart;
		}

		@Override
		public LocationVector getPointEnd() {
			return _pointEnd;
		}

		@Override
		public Color getColor() {
			return _color;
		}

		@Override
		public int getWeight() {
			return _weight;
		}

		@Override
		public int getStyle() {
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
		public void setWeight(int x) {
			List<Shape> _temp = new ArrayList<Shape>();
			System.out.println("Called Set Style " + x);
			for (int i = 0; i < _shapes.size(); i++){
				System.out.println("FOUND A SHAPE");
				if (_shapes.get(i).isSelected()){
					System.out.println("FOUND A SELECTED SHAPE");
					_temp.add(_shapes.get(i));
				}
			}
			Invoker invoker = new Invoker();
			Thickness cmd = new Thickness(_temp, x);
			invoker.getInstance().storeAndExecute(cmd);
			MyWindow mywindow = new MyWindow();
			mywindow.getInstance().updateUI();
		}

		@Override
		public void setStyle(int x) {
			List<Shape> _temp = new ArrayList<Shape>();
			System.out.println("Called Set Style " + x);
			for (int i = 0; i < _shapes.size(); i++){
				System.out.println("FOUND A SHAPE");
				if (_shapes.get(i).isSelected()){
					System.out.println("FOUND A SELECTED SHAPE");
					_temp.add(_shapes.get(i));
				}
			}
			Invoker invoker = new Invoker();
			Stroke cmd = new Stroke(_temp, x);
			invoker.getInstance().storeAndExecute(cmd);
			MyWindow mywindow = new MyWindow();
			mywindow.getInstance().updateUI();
		}
		
		@Override
		public void setColor(Color x) {
			List<Shape> _temp = new ArrayList<Shape>();
			System.out.println("Called Set Style " + x);
			for (int i = 0; i < _shapes.size(); i++){
				System.out.println("FOUND A SHAPE");
				if (_shapes.get(i).isSelected()){
					System.out.println("FOUND A SELECTED SHAPE");
					_temp.add(_shapes.get(i));
				}
			}
			Invoker invoker = new Invoker();
			Colour cmd = new Colour(_temp, x);
			invoker.getInstance().storeAndExecute(cmd);
			MyWindow mywindow = new MyWindow();
			mywindow.getInstance().updateUI();
		}

		@Override
		public boolean resize(LocationVector start, LocationVector end) {
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
		@Override
		public boolean isSelected() {
			return _selected;
		}

		public void removeLastFromShapeList() {
			_shapes.get(_shapes.size()-1).setVisible(false);
			_shapes.remove(_shapes.size()-1);
		}

}
