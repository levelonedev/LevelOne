package me.annanie.gobot.levelone;

import java.util.Random;

/**
 * Created by chris on 3/16/15.
 */
public class LevelOneBot {

    private Double komi = 6.5;
    private String name = "LevelOneBot";
    private String version = "v0.0000001";
    private Board board = new Board();
    Random random = new Random();

    public void setBoardSize(Integer boardSize) {
        this.board.setSize(boardSize);
    }

    public int getBoardSize() {
        return this.board.getSize();
    }

    public void clearBoard() {
        board.clear();
    }

    public void setKomi(Double komi) {
        this.komi = komi;
    }

    public Double getKomi() {
        return komi;
    }

    public Coordinate genMove(char color) {
        return new Coordinate(random.nextInt(getBoardSize()), random.nextInt(getBoardSize()));
    }

    public void getScore() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



    public void playMove(char color, Coordinate coord) {
        board.setCell(color, coord);
    }
}
