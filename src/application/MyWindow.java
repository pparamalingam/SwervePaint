package application;

import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import tools.Shape;

@SuppressWarnings("serial")
public class MyWindow extends JPanel implements Window {
    private static volatile MyWindow instance = new MyWindow();

    public MyWindow() { }

    public static MyWindow getInstance(){
    	return instance;
    }

	@Override
	public SwerveFile createFile() {
		return factoryMethod();
	}

	@Override
	public void newFile(JFileChooser filename, List<Shape> shapes) {
		SwerveFile file = createFile();
		file.save(filename, shapes);
		
	}

	@Override
	public Object openFile(JFileChooser filename) {
		SwerveFile file = createFile();
		return file.open(filename);
	}
	
	SwerveFile factoryMethod(){
		return new MySwerveFile();
	}
}
