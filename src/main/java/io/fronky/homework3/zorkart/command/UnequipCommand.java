package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.wearable.WearableItem;
import io.fronky.homework3.zorkart.entity.items.wearable.armors.Armor;
import io.fronky.homework3.zorkart.entity.items.wearable.weapons.Weapon;
import io.fronky.homework3.zorkart.map.GameMap;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnequipCommand implements Command{

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
                if(player.unequip(wearableItem)){
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
        Pair<Armor, Weapon> equippedItems = player.getEquippedItem();
        Map<String, WearableItem> inventoryMap = new HashMap<>();
        int i = 1;
        if(equippedItems.getKey() != null){
            WearableItem item = equippedItems.getKey();
            inventoryMap.put(String.valueOf(i), item);
            System.out.printf("[%d] %s\n", i++, item.getClass().getSimpleName());
        }
        if(equippedItems.getValue() != null){
            WearableItem item = equippedItems.getKey();
            inventoryMap.put(String.valueOf(i), item);
            System.out.printf("[%d] %s\n", i, item.getClass().getSimpleName());
        }
        prompt(inventoryMap);
    }

    @Override
    public void describe() {
        System.out.println("unequip: unequip specified equipped item");
    }
}
