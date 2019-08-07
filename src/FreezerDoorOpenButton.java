
public class FreezerDoorOpenButton extends GUIButton {

	public FreezerDoorOpenButton(String string) {
		super(string);
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
	FreezerDoorOpenManager.instance().processEvent(new FreezerDoorOpenEvent(source));		
	}
}
