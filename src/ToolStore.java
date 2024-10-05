public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- Magazaya Hosgeldiniz ! -----");
        String mesagge = "1-Silahlar\n" +
                          "2-Zirhlar\n" +
                           "q-Cikis";


        while(true){
            System.out.println(mesagge);
            System.out.print("Secim yapin :");
            String selectproduct = scanner.nextLine();
            if(selectproduct.equals("q")){
                System.out.println("Magazadan Cikiliyor");
                break;
            }
            else if(selectproduct.equals("1")){
                printWeapon();
                buyWeapon();

            }
            else if(selectproduct.equals("2")){
                printArmor();
                buyArmor();
            }
            else{
                System.out.println("Gecersiz islem lutfen dogru deger girin :");

            }
        }
        return  true;
    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for(Weapon weapon: Weapon.getWeapons()){
            System.out.println("ID :"+weapon.getId()
                    +"\t Silah :"+weapon.getName()
                    +"\t Fiyat :"+weapon.getPrice()
                    +"\t Hasar :"+weapon.getDamage());
        }

    }
    public void buyWeapon(){

        System.out.print("Hangi Silahi almak istiyorsunuz :");
        int selectWeapon = scanner.nextInt();
        while(selectWeapon < 1 || selectWeapon > Weapon.getWeapons().length)
        {
            System.out.print("Gecersiz deger duzgun girin :");
            selectWeapon = scanner.nextInt();
        }
        for (Weapon weapon: Weapon.getWeapons()){
            if(weapon.getId() == selectWeapon){
                if(weapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli Para yok");
                }
                else {
                    System.out.println(weapon.getName()+" Silahini Satin aldiniz.");
                    int balance = this.getPlayer().getMoney() - weapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan para :"+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(weapon);

                }
            }
        }
        scanner.nextLine();

    }
    public void printArmor(){
        System.out.println("----- Zirhlar -----");
        for(Armor armor: Armor.getArmors()){
            System.out.println("ID :"+armor.getId()
                    +"\t Level :"+armor.getLevel()
                    +"\t Fiyat :"+armor.getPrice()
                    +"\t Savunma :"+armor.getDefence());
        }

    }

    public void buyArmor(){
        System.out.print("Hangi Zirhi almak istiyorsunuz :");
        int selectArmor = scanner.nextInt();
        while(selectArmor < 1 || selectArmor > Weapon.getWeapons().length)
        {
            System.out.println("Gecersiz deger duzgun girin");
            selectArmor = scanner.nextInt();
        }
        for (Armor armor: Armor.getArmors()){
            if(armor.getId() == selectArmor){
                if(armor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli Para yok");
                }
                else {
                    System.out.println(armor.getLevel()+" Bir Zirh Satin aldiniz.");
                    int balance = this.getPlayer().getMoney() - armor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan para :"+ this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(armor);

                }
            }
        }

        scanner.nextLine();

    }


}
