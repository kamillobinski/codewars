public class Kata {
    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int matrixLength = a.length;
        int[][] outputMatrix = new int[matrixLength][matrixLength];

        for(int i = 0; i < matrixLength; i++) {
            for(int j  = 0; j < matrixLength; j++) {
                outputMatrix[i][j] = a[i][j] + b[i][j];
            }
        }

        return outputMatrix;
    }
}
