## Dokumentation

## Setup

Wir, Aaron Haeßler und Quentin Robert, haben Aufgabe B implementiert und Tests für Aufgabe A geschrieben.
Nico Schreiber und Simon Niedt de Matos haben Aufgabe A implementiert und Tests für Aufgabe B geschrieben.


## Test
7 von 9 Test haben funktionniert.

```java
@Test
public void testVorschauBeiTextMehr140ZeichenEndetMitLetztenWort() {
    assertTrue(Utilities.shortenText(starWars).endsWith("against..."));
}
```
Bei diesem Test ist die Interpretation der Aufgabe bei den 2 Teams anderes gewesen. Wir haben gedacht, es gibt maximal 140 Zeichen plus die 3 Punkte, das andere Team ist davon ausgegangen, dass es maximal 140 Zeichen inklusive den 3 Punkten.