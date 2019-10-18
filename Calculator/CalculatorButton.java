import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class CalculatorButton extends Button{

	
	public static String old_num; // g�r en string till old_num Siffror 
	public static char old_calc; // g�r en char och ger den en definition till old_calc minr�karnens funktion.
	
	private char button; 
	private TextField textField;
	
	public CalculatorButton(char c,TextField tf) {
		
		// kallar construktorn N�r man anv�nder this.XXXXX
		this.setText(Character.toString(c));// G�r om char till string 
		this.button = c;
		textField = tf;
		
		setEvent();
	}
	
	public abstract void setEvent(); 
	
	public TextField getTextField() {
		return textField;
	}
	
	public char getButton() {
		return button;
	}
	

	
	
	
	
	
}
