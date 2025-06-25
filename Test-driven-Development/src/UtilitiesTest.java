import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UtilitiesTest{

    String starWars = """
            Episode Four – A New Hope
            It is a period of civil war.
            Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.

            During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet.

            Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy.
            """;
    @Test
    public void testEndeVorschauBeiTexteWeniger140zeichen(){
        assertTrue(Utilities.shortenText("Hallo").endsWith("o"));
    }

    @Test
    public void testEndeVorschauBeiTexteMehr140zeichen(){
        assertTrue(Utilities.shortenText(starWars).endsWith("..."));
    }
    @Test
    public void testVorschauBeiTextMehr140ZeichenNichtInDerMitteDesWortesAbgeschnitten(){
        String zeichen140 = String.valueOf(starWars.charAt(140));
        assertFalse(Utilities.shortenText(starWars).endsWith(zeichen140 + "..."));
    }
    @Test
    public void testVorschauBeiTextMehr140ZeichenEndetMitLetztenWort(){
        assertTrue(Utilities.shortenText(starWars).endsWith("against..."));
    }
    @Test
    public void testVorschauKleinerGleich140Zeichen(){
        assertTrue(Utilities.shortenText(starWars).length() <= 143);
    }
    @Test
    public void testVorschauBeiNullTextException() {
        assertThrows(Exception.class, () -> Utilities.shortenText(null));
    }

    @Test
    public void testVorschauBeiTextMit140ZeichenOhneLeerzeichen() {
        String starWarsOhneLeerzeichen = starWars.replaceAll(" ", "");
        System.out.println(starWarsOhneLeerzeichen);
        assertThrows(Exception.class, () -> Utilities.shortenText(starWarsOhneLeerzeichen));
    }
    @Test
    public void testVorschauBeiKeinemText() {
        assertEquals("", Utilities.shortenText(""));
    }
    @Test
    public void testVorschauEndetNichtMitLeerzeichen() {
        String beispiel = "Dies ist ein Beispieltext, der genau 136 Zeichen lang ist und dazu dient, deine Anforderungen zu erfüllen. Achte auf die Struktur des Textes.      FortsetzungText";
        assertFalse(Utilities.shortenText(beispiel).endsWith(" ..."));
    }
}