import javafx.scene.control.TextField;

public class DigitButton extends CalculatorButton {

	public DigitButton(char c, TextField tf) {
		super(c, tf);
	}

	
	
	// metoden fungerar s� att n�r du klickar p� en siffra s� syns den i textfield och n�r du klickar p� den igen s� l�ggs det till en ytterligare siffra  
	public void setEvent(){
		this.setOnMouseClicked(event->{
			getTextField().setText(getTextField().getText()+getButton());
		});

	}

}