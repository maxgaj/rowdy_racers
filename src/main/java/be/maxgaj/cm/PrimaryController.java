package be.maxgaj.cm;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PrimaryController {

    @FXML
    private GridPane gridpane;

    public PrimaryController() {
    }

    @FXML
    private void initialize() {
        int rowCount = gridpane.getRowCount();
        int colCount = gridpane.getColumnCount();

        for (int i = 0; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: #e5e5e5; -fx-border-color: #000000; -fx-border-radius: 3");
                gridpane.add(pane, i, j);
                GridPane.setMargin(pane, new Insets(2,2,2,2));
            }
        }

        try {
            Image image = new Image(new FileInputStream("pikachu.png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(128);
            imageView.setFitWidth(128);
            imageView.setPreserveRatio(true);
            Pane pane = (Pane) gridpane.getChildren().get(1);
            pane.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
