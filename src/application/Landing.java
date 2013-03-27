package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
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
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;

public class Landing extends JFrame {
	public static final int MAXSIZE = 500;
	
	private MyWindow _myWindow;		//JFRAME - For singleton pattern
	private Canvas _bigCanvas = new Canvas(MAXSIZE);		//The original canvas that holds everything else
	private JPanel panel_1;	//This is the actual canvas
	
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
	public Landing() {
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
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		mnEdit.addSeparator();
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		mnEdit.addSeparator();
		
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
		mntmAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane jd = new JOptionPane("Made by Husain & Preshoth");
				jd.setVisible(true);
				System.out.println("HELP");
			}
		});
		mnNewMenu.add(mntmAbout);
		
		_myWindow = new MyWindow();
		_myWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		_myWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(_myWindow);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
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
					_bigCanvas.addToShapeList(shape);
				}
				else if (tglbtnRectangle.isSelected()){
					Rectangle shape = new Rectangle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					_bigCanvas.addToShapeList(shape);
				}
				else if (tglbtnTriangle.isSelected()){
					Triangle shape = new Triangle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					_bigCanvas.addToShapeList(shape);
				}
				else if (tglbtnCircle.isSelected()){
					Circle shape = new Circle(_tempFirstCoord, _tempSecondCoord, theColor, theWeight, theStyle);
					_bigCanvas.addToShapeList(shape);
				}
				
				_bigCanvas.draw();
				

				System.out.println("Make a shape at: " + _tempFirstCoord + " and " + _tempSecondCoord);
				
			}
		});
		
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(MAXSIZE,MAXSIZE));
		panel_1.setVisible(true);
		_myWindow.add(panel_1, BorderLayout.WEST);
		
		
		//Shapes
		JToolBar toolBar = new JToolBar();
		_myWindow.add(toolBar, BorderLayout.NORTH);
		tglbtnLine.setSelected(true);
		toolBar.add(tglbtnLine);
		toolBar.add(tglbtnRectangle);
		toolBar.add(tglbtnCircle);
		toolBar.add(tglbtnTriangle);
		ButtonGroup g3 = new ButtonGroup();
		g3.add(tglbtnLine);
		g3.add(tglbtnRectangle);
		g3.add(tglbtnCircle);
		g3.add(tglbtnTriangle);
		
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

}
