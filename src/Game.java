import java.util.Scanner;

public class Game {
    private MagicSquare square;

    public Game(int size) {
        square = new MagicSquare(size);
        Shuffler.shuffle(square);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int moveCount = 0;
        square.printSquare();

        while (square.isSolved() == false) {
            System.out.println("Enter row, column and direction(U, D, L, R)");
            int row = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;
            String direction = scanner.next().toUpperCase();

            if (processMove(row, column, direction.charAt(0))) {
                moveCount++;
                System.out.println("Moves: " + moveCount);
                square.printSquare();
            }
            else {
                System.out.println("Invalid move. Try again");
            }
        }

        System.out.println("Well done! You completed the game in " + moveCount + " moves");
        scanner.close();
    }

    private boolean processMove(int row, int column, char direction) {
        int size = square.getSize();
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case 'U': if (row > 0) newRow--; break;
            case 'D': if (row < size - 1) newRow++; break;
            case 'L': if (column > 0) newColumn--; break;
            case 'R': if (column < size - 1) newColumn++; break;
            default: return false;
        }

        if (newRow == row && newColumn == column) {
            return false;
        }

        int temp = square.getValueAt(row, column);
        square.setValueAt(row, column, square.getValueAt(newRow, newColumn));
        square.setValueAt(newRow, newColumn, temp);

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of magic square: ");
        int size = scanner.nextInt();

        if (size % 2 == 0) {
            System.out.println("Size must be an odd integer");
            return;
        }

        Game game = new Game(size);
        game.start();
    }
}
