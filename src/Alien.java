import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
		super.update();
		y += 1;
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.YELLOW);
		graphic.fillRect(x, y, width, height);
	}
}