import java.util.Scanner;

public abstract class GameLocation {
    public static Scanner scanner = new Scanner(System.in);
    private String name;
    private Player player;
    public GameLocation(Player player,String name){
        this.player = player;
        this.name = name;
    }
    public Player getPlayer(){
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean onLocation();
}
