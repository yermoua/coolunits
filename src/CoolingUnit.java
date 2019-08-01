import java.util.Observable;
import java.util.Observer;

public abstract class CoolingUnit extends Observable{
	public CoolingUnit() {
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

	public abstract void openDoor();

	public abstract void closeDoor();

	public abstract int getTemp();

	public abstract void startCooling();

	public abstract boolean isCooling();

	public abstract boolean isDoorOpen();
}
