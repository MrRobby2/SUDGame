package pl.kalat.sudgame.services;

import pl.kalat.sudgame.domain.Direction;
import pl.kalat.sudgame.domain.Player;

public class MoveCommand implements Command {

    private Direction direction;
    private Player player;

    MoveCommand(Direction direction, Player player) {
        this.direction = direction;
        this.player = player;
    }

    @Override
    public String execute() {
        String result = "";
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            result = player.getCurrentLocationDescription();
        } else {
            result = "you can't go that way";
        }
        return result;
    }

}
