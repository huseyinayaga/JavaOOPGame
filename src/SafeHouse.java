public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player,"Guvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Guvenli Evdesiniz !");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        System.out.println("Caniniz Yenilendi :");
        System.out.println("--------------------------------------------------");
        return true;
    }
}
