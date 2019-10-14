package be.maxgaj.cm.rowdyracers.gui;

import be.maxgaj.cm.rowdyracers.domain.squares.Square;
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
    private double dimension;

    @FXML
    private ImageView imageView;

    public GuiSquare(Square square, double dimension) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/maxgaj/cm/rowdyracers/fxml/guiSquare.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.square = square;
        this.dimension = dimension;
        this.setPrefWidth(dimension);
        this.setPrefHeight(dimension);
        setImageView(dimension);
        renderGuiSquare();
    }

    public void setImageView(double dimension){
        ImageView imageView = new ImageView();
        imageView.setFitHeight(dimension-6);
        imageView.setFitWidth(dimension-6);
        setAnchors(imageView);
        this.getChildren().add(imageView);
        this.imageView = imageView;
    }

    private void setAnchors(ImageView imageView) {
        AnchorPane.setTopAnchor(imageView, 2.0);
        AnchorPane.setRightAnchor(imageView, 2.0);
        AnchorPane.setBottomAnchor(imageView, 2.0);
        AnchorPane.setLeftAnchor(imageView, 2.0);
    }

    private void renderGuiSquare(){
        if (square.hasWall()){
            setWall();
        }
        else if (square.hasItem()){
            setItem();
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
            input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/trees.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        setImage(image);
    }

    private void setItem() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/be/maxgaj/cm/rowdyracers/img/voltorbe.png");
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
