package android.Game;

import android.widget.HorizontalScrollView;
import processing.core.*;

public class GameActivity extends PApplet{
	
	//these will probably get merged to a Map class when holes etc get implemented
	PImage background;
	PImage foreground;
	private static String bgImg = "a";
	private static String fgImg = "asdas";
	
	
	public void setup(){
		orientation(LANDSCAPE);
		//background = loadImage(bgImg);
		//foreground = loadImage(fgImg);
	}
	
	public void draw(){
		background(0,0,0);
		fill(255,255,255);
		textSize(72);
		text("STARTED",50,50);
	}

}
