package pl.kalat.sudgame;

import pl.kalat.sudgame.domain.NPC;
import pl.kalat.sudgame.domain.Player;

public class FightThread implements Runnable {

    private Player player;
    private NPC targetNPC;
    FightStrategy fightStrategy;

    public FightThread(Player player, NPC targetNPC, FightStrategy fightStrategy) {
        this.player = player;
        this.targetNPC = targetNPC;
        this.fightStrategy = fightStrategy;
    }
    
    @Override
    public void run() {
        fightStrategy.fight(player,targetNPC);
    }
    
}
