
public class FridgeDoorCloseState extends RefrigeratorState implements FridgeDoorOpenListener  { //need to add listeners
	
	
	private static FridgeDoorCloseState instance;
	private FridgeDoorCloseState() {
		//to make a singleton
	}

	public static FridgeDoorCloseState instance() {
		if(instance == null) {
			instance = new FridgeDoorCloseState();
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
		FridgeDoorOpenManager.instance().removeFridgeDoorOpenListener(instance);
	
	}

	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		// TODO Auto-generated method stub
		context.changeCurrentState(FridgeDoorOpenState.instance());
	} 
	

}
