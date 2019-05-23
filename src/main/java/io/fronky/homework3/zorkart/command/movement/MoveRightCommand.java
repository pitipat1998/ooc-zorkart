package io.fronky.homework3.zorkart.command.movement;

import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.command.Command;
import io.fronky.homework3.zorkart.map.GameMap;

public class MoveRightCommand implements Command {

    @Override
    public void apply() {
        GameMap currentLevel = gameMediator.getCurrentLevel();
        Location currentLoc = currentLevel.getCurrentLoc();
        Location newLoc = new Location(currentLoc.getRow(), currentLoc.getCol()+1);
        if(currentLevel.move(newLoc))
            System.out.println("move right one step");
    }

    @Override
    public void describe() {
        System.out.println("move right: move player one step right if valid");
    }
}
