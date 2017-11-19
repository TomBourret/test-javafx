package fr.insalyon.teamparrot.testjavafx.controller;

import java.util.ArrayList;

class CommandHistory {

    private static CommandHistory instance = null;
    static CommandHistory getInstance() {
        if (null == instance) {
            instance = new CommandHistory();
        }
        return instance;
    }

    private final ArrayList<Command> history;
    private final ArrayList<Command> futureCommands;

    private CommandHistory() {
        this.history = new ArrayList<>();
        this.futureCommands = new ArrayList<>();
    }

    void execute(Command command) {
        history.add(command);
        futureCommands.clear();
        command.execute();
    }

    void undo() {
        if (history.isEmpty()) return;

        Command c = history.get(history.size() - 1);

        futureCommands.add(c);
        history.remove(history.size() - 1);

        c.rollback();
    }

    void redo() {
        if (futureCommands.isEmpty()) return;

        Command c = futureCommands.get(futureCommands.size() - 1);

        futureCommands.remove(futureCommands.size() - 1);
        history.add(c);

        c.execute();
    }
}
