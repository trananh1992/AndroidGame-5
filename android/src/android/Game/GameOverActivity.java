package android.Game;
import android.content.Intent;
import android.widget.HorizontalScrollView;
import processing.core.*;

public class GameOverActivity extends PApplet{
	
	public void setup() {
		orientation(LANDSCAPE);
	}
	
	public void draw() {
		background(0,0,0);
		fill(60,255,60);
		text("GAMEOVER", displayWidth/3, displayHeight/2);
	}

}
