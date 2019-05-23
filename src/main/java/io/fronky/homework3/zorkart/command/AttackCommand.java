package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.entity.character.Monster;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.map.GameMap;
import io.fronky.homework3.zorkart.map.Room;

import java.util.Scanner;

public class AttackCommand implements Command {

    @Override
    public void apply() {
        GameMap gameMap = gameMediator.getCurrentLevel();
        Room room = gameMap.getRoom(gameMap.getCurrentLoc());
        Player player = gameMap.getPlayer();
        Monster monster = room.getMonster();
        if(monster != null){
            player.attack(monster);
            if(!monster.isAlive()){
                player.setAtk(player.getAtk()+monster.getAtk()/2);
                room.setMonster(null);
                gameMap.setNumOfMonster(gameMap.getNumOfMonster()-1);
            }
            else
                monster.examine();
            player.examine();
        }

        if(!player.isAlive()){
            System.out.println("Game Over!!");
            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            while(!quit){
                System.out.print("Want to replay? (yY/nN): ");
                String commandLine = scanner.nextLine().toLowerCase().trim();
                if(commandLine.equals("y")){
                    gameMediator.reset();
                    quit = true;
                }
                else if(commandLine.equals("n")){
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void describe() {
        System.out.println("attack: attack one monster in the room if exits");
    }

}
