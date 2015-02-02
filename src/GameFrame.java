import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {
	Timer mainTimer;

	// Missle missle;
	
	Background background;
	TeamSub teamSub;
	City city;
	
	int targetCount = 3;
	static ArrayList<Target> targets = new ArrayList<Target>();
	static ArrayList<Missle> missles = new ArrayList<Missle>();

	Random random = new Random();

	public GameFrame() {
		setFocusable(true);

		
		background = new Background(800, 800);
		teamSub = new TeamSub(20, 300);
		city = new City(0,0);
		
		addKeyListener(new KeyAdapt(teamSub));

		mainTimer = new Timer(10, this);
		mainTimer.start();
	
		for (int i = 0, z = 0; i < targetCount; i++, z += 80) {
			addTarget(new Target(random.nextInt(2) + 560 + z,
								 random.nextInt(50) + 1));
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		
		background.draw(g2d);
		teamSub.draw(g2d);
		city.draw(g2d);
		
		g2d.setColor(Color.green);
		g2d.setFont(new Font("Verdana", Font.BOLD, 16));
		g2d.drawString("Enemies killed:" + Missle.getHits().toString(), 10, 30);
		
		for (int i = 0; i < targets.size(); i++) {
			targets.get(i).draw(g2d);
		}
		for (int i = 0; i < missles.size(); i++) {
			Missle m = missles.get(i);
			m.draw(g2d);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		teamSub.update();
		city.update();
		
		for (int i = 0; i < targets.size(); i++) {
			targets.get(i).update();
		}
		for (int i = 0; i < missles.size(); i++) {
			Missle m = missles.get(i);
			m.update();
		}
		repaint();
	    checkEndGame();
	}

	public static void addTarget(Target t) {
		targets.add(t);
	}

	public static void removeTarget(Target t) {
		targets.remove(t);
	}

	public static ArrayList<Target> getTargetsList() {
		return targets;
	}

	public static void addMissle(Missle m) {
		missles.add(m);
	}

	public static void removeMissle(Missle m) {
		missles.remove(m);
	}

	public static ArrayList<Missle> getMisslesList() {
		return missles;
	}

	public void startGame() {
		targetCount = 3;
	}

	public void checkEndGame() {
		ArrayList<Target> targets = GameFrame.getTargetsList();
		if (targets.size() == 0) {
			
			JOptionPane.showMessageDialog(null,
					"You are a hero! You have saved the town!!");
			System.exit(0);
		}
	}
}
