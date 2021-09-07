import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Random;
import java.util.stream.*;

public class SolutionTest {
    private static Random rnd = new Random();
    
    private static String generateRandomWord() {
      return IntStream.range(0, rnd.nextInt(10)).mapToObj(x -> Character.toString((char) (rnd.nextInt((123 - 97) + 1) + 97))).collect(Collectors.joining());
    }
    
    private static String solution(String[] words) {
      return words == null || words.length == 0
        ? ""
        : Stream.of(words).filter(x -> !x.isEmpty()).collect(Collectors.joining(", ")).replaceAll(", (?=\\S+$)", " and ");
    }
    
    @Test
    public void sampleTests() {
        assertEquals("one, two, three and four", Kata.formatWords(new String[] {"one", "two", "three", "four"}));
        assertEquals("one", Kata.formatWords(new String[] {"one"}));
        assertEquals("one and three", Kata.formatWords(new String[] {"one", "", "three"}));
        assertEquals("three", Kata.formatWords(new String[] {"", "", "three"}));
        assertEquals("one and two", Kata.formatWords(new String[] {"one", "two", ""}));
        assertEquals("", Kata.formatWords(new String[] {}));
        assertEquals("", Kata.formatWords(null));
        assertEquals("", Kata.formatWords(new String[] {""}));
    }
    
    @Test
    public void randomTests() {
      int tests = 100;
      
      for (int i = 0; i < tests; i++) {
        String[] test = IntStream.range(0, rnd.nextInt(20)).mapToObj(x -> generateRandomWord()).toArray(String[]::new);
        if (rnd.nextInt(20) == 0) test = null;
        
        String expected = solution(test);
        String actual = Kata.formatWords(test);
        
        assertEquals(expected, actual);
      }
    }
}