import java.util.ArrayList;

import processing.core.PApplet;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Principal");
	}
		
	
	@Override
	public void settings() {
		size(900,600);
	}
	
	Rectangle rect;
	ArrayList<Rectangle>listRect;
	int numberRect;
	boolean createRect;
	
	@Override
	public void setup() {
		
		createRect = true;
		numberRect = 50;
		listRect = new ArrayList<Rectangle>();
	
	}
	
	@Override
	public void draw() {
		background(255);
		createRects();
		//Drawing and moving the rectangles from the list
		for (int i = 0; i < listRect.size(); i++) {
			listRect.get(i).drawRect(this);
			listRect.get(i).moveRect();
			
			bounceRects(listRect.get(i));
			
			//Erase rectangles
			if (listRect.get(i).getY() < 0 && listRect.get(i).isDirection() == false) {
				listRect.remove(i);
			}
		}
		
		System.out.println(listRect.size());
	}

	private void createRects() {
		frameRate(60);
		int xTemp = (int) random (20, 880);
		int yTemp = (int) random (-50, 20);
		if (frameCount == 60) {
			frameCount = 0;
			listRect.add(new Rectangle(xTemp, yTemp));
		}
	}
	
	private void bounceRects(Rectangle rectangle) {
		if (rectangle.getY() >= height - (rectangle.getSides()/2)) {
			rectangle.setDirection(!rectangle.isDirection());
		}

	}
	
	@Override
	public void mousePressed() {
		for (int i = 0; i < listRect.size(); i++) {
			Rectangle current = listRect.get(i);
			if (mouseX > current.getX()-current.getWidth()/2 && mouseX < current.getX()+current.getWidth()/2 &&
					mouseY > current.getY()-current.getHeight()/2 && mouseY < current.getY()+current.getHeight()/2) {
				current.setMove(!current.getMove());
			}
		}
	}
	
	
}
