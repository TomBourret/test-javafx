package fr.insalyon.teamparrot.testjavafx.controller;

import fr.insalyon.teamparrot.testjavafx.event.Event;
import fr.insalyon.teamparrot.testjavafx.event.EventBus;
import javafx.fxml.FXML;

public class MenuController {

    private CommandHistory commandHistory;

    @FXML
    public void initialize() {
        System.out.println("MenuController initialized");
        commandHistory = CommandHistory.getInstance();
    }

    @FXML
    private void exitButtonAction() {
        System.exit(0);
    }

    @FXML
    public void undo() {
        commandHistory.undo();
    }

    @FXML
    public void redo() {
        commandHistory.redo();
    }
}
