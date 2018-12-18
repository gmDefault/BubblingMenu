package model;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class model {
	public ArrayList<MyMenuItem> importantItems = new ArrayList<MyMenuItem> ();
	public JMenuItem test;
	
	public model() {
		
	}
	
	
	public void setImportantItems(ArrayList<MyMenuItem> importantItems) {
		this.importantItems = importantItems;
	}

	public ArrayList<MyMenuItem> getImportantItems(){
		return importantItems;
	}
	
	public void setImportantItem(MyMenuItem item) {
		importantItems.add(item);
	}
	
	
}
