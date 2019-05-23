package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.wearable.WearableItem;
import io.fronky.homework3.zorkart.map.GameMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EquipCommand implements Command{

    private Scanner scanner = new Scanner(System.in);

    private void prompt(Map<String, WearableItem> itemMap){
        GameMap map = gameMediator.getCurrentLevel();
        Player player = map.getPlayer();
        boolean quit = false;
        while(!quit){
            System.out.print("choose your item to equip or type cancel: ");
            String commandLine = scanner.nextLine();
            commandLine = commandLine.trim().toLowerCase();
            if (commandLine.equals("")) continue;
            else if (commandLine.equals("cancel")) quit = true;
            else if(itemMap.containsKey(commandLine)){
                WearableItem wearableItem = itemMap.get(commandLine);
                if(player.equipItem(wearableItem)){
                    quit = true;
                }
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
        List<WearableItem> inventory = player.getItems(WearableItem.class);
        Map<String, WearableItem> inventoryMap = new HashMap<>();
        for(int i=0; i < inventory.size(); i++){
            WearableItem item = inventory.get(i);
            inventoryMap.put(String.valueOf(i), item);
            System.out.printf("[%d] %s\n", i, item.getClass().getSimpleName());
        }
        prompt(inventoryMap);
    }

    @Override
    public void describe() {
        System.out.println("equip: equip weapon or armor");
    }
}
