import java.util.Random;

public class Bear extends  Obstacle{
    public Bear() {
        super(8, "Ayi", 20, new Money(12));
    }
    public static Bear[] createBear(){
        Random r = new Random();
        int randomNumber = r.nextInt(3) +1;
        Bear[] bears = new Bear[randomNumber];
        System.out.println(randomNumber + " Adet Ayi var");
        for(int i = 0; i<randomNumber; i++){
            bears[i] = new Bear();
        }
        return bears;
    }
}
