import java.util.EventListener;

public interface FridgeDoorOpenListener extends EventListener {
	public void fridgeDoorOpened(FridgeDoorOpenEvent event);
}