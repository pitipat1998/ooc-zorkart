package io.fronky.homework3.zorkart.map;

import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.entity.character.Monster;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.usable.potions.BigHpPotion;
import io.fronky.homework3.zorkart.entity.items.wearable.armors.AssaultCuirass;
import io.fronky.homework3.zorkart.entity.items.wearable.weapons.DivineRapier;

public class Level2 extends GameMap{

    private static final int ROWS = 5;
    private static final int COLS = 5;

    public Level2(Player player){
        super(ROWS,COLS, new Location(2, 2), player);
        fillRoom();

        getRoom(0,0).setMonster(new Monster());
        getRoom(4,0).setMonster(new Monster());
        getRoom(0,4).setMonster(new Monster());
        getRoom(4,4).setMonster(new Monster());
        setNumOfMonster(4);

        getRoom(1, 1).setItem(new BigHpPotion());
        getRoom(1, 3).setItem(new BigHpPotion());
        getRoom(3, 1).setItem(new BigHpPotion());
        getRoom(3, 3).setItem(new BigHpPotion());
        getRoom(2, 1).setItem(new AssaultCuirass());
        getRoom(2, 3).setItem(new DivineRapier());

    }

    @Override
    public boolean achieveObjective() {
        return getNumOfMonster() == 0;
    }

    @Override
    public void printObjective() {
        System.out.println("Kill all monsters to pass this level");
    }
}
