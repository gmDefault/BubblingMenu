package view;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import javax.swing.JPanel;

public class view extends JPanel{

	

	public void mouseDragged(MouseEvent e) {
		int y = e.getY();
		Ellipse2D.Double ellipse = (Ellipse2D.Double) shape;
		if (ellipse == null) {
			ellipse = new Ellipse2D.Double(o.getX(), o.getY(), 0, 0);
			pm.addShape(shape = ellipse, pm.getColor());
		}
		ellipse.setFrame(min(e.getX(), o.getX()), min(e.getY() - TOOLBAR_HEIGHT, o.getY() - TOOLBAR_HEIGHT), abs(e.getX() - o.getX()),
			abs(e.getY() - o.getY()));
			panel.repaint();
		}	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		                    RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		Set<Entry<Shape, Color>> setHm = pm.getShapes().entrySet();
		Iterator<Entry<Shape, Color>> it = setHm.iterator();
		while(it.hasNext()) {
			Entry<Shape, Color> e = it.next();
			g2.setColor(e.getValue());
			g2.draw(e.getKey());
		}
	}

		
}
