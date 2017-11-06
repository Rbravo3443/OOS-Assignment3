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

public class PlanetController implements Initializable {
	private Planet planet;
	public PlanetController(Planet planet){
		this.planet = planet;
	}
	public void initialize(URL location, ResourceBundle resources){
		planetName.setText(planet.getPlanetName());
	}

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
    

    @FXML
    void selectImage(ActionEvent event) {
    	FileChooser Selector = new FileChooser();
    	Selector.setTitle("Select Image");   
    	FileInputStream File;
    	try{
    		File = new FileInputStream(Selector.showOpenDialog(new Stage()).getAbsolutePath() );
    		Image image = new Image(File);
    		planetImage.setImage(image);
    	}
    	catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void loadPlanet(ActionEvent event) {
    	
    }
    
    @FXML
    void savePlanet(ActionEvent event) {
    }
}