package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import view.view;

public class MyMenuItem extends JMenuItem {
	view view;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuItem(final String str, final view view) {
		super(str);
		this.view = view;
		this.setPreferredSize(new Dimension(100, 50));
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (SwingUtilities.isLeftMouseButton(arg0)) {
					System.out.println(str);
					view.getTextarea().setText(str);
				}
			}
		});
	}
	
	public void changeInterestOfItem() {
		this.setBackground(new Color(128, 191, 255));
	}

}
