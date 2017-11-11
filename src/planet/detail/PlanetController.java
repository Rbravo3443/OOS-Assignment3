package planet.detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class PlanetController implements Initializable {
	private Planet planet;
	private Thread thread1;
	private String text = "Planet";
	private int number = 0;
	
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
    private String ImagePath;
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
    void selectImage(ActionEvent event) throws FileNotFoundException{
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Select Image");
    	fileChooser.getExtensionFilters().addAll(
    			new ExtensionFilter("Image Files", "*.png","*.jpg","*.gif"));
    	File selectedFile = fileChooser.showOpenDialog(new Stage().getOwner());
    	System.out.println(selectedFile.getName() +" "+ selectedFile.getAbsolutePath()); //print to console for debugging
    }

    @FXML
    void loadPlanet(ActionEvent event) {
    	FileChooser Selector = new FileChooser();
    	Selector.setTitle("Load Image");
    	FileInputStream LoadedFile;
    	InputStream StreamForFile;
    	Scanner Scan;
    	try{
    		LoadedFile = new FileInputStream(Selector.showOpenDialog(new Stage()).getAbsolutePath());
    		StreamForFile = ((InputStream) LoadedFile);
        	Scan = new Scanner( StreamForFile );
        	while(Scan.hasNext()){
        		 String test = Scan.nextLine();
        		 Pattern pattern = Pattern.compile("(^.*?):(.*$?)");
        		 Matcher match = pattern.matcher(test);
        		 if (match.find())
        		 {
        		     switch(match.group(1)){
        		    	 case "planetName":
        		    		planetName.setText(match.group(2));
        		    		break;
        		    	 case "Planet Diameter KM":
        		    		planetDiameterKM.setText(match.group(2));
        		    		break;
        		    	 case "Planet Diameter M":
        		    	    planetDiameterM.setText(match.group(2));
        		    	    break;
        		    	 case "Planet Surface Temperature ":
        		    		planetMeanSurfaceTempC.setText(match.group(2));
        		    		break;
        		    	 case "Planet Surface Temperature Fahrenheit":
        		    		planetMeanSurfaceTempF.setText(match.group(2));
        		    		break;
        		    	 case "Number of Moons":
        		    		planetNumberOfMoons.setText(match.group(2));
        		    		break;
        		    	 case "Image Link":
        		    		 System.out.println("hello");
        		    		//System.out.println(m.group(2));
        		    		//ImagePath = match.group(2);
        		    		//FileInputStream File = new FileInputStream(ImagePath);
        		    		//Image image = new Image(File);
        		    		//planetImage.setImage(image);
        		    		break;
        		         default:
        		    		 System.out.println("Something went very very very wrong!");
        		    		 break;
        		     }
               		     
        		 }
        		 
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
 
    	
    	
    }
    
    /** 
     * Refactor 
     * @param event
     */
    @FXML
    void savePlanet(ActionEvent event) {
    	String errorMessage = " ";
    	if(planetName.getText() == null || !(planet.isValidPlanet(planetName.getText()))){
    		errorMessage += "Invalid Planet Name !\n";
    	}
    	if(planetDiameterKM.getText() == null || !(planet.isValiddiameterNumber(planetDiameterKM.getText()))){
    		errorMessage +="Invalid Diameter!\n";
    	}
    	if(planetMeanSurfaceTempC.getText() == null || !(planet.isValidTemperature(planetMeanSurfaceTempC.getText()))){
    		errorMessage += " Invalid Mean Surface Temperature!\n";
    	}
    	if(planetNumberOfMoons.getText() == null || !(planet.isValidNumberofMoons(Integer.parseInt(planetNumberOfMoons.getText())))){
    		errorMessage += "Invalid Number of Moons! \n";
    	}
    	PrintWriter writer = null;
    	if(planet.isValidFields(planetName.getText(), planetDiameterKM.getText(), planetMeanSurfaceTempC.getText(), Integer.parseInt(planetNumberOfMoons.getText()))){
    	planetDiameterM.setText(planet.KM_To_M(Double.parseDouble(planetDiameterKM.getText())));
    	planetMeanSurfaceTempF.setText(planet.Far_To_Cel(Double.parseDouble(planetMeanSurfaceTempC.getText())));
    	try{
    		String num = Integer.toString(number);
    		text += num;
    		text += ".txt";
    		writer = new PrintWriter(text,"UTF-8");
    		writer.println("planetName:" +planetName.getText());
    		writer.println("Planet Diameter KM: " +planetDiameterKM.getText());
    		writer.println("Planet Diameter M: "+planetDiameterM.getText());
    		writer.println("Planet Surface Temperature :" + planetMeanSurfaceTempC.getText());
    		writer.println("Planet Surface Temperature Fahrenheit: " +planetMeanSurfaceTempF.getText());
    		writer.println("Number of Moons: " +planetNumberOfMoons.getText());
    		number++;
    		text = "Planet";
    		writer.println("Image Link: "+ImagePath);
    		}catch(Exception e){
    		System.out.println("File is not being written to");
    	}
    	}
    	else{
    			if(errorMessage.length() > 0){
    			Stage dialogStage = null;
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.initOwner(dialogStage);
    			alert.setTitle("Invalid Fields");
    			alert.setHeaderText("Please Correct Invalid fields");
    			alert.setContentText(errorMessage);
    			alert.showAndWait();
    			}
    	
    	}
    	writer.close();
    	
    	}	
    
}