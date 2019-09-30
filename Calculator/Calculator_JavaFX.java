import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public abstract class Calculator_JavaFX extends Application {

	Stage stage;
	HBox hBox;
	Scene scene;
	
	Button Noll;
			
	public static void main(String[] args) {
		launch();
	}

	

	public static final String[][] template = {

		{ "c", "1", "2", "*" },
		{ "3", "4", "5", "/" }, 
		{ "6", "7", "8", "+" }, 
		{ "9", "0", "=", "-" },

	};
	
	

	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage; 
		
		
	}
	
	private void CreatButtom() {
		
		Noll = new Button("String");
		
		
	}

}
