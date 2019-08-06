
public class FridgeDoorClosedState extends RefrigeratorState implements FreezerDoorOpenListener  { //need to add listeners
	
	
	private static FridgeDoorClosedState instance;
	private FridgeDoorClosedState() {
		//to make a singleton
	}

	public static FridgeDoorClosedState instance() {
		if(instance == null) {
			instance = new FridgeDoorClosedState();
		}
		return instance;
	}
	
	@Override
	public void run() {
		display.doorClosed();
		display.turnLightOff();
		
	}

	@Override
	public void leave() {
		// need to add listeners
		FreezerDoorOpenManager.instance().removeFreezerDoorOpenListener(instance);
	
	}

	@Override
	public void freezerDoorOpened(FreezerDoorOpenEvent event) {
		// TODO Auto-generated method stub
		context.changeCurrentState(FridgeDoorOpenState.instance());
	} 
	

}
