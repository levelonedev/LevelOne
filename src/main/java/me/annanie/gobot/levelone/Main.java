package me.annanie.gobot.levelone;

import java.io.IOException;

/**
 * Created by chris on 3/16/15.
 */
public class Main {
    public static void main(String[] args){
        Gtp gtp = new Gtp(System.in, System.out);
        try {
            gtp.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
