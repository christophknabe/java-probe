package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 3-4 of "FxAlerter for Dummies".
 * Doing event handlers with lambda expressions.
 */
public class AddSubtract4 extends Application {


    public static void main(final String[] args) {
        launch(args);
    }

    private final Button addButton;
    private final Button subtractButton;
    private final Label label = new Label("0");
    private int count = 0;
    private final Scene scene;

    public AddSubtract4(){

        //Create the Add button
        this.addButton = new Button("Add");
        addButton.setOnAction(e -> _computeLabel(++count));

        //Create the Subtract button
        this.subtractButton = new Button("Subtract");
        subtractButton.setOnAction(e -> _computeLabel(--count));

        //Add the addButton to a layout pane
        final HBox pane = new HBox(10);
        pane.getChildren().addAll(label, addButton, subtractButton);

        //Add the layout pane to a scene
        scene = new Scene(pane, 300, 250);
    }

    private void _computeLabel(final int count) {
        label.setText(Integer.toString(count));
    }

    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub 4");
        primaryStage.show();
    }


}
