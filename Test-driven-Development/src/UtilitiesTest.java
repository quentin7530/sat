import junit.framework.*;
import org.junit.Test;
public class UtilitiesTest extends TestCase{

    String StarWars = "Episode IV – A New Hope\n" +
            "It is a period of civil war.\n" +
            "Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.\n" +
            "\n" +
            "During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet.\n" +
            "\n" +
            "Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy.\n";
    @Test
    public void testEndeDesVorschausBeiTexteWeniger140zeichen(){
        assertTrue(Utilities.shortenText("Hallo").endsWith("o"));
    }

    public void testEndeDesVorschausBeiTexteMehr140zeichen(){
        assertTrue(Utilities.shortenText(StarWars).endsWith("..."));
    }

    public void testVorschauBeiTextMehr140ZeichenNichtInDerMitteDesWortesAbgeschnitten(){
        char zeichen140 = StarWars.charAt(140);
        assertTrue(Utilities.shortenText("Hallo").endsWith("o"));
    }
}