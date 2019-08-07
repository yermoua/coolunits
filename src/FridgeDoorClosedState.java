
public class FridgeDoorClosedState extends RefrigeratorState implements FridgeDoorOpenListener  {
	
	
	private static FridgeDoorClosedState instance;
	private FridgeDoorClosedState() {

	}

	public static FridgeDoorClosedState instance() {
		if(instance == null) {
			instance = new FridgeDoorClosedState();
		}
		return instance;
	}

	@Override
	public void leave() {
		FridgeDoorOpenManager.instance().removeFridgeDoorOpenListener(instance);
	
	}

	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		context.changeCurrentState(FridgeDoorOpenState.instance());
	} 
	
	@Override
	public void run() {
		FridgeDoorOpenManager.instance().addFridgeDoorOpenListener(instance);
		display.doorClosed();
		display.turnLightOff();
		
	}
}
