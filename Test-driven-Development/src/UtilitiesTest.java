 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;

//import junit.framework.TestCase;

public class UtilitiesTest{

    String starWars = """
            Episode Four – A New Hope
            It is a period of civil war.
            Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire.

            During the battle, Rebel spies managed to steal secret plans to the Empire’s ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet.

            Pursued by the Empire’s sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy.
            """;

    @Test
    public void testEndeVorschauBeiTexteWeniger140zeichen() {
        assertTrue(Utilities.shortenText("Hallo").endsWith("o"));
    }

    @Test
    public void testEndeVorschauBeiTexteMehr140zeichen() {
        assertTrue(Utilities.shortenText(starWars).endsWith("..."));
    }

    @Test
    public void testVorschauBeiTextMehr140ZeichenNichtInDerMitteDesWortesAbgeschnitten() {
        String zeichen140 = String.valueOf(starWars.charAt(140));
        assertFalse(Utilities.shortenText(starWars).endsWith(zeichen140 + "..."));
    }

    @Test
    public void testVorschauBeiTextMehr140ZeichenEndetMitLetztenWort() {
        assertTrue(Utilities.shortenText(starWars).endsWith("against..."));
    }

    @Test
    public void testVorschauKleinerGleich140Zeichen() {
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

    @Test
    public void testPrepareStringForUrl_BasicTransformation() {
        // Test grundlegende Transformation: Großbuchstaben zu Kleinbuchstaben,
        // Leerzeichen zu Minus
        String result = Utilities.prepareStringForUrl("Hello World");
        assertEquals("hello-world", result);
    }

    @Test
    public void testPrepareStringForUrl_SpecialCharacters() {
        // Test Umwandlung von ?, &, # in qm, amp, hash
        String result = Utilities.prepareStringForUrl("What? This & That#");
        assertEquals("whatqm-this-amp-thathash", result);
    }

    @Test
    public void testPrepareStringForUrl_RemoveSpecialCharacters() {
        // Test Entfernung von Sonderzeichen (außer Minus) durch Minus
        String result = Utilities.prepareStringForUrl("Hello@World!$Test%");
        assertEquals("hello-world-test", result);
    }

    @Test
    public void testPrepareStringForUrl_NoConsecutiveDashes() {
        // Test, dass keine aufeinanderfolgenden Minuszeichen entstehen
        String result = Utilities.prepareStringForUrl("Hello   World!!!   Test");
        assertEquals("hello-world-test", result);
    }

    @Test
    public void testPrepareStringForUrl_TrimDashes() {
        // Test, dass Ergebnis nicht mit Minus beginnt oder endet
        String result = Utilities.prepareStringForUrl("   Hello World   ");
        assertEquals("hello-world", result);
    }

    @Test
    public void testPrepareStringForUrl_AlphanumericOnly() {
        // Test, dass nur Buchstaben a-z und Ziffern 0-9 plus Minus erhalten bleiben
        String result = Utilities.prepareStringForUrl("Test123");
        assertEquals("test123", result);
    }

    @Test
    public void testPrepareStringForUrl_EmptyAfterProcessing() {
        // Test, dass null zurückgegeben wird wenn nur Sonderzeichen eingegeben werden
        String result = Utilities.prepareStringForUrl("!@#$%^&*()");
        assertNull(result);
    }

    @Test
    public void testPrepareStringForUrl_NullInput() {
        // Test, dass null-Eingabe korrekt behandelt wird
        String result = Utilities.prepareStringForUrl(null);
        assertNull(result);
    }
}