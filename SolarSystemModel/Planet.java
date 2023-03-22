
// Class which provides methods for creating a basic planet
public class Planet {

    // Basic data about a planet
    private String name;
    private double distance;
    private double orbitalPeriod;

    // Value used to round numbers to a more readable format
    private static final double ROUNDING_NUM = 1000.0;

    // Variables used to override hashcode
    private static final int HASH_PRIME = 31;
    private int hashResult = 1;

    private static final String PLANET_INFO = 
        "%s  is %sAU from its star, and orbits in %s years\n";


    public Planet(String name, double distance) {

        this.name = name;
        this.distance = distance;
        calculateOrbitalPeriod();
    }


    // Executes formula given for orbital period
    private void calculateOrbitalPeriod() {
        orbitalPeriod = Math.sqrt(distance*distance*distance);
    }

    // Rounds number to 3 decimal places and removes trailing 0s
    protected String roundValue(double number) {
        return String.valueOf(Math.round(number*ROUNDING_NUM)/ROUNDING_NUM);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
        calculateOrbitalPeriod(); // Updates value due to new data
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }


    @Override
    public boolean equals(Object obj) {

        // Checks to see if planet object passed is not a planet object
        if (!(obj instanceof Planet)) {
            return false;

        // Object passed is the same object
        } else if (this == obj) {
            return true;

        // Object passed is an instance of planet class
        } else {
            Planet planet = (Planet) obj;
            // Check to see if planet's details matchs
            if (planet.getName().equals(name) && planet.getDistance() == distance) {
                return true;
            }
            return false;
        }
    }

    @Override
    public int hashCode() {

        // Creates hashcode for object
        hashResult *= HASH_PRIME + ((name != null) ? name.hashCode() : 0);
        hashResult *= HASH_PRIME + distance;

        return hashResult;
    }

    @Override
    public String toString() {

        return String.format(PLANET_INFO, 
            name, roundValue(distance), roundValue(orbitalPeriod));
    }
}
