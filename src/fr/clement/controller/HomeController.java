package fr.clement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HomeController {
    @FXML 
    private Button quitter;
    @FXML 
    private Button recettes;
    @FXML 
    private Button ingredients;
    
    @FXML 
    private void onButtonActivated(final ActionEvent actionEvent) { 
        System.out.println("Salut le monde !"); 
    }
}
