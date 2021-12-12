package com.example.javafxpracticing;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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

        clickButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)

            {
                myLabel.setText("Button has been clicked");

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