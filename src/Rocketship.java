import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();
		if (up == true) {
			y -= speed;
		}
		if (down == true) {
			y += speed;
		}
		if (right == true) {
			x += speed;
		}
		if (left == true) {
			x -= speed;
		}
	}

	void draw(Graphics graphic) {
		graphic.setColor(Color.BLUE);
		graphic.fillRect(x, y, width, height);

	}
}