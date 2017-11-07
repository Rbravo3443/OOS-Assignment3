package planet.detail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
	private Thread thread1;
	public PlanetController(Planet planet){
		this.planet = planet;
		//thread1 = new Thread(new NumberParallel(this.planet));
	}
	public void initialize(URL location, ResourceBundle resources){
		//thread1.start();
		planetName.setText(planet.getPlanetName());
		planetDiameterKM.setText(planet.getDiameterkm());
		planetMeanSurfaceTempF.setText(planet.getTemperatureF());
		planetNumberOfMoons.setText(Integer.toString(planet.getNumberofmoon()));
		
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
    	PrintWriter writer = null;
    	planetDiameterM.setText(planet.KM_To_M(Double.parseDouble(planetDiameterKM.getText())));
    	planetMeanSurfaceTempF.setText(planet.Far_To_Cel(Double.parseDouble(planetMeanSurfaceTempC.getText())));
    	try{
    		writer = new PrintWriter("Planet.txt","UTF-8");
    		writer.println("planetName:" +planetName.getText());
    		writer.println("Planet Diameter KM: " +planetDiameterKM.getText());
    		writer.println("Planet Diameter M: "+planetDiameterM.getText());
    		writer.println("Planet Surface Temperature :" + planetMeanSurfaceTempC.getText());
    		writer.println("Planet Surface Temperature Farheniet: " +planetMeanSurfaceTempF.getText());
    		writer.println("Number of Moons: " +planetNumberOfMoons.getText());
    		}catch(Exception e){
    		System.out.println("File is not being written to");
    	}
    		
    	writer.close();
    	
    	}	
    
}