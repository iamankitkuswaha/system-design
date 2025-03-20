import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayer;
    public Game(){
        players =  new ArrayList<>();
        currentPlayer = 0;
    }

    public void addPlayer(Player player){
        players.add(player);
        System.out.println(player.getName()+": "+ "added!!");
    }
    public void notifyPlayers(String message){
        for(Player player : players){
            player.update(message);
            break;
        }
    }
    public Player getCurrentPlayer(){
        return players.get(currentPlayer);
    }

    public void nextPlayer(){
        currentPlayer =  (currentPlayer+1)%players.size();
    }
}
