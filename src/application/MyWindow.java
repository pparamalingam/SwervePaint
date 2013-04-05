package application;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyWindow extends JPanel implements Window {
    private static volatile MyWindow instance = new MyWindow();

    public MyWindow() { }

    public static MyWindow getInstance(){
    	return instance;
    }

	@Override
	public SwerveFile createFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openFile() {
		// TODO Auto-generated method stub
		
	}
	
	SwerveFile factoryMethod(){
		return new MySwerveFile();
	}
}
