import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Main {
	// public static JLabel itemSelect = new JLabel("Item frappe");
	static JLabel textArea = new JLabel("");

	public static void main(String[] args) {
		ArrayList<MyMenuItem> list = new ArrayList<MyMenuItem>();
		MyMenuItem itemSelectionne = null;
		JFrame frame = new JFrame();
		Bubbling bubble = new Bubbling(50, 50);
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		frame.setSize(600, 600);

		panel.setLayout(new BorderLayout());

		panel.setBounds(0, 0, 600, 600);
		bubble.setBounds(0, 0, 100, 100);

		/* différents menus */
		MyMenu menu1 = new MyMenu("Fichier");
		JMenuBar menu_bar1 = new JMenuBar();
		panel.add(menu_bar1, BorderLayout.NORTH);

		/* differents choix de chaque menu */
		MyMenuItem demarrer = new MyMenuItem("Démarrer");
		MyMenuItem fin = new MyMenuItem("Fin");
		MyMenuItem item1 = new MyMenuItem("item1");
		MyMenuItem item2 = new MyMenuItem("item2");
		MyMenuItem item3 = new MyMenuItem("item3");
		MyMenuItem item4 = new MyMenuItem("item4");
		MyMenuItem item5 = new MyMenuItem("item5");

		// sous menu
		menu1.addSeparator();
		MyMenu submenu = new MyMenu("A submenu");
		submenu.setPreferredSize(new Dimension(50, 50));
		MyMenuItem item6 = new MyMenuItem("item6");
		MyMenuItem item7 = new MyMenuItem("item7");
		MyMenuItem item8 = new MyMenuItem("item8");
		MyMenuItem item9 = new MyMenuItem("item9");
		MyMenuItem item10 = new MyMenuItem("item10");

		// Définition de nos points d'intérêts
		demarrer.changeInterestOfItem();
		item9.changeInterestOfItem();
		item4.changeInterestOfItem();
		submenu.changeInterestOfMenu();

		list.add(item4);
		list.add(item9);

		submenu.add(item6);
		submenu.add(item7);
		submenu.add(item8);
		submenu.add(item9);
		submenu.add(item10);

		/* Ajouter les choix au menu */
		menu1.add(demarrer);
		menu1.add(fin);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(submenu);
		menu1.add(item3);
		menu1.add(item4);
		menu1.add(item5);
		/* Ajouter les menu sur la barre de menu */
		menu_bar1.add(menu1);

		/* Ajouter les mouse listener a tous les elements */
		item1.addMouseMotionListener(new MyListener(bubble));
		item2.addMouseMotionListener(new MyListener(bubble));
		item3.addMouseMotionListener(new MyListener(bubble));
		item4.addMouseMotionListener(new MyListener(bubble));
		item5.addMouseMotionListener(new MyListener(bubble));
		item6.addMouseMotionListener(new MyListener(bubble));
		item7.addMouseMotionListener(new MyListener(bubble));
		item8.addMouseMotionListener(new MyListener(bubble));
		item9.addMouseMotionListener(new MyListener(bubble));
		item10.addMouseMotionListener(new MyListener(bubble));
		demarrer.addMouseMotionListener(new MyListener(bubble));
		fin.addMouseMotionListener(new MyListener(bubble));

		menu1.addMouseListener(new MyListener(bubble));
		// menu2.addMouseListener(new MyListener(bubble, menu2, panel));
		submenu.addMouseListener(new MyListener(bubble));

		textArea.setBounds(500, 50, 50, 50);

		frame.addMouseMotionListener(new MyListener(bubble, list));
		menu_bar1.add(menu1);
		// menu_bar1.add(menu2);
		frame.add(textArea);
		frame.add(panel);
		frame.setGlassPane(bubble);
		bubble.setVisible(true);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}