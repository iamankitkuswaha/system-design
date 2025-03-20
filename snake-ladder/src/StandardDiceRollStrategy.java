import java.util.Random;

public class StandardDiceRollStrategy implements DiceRollStrategy{
    private Random random;

    public StandardDiceRollStrategy(){
        random = new Random();
    }
    @Override
    public int roll() {
        return random.nextInt(6)+1;
    }
}
