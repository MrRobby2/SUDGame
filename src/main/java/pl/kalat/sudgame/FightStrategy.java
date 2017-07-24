package pl.kalat.sudgame;

import pl.kalat.sudgame.domain.NPC;
import pl.kalat.sudgame.domain.Player;

public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);
    
}
