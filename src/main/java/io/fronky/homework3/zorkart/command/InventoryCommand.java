package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.Item;
import io.fronky.homework3.zorkart.map.GameMap;

import java.util.List;

public class InventoryCommand implements Command {

    @Override
    public void apply() {
        GameMap map = gameMediator.getCurrentLevel();
        Player player = map.getPlayer();
        List<Item> inventory = player.getItems(Item.class);
        for(Item item : inventory){
            item.examine();
        }
    }

    @Override
    public void describe() {
        System.out.println("inventory: show player's current inventory");
    }
}
