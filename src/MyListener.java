import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MyListener implements MouseInputListener {
	private ArrayList<MyMenuItem> importantItems = new ArrayList<MyMenuItem>();
	private Bubbling bubble;


	public MyListener(Bubbling bubble, ArrayList<MyMenuItem> importantItems) {
		this.bubble = bubble;
		this.importantItems = importantItems;
	}

	public MyListener(Bubbling bubble) {
		this.bubble = bubble;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// selectionner item
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

	@Override
	public void mouseMoved(MouseEvent e) {
		int closestDist = (int) getDistanceClosestItem(importantItems, e);
		System.out.println(closestDist);
		bubble.setBounds(e.getX() - closestDist / 2, e.getY() - closestDist / 2, closestDist / 2, closestDist / 2);
		bubble.repaint();
	}

	public MyMenuItem getClosestItem(ArrayList<MyMenuItem> importantItems, MouseEvent e) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		for (int i = 0; i < importantItems.size(); i++) {
			currentDistance = Math.sqrt(
					(importantItems.get(i).getX() - e.getX()) ^ 2 + (importantItems.get(i).getY() - e.getY()) ^ 2);
			if (currentDistance < distance) {
				currentClosestItem = importantItems.get(i);
			}
		}
		return currentClosestItem;
	}

	public double getDistanceClosestItem(ArrayList<MyMenuItem> importantItems, MouseEvent e) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		for (int i = 0; i < importantItems.size(); i++) {
			currentDistance = Math.sqrt(Math.pow((int) importantItems.get(i).getLocation().getX() - e.getX(), 2)
					+ Math.pow((int) importantItems.get(i).getLocation().getY() - e.getY(), 2));
			if (currentDistance < distance) {
				distance = currentDistance;
			}
		}
		return distance;
	}

}