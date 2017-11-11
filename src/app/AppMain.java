package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import planet.detail.Planet;
import planet.detail.PlanetController;

public class AppMain extends Application {
	public AppMain() {
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//FXML startup method
	@Override
	public void start(Stage primaryStage) throws Exception {
		Planet planet = new Planet("JU","72.5","56.7",0);
		
		PlanetController controller = new PlanetController(planet);

		FXMLLoader loader = new FXMLLoader(controller.getClass().getResource("PlanetView.fxml"));
		loader.setController(controller);
		
		Pane pane = (Pane) loader.load();

		Scene scene = new Scene(pane, 590, 400);
		primaryStage.setTitle("CS 4773 Assignment 3");
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.setPlanetLabel().textProperty().bind(controller.setPlanetname().textProperty());
	}
}