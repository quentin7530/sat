import java.util.HashMap;
import java.util.Objects;

public class Utilities {

    // Konstruktor
    public Utilities() {
        // Initialisierung, falls nötig
    }

    // A implementiert von Simon Niedt de Matos und Nico Schreiber
    public static String shortenText(String s) {
        final int maxLength = 140;
        final String continuation = "...";

        Objects.requireNonNull(s, "String has to be non-null");

        if (s.length() <= maxLength) {
            return s;
        }

        s = s.substring(0, maxLength - continuation.length());
        int indexOfLastSpace = s.lastIndexOf(" ");

        if (indexOfLastSpace < 0) {
            return s + continuation;
        }

        return s.substring(0, indexOfLastSpace) + continuation;
    }

    // B implementiert von Aaron Haeßler und Quentin Robert
    public static String prepareStringForUrl(String s) {

        if (s == null)
            return s;

        HashMap<Character, String> charactersToReplace = new HashMap<>();
        charactersToReplace.put('?', "qm");
        charactersToReplace.put('&', "amp");
        charactersToReplace.put('#', "hash");
        charactersToReplace.put(' ', "-");

        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isAllowedCharacter(c)) {
                builder.append(c);
            } else {
                if (charactersToReplace.containsKey(c)) {
                    builder.append(charactersToReplace.get(c));
                } else {
                    builder.append('-');
                }
            }
        }

        int i = 0;
        while (i < builder.length() - 1) {
            if (builder.charAt(i) == '-' && builder.charAt(i + 1) == '-') {
                builder.deleteCharAt(i);
            } else {
                i++;
            }
        }

        if (builder.length() >= 0 && builder.charAt(0) == ('-')) {
            builder.deleteCharAt(0);
        }

        if (builder.length() >= 0 && builder.charAt(builder.length() - 1) == ('-')) {
            builder.deleteCharAt(builder.length() - 1);
        }

        if (builder.length() <= 0)
            return null;

        return builder.toString();
    }

    public static boolean isAllowedCharacter(char c) {
        return Character.isLetterOrDigit(c) || c == '-';
    }

    public static void main(String[] args) {
        try {
            String inputString1 = " ()";
            System.out.println("Input: " + inputString1);
            System.out.println("Output: " + prepareStringForUrl(inputString1));

        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            String inputString2 = "-()Test & Check #URL! ";
            System.out.println("Input: " + inputString2);
            System.out.println("Output: " + prepareStringForUrl(inputString2));
        } catch (Exception e) {
            // TODO: handle exception
        }
        try {
            String inputString3 = "Java? Rocks & -- Rolls--";
            System.out.println("Input: " + inputString3);
            System.out.println("Output: " + prepareStringForUrl(inputString3));

        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            String inputString4 = "Space  and  #Hash?";
            System.out.println("Input: " + inputString4);
            System.out.println("Output: " + prepareStringForUrl(inputString4));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}