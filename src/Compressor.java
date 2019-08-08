import java.util.Observable;


public class Compressor extends Observable implements Runnable {
	private Thread thread = new Thread(this);
	private static Compressor instance;

	public enum Events {
		COMPRESSOR_TICKED_EVENT
	}

	private Compressor() {
		thread.start();
	}

	public static Compressor instance() {
		if (instance == null) {
			instance = new Compressor();
		}
		return instance;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				setChanged();
				notifyObservers(Events.COMPRESSOR_TICKED_EVENT);
			}
		} catch (InterruptedException ie) {
		}
	}

}
