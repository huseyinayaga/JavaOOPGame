public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean firewood;
    private boolean food;
    private boolean water;
    private boolean gold;

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public Inventory(){
        this.weapon = new Weapon(0,"Yumruk",0,0);
        this.armor = new Armor(0,"bos",0,0);
        this.firewood = false;
        this.food = false;
        this.water = false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
