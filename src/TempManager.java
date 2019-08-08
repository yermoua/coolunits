import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states
 * that acts when a certain temp is hit
 * @author yer.moua, marquise.allen, dan.vail
 */
public class TempManager {
	private EventListenerList listenerList = new EventListenerList();
	private static TempManager instance;
	
	/**
	 * Private for making the class a singleton
	 */
	private TempManager(){
	}
	
	/**
	 * Returns the instance of the class
	 * @return the only instance of the class
	 */
	public static TempManager instance() {
		if (instance == null) {
			instance = new TempManager();
		}
		return instance;
	}
	
	/**
	 * Adds a listener
	 * @param listener
	 */
	public void addTempListener(TempListener listener){
		listenerList.add(TempListener.class, listener);
	}
	
	/**
	 * Removes a listener
	 * @param listener
	 */
	public void removeTempListener(TempListener listener) {
		listenerList.remove(TempListener.class, listener);
	}
	
	/**
	 * Process the event by calling the TempMax method of the listener
	 * @param event
	 */
	public void processEvent(TempEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(TempListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((TempListener) listeners[index]).tempThreshold(event);
		}
	}
	

}
