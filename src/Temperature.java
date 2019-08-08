import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author yer.moua, marquise.allen, dan.vail
 */
public class Temperature implements Observer{
	private static Temperature instance;
	private int tempValue;
	
	/**
	 * For singleton
	 */
	private Temperature() {
		instance = this;
		Compressor.instance().addObserver(instance);
	}
	
	/**
	 * For singleton pattern
	 * @return the instance
	 */
	public static Temperature instance() {
		if (instance == null) {
			instance = new Temperature();
		}
		return instance;
	}
	
	public void setTempValue(int value){
		this.tempValue = value;
	}
	
	public void addTempValue(int value){
		tempValue += value;
	}
	
	public int getTempValue(){
		return tempValue;
	}
	
	
	@Override
	public void update(Observable compressor, Object value) {
		if (--tempValue == 0) {
			TempManager.instance().processEvent(
					new TempEvent(instance));
		} else {
			TempManager.instance().processEvent(
					new TempEvent(instance));
		}
		
	}

}
