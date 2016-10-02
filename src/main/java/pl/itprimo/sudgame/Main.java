package pl.itprimo.sudgame;

import java.util.Scanner;
import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.FightThread;
import pl.itprimo.sudgame.domain.Location;
import pl.itprimo.sudgame.domain.NPC;
import pl.itprimo.sudgame.domain.Player;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100, 10);

        Location startLoc = new Location("Small room", "You're in small, dark room. Single bed standing next to the walll is only furniture in here");
        Location secondLocation = new Location("Dark corridor", "...");

        startLoc.addExit(Direction.N, secondLocation);
        secondLocation.addExit(Direction.S, startLoc);

        NPC ork = new NPC("Ork", 50, 5);

        startLoc.addNpc(ork);

        player.setCurrentLocation(startLoc);

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while (!command.equals("zakoncz")) {
            command = readPlayerInput(scanner);
            actOnCommand(command, player);
        }

        System.out.println("Bye!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");
        String command = scanner.nextLine();
        return command;
    }

    private static void actOnCommand(String command, Player player) {

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

    private static void move(Direction direction, Player player) {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("you can't go that way");
        }
    }

    private static void attack(String target, Player player) {
        NPC targetNPC = player.getNearbyNPC(target);
        if (target != null) {
            beginCombat(player, targetNPC);
        } else {
            System.out.println("There's no one like that around.");
        }
    }

    private static void beginCombat(Player player, NPC targetNPC) {

        FightThread ft = new FightThread(player, targetNPC);
        Thread t = new Thread(ft);
        t.start();
    }
}