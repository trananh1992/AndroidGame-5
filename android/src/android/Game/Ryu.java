package android.Game;

import java.util.ArrayList;

import processing.core.PImage;

public class Ryu implements Playable{
ArrayList<PImage> imgs = new ArrayList<PImage>();
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadSprite() {
		String s = "";
		for(int i = 1; i < 6; i++) {
			s = "p"+i+".png";
		//	PImage img = loadImage(s);
		//	imgs.add(img);
		}
	}

	@Override
	public void setAbility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useAbility() {
		// TODO Auto-generated method stub
		
	}
}
