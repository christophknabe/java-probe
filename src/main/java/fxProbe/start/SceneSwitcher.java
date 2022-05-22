package fxProbe.start;
/** Created by knabe on 04.08.16. */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 4-1 of "FxAlerter for Dummies".
 * Shows switching between the ClickMe scene, and the AddSubtract4 scene.
 */
public class SceneSwitcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**FxAlerter scene, modified from Listing 2-2 of "FxAlerter for Dummies", but with a Switch button. */
    private class ClickCounter {

        private final Label label = new Label("You have not clicked the Click me button.");
        private final Button clickMeButton = new Button("Click me please!");
        private final Button switchButton = new Button("Switch");
        private final VBox pane = new VBox(); // Must be a VBox because of 3 components.
        private int clickCount;
        private final Scene scene;

        public ClickCounter() {
            //Provide the buttons with actions:
            clickMeButton.setOnAction(e -> buttonClick());
            switchButton.setOnAction(e -> stage.setScene(addSubtract.scene));

            //Add the label and the buttons to a layout pane
            pane.getChildren().addAll(label, clickMeButton, switchButton);

            //Add the layout pane to a scene
            scene = new Scene(pane, 300, 250);
        }

        private void buttonClick() {
            clickCount++;
            final String youHaveclicked = "You have clicked ";
            label.setText(
                    clickCount == 1 ? youHaveclicked + "once!" : youHaveclicked + clickCount + " times."
            );
        }
    }

    private final ClickCounter clickCounter = new ClickCounter();

    /**FxAlerter scene, modified from Listing 3-4 of "FxAlerter for Dummies", but with a Switch button.
     * Doing event handlers with lambda expressions.
     */
    private class AddSubtract {

        private final Label label = new Label("0");
        private final Button addButton = new Button("Add");
        private final Button subtractButton = new Button("Subtract");
        private final Button switchButton = new Button("Switch");
        private int count = 0;
        private final Scene scene;

        public AddSubtract(){

            //Provide the buttons with actions:
            addButton.setOnAction(e -> _computeLabel(++count));
            subtractButton.setOnAction(e -> _computeLabel(--count));
            switchButton.setOnAction(e -> stage.setScene(clickCounter.scene));

            //Add the addButton to a layout pane
            final HBox pane = new HBox(10);
            pane.getChildren().addAll(label, addButton, subtractButton, switchButton);

            //Add the layout pane to a scene
            scene = new Scene(pane, 300, 250);
        }

        private void _computeLabel(final int count) {
            label.setText(Integer.toString(count));
        }

    }

    private final AddSubtract addSubtract = new AddSubtract();

    private Stage stage;

    @Override
    public void start(final Stage primaryStage) {
        stage = primaryStage;

        //Begin the stage with the Click Counter scene and show the stage:
        stage.setTitle("Scene Switcher");
        stage.setScene(clickCounter.scene);
        stage.show();
    }

}
