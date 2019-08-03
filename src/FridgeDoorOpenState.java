
public class FridgeDoorOpenState extends RefrigeratorState implements FridgeDoorCloseListener {

	private static FridgeDoorOpenState instance;
	
	
	@Override
	public void run() {
		FridgeDoorCloseManager.instance().addFridgeDoorCloseListener(this);
		display.turnLightOn();
		display.doorOpened();
	}

	@Override
	public void leave() {
		FridgeDoorCloseManager.instance().removeFridgeDoorCloseListener(this);
		
	}

	@Override
	public void frigeDoorClosed(FridgeDoorCloseEvent event) {
		context.changeCurrentState(FridgeDoorCloseState.instance());
	}

	public static RefrigeratorState instance() {
		if(instance == null) {
			instance = new FridgeDoorOpenState();
		}
		return instance;
	}

}
