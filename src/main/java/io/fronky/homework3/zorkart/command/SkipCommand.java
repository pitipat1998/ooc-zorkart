package io.fronky.homework3.zorkart.command;

public class SkipCommand implements Command {

    @Override
    public void apply() {
        gameMediator.nextMap();
    }

    @Override
    public void describe() {
        System.out.println("skip: skip the current level");
    }

}
