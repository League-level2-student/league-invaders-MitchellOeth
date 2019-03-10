import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer framerate;
	GamePanel(){
		framerate = new Timer(1000/60, this);
	}
	void startGame() {
		framerate.start();
	}
	public void paintComponent(Graphics graphic){
		graphic.fillRect(10, 10, 100, 100);
    }
	public void actionPerformed(ActionEvent event) {
		repaint();
	}
	public void keyTyped(KeyEvent event) {
		System.out.println("message 1");
	}
	public void keyPressed(KeyEvent event) {
		System.out.println("message 2");
	}
	public void keyReleased(KeyEvent event) {
		System.out.println("message 3");
	}
}