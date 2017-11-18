package fr.insalyon.teamparrot.testjavafx.controller;

import fr.insalyon.teamparrot.testjavafx.event.EventBus;
import fr.insalyon.teamparrot.testjavafx.event.ValueCreatedEvent;
import fr.insalyon.teamparrot.testjavafx.model.Value;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;

public class LeftPaneController implements InvalidationListener {

    private Value value;
    private CommandHistory commandHistory;

    public LeftPaneController() {
        System.out.println("LeftPaneController constructed");
    }

    @FXML
    public void initialize() {
        System.out.println("LeftPaneController initialized");
        commandHistory = CommandHistory.getInstance();
    }

    @FXML
    private void add5() {
        commandHistory.execute(new CommandAdd(value, 5));
    }

    @FXML
    public void load() {
        value = new Value();
        value.addListener(this);

        EventBus.post(new ValueCreatedEvent(value));
    }

    @Override
    public void invalidated(Observable observable) {
        if (observable.equals(value)) {
            System.out.println("LeftPaneController received notification: value = " + value);
        }
    }
}
