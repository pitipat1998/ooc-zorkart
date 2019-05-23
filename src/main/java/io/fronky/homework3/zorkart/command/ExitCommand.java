package io.fronky.homework3.zorkart.command;

public class ExitCommand implements Command{

    @Override
    public void apply() {
        System.exit(0);
    }

    @Override
    public void describe() {
        System.out.println("quit: quit the game");
    }
}
