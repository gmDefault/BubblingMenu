package model;

import java.awt.Color;
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
	private int height;
	private int width;
	
	public MyPanel() {
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				x = arg0.getX();
				y = arg0.getY();
			}
		});
	}

	// This is Swing, so override paint*Component* - not paint
	protected void paintComponent(Graphics g) {
		// call super.paintComponent to get default Swing
		// painting behavior (opaque honored, etc.)
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, height, width);
	}
}
