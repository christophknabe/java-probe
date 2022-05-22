package fxProbe.start;/**
 * Created by knabe on 2016-08-01.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 2-2 of "FxAlerter for Dummies".
 * Clicking a button increments a counter and displays its content as a UI label.
 * All code including constructor is executed on the FxAlerter Application Thread.
 * Only the main method is executed on the main thread, and the init method is executed on the FxAlerter-Launcher thread.
 * If the current system time in millis is dividable by 5, then a RuntimeException is thrown in the method {@link #buttonClick()}.
 * */
public class ClickCounterThrowing extends Application {

    public static void main(final String[] args) {
        _printThread("Launching FxAlerter"); //on main thread
        launch(args);
        _printThread("Finnished FxAlerter");
    }

    private final Button button;
    private final Label label = new Label("You have not clicked the button: " + Thread.currentThread().getName()); //on FxAlerter Application Thread
    private int clickCount;
    private final Scene scene;

    public ClickCounterThrowing(){
        _printThread("ClickCounter constructor"); //on FxAlerter Application Thread
        //Create the button
        this.button = new Button();
        button.setText("Click me please!");
        button.setOnAction(e -> buttonClick());

        //Add the button to a layout pane
        final BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(button);

        //Add the layout pane to a scene
        scene = new Scene(pane, 300, 250);
    }

    @Override
    public void init() throws Exception {
        _printThread("overridden init()"); //on FxAlerter-Launcher thread
    }

    @Override
    public void start(final Stage primaryStage) {
        _printThread("start(primaryStage)");
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getSimpleName());
        primaryStage.show();
    }

    private void buttonClick() {
        _printThread("buttonClick()"); //on FxAlerter Application Thread
        clickCount++;
        final long millis = System.currentTimeMillis();
        System.out.println("millis=" + millis);
        if(millis%5L == 0L){
            throw new RuntimeException("Failure when clicking the " + clickCount + "th time.");
        }
        final String youHaveclicked = "You have clicked ";
        label.setText(
                clickCount==1 ? youHaveclicked + "once!" : youHaveclicked + clickCount + " times."
        );
    }

    private static void _printThread(final String context){
        System.out.println(context + ": " + Thread.currentThread().getName());
    }


}
