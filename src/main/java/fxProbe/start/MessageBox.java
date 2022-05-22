package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**FxAlerter Stage, modified from Listing 4-2 of "JavaFX for Dummies".
 * Serves to display a modal message dialog.
 */
public class MessageBox {


    public MessageBox(final String title, final String message){
        final Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        final Label label = new Label(message);

        final Button button = new Button("OK");
        button.setOnAction(e -> stage.close());

        //Add the button to a layout pane
        final VBox pane = new VBox(20);
        pane.getChildren().addAll(label, button);

        //Add the layout pane to a scene
        final Scene scene = new Scene(pane, 300, 250);
        stage.setScene(scene);
        stage.showAndWait();
    }


}
