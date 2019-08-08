
public class FridgeDoorOpenState extends RefrigeratorState implements FridgeDoorCloseListener,
	FridgeDoorOpenListener, CompressorListener, FreezerDoorCloseListener, FreezerDoorOpenListener,
	TempListener, TimerTickedListener{

	private static FridgeDoorOpenState instance;
	
	private FridgeDoorOpenState() {
	}
	

	@Override
	public void leave() {
		FridgeDoorCloseManager.instance().removeFridgeDoorCloseListener(this);
		
	}

	public static RefrigeratorState instance() {
		if(instance == null) {
			instance = new FridgeDoorOpenState();
		}
		return instance;
	}
	
	
	@Override
	public void frigeDoorClosed(FridgeDoorCloseEvent event) {
		context.changeCurrentState(FridgeDoorClosedState.instance());		
	}
	
	@Override
	public void run() {
		FridgeDoorCloseManager.instance().addFridgeDoorCloseListener(this);
		FridgeDoorOpenManager.instance().addFridgeDoorOpenListener(this);
		FreezerDoorOpenManager.instance().addFreezerDoorOpenListener(this);
		FreezerDoorCloseManager.instance().addFreezerDoorCloseListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		TempManager.instance().addTempListener(this);
		CompressorManager.instance().addCompressortListener(this);
		display.fridgeDoorOpened();
		
	}

	//added new listener
	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		context.changeCurrentState(FridgeDoorOpenState.instance());
		
	}


	@Override
	public void timerTicked(TimerTickedEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void tempThreshold(TempEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void freezerDoorOpen(FreezerDoorOpenEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void freezerDoorClosed(FreezerDoorCloseEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void compressorRunning(CompressorEvent event) {
		// TODO Auto-generated method stub
		
	}

}
