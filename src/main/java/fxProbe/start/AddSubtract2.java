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

/**FxAlerter application, modified from Listing 3-2 of "FxAlerter for Dummies".
 * Doing event handlers with named inner class.
 */
public class AddSubtract2 extends Application {


    public static void main(final String[] args) {
        launch(args);
    }

    private final Button addButton;
    private final Button subtractButton;
    private final Label label = new Label("0");
    private int count = 0;
    private final Scene scene;

    public AddSubtract2(){
        //Create a ClickHandler instance
        final ClickHandler ch = new ClickHandler();

        //Create the Add button
        this.addButton = new Button("Add");
        addButton.setOnAction(ch);

        //Create the Subtract button
        this.subtractButton = new Button("Subtract");
        subtractButton.setOnAction(ch);

        //Add the addButton to a layout pane
        final HBox pane = new HBox(10);
        pane.getChildren().addAll(label, addButton, subtractButton);

        //Add the layout pane to a scene
        scene = new Scene(pane, 300, 250);
    }

    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub 2");
        primaryStage.show();
    }

    private class ClickHandler  implements EventHandler<ActionEvent> {
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


}
