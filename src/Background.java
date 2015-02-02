import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background extends Elements {


	public Background(int x, int y) {
		super(x, y);
	}

	public void update() {
		 		
		
	}
	 public void draw(Graphics2D g2d) {
			g2d.drawImage(getPoint(), 0, 0, null);
		
		}

	public Image getPoint() {
		
		ImageIcon ic = new ImageIcon("Ocean.jpg");
		return ic.getImage();
	}
	
}