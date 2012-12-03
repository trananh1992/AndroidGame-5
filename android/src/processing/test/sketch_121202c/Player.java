package processing.test.sketch_121202c;

public class Player {
	Playable player;
	int attackPower;
	int healthPoints;
	String ability;
	
	Player(){
		player = new Megaman();
		attackPower = 10;
		healthPoints = 80;
		ability = "None";
	}
	
	Player(Playable player) {
		player = new Megaman();
		attackPower = 0;
		healthPoints = 0;
		ability = "None";
	}
}
