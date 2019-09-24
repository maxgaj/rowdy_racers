package be.maxgaj.cm.rowdyracers.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Square extends AnchorPane {

    @FXML
    private ImageView imageView;

    public Square() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/be/maxgaj/cm/rowdyracers/fxml/square.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
