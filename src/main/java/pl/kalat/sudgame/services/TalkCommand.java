/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kalat.sudgame.services;

import pl.kalat.sudgame.domain.Player;

/**
 *
 * @author Robert Kałat
 */
public class TalkCommand implements Command {

    private Player player;
    private String targetName;

    public TalkCommand(String targetName, Player player) {
        this.player = player;
        this.targetName = targetName;
    }
    
    

    @Override
    public String execute() {

        return "";
    }

}
