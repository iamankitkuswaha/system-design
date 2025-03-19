import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Symbol[] symbols;
    private Scanner scanner;
    public Game(Board board, Symbol[] symbols){
        this.board = board;
        this.symbols = symbols;
        scanner = new Scanner(System.in);
    }

    public void play(){
        int playerNumber=0;
        int numberOfPlayers = symbols.length;
        while(true){
            Symbol symbol = symbols[playerNumber%numberOfPlayers];
            List<Cell> availableCells = board.getAvailableCell();
            if(availableCells.size() == 0){
                System.out.println("No cell available");
                System.out.println("Match has tie!!");
                return;
            }
            System.out.println("Available Cells");
            for(Cell cell : availableCells){
                System.out.println("["+cell.getX()+", "+cell.getY()+"]");
            }
            System.out.println("");
            System.out.println("Player with symbol: "+symbol+ " enter cell position: ");
            int x = scanner.nextInt();
            int y =  scanner.nextInt();
            board.playYouTurn(x,y,symbol);
            board.showBoard();
            if(board.isWin(symbol)){
                System.out.println("Player with symbol: "+symbol.toString()+" has win!!!");
                return;
            }
            playerNumber += 1;
        }
    }
}
