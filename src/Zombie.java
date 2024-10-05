import java.util.Random;

public class Zombie extends Obstacle{
    public Zombie() {
        super(5, "Zombi", 10, new Money(4));
    }
    public static Zombie[] createZombie(){
        Random r = new Random();
        int randomNumber = r.nextInt(5) +1;
        Zombie[] zombies = new Zombie[randomNumber];
        System.out.println(randomNumber + " Adet Zombi var");
        for(int i = 0; i<randomNumber; i++){
            zombies[i] = new Zombie();
        }
        return zombies;
    }
}
