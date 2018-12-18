package controller;

import java.util.ArrayList;

import model.MyMenuItem;
import view.view;

public class controller {

	public controller(view view) {
		// TODO Auto-generated constructor stub
	}

	public MyMenuItem getClosestItem(view View,ArrayList<MyMenuItem> importantItems) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		for (int i = 0; i < importantItems.size(); i++) {
			currentDistance = Math.sqrt((importantItems.get(i).getX() - View.getX())^2 + (importantItems.get(i).getY() - View.getY())^2)  ;
			if (currentDistance < distance) {
				currentClosestItem = importantItems.get(i);
			}
		}
		return currentClosestItem;
	}
	
	public double getDistanceClosestItem(view View,ArrayList<MyMenuItem> importantItems) {
		MyMenuItem currentClosestItem = null;
		double distance = Double.MAX_VALUE;
		double currentDistance = 0;
		for (int i = 0; i < importantItems.size(); i++) {
			currentDistance = Math.sqrt((importantItems.get(i).getX() - View.getX())^2 + (importantItems.get(i).getY() - View.getY())^2)  ;
			if (currentDistance < distance) {
				distance = currentDistance;
			}
		}
		return distance;
	}

}
