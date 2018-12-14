package model;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;

public class MyMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	public MyMenu(String str) {
		super(str);
	}
	
	public void changeInterestOfMenu() {
		this.setBackground(new Color(128, 191, 255));
	}
	
}
