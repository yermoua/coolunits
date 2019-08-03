
public class FreezerDoorOpenState extends RefrigeratorState implements FreezerDoorCloseListener {

	private static FreezerDoorOpenState instance;
	
	
	@Override
	public void run() {
		FreezerDoorCloseManager.instance().addFreezerDoorCloseListener(this);
		display.turnLightOn();
		display.doorOpened();
	}

	@Override
	public void leave() {
		FreezerDoorCloseManager.instance().removeFreezerDoorCloseListener(this);
		
	}

	@Override
	public void freezerDoorClosed(FreezerDoorCloseEvent event) {
		context.changeCurrentState(FreezerDoorCloseState.instance());
	}

	public static RefrigeratorState instance() {
		if(instance == null) {
			instance = new FreezerDoorOpenState();
		}
		return instance;
	}

}