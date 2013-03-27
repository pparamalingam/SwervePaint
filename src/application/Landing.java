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
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Landing extends JFrame {
	private JPanel contentPane;	//This is the overall pane (menu and canvas)
	private MyWindow _myWindow;
	private JPanel panel_1;	//This is the actual canvas
	
//swerve
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
		
		JMenu mnColour = new JMenu("Colour");
		mnShapeOptions.add(mnColour);
		
		JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		mnColour.add(rdbtnmntmRed);
		
		JRadioButtonMenuItem rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
		mnColour.add(rdbtnmntmGreen);
		
		JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		mnColour.add(rdbtnmntmBlue);
		
		JRadioButtonMenuItem rdbtnmntmBlack = new JRadioButtonMenuItem("Black");
		mnColour.add(rdbtnmntmBlack);
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(rdbtnmntmRed);
		g1.add(rdbtnmntmGreen);
		g1.add(rdbtnmntmBlue);
		g1.add(rdbtnmntmBlack);
		
		JMenu mnStyle = new JMenu("Style");
		mnShapeOptions.add(mnStyle);
		
		JRadioButtonMenuItem rdbtnmntmSolid = new JRadioButtonMenuItem("Solid");
		mnStyle.add(rdbtnmntmSolid);
		
		JRadioButtonMenuItem rdbtnmntmDashed = new JRadioButtonMenuItem("Dashed");
		mnStyle.add(rdbtnmntmDashed);
		
		ButtonGroup g2 = new ButtonGroup();
		g2.add(rdbtnmntmSolid);
		g2.add(rdbtnmntmDashed);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed: " + e.getX() + ", " + e.getY());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Released: " + e.getX() + ", " + e.getY());
			}
		});
		
		
		
	
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(500,500));
		panel_1.setVisible(true);
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setSelected(true);
		toolBar.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		toolBar.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		toolBar.add(tglbtnCircle);
		
		JToggleButton tglbtnTriangle = new JToggleButton("Triangle");
		toolBar.add(tglbtnTriangle);
		
		ButtonGroup g3 = new ButtonGroup();
		g3.add(tglbtnLine);
		g3.add(tglbtnRectangle);
		g3.add(tglbtnCircle);
		g3.add(tglbtnTriangle);
		
	}

}
