package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.GameMediator;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.Item;
import io.fronky.homework3.zorkart.map.GameMap;
import io.fronky.homework3.zorkart.map.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DropCommand implements Command{

    private Scanner scanner = new Scanner(System.in);

    public void prompt(Map<String, Item> itemMap){
        GameMap map = gameMediator.getCurrentLevel();
        Room room = map.getRoom(map.getCurrentLoc());
        Player player = map.getPlayer();
        boolean quit = false;
        while(!quit){
            System.out.print("choose your item to drop or type cancel: ");
            String commandLine = scanner.nextLine();
            commandLine = commandLine.trim().toLowerCase();
            if (commandLine.equals("")) continue;
            else if (commandLine.equals("cancel")) quit = true;
            else if(itemMap.containsKey(commandLine)){
                Item item = itemMap.get(commandLine);
                player.removeItem(item);
                room.setItem(item);
                quit = true;
                System.out.println("you have dropped " + commandLine);
            }
            else {
                System.out.println("no item found");
            }
        }
    }

    @Override
    public void apply() {
        GameMap map = gameMediator.getCurrentLevel();
        Player player = map.getPlayer();
        List<Item> inventory = player.getItems(Item.class);
        Map<String, Item> inventoryMap = new HashMap<>();
        for(int i=0; i<inventory.size(); i++){
            Item item = inventory.get(i);
            inventoryMap.put(String.valueOf(i), item);
            System.out.printf("[%d] %s\n", i, item.getClass().getSimpleName());
        }
        prompt(inventoryMap);
    }

    @Override
    public void describe() {
        System.out.println("drop: drop item of choice from inventory");
    }

}
