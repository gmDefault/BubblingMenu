package view;

import java.awt.Dimension;

import javax.swing.JMenuItem;

public class MyMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyMenuItem(String str) {
		super(str);
		this.setPreferredSize(new Dimension(100,50));
	}

}
