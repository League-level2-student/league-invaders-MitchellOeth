import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Rocketship you = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(you);
	Font titleFont = new Font("Arial", Font.BOLD, 48);
	Font normalFont = new Font("Arial", Font.PLAIN, 25);
	Timer framerate;
	public static boolean allowUp;
	public static boolean allowDown;
	public static boolean allowRight;
	public static boolean allowLeft;
	GamePanel() {
		framerate = new Timer(1000 / 60, this);
		addKeyListener(this);
	}

	void startGame() {
		framerate.start();
	}

	public void paintComponent(Graphics graphic) {
		if (currentState == MENU_STATE) {
			drawMenuState(graphic);
		} else if (currentState == GAME_STATE) {
			drawGameState(graphic);
		} else if (currentState == END_STATE) {
			drawEndState(graphic);
		}
	}

	public void actionPerformed(ActionEvent event) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	public void keyTyped(KeyEvent event) {

	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState==END_STATE){
				you = new Rocketship(250,700,50,50);
				objectManager = new ObjectManager(you);
			}
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			objectManager.addProjectile(new Projectile(you.x + 20, you.y, 10, 10));
		}
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			you.up = true;
		}
		
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			you.down = true;
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.right = true;
		}
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			you.left = true;
		}
	}

	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_UP) {
			you.up = false;
		}
		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			you.down = false;
		}
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.right = false;
		}
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			you.left = false;
		}
	}

	public final static int MENU_STATE = 0;
	public final static int GAME_STATE = 1;
	public final static int END_STATE = 2;
	public static int currentState = MENU_STATE;
public static int kill = 0;
	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
		objectManager.manageEnemies();
		if(you.y<=50) {
		allowUp=false;
		}else {
			allowUp=true;
		}
		if(you.y>=750) {
			allowDown = false;
		}else {
			allowDown = true;
		}
		if(you.x<=50) {
			allowLeft=false;
		}else {
			allowLeft=true;
		}
		if(you.y>=450) {
			allowRight=false;
		}else {
			allowRight=true;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		graphic.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		graphic.setFont(titleFont);
		graphic.setColor(Color.WHITE);
		graphic.drawString("LEAGUE INVADERS", 25, 200);
		graphic.setFont(normalFont);
		graphic.drawString("Press ENTER to start", 125, 400);
		graphic.drawString("Press SPACE for instructions", 75, 600);
	}

	void drawGameState(Graphics graphic) {
		graphic.setColor(Color.BLACK);
		graphic.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		you.draw(graphic);
		objectManager.draw(graphic);
		objectManager.checkCollision();
		
	}

	void drawEndState(Graphics graphic) {
		graphic.setColor(Color.RED);
		graphic.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		graphic.setColor(Color.BLACK);
		graphic.setFont(titleFont);
		graphic.drawString("GAME OVER", 100, 200);
		graphic.setFont(normalFont);
		graphic.drawString("You killed " + kill + " enemies", 130, 400);
		graphic.drawString("Press ENTER to restart", 115, 600);
		if (currentState==END_STATE){
			you = new Rocketship(250,700,50,50);
			objectManager = new ObjectManager(you);
			kill=0;
		}
	}
}