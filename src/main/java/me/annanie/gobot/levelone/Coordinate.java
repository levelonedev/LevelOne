package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/23/15.
 */
public class Coordinate {
    private int y;
    private int x;
    public static String rowValues = "ABCDEFGHJKLMNOPQRST";


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate() {

    }

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Coordinate parseCoord(String move){
        int x = 0;
        int y = 0;
        String upperedMove = move.toUpperCase();
        char xChar = upperedMove.charAt(0);
        x = rowValues.indexOf(xChar);
        y = Integer.parseInt(move.substring(1)) - 1;

        return new Coordinate(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer coordinate = new StringBuffer();

        coordinate.append(rowValues.substring(this.x, this.x+1));
        coordinate.append(this.y+1);
        return coordinate.toString();
    }
}
