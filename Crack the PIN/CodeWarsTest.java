import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Random;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 


public class CodeWarsTest {
    private CodeWars objTF = new CodeWars();
    @Test
    public void simple_test() {
        assertEquals("Should work with simple PIN", "12345", objTF.crack("827ccb0eea8a706c4c34a16891f84e7b"));
    }
    @Test
    public void harder_test() {
        assertEquals("Should work with harder PIN", "00078", objTF.crack("86aa400b65433b608a9db30070ec60cd"));
    }
  
    public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
  
  
    @Test
    public void twenty_random_tests() {
      for (int x = 0; x < 20; x++) {
          String buffer = "";
          Random rand = new Random();
          for (int i = 0; i < 5; i++) {
            buffer += String.valueOf(rand.nextInt(10));
          }
          String hash = getMd5(buffer);
          assertEquals("Should work with random PINs", buffer, objTF.crack(hash));
      }
    }
}