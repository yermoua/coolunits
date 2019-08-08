import java.util.EventListener;

/**
 * Any class that wants to listen temperature should implement this
 * interface.
 * @author yer.moua, marquise.allen, dan.vail
 */
public interface TempListener extends EventListener{

	/**
	 * This method should implement the functionality to handle the situation 
	 * of the temperature hitting a certain temp
	 * @param event description
	 */
	public void tempThreshold(TempEvent event);
}
