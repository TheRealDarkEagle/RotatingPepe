package rotatingGif;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;

public class View {
	
	private Control movementControl = new Control();
	private static JSlider movementSlider;
	private static JSlider rotationSlider;
	private int x = Control.randomStartPoint();
	private int y = Control.randomStartPoint();
	private double rotation;
	
	public ImageIcon getIcon(String name) {
		return new ImageIcon(name);
	}
	
	public JSlider getMovingSlider() {
		movementSlider = new JSlider(0,10,0);
		movementSlider.setToolTipText("Bewegungsgeschwindigkeit");
		movementSlider.setMinorTickSpacing(1);
		movementSlider.setPaintTicks(true);
		movementSlider.setSnapToTicks(true);
		return movementSlider;
	}
	
	
	public JSlider getRotationSlider() {
		rotationSlider = new JSlider(0, 10, 0);
		rotationSlider.setToolTipText("Rotationsgeschwindigkeit");
		rotationSlider.setMinorTickSpacing(1);
		rotationSlider.setPaintTicks(true);
		rotationSlider.setSnapToTicks(true);
		return rotationSlider;
	}
	
	public JButton getPepeButtonSwitch() {
		JButton pepeButton = new JButton("which Pepe");
		pepeButton.addActionListener((e)->{
			
		});
		return pepeButton;
	}
	
	public double getRotation() {
		this.rotation = movementControl.rotationAngle(rotation, rotationSlider.getValue());
		return rotation;
	}
	
	public int getX() {
		this.x = movementControl.movementX(x,movementSlider.getValue());
		return x;
	}
	
	public int getY() {
		this.y = movementControl.movementY(y, movementSlider.getValue()); 
		return y;
	}
	
}

