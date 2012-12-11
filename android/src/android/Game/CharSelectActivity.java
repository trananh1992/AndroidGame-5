package android.Game;

import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import android.view.MotionEvent; 
import android.view.KeyEvent; 
import android.content.Intent;
import android.graphics.Bitmap; 
import java.io.*; 
import java.util.*; 
import sprites.*;

public class CharSelectActivity extends PApplet {

	private static int characters = 2;
	ArrayList<PImage> imgsM = new ArrayList<PImage>();
	ArrayList<PImage> imgsQ = new ArrayList<PImage>();
	
	PImage megamanImg, quagsireImg;
	PGraphics pg;
	PImage toDraw;
	Playable player;
	Player player1;
	int counter = 0;

	public void setup() {
		megamanImg = loadImage("megaman.png");
		megamanImg.loadPixels();
		quagsireImg = loadImage("quagsire.png");
		quagsireImg.loadPixels();
		orientation(LANDSCAPE);
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
		frameRate(15);
	}

	void drawTitle() {
		textSize(48);
		fill(0,0,0);
		text("Select Your Hero!!!", displayWidth/4 , displayHeight/12);
	}

	void drawCharacters() {
		PImage temp = createImage(34, 44, ARGB);
		temp = megamanImg.get(34*(counter%10), 0, 34, 44);
		image(temp,  displayWidth/16, displayHeight/12, displayHeight/4, displayHeight/4); 
		
		PImage temp2 = createImage(64, 82, ARGB);
		temp2 = quagsireImg.get(64*(counter%5), 0, 64, 82);
		image(temp2,  displayWidth/16, 4*displayHeight/12, displayHeight/4, displayHeight/4); 
	}
	
	void drawStats() {
		textSize(24);
		fill(145, 255, 185);
		rect(displayWidth/2+4, displayHeight/12+5, displayWidth/2-8, displayHeight/2, 10);
		
		fill(0, 0, 60);
		text("Hero:", 3*displayWidth/6 + 8, 3*displayHeight/16);
		text(player1.heroName, 4*displayWidth/6, 3*displayHeight/16);
		
		fill(230, 40, 10);
		text("Health:", 3*displayWidth/6 + 8, 4*displayHeight/16);
		rect(4*displayWidth/6, 4*displayHeight/16-12, player1.healthPoints*10, 15, 10);
		
		fill(20, 230, 115);
		text("Atk Pwr:", 3*displayWidth/6 + 8, 5*displayHeight/16);
		rect(4*displayWidth/6, 5*displayHeight/16-12, player1.attackPower*10, 15, 10);
		
		fill(0, 0, 0);
		text("Ability:", 3*displayWidth/6 + 8, 6*displayHeight/16);
		text(player1.ability, 4*displayWidth/6, 6*displayHeight/16);
	}
	
	void drawStartButton() {
		textSize(36);
		fill(45, 255, 185);
		rect(displayWidth/2-30, 4*displayHeight/6+50, displayWidth/4, displayHeight/12, 10);
	}
	public void mousePressed(){
		if((mouseY > 4*displayHeight/6 && mouseX < displayHeight) && (mouseX > 4*displayWidth/8 && mouseX < 7*displayWidth/8))
		{
			text("HEYHEY!", 50, 50);
			Intent i = new Intent(this, GameActivity.class);
			i.putExtra("PLAYER", player1);
			
			this.startActivity(i);
		}
	}
	
	public void draw() {
		background(255,255,255);
		drawTitle();
	
		if(player1 != null ) {
			drawStats();
			drawStartButton();
			fill(30,30,30);
			text("STAART!!", displayWidth/2-30, 5*displayHeight/6);
			//text(mouseX, 100, 700);
			//text(mouseY, 200, 700);
		}
		
		
		counter++;
		drawCharacters();
		//image(imgsM.get(counter%5), displayWidth/16, displayHeight/12, displayHeight/4, displayHeight/4);
		//image(imgsQ.get(counter%3), displayWidth/16, (displayHeight/4)+displayHeight/12, displayHeight/4, displayHeight/4);
		
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
}
