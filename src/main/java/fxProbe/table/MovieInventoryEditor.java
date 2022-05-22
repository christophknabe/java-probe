package fxProbe.table;/**
 * Created by knabe on 15.09.16.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.Arrays;
import static java.util.Arrays.asList;

/**
 * An editor for movies in a database.
 * Following listing 9-3 of JavaFX for Dummies.
 */
public class MovieInventoryEditor extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    private final String dialogTitle = "Movie Inventory";
    private final TableView<Movie> table = new TableView<>();
    private final TextField titleTF = new TextField(), yearTF = new TextField(), priceTF = new TextField();
    private final Scene scene;

    //Dynamic Initialization of this object:
    {
        final Label headingLabel = new Label(dialogTitle);
        headingLabel.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setItems(loadData());

        //Create and configure titleTitle column:
        final String titleTitle = "Title";
        final TableColumn<Movie,String> titleColumn = new TableColumn<>(titleTitle);
        titleColumn.setMinWidth(300);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>(titleTitle));
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        titleColumn.setOnEditCommit(this::titleColumn_onEditCommit);

        //Create and configure year column:
        final String yearTitle = "Year";
        final TableColumn<Movie,Integer> yearColumn = new TableColumn<>(yearTitle);
        yearColumn.setMinWidth(100);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>(yearTitle));
        yearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        yearColumn.setOnEditCommit(this::yearColumn_onEditCommit);

        //Create and configure price column:
        final String priceTitle = "Price";
        final TableColumn<Movie,Double> priceColumn = new TableColumn<>(priceTitle);
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>(priceTitle));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        priceColumn.setOnEditCommit(this::priceColumn_onEditCommit);

        table.getColumns().addAll(titleColumn, yearColumn, priceColumn);

        //Configure the movie text fields:
        titleTF.setPromptText(titleTitle);
        titleTF.setMinWidth(100);
        yearTF.setMaxWidth(100);
        yearTF.setPromptText(yearTitle);
        priceTF.setMaxWidth(100);
        priceTF.setPromptText(priceTitle);

        //Create and configure the action buttons:
        final Button addButton = new Button("Add");
        addButton.setMinWidth(60);
        addButton.setOnAction(e -> addButton_clicked());
        final Button deleteButton = new Button("Delete");
        deleteButton.setMinWidth(60);
        deleteButton.setOnAction(e -> deleteButton_clicked());

        //Make the lay out:
        final HBox addPane = new HBox();
        addPane.setSpacing(8);
        addPane.getChildren().addAll(titleTF, yearTF, priceTF, addButton, deleteButton);
        final VBox mainPane = new VBox();
        mainPane.setSpacing(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.getChildren().addAll(headingLabel, table, addPane);
        scene = new Scene(mainPane);
    }

    private void titleColumn_onEditCommit(final TableColumn.CellEditEvent<Movie, String> e) {
        final Movie m = e.getRowValue();
        m.setTitle(e.getNewValue());
    }

    private void yearColumn_onEditCommit(final TableColumn.CellEditEvent<Movie, Integer> e) {
        final Movie m = e.getRowValue();
        m.setYear(e.getNewValue());
    }

    private void priceColumn_onEditCommit(final TableColumn.CellEditEvent<Movie, Double> e) {
        final Movie m = e.getRowValue();
        m.setPrice(e.getNewValue());
    }

    private void addButton_clicked() {
        final Movie m = new Movie();
        m.setTitle(titleTF.getText());
        m.setYear(Integer.parseInt(yearTF.getText()));
        m.setPrice(Double.parseDouble(priceTF.getText()));
        table.getItems().add(m);
        asList(titleTF, yearTF, priceTF).forEach(TextField::clear);
    }

    private void deleteButton_clicked() {
        final ObservableList<Movie> items = table.getItems();
        for(final Movie m: table.getSelectionModel().getSelectedItems()){
            items.remove(m);
        }
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.setTitle(dialogTitle);
        primaryStage.show();
    }

    private ObservableList<Movie> loadData() {
        final ObservableList<Movie> result = FXCollections.observableArrayList(
                new Movie("It's a Wonderful Life", 1946, 14.95)
                ,new Movie("Young Frankenstein", 1974, 16.95)
                ,new Movie("Star Wars Episode 4", 1976, 17.95)
                ,new Movie("The Princess Bride", 1987, 16.95)
                ,new Movie("Glory", 1989, 14.95)
                ,new Movie("The Game", 1997, 14.95)
                ,new Movie("Shakespeare in Love", 1998, 19.95)
                ,new Movie("The Invention of Lying", 2009, 18.95)
                ,new Movie("The King's Speech", 2010, 19.95)
        );
        return result;
    }
}
