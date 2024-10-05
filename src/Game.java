import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    public Game(){
        start();
    }
    public void start(){
        System.out.println("\n\n################## Macera Oyununa Hosgeldiniz! ##################");
        System.out.print("Lutfen Bir Nickname Girin : ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayin "+player.getName() + " Hosgeldiniz");
        System.out.println("Oyuna baslamak icin bir karakter secin !");
        player.selectChar();

        String zones = "1-Guvenli Ev --> Burada dusman yok Can yenilenir\n" +
                       "2-Magaza --> Buradan Zirh ve Silah alabilirsiniz\n" +
                       "3-Orman --> Burada 1 ile 3 arasinda vampir bulunur\n" +
                       "4-Magara --> Burada 1 ile 5 arasinda zombie bulunur\n" +
                       "5-Nehir --> Burada 1 ile 3 arasinda ayi bulunur\n" +
                       "6-Maden --> Burada yilanlar var ama item kasabilirsin\n" +
                       "q-Cikis -->Cikis yapmak icin";
        while(true){
            player.infoPlayer();
            GameLocation location = null;
            System.out.println("############## Bolgeler ##############");
            System.out.println(zones);
            System.out.print("Gitmek istediginiz bolgeyi secin :");
            String selectLoc = scanner.nextLine();
            switch (selectLoc){
                case "q":
                    System.out.println("Oyundan Cikiliyor...");
                    System.exit(0);
                    break;
                case "1":
                    if(player.isFinish()){
                        System.out.println("Tebrikler Oyunu bitirdiniz tekrar bekleriz.");
                        System.exit(0);
                    }
                    location = new SafeHouse(player);
                    break;
                case "2":
                    location = new ToolStore(player);
                    break;
                case "3":
                    if(player.getInventory().isFirewood()){
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Bu bolgeyi zaten bitirdiniz baska bolgelere saldirin");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    }
                    location = new Forest(player);
                    break;
                case "4":
                    if(player.getInventory().isFood()){
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Bu bolgeyi zaten bitirdiniz baska bolgelere saldirin");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    }
                    location = new Cave(player);
                    break;
                case "5":
                    if(player.getInventory().isWater()){
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Bu bolgeyi zaten bitirdiniz baska bolgelere saldirin");
                        System.out.println("-----------------------------------------------------------");

                        break;
                    }
                    location = new River(player);
                    break;
                case "6":
                    if(player.getInventory().isGold()){
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Bu bolgeyi zaten bitirdiniz baska bolgelere saldirin");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    }
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if(location != null && !location.onLocation()){
                System.out.println("GAME OVER !!!");
                break;
            }
            if(player.isFinish()){
                System.out.println("************* BUTUN BOLGELERI TEMIZLEDINIZ OYUNU BITIRMEK ICIN GUVENLI EVE GIDIN *************");
            }
        }
    }


}
