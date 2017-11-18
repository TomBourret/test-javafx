package fr.insalyon.teamparrot.testjavafx.controller;

import fr.insalyon.teamparrot.testjavafx.event.EventBus;
import fr.insalyon.teamparrot.testjavafx.event.ValueCreatedEvent;
import fr.insalyon.teamparrot.testjavafx.model.Value;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CenterPaneController implements InvalidationListener {

    private Value value;
    private CommandHistory commandHistory;

    @FXML
    private Label resultLabel;

    @FXML
    public void initialize() {
        System.out.println("CenterPaneController initialized");
        commandHistory = CommandHistory.getInstance();

        EventBus.getInstance().subscribe(ValueCreatedEvent.class, event -> {
            ValueCreatedEvent valueCreatedEvent = (ValueCreatedEvent) event;
            value = valueCreatedEvent.getValue();
            value.addListener(this);
            resultLabel.setText("Value: " + value);
        });
    }

    @FXML
    private void add1() {
        if (null != value) {
            commandHistory.execute(new CommandAdd(value, 1));
        }
    }

    @FXML
    private void add2() {
        if (null != value) {
            commandHistory.execute(new CommandAdd(value, 2));
        }
    }

    @FXML
    private void undo() {
        commandHistory.undo();
    }

    @FXML
    private void redo() {
        commandHistory.redo();
    }

    @Override
    public void invalidated(Observable observable) {
        if (observable.equals(value)) {
            System.out.println("CenterPaneController received notification: value = " + value);
            resultLabel.setText("Value: " + value);
        }
    }
}
