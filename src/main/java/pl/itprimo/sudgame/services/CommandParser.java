package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.AgilityFightStrategy;
import pl.itprimo.sudgame.FightStrategy;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.FightThread;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

public class CommandParser {

    public void actOnCommand(String playerCommand, Player player) {
        playerCommand = playerCommand.toLowerCase();

        String[] splitted = playerCommand.split(" ");

        Command command = null;

        switch (splitted[0]) {
            case "n":
            case "north":
                command = new MoveCommand(Direction.N, player);
                break;
            case "s":
            case "south":
                command = new MoveCommand(Direction.S, player);
                break;
            case "e":
            case "east":
                command = new MoveCommand(Direction.E, player);
                break;
            case "w":
            case "west":
                command = new MoveCommand(Direction.W, player);
                break;
            case "kill":
                attack(splitted[1], player);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

        if (command != null) {
            command.execute();
        }
    }

    void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if (target != null) {
            beginCombat(player, targetNPC);
        } else {
            System.out.println("There's no one like that around.");
        }
    }

    private void beginCombat(Player player, NPC targetNPC) {

        FightStrategy fs = new AgilityFightStrategy();
        FightThread ft = new FightThread(player, targetNPC, fs);
        Thread t = new Thread(ft);
        t.start();
    }

}
