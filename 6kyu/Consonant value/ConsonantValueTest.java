import org.junit.Test;
import java.util.Random;

public class ConsonantValueTest {
    @Test
    public void basicTests() {
        Tester.doTest("zodiac", 26);
        Tester.doTest("chruschtschov", 80);
        Tester.doTest("khrushchev", 38);
        Tester.doTest("strength", 57);
        Tester.doTest("catchphrase", 73);
        Tester.doTest("twelfthstreet", 103);
        Tester.doTest("mischtschenkoana", 80);
        Tester.doTest("az", 26);
        Tester.doTest("zozz", 52);
        Tester.doTest("fizzbuzzy", 77);
    }
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz",
                         vowels   = "aeiou";
    @Test
    public void randomTests() {
        Random rand = new Random();
        for (int trial = 1; trial <= 100; trial++) {
            String word = "";
            for (int lenMult = rand.nextInt(5) + 7; lenMult-- > 0;)
                word += vowels + alphabet;
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                int  j = rand.nextInt(letters.length);
                char t = letters[i];
                letters[i] = letters[j];
                letters[j] = t;
            }
            word = new String(letters);
            Tester.doTest(word, solution(word));
        }
    }
    private int solution(final String s) {
        int m = 0, v = 0;
        for (char c : s.toCharArray())
            if ( vowels.indexOf(c) >= 0 ) {
                m = m < v ? v : m;
                v = 0;
            } else
                v += alphabet.indexOf(c) + 1;
        return Math.max(m,v);
    }
}