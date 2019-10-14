package be.maxgaj.cm.rowdyracers;

import be.maxgaj.cm.rowdyracers.domain.Game;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;
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
        createGridPane(width, height);
    }

    private void createGridPane(int width, int height) {
        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(800.0);
        gridPane.setPrefHeight(800.0);
        double dim = 800.0 / Math.max(width, height);
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                GuiSquare guiSquare = createGuiSquare(i, j, dim);
                gridPane.getChildren().add(guiSquare);
            }
        }
        rightAnchorPane.getChildren().add(gridPane);
    }

    private GuiSquare createGuiSquare(int rowIndex, int colIndex, double dim) {
        Square square = game.getSquareAtPosition(rowIndex, colIndex);
        GuiSquare guiSquare = new GuiSquare(square, dim);
        GridPane.setConstraints(guiSquare, colIndex, rowIndex);
        return guiSquare;
    }
}
