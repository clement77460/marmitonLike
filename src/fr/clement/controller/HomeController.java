package fr.clement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HomeController {
	@FXML 
    private GridPane root; 
    @FXML 
    private Button label;
    
    @FXML 
    private void onButtonActivated(final ActionEvent actionEvent) { 
        System.out.println("Salut le monde !"); 
    }
}
