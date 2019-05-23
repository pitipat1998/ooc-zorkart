package io.fronky.homework3.zorkart.command;

import io.fronky.homework3.zorkart.command.movement.MoveDownCommand;
import io.fronky.homework3.zorkart.command.movement.MoveLeftCommand;
import io.fronky.homework3.zorkart.command.movement.MoveRightCommand;
import io.fronky.homework3.zorkart.command.movement.MoveUpCommand;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandFactory {


    private static final Map<String, Command> commands = new LinkedHashMap<String, Command>() {
        {
            put("move left", new MoveLeftCommand());
            put("move right", new MoveRightCommand());
            put("move up", new MoveUpCommand());
            put("move down", new MoveDownCommand());
            put("attack", new AttackCommand());
            put("take", new TakeCommand());
            put("drop", new DropCommand());
            put("equip", new EquipCommand());
            put("unequip", new UnequipCommand());
            put("use", new UseCommand());
            put("inventory", new InventoryCommand());
            put("map", new MapCommand());
            put("skip", new SkipCommand());
            put("info", new InfoCommand());
            put("help", new HelpCommand());
            put("quit", new ExitCommand());
        }
    };

    static Map<String, Command> getCommands() { return commands; }

    public static Command getCommand(String name) {
        return commands.get(name);
    }
}
