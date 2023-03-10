import java.util.HashSet;
import java.util.Set;

public class Anagrams {
    public static Set<String> getAllAnagrams(String word) {
        final Set<String> anagrams = new HashSet<>();

        if (word.length() > 3)
        {
            for(int i = 0; i < word.length(); i++) {
                final Set<String> anagramsForSubstring = getAllAnagrams(word.substring(1));
                final String firstChar = word.substring(0, 1);

                anagramsForSubstring.forEach(a->anagrams.add(firstChar.concat(a)));
                word = shiftLeft(word);
            }
        }

        anagrams.addAll(getAllAnagramsForUpTo3Chars(word));

        return anagrams;
    }

    private static Set<String> getAllAnagramsForUpTo3Chars(String word) {
        final Set<String> anagrams = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            anagrams.add(word);
            word = shiftLeft(word);

            for(int j = 0; j < word.length() - 1; j++) {
                anagrams.add(switchCharacters(word, j));
            }
        }

        return anagrams;
    }

    private static String shiftLeft(String word) {
        return word.substring(1).concat(word.substring(0, 1));
    }

    private static String switchCharacters(String word, int index) {
        assert index + 1 < word.length();

        final char[] chars = word.toCharArray();

        char c = chars[index];
        chars[index] = chars[index + 1];
        chars[index + 1] = c;

        return new String(chars);
    }
}
