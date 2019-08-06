
public class FridgeDoorOpenState extends RefrigeratorState implements FridgeDoorOpenListener {

	private static FridgeDoorOpenState instance;
	
	private FridgeDoorOpenState() {
		
	}
	
	

	@Override
	public void leave() {
		FridgeDoorOpenManager.instance().removeFridgeDoorOpenListener(this);
		
	}



	public static RefrigeratorState instance() {
		if(instance == null) {
			instance = new FridgeDoorOpenState();
		}
		return instance;
	}
	@Override
	public void run() {
		FridgeDoorOpenManager.instance().addFridgeDoorOpenListener(this);
		display.turnLightOn();
		display.doorOpened();
	}



	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		context.changeCurrentState(FridgeDoorOpenState.instance());		
	}

}
