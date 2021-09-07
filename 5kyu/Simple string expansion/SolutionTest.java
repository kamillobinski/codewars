import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;

public class SolutionTest{
    private static Random random = new Random();    
    
    private static String uy8(String s){
        char [] a = new StringBuilder(s).reverse().toString().toCharArray(); // reverse the input string to access characters in reverse.
        String b = "", c;   
        for (char ch : a){                                                   // start iteration. 
            if (Character.isLetter(ch)) b += ch;                             // Is char a letter? Add it to string b. 
            else if (Character.isDigit(ch)){                                 // Is char a digit string?
                int i = ch - '0' - 1;                                        // convert the char to number - 1. It's one less (-1) because 'b' already holds one copy. 
                c = b;                                                       // copy current string. Try and see that b += b in the while loop below fails.   
                while (i > 0){
                    b += c;                                                  // concatenate a repeat of the string i times. 
                    i--; 
                }                             
            }
        }
        return new StringBuilder(b).reverse().toString();                    // reverse string and return.
    }
  
    private static String rand9(){
        String st = "abcdefghijklmnopqrstuvwxyzab", s = ""; 
          int len = random(3,5), c = 0, fLetter = random(0,2);             
          s += (fLetter == 0) ? st.charAt(random(0,26)) : String.valueOf(random(1,10));           
          while (c < len){
            int r = random(0,3);
            String ch = Character.toString(st.charAt(random(0,26))), n = String.valueOf(random(1,10));   
            s += '(' + (r == 0 ? n : r == 1 ? ch : ch + n);
            c++;
        }    
        s += "(" + st.charAt(random(0,26)) + (random(0,2) == 0 ? "" : st.charAt(random(0,26)));
        return s += ")".repeat(len+1); //"string".repeat method (from Java 11 onwards). No  more useless loops!!
    }
    
    private static int random(int l, int u){
        return random.nextInt(u-l)+l;
    }

    
    @Test
    public void basicTests(){     
        assertEquals("ababab",Solution.solve("3(ab)"));
        assertEquals("abbbabbb",Solution.solve("2(a3(b))"));
        assertEquals("bccbccbcc",Solution.solve("3(b(2(c)))"));
        assertEquals("kabaccbaccbacc",Solution.solve("k(a3(b(a2(c))))"));
    }
    
    @Test
    public void randomTests(){ 
        for(int i=0;i<100;i++){
            String s = rand9();
            assertEquals(uy8(s),Solution.solve(s));
        }
    }
}