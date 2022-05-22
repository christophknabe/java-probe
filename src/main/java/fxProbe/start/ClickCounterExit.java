package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 4-5 of "FxAlerter for Dummies".
 * Counts button clicks and shows each increment by a message dialog.
 * Closing by X button in title bar or by Close button causes a confirmation dialog to be shown before closing the application.
 */
public class ClickCounterExit extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private int clickCount;
    private final Scene scene;
    private final VBox pane;

    public ClickCounterExit(){
        //Create the button
        final Button button = new Button("Count");
        button.setOnAction(e -> countButtonClick());

        //Add the button to a layout pane
        pane = new VBox(10);
        pane.getChildren().add(button);
        pane.setAlignment(Pos.CENTER);

        //Add the layout pane to a scene
        scene = new Scene(pane, 250, 150);
    }

    @Override
    public void start(final Stage stage) {
        final Button button = new Button("Close");
        button.setOnAction(e -> closeButtonClick(stage));
        pane.getChildren().add(button);

        //Finalize and show the stage
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());
        stage.setOnCloseRequest(e -> {
            e.consume();
            closeButtonClick(stage);
        });
        stage.show();
    }

    private void countButtonClick() {
        clickCount++;
        final String youHaveclicked = "You have clicked ";
        final String times = clickCount==1 ? "once!" : clickCount + " times.";
        new MessageBox("MessageBox", youHaveclicked + times);
    }

    private void closeButtonClick(final Stage stage) {
        final boolean confirmed = new ConfirmationBox("Confirmation", "Are you sure you want to quit?").ask("Yes", "No");
        if(confirmed){
            stage.close();
        }
    }


}
