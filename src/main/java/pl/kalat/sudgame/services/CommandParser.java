package pl.kalat.sudgame.services;

import pl.kalat.sudgame.domain.Direction;
import pl.kalat.sudgame.domain.Player;

public class CommandParser {

    String result;

    public String actOnCommand(String playerCommand, Player player) {
        playerCommand = playerCommand.toLowerCase();
        String[] splitted = playerCommand.split(" ");
        Command command = null;

        Direction move = Direction.getDirection(splitted[0]);

        //dzieki zastosowaiu enuma zaoszczedzilismy ponad 10 linijek kodu, mnustwo mozliwosci bledow wyniklych ze zlego pisania,
        // a poza tym jesli juz gdzies przyjdzie zmiana to poprawisz tylko enuma i bedzie w calej aplikacji poprawione :)
        //idąc tym tropem zmień tak żeby nie używać wogóle switcha, tak naprawdę to jes to komenda prawie że zabroniona
        // ze względu na brak jakiejkowiek czytelnosci kodu i robią się straszne makarony

        if (move != Direction.UNKNOWN) {
            command = new MoveCommand(move, player);
        } else {
            switch (splitted[0]) {
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

                    if (splitted[1].equals("at")) {

                        if (splitted.length == 3) {
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
        }

        if (command != null) {
            System.out.println(command.execute());
        }

        return result;
    }
}
