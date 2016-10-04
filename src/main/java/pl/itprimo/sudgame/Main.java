package pl.itprimo.sudgame;

import java.util.Scanner;
import pl.itprimo.sudgame.domain.Player;
import pl.itprimo.sudgame.repository.LocationRepository;
import pl.itprimo.sudgame.services.CommandParser;

public class Main {

    public static void main(String[] args) {

        LocationRepository locationRepository = new LocationRepository();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName, 100, 10);

        player.setCurrentLocation(locationRepository.getStartLocation());

        System.out.println(player.getCurrentLocationDescription());

        String command = "";
        while (!command.equals("quit")) {
            command = readPlayerInput(scanner);
            CommandParser.actOnCommand(command, player);
        }

        System.out.println("Bye!");
    }

    private static String readPlayerInput(Scanner scanner) {
        System.out.println(">");
        String command = scanner.nextLine();
        return command;
    }
}
