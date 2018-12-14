package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x;
	private int y;
	private int height = 10;
	private int width = 10;
	
	public MyPanel() {
	}

	// This is Swing, so override paint*Component* - not paint
	protected void paintComponent(Graphics g) {
		// call super.paintComponent to get default Swing
		// painting behavior (opaque honored, etc.)
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, height, width);
		System.out.println("testetst");
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
