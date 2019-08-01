import java.util.Observer;

public class Freezer extends CoolingUnit {

	protected boolean isLightOn;
	protected boolean isCooling;
	protected int temp;

	public Freezer() {
		super();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);
	}

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}

	@Override
	public synchronized void deleteObservers() {
		super.deleteObservers();
	}

	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}

	@Override
	protected synchronized void clearChanged() {
		super.clearChanged();
	}

	@Override
	public synchronized boolean hasChanged() {
		return super.hasChanged();
	}

	@Override
	public synchronized int countObservers() {
		return super.countObservers();
	}

	public void openDoor() {
		return;
	}

	public void closeDoor() {
		return;
	}

	public int getTemp() {
		return 0;
	}

	public void startCooling() {
		return;
	}

	public boolean isCooling() {
		return this.isCooling;
	}

	public boolean isDoorOpen() {
		return this.isLightOn;
	}
}