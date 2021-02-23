import processing.core.PApplet;
import processing.core.PConstants;

public class Rectangle {
	
	private int x, y;
	private int height, width, sides;
	private boolean move, direction;
	private int movement;
	
	public Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
		this.sides = (int) (Math.random()*60+30);
		this.height = sides;
		this.width = sides;
		this.move = true;
		this.movement = (int) (Math.random()*5+2);
		this.direction = true;
	}
	
	public void drawRect(PApplet app) {
		app.rectMode(PConstants.CENTER);
		app.fill(255,0,0);
		app.rect(x, y, height, width);
	}
	
	public void moveRect() {
		if (move == true && direction == true) {
			y += movement;
		} else if (direction == false) {
			y -= movement;;
		}
		
		if (y >= 600) {
			direction = !direction;
		}
		
	
	}
	
	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean getMove() {
		return move;
	}
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public int getSides() {
		return sides;
	}	
	
}
