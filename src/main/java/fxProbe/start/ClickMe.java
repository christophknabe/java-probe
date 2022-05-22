package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**First FxAlerter application, modified from Listing 1-1 of "FxAlerter for Dummies"*/
public class ClickMe extends Application {

    public static void main(final String[] args) {
        System.out.println("Launching FxAlerter");
        launch(args);
        System.out.println("Finnished FxAlerter");
    }

    private final Button button;
    private final Scene scene;

    public ClickMe(){
        //Create the button
        this.button = new Button();
        buttonClick();
        button.setOnAction(e -> buttonClick());

        //Add the button to a layout pane
        final BorderPane pane = new BorderPane();
        pane.setCenter(button);

        //Add the layout pane to a scene
        scene = new Scene(pane, 300, 250);
    }

    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Click Me App");
        primaryStage.show();
    }

    private void buttonClick() {
        final String clickMePlease = "Click me please!";
        button.setText(
                button.getText().equals(clickMePlease) ? "You clicked me!" : clickMePlease
        );
    }


}
