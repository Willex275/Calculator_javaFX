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
	TextField inputField = new TextField("");

	// buttons

	public static void main(String[] args) {
		launch();
	}

	public void createButtons() {
		char[] bTTKeys = { '1', '2', '3', '-', '4', '5', '6', '/', '7', '8', '9', '+', '0', 'c', '=', '*' };

		for (char key : bTTKeys) {
			CalculatorButton btn;
			// Lägger till metoden IsDigit så att den får in textfield
			if (Character.isDigit(key)) {
				btn = new DigitButton(key, inputField);
			} else {
				btn = new SpecialButton(key, inputField);// lägger in Abstrakta klassen 
			}

			btn.setMinSize(80, 60);

			buttons.add(btn);

		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox displayBox = new HBox();
		buttons = new ArrayList<Button>();
		createButtons();
		mainBox = new BorderPane();
		bTTLayout = new GridPane();
		mainBox.setStyle("-fx-background-color: Black; -fx-padding: 20; -fx-font-size: 20;");
		mainBox.setCenter(bTTLayout);
		mainBox.setTop(displayBox);
		displayBox.setMinSize(50, 80);
		displayBox.setStyle("-fx-background-color: Gray; -fx-padding: 20; -fx-font-size: 20;");

		displayButtons();

		displayBox.getChildren().add(inputField);
		inputField.setOnAction(event -> {
			displayBox.getChildren().clear();

		});

		scene = new Scene(mainBox, 360, 360);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void displayButtons() {
		int buttonIndex = 0;
		for (int row = 0; row < 6; row++) {
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
