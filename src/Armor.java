public class Armor extends Loot{
    private int id;
    private String level;
    private int price;
    private int defence;
    private String name="Zirh";


    @Override
    public String toString() {
        return name;
    }

    public Armor(int id, String level, int price, int defence) {
        this.id = id;
        this.level = level;
        this.price = price;
        this.defence = defence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public static Armor[] getArmors(){
        Armor[] armors = {new Armor(1,"hafif",20,1),
                          new Armor(2,"orta",30,3),
                          new Armor(3,"agir",40,5)};
        return armors;
    }
}
