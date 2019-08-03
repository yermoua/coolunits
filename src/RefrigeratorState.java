
public abstract class RefrigeratorState {
	
	protected static RefrigeratorContext context;
	protected static RefrigeratorDisplay display;
	
	protected RefrigeratorState() {
		context = RefrigeratorContext.instance();
		display = context.getDisplay();
	}
	
	public abstract void run();
	
	public abstract void leave();
	

}
