import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class FridgeDoorCloseManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FridgeDoorCloseManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeDoorCloseManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeDoorCloseManager instance() {
		if (instance == null) {
			instance = new FridgeDoorCloseManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFridgeDoorCloseListener(FridgeDoorCloseListener listener) {
		listenerList.add(FridgeDoorCloseListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFridgeDoorCloseListener(FridgeDoorCloseListener listener) {
		listenerList.remove(FridgeDoorCloseListener.class, listener);
	}

	/**
	 * Handles the request to close the door.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(FridgeDoorCloseEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeDoorCloseListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeDoorCloseListener) listeners[index]).frigeDoorClosed(event);
		}
	}
}
