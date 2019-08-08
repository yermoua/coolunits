import java.util.EventObject;


public class TempEvent extends EventObject{
	
	/**
	 * Event is created with the identity of the source
	 * @param source is the object that created the event
	 */
	public TempEvent(Object source){
		super(source);
	}

}
