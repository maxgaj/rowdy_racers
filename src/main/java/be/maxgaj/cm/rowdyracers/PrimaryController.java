package be.maxgaj.cm.rowdyracers;

import be.maxgaj.cm.rowdyracers.domain.Game;
import be.maxgaj.cm.rowdyracers.gui.Splashscreen;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {

    private Game game;

    @FXML
    private AnchorPane rightAnchorPane;
    @FXML
    private AnchorPane leftAnchorPane;

    public PrimaryController() {
    }

    @FXML
    private void initialize() {
        leftAnchorPane.getChildren().add(new Splashscreen(this));
    }

    public void startGame(int width, int height) {
        game = new Game(width, height);
        game.printGrid();
    }
}
