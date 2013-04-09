package application;

import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFileChooser;

import tools.Shape;

public interface SwerveFile {
	void save(JFileChooser filename, List<Shape> shapes);
	void close();
	Object open(JFileChooser filename);
}
