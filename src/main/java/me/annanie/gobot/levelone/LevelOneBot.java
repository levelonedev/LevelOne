package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/16/15.
 */
public class LevelOneBot {


    private Integer boardSize;
    private Double komi;
    private String name = "LevelOneBot";
    private String version = "v0.0000001";

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public void clearBoard() {

    }

    public void setKomi(Double komi) {
        this.komi = komi;
    }

    public Double getKomi() {
        return komi;
    }

    public void genMove() {
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
}
