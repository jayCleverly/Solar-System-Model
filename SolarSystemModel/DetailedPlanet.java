
// Class which provides methods for creating a detailed planet
public class DetailedPlanet extends Planet {

    // Extra details about a planet
    private double mass;
    private double radius;
    private double surfaceGravity;
    private double systemLuminosity;
    private String habitable;

    // Habitabilty formula variables
    private static final double HAB_VAL_1 = 0.75;
    private static final double HAB_VAL_2 = 2.0;
    private static final double HAB_VAL_3 = 0.6;
    private static final double HAB_VAL_4 = 7.0;

    private static final String PLANET_INFO = 
        "%s has a mass of %s Earths with a surface gravity of %sg, is %sAU from its star, " 
        + "and orbits in %s years: could be habitable? %s\n";


    public DetailedPlanet(String name, double mass, double radius, double distance) {
        
        // Invokes the parent class 'Planet' constructor
        super(name, distance);

        this.mass = mass;
        this.radius = radius;
        calculateSurfaceGravity();
    }
    

    // Executes formula for surface gravity
    private void calculateSurfaceGravity() {
        surfaceGravity = mass / (radius * radius);
    }

    // Determines habitabilty for a planet
    public void calculateHabitabilty(double systemLuminosity) {
        
        this.systemLuminosity = systemLuminosity;
        final double systemLuminosityFactor = Math.sqrt(systemLuminosity);

        // Applies specified formula to find if variables passed meet habitabilty criteria
        if ((HAB_VAL_1 * systemLuminosityFactor <= getDistance()) 
        && (getDistance() <= HAB_VAL_2 * systemLuminosityFactor)
        && (HAB_VAL_3 <= mass && mass <= HAB_VAL_4)) {
            habitable = "yes";
        } else {
            habitable = "no";
        }
    }

    // Updates calculation values when new data is set via accessor methods
    private void updateCalculationValues() {
        calculateSurfaceGravity();
        calculateHabitabilty(systemLuminosity);
    }


    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
        updateCalculationValues(); // Updates related values due to new data
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        updateCalculationValues(); // Updates related values due to new data
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public String getHabitable() {
        return habitable;
    }


    @Override
    public String toString() {

        return String.format(PLANET_INFO, getName(), roundValue(mass), 
            roundValue(surfaceGravity), roundValue(getDistance()), roundValue(getOrbitalPeriod()), habitable);
    }
}
