
public class FridgeDoorClosedState extends RefrigeratorState implements FridgeDoorCloseListener,
	FridgeDoorOpenListener, CompressorListener, FreezerDoorCloseListener, FreezerDoorOpenListener,
	TempListener, TimerTickedListener{
	
	
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
		FridgeDoorCloseManager.instance().addFridgeDoorCloseListener(instance);
		FreezerDoorOpenManager.instance().addFreezerDoorOpenListener(instance);
		FreezerDoorCloseManager.instance().addFreezerDoorCloseListener(instance);
		TimerTickedManager.instance().addTimerTickedListener(instance);
		TempManager.instance().addTempListener(instance);
		CompressorManager.instance().addCompressortListener(instance);
		
		display.fridgeDoorClosed();
		
		
	}

	//added listener
	@Override
	public void frigeDoorClosed(FridgeDoorCloseEvent event) {
		context.changeCurrentState(FridgeDoorClosedState.instance());
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
