package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;

import tools.Canvas;
import tools.Circle;
import tools.Line;
import tools.Rectangle;
import tools.LocationVector;
import tools.Triangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.io.File;

import javax.swing.JSeparator;

import commands.CanvasComponent;
import commands.Invoker;

@SuppressWarnings("serial")
public class Landing extends JFrame {
	public int MAXSIZE = Global.MAXSIZE;
	
	private MyWindow _myWindow;		//JFRAME - For singleton pattern
	private Canvas _bigCanvas = new Canvas(new LocationVector(0,0), new LocationVector(MAXSIZE, MAXSIZE), Color.WHITE, -1, -1);		//The original canvas that holds everything else
	
	private LocationVector _tempFirstCoord;
	private LocationVector _tempSecondCoord;
	
	//Colour Menu Options
	private JRadioButtonMenuItem rdbtnmntmBlack = new JRadioButtonMenuItem("Black");
	private JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
	private JRadioButtonMenuItem rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
	private JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
	
	//Style Menu Options
	private JRadioButtonMenuItem rdbtnmntmSolid = new JRadioButtonMenuItem("Solid");
	private JRadioButtonMenuItem rdbtnmntmDashed = new JRadioButtonMenuItem("Dashed");
	
	//Shape Options
	private JToggleButton tglbtnCircle = new JToggleButton("Circle");
	private JToggleButton tglbtnTriangle = new JToggleButton("Triangle");
	private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglbtnLine = new JToggleButton("Line");
	
	//Weight Options
	private JSlider slider = new JSlider();
	
	//Select/Move
	private JToggleButton tglbtnResize = new JToggleButton("Resize");
	private JToggleButton tglbtnMove = new JToggleButton("Move");
	private JToggleButton tglbtnSelect = new JToggleButton("Select"); 
	
