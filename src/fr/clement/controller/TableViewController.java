package fr.clement.controller;

import java.net.URL;
import java.util.ResourceBundle;

import fr.clement.entities.RecetteBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class TableViewController  implements Initializable {
    @FXML 
    private TableView recettesContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("inittt");
		ObservableList<RecetteBean> data = FXCollections.<RecetteBean>observableArrayList(  
				new RecetteBean("Note", "Des"),
				new RecetteBean("Note 2", "Description of note 32"),
				new RecetteBean("Note 3", "Description of note 23"),
				new RecetteBean("Note 4", "Description of note 14"));
		FilteredList<RecetteBean> filteredData = new FilteredList<>(data, n->true);
		recettesContainer.setItems(filteredData);
		System.out.println(filteredData);
		recettesContainer.refresh();
		
	}
}
