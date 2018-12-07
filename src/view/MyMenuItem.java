package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MyMenuItem extends JMenuItem {
	view view;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuItem(String str, view view) {
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

}
