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

	// main metoden �r d�r f�r att programet ska k�ras och fungera D�rav att det
	// st�r Launch.
	public static void main(String[] args) {
		launch();
	}

	// metod som g�r om Char button till "string".
	public void createButtons() {
		char[] bTTKeys = { '1', '2', '3', '-', '4', '5', '6', '/', '7', '8', '9', '+', '0', 'c', '=', '*' };

		for (char key : bTTKeys) {
			CalculatorButton btn;
			// L�gger till metoden IsDigit s� att den f�r in textfield
			if (Character.isDigit(key)) {
				btn = new DigitButton(key, inputField);
			} else {
				btn = new SpecialButton(key, inputField);// L�gger in metoden special Button D�r Key �r dem olika r�kneknappparna som
															// l�ggs in i input field
			}

			btn.setMinSize(85, 60);

			buttons.add(btn);

		}

	}
	   
	@Override
	public void start(Stage primaryStage) throws Exception { // Start) N�r man k�r programet 
		HBox displayBox = new HBox();
		buttons = new ArrayList<Button>(); // lagrar buttons i en lista 
		createButtons();// skappar knapparna 
		mainBox = new BorderPane();
		bTTLayout = new GridPane();
		mainBox.setStyle("-fx-background-color: Black; -fx-padding: 20; -fx-font-size: 20;");
		mainBox.setCenter(bTTLayout);// l�gger Knapparna centralt i beh�llaren/ stage / scene 
		mainBox.setTop(displayBox);
		displayBox.setMinSize(50, 50);// definera storleken (displayBox)   
		displayBox.setStyle("-fx-background-color: Gray; -fx-padding: 20; -fx-font-size:20;");
		displayButtons();
		inputField.setEditable(false); // s� att man inte kan edita i textfield beh�llaren 

		displayBox.getChildren().add(inputField); // Funktionen till clear knappen som tar bort inputen i textfiled 
		inputField.setOnAction(event -> {
			displayBox.getChildren().clear(); // clear button knappen som 

		});

		scene = new Scene(mainBox, 370, 360);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);// g�r s� att Beh�llaren inte g�r att f�rstora utan kar en fast storlek  
		primaryStage.show();// Visar scene n�r programet k�rs 
	}
	
	
	

	// metod: Layout f�r buttons och hur kolumerna ligger och defineras 
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
