package be.maxgaj.cm.rowdyracers;

import be.maxgaj.cm.rowdyracers.gui.Splashscreen;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {
    @FXML
    private AnchorPane rightAnchorPane;
    @FXML
    private AnchorPane leftAnchorPane;

    public PrimaryController() {
    }

    @FXML
    private void initialize() {
        leftAnchorPane.getChildren().add(new Splashscreen());
    }
}
