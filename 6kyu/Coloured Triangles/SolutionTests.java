import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTests {

  @Test
  public void examples() {
    // assertEquals("expected", "actual");
    assertEquals('R', Kata.triangle("GB"));
    assertEquals('R', Kata.triangle("RRR"));
    assertEquals('B', Kata.triangle("RGBG"));
    assertEquals('G', Kata.triangle("RBRGBRB"));
    assertEquals('G', Kata.triangle("RBRGBRBGGRRRBGBBBGG"));
    assertEquals('B', Kata.triangle("B"));
  }
  
  private static class KataReferenceImplementation {
  
    static char triangle(final String row) {
    
      if (row.length() == 1) return row.charAt(0);
      
      String nextRow = "";
      for (int i = 1; i < row.length(); i++) {
        char c1 = row.charAt(i-1), c2 = row.charAt(i);
        switch (c1) {
          case 'R': nextRow += c2=='R'?'R':c2=='G'?'B':'G'; break;
          case 'G': nextRow += c2=='R'?'B':c2=='G'?'G':'R'; break;
          case 'B': nextRow += c2=='R'?'G':c2=='G'?'R':'B'; break;
        }    
      }
      
      return triangle(nextRow); // recurse
    }
  
  }    

  private static final String CHARS = "RGB";  
  private String gen_fcw34gvw34gw() {
    String s = "";
    final int len = (int)Math.ceil(Math.random() * 30);
    for (int i = 0; i <= len; i++) {
      s += CHARS.charAt((int)Math.floor(Math.random() * 3));
    }
    return s;
  }
  
  @Test
  public void randomTests() {
    // assertEquals("expected", "actual");    
    final int toRun = (int)Math.floor(Math.random() * 20 + 150);
    for (int i = 0; i < toRun; i++) {
      final String row = gen_fcw34gvw34gw();
      //System.out.println(row);
      assertEquals(KataReferenceImplementation.triangle(row), Kata.triangle(row));
    }      
  }
      
}