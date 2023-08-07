package com.systeminfos.design.pattern.command;

public class Invoker {

    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        System.out.println(22);
    }

}
