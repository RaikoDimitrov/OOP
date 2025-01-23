package DesignPatterns.command;

import java.util.ArrayDeque;

public class ModifyPrice {

    private final ArrayDeque<Command> commandTracker;
    private Command command;

    public ModifyPrice() {
        this.commandTracker = new ArrayDeque<>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setAndExecuteCommand(Command command) {
        setCommand(command);
        this.commandTracker.push(command);
        System.out.println(command.executeAction());
    }

    public void undoExecutedCommand() {
        if (!commandTracker.isEmpty()) {
            this.commandTracker.pop();
            System.out.println(command.undoAction());
        }
        else System.out.println("No commands to undo.");
    }
}
