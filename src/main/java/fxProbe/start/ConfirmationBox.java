package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**FxAlerter Stage, modified from Listing 4-4 of "FxAlerter for Dummies".
 * Serves to display a modal confirmation dialog with Yes/No answer buttons.
 */
public class ConfirmationBox {


    private final VBox pane = new VBox(20);
    private final Stage stage = new Stage();
    private boolean answer = false;

    public ConfirmationBox(final String title, final String message){
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);

        final Label label = new Label(message);
        pane.getChildren().add(label);

        //Add the layout pane to a scene
        final Scene scene = new Scene(pane, 300, 250);
        stage.setScene(scene);
    }

    /**Displays two buttons with the inscriptions for Yes and No in the ConfirmationBox. If any button is clicked, the ConfirmationBox is closed.
     * @return true if the Yes button was clicked. */
    public boolean ask(final String yesText, final String noText){
        final Button yesButton = new Button(yesText);
        yesButton.setOnAction(e -> {stage.close(); answer=true;});
        final Button noButton = new Button(noText);
        noButton.setOnAction(e -> {stage.close(); answer=false;});
        pane.getChildren().addAll(yesButton, noButton);
        stage.showAndWait();
        return answer;
    }


}
