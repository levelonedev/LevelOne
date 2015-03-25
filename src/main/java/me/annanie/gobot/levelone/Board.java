package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/23/15.
 */
public class Board {

    private int size;
    private char [][] boardGrid;
    private static final char EMPTY_CELL = ' ';


    public Board() {
         this(19);
    }
    public Board(int size){
        boardGrid = new char[size][size];
        clear();
    }

    public void clear() {
        for(int i = 0; i < size; i++) {
           for (int k = 0; k < size; k++) {
                boardGrid[i][k] = EMPTY_CELL;
            }
        }
    }

    public boolean isCellEmpty(Coordinate coord){
        return boardGrid[coord.getX()][coord.getY()] == EMPTY_CELL;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setCell(char color, Coordinate coord) {
        boardGrid[coord.getX()][coord.getY()] = color;
    }
}
