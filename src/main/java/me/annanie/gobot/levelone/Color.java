package me.annanie.gobot.levelone;

/**
 * Created by chris on 3/23/15.
 */
public class Color {

    public static char BLACK = 'b';
    public static char WHITE = 'w';
    public static char ERROR = 'e';

    public static char parseColor(String color){
        if(color.equals("b")){
            return BLACK;
        } else if (color.equalsIgnoreCase("w")){
            return WHITE;
        } else {
            return ERROR;
        }
    }
}
