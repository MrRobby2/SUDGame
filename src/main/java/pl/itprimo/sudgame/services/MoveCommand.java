package pl.itprimo.sudgame.services;

import pl.itprimo.sudgame.domain.Direction;
import pl.itprimo.sudgame.domain.Player;

public class MoveCommand implements Command {

    Direction direction;
    Player player;

    MoveCommand(Direction direction, Player player) {
        this.direction = direction;
        this.player = player;
    }

    @Override
    public void execute() {
        boolean hasMoved = player.move(direction);
        if (hasMoved) {
            System.out.println(player.getCurrentLocationDescription());
        } else {
            System.out.println("you can't go that way");
        }
    }

}
