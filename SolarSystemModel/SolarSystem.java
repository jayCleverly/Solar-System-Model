
import java.util.ArrayList;


// Class which provides methods for creating a solar system
public class SolarSystem {

    // Basic info about a solar system
    private String name;
    private double luminosity;
    private ArrayList<Planet> planets = new ArrayList<>(); // Used to store planet objects

    private static final String SOLAR_SYSTEM_INFO = "Star %s has planets:\n";
    

    public SolarSystem(String name) {
        setName(name);
    }

    public SolarSystem(String name, double luminosity) {
        setName(name);
        this.luminosity = luminosity;
    }

    
    // Saves new basic planet to array
    public void addPlanet(String name, double distance) {
        planets.add(new Planet(name, distance));
    }

    // Saves new detailed planet to array
    public void addPlanet(String name, double mass, double radius, double distance) {
        DetailedPlanet newPlanet = new DetailedPlanet(name, mass, radius, distance);
        planets.add(newPlanet);

        // Determines if planet is habitable
        newPlanet.calculateHabitabilty(luminosity);
    }


    // Rearranges planets by distance
    private Planet sortPlanets(boolean sortByFurthest) {

        Planet p = planets.get(0);
        double currentDistance = p.getDistance();

        if (sortByFurthest) {
            // Stores the planet with the largest distance
            for (Planet planet: planets) {
                if (currentDistance < planet.getDistance()) {
    
                    currentDistance = planet.getDistance();
                    p = planet;
                }
            }
        } else if (!sortByFurthest) {
            // Stores the planet with the smallest distance
            for (Planet planet: planets) {
                if (planet.getDistance() < currentDistance) {
    
                    currentDistance = planet.getDistance();
                    p = planet;
                }
            }
        }
        return p;
    }

    // Sorts the planets to find the planet with largest distance
    public Planet furthest() {
        return sortPlanets(true);
    }

    // Sorts the planets to find the planet with smallest distance
    public Planet closest() {
        return sortPlanets(false);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLuminosity() {
        return luminosity;
    }

    // Searches for planet with given name
    public Planet getPlanetByName(String name) {

        // Checks to see if planet's names match
        for (Planet planet: planets) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }


    @Override
    public String toString() {

        // Combines planets information with solar system details
        String s = SOLAR_SYSTEM_INFO;

        for (Planet planet: planets) {
            s += planet.toString();
        }
        return String.format(s, name);
    }
}
