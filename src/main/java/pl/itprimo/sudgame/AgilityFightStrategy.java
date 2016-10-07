/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itprimo.sudgame;

import java.util.Random;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class AgilityFightStrategy implements FightStrategy {

    public void fight(Player player, NPC targetNPC) {
        int hit = 0;
        while (player.isAlive() && targetNPC.isAlive()) {

            boolean targetStillHere = player.itThereNPCNearby(targetNPC);

            if (!targetStillHere) {
                System.out.println("Your target is no longer here");
                return;
            }
            try {
                if (calculateHitStrength(player, targetNPC)) {

                    hit = calculateHitStrength(player.getStrength());
                    showHitMessage(targetNPC, hit);
                    targetNPC.damageTaken(hit);
                } else {
                    System.out.println("Your hit missed " + targetNPC.getName());
                }

                Thread.sleep(2000);

                if (calculateHitStrength(targetNPC, player)) {
                    hit = calculateHitStrength(targetNPC.getStrength());
                    showHitMessage(hit);
                    player.damageTaken(hit);
                } else {
                    System.out.println(targetNPC.getName()+ "'s hit missed you");
                }

                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Cos sie zwalilo");
            }
        }

        if (player.isAlive() && !targetNPC.isAlive()) {
            System.out.println("You're victoruious!");
        } else if (!player.isAlive() && targetNPC.isAlive()) {
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

    private boolean calculateHitStrength(NPC targetNPC, Player player) {
        int rand = new Random().nextInt(20);
        // jesli true to gracz zostaje trafiony
        return (targetNPC.getAgility() + rand) > player.getAgility();
    }

    private boolean calculateHitStrength(Player player, NPC targetNPC) {
        int rand = new Random().nextInt(40);
        // jesli true to NPC zostaje trafiony
        return (player.getAgility() + rand) > targetNPC.getAgility();
    }

}
