import java.util.Random;

public class Vampire extends Obstacle{

    public Vampire() {
        super(6, "Vampir", 14, new Money(7));
    }
    public static Vampire[] createVampire(){
        Random r = new Random();
        int randomNumber = r.nextInt(3) +1;
        Vampire[] vampirs = new Vampire[randomNumber];
        System.out.println(randomNumber + " Adet Vampir var");
        for(int i = 0; i<randomNumber; i++){
            vampirs[i] = new Vampire();
        }
        return vampirs;
    }
}
