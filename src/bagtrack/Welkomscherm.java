/*
 * Dit is het scherm dat de gebruiker te zien krijgt als zij/hij inlogt.
 * Het scherm bestaat uit het Corendon logo en een welkomsbericht.
 * @author Team Twee
 */
package bagtrack;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Welkomscherm extends Application {

    static Thread welkom;

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static void flip() {
        Main.change(Zoekscherm.returnScherm2("SELECT * FROM bagage", 3, ""));
    }

    public static GridPane returnScherm() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int logoWidth = (int) (screenSize.getWidth() * 0.45);
        int logoHeight = (int) (screenSize.getHeight() * 0.45);

        //Corendon logo eigenschappen
        Image logo = new Image("Corendon Logo.png", logoWidth, logoHeight,
                false, false);
        ImageView logoView = new ImageView();
        logoView.setImage(logo);

        //welkomsbericht eigenschappen
        Text welkomBericht = new Text();
        welkomBericht.setText("Welkom " + Loginscherm.getUsername() + " bij het"
                + " Corendon bagagesysteem");
        welkomBericht.setFont(Font.font("Verdana", 40));
        welkomBericht.setFill(WHITE);

        GridPane scherm = new GridPane();
        scherm.setAlignment(Pos.CENTER);
        scherm.add(welkomBericht, 0, 0);
        scherm.add(logoView, 0, 1);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2500),
                ae -> flip()
        ));
        timeline.play();

        return scherm;
    }
}
