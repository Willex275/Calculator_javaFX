import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator_JavaFX extends Application {

	//
	Stage stage;
	HBox displayBox;
	Scene scene;
	Button Button;
	HBox mainBox;
	GridPane bTTLayout;
	TextField inputField;
	ArrayList<Button> buttons;

	// buttons

	public static void main(String[] args) {
		launch();
	}

	public void InBTT() {
		char[] bTTKeys = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '/', '+', '-', '*' };
		
		for (char key : bTTKeys) {
			String keytext = key + "";
			Button tempButton = new Button(keytext);
			tempButton.setId(keytext);
			tempButton.setOnAction(event -> {
				inputField.textProperty().set(inputField.textProperty().get() + keytext);
				buttons.add(tempButton);

			});

		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox Displaybox = new HBox();
		buttons = new ArrayList<Button>();
		mainBox = new HBox();
		bTTLayout = new GridPane();
		Button ClearButton = new Button("c");
		Displaybox.getChildren().add(ClearButton);
		ClearButton.setOnAction(event -> {
			displayBox.getChildren().clear();
			

		});

		Scene scene = new Scene(mainBox, 300, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