	//Undo and Redo Buttons
	JMenuItem mntmUndo = new JMenuItem("Undo");
	JMenuItem mntmRedo = new JMenuItem("Redo");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing frame = new Landing();
					frame.setSize(600,600);
					frame.setVisible(true);
					frame.setTitle("SwervePaint");
					frame.setSize(600,600);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "static-access" })
	public Landing() {
		@SuppressWarnings("unused")
		Invoker invokeACommand = new Invoker();
		
		setSize(new Dimension(800, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		
		mnEdit.add(mntmUndo);
		mnEdit.add(mntmRedo);
		
		mnEdit.addSeparator();
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);
		
		JMenuItem mntmGroup = new JMenuItem("Group");
		mnEdit.add(mntmGroup);
		
		JMenuItem mntmUngroup = new JMenuItem("Ungroup");
		mnEdit.add(mntmUngroup);
		
		
		JMenu mnShapeOptions = new JMenu("Shape Options");
		menuBar.add(mnShapeOptions);
		
		//Colours
		JMenu mnColour = new JMenu("Colour");
		mnShapeOptions.add(mnColour);
		rdbtnmntmBlack.setSelected(true);
		mnColour.add(rdbtnmntmBlack);
		mnColour.add(rdbtnmntmRed);
		mnColour.add(rdbtnmntmGreen);
		mnColour.add(rdbtnmntmBlue);
		ButtonGroup g1 = new ButtonGroup();
		g1.add(rdbtnmntmRed);
		g1.add(rdbtnmntmGreen);
		g1.add(rdbtnmntmBlue);
		g1.add(rdbtnmntmBlack);
		
		//Styles
		JMenu mnStyle = new JMenu("Style");
		mnShapeOptions.add(mnStyle);
		rdbtnmntmSolid.setSelected(true);
		mnStyle.add(rdbtnmntmSolid);
		mnStyle.add(rdbtnmntmDashed);
		ButtonGroup g2 = new ButtonGroup();
		g2.add(rdbtnmntmSolid);
		g2.add(rdbtnmntmDashed);
		
		JMenu mnNewMenu = new JMenu("Help\r\n");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu.add(mntmAbout);
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Made By Husain Fazal & Preshoth Paramalingam", "About", JOptionPane.DEFAULT_OPTION);
				System.out.println("HELP");
			}
		});
		
		
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		rdbtnmntmSolid.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setStyle(1);
			}
		});
		
		rdbtnmntmDashed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setStyle(0);
			}
		});
		
		_myWindow = new MyWindow();
		_myWindow = _myWindow.getInstance();
		_myWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		_myWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(_myWindow);
		
		updateRedoAndUndoButtons(true, true);
		
		mntmUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Invoker invoker = new Invoker();
				invoker.getInstance().undoLast();
			}
		});
		
		mntmRedo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Invoker invoker = new Invoker();
				invoker.getInstance().redoLast();
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (!slider.getValueIsAdjusting()){
					_bigCanvas.setWeight(slider.getValue());
				}
			}
		});
		rdbtnmntmBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setColor(Color.BLACK);
			}
		});
		rdbtnmntmRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setColor(Color.RED);
			}
		});
		rdbtnmntmGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setColor(Color.GREEN);
			}
		});
		rdbtnmntmBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setColor(Color.BLUE);
			}
		});
		
		tglbtnMove.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
				_bigCanvas.addShapeListeners(1);	//Enable move listeners
			}
		});
		
		tglbtnResize.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
				_bigCanvas.addShapeListeners(2);	//Enable resize listeners
			}
		});
		
		tglbtnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
				_bigCanvas.addShapeListeners(3);	//Enable Select listeners
			}
		});
		
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
			}
		});
		tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
			}
		});
		tglbtnTriangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
			}
		});
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.removeShapeListeners();
			}
		});
		
		mntmCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.copySelected();
			}
		});
		
		mntmPaste.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.pasteBuffer();
			}
		});
		
		mntmSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");    
				 
				int userSelection = fileChooser.showSaveDialog(_myWindow);
				//System.out.println(fileChooser.getSelectedFile());
				if (userSelection == fileChooser.APPROVE_OPTION){
					_bigCanvas.saveCanvas(fileChooser);
				}
			}
		});
		
		mntmOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to open");    
				 
				int userSelection = fileChooser.showOpenDialog(_myWindow);
				//System.out.println(fileChooser.getSelectedFile());
				if (userSelection == fileChooser.APPROVE_OPTION){
					_bigCanvas.openCanvas(fileChooser);
				}
			}
		});
		
		mntmGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setGroup();
				   
			}
		});
		
		mntmUngroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_bigCanvas.setUngroup();
			}
		});
		
		_bigCanvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed: " + e.getX() + ", " + e.getY());
				_tempFirstCoord = new LocationVector(e.getX(), e.getY());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Released: " + e.getX() + ", " + e.getY());
				_tempSecondCoord = new LocationVector(e.getX(), e.getY());
				_tempFirstCoord.refractor(MAXSIZE);
				_tempSecondCoord.refractor(MAXSIZE);
				//make shape
				
				Color theColor = Color.BLACK;
				int theWeight = 1;
				int theStyle = 1;
				
				//Check for color
				if (rdbtnmntmBlack.isSelected()){
					theColor = Color.BLACK;
				}
				else if (rdbtnmntmRed.isSelected()){
					theColor = Color.RED;
				}
				else if (rdbtnmntmGreen.isSelected()){
					theColor = Color.GREEN;
				}
				else if (rdbtnmntmBlue.isSelected()){
					theColor = Color.BLUE;
				}
				
				//Check for style
				if (rdbtnmntmSolid.isSelected()){
					theStyle = 1;
				}
				else if (rdbtnmntmDashed.isSelected()){
					theStyle = 0;
				}
				
				//Check for Weight
				theWeight = slider.getValue();
				
				//Check for shape
				if (tglbtnLine.isSelected()){
					Line shape = new Line(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					CanvasComponent cmd = new CanvasComponent(_bigCanvas, shape);
					Invoker invoker = new Invoker();
					invoker.getInstance().storeAndExecute(cmd);
				}
				else if (tglbtnRectangle.isSelected()){
					Rectangle shape = new Rectangle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					CanvasComponent cmd = new CanvasComponent(_bigCanvas, shape);
					Invoker invoker = new Invoker();
					invoker.getInstance().storeAndExecute(cmd);
				}
				else if (tglbtnTriangle.isSelected()){
					Triangle shape = new Triangle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					CanvasComponent cmd = new CanvasComponent(_bigCanvas, shape);
					Invoker invoker = new Invoker();
					invoker.getInstance().storeAndExecute(cmd);
				}
				else if (tglbtnCircle.isSelected()){
					Circle shape = new Circle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					CanvasComponent cmd = new CanvasComponent(_bigCanvas, shape);
					Invoker invoker = new Invoker();
					invoker.getInstance().storeAndExecute(cmd);
				}

				_myWindow.updateUI();
			}
		});
		
		_bigCanvas.setBackground(Color.WHITE);
		_bigCanvas.setPreferredSize(new Dimension(MAXSIZE,MAXSIZE));
		_myWindow.add(_bigCanvas, BorderLayout.WEST);
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		//Shapes
		JToolBar toolBar = new JToolBar();
		_myWindow.add(toolBar, BorderLayout.NORTH);
		tglbtnLine.setSelected(true);
		toolBar.add(tglbtnLine);
		toolBar.add(tglbtnRectangle);
		toolBar.add(tglbtnCircle);
		toolBar.add(tglbtnTriangle);
		toolBar.add(separator);
		toolBar.add(tglbtnResize);
		toolBar.add(tglbtnMove);
		toolBar.add(tglbtnSelect);
		toolBar.add(separator_1);
		ButtonGroup g3 = new ButtonGroup();
		g3.add(tglbtnLine);
		g3.add(tglbtnRectangle);
		g3.add(tglbtnCircle);
		g3.add(tglbtnTriangle);
		g3.add(tglbtnResize);
		g3.add(tglbtnMove);
		g3.add(tglbtnSelect);
	
		
		slider.setFont(new Font("Tahoma", Font.PLAIN, 6));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setValue(1);
		slider.setToolTipText("Weight");
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(10);
		toolBar.add(slider);
	}

	public void updateRedoAndUndoButtons(boolean redo, boolean undo){
		System.out.println("LOL: " + redo + " " + undo);
		mntmRedo.setEnabled(redo);
		mntmUndo.setEnabled(undo);
	}
}
