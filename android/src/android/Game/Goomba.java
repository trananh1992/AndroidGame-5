package android.Game;

public class Goomba {
	private int x;
	private int y;
	private int health;
	
	public Goomba(){
		x = 0;
		y = 0;
		health = 10;
	}
	
	public void spawnGoomba() {
		x = 0;
		y = 0;
		health = 10;
	}
	
	public void moveForward() {
		x += 8;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
