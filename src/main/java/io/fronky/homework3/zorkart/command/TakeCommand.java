package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.Item;
import io.fronky.homework3.zorkart.map.GameMap;
import io.fronky.homework3.zorkart.map.Room;

import java.util.Scanner;

public class TakeCommand implements Command {

    @Override
    public void apply() {
        GameMap gameMap = gameMediator.getCurrentLevel();
        Room room = gameMap.getRoom(gameMap.getCurrentLoc());
        Player player = gameMap.getPlayer();
        Item item = room.getItem();
        if(item != null){
            if(player.takeItem(item)){
                room.setItem(null);
            }
        }
    }

    @Override
    public void describe() {
        System.out.println("take: take an item in the room");
    }
}
