import java.util.EventListener;

public interface CompressorListener extends EventListener {
	/**
	 * Processes cook requests
	 * 
	 * @param event the object that represents the event
	 */
	public void compressorRunning(CompressorEvent event);

}
