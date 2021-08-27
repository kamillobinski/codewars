public class Solution {
    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        int currentVerticalPos = position[0];
        int currentHorizontalPos = position[1];

        int MAX_VERTICAL_POS = fighters.length;
        int MIN_VERTICAL_POS = 0;
        int MAX_HORIZONTAL_POS = fighters[0].length;
        int MIN_HORIZONTAL_POS = 0;

        String[] output = new String[moves.length];

        for (int i = 0; i < moves.length; i++) {
            switch(moves[i]) {
                case "up": { currentVerticalPos = moveUp(currentVerticalPos, MIN_VERTICAL_POS); break; }
                case "down": { currentVerticalPos = moveDown(currentVerticalPos, MAX_VERTICAL_POS); break; }
                case "left": { currentHorizontalPos = moveLeft(currentHorizontalPos, MAX_HORIZONTAL_POS); break; }
                case "right": { currentHorizontalPos = moveRight(currentHorizontalPos, MIN_HORIZONTAL_POS, MAX_HORIZONTAL_POS); break; }
            }
            output[i] = fighters[currentVerticalPos][currentHorizontalPos];
        }
        return output;
    }

    public static int moveUp(int verticalPos, int minVerticalPos) {
        return verticalPos == minVerticalPos ? minVerticalPos : verticalPos - 1;
    }

    public static int moveDown(int verticalPos, int maxVerticalPos) {
        return verticalPos == maxVerticalPos - 1 ? maxVerticalPos - 1 : verticalPos + 1;
    }

    public static int moveLeft(int horizontalPos, int maxHorizontalPos) {
        return horizontalPos == 0 ? maxHorizontalPos - 1 : horizontalPos - 1;
    }

    public static int moveRight(int horizontalPos, int minHorizontalPos, int maxHorizontalPos) {
        return horizontalPos == maxHorizontalPos - 1 ? minHorizontalPos : horizontalPos + 1;
    }
}