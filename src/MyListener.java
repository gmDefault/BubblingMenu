import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;


public class MyListener implements MouseInputListener {
	private ArrayList<MyMenuItem> importantItems = new ArrayList<MyMenuItem>();
	private Bubbling bubble;
	public static JFrame frame;
	public static final int LG_MENU = 50;
	public static final int HT_MENU = 25;

	public MyListener(Bubbling bubble, ArrayList<MyMenuItem> importantItems) {
		this.bubble = bubble;
		this.importantItems = importantItems;
	}

	public MyListener(Bubbling bubble) {
		this.bubble = bubble;
	}

	public void setJFrame(JFrame frame) {
		MyListener.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	Bubbling.drawBubble = !Bubbling.drawBubble;
	System.out.println("HAHAHAHA");
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
		bubble.setBounds(e.getX() - closestDist / 2, e.getY() - closestDist / 2, closestDist / 2, closestDist / 2);
		bubble.repaint();
	}

//	public MyMenuItem getClosestItem(ArrayList<MyMenuItem> importantItems, MouseEvent e) {
//		MyMenuItem currentClosestItem = null;
//		double distance = Double.MAX_VALUE;
//		double currentDistance = 0;
//		for (int i = 0; i < importantItems.size(); i++) {
//			currentDistance = Math.sqrt(
//					(importantItems.get(i).getX() - e.getX()) ^ 2 + (importantItems.get(i).getY() - e.getY()) ^ 2);
//			if (currentDistance < distance) {
//				currentClosestItem = importantItems.get(i);
//			}
//		}
//		return currentClosestItem;
//	}

	public double getDistanceClosestItem(ArrayList<MyMenuItem> importantItems, MouseEvent e) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		Point eventLoc = new Point();
		Point importantItemLoc = new Point();
		for (int i = 0; i < importantItems.size(); i++) {
			if(importantItems.get(i).isShowing())
				importantItemLoc = importantItems.get(i).getLocationOnScreen();
			eventLoc = e.getPoint();
			SwingUtilities.convertPointToScreen(eventLoc, importantItems.get(i));
			currentDistance = Math.sqrt(Math.pow(importantItemLoc.getX() + LG_MENU - e.getX(), 2)
					+ Math.pow(importantItemLoc.getY() + HT_MENU - e.getY(), 2));
//			System.out.println("i : " + i + " current dist : " + currentDistance);
			System.out.println("X I : " + importantItemLoc.getX() + " Y I "  + importantItemLoc.getY()) ;
			if (currentDistance < distance) {
				distance = currentDistance;
			}
		}

		
		return distance;
	}

}