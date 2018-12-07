package model;

import java.awt.Color;
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
	
	public void changeInterestOfItem() {
		this.setBackground(new Color(128, 191, 255));
	}

}
