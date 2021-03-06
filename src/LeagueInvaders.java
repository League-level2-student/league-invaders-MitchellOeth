import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class LeagueInvaders {
   
	final static int width = 500;
	final static int height = 800;
	GamePanel gamePanel;
	JFrame frame;
	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
		
	}
	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();
	}
	void setup() {
		frame.addKeyListener(gamePanel);
		frame.add(gamePanel);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.startGame();
	}
}