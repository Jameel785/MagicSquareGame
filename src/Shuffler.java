import java.util.Random;

public class Shuffler {
    public static void shuffle(MagicSquare square) {
        Random random = new Random();
        int n = square.getSize();

        for (int i = 0; i < n * n; i++) {
            int row = random.nextInt(n);
            int column = random.nextInt(n);
            int[] neighbor = getNeighbor(row, column, n);

            int temp = square.getValueAt(row, column);
            square.setValueAt(row, column, square.getValueAt(neighbor[0], neighbor[1]));
            square.setValueAt(neighbor[0], neighbor[1], temp);
        }
    }

    private static int[] getNeighbor(int row, int column, int n) {
        Random random = new Random();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] choice = directions[random.nextInt(directions.length)];

        int newRow = (row + choice[0] + n) % n;
        int newColumn = (column + choice[1] + n) % n;
        return new int[]{newRow, newColumn};
    }
}
