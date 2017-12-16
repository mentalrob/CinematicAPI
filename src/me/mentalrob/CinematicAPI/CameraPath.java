package me.mentalrob.CinematicAPI;

import org.bukkit.Location;

public class CameraPath {
	private Location loc;
	private float yawS;
	private float pitchS;
	private int waittime;
	private Commands komutlar;
	private boolean engelle;
	public CameraPath(Location loc, float yawS, float pitchS, int waittime,
			Commands komutlar,boolean engelle) {
		super();
		this.loc = loc;
		this.yawS = yawS;
		this.pitchS = pitchS;
		this.waittime = waittime;
		this.komutlar = komutlar;
		this.engelle = engelle;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	public float getYawS() {
		return yawS;
	}
	public void setYawS(float yawS) {
		this.yawS = yawS;
	}
	public float getPitchS() {
		return pitchS;
	}
	public void setPitchS(float pitchS) {
		this.pitchS = pitchS;
	}
	public int getWaittime() {
		return waittime;
	}
	public void setWaittime(int waittime) {
		this.waittime = waittime;
	}
	public Commands getKomutlar() {
		return komutlar;
	}
	public void setKomutlar(Commands komutlar) {
		this.komutlar = komutlar;
	}
	public boolean isEngelle() {
		return engelle;
	}
	public void setEngelle(boolean engelle) {
		this.engelle = engelle;
	}
	
}
