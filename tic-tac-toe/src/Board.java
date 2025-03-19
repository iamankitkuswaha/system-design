import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    private Symbol[][] board;
    public Board(int size){
        this.size = size;
        board = new Symbol[size][size];
    }
    public boolean playYouTurn(int x, int y, Symbol symbol){
        if(x<size && y<size && board[x][y]==null){
            board[x][y] = symbol;
            return true;
        }else{
            System.out.println("Not a valid move!!");
            return false;
        }
    }

    public void showBoard(){
        System.out.println("\n------- Board -------\n");
        System.out.println(" -- -- --- -- ---- --- ---");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(" | ");
                if(board[i][j]!=null){
                    System.out.print("  "+board[i][j]+"  ");
                }else{
                    System.out.print("  "+" "+"  ");
                }
            }
            System.out.print(" | ");
            System.out.println("");
            System.out.println(" -- -- --- -- ---- --- ---");
        }
        System.out.println("");
    }

    public List<Cell> getAvailableCell(){
        List<Cell> availableCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null)
                    availableCells.add(new Cell(i,j));
            }
        }
        return availableCells;
    }
    public boolean isWin(Symbol symbol){
        // check for row and column
        for(int i=0;i<size;i++){
            boolean rowFlag =  true;
            boolean colFlag = true;
            int j = 0;
            for(;j<size;j++){
                if(!symbol.equals(board[i][j]))
                    rowFlag = false;

                if(!symbol.equals(board[j][i]))
                    colFlag = false;
            }
            if(rowFlag || colFlag)
                return true;
        }
        // check for diagonal
        boolean leftFlag = true;
        boolean rightFlag = true;

        for(int i=0;i<size;i++){
            if(!symbol.equals(board[i][i]))
                leftFlag = false;
            if(!symbol.equals(board[i][size-i-1]))
                rightFlag = false;
        }
        if(leftFlag || rightFlag)
            return true;

        return false;
    }
}
