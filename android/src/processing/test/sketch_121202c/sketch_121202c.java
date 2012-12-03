package processing.test.sketch_121202c;

import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import android.view.MotionEvent; 
import android.view.KeyEvent; 
import android.graphics.Bitmap; 
import java.io.*; 
import java.util.*; 

public class sketch_121202c extends PApplet {

ArrayList<PImage> imgs = new ArrayList<PImage>();
Playable player;
int counter = 0;

public void setup() {
	
	String s = "";
	for(int i = 1; i < 6; i++) {
		s = "p"+i+".png";
		PImage img = loadImage(s);
		imgs.add(img);
	}
	
	frameRate(10);
}

public void draw() {
	background(255,255,255);
	counter = (counter+1) % 5;
	if (counter > 6) counter = 0;
	
	image(imgs.get(counter), 50, 50, 100, 100);
	
	if (mousePressed) {
		player = new Megaman();
	}
	else {
		fill(0,0,0);
		textSize(32);
		text("Pressed", 100, 300);
		fill(counter, counter, 0);
	}
	if(player != null) {
		fill(230, 40, 10);
		text("Health:", 5, 610);
		rect(145, 600, 100, 15, 10);
		
		fill(20, 230, 115);
		text("Atk Pwr:", 5, 645);
		rect(145, 635, 155, 15, 10);
		
		fill(255, 240, 60);
		text("Ability:", 5, 680);
		text("MegaBuster!", 145, 680);
	}
}

  public int sketchWidth() { return 480; }
  public int sketchHeight() { return 920; }
}
