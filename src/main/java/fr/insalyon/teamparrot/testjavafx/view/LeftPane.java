package fr.insalyon.teamparrot.testjavafx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LeftPane extends AnchorPane {

    public LeftPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/leftPane.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
