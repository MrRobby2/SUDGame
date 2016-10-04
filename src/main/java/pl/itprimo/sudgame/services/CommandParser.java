package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.FightThread;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class CommandParser {

    public void actOnCommand(String command, Player player){
        command = command.toLowerCase();

        String[] splitted = command.split(" ");

        switch (splitted[0]) {
            case "n":
            case "north":
                move(Direction.N, player);
                break;
            case "s":
            case "south":
                move(Direction.S, player);
                break;
            case "e":
            case "east":
                move(Direction.E, player);
                break;
            case "w":
            case "west":
                move(Direction.W, player);
                break;
            case "kill":
                attack(splitted[1], player);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
    
    void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("you can't go that way");
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

        FightThread ft = new FightThread(player, targetNPC);
        Thread t = new Thread(ft);
        t.start();
    }
     
}
