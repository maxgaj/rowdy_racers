package be.maxgaj.cm.rowdyracers.gui;

import be.maxgaj.cm.rowdyracers.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Splashscreen extends AnchorPane {

    @FXML
    private TextField widthTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private Button newGameButton;

    public Splashscreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/maxgaj/cm/rowdyracers/fxml/splashscreen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize(){}

    @FXML
    public void handleNewGameClick() throws IOException {
//        App.setRoot("primary");
    }
}
