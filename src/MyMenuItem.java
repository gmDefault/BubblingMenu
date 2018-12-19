import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MyMenuItem extends JMenuItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyMenuItem(final String str) {
		super(str);
		this.setPreferredSize(new Dimension(100, 50));
	}

	public void changeInterestOfItem() {
		this.setBackground(new Color(128, 191, 255));
	}

}
