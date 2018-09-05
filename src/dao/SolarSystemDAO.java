package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.SolarSystem;

public class SolarSystemDAO {
	
	private Connection connection;
	private PlanetDAO planetDAO = new PlanetDAO();
	private final String GET_SOLARSYSTEM_QUERY = "SELECT * FROM solarsystems";
	private final String GET_SS_BY_ID_QUERY = "SELECT * FROM solarsystems WHERE id = ?";
	private final String CREATE_SS_QUERY = "INSERT INTO solarsystem(SS_id, star_name, galaxy) VALUES(?,?,?)";
	private final String DELETE_SS_BY_ID_QUERY = "DELETE FROM solarsystems WHERE solarSystem_Id = ?";
	
	public SolarSystemDAO() {
		connection = DBConnection.getConnection(); 
		planetDAO = new PlanetDAO(); 
	}
	
	public List<SolarSystem> getSolarSystems() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SOLARSYSTEM_QUERY).executeQuery();
		List<SolarSystem> solarSystems = new ArrayList<SolarSystem>();
		
		while (rs.next()) {
			solarSystems.add(populateSolarSystem(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return solarSystems;
	}
	
	public void deleteStellarSystem(int SS_Id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SS_BY_ID_QUERY);
		ps.setInt(1, SS_Id);
		ps.executeUpdate();
	}
	
	public void createStarSystem(int SS_id, String star_name, String galaxy) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_SS_QUERY);
		ps.setInt(1, SS_id);
		ps.setString(2, star_name);
		ps.setString(3, galaxy);
		ps.executeUpdate();
	}
	
	public SolarSystem getSSById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SS_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs =  ps.executeQuery();
		rs.next();
		return populateSolarSystem(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	private SolarSystem populateSolarSystem(int id, String name, String galaxy) throws SQLException {
		return new SolarSystem(id, name, galaxy, planetDAO.getPlanetsbySolarSystemId(id));
	}

}
