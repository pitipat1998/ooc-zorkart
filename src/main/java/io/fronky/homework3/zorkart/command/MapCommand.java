package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.map.GameMap;

public class MapCommand implements Command {

    @Override
    public void apply() {
        GameMap map = gameMediator.getCurrentLevel();
        map.printMap();
    }

    @Override
    public void describe() {
        System.out.println("map: show current level's map");
    }
}
