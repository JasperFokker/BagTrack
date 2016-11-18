package bagtrack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.paint.Color.WHITE;
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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) screenSize.getHeight();
        int w = (int) screenSize.getWidth();
        int menuwidth = (int)(w*0.10);
        int menuheight = (int)(h*0.10);
        
        Image plaatje = new Image("Corendon Logo.jpg", w*0.50,h*0.50, false, false);
        
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
        welkombericht1.setFill(WHITE);

        scherm.add(welkombericht1, 2, 1);
        scherm.add(iv1, 2, 4);

        return scherm;
    }
}
