package com.example.javafxpracticing;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{

    public Button clickButton;
    public Label myLabel;
    @FXML
    private ListView<String> employeeListView;
    @FXML
    private  ListView<Faculty> employeeListView2;

    private ObservableList<String> items;
    private ObservableList<Faculty> items2;

    private Faculty _selectedFaculty;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        items = employeeListView.getItems();
        items2 = employeeListView2.getItems();

        Faculty faculty1 = new Faculty();
        Faculty faculty2 = new Faculty();
        faculty1.name="Altino";
        faculty2.name= "Brenda";

        items.add(faculty1.name);
        items.add(faculty2.name);

        GenerateFaculty(10);

        //Setting action for the clickButton..
        clickButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)

            {
                myLabel.setText("Button has been clicked.");
                myLabel.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));

            }
        });

        //Creating listener for the listview

        //listener for employeeListView
        employeeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
            {

                myLabel.setText("Selected Faculty: " + newValue);
                myLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

            }
        });

        //listener for employeeListView2
        employeeListView2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Faculty>() {
            @Override
            public void changed(ObservableValue<? extends Faculty> observableValue, Faculty oldValue, Faculty newValue)
            {

                _selectedFaculty = newValue;
                myLabel.setText("Selected Faculty: " + _selectedFaculty.name);
                myLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
    }
    private void GenerateFaculty(int number)
    {
        for(int i = 0; i < number; i++)
        {
            Faculty faculty = new Faculty();
            faculty.name = "Faculty Number: " + i;
            items2.add(faculty);
        }
    }
}