package application;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyWindow extends JPanel {
    private static volatile MyWindow instance = new MyWindow();

    public MyWindow() { }

    public static MyWindow getInstance(){
    	return instance;
    }
}
