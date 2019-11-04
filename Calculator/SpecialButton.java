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
				old_num = null; // tar in en siffra och g�r den till ett gammalt nummer och gammalt r�knes�tt
								// och ger det nya numret.
				old_calc = getButton();
			} else {
				calc();
				old_num = getTextField().getText();
				old_calc = getButton();
				getTextField().clear(); // Tar bort sifferv�rdena och rensar Displayen.
			}

		});

	}

	private void calc() {
		if (old_num != null) {
			switch (old_calc) { // anv�nds i st�llet f�r (if) n�r man ger ett object case och r�kne s�ttet

			default: // Default �r (=) tecknet
				return;

			// case anv�nds ist�llet f�r if & else och denfinerar dem olika r�knes�tten 
			// = och c �r inte definerade i case utan deniferas beroende p� om textfield rensas  
			// = funktion �r att visa resultat i textfield om det finns en input i textfield. 
			// R�kneknapparna syns inte i textfield eftersom dem inte har definerats som sifferknapparna
			// samma med C och = knapparna som med r�kneknapparna 
			case '+':

				double new_num = Double.parseDouble(old_num) + Double.parseDouble(getTextField().getText());
				getTextField().setText(Double.toString(new_num));// parseDouble g�r om string till double
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
