public class Weapon extends Loot{
    private int id;
    private String name;
    private int price;
    private int damage;

    @Override
    public String toString() {
        return name;
    }

    public Weapon(int id, String name, int price, int damage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public static Weapon[] getWeapons(){
        Weapon[] weapons = {new Weapon(1,"tabanca",15,3),
                            new Weapon(2,"kilic",30,5),
                            new Weapon(3,"mizrak",35,8)};
        return weapons;
    }
}
