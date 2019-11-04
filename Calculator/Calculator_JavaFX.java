import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator_JavaFX extends Application {

	//
	Stage stage;
	HBox displayBox;
	Scene scene;
	Button Button;
	BorderPane mainBox;
	GridPane bTTLayout;
	ArrayList<Button> buttons;
	static TextField inputField = new TextField("");

	// buttons

	// main metoden är där för att programet ska köras och fungera Därav att det
	// står Launch.
	public static void main(String[] args) {
		launch();
	}

	// metod som gör om Char button till "string".
	public void createButtons() {
		char[] bTTKeys = { '1', '2', '3', '-', '4', '5', '6', '/', '7', '8', '9', '+', '0', 'c', '=', '*' };

		for (char key : bTTKeys) {
			CalculatorButton btn;
			// Lägger till metoden IsDigit så att den får in textfield
			if (Character.isDigit(key)) {
				btn = new DigitButton(key, inputField);
			} else {
				btn = new SpecialButton(key, inputField);// Lägger in metoden special Button Där Key är dem olika räkneknappparna som
															// läggs in i input field
			}

			btn.setMinSize(85, 60);

			buttons.add(btn);

		}

	}
	   
	@Override
	public void start(Stage primaryStage) throws Exception { // Start) När man kör programet 
		HBox displayBox = new HBox();
		buttons = new ArrayList<Button>(); // lagrar buttons i en lista 
		createButtons();// skappar knapparna 
		mainBox = new BorderPane();
		bTTLayout = new GridPane();
		mainBox.setStyle("-fx-background-color: Black; -fx-padding: 20; -fx-font-size: 20;");
		mainBox.setCenter(bTTLayout);// lägger Knapparna centralt i behållaren/ stage / scene 
		mainBox.setTop(displayBox);
		displayBox.setMinSize(50, 50);// definera storleken (displayBox)   
		displayBox.setStyle("-fx-background-color: Gray; -fx-padding: 20; -fx-font-size:20;");
		displayButtons();
		inputField.setEditable(false); // så att man inte kan edita i textfield behållaren 

		displayBox.getChildren().add(inputField); // Funktionen till clear knappen som tar bort inputen i textfiled 
		inputField.setOnAction(event -> {
			displayBox.getChildren().clear(); // clear button knappen som 

		});

		scene = new Scene(mainBox, 370, 360);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);// gör så att Behållaren inte går att förstora utan kar en fast storlek  
		primaryStage.show();// Visar scene när programet körs 
	}
	
	
	

	// metod: Layout för buttons och hur kolumerna ligger och defineras 
	private void displayButtons() {
		int buttonIndex = 0;
		for (int row = 0; row < 6; row++) {// loopar igenom och ger buttons en position 
			for (int col = 0; col < 4; col++) {
				bTTLayout.add(buttons.get(buttonIndex), col, row);
				buttonIndex++;
				if (buttonIndex == buttons.size()) {
					return;
				}
			}
		}

	}

}
