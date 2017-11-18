package fr.insalyon.teamparrot.testjavafx.controller;

import fr.insalyon.teamparrot.testjavafx.model.Value;

public class CommandAdd implements Command {

    final private Value value;
    final private Integer howMuch;

    CommandAdd(Value value, Integer howMuch) {
        this.value = value;
        this.howMuch = howMuch;
    }

    public void execute() {
        value.add(howMuch);
    }

    public void rollback() {
        value.withdraw(howMuch);
    }
}
