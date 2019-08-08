


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
		FreezerDoorOpenManager.instance().addFreezerDoorOpenListener(instance);
		display.freezerDoorClosed();
		
	}

	@Override
	public void leave() {
		// need to add listeners
		FreezerDoorOpenManager.instance().removeFreezerDoorOpenListener(instance);
	
	}

	@Override
	public void freezerDoorOpen(FreezerDoorOpenEvent event) {
		context.changeCurrentState(FreezerDoorOpenState.instance());
	} 
	

}
