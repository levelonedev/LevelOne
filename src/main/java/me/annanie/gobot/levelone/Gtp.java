package me.annanie.gobot.levelone;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by chris on 3/16/15.
 */
public class Gtp {

    protected final BufferedReader bufferedIn;
    protected final PrintStream out;
    protected final LevelOneBot bot;
    protected final Map<String, BiFunction<String[], Integer, String>> commandList;

    public Gtp(InputStream in, PrintStream outout) {

        bufferedIn = new BufferedReader(new InputStreamReader(in));
        bot = new LevelOneBot();
        out = outout;
        commandList = createCommandList();
    }

    private Map<String, BiFunction<String[], Integer, String>> createCommandList(){
        Map<String, BiFunction<String[], Integer, String>> returnMap = new HashMap();

        //BOARDSIZE
        returnMap.put("boardsize", (commands, index) -> {
            try {
                Integer boardsize = Integer.parseInt(commands[index+1]);
                bot.setBoardSize(boardsize);
            } catch(NumberFormatException nfe){
                System.err.println("Illegal value for boardsize command: " + commands);
                return "ERROR ILLEGAL NUMBER";
            }
            return "";
        });

        //CLEARBOARD
        returnMap.put("clear_board", (commands, index) -> {
            bot.clearBoard();
            return "";
        });

        //KOMI
        returnMap.put("komi", (commands, index) -> {
            try {
                Double komi = Double.parseDouble(commands[index+1]);
                bot.setKomi(komi);
            } catch(NumberFormatException nfe){
                System.err.println("Illegal value for komi command: " + commands);
                return "ERROR ILLEGAL NUMBER" + commands[index+1];
            }
            return "";
        });

        //PLAY
        returnMap.put("play", (commands, index) -> {
            char color = Color.parseColor(commands[index+1]);
            String move = commands[index+2];
            if(move.equalsIgnoreCase("pass")){
                return "";
            }else {
                Coordinate coord = Coordinate.parseCoord(commands[index + 2]);
                bot.playMove(color, coord);
                return "";
            }
        });

        //GENMOVE
        returnMap.put("genmove", (commands, index) -> {
            char color = Color.parseColor(commands[index+1]);
            Coordinate coord = bot.genMove(color);
            return coord.toString();
        });

        //FINAL_SCORE
        returnMap.put("final_score", (commands, index) -> {
            bot.getScore();
            return "final_score not implemented yet.";
        });

        //NAME
        returnMap.put("name", (commands, index) -> {
            return bot.getName();
        });

        //VERSION
        returnMap.put("version", (commands, index) -> {
            return bot.getVersion();
        });

        //VERSION
        returnMap.put("list_commands", (commands, index) -> {
            return returnMap.keySet().stream().collect(Collectors.joining(" "));
        });

        return returnMap;
    }

    public void run() throws IOException {
        boolean playing = true;
        String line = null;
        String commandId = "";
        int commandIndex = 0;
        while (playing){
            line = bufferedIn.readLine();
            String[] lines = line.split(" ");
            if (lines[0].matches("\\d+")){
                commandId = lines[0];
                commandIndex = 1;
            } else {
                commandId = "";
                commandIndex = 0;
            }

            if(commandList.containsKey(lines[commandIndex])) {
                String result = commandList.get(lines[commandIndex]).apply(lines, commandIndex);
                out.print("="+commandId+ " " + result + "\n\n");
            } else {
                out.print("?" + commandId + "Command not found. Ignoring: " + line + "\n\n");
            }

            System.out.flush();
        }
    }
}
