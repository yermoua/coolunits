
public class CompressorState extends RefrigeratorState implements TempListener,
	TimerTickedListener,FridgeDoorOpenListener, FreezerDoorOpenListener{

	/**
	 * Grabs Yer implementation on the Timer
	 * uncomment the method being used in this class
	 */
	
	
	/**
	 * Private for the singleton pattern
	 */
	private CompressorState() {
		
	}
	
	/**
	 * When the Compressor leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		FreezerDoorOpenManager.instance().removeFreezerDoorOpenListener(this);
		TempManager.instance().removeTempListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
	}
	/**
	 * Process freezer door open request
	 */
	@Override
	public void freezerDoorOpen(FreezerDoorOpenEvent event) {
		context.changeCurrentState(FreezerDoorOpenState.instance());
	}
	/**
	 * Process fridge door open request
	 */
	@Override
	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
		context.changeCurrentState(FridgeDoorOpenState.instance());
	}
	
	/**
	 * Process clock tick Generates the timer runs out event
	 */
	@Override
	public void timerTicked(TimerTickedEvent event) {
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	@Override
	public void tempThreshold(TempEvent event) {
		display.fridgeTempDisplay(Temperature.instance().getTempValue());
		context.changeCurrentState(FridgeDoorClosedState.instance());
	}


	@Override
	public void run() {
		FridgeDoorOpenManager.instance().addFridgeDoorOpenListener(this);
		FreezerDoorOpenManager.instance().addFreezerDoorOpenListener(this);
		TempManager.instance().addTempListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		display.freezerDoorOpened();
		display.fridgeDoorClosed();
		Temperature.instance().setTempValue(30);


	}


	
	

}
