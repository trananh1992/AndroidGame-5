package android.Game;

import android.content.Intent;
import android.widget.HorizontalScrollView;
import processing.core.*;

public class GameActivity extends PApplet{
	
	//these will probably get merged to a Map class when holes etc get implemented
	PImage background;
	PImage foreground;
	PImage megaman;
	PImage quagsire;
	PImage goomba;
	private static String bgImg = "mushroomKingdom.png";
	private static String fgImg = "tiles.png";
	
	Player player;
	int counter;
	int bgCounter;
	int y = 0;
	JumpState jump;
	Goomba enemy;
	boolean enemyExists;
	
	public void setup(){
		megaman = loadImage("megaman.png");
		quagsire = loadImage("quagsire.png");
		goomba = loadImage("goomba.png");
		jump = JumpState.NONE;
		counter = bgCounter = 0;
		orientation(LANDSCAPE);
		Intent intent = getIntent();
		player = intent.getParcelableExtra("PLAYER");
		background = loadImage(bgImg);
		foreground = loadImage(fgImg);
		frameRate(15);
		enemyExists = false;
		//foreground = loadImage(fgImg);
	}
	
	void drawBackground() {
		PImage temp = createImage(displayHeight, displayWidth, ARGB);
		temp = background.get(bgCounter, 0, 3*displayHeight/4, displayWidth);
		image(temp, 0, 0, displayWidth, 3*displayHeight/4);
		//image(background, 0+counter, displayHeight/6, displayHeight, displayWidth); 
	}
	void drawForeground() {
		PImage temp = createImage(32, 32, ARGB);
		temp = foreground.get(0, 0, 32, 32);
		for(int i = -40; i < displayWidth+40; i+=32)
		{
			image(temp, i-counter%32, 10*displayHeight/12, displayHeight/8, displayHeight/8);
			image(temp, i-counter%32, 9*displayHeight/12, displayHeight/8, displayHeight/8);
		}
	}

	void drawCharacter() {
		if(player.heroName.equals("Megaman")) {
			PImage temp = createImage(34, 44, ARGB);
			temp = megaman.get(34*(counter%10), 0, 34, 44);
			image(temp, displayWidth/16, 7*displayHeight/12+y, displayHeight/4, displayHeight/4);
		} else {
			PImage temp = createImage(64, 82, ARGB);
			temp = quagsire.get(64*(counter%5), 0, 64, 82);
			image(temp,  displayWidth/16, 7*displayHeight/12+y, displayHeight/4, displayHeight/4); 
		}
	}
	
	void drawGoomba() {
		PImage temp = createImage(24, 24, ARGB);
		temp = goomba.get(24*(counter%4), 0, 24, 24);
		image(temp, displayWidth - enemy.getX(), 7*displayHeight/12, displayHeight/5, displayHeight/5);
	}
	
	public void mousePressed() {
		if(jump == JumpState.NONE)
			jump = JumpState.RISING;
	}
	
	public void draw(){
		background(0,0,0);
		fill(255,255,255);
		drawBackground();
		drawForeground();
		drawCharacter();
		if(!enemyExists) {
			enemy = new Goomba();
			enemyExists = true;
			enemy.setX(0);
		}
		
		if(enemyExists) {
			drawGoomba();
			enemy.moveForward();
			if (enemy.getX() > displayWidth+25)
				enemyExists = false;
		}
		
		counter = (counter + 1) % displayWidth;
		if(counter % 10 == 0)
			bgCounter++;
		if(jump == JumpState.RISING) {
			y-=10;
			if(y < -150) {
				y = -150;
				jump = JumpState.FALLING;
			}
		}
		else if(jump == JumpState.FALLING) {
			y+=10;
			if(y > 0) {
				jump = JumpState.NONE;
				y = 0;
			}
		}
	}

}
