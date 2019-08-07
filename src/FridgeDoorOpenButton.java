
public class FridgeDoorOpenButton extends GUIButton {
	
	public FridgeDoorOpenButton(String string) {
		super(string);
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeDoorOpenManager.instance().processEvent(new FridgeDoorOpenEvent(source));
	}

}
