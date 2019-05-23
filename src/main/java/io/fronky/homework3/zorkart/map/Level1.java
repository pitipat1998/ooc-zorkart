package io.fronky.homework3.zorkart.map;

import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.entity.character.Monster;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.usable.Key;
import io.fronky.homework3.zorkart.entity.items.usable.potions.SmallHpPotion;
import io.fronky.homework3.zorkart.entity.items.wearable.armors.Chainmail;
import io.fronky.homework3.zorkart.entity.items.wearable.weapons.Sword;

public class Level1 extends GameMap {

    private static final int ROWS = 4;
    private static final int COLS = 4;

    private Location destination;

    public Level1(Player player){
        super(ROWS, COLS, new Location(0,0), player);

        fillRoom();

        placeRoom(new Room(true), 0, 1);

        placeRoom(new Room(true), 1, 3);

        placeRoom(new Room(true), 2, 0);
        placeRoom(new Room(true), 2, 1);
        placeRoom(new Room(true), 2, 3);

        getRoom(2,2).setLocked(true);

        getRoom(0,2).setMonster(new Monster());
        getRoom(3,2).setMonster(new Monster());
        setNumOfMonster(2);

        getRoom(1, 0).setItem(new Chainmail());
        getRoom(0,2).setItem(new Sword());
        getRoom(0, 3).setItem(new Key(2, 2));
        getRoom(2,2).setItem(new SmallHpPotion());

        destination = new Location(3, 3);
    }

    @Override
    public boolean achieveObjective(){
        return getCurrentLoc().equals(destination);
    }

    @Override
    public void printObjective(){
        System.out.println("Find the key to pass this level");
    }

}
