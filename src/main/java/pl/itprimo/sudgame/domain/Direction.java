package pl.itprimo.sudgame.domain;

public enum Direction {
N("North"),S("South"),W("West"),E("East"),D("Down"),U("Up");

private String directionDescription;

    private Direction(String directionDescription) {
        this.directionDescription = directionDescription;
    }

    @Override
    public String toString() {
        return directionDescription;
    }


}
