package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Player;

public class CommandParser {

    String result;

    public String actOnCommand(String playerCommand, Player player) {
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
                result = "CASE kill";
                break;
            case "look":
                if (splitted.length == 1) {
                    command = new LookCommand(player);
                    result = "CASE look";
                    break;
                }
            case "look at":
                if ( splitted[1].equals("at") ) {
                    if ( splitted.length == 3 ) {
                        command = new LookCommand(splitted[2], player);
                        result = "CASE look at target";
                    } else if (splitted.length == 2) {
                        System.out.println("You didn't enter the target");
                        result = "CASE look at without target";
                    }
                }
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

        if (command != null) {
            System.out.println(command.execute());
        }
        return result;
    }
}
