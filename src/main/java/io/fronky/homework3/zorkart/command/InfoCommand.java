package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.command.Command;
import io.fronky.homework3.zorkart.map.GameMap;
import io.fronky.homework3.zorkart.map.Room;

public class InfoCommand implements Command {

    @Override
    public void apply() {
        GameMap map = gameMediator.getCurrentLevel();
        Room room = map.getRoom(map.getCurrentLoc());
        map.getPlayer().examine();
        room.showStatus();
    }

    @Override
    public void describe() {

    }

}
