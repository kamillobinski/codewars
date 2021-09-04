import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsonantValue {
    public static int solve(final String s) {
        String[] substrings = s.split("[a\\\\e\\\\i\\\\o\\\\u]");
        List<Integer> values = new ArrayList<>();
        for(String substring: substrings) {
            int value = 0;
            for(int i = 0; i < substring.length(); i++) {
                char letter = substring.charAt(i);
                value += (int) letter - 96;
            }
            values.add(value);
        }
        return Collections.max(values);
    }
}