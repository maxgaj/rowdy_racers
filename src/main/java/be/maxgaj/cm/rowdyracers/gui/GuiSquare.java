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
        setImageView();
        renderGuiSquare();
    }

    public void setImageView(){
        ImageView imageView = new ImageView();
        imageView.setFitHeight(this.getPrefHeight() - 6);
        imageView.setFitWidth(this.getPrefWidth() - 6);
        AnchorPane.setTopAnchor(imageView, 2.0);
        AnchorPane.setRightAnchor(imageView, 2.0);
        AnchorPane.setBottomAnchor(imageView, 2.0);
        AnchorPane.setLeftAnchor(imageView, 2.0);
        this.getChildren().add(imageView);
        this.imageView = imageView;
    }

    private void renderGuiSquare(){
        if (square.hasWall()){
            setWall();
        }
        else if (square.hasPlayer()){
            setPlayer(square.getPlayerNumber());
        }
    }

    private void setPlayer(int playerNumber) {
        FileInputStream input = null;
        try {
            if (playerNumber == 1){
                input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/pikachu.png");
            } else {
                input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/charmander.png");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        setImage(image);
    }

    private void setWall() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/brick-wall.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        setImage(image);
    }

    private void setImage(Image image){
        imageView.setImage(image);
    }
}
