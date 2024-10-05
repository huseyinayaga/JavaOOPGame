import java.util.Scanner;

public class Player {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int damage;
    private int totalDamage;
    private int defHealth;

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    private int health;

    public int getTotalDamage() {
        return damage+ inventory.getWeapon().getDamage();
    }

    public void setTotalDamage(int totalDamage) {
        this.totalDamage = damage + inventory.getWeapon().getDamage();
    }

    private int money;
    private String charName;
    private Inventory inventory;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if( health < 0){
            this.health = 0;
        }
        else{
            this.health = health;
        }
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

    public Player(String playerName){
        this.name = playerName;
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public  void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler");
        System.out.println("---------------------------------------------------------------------------");
        for(GameChar gameChar :charList){
            System.out.println("ID :"+gameChar.getId() +
                    "\t Karakter :"+gameChar.getCharName()+
                    "\t\t Hasar :"+gameChar.getDamage() +
                    "\t\t Saglik :"+ gameChar.getHealth() +
                    "\t\t Para :"+gameChar.getMoney());
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.print("Lutfen bir karakter secin :");
        String selectChar = scanner.nextLine();
        switch (selectChar){
            case "1":
                initPlayer(new Samurai());
                break;
            case "2":
                initPlayer(new Archer());
                break;
            case "3":
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;

        }
    }
    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getCharName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setDefHealth(gameChar.getHealth());
    }

    public void infoPlayer(){
        System.out.println("Karakter : "+this.getCharName() +
                ",\t Silah : "+this.getInventory().getWeapon().getName()+
                ",\t Zirh : "+this.getInventory().getArmor().getLevel()+
                ",\t Savunma : "+this.getInventory().getArmor().getDefence()+
                ",\t Hasar :"+this.getTotalDamage()+
                ",\t Saglik :"+this.getHealth()+
                ",\t Para :"+this.getMoney());
    }
    public boolean isFinish(){
        return this.getInventory().isFirewood()
            && this.getInventory().isWater()
            && this.getInventory().isFood()
            && this.getInventory().isGold();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
