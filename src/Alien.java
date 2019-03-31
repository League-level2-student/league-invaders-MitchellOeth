import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		if(isAlive == true) {
		super.update();
		y += 5;
	}
	}

	void draw(Graphics graphic) {
		graphic.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}