import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.sound.midi.Receiver;
import javax.swing.ImageIcon;

public class Missle extends Elements {
	int velX = 6;
	static int counter = 0;
	public Missle(int x, int y) {
		super(x, y);
	}

	public void update() {
		x += velX;

		checkForCollisions();
	}

	public void draw(Graphics2D g2d) {

		g2d.drawImage(getMissleImage(), x + 70, y + 40, null);


	}

	public Image getMissleImage() {

		ImageIcon ic = new ImageIcon("Torped.png");
		return ic.getImage();
	}

	public void checkForCollisions() {
		
		ArrayList<Target> targets = GameFrame.getTargetsList();
		ArrayList<Missle> missles = GameFrame.getMisslesList();
		for (int i = 0; i < targets.size(); i++) {
			Target currentTarget = targets.get(i);
				if (getBounds().intersects(currentTarget.getBounds())) {
					// BOOM
					GameFrame.removeTarget(currentTarget);
					GameFrame.removeMissle(this);
					++counter;
			}
		}
	}
	
	public static Integer getHits() {
		return counter;
		}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getMissleImage().getWidth(null),
				getMissleImage().getHeight(null));
	}
}