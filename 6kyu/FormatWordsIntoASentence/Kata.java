import java.util.Arrays;

public class Kata {

    public static String formatWords(String[] words) {
        String result = "";

        if(words != null) {
            // Remove empty words from array
            String[] objects = Arrays.stream(words).filter(x -> !x.isEmpty()).toArray(String[]::new);
            
            if(objects.length == 1) {
                result += objects[0];
            } else {
                for(int i  = 0; i < objects.length; i++) {
                    if(i == objects.length - 2) {
                        result += objects[i];
                    } else if(i == objects.length - 1) {
                        result += " and " + objects[i];
                    } else {
                        result += objects[i] + ", ";
                    }
                }
            }
        }
        return result;
    }
}