import java.util.ArrayList;
import java.util.List;

public class DeadFish {
    public static int[] parse(String data) {
        String[] commands = data.split("");
        List<Integer> outputScores = new ArrayList<Integer>();
        int score = 0;

        for(String command: commands) {
            switch(command) {
                case "i": { score++; break; }
                case "d": { score--; break; }
                case "s": { score = (int) Math.pow(score, 2); break; }
                case "o": { outputScores.add(score); break; }
            }
        }

        int[] output = new int[outputScores.size()];
        for(int i = 0; i < outputScores.size(); i++) {
            output[i] = outputScores.get(i);
        }

        return output;
    }
}