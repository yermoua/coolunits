


public class FreezerDoorCloseState extends RefrigeratorState implements FreezerDoorOpenListener  { //need to add listeners
	
	
	private static FreezerDoorCloseState instance;
	private FreezerDoorCloseState() {
		//to make a singleton
	}

	public static FreezerDoorCloseState instance() {
		if(instance == null) {
			instance = new FreezerDoorCloseState();
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
		context.changeCurrentState(FreezerDoorOpenState.instance());
	} 
	

}
