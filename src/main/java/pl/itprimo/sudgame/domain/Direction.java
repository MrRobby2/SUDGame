package pl.itprimo.sudgame.domain;

public enum Direction {
    N("North","n"),
    S("South","s"),
    W("West","w"),
    E("East","e"),
    D("Down","d"),
    U("Up","u"),
    UNKNOWN("","");

    private String directionDescription;
    private String directionDescriptionShort;

    Direction(String directionDescription, String directionDescriptionShort) {
        this.directionDescription = directionDescription;
        this.directionDescriptionShort = directionDescriptionShort;
    }

    public String getDirectionDescription() {
        return directionDescription;
    }

    public String getDirectionDescriptionShort() {
        return directionDescriptionShort;
    }

    @Override
    public String toString() {
        return directionDescription;
    }

    public static Direction getDirection(String commad){
        for(Direction d : Direction.values()){
            if(d.getDirectionDescription().equals(commad)){
                return d;
            }

            if(d.getDirectionDescriptionShort().equals(commad)){
                return d;
            }
        }

        return Direction.UNKNOWN;
    }


}
