package io.fronky.homework3.zorkart.entity.items.usable;

import io.fronky.homework3.zorkart.GameMediator;
import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.entity.character.Player;
import io.fronky.homework3.zorkart.entity.items.Item;

public class Key extends UsableItem {

    private Location lockedRoom;

    public Key(int row, int col){
        this(new Location(row, col));
    }

    public Key(Location lockedRoom) {
        super(1);
        this.lockedRoom = lockedRoom;
    }

    @Override
    public void examine() {
        System.out.printf("Key: \n" +
                "   WEIGHT: %d\n",
                getWeight()
        );
    }

    @Override
    public boolean activate(GameMediator gameMediator) {
        Location location = gameMediator.getCurrentLevel().getCurrentLoc();
        Player player = gameMediator.getCurrentLevel().getPlayer();
        if(lockedRoom.isAdjacent(location)){
            gameMediator.getCurrentLevel().getRoom(lockedRoom).setLocked(false);
            System.out.println("The room is unlocked");
            player.removeItem(this);
            return true;
        }
        System.out.println("You must be adjacent to the locked room");
        return false;
    }
}
