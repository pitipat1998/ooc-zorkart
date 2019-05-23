package io.fronky.homework3.zorkart.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelpCommand implements Command {

    @Override
    public void apply() {
        List<Command> commands = new ArrayList<>(CommandFactory.getCommands().values());
        Iterator<Command> iterator = commands.iterator();
        while(iterator.hasNext()){
            Command command = iterator.next();
            command.describe();
        }
    }

    @Override
    public void describe() {
        System.out.println("help: show all commands");
    }
}

