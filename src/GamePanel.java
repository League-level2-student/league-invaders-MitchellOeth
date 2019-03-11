import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Rocketship you = new Rocketship(250,700,50,50);
	Font titleFont = new Font("Arial",Font.BOLD,48);
	Font normalFont = new Font("Arial",Font.PLAIN,25);
	Timer framerate;	
	GamePanel(){
		framerate = new Timer(1000/60, this);
		addKeyListener(this);	
	}
	void startGame() {
		framerate.start();
	}
	public void paintComponent(Graphics graphic){	
		 if(currentState == MENU_STATE){
            drawMenuState(graphic);
     }else if(currentState == GAME_STATE){
             drawGameState(graphic);
     }else if(currentState == END_STATE){
             drawEndState(graphic);
     }
    }
	public void actionPerformed(ActionEvent event) {
		repaint();
		 if(currentState == MENU_STATE){
             updateMenuState();
     }else if(currentState == GAME_STATE){
             updateGameState();
     }else if(currentState == END_STATE){
             updateEndState();
     }
	}
	public void keyTyped(KeyEvent event) {
		
	}
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState>END_STATE) {
				currentState=MENU_STATE;
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			you.up = true;
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			you.down = true;
		}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.right = true;
		}
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			you.left = true;
		}
	}
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			you.up = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			you.down = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			you.right = false;
		}
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			you.left = false;
		}
	}
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	void updateMenuState() {
		
	}
	void updateGameState() {
		you.update();
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
		
	}
	void drawEndState(Graphics graphic) {
		graphic.setColor(Color.RED);
		graphic.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		graphic.setColor(Color.BLACK);
		graphic.setFont(titleFont);
		graphic.drawString("GAME OVER", 100, 200);
		graphic.setFont(normalFont);
		graphic.drawString("You killed "+0+" enemies",130,400);
		graphic.drawString("Press ENTER to restart", 115,600);
	}
}