package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PlanetDAO;
import dao.SolarSystemDAO;
import entities.Planet;
import entities.SolarSystem;

public class Menu {
	
	private SolarSystemDAO solarSystemDAO = new SolarSystemDAO();
	private PlanetDAO planetDAO = new PlanetDAO();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Stellar Systems",
			"Display Solar System",
			"Create Stellar System",
			"Delete Stellar System",
			"Create Planet",
			"Delete Planet"
			);
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayStellarSystems();
				} else if (selection.equals("2")) {
					displaySolarSystem();
				} else if (selection.equals("3")) {
					createStellarSystem();
				} else if (selection.equals("4")) {
					deleteStellarSystem();
				} else if (selection.equals("5")) {
					createPlanet();
				} else if (selection.equals("6")) {
					deletePlanet();
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			System.out.println("Press ENTER to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}

	private void deletePlanet() throws SQLException {
		System.out.println("Enter the Planet ID you wish to DELETE: ");
		int planet_Id = Integer.parseInt(scanner.nextLine());
		planetDAO.deletePlanet(planet_Id);
		System.out.println("DELETED!");
		
	}

	private void createPlanet() throws SQLException {
		System.out.println("Enter the NEW Planet ID: ");
		int planet_Id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the NAME of the NEW planet: ");
		String name = scanner.nextLine();
		System.out.println("Enter the POSITION from parent star:");
		int pos = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter any INFORMATION you would like to include about his planet: ");
		String info = scanner.nextLine();
		System.out.println("Enter the Stellar System ID in which your NEW planet resides: ");
		int SS_Id = Integer.parseInt(scanner.nextLine());
		planetDAO.createPlanet(planet_Id, name, pos, info, SS_Id);
		System.out.println("You've created a Planet! \n");
		planetDAO.getPlanetInfo(planet_Id);
	}

	private void deleteStellarSystem() throws SQLException {
		System.out.println("Enter the Stellar System ID for the system you would like to DELETE:");
		int SS_Id = Integer.parseInt(scanner.nextLine());
		solarSystemDAO.deleteStellarSystem(SS_Id);
		System.out.println("Stellar System: " + solarSystemDAO.getSSById(SS_Id));
	}

	private void createStellarSystem() throws SQLException {
		System.out.println("Enter the NEW Stellar System ID: \n---------------------------");
		int SS_Id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the NAME of the NEW Stellar System's Parent Star:\n-------------------------------------------------------");
		String star_name = scanner.nextLine();
		System.out.println("Enter the NAME of the Stellar System's GALAXY:\n----------------------------------------------");
		String galaxy = scanner.nextLine();
		solarSystemDAO.createStarSystem(SS_Id, star_name, galaxy);
	}

	private void printMenu() {
		System.out.println("Select an Option: \n ----------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}

	private void displayStellarSystems() throws SQLException {
		List<SolarSystem> systems = solarSystemDAO.getSolarSystems();
		for (SolarSystem system : systems) {
			System.out.println(system.getSolarSystem_Id() + ": " + system.getParentStarName() + " System");
		}
			
	}
	
	private void displaySolarSystem() throws SQLException {
		System.out.print("Enter Solar System ID");
		int id = Integer.parseInt(scanner.nextLine());
		SolarSystem solarSystem = solarSystemDAO.getSSById(id);
		System.out.println(solarSystem.getSolarSystem_Id() + ": " + solarSystem.getParentStarName());
		for(Planet planet : solarSystem.getPlanets()) {
			System.out.println("\tSolarSystemID: " + solarSystem.getSolarSystem_Id() + 
					" - Parent Star Name: " + solarSystem.getParentStarName() +
					"\n\tPlanets: " + planet.getPlanetName());
		}
		
	}
}
