package entities;

public class Planet {

	private int planet_Id;
	private String planetName;
	private int positionFromStar;
	private String planetInfo;
	private int ssid;
	
	public Planet(int id, String name, int pos, String planetInfo, int ssid) {
		this.setPlanetName(name);
		this.setPositionFromStar(pos);
		this.setPlanetInfo(planetInfo);
		this.setSsid(ssid);
	}

	public int getPlanet_Id() {
		return planet_Id;
	}

	public void setPlanet_Id(int planet_Id) {
		this.planet_Id = planet_Id;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}

	public int getPositionFromStar() {
		return positionFromStar;
	}

	public void setPositionFromStar(int positionFromStar) {
		this.positionFromStar = positionFromStar;
	}

	public String getPlanetInfo() {
		return planetInfo;
	}

	public void setPlanetInfo(String planetInfo) {
		this.planetInfo = planetInfo;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}


	
	
}
