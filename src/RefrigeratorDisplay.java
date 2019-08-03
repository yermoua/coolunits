import java.util.Observable;

public abstract class RefrigeratorDisplay extends Observable {
	
	protected static RefrigeratorDisplay instance;

	public abstract void displayTimeRemaining(int time);

	public abstract void turnLightOn();

	public abstract void turnLightOff();

	public abstract void doorClosed();

	public abstract void doorOpened();
	
	public abstract void setTemp();

}
