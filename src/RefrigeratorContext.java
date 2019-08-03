
public class RefrigeratorContext {

	private static RefrigeratorDisplay refrigeratorDisplay;
	private RefrigeratorState currentState;
	private static RefrigeratorContext instance;

	// Produce a singleton
	private RefrigeratorContext() {
		instance = this;
		refrigeratorDisplay = RefrigeratorDisplay.instance();
		currentState = FridgeDoorCloseState.instance();
	}

	/**
	 * Return the instance
	 * @return the object
	 */
	public static RefrigeratorContext instance() {
		if (instance == null) {
			instance = new RefrigeratorContext();
		}
		return instance;
	}
	
	public void initialize() {
		instance.changeCurrentState(FridgeDoorCloseState.instance());
	}
	
	public void changeCurrentState(RefrigeratorState nextState) {
		currentState.leave();
		currentState = nextState;
		nextState.run();
	}
	
	public RefrigeratorDisplay getDisplay() {
		return refrigeratorDisplay;
	}
}
