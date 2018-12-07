package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import controller.controller;
import view.MyMenuItem;

public class view extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private controller controler;
	private JMenuBar toolBar = fillToolBar();
	private JLabel textarea = new JLabel();


	public view() {

		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);

		add(panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
			}
		});
		panel.add(textarea);
		controler = new controller(this);
		controler.addMouseListeners(this);

		add(toolBar, BorderLayout.NORTH);
		setSize(600, 600);
		show();
	}

	private JMenuBar fillToolBar() {
		JMenuBar menu_bar1 = new JMenuBar();
		/* différents menus */
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Edition");
		/* differents choix de chaque menu */
		MyMenuItem demarrer = new MyMenuItem("Démarrer",this);
		MyMenuItem fin = new MyMenuItem("Fin",this);
		MyMenuItem annuler = new MyMenuItem("Annuler",this);
		MyMenuItem copier = new MyMenuItem("Copier",this);
		MyMenuItem coller = new MyMenuItem("Coller",this);
		MyMenuItem item1 = new MyMenuItem("item1",this);
		MyMenuItem item2 = new MyMenuItem("item2",this);
		MyMenuItem item3 = new MyMenuItem("item3",this);
		MyMenuItem item4 = new MyMenuItem("item4",this);
		MyMenuItem item5 = new MyMenuItem("item5",this);
		// sous menu
		menu1.addSeparator();
		JMenu submenu = new JMenu("A submenu");
		submenu.setPreferredSize(new Dimension(50, 50));
		MyMenuItem item6 = new MyMenuItem("item6",this);
		MyMenuItem item7 = new MyMenuItem("item7",this);
		MyMenuItem item8 = new MyMenuItem("item8",this);
		MyMenuItem item9 = new MyMenuItem("item9",this);
		MyMenuItem item10 = new MyMenuItem("item10",this);
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
		menu2.add(annuler);
		menu2.add(copier);
		menu2.add(coller);
		/* Ajouter les menu sur la bar de menu */
		menu_bar1.add(menu1);
		menu_bar1.add(menu2);

		return menu_bar1;
	}

	public JLabel getTextarea() {
		return textarea;
	}

	public static void main(String[] arg) {
		view view = new view();
	}
}
