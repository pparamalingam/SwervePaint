package swerve;

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
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class Landing extends JFrame {
	//test
	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Line");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Rectangle");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Circle");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Triangle");
		panel.add(btnNewButton_3);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_4);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JSlider slider = new JSlider();
		panel.add(slider);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		JButton btnCopy = new JButton("Copy");
		panel.add(btnCopy);
		
		JButton btnPaste = new JButton("Paste");
		panel.add(btnPaste);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2);
		
		JButton btnUndo = new JButton("Undo");
		panel.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		panel.add(btnRedo);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_3);
		
		JButton btnGroup = new JButton("Group");
		panel.add(btnGroup);
		
		JButton btnUngroup = new JButton("Ungroup");
		panel.add(btnUngroup);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setForeground(Color.BLACK);
		panel.add(verticalStrut);
		
		JButton btnLoad = new JButton("Load");
		panel.add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setSize(new Dimension(500, 500));
		contentPane.add(panel_1, BorderLayout.EAST);
	}

}
