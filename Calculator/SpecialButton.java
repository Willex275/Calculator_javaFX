import javafx.scene.control.TextField;

public class SpecialButton extends CalculatorButton {

	public SpecialButton(char c, TextField tf) {
		super(c, tf);
	}

	@Override
	public void setEvent() {

		this.setOnMouseClicked(event -> {

			// definerar (=) knappens funktion
			if (getButton() == '=') {
				calc();
				old_num = null;
				old_calc = getButton();
			} else {
				calc();
				old_num = getTextField().getText();
				old_calc = getButton();
				getTextField().clear(); // Tar bort siffervärdena och rensar Displayen.
			}

		});

	}

	private void calc() {
		if (old_num != null) {
			switch (old_calc) { // används i stället för (if) när man ger ett object case och räkne sättet 

			case '+':
			
				double new_num = Double.parseDouble(old_num) + Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num));// parseDouble gör om string till double
				break;

			default: // Default är = tecknet  
				break;

			case '*':
				double new_num2 = Double.parseDouble(old_num) * Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num2));
				break;

			case '/':
				double new_num3 = Double.parseDouble(old_num) / Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num3));
				break;

			case '-': // case är 
				double new_num4 = Double.parseDouble(old_num) - Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num4));
				break;

			}
		}
	}

}
