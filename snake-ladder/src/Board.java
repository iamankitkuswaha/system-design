import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Board {
    private static Board boardInstance;
    private final int maxSize;
    private Map<Integer, Integer> snakesMap;
    private Map<Integer, Integer> laddersMap;

    private Board(int maxSize){
        snakesMap =  new ConcurrentHashMap<>();
        laddersMap = new ConcurrentHashMap<>();
        this.maxSize = maxSize;
    }

    public static Board getBoardInstance(int maxSize){
        if(boardInstance == null)
            boardInstance =  new Board(maxSize);
        return boardInstance;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public Map<Integer, Integer> getSnakesMap(){
        return snakesMap;
    }
    public Map<Integer, Integer> getLaddersMap(){
        return laddersMap;
    }

    public void addSnakes(List<Snake> snakesList){
        for(Snake snake : snakesList)
            snakesMap.put(snake.getHead(), snake.getTail());
    }

    public void addLadders(List<Ladder> laddersList){
        for(Ladder ladder : laddersList)
            laddersMap.put(ladder.getFoot(), ladder.getHead());
    }
}
