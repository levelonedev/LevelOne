package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/27/15.
 */
public class Move {
    private char color;
    private Coordinate coord;

    public Move (char color, Coordinate coord){
        this.color = color;
        this.coord = coord;
    }


    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public Coordinate getCoordinate() {
        return coord;
    }

    public void setCoordinate(Coordinate coord) {
        this.coord = coord;
    }
}
