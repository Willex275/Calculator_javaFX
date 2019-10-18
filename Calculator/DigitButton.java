import javafx.scene.control.TextField;

public class DigitButton extends CalculatorButton {

	public DigitButton(char c, TextField tf) {
		super(c, tf);
	}

	
	
	// metoden fungerar så att när du klickar på en siffra så syns den i textfield och när du klickar på den igen så läggs det till en ytterligare siffra  
	public void setEvent(){
		this.setOnMouseClicked(event->{
			getTextField().setText(getTextField().getText()+getButton());
		});

	}

}
