package be.maxgaj.cm.rowdyracers.gui;

import be.maxgaj.cm.rowdyracers.App;
import be.maxgaj.cm.rowdyracers.PrimaryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class Splashscreen extends AnchorPane {
    private PrimaryController primaryController;

    @FXML
    private TextField widthTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private Button newGameButton;
    @FXML
    private Text errorText;

    public Splashscreen(PrimaryController primaryController) {
        this.primaryController = primaryController;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/maxgaj/cm/rowdyracers/fxml/splashscreen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize(){
        newGameButton.setOnAction(actionEvent -> handleNewGameClick());
    }

    @FXML
    public void handleNewGameClick() {
        int width = parseDimensionInput(widthTextField.getText());
        int height = parseDimensionInput(heightTextField.getText());
        if (width<10 || height<10 || width>25 || height>25){
            errorText.setText("Dimensions must be integer between 10 and 25.");
        } else {
            errorText.setText("");
        primaryController.startGame(width, height);
        }
    }

    private int parseDimensionInput(String dimensionInput) {
        int dimension;
        try {
            dimension = Integer.parseInt(dimensionInput);
        } catch (NumberFormatException e){
            dimension = 0;
        }
        return dimension;
    }
}
