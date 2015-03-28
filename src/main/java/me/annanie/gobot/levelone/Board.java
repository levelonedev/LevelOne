package me.annanie.gobot.levelone;

import java.util.*;

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

    public void playCell(Move nextMove){
        if(isMoveLegal(nextMove)){
            capture(nextMove);
        }



    }

    private boolean inBounds(int value){
        return (value < size && value >= 0);
    }

    public void capture(Move newMove){
        this.setCell(newMove);

        for(Coordinate c : findNeighbors(newMove.getCoordinate())){
            if(getCellValue(c) != newMove.getColor()){
                if(countLiberties(c) == 0){
                    removeGroup(c);
                }
            }
        }
    }

    private void removeGroup(Coordinate coordinate) {
        Queue<Coordinate> leftToRemove = new LinkedList<>();
        char groupColor = getCellValue(coordinate);

        leftToRemove.add(coordinate);

        Set<Coordinate> checkedSet = new HashSet<>();

        while (!leftToRemove.isEmpty()){
            Coordinate coord = leftToRemove.remove();

            for(Coordinate c : findNeighbors(coord)){
                if (getCellValue(c) == groupColor && !checkedSet.contains(c)){
                    leftToRemove.add(c);
                }
            }
            setCell(new Move(EMPTY_CELL, coord));
            checkedSet.add(coord);
        }
    }

    public List<Coordinate> findNeighbors(Coordinate coord){
        ArrayList<Coordinate> returnList = new ArrayList<>();

        if(inBounds(coord.getX() + 1)){
            returnList.add(new Coordinate(coord.getX() + 1, coord.getY()));
        }
        if(inBounds(coord.getX() - 1)){
            returnList.add(new Coordinate(coord.getX() - 1, coord.getY()));
        }
        if(inBounds(coord.getY() + 1)){
            returnList.add(new Coordinate(coord.getX(), coord.getY() + 1));
        }
        if(inBounds(coord.getY() - 1)){
            returnList.add(new Coordinate(coord.getX(), coord.getY() - 1));
        }

        return returnList;
    }

    private int countLiberties(Coordinate coordinate) {
        Queue<Coordinate> leftToCheck = new LinkedList<>();
        int liberties = 0;
        char groupColor = getCellValue(coordinate);

        leftToCheck.add(coordinate);

        while (!leftToCheck.isEmpty()){
            Coordinate coord = leftToCheck.remove();

            for(Coordinate c : findNeighbors(coord)) {
                if(!c.equals(coord)) {
                    if (getCellValue(c) == EMPTY_CELL) {
                        liberties += 1;
                    } else if (getCellValue(c) == groupColor) {
                        leftToCheck.add(c);
                    }
                }
            }
        }

        return liberties;
    }

    private char getCellValue(Coordinate coord) {
        return boardGrid[coord.getX()][coord.getY()];
    }

    public void setCell(Move setMove) {
        boardGrid[setMove.getCoordinate().getX()][setMove.getCoordinate().getY()] = setMove.getColor();
    }

    public boolean isMoveLegal(Move newMove) {
        if(!isCellEmpty(newMove.getCoordinate())){
            return false;
        }
//        if (isSuicide(newMove)){
//            return false;
//        }
//        if (breaksKoRule(newMove)){
//            return false;
//        }

        return true;
    }
}
