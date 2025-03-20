public class MoveCommand implements Command{
    private Player player;
    private Board board;
    private int steps;

    public MoveCommand(Player player, Board board, int steps){
        this.player = player;
        this.board = board;
        this.steps = steps;
    }
    @Override
    public void execute() {
        int newPosition = player.getPosition()+steps;
        if(newPosition > board.getMaxSize())
            newPosition = board.getMaxSize();
        if(board.getSnakesMap().containsKey(newPosition)){
            newPosition =  board.getSnakesMap().get(newPosition);
            System.out.println("Oh no!! "+player.getName()+" bitten by snake and moved to the position "+newPosition);
        }
        if(board.getLaddersMap().containsKey(newPosition)){
            newPosition =  board.getLaddersMap().get(newPosition);
            System.out.println("Great "+player.getName()+" got ladder and moved to the position "+newPosition);
        }
        player.setPosition(newPosition);
    }
}
