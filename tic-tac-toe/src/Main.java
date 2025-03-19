import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wantToPlay;
        System.out.println("Want to play then enter 1");
        wantToPlay =  scanner.nextInt();
        while(wantToPlay == 1) {
            System.out.println("\n Game has started!!!");
            Board board = new Board(3);
            board.showBoard();

            Symbol[] symbols = new Symbol[]{Symbol.X, Symbol.O};
            Game game = new Game(board, symbols);
            game.play();
            System.out.println("\nwant to play again then enter 1 else enter 0");
            wantToPlay = scanner.nextInt();
        }
    }
}