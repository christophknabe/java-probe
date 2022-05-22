package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 4-3 of "FxAlerter for Dummies".
 * Counts button clicks and shows each increment by a message dialog.
 */
public class MessageClickCounter extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private final Button button;
    private int clickCount;
    private final Scene scene;

    public MessageClickCounter(){
        //Create the button
        this.button = new Button("Click me please!");
        button.setOnAction(e -> buttonClick());

        //Add the button to a layout pane
        final BorderPane pane = new BorderPane();
        pane.setCenter(button);

        //Add the layout pane to a scene
        scene = new Scene(pane, 250, 150);
    }

    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getSimpleName());
        primaryStage.show();
    }

    private void buttonClick() {
        clickCount++;
        final String youHaveclicked = "You have clicked ";
        final String times = clickCount==1 ? "once!" : clickCount + " times.";
        new MessageBox("MessageBox", youHaveclicked + times);
    }


}
