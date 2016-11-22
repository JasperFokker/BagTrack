/* 
 * Dit is het scherm dat de gebruiker te zien krijgt als hij/zij inlogt.
 * Het scherm bestaat uit het logo van corendon en een welkomsbericht.
 * @author Team Twee
 */

package bagtrack;

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

public class Welkomscherm extends Application {

    @Override
    public void start(Stage primaryStage) {
        returnScherm();
    }

    public static GridPane returnScherm() {
        
        GridPane scherm = new GridPane();
        HBox box = new HBox();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int logoWidth = (int) (screenSize.getWidth() * 0.45);
        int logoHeight = (int) (screenSize.getHeight() * 0.45);
        
        Text welkomBericht = new Text();
        Image logo = new Image("Corendon Logo.png", logoWidth, logoHeight, false, false);
        ImageView logoView = new ImageView();
        logoView.setImage(logo);
        
        welkomBericht.setText("Welkom bij het Corendon bagagesysteem");
        welkomBericht.setFont(Font.font("Verdana", 40));
        welkomBericht.setFill(WHITE);
        
        scherm.setAlignment(Pos.CENTER);
        //scherm.setGridLinesVisible(true);        
        
        scherm.add(welkomBericht, 2, 1);
        scherm.add(logoView, 2, 4);
        
        return scherm;
    }
}
