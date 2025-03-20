import java.util.Arrays;
import java.util.List;

public class SnakeLadderGame {
    public static void main(String[] args) {

        Board board =  Board.getBoardInstance(100);

        List<Snake> snakes =  Arrays.asList(new Snake(55,20), new Snake(20,1), new Snake(62,19),
                                            new Snake(56,30), new Snake(64,60));
        List<Ladder> ladders = Arrays.asList(new Ladder(23,51), new Ladder(10,59), new Ladder(75, 100),
                                             new Ladder(25, 60), new Ladder(1, 49), new Ladder(20,80));
        board.addSnakes(snakes);
        board.addLadders(ladders);

        Player player1 = new Player("p1","Player1");
        Player player2 = new Player("p2","Player2");

        Game game = new Game();
        System.out.println("\n");
        game.addPlayer(player1);
        game.addPlayer(player2);
        System.out.println("\n");
        DiceRollStrategy diceRollStrategy =  new StandardDiceRollStrategy();
        while(true){
            Player currentPlayer =  game.getCurrentPlayer();
            int steps = diceRollStrategy.roll();
            System.out.println("\n"+currentPlayer.getName()+" moved from "+currentPlayer.getPosition()+" to "+(currentPlayer.getPosition()+steps));

            Command command =  new MoveCommand(currentPlayer, board, steps);
            command.execute();
            if(currentPlayer.getPosition() == board.getMaxSize()){
                System.out.println("\n");
                game.notifyPlayers(currentPlayer.getName()+" wins!!");
                break;
            }
            game.nextPlayer();
        }
    }
}