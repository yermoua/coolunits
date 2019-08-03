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
	
	public void intitialize() {
		context.initialize();
	}

	public abstract void displayTimeRemaining(int time);

	public abstract void turnLightOn();

	public abstract void turnLightOff();

	public abstract void doorClosed();

	public abstract void doorOpened();
	
	public abstract void setTemp();
	
	

}
