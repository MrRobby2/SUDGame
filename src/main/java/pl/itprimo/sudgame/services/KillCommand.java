package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.AgilityFightStrategy;
import pl.itprimo.sudgame.FightStrategy;
import pl.itprimo.sudgame.FightThread;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

public class KillCommand implements Command {

    private String targetName;
    private Player player;

    KillCommand(String targetName, Player player) {
        this.targetName = targetName;
        this.player = player;
    }

    @Override
    public String execute() {
        String result = "";

        NPC targetNPC = player.getNearbyNPC(targetName);
        if (targetNPC != null) {
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
}
