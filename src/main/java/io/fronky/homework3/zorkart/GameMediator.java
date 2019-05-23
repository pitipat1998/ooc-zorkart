package io.fronky.homework3.zorkart;

import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.map.GameMap;
import io.fronky.homework3.zorkart.map.Level1;
import io.fronky.homework3.zorkart.map.Level2;
import io.fronky.homework3.zorkart.map.Level3;

import java.util.*;

public class GameMediator {

    private static GameMediator gameMediator = null;

    private Player player;
    private Queue<GameMap> maps;
    private GameMap currentLevel;

    private GameMediator(){
        reset();
    }

    public void reset(){
        player = new Player();
        maps = new LinkedList<>();
        currentLevel = null;
        addMap(new Level1(player));
        addMap(new Level2(player));
        addMap(new Level3(player));
    }

    public static GameMediator getInstance(){
        if(gameMediator == null){
            gameMediator = new GameMediator();
        }
        return gameMediator;
    }

    public void addMap(GameMap map){
        if(map == null) return;
        maps.add(map);
        if(currentLevel == null){
            currentLevel = maps.poll();
        }
    }

    public void nextMap(){
        if(maps.peek() != null){
            currentLevel = maps.poll();
        }
        else{
            System.out.println("CONGRATS YOU WIN THE GAME");
            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            while(!quit){
                System.out.print("Want to replay? (yY/nN): ");
                String commandLine = scanner.nextLine().toLowerCase().trim();
                if(commandLine.equals("y")){
                    reset();
                    quit = true;
                }
                else if(commandLine.equals("n")){
                    System.exit(0);
                }
            }

        }
    }

    public GameMap getCurrentLevel() {
        return currentLevel;
    }

}
