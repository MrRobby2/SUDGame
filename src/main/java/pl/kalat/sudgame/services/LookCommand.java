package pl.kalat.sudgame.services;

import pl.kalat.sudgame.domain.NPC;
import pl.kalat.sudgame.domain.Player;

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

    public LookCommand(String targetName, Player player) {
        this.player = player;
        this.targetName = targetName;
    }
    
    @Override
    public String execute() {
        String result = "";
        String item ="";
        
        NPC targetNPC = player.getNearbyNPC(targetName);
        item = player.getNearbyItem(targetName);
        
        if ( (targetNPC != null) && (item != null)) {
            result = "NPC: " + targetNPC.getDescription()
                    + "\nItem: " + item;
        } else if (targetNPC != null) {
            result = targetNPC.getDescription();
        } else if (item != null) {
            result = item;
        } else {
            result = player.getCurrentLocationDescription();
        }
        return result;
    }
    
}