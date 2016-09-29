/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itprimo.sudgame.domain;

/**
 *
 * @author Robert Kałat
 */
public enum Direction {
N("North"),S("South"),W("West"),E("East"),D("Down"),U("Up");

private String directionDescription;

    private Direction(String directionDescription) {
        this.directionDescription = directionDescription;
    }

    public String getDirectionDescription() {
        return directionDescription;
    }


}
