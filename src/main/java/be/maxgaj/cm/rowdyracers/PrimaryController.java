package be.maxgaj.cm.rowdyracers;

import be.maxgaj.cm.rowdyracers.domain.Game;
import be.maxgaj.cm.rowdyracers.domain.Square;
import be.maxgaj.cm.rowdyracers.gui.Splashscreen;
import be.maxgaj.cm.rowdyracers.gui.GuiSquare;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
        GridPane gridPane = new GridPane();
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                Square square = game.getSquareAtPosition(i, j);
                GuiSquare guiSquare = new GuiSquare(square);
                GridPane.setConstraints(guiSquare, i, j);
                gridPane.getChildren().add(guiSquare);
            }
        }
        rightAnchorPane.getChildren().add(gridPane);
    }
}
