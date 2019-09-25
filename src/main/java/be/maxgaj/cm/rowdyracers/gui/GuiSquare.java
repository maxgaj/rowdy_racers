package be.maxgaj.cm.rowdyracers.gui;

import be.maxgaj.cm.rowdyracers.domain.Square;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GuiSquare extends AnchorPane {
    private Square square;

    @FXML
    private ImageView imageView;

    public GuiSquare(Square square) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/maxgaj/cm/rowdyracers/fxml/guiSquare.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.square = square;
        if (square.hasWall()){
            setWall();
        }
    }

    private void setWall() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/brick-wall.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(this.getPrefHeight() - 6);
        imageView.setFitWidth(this.getPrefWidth() - 6);
        AnchorPane.setTopAnchor(imageView, 2.0);
        AnchorPane.setRightAnchor(imageView, 2.0);
        AnchorPane.setBottomAnchor(imageView, 2.0);
        AnchorPane.setLeftAnchor(imageView, 2.0);
        this.getChildren().add(imageView);
    }
}
