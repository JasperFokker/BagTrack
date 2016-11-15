package bagtrack;

import java.awt.Color;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Thom
 */
public class Welkomscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {
        Image plaatje = new Image("Corendon Logo.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(plaatje);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(iv1);
        root.getChildren().add(box);

        GridPane scherm = new GridPane();
        scherm.setPrefSize(600, 450);
        scherm.setHgap(10);
        scherm.setVgap(10);
        scherm.setPadding(new Insets(50, 25, 25, 25));

        Text welkombericht1 = new Text();
        welkombericht1.setText("Welkom bij het Corendon bagagesysteem");
        welkombericht1.setFont(Font.font("Verdana", 35));

        scherm.add(welkombericht1, 10, 5);
        scherm.add(iv1, 10, 20);

        return scherm;
    }
}
