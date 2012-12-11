package android.Game;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable{
	//Playable player;
	int attackPower;
	int healthPoints;
	String ability;
	String heroName;
	
	
	Player(){
		//player = new Megaman();
		attackPower = 10;
		healthPoints = 8;
		ability = "MegaBuster!";
		heroName = "Megaman";
	}
	
	Player(Playable player) {
		//player = new Megaman();
		attackPower = 0;
		healthPoints = 0;
		ability = "None";
	}
	
	Player(Parcel in) {
		attackPower = in.readInt();
		healthPoints = in.readInt();
		ability = in.readString();
		heroName = in.readString();
	}
	
	void pickQuagsire() {
	//	player = new Megaman();
		attackPower = 6;
		healthPoints = 12;
		ability = "Hydro Pump!";
		heroName = "Quagsire";
	}
	
	void pickMegaman() {
	//	player = new Megaman();
		attackPower = 10;
		healthPoints = 8;
		ability = "MegaBuster!";
		heroName = "Megaman";
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int arg1) {
		out.writeInt(attackPower);
		out.writeInt(healthPoints);
		out.writeString(ability);
		out.writeString(heroName);
		/*
		Playable player;
		int attackPower;
		int healthPoints;
		String ability;
		String heroName;*/
	}
	
	public static final Parcelable.Creator<Player> CREATOR = new Creator<Player>() {

	    public Player createFromParcel(Parcel source) {

	        return new Player(source);
	    }

	    public Player[] newArray(int size) {

	        return new Player[size];
	    }

	};
}
