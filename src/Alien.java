import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		if(isAlive == true) {
		super.update();
		y += 1;
	}
		else {
			x = 2000;
		}
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.YELLOW);
		graphic.fillRect(x, y, width, height);
	}
}