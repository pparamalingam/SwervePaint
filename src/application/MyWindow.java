package application;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyWindow extends JPanel {
    private static volatile MyWindow instance = null;

    MyWindow() {       }

    public static MyWindow getInstance() {
            if (instance == null) {
                    synchronized (MyWindow .class){
                            if (instance == null) {
                                    instance = new MyWindow ();
                            }
                  }
            }
            return instance;
    }
}
