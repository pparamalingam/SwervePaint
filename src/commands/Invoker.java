package commands;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Command> history;
 
	public Invoker() {
		history = new ArrayList<Command>();
	}
 
   public void storeAndExecute(Command c) {
	   this.history.add(c);
	   c.execute();
	}
}