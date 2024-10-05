public abstract class GameChar {
    private int id;
    private String charName;
    private int damage;
    private int money;
    private int health;

    public GameChar(int id,String charName,int damage, int money, int health) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.money = money;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
