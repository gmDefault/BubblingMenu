import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.SwingUtilities;

public class MyMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public MyMenu(final String str) {
		super(str);
	}

	public void changeInterestOfMenu() {
		this.setBackground(new Color(128, 191, 255));
		this.setOpaque(true);
	}

}
