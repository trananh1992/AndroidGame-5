package android.Game;

public class Player {
	Playable player;
	int attackPower;
	int healthPoints;
	String ability;
	String heroName;
	
	Player(){
		player = new Megaman();
		attackPower = 10;
		healthPoints = 8;
		ability = "MegaBuster!";
		heroName = "Megaman";
	}
	
	Player(Playable player) {
		player = new Megaman();
		attackPower = 0;
		healthPoints = 0;
		ability = "None";
	}
	
	void pickQuagsire() {
		player = new Megaman();
		attackPower = 6;
		healthPoints = 12;
		ability = "Hydro Pump!";
		heroName = "Quagsire";
	}
	
	void pickMegaman() {
		player = new Megaman();
		attackPower = 10;
		healthPoints = 8;
		ability = "MegaBuster!";
		heroName = "Megaman";
	}
}
