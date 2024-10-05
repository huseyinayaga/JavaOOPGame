import java.util.Random;

public class Snake extends Obstacle{
    private static Random random = new Random();
    public Snake() {
        super(createDamage(),"Yilan", 12,createLoot());
    }
    private static int createDamage(){
        int randomDamage =random.nextInt(4)+3;
        return randomDamage;
    }
    private static Loot createLoot(){
        int randomLoot = random.nextInt(100);
        if(randomLoot < 15){
            //silah
            int randomWeapon = random.nextInt(100);
            if(randomWeapon <50){
                return new Weapon(1,"tabanca",15,3);
            }
            else if(randomWeapon<70){
                return new Weapon(3,"mizrak",35,8);
            }
            else {
                new Weapon(2,"kilic",30,5);
            }

        }
        else if(randomLoot >=15 && randomLoot <30){
            //zirh
            int randomArmor = random.nextInt(100);
            if(randomArmor <50){
                return new Armor(1,"hafif",20,1);
            }
            else if(randomArmor<70){
                return new Armor(3,"agir",40,5);
            }
            else {
                return new Armor(2,"orta",30,3);
            }
        }
        else if(randomLoot >= 30 && randomLoot <=55){
            //para
            int randomCash = random.nextInt(100);
            if(randomCash <50){
                return new Money(1);
            }
            else if(randomCash<70){
                return new Money(10);
            }
            else {
                return new Money(5);
            }

        }

        return new Money(0);

    }

    public static Snake[] createSnake(){
        Random r = new Random();
        int randomNumber = r.nextInt(5) +1;
        Snake[] snakes = new Snake[randomNumber];
        System.out.println(randomNumber + " Adet Yilan var");
        for(int i = 0; i<randomNumber; i++){
            snakes[i] = new Snake();
        }
        return snakes;
    }


}
