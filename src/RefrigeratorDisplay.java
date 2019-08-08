import java.util.Observable;

//need implementation around context.

public abstract class RefrigeratorDisplay extends Observable {
	protected static RefrigeratorContext context;
	protected static RefrigeratorDisplay instance;
	
	protected RefrigeratorDisplay() {
		instance = this;
		context = RefrigeratorContext.instance();
	}
	
	public static RefrigeratorDisplay instance() {
		return instance;
	}
	
	public void initialize() {
		context.initialize();
	}

	public abstract void fridgeDoorClosed();

	public abstract void fridgeDoorOpened();
	
	public abstract void freezerDoorClosed();

	public abstract void freezerDoorOpened();
	
	public abstract void fridgeTempDisplay(int value);
	
	public abstract void freezerTempDisplay(int value);
	
	
}
