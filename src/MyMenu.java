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
//		this.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				Main.textArea.setText(str);
//				Bubbling.drawBubble = true;
//
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				Bubbling.drawBubble = true;
//				if (SwingUtilities.isLeftMouseButton(arg0)) {
//					System.out.println(str);
//				}
//			}
//		});
	}

	public void changeInterestOfMenu() {
		this.setBackground(new Color(128, 191, 255));
		this.setOpaque(true);
	}

}
