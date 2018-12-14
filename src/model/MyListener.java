package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import view.view;

public class MyListener implements MouseMotionListener {
	private JPanel gp;
	private view view;
	private MyMenu menu;
	private JPanel panel;
	public MyListener(JPanel glassPanel, MyMenu menu, view view, JPanel panel) {
		gp = glassPanel;
		this.view = view;
		this.menu = menu;
		this.panel = panel;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println(view.posX + arg0.getX() - 10 );
		System.out.println(view.posY + arg0.getY());
		this.view.setX(view.posX + arg0.getX()-10);
		this.view.setY(view.posY + arg0.getY());
		panel.repaint();
		gp.repaint();
	}

}
