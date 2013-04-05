package commands;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private static volatile Invoker instance = new Invoker();
	
	private List<Command> history = new ArrayList<Command>();
	private int positionInList = -1;
	
	public Invoker() {}
 
	public void storeAndExecute(Command c) {
		positionInList++;
		this.history.add(positionInList, c);
		this.history.get(positionInList).execute();
		for (int i = history.size()-1; positionInList > i; i--){
			history.remove(i);
		}
		System.out.println("Execute the command at " + positionInList);
	}
	
	public void undoLast(){
		if (history.size() > 0 && positionInList >= 0){
			this.history.get(positionInList).unexecute();
			positionInList--;
		}
	}
   
	public void redoLast(){
		if (history.size() > 0 && history.size() > positionInList + 1){
			positionInList++;
			this.history.get(positionInList).execute();
		}
	}
	
	public boolean isRedoAvailable() {
		if (history.size() > 0 && history.size() > positionInList + 1){
			return true;
		}
		return false;
	}
	
	public static Invoker getInstance(){
	   return instance;
	}
}