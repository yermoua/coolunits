//
//public class FridgeDoorCloseState extends RefrigeratorState implements FridgeDoorOpenListener  { //need to add listeners
//	
//	
//	private static FridgeDoorCloseState instance;
//	private FridgeDoorCloseState() {
//		
//	}
//
//	public static FridgeDoorCloseState instance() {
//		if(instance == null) {
//			instance = new FridgeDoorCloseState();
//		}
//		return instance;
//	}
//	
//	@Override
//	public void run() {
//		display.fridgeDoorClosed();
//		
//	}
//
//	@Override
//	public void leave() {
//		FridgeDoorOpenManager.instance().removeFridgeDoorOpenListener(instance);
//	
//	}
//
//	@Override
//	public void fridgeDoorOpened(FridgeDoorOpenEvent event) {
//		context.changeCurrentState(FridgeDoorOpenState.instance());
//	} 
//	
//
//}
