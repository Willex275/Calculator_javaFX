import javafx.scene.control.TextField;

public class SpecialButton extends CalculatorButton {

	public SpecialButton(char c, TextField tf) {
		super(c, tf); // superclass metod
	}

	@Override
	public void setEvent() {

		this.setOnMouseClicked(event -> {

			// definerar (=) knappens funktion
			if (getButton() == '=') {
				calc();
				old_num = null; // tar in en siffra och gör den till ett gammalt nummer och gammalt räknesätt
								// och ger det nya numret.
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

			default: // Default är (=) tecknet
				return;

			// case används istället för if & else och denfinerar dem olika räknesätten 
			// = och c är inte definerade i case utan deniferas beroende på om textfield rensas  
			// = funktion är att visa resultat i textfield om det finns en input i textfield. 
			// Räkneknapparna syns inte i textfield eftersom dem inte har definerats som sifferknapparna
			// samma med C och = knapparna som med räkneknapparna 
			case '+':

				double new_num = Double.parseDouble(old_num) + Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num));// parseDouble gör om string till double
				return;

			case '*':
				double new_num2 = Double.parseDouble(old_num) * Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num2));
				return;

			case '/':
				double new_num3 = Double.parseDouble(old_num) / Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num3));
				return;

			case '-': 
				double new_num4 = Double.parseDouble(old_num) - Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num4));
				return;

			}
		}
	}

}
