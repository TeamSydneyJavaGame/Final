import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Target extends Elements {
	Random random = new Random();
	int velX = 0;
	int velY = random.nextInt(2) + 1;

	public Target(int x, int y) {
		super(x, y);
	}

	public void update() {

		x += velX;
		y += velY;

//		if (y > 600) {
//			y = 600;
//		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getTargetImage(), x, y, null);
	}

	public Image getTargetImage() {

		ImageIcon ic = new ImageIcon("subFinal.png");
		return ic.getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getTargetImage().getWidth(null),
				getTargetImage().getHeight(null));
	}
}
