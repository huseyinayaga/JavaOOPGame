import java.util.Random;

public abstract class BattleLoc extends GameLocation{
    private Obstacle[] obstacle;
    private String award;
    public BattleLoc(Player player,String name,Obstacle[] obstacle,String award) {
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Suan Buradasiniz : "+this.getName());
        System.out.print("S-> Savas K-> Kac :");
        String selectCase = scanner.nextLine().toUpperCase();
        if(selectCase.equals("S")){
            if(combat()){
                System.out.println(this.getName()+ " Temizlendi");
                if(this.getAward().equals("firewood")){
                    this.getPlayer().getInventory().setFirewood(true);
                    System.out.println("Odun kazandiniz");

                }
                else if(this.getAward().equals("food")){
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println("Yemek kazandiniz");

                }
                else if(this.getAward().equals("water")){
                    this.getPlayer().getInventory().setWater(true);
                    System.out.println("Su kazandiniz");

                }
                else{
                    this.getPlayer().getInventory().setGold(true);
                    System.out.println("Altin kazandiniz");
                }
                return true;
            }
            else{
                if(this.getPlayer().getHealth() <=0){
                    return false;
                }

            }
        }

        return true;
    }
    public boolean combat(){

        int i = 1;
        for(Obstacle obs: obstacle){
            Random random = new Random();
            playerStats();
            obstacleStats(obs,i);
            int attackPriority = random.nextInt(101);
            while(this.getPlayer().getHealth()>0 && obs.getHealth() > 0){
                System.out.print("V-> Vur K-> Kac :");
                String selectCombat = scanner.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    // 50 den kucuk olmasi durumunda ilk once oyuncu vurucak
                    if (attackPriority < 50) {
                        System.out.println(obs.getName() + "'e Vurdunuz");
                        obs.setHealth(obs.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit(obs, i);

                        if (obs.getHealth() > 0) {

                            System.out.println(obs.getName() + " Size Vurdu");
                            int obstacleDamage = obs.getDamage() - this.getPlayer().getInventory().getArmor()
                                    .getDefence();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit(obs, i);
                            if (this.getPlayer().getHealth() <= 0) {
                                System.out.println(obs.getName() + " Sizi oldurdu");
                                return false;
                            }
                        }
                        else {
                            System.out.println(obs.getName() + " Oldu");
                            Loot loot =obs.getLoot();
                            if(loot instanceof Weapon){
                                this.getPlayer().getInventory().setWeapon((Weapon) loot);
                                System.out.println("Tebrikler "+((Weapon) loot).getName()+" Dusurdunuz");
                            }
                            else if(loot instanceof Armor){
                                this.getPlayer().getInventory().setArmor((Armor) loot);
                                System.out.println("Tebrikler "+((Armor) loot).getLevel()+" Zirh Dusurdunuz");
                            }
                            else{
                                this.getPlayer().setMoney(this.getPlayer().getMoney() +((Money) loot).getMoney());
                                System.out.println("Tebrikler "+((Money) loot).getMoney()+" Para Kazandiniz");

                            }
                            //this.getPlayer().setMoney(this.getPlayer().getMoney() +(int)obs.getLoot());
                        }
                    }
                    //50 den buyuk olmasi durumunda ilk once canavar vurucak
                    else{
                        if(obs.getHealth() > 0){
                            System.out.println(obs.getName() + " Size Vurdu");
                            int obstacleDamage = obs.getDamage() - this.getPlayer().getInventory().getArmor()
                                    .getDefence();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit(obs, i);
                            if (this.getPlayer().getHealth() <= 0) {
                                System.out.println(obs.getName() + " Sizi oldurdu");
                                return false;
                            }
                            System.out.println(obs.getName() + "'e Vurdunuz");
                            obs.setHealth(obs.getHealth() - this.getPlayer().getTotalDamage());
                            afterHit(obs, i);
                            if(obs.getHealth() <=0){
                                System.out.println(obs.getName() + " Oldu");
                                Loot loot =obs.getLoot();
                                if(loot instanceof Weapon){
                                    System.out.println("Tebrikler "+((Weapon) loot).getName()+" Dusurdunuz");
                                    this.getPlayer().getInventory().setWeapon((Weapon) loot);
                                }
                                else if(loot instanceof Armor){
                                    this.getPlayer().getInventory().setArmor((Armor) loot);
                                    System.out.println("Tebrikler "+((Armor) loot).getLevel()+" Zirh Dusurdunuz");
                                }
                                else{
                                    this.getPlayer().setMoney(this.getPlayer().getMoney() +((Money) loot).getMoney());
                                    System.out.println("Tebrikler "+((Money) loot).getMoney()+" Para Kazandiniz");
                                }
                            }
                        }

                    }
                }
                else if(selectCombat.equals("K")){

                    System.out.println(this.getPlayer().getName()+ " Kaciyor...");
                    return false;
                }
                else{
                    System.out.println("V ya da K seklinde girin");
                }

                /*if(selectCombat.equals("V")){
                    System.out.println(obs.getName()+"'e Vurdunuz");
                    obs.setHealth(obs.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit(obs,i);

                    if(obs.getHealth() > 0){

                        System.out.println(obs.getName()+" Size Vurdu");
                        int obstacleDamage = obs.getDamage() - this.getPlayer().getInventory().getArmor()
                                .getDefence();
                        if(obstacleDamage < 0 ){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit(obs,i);
                        if(this.getPlayer().getHealth() <= 0){
                            System.out.println(obs.getName()+" Sizi oldurdu");
                            return false;
                        }
                    }
                    else{
                        System.out.println(obs.getName()+" Oldu");
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+obs.getLoot());
                    }
                }
                else if(selectCombat.equals("K")){

                    System.out.println(this.getPlayer().getName()+ " Kaciyor...");
                    return false;
                }
                else{
                    System.out.println("V ya da K seklinde girin");
                }*/

            }
            i++;
        }
        return true;
    }
    public void afterHit(Obstacle obstacle,int i){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Caniniz :" +this.getPlayer().getHealth());
        System.out.println(i+ ". "+obstacle.getName()+ " Cani :"+obstacle.getHealth());
        System.out.println("-------------------------------------------------------------");
    }
    public void playerStats(){
        System.out.println("Oyuncu Degerleri :");
        System.out.println("--------------------------------------------");
        System.out.println("Saglik :"+this.getPlayer().getHealth());
        System.out.println("Hasar :"+ this.getPlayer().getTotalDamage());
        System.out.println("Para :" + this.getPlayer().getMoney());
        System.out.println("Silah :" +this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zirh :" +this.getPlayer().getInventory().getArmor().getLevel());
        System.out.println("Savunma :"+this.getPlayer().getInventory().getArmor().getDefence());
    }
    public void obstacleStats(Obstacle obs,int i){
        System.out.println();
        System.out.println(i+". "+obs.getName()+" Degerleri");
        System.out.println("-----------------------------------------");
        System.out.println("Saglik :"+obs.getHealth());
        System.out.println("Hasar :"+obs.getDamage());
        System.out.println("Odul :"+obs.getLoot());
    }

    public Obstacle[] getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle[] obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
