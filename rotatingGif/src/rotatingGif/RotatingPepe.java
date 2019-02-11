package rotatingGif;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
/*
 * @TODO:
 * 
 * Button um zwischen den beiden gifs zu wechseln (pepehands und pepesad)
 * statusbar welches den value der beiden slider anzeigt 
 */
public class RotatingPepe  extends JPanel{
	
	private View view = new View();
	private JSlider movingSpeedSlider;
	private JSlider rotationSlider; 
	private JFrame frame = new JFrame();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Darstellung von Pepe und dem PopupMenu(mit beiden Slidern)
	public void initUI() {
		JPanel statusbar = new JPanel();
		frame.add(statusbar, BorderLayout.SOUTH);
		movingSpeedSlider = view.getMovingSlider();
		rotationSlider = view.getRotationSlider();
		frame.add(new RotatingPepe());
		JPopupMenu speedMenu = new JPopupMenu();
		speedMenu.add(rotationSlider);
		speedMenu.add(movingSpeedSlider);
		add(speedMenu);
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON3) {
					speedMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		frame.setSize(750,750);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public int getSliderValue() {
		return movingSpeedSlider.getValue();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = view.getIcon("Pepehands.gif");
		//zeichnet an der stelle das Bild neu 
		AffineTransform at = AffineTransform.getTranslateInstance(view.getX(),view.getY());
		Image image = icon.getImage();
		//Leerers bufferedImage mit der größe von pepe 
		BufferedImage emptyBuffer = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics f = emptyBuffer.getGraphics();
		f.drawImage(image, 0, 0, null);
		//Ist für die Rotation des Bildes zustädnig 
		at.rotate(Math.toRadians(view.getRotation()),icon.getIconWidth()/2, icon.getIconHeight()/2);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(emptyBuffer, at, null);
		repaint();
	}
	
	public static void main(String[] args) {
			RotatingPepe pepe = new RotatingPepe();
			pepe.initUI();
	}
	
}
