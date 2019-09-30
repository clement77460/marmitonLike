package fr.clement.view;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FxView extends Application{
	
	private Stage primaryStage;
	private BorderPane rootPane;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage0) {
        this.primaryStage=primaryStage0;
        this.primaryStage.setTitle("Hello World!");
        this.primaryStage.show();
        
        this.setHomeView();
        this.setHeader();
        this.setMiddlePane();
	}
	
	@Override
	public void stop() {
	}
	
	public void setHomeView() {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FxView.class.getResource("HomeView.fxml"));
            
            this.rootPane = (BorderPane ) loader.load();
            Scene scene = new Scene(rootPane);
            this.primaryStage.setScene(scene);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void setMiddlePane() {
		try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FxView.class.getResource("MiddlePane.fxml"));
			this.rootPane.setCenter((AnchorPane ) loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setHeader() {
        try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FxView.class.getResource("ApplicationHeader.fxml"));
			this.rootPane.setTop((AnchorPane ) loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
