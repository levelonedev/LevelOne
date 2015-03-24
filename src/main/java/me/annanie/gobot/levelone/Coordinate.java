package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/23/15.
 */
public class Coordinate {
    private int y;
    private int x;

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
        x = xChar -'A';
        y = Integer.parseInt(move.substring(1)) - 1;

        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        StringBuffer coordinate = new StringBuffer();

        coordinate.append((char) (this.x + 'A'));
        coordinate.append(this.y+1);
        return coordinate.toString();
    }
}
