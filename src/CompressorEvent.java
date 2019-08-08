import java.util.EventObject;

public class CompressorEvent extends EventObject {
	
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public CompressorEvent(Object source) {
		super(source);
	}
}
