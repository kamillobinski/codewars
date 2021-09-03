import java.util.ArrayList;
import java.util.List;

public class Kata {

    public static char[] generateAlphabet() {
        return "abcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    public static List<Integer> parseWords(String[] words) {
        List<Integer> points = new ArrayList<>();
        char[] alphabet = generateAlphabet();
        for(String word: words) {
            char[] wordLetters = word.toCharArray();
            points.add(calcWordPoints(alphabet, wordLetters));
        }
        return points;
    }

    public static int calcWordPoints(char[] alphabet, char[] word) {
        int points = 0;
        for(char character: word) {
            for(int i = 0; i < alphabet.length; i++) {
                if(alphabet[i] == character) {
                    points += i + 1;
                }
            }
        }
        System.out.println(points);
        return points;
    }

    public static int getHighestScore(List<Integer> points) {
        int highest = 0;
        int index = 0;
        for(int i = 0; i < points.size(); i++) {
            if(points.get(i) > highest) {
                highest = points.get(i);
                index = i;
            }
        }
        return index;
    }

    public static String high(String s) {
        String[] words = s.split(" ");
        List<Integer> points = parseWords(words);
        int highestIndex = getHighestScore(points);
        return words[highestIndex];
    }
}