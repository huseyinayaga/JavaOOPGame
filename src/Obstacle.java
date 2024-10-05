public class Obstacle {

    private int damage;
    private String name;
    private int health;
    private Loot loot;

    public Obstacle(int damage, String name, int health, Loot loot) {
        this.damage = damage;
        this.name = name;
        this.health = health;
        this.loot = loot;
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0 ){
            this.health = 0;
        }
        else{
            this.health = health;
        }
    }

    public Loot getLoot() {
        return loot;
    }

    public void setLoot(Loot loot) {
        this.loot = loot;
    }
}
