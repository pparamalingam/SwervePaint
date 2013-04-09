package application;

import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFileChooser;

import tools.Shape;

public interface Window {
	SwerveFile createFile();
	void newFile(JFileChooser filename, List<Shape> shapes);
	Object openFile(JFileChooser filename);

}
