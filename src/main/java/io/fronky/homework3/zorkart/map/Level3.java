package io.fronky.homework3.zorkart.map;

import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.entity.character.Demon;
import io.fronky.homework3.zorkart.entity.character.Monster;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.usable.potions.BigHpPotion;

public class Level3 extends GameMap{

    private static final int ROWS = 5;
    private static final int COLS = 5;

    public Level3(Player player) {
        super(ROWS, COLS, new Location(4, 4), player);

        fillRoom();

        placeRoom(new Room(true), 1,0);
        placeRoom(new Room(true), 1,1);
        placeRoom(new Room(true), 1,2);
        placeRoom(new Room(true), 1,3);

        placeRoom(new Room(true), 3,1);
        placeRoom(new Room(true), 3,2);
        placeRoom(new Room(true), 3,3);
        placeRoom(new Room(true), 3,4);

        getRoom(4, 4).setMonster(new Demon());
        setNumOfMonster(1);

        getRoom(4, 0).setItem(new BigHpPotion());
    }

    @Override
    public boolean achieveObjective() {
        return getNumOfMonster() == 0;
    }

    @Override
    public void printObjective() {
        System.out.println("Kill the last boss to pass this level");
    }

}
