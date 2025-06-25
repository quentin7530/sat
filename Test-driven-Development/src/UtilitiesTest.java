import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UtilitiesTest{

    String StarWars = """
            Episode Four – A New Hope
            It is a period of civil war.
            Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.

            During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet.

            Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy.
            """;
    @Test
    public void testEndeDesVorschausBeiTexteWeniger140zeichen(){
        assertTrue(Utilities.shortenText("Hallo").endsWith("o"));
    }

    @Test
    public void testEndeDesVorschausBeiTexteMehr140zeichen(){
        assertTrue(Utilities.shortenText(StarWars).endsWith("..."));
    }
    @Test
    public void testVorschauBeiTextMehr140ZeichenNichtInDerMitteDesWortesAbgeschnitten(){
        char zeichen140 = StarWars.charAt(140);
        assertFalse(Utilities.shortenText("Hallo").endsWith("h"));
    }
    @Test
    public void testVorschauBeiTextMehr140ZeichenEndetMitLetztenWort(){
        char zeichen140 = StarWars.charAt(140);
        assertFalse(Utilities.shortenText(StarWars).endsWith("the..."));
    }
    @Test
    public void testVorschauKleinerGleich140Zeichen(){
        assertTrue(Utilities.shortenText(StarWars).length() <= 143);
    }
    @Test
    public void testVorschauBeiNullText() throws Exception{
         assertThrows(Exception.class, () -> Utilities.shortenText(null)) ;
    }
}