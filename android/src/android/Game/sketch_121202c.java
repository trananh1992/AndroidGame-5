package android.Game;

import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import android.view.MotionEvent; 
import android.view.KeyEvent; 
import android.graphics.Bitmap; 
import java.io.*; 
import java.util.*; 

public class sketch_121202c extends PApplet {

ArrayList<PImage> imgsM = new ArrayList<PImage>();
ArrayList<PImage> imgsQ = new ArrayList<PImage>();
Playable player;
Player player1;
int counter = 0;

public void setup() {
	
	String s = "";
	for(int i = 1; i < 6; i++) {
		s = "p"+i+".png";
		PImage img = loadImage(s);
		imgsM.add(img);
	}
	for(int i = 1; i < 4; i++) {
		s = "q"+i+".png";
		PImage img = loadImage(s);
		imgsQ.add(img);
	}
	player1 = new Player();
	frameRate(10);
}

public void draw() {
	background(255,255,255);
	//line(0,4*counter%900, 480, (4*counter - 150)%600);
	
	if(player1 != null ) {
		textSize(24);
		fill(145, 255, 185);
		rect(2, 550, 480, 355, 10);
		
		fill(0, 0, 60);
		text("Hero:", 5, 575);
		text(player1.heroName, 145, 575);
		
		fill(230, 40, 10);
		text("Health:", 5, 610);
		rect(145, 600, player1.healthPoints*10, 15, 10);
		
		fill(20, 230, 115);
		text("Atk Pwr:", 5, 645);
		rect(145, 635, player1.attackPower*10, 15, 10);
		
		fill(0, 0, 0);
		text("Ability:", 5, 680);
		text(player1.ability, 145, 680);
		
		text("STAART!!", 160, 750);
		//text(mouseX, 100, 700);
		//text(mouseY, 200, 700);
	}
	
	
	counter++;
	
	image(imgsM.get(counter%5), 50, 50, 100, 100);
	image(imgsQ.get(counter%3), 50, 160, 100, 100);
	
	if (mousePressed) {
		if (mouseY < 150) {
			player1.pickMegaman();
			text("Megaman", 200, 300);
		} else if ( mouseY < 300) {
			player1.pickQuagsire();
			text("Quagsire", 200, 300);
		}
	}

	
}

  public int sketchWidth() { return 480; }
  public int sketchHeight() { return 920; }
}
