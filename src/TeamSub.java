import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class TeamSub extends Elements {
	int velX = 0;
	int velY = 0;

	public TeamSub(int x, int y) {
		super(x, y);
	}

	public void update() {
		x += velX;
		y += velY;
		
//		if (y > 600) {
//			y = 520;
//		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getTeamSubImage(), x, y, null);

	}

	public Image getTeamSubImage() {

		ImageIcon ic = new ImageIcon("TeamSub.png");
		return ic.getImage();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			velY = -5;
		} else if (key == KeyEvent.VK_Z) {
			velY = 5;
		} else if (key == KeyEvent.VK_SPACE) {
			GameFrame.addMissle(new Missle(x, y));
			// velX = 10;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_A) {
			velY = 0;
		} else if (key == KeyEvent.VK_Z) {
			velY = 0;
		}
	}
}
