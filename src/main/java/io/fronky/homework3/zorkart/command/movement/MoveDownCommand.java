package io.fronky.homework3.zorkart.command.movement;

import io.fronky.homework3.zorkart.GameMediator;
import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.command.Command;
import io.fronky.homework3.zorkart.map.GameMap;

public class MoveDownCommand implements Command {

    @Override
    public void apply() {
        GameMap currentLevel = gameMediator.getCurrentLevel();
        Location currentLoc = currentLevel.getCurrentLoc();
        Location newLoc = new Location(currentLoc.getRow()+1, currentLoc.getCol());
        if(currentLevel.move(newLoc))
            System.out.println("move down one step");
    }

    @Override
    public void describe(){
        System.out.println("move down: move player one step down if valid");
    }

}
