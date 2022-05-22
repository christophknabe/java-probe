package fxProbe.start;/**
 * Created by knabe on 2016-08-07.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**FxAlerter application, modified from Listing 6-1 of "FxAlerter for Dummies".
 * Prompts user for input of a character's name and an actor's name. Then displays a message box with the designated role attribution.
 */
public class RolePlayer extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private final TextField characterTF = new TextField();
    private final TextField actorTF = new TextField();
    private final Scene scene;

    public RolePlayer(){
        final HBox characterPane = _createTextFieldHBox("Character's Name:", characterTF, "Enter the name of the character here.");
        final HBox actorPane = _createTextFieldHBox("Actor's Name:", actorTF, "Enter the name of the actor here.");

        //Configure the okButton
        final Button okButton = new Button("OK");
        okButton.setMinWidth(75);
        okButton.setOnAction(e -> okButtonClick());

        //Add the okButton to a layout pane
        final HBox buttonPane = _createHBox(okButton);

        //Add the Character, Actor, and Button panes to a VBox:
        final VBox pane = new VBox(10, characterPane, actorPane, buttonPane);

        //Add the layout pane to a scene
        this.scene = new Scene(pane);
    }

    private HBox _createTextFieldHBox(final String labelText, final TextField textField, final String prompt) {
        final Label label = new Label(labelText);
        label.setMinWidth(130);
        label.setAlignment(Pos.BOTTOM_RIGHT);
        //Configure the text field:
        textField.setMinWidth(200);
        textField.setMaxWidth(200);
        textField.setPromptText(prompt);
        return _createHBox(label, textField);

    }

    private HBox _createHBox(final Node... nodes) {
        //Put the Label and the TextField into an HBox and return it:
        final HBox result = new HBox(20, nodes);
        result.setPadding(new Insets(10));
        result.setAlignment(Pos.BOTTOM_RIGHT);
        return result;
    }


    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Role Player");
        primaryStage.show();
    }

    private void okButtonClick() {
        final StringBuilder err = new StringBuilder();
        _checkField(err, characterTF, "Character");
        _checkField(err, actorTF, "Actor");
        if(err.length() > 0){
            new MessageBox("Missing Data", err.toString());
            return;
        }
        new MessageBox("Cast", "The role of " + characterTF.getText() + " will be played by " + actorTF.getText() + ".");
    }

    private void _checkField(final StringBuilder out, final TextField textField, final String name){
        if(textField.getText().isEmpty()){
            out.append("\n");
            out.append(name);
            out.append(" is a required field.");
        }
    }


}
