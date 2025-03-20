public class Player implements Observer{
    private final String id;
    private String name;
    private int position;
    public Player(String id, String name){
        this.id = id;
        this.name = name;
        position = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int move(int space){
        position+=space;
        return position;
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
