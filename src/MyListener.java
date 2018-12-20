import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class MyListener implements MouseInputListener {
	private ArrayList<JComponent> importantItems = new ArrayList<JComponent>();
	private Bubbling bubble;
	public static JPanel panel;
	private String str;
	public JComponent item;
	public static final int LG_MENU = 50;
	public static final int HT_MENU = 25;

	public MyListener(Bubbling bubble, ArrayList<JComponent> importantItems, MyMenu item) {
		this.bubble = bubble;
		this.importantItems = importantItems;
		this.item = item;
	}

	public MyListener(Bubbling bubble, ArrayList<JComponent> importantItems, MyMenuItem item) {
		this.bubble = bubble;
		this.importantItems = importantItems;
		this.item = item;
	}

	public MyListener(Bubbling bubble, ArrayList<JComponent> importantItems, JPanel item) {
		this.bubble = bubble;
		this.importantItems = importantItems;
		this.item = item;
	}

	public MyListener(Bubbling bubble) {
		this.bubble = bubble;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	// Lorsque le clic droit de la souris est pressé, le bubbling menu apparaît
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			Bubbling.drawBubble = true;
		}
	}

	// Sélection de l'item avec la bubble. Si cet item est un Sous-menu, la bubble ne disparait pas. Sinon, l'item le plus proche est cliqué. 
	@Override
	public void mouseReleased(MouseEvent e) {
		if(!(Main.itemToClick instanceof MyMenu)) {
			Bubbling.drawBubble = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (Main.itemToClick != null) {
				if (Main.itemToClick instanceof MyMenu) {
					((MyMenu) Main.itemToClick).doClick();
				} else if (Main.itemToClick instanceof MyMenuItem) {
					((MyMenuItem) Main.itemToClick).doClick();
				}
			}
		}
		bubble.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	// Calcul la distance de l'item le plus proche à chaque instant afin de faire varier la taille de la bubble.
	@Override
	public void mouseMoved(MouseEvent e) {
		// Récupère la distance de l'item d'intérêt le plus proche
		int closestDist = (int) getDistanceClosestItem(importantItems, e);
		// Transforme la position relative de la souris en position absolu
		Point absoluteMousePos = SwingUtilities.convertPoint(item, e.getPoint(), panel);
		bubble.setBounds((int) absoluteMousePos.getX() - closestDist, (int) absoluteMousePos.getY() - closestDist,
				closestDist * 2, closestDist * 2);
		bubble.repaint();
	}

	// Calcul la distance de la souris a tout les items importants
	public double getDistanceClosestItem(ArrayList<JComponent> importantItems, MouseEvent e) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		Point absoluteMousePos = e.getPoint();
		// Transforme la position relative de la souris en position absolu
		absoluteMousePos = SwingUtilities.convertPoint(item, absoluteMousePos, panel);
		Point importantItemLoc = new Point();
		//Pour chaque items immportants, on va calculer la distance entre la souris et l'item.
		for (int i = 0; i < importantItems.size(); i++) {
			if (importantItems.get(i).isShowing()) {
				importantItemLoc = importantItems.get(i).getLocationOnScreen();
				importantItemLoc.x += LG_MENU;
				importantItemLoc.y += HT_MENU;
				SwingUtilities.convertPointFromScreen(importantItemLoc, panel);
				currentDistance = Math.sqrt(Math.pow(importantItemLoc.getX() - absoluteMousePos.getX(), 2)
						+ Math.pow(importantItemLoc.getY() - absoluteMousePos.getY(), 2));
				if (currentDistance <= distance) {
					distance = currentDistance;
					//On met à jour l'item à cliqué dans le cas où le clic est effectué
					if (Bubbling.drawBubble)
						Main.itemToClick = importantItems.get(i);
				}
			}
		}
		return distance;

	}
}