import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Bubbling extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean drawBubble;
	private int mousePosX;
	private int mousePosY;
	private ArrayList<MyMenuItem> importantItems;

	public Bubbling(int mousePosX, int mousePosY) {
		this.mousePosX = mousePosX;
		this.mousePosY = mousePosY;
	}

	public void setMousePos(int x, int y) {
		this.mousePosX = x;
		this.mousePosY = y;
	}

	public int getMousePosX() {
		return mousePosX;
	}

	public void setMousePosX(int mousePosX) {
		this.mousePosX = mousePosX;
	}

	public int getMousePosY() {
		return mousePosY;
	}

	public void setMousePosY(int mousePosY) {
		this.mousePosY = mousePosY;
	}

	public ArrayList<MyMenuItem> getImportantItems() {
		return importantItems;
	}

	public void setImportantItems(ArrayList<MyMenuItem> importantItems) {
		this.importantItems = importantItems;
	}

	// Si DrawBubble est activé, on dessine la bubble
	@Override
	public void paintComponent(Graphics g) {
		if (drawBubble) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(128, 191, 255, 125));
			g2.fillOval(0, 0, this.getWidth(), this.getHeight());
		}
	}
}
