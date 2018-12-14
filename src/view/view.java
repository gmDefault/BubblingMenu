package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import controller.controller;
import model.MyMenu;
import model.MyMenuItem;
import model.MyPanel;
import model.TransparentPanel;
import model.model;

public class view extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel backPanel;
	private TransparentPanel panelCircle;
	private controller controler;
	private model modelMenu = new model();
	private JMenuBar toolBar;
	private JLabel textarea = new JLabel();
	

	public view() {
		toolBar = fillToolBar();
		
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		
		backPanel = new JPanel();
		backPanel.setLayout(null);

		MyPanel panelTop = new MyPanel();
		panelTop.setBounds(new Rectangle(0,0,600,600));
		panelTop.setOpaque(false);
		backPanel.add(panelTop);
		
		add(panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
			}
		});
		panel.setBounds(new Rectangle(0,0,600,600));
		panel.add(textarea);
		panel.setOpaque(true);
		backPanel.add(panel);		
		
		controler = new controller(this);
		controler.addMouseListeners(this);
		//add(panelCircle = new TransparentPanel());
		setContentPane(backPanel);
        setLocationRelativeTo(null);
		panel.add(toolBar, BorderLayout.NORTH);
		show();
	}

	public JMenuBar fillToolBar() {
		
		ArrayList<MyMenuItem> list = this.modelMenu.getImportantItems();
		JMenuBar menu_bar1 = new JMenuBar();
		/* différents menus */
		MyMenu menu1 = new MyMenu("Fichier");
		MyMenu menu2 = new MyMenu("Edition");
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
		MyMenu submenu = new MyMenu("A submenu");
		submenu.setPreferredSize(new Dimension(50, 50));
		MyMenuItem item6 = new MyMenuItem("item6",this);
		MyMenuItem item7 = new MyMenuItem("item7",this);
		MyMenuItem item8 = new MyMenuItem("item8",this);
		MyMenuItem item9 = new MyMenuItem("item9",this);
		MyMenuItem item10 = new MyMenuItem("item10",this);

		//Définition de nos points d'intérêts
		demarrer.changeInterestOfItem();
		item9.changeInterestOfItem();
		item4.changeInterestOfItem();
		submenu.changeInterestOfMenu();

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
