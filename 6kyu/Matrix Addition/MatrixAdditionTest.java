import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixAdditionTest {
  
  @Test
  public void sampleTest() {
    int[][] expected = new int[][] { { 3, 4, 4 }, { 6, 4, 4 }, { 2, 2, 4 } };
    
    assertArrayEquals(expected,
        Kata.matrixAddition(
            new int[][] { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 1 } },
            new int[][] { { 2, 2, 1 }, { 3, 2, 3 }, { 1, 1, 3 } }));
    
    expected = new int[][] { { 3 } };
    assertArrayEquals(expected, 
        Kata.matrixAddition(
            new int[][] { { 1 } },
            new int[][] { { 2 } }));
    
    expected = new int[][] { { 3, 5 }, { 3, 5 } };
    assertArrayEquals(expected,
        Kata.matrixAddition(
            new int[][] { { 1, 2 }, { 1, 2 } },
            new int[][] { { 2, 3 }, { 2, 3 } }));
  }

  private static final Random rnd = new Random();

  @Test
  public void randomTest() {
    
    for (int test = 0; test < 50; test++) {

      int size = rnd.nextInt(60) + 1;
      int[][] expected = new int[size][];
      int[][] a = new int[size][];
      int[][] b = new int[size][];

      for (int row = 0; row < size; row++) {

        expected[row] = new int[size];
        a[row] = new int[size];
        b[row] = new int[size];

        for (int col = 0; col < size; col++) {
          expected[row][col] = rnd.nextInt(600)+1;
          a[row][col] = rnd.nextInt(600)+1;
          b[row][col] = expected[row][col] - a[row][col];
        }
      }     
      assertArrayEquals(expected, Kata.matrixAddition(a, b));
    }
  }
}