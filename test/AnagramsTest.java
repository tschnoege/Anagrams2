import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramsTest {
    @Test
    void anagramsFrom2CharWords() {
        assertEquals(Set.of("ab", "ba"), Anagrams.getAllAnagrams("ab"));
        assertEquals(Set.of("xy", "yx"), Anagrams.getAllAnagrams("xy"));
        assertEquals(Set.of("to", "ot"), Anagrams.getAllAnagrams("to"));
    }

    @Test
    void anagramsFrom3CharWords() {
        assertEquals(Set.of("abc", "acb", "cba", "bca", "cab", "bac"), Anagrams.getAllAnagrams("abc"));
        assertEquals(Set.of("xyz", "xzy", "zyx", "yzx", "zxy", "yxz"), Anagrams.getAllAnagrams("xyz"));
        assertEquals(6, Anagrams.getAllAnagrams("two").size());
    }

    @Test
    void anagramsFrom4CharWords() {
        assertEquals(24, Anagrams.getAllAnagrams("abcd").size());
        assertEquals(Set.of(
                "biro", "bior", "brio", "broi", "boir", "bori",
                "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                "rbio", "rboi", "ribo", "riob", "roib", "robi",
                "obir", "obri", "oibr", "oirb", "orbi", "orib"), Anagrams.getAllAnagrams("bori"));

    }

    @Test
    void anagramsForAnyWord() {
        assertEquals(1*2*3*4*5, Anagrams.getAllAnagrams("abcde").size());
        assertEquals(1*2*3*4*5*6, Anagrams.getAllAnagrams("abcdef").size());
        assertEquals(1*2*3*4*5*6*7, Anagrams.getAllAnagrams("abcdefg").size());
    }
}
