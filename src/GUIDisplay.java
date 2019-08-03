import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIDisplay {
	
	private static SimpleDisplay frame;
	
	private GUIDisplay() {
		frame = new SimpleDisplay();
		frame.pack();
//		initialize();
	}
	/**
	 * Inner class because the outer class extends RefridgeratorDisplay.
	 *
	 */
	private class SimpleDisplay extends JFrame {
		//setting temp
		private GUIButton roomTempButton = new RoomTempButton("Set room temp");
		private GUIButton fridgeTempButton = new FridgeTempButton("Set desired fridge temp");
		private GUIButton freezerTempButton = new FreezerTempButton("Set desired freezer temp");
		
		private JLabel roomTemp = new JLabel("Room temp");
		private JLabel desiredFridgeTemp = new JLabel("Desired fridge temp");
		private JLabel desiredFreezerTemp = new JLabel("Desired freezer temp");
		
		
		//open or close door
		private GUIButton fridgeDoorCloser = new FridgeDoorCloseButton("Close fridge door");
		private GUIButton fridgeDoorOpener = new FridgeDoorOpenButton("Open fridge door");
		private GUIButton freezerDoorCloser = new FreezerDoorCloseButton("Close freezer door");
		private GUIButton freezerDoorOpener = new FreezerDoorOpenButton("Open freezer door");
		
		//header for the following information on light, temp, compressor
		private JLabel statusString = new JLabel("Status");
		
		//the status of light, temp, compressor
		private JLabel fridgeLightString = new JLabel("Fridge Light ");
		private JLabel fridgeLightStatus = new JLabel("             ");
		private JLabel freezerLightString = new JLabel("Freezer Light ");
		private JLabel freezerLightStatus = new JLabel("             ");
		
		private JLabel fridgeTempString = new JLabel("Fridge Temp ");
		private JLabel fridgeTempStatus = new JLabel("             ");
		private JLabel freezerTempString = new JLabel("Freezer Temp ");
		private JLabel freezerTempStatus = new JLabel("            ");
		
		private JLabel fridgeCompressorString = new JLabel("Fridge ");
		private JLabel fridgeCompressorStatus = new JLabel("             ");
		private JLabel freezerCompressorString = new JLabel("Freezer ");
		private JLabel freezerComporessorStatus = new JLabel("             ");
		
		private JTextField roomTempText = new JTextField();
		private JTextField desiredFridgeTempText = new JTextField();
		private JTextField desiredFreezerTempText = new JTextField();
		
		
		private SimpleDisplay() {
			super("Refrigerator");
			JPanel topPanel = new JPanel();       
			topPanel.setLayout(new GridLayout(4, 3));
			topPanel.add(roomTemp);
			topPanel.add(roomTempText);
			topPanel.add(roomTempButton);
			topPanel.add(desiredFridgeTemp);
			topPanel.add(desiredFridgeTempText);
			topPanel.add(fridgeTempButton);
			topPanel.add(desiredFreezerTemp);
			topPanel.add(desiredFreezerTempText);
			topPanel.add(freezerTempButton);
			statusString.setFont(new Font("Georgia", Font.BOLD, 15));
			statusString.setForeground(Color.RED);
			topPanel.add(statusString);
			
			JPanel middlePanel = new JPanel();
			middlePanel.setLayout(new GridLayout(2,2));
			middlePanel.add(fridgeDoorOpener);
			middlePanel.add(fridgeDoorCloser);
			middlePanel.add(freezerDoorOpener);
			middlePanel.add(freezerDoorCloser);
			
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(new GridLayout(3,2));
			bottomPanel.add(fridgeLightString);
			bottomPanel.add(fridgeLightStatus);
			bottomPanel.add(freezerLightString);
			bottomPanel.add(freezerLightStatus);
			bottomPanel.add(fridgeTempString);
			bottomPanel.add(fridgeTempStatus);
			bottomPanel.add(freezerTempString);
			bottomPanel.add(freezerTempStatus);
			bottomPanel.add(fridgeCompressorString);
			bottomPanel.add(fridgeCompressorStatus);
			bottomPanel.add(freezerCompressorString);
			bottomPanel.add(freezerComporessorStatus);
			bottomPanel.setBackground(Color.WHITE);
	
			getContentPane().setLayout(new GridLayout(3,1));
			getContentPane().add(topPanel);
			getContentPane().add(middlePanel);
			getContentPane().add(bottomPanel);

			setVisible(true);
		}
		
		
	}
	

	public static void main(String[] args) {
		GUIDisplay display = new GUIDisplay();
	}

}