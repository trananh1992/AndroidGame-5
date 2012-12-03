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
PImage img1;
PImage img2;
PImage img3;
PImage img4;
PImage img5;
int counter = 0;

public void setup() {
	//PImage image = loadImage("pirate.jpg");
	//background(image);
	String s = "";
	for(int i = 1; i < 6; i++) {
		s = "p"+i+".png";
		PImage img = loadImage(s);
		imgs.add(img);
	}
	img1 = loadImage("p1.png");
	img2 = loadImage("p2.png");
	img3 = loadImage("p3.png");
	img4 = loadImage("p4.png");
	img5 = loadImage("p5.png");
	frameRate(15);
}

public void draw() {
	counter = (counter+1) % 5;
	if (counter > 6) counter = 0;
//	if(img == null) {
//		fill(255,255,255);
//		ellipse(50,50,50,50);
//	}
//	else {	
	  
  if (mousePressed) {
	  background(255,255,255);
	  fill(0,0,0);
	  textSize(12);
	  text("Pressed", 100, 300);
	  text(imgs.size(), 100, 400);
	  text(imgs.get(0).toString(), 100, 400);
	  imageMode(CENTER);
	  switch(counter) {
	  	case 0:
	  		image(img1, 50, 50, 100, 100);
	  		break;
	  	case 1:
	  		image(img2, 50, 50, 100, 100);
	  		break;
	  	case 2:
	  		image(img3, 50, 50, 100, 100);
	  		break;
	  	case 3:
	  		image(img4, 50, 50, 100, 100);
	  		break;
	  	case 4:
	  		image(img5, 50, 50, 100, 100);
	  		break;
	  	default:
	  		break;
	  }
	  
	  //image(imgs.get(counter), 50, 50);
  } else {
	  fill(0,0,0);
	  textSize(32);
	  text("Pressed", 100, 300);
	  fill(counter, counter, 0);
  }
}

  public int sketchWidth() { return 480; }
  public int sketchHeight() { return 920; }
}
