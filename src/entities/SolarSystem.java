package entities;

import java.util.List;

public class SolarSystem {
	
	private int solarSystem_Id;
	private String parentStarName;
	private String galaxy;
	private List<Planet> planets;
	
	public SolarSystem (int id, String starName, String galaxy, List<Planet> planets) {
		this.solarSystem_Id = id;
		this.parentStarName = starName;
		this.galaxy = galaxy;
		this.planets = planets;
	}
	

	public int getSolarSystem_Id() {
		return solarSystem_Id;
	}
	public void setSolarSystem_Id(int solarSystem_Id) {
		this.solarSystem_Id = solarSystem_Id;
	}
	public String getParentStarName() {
		return parentStarName;
	}
	public void setParentStarName(String parentStarName) {
		this.parentStarName = parentStarName;
	}
	public String getGalaxy() {
		return galaxy;
	}
	public void setGalaxy(String galaxy) {
		this.galaxy = galaxy;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
}
