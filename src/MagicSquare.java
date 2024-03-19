public class MagicSquare {
    private int[][] square;
    public int[][] originalSquare;

    public MagicSquare(int n) {
        square = new int[n][n];
        generateSquare(n);
    }

    private void generateSquare(int n) {
        int row = 0;
        int column = (n + 1) / 2 - 1;
        square[row][column] = 1;

        for (int i = 2; i <= n * n; i++) {
            int newRow = (row + n - 1) % n;
            int newColumn = (column + n - 1) % n;

            if (square[newRow][newColumn] == 0) {
                row = newRow;
                column = newColumn;
            }
            else {
                row = (row + 1) % n;
            }
            square[row][column] = i;
        }

        originalSquare = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(square[i], 0, originalSquare[i], 0, square[i].length);
        }
    }

    public boolean isSolved() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (square[i][j] != originalSquare[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return square.length;
    }

    public int getValueAt(int row, int column) {
        return square[row][column];
    }

    public void setValueAt(int row, int column, int value) {
        square[row][column] = value;
    }

    public void printSquare() {
        for (int[] row : square) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
}
