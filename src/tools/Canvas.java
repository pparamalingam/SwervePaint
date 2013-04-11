package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;

import application.Global;
import application.MyWindow;

import commands.Colour;
import commands.Copy;
import commands.Group;
import commands.Ungroup;
import commands.Invoker;
import commands.Move;
import commands.Paste;
import commands.Size;
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
  
  public int getShapeListSize(){
   return _shapes.size();
  }

  public List<Shape> getShapeList(){
   return _shapes;
  }
  
  public void setShapeList(List<Shape> _shapes) {
   this._shapes = _shapes;
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
  public void setGroup() {
   ArrayList<Shape> backupList = new ArrayList<Shape>();
   for(Shape s : _shapes) {
       backupList.add(s.getACopy());
   }
   System.out.println("Called Set Group ");
   Invoker invoker = new Invoker();
   Group cmd = new Group(this, backupList );
   invoker.getInstance().storeAndExecute(cmd);
   MyWindow mywindow = new MyWindow();
   mywindow.getInstance().updateUI();
  }

  @Override
  public void setUngroup() {
	   ArrayList<Shape> backupList = new ArrayList<Shape>();
	   for(Shape s : _shapes) {
	       backupList.add(s.getACopy());
	   }
	   System.out.println("Called Set Ungroup ");
	   Invoker invoker = new Invoker();
	   Ungroup cmd = new Ungroup(this, backupList );
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
   if (s.isCanvas()){
	   System.out.println("ITS A CANVAS");
   }
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
  public void moveThatShape(LocationVector s, LocationVector e){
   LocationVector newStarter = new LocationVector(_pointStart.get_x() + e.get_x() - ((_pointEnd.get_x() - _pointStart.get_x()) / 2), _pointStart.get_y() + e.get_y() - ((_pointEnd.get_y() - _pointStart.get_y()) / 2));
   LocationVector newEnder  = new LocationVector(_pointEnd.get_x() + e.get_x() -  ((_pointEnd.get_x() - _pointStart.get_x()) / 2), _pointEnd.get_y() + e.get_y() - ((_pointEnd.get_y() - _pointStart.get_y()) / 2)); 
   if (newStarter.get_x() > 0 && newStarter.get_y() >0 && newStarter.get_x() < Global.MAXSIZE && newStarter.get_y() < Global.MAXSIZE &&
     newEnder.get_x() > 0 && newEnder.get_y() >0 && newEnder.get_x() < Global.MAXSIZE && newEnder.get_y() < Global.MAXSIZE){
    setPointStart(newStarter);
    setPointEnd(newEnder);
   }
  }

  @Override
  public void addML(int x) {
   if (x == 1){ // Move
    _ml = new MouseAdapter() {
     private LocationVector nsl;
     private LocationVector nel;
     
     @Override
     public void mousePressed(MouseEvent e) {
      System.out.println("Pressed newCanvas: " + e.getX() + ", " + e.getY());
      nsl = new LocationVector(e.getX(), e.getY());
      
     }
     @SuppressWarnings("static-access")
     @Override
     public void mouseReleased(MouseEvent e) {
      nel = new LocationVector(e.getX(), e.getY());
      Invoker invoker = new Invoker();
      Move cmd = new Move(getThis(), nsl, nel);
      invoker.getInstance().storeAndExecute(cmd);
      MyWindow x = new MyWindow();
      x.getInstance().updateUI();
     }
    };
   }
   else if (x == 2){ // Resize
    _ml = new MouseAdapter() {
     private LocationVector nsl;
     private LocationVector nel;
     
     @Override
     public void mousePressed(MouseEvent e) {
      //System.out.println("Pressed Rectangle: " + e.getX() + ", " + e.getY());
      nsl = new LocationVector(e.getX(), e.getY());
      
     }
     @SuppressWarnings("static-access")
     @Override
     public void mouseReleased(MouseEvent e) {
      //System.out.println("Released Rectangle: " + e.getX() + ", " + e.getY());
      nel = new LocationVector(e.getX(), e.getY());
      Invoker invoker = new Invoker();
      Size cmd = new Size(getThis(), nsl, nel);
      invoker.getInstance().storeAndExecute(cmd);
      MyWindow x = new MyWindow();
      x.getInstance().updateUI();
     }
    };
   }
   else if (x == 3){ // Selected
    _ml = new MouseAdapter() {    
     @SuppressWarnings("static-access")
     @Override
     public void mouseClicked(MouseEvent e) {
      selectThatShape();
      MyWindow x = new MyWindow();
      x.getInstance().updateUI();
      x.getInstance().getWidth();
     }
    };
   }
   System.out.println("THE MOUSE LISTENER HAS BEEN SET FOR " + x);
   this.addMouseListener(_ml);
  }
  
  public Shape getThis(){
   return this;
  }

  @Override
  public void resizeThatShape(LocationVector s, LocationVector e) {
   // gtfo
   // will be used to resize groups
   
  }

  @Override
  public void selectThatShape() {
	  if (!_selected){
			_selected = true;
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		}
		else { //(_selected)
			_selected = false;
			setBorder(null);
		}
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

  public void pasteBuffer() {
   Invoker invoker = new Invoker();
   Paste cmd = new Paste(this);
   invoker.getInstance().storeAndExecute(cmd);
   MyWindow mywindow = new MyWindow();
   mywindow.getInstance().updateUI();
  }

  public void copySelected() {
   List<Shape> _temp = new ArrayList<Shape>();
   for (int i = 0; i < _shapes.size(); i++){
    if (_shapes.get(i).isSelected()){
     _temp.add(_shapes.get(i));
    }
   }
   Invoker invoker = new Invoker();
   Copy cmd = new Copy(_temp);
   invoker.getInstance().storeAndExecute(cmd);
   MyWindow mywindow = new MyWindow();
   mywindow.getInstance().updateUI();
  }

  @Override
  public Shape getACopy() {
   return null;
  }

  public void saveCanvas(JFileChooser filename) {
   MyWindow mywindow = new MyWindow();
   mywindow.newFile(filename, _shapes);
   
  }

  public void openCanvas(JFileChooser filename) {
   MyWindow mywindow = new MyWindow();
   _shapes = (List<Shape>) mywindow.openFile(filename);
   mywindow.getInstance().updateUI();
   
  }

  public void groupThemShapes() {
   int startGroupX=1000, startGroupY=1000, endGroupX=0, endGroupY=0;
   for (int i=0; i<_shapes.size(); i++){
    if (_shapes.get(i).isSelected()){
     if(_shapes.get(i).getPointStart().get_x() < startGroupX){
      startGroupX = _shapes.get(i).getPointStart().get_x();
     }
     if(_shapes.get(i).getPointStart().get_y() < startGroupY){
      startGroupY = _shapes.get(i).getPointStart().get_y();
      
     } 
     if(_shapes.get(i).getPointEnd().get_x() > endGroupX){
      endGroupX = _shapes.get(i).getPointEnd().get_x();
     }
     if(_shapes.get(i).getPointEnd().get_y() > endGroupY){
      endGroupY = _shapes.get(i).getPointEnd().get_y();
      
     } 
    }
   }
   System.out.println(startGroupX + " " + startGroupY + " " + endGroupX + " " + endGroupY);
   Canvas newCanvas = new Canvas(new LocationVector(startGroupX, startGroupY), new LocationVector(endGroupX, endGroupY), Color.WHITE, -1, -1);
   System.out.println (_shapes.size() + "PRESIZE");
   ArrayList<Integer> indexes = new ArrayList<Integer>();
   for (int i=0; i<_shapes.size(); i++){
    if (_shapes.get(i).isSelected()){
     System.out.println(_shapes.get(i).isSelected() + "88888888888");
     _shapes.get(i).setPointStart(new LocationVector(_shapes.get(i).getPointStart().get_x() - startGroupX, _shapes.get(i).getPointStart().get_y() - startGroupY));
     _shapes.get(i).setPointEnd(new LocationVector(_shapes.get(i).getPointEnd().get_x() - startGroupX, _shapes.get(i).getPointEnd().get_y() - startGroupY));
     
     newCanvas.addToShapeList(_shapes.get(i));
     indexes.add(i);
     
    }
   }
   _shapes.removeAll(newCanvas.getShapeList());
   System.out.println (_shapes.size() + "POSTSIZE");

   //newCanvas.setBorder(BorderFactory.createLineBorder(Color.black));
   _shapes.add(newCanvas);
  }
  
  public void ungroupThemShapes() {
	  for (int x=0; x<_shapes.size(); x++){
		  if (_shapes.get(x).isSelected() && _shapes.get(x).isCanvas()){
			  Canvas canvas = (Canvas)_shapes.get(x);
			  int xDim = canvas.getX();
			  int yDim = canvas.getY();
			  List<Shape> canvasShapes = canvas.getShapeList();
			  for (int i=0; i<canvasShapes.size(); i++) {
				  canvasShapes.get(i).setPointStart(new LocationVector(canvasShapes.get(i).getPointStart().get_x()+xDim, canvasShapes.get(i).getPointStart().get_y()+yDim));
				  canvasShapes.get(i).setPointEnd(new LocationVector(canvasShapes.get(i).getPointEnd().get_x()+xDim, canvasShapes.get(i).getPointEnd().get_y()+yDim));
				  canvasShapes.get(i).addML(1);
				  _shapes.add(canvasShapes.get(i));
				  System.out.println(i);
			  }
			  _shapes.remove(canvas);
		  } 
	  }
  }

@Override
public boolean isCanvas() {
	// TODO Auto-generated method stub
	return true;
}

}
