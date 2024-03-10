package com.Adesh;

public class PVP {

    public static void main(String[] args) {
        Player1 player = new Player1("Adesh", "Sword", 100);
//        System.out.println(player.getName());
//        System.out.println(player.getWeapon());
//        System.out.println(player.getHealth());
        
        player.damageByGun1();
        player.damageByGun1();
        player.damageByGun2();
        player.heal();
        
//        Player2 betterplayer = new Player2("Eden", "Gun", 80 , false );
//        
//        betterplayer.damageByGun1();
    }
}

