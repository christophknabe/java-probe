package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 3-1 of "FxAlerter for Dummies".
 * Doing event handlers by implementing EventHandler.
 */
public class AddSubtract1 extends Application implements EventHandler<ActionEvent> {


    public static void main(final String[] args) {
        launch(args);
    }

    private final Button addButton;
    private final Button subtractButton;
    private final Label label = new Label("0");
    private int count = 0;
    private final Scene scene;

    public AddSubtract1(){
        //Create the Add button
        this.addButton = new Button("Add");
        addButton.setOnAction(this);

        //Create the Subtract button
        this.subtractButton = new Button("Subtract");
        subtractButton.setOnAction(this);

        //Add the addButton to a layout pane
        final HBox pane = new HBox(10, label, addButton, subtractButton);

        //Add the layout pane to a scene
        scene = new Scene(pane, 300, 250);
    }

    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub 1");
        primaryStage.show();
    }

    @Override
    public void handle(final ActionEvent ev){
        final Object evSource = ev.getSource();
        if(evSource==addButton){
            count++;
        }else if(evSource==subtractButton){
            count--;
        }else{
            throw new IllegalArgumentException(evSource.toString());
        }
        label.setText(Integer.toString(count));
    }


}
