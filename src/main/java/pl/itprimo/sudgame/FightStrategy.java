package pl.itprimo.sudgame;

import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public interface FightStrategy {

    public void fight(Player player, NPC targetNPC);
    
}
