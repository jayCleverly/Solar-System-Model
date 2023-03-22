
/* Coursework submission which allows
   the creation of a solar system.
*/

// Class which can be used to test the features of a solar system
public class Main{
    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem("'Solar System'");

        solarSystem.addPlanet("Mercury", 3.285, 2439.7, 67.274);
        solarSystem.addPlanet("Venus", 4.867, 6051.8, 108.77);
        solarSystem.addPlanet("Earth", 5.972 , 6371.1, 147.53);
        solarSystem.addPlanet("Mars", 6.39, 3389.5, 229.48);
        solarSystem.addPlanet("Jupiter", 1.898, 69911, 740.86);
        solarSystem.addPlanet("Saturn", 5.683, 58232, 14705000);
        solarSystem.addPlanet("Uranus", 8.681, 25362, 294230000);
        solarSystem.addPlanet("Neptune", 1.024, 24622, 447370000);

        System.out.println(solarSystem.toString());
    }
}
