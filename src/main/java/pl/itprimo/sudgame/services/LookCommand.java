package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class LookCommand implements Command {

    private Player player;
    private String targetName;

    public LookCommand(Player player) {
        this.player = player;
    }

    public LookCommand(Player player, String targetName) {
        this.player = player;
        this.targetName = targetName;
    }
    
    @Override
    public String execute() {
        String result = "";
        //String item ="";
        
        NPC targetNPC = player.getNearbyNPC(targetName);
        //item = player.getNearbyItem(targetName);
        if (targetNPC != null) {
            result = targetNPC.getDescription();
        } else {
            result = player.getCurrentLocationDescription();
        }
        return result;
    }
    
    /*
    public String execute() {
        String result = "";

        
            result = "You attack " + targetName;
            beginCombat(player, targetNPC);
        } else {
            result = "There's no one like that around.";
        }
        return result;
    }

    void beginCombat(Player player, NPC targetNPC) {

        FightStrategy fs = new AgilityFightStrategy();
        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);
        t.start();
    }
    */
    
}
