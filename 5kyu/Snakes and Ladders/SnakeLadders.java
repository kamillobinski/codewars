public class SnakesLadders {

    private int[] playerSquare = {0, 0};
    private int player = 0;
    private boolean isWon = false;
    private final int[][] LADDERS = {{2, 38}, {7, 14}, {8, 31}, {15, 26}, {21, 42}, {28, 84}, {36, 44}, {51, 67}, {71, 91}, {78, 98}, {87, 94}};
    private final int[][] SNAKES = {{16, 6}, {46, 25}, {49, 11}, {62, 19}, {64, 60}, {74, 53}, {89, 68}, {92, 88}, {95, 75}, {99, 80}};

    public SnakesLadders() {

    }

    public void checkSnakes() {
        for(int i = 0; i < SNAKES.length; i++) {
            if(playerSquare[player] == SNAKES[i][0]) {
                playerSquare[player] = SNAKES[i][1];
            }
        }
    }

    public void checkLadders() {
        for (int i = 0; i < LADDERS.length; i++) {
            if(playerSquare[player] == LADDERS[i][0]) {
                playerSquare[player] = LADDERS[i][1];
            }
        }
    }

    public void togglePlayer(int die1, int die2) {
        if(die1 != die2) {
            if(player == 0) {
                player = 1;
            } else {
                player = 0;
            }
        }
    }

    public String play(int die1, int die2) {
        if (!isWon) {
            int roll = die1 + die2;

            if ((playerSquare[player] + roll) <= 100) {
                playerSquare[player] += roll;
                if (playerSquare[player] == 100) {
                    isWon = true;
                    return "Player " + (player + 1) + " Wins!";
                }
            } else {
                playerSquare[player] = 100 - (playerSquare[player] + roll - 100);
            }

            checkSnakes();
            checkLadders();
            String message = "Player " + (player + 1) + " is on square " + playerSquare[player];
            togglePlayer(die1, die2);

            return message;
        } else {
            return "Game over!";
        }
    }
}