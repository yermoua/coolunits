import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GUIButton extends JButton {
	
	public GUIButton(String string) {
		super(string);
	}
	
	public abstract void inform(RefrigeratorDisplay display);
	

}
