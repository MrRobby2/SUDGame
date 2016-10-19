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
                command = new KillCommand(splitted[1], player);
                break;
            case "look":
                if (splitted.length == 1) {
                    command = new LookCommand(player);
                    break;
                }
            case "look at":
                if (splitted[1].equals("at")) {
                    command = new LookCommand(splitted[2], player);
                }
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

        if (command != null) {
            System.out.println(command.execute());
        }
    }
}
