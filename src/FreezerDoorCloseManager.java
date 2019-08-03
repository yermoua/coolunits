
import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class FreezerDoorCloseManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerDoorCloseManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerDoorCloseManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerDoorCloseManager instance() {
		if (instance == null) {
			instance = new FreezerDoorCloseManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFreezerDoorCloseListener(FreezerDoorCloseListener listener) {
		listenerList.add(FreezerDoorCloseListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFreezerDoorCloseListener(FreezerDoorCloseListener listener) {
		listenerList.remove(FreezerDoorCloseListener.class, listener);
	}

	/**
	 * Handles the request to close the door.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(FreezerDoorCloseEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerDoorCloseListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerDoorCloseListener) listeners[index]).freezerDoorClosed(event);
		}
	}
}
