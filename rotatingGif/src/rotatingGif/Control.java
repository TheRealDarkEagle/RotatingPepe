package rotatingGif;

import java.util.Random;

public class Control {
	
	private boolean up, right;
	
	public static int randomStartPoint() {
		Random rand = new Random();
		int startpoint = rand.nextInt(550);
		return startpoint;
	}
	
	
	public int movementX(int oldX, int value) {
		if(oldX >=480) {
			right = false;
		}
		if(oldX <= 0 ) {
			right = true;
		}
		if(right) {
			return oldX+value;
		}else{
			return oldX-value;
		}
	}
	
	
	
	public int movementY(int oldY, int value) {
		if(oldY>=480) {
			up = true;
		}else if(oldY <=0) {
			up = false;
		}
		if(up) {
			return oldY-value;
		}else {
			return oldY+value;
		}
	}
	
	
	public double rotationAngle(double oldAngle, double inkrement) {
		if(oldAngle>=360) {
			oldAngle -= 360;
		}
		return oldAngle+inkrement;
	}
}