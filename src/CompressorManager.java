import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class CompressorManager {
	private EventListenerList listenerList = new EventListenerList();
	private static CompressorManager instance;

	/**
	 * Private to make it a singleton
	 */
	private CompressorManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static CompressorManager instance() {
		if (instance == null) {
			instance = new CompressorManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addCompressortListener(CompressorListener listener) {
		listenerList.add(CompressorListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeCompressorListener(CompressorListener listener) {
		listenerList.remove(CompressorListener.class, listener);
	}

	/**
	 * Handles the request to cook.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(CompressorEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(CompressorListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((CompressorListener) listeners[index]).compressorRunning(event);
		}
	}
}
