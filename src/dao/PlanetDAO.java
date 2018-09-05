package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Planet;

public class PlanetDAO {

	private Connection connection;
	private final String GET_PLANETS_BY_SS_ID_QUERY = "SELECT * FROM planets WHERE solarSystem_Id = ?";
	private final String DELETE_PLANETS_BY_SS_ID_QUERY = "DELETE FROM planets WHERE solarSystem_Id = ?";
	private final String CREATE_PLANET_QUERY = "INSERT INTO planets(planet_Id, name, pos, info, SS_Id) VALUES(?,?,?,?,?)";
	private final String GET_PLANET_INFO_BY_ID = "SELECT * FROM planets WHERE planet_Id = ?";
	private final String DELETE_PLANET_BY_ID_QUERY = "DELETE FROM planets WHERE planet_Id = ?";
	
	public PlanetDAO() {
		connection = DBConnection.getConnection();
	}
	
	public List<Planet> getPlanetsbySolarSystemId(int ssid) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLANETS_BY_SS_ID_QUERY);
		ps.setInt(1, ssid); 
		ResultSet rs = ps.executeQuery();
		List<Planet> planets = new ArrayList<Planet>();
		
		while (rs.next()) {
			planets.add(new Planet(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
		}
		return null;
	}

	public void deletePlanetsBySSId(int SS_Id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLANETS_BY_SS_ID_QUERY);
		ps.setInt(1, SS_Id);
		ps.executeUpdate();
	}
	
	public void createPlanet(int planet_Id, String name, int pos, String info, int SS_Id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_PLANET_QUERY);
		ps.setInt(1, planet_Id);
		ps.setString(2, name);
		ps.setInt(3, pos);
		ps.setString(4, info);
		ps.setInt(5, SS_Id);
		ps.executeUpdate();	
	}
	
	public void deletePlanet(int planet_Id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLANET_BY_ID_QUERY);
		ps.setInt(1, planet_Id);
		ps.executeUpdate();
	}
	
	public void getPlanetInfo(int planet_Id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLANET_INFO_BY_ID);
		ps.setInt(1, planet_Id);
		ps.executeQuery();
	}
}
