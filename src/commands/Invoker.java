package commands;

import java.util.ArrayList;
import java.util.List;

import application.MyWindow;

@SuppressWarnings("static-access")
public class Invoker {
	private static volatile Invoker instance = new Invoker();
	private List<Command> history = new ArrayList<Command>();
	private int positionInList = -1;
	MyWindow x = new MyWindow();
	
	public Invoker() {}
 
	public void storeAndExecute(Command c) {
		positionInList++;
		this.history.add(positionInList, c);
		this.history.get(positionInList).execute();
		for (int i = history.size()-1; positionInList < i; i--){
			history.remove(i);
		}
		x.getInstance().updateUI();
	}
	
	public void undoLast(){
		if (history.size() > 0 && positionInList >= 0){
			this.history.get(positionInList).unexecute();
			positionInList--;
		}
		x.getInstance().updateUI();
	}
   
	
	public void redoLast(){
		if (history.size() > 0 && history.size() > positionInList + 1){
			positionInList++;
			this.history.get(positionInList).execute();
		}
		x.getInstance().updateUI();
	}
	
	public boolean isRedoAvailable() {
		if (history.size() > 0 && history.size() > positionInList + 1){
			return true;
		}
		return false;
	}
	
	public boolean isUndoAvailable(){
		if (history.size() > 0 && positionInList >= 0){
			return true;
		}
		return false;
	}
	
	public static Invoker getInstance(){
	   return instance;
	}
}