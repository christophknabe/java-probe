package fxProbe.start;/**
 * Created by knabe on 2016-08-09.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**JavaFX application, modified from Listing 6-2 of "JavaFX for Dummies".
 * Collects order details for a pizza from the user and displays an order confirmation message box.
 */
public class PizzaOrder extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private final String nameTitle = "Name";
    private final String phoneTitle = "Phone Number";
    private final String addressTitle = "Address";
    private final TextField nameTF = new TextField();
    private final TextField phoneTF = new TextField();
    private final TextField addressTF = new TextField();
    private final RadioButton smallRB = new RadioButton("Small");
    private final RadioButton mediumRB = new RadioButton("Medium");
    private final RadioButton largeRB = new RadioButton("Large");
    private final RadioButton thinRB = new RadioButton("Thin");
    private final RadioButton thickRB = new RadioButton("Thick");
    private final CheckBox pepperoniCB = new CheckBox("Pepperoni");
    private final CheckBox sausageCB = new CheckBox("Sausage");
    private final CheckBox linguicaCB = new CheckBox("Linguica");
    private final CheckBox olivesCB = new CheckBox("Olives");
    private final CheckBox mushroomsCB = new CheckBox("Mushrooms");
    private final CheckBox tomatoesCB = new CheckBox("Tomatoes");
    private final CheckBox anchoviesCB = new CheckBox("Anchovies");
    private final Button cancelButton;
    private final Scene scene;

    public PizzaOrder(){
        //Create the heading:
        final Text headingText = new Text("Order Your Pizza Now!");
        headingText.setFont(new Font(20));
        final HBox headingPane = _createHBox(headingText);

        //Create the customer data pane:
        final HBox namePane = _createTextFieldHBox(nameTitle, nameTF, "Enter the customer's name here.");
        final HBox phonePane = _createTextFieldHBox(phoneTitle, phoneTF, "Enter the customer's phone number here.");
        final HBox addressPane = _createTextFieldHBox(addressTitle, addressTF, "Enter the customer's address here.");
        final VBox customerPane = new VBox(10, namePane, phonePane, addressPane);

        //Create the size pane:
        final Label sizeLabel = new Label("Size");
        mediumRB.setSelected(true);
        final ToggleGroup sizeGroup = new ToggleGroup();
        smallRB.setToggleGroup(sizeGroup);
        mediumRB.setToggleGroup(sizeGroup);
        largeRB.setToggleGroup(sizeGroup);
        final VBox sizePane = new VBox(10, sizeLabel, smallRB, mediumRB, largeRB);

        //Create the crust pane:
        final Label crustLabel = new Label("Crust");
        thinRB.setSelected(true);
        final ToggleGroup crustGroup = new ToggleGroup();
        thinRB.setToggleGroup(crustGroup);
        thickRB.setToggleGroup(crustGroup);
        final VBox crustPane = new VBox(10, crustLabel, thinRB, thickRB);

        //Create the toppings pane:
        final Label toppingsLabel = new Label("Toppings");
        final FlowPane toppingsPane = new FlowPane(Orientation.VERTICAL, pepperoniCB, sausageCB, linguicaCB, olivesCB, mushroomsCB, tomatoesCB, anchoviesCB);
        toppingsPane.setPadding(new Insets(10, 0, 10, 0));
        toppingsPane.setHgap(20);
        toppingsPane.setVgap(10);
        toppingsPane.setPrefWrapLength(100);
        final VBox toppingsVBox = new VBox(toppingsLabel, toppingsPane);

        //Collect size, crust, and toppings pane to the order pane:
        final HBox orderPane = new HBox(50, sizePane, crustPane, toppingsVBox);

        //Create the center pane:
        final VBox centerPane = new VBox(20, customerPane, orderPane);
        centerPane.setPadding(new Insets(0, 10, 0, 10));


        //Configure the buttons:
        final Region spacer = new Region();
        final Button okButton = new Button("OK");
        okButton.setPrefWidth(80);
        okButton.setOnAction(e -> _okButtonClick());
        cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(80);

        //Add the okButton to a layout pane
        final HBox buttonPane = _createHBox(spacer, okButton, cancelButton);
        buttonPane.setHgrow(spacer, Priority.ALWAYS);


        final BorderPane mainPane = new BorderPane();
        mainPane.setTop(headingPane);
        mainPane.setCenter(centerPane);
        mainPane.setBottom(buttonPane);
        //Add the layout pane to a scene
        this.scene = new Scene(mainPane);
    }

    private HBox _createTextFieldHBox(final String labelText, final TextField textField, final String prompt) {
        final Label label = new Label(labelText + ":");
        label.setPrefWidth(110);
        //Configure the text field:
        textField.setPrefColumnCount(20);
        textField.setMaxWidth(Double.MAX_VALUE);
        textField.setPromptText(prompt);
        return _createHBox(label, textField);
    }

    private HBox _createHBox(final Node... nodes) {
        //Put the nodes into an HBox and return it:
        final HBox result = new HBox(10, nodes);
        result.setPadding(new Insets(10));
        return result;
    }


    @Override
    public void start(final Stage primaryStage) {
        //Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        cancelButton.setOnAction(e -> primaryStage.close());
        primaryStage.show();
    }

    private void _okButtonClick() {
        final StringBuilder out = new StringBuilder();
        _checkField(out, nameTF, nameTitle);
        _checkField(out, phoneTF, phoneTitle);
        _checkField(out, addressTF, addressTitle);
        if(out.length() > 0){
            new MessageBox("Missing Data", out.toString());
            return;
        }
        out.setLength(0);
        out.append("Customer:\n\n");
        _addFieldContents(out, nameTF, phoneTF, addressTF);
        out.append("\nYou have ordered a ");
        _addRadioButtonContents(out, smallRB, mediumRB, largeRB, thinRB, thickRB);
        _addCheckboxContents(out, pepperoniCB, sausageCB, linguicaCB, olivesCB, mushroomsCB, tomatoesCB, anchoviesCB);

        new MessageBox("Order Details", out.toString());
    }

    private void _addFieldContents(final StringBuilder out, final TextField... textFields) {
        for(final TextField textField: textFields) {
            out.append('\t');
            out.append(textField.getText());
            out.append('\n');
        }
    }

    private void _addRadioButtonContents(final StringBuilder out, final RadioButton... radioButtons) {
        for(final RadioButton radioButton: radioButtons){
            if(radioButton.isSelected()){
                final String text = radioButton.getText();
                out.append(text.toLowerCase());
                out.append(' ');
            }
        }
        out.append("crust pizza with\n");
    }

    private void _addCheckboxContents(final StringBuilder out, final CheckBox... checkBoxes) {
        final StringBuilder toppings = new StringBuilder();
        for(final CheckBox checkBox: checkBoxes) {
            if(checkBox.isSelected()){
                if(toppings.length() > 0){
                    toppings.append(", ");
                }
                toppings.append(checkBox.getText());
            }
        }
        if(toppings.length() <= 0) {
            out.append("no toppings.");
            return;
        }
        out.append("the following toppings:\n");
        out.append(toppings);
    }


    private void _checkField(final StringBuilder out, final TextField textField, final String name){
        if(textField.getText().isEmpty()){
            out.append("\n");
            out.append(name);
            out.append(" is a required field.");
        }
    }


}
