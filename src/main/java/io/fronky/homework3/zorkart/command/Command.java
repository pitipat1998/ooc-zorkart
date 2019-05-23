package io.fronky.homework3.zorkart.command;


import io.fronky.homework3.zorkart.GameMediator;

public interface Command {
    
    GameMediator gameMediator = GameMediator.getInstance();

    void apply();

    void describe();

    default void checkObjective(){
        if(gameMediator.getCurrentLevel().achieveObjective()){
            System.out.println("You have passed " + gameMediator.getCurrentLevel().getClass().getSimpleName());
            gameMediator.nextMap();
        }
    }

}
