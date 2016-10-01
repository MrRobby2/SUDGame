/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itprimo.sudgame.domain;

import java.util.Random;

/**
 *
 * @author Robert Kałat
 */
public class FightThread implements Runnable {

    private Player player;
    private NPC targetNPC;

    public FightThread(Player player, NPC targetNPC) {
        this.player = player;
        this.targetNPC = targetNPC;
    }
    
    @Override
    public void run() {
        int hit = 0;
        while (player.isAlive() && targetNPC.isAlive()) {

            boolean targetStillHere = player.itThereNPCNearby(targetNPC);
            
            if(!targetStillHere) {
                System.out.println("Your target is no longer here");
                return;
            }
            try {
                hit = calculateHitStrength(player.getStrength());
                showHitMessage(targetNPC, hit);
                targetNPC.damageTaken(hit);
                Thread.sleep(2000);
                hit = calculateHitStrength(targetNPC.getStrength());
                showHitMessage(hit);
                player.damageTaken(hit);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Cos sie zwalilo");
            }
        }

        if (player.isAlive() && !targetNPC.isAlive()) {
            System.out.println("You're victoruious!");
        } else if (!player.isAlive() && targetNPC.isAlive()){
            System.out.println("Try harder next time");
        } else {
            System.out.println("Run away!");
        }
    }
    
    private int calculateHitStrength(int strenght) {
        Random r = new Random();
        return strenght + r.nextInt(4);

    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("You hit " + targetNPC.getName() + " for " + hit + " damage.");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + " damage.");
    }

}
