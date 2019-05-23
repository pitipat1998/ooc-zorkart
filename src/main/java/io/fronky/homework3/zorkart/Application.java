package io.fronky.homework3.zorkart;


import io.fronky.homework3.zorkart.command.Command;
import io.fronky.homework3.zorkart.command.CommandFactory;

import java.util.Scanner;

public class Application {
    //TODO: fix reequip
    public static void main(String[] args) {

        GameMediator gameMediator = GameMediator.getInstance();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bot: Hello, command me!!");
        while (true) {
            gameMediator.getCurrentLevel().printObjective();
            System.out.print("You: ");
            String commandLine = scanner.nextLine();
            commandLine = commandLine.toLowerCase().trim();
            if(commandLine.equals("")) continue;
            Command command = CommandFactory.getCommand(commandLine);
            if (null == command) {
                System.out.println("Unknown command");
            } else {
                command.apply();
                command.checkObjective();
            }
            System.out.println();
//            gameMediator.getCurrentLevel().printMap();
        }
    }
}
