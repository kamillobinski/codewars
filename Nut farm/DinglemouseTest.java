import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SolutionTests {

  // Reference implementation for the random test cases.
  private static class Dinglemouse20170808 {
  
    static int[] shakeTree(char[][] tree) {
      final int ret[] = new int[tree[0].length];
      XLOOP:
      for (int x = 0; x < tree[0].length; x++) {    
        if (tree[0][x] == 'o') {
          int nutx = x;
          for (int y = 0; y < tree.length - 1; y++) {
            switch (tree[y+1][nutx]) {
              case '/': nutx--; break;
              case '\\': nutx++; break;
              case '_' : continue XLOOP;
            }
          }
          ret[nutx]++;
        }
      }
      return ret;
    }
  
  }
  
  // Random Tree
  private char[][] makeRandomTree() {
    int w = (int)(Math.random() * 35 + 5); // width of tree
    String tree = "";
    // Nuts
    String s = " ";
    for (int x = 0; x < w; x++) {
      final double rnd = Math.random();
      s += rnd > 0.2 ? "o" : " "; // nuts on top row
    }
    s += " ";
    tree += s + "\n";
    
    // Branches
    for (int h = 0; h < w/2; h++) { // height of tree
      s = " ";
      boolean space = true; // esure barchches separated by spaces
      for (int x = 0; x < w; x++) {
        final double rnd = Math.random();
        if (!space) {
          s += " ";
          space = true;
        } else {
          final char c = rnd < 0.2 ? '/' : rnd < 0.4 ? '\\' : rnd < 0.42 ? '_' : ' ';
          space = c == ' ';
          s += c;
        }
      }
      s += " ";
      tree += s + "\n";
    }
    
    // Tree trunk
    int th = Math.max(w/4,1); // height of trunk
    int tw = Math.max(1,w*1/6); // width of trunk
    for (int h = 0; h < th; h++) { // height of trunk
      s = " ";      
      for (int i = 0; i < w; i++) {
        s += (i >= (w-tw)/2 && i <= tw+(w-tw)/2) ? "|" : " ";
      }
      s += " ";
      tree += s + "\n";
    }
    
    String rows[] = tree.split("\n");
    char ary[][] = new char[rows.length][];
    for (int i = 0; i < rows.length; i++) ary[i] = new String(rows[i]).toCharArray();
    return ary;
  }
  
  // ======================================================
  
  @Test
  public void bounceLeft() {
    final char tree[][] = Utils.makeTree(new String[] {    
      " o o o  ",
      " /    / ",
      "   /    ",
      "  /  /  ",
      "   ||   ",
      "   ||   ",
      "   ||   "
    });
    Utils.showTree(tree);
    final int[] got = Dinglemouse.shakeTree(tree);
    Utils.showNuts(got);
    assertArrayEquals(new int[]{1,1,0,0,1,0,0,0}, got);
  }
  
  @Test
  public void bounceRight() {
    final char tree[][] = Utils.makeTree(new String[] {    
      " o o o  ",
      " \\    \\ ",
      "   \\    ",
      "  \\  \\  ",
      "   ||   ",
      "   ||   ",
      "   ||   ",
      
    });
    Utils.showTree(tree);
    final int[] got = Dinglemouse.shakeTree(tree);
    Utils.showNuts(got);
    assertArrayEquals(new int[]{0,0,0,1,1,0,1,0}, got);
  }

  @Test
  public void getStuck() {
    final char tree[][] = Utils.makeTree(new String[] {    
      " o o o  ",
      " _      ",
      "   _ _  ",
      "   ||   ",
      "   ||   ",
      "   ||   ",
    });
    Utils.showTree(tree);
    final int[] got = Dinglemouse.shakeTree(tree);
    Utils.showNuts(got);
    assertArrayEquals(new int[]{0,0,0,0,0,0,0,0}, got);
  }

  @Test
  public void leftRightAndStuckToo() {
    final char tree[][] = Utils.makeTree(new String[] {    
      " oooooo ",
      " /  \\ / ",
      "  _  \\  ",
      "   / _  ",
      "  \\     ",
      "   ||   ",
      "   ||   ",
    });
    Utils.showTree(tree);
    final int[] got = Dinglemouse.shakeTree(tree);
    Utils.showNuts(got);
    assertArrayEquals(new int[]{1,0,0,1,0,0,3,0}, got);
  }

  @Test
  public void noObstacles() {
    final char tree[][] = Utils.makeTree(new String[] {    
      " oooooo ",
      "        ",
      "        ",
      "   ||   ",
      "   ||   ",
      "   ||   ",
    });
    Utils.showTree(tree);
    final int[] got = Dinglemouse.shakeTree(tree);
    Utils.showNuts(got);
    assertArrayEquals(new int[]{0,1,1,1,1,1,1,0}, got);
  }
  
  @Test
  public void random() {
    for (int r = 1; r <= 20; r++) {
      System.out.println(String.format("<hr>Random test #%d\n", r));
      final char tree[][] = makeRandomTree();
      Utils.showTree(tree);
      final int[] expected = Dinglemouse20170808.shakeTree(tree);
      final int[] got = Dinglemouse.shakeTree(tree);
      Utils.showNuts(got);
      assertArrayEquals(expected, got);
    }
  }  

}