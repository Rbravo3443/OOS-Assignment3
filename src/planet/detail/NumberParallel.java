package planet.detail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NumberParallel implements Runnable {
	 	
		private Planet plan_it;
		
		@FXML
	    private ImageView planetImage;

	    @FXML
	    private Button selectImageButton;

	    @FXML
	    private TextField planetName;

	    @FXML
	    private TextField planetDiameterKM;

	    @FXML
	    private TextField planetDiameterM;

	    @FXML
	    private TextField planetMeanSurfaceTempC;

	    @FXML
	    private TextField planetMeanSurfaceTempF;

	    @FXML
	    private TextField planetNumberOfMoons;

	    @FXML
	    private Label fancyPlanetName;
	    
	public NumberParallel(Planet planet){
		this.plan_it = planet;
	}
	
	public void run(){
		System.out.println("Hello");
		planetDiameterM.setText(planetDiameterKM.getText());
	}
}
